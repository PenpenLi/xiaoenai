package com.xiaoenai.app.classes.common;

import android.view.View;
import android.view.View.OnClickListener;

class d
  implements View.OnClickListener
{
  d(ColorPickerActivity paramColorPickerActivity) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    ColorPickerActivity.a(this.a, i + 1);
    ColorPickerActivity.a(this.a, true);
    ColorPickerActivity.b(this.a, i);
    this.a.r();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */