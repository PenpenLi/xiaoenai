package com.xiaoenai.app.classes.forum.fragment;

import android.widget.ImageButton;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.marshalchen.ultimaterecyclerview.RefreshCustomUltimateRecyclerview;
import com.xiaoenai.app.ui.component.view.ProgressView;

public class z<T extends NewForumTopicsFragment>
  implements Unbinder
{
  protected T a;
  
  public z(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.mRecyclerview = ((RefreshCustomUltimateRecyclerview)paramFinder.findRequiredViewAsType(paramObject, 2131558668, "field 'mRecyclerview'", RefreshCustomUltimateRecyclerview.class));
    paramT.mProgessView = ((ProgressView)paramFinder.findRequiredViewAsType(paramObject, 2131558669, "field 'mProgessView'", ProgressView.class));
    paramT.mFloatingButton = ((ImageButton)paramFinder.findRequiredViewAsType(paramObject, 2131559332, "field 'mFloatingButton'", ImageButton.class));
  }
  
  public void unbind()
  {
    NewForumTopicsFragment localNewForumTopicsFragment = this.a;
    if (localNewForumTopicsFragment == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localNewForumTopicsFragment.mRecyclerview = null;
    localNewForumTopicsFragment.mProgessView = null;
    localNewForumTopicsFragment.mFloatingButton = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\fragment\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */