package android.support.v4.app;

import android.support.annotation.Nullable;
import android.view.View;

class Fragment$1
  extends FragmentContainer
{
  Fragment$1(Fragment paramFragment) {}
  
  @Nullable
  public View onFindViewById(int paramInt)
  {
    if (this.this$0.mView == null) {
      throw new IllegalStateException("Fragment does not have a view");
    }
    return this.this$0.mView.findViewById(paramInt);
  }
  
  public boolean onHasView()
  {
    return this.this$0.mView != null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\app\Fragment$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */