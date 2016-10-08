package org.mzd.crypto;

public class CryptoJNI
{
  public static final native String decryptFromJson(String paramString);
  
  public static final native String encryptToLocal(String paramString);
  
  public static final native String encryptToServer(String paramString);
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\mzd\crypto\CryptoJNI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */