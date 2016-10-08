package com.xiaoenai.app.classes.forum;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.SparseArray;
import com.xiaoenai.app.classes.common.mvp.view.a.a;
import com.xiaoenai.app.classes.forum.widget.RedPointThreeTabLayout;
import com.xiaoenai.app.model.UserConfig;

class c
  implements ViewPager.OnPageChangeListener
{
  c(ForumActivity paramForumActivity) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    ForumActivity.c(this.a).setCurrentPosition(paramInt);
    a locala = (a)ForumActivity.a(this.a).get(paramInt);
    if (locala != null)
    {
      locala.i();
      locala.h();
    }
    if (paramInt == 2)
    {
      UserConfig.setInt("forum_current_moment_id", UserConfig.getInt("forum_moment_id", Integer.valueOf(-1)).intValue());
      UserConfig.setLong("forum_current_moment_end_time", UserConfig.getLong("forum_moment_end_time", 0L));
      this.a.a(2);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */