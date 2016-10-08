package com.xiaoenai.app.classes.street;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.xiaoenai.app.utils.ak;
import java.util.TimerTask;

class b
  extends TimerTask
{
  b(a parama, long paramLong1, long paramLong2, Context paramContext, Handler paramHandler, TextView paramTextView, a.a parama1) {}
  
  public void run()
  {
    String str2 = ak.a(this.a, this.b);
    if (str2 != null)
    {
      String str1 = this.c.getString(2131101413) + "\n";
      str2 = str1 + str2;
      SpannableString localSpannableString = new SpannableString(str2);
      int i = str1.length();
      int j = str2.length();
      localSpannableString.setSpan(new ForegroundColorSpan(this.c.getResources().getColor(2131493132)), i, j, 33);
      this.d.post(new c(this, localSpannableString));
      return;
    }
    this.f.a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */