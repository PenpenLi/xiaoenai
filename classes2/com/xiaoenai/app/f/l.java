package com.xiaoenai.app.f;

import android.os.Handler;
import com.xiaoenai.app.model.ImageInfo;
import org.json.JSONException;
import org.json.JSONObject;

class l
  implements Runnable
{
  l(k paramk, JSONObject paramJSONObject) {}
  
  public void run()
  {
    try
    {
      this.b.a[j.a(this.b.b)] = new ImageInfo(this.a.getString("url"), Integer.valueOf(this.a.getInt("height")), Integer.valueOf(this.a.getInt("width")));
      j.b(this.b.b);
      if (j.a(this.b.b, j.a(this.b.b))) {
        j.a(this.b.b, j.c(this.b.b), j.d(this.b.b), j.e(this.b.b), this.b.a);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      j.g(this.b.b).post(new m(this));
      localJSONException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\f\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */