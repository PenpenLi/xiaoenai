package com.xiaoenai.app.classes.home.a;

import android.content.Context;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class e
  extends m
{
  e(a parama, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt) {}
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    int i = paramJSONObject.optInt("topics_desc");
    if (i >= 0)
    {
      k.a().a(i, "xiaoenai.discovery.forum", b());
      a.b(this.a).notifyDataSetChanged();
      a.c(i);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */