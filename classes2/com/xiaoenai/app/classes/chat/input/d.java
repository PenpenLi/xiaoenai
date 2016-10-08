package com.xiaoenai.app.classes.chat.input;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.xiaoenai.app.classes.chat.ChatActivity;
import com.xiaoenai.app.classes.chat.input.a.a;
import com.xiaoenai.app.classes.chat.input.a.i;

class d
  implements View.OnClickListener
{
  d(InputFragment paramInputFragment) {}
  
  public void onClick(View paramView)
  {
    ((ChatActivity)this.a.getActivity()).q();
    if ("plus_tag".equals(InputFragment.b(this.a).getTag()))
    {
      this.a.j();
      this.a.a(0);
      InputFragment.c(this.a);
      InputFragment.d(this.a);
    }
    do
    {
      return;
      paramView = (i)this.a.getActivity().getSupportFragmentManager().findFragmentByTag("StatusFragment");
      if ((paramView == null) || (!paramView.isAdded())) {
        break;
      }
      i.a(this.a);
      paramView = a.a(this.a.getActivity());
    } while ((paramView == null) || (paramView.getView() == null));
    paramView.getView().setVisibility(0);
    return;
    this.a.i();
    this.a.q();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */