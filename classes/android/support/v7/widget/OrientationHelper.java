package android.support.v7.widget;

import android.view.View;

public abstract class OrientationHelper
{
  public static final int HORIZONTAL = 0;
  private static final int INVALID_SIZE = Integer.MIN_VALUE;
  public static final int VERTICAL = 1;
  private int mLastTotalSpace = Integer.MIN_VALUE;
  protected final RecyclerView.LayoutManager mLayoutManager;
  
  private OrientationHelper(RecyclerView.LayoutManager paramLayoutManager)
  {
    this.mLayoutManager = paramLayoutManager;
  }
  
  public static OrientationHelper createHorizontalHelper(RecyclerView.LayoutManager paramLayoutManager)
  {
    return new ap(paramLayoutManager);
  }
  
  public static OrientationHelper createOrientationHelper(RecyclerView.LayoutManager paramLayoutManager, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("invalid orientation");
    case 0: 
      return createHorizontalHelper(paramLayoutManager);
    }
    return createVerticalHelper(paramLayoutManager);
  }
  
  public static OrientationHelper createVerticalHelper(RecyclerView.LayoutManager paramLayoutManager)
  {
    return new aq(paramLayoutManager);
  }
  
  public abstract int getDecoratedEnd(View paramView);
  
  public abstract int getDecoratedMeasurement(View paramView);
  
  public abstract int getDecoratedMeasurementInOther(View paramView);
  
  public abstract int getDecoratedStart(View paramView);
  
  public abstract int getEnd();
  
  public abstract int getEndAfterPadding();
  
  public abstract int getEndPadding();
  
  public abstract int getMode();
  
  public abstract int getModeInOther();
  
  public abstract int getStartAfterPadding();
  
  public abstract int getTotalSpace();
  
  public int getTotalSpaceChange()
  {
    if (Integer.MIN_VALUE == this.mLastTotalSpace) {
      return 0;
    }
    return getTotalSpace() - this.mLastTotalSpace;
  }
  
  public abstract void offsetChild(View paramView, int paramInt);
  
  public abstract void offsetChildren(int paramInt);
  
  public void onLayoutComplete()
  {
    this.mLastTotalSpace = getTotalSpace();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\OrientationHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */