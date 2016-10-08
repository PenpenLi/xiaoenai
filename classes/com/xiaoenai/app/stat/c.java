package com.xiaoenai.app.stat;

import android.util.SparseIntArray;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.l;
import com.xiaoenai.app.utils.ak;

public class c
{
  private static int a = 1800000;
  private static volatile c b = null;
  private volatile boolean c = false;
  private SparseIntArray d = new SparseIntArray();
  
  public static c a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new c();
      }
      return b;
    }
    finally {}
  }
  
  private void a(String paramString1, String paramString2)
  {
    new l(new e(this, Xiaoenai.j())).k(paramString1, paramString2);
  }
  
  public void a(int paramInt)
  {
    g.a(a.a(paramInt, (int)ak.b()));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    g.b(a.a(paramInt1, (int)ak.b(), paramInt2));
  }
  
  public void b()
  {
    try
    {
      if (AppModel.getInstance().isLogined())
      {
        long l = UserConfig.getLong("last_upload_stat_time", 0L);
        if ((System.currentTimeMillis() - l > a) && (!this.c))
        {
          this.c = true;
          Xiaoenai.j().a(new d(this), 15000L);
        }
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void b(int paramInt)
  {
    this.d.put(paramInt, (int)System.currentTimeMillis() / 1000);
  }
  
  public void c(int paramInt)
  {
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = this.d.get(paramInt);
    if ((j != 0) && (i - j > 0)) {
      a(paramInt, i - j);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\stat\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */