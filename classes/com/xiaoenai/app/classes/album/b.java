package com.xiaoenai.app.classes.album;

import android.content.Context;
import com.xiaoenai.app.model.album.PhotoImageList;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.component.view.ProgressView;
import org.json.JSONObject;

class b
  extends m
{
  b(PhotoAlbumActivity paramPhotoAlbumActivity, Context paramContext, int paramInt)
  {
    super(paramContext);
  }
  
  public void a()
  {
    PhotoAlbumActivity.b(this.b, true);
    if (this.a == 0)
    {
      if (PhotoImageList.getInstance().size() == 0) {
        PhotoAlbumActivity.g(this.b).setVisibility(0);
      }
      PhotoAlbumActivity.c(this.b, true);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.a == 0)
    {
      if (PhotoImageList.getInstance().size() == 0) {
        PhotoImageList.getInstance().loadPhotosFromDB();
      }
      PhotoAlbumActivity.a(this.b);
    }
    PhotoAlbumActivity.b(this.b, false);
    PhotoAlbumActivity.g(this.b).setVisibility(8);
    PhotoAlbumActivity.c(this.b, false);
    if (!this.b.isFinishing()) {
      super.a(paramInt);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    PhotoAlbumActivity.b(this.b, false);
    if (this.a == 0) {
      PhotoImageList.getInstance().clearPhotos();
    }
    PhotoAlbumActivity.a(this.b, paramJSONObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\album\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */