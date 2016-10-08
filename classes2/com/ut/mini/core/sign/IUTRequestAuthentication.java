package com.ut.mini.core.sign;

public abstract interface IUTRequestAuthentication
{
  public abstract String getAppkey();
  
  public abstract String getSign(String paramString);
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\ut\mini\core\sign\IUTRequestAuthentication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */