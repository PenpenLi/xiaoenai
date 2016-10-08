package com.ut.mini.core.sign;

import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.j;

public class UTBaseRequestAuthentication
  implements IUTRequestAuthentication
{
  private String Z = null;
  private String b = null;
  
  public UTBaseRequestAuthentication(String paramString1, String paramString2)
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
      i.a("UTBaseRequestAuthentication", "There is no appkey,please check it!");
    }
    while (paramString == null) {
      return null;
    }
    return j.a(j.a((paramString + this.Z).getBytes()));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\ut\mini\core\sign\UTBaseRequestAuthentication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */