package com.xiaoenai.app.classes.chat.history;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.xiaoenai.app.widget.TitleBarView;

class b
  implements View.OnClickListener
{
  b(ChatHisEditActivity paramChatHisEditActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.c(false);
    this.a.a(false);
    this.a.b(false);
    this.a.q();
    ChatHisEditActivity.e(this.a).h();
    ChatHisEditActivity.d(this.a).setText(this.a.getResources().getText(2131100534));
    ChatHisEditActivity.i(this.a).setTitle(this.a.a(new Integer[] { Integer.valueOf(ChatHisEditActivity.f(this.a)), Integer.valueOf(ChatHisEditActivity.g(this.a)), Integer.valueOf(ChatHisEditActivity.h(this.a)) }));
    ChatHisEditActivity.a(this.a, 0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\history\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */