package com.xiaoenai.app.classes.extentions.anniversary;

import com.xiaoenai.app.utils.c.c;
import com.xiaoenai.app.utils.f.a;
import com.xiaoenai.app.widget.wheel.WheelView;
import com.xiaoenai.app.widget.wheel.b;

class ap
  implements b
{
  ap(DatePickerView paramDatePickerView) {}
  
  public void a(WheelView paramWheelView, int paramInt1, int paramInt2)
  {
    paramInt1 = c.e(DatePickerView.g(this.a).getCurrentItem() + DatePickerView.a(this.a));
    if ((paramInt1 != Integer.MIN_VALUE) && (paramInt1 <= paramInt2)) {
      if (paramInt2 == paramInt1) {
        paramInt1 = c.f(DatePickerView.g(this.a).getCurrentItem() + DatePickerView.a(this.a));
      }
    }
    for (;;)
    {
      a.c("days:{}", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 >= 30) {
        break;
      }
      DatePickerView.e(this.a).setViewAdapter(new DatePickerView.a(this.a, this.a.getContext(), this.a.j));
      return;
      paramInt1 = c.b(paramInt2, DatePickerView.g(this.a).getCurrentItem() + DatePickerView.a(this.a));
      continue;
      paramInt1 = c.b(paramInt2 + 1, DatePickerView.g(this.a).getCurrentItem() + DatePickerView.a(this.a));
    }
    DatePickerView.e(this.a).setViewAdapter(new DatePickerView.a(this.a, this.a.getContext(), this.a.i));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\anniversary\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */