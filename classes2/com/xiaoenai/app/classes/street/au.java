package com.xiaoenai.app.classes.street;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import org.json.JSONObject;

class au
  implements Runnable
{
  au(as paramas, JSONObject paramJSONObject) {}
  
  public void run()
  {
    StreetCommentsAvtivity.f(this.b.a).k();
    if (this.a.optBoolean("success")) {
      StreetCommentsAvtivity.a(this.b.a, this.a.optJSONArray("data"));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */