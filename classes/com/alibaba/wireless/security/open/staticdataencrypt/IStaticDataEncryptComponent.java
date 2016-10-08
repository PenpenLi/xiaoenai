package com.alibaba.wireless.security.open.staticdataencrypt;

import com.alibaba.wireless.security.open.IComponent;

public abstract interface IStaticDataEncryptComponent
  extends IComponent
{
  public static final int ALGORITHM_MAX_NUMBER = 19;
  public static final int OPEN_ENUM_CIPHER_AES128 = 16;
  public static final int OPEN_ENUM_CIPHER_AES192 = 17;
  public static final int OPEN_ENUM_CIPHER_AES256 = 18;
  
  public abstract byte[] staticBinarySafeDecrypt(int paramInt, String paramString1, byte[] paramArrayOfByte, String paramString2);
  
  public abstract byte[] staticBinarySafeDecryptNoB64(int paramInt, String paramString1, byte[] paramArrayOfByte, String paramString2);
  
  public abstract byte[] staticBinarySafeEncrypt(int paramInt, String paramString1, byte[] paramArrayOfByte, String paramString2);
  
  public abstract byte[] staticBinarySafeEncryptNoB64(int paramInt, String paramString1, byte[] paramArrayOfByte, String paramString2);
  
  public abstract String staticSafeDecrypt(int paramInt, String paramString1, String paramString2, String paramString3);
  
  public abstract String staticSafeEncrypt(int paramInt, String paramString1, String paramString2, String paramString3);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\staticdataencrypt\IStaticDataEncryptComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */