package com.xiaoenai.app.classes.street.widget;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.common.image.imagePreview.ImageViewPager;
import com.xiaoenai.app.classes.street.model.ImageInfo;

class ak
  implements View.OnClickListener
{
  ak(aj paramaj) {}
  
  public void onClick(View paramView)
  {
    if ((aj.a(this.a) != null) && (aj.a(this.a).length > 0))
    {
      paramView = new String[aj.a(this.a).length];
      int i = 0;
      while (i < aj.a(this.a).length)
      {
        paramView[i] = (aj.a(this.a)[i].getUrl() + "?imageView/1/w/" + aj.a(this.a)[i].getWidth() + "/h/" + aj.a(this.a)[i].getHeight());
        i += 1;
      }
      Intent localIntent = new Intent(this.a.getActivity(), ImageViewPager.class);
      localIntent.putExtra("imageUrls", paramView);
      localIntent.putExtra("from", 8);
      localIntent.putExtra("position", aj.b(this.a));
      this.a.getActivity().startActivityForResult(localIntent, 10);
      this.a.getActivity().overridePendingTransition(2130968588, 2130968589);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */