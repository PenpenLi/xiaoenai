package com.xiaoenai.app.classes.home;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.common.image.ImagePicker;
import com.xiaoenai.app.utils.as;

class ae
  implements View.OnClickListener
{
  ae(v paramv) {}
  
  public void onClick(View paramView)
  {
    if (!as.c())
    {
      as.a(this.a.getActivity());
      return;
    }
    paramView = new ImagePicker(this.a.getActivity());
    paramView.a(new af(this));
    paramView.a(1280, 1280);
    paramView.a(this.a.getActivity().getString(2131100588), this.a, new ag(this, this.a.getActivity()), new ah(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */