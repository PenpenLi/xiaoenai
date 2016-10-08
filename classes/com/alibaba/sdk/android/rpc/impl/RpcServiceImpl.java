package com.alibaba.sdk.android.rpc.impl;

import android.util.Log;
import com.alibaba.sdk.android.ConfigManager;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.rpc.RpcService;
import com.alibaba.sdk.android.rpc.ServiceInvokeException;
import com.alibaba.sdk.android.rpc.ServiceInvokeException.ServiceInvokeExceptionType;
import com.alibaba.sdk.android.rpc.ServiceRequest;
import com.alibaba.sdk.android.rpc.ServiceResponse;
import com.alibaba.sdk.android.rpc.annotation.API;
import com.alibaba.sdk.android.rpc.annotation.APIParameter;
import com.alibaba.sdk.android.rpc.annotation.Cache;
import com.alibaba.sdk.android.rpc.http.HttpRpcServiceClient;
import com.alibaba.sdk.android.rpc.model.RpcRequest;
import com.alibaba.sdk.android.rpc.utils.ProtocolUtils;
import com.alibaba.sdk.android.time.TimeService;
import com.alibaba.sdk.android.trace.ActionTraceLogger;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.trace.TraceLoggerManager;
import com.alibaba.sdk.android.util.JSONUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public class RpcServiceImpl
  implements RpcService
{
  private static final String TAG = "RpcServiceInvoker";
  private HttpRpcServiceClient rpcClient = new HttpRpcServiceClient((TimeService)RpcContext.appContext.getService(TimeService.class), (ExecutorService)RpcContext.appContext.getService(ExecutorService.class));
  
  public RpcServiceImpl()
  {
    this.rpcClient.extraHttpHeaders.put("sdkVersion", ConfigManager.SDK_INTERNAL_VERSION + " " + RpcContext.rpcVersion);
    this.rpcClient.extraHttpHeaders.put("platformName", "android");
    this.rpcClient.defaultPlatformId = "1";
  }
  
  public <T> T getProxy(Class<T> paramClass)
  {
    Log.i("RpcServiceInvoker", "Get Proxy Object for " + paramClass.getName());
    try
    {
      ClassLoader localClassLoader = getClass().getClassLoader();
      APIProxy localAPIProxy = new APIProxy(this, paramClass);
      paramClass = Proxy.newProxyInstance(localClassLoader, new Class[] { paramClass }, localAPIProxy);
      return paramClass;
    }
    catch (IllegalArgumentException paramClass)
    {
      Log.w("RpcServiceInvoker", "RPCService.getProxy IllegalArgumentException: " + paramClass.getMessage());
      return null;
    }
    catch (Exception paramClass)
    {
      for (;;)
      {
        Log.w("RpcServiceInvoker", "RPCService.getProxy RuntimeException: " + paramClass.getMessage());
      }
    }
  }
  
  public <T> T invoke(RpcRequest paramRpcRequest, Class<T> paramClass)
  {
    paramRpcRequest = invoke(paramRpcRequest);
    if ((paramRpcRequest == null) || (paramClass == null) || (paramRpcRequest.equals("null"))) {
      return null;
    }
    return (T)JSONUtils.parseStringValue(paramRpcRequest, paramClass);
  }
  
  public String invoke(RpcRequest paramRpcRequest)
  {
    ActionTraceLogger localActionTraceLogger = TraceLoggerManager.INSTANCE.action(5, "rpc", "invoke." + paramRpcRequest.target);
    localActionTraceLogger.infos(paramRpcRequest.params);
    Object localObject;
    for (;;)
    {
      try
      {
        localActionTraceLogger.begin();
        localObject = new ServiceRequest();
        ((ServiceRequest)localObject).rpcRequest = paramRpcRequest;
        localObject = this.rpcClient.call((ServiceRequest)localObject);
        if (AliSDKLogger.isDebugEnabled())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("rpc response: ");
          if (localObject != null)
          {
            paramRpcRequest = ProtocolUtils.toString((ServiceResponse)localObject);
            AliSDKLogger.d("RpcServiceInvoker", paramRpcRequest);
          }
        }
        else
        {
          if (localObject != null) {
            break;
          }
          throw new ServiceInvokeException(ServiceInvokeException.ServiceInvokeExceptionType.SYSTEM_ERROR, "null response for the rpc call");
        }
      }
      catch (Exception paramRpcRequest)
      {
        localActionTraceLogger.failed("e", paramRpcRequest);
        throw new RuntimeException(paramRpcRequest);
      }
      paramRpcRequest = null;
    }
    localActionTraceLogger.success("response", localObject);
    return ((ServiceResponse)localObject).asJSONString();
  }
  
  static class APIMethodDefination
  {
    boolean ansyInvoke = false;
    String api;
    List<Integer> cacheKeyParams;
    int cacheType;
    Method method;
    Map<String, Integer> paramNames;
    String protocol;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append(" api [ name=").append(this.api).append("; method name=");
      if (this.method == null) {}
      for (String str = null;; str = this.method.getName()) {
        return str + " ]";
      }
    }
  }
  
  private static class APIProxy
    implements InvocationHandler
  {
    private final RpcService client;
    private final Map<Method, RpcServiceImpl.APIMethodDefination> methodDefinations;
    
    public APIProxy(RpcService paramRpcService, Class<?> paramClass)
    {
      this.client = paramRpcService;
      this.methodDefinations = RpcServiceImpl.AnnotationAPIParser.parseDefinations(paramClass);
    }
    
    private String cacheKey(RpcServiceImpl.APIMethodDefination paramAPIMethodDefination, Object[] paramArrayOfObject)
    {
      StringBuilder localStringBuilder = new StringBuilder("api:").append(paramAPIMethodDefination.api);
      if (paramAPIMethodDefination.cacheKeyParams != null)
      {
        paramAPIMethodDefination = paramAPIMethodDefination.cacheKeyParams.iterator();
        while (paramAPIMethodDefination.hasNext())
        {
          int i = ((Integer)paramAPIMethodDefination.next()).intValue();
          localStringBuilder.append('|').append(paramArrayOfObject[i]);
        }
      }
      return localStringBuilder.toString();
    }
    
    private Object doInvoke(RpcServiceImpl.APIMethodDefination paramAPIMethodDefination, Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      paramObject = new RpcRequest();
      ((RpcRequest)paramObject).target = paramAPIMethodDefination.api;
      ((RpcRequest)paramObject).params = new LinkedHashMap();
      paramAPIMethodDefination = paramAPIMethodDefination.paramNames;
      if (paramAPIMethodDefination != null)
      {
        paramAPIMethodDefination = paramAPIMethodDefination.entrySet().iterator();
        while (paramAPIMethodDefination.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramAPIMethodDefination.next();
          ((RpcRequest)paramObject).params.put(localEntry.getKey(), paramArrayOfObject[((Integer)localEntry.getValue()).intValue()]);
        }
      }
      paramAPIMethodDefination = paramMethod.getReturnType();
      return this.client.invoke((RpcRequest)paramObject, paramAPIMethodDefination);
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      Log.w("RpcServiceInvoker", "Start invoke " + paramMethod.getName());
      RpcServiceImpl.APIMethodDefination localAPIMethodDefination = (RpcServiceImpl.APIMethodDefination)this.methodDefinations.get(paramMethod);
      if (localAPIMethodDefination == null)
      {
        Log.w("RpcServiceInvoker", paramMethod.getName() + " can not be proxy");
        throw new InternalError(paramMethod.getName() + " can not be proxy");
      }
      return doInvoke(localAPIMethodDefination, paramObject, paramMethod, paramArrayOfObject);
    }
  }
  
  private static final class AnnotationAPIParser
  {
    public static Map<Method, RpcServiceImpl.APIMethodDefination> parseDefinations(Class<?> paramClass)
    {
      API localAPI = (API)paramClass.getAnnotation(API.class);
      LinkedHashMap localLinkedHashMap = new LinkedHashMap();
      Method[] arrayOfMethod = paramClass.getDeclaredMethods();
      int m = arrayOfMethod.length;
      int i = 0;
      Method localMethod;
      Object localObject1;
      if (i < m)
      {
        localMethod = arrayOfMethod[i];
        if (Modifier.isPublic(localMethod.getModifiers()))
        {
          if (localAPI == null) {
            break label539;
          }
          localObject1 = localAPI.value();
          if ((localAPI.protocol() == null) || (localAPI.protocol().length() <= 0)) {
            break label534;
          }
          paramClass = localAPI.protocol();
        }
      }
      for (;;)
      {
        Object localObject3 = (API)localMethod.getAnnotation(API.class);
        if (localObject3 == null) {}
        for (;;)
        {
          i += 1;
          break;
          Object localObject2 = localObject1;
          if (((API)localObject3).value() != null)
          {
            localObject2 = localObject1;
            if (((API)localObject3).value().length() > 0) {
              localObject2 = ((API)localObject3).value();
            }
          }
          localObject1 = paramClass;
          if (((API)localObject3).protocol() != null)
          {
            localObject1 = paramClass;
            if (((API)localObject3).protocol().length() > 0) {
              localObject1 = ((API)localObject3).protocol();
            }
          }
          paramClass = new RpcServiceImpl.APIMethodDefination();
          paramClass.api = ((String)localObject2);
          paramClass.protocol = ((String)localObject1);
          paramClass.method = localMethod;
          Log.i("RpcServiceInvoker", "Parse API interface's method defination start: " + paramClass);
          localObject1 = localMethod.getParameterAnnotations();
          localObject3 = localMethod.getParameterTypes();
          int n = localObject3.length;
          localObject2 = (Cache)localMethod.getAnnotation(Cache.class);
          if (localObject2 != null)
          {
            paramClass.cacheType = ((Cache)localObject2).value();
            paramClass.cacheKeyParams = new ArrayList(n);
          }
          if ((localObject1 != null) && (localObject3 != null) && (localObject3.length > 0))
          {
            if (localObject1.length != n)
            {
              Log.w("RpcServiceInvoker", localMethod.getName() + " paramAnnotations.length and args.length is not equale");
              continue;
            }
            paramClass.paramNames = new LinkedHashMap();
            int j = 0;
            if (j < n)
            {
              localObject3 = localObject1[j];
              int i1 = localObject3.length;
              int k = 0;
              for (;;)
              {
                if (k < i1)
                {
                  Object localObject4 = localObject3[k];
                  if (!APIParameter.class.equals(((Annotation)localObject4).annotationType())) {
                    break label483;
                  }
                  localObject3 = (APIParameter)localObject4;
                  paramClass.paramNames.put(((APIParameter)localObject3).value(), Integer.valueOf(j));
                  if ((localObject2 != null) && (((APIParameter)localObject3).cacheKey())) {
                    paramClass.cacheKeyParams.add(Integer.valueOf(j));
                  }
                }
                j += 1;
                break;
                label483:
                k += 1;
              }
            }
          }
          Log.i("RpcServiceInvoker", "Parse API interface's method defination finish: " + paramClass);
          localLinkedHashMap.put(localMethod, paramClass);
        }
        return localLinkedHashMap;
        label534:
        paramClass = null;
        continue;
        label539:
        localObject1 = null;
        paramClass = null;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\rpc\impl\RpcServiceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */