package com.xiaoenai.app.classes.chat.history;

import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.l;
import com.xiaoenai.app.widget.TitleBarView;
import java.util.Calendar;

class k
  implements t
{
  k(j paramj, h paramh) {}
  
  public void a()
  {
    this.a.dismiss();
  }
  
  public void a(String paramString)
  {
    this.a.dismiss();
    ChatHisEditActivity.a(this.b.a, l.a(paramString));
    ChatHisEditActivity.a(this.b.a, ChatHisEditActivity.j(this.b.a).b());
    this.b.a.a(false);
    paramString = x.a(ChatHisEditActivity.j(this.b.a).a());
    this.b.a.a(paramString.get(1), paramString.get(2), paramString.get(5));
    ChatHisEditActivity.o(this.b.a).setTitle(this.b.a.a(new Integer[] { Integer.valueOf(paramString.get(1)), Integer.valueOf(paramString.get(2) + 1), Integer.valueOf(paramString.get(5)) }));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\history\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */