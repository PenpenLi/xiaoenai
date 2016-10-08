package com.xiaoenai.app.classes.extentions.menses;

import android.widget.TextView;
import com.xiaoenai.app.utils.ak;
import java.util.Timer;

class y
  implements Runnable
{
  y(x paramx) {}
  
  public void run()
  {
    if (MensesMaleFragment.a(this.a.a) > 259200L) {
      MensesMaleFragment.c(this.a.a).setText(ak.i(MensesMaleFragment.b(this.a.a)));
    }
    do
    {
      return;
      MensesMaleFragment.a(this.a.a, ac.a.b);
      MensesMaleFragment.b(this.a.a, MensesMaleFragment.d(this.a.a));
    } while (MensesMaleFragment.e(this.a.a) == null);
    MensesMaleFragment.e(this.a.a).cancel();
    MensesMaleFragment.a(this.a.a, null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */