package cn.sharesdk.tencent.qzone;

class e
  extends Thread
{
  e(d paramd, String paramString) {}
  
  public void run()
  {
    try
    {
      this.b.a(this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.d.a().w(localThrowable);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\tencent\qzone\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */