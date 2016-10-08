package com.xiaoenai.app.net;

import android.app.Activity;
import android.content.Context;
import com.xiaoenai.app.net.c.a.j;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.f.a;
import org.json.JSONObject;

public class m
{
  private Context a;
  private boolean b = true;
  
  public m(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt == -1) || ((paramInt > 10000) && (paramInt <= 10002));
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    try
    {
      if ((!b(paramInt)) && ((this.a instanceof Activity)) && (!((Activity)this.a).isFinishing()) && (c())) {
        h.c(this.a, j.a(paramInt), 1500L);
      }
      a.c("http error errCode = {}", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(k paramk)
  {
    a.d("http error errMsg ", new Object[] { Boolean.valueOf(true) });
  }
  
  public void a(JSONObject paramJSONObject)
  {
    a.a(paramJSONObject);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public Context b()
  {
    return this.a;
  }
  
  public boolean c()
  {
    return this.b;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\net\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */