package com.xiaoenai.app.utils.d;

import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;

final class z
  implements View.OnTouchListener
{
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!(paramView instanceof ImageButton)) {}
    do
    {
      do
      {
        return false;
        paramView = (ImageButton)paramView;
      } while (paramView.getDrawable() == null);
      if (paramMotionEvent.getAction() == 0)
      {
        paramMotionEvent = paramView.getDrawable();
        paramMotionEvent.setColorFilter(new ColorMatrixColorFilter(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -50.0F, 0.0F, 1.0F, 0.0F, 0.0F, -50.0F, 0.0F, 0.0F, 1.0F, 0.0F, -50.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F }));
        paramView.setImageDrawable(paramMotionEvent);
        return false;
      }
    } while ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3));
    paramMotionEvent = paramView.getDrawable();
    paramMotionEvent.setColorFilter(new ColorMatrixColorFilter(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F }));
    paramView.setImageDrawable(paramMotionEvent);
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\d\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */