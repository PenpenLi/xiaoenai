package com.xiaoenai.app.classes.album;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.model.album.Photo;
import com.xiaoenai.app.model.album.PhotoImageList;
import com.xiaoenai.app.utils.as;
import java.util.ArrayList;
import java.util.Iterator;

class h
  implements View.OnClickListener
{
  h(PhotoAlbumActivity paramPhotoAlbumActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new ArrayList();
    Iterator localIterator = PhotoImageList.getInstance().getPhotoList().iterator();
    while (localIterator.hasNext())
    {
      Photo localPhoto = (Photo)localIterator.next();
      if (localPhoto.isSelected()) {
        paramView.add(localPhoto);
      }
    }
    if (paramView.size() == 0)
    {
      as.b(2131099728);
      return;
    }
    PhotoAlbumActivity.a(this.a, paramView);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\album\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */