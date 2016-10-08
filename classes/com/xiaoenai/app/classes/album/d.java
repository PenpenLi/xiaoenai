package com.xiaoenai.app.classes.album;

import android.content.Intent;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.utils.g.a;
import org.json.JSONObject;

class d
  implements g.a
{
  d(PhotoAlbumActivity paramPhotoAlbumActivity, Intent paramIntent) {}
  
  public void a()
  {
    this.b.a(this.b.getString(2131101606));
  }
  
  public void a(int paramInt)
  {
    Xiaoenai.j().a(new f(this));
  }
  
  public void a(k paramk)
  {
    Xiaoenai.j().a(new g(this));
  }
  
  public void a(JSONObject paramJSONObject, String paramString)
  {
    Xiaoenai.j().a(new e(this, paramJSONObject, paramString));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\album\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */