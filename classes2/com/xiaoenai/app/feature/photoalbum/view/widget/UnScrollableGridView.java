package com.xiaoenai.app.feature.photoalbum.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.GridView;
import com.xiaoenai.app.utils.d.t;

public class UnScrollableGridView
  extends GridView
{
  private Context a;
  
  public UnScrollableGridView(Context paramContext)
  {
    this(paramContext, null);
    this.a = paramContext;
  }
  
  public UnScrollableGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    this.a = paramContext;
  }
  
  public UnScrollableGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
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
      i = View.MeasureSpec.makeMeasureSpec(t.a(this.a), Integer.MIN_VALUE);
    }
    super.onMeasure(paramInt1, i);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\view\widget\UnScrollableGridView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */