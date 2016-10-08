package com.xiaoenai.app.classes.home.view;

import android.content.Context;
import com.xiaoenai.app.classes.chat.messagelist.message.model.k;
import com.xiaoenai.app.model.HomeModeSettings;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import org.json.JSONObject;

class n
  extends m
{
  h a = h.a(b());
  
  n(ContentView paramContentView, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.a.show();
    super.a();
  }
  
  public void a(int paramInt)
  {
    this.a.dismiss();
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.a.dismiss();
    ContentView.d(this.b);
    k localk = k.x();
    localk.j();
    HomeModeSettings.saveMessage("home_mode.msg", localk);
    this.b.d();
    super.a(paramJSONObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */