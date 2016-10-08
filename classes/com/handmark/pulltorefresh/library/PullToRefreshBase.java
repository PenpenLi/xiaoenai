package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.handmark.pulltorefresh.library.internal.f;
import com.handmark.pulltorefresh.library.internal.k;
import com.handmark.pulltorefresh.library.internal.l;
import com.handmark.pulltorefresh.library.internal.m;

public abstract class PullToRefreshBase<T extends View>
  extends LinearLayout
{
  T a;
  private int b;
  private float c;
  private float d;
  private float e;
  private float f;
  private boolean g = false;
  private j h = j.a;
  private b i = b.a();
  private b j;
  private FrameLayout k;
  private boolean l = true;
  private boolean m = false;
  private boolean n = true;
  private boolean o = true;
  private boolean p = true;
  private Interpolator q;
  private a r = a.a();
  private f s;
  private f t;
  private e<T> u;
  private f<T> v;
  private d<T> w;
  private PullToRefreshBase<T>.i x;
  
  public PullToRefreshBase(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public PullToRefreshBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public PullToRefreshBase(Context paramContext, b paramb)
  {
    super(paramContext);
    this.i = paramb;
    a(paramContext, null);
  }
  
  public PullToRefreshBase(Context paramContext, b paramb, a parama)
  {
    super(paramContext);
    this.i = paramb;
    this.r = parama;
    a(paramContext, null);
  }
  
  private final void a(int paramInt, long paramLong)
  {
    a(paramInt, paramLong, 0L, null);
  }
  
  private final void a(int paramInt, long paramLong1, long paramLong2, g paramg)
  {
    if (this.x != null) {
      this.x.a();
    }
    switch (i.a[getPullToRefreshScrollDirection().ordinal()])
    {
    }
    for (int i1 = getScrollY();; i1 = getScrollX())
    {
      if (i1 != paramInt)
      {
        if (this.q == null) {
          this.q = new DecelerateInterpolator();
        }
        this.x = new i(i1, paramInt, paramLong1, paramg);
        if (paramLong2 <= 0L) {
          break;
        }
        postDelayed(this.x, paramLong2);
      }
      return;
    }
    post(this.x);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray;
    switch (i.a[getPullToRefreshScrollDirection().ordinal()])
    {
    default: 
      setOrientation(1);
      setGravity(17);
      this.b = ViewConfiguration.get(paramContext).getScaledTouchSlop();
      localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, l.g.PullToRefresh);
      if (localTypedArray.hasValue(l.g.PullToRefresh_ptrMode)) {
        this.i = b.a(localTypedArray.getInteger(l.g.PullToRefresh_ptrMode, 0));
      }
      if (localTypedArray.hasValue(l.g.PullToRefresh_ptrAnimationStyle)) {
        this.r = a.a(localTypedArray.getInteger(l.g.PullToRefresh_ptrAnimationStyle, 0));
      }
      this.a = c(paramContext, paramAttributeSet);
      a(paramContext, this.a);
      this.s = a(paramContext, b.b, localTypedArray);
      this.t = a(paramContext, b.c, localTypedArray);
      if (localTypedArray.hasValue(l.g.PullToRefresh_ptrRefreshableViewBackground))
      {
        paramContext = localTypedArray.getDrawable(l.g.PullToRefresh_ptrRefreshableViewBackground);
        if (paramContext != null) {
          this.a.setBackgroundDrawable(paramContext);
        }
      }
      break;
    }
    for (;;)
    {
      if (localTypedArray.hasValue(l.g.PullToRefresh_ptrOverScroll)) {
        this.o = localTypedArray.getBoolean(l.g.PullToRefresh_ptrOverScroll, true);
      }
      if (localTypedArray.hasValue(l.g.PullToRefresh_ptrScrollingWhileRefreshingEnabled)) {
        this.m = localTypedArray.getBoolean(l.g.PullToRefresh_ptrScrollingWhileRefreshingEnabled, false);
      }
      a(localTypedArray);
      localTypedArray.recycle();
      f();
      return;
      setOrientation(0);
      break;
      if (localTypedArray.hasValue(l.g.PullToRefresh_ptrAdapterViewBackground))
      {
        l.a("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
        paramContext = localTypedArray.getDrawable(l.g.PullToRefresh_ptrAdapterViewBackground);
        if (paramContext != null) {
          this.a.setBackgroundDrawable(paramContext);
        }
      }
    }
  }
  
  private void a(Context paramContext, T paramT)
  {
    this.k = new FrameLayout(paramContext);
    this.k.addView(paramT, -1, -1);
    a(this.k, new LinearLayout.LayoutParams(-1, -1));
  }
  
  private void g()
  {
    if (this.u != null) {
      this.u.a(this);
    }
    do
    {
      do
      {
        return;
      } while (this.v == null);
      if (this.j == b.b)
      {
        this.v.a(this);
        return;
      }
    } while (this.j != b.c);
    this.v.b(this);
  }
  
  private LinearLayout.LayoutParams getLoadingLayoutLayoutParams()
  {
    switch (i.a[getPullToRefreshScrollDirection().ordinal()])
    {
    default: 
      return new LinearLayout.LayoutParams(-1, -2);
    }
    return new LinearLayout.LayoutParams(-2, -1);
  }
  
  private int getMaximumPullScroll()
  {
    switch (i.a[getPullToRefreshScrollDirection().ordinal()])
    {
    default: 
      return Math.round(getHeight() / 2.0F);
    }
    return Math.round(getWidth() / 2.0F);
  }
  
  private boolean o()
  {
    switch (i.c[this.i.ordinal()])
    {
    }
    do
    {
      return false;
      return d();
      return e();
    } while ((!e()) && (!d()));
    return true;
  }
  
  private void p()
  {
    float f2;
    float f1;
    int i2;
    int i1;
    switch (i.a[getPullToRefreshScrollDirection().ordinal()])
    {
    default: 
      f2 = this.f;
      f1 = this.d;
      switch (i.c[this.j.ordinal()])
      {
      default: 
        i2 = Math.round(Math.min(f2 - f1, 0.0F) / 2.0F);
        i1 = getHeaderSize();
        label87:
        setHeaderScroll(i2);
        if ((i2 != 0) && (!j()))
        {
          f1 = Math.abs(i2) / i1;
          switch (i.c[this.j.ordinal()])
          {
          default: 
            this.s.b(f1);
            label152:
            if ((this.h != j.b) && (i1 >= Math.abs(i2))) {
              a(j.b, new boolean[0]);
            }
            break;
          }
        }
        break;
      }
      break;
    }
    while ((this.h != j.b) || (i1 >= Math.abs(i2)))
    {
      return;
      f2 = this.e;
      f1 = this.c;
      break;
      i2 = Math.round(Math.max(f2 - f1, 0.0F) / 2.0F);
      i1 = getFooterSize();
      break label87;
      this.t.b(f1);
      break label152;
    }
    a(j.c, new boolean[0]);
  }
  
  protected c a(boolean paramBoolean1, boolean paramBoolean2)
  {
    c localc = new c();
    if ((paramBoolean1) && (this.i.c())) {
      localc.a(this.s);
    }
    if ((paramBoolean2) && (this.i.d())) {
      localc.a(this.t);
    }
    return localc;
  }
  
  protected f a(Context paramContext, b paramb, TypedArray paramTypedArray)
  {
    paramContext = this.r.a(paramContext, paramb, getPullToRefreshScrollDirection(), paramTypedArray);
    paramContext.setVisibility(4);
    return paramContext;
  }
  
  protected void a()
  {
    this.g = false;
    this.p = true;
    this.s.i();
    this.t.i();
    a(0);
  }
  
  protected final void a(int paramInt)
  {
    a(paramInt, getPullToRefreshScrollDuration());
  }
  
  protected final void a(int paramInt1, int paramInt2)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.k.getLayoutParams();
    switch (i.a[getPullToRefreshScrollDirection().ordinal()])
    {
    }
    do
    {
      do
      {
        return;
      } while (localLayoutParams.width == paramInt1);
      localLayoutParams.width = paramInt1;
      this.k.requestLayout();
      return;
    } while (localLayoutParams.height == paramInt2);
    localLayoutParams.height = paramInt2;
    this.k.requestLayout();
  }
  
  protected final void a(int paramInt, g paramg)
  {
    a(paramInt, getPullToRefreshScrollDuration(), 0L, paramg);
  }
  
  protected void a(TypedArray paramTypedArray) {}
  
  protected void a(Bundle paramBundle) {}
  
  protected final void a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  protected final void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, -1, paramLayoutParams);
  }
  
  final void a(j paramj, boolean... paramVarArgs)
  {
    this.h = paramj;
    switch (i.b[this.h.ordinal()])
    {
    }
    for (;;)
    {
      if (this.w != null) {
        this.w.a(this, this.h, this.j);
      }
      return;
      a();
      continue;
      b();
      continue;
      c();
      continue;
      a(paramVarArgs[0]);
    }
  }
  
  public void a(CharSequence paramCharSequence, b paramb)
  {
    b(paramb.c(), paramb.d()).setReleaseLabel(paramCharSequence);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.i.c()) {
      this.s.g();
    }
    if (this.i.d()) {
      this.t.g();
    }
    if (paramBoolean)
    {
      if (this.l)
      {
        g localg = new g(this);
        switch (i.c[this.j.ordinal()])
        {
        case 2: 
        default: 
          a(-getHeaderSize(), localg);
          return;
        }
        a(getFooterSize(), localg);
        return;
      }
      a(0);
      return;
    }
    g();
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    View localView = getRefreshableView();
    if ((localView instanceof ViewGroup))
    {
      ((ViewGroup)localView).addView(paramView, paramInt, paramLayoutParams);
      return;
    }
    throw new UnsupportedOperationException("Refreshable View is not a ViewGroup so can't addView");
  }
  
  public final b b(boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramBoolean1, paramBoolean2);
  }
  
  protected void b()
  {
    switch (i.c[this.j.ordinal()])
    {
    default: 
      return;
    case 1: 
      this.t.f();
      return;
    }
    this.s.f();
  }
  
  protected void b(Bundle paramBundle) {}
  
  protected abstract T c(Context paramContext, AttributeSet paramAttributeSet);
  
  protected void c()
  {
    switch (i.c[this.j.ordinal()])
    {
    default: 
      return;
    case 1: 
      this.t.h();
      return;
    }
    this.s.h();
  }
  
  protected abstract boolean d();
  
  protected abstract boolean e();
  
  protected void f()
  {
    Object localObject = getLoadingLayoutLayoutParams();
    if (this == this.s.getParent()) {
      removeView(this.s);
    }
    if (this.i.c()) {
      a(this.s, 0, (ViewGroup.LayoutParams)localObject);
    }
    if (this == this.t.getParent()) {
      removeView(this.t);
    }
    if (this.i.d()) {
      a(this.t, (ViewGroup.LayoutParams)localObject);
    }
    n();
    if (this.i != b.d) {}
    for (localObject = this.i;; localObject = b.b)
    {
      this.j = ((b)localObject);
      return;
    }
  }
  
  public final b getCurrentMode()
  {
    return this.j;
  }
  
  public final boolean getFilterTouchEvents()
  {
    return this.n;
  }
  
  protected final f getFooterLayout()
  {
    return this.t;
  }
  
  protected final int getFooterSize()
  {
    return this.t.getContentSize();
  }
  
  protected final f getHeaderLayout()
  {
    return this.s;
  }
  
  protected final int getHeaderSize()
  {
    return this.s.getContentSize();
  }
  
  public final b getLoadingLayoutProxy()
  {
    return b(true, true);
  }
  
  public final b getMode()
  {
    return this.i;
  }
  
  public abstract h getPullToRefreshScrollDirection();
  
  protected int getPullToRefreshScrollDuration()
  {
    return 200;
  }
  
  protected int getPullToRefreshScrollDurationLonger()
  {
    return 325;
  }
  
  public final T getRefreshableView()
  {
    return this.a;
  }
  
  protected FrameLayout getRefreshableViewWrapper()
  {
    return this.k;
  }
  
  public final boolean getShowViewWhileRefreshing()
  {
    return this.l;
  }
  
  public final j getState()
  {
    return this.h;
  }
  
  public final boolean h()
  {
    return this.i.b();
  }
  
  public final boolean i()
  {
    return (Build.VERSION.SDK_INT >= 9) && (this.o) && (d.a(this.a));
  }
  
  public final boolean j()
  {
    return (this.h == j.d) || (this.h == j.e);
  }
  
  public final void k()
  {
    if (j()) {
      a(j.a, new boolean[0]);
    }
  }
  
  public final void l()
  {
    setRefreshing(true);
  }
  
  protected final void m()
  {
    this.p = false;
  }
  
  protected final void n()
  {
    int i6 = 0;
    int i7 = (int)(getMaximumPullScroll() * 1.2F);
    int i3 = getPaddingLeft();
    int i2 = getPaddingTop();
    int i5 = getPaddingRight();
    int i4 = getPaddingBottom();
    int i1;
    switch (i.a[getPullToRefreshScrollDirection().ordinal()])
    {
    default: 
      i1 = i4;
      i4 = i3;
      i3 = i2;
      i2 = i1;
      i1 = i5;
    }
    for (;;)
    {
      setPadding(i4, i3, i1, i2);
      return;
      if (this.i.c()) {
        this.s.setWidth(i7);
      }
      for (i1 = -i7;; i1 = 0)
      {
        if (!this.i.d()) {
          break label163;
        }
        this.t.setWidth(i7);
        i3 = -i7;
        i5 = i1;
        i1 = i3;
        i3 = i2;
        i2 = i4;
        i4 = i5;
        break;
      }
      label163:
      i5 = i1;
      i1 = 0;
      i3 = i2;
      i2 = i4;
      i4 = i5;
      continue;
      if (this.i.c()) {
        this.s.setHeight(i7);
      }
      for (i1 = -i7;; i1 = 0)
      {
        if (!this.i.d()) {
          break label250;
        }
        this.t.setHeight(i7);
        i2 = -i7;
        i4 = i1;
        i1 = i5;
        i5 = i3;
        i3 = i4;
        i4 = i5;
        break;
      }
      label250:
      i4 = i1;
      i1 = i5;
      i5 = i3;
      i2 = i6;
      i3 = i4;
      i4 = i5;
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!h()) {
      return false;
    }
    int i1 = paramMotionEvent.getAction();
    if ((i1 == 3) || (i1 == 1))
    {
      this.g = false;
      return false;
    }
    if ((i1 != 0) && (this.g)) {
      return true;
    }
    switch (i1)
    {
    }
    for (;;)
    {
      return this.g;
      if ((!this.m) && (j())) {
        return true;
      }
      if (o())
      {
        float f3 = paramMotionEvent.getY();
        float f4 = paramMotionEvent.getX();
        float f2;
        switch (i.a[getPullToRefreshScrollDirection().ordinal()])
        {
        default: 
          f2 = f3 - this.d;
        }
        for (float f1 = f4 - this.c;; f1 = f3 - this.d)
        {
          float f5 = Math.abs(f2);
          if ((f5 <= this.b) || ((this.n) && (f5 <= Math.abs(f1)))) {
            break;
          }
          if ((!this.i.c()) || (f2 < 1.0F) || (!d())) {
            break label273;
          }
          this.d = f3;
          this.c = f4;
          this.g = true;
          if (this.i != b.d) {
            break;
          }
          this.j = b.b;
          break;
          f2 = f4 - this.c;
        }
        label273:
        if ((this.i.d()) && (f2 <= -1.0F) && (e()))
        {
          this.d = f3;
          this.c = f4;
          this.g = true;
          if (this.i == b.d)
          {
            this.j = b.c;
            continue;
            if (o())
            {
              f1 = paramMotionEvent.getY();
              this.f = f1;
              this.d = f1;
              f1 = paramMotionEvent.getX();
              this.e = f1;
              this.c = f1;
              this.g = false;
            }
          }
        }
      }
    }
  }
  
  protected final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      setMode(b.a(paramParcelable.getInt("ptr_mode", 0)));
      this.j = b.a(paramParcelable.getInt("ptr_current_mode", 0));
      this.m = paramParcelable.getBoolean("ptr_disable_scrolling", false);
      this.l = paramParcelable.getBoolean("ptr_show_refreshing_view", true);
      super.onRestoreInstanceState(paramParcelable.getParcelable("ptr_super"));
      j localj = j.a(paramParcelable.getInt("ptr_state", 0));
      if ((localj == j.d) || (localj == j.e)) {
        a(localj, new boolean[] { true });
      }
      a(paramParcelable);
      return;
    }
    super.onRestoreInstanceState(paramParcelable);
  }
  
  protected final Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    b(localBundle);
    localBundle.putInt("ptr_state", this.h.a());
    localBundle.putInt("ptr_mode", this.i.e());
    localBundle.putInt("ptr_current_mode", this.j.e());
    localBundle.putBoolean("ptr_disable_scrolling", this.m);
    localBundle.putBoolean("ptr_show_refreshing_view", this.l);
    localBundle.putParcelable("ptr_super", super.onSaveInstanceState());
    return localBundle;
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    n();
    a(paramInt1, paramInt2);
    post(new h(this));
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!h()) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            if ((!this.m) && (j())) {
              return true;
            }
          } while ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0));
          switch (paramMotionEvent.getAction())
          {
          default: 
            return false;
          }
        } while (!o());
        float f1 = paramMotionEvent.getY();
        this.f = f1;
        this.d = f1;
        f1 = paramMotionEvent.getX();
        this.e = f1;
        this.c = f1;
        return true;
      } while (!this.g);
      this.d = paramMotionEvent.getY();
      this.c = paramMotionEvent.getX();
      p();
      return true;
    } while (!this.g);
    this.g = false;
    if ((this.h == j.c) && ((this.u != null) || (this.v != null)))
    {
      a(j.d, new boolean[] { true });
      return true;
    }
    if (j())
    {
      a(0);
      return true;
    }
    a(j.a, new boolean[0]);
    return true;
  }
  
  public void setDisableScrollingWhileRefreshing(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      setScrollingWhileRefreshingEnabled(paramBoolean);
      return;
    }
  }
  
  public final void setFilterTouchEvents(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  protected final void setHeaderScroll(int paramInt)
  {
    int i1 = getMaximumPullScroll();
    paramInt = Math.min(i1, Math.max(-i1, paramInt));
    if (this.p)
    {
      if (paramInt >= 0) {
        break label69;
      }
      this.s.setVisibility(0);
    }
    for (;;)
    {
      switch (i.a[getPullToRefreshScrollDirection().ordinal()])
      {
      default: 
        return;
        label69:
        if (paramInt > 0)
        {
          this.t.setVisibility(0);
        }
        else
        {
          this.s.setVisibility(4);
          this.t.setVisibility(4);
        }
        break;
      }
    }
    scrollTo(0, paramInt);
    return;
    scrollTo(paramInt, 0);
  }
  
  public void setLastUpdatedLabel(CharSequence paramCharSequence)
  {
    getLoadingLayoutProxy().setLastUpdatedLabel(paramCharSequence);
  }
  
  public void setLoadingDrawable(Drawable paramDrawable)
  {
    getLoadingLayoutProxy().setLoadingDrawable(paramDrawable);
  }
  
  public void setLongClickable(boolean paramBoolean)
  {
    getRefreshableView().setLongClickable(paramBoolean);
  }
  
  public final void setMode(b paramb)
  {
    if (paramb != this.i)
    {
      this.i = paramb;
      f();
    }
  }
  
  public void setOnPullEventListener(d<T> paramd)
  {
    this.w = paramd;
  }
  
  public final void setOnRefreshListener(e<T> parame)
  {
    this.u = parame;
    this.v = null;
  }
  
  public final void setOnRefreshListener(f<T> paramf)
  {
    this.v = paramf;
    this.u = null;
  }
  
  public void setPullLabel(CharSequence paramCharSequence)
  {
    getLoadingLayoutProxy().setPullLabel(paramCharSequence);
  }
  
  public final void setPullToRefreshEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (b localb = b.a();; localb = b.a)
    {
      setMode(localb);
      return;
    }
  }
  
  public final void setPullToRefreshOverScrollEnabled(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public final void setRefreshing(boolean paramBoolean)
  {
    if (!j()) {
      a(j.e, new boolean[] { paramBoolean });
    }
  }
  
  public void setRefreshingLabel(CharSequence paramCharSequence)
  {
    getLoadingLayoutProxy().setRefreshingLabel(paramCharSequence);
  }
  
  public void setReleaseLabel(CharSequence paramCharSequence)
  {
    a(paramCharSequence, b.d);
  }
  
  public void setScrollAnimationInterpolator(Interpolator paramInterpolator)
  {
    this.q = paramInterpolator;
  }
  
  public final void setScrollingWhileRefreshingEnabled(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public final void setShowViewWhileRefreshing(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public static enum a
  {
    private a() {}
    
    static a a()
    {
      return a;
    }
    
    static a a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return a;
      }
      return b;
    }
    
    f a(Context paramContext, PullToRefreshBase.b paramb, PullToRefreshBase.h paramh, TypedArray paramTypedArray)
    {
      switch (i.d[ordinal()])
      {
      default: 
        return new k(paramContext, paramb, paramh, paramTypedArray);
      }
      return new com.handmark.pulltorefresh.library.internal.b(paramContext, paramb, paramh, paramTypedArray);
    }
  }
  
  public static enum b
  {
    public static b f = b;
    public static b g = c;
    private int h;
    
    private b(int paramInt)
    {
      this.h = paramInt;
    }
    
    static b a()
    {
      return b;
    }
    
    static b a(int paramInt)
    {
      b[] arrayOfb = values();
      int k = arrayOfb.length;
      int j = 0;
      while (j < k)
      {
        b localb = arrayOfb[j];
        if (paramInt == localb.e()) {
          return localb;
        }
        j += 1;
      }
      return a();
    }
    
    boolean b()
    {
      return (this != a) && (this != e);
    }
    
    public boolean c()
    {
      return (this == b) || (this == d);
    }
    
    public boolean d()
    {
      return (this == c) || (this == d) || (this == e);
    }
    
    int e()
    {
      return this.h;
    }
  }
  
  public static abstract interface c
  {
    public abstract void a();
  }
  
  public static abstract interface d<V extends View>
  {
    public abstract void a(PullToRefreshBase<V> paramPullToRefreshBase, PullToRefreshBase.j paramj, PullToRefreshBase.b paramb);
  }
  
  public static abstract interface e<V extends View>
  {
    public abstract void a(PullToRefreshBase<V> paramPullToRefreshBase);
  }
  
  public static abstract interface f<V extends View>
  {
    public abstract void a(PullToRefreshBase<V> paramPullToRefreshBase);
    
    public abstract void b(PullToRefreshBase<V> paramPullToRefreshBase);
  }
  
  static abstract interface g
  {
    public abstract void a();
  }
  
  public static enum h
  {
    private h() {}
  }
  
  final class i
    implements Runnable
  {
    private final Interpolator b;
    private final int c;
    private final int d;
    private final long e;
    private PullToRefreshBase.g f;
    private boolean g = true;
    private long h = -1L;
    private int i = -1;
    
    public i(int paramInt1, int paramInt2, long paramLong, PullToRefreshBase.g paramg)
    {
      this.d = paramInt1;
      this.c = paramInt2;
      this.b = PullToRefreshBase.b(PullToRefreshBase.this);
      this.e = paramLong;
      this.f = paramg;
    }
    
    public void a()
    {
      this.g = false;
      PullToRefreshBase.this.removeCallbacks(this);
    }
    
    public void run()
    {
      if (this.h == -1L)
      {
        this.h = System.currentTimeMillis();
        if ((!this.g) || (this.c == this.i)) {
          break label128;
        }
        m.a(PullToRefreshBase.this, this);
      }
      label128:
      while (this.f == null)
      {
        return;
        long l = Math.max(Math.min((System.currentTimeMillis() - this.h) * 1000L / this.e, 1000L), 0L);
        float f1 = this.d - this.c;
        int j = Math.round(this.b.getInterpolation((float)l / 1000.0F) * f1);
        this.i = (this.d - j);
        PullToRefreshBase.this.setHeaderScroll(this.i);
        break;
      }
      this.f.a();
    }
  }
  
  public static enum j
  {
    private int g;
    
    private j(int paramInt)
    {
      this.g = paramInt;
    }
    
    static j a(int paramInt)
    {
      j[] arrayOfj = values();
      int j = arrayOfj.length;
      int i = 0;
      while (i < j)
      {
        j localj = arrayOfj[i];
        if (paramInt == localj.a()) {
          return localj;
        }
        i += 1;
      }
      return a;
    }
    
    int a()
    {
      return this.g;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\handmark\pulltorefresh\library\PullToRefreshBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */