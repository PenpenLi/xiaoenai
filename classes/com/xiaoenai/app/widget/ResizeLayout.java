package com.xiaoenai.app.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.f.a;
import java.util.ArrayList;
import java.util.Iterator;

public class ResizeLayout
  extends RelativeLayout
{
  private Context a;
  private int b = 0;
  private ArrayList<Integer> c = new ArrayList();
  private a d;
  
  public ResizeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
  }
  
  private int a(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    switch (i)
    {
    default: 
      paramInt = 0;
    }
    return paramInt;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    a.c("===========onLayout=========== size = {}", new Object[] { Integer.valueOf(this.c.size()) });
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      a.c("heightList = {}", new Object[] { Integer.valueOf(((Integer)localIterator.next()).intValue()) });
    }
    a.c("===========getScreenHeight=========== {}", new Object[] { Integer.valueOf(ab.a()) });
    if (this.c.size() >= 2)
    {
      paramInt1 = ((Integer)this.c.get(0)).intValue();
      paramInt2 = ((Integer)this.c.get(this.c.size() - 1)).intValue();
      a.c("===========onLayout=====oldh====== {}", new Object[] { Integer.valueOf(paramInt1) });
      a.c("===========onLayout=====newh====== {}", new Object[] { Integer.valueOf(paramInt2) });
      if ((Build.VERSION.SDK_INT <= 10) && (paramInt1 == paramInt2) && (paramInt1 > 0))
      {
        this.c.clear();
        this.c.add(Integer.valueOf(paramInt1));
      }
    }
    label283:
    while (Build.VERSION.SDK_INT <= 10)
    {
      return;
      paramInt3 = this.b - paramInt2;
      if (paramInt1 != paramInt2)
      {
        if (paramInt1 != this.b) {
          break label283;
        }
        a.c("=====OnSoftPop===== {}", new Object[] { Integer.valueOf(paramInt3) });
        if (this.d != null) {
          this.d.b(paramInt3);
        }
      }
      for (;;)
      {
        this.c.clear();
        return;
        if (paramInt2 == this.b)
        {
          a.c("=====OnSoftClose===== {}", new Object[] { Integer.valueOf(paramInt3) });
          if (this.d != null) {
            this.d.c(paramInt3);
          }
        }
        else
        {
          a.c("=====OnSoftChanegHeight===== {}", new Object[] { Integer.valueOf(paramInt3) });
          if (this.d != null) {
            this.d.d(paramInt3);
          }
        }
      }
    }
    this.c.clear();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    a.c("===========onMeasure=========== {}", new Object[] { Integer.valueOf(paramInt2) });
    int i = a(paramInt2);
    a.c("===========onMeasure====== measureHeight ===== {}", new Object[] { Integer.valueOf(i) });
    this.c.add(Integer.valueOf(i));
    if (this.b != 0)
    {
      paramInt2 = View.MeasureSpec.getMode(paramInt2);
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.b, paramInt2));
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a.c("===========onSizeChanged=========== {}", new Object[] { Integer.valueOf(this.b) });
    if (this.b == 0) {
      this.b = paramInt2;
    }
  }
  
  public void setOnResizeListener(a parama)
  {
    this.d = parama;
  }
  
  public static abstract interface a
  {
    public abstract void b(int paramInt);
    
    public abstract void c(int paramInt);
    
    public abstract void d(int paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\widget\ResizeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */