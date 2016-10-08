package com.xiaoenai.app.classes.street.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.street.model.Banner;
import com.xiaoenai.app.utils.f.a;

class i
  implements View.OnClickListener
{
  i(StreetImageListView paramStreetImageListView) {}
  
  public void onClick(View paramView)
  {
    a.c("click tag  = {}", new Object[] { paramView.getTag() });
    if (StreetImageListView.a(this.a) != null)
    {
      paramView = (Banner)paramView.getTag();
      a.c("banner = {}", new Object[] { paramView });
      if (paramView != null) {
        StreetImageListView.a(this.a).a(paramView);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */