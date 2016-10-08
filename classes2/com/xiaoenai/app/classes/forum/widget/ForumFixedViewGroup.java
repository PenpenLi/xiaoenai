package com.xiaoenai.app.classes.forum.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

public class ForumFixedViewGroup
  extends ViewGroup
{
  public ForumFixedViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ForumFixedViewGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = getChildAt(0);
    if (localView == null) {
      return;
    }
    localView.layout(getPaddingLeft(), getPaddingTop(), getPaddingRight() + localView.getMeasuredWidth(), getPaddingBottom() + localView.getMeasuredHeight());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (getChildCount() > 1) {
      throw new RuntimeException("just only hava one child");
    }
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    if (j == 1073741824)
    {
      paramInt1 = i - getPaddingLeft() - getPaddingRight();
      measureChildren(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
      setMeasuredDimension(i, paramInt1 + getPaddingBottom() + getPaddingTop());
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\widget\ForumFixedViewGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */