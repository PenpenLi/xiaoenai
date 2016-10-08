package com.tonicartos.superslim;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class GridSLM
  extends h
{
  public static int a = 2;
  private final Context c;
  private int d = 0;
  private int e = 0;
  private int f;
  private boolean g;
  
  public GridSLM(LayoutManager paramLayoutManager, Context paramContext)
  {
    super(paramLayoutManager);
    this.c = paramContext;
  }
  
  private void a(d.a parama, int paramInt1, int paramInt2, int paramInt3, g paramg, d paramd)
  {
    int i;
    if (parama.a().height == -1)
    {
      if (paramInt2 != this.e - 1) {
        break label97;
      }
      i = this.b.getDecoratedMeasuredWidth(parama.a);
      label34:
      if (!paramd.c) {
        break label120;
      }
    }
    label97:
    label120:
    for (int j = paramg.i;; j = paramg.h)
    {
      paramInt2 = this.f * paramInt2 + j;
      this.b.layoutDecorated(parama.a, paramInt2, paramInt1, paramInt2 + i, paramInt1 + paramInt3);
      return;
      paramInt3 = this.b.getDecoratedMeasuredHeight(parama.a);
      break;
      i = Math.min(this.f, this.b.getDecoratedMeasuredWidth(parama.a));
      break label34;
    }
  }
  
  private void a(d.a parama, g paramg)
  {
    int i = this.e;
    int j = this.f;
    this.b.measureChildWithMargins(parama.a, (i - 1) * j + (paramg.j + paramg.k), 0);
  }
  
  private void c(g paramg)
  {
    int i = this.b.getWidth() - paramg.i - paramg.h;
    if (!this.g)
    {
      if (this.d <= 0) {
        this.d = ((int)TypedValue.applyDimension(1, 48.0F, this.c.getResources().getDisplayMetrics()));
      }
      this.e = (i / Math.abs(this.d));
    }
    if (this.e < 1) {
      this.e = 1;
    }
    this.f = (i / this.e);
    if (this.f == 0) {
      Log.e("GridSection", "Too many columns (" + this.e + ") for available width" + i + ".");
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 0;
    int i = this.b.getWidth();
    int m = 0;
    int k = paramInt2;
    paramInt2 = m;
    View localView;
    LayoutManager.LayoutParams localLayoutParams;
    if (k >= 0)
    {
      localView = this.b.getChildAt(k);
      localLayoutParams = (LayoutManager.LayoutParams)localView.getLayoutParams();
      if (localLayoutParams.d() == paramInt1) {}
    }
    else
    {
      label56:
      if (j == 0) {
        return paramInt3;
      }
      return paramInt2;
    }
    if (localLayoutParams.a)
    {
      m = j;
      j = paramInt2;
    }
    for (paramInt2 = m;; paramInt2 = m)
    {
      m = k - 1;
      k = j;
      j = paramInt2;
      paramInt2 = k;
      k = m;
      break;
      if (localView.getLeft() >= i) {
        break label56;
      }
      i = localView.getLeft();
      m = 1;
      j = Math.max(paramInt2, this.b.getDecoratedBottom(localView));
    }
    return paramInt3;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, g paramg, d paramd)
  {
    if (paramInt2 >= paramInt1) {}
    int k;
    Object localObject;
    do
    {
      do
      {
        return paramInt2;
        k = paramd.a().getItemCount();
      } while (paramInt3 >= k);
      localObject = paramd.c(paramInt3);
      paramd.a(paramInt3, ((d.a)localObject).a);
    } while (((d.a)localObject).a().d() != paramg.a);
    int i;
    int m;
    label89:
    int j;
    if (paramg.b)
    {
      i = paramg.a + 1;
      m = (paramInt3 - i) % this.e;
      i = 1;
      if (i > m) {
        break label220;
      }
      j = 1;
      label99:
      if (j > this.b.getChildCount()) {
        break label303;
      }
      localObject = this.b.getChildAt(this.b.getChildCount() - j);
      if (this.b.getPosition((View)localObject) != paramInt3 - i) {
        break label189;
      }
      paramInt2 = this.b.getDecoratedTop((View)localObject);
      this.b.detachAndScrapViewAt(j, paramd.a);
    }
    label189:
    label220:
    label303:
    for (;;)
    {
      i += 1;
      break label89;
      i = paramg.a;
      break;
      if (((LayoutManager.LayoutParams)((View)localObject).getLayoutParams()).d() == paramg.a)
      {
        j += 1;
        break label99;
        paramInt3 -= m;
        for (;;)
        {
          if ((paramInt3 >= k) || (paramInt2 > paramInt1)) {}
          for (;;)
          {
            return paramInt2;
            localObject = paramd.c(paramInt3);
            if (((d.a)localObject).a().d() == paramg.a) {
              break;
            }
            paramd.a(paramInt3, ((d.a)localObject).a);
          }
          paramInt2 += a(paramInt2, paramInt3, LayoutManager.a.b, true, paramg, paramd);
          paramInt3 += this.e;
        }
      }
    }
  }
  
  public int a(int paramInt1, int paramInt2, LayoutManager.a parama, boolean paramBoolean, g paramg, d paramd)
  {
    int j = 0;
    d.a[] arrayOfa = new d.a[this.e];
    int i = 0;
    int k;
    if (i < this.e)
    {
      k = paramInt2 + i;
      if (k < paramd.a().getItemCount()) {}
    }
    else
    {
      label43:
      if (parama != LayoutManager.a.a) {
        break label227;
      }
      k = 1;
      label53:
      if (k == 0) {
        break label311;
      }
    }
    label66:
    label89:
    label112:
    label227:
    label239:
    label245:
    label269:
    label311:
    for (int m = paramInt1 - j;; m = paramInt1)
    {
      paramInt1 = 0;
      if (paramInt1 < this.e)
      {
        int n;
        if (k != 0)
        {
          n = this.e - paramInt1 - 1;
          if (!paramd.c) {
            break label245;
          }
          if (k == 0) {
            break label239;
          }
          i = this.e - paramInt1 - 1;
          if (arrayOfa[n] != null) {
            break label269;
          }
        }
        for (;;)
        {
          paramInt1 += 1;
          break label66;
          d.a locala = paramd.c(k);
          if (locala.a().d() != paramg.a)
          {
            paramd.a(k, locala.a);
            break label43;
          }
          if (paramBoolean) {
            a(locala, paramg);
          }
          for (;;)
          {
            j = Math.max(j, this.b.getDecoratedMeasuredHeight(locala.a));
            arrayOfa[i] = locala;
            i += 1;
            break;
            paramd.a(i + paramInt2);
          }
          k = 0;
          break label53;
          n = paramInt1;
          break label89;
          i = paramInt1;
          break label112;
          if (k != 0) {}
          for (i = paramInt1;; i = this.e - paramInt1 - 1) {
            break;
          }
          a(arrayOfa[n], m, i, j, paramg, paramd);
          a(arrayOfa[n], n + paramInt2, parama, paramd);
        }
      }
      return j;
    }
  }
  
  public int a(int paramInt, View paramView, g paramg, d paramd)
  {
    int i = this.b.getPosition(paramView);
    return a(paramInt, a(paramg.a, this.b.getChildCount() - 1, this.b.getDecoratedBottom(paramView)), i + 1, paramg, paramd);
  }
  
  public int a(int paramInt, g paramg, d paramd)
  {
    int n = paramd.a().getItemCount();
    int i = paramg.a + 1;
    int j = 0;
    while ((j < paramg.g) && (i < paramInt))
    {
      int k = 0;
      int m = 0;
      while ((k < this.e) && (i + k < n))
      {
        d.a locala = paramd.c(i + k);
        a(locala, paramg);
        m = Math.max(m, this.b.getDecoratedMeasuredHeight(locala.a));
        paramd.a(i + k, locala.a);
        k += 1;
      }
      j += m;
      i += this.e;
    }
    if (j == paramg.g) {
      return 0;
    }
    if (j > paramg.g) {
      return 1;
    }
    return -j;
  }
  
  public GridSLM a(g paramg)
  {
    super.b(paramg);
    int i;
    if ((paramg.l instanceof LayoutParams))
    {
      LayoutParams localLayoutParams = (LayoutParams)paramg.l;
      int k = localLayoutParams.a();
      int j = localLayoutParams.b();
      i = j;
      if (k < 0)
      {
        i = j;
        if (j < 0) {
          i = 1;
        }
      }
      if (i != -1) {
        break label72;
      }
      a(k);
    }
    for (;;)
    {
      c(paramg);
      return this;
      label72:
      b(i);
    }
  }
  
  public LayoutManager.LayoutParams a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new LayoutParams(paramContext, paramAttributeSet);
  }
  
  public LayoutManager.LayoutParams a(LayoutManager.LayoutParams paramLayoutParams)
  {
    return LayoutParams.a(paramLayoutParams);
  }
  
  @Deprecated
  public void a(int paramInt)
  {
    this.d = paramInt;
    this.g = false;
  }
  
  public int b(int paramInt1, int paramInt2, int paramInt3, g paramg, d paramd)
  {
    int i;
    int j;
    label20:
    Object localObject;
    int m;
    if (paramg.b)
    {
      i = paramg.a + 1;
      j = 0;
      if (j >= this.b.getChildCount()) {
        break label613;
      }
      localObject = (LayoutManager.LayoutParams)this.b.getChildAt(0).getLayoutParams();
      if (((LayoutManager.LayoutParams)localObject).d() == paramg.a) {
        break label154;
      }
      m = 1;
    }
    for (;;)
    {
      label64:
      int k = (paramInt3 - i) % this.e;
      i = 1;
      label78:
      if (i < this.e - k)
      {
        j = 0;
        for (;;)
        {
          if (j < this.b.getChildCount())
          {
            localObject = this.b.getChildAt(j);
            if (((LayoutManager.LayoutParams)((View)localObject).getLayoutParams()).d() == paramg.a) {
              break label177;
            }
          }
          for (;;)
          {
            i += 1;
            break label78;
            i = paramg.a;
            break;
            label154:
            if (!((LayoutManager.LayoutParams)localObject).a)
            {
              m = 0;
              break label64;
            }
            j += 1;
            break label20;
            label177:
            if (this.b.getPosition((View)localObject) != paramInt3 + i) {
              break label210;
            }
            this.b.detachAndScrapViewAt(j, paramd.a);
          }
          label210:
          j += 1;
        }
      }
      int n = paramInt3 - k;
      i = -1;
      j = 0;
      if (m != 0)
      {
        i = n;
        k = -1;
        if (i < 0) {
          break label607;
        }
        localObject = paramd.c(i);
        paramd.a(i, ((d.a)localObject).a);
        if (((d.a)localObject).a().d() != paramg.a) {
          paramInt3 = k;
        }
      }
      for (;;)
      {
        label288:
        i = paramInt3;
        if (j < paramg.c)
        {
          j -= paramg.c;
          paramInt2 += j;
          i = paramInt3;
        }
        for (paramInt3 = j;; paramInt3 = 0)
        {
          j = paramInt2;
          paramInt2 = n;
          if ((paramInt2 < 0) || (j - paramInt3 <= paramInt1)) {}
          label484:
          do
          {
            return j;
            int i1 = 0;
            k = 0;
            LayoutManager.LayoutParams localLayoutParams;
            if ((k < this.e) && (i + k <= paramInt3))
            {
              localObject = paramd.c(i + k);
              paramd.a(i + k, ((d.a)localObject).a);
              localLayoutParams = ((d.a)localObject).a();
              if (localLayoutParams.d() == paramg.a) {}
            }
            else
            {
              j += i1;
              if (j < paramg.c) {
                break label484;
              }
              paramInt3 = i;
              break label288;
            }
            if (localLayoutParams.a) {}
            for (;;)
            {
              k += 1;
              break;
              a((d.a)localObject, paramg);
              i1 = Math.max(i1, this.b.getDecoratedMeasuredHeight(((d.a)localObject).a));
            }
            i1 = this.e;
            k = i;
            i -= i1;
            break;
            localObject = paramd.c(paramInt2);
            paramd.a(paramInt2, ((d.a)localObject).a);
            localObject = ((d.a)localObject).a();
          } while ((((LayoutManager.LayoutParams)localObject).a) || (((LayoutManager.LayoutParams)localObject).d() != paramg.a));
          if ((m == 0) || (paramInt2 < i)) {}
          for (boolean bool = true;; bool = false)
          {
            j -= a(j, paramInt2, LayoutManager.a.a, bool, paramg, paramd);
            paramInt2 -= this.e;
            break;
          }
        }
        label607:
        paramInt3 = k;
      }
      label613:
      m = 0;
    }
  }
  
  public int b(int paramInt, View paramView, g paramg, d paramd)
  {
    int i = this.b.getPosition(paramView);
    return b(paramInt, this.b.getDecoratedTop(paramView), i - 1, paramg, paramd);
  }
  
  @Deprecated
  public void b(int paramInt)
  {
    this.e = paramInt;
    this.d = 0;
    this.g = true;
  }
  
  public static class LayoutParams
    extends LayoutManager.LayoutParams
  {
    private int i;
    private int j;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, f.a.superslim_GridSLM);
      this.i = paramContext.getInt(f.a.superslim_GridSLM_slm_grid_numColumns, -1);
      this.j = paramContext.getDimensionPixelSize(f.a.superslim_GridSLM_slm_grid_columnWidth, -1);
      paramContext.recycle();
    }
    
    @Deprecated
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      c(paramLayoutParams);
    }
    
    @Deprecated
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      c(paramMarginLayoutParams);
    }
    
    public static LayoutParams a(ViewGroup.LayoutParams paramLayoutParams)
    {
      if (paramLayoutParams == null)
      {
        Log.w("SuperSLiM", "Null value passed in call to GridSLM.LayoutParams.from().");
        return new LayoutParams(-2, -2);
      }
      if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      }
      return new LayoutParams(paramLayoutParams);
    }
    
    private void c(ViewGroup.LayoutParams paramLayoutParams)
    {
      if ((paramLayoutParams instanceof LayoutParams))
      {
        paramLayoutParams = (LayoutParams)paramLayoutParams;
        this.i = paramLayoutParams.i;
        this.j = paramLayoutParams.j;
        return;
      }
      this.i = -1;
      this.j = -1;
    }
    
    public int a()
    {
      return this.j;
    }
    
    public void a(int paramInt)
    {
      this.j = paramInt;
    }
    
    public int b()
    {
      return this.i;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\tonicartos\superslim\GridSLM.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */