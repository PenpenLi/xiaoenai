package com.xiaoenai.app.classes.chat.history;

import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.l;
import com.xiaoenai.app.widget.TitleBarView;
import java.util.Calendar;
import java.util.Vector;

class e
  implements t
{
  e(d paramd, h paramh, int paramInt) {}
  
  public void a()
  {
    this.a.dismiss();
    ChatHisEditActivity.l(this.c.a.a).clear();
    this.c.a.a.a(false);
    Calendar localCalendar = x.a(this.b);
    ChatHisEditActivity.j(this.c.a.a).a(this.b);
    ChatHisEditActivity.m(this.c.a.a).setTitle(this.c.a.a.a(new Integer[] { Integer.valueOf(localCalendar.get(1)), Integer.valueOf(localCalendar.get(2) + 1), Integer.valueOf(localCalendar.get(5)) }));
  }
  
  public void a(String paramString)
  {
    this.a.dismiss();
    ChatHisEditActivity.a(this.c.a.a, l.a(paramString));
    ChatHisEditActivity.a(this.c.a.a, ChatHisEditActivity.j(this.c.a.a).b());
    this.c.a.a.a(false);
    paramString = x.a(ChatHisEditActivity.j(this.c.a.a).a());
    ChatHisEditActivity.k(this.c.a.a).setTitle(this.c.a.a.a(new Integer[] { Integer.valueOf(paramString.get(1)), Integer.valueOf(paramString.get(2) + 1), Integer.valueOf(paramString.get(5)) }));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\history\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */