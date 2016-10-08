package com.xiaoenai.app.classes.settings.feedback.a;

import android.content.Context;
import com.xiaoenai.app.classes.chat.messagelist.view.o;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.ui.component.view.AvatarView;

public abstract class a
  extends o
{
  protected int d;
  
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    if (this.d == 2) {}
    for (String str = User.getInstance().getLoverAvatar();; str = User.getInstance().getAvatar())
    {
      this.mMessageAvatar.setRoundedImage(str);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\settings\feedback\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */