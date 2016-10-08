package com.xiaoenai.app.classes.chat.history;

import com.xiaoenai.app.utils.l;
import com.xiaoenai.app.widget.TitleBarView;
import java.util.Calendar;

class i
  implements t
{
  i(h paramh) {}
  
  public void a() {}
  
  public void a(String paramString)
  {
    ChatHisEditActivity.a(this.a.a, l.a(paramString));
    ChatHisEditActivity.a(this.a.a, ChatHisEditActivity.j(this.a.a).b());
    this.a.a.a(false);
    paramString = x.a(ChatHisEditActivity.j(this.a.a).a());
    this.a.a.a(paramString.get(1), paramString.get(2), paramString.get(5));
    ChatHisEditActivity.n(this.a.a).setTitle(this.a.a.a(new Integer[] { Integer.valueOf(paramString.get(1)), Integer.valueOf(paramString.get(2) + 1), Integer.valueOf(paramString.get(5)) }));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\history\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */