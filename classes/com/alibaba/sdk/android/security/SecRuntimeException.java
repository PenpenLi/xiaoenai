package com.alibaba.sdk.android.security;

public class SecRuntimeException
  extends RuntimeException
{
  private static final long serialVersionUID = -2429061914258524220L;
  private int secCode;
  
  public SecRuntimeException(int paramInt, Throwable paramThrowable)
  {
    super(paramThrowable);
    this.secCode = paramInt;
  }
  
  public int getErrorCode()
  {
    return this.secCode;
  }
  
  public String getMessage()
  {
    return super.getMessage() + " secCode = " + this.secCode;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\security\SecRuntimeException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */