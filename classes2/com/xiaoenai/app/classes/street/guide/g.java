package com.xiaoenai.app.classes.street.guide;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.xiaoenai.app.classes.common.widget.NewViewPagerIndicator;
import com.xiaoenai.app.widget.CustomViewPager;

public class g<T extends StreetLifeServiceActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public g(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    View localView = paramFinder.findRequiredView(paramObject, 2131559882, "field 'mProfile' and method 'profile'");
    paramT.mProfile = ((ImageView)paramFinder.castView(localView, 2131559882, "field 'mProfile'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new h(this, paramT));
    paramT.mViewPagerIndicator = ((NewViewPagerIndicator)paramFinder.findRequiredViewAsType(paramObject, 2131559884, "field 'mViewPagerIndicator'", NewViewPagerIndicator.class));
    paramT.mLifeServicePager = ((CustomViewPager)paramFinder.findRequiredViewAsType(paramObject, 2131559885, "field 'mLifeServicePager'", CustomViewPager.class));
    paramFinder = paramFinder.findRequiredView(paramObject, 2131559883, "method 'cart'");
    this.c = paramFinder;
    paramFinder.setOnClickListener(new i(this, paramT));
  }
  
  public void unbind()
  {
    StreetLifeServiceActivity localStreetLifeServiceActivity = this.a;
    if (localStreetLifeServiceActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localStreetLifeServiceActivity.mProfile = null;
    localStreetLifeServiceActivity.mViewPagerIndicator = null;
    localStreetLifeServiceActivity.mLifeServicePager = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\guide\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */