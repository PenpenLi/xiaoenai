package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;

class aj
  extends LinearSmoothScroller
{
  aj(LinearLayoutManager paramLinearLayoutManager, Context paramContext)
  {
    super(paramContext);
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    return this.a.computeScrollVectorForPosition(paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */