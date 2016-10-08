package com.xiaoenai.app.f;

import android.os.Handler;
import com.xiaoenai.app.model.Forum.Post.a;
import com.xiaoenai.app.utils.f.a;
import org.json.JSONException;
import org.json.JSONObject;

class f
  implements Runnable
{
  f(e parame, JSONObject paramJSONObject) {}
  
  public void run()
  {
    try
    {
      a.c("======================== {}", new Object[] { this.a.getString("url") });
      this.b.a[d.a(this.b.b)] = new Post.a(this.a.getString("url"), Integer.valueOf(this.a.getInt("height")), Integer.valueOf(this.a.getInt("width")));
      d.b(this.b.b);
      if (d.a(this.b.b, d.a(this.b.b))) {
        d.a(this.b.b, d.c(this.b.b), d.d(this.b.b), this.b.a);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      d.f(this.b.b).post(new g(this));
      localJSONException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\f\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */