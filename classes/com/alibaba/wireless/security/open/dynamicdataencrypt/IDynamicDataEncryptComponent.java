package com.alibaba.wireless.security.open.dynamicdataencrypt;

import com.alibaba.wireless.security.open.IComponent;

public abstract interface IDynamicDataEncryptComponent
  extends IComponent
{
  public abstract String dynamicDecrypt(String paramString);
  
  public abstract byte[] dynamicDecryptByteArray(byte[] paramArrayOfByte);
  
  public abstract byte[] dynamicDecryptByteArrayDDp(byte[] paramArrayOfByte);
  
  public abstract String dynamicDecryptDDp(String paramString);
  
  public abstract String dynamicEncrypt(String paramString);
  
  public abstract byte[] dynamicEncryptByteArray(byte[] paramArrayOfByte);
  
  public abstract byte[] dynamicEncryptByteArrayDDp(byte[] paramArrayOfByte);
  
  public abstract String dynamicEncryptDDp(String paramString);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\dynamicdataencrypt\IDynamicDataEncryptComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */