package com.xiaoenai.app.classes.extentions.anniversary;

import android.view.View;
import android.view.View.OnClickListener;

class ac
  implements View.OnClickListener
{
  ac(AnniversaryAddActivity paramAnniversaryAddActivity) {}
  
  public void onClick(View paramView)
  {
    if (AnniversaryAddActivity.k(this.a) == 1)
    {
      AnniversaryAddActivity.d(this.a).b();
      AnniversaryAddActivity.a(this.a, 0);
      AnniversaryAddActivity.a(this.a, true);
      AnniversaryAddActivity.l(this.a);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\anniversary\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */