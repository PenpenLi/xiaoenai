package com.alibaba.mtl.log.sign;

public abstract interface IRequestAuth
{
  public abstract String getAppkey();
  
  public abstract String getSign(String paramString);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\sign\IRequestAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */