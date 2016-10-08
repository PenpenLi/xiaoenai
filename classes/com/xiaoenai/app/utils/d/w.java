package com.xiaoenai.app.utils.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.widget.Button;

public final class w
{
  public static final View.OnTouchListener a = new x();
  public static final View.OnTouchListener b = new y();
  public static final View.OnTouchListener c = new z();
  
  public static void a(View paramView)
  {
    paramView.measure(-1, -2);
    int i = paramView.getMeasuredHeight();
    paramView.getLayoutParams().height = 1;
    paramView.setVisibility(0);
    paramView.requestLayout();
    aa localaa = new aa(paramView, i);
    localaa.setDuration((int)(i / paramView.getContext().getResources().getDisplayMetrics().density));
    paramView.startAnimation(localaa);
  }
  
  public static void a(Button paramButton)
  {
    if (paramButton != null)
    {
      Drawable localDrawable = paramButton.getBackground();
      if (localDrawable != null) {
        localDrawable.setAlpha(153);
      }
      paramButton.setClickable(false);
      if (Build.VERSION.SDK_INT <= 11) {
        paramButton.invalidate();
      }
    }
  }
  
  public static void b(View paramView)
  {
    int i = paramView.getMeasuredHeight();
    ab localab = new ab(paramView, i);
    localab.setDuration((int)(i / paramView.getContext().getResources().getDisplayMetrics().density));
    paramView.startAnimation(localab);
  }
  
  public static void b(Button paramButton)
  {
    if (paramButton != null)
    {
      Drawable localDrawable = paramButton.getBackground();
      if (localDrawable != null) {
        localDrawable.setAlpha(255);
      }
      paramButton.setClickable(true);
      if (Build.VERSION.SDK_INT <= 11) {
        paramButton.invalidate();
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\d\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */