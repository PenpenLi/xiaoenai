package com.xiaoenai.app.classes.chat.messagelist.message.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.chat.messagelist.view.o;
import java.util.ArrayList;

final class q
  implements View.OnClickListener
{
  q(ArrayList paramArrayList, o paramo) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    while (i < this.a.size())
    {
      p.a(((c)this.a.get(i)).a, this.b.getContext());
      i += 1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\b\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */