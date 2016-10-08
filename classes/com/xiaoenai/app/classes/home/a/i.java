package com.xiaoenai.app.classes.home.a;

import android.view.View;
import com.xiaoenai.app.classes.home.model.HomeDiscoverItem;
import com.xiaoenai.app.classes.home.view.viewHolder.LifeServiceItemViewHolder.a;
import com.xiaoenai.app.stat.j;

class i
  implements LifeServiceItemViewHolder.a
{
  i(a parama) {}
  
  public void a(View paramView)
  {
    if ((paramView != null) && (paramView.getTag() != null))
    {
      paramView = (HomeDiscoverItem)paramView.getTag();
      j.a().a(this.a.getActivity(), "discover", paramView.getClickUrl());
      this.a.a(paramView);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */