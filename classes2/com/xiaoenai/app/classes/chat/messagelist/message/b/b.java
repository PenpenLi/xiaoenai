package com.xiaoenai.app.classes.chat.messagelist.message.b;

import android.content.res.Resources;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.chat.messagelist.message.model.k;
import com.xiaoenai.app.classes.chat.messagelist.view.n;

public class b
  extends o
{
  public static void a(k paramk, n paramn)
  {
    paramn.setStatus(paramk.f().intValue());
    String str = a(paramk.w());
    int j = Xiaoenai.j().getResources().getIdentifier(str, "drawable", "com.xiaoenai.app");
    int i = j;
    if (j == 0) {
      i = 2130838903;
    }
    paramn.setStatusIcon(i);
    paramn.setContentText(paramk.r());
    paramn.requestLayout();
  }
  
  public static void b(k paramk, n paramn)
  {
    paramn.setStatus(paramk.f().intValue());
    String str = a(paramk.w());
    int j = Xiaoenai.j().getResources().getIdentifier(str, "drawable", "com.xiaoenai.app");
    int i = j;
    if (j == 0) {
      i = 2130838903;
    }
    paramn.setStatusIcon(i);
    paramn.setContentText(paramk.r());
    paramn.requestLayout();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */