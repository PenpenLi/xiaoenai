package cn.sharesdk.tencent.qq;

import com.mob.tools.b.a;

class j
  extends Thread
{
  j(i parami, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {}
  
  public void run()
  {
    try
    {
      str = a.a(i.a(this.h), this.a);
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          String str;
          i.a(this.h, this.b, this.c, this.d, this.a, str, this.e, this.f, this.g);
          return;
        }
        catch (Throwable localThrowable2)
        {
          Object localObject;
          cn.sharesdk.framework.utils.d.a().w(localThrowable2);
        }
        localThrowable1 = localThrowable1;
        cn.sharesdk.framework.utils.d.a().w(localThrowable1);
        localObject = null;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\tencent\qq\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */