package com.tonicartos.superslim;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.IntDef;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;

public class LayoutManager
  extends RecyclerView.LayoutManager
{
  private final h a = new e(this);
  private final h b;
  private int c = -1;
  private Rect d = new Rect();
  private int e = 0;
  private HashMap<String, h> f;
  private boolean g = true;
  
  public LayoutManager(Context paramContext)
  {
    this.b = new GridSLM(this, paramContext);
    this.f = new HashMap();
  }
  
  private float a(RecyclerView.State paramState, boolean paramBoolean)
  {
    paramState = getChildAt(0);
    int i1 = getPosition(paramState);
    int j = 0;
    float f1 = getDecoratedTop(paramState);
    if (getDecoratedBottom(paramState) < 0.0F) {
      f1 = 1.0F;
    }
    float f2;
    for (;;)
    {
      paramState = new g(this, paramState);
      if ((!paramState.l.a) || (!paramState.l.f())) {
        break;
      }
      return f1;
      if (0.0F <= f1)
      {
        f1 = 0.0F;
      }
      else
      {
        f2 = getDecoratedMeasuredHeight(paramState);
        f1 = -f1 / f2;
      }
    }
    int i = -1;
    SparseArray localSparseArray = new SparseArray();
    int k = 1;
    View localView;
    LayoutParams localLayoutParams;
    if (k < getChildCount())
    {
      localView = getChildAt(k);
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (paramState.a(localLayoutParams)) {}
    }
    else
    {
      return f1 - j - a(paramState).a(i, localSparseArray);
    }
    int n = getPosition(localView);
    int m = j;
    if (!paramBoolean)
    {
      m = j;
      if (n < i1) {
        m = j + 1;
      }
    }
    float f3 = getDecoratedTop(localView);
    if (getDecoratedBottom(localView) < 0.0F) {}
    for (f1 += 1.0F;; f1 += -f3 / f2)
    {
      j = i;
      f2 = f1;
      if (!localLayoutParams.a)
      {
        j = i;
        if (i == -1) {
          j = n;
        }
        localSparseArray.put(n, Boolean.valueOf(true));
        f2 = f1;
      }
      do
      {
        k += 1;
        i = j;
        j = m;
        f1 = f2;
        break;
        j = i;
        f2 = f1;
      } while (0.0F <= f3);
      f2 = getDecoratedMeasuredHeight(localView);
    }
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 < paramInt1) {
      return -1;
    }
    int i = paramInt1 + (paramInt2 - paramInt1) / 2;
    LayoutParams localLayoutParams = (LayoutParams)getChildAt(i).getLayoutParams();
    if (localLayoutParams.d() < paramInt3) {
      return a(i + 1, paramInt2, paramInt3);
    }
    if ((localLayoutParams.d() > paramInt3) || (localLayoutParams.a)) {
      return a(paramInt1, i - 1, paramInt3);
    }
    if (i == getChildCount() - 1) {
      return i;
    }
    localLayoutParams = (LayoutParams)getChildAt(i + 1).getLayoutParams();
    if (localLayoutParams.d() != paramInt3) {
      return i;
    }
    if (localLayoutParams.a)
    {
      if (i + 1 == getChildCount() - 1) {
        return i;
      }
      if (((LayoutParams)getChildAt(i + 2).getLayoutParams()).d() != paramInt3) {
        return i;
      }
    }
    return a(i + 1, paramInt2, paramInt3);
  }
  
  private int a(int paramInt1, int paramInt2, d paramd)
  {
    if (paramInt2 >= paramInt1) {}
    int j;
    do
    {
      return paramInt2;
      j = getPosition(c()) + 1;
    } while (j >= paramd.a().getItemCount());
    d.a locala = paramd.c(j);
    g localg = new g(this, locala.a);
    if (localg.b)
    {
      a(locala.a);
      localg = new g(this, locala.a);
      paramInt2 = b(locala.a, paramInt2, localg, paramd);
      j += 1;
    }
    for (;;)
    {
      int i = paramInt2;
      if (j < paramd.a().getItemCount()) {
        i = a(localg).a(paramInt1, paramInt2, j, localg, paramd);
      }
      paramInt2 = i;
      if (localg.b)
      {
        addView(locala.a);
        if (locala.b) {
          paramd.a(localg.a);
        }
        paramInt2 = Math.max(getDecoratedBottom(locala.a), i);
      }
      return a(paramInt1, paramInt2, paramd);
      paramd.a(j, locala.a);
    }
  }
  
  private int a(int paramInt, a parama, d paramd)
  {
    if (parama == a.a) {
      return b(paramInt, paramd);
    }
    return a(paramInt, paramd);
  }
  
  private int a(int paramInt, d paramd)
  {
    View localView = c();
    g localg = new g(this, b(((LayoutParams)localView.getLayoutParams()).d(), a.b, paramd));
    int i = a(localg).a(paramInt, localView, localg, paramd);
    int j = a(a(localg.a), i);
    i = j;
    if (j <= paramInt) {
      i = a(paramInt, j, paramd);
    }
    return i;
  }
  
  private int a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return paramInt;
    }
    detachView(paramView);
    attachView(paramView, -1);
    return Math.max(paramInt, getDecoratedBottom(paramView));
  }
  
  private int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, g paramg, d paramd)
  {
    Rect localRect = a(this.d, paramg, paramd);
    if ((paramg.l.f()) && (!paramg.l.g()))
    {
      localRect.bottom = paramInt2;
      localRect.top = (localRect.bottom - paramg.g);
    }
    for (;;)
    {
      paramInt3 = paramInt2;
      if (paramg.l.i())
      {
        paramInt3 = paramInt2;
        if (localRect.top < paramInt1)
        {
          paramInt3 = paramInt2;
          if (paramg.a != paramd.a().getTargetScrollPosition())
          {
            localRect.top = paramInt1;
            localRect.bottom = (localRect.top + paramg.g);
            paramInt3 = paramInt2;
            if (paramg.l.f())
            {
              paramInt3 = paramInt2;
              if (!paramg.l.g()) {
                paramInt3 = paramInt2 - paramg.g;
              }
            }
          }
        }
      }
      if (localRect.bottom > paramInt4)
      {
        localRect.bottom = paramInt4;
        localRect.top = (localRect.bottom - paramg.g);
      }
      layoutDecorated(paramView, localRect.left, localRect.top, localRect.right, localRect.bottom);
      return Math.min(localRect.top, paramInt3);
      if (paramInt3 <= 0)
      {
        localRect.top = (paramInt2 + paramInt3);
        localRect.bottom = (localRect.top + paramg.g);
      }
      else
      {
        localRect.bottom = paramInt1;
        localRect.top = (localRect.bottom - paramg.g);
      }
    }
  }
  
  private int a(View paramView, int paramInt1, int paramInt2, g paramg, d paramd)
  {
    if (!paramg.b) {
      return paramInt2;
    }
    h localh = a(paramg);
    int k = b(paramg.a);
    int m = getHeight();
    int i;
    label48:
    View localView;
    Object localObject;
    if (k == -1)
    {
      i = 0;
      j = i;
      i = m;
      if (j < getChildCount())
      {
        localView = getChildAt(j);
        localObject = (LayoutParams)localView.getLayoutParams();
        if (((LayoutParams)localObject).d() == paramg.a) {
          break label241;
        }
        localObject = a(((LayoutParams)localObject).d(), j, a.a);
        if (localObject != null) {
          break label230;
        }
        i = getDecoratedTop(localView);
      }
      label121:
      if ((k != -1) || (!paramg.l.f()) || (paramg.l.g())) {
        break label274;
      }
    }
    label230:
    label241:
    label274:
    for (int j = i;; j = paramInt2)
    {
      if ((!paramg.l.f()) || (paramg.l.g()))
      {
        localView = localh.a(paramg.a, true);
        if (localView == null) {
          paramInt2 = 0;
        }
      }
      for (;;)
      {
        paramInt2 = a(paramView, paramInt1, j, paramInt2, i, paramg, paramd);
        a(paramView, paramInt1, paramg, paramd);
        return paramInt2;
        i = k;
        break;
        i = getDecoratedTop((View)localObject);
        break label121;
        j += 1;
        break label48;
        paramInt2 = localh.a(getPosition(localView), paramg, paramd);
        continue;
        paramInt2 = 0;
      }
    }
  }
  
  private Rect a(Rect paramRect, g paramg, d paramd)
  {
    int i = getPaddingLeft();
    int j = getPaddingRight();
    if (paramg.l.e())
    {
      if ((!paramg.l.g()) && (!paramg.l.f) && (paramg.k > 0))
      {
        if (paramd.c)
        {
          paramRect.left = (getWidth() - paramg.k - j);
          paramRect.right = (paramRect.left + paramg.f);
          return paramRect;
        }
        paramRect.right = (i + paramg.k);
        paramRect.left = (paramRect.right - paramg.f);
        return paramRect;
      }
      if (paramd.c)
      {
        paramRect.right = (getWidth() - j);
        paramRect.left = (paramRect.right - paramg.f);
        return paramRect;
      }
      paramRect.left = i;
      paramRect.right = (paramRect.left + paramg.f);
      return paramRect;
    }
    if (paramg.l.h())
    {
      if ((!paramg.l.g()) && (!paramg.l.e) && (paramg.j > 0))
      {
        if (paramd.c)
        {
          paramRect.right = (i + paramg.j);
          paramRect.left = (paramRect.right - paramg.f);
          return paramRect;
        }
        paramRect.left = (getWidth() - paramg.j - j);
        paramRect.right = (paramRect.left + paramg.f);
        return paramRect;
      }
      if (paramd.c)
      {
        paramRect.left = i;
        paramRect.right = (paramRect.left + paramg.f);
        return paramRect;
      }
      paramRect.right = (getWidth() - j);
      paramRect.left = (paramRect.right - paramg.f);
      return paramRect;
    }
    paramRect.left = i;
    paramRect.right = (paramRect.left + paramg.f);
    return paramRect;
  }
  
  private View a(int paramInt)
  {
    int i = getChildCount() - 1;
    for (;;)
    {
      View localView;
      LayoutParams localLayoutParams;
      if (i >= 0)
      {
        localView = getChildAt(i);
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.d() == paramInt) {}
      }
      else
      {
        return null;
      }
      if (localLayoutParams.a) {
        return localView;
      }
      i -= 1;
    }
  }
  
  private View a(int paramInt1, int paramInt2, a parama)
  {
    int i;
    if (parama == a.a) {
      i = 1;
    }
    for (;;)
    {
      if ((paramInt2 >= 0) && (paramInt2 < getChildCount()))
      {
        parama = getChildAt(paramInt2);
        if (getPosition(parama) == paramInt1)
        {
          return parama;
          i = -1;
          continue;
        }
        if (((LayoutParams)parama.getLayoutParams()).d() == paramInt1) {}
      }
      else
      {
        return null;
      }
      paramInt2 += i;
    }
  }
  
  private View a(int paramInt, a parama)
  {
    if (parama == a.b) {
      return a(paramInt);
    }
    return b(0, getChildCount() - 1, paramInt);
  }
  
  private h a(int paramInt, String paramString)
  {
    if (paramInt == -1) {
      return (h)this.f.get(paramString);
    }
    if (paramInt == 1) {
      return this.a;
    }
    if (paramInt == 2) {
      return this.b;
    }
    throw new b(paramInt);
  }
  
  private h a(LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams.h == -1) {
      return (h)this.f.get(paramLayoutParams.g);
    }
    if (paramLayoutParams.h == 1) {
      return this.a;
    }
    if (paramLayoutParams.h == 2) {
      return this.b;
    }
    throw new b(paramLayoutParams.h);
  }
  
  private h a(g paramg)
  {
    if (paramg.l.h == -1)
    {
      h localh2 = (h)this.f.get(paramg.d);
      localh1 = localh2;
      if (localh2 == null) {
        throw new c(paramg.d);
      }
    }
    else
    {
      if (paramg.l.h != 1) {
        break label67;
      }
    }
    for (h localh1 = this.a;; localh1 = this.b)
    {
      return localh1.b(paramg);
      label67:
      if (paramg.l.h != 2) {
        break;
      }
    }
    throw new b(paramg.l.h);
  }
  
  private void a(View paramView, int paramInt, g paramg, d paramd)
  {
    if ((paramd.b(paramg.a) != null) && (getDecoratedBottom(paramView) > paramInt))
    {
      addView(paramView, b(paramg.a) + 1);
      paramd.a(paramg.a);
    }
  }
  
  private void a(a parama, d paramd)
  {
    if (parama == a.a)
    {
      c(paramd);
      return;
    }
    b(paramd);
  }
  
  private boolean a(d paramd)
  {
    int m = paramd.a().getItemCount();
    if (getChildCount() == 0) {}
    label47:
    label77:
    label82:
    label88:
    label150:
    label153:
    for (;;)
    {
      return false;
      paramd = a();
      int i;
      int j;
      if (getPosition(paramd) == 0)
      {
        i = 1;
        if (getDecoratedTop(paramd) <= getPaddingTop()) {
          break label77;
        }
        j = 1;
        if (getDecoratedTop(paramd) != getPaddingTop()) {
          break label82;
        }
      }
      for (int k = 1;; k = 0)
      {
        if ((i == 0) || (j == 0)) {
          break label88;
        }
        return true;
        i = 0;
        break;
        j = 0;
        break label47;
      }
      if ((i == 0) || (k == 0))
      {
        paramd = b();
        if (getPosition(paramd) == m - 1)
        {
          i = 1;
          if (getDecoratedBottom(paramd) >= getHeight() - getPaddingBottom()) {
            break label150;
          }
        }
        for (j = 1;; j = 0)
        {
          if ((i == 0) || (j == 0)) {
            break label153;
          }
          return true;
          i = 0;
          break;
        }
      }
    }
  }
  
  private float b(RecyclerView.State paramState, boolean paramBoolean)
  {
    float f3 = getHeight();
    paramState = getChildAt(getChildCount() - 1);
    int i1 = getPosition(paramState);
    paramState = new g(this, paramState);
    SparseArray localSparseArray = new SparseArray();
    int j = 0;
    float f1 = 0.0F;
    int i = -1;
    int k = 1;
    View localView;
    LayoutParams localLayoutParams;
    int n;
    float f2;
    float f4;
    for (;;)
    {
      if (k <= getChildCount())
      {
        localView = getChildAt(getChildCount() - k);
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (paramState.a(localLayoutParams)) {}
      }
      else
      {
        return f1 - j - a(paramState).b(i, localSparseArray);
      }
      n = getPosition(localView);
      int m = j;
      if (!localLayoutParams.a)
      {
        m = j;
        if (!paramBoolean)
        {
          m = j;
          if (n > i1) {
            m = j + 1;
          }
        }
      }
      f2 = getDecoratedBottom(localView);
      f4 = getDecoratedTop(localView);
      if (f2 > f3) {
        break;
      }
      f2 = f1;
      j = i;
      k += 1;
      i = j;
      f1 = f2;
      j = m;
    }
    if (f3 < f4) {}
    for (f1 += 1.0F;; f1 += (f2 - f3) / getDecoratedMeasuredHeight(localView))
    {
      j = i;
      f2 = f1;
      if (localLayoutParams.a) {
        break;
      }
      j = i;
      if (i == -1) {
        j = n;
      }
      localSparseArray.put(n, Boolean.valueOf(true));
      f2 = f1;
      break;
    }
  }
  
  private int b(int paramInt)
  {
    return a(0, getChildCount() - 1, paramInt);
  }
  
  private int b(int paramInt1, int paramInt2, d paramd)
  {
    if (paramInt2 < paramInt1) {
      return paramInt2;
    }
    Object localObject1 = d();
    Object localObject2 = a(((LayoutParams)((View)localObject1).getLayoutParams()).c(), 0, a.a);
    label49:
    View localView1;
    if (localObject2 != null)
    {
      i = getPosition((View)localObject2) - 1;
      if (i < 0) {
        break label250;
      }
      localView1 = b(paramd.c(i).a().d(), a.a, paramd);
      localObject2 = new g(this, localView1);
      localObject1 = localObject2;
      if (((g)localObject2).b)
      {
        a(localView1);
        localObject1 = new g(this, localView1);
      }
      localObject2 = a((g)localObject1);
      if (i < 0) {
        break label271;
      }
    }
    label250:
    label252:
    label271:
    for (int i = ((h)localObject2).b(paramInt1, paramInt2, i, (g)localObject1, paramd);; i = paramInt2)
    {
      int j = i;
      View localView2;
      if (((g)localObject1).b)
      {
        j = 0;
        if ((!((g)localObject1).l.f()) || (((g)localObject1).l.g()))
        {
          localView2 = ((h)localObject2).a(((g)localObject1).a, true);
          if (localView2 != null) {
            break label252;
          }
        }
      }
      for (j = 0;; j = ((h)localObject2).a(getPosition(localView2), (g)localObject1, paramd))
      {
        j = a(localView1, paramInt1, i, j, paramInt2, (g)localObject1, paramd);
        a(localView1, paramInt1, (g)localObject1, paramd);
        return b(paramInt1, j, paramd);
        i = getPosition((View)localObject1) - 1;
        break label49;
        break;
      }
    }
  }
  
  private int b(int paramInt, d paramd)
  {
    View localView1 = d();
    View localView2 = b(((LayoutParams)localView1.getLayoutParams()).d(), a.a, paramd);
    g localg = new g(this, localView2);
    h localh = a(localg);
    int i = getPosition(localView1);
    if (i == localg.a) {
      i = getDecoratedTop(localView1);
    }
    for (;;)
    {
      int j = a(localView2, paramInt, i, localg, paramd);
      i = j;
      if (j > paramInt) {
        i = b(paramInt, j, paramd);
      }
      return i;
      if ((i - 1 == localg.a) && (localg.b)) {
        i = getDecoratedTop(localView1);
      } else {
        i = localh.b(paramInt, localView1, localg, paramd);
      }
    }
  }
  
  private int b(View paramView, int paramInt, g paramg, d paramd)
  {
    paramd = a(this.d, paramg, paramd);
    paramd.top = paramInt;
    paramd.bottom = (paramd.top + paramg.g);
    int i = paramInt;
    if (paramg.l.f())
    {
      i = paramInt;
      if (!paramg.l.g()) {
        i = paramd.bottom;
      }
    }
    if ((paramg.l.i()) && (paramd.top < 0))
    {
      paramd.top = 0;
      paramd.bottom = (paramd.top + paramg.g);
    }
    layoutDecorated(paramView, paramd.left, paramd.top, paramd.right, paramd.bottom);
    return i;
  }
  
  private View b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 < paramInt1) {
      return null;
    }
    int i = paramInt1 + (paramInt2 - paramInt1) / 2;
    View localView = getChildAt(i);
    LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
    if (localLayoutParams.d() != paramInt3) {
      return b(paramInt1, i - 1, paramInt3);
    }
    if (localLayoutParams.a) {
      return localView;
    }
    return b(i + 1, paramInt2, paramInt3);
  }
  
  private View b(int paramInt, a parama, d paramd)
  {
    if (parama == a.a) {}
    for (int i = 0;; i = getChildCount() - 1)
    {
      Object localObject = a(paramInt, i, parama);
      parama = (a)localObject;
      if (localObject == null)
      {
        localObject = paramd.c(paramInt);
        parama = ((d.a)localObject).a;
        if (((d.a)localObject).a().a) {
          a(((d.a)localObject).a);
        }
        paramd.a(paramInt, parama);
      }
      return parama;
    }
  }
  
  private void b(View paramView)
  {
    int i = 0;
    g localg = new g(this, paramView);
    if (!localg.l.i()) {}
    int j;
    int i1;
    do
    {
      do
      {
        return;
        j = b(localg.a);
      } while (j == -1);
      h localh = a(localg);
      j = localh.a(localg.a, j, getHeight());
      k = localh.b(localg.a, 0, 0);
      i1 = getDecoratedMeasuredHeight(paramView);
    } while (((!localg.l.f()) || (localg.l.g())) && (j - k < i1));
    int m = getDecoratedLeft(paramView);
    int n = getDecoratedRight(paramView);
    int k = 0 + i1;
    if (k > j) {
      i = j - i1;
    }
    for (;;)
    {
      layoutDecorated(paramView, m, i, n, j);
      return;
      j = k;
    }
  }
  
  private void b(d paramd)
  {
    int j = getHeight();
    int i = getChildCount() - 1;
    if (i >= 0)
    {
      View localView = getChildAt(i);
      if (getDecoratedTop(localView) >= j) {
        removeAndRecycleView(localView, paramd.a);
      }
      while (((LayoutParams)localView.getLayoutParams()).a)
      {
        i -= 1;
        break;
      }
    }
  }
  
  private int c(int paramInt)
  {
    int i = 1;
    g localg = new g(this, getChildAt(0));
    if (paramInt < getPosition(a(localg).a(localg.a, true))) {
      i = -1;
    }
    return i;
  }
  
  private int c(int paramInt1, int paramInt2, d paramd)
  {
    int k = getHeight();
    d.a locala = paramd.c(paramInt1);
    paramd.a(paramInt1, locala.a);
    int i = locala.a().d();
    locala = paramd.c(i);
    a(locala.a);
    paramd.a(i, locala.a);
    g localg = new g(this, locala.a);
    h localh = a(localg);
    int j;
    if ((localg.b) && (paramInt1 == localg.a))
    {
      j = b(locala.a, paramInt2, localg, paramd);
      i = paramInt1 + 1;
    }
    for (;;)
    {
      j = localh.a(k, j, i, localg, paramd);
      if ((localg.b) && (paramInt1 != localg.a))
      {
        paramInt1 = localh.a(i, localg, paramd);
        a(locala.a, 0, paramInt2, paramInt1, j, localg, paramd);
      }
      for (paramInt1 = j;; paramInt1 = Math.max(j, getDecoratedBottom(locala.a)))
      {
        if ((localg.b) && (getDecoratedBottom(locala.a) > 0))
        {
          addView(locala.a);
          paramd.a(localg.a);
        }
        return a(k, paramInt1, paramd);
      }
      i = paramInt1;
      j = paramInt2;
    }
  }
  
  private View c()
  {
    if (getChildCount() == 1) {
      return getChildAt(0);
    }
    View localView1 = getChildAt(getChildCount() - 1);
    LayoutParams localLayoutParams = (LayoutParams)localView1.getLayoutParams();
    if (localLayoutParams.a)
    {
      View localView2 = getChildAt(getChildCount() - 2);
      if (((LayoutParams)localView2.getLayoutParams()).d() == localLayoutParams.d()) {
        return localView2;
      }
    }
    return localView1;
  }
  
  private void c(int paramInt, d paramd)
  {
    if (!a(paramd)) {}
    do
    {
      return;
      offsetChildrenVertical(getHeight() - getPaddingBottom() - paramInt);
      paramInt = b(0, paramd);
    } while (paramInt <= getPaddingTop());
    offsetChildrenVertical(getPaddingTop() - paramInt);
  }
  
  private void c(d paramd)
  {
    int i = 0;
    Object localObject;
    if (i < getChildCount())
    {
      localObject = getChildAt(i);
      if (getDecoratedBottom((View)localObject) <= 0) {}
    }
    for (;;)
    {
      if (localObject == null)
      {
        detachAndScrapAttachedViews(paramd.a);
        return;
        i += 1;
        break;
      }
      localObject = (LayoutParams)((View)localObject).getLayoutParams();
      int j;
      if (((LayoutParams)localObject).a)
      {
        j = i - 1;
        if (j >= 0)
        {
          LayoutParams localLayoutParams = (LayoutParams)getChildAt(j).getLayoutParams();
          if (localLayoutParams.d() == ((LayoutParams)localObject).d())
          {
            localObject = localLayoutParams;
            i = j;
          }
        }
      }
      for (;;)
      {
        j = 0;
        for (;;)
        {
          if (j < i)
          {
            removeAndRecycleViewAt(0, paramd.a);
            j += 1;
            continue;
            j -= 1;
            break;
          }
        }
        localObject = a(((LayoutParams)localObject).d(), a.a);
        if (localObject == null) {
          break;
        }
        if (getDecoratedTop((View)localObject) < 0) {
          b((View)localObject);
        }
        if (getDecoratedBottom((View)localObject) > 0) {
          break;
        }
        removeAndRecycleView((View)localObject, paramd.a);
        return;
      }
      i = 0;
      localObject = null;
    }
  }
  
  private View d()
  {
    View localView = getChildAt(0);
    Object localObject = (LayoutParams)localView.getLayoutParams();
    int i = ((LayoutParams)localObject).d();
    if (!((LayoutParams)localObject).a) {
      return localView;
    }
    if (1 < getChildCount())
    {
      localObject = getChildAt(1);
      if (((LayoutParams)((View)localObject).getLayoutParams()).d() == i) {
        return (View)localObject;
      }
    }
    return localView;
  }
  
  private View e()
  {
    if (getChildCount() == 0) {
      return null;
    }
    View localView1 = getChildAt(0);
    int i = ((LayoutParams)localView1.getLayoutParams()).d();
    View localView2 = a(i, 0, a.a);
    if (localView2 == null) {
      return localView1;
    }
    LayoutParams localLayoutParams = (LayoutParams)localView2.getLayoutParams();
    if (!localLayoutParams.a) {
      return localView1;
    }
    if ((localLayoutParams.f()) && (!localLayoutParams.g()))
    {
      if (getDecoratedBottom(localView2) <= getDecoratedTop(localView1)) {
        return localView2;
      }
      return localView1;
    }
    if (getDecoratedTop(localView1) < getDecoratedTop(localView2)) {
      return localView1;
    }
    if (i + 1 == getPosition(localView1)) {
      return localView2;
    }
    return localView1;
  }
  
  int a(View paramView, a parama)
  {
    if (paramView == null)
    {
      if (parama == a.a) {
        return getPaddingBottom();
      }
      return getPaddingTop();
    }
    if (parama == a.a) {
      return getDecoratedBottom(paramView);
    }
    return getDecoratedTop(paramView);
  }
  
  public View a()
  {
    Object localObject = new g(this, getChildAt(0));
    View localView = a((g)localObject).a(((g)localObject).a, false);
    int i = getPosition(localView);
    if ((i > ((g)localObject).a + 1) || (i == ((g)localObject).a)) {
      return localView;
    }
    localObject = a(((g)localObject).a, 0, a.a);
    if (localObject == null) {
      return localView;
    }
    if (getDecoratedBottom((View)localObject) <= getDecoratedTop(localView)) {
      return (View)localObject;
    }
    LayoutParams localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
    if (((!localLayoutParams.f()) || (localLayoutParams.g())) && (getDecoratedTop((View)localObject) == getDecoratedTop(localView))) {
      return (View)localObject;
    }
    return localView;
  }
  
  public LayoutParams a(ViewGroup.LayoutParams paramLayoutParams)
  {
    paramLayoutParams = LayoutParams.b(paramLayoutParams);
    paramLayoutParams.width = -1;
    paramLayoutParams.height = -1;
    return a(paramLayoutParams).a(paramLayoutParams);
  }
  
  void a(View paramView)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = getWidth() - getPaddingStart() - getPaddingEnd();
    if (!localLayoutParams.g()) {
      if ((localLayoutParams.h()) && (!localLayoutParams.e)) {
        i -= localLayoutParams.d;
      }
    }
    for (;;)
    {
      measureChildWithMargins(paramView, i, 0);
      return;
      if ((localLayoutParams.e()) && (!localLayoutParams.f)) {
        i -= localLayoutParams.c;
      } else {
        i = 0;
      }
    }
  }
  
  public View b()
  {
    g localg = new g(this, getChildAt(getChildCount() - 1));
    return a(localg).c(localg.a);
  }
  
  public boolean canScrollVertically()
  {
    return true;
  }
  
  public int computeVerticalScrollExtent(RecyclerView.State paramState)
  {
    if ((getChildCount() == 0) || (paramState.getItemCount() == 0)) {
      return 0;
    }
    if (!this.g) {
      return getChildCount();
    }
    return (int)((getChildCount() - a(paramState, true) - b(paramState, true)) / paramState.getItemCount() * getHeight());
  }
  
  public int computeVerticalScrollOffset(RecyclerView.State paramState)
  {
    if ((getChildCount() == 0) || (paramState.getItemCount() == 0)) {
      return 0;
    }
    View localView = getChildAt(0);
    if (!this.g) {
      return getPosition(localView);
    }
    float f1 = getPosition(localView);
    return (int)((a(paramState, false) + f1) / paramState.getItemCount() * getHeight());
  }
  
  public int computeVerticalScrollRange(RecyclerView.State paramState)
  {
    if (!this.g) {
      return paramState.getItemCount();
    }
    return getHeight();
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-2, -2);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    int k = 0;
    int i = 0;
    int j = 1;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, f.a.superslim_LayoutManager);
    Object localObject;
    if (Build.VERSION.SDK_INT < 21)
    {
      localObject = new TypedValue();
      localTypedArray.getValue(f.a.superslim_LayoutManager_slm_section_sectionManager, (TypedValue)localObject);
      if (((TypedValue)localObject).type == 3) {
        i = 1;
      }
      localObject = null;
      if (i == 0) {
        break label129;
      }
      localObject = localTypedArray.getString(f.a.superslim_LayoutManager_slm_section_sectionManager);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label123;
      }
      i = j;
    }
    for (;;)
    {
      localTypedArray.recycle();
      return a(i, (String)localObject).a(paramContext, paramAttributeSet);
      i = k;
      if (localTypedArray.getType(f.a.superslim_LayoutManager_slm_section_sectionManager) == 3) {
        i = 1;
      }
      break;
      label123:
      i = -1;
      continue;
      label129:
      i = localTypedArray.getInt(f.a.superslim_LayoutManager_slm_section_sectionManager, 1);
    }
  }
  
  public int getDecoratedBottom(View paramView)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = super.getDecoratedBottom(paramView);
    return localMarginLayoutParams.bottomMargin + i;
  }
  
  public int getDecoratedLeft(View paramView)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    return super.getDecoratedLeft(paramView) - localMarginLayoutParams.leftMargin;
  }
  
  public int getDecoratedMeasuredHeight(View paramView)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = super.getDecoratedMeasuredHeight(paramView);
    int j = localMarginLayoutParams.topMargin;
    return localMarginLayoutParams.bottomMargin + (i + j);
  }
  
  public int getDecoratedMeasuredWidth(View paramView)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = super.getDecoratedMeasuredWidth(paramView);
    int j = localMarginLayoutParams.leftMargin;
    return localMarginLayoutParams.rightMargin + (i + j);
  }
  
  public int getDecoratedRight(View paramView)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = super.getDecoratedRight(paramView);
    return localMarginLayoutParams.rightMargin + i;
  }
  
  public int getDecoratedTop(View paramView)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    return super.getDecoratedTop(paramView) - localMarginLayoutParams.topMargin;
  }
  
  public void layoutDecorated(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    super.layoutDecorated(paramView, paramInt1 + localMarginLayoutParams.leftMargin, paramInt2 + localMarginLayoutParams.topMargin, paramInt3 - localMarginLayoutParams.rightMargin, paramInt4 - localMarginLayoutParams.bottomMargin);
  }
  
  public void onAdapterChanged(RecyclerView.Adapter paramAdapter1, RecyclerView.Adapter paramAdapter2)
  {
    removeAllViews();
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView)
  {
    paramRecyclerView = e();
    if (paramRecyclerView == null)
    {
      this.c = -1;
      this.e = 0;
      return;
    }
    this.c = getPosition(paramRecyclerView);
    this.e = getDecoratedTop(paramRecyclerView);
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onItemsUpdated(paramRecyclerView, paramInt1, paramInt2);
    paramRecyclerView = getChildAt(0);
    View localView = getChildAt(getChildCount() - 1);
    if (paramInt1 + paramInt2 <= getPosition(paramRecyclerView)) {}
    while (paramInt1 > getPosition(localView)) {
      return;
    }
    requestLayout();
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    int i = 0;
    int j = paramState.getItemCount();
    if (j == 0)
    {
      detachAndScrapAttachedViews(paramRecycler);
      return;
    }
    int k;
    if (this.c != -1)
    {
      k = Math.min(this.c, j - 1);
      this.c = -1;
      i = this.e;
      this.e = 0;
      j = i;
      detachAndScrapAttachedViews(paramRecycler);
      paramRecycler = new d(this, paramRecycler, paramState);
      c(c(k, j, paramRecycler), paramRecycler);
      return;
    }
    View localView = e();
    if (localView == null) {}
    for (;;)
    {
      j = a(localView, a.b);
      k = i;
      break;
      i = Math.min(getPosition(localView), j - 1);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    this.c = ((SavedState)paramParcelable).a;
    this.e = ((SavedState)paramParcelable).b;
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState();
    View localView = e();
    if (localView == null)
    {
      localSavedState.a = 0;
      localSavedState.b = 0;
      return localSavedState;
    }
    localSavedState.a = getPosition(localView);
    localSavedState.b = getDecoratedTop(localView);
    return localSavedState;
  }
  
  public void scrollToPosition(int paramInt)
  {
    if ((paramInt < 0) || (getItemCount() <= paramInt))
    {
      Log.e("SuperSLiM.LayoutManager", "Ignored scroll to " + paramInt + " as it is not within the item range 0 - " + getItemCount());
      return;
    }
    this.c = paramInt;
    requestLayout();
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (getChildCount() == 0) {}
    d locald;
    int j;
    label39:
    int k;
    label56:
    View localView;
    LayoutParams localLayoutParams;
    do
    {
      return 0;
      locald = new d(this, paramRecycler, paramState);
      if (paramInt <= 0) {
        break label205;
      }
      paramRecycler = a.b;
      if (paramRecycler != a.b) {
        break label212;
      }
      j = 1;
      k = getHeight();
      if (j == 0) {
        break label218;
      }
      i = k + paramInt;
      if (j == 0) {
        break;
      }
      localView = c();
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
    } while ((a(localLayoutParams).a(localLayoutParams.d(), getChildCount() - 1, getDecoratedBottom(localView)) < k - getPaddingBottom()) && (getPosition(localView) == paramState.getItemCount() - 1));
    int i = a(i, paramRecycler, locald);
    if (j != 0)
    {
      k = i - k + getPaddingBottom();
      i = paramInt;
      if (k < paramInt) {
        i = k;
      }
      label169:
      if (i != 0)
      {
        offsetChildrenVertical(-i);
        if (j == 0) {
          break label249;
        }
      }
    }
    label205:
    label212:
    label218:
    label249:
    for (paramRecycler = a.a;; paramRecycler = a.b)
    {
      a(paramRecycler, locald);
      locald.b();
      return i;
      paramRecycler = a.a;
      break;
      j = 0;
      break label39;
      i = paramInt;
      break label56;
      k = i - getPaddingTop();
      i = paramInt;
      if (k > paramInt) {
        i = k;
      }
      break label169;
    }
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt)
  {
    if ((paramInt < 0) || (getItemCount() <= paramInt))
    {
      Log.e("SuperSLiM.LayoutManager", "Ignored smooth scroll to " + paramInt + " as it is not within the item range 0 - " + getItemCount());
      return;
    }
    requestLayout();
    paramRecyclerView.getHandler().post(new a(this, paramRecyclerView, paramInt));
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
  {
    public boolean a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public boolean f;
    String g;
    int h = 1;
    private int i;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      this.a = false;
    }
    
    @TargetApi(21)
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, f.a.superslim_LayoutManager);
      this.a = paramContext.getBoolean(f.a.superslim_LayoutManager_slm_isHeader, false);
      this.b = paramContext.getInt(f.a.superslim_LayoutManager_slm_headerDisplay, 17);
      this.i = paramContext.getInt(f.a.superslim_LayoutManager_slm_section_firstPosition, -1);
      if (Build.VERSION.SDK_INT < 21)
      {
        paramAttributeSet = new TypedValue();
        paramContext.getValue(f.a.superslim_LayoutManager_slm_section_headerMarginStart, paramAttributeSet);
        if (paramAttributeSet.type == 5)
        {
          bool1 = true;
          b(paramContext, bool1);
          paramContext.getValue(f.a.superslim_LayoutManager_slm_section_headerMarginEnd, paramAttributeSet);
          if (paramAttributeSet.type != 5) {
            break label165;
          }
          bool1 = true;
          label123:
          a(paramContext, bool1);
          paramContext.getValue(f.a.superslim_LayoutManager_slm_section_sectionManager, paramAttributeSet);
          if (paramAttributeSet.type != 3) {
            break label170;
          }
        }
        label165:
        label170:
        for (bool1 = bool2;; bool1 = false)
        {
          c(paramContext, bool1);
          paramContext.recycle();
          return;
          bool1 = false;
          break;
          bool1 = false;
          break label123;
        }
      }
      if (paramContext.getType(f.a.superslim_LayoutManager_slm_section_headerMarginStart) == 5)
      {
        bool1 = true;
        label188:
        b(paramContext, bool1);
        if (paramContext.getType(f.a.superslim_LayoutManager_slm_section_headerMarginEnd) != 5) {
          break label241;
        }
        bool1 = true;
        label207:
        a(paramContext, bool1);
        if (paramContext.getType(f.a.superslim_LayoutManager_slm_section_sectionManager) != 3) {
          break label246;
        }
      }
      label241:
      label246:
      for (boolean bool1 = bool3;; bool1 = false)
      {
        c(paramContext, bool1);
        break;
        bool1 = false;
        break label188;
        bool1 = false;
        break label207;
      }
    }
    
    @Deprecated
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      a(paramLayoutParams);
    }
    
    @Deprecated
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      a(paramMarginLayoutParams);
    }
    
    private void a(TypedArray paramTypedArray, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.f = false;
        this.c = paramTypedArray.getDimensionPixelSize(f.a.superslim_LayoutManager_slm_section_headerMarginEnd, 0);
        return;
      }
      this.f = true;
    }
    
    private void a(ViewGroup.LayoutParams paramLayoutParams)
    {
      if ((paramLayoutParams instanceof LayoutParams))
      {
        paramLayoutParams = (LayoutParams)paramLayoutParams;
        this.a = paramLayoutParams.a;
        this.b = paramLayoutParams.b;
        this.i = paramLayoutParams.i;
        this.g = paramLayoutParams.g;
        this.h = paramLayoutParams.h;
        this.c = paramLayoutParams.c;
        this.d = paramLayoutParams.d;
        this.f = paramLayoutParams.f;
        this.e = paramLayoutParams.e;
        return;
      }
      this.a = false;
      this.b = 17;
      this.c = -1;
      this.d = -1;
      this.e = true;
      this.f = true;
      this.h = 1;
    }
    
    public static LayoutParams b(ViewGroup.LayoutParams paramLayoutParams)
    {
      if (paramLayoutParams == null)
      {
        Log.w("SuperSLiM", "Null value passed in call to LayoutManager.LayoutParams.from().");
        return new LayoutParams(-2, -2);
      }
      if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      }
      return new LayoutParams(paramLayoutParams);
    }
    
    private void b(TypedArray paramTypedArray, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.e = false;
        this.d = paramTypedArray.getDimensionPixelSize(f.a.superslim_LayoutManager_slm_section_headerMarginStart, 0);
        return;
      }
      this.e = true;
    }
    
    private void c(TypedArray paramTypedArray, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.g = paramTypedArray.getString(f.a.superslim_LayoutManager_slm_section_sectionManager);
        if (TextUtils.isEmpty(this.g))
        {
          this.h = 1;
          return;
        }
        this.h = -1;
        return;
      }
      this.h = paramTypedArray.getInt(f.a.superslim_LayoutManager_slm_section_sectionManager, 1);
    }
    
    public void b(int paramInt)
    {
      if (paramInt < 0) {
        throw new a();
      }
      this.i = paramInt;
    }
    
    public int c()
    {
      return this.i;
    }
    
    public void c(int paramInt)
    {
      this.h = paramInt;
    }
    
    public int d()
    {
      if (this.i == -1) {
        throw new b();
      }
      return this.i;
    }
    
    public boolean e()
    {
      return (this.b & 0x4) != 0;
    }
    
    public boolean f()
    {
      return (this.b & 0x1) != 0;
    }
    
    public boolean g()
    {
      return (this.b & 0x8) != 0;
    }
    
    public boolean h()
    {
      return (this.b & 0x2) != 0;
    }
    
    public boolean i()
    {
      return (this.b & 0x10) != 0;
    }
    
    @Retention(RetentionPolicy.SOURCE)
    @IntDef
    public static @interface HeaderDisplayOptions {}
    
    private class a
      extends RuntimeException
    {
      a()
      {
        super();
      }
    }
    
    private class b
      extends RuntimeException
    {
      b()
      {
        super();
      }
    }
  }
  
  protected static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new c();
    public int a;
    public int b;
    
    protected SavedState() {}
    
    protected SavedState(Parcel paramParcel)
    {
      this.a = paramParcel.readInt();
      this.b = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.a);
      paramParcel.writeInt(this.b);
    }
  }
  
  public static enum a
  {
    private a() {}
  }
  
  private class b
    extends RuntimeException
  {
    public b(int paramInt)
    {
      super();
    }
  }
  
  private class c
    extends RuntimeException
  {
    public c(String paramString)
    {
      super();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\tonicartos\superslim\LayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */