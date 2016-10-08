package com.alibaba.sdk.android.security;

public abstract interface SecurityGuardService
{
  public abstract Long analyzeOpenId(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte);
  
  public abstract String genAsymEncryptedSeedKey();
  
  public abstract String genAsymEncryptedSeedKey(String paramString);
  
  public abstract byte[] genSeedKey();
  
  public abstract String getAppKey();
  
  public abstract byte[] getByteArrayFromDynamicDataStore(String paramString);
  
  public abstract String getProviderName();
  
  public abstract String getSecurityToken();
  
  public abstract String getValueFromDynamicDataStore(String paramString);
  
  public abstract String getValueFromStaticDataStore(String paramString);
  
  public abstract boolean isSecretExist(String paramString);
  
  public abstract void putValueInDynamicDataStore(String paramString1, String paramString2);
  
  public abstract void putValueInDynamicDataStore(String paramString, byte[] paramArrayOfByte);
  
  public abstract void removeValueFromDynamicDataStore(String paramString);
  
  public abstract boolean restoreSecretIfAbsent(String paramString);
  
  public abstract String rsaEncrypt(byte[] paramArrayOfByte);
  
  public abstract void savePublicKey(byte[] paramArrayOfByte);
  
  public abstract void saveSecret(String paramString, byte[] paramArrayOfByte);
  
  public abstract String sign(String paramString);
  
  public abstract String sign(String paramString1, String paramString2);
  
  public abstract String signRequest(String paramString, int paramInt);
  
  public abstract String symDecrypt(String paramString);
  
  public abstract String symDecrypt(String paramString1, String paramString2);
  
  public abstract byte[] symDecrypt(byte[] paramArrayOfByte, String paramString);
  
  public abstract String symEncrypt(String paramString);
  
  public abstract String symEncrypt(String paramString1, String paramString2);
  
  public abstract byte[] symEncrypt(byte[] paramArrayOfByte, String paramString);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\security\SecurityGuardService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */