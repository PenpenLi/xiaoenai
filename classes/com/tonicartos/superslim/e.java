package com.tonicartos.superslim;

import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class e
  extends h
{
  public static int a = 1;
  
  public e(LayoutManager paramLayoutManager)
  {
    super(paramLayoutManager);
  }
  
  private int a(d.a parama, int paramInt, LayoutManager.a parama1, g paramg, d paramd)
  {
    int j = this.b.getDecoratedMeasuredHeight(parama.a);
    int m = this.b.getDecoratedMeasuredWidth(parama.a);
    int i;
    if (paramd.c)
    {
      i = paramg.i;
      if (parama1 != LayoutManager.a.b) {
        break label104;
      }
      j = paramInt + j;
    }
    for (;;)
    {
      this.b.layoutDecorated(parama.a, i, paramInt, i + m, j);
      if (parama1 != LayoutManager.a.b) {
        break label119;
      }
      return this.b.getDecoratedBottom(parama.a);
      i = paramg.h;
      break;
      label104:
      int k = paramInt - j;
      j = paramInt;
      paramInt = k;
    }
    label119:
    return this.b.getDecoratedTop(parama.a);
  }
  
  private void a(d.a parama, g paramg)
  {
    this.b.measureChildWithMargins(parama.a, paramg.a(), 0);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, g paramg, d paramd)
  {
    int i = paramd.a().getItemCount();
    for (;;)
    {
      if ((paramInt3 >= i) || (paramInt2 >= paramInt1)) {
        return paramInt2;
      }
      d.a locala = paramd.c(paramInt3);
      if (locala.a().d() != paramg.a)
      {
        paramd.a(paramInt3, locala.a);
        return paramInt2;
      }
      a(locala, paramg);
      paramInt2 = a(locala, paramInt2, LayoutManager.a.b, paramg, paramd);
      a(locala, paramInt3, LayoutManager.a.b, paramd);
      paramInt3 += 1;
    }
  }
  
  public int a(int paramInt, View paramView, g paramg, d paramd)
  {
    int i = this.b.getPosition(paramView);
    return a(paramInt, this.b.getDecoratedBottom(paramView), i + 1, paramg, paramd);
  }
  
  public int a(int paramInt, g paramg, d paramd)
  {
    int i = paramg.a + 1;
    int j = 0;
    while ((j < paramg.g) && (i < paramInt))
    {
      d.a locala = paramd.c(i);
      a(locala, paramg);
      j += this.b.getDecoratedMeasuredHeight(locala.a);
      paramd.a(i, locala.a);
      i += 1;
    }
    if (j == paramg.g) {
      return 0;
    }
    if (j > paramg.g) {
      return 1;
    }
    return -j;
  }
  
  public int b(int paramInt1, int paramInt2, int paramInt3, g paramg, d paramd)
  {
    int i = 0;
    Object localObject;
    if (i < paramd.a().getItemCount())
    {
      localObject = this.b.getChildAt(0);
      if (localObject == null) {
        i = 0;
      }
    }
    for (;;)
    {
      int n = -1;
      int j = n;
      int m;
      int i1;
      int k;
      LayoutManager.LayoutParams localLayoutParams;
      if (i != 0)
      {
        j = paramInt3;
        m = 0;
        i1 = m;
        k = n;
        if (j >= 0)
        {
          localObject = paramd.c(j);
          paramd.a(j, ((d.a)localObject).a);
          localLayoutParams = ((d.a)localObject).a();
          if (localLayoutParams.d() != paramg.a)
          {
            k = n;
            i1 = m;
          }
        }
        else
        {
          label114:
          j = k;
          if (i1 >= paramg.c) {
            break label397;
          }
          j = i1 - paramg.c;
          paramInt2 += j;
          label143:
          if ((paramInt3 >= 0) && (paramInt2 - j > paramInt1)) {
            break label272;
          }
          return paramInt2;
          localObject = (LayoutManager.LayoutParams)((View)localObject).getLayoutParams();
          if (((LayoutManager.LayoutParams)localObject).d() != paramg.a)
          {
            i = 1;
            continue;
          }
          if (!((LayoutManager.LayoutParams)localObject).a)
          {
            i = 0;
            continue;
          }
          i += 1;
          break;
        }
        if (!localLayoutParams.a) {}
      }
      for (;;)
      {
        j -= 1;
        break;
        a((d.a)localObject, paramg);
        m += this.b.getDecoratedMeasuredHeight(((d.a)localObject).a);
        if (m >= paramg.c)
        {
          i1 = m;
          k = j;
          break label114;
          label272:
          localObject = paramd.c(paramInt3);
          localLayoutParams = ((d.a)localObject).a();
          if (localLayoutParams.a)
          {
            paramd.a(paramInt3, ((d.a)localObject).a);
            return paramInt2;
          }
          if (localLayoutParams.d() != paramg.a)
          {
            paramd.a(paramInt3, ((d.a)localObject).a);
            return paramInt2;
          }
          if ((i == 0) || (paramInt3 < k)) {
            a((d.a)localObject, paramg);
          }
          for (;;)
          {
            paramInt2 = a((d.a)localObject, paramInt2, LayoutManager.a.a, paramg, paramd);
            a((d.a)localObject, paramInt3, LayoutManager.a.a, paramd);
            paramInt3 -= 1;
            break;
            paramd.a(paramInt3);
          }
          label397:
          m = 0;
          k = j;
          j = m;
          break label143;
        }
        n = j;
      }
      i = 0;
    }
  }
  
  public int b(int paramInt, View paramView, g paramg, d paramd)
  {
    int i = this.b.getPosition(paramView);
    return b(paramInt, this.b.getDecoratedTop(paramView), i - 1, paramg, paramd);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\tonicartos\superslim\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */