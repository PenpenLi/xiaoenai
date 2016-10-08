package com.xiaoenai.app.ui.component.view.keyboard;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FuncLayout
  extends LinearLayout
{
  public final int a = Integer.MIN_VALUE;
  protected int b = 0;
  private final SparseArray<View> c = new SparseArray();
  private int d = Integer.MIN_VALUE;
  private List<b> e;
  private a f;
  
  public FuncLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.c.size())
    {
      int j = this.c.keyAt(i);
      ((View)this.c.get(j)).setVisibility(8);
      i += 1;
    }
    this.d = Integer.MIN_VALUE;
    setVisibility(false);
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(b paramb)
  {
    if (this.e == null) {
      this.e = new ArrayList();
    }
    this.e.add(paramb);
  }
  
  public boolean b()
  {
    return this.d == Integer.MIN_VALUE;
  }
  
  public int getCurrentFuncKey()
  {
    return this.d;
  }
  
  public void setOnFuncChangeListener(a parama)
  {
    this.f = parama;
  }
  
  public void setVisibility(boolean paramBoolean)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)getLayoutParams();
    Iterator localIterator;
    if (paramBoolean)
    {
      setVisibility(0);
      localLayoutParams.height = this.b;
      if (this.e != null)
      {
        localIterator = this.e.iterator();
        while (localIterator.hasNext()) {
          ((b)localIterator.next()).c(this.b);
        }
      }
    }
    else
    {
      setVisibility(8);
      localLayoutParams.height = 0;
      if (this.e != null)
      {
        localIterator = this.e.iterator();
        while (localIterator.hasNext()) {
          ((b)localIterator.next()).m();
        }
      }
    }
    setLayoutParams(localLayoutParams);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void c(int paramInt);
    
    public abstract void m();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\ui\component\view\keyboard\FuncLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */