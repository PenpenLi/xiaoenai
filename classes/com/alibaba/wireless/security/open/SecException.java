package com.alibaba.wireless.security.open;

import java.io.PrintStream;
import java.io.PrintWriter;

public class SecException
  extends Exception
{
  public static final int ERROR_NULL_CONTEXT = -100;
  private int a;
  
  public SecException(int paramInt)
  {
    this.a = paramInt;
  }
  
  public SecException(String paramString, int paramInt)
  {
    super(paramString);
    this.a = paramInt;
  }
  
  public SecException(String paramString, Throwable paramThrowable, int paramInt)
  {
    super(paramString, paramThrowable);
    this.a = paramInt;
  }
  
  public SecException(Throwable paramThrowable, int paramInt)
  {
    super(paramThrowable);
    this.a = paramInt;
  }
  
  public int getErrorCode()
  {
    return this.a;
  }
  
  public void printStackTrace(PrintStream paramPrintStream)
  {
    paramPrintStream.println("ErrorCode = " + getErrorCode());
    super.printStackTrace(paramPrintStream);
  }
  
  public void printStackTrace(PrintWriter paramPrintWriter)
  {
    paramPrintWriter.println("ErrorCode = " + getErrorCode());
    super.printStackTrace(paramPrintWriter);
  }
  
  public void setErrorCode(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\SecException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */