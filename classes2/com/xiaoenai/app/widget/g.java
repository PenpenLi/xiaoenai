package com.xiaoenai.app.widget;

import android.os.Handler;
import android.os.SystemClock;
import com.xiaoenai.app.utils.as;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class g
  implements Runnable
{
  g(DigitalClock paramDigitalClock) {}
  
  public void run()
  {
    if (DigitalClock.a(this.a)) {
      return;
    }
    this.a.a.setTimeInMillis(System.currentTimeMillis());
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(this.a.b, as.k());
    this.a.setText(localSimpleDateFormat.format(this.a.a.getTime()));
    this.a.invalidate();
    long l = SystemClock.uptimeMillis();
    DigitalClock.c(this.a).postAtTime(DigitalClock.b(this.a), l + (1000L - l % 1000L));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */