package com.xiaoenai.app.classes.chat.history;

import android.content.res.Resources;
import android.widget.TextView;

class a
  implements q
{
  a(ChatHisEditActivity paramChatHisEditActivity) {}
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getResources().getText(2131100534));
    if (paramBoolean) {
      ChatHisEditActivity.a(this.a);
    }
    for (;;)
    {
      if (ChatHisEditActivity.c(this.a) != 0)
      {
        localStringBuilder.append("(");
        localStringBuilder.append(ChatHisEditActivity.c(this.a));
        localStringBuilder.append(")");
      }
      ChatHisEditActivity.d(this.a).setText(localStringBuilder.toString());
      return;
      ChatHisEditActivity.b(this.a);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\history\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */