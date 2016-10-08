package com.xiaoenai.app.classes.home.view;

import android.content.Context;
import android.widget.Button;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import java.util.Timer;
import org.json.JSONObject;

class b
  extends m
{
  h a = h.a(b());
  
  b(ContentView paramContentView, Context paramContext, Button paramButton)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.a.setCancelable(true);
    this.a.show();
    ContentView.a(this.c, true);
    this.c.setSendedAlarm(true);
  }
  
  public void a(int paramInt)
  {
    ContentView.a(this.c, false);
    this.c.setSendedAlarm(false);
    super.a(paramInt);
  }
  
  public void a(k paramk)
  {
    ContentView.a(this.c, false);
    this.c.setSendedAlarm(false);
    super.a(paramk);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.a.dismiss();
    h.a(b(), 2131100579, 1500L);
    if (ContentView.a(this.c) == null) {
      ContentView.a(this.c, new Timer());
    }
    ContentView.a(this.c).schedule(new c(this), 0L, 1000L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */