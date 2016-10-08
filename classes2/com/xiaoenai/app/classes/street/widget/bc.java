package com.xiaoenai.app.classes.street.widget;

import com.xiaoenai.app.classes.common.c.a;
import com.xiaoenai.app.classes.common.c.d;
import com.xiaoenai.app.classes.common.c.e;
import com.xiaoenai.app.classes.street.model.Banner;

class bc
  implements StreetImageViewPager.d
{
  bc(StreetSceneView paramStreetSceneView) {}
  
  public void a(Banner paramBanner)
  {
    if (paramBanner != null)
    {
      paramBanner = new a().a(paramBanner.getXea_url(), "street_banner");
      new e().a(StreetSceneView.b(this.a), paramBanner);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */