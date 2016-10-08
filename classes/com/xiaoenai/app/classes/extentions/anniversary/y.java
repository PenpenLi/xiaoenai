package com.xiaoenai.app.classes.extentions.anniversary;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.d.d;

class y
  implements View.OnClickListener
{
  y(AnniversaryAddActivity paramAnniversaryAddActivity) {}
  
  public void onClick(View paramView)
  {
    ab.b(this.a);
    if (AnniversaryAddActivity.d(this.a).getVisibility() != 0)
    {
      AnniversaryAddActivity.e(this.a);
      if ((AnniversaryAddActivity.f(this.a) == -1) && (AnniversaryAddActivity.g(this.a).getText() != null) && (AnniversaryAddActivity.g(this.a).getText().toString().trim().length() == 0)) {
        AnniversaryAddActivity.g(this.a).setText(d.d(System.currentTimeMillis()));
      }
      return;
    }
    AnniversaryAddActivity.h(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\anniversary\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */