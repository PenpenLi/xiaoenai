package com.alibaba.wireless.security.open.statickeyencrypt;

import com.alibaba.wireless.security.open.IComponent;

public abstract interface IStaticKeyEncryptComponent
  extends IComponent
{
  public static final int OPEN_ALGORITHM_MAX_NUMBER = 20;
  public static final int OPEN_CIPHER_AES128 = 16;
  public static final int OPEN_CIPHER_AES192 = 17;
  public static final int OPEN_CIPHER_AES256 = 18;
  public static final int OPEN_NO_SUCH_ITEM = 2;
  public static final int OPEN_OVERRIDE_SUCCESS = 2;
  public static final int OPEN_REMOVE_FAILED = 0;
  public static final int OPEN_REMOVE_SUCCESS = 1;
  public static final int OPEN_SAVE_FAILED = 0;
  public static final int OPEN_SAVE_SUCCESS = 1;
  
  public abstract byte[] decrypt(int paramInt, String paramString, byte[] paramArrayOfByte);
  
  public abstract byte[] encrypt(int paramInt, String paramString, byte[] paramArrayOfByte);
  
  public abstract byte[] encryptSecretData(int paramInt, String paramString1, String paramString2);
  
  public abstract boolean isSecretExist(String paramString);
  
  public abstract int removeSecret(String paramString);
  
  public abstract int saveSecret(String paramString, byte[] paramArrayOfByte);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\statickeyencrypt\IStaticKeyEncryptComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */