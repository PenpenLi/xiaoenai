package com.xiaoenai.app.utils;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public class f
{
  public static abstract interface a
  {
    public abstract void a(Message paramMessage);
  }
  
  public static class b
    extends Handler
  {
    WeakReference<f.a> a;
    
    public b(f.a parama)
    {
      this.a = new WeakReference(parama);
    }
    
    public void handleMessage(Message paramMessage)
    {
      f.a locala = (f.a)this.a.get();
      if (locala != null) {
        locala.a(paramMessage);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */