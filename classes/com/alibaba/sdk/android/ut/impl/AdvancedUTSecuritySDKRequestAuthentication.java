package com.alibaba.sdk.android.ut.impl;

import android.content.Context;
import android.util.Log;
import com.alibaba.sdk.android.ConfigManager;
import com.ut.mini.core.sign.UTSecuritySDKRequestAuthentication;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class AdvancedUTSecuritySDKRequestAuthentication
  extends UTSecuritySDKRequestAuthentication
{
  private static final String TAG = "ut";
  private String appKey = null;
  private Context context;
  private Field contextAppKeyField = null;
  private Field contextParamMapField = null;
  private Field contextRequestTypeField = null;
  private boolean initialized;
  private Object securityGuardManager = null;
  private Class<?> securityGuardParamContextClazz = null;
  private Object securitySignatureComponent = null;
  private Method signRequestMethod = null;
  
  public AdvancedUTSecuritySDKRequestAuthentication(String paramString, Context paramContext)
  {
    super(paramString, "");
    this.appKey = paramString;
    this.context = paramContext;
    init();
  }
  
  private void init()
  {
    try
    {
      Class localClass = Class.forName("com.alibaba.wireless.security.open.SecurityGuardManager");
      this.securityGuardManager = localClass.getMethod("getInstance", new Class[] { Context.class }).invoke(null, new Object[] { this.context });
      this.securitySignatureComponent = localClass.getMethod("getSecureSignatureComp", new Class[0]).invoke(this.securityGuardManager, new Object[0]);
      return;
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        this.securityGuardParamContextClazz = Class.forName("com.alibaba.wireless.security.open.SecurityGuardParamContext");
        this.contextAppKeyField = this.securityGuardParamContextClazz.getDeclaredField("appKey");
        this.contextParamMapField = this.securityGuardParamContextClazz.getDeclaredField("paramMap");
        this.contextRequestTypeField = this.securityGuardParamContextClazz.getDeclaredField("requestType");
        this.signRequestMethod = Class.forName("com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent").getMethod("signRequest", new Class[] { this.securityGuardParamContextClazz, String.class });
        this.initialized = true;
        return;
      }
      catch (Throwable localThrowable2)
      {
        Log.e("ut", "Fail to init UT, the error message is " + localThrowable2.getMessage());
        localThrowable2.printStackTrace();
      }
      localThrowable1 = localThrowable1;
      Log.e("ut", "Fail to load security signature component", localThrowable1);
      return;
    }
  }
  
  public String getAppkey()
  {
    return this.appKey;
  }
  
  public String getSign(String paramString)
  {
    if (this.appKey == null)
    {
      Log.e("ut", "UTSecuritySDKRequestAuthentication:getSign, There is no appkey,please check it!");
      return null;
    }
    if (paramString == null) {
      return null;
    }
    if (!this.initialized) {
      return null;
    }
    try
    {
      Object localObject = this.securityGuardParamContextClazz.newInstance();
      this.contextAppKeyField.set(localObject, this.appKey);
      ((Map)this.contextParamMapField.get(localObject)).put("INPUT", paramString);
      this.contextRequestTypeField.set(localObject, Integer.valueOf(1));
      paramString = (String)this.signRequestMethod.invoke(this.securitySignatureComponent, new Object[] { localObject, ConfigManager.POSTFIX_OF_SECURITY_JPG });
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ut\impl\AdvancedUTSecuritySDKRequestAuthentication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */