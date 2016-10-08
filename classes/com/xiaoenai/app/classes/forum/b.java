package com.xiaoenai.app.classes.forum;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.xiaoenai.app.classes.forum.widget.RedPointThreeTabLayout.a;

class b
  implements RedPointThreeTabLayout.a
{
  b(ForumActivity paramForumActivity) {}
  
  public void a(View paramView, int paramInt)
  {
    if (paramInt == ForumActivity.b(this.a).getCurrentItem()) {
      return;
    }
    ForumActivity.b(this.a).setCurrentItem(paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */