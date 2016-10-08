package com.xiaoenai.app.classes.home.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.extentions.reward.RewardActivity;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.utils.as;

class b
  implements View.OnClickListener
{
  b(a parama) {}
  
  public void onClick(View paramView)
  {
    if (User.isSingle())
    {
      as.a();
      return;
    }
    this.a.a(RewardActivity.class);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */