package com.xiaoenai.app.classes.chat.history;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.xiaoenai.app.ui.a.h;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

class f
  implements View.OnClickListener
{
  f(ChatHisEditActivity paramChatHisEditActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = ChatHisEditActivity.e(this.a).e();
    Object localObject = paramView.iterator();
    Long[] arrayOfLong = new Long[paramView.size()];
    Integer[] arrayOfInteger = new Integer[paramView.size()];
    Vector localVector = new Vector();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      arrayOfLong[i] = Long.valueOf(((com.xiaoenai.app.classes.chat.messagelist.message.a.a)ChatHisEditActivity.l(this.a).get(localInteger.intValue())).h());
      arrayOfInteger[i] = Integer.valueOf(((com.xiaoenai.app.classes.chat.messagelist.message.a.a)ChatHisEditActivity.l(this.a).get(localInteger.intValue())).d());
      localVector.add(ChatHisEditActivity.l(this.a).get(localInteger.intValue()));
      i += 1;
    }
    localObject = new com.xiaoenai.app.net.d.a(new g(this, this.a, localVector));
    if (paramView.size() > 0)
    {
      ((com.xiaoenai.app.net.d.a)localObject).a(arrayOfInteger, arrayOfLong);
      ChatHisEditActivity.a(this.a, 0);
      ChatHisEditActivity.e(this.a).h();
      ChatHisEditActivity.e(this.a).f();
      ChatHisEditActivity.d(this.a).setText(this.a.getResources().getText(2131100534));
      return;
    }
    paramView = new h(this.a);
    paramView.a(2131100539);
    paramView.a(1500L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\history\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */