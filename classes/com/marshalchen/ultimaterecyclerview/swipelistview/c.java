package com.marshalchen.ultimaterecyclerview.swipelistview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.c.a.ad;
import com.c.c.a;
import com.c.c.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class c
  implements View.OnTouchListener
{
  private View A;
  private View B;
  private View C;
  private boolean D;
  private int E = 3;
  private int F = 0;
  private int G = 0;
  private List<Boolean> H = new ArrayList();
  private List<Boolean> I = new ArrayList();
  private boolean J;
  private List<Boolean> K = new ArrayList();
  private int L;
  private int M;
  private int a = 1;
  private boolean b = true;
  private boolean c = true;
  private int d = 0;
  private int e = 0;
  private Rect f = new Rect();
  private int g;
  private int h;
  private int i;
  private long j;
  private long k;
  private float l = 0.0F;
  private float m = 0.0F;
  private int n = 0;
  private int o = 0;
  private boolean p = false;
  private LinearLayoutManager q;
  private SwipeListView r;
  private int s = 1;
  private List<a> t = new ArrayList();
  private int u = 0;
  private float v;
  private boolean w;
  private boolean x;
  private VelocityTracker y;
  private int z;
  
  public c(SwipeListView paramSwipeListView, int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramSwipeListView.getContext());
    this.g = localViewConfiguration.getScaledTouchSlop();
    this.h = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.i = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.j = paramSwipeListView.getContext().getResources().getInteger(17694720);
    this.k = this.j;
    this.r = paramSwipeListView;
  }
  
  private void a(View paramView)
  {
    this.A = paramView;
  }
  
  private void a(View paramView, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (this.E == 0) {
      c(paramView, paramBoolean1, paramBoolean2, paramInt);
    }
    if (this.E == 1) {
      b(this.A, paramBoolean1, paramBoolean2, paramInt);
    }
    if (this.E == 2) {
      e(paramView, paramInt);
    }
  }
  
  public static void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int i2 = paramViewGroup.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = paramViewGroup.getChildAt(i1);
      localView.setEnabled(paramBoolean);
      if ((localView instanceof ViewGroup)) {
        a((ViewGroup)localView, paramBoolean);
      }
      i1 += 1;
    }
  }
  
  private void b(View paramView)
  {
    this.C = paramView;
    paramView.setOnClickListener(new g(this));
  }
  
  private void b(View paramView, int paramInt)
  {
    this.B = paramView;
    paramView.setOnClickListener(new d(this));
    paramView.setOnLongClickListener(new f(this, paramInt));
  }
  
  private void b(View paramView, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int i1;
    if (((Boolean)this.H.get(paramInt)).booleanValue())
    {
      if (paramBoolean1) {
        break label175;
      }
      if (((Boolean)this.I.get(paramInt)).booleanValue()) {
        i1 = (int)(this.s - this.m);
      }
    }
    for (;;)
    {
      int i2 = 1;
      if (paramBoolean1)
      {
        this.u += 1;
        i2 = 0;
      }
      b.a(paramView).a(i1).b(i2).a(this.k).a(new i(this, paramBoolean1, paramView, paramInt));
      return;
      i1 = (int)(-this.s + this.l);
      continue;
      if (paramBoolean1)
      {
        if (paramBoolean2) {}
        for (i1 = (int)(this.s - this.m);; i1 = (int)(-this.s + this.l)) {
          break;
        }
      }
      label175:
      i1 = 0;
    }
  }
  
  private void c(View paramView, int paramInt)
  {
    if (!((Boolean)this.H.get(paramInt)).booleanValue()) {
      c(paramView, true, false, paramInt);
    }
  }
  
  private void c(View paramView, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int i1;
    if (((Boolean)this.H.get(paramInt)).booleanValue())
    {
      if (paramBoolean1) {
        break label224;
      }
      if (((Boolean)this.I.get(paramInt)).booleanValue()) {
        i1 = (int)(this.s - this.m);
      }
    }
    for (;;)
    {
      if (!((Boolean)this.H.get(paramInt)).booleanValue()) {}
      for (boolean bool = true;; bool = false)
      {
        if ((this.p) && (paramBoolean1))
        {
          this.H.set(paramInt, Boolean.valueOf(bool));
          this.I.set(paramInt, Boolean.valueOf(paramBoolean2));
        }
        b.a(paramView).a(i1).a(this.k).a(new j(this, paramBoolean1, bool, paramInt, paramBoolean2));
        return;
        i1 = (int)(-this.s + this.l);
        break;
        if (!paramBoolean1) {
          break label224;
        }
        if (paramBoolean2) {}
        for (i1 = (int)(this.s - this.m);; i1 = (int)(-this.s + this.l)) {
          break;
        }
      }
      label224:
      i1 = 0;
    }
  }
  
  private void d(View paramView, int paramInt)
  {
    if (((Boolean)this.H.get(paramInt)).booleanValue()) {
      c(paramView, true, false, paramInt);
    }
  }
  
  private void e(View paramView, int paramInt)
  {
    b.a(paramView).a(0.0F).a(this.k).a(new h(this));
  }
  
  private void h(int paramInt)
  {
    boolean bool2 = true;
    int i2 = e();
    boolean bool3 = ((Boolean)this.K.get(paramInt)).booleanValue();
    Object localObject = this.K;
    int i1;
    if (!bool3)
    {
      bool1 = true;
      ((List)localObject).set(paramInt, Boolean.valueOf(bool1));
      if (!bool3) {
        break label147;
      }
      i1 = i2 - 1;
      label63:
      if ((i2 == 0) && (i1 == 1))
      {
        this.r.a();
        h();
        i(2);
      }
      if ((i2 == 1) && (i1 == 0))
      {
        this.r.b();
        i();
      }
      localObject = this.r;
      if (bool3) {
        break label155;
      }
    }
    label147:
    label155:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((SwipeListView)localObject).d(paramInt, bool1);
      a(this.B, paramInt);
      return;
      bool1 = false;
      break;
      i1 = i2 + 1;
      break label63;
    }
  }
  
  private void i(int paramInt)
  {
    this.L = this.G;
    this.M = this.F;
    this.G = paramInt;
    this.F = paramInt;
  }
  
  private void j(int paramInt)
  {
    Collections.sort(this.t);
    Object localObject = new int[this.t.size()];
    int i1 = this.t.size() - 1;
    while (i1 >= 0)
    {
      localObject[i1] = ((a)this.t.get(i1)).a;
      i1 -= 1;
    }
    this.r.a((int[])localObject);
    localObject = this.t.iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if (locala.b != null)
      {
        a.a(locala.b, 1.0F);
        a.b(locala.b, 0.0F);
        ViewGroup.LayoutParams localLayoutParams = locala.b.getLayoutParams();
        localLayoutParams.height = paramInt;
        locala.b.setLayoutParams(localLayoutParams);
      }
    }
    j();
  }
  
  private void k()
  {
    if (this.z != -1)
    {
      if (this.E == 2) {
        this.C.setVisibility(0);
      }
      this.B.setClickable(((Boolean)this.H.get(this.z)).booleanValue());
      this.B.setLongClickable(((Boolean)this.H.get(this.z)).booleanValue());
      this.B = null;
      this.C = null;
      this.z = -1;
    }
  }
  
  private void l()
  {
    if ((this.H != null) && (this.z != -1))
    {
      int i2 = this.q.findFirstVisibleItemPosition();
      int i3 = this.q.findLastVisibleItemPosition();
      int i1 = i2;
      while (i1 <= i3)
      {
        if ((((Boolean)this.H.get(i1)).booleanValue()) && (i1 != this.z)) {
          d(this.r.getChildAt(i1 - i2).findViewById(this.d), i1);
        }
        i1 += 1;
      }
    }
  }
  
  public void a(float paramFloat)
  {
    this.m = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(long paramLong)
  {
    if (paramLong > 0L)
    {
      this.k = paramLong;
      return;
    }
    this.k = this.j;
  }
  
  public void a(LinearLayoutManager paramLinearLayoutManager)
  {
    this.q = paramLinearLayoutManager;
  }
  
  protected void a(View paramView, int paramInt)
  {
    if (g(paramInt)) {
      if (this.n > 0) {
        paramView.setBackgroundResource(this.n);
      }
    }
    while (this.o <= 0) {
      return;
    }
    paramView.setBackgroundResource(this.o);
  }
  
  protected void a(View paramView, int paramInt, boolean paramBoolean)
  {
    a((ViewGroup)paramView, false);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    int i1 = paramView.getHeight();
    ad localad = ad.b(new int[] { i1, 1 }).c(this.k);
    if (paramBoolean) {
      localad.a(new m(this, i1));
    }
    localad.a(new n(this, paramView));
    localad.a(new e(this, localLayoutParams, paramView));
    this.t.add(new a(paramInt, paramView));
    localad.a();
  }
  
  public void a(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  protected boolean a()
  {
    return this.a != 0;
  }
  
  public int b()
  {
    return this.F;
  }
  
  public void b(float paramFloat)
  {
    this.l = paramFloat;
  }
  
  public void b(int paramInt)
  {
    this.F = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public int c()
  {
    return this.G;
  }
  
  public void c(float paramFloat)
  {
    this.r.a(this.z, paramFloat);
    float f2 = a.a(this.B);
    float f1 = f2;
    boolean bool;
    if (((Boolean)this.H.get(this.z)).booleanValue())
    {
      if (((Boolean)this.I.get(this.z)).booleanValue())
      {
        f1 = -this.s + this.m;
        f1 += f2;
      }
    }
    else
    {
      if ((f1 > 0.0F) && (!this.x))
      {
        if (this.x) {
          break label250;
        }
        bool = true;
        label105:
        this.x = bool;
        this.E = this.G;
        if (this.E != 2) {
          break label256;
        }
        this.C.setVisibility(8);
      }
      label136:
      if ((f1 < 0.0F) && (this.x))
      {
        if (this.x) {
          break label267;
        }
        bool = true;
        label159:
        this.x = bool;
        this.E = this.F;
        if (this.E != 2) {
          break label273;
        }
        this.C.setVisibility(8);
      }
      label190:
      if (this.E != 1) {
        break label284;
      }
      a.b(this.A, paramFloat);
      a.a(this.A, Math.max(0.0F, Math.min(1.0F, 1.0F - 2.0F * Math.abs(paramFloat) / this.s)));
    }
    label250:
    label256:
    label267:
    label273:
    label284:
    do
    {
      return;
      f1 = this.s - this.l;
      break;
      bool = false;
      break label105;
      this.C.setVisibility(0);
      break label136;
      bool = false;
      break label159;
      this.C.setVisibility(0);
      break label190;
      if (this.E != 2) {
        break label373;
      }
    } while (((!this.x) || (paramFloat <= 0.0F) || (f1 >= 80.0F)) && ((this.x) || (paramFloat >= 0.0F) || (f1 <= -80.0F)) && ((!this.x) || (paramFloat >= 80.0F)) && ((this.x) || (paramFloat <= -80.0F)));
    a.b(this.B, paramFloat);
    return;
    label373:
    a.b(this.B, paramFloat);
  }
  
  public void c(int paramInt)
  {
    this.G = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void d()
  {
    if (this.r.getAdapter() != null)
    {
      int i2 = this.r.getAdapter().getItemCount();
      int i1 = this.H.size();
      while (i1 <= i2)
      {
        this.H.add(Boolean.valueOf(false));
        this.I.add(Boolean.valueOf(false));
        this.K.add(Boolean.valueOf(false));
        i1 += 1;
      }
    }
  }
  
  protected void d(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void d(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.D = paramBoolean;
      return;
    }
  }
  
  protected int e()
  {
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < this.K.size(); i2 = i3)
    {
      i3 = i2;
      if (((Boolean)this.K.get(i1)).booleanValue()) {
        i3 = i2 + 1;
      }
      i1 += 1;
    }
    return i2;
  }
  
  protected void e(int paramInt)
  {
    this.o = paramInt;
  }
  
  protected List<Integer> f()
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < this.K.size())
    {
      if (((Boolean)this.K.get(i1)).booleanValue()) {
        localArrayList.add(Integer.valueOf(i1));
      }
      i1 += 1;
    }
    return localArrayList;
  }
  
  protected void f(int paramInt)
  {
    View localView = this.r.getChildAt(paramInt - this.q.findFirstVisibleItemPosition()).findViewById(this.d);
    if (localView != null) {
      c(localView, paramInt);
    }
  }
  
  public RecyclerView.OnScrollListener g()
  {
    return new k(this);
  }
  
  protected boolean g(int paramInt)
  {
    return (paramInt < this.K.size()) && (((Boolean)this.K.get(paramInt)).booleanValue());
  }
  
  void h()
  {
    if (this.H != null)
    {
      int i2 = this.q.findFirstVisibleItemPosition();
      int i3 = this.q.findLastVisibleItemPosition();
      int i1 = i2;
      while (i1 <= i3)
      {
        if (((Boolean)this.H.get(i1)).booleanValue()) {
          d(this.r.getChildAt(i1 - i2).findViewById(this.d), i1);
        }
        i1 += 1;
      }
    }
  }
  
  protected void i()
  {
    this.G = this.L;
    this.F = this.M;
  }
  
  protected void j()
  {
    this.t.clear();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if (!a())
    {
      break label60;
      break label60;
      label10:
      return false;
    }
    else if (this.s < 2)
    {
      this.s = this.r.getWidth();
    }
    label60:
    int i2;
    Object localObject;
    int i1;
    boolean bool1;
    label367:
    label373:
    float f3;
    float f1;
    float f2;
    switch (MotionEventCompat.getActionMasked(paramMotionEvent))
    {
    default: 
    case 0: 
    case 1: 
      for (;;)
      {
        if (this.p)
        {
          l();
          paramView.onTouchEvent(paramMotionEvent);
          return true;
          if ((this.D) && (this.z != -1)) {
            break;
          }
          this.E = 3;
          i2 = this.r.getChildCount();
          localObject = new int[2];
          this.r.getLocationOnScreen((int[])localObject);
          int i3 = (int)paramMotionEvent.getRawX();
          int i4 = localObject[0];
          int i5 = (int)paramMotionEvent.getRawY();
          int i6 = localObject[1];
          i1 = 0;
          for (;;)
          {
            View localView;
            if (i1 < i2)
            {
              localObject = this.r.getChildAt(i1);
              ((View)localObject).getHitRect(this.f);
              int i7 = this.r.getChildPosition((View)localObject);
              if (!this.f.contains(i3 - i4, i5 - i6)) {
                break label373;
              }
              a((View)localObject);
              b(((View)localObject).findViewById(this.d), i7);
              this.v = paramMotionEvent.getRawX();
              this.z = i7;
              localView = this.B;
              if (((Boolean)this.H.get(this.z)).booleanValue()) {
                break label367;
              }
            }
            for (bool1 = true;; bool1 = false)
            {
              localView.setClickable(bool1);
              localView = this.B;
              bool1 = bool2;
              if (!((Boolean)this.H.get(this.z)).booleanValue()) {
                bool1 = true;
              }
              localView.setLongClickable(bool1);
              this.y = VelocityTracker.obtain();
              this.y.addMovement(paramMotionEvent);
              if (this.e > 0) {
                b(((View)localObject).findViewById(this.e));
              }
              paramView.onTouchEvent(paramMotionEvent);
              return true;
            }
            i1 += 1;
          }
          if ((this.y != null) && (this.w) && (this.z != -1))
          {
            f3 = paramMotionEvent.getRawX() - this.v;
            this.y.addMovement(paramMotionEvent);
            this.y.computeCurrentVelocity(1000);
            f1 = Math.abs(this.y.getXVelocity());
            if (((Boolean)this.H.get(this.z)).booleanValue()) {
              break label1423;
            }
            if ((this.a != 3) || (this.y.getXVelocity() <= 0.0F)) {
              break label1417;
            }
            f2 = 0.0F;
            label489:
            f1 = f2;
            if (this.a == 2)
            {
              f1 = f2;
              if (this.y.getXVelocity() < 0.0F) {
                f1 = 0.0F;
              }
            }
          }
        }
      }
    }
    label573:
    label659:
    label974:
    label1147:
    label1259:
    label1265:
    label1405:
    label1417:
    label1423:
    for (;;)
    {
      f2 = Math.abs(this.y.getYVelocity());
      if ((this.h <= f1) && (f1 <= this.i) && (f2 * 2.0F < f1)) {
        if (this.y.getXVelocity() > 0.0F)
        {
          bool2 = true;
          if ((bool2 == this.x) || (this.F == this.G)) {
            break label659;
          }
          bool1 = false;
        }
      }
      for (;;)
      {
        a(this.B, bool1, bool2, this.z);
        if (this.E == 2) {
          h(this.z);
        }
        this.y.recycle();
        this.y = null;
        this.v = 0.0F;
        this.w = false;
        break label60;
        break label10;
        bool2 = false;
        break label573;
        if ((((Boolean)this.H.get(this.z)).booleanValue()) && (((Boolean)this.I.get(this.z)).booleanValue()) && (bool2))
        {
          bool1 = false;
        }
        else if ((((Boolean)this.H.get(this.z)).booleanValue()) && (!((Boolean)this.I.get(this.z)).booleanValue()) && (!bool2))
        {
          bool1 = false;
        }
        else
        {
          bool1 = true;
          continue;
          if (Math.abs(f3) > this.s / 2)
          {
            if (f3 > 0.0F) {}
            for (bool1 = true;; bool1 = false)
            {
              bool2 = bool1;
              bool1 = true;
              break;
            }
            if ((this.y == null) || (this.D) || (this.z == -1)) {
              break;
            }
            this.y.addMovement(paramMotionEvent);
            this.y.computeCurrentVelocity(1000);
            f3 = Math.abs(this.y.getXVelocity());
            float f4 = Math.abs(this.y.getYVelocity());
            f2 = paramMotionEvent.getRawX() - this.v;
            f1 = Math.abs(f2);
            i1 = this.a;
            i2 = this.r.c(this.z);
            if (i2 >= 0) {
              i1 = i2;
            }
            if (i1 == 0) {
              f1 = 0.0F;
            }
            for (;;)
            {
              if ((f1 > this.g) && (this.E == 3) && (f4 < f3))
              {
                this.w = true;
                if (f2 <= 0.0F) {
                  break label1259;
                }
                bool1 = true;
                this.x = bool1;
                if (!((Boolean)this.H.get(this.z)).booleanValue()) {
                  break label1265;
                }
                this.r.a(this.z, this.x);
                this.E = 0;
                this.r.requestDisallowInterceptTouchEvent(true);
                localObject = MotionEvent.obtain(paramMotionEvent);
                ((MotionEvent)localObject).setAction(MotionEventCompat.getActionIndex(paramMotionEvent) << 8 | 0x3);
                this.r.onTouchEvent((MotionEvent)localObject);
                if (this.E == 2) {
                  this.C.setVisibility(8);
                }
              }
              if ((!this.w) || (this.z == -1)) {
                break;
              }
              if (((Boolean)this.H.get(this.z)).booleanValue()) {
                if (((Boolean)this.I.get(this.z)).booleanValue()) {
                  f1 = this.s - this.m;
                }
              }
              for (f1 += f2;; f1 = f2)
              {
                c(f1);
                return true;
                if (i1 == 1) {
                  break label1405;
                }
                if (((Boolean)this.H.get(this.z)).booleanValue())
                {
                  if ((i1 == 3) && (f2 < 0.0F))
                  {
                    f1 = 0.0F;
                    break;
                  }
                  if ((i1 != 2) || (f2 <= 0.0F)) {
                    break label1405;
                  }
                  f1 = 0.0F;
                  break;
                }
                if ((i1 == 3) && (f2 > 0.0F))
                {
                  f1 = 0.0F;
                  break;
                }
                if ((i1 != 2) || (f2 >= 0.0F)) {
                  break label1405;
                }
                f1 = 0.0F;
                break;
                bool1 = false;
                break label974;
                if ((this.x) && (this.G == 1)) {
                  this.E = 1;
                }
                for (;;)
                {
                  this.r.a(this.z, this.E, this.x);
                  break;
                  if ((!this.x) && (this.F == 1)) {
                    this.E = 1;
                  } else if ((this.x) && (this.G == 2)) {
                    this.E = 2;
                  } else if ((!this.x) && (this.F == 2)) {
                    this.E = 2;
                  } else {
                    this.E = 0;
                  }
                }
                f1 = -this.s + this.l;
                break label1147;
              }
            }
          }
          bool2 = false;
          bool1 = false;
        }
      }
      f2 = f1;
      break label489;
    }
  }
  
  class a
    implements Comparable<a>
  {
    public int a;
    public View b;
    
    public a(int paramInt, View paramView)
    {
      this.a = paramInt;
      this.b = paramView;
    }
    
    public int a(a parama)
    {
      return parama.a - this.a;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\swipelistview\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */