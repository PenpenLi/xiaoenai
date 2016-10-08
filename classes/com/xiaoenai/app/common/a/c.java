package com.xiaoenai.app.common.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.xiaoenai.app.utils.f.a;

public class c
{
  private PowerManager a;
  private PowerManager.WakeLock b;
  
  public c(Context paramContext, String paramString)
  {
    a(paramContext, paramString);
  }
  
  private void a(Context paramContext, String paramString)
  {
    this.a = ((PowerManager)paramContext.getSystemService("power"));
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.b = this.a.newWakeLock(32, paramString);
      return;
    }
    this.b = this.a.newWakeLock(32, paramString);
  }
  
  public boolean a()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return this.a.isInteractive();
    }
    return this.a.isScreenOn();
  }
  
  public void b()
  {
    a.d("PowerManager.WakeLock : wakeLock.isHeld: {}", new Object[] { Boolean.valueOf(this.b.isHeld()) });
    if (!this.b.isHeld())
    {
      a.d("PowerManager.WakeLock : 灭掉屏幕", new Object[0]);
      this.b.acquire();
    }
  }
  
  public void c()
  {
    a.d("PowerManager.WakeLock : wakeLock.isHeld: {}", new Object[] { Boolean.valueOf(this.b.isHeld()) });
    if ((this.b != null) && (this.b.isHeld())) {
      a.d("PowerManager.WakeLock : 点亮屏幕", new Object[0]);
    }
    try
    {
      this.b.setReferenceCounted(false);
      this.b.release();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\common\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */