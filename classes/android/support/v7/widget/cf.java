package android.support.v7.widget;

import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;

class cf
  extends ViewPropertyAnimatorListenerAdapter
{
  private boolean c = false;
  
  cf(ToolbarWidgetWrapper paramToolbarWidgetWrapper, int paramInt) {}
  
  public void onAnimationCancel(View paramView)
  {
    this.c = true;
  }
  
  public void onAnimationEnd(View paramView)
  {
    if (!this.c) {
      ToolbarWidgetWrapper.access$000(this.b).setVisibility(this.a);
    }
  }
  
  public void onAnimationStart(View paramView)
  {
    ToolbarWidgetWrapper.access$000(this.b).setVisibility(0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */