package com.xiaoenai.app.classes.street;

import android.content.Context;
import android.os.Handler;
import android.widget.TextView;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.utils.ak;
import java.util.Timer;

public class a
{
  private Timer a = new Timer();
  
  public static int a(int paramInt, long paramLong1, long paramLong2)
  {
    int i = paramInt;
    if (paramInt == 0)
    {
      i = paramInt;
      if (a(paramLong1, paramLong2)) {
        i = 4;
      }
    }
    return i;
  }
  
  private static boolean a(long paramLong1, long paramLong2)
  {
    return paramLong1 - ((int)ak.b() - paramLong2) <= 0L;
  }
  
  public void a()
  {
    if (this.a != null)
    {
      this.a.cancel();
      this.a = null;
    }
  }
  
  public void a(Context paramContext, TextView paramTextView, long paramLong1, long paramLong2, a parama)
  {
    Handler localHandler = Xiaoenai.j().k();
    if (this.a == null) {
      this.a = new Timer();
    }
    this.a.schedule(new b(this, paramLong1, paramLong2, paramContext, localHandler, paramTextView, parama), 0L, 1000L);
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */