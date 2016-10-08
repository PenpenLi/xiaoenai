package com.xiaoenai.app.classes.common.image.imagePreview;

import com.xiaoenai.app.model.album.PhotoImageList;
import com.xiaoenai.app.widget.TitleBarView;
import java.util.ArrayList;

class k
  implements Runnable
{
  k(j paramj) {}
  
  public void run()
  {
    PhotoImageList.getInstance().removePhoto(this.a.a);
    a.e(this.a.c).remove(this.a.a);
    this.a.c.notifyDataSetChanged();
    int i = this.a.a + 1;
    if (this.a.a == this.a.b - 1) {
      i = this.a.a;
    }
    a.a(this.a.c).setTitle(i + " / " + PhotoImageList.getInstance().getPhotoLength());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */