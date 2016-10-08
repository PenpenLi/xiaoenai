package com.xiaoenai.app.classes.extentions.menses;

import android.widget.TextView;
import com.xiaoenai.app.classes.extentions.anniversary.DatePickerView.b;
import java.util.Locale;

class at
  implements DatePickerView.b
{
  at(MensesSettingActivity paramMensesSettingActivity) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    MensesSettingActivity.h(this.a).setText(String.format(Locale.getDefault(), "%04d-%02d-%02d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2 + 1), Integer.valueOf(paramInt3) }));
  }
  
  public void a(String paramString) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */