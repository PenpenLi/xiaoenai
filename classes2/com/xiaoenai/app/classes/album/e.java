package com.xiaoenai.app.classes.album;

import android.content.Intent;
import android.net.Uri;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.model.album.Photo;
import com.xiaoenai.app.model.album.PhotoImageList;
import com.xiaoenai.app.utils.f.a;
import org.json.JSONException;
import org.json.JSONObject;

class e
  implements Runnable
{
  e(d paramd, JSONObject paramJSONObject, String paramString) {}
  
  public void run()
  {
    this.c.b.l_();
    try
    {
      int i = this.a.getInt("id");
      int j = this.a.getInt("ts");
      a.a(this.a.toString());
      Photo localPhoto = new Photo(i, j, this.b, 0, 0, 0);
      PhotoImageList.getInstance().addPhoto(localPhoto, 0);
      PhotoAlbumActivity.l(this.c.b);
      UserConfig.setInt("photoalbum_cur", PhotoAlbumActivity.i(this.c.b));
      PhotoAlbumActivity.a(this.c.b);
      a.c("url = {} {}", new Object[] { this.b, this.c.a.getData().getPath() });
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\album\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */