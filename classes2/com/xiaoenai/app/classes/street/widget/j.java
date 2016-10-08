package com.xiaoenai.app.classes.street.widget;

import android.widget.ImageView;
import android.widget.LinearLayout;
import com.xiaoenai.app.utils.f.a;
import com.xiaoenai.app.widget.LoopViewPager.e;
import java.util.List;

class j
  implements LoopViewPager.e
{
  j(StreetImageViewPager paramStreetImageViewPager) {}
  
  public void a(int paramInt)
  {
    a.a("position = {}", new Object[] { Integer.valueOf(paramInt) });
    int i;
    label37:
    boolean bool;
    if (paramInt >= 0)
    {
      paramInt %= StreetImageViewPager.a(this.a).size();
      i = 0;
      if (i >= StreetImageViewPager.a(this.a).size()) {
        break label147;
      }
      ImageView localImageView = (ImageView)StreetImageViewPager.b(this.a).getChildAt(i);
      if (localImageView == null) {
        break label135;
      }
      if (i != paramInt) {
        break label129;
      }
      bool = true;
      label80:
      localImageView.setSelected(bool);
    }
    for (;;)
    {
      i += 1;
      break label37;
      paramInt = StreetImageViewPager.a(this.a).size() - Math.abs(paramInt) % StreetImageViewPager.a(this.a).size() - 1;
      break;
      label129:
      bool = false;
      break label80;
      label135:
      a.a("imageview = null", new Object[0]);
    }
    label147:
    if ((StreetImageViewPager.a(this.a) != null) && (StreetImageViewPager.a(this.a).size() > 1))
    {
      StreetImageViewPager.a(this.a, StreetImageViewPager.c(this.a));
      return;
    }
    StreetImageViewPager.d(this.a);
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void b(int paramInt) {}
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */