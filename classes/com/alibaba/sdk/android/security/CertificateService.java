package com.alibaba.sdk.android.security;

public abstract interface CertificateService
{
  public abstract byte[] getPublicKey();
  
  public abstract void refreshCer();
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\security\CertificateService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */