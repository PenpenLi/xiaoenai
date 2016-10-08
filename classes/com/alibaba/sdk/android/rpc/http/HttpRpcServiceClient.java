package com.alibaba.sdk.android.rpc.http;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.event.EventBus;
import com.alibaba.sdk.android.model.Result;
import com.alibaba.sdk.android.plugin.config.PluginConfigurations;
import com.alibaba.sdk.android.rpc.RpcServiceClient;
import com.alibaba.sdk.android.rpc.ServiceInvokeException;
import com.alibaba.sdk.android.rpc.ServiceInvokeException.ServiceInvokeExceptionType;
import com.alibaba.sdk.android.rpc.ServiceRequest;
import com.alibaba.sdk.android.rpc.ServiceRequestCallback;
import com.alibaba.sdk.android.rpc.ServiceResponse;
import com.alibaba.sdk.android.rpc.impl.RpcContext;
import com.alibaba.sdk.android.rpc.model.RpcRequest;
import com.alibaba.sdk.android.rpc.utils.TraceUtils;
import com.alibaba.sdk.android.security.SecurityGuardService;
import com.alibaba.sdk.android.session.SessionService;
import com.alibaba.sdk.android.time.TimeService;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.util.CommonUtils;
import com.alibaba.sdk.android.util.HttpDNSUtils;
import com.alibaba.sdk.android.util.IOUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class HttpRpcServiceClient
  implements RpcServiceClient
{
  private static final String TAG = "HttpRPCSerivceClient";
  private static Handler handler = new Handler(Looper.getMainLooper());
  public String defaultPlatformId = "1";
  public ExecutorService executorService;
  public Map<String, String> extraHttpHeaders = new HashMap();
  private volatile boolean rpcDegradeEventSent = false;
  private AtomicInteger rpcTimeoutCount = new AtomicInteger();
  public TimeService timeService;
  
  public HttpRpcServiceClient(TimeService paramTimeService, ExecutorService paramExecutorService)
  {
    this.timeService = paramTimeService;
    this.executorService = paramExecutorService;
  }
  
  /* Error */
  private ServiceResponse internalCall(InvocationContext paramInvocationContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 83	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$InvocationContext:request	Lcom/alibaba/sdk/android/rpc/ServiceRequest;
    //   4: astore_3
    //   5: invokestatic 89	com/alibaba/sdk/android/trace/AliSDKLogger:isDebugEnabled	()Z
    //   8: ifeq +75 -> 83
    //   11: new 91	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   18: ldc 94
    //   20: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_3
    //   24: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   27: ldc 103
    //   29: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_1
    //   33: getfield 107	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$InvocationContext:callback	Lcom/alibaba/sdk/android/rpc/ServiceRequestCallback;
    //   36: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   39: ldc 109
    //   41: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: astore 4
    //   46: aload_3
    //   47: getfield 114	com/alibaba/sdk/android/rpc/ServiceRequest:region	Ljava/lang/String;
    //   50: ifnull +15 -> 65
    //   53: aload_3
    //   54: getfield 114	com/alibaba/sdk/android/rpc/ServiceRequest:region	Ljava/lang/String;
    //   57: ldc 116
    //   59: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   62: ifeq +64 -> 126
    //   65: getstatic 127	com/alibaba/sdk/android/rpc/impl/RpcContext:rpcHTTPGateway	Ljava/lang/String;
    //   68: astore_2
    //   69: ldc 13
    //   71: aload 4
    //   73: aload_2
    //   74: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 135	com/alibaba/sdk/android/trace/AliSDKLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload_0
    //   84: aload_3
    //   85: invokespecial 139	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient:syncInvokeHttp	(Lcom/alibaba/sdk/android/rpc/ServiceRequest;)Lcom/alibaba/sdk/android/rpc/ServiceResponse;
    //   88: iconst_1
    //   89: aload_3
    //   90: getfield 143	com/alibaba/sdk/android/rpc/ServiceRequest:rpcRequest	Lcom/alibaba/sdk/android/rpc/model/RpcRequest;
    //   93: getfield 148	com/alibaba/sdk/android/rpc/model/RpcRequest:seedKey	Ljava/lang/String;
    //   96: invokestatic 154	com/alibaba/sdk/android/rpc/utils/ProtocolUtils:processServiceResponse	(Lcom/alibaba/sdk/android/rpc/ServiceResponse;ZLjava/lang/String;)Lcom/alibaba/sdk/android/rpc/ServiceResponse;
    //   99: astore_2
    //   100: aload_1
    //   101: getfield 107	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$InvocationContext:callback	Lcom/alibaba/sdk/android/rpc/ServiceRequestCallback;
    //   104: ifnull +268 -> 372
    //   107: getstatic 43	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient:handler	Landroid/os/Handler;
    //   110: new 156	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$2
    //   113: dup
    //   114: aload_0
    //   115: aload_1
    //   116: aload_2
    //   117: invokespecial 159	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$2:<init>	(Lcom/alibaba/sdk/android/rpc/http/HttpRpcServiceClient;Lcom/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$InvocationContext;Lcom/alibaba/sdk/android/rpc/ServiceResponse;)V
    //   120: invokevirtual 163	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   123: pop
    //   124: aload_2
    //   125: areturn
    //   126: aload_3
    //   127: getfield 114	com/alibaba/sdk/android/rpc/ServiceRequest:region	Ljava/lang/String;
    //   130: astore_2
    //   131: goto -62 -> 69
    //   134: astore_2
    //   135: new 77	com/alibaba/sdk/android/rpc/ServiceInvokeException
    //   138: dup
    //   139: getstatic 169	com/alibaba/sdk/android/rpc/ServiceInvokeException$ServiceInvokeExceptionType:NETWORK_UNAVAILABLE	Lcom/alibaba/sdk/android/rpc/ServiceInvokeException$ServiceInvokeExceptionType;
    //   142: aload_2
    //   143: invokevirtual 172	java/net/UnknownHostException:getMessage	()Ljava/lang/String;
    //   146: invokespecial 175	com/alibaba/sdk/android/rpc/ServiceInvokeException:<init>	(Lcom/alibaba/sdk/android/rpc/ServiceInvokeException$ServiceInvokeExceptionType;Ljava/lang/String;)V
    //   149: astore_2
    //   150: aload_1
    //   151: getfield 178	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$InvocationContext:syncInvoke	Z
    //   154: ifeq +5 -> 159
    //   157: aload_2
    //   158: athrow
    //   159: aload_1
    //   160: getfield 107	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$InvocationContext:callback	Lcom/alibaba/sdk/android/rpc/ServiceRequestCallback;
    //   163: ifnull +20 -> 183
    //   166: getstatic 43	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient:handler	Landroid/os/Handler;
    //   169: new 180	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$3
    //   172: dup
    //   173: aload_0
    //   174: aload_1
    //   175: aload_2
    //   176: invokespecial 183	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$3:<init>	(Lcom/alibaba/sdk/android/rpc/http/HttpRpcServiceClient;Lcom/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$InvocationContext;Lcom/alibaba/sdk/android/rpc/ServiceInvokeException;)V
    //   179: invokevirtual 163	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   182: pop
    //   183: aconst_null
    //   184: areturn
    //   185: astore_2
    //   186: getstatic 186	com/alibaba/sdk/android/rpc/ServiceInvokeException$ServiceInvokeExceptionType:INVALID_SID	Lcom/alibaba/sdk/android/rpc/ServiceInvokeException$ServiceInvokeExceptionType;
    //   189: aload_2
    //   190: invokevirtual 190	com/alibaba/sdk/android/rpc/ServiceInvokeException:getExceptionType	()Lcom/alibaba/sdk/android/rpc/ServiceInvokeException$ServiceInvokeExceptionType;
    //   193: invokevirtual 191	com/alibaba/sdk/android/rpc/ServiceInvokeException$ServiceInvokeExceptionType:equals	(Ljava/lang/Object;)Z
    //   196: ifeq +31 -> 227
    //   199: aload_1
    //   200: getfield 194	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$InvocationContext:retryInvalidSid	Z
    //   203: ifeq +24 -> 227
    //   206: aload_1
    //   207: iconst_0
    //   208: putfield 194	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$InvocationContext:retryInvalidSid	Z
    //   211: aload_0
    //   212: aload_1
    //   213: getfield 83	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$InvocationContext:request	Lcom/alibaba/sdk/android/rpc/ServiceRequest;
    //   216: iconst_1
    //   217: aload_1
    //   218: invokevirtual 198	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient:assembleSid	(Lcom/alibaba/sdk/android/rpc/ServiceRequest;ZLcom/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$InvocationContext;)V
    //   221: aload_0
    //   222: aload_1
    //   223: invokespecial 73	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient:internalCall	(Lcom/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$InvocationContext;)Lcom/alibaba/sdk/android/rpc/ServiceResponse;
    //   226: areturn
    //   227: getstatic 201	com/alibaba/sdk/android/rpc/ServiceInvokeException$ServiceInvokeExceptionType:TIMESTAMP_MISMATCH	Lcom/alibaba/sdk/android/rpc/ServiceInvokeException$ServiceInvokeExceptionType;
    //   230: aload_2
    //   231: invokevirtual 190	com/alibaba/sdk/android/rpc/ServiceInvokeException:getExceptionType	()Lcom/alibaba/sdk/android/rpc/ServiceInvokeException$ServiceInvokeExceptionType;
    //   234: invokevirtual 191	com/alibaba/sdk/android/rpc/ServiceInvokeException$ServiceInvokeExceptionType:equals	(Ljava/lang/Object;)Z
    //   237: ifeq +44 -> 281
    //   240: aload_1
    //   241: getfield 204	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$InvocationContext:retryMismatchTimestamp	Z
    //   244: ifeq +37 -> 281
    //   247: aload_0
    //   248: getfield 65	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient:timeService	Lcom/alibaba/sdk/android/time/TimeService;
    //   251: ifnull +30 -> 281
    //   254: aload_1
    //   255: iconst_0
    //   256: putfield 204	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$InvocationContext:retryMismatchTimestamp	Z
    //   259: aload_1
    //   260: getfield 83	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$InvocationContext:request	Lcom/alibaba/sdk/android/rpc/ServiceRequest;
    //   263: aload_0
    //   264: getfield 65	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient:timeService	Lcom/alibaba/sdk/android/time/TimeService;
    //   267: invokeinterface 210 1 0
    //   272: putfield 214	com/alibaba/sdk/android/rpc/ServiceRequest:clientTimestamp	J
    //   275: aload_0
    //   276: aload_1
    //   277: invokespecial 73	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient:internalCall	(Lcom/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$InvocationContext;)Lcom/alibaba/sdk/android/rpc/ServiceResponse;
    //   280: areturn
    //   281: aload_1
    //   282: getfield 178	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$InvocationContext:syncInvoke	Z
    //   285: ifeq +5 -> 290
    //   288: aload_2
    //   289: athrow
    //   290: aload_1
    //   291: getfield 107	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$InvocationContext:callback	Lcom/alibaba/sdk/android/rpc/ServiceRequestCallback;
    //   294: ifnull -111 -> 183
    //   297: getstatic 43	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient:handler	Landroid/os/Handler;
    //   300: new 216	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$4
    //   303: dup
    //   304: aload_0
    //   305: aload_1
    //   306: aload_2
    //   307: invokespecial 217	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$4:<init>	(Lcom/alibaba/sdk/android/rpc/http/HttpRpcServiceClient;Lcom/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$InvocationContext;Lcom/alibaba/sdk/android/rpc/ServiceInvokeException;)V
    //   310: invokevirtual 163	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   313: pop
    //   314: goto -131 -> 183
    //   317: astore_2
    //   318: aload_2
    //   319: invokestatic 223	com/alibaba/sdk/android/util/CommonUtils:isConnectionTimeout	(Ljava/lang/Throwable;)Z
    //   322: ifeq +7 -> 329
    //   325: aload_0
    //   326: invokespecial 226	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient:updateRpcDegrade	()V
    //   329: aload_1
    //   330: getfield 178	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$InvocationContext:syncInvoke	Z
    //   333: ifeq +12 -> 345
    //   336: new 77	com/alibaba/sdk/android/rpc/ServiceInvokeException
    //   339: dup
    //   340: aload_2
    //   341: invokespecial 229	com/alibaba/sdk/android/rpc/ServiceInvokeException:<init>	(Ljava/lang/Throwable;)V
    //   344: athrow
    //   345: aload_1
    //   346: getfield 107	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$InvocationContext:callback	Lcom/alibaba/sdk/android/rpc/ServiceRequestCallback;
    //   349: ifnull -166 -> 183
    //   352: getstatic 43	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient:handler	Landroid/os/Handler;
    //   355: new 231	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$5
    //   358: dup
    //   359: aload_0
    //   360: aload_1
    //   361: aload_2
    //   362: invokespecial 234	com/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$5:<init>	(Lcom/alibaba/sdk/android/rpc/http/HttpRpcServiceClient;Lcom/alibaba/sdk/android/rpc/http/HttpRpcServiceClient$InvocationContext;Ljava/lang/Exception;)V
    //   365: invokevirtual 163	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   368: pop
    //   369: goto -186 -> 183
    //   372: aload_2
    //   373: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	this	HttpRpcServiceClient
    //   0	374	1	paramInvocationContext	InvocationContext
    //   68	63	2	localObject	Object
    //   134	9	2	localUnknownHostException	java.net.UnknownHostException
    //   149	27	2	localServiceInvokeException1	ServiceInvokeException
    //   185	122	2	localServiceInvokeException2	ServiceInvokeException
    //   317	56	2	localException	Exception
    //   4	123	3	localServiceRequest	ServiceRequest
    //   44	28	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	65	134	java/net/UnknownHostException
    //   65	69	134	java/net/UnknownHostException
    //   69	83	134	java/net/UnknownHostException
    //   83	124	134	java/net/UnknownHostException
    //   126	131	134	java/net/UnknownHostException
    //   0	65	185	com/alibaba/sdk/android/rpc/ServiceInvokeException
    //   65	69	185	com/alibaba/sdk/android/rpc/ServiceInvokeException
    //   69	83	185	com/alibaba/sdk/android/rpc/ServiceInvokeException
    //   83	124	185	com/alibaba/sdk/android/rpc/ServiceInvokeException
    //   126	131	185	com/alibaba/sdk/android/rpc/ServiceInvokeException
    //   0	65	317	java/lang/Exception
    //   65	69	317	java/lang/Exception
    //   69	83	317	java/lang/Exception
    //   83	124	317	java/lang/Exception
    //   126	131	317	java/lang/Exception
  }
  
  private final ServiceResponse syncInvokeHttp(ServiceRequest paramServiceRequest)
  {
    localObject3 = null;
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramServiceRequest.region)) {
          continue;
        }
        localObject1 = RpcContext.rpcHTTPGateway;
        if ((RpcContext.appContext == null) || (!RpcContext.httpDNSEnabled)) {
          continue;
        }
        localObject1 = HttpDNSUtils.getHttpURLConnection((String)localObject1, RpcContext.appContext.getAndroidContext());
        try
        {
          ((HttpURLConnection)localObject1).setUseCaches(false);
          ((HttpURLConnection)localObject1).setRequestMethod("POST");
          ((HttpURLConnection)localObject1).setConnectTimeout(paramServiceRequest.timeout);
          ((HttpURLConnection)localObject1).setReadTimeout(paramServiceRequest.timeout);
          ((HttpURLConnection)localObject1).setDoOutput(true);
          ((HttpURLConnection)localObject1).setDoInput(true);
          if ((RpcContext.includeResourceInHttpHeader) && (paramServiceRequest.rpcRequest.target != null)) {
            ((HttpURLConnection)localObject1).setRequestProperty("RPC-API", paramServiceRequest.rpcRequest.target);
          }
          if (paramServiceRequest.rpcRequest.rpcReferer != null) {
            ((HttpURLConnection)localObject1).setRequestProperty("RPC-Referer", paramServiceRequest.rpcRequest.rpcReferer);
          }
          if (paramServiceRequest.platformId != null) {
            continue;
          }
          localObject3 = this.defaultPlatformId;
          ((HttpURLConnection)localObject1).setRequestProperty("platformId", (String)localObject3);
          ((HttpURLConnection)localObject1).setRequestProperty("sid", paramServiceRequest.sid);
          localObject3 = this.extraHttpHeaders.entrySet().iterator();
          if (!((Iterator)localObject3).hasNext()) {
            continue;
          }
          localObject4 = (Map.Entry)((Iterator)localObject3).next();
          ((HttpURLConnection)localObject1).setRequestProperty((String)((Map.Entry)localObject4).getKey(), (String)((Map.Entry)localObject4).getValue());
          continue;
          IOUtils.closeQuietly((Closeable)localObject1);
        }
        finally
        {
          localObject4 = null;
          localObject3 = localObject1;
          localObject1 = localObject4;
        }
      }
      finally
      {
        Object localObject1;
        Object localObject4;
        localObject2 = null;
        continue;
        continue;
      }
      if (localObject3 != null) {}
      try
      {
        ((HttpURLConnection)localObject3).disconnect();
        throw paramServiceRequest;
        localObject1 = paramServiceRequest.region;
        continue;
        localObject1 = (HttpURLConnection)new URL((String)localObject1).openConnection();
        continue;
        localObject3 = paramServiceRequest.platformId;
        continue;
        if (RpcContext.appContext != null)
        {
          localObject3 = RpcContext.appContext.getUserTrackerId();
          if (localObject3 != null) {
            ((HttpURLConnection)localObject1).setRequestProperty("did", (String)localObject3);
          }
        }
        ((HttpURLConnection)localObject1).setRequestProperty("tid", TraceUtils.createTraceId());
        ((HttpURLConnection)localObject1).setRequestProperty("Content-Type", "application/octet-stream");
        localObject3 = ((HttpURLConnection)localObject1).getOutputStream();
        ((OutputStream)localObject3).write(paramServiceRequest.toBytes(true));
        ((OutputStream)localObject3).flush();
        try
        {
          i = ((HttpURLConnection)localObject1).getResponseCode();
          if (i == 200) {
            if ("1".equals(((HttpURLConnection)localObject1).getHeaderField("BC-GW-Code"))) {
              throw new ServiceInvokeException(ServiceInvokeException.ServiceInvokeExceptionType.INVALID_SID, "Error occurred, GW-Code = 1");
            }
          }
        }
        catch (IOException paramServiceRequest)
        {
          i = ((HttpURLConnection)localObject1).getResponseCode();
          continue;
          if ("1".equals(((HttpURLConnection)localObject1).getHeaderField("tmd_limited")))
          {
            updateRpcDegrade();
            throw new ServiceInvokeException(ServiceInvokeException.ServiceInvokeExceptionType.API_FLOW_REGULATION, "Error occurred, tmd_limited = 1");
          }
          localObject3 = ((HttpURLConnection)localObject1).getInputStream();
        }
      }
      catch (Exception localException2)
      {
        try
        {
          int i = ((HttpURLConnection)localObject1).getContentLength();
          if (i > 0)
          {
            paramServiceRequest = new ByteArrayOutputStream(i);
            IOUtils.copyStream((InputStream)localObject3, paramServiceRequest, 2048);
            paramServiceRequest = new ServiceResponse(paramServiceRequest.toByteArray());
            IOUtils.closeQuietly((Closeable)localObject3);
            if (localObject1 == null) {}
          }
          try
          {
            ((HttpURLConnection)localObject1).disconnect();
            return paramServiceRequest;
          }
          catch (Exception localException1)
          {
            return paramServiceRequest;
          }
          i = 512;
          continue;
          throw new IOException("status code : " + i);
        }
        finally
        {
          localObject4 = localObject2;
          Object localObject2 = localObject3;
          localObject3 = localObject4;
        }
        localException2 = localException2;
      }
    }
  }
  
  private void updateRpcDegrade()
  {
    if (!CommonUtils.isNetworkAvailable()) {}
    int i;
    do
    {
      return;
      i = this.rpcTimeoutCount.incrementAndGet();
    } while ((this.rpcDegradeEventSent) || (!"T".equals(RpcContext.pluginConfigurations.getStringValue("ENABLE_CLIENT_AUTO_DEGRAGE", "F"))) || (i < RpcContext.pluginConfigurations.getIntValue("CLIENT_AUTO_DEGRAGE_RPC_FAILED_TIMES", 20)));
    EventBus.getDefault().sendEvent("rpc-degrade");
  }
  
  public void assembleSid(ServiceRequest paramServiceRequest, boolean paramBoolean, InvocationContext paramInvocationContext)
  {
    SessionService localSessionService = (SessionService)RpcContext.appContext.getService(SessionService.class, paramServiceRequest.rpcRequest.filter);
    if (localSessionService == null) {
      throw new IllegalStateException("sessionService or provider isn't init!");
    }
    if (paramBoolean) {
      AliSDKLogger.w("HttpRPCSerivceClient", "force init sid for request");
    }
    String str;
    if (paramBoolean) {
      str = (String)localSessionService.refreshSId().data;
    }
    while ((str == null) || (!RpcContext.securityGuardService.restoreSecretIfAbsent(paramServiceRequest.rpcRequest.seedKey))) {
      if (paramInvocationContext.retryInvalidSid)
      {
        paramInvocationContext.retryInvalidSid = false;
        str = (String)localSessionService.refreshSId().data;
        paramInvocationContext = str;
        if (str != null) {
          break label171;
        }
        throw new IllegalStateException("sid is null");
        str = (String)localSessionService.getSId().data;
      }
      else
      {
        throw new IllegalStateException("sid is null");
      }
    }
    paramInvocationContext = str;
    label171:
    paramServiceRequest.sid = paramInvocationContext;
  }
  
  public ServiceResponse call(ServiceRequest paramServiceRequest)
  {
    InvocationContext localInvocationContext = new InvocationContext();
    localInvocationContext.retryInvalidSid = true;
    localInvocationContext.retryMismatchTimestamp = true;
    localInvocationContext.syncInvoke = true;
    localInvocationContext.request = paramServiceRequest;
    if (paramServiceRequest.sid == null) {
      assembleSid(paramServiceRequest, false, localInvocationContext);
    }
    return internalCall(localInvocationContext);
  }
  
  public void call(ServiceRequest paramServiceRequest, ServiceRequestCallback paramServiceRequestCallback)
  {
    InvocationContext localInvocationContext = new InvocationContext();
    localInvocationContext.request = paramServiceRequest;
    localInvocationContext.callback = paramServiceRequestCallback;
    localInvocationContext.retryInvalidSid = true;
    localInvocationContext.retryMismatchTimestamp = true;
    localInvocationContext.syncInvoke = false;
    if (paramServiceRequest.sid == null) {
      assembleSid(paramServiceRequest, false, localInvocationContext);
    }
    this.executorService.submit(new HttpRpcServiceClient.1(this, localInvocationContext));
  }
  
  static class InvocationContext
  {
    public ServiceRequestCallback callback;
    public ServiceRequest request;
    public boolean retryInvalidSid;
    public boolean retryMismatchTimestamp;
    public boolean syncInvoke;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\rpc\http\HttpRpcServiceClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */