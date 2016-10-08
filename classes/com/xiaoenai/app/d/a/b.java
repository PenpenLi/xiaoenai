package com.xiaoenai.app.d.a;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Handler;
import android.os.HandlerThread;

public abstract class b
  extends SQLiteOpenHelper
{
  private static HandlerThread a;
  public static int b = 1;
  public static int c = 2;
  private static Handler d = new Handler(a.getLooper());
  
  static
  {
    a = null;
    d = null;
    a = new HandlerThread("xiaoenai");
    a.start();
  }
  
  public b(String paramString, int paramInt) {}
  
  public b(String paramString, int paramInt1, int paramInt2) {}
  
  public void a(Runnable paramRunnable)
  {
    d.post(paramRunnable);
  }
  
  public static class a
  {
    public void a() {}
    
    public void a(long paramLong) {}
  }
  
  public static abstract interface b<Data>
  {
    public abstract void a(long paramLong, Data paramData);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\d\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */