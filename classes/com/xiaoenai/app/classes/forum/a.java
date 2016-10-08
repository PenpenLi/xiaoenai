package com.xiaoenai.app.classes.forum;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import com.xiaoenai.app.classes.forum.fragment.ForumMomentListFragment;
import com.xiaoenai.app.classes.forum.fragment.NewForumTopicsFragment;

class a
  extends FragmentStatePagerAdapter
{
  a(ForumActivity paramForumActivity, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public int getCount()
  {
    return 3;
  }
  
  public Fragment getItem(int paramInt)
  {
    com.xiaoenai.app.utils.f.a.c("getItem = {}", new Object[] { Integer.valueOf(paramInt) });
    Object localObject = (com.xiaoenai.app.classes.common.mvp.view.a.a)ForumActivity.a(this.a).get(paramInt);
    if (localObject == null)
    {
      if (paramInt == 0)
      {
        localObject = new NewForumTopicsFragment();
        ((NewForumTopicsFragment)localObject).a(16);
      }
      for (;;)
      {
        ForumActivity.a(this.a).put(paramInt, localObject);
        return (Fragment)localObject;
        if (1 == paramInt)
        {
          localObject = new NewForumTopicsFragment();
          ((NewForumTopicsFragment)localObject).a(14);
        }
        else
        {
          localObject = new ForumMomentListFragment();
        }
      }
    }
    return (Fragment)localObject;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */