package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;

class bs
  extends LinearSmoothScroller
{
  bs(StaggeredGridLayoutManager paramStaggeredGridLayoutManager, Context paramContext)
  {
    super(paramContext);
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    paramInt = StaggeredGridLayoutManager.access$400(this.a, paramInt);
    if (paramInt == 0) {
      return null;
    }
    if (StaggeredGridLayoutManager.access$500(this.a) == 0) {
      return new PointF(paramInt, 0.0F);
    }
    return new PointF(0.0F, paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */