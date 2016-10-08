package com.xiaoenai.app.classes.extentions.menses;

import android.widget.TextView;
import com.xiaoenai.app.utils.ak;
import java.util.Timer;

class m
  implements Runnable
{
  m(l paraml) {}
  
  public void run()
  {
    if (MensesActivity.b(this.a.a) > 259200L) {
      MensesActivity.d(this.a.a).setText(ak.i(MensesActivity.c(this.a.a)));
    }
    do
    {
      return;
      MensesActivity.a(this.a.a, ac.a.b);
      MensesActivity.c(this.a.a, MensesActivity.a(this.a.a));
    } while (MensesActivity.e(this.a.a) == null);
    MensesActivity.e(this.a.a).cancel();
    MensesActivity.a(this.a.a, null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */