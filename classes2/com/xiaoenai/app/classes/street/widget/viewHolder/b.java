package com.xiaoenai.app.classes.street.widget.viewHolder;

import android.view.View;
import com.marshalchen.ultimaterecyclerview.f;
import com.xiaoenai.app.classes.street.model.Banner;
import com.xiaoenai.app.classes.street.widget.StreetImageViewPager;
import com.xiaoenai.app.classes.street.widget.StreetImageViewPager.d;
import com.xiaoenai.app.utils.f.a;
import java.util.Arrays;

public class b
  extends f
{
  private StreetImageViewPager e;
  private Banner[] f = null;
  
  public b(View paramView, StreetImageViewPager.d paramd)
  {
    super(paramView);
    this.e = ((StreetImageViewPager)paramView);
    this.e.setOnClickListener(paramd);
    this.e.setFocusable(false);
    this.e.setFocusableInTouchMode(false);
  }
  
  public void a(Banner[] paramArrayOfBanner)
  {
    if (paramArrayOfBanner == null) {}
    for (boolean bool = true;; bool = false)
    {
      a.c("bannersMid banners is null ＝ {}", new Object[] { Boolean.valueOf(bool) });
      if ((paramArrayOfBanner == null) || (paramArrayOfBanner.length <= 0)) {
        break;
      }
      if ((this.f == null) || (!Arrays.equals(this.f, paramArrayOfBanner)))
      {
        this.f = paramArrayOfBanner;
        a.c("bannersMid ＝ {}", new Object[] { Integer.valueOf(paramArrayOfBanner.length) });
        this.e.a(paramArrayOfBanner, 5L);
        this.e.a();
        this.e.setVisibility(0);
      }
      return;
    }
    this.e.setVisibility(8);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\viewHolder\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */