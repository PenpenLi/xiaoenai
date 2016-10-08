package com.alibaba.sdk.android.ui.bus;

public class ExecutionResult
{
  public boolean procceed = false;
  public String uri;
  
  public ExecutionResult(boolean paramBoolean, String paramString)
  {
    this.procceed = paramBoolean;
    this.uri = paramString;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\bus\ExecutionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */