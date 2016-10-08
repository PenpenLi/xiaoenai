package com.xiaoenai.app.classes.chat.messagelist;

import android.content.Context;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.chat.av;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class c
  extends m
{
  c(a parama, Context paramContext, av paramav)
  {
    super(paramContext);
  }
  
  public void a()
  {
    super.a();
    a.a(this.b, true);
  }
  
  public void a(int paramInt)
  {
    a.a(this.b, false);
    a.b(true);
    a.l();
    Xiaoenai.j().a(new e(this));
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    a.a(this.b, paramJSONObject);
    Xiaoenai.j().a(new d(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */