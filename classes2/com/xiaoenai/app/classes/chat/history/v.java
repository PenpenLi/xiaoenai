package com.xiaoenai.app.classes.chat.history;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.ui.component.view.AvatarView;
import java.util.Set;
import java.util.Vector;

class v
  implements View.OnClickListener
{
  v(u paramu, int paramInt, AvatarView paramAvatarView) {}
  
  public void onClick(View paramView)
  {
    if (((Boolean)u.a(this.c).get(this.a)).booleanValue())
    {
      this.b.setImageResource(2130837597);
      u.a(this.c).set(this.a, Boolean.valueOf(false));
      if (u.j().contains(Integer.valueOf(this.a))) {
        u.j().remove(Integer.valueOf(this.a));
      }
      u.b(this.c).a(false);
      return;
    }
    this.b.setImageResource(2130837596);
    u.a(this.c).set(this.a, Boolean.valueOf(true));
    u.j().add(Integer.valueOf(this.a));
    u.b(this.c).a(true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\history\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */