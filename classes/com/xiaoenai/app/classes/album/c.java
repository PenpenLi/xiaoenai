package com.xiaoenai.app.classes.album;

import android.content.Context;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.model.album.PhotoImageList;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import java.util.List;
import org.json.JSONObject;

class c
  extends m
{
  c(PhotoAlbumActivity paramPhotoAlbumActivity, Context paramContext, List paramList)
  {
    super(paramContext);
  }
  
  public void a()
  {
    PhotoAlbumActivity.k(this.b);
  }
  
  public void a(int paramInt)
  {
    PhotoAlbumActivity.h(this.b);
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    PhotoAlbumActivity.h(this.b);
    try
    {
      h.a(this.b, 2131099713, 1500L);
      PhotoAlbumActivity.a(this.b, false);
      PhotoAlbumActivity.a(this.b, "normal");
      PhotoImageList.getInstance().delPhotos(this.a);
      if (paramJSONObject.has("count"))
      {
        PhotoAlbumActivity.a(this.b, paramJSONObject.getInt("count"));
        UserConfig.setInt("photoalbum_cur", PhotoAlbumActivity.i(this.b));
      }
      for (;;)
      {
        PhotoAlbumActivity.a(this.b);
        return;
        PhotoAlbumActivity.j(this.b);
        UserConfig.setInt("photoalbum_cur", PhotoAlbumActivity.i(this.b));
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\album\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */