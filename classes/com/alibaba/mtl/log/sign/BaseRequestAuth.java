package com.alibaba.mtl.log.sign;

import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.j;

public class BaseRequestAuth
  implements IRequestAuth
{
  private String Z = null;
  private String b = null;
  
  public BaseRequestAuth(String paramString1, String paramString2)
  {
    this.b = paramString1;
    this.Z = paramString2;
  }
  
  public String getAppSecret()
  {
    return this.Z;
  }
  
  public String getAppkey()
  {
    return this.b;
  }
  
  public String getSign(String paramString)
  {
    if ((this.b == null) || (this.Z == null)) {
      i.a("BaseRequestAuth", new Object[] { "There is no appkey,please check it!" });
    }
    while (paramString == null) {
      return null;
    }
    return j.a(j.a((paramString + this.Z).getBytes()));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\sign\BaseRequestAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */