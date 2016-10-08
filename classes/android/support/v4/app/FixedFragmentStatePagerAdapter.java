package android.support.v4.app;

import android.os.Bundle;
import android.view.ViewGroup;

public abstract class FixedFragmentStatePagerAdapter
  extends FragmentStatePagerAdapter
{
  public FixedFragmentStatePagerAdapter(FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = (Fragment)super.instantiateItem(paramViewGroup, paramInt);
    Bundle localBundle = paramViewGroup.mSavedFragmentState;
    if (localBundle != null) {
      localBundle.setClassLoader(paramViewGroup.getClass().getClassLoader());
    }
    return paramViewGroup;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\app\FixedFragmentStatePagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */