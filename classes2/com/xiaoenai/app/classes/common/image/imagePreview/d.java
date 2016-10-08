package com.xiaoenai.app.classes.common.image.imagePreview;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.model.album.Photo;
import java.util.ArrayList;

class d
  implements View.OnClickListener
{
  d(a parama) {}
  
  public void onClick(View paramView)
  {
    a.a(this.a, ((Photo)a.e(this.a).get(a.d(this.a).getCurrentItem())).getUrl());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */