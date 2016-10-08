package com.xiaoenai.app.utils.e.d;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.xiaoenai.app.utils.e.c.a;
import java.lang.ref.WeakReference;

public class f
  extends RecyclerView.OnScrollListener
{
  private final boolean a;
  private final boolean b;
  private final RecyclerView.OnScrollListener c;
  private WeakReference<a> d;
  
  public f(WeakReference<a> paramWeakReference, boolean paramBoolean1, boolean paramBoolean2, RecyclerView.OnScrollListener paramOnScrollListener)
  {
    this.d = paramWeakReference;
    this.a = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramOnScrollListener;
  }
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    a locala = (a)this.d.get();
    if (locala != null) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      if (this.c != null) {
        this.c.onScrollStateChanged(paramRecyclerView, paramInt);
      }
      return;
      locala.d();
      continue;
      if (this.a)
      {
        locala.e();
        continue;
        if (this.b) {
          locala.e();
        }
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (this.c != null) {
      this.c.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\e\d\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */