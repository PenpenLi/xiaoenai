package com.xiaoenai.app.classes.common.image.imagePreview;

import android.view.View;
import com.xiaoenai.app.model.album.Photo;
import com.xiaoenai.app.model.album.PhotoImageList;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.ui.a.k.a;
import java.util.ArrayList;

class h
  implements k.a
{
  h(a parama, int paramInt) {}
  
  public void a(k paramk, View paramView)
  {
    paramk.dismiss();
    paramk = PhotoImageList.getInstance().getPhoto(this.a);
    paramView = new ArrayList();
    paramView.add(Integer.valueOf(paramk.getId()));
    a.a(this.b, paramView, PhotoImageList.getInstance().getPhotoLength(), this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */