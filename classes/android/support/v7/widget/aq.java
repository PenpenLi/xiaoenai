package android.support.v7.widget;

import android.view.View;

final class aq
  extends OrientationHelper
{
  aq(RecyclerView.LayoutManager paramLayoutManager)
  {
    super(paramLayoutManager, null);
  }
  
  public int getDecoratedEnd(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = this.mLayoutManager.getDecoratedBottom(paramView);
    return localLayoutParams.bottomMargin + i;
  }
  
  public int getDecoratedMeasurement(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = this.mLayoutManager.getDecoratedMeasuredHeight(paramView);
    int j = localLayoutParams.topMargin;
    return localLayoutParams.bottomMargin + (i + j);
  }
  
  public int getDecoratedMeasurementInOther(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = this.mLayoutManager.getDecoratedMeasuredWidth(paramView);
    int j = localLayoutParams.leftMargin;
    return localLayoutParams.rightMargin + (i + j);
  }
  
  public int getDecoratedStart(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return this.mLayoutManager.getDecoratedTop(paramView) - localLayoutParams.topMargin;
  }
  
  public int getEnd()
  {
    return this.mLayoutManager.getHeight();
  }
  
  public int getEndAfterPadding()
  {
    return this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingBottom();
  }
  
  public int getEndPadding()
  {
    return this.mLayoutManager.getPaddingBottom();
  }
  
  public int getMode()
  {
    return this.mLayoutManager.getHeightMode();
  }
  
  public int getModeInOther()
  {
    return this.mLayoutManager.getWidthMode();
  }
  
  public int getStartAfterPadding()
  {
    return this.mLayoutManager.getPaddingTop();
  }
  
  public int getTotalSpace()
  {
    return this.mLayoutManager.getHeight() - this.mLayoutManager.getPaddingTop() - this.mLayoutManager.getPaddingBottom();
  }
  
  public void offsetChild(View paramView, int paramInt)
  {
    paramView.offsetTopAndBottom(paramInt);
  }
  
  public void offsetChildren(int paramInt)
  {
    this.mLayoutManager.offsetChildrenVertical(paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */