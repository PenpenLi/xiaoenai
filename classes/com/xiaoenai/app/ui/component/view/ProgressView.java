package com.xiaoenai.app.ui.component.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.xiaoenai.app.ui.component.a.a;
import com.xiaoenai.app.ui.component.a.c;

public class ProgressView
  extends ProgressBar
{
  public static int a = 0;
  public static int b = 1;
  private int c = 0;
  
  public ProgressView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.c.ProgressView);
    try
    {
      this.c = paramContext.getInt(a.c.ProgressView_ProgressColor, 0);
      invalidate();
      paramContext.recycle();
      setType(this.c);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  public void a()
  {
    setVisibility(0);
  }
  
  public void b()
  {
    setVisibility(8);
  }
  
  public void setType(int paramInt)
  {
    if (paramInt == a)
    {
      setIndeterminateDrawable(getResources().getDrawable(a.a.progress_view_white_anim));
      return;
    }
    if (paramInt == b)
    {
      setIndeterminateDrawable(getResources().getDrawable(a.a.progress_view_grey_anim));
      return;
    }
    setIndeterminateDrawable(getResources().getDrawable(a.a.widget_progress_circle_anim));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\ui\component\view\ProgressView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */