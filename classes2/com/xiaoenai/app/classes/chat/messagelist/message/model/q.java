package com.xiaoenai.app.classes.chat.messagelist.message.model;

import android.content.Context;
import com.xiaoenai.app.classes.chat.messagelist.a;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class q
  extends m
{
  q(o paramo, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    super.a();
    this.a.b(Integer.valueOf(-1));
    this.a.k();
    a.a().a(this.a);
    a.l();
  }
  
  public void a(int paramInt)
  {
    this.a.b(Integer.valueOf(-2));
    this.a.k();
    a.l();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.getString("url");
    this.a.d(str);
    this.a.e(paramJSONObject.getString("key"));
    if (this.a.x() != null)
    {
      this.a.k();
      a.l();
      o.a(this.a);
      o.a(this.a, this.a.u(), str);
      return;
    }
    this.a.b(Integer.valueOf(-2));
    this.a.k();
    a.l();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\model\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */