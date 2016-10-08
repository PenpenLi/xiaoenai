package com.xiaoenai.app.classes.extentions.anniversary;

import com.xiaoenai.app.utils.c.c;
import com.xiaoenai.app.utils.f.a;
import com.xiaoenai.app.widget.wheel.WheelView;
import com.xiaoenai.app.widget.wheel.a.e;
import com.xiaoenai.app.widget.wheel.b;
import java.util.ArrayList;
import java.util.Arrays;

class ao
  implements b
{
  ao(DatePickerView paramDatePickerView) {}
  
  public void a(WheelView paramWheelView, int paramInt1, int paramInt2)
  {
    paramInt1 = c.e(DatePickerView.a(this.a) + paramInt2);
    if (paramInt1 != Integer.MIN_VALUE)
    {
      paramWheelView = DatePickerView.a(this.a, paramInt1);
      ArrayList localArrayList = new ArrayList(13);
      localArrayList.addAll(Arrays.asList(this.a.h));
      localArrayList.add(paramInt1, paramWheelView);
      DatePickerView.b(this.a).setViewAdapter(new DatePickerView.a(this.a, this.a.getContext(), localArrayList.toArray(new String[localArrayList.size()])));
      paramInt1 = c.e(DatePickerView.g(this.a).getCurrentItem() + DatePickerView.a(this.a));
      if ((paramInt1 == Integer.MIN_VALUE) || (paramInt1 > DatePickerView.h(this.a))) {
        break label370;
      }
      if (DatePickerView.h(this.a) != paramInt1) {
        break label338;
      }
      paramInt1 = c.f(DatePickerView.g(this.a).getCurrentItem() + DatePickerView.a(this.a));
    }
    for (;;)
    {
      a.c("days:{}", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 >= 30) {
        break label404;
      }
      DatePickerView.e(this.a).setViewAdapter(new DatePickerView.a(this.a, this.a.getContext(), this.a.j));
      return;
      DatePickerView.b(this.a).setViewAdapter(new DatePickerView.a(this.a, this.a.getContext(), this.a.h));
      if (DatePickerView.h(this.a) < DatePickerView.b(this.a).getViewAdapter().a()) {
        break;
      }
      DatePickerView.b(this.a, DatePickerView.b(this.a).getViewAdapter().a() - 1);
      DatePickerView.b(this.a).setCurrentItem(DatePickerView.h(this.a));
      break;
      label338:
      paramInt1 = c.b(DatePickerView.h(this.a), DatePickerView.g(this.a).getCurrentItem() + DatePickerView.a(this.a));
      continue;
      label370:
      paramInt1 = c.b(DatePickerView.h(this.a) + 1, DatePickerView.g(this.a).getCurrentItem() + DatePickerView.a(this.a));
    }
    label404:
    DatePickerView.e(this.a).setViewAdapter(new DatePickerView.a(this.a, this.a.getContext(), this.a.i));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\anniversary\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */