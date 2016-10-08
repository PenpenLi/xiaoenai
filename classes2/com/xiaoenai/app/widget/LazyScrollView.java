package com.xiaoenai.app.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ScrollView;

public class LazyScrollView
  extends ScrollView
{
  View.OnTouchListener a = new l(this);
  private Handler b;
  private View c;
  private boolean d;
  private a e;
  
  public LazyScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LazyScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @SuppressLint({"HandlerLeak"})
  private void a()
  {
    setOnTouchListener(this.a);
    this.b = new k(this);
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (paramInt == 1) {}
      int i;
      int j;
      do
      {
        do
        {
          return true;
          i = computeVerticalScrollOffset();
          j = computeVerticalScrollRange() - computeVerticalScrollExtent();
          if (j == 0) {
            return false;
          }
          if (paramInt >= 0) {
            break;
          }
        } while (i > 0);
        return false;
      } while (i < j - 1);
      return false;
    }
    return super.canScrollVertically(paramInt);
  }
  
  public int computeVerticalScrollOffset()
  {
    return super.computeVerticalScrollOffset();
  }
  
  public int computeVerticalScrollRange()
  {
    return super.computeHorizontalScrollRange();
  }
  
  public void getView()
  {
    this.c = getChildAt(0);
    if (this.c != null) {
      a();
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.d = true;
  }
  
  public void setOnScrollListener(a parama)
  {
    this.e = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
    
    public abstract void c();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\LazyScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */