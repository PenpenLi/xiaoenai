package com.alibaba.sdk.android.ui.bus.filter.impl;

import android.text.TextUtils;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.ui.UIContext;
import com.alibaba.sdk.android.ui.bus.filter.FilterAction;
import com.alibaba.sdk.android.ui.bus.filter.FilterInfo.ActionInfo;
import com.alibaba.sdk.android.util.ReflectionUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;

public class ServiceInvocationFilterAction
  implements FilterAction
{
  private static final int RET_DEFAULT_MODE = 3;
  private static final int RET_FIELD_MODE = 2;
  private static final int RET_METHOD_MODE = 1;
  private FilterInfo.ActionInfo actionInfo;
  private WeakReference<?> cachedInstance;
  private Field[] cachedRetFields;
  private Method[] cachedRetMethods;
  private boolean initialized;
  private String keyName;
  private Method method;
  private int retMode;
  private String[] retPatterns;
  private Map<String, String> serviceFilter;
  private Class<?> serviceInterfaceClazz;
  private boolean syncInvoke;
  private boolean uiThread;
  
  public ServiceInvocationFilterAction(FilterInfo.ActionInfo paramActionInfo)
  {
    this.actionInfo = paramActionInfo;
    this.initialized = initialize();
  }
  
  private Object getRetByFieldMode(Object paramObject)
  {
    int j = this.retPatterns.length;
    int i = 0;
    while (i < j)
    {
      if (paramObject == null) {
        return null;
      }
      Field localField2 = this.cachedRetFields[i];
      Field localField1 = localField2;
      if (localField2 == null)
      {
        localField1 = ReflectionUtils.getField(paramObject.getClass(), this.retPatterns[i]);
        if (localField1 == null) {
          return null;
        }
        this.cachedRetFields[i] = localField1;
      }
      paramObject = localField1.get(paramObject);
      i += 1;
    }
    return paramObject;
  }
  
  private Object getRetByMethodMode(Object paramObject)
  {
    int j = this.retPatterns.length;
    int i = 0;
    while (i < j)
    {
      if (paramObject == null) {
        return null;
      }
      Method localMethod2 = this.cachedRetMethods[i];
      Method localMethod1 = localMethod2;
      if (localMethod2 == null)
      {
        localMethod1 = ReflectionUtils.getMethod(paramObject.getClass(), this.retPatterns[i], new Class[0]);
        if (localMethod1 == null) {
          return null;
        }
        this.cachedRetMethods[i] = localMethod1;
      }
      paramObject = localMethod1.invoke(paramObject, new Object[0]);
      i += 1;
    }
    return paramObject;
  }
  
  private boolean initialize()
  {
    Object localObject1 = (String)this.actionInfo.parameters.get("serviceInterface");
    if (localObject1 == null) {
      return false;
    }
    this.serviceInterfaceClazz = ReflectionUtils.loadClassQuietly((String)localObject1);
    if (this.serviceInterfaceClazz == null) {
      return false;
    }
    localObject1 = (String)this.actionInfo.parameters.get("filterKey");
    Object localObject2 = (String)this.actionInfo.parameters.get("filterValue");
    if ((localObject1 != null) && (localObject2 != null)) {
      this.serviceFilter = Collections.singletonMap(localObject1, localObject2);
    }
    this.keyName = ((String)this.actionInfo.parameters.get("attributeKey"));
    this.uiThread = "true".equals(this.actionInfo.parameters.get("uiThread"));
    this.syncInvoke = "true".equals(this.actionInfo.parameters.get("syncInvoke"));
    localObject1 = (String)this.actionInfo.parameters.get("retMode");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      this.retMode = 3;
    }
    while (this.retMode != 3)
    {
      localObject1 = (String)this.actionInfo.parameters.get("retPattern");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        return false;
        this.retMode = Integer.parseInt((String)localObject1);
      }
      else
      {
        this.retPatterns = ((String)localObject1).split("[\\.]");
        if (this.retMode != 2) {
          break label291;
        }
        this.cachedRetFields = new Field[this.retPatterns.length];
      }
    }
    String str;
    for (;;)
    {
      str = (String)this.actionInfo.parameters.get("method");
      if (str != null) {
        break;
      }
      return false;
      label291:
      if (this.retMode == 1) {
        this.cachedRetMethods = new Method[this.retPatterns.length];
      }
    }
    try
    {
      this.method = this.serviceInterfaceClazz.getMethod(str, new Class[0]);
      if (this.method == null) {}
      try
      {
        if (this.cachedInstance != null)
        {
          localObject2 = this.cachedInstance.get();
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = UIContext.appContext.getService(this.serviceInterfaceClazz, this.serviceFilter);
          this.cachedInstance = new WeakReference(localObject1);
        }
        if (localObject1 != null) {
          this.method = ReflectionUtils.getMethod(localObject1.getClass(), str, new Class[0]);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          AliSDKLogger.w("ui", "fail to initialize the action method " + this.actionInfo.parameters + ", the error message is " + localException2.getMessage());
        }
      }
      return true;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        AliSDKLogger.w("ui", "fail to initialize the action method " + this.actionInfo.parameters + ", the error message is " + localException1.getMessage());
      }
    }
  }
  
  /* Error */
  public boolean execute(com.alibaba.sdk.android.ui.bus.filter.FilterContext paramFilterContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/alibaba/sdk/android/ui/bus/filter/impl/ServiceInvocationFilterAction:initialized	Z
    //   4: ifne +40 -> 44
    //   7: ldc -66
    //   9: new 192	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   16: ldc -35
    //   18: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: getfield 46	com/alibaba/sdk/android/ui/bus/filter/impl/ServiceInvocationFilterAction:actionInfo	Lcom/alibaba/sdk/android/ui/bus/filter/FilterInfo$ActionInfo;
    //   25: getfield 224	com/alibaba/sdk/android/ui/bus/filter/FilterInfo$ActionInfo:name	Ljava/lang/String;
    //   28: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc -30
    //   33: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 217	com/alibaba/sdk/android/trace/AliSDKLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: iconst_0
    //   43: ireturn
    //   44: aload_0
    //   45: getfield 168	com/alibaba/sdk/android/ui/bus/filter/impl/ServiceInvocationFilterAction:cachedInstance	Ljava/lang/ref/WeakReference;
    //   48: ifnull +17 -> 65
    //   51: aload_0
    //   52: getfield 168	com/alibaba/sdk/android/ui/bus/filter/impl/ServiceInvocationFilterAction:cachedInstance	Ljava/lang/ref/WeakReference;
    //   55: invokevirtual 173	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   58: astore_3
    //   59: aload_3
    //   60: astore_2
    //   61: aload_3
    //   62: ifnonnull +274 -> 336
    //   65: getstatic 179	com/alibaba/sdk/android/ui/UIContext:appContext	Lcom/alibaba/sdk/android/app/AppContext;
    //   68: aload_0
    //   69: getfield 109	com/alibaba/sdk/android/ui/bus/filter/impl/ServiceInvocationFilterAction:serviceInterfaceClazz	Ljava/lang/Class;
    //   72: aload_0
    //   73: getfield 121	com/alibaba/sdk/android/ui/bus/filter/impl/ServiceInvocationFilterAction:serviceFilter	Ljava/util/Map;
    //   76: invokeinterface 185 3 0
    //   81: astore_2
    //   82: aload_0
    //   83: new 170	java/lang/ref/WeakReference
    //   86: dup
    //   87: aload_2
    //   88: invokespecial 188	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   91: putfield 168	com/alibaba/sdk/android/ui/bus/filter/impl/ServiceInvocationFilterAction:cachedInstance	Ljava/lang/ref/WeakReference;
    //   94: goto +242 -> 336
    //   97: aload_0
    //   98: getfield 166	com/alibaba/sdk/android/ui/bus/filter/impl/ServiceInvocationFilterAction:method	Ljava/lang/reflect/Method;
    //   101: ifnonnull +44 -> 145
    //   104: aload_0
    //   105: aload_2
    //   106: invokevirtual 63	java/lang/Object:getClass	()Ljava/lang/Class;
    //   109: aload_0
    //   110: getfield 46	com/alibaba/sdk/android/ui/bus/filter/impl/ServiceInvocationFilterAction:actionInfo	Lcom/alibaba/sdk/android/ui/bus/filter/FilterInfo$ActionInfo;
    //   113: getfield 96	com/alibaba/sdk/android/ui/bus/filter/FilterInfo$ActionInfo:parameters	Ljava/util/Map;
    //   116: ldc -95
    //   118: invokeinterface 101 2 0
    //   123: checkcast 103	java/lang/String
    //   126: iconst_0
    //   127: anewarray 79	java/lang/Class
    //   130: invokestatic 83	com/alibaba/sdk/android/util/ReflectionUtils:getMethod	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   133: putfield 166	com/alibaba/sdk/android/ui/bus/filter/impl/ServiceInvocationFilterAction:method	Ljava/lang/reflect/Method;
    //   136: aload_0
    //   137: getfield 166	com/alibaba/sdk/android/ui/bus/filter/impl/ServiceInvocationFilterAction:method	Ljava/lang/reflect/Method;
    //   140: ifnonnull +5 -> 145
    //   143: iconst_0
    //   144: ireturn
    //   145: invokestatic 232	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   148: invokestatic 235	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   151: if_acmpne +193 -> 344
    //   154: iconst_1
    //   155: istore 4
    //   157: iload 4
    //   159: ifeq +103 -> 262
    //   162: aload_0
    //   163: getfield 134	com/alibaba/sdk/android/ui/bus/filter/impl/ServiceInvocationFilterAction:uiThread	Z
    //   166: ifne +96 -> 262
    //   169: getstatic 179	com/alibaba/sdk/android/ui/UIContext:appContext	Lcom/alibaba/sdk/android/app/AppContext;
    //   172: ldc -19
    //   174: invokeinterface 240 2 0
    //   179: checkcast 237	java/util/concurrent/ExecutorService
    //   182: new 242	com/alibaba/sdk/android/ui/bus/filter/impl/ServiceInvocationFilterAction$1
    //   185: dup
    //   186: aload_0
    //   187: aload_0
    //   188: getfield 166	com/alibaba/sdk/android/ui/bus/filter/impl/ServiceInvocationFilterAction:method	Ljava/lang/reflect/Method;
    //   191: aload_2
    //   192: invokespecial 245	com/alibaba/sdk/android/ui/bus/filter/impl/ServiceInvocationFilterAction$1:<init>	(Lcom/alibaba/sdk/android/ui/bus/filter/impl/ServiceInvocationFilterAction;Ljava/lang/reflect/Method;Ljava/lang/Object;)V
    //   195: invokeinterface 249 2 0
    //   200: astore_2
    //   201: aload_0
    //   202: getfield 137	com/alibaba/sdk/android/ui/bus/filter/impl/ServiceInvocationFilterAction:syncInvoke	Z
    //   205: istore 5
    //   207: iload 5
    //   209: ifeq +122 -> 331
    //   212: aload_2
    //   213: ldc2_w 250
    //   216: getstatic 257	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   219: invokeinterface 262 4 0
    //   224: astore_2
    //   225: aload_2
    //   226: ifnull +71 -> 297
    //   229: aload_0
    //   230: getfield 146	com/alibaba/sdk/android/ui/bus/filter/impl/ServiceInvocationFilterAction:retMode	I
    //   233: iconst_2
    //   234: if_icmpne +44 -> 278
    //   237: aload_0
    //   238: aload_2
    //   239: invokespecial 264	com/alibaba/sdk/android/ui/bus/filter/impl/ServiceInvocationFilterAction:getRetByFieldMode	(Ljava/lang/Object;)Ljava/lang/Object;
    //   242: astore_3
    //   243: aload_3
    //   244: ifnull +98 -> 342
    //   247: aload_1
    //   248: aload_0
    //   249: getfield 125	com/alibaba/sdk/android/ui/bus/filter/impl/ServiceInvocationFilterAction:keyName	Ljava/lang/String;
    //   252: aload_3
    //   253: invokevirtual 265	java/lang/Object:toString	()Ljava/lang/String;
    //   256: invokevirtual 270	com/alibaba/sdk/android/ui/bus/filter/FilterContext:setContextParameter	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: goto +83 -> 342
    //   262: aload_0
    //   263: getfield 166	com/alibaba/sdk/android/ui/bus/filter/impl/ServiceInvocationFilterAction:method	Ljava/lang/reflect/Method;
    //   266: aload_2
    //   267: iconst_0
    //   268: anewarray 4	java/lang/Object
    //   271: invokevirtual 89	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   274: astore_2
    //   275: goto -50 -> 225
    //   278: aload_2
    //   279: astore_3
    //   280: aload_0
    //   281: getfield 146	com/alibaba/sdk/android/ui/bus/filter/impl/ServiceInvocationFilterAction:retMode	I
    //   284: iconst_1
    //   285: if_icmpne -42 -> 243
    //   288: aload_0
    //   289: aload_2
    //   290: invokespecial 272	com/alibaba/sdk/android/ui/bus/filter/impl/ServiceInvocationFilterAction:getRetByMethodMode	(Ljava/lang/Object;)Ljava/lang/Object;
    //   293: astore_3
    //   294: goto -51 -> 243
    //   297: iconst_0
    //   298: ireturn
    //   299: astore_1
    //   300: ldc -66
    //   302: new 192	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   309: ldc_w 274
    //   312: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload_1
    //   316: invokevirtual 208	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   319: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: aload_1
    //   326: invokestatic 278	com/alibaba/sdk/android/trace/AliSDKLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   329: iconst_0
    //   330: ireturn
    //   331: aconst_null
    //   332: astore_2
    //   333: goto -108 -> 225
    //   336: aload_2
    //   337: ifnonnull -240 -> 97
    //   340: iconst_0
    //   341: ireturn
    //   342: iconst_1
    //   343: ireturn
    //   344: iconst_0
    //   345: istore 4
    //   347: goto -190 -> 157
    //   350: astore_2
    //   351: aconst_null
    //   352: astore_2
    //   353: goto -128 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	this	ServiceInvocationFilterAction
    //   0	356	1	paramFilterContext	com.alibaba.sdk.android.ui.bus.filter.FilterContext
    //   60	277	2	localObject1	Object
    //   350	1	2	localException	Exception
    //   352	1	2	localObject2	Object
    //   58	236	3	localObject3	Object
    //   155	191	4	i	int
    //   205	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   44	59	299	java/lang/Exception
    //   65	94	299	java/lang/Exception
    //   97	143	299	java/lang/Exception
    //   145	154	299	java/lang/Exception
    //   162	207	299	java/lang/Exception
    //   229	243	299	java/lang/Exception
    //   247	259	299	java/lang/Exception
    //   262	275	299	java/lang/Exception
    //   280	294	299	java/lang/Exception
    //   212	225	350	java/lang/Exception
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\bus\filter\impl\ServiceInvocationFilterAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */