package com.xiaoenai.app.utils.e.d;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.xiaoenai.app.utils.e.c.a;
import java.lang.ref.WeakReference;

public class e
  implements AbsListView.OnScrollListener
{
  private WeakReference<a> a;
  private final boolean b;
  private final boolean c;
  private final AbsListView.OnScrollListener d;
  
  public e(WeakReference<a> paramWeakReference, boolean paramBoolean1, boolean paramBoolean2, AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.a = paramWeakReference;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = paramOnScrollListener;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.d != null) {
      this.d.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.d != null) {
        this.d.onScrollStateChanged(paramAbsListView, paramInt);
      }
      return;
      a locala = (a)this.a.get();
      if (locala != null)
      {
        locala.d();
        continue;
        if (this.b)
        {
          locala = (a)this.a.get();
          if (locala != null)
          {
            locala.e();
            continue;
            if (this.c)
            {
              locala = (a)this.a.get();
              if (locala != null) {
                locala.e();
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\e\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */