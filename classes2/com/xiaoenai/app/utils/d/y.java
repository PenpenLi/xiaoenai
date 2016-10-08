package com.xiaoenai.app.utils.d;

import android.annotation.SuppressLint;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;

final class y
  implements View.OnTouchListener
{
  @SuppressLint({"NewApi"})
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = (Button)paramView;
    if (paramView.getBackground() == null) {}
    do
    {
      return false;
      if (paramMotionEvent.getAction() == 0)
      {
        paramView.getBackground().setColorFilter(new ColorMatrixColorFilter(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -50.0F, 0.0F, 1.0F, 0.0F, 0.0F, -50.0F, 0.0F, 0.0F, 1.0F, 0.0F, -50.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F }));
        if (Build.VERSION.SDK_INT < 16)
        {
          paramView.setBackgroundDrawable(paramView.getBackground());
          paramView.setTextColor(paramView.getTextColors());
          return false;
        }
        paramView.setBackground(paramView.getBackground());
        paramView.setTextColor(paramView.getTextColors());
        return false;
      }
    } while ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3));
    paramView.getBackground().setColorFilter(new ColorMatrixColorFilter(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F }));
    if (Build.VERSION.SDK_INT < 16)
    {
      paramView.setBackgroundDrawable(paramView.getBackground());
      paramView.setTextColor(paramView.getTextColors());
      return false;
    }
    paramView.setBackground(paramView.getBackground());
    paramView.setTextColor(paramView.getTextColors());
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\d\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */