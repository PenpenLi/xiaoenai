package com.xiaoenai.app.classes.settings.feedback;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.xiaoenai.app.classes.chat.messagelist.view.j;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.ui.component.view.AvatarView;
import com.xiaoenai.app.ui.component.view.MaskableFrameLayout;
import com.xiaoenai.app.utils.ab;

public class m
  extends j
{
  public m(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    if (this.a == 2) {
      getAvatar().setImageResource(2130838815);
    }
    for (;;)
    {
      this.mRlStatus.setVisibility(8);
      return;
      String str = User.getInstance().getAvatar();
      getAvatar().setRoundedImage(str);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = (int)(ab.b() * 0.3125D);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    if (paramInt1 > paramInt2) {
      if (paramInt1 > i)
      {
        localLayoutParams.width = i;
        localLayoutParams.height = (i * paramInt2 / paramInt1);
      }
    }
    for (;;)
    {
      this.b.setLayoutParams(localLayoutParams);
      return;
      if (paramInt2 > i)
      {
        localLayoutParams.height = i;
        localLayoutParams.width = (i * paramInt1 / paramInt2);
      }
    }
  }
  
  public int getImageViewMaxWidth()
  {
    return (int)(ab.b() * 0.3125D);
  }
  
  public void setStatus(int paramInt)
  {
    this.mRlStatus.setVisibility(8);
  }
  
  public void setUserType(int paramInt)
  {
    super.setUserType(paramInt);
    if (this.a == 2) {}
    this.mRlStatus.setVisibility(8);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\settings\feedback\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */