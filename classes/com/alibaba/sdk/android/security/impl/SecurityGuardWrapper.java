package com.alibaba.sdk.android.security.impl;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.sdk.android.AlibabaSDK;
import com.alibaba.sdk.android.ConfigManager;
import com.alibaba.sdk.android.ResultCode;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.lock.InterProcessLock;
import com.alibaba.sdk.android.security.SecRuntimeException;
import com.alibaba.sdk.android.security.SecurityGuardService;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.ut.UserTrackerService;
import com.alibaba.sdk.android.util.CommonUtils;
import com.alibaba.sdk.android.util.ReflectionUtils;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent;
import com.alibaba.wireless.security.open.opensdk.IOpenSDKComponent;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import com.alibaba.wireless.security.open.staticdatastore.IStaticDataStoreComponent;
import com.alibaba.wireless.security.open.statickeyencrypt.IStaticKeyEncryptComponent;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class SecurityGuardWrapper
  implements SecurityGuardService
{
  public static final String INIT_SEED_KEY = "initialization_key";
  public static final SecurityGuardWrapper INSTANCE = new SecurityGuardWrapper();
  private static final String SEED_KEY = "seed_key";
  private static final String TAG = SecurityGuardWrapper.class.getSimpleName();
  private Map<String, byte[]> cachedSeedKeys = new HashMap();
  private Context context;
  private InterProcessLock lock;
  private Map<String, ThreadLocal<byte[]>> threedLocalSeedKey = new HashMap();
  
  /* Error */
  private void _removeSecret(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 59	com/alibaba/sdk/android/security/impl/SecurityGuardWrapper:getSecurityGuardManager	()Lcom/alibaba/wireless/security/open/SecurityGuardManager;
    //   6: invokevirtual 65	com/alibaba/wireless/security/open/SecurityGuardManager:getStaticKeyEncryptComp	()Lcom/alibaba/wireless/security/open/statickeyencrypt/IStaticKeyEncryptComponent;
    //   9: aload_1
    //   10: invokeinterface 71 2 0
    //   15: pop
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: astore_2
    //   20: ldc 73
    //   22: new 75	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   29: ldc 78
    //   31: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_1
    //   35: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc 84
    //   40: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_2
    //   44: invokevirtual 88	com/alibaba/wireless/security/open/SecException:getErrorCode	()I
    //   47: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: aload_2
    //   54: invokestatic 100	com/alibaba/sdk/android/trace/AliSDKLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   57: goto -41 -> 16
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    //   65: astore_2
    //   66: ldc 73
    //   68: new 75	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   75: ldc 78
    //   77: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_1
    //   81: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: aload_2
    //   88: invokestatic 100	com/alibaba/sdk/android/trace/AliSDKLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   91: goto -75 -> 16
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	SecurityGuardWrapper
    //   0	94	1	paramString	String
    //   19	35	2	localSecException	SecException
    //   65	23	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	16	19	com/alibaba/wireless/security/open/SecException
    //   2	16	60	finally
    //   20	57	60	finally
    //   66	91	60	finally
    //   2	16	65	java/lang/Exception
  }
  
  private void _saveSecret(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        this.lock.tryLock("saveSecret");
        int i = getSecurityGuardManager().getStaticKeyEncryptComp().saveSecret(paramString, paramArrayOfByte);
        if (paramBoolean) {
          this.cachedSeedKeys.put(paramString, paramArrayOfByte);
        }
        if (paramArrayOfByte == null)
        {
          str = "NULL";
          logSecurityGuardUTMessage("security_saveSecret", true, new String[] { "key", paramString, "inputBytes", str, "ret", String.valueOf(i) });
        }
      }
      catch (SecException localSecException)
      {
        String str;
        if (paramArrayOfByte != null) {
          break;
        }
        paramArrayOfByte = "NULL";
        logSecurityGuardUTMessage("security_saveSecret", false, new String[] { "key", paramString, "inputBytes", paramArrayOfByte, "code", String.valueOf(localSecException.getErrorCode()) });
        throw new SecRuntimeException(localSecException.getErrorCode(), localSecException);
      }
      finally
      {
        this.lock.unLock("saveSecret");
      }
      try
      {
        this.lock.unLock("saveSecret");
        return;
      }
      finally {}
      str = "N-NULL";
    }
    for (;;)
    {
      paramArrayOfByte = "N-NULL";
    }
  }
  
  private String _sign(SecurityGuardParamContext paramSecurityGuardParamContext, String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        this.lock.tryLock("sign");
        paramSecurityGuardParamContext = getSecurityGuardManager().getSecureSignatureComp().signRequest(paramSecurityGuardParamContext, ConfigManager.POSTFIX_OF_SECURITY_JPG);
        return paramSecurityGuardParamContext;
      }
      catch (SecException localSecException)
      {
        if (paramString1 == null)
        {
          paramSecurityGuardParamContext = "NULL";
          logSecurityGuardUTMessage("security_sign", false, new String[] { "seedKeyName", paramString2, "inputStr", paramSecurityGuardParamContext, "code", String.valueOf(localSecException.getErrorCode()) });
          throw new SecRuntimeException(localSecException.getErrorCode(), localSecException);
        }
      }
      finally
      {
        this.lock.unLock("sign");
      }
      paramSecurityGuardParamContext = "N-NULL";
    }
  }
  
  private byte[] _symDecrypt(byte[] paramArrayOfByte, String paramString)
  {
    for (;;)
    {
      byte[] arrayOfByte;
      try
      {
        this.lock.tryLock("symDecrypt");
        arrayOfByte = getSecurityGuardManager().getStaticKeyEncryptComp().decrypt(16, paramString, paramArrayOfByte);
        if (paramArrayOfByte == null)
        {
          str1 = "NULL";
          break label198;
          logSecurityGuardUTMessage("security_symDecrypt", true, new String[] { "seedKeyName", paramString, "inputBytes", str1, "ret", str2 });
        }
      }
      catch (SecException localSecException)
      {
        String str1;
        if (paramArrayOfByte != null) {
          break label192;
        }
        paramArrayOfByte = "NULL";
        logSecurityGuardUTMessage("security_symDecrypt", false, new String[] { "seedKeyName", paramString, "inputBytes", paramArrayOfByte, "code", String.valueOf(localSecException.getErrorCode()) });
        throw new SecRuntimeException(localSecException.getErrorCode(), localSecException);
      }
      finally
      {
        this.lock.unLock("symDecrypt");
      }
      try
      {
        this.lock.unLock("symDecrypt");
        return arrayOfByte;
      }
      finally {}
      str1 = "N-NULL";
      break label198;
      String str2 = "N-NULL";
      continue;
      label192:
      paramArrayOfByte = "N-NULL";
      continue;
      label198:
      if (arrayOfByte == null) {
        str2 = "NULL";
      }
    }
  }
  
  private byte[] _symEncrypt(byte[] paramArrayOfByte, String paramString)
  {
    for (;;)
    {
      try
      {
        this.lock.tryLock("symEncrypt");
        saveThreadSeedKey(paramString);
        arrayOfByte = getSecurityGuardManager().getStaticKeyEncryptComp().encrypt(16, paramString, paramArrayOfByte);
        if (arrayOfByte == null)
        {
          paramArrayOfByte = "NULL";
          logSecurityGuardUTMessage("security_symEncrypt", true, new String[] { "seedKeyName", paramString, "inputStr", "N-NULL", "ret", paramArrayOfByte });
        }
      }
      catch (SecException paramArrayOfByte)
      {
        byte[] arrayOfByte;
        logSecurityGuardUTMessage("security_symEncrypt", false, new String[] { "seedKeyName", paramString, "inputStr", "N-NULL", "code", String.valueOf(paramArrayOfByte.getErrorCode()) });
        throw new SecRuntimeException(paramArrayOfByte.getErrorCode(), paramArrayOfByte);
      }
      finally
      {
        this.lock.unLock("symEncrypt");
      }
      try
      {
        this.lock.unLock("symEncrypt");
        return arrayOfByte;
      }
      finally {}
      paramArrayOfByte = "N-NULL";
    }
  }
  
  private SecurityGuardManager getSecurityGuardManager()
  {
    try
    {
      SecurityGuardManager localSecurityGuardManager = SecurityGuardManager.getInstance(this.context);
      return localSecurityGuardManager;
    }
    catch (SecException localSecException)
    {
      throw new SecRuntimeException(localSecException.getErrorCode(), localSecException);
    }
  }
  
  /* Error */
  private byte[] getThreadSeedKey(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 47	com/alibaba/sdk/android/security/impl/SecurityGuardWrapper:threedLocalSeedKey	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 211 2 0
    //   12: checkcast 213	java/lang/ThreadLocal
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull +9 -> 26
    //   20: aconst_null
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: areturn
    //   26: aload_1
    //   27: invokevirtual 216	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   30: checkcast 218	[B
    //   33: astore_1
    //   34: goto -12 -> 22
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	SecurityGuardWrapper
    //   0	42	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	16	37	finally
    //   26	34	37	finally
  }
  
  private boolean isWeakSecurity()
  {
    return getSecurityGuardManager().getSDKVerison().contains("weak");
  }
  
  private void logSecurityGuardUTMessage(String paramString, boolean paramBoolean, String... paramVarArgs)
  {
    if (SecurityContext.disableSecurityGuardUT) {}
    for (;;)
    {
      return;
      try
      {
        UserTrackerService localUserTrackerService = (UserTrackerService)SecurityContext.appContext.getService(UserTrackerService.class);
        if (localUserTrackerService == null) {
          continue;
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("process", CommonUtils.getCurrentProcessName());
        if (paramVarArgs.length > 1)
        {
          int i = 0;
          int j = paramVarArgs.length;
          while (i < j)
          {
            localHashMap.put(paramVarArgs[i], paramVarArgs[(i + 1)]);
            i += 2;
          }
        }
        localHashMap.put("provider", getProviderName());
        if (paramBoolean) {}
        for (paramVarArgs = "success";; paramVarArgs = "error")
        {
          localUserTrackerService.sendCustomHit(paramString, 0L, paramVarArgs, localHashMap);
          return;
        }
        return;
      }
      catch (Throwable paramString) {}
    }
  }
  
  private void saveThreadSeedKey(String paramString)
  {
    try
    {
      byte[] arrayOfByte = (byte[])this.cachedSeedKeys.get(paramString);
      if (arrayOfByte != null) {
        saveThreadSeedKey(paramString, arrayOfByte);
      }
      return;
    }
    finally {}
  }
  
  private void saveThreadSeedKey(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      ThreadLocal localThreadLocal2 = (ThreadLocal)this.threedLocalSeedKey.get(paramString);
      ThreadLocal localThreadLocal1 = localThreadLocal2;
      if (localThreadLocal2 == null)
      {
        localThreadLocal1 = new ThreadLocal();
        this.threedLocalSeedKey.put(paramString, localThreadLocal1);
      }
      localThreadLocal1.set(paramArrayOfByte);
      return;
    }
    finally {}
  }
  
  public Long analyzeOpenId(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    if ((getSecurityGuardManager() == null) || (getSecurityGuardManager().getOpenSDKComp() == null)) {
      return null;
    }
    try
    {
      paramString1 = getSecurityGuardManager().getOpenSDKComp().analyzeOpenId(paramString1, paramString2, paramString3, paramArrayOfByte, ConfigManager.POSTFIX_OF_SECURITY_JPG);
      return paramString1;
    }
    catch (SecException paramString1)
    {
      AliSDKLogger.e(TAG, "Fail to analyze open id, the sec code is " + paramString1.getErrorCode(), paramString1);
    }
    return null;
  }
  
  public String genAsymEncryptedSeedKey()
  {
    return genAsymEncryptedSeedKey("seed_key");
  }
  
  public String genAsymEncryptedSeedKey(String paramString)
  {
    byte[] arrayOfByte = genSeedKey();
    saveSecret(paramString, arrayOfByte);
    paramString = CommonUtils.rsaEncrypt(arrayOfByte, CertificateManager.INSTANCE.getPublicKey());
    if (AliSDKLogger.isDebugEnabled()) {
      AliSDKLogger.d(TAG, Base64.encodeToString(paramString, 11));
    }
    return Base64.encodeToString(paramString, 11);
  }
  
  public byte[] genSeedKey()
  {
    try
    {
      KeyGenerator localKeyGenerator = KeyGenerator.getInstance("AES");
      localKeyGenerator.init(128);
      return localKeyGenerator.generateKey().getEncoded();
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      logSecurityGuardUTMessage("security_genSeedKey", false, new String[] { "code", localNoSuchAlgorithmException.getMessage() });
      throw new RuntimeException(localNoSuchAlgorithmException);
    }
  }
  
  public String getAppKey()
  {
    try
    {
      String str = getSecurityGuardManager().getStaticDataStoreComp().getAppKeyByIndex(ConfigManager.getAppKeyIndex(), ConfigManager.POSTFIX_OF_SECURITY_JPG);
      return str;
    }
    catch (SecException localSecException)
    {
      logSecurityGuardUTMessage("security_getAppKey", false, new String[] { "code", String.valueOf(localSecException.getErrorCode()) });
      throw new SecRuntimeException(localSecException.getErrorCode(), localSecException);
    }
  }
  
  public byte[] getByteArrayFromDynamicDataStore(String paramString)
  {
    for (;;)
    {
      try
      {
        this.lock.tryLock("getByteArrayFromDynamicDataStore");
        arrayOfByte = getSecurityGuardManager().getDynamicDataStoreComp().getByteArray(paramString);
        if (arrayOfByte == null)
        {
          str = "NULL";
          logSecurityGuardUTMessage("security_getDynamicDataStore", true, new String[] { "key", paramString, "ret", str });
        }
      }
      catch (SecException localSecException)
      {
        byte[] arrayOfByte;
        String str;
        logSecurityGuardUTMessage("security_getDynamicDataStore", false, new String[] { "key", paramString, "code", String.valueOf(localSecException.getErrorCode()) });
        AliSDKLogger.e(TAG, "Sec Exception, the code = " + localSecException.getErrorCode(), localSecException);
        paramString = null;
        this.lock.unLock("getByteArrayFromDynamicDataStore");
        continue;
      }
      finally
      {
        this.lock.unLock("getByteArrayFromDynamicDataStore");
      }
      try
      {
        this.lock.unLock("getByteArrayFromDynamicDataStore");
        paramString = arrayOfByte;
        return paramString;
      }
      finally {}
      str = "N-NULL";
    }
  }
  
  public String getProviderName()
  {
    if (isWeakSecurity()) {
      return "mini";
    }
    return "full";
  }
  
  /* Error */
  public String getSecurityToken()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 59	com/alibaba/sdk/android/security/impl/SecurityGuardWrapper:getSecurityGuardManager	()Lcom/alibaba/wireless/security/open/SecurityGuardManager;
    //   4: invokevirtual 399	com/alibaba/wireless/security/open/SecurityGuardManager:getUMIDComp	()Lcom/alibaba/wireless/security/open/umid/IUMIDComponent;
    //   7: invokeinterface 403 1 0
    //   12: astore_2
    //   13: aload_2
    //   14: ifnonnull +29 -> 43
    //   17: ldc 123
    //   19: astore_1
    //   20: aload_0
    //   21: ldc_w 405
    //   24: iconst_1
    //   25: iconst_2
    //   26: anewarray 127	java/lang/String
    //   29: dup
    //   30: iconst_0
    //   31: ldc -123
    //   33: aastore
    //   34: dup
    //   35: iconst_1
    //   36: aload_1
    //   37: aastore
    //   38: invokespecial 141	com/alibaba/sdk/android/security/impl/SecurityGuardWrapper:logSecurityGuardUTMessage	(Ljava/lang/String;Z[Ljava/lang/String;)V
    //   41: aload_2
    //   42: areturn
    //   43: ldc -110
    //   45: astore_1
    //   46: goto -26 -> 20
    //   49: astore_1
    //   50: aload_0
    //   51: ldc_w 405
    //   54: iconst_0
    //   55: iconst_2
    //   56: anewarray 127	java/lang/String
    //   59: dup
    //   60: iconst_0
    //   61: ldc -108
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: aload_1
    //   67: invokevirtual 88	com/alibaba/wireless/security/open/SecException:getErrorCode	()I
    //   70: invokestatic 137	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   73: aastore
    //   74: invokespecial 141	com/alibaba/sdk/android/security/impl/SecurityGuardWrapper:logSecurityGuardUTMessage	(Ljava/lang/String;Z[Ljava/lang/String;)V
    //   77: new 150	com/alibaba/sdk/android/security/SecRuntimeException
    //   80: dup
    //   81: aload_1
    //   82: invokevirtual 88	com/alibaba/wireless/security/open/SecException:getErrorCode	()I
    //   85: aload_1
    //   86: invokespecial 153	com/alibaba/sdk/android/security/SecRuntimeException:<init>	(ILjava/lang/Throwable;)V
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	SecurityGuardWrapper
    //   19	27	1	str1	String
    //   49	37	1	localSecException	SecException
    //   12	30	2	str2	String
    // Exception table:
    //   from	to	target	type
    //   0	13	49	com/alibaba/wireless/security/open/SecException
    //   20	41	49	com/alibaba/wireless/security/open/SecException
  }
  
  public String getValueFromDynamicDataStore(String paramString)
  {
    for (;;)
    {
      try
      {
        this.lock.tryLock("getValueFromDynamicDataStore");
        str2 = getSecurityGuardManager().getDynamicDataStoreComp().getString(paramString);
        if (str2 == null)
        {
          str1 = "NULL";
          logSecurityGuardUTMessage("security_getDynamicDataStore", true, new String[] { "key", paramString, "ret", str1 });
        }
      }
      catch (SecException localSecException)
      {
        String str2;
        String str1;
        logSecurityGuardUTMessage("security_getDynamicDataStore", false, new String[] { "key", paramString, "code", String.valueOf(localSecException.getErrorCode()) });
        AliSDKLogger.e(TAG, "Sec Exception, the code = " + localSecException.getErrorCode(), localSecException);
        paramString = null;
        this.lock.unLock("getValueFromDynamicDataStore");
        continue;
      }
      finally
      {
        this.lock.unLock("getValueFromDynamicDataStore");
      }
      try
      {
        this.lock.unLock("getValueFromDynamicDataStore");
        paramString = str2;
        return paramString;
      }
      finally {}
      str1 = "N-NULL";
    }
  }
  
  public String getValueFromStaticDataStore(String paramString)
  {
    for (;;)
    {
      try
      {
        String str2 = getSecurityGuardManager().getStaticDataStoreComp().getExtraData(paramString, ConfigManager.POSTFIX_OF_SECURITY_JPG);
        if (str2 != null) {
          continue;
        }
        str1 = "NULL";
        logSecurityGuardUTMessage("security_getStaticDataStore", true, new String[] { "key", paramString, "ret", str1 });
        paramString = str2;
      }
      catch (SecException localSecException)
      {
        String str1;
        logSecurityGuardUTMessage("security_getStaticDataStore", false, new String[] { "key", paramString, "code", String.valueOf(localSecException.getErrorCode()) });
        AliSDKLogger.e(TAG, "Sec Exception, the code = " + localSecException.getErrorCode(), localSecException);
        paramString = null;
        continue;
      }
      finally {}
      return paramString;
      str1 = "N-NULL";
    }
  }
  
  public ResultCode init(AppContext paramAppContext)
  {
    this.context = paramAppContext.getAndroidContext();
    this.lock = new InterProcessLock(this.context, "securityGuardWrapper");
    this.lock.enableUTLog = "true".equals(AlibabaSDK.getProperty("security", "disableSecurityGuardUT"));
    InterProcessLock localInterProcessLock = this.lock;
    if (!"true".equals(AlibabaSDK.getProperty("security", "enableFileLock"))) {}
    for (boolean bool = true;; bool = false)
    {
      localInterProcessLock.disabled = bool;
      return new SecurityGuardInitializer().init(paramAppContext);
    }
  }
  
  public boolean isSecretExist(String paramString)
  {
    try
    {
      this.lock.tryLock("isSecretExist");
      boolean bool = getSecurityGuardManager().getStaticKeyEncryptComp().isSecretExist(paramString);
      return bool;
    }
    catch (SecException paramString)
    {
      AliSDKLogger.e("SecurityGuardWrapper", "failed to invoke isSecretExis, the code " + paramString.getErrorCode(), paramString);
      return false;
    }
    finally
    {
      this.lock.unLock("isSecretExist");
    }
  }
  
  public void putValueInDynamicDataStore(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        this.lock.tryLock("putValueInDynamicDataStore");
        int i = getSecurityGuardManager().getDynamicDataStoreComp().putString(paramString1, paramString2);
        if (paramString2 == null)
        {
          str = "NULL";
          logSecurityGuardUTMessage("security_putDynamicDataStore", true, new String[] { "key", paramString1, "value", str, "res", String.valueOf(i) });
        }
      }
      catch (SecException localSecException)
      {
        String str;
        if (paramString2 != null) {
          break;
        }
        paramString2 = "NULL";
        logSecurityGuardUTMessage("security_putDynamicDataStore", false, new String[] { "key", paramString1, "value", paramString2, "code", String.valueOf(localSecException.getErrorCode()) });
        throw new SecRuntimeException(localSecException.getErrorCode(), localSecException);
      }
      finally
      {
        this.lock.unLock("putValueInDynamicDataStore");
      }
      try
      {
        this.lock.unLock("putValueInDynamicDataStore");
        return;
      }
      finally {}
      str = "N-NULL";
    }
    for (;;)
    {
      paramString2 = "N-NULL";
    }
  }
  
  public void putValueInDynamicDataStore(String paramString, byte[] paramArrayOfByte)
  {
    for (;;)
    {
      try
      {
        this.lock.tryLock("putValueInDynamicDataStore");
        int i = getSecurityGuardManager().getDynamicDataStoreComp().putByteArray(paramString, paramArrayOfByte);
        if (paramArrayOfByte == null)
        {
          str = "NULL";
          logSecurityGuardUTMessage("security_putDynamicDataStore", true, new String[] { "key", paramString, "value", str, "res", String.valueOf(i) });
        }
      }
      catch (SecException localSecException)
      {
        String str;
        if (paramArrayOfByte != null) {
          break;
        }
        paramArrayOfByte = "NULL";
        logSecurityGuardUTMessage("security_putDynamicDataStore", false, new String[] { "key", paramString, "value", paramArrayOfByte, "code", String.valueOf(localSecException.getErrorCode()) });
        throw new SecRuntimeException(localSecException.getErrorCode(), localSecException);
      }
      finally
      {
        this.lock.unLock("putValueInDynamicDataStore");
      }
      try
      {
        this.lock.unLock("putValueInDynamicDataStore");
        return;
      }
      finally {}
      str = "N-NULL";
    }
    for (;;)
    {
      paramArrayOfByte = "N-NULL";
    }
  }
  
  /* Error */
  public void removeValueFromDynamicDataStore(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 104	com/alibaba/sdk/android/security/impl/SecurityGuardWrapper:lock	Lcom/alibaba/sdk/android/lock/InterProcessLock;
    //   6: ldc_w 477
    //   9: invokevirtual 112	com/alibaba/sdk/android/lock/InterProcessLock:tryLock	(Ljava/lang/String;)Z
    //   12: pop
    //   13: aload_0
    //   14: invokespecial 59	com/alibaba/sdk/android/security/impl/SecurityGuardWrapper:getSecurityGuardManager	()Lcom/alibaba/wireless/security/open/SecurityGuardManager;
    //   17: invokevirtual 379	com/alibaba/wireless/security/open/SecurityGuardManager:getDynamicDataStoreComp	()Lcom/alibaba/wireless/security/open/dynamicdatastore/IDynamicDataStoreComponent;
    //   20: aload_1
    //   21: invokeinterface 480 2 0
    //   26: aload_0
    //   27: ldc_w 482
    //   30: iconst_1
    //   31: iconst_2
    //   32: anewarray 127	java/lang/String
    //   35: dup
    //   36: iconst_0
    //   37: ldc -127
    //   39: aastore
    //   40: dup
    //   41: iconst_1
    //   42: aload_1
    //   43: aastore
    //   44: invokespecial 141	com/alibaba/sdk/android/security/impl/SecurityGuardWrapper:logSecurityGuardUTMessage	(Ljava/lang/String;Z[Ljava/lang/String;)V
    //   47: aload_0
    //   48: getfield 104	com/alibaba/sdk/android/security/impl/SecurityGuardWrapper:lock	Lcom/alibaba/sdk/android/lock/InterProcessLock;
    //   51: ldc_w 477
    //   54: invokevirtual 144	com/alibaba/sdk/android/lock/InterProcessLock:unLock	(Ljava/lang/String;)Z
    //   57: pop
    //   58: aload_0
    //   59: monitorexit
    //   60: return
    //   61: astore_2
    //   62: aload_0
    //   63: ldc_w 482
    //   66: iconst_0
    //   67: iconst_4
    //   68: anewarray 127	java/lang/String
    //   71: dup
    //   72: iconst_0
    //   73: ldc -127
    //   75: aastore
    //   76: dup
    //   77: iconst_1
    //   78: aload_1
    //   79: aastore
    //   80: dup
    //   81: iconst_2
    //   82: ldc -108
    //   84: aastore
    //   85: dup
    //   86: iconst_3
    //   87: aload_2
    //   88: invokevirtual 88	com/alibaba/wireless/security/open/SecException:getErrorCode	()I
    //   91: invokestatic 137	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   94: aastore
    //   95: invokespecial 141	com/alibaba/sdk/android/security/impl/SecurityGuardWrapper:logSecurityGuardUTMessage	(Ljava/lang/String;Z[Ljava/lang/String;)V
    //   98: new 150	com/alibaba/sdk/android/security/SecRuntimeException
    //   101: dup
    //   102: aload_2
    //   103: invokevirtual 88	com/alibaba/wireless/security/open/SecException:getErrorCode	()I
    //   106: aload_2
    //   107: invokespecial 153	com/alibaba/sdk/android/security/SecRuntimeException:<init>	(ILjava/lang/Throwable;)V
    //   110: athrow
    //   111: astore_1
    //   112: aload_0
    //   113: getfield 104	com/alibaba/sdk/android/security/impl/SecurityGuardWrapper:lock	Lcom/alibaba/sdk/android/lock/InterProcessLock;
    //   116: ldc_w 477
    //   119: invokevirtual 144	com/alibaba/sdk/android/lock/InterProcessLock:unLock	(Ljava/lang/String;)Z
    //   122: pop
    //   123: aload_1
    //   124: athrow
    //   125: astore_1
    //   126: aload_0
    //   127: monitorexit
    //   128: aload_1
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	SecurityGuardWrapper
    //   0	130	1	paramString	String
    //   61	46	2	localSecException	SecException
    // Exception table:
    //   from	to	target	type
    //   2	47	61	com/alibaba/wireless/security/open/SecException
    //   2	47	111	finally
    //   62	111	111	finally
    //   47	58	125	finally
    //   112	125	125	finally
  }
  
  public boolean restoreSecretIfAbsent(String paramString)
  {
    if (isSecretExist(paramString)) {
      return true;
    }
    byte[] arrayOfByte = getThreadSeedKey(paramString);
    if (arrayOfByte != null) {
      saveSecret(paramString, arrayOfByte);
    }
    return isSecretExist(paramString);
  }
  
  public String rsaEncrypt(byte[] paramArrayOfByte)
  {
    return Base64.encodeToString(CommonUtils.rsaEncrypt(paramArrayOfByte, CertificateManager.INSTANCE.getPublicKey()), 11);
  }
  
  /* Error */
  public void savePublicKey(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 261	com/alibaba/sdk/android/security/impl/SecurityGuardWrapper:getProviderName	()Ljava/lang/String;
    //   6: ldc_w 491
    //   9: invokevirtual 439	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12: istore_3
    //   13: iload_3
    //   14: ifeq +48 -> 62
    //   17: aload_0
    //   18: invokespecial 59	com/alibaba/sdk/android/security/impl/SecurityGuardWrapper:getSecurityGuardManager	()Lcom/alibaba/wireless/security/open/SecurityGuardManager;
    //   21: invokevirtual 495	java/lang/Object:getClass	()Ljava/lang/Class;
    //   24: ldc_w 497
    //   27: iconst_1
    //   28: anewarray 29	java/lang/Class
    //   31: dup
    //   32: iconst_0
    //   33: ldc -38
    //   35: aastore
    //   36: invokevirtual 501	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   39: astore_2
    //   40: aload_2
    //   41: iconst_1
    //   42: invokevirtual 507	java/lang/reflect/Method:setAccessible	(Z)V
    //   45: aload_2
    //   46: aload_0
    //   47: invokespecial 59	com/alibaba/sdk/android/security/impl/SecurityGuardWrapper:getSecurityGuardManager	()Lcom/alibaba/wireless/security/open/SecurityGuardManager;
    //   50: iconst_1
    //   51: anewarray 4	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: aload_1
    //   57: aastore
    //   58: invokevirtual 511	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   61: pop
    //   62: aload_0
    //   63: monitorexit
    //   64: return
    //   65: astore_1
    //   66: getstatic 35	com/alibaba/sdk/android/security/impl/SecurityGuardWrapper:TAG	Ljava/lang/String;
    //   69: new 75	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   76: ldc_w 513
    //   79: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_1
    //   83: invokevirtual 514	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   86: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: aload_1
    //   93: invokestatic 100	com/alibaba/sdk/android/trace/AliSDKLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   96: goto -34 -> 62
    //   99: astore_1
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_1
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	SecurityGuardWrapper
    //   0	104	1	paramArrayOfByte	byte[]
    //   39	7	2	localMethod	java.lang.reflect.Method
    //   12	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   17	62	65	java/lang/Exception
    //   2	13	99	finally
    //   17	62	99	finally
    //   66	96	99	finally
  }
  
  public void saveSecret(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      _saveSecret(paramString, paramArrayOfByte, true);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public String sign(String paramString)
  {
    return sign(paramString, "seed_key");
  }
  
  public String sign(String paramString1, String paramString2)
  {
    if (getSecurityGuardManager() == null)
    {
      AliSDKLogger.e(TAG, "security guard manager null");
      return null;
    }
    String str1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str1 = "seed_key";
    }
    paramString2 = new SecurityGuardParamContext();
    paramString2.paramMap.put("SEEDKEY", str1);
    paramString2.paramMap.put("INPUT", paramString1);
    paramString2.appKey = AlibabaSDK.getGlobalProperty("com.alibaba.app.appkey");
    paramString2.requestType = 0;
    if (("initialization_key".equals(str1)) && (isWeakSecurity())) {
      ReflectionUtils.set(paramString2, "init", Boolean.valueOf(true));
    }
    try
    {
      String str2 = _sign(paramString2, paramString1, str1);
      return str2;
    }
    catch (SecRuntimeException localSecRuntimeException)
    {
      if (localSecRuntimeException.getErrorCode() == 606)
      {
        byte[] arrayOfByte = getThreadSeedKey(str1);
        if (arrayOfByte != null)
        {
          _saveSecret(str1, arrayOfByte, false);
          return _sign(paramString2, paramString1, str1);
        }
      }
      throw localSecRuntimeException;
    }
  }
  
  public String signRequest(String paramString, int paramInt)
  {
    Object localObject = new SecurityGuardParamContext();
    ((SecurityGuardParamContext)localObject).paramMap.put("INPUT", paramString);
    ((SecurityGuardParamContext)localObject).appKey = AlibabaSDK.getGlobalProperty("com.alibaba.app.appkey");
    ((SecurityGuardParamContext)localObject).requestType = paramInt;
    for (;;)
    {
      try
      {
        this.lock.tryLock("signRequest");
        localObject = getSecurityGuardManager().getSecureSignatureComp().signRequest((SecurityGuardParamContext)localObject, ConfigManager.POSTFIX_OF_SECURITY_JPG);
        return (String)localObject;
      }
      catch (SecException localSecException)
      {
        if (paramString == null)
        {
          paramString = "NULL";
          logSecurityGuardUTMessage("security_signRequest", false, new String[] { "type", String.valueOf(paramInt), "inputStr", paramString, "code", String.valueOf(localSecException.getErrorCode()) });
          throw new SecRuntimeException(localSecException.getErrorCode(), localSecException);
        }
      }
      finally
      {
        this.lock.unLock("signRequest");
      }
      paramString = "N-NULL";
    }
  }
  
  public String symDecrypt(String paramString)
  {
    return symDecrypt(paramString, "seed_key");
  }
  
  public String symDecrypt(String paramString1, String paramString2)
  {
    Object localObject1 = paramString2;
    String str;
    try
    {
      Object localObject2 = Base64.decode(paramString1, 8);
      str = paramString2;
      localObject1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = "seed_key";
      }
      localObject1 = str;
      byte[] arrayOfByte;
      try
      {
        paramString2 = new String(_symDecrypt((byte[])localObject2, str), "UTF-8");
        return paramString2;
      }
      catch (SecRuntimeException paramString2)
      {
        localObject1 = str;
        if (paramString2.getErrorCode() != 703)
        {
          localObject1 = str;
          if (paramString2.getErrorCode() != 705) {
            break label232;
          }
        }
        localObject1 = str;
        arrayOfByte = getThreadSeedKey(str);
        if (arrayOfByte == null) {
          break label232;
        }
      }
      localObject1 = str;
      paramString2 = str + Thread.currentThread().getId();
      paramString1 = "NULL";
    }
    catch (UnsupportedEncodingException paramString2)
    {
      try
      {
        _saveSecret(str, arrayOfByte, false);
        localObject2 = new String(_symDecrypt((byte[])localObject2, str), "UTF-8");
        localObject1 = str;
        _removeSecret(paramString2);
        return (String)localObject2;
      }
      finally
      {
        localObject1 = str;
        _removeSecret(paramString2);
        localObject1 = str;
      }
      paramString2 = paramString2;
      if (paramString1 != null) {}
    }
    for (;;)
    {
      logSecurityGuardUTMessage("security_symDecrypt", false, new String[] { "seedKeyName", localObject1, "inputStr", paramString1, "code", paramString2.getMessage() });
      throw new RuntimeException(paramString2);
      label232:
      localObject1 = str;
      throw paramString2;
      paramString1 = "N-NULL";
    }
  }
  
  public byte[] symDecrypt(byte[] paramArrayOfByte, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "seed_key";
    }
    try
    {
      paramString = _symDecrypt(paramArrayOfByte, str);
      return paramString;
    }
    catch (SecRuntimeException localSecRuntimeException)
    {
      if ((localSecRuntimeException.getErrorCode() == 703) || (localSecRuntimeException.getErrorCode() == 705))
      {
        paramString = getThreadSeedKey(str);
        if (paramString != null)
        {
          str = str + Thread.currentThread().getId();
          try
          {
            _saveSecret(str, paramString, false);
            paramArrayOfByte = _symDecrypt(paramArrayOfByte, str);
            return paramArrayOfByte;
          }
          finally
          {
            _removeSecret(str);
          }
        }
      }
      throw localSecRuntimeException;
    }
  }
  
  public String symEncrypt(String paramString)
  {
    return symEncrypt(paramString, "seed_key");
  }
  
  /* Error */
  public String symEncrypt(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 581
    //   4: invokevirtual 605	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   7: astore_3
    //   8: aload_2
    //   9: astore_1
    //   10: aload_2
    //   11: invokestatic 527	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +6 -> 20
    //   17: ldc 15
    //   19: astore_1
    //   20: aload_0
    //   21: aload_3
    //   22: aload_1
    //   23: invokespecial 607	com/alibaba/sdk/android/security/impl/SecurityGuardWrapper:_symEncrypt	([BLjava/lang/String;)[B
    //   26: bipush 11
    //   28: invokestatic 321	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   31: astore_2
    //   32: aload_2
    //   33: areturn
    //   34: astore_1
    //   35: new 354	java/lang/RuntimeException
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 357	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   43: athrow
    //   44: astore_2
    //   45: aload_2
    //   46: invokevirtual 563	com/alibaba/sdk/android/security/SecRuntimeException:getErrorCode	()I
    //   49: sipush 703
    //   52: if_icmpne +34 -> 86
    //   55: aload_0
    //   56: aload_1
    //   57: invokespecial 486	com/alibaba/sdk/android/security/impl/SecurityGuardWrapper:getThreadSeedKey	(Ljava/lang/String;)[B
    //   60: astore 4
    //   62: aload 4
    //   64: ifnull +22 -> 86
    //   67: aload_0
    //   68: aload_1
    //   69: aload 4
    //   71: invokevirtual 300	com/alibaba/sdk/android/security/impl/SecurityGuardWrapper:saveSecret	(Ljava/lang/String;[B)V
    //   74: aload_0
    //   75: aload_3
    //   76: aload_1
    //   77: invokespecial 607	com/alibaba/sdk/android/security/impl/SecurityGuardWrapper:_symEncrypt	([BLjava/lang/String;)[B
    //   80: bipush 11
    //   82: invokestatic 321	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   85: areturn
    //   86: aload_2
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	SecurityGuardWrapper
    //   0	88	1	paramString1	String
    //   0	88	2	paramString2	String
    //   7	69	3	arrayOfByte1	byte[]
    //   60	10	4	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	8	34	java/io/UnsupportedEncodingException
    //   20	32	44	com/alibaba/sdk/android/security/SecRuntimeException
  }
  
  public byte[] symEncrypt(byte[] paramArrayOfByte, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "seed_key";
    }
    try
    {
      paramString = _symEncrypt(paramArrayOfByte, str);
      return paramString;
    }
    catch (SecRuntimeException paramString)
    {
      if (paramString.getErrorCode() == 703)
      {
        byte[] arrayOfByte = getThreadSeedKey(str);
        if (arrayOfByte != null)
        {
          saveSecret(str, arrayOfByte);
          return _symEncrypt(paramArrayOfByte, str);
        }
      }
      throw paramString;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\security\impl\SecurityGuardWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */