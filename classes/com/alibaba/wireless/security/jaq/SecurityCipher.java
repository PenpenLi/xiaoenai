package com.alibaba.wireless.security.jaq;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.atlasencrypt.IAtlasEncryptComponent;
import com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent;

public class SecurityCipher
{
  private Context a;
  
  public SecurityCipher(Context paramContext)
  {
    if (paramContext != null) {
      this.a = paramContext.getApplicationContext();
    }
  }
  
  public String atlasEncryptString(String paramString)
  {
    try
    {
      IAtlasEncryptComponent localIAtlasEncryptComponent = SecurityGuardManager.getInstance(this.a).getAtlasEncryptComp();
      if (localIAtlasEncryptComponent != null) {
        return localIAtlasEncryptComponent.atlasSafeEncrypt(paramString, "0335");
      }
      throw new SecException(1098);
    }
    catch (SecException paramString)
    {
      paramString.printStackTrace();
      throw new JAQException(paramString.getErrorCode());
    }
  }
  
  public byte[] decryptBinary(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      paramArrayOfByte = SecurityGuardManager.getInstance(this.a).getStaticDataEncryptComp().staticBinarySafeDecrypt(16, paramString, paramArrayOfByte, "0335");
      return paramArrayOfByte;
    }
    catch (SecException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      throw new JAQException(paramArrayOfByte.getErrorCode());
    }
  }
  
  public String decryptString(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = SecurityGuardManager.getInstance(this.a).getStaticDataEncryptComp().staticSafeDecrypt(16, paramString2, paramString1, "0335");
      return paramString1;
    }
    catch (SecException paramString1)
    {
      paramString1.printStackTrace();
      throw new JAQException(paramString1.getErrorCode());
    }
  }
  
  public byte[] encryptBinary(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      paramArrayOfByte = SecurityGuardManager.getInstance(this.a).getStaticDataEncryptComp().staticBinarySafeEncrypt(16, paramString, paramArrayOfByte, "0335");
      return paramArrayOfByte;
    }
    catch (SecException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      throw new JAQException(paramArrayOfByte.getErrorCode());
    }
  }
  
  public String encryptString(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = SecurityGuardManager.getInstance(this.a).getStaticDataEncryptComp().staticSafeEncrypt(16, paramString2, paramString1, "0335");
      return paramString1;
    }
    catch (SecException paramString1)
    {
      paramString1.printStackTrace();
      throw new JAQException(paramString1.getErrorCode());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\jaq\SecurityCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */