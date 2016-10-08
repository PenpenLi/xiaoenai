package com.inmobi.ads;

import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.view.View;

final class ap$1
  implements ap.a
{
  private final Rect a = new Rect();
  
  public boolean a(@Nullable View paramView1, @Nullable View paramView2, int paramInt, Object paramObject)
  {
    if ((paramView2 == null) || (paramView2.getVisibility() != 0) || (paramView1.getParent() == null)) {}
    long l1;
    long l2;
    long l3;
    do
    {
      do
      {
        return false;
      } while (!paramView2.getGlobalVisibleRect(this.a));
      l1 = this.a.height();
      l2 = this.a.width();
      l3 = paramView2.getHeight() * paramView2.getWidth();
    } while ((l3 <= 0L) || (l1 * l2 * 100L < l3 * paramInt));
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\ap$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */