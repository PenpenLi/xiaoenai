package com.xiaoenai.app.net.socket;

import com.xiaoenai.app.d.q;

public class a
  extends f
{
  private static long c = 0L;
  
  public static void a(long paramLong)
  {
    if (paramLong > c) {
      c = paramLong;
    }
  }
  
  private static long f()
  {
    if (0L == c) {
      c = new q().a();
    }
    return c;
  }
  
  public void a()
  {
    super.a();
    long l1 = com.xiaoenai.app.classes.chat.messagelist.a.a().n();
    long l2 = f();
    SocketManager.a().a(l1, l2);
  }
  
  public void b()
  {
    super.a();
    long l1 = com.xiaoenai.app.classes.chat.messagelist.a.a().n();
    long l2 = f();
    SocketManager.a().a(l1, l2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\net\socket\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */