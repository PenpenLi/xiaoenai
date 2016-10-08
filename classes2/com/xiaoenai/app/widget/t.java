package com.xiaoenai.app.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

class t
  implements View.OnClickListener
{
  t(ThreeTabLayout paramThreeTabLayout) {}
  
  public void onClick(View paramView)
  {
    if (ThreeTabLayout.a(this.a).getVisibility() == 0)
    {
      this.a.a(2);
      ThreeTabLayout.a(this.a, 2);
      return;
    }
    this.a.a(1);
    ThreeTabLayout.a(this.a, 1);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */