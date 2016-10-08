package com.xiaoenai.app.classes.extentions.anniversary;

import android.view.View;
import android.view.View.OnClickListener;

class ak
  implements View.OnClickListener
{
  ak(AnniversaryRepeatActivity paramAnniversaryRepeatActivity) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    AnniversaryRepeatActivity.a(this.a, i);
    AnniversaryRepeatActivity.b(this.a, i);
    this.a.r();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\anniversary\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */