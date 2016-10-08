package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.view.View;

@TargetApi(9)
public final class d
{
  public static void a(PullToRefreshBase<?> paramPullToRefreshBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat, boolean paramBoolean)
  {
    PullToRefreshBase.b localb;
    switch (e.a[paramPullToRefreshBase.getPullToRefreshScrollDirection().ordinal()])
    {
    default: 
      int i = paramPullToRefreshBase.getScrollY();
      paramInt2 = paramInt4;
      paramInt1 = paramInt3;
      paramInt3 = i;
      if ((paramPullToRefreshBase.i()) && (!paramPullToRefreshBase.j()))
      {
        localb = paramPullToRefreshBase.getMode();
        if ((!localb.b()) || (paramBoolean) || (paramInt1 == 0)) {
          break label213;
        }
        paramInt1 += paramInt2;
        if (paramInt1 >= 0 - paramInt6) {
          break label134;
        }
        if (localb.c())
        {
          if (paramInt3 == 0) {
            paramPullToRefreshBase.a(PullToRefreshBase.j.f, new boolean[0]);
          }
          paramPullToRefreshBase.setHeaderScroll((int)((paramInt3 + paramInt1) * paramFloat));
        }
      }
      break;
    }
    label134:
    label181:
    label213:
    while ((!paramBoolean) || (PullToRefreshBase.j.f != paramPullToRefreshBase.getState()))
    {
      do
      {
        do
        {
          return;
          paramInt3 = paramPullToRefreshBase.getScrollX();
          break;
          if (paramInt1 <= paramInt5 + paramInt6) {
            break label181;
          }
        } while (!localb.d());
        if (paramInt3 == 0) {
          paramPullToRefreshBase.a(PullToRefreshBase.j.f, new boolean[0]);
        }
        paramPullToRefreshBase.setHeaderScroll((int)((paramInt3 + paramInt1 - paramInt5) * paramFloat));
        return;
      } while ((Math.abs(paramInt1) > paramInt6) && (Math.abs(paramInt1 - paramInt5) > paramInt6));
      paramPullToRefreshBase.a(PullToRefreshBase.j.a, new boolean[0]);
      return;
    }
    paramPullToRefreshBase.a(PullToRefreshBase.j.a, new boolean[0]);
  }
  
  public static void a(PullToRefreshBase<?> paramPullToRefreshBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    a(paramPullToRefreshBase, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 0, 1.0F, paramBoolean);
  }
  
  public static void a(PullToRefreshBase<?> paramPullToRefreshBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    a(paramPullToRefreshBase, paramInt1, paramInt2, paramInt3, paramInt4, 0, paramBoolean);
  }
  
  static boolean a(View paramView)
  {
    return paramView.getOverScrollMode() != 2;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\handmark\pulltorefresh\library\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */