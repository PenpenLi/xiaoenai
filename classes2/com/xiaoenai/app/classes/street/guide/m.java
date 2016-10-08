package com.xiaoenai.app.classes.street.guide;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;

public class m<T extends StreetTaeAuthorizationActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public m(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.mIconImg = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131558577, "field 'mIconImg'", ImageView.class));
    paramT.mTipTxt = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131559878, "field 'mTipTxt'", TextView.class));
    paramObject = paramFinder.findRequiredView(paramObject, 2131559879, "field 'mAuthorizationBtn' and method 'authorization'");
    paramT.mAuthorizationBtn = ((Button)paramFinder.castView((View)paramObject, 2131559879, "field 'mAuthorizationBtn'", Button.class));
    this.b = ((View)paramObject);
    ((View)paramObject).setOnClickListener(new n(this, paramT));
  }
  
  public void unbind()
  {
    StreetTaeAuthorizationActivity localStreetTaeAuthorizationActivity = this.a;
    if (localStreetTaeAuthorizationActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localStreetTaeAuthorizationActivity.mIconImg = null;
    localStreetTaeAuthorizationActivity.mTipTxt = null;
    localStreetTaeAuthorizationActivity.mAuthorizationBtn = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\guide\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */