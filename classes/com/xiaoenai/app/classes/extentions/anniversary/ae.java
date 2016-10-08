package com.xiaoenai.app.classes.extentions.anniversary;

import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;

class ae
  implements DatePicker.OnDateChangedListener
{
  ae(AnniversaryDatePickerDialog paramAnniversaryDatePickerDialog) {}
  
  public void onDateChanged(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.a = paramInt1;
    this.a.b = paramInt2;
    this.a.c = paramInt3;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\anniversary\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */