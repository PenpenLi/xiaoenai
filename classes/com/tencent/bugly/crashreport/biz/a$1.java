package com.tencent.bugly.crashreport.biz;

import com.tencent.bugly.proguard.s;
import com.tencent.bugly.proguard.w;
import java.util.Iterator;
import java.util.List;

final class a$1
  implements s
{
  a$1(a parama, List paramList) {}
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      w.c("up success do final", new Object[0]);
      long l = System.currentTimeMillis();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        UserInfoBean localUserInfoBean = (UserInfoBean)localIterator.next();
        localUserInfoBean.f = l;
        a.a(this.b, localUserInfoBean);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\tencent\bugly\crashreport\biz\a$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */