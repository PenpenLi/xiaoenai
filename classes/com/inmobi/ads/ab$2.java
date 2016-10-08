package com.inmobi.ads;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

final class ab$2
  implements ap.a
{
  private final Rect a = new Rect();
  
  public boolean a(@Nullable View paramView1, @Nullable View paramView2, int paramInt, @NonNull Object paramObject)
  {
    if (!(paramObject instanceof q)) {}
    long l1;
    long l2;
    long l3;
    do
    {
      do
      {
        return false;
        paramObject = (q)paramObject;
      } while ((paramView2 == null) || (!paramView2.isShown()) || (paramView1.getParent() == null) || (!paramView2.getGlobalVisibleRect(this.a)));
      l1 = this.a.height();
      l2 = this.a.width();
      l3 = ((q)paramObject).a().e() * ((q)paramObject).a().f();
    } while ((l3 <= 0L) || (l1 * l2 * 100L < l3 * paramInt));
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\ab$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */