package com.xiaoenai.app.classes.extentions.anniversary;

import android.widget.TextView;

class g
  implements DatePickerView.b
{
  g(AnniversaryAddActivity paramAnniversaryAddActivity) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = 1;
    AnniversaryAddActivity.a(this.a, AnniversaryAddActivity.d(this.a).getDateTs() / 1000L);
    if (AnniversaryAddActivity.m(this.a) != AnniversaryAddActivity.i(this.a).b()) {
      AnniversaryAddActivity.a(this.a, true);
    }
    AnniversaryAddActivity localAnniversaryAddActivity = this.a;
    if (AnniversaryAddActivity.d(this.a).a()) {
      paramInt1 = 0;
    }
    AnniversaryAddActivity.a(localAnniversaryAddActivity, paramInt1);
  }
  
  public void a(String paramString)
  {
    AnniversaryAddActivity.g(this.a).setText(paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\anniversary\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */