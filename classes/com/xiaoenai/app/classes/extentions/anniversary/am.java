package com.xiaoenai.app.classes.extentions.anniversary;

import com.xiaoenai.app.utils.c.c;
import com.xiaoenai.app.widget.wheel.WheelView;
import com.xiaoenai.app.widget.wheel.b;
import java.util.List;

class am
  implements b
{
  am(DatePickerView paramDatePickerView) {}
  
  public void a(WheelView paramWheelView, int paramInt1, int paramInt2)
  {
    paramInt1 = paramInt2 + 1;
    if (DatePickerView.c(this.a).contains(String.valueOf(paramInt1)))
    {
      DatePickerView.e(this.a).setViewAdapter(new DatePickerView.c(this.a, this.a.getContext(), 1, 31, DatePickerView.d(this.a)));
      return;
    }
    if (DatePickerView.f(this.a).contains(String.valueOf(paramInt1)))
    {
      DatePickerView.e(this.a).setViewAdapter(new DatePickerView.c(this.a, this.a.getContext(), 1, 30, DatePickerView.d(this.a)));
      return;
    }
    if (c.d(DatePickerView.g(this.a).getCurrentItem() + DatePickerView.a(this.a)))
    {
      DatePickerView.e(this.a).setViewAdapter(new DatePickerView.c(this.a, this.a.getContext(), 1, 29, DatePickerView.d(this.a)));
      return;
    }
    DatePickerView.e(this.a).setViewAdapter(new DatePickerView.c(this.a, this.a.getContext(), 1, 28, DatePickerView.d(this.a)));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\anniversary\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */