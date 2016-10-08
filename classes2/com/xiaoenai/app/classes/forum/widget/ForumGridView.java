package com.xiaoenai.app.classes.forum.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.GridView;
import com.xiaoenai.app.utils.ab;

public class ForumGridView
  extends GridView
{
  public ForumGridView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ForumGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ForumGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 2) {
      return false;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (View.MeasureSpec.getMode(paramInt2) == 0) {
      i = View.MeasureSpec.makeMeasureSpec(ab.a(), Integer.MIN_VALUE);
    }
    super.onMeasure(paramInt1, i);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\widget\ForumGridView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */