package com.xiaoenai.app.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LoopViewPager
  extends ViewGroup
{
  private static final int[] a = { 16842931 };
  private static final h ah = new h();
  private static final Comparator<b> c = new m();
  private static final Interpolator d = new n();
  private int A = 1;
  private boolean B;
  private boolean C;
  private int D;
  private int E;
  private int F;
  private float G;
  private float H;
  private float I;
  private float J;
  private int K = -1;
  private VelocityTracker L;
  private int M;
  private int N;
  private int O;
  private int P;
  private boolean Q;
  private EdgeEffectCompat R;
  private EdgeEffectCompat S;
  private boolean T = true;
  private boolean U = false;
  private boolean V;
  private int W;
  private e aa;
  private e ab;
  private d ac;
  private f ad;
  private Method ae;
  private int af;
  private ArrayList<View> ag;
  private final Runnable ai = new o(this);
  private int aj = 0;
  private int b;
  private final ArrayList<b> e = new ArrayList();
  private boolean f = true;
  private final b g = new b();
  private final Rect h = new Rect();
  private PagerAdapter i;
  private int j;
  private int k = -1;
  private Parcelable l = null;
  private ClassLoader m = null;
  private Scroller n;
  private g o;
  private int p;
  private Drawable q;
  private int r;
  private int s;
  private float t = -3.4028235E38F;
  private float u = Float.MAX_VALUE;
  private int v;
  private int w;
  private boolean x;
  private boolean y;
  private boolean z;
  
  public LoopViewPager(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public LoopViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private int a(b paramb, int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((Math.abs(paramInt3) > this.O) && (Math.abs(paramInt2) > this.M)) {
      if (paramInt2 > 0) {
        paramInt2 = paramInt1;
      }
    }
    for (;;)
    {
      paramInt1 = paramInt2;
      if (this.e.size() > 0)
      {
        paramb = (b)this.e.get(0);
        b localb = (b)this.e.get(this.e.size() - 1);
        paramInt1 = Math.max(paramb.c, Math.min(paramInt2, localb.c));
      }
      return paramInt1;
      paramInt2 = paramInt1 + 1;
      continue;
      if (paramInt1 >= this.j) {}
      for (float f1 = 0.4F;; f1 = 0.6F)
      {
        if (this.f) {
          break label145;
        }
        paramInt2 = (int)(f1 + (paramInt1 + paramFloat));
        break;
      }
      label145:
      if (paramInt1 >= this.j)
      {
        paramInt2 = paramInt1;
        if (paramFloat > 0.6F) {
          paramInt2 = paramInt1 + 1;
        }
      }
      else
      {
        paramInt2 = paramInt1;
        if (paramFloat > 0.4F) {
          paramInt2 = this.j;
        }
      }
    }
  }
  
  private Rect a(Rect paramRect, View paramView)
  {
    if (paramRect == null) {
      paramRect = new Rect();
    }
    for (;;)
    {
      if (paramView == null)
      {
        paramRect.set(0, 0, 0, 0);
        return paramRect;
      }
      paramRect.left = paramView.getLeft();
      paramRect.right = paramView.getRight();
      paramRect.top = paramView.getTop();
      paramRect.bottom = paramView.getBottom();
      for (paramView = paramView.getParent(); ((paramView instanceof ViewGroup)) && (paramView != this); paramView = paramView.getParent())
      {
        paramView = (ViewGroup)paramView;
        paramRect.left += paramView.getLeft();
        paramRect.right += paramView.getRight();
        paramRect.top += paramView.getTop();
        paramRect.bottom += paramView.getBottom();
      }
      return paramRect;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > 0) && (!this.e.isEmpty()))
    {
      int i1 = getPaddingLeft();
      int i2 = getPaddingRight();
      int i3 = getPaddingLeft();
      int i4 = getPaddingRight();
      f1 = getScrollX() / (paramInt2 - i3 - i4 + paramInt4);
      paramInt2 = (int)((paramInt1 - i1 - i2 + paramInt3) * f1);
      scrollTo(paramInt2, getScrollY());
      if (!this.n.isFinished())
      {
        paramInt3 = this.n.getDuration();
        paramInt4 = this.n.timePassed();
        localb = b(this.j);
        this.n.startScroll(paramInt2, 0, (int)(localb.f * paramInt1), 0, paramInt3 - paramInt4);
      }
      return;
    }
    b localb = b(this.j);
    if (localb != null) {}
    for (float f1 = Math.min(localb.f, this.u);; f1 = 0.0F)
    {
      paramInt1 = (int)(f1 * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (paramInt1 == getScrollX()) {
        break;
      }
      a(false);
      scrollTo(paramInt1, getScrollY());
      return;
    }
  }
  
  private void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    b localb = b(paramInt1);
    float f1;
    if (localb != null) {
      f1 = getClientWidth();
    }
    for (int i1 = (int)(localb.f * f1);; i1 = 0)
    {
      if (paramBoolean1)
      {
        a(i1, 0, paramInt2);
        if ((paramBoolean2) && (this.aa != null)) {
          this.aa.a(paramInt1);
        }
        if ((paramBoolean2) && (this.ab != null)) {
          this.ab.a(paramInt1);
        }
        return;
      }
      if ((paramBoolean2) && (this.aa != null)) {
        this.aa.a(paramInt1);
      }
      if ((paramBoolean2) && (this.ab != null)) {
        this.ab.a(paramInt1);
      }
      a(false);
      scrollTo(i1, 0);
      d(i1);
      return;
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i1) == this.K) {
      if (i1 != 0) {
        break label56;
      }
    }
    label56:
    for (i1 = 1;; i1 = 0)
    {
      this.G = MotionEventCompat.getX(paramMotionEvent, i1);
      this.K = MotionEventCompat.getPointerId(paramMotionEvent, i1);
      if (this.L != null) {
        this.L.clear();
      }
      return;
    }
  }
  
  private void a(b paramb1, int paramInt, b paramb2)
  {
    int i4 = this.i.getCount();
    int i1 = getClientWidth();
    float f2;
    if (i1 > 0)
    {
      f2 = this.p / i1;
      if (paramb2 == null) {
        break label409;
      }
      i1 = paramb2.c;
      if (i1 < paramb1.c)
      {
        f1 = paramb2.f + paramb2.e + f2;
        i1 += 1;
        i2 = 0;
      }
    }
    else
    {
      for (;;)
      {
        if ((i1 > paramb1.c) || (i2 >= this.e.size())) {
          break label409;
        }
        for (paramb2 = (b)this.e.get(i2);; paramb2 = (b)this.e.get(i2))
        {
          i3 = i1;
          f3 = f1;
          if (i1 <= paramb2.c) {
            break;
          }
          i3 = i1;
          f3 = f1;
          if (i2 >= this.e.size() - 1) {
            break;
          }
          i2 += 1;
        }
        f2 = 0.0F;
        break;
        while (i3 < paramb2.c)
        {
          f3 += this.i.getPageWidth(i3) + f2;
          i3 += 1;
        }
        paramb2.f = f3;
        f1 = f3 + (paramb2.e + f2);
        i1 = i3 + 1;
      }
    }
    if (i1 > paramb1.c)
    {
      i2 = this.e.size() - 1;
      f1 = paramb2.f;
      i1 -= 1;
      while ((i1 >= paramb1.c) && (i2 >= 0))
      {
        for (paramb2 = (b)this.e.get(i2);; paramb2 = (b)this.e.get(i2))
        {
          i3 = i1;
          f3 = f1;
          if (i1 >= paramb2.c) {
            break;
          }
          i3 = i1;
          f3 = f1;
          if (i2 <= 0) {
            break;
          }
          i2 -= 1;
        }
        while (i3 > paramb2.c)
        {
          f3 -= this.i.getPageWidth(i3) + f2;
          i3 -= 1;
        }
        f1 = f3 - (paramb2.e + f2);
        paramb2.f = f1;
        i1 = i3 - 1;
      }
    }
    label409:
    int i3 = this.e.size();
    float f3 = paramb1.f;
    i1 = paramb1.c - 1;
    if (paramb1.c == 0)
    {
      f1 = paramb1.f;
      this.t = f1;
      if (paramb1.c != i4 - 1) {
        break label550;
      }
      f1 = paramb1.f + paramb1.e - 1.0F;
      label475:
      this.u = f1;
      i2 = paramInt - 1;
      f1 = f3;
    }
    for (;;)
    {
      if (i2 < 0) {
        break label590;
      }
      paramb2 = (b)this.e.get(i2);
      for (;;)
      {
        if (i1 > paramb2.c)
        {
          f1 -= this.i.getPageWidth(i1) + f2;
          i1 -= 1;
          continue;
          f1 = -3.4028235E38F;
          break;
          label550:
          f1 = Float.MAX_VALUE;
          break label475;
        }
      }
      f1 -= paramb2.e + f2;
      paramb2.f = f1;
      i1 -= 1;
      i2 -= 1;
    }
    label590:
    float f1 = paramb1.f + paramb1.e + f2;
    int i2 = paramb1.c + 1;
    i1 = paramInt + 1;
    paramInt = i2;
    while (i1 < i3)
    {
      paramb1 = (b)this.e.get(i1);
      while (paramInt < paramb1.c)
      {
        f1 = this.i.getPageWidth(paramInt) + f2 + f1;
        paramInt += 1;
      }
      if (paramb1.c == i4 - 1) {
        this.u = (paramb1.e + f1 - 1.0F);
      }
      paramb1.f = f1;
      f1 += paramb1.e + f2;
      paramInt += 1;
      i1 += 1;
    }
    this.U = false;
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.aj == 2) {}
    int i2;
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        setScrollingCacheEnabled(false);
        this.n.abortAnimation();
        i2 = getScrollX();
        i3 = getScrollY();
        int i4 = this.n.getCurrX();
        int i5 = this.n.getCurrY();
        if ((i2 != i4) || (i3 != i5)) {
          scrollTo(i4, i5);
        }
      }
      this.z = false;
      int i3 = 0;
      i2 = i1;
      i1 = i3;
      while (i1 < this.e.size())
      {
        b localb = (b)this.e.get(i1);
        if (localb.d)
        {
          localb.d = false;
          i2 = 1;
        }
        i1 += 1;
      }
    }
    if (i2 != 0)
    {
      if (paramBoolean) {
        ViewCompat.postOnAnimation(this, this.ai);
      }
    }
    else {
      return;
    }
    this.ai.run();
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return ((paramFloat1 < this.E) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getWidth() - this.E) && (paramFloat2 < 0.0F));
  }
  
  private void b(boolean paramBoolean)
  {
    int i3 = getChildCount();
    int i1 = 0;
    if (i1 < i3)
    {
      if (paramBoolean) {}
      for (int i2 = 2;; i2 = 0)
      {
        ViewCompat.setLayerType(getChildAt(i1), i2, null);
        i1 += 1;
        break;
      }
    }
  }
  
  private boolean b(float paramFloat)
  {
    int i2 = 1;
    boolean bool2 = false;
    boolean bool1 = false;
    float f1 = this.G;
    this.G = paramFloat;
    float f2 = getScrollX() + (f1 - paramFloat);
    int i3 = getClientWidth();
    paramFloat = i3 * this.t;
    f1 = i3;
    float f3 = this.u;
    b localb1 = (b)this.e.get(0);
    b localb2 = (b)this.e.get(this.e.size() - 1);
    if (localb1.c != 0) {
      paramFloat = localb1.f * i3;
    }
    for (int i1 = 0;; i1 = 1)
    {
      if (localb2.c != this.i.getCount() - 1)
      {
        f1 = localb2.f * i3;
        i2 = 0;
      }
      for (;;)
      {
        if (f2 < paramFloat)
        {
          f1 = paramFloat;
          if (i1 != 0)
          {
            bool1 = this.R.onPull(Math.abs(paramFloat - f2) / i3);
            f1 = paramFloat;
          }
        }
        for (;;)
        {
          this.G += f1 - (int)f1;
          scrollTo((int)f1, getScrollY());
          d((int)f1);
          return bool1;
          if (f2 > f1)
          {
            bool1 = bool2;
            if (i2 != 0) {
              bool1 = this.S.onPull(Math.abs(f2 - f1) / i3);
            }
          }
          else
          {
            f1 = f2;
          }
        }
        f1 *= f3;
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  private boolean d(int paramInt)
  {
    boolean bool = false;
    if (this.e.size() == 0)
    {
      this.V = false;
      a(0, 0.0F, 0);
      if (!this.V) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
    }
    else
    {
      b localb = i();
      int i2 = getClientWidth();
      int i3 = this.p;
      float f1 = this.p / i2;
      int i1 = localb.c;
      f1 = (paramInt / i2 - localb.f) / (localb.e + f1);
      paramInt = (int)((i3 + i2) * f1);
      this.V = false;
      a(i1, f1, paramInt);
      if (!this.V) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
      bool = true;
    }
    return bool;
  }
  
  private void g()
  {
    int i2;
    for (int i1 = 0; i1 < getChildCount(); i1 = i2 + 1)
    {
      i2 = i1;
      if (!((LayoutParams)getChildAt(i1).getLayoutParams()).a)
      {
        removeViewAt(i1);
        i2 = i1 - 1;
      }
    }
  }
  
  private int getClientWidth()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private void h()
  {
    if (this.af != 0)
    {
      if (this.ag == null) {
        this.ag = new ArrayList();
      }
      for (;;)
      {
        int i2 = getChildCount();
        int i1 = 0;
        while (i1 < i2)
        {
          View localView = getChildAt(i1);
          this.ag.add(localView);
          i1 += 1;
        }
        this.ag.clear();
      }
      Collections.sort(this.ag, ah);
    }
  }
  
  private b i()
  {
    int i1 = getClientWidth();
    float f1;
    float f2;
    label36:
    float f4;
    float f3;
    int i3;
    int i4;
    int i2;
    Object localObject1;
    label56:
    Object localObject2;
    b localb;
    if (i1 > 0)
    {
      f1 = getScrollX() / i1;
      if (i1 <= 0) {
        break label226;
      }
      f2 = this.p / i1;
      f4 = 0.0F;
      f3 = 0.0F;
      i3 = -1;
      i4 = -1;
      i2 = 1;
      i1 = 0;
      localObject1 = null;
      localObject2 = localObject1;
      if (i1 < this.e.size())
      {
        localb = (b)this.e.get(i1);
        if ((i2 != 0) || (localb.c == i4 + 1)) {
          break label268;
        }
        localb = this.g;
        localb.f = (f4 + f3 + f2);
        localb.b = (i3 + 1);
        localb.c = (i4 + 1);
        localb.e = this.i.getPageWidth(localb.c);
        i1 -= 1;
      }
    }
    label226:
    label231:
    label268:
    for (;;)
    {
      f3 = localb.f;
      f4 = localb.e;
      if (i2 == 0)
      {
        localObject2 = localObject1;
        if (f1 < f3) {}
      }
      else
      {
        if ((f1 >= f4 + f3 + f2) && (i1 != this.e.size() - 1)) {
          break label231;
        }
        localObject2 = localb;
      }
      return (b)localObject2;
      f1 = 0.0F;
      break;
      f2 = 0.0F;
      break label36;
      i4 = localb.c;
      i3 = localb.b;
      f4 = localb.e;
      i2 = 0;
      i1 += 1;
      localObject1 = localb;
      break label56;
    }
  }
  
  private void j()
  {
    this.B = false;
    this.C = false;
    if (this.L != null)
    {
      this.L.recycle();
      this.L = null;
    }
  }
  
  private void setScrollState(int paramInt)
  {
    if (this.aj == paramInt) {
      return;
    }
    this.aj = paramInt;
    if (this.ad != null) {
      if (paramInt == 0) {
        break label50;
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      b(bool);
      if (this.aa == null) {
        break;
      }
      this.aa.b(paramInt);
      return;
    }
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.y != paramBoolean) {
      this.y = paramBoolean;
    }
  }
  
  float a(float paramFloat)
  {
    return (float)Math.sin((float)((paramFloat - 0.5F) * 0.4712389167638204D));
  }
  
  b a(int paramInt1, int paramInt2)
  {
    b localb = new b();
    localb.b = paramInt1;
    localb.c = paramInt1;
    int i1 = Math.abs(this.b + paramInt1 % this.b);
    int i2 = this.b;
    localb.a = this.i.instantiateItem(this, paramInt1);
    localb.e = this.i.getPageWidth(i1 % i2);
    if ((paramInt2 < 0) || (paramInt2 >= this.e.size()))
    {
      this.e.add(localb);
      return localb;
    }
    this.e.add(paramInt2, localb);
    return localb;
  }
  
  b a(View paramView)
  {
    int i1 = 0;
    while (i1 < this.e.size())
    {
      b localb = (b)this.e.get(i1);
      if (this.i.isViewFromObject(paramView, localb.a)) {
        return localb;
      }
      i1 += 1;
    }
    return null;
  }
  
  void a()
  {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context localContext = getContext();
    this.n = new Scroller(localContext, d);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
    float f1 = localContext.getResources().getDisplayMetrics().density;
    this.F = ViewConfigurationCompat.getScaledPagingTouchSlop(localViewConfiguration);
    this.M = ((int)(400.0F * f1));
    this.N = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.R = new EdgeEffectCompat(localContext);
    this.S = new EdgeEffectCompat(localContext);
    this.O = ((int)(25.0F * f1));
    this.P = ((int)(2.0F * f1));
    this.D = ((int)(16.0F * f1));
    ViewCompat.setAccessibilityDelegate(this, new c());
    if (ViewCompat.getImportantForAccessibility(this) == 0) {
      ViewCompat.setImportantForAccessibility(this, 1);
    }
  }
  
  void a(int paramInt)
  {
    int i1;
    Object localObject2;
    if (this.j != paramInt) {
      if (this.j < paramInt)
      {
        i1 = 66;
        localObject2 = b(this.j);
        this.j = paramInt;
      }
    }
    for (int i2 = i1;; i2 = 2)
    {
      if (this.i == null) {
        h();
      }
      do
      {
        return;
        i1 = 17;
        break;
        if (this.z)
        {
          h();
          return;
        }
      } while (getWindowToken() == null);
      this.i.startUpdate(this);
      paramInt = this.A;
      int i4 = Math.max(0, this.j - paramInt);
      int i7 = this.i.getCount();
      int i3 = Math.min(i7 - 1, this.j + paramInt);
      if (this.f)
      {
        i3 = this.j;
        i1 = this.j;
        i4 = i3 - paramInt;
        i3 = i1 + paramInt;
      }
      for (;;)
      {
        Object localObject1;
        if (i7 != this.b) {
          try
          {
            String str = getResources().getResourceName(getId());
            throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.b + ", found: " + i7 + " Pager id: " + str + " Pager class: " + getClass() + " Problematic adapter: " + this.i.getClass());
          }
          catch (Resources.NotFoundException localNotFoundException)
          {
            for (;;)
            {
              localObject1 = Integer.toHexString(getId());
            }
          }
        }
        paramInt = 0;
        if (paramInt < this.e.size())
        {
          localObject1 = (b)this.e.get(paramInt);
          if (((b)localObject1).b >= this.j) {
            if (((b)localObject1).b != this.j) {
              break label1286;
            }
          }
        }
        for (;;)
        {
          if ((localObject1 == null) && (i7 > 0)) {}
          for (Object localObject3 = a(this.j, paramInt);; localObject3 = localObject1)
          {
            int i5;
            label375:
            int i8;
            float f2;
            label388:
            float f1;
            if (localObject3 != null)
            {
              i5 = paramInt - 1;
              if (i5 < 0) {
                break label678;
              }
              localObject1 = (b)this.e.get(i5);
              i8 = getClientWidth();
              if (i8 > 0) {
                break label684;
              }
              f2 = 0.0F;
              i1 = this.j;
              f1 = 0.0F;
              int i6 = i1 - 1;
              i1 = paramInt;
              paramInt = i5;
              i5 = i6;
              label412:
              if ((i5 >= this.j - this.b) && ((this.f) || (i5 >= 0))) {
                break label705;
              }
            }
            label479:
            label486:
            label498:
            label526:
            label559:
            label678:
            label684:
            label705:
            do
            {
              f1 = ((b)localObject3).e;
              paramInt = i1 + 1;
              if (f1 < 2.0F)
              {
                if (paramInt >= this.e.size()) {
                  break label918;
                }
                localObject1 = (b)this.e.get(paramInt);
                if (i8 > 0) {
                  break label924;
                }
                f2 = 0.0F;
                i4 = this.j;
                i4 += 1;
                if ((i4 <= this.j + this.b) && ((this.f) || (i4 < i7))) {
                  break label939;
                }
              }
              a((b)localObject3, i1, (b)localObject2);
              localObject2 = this.i;
              paramInt = this.j;
              if (localObject3 == null) {
                break label1155;
              }
              localObject1 = ((b)localObject3).a;
              ((PagerAdapter)localObject2).setPrimaryItem(this, paramInt, localObject1);
              this.i.finishUpdate(this);
              i1 = getChildCount();
              paramInt = 0;
              while (paramInt < i1)
              {
                localObject2 = getChildAt(paramInt);
                localObject1 = (LayoutParams)((View)localObject2).getLayoutParams();
                ((LayoutParams)localObject1).f = paramInt;
                if ((!((LayoutParams)localObject1).a) && (((LayoutParams)localObject1).c == 0.0F))
                {
                  localObject2 = a((View)localObject2);
                  if (localObject2 != null)
                  {
                    ((LayoutParams)localObject1).c = ((b)localObject2).e;
                    ((LayoutParams)localObject1).e = ((b)localObject2).c;
                  }
                }
                paramInt += 1;
              }
              paramInt += 1;
              break;
              localObject1 = null;
              break label375;
              f2 = 2.0F - ((b)localObject3).e + getPaddingLeft() / i8;
              break label388;
              if ((f1 < f2) || (i5 >= i4)) {
                break label810;
              }
            } while (localObject1 == null);
            if ((i5 == ((b)localObject1).b) && (!((b)localObject1).d))
            {
              this.e.remove(paramInt);
              this.i.destroyItem(this, ((b)localObject1).c, ((b)localObject1).a);
              paramInt -= 1;
              if (paramInt >= 0)
              {
                localObject1 = (b)this.e.get(paramInt);
                label789:
                i1 -= 1;
              }
            }
            for (;;)
            {
              i5 -= 1;
              break label412;
              localObject1 = null;
              break label789;
              label810:
              if ((localObject1 != null) && (i5 == ((b)localObject1).b))
              {
                f3 = ((b)localObject1).e;
                paramInt -= 1;
                if (paramInt >= 0) {}
                for (localObject1 = (b)this.e.get(paramInt);; localObject1 = null)
                {
                  f1 += f3;
                  break;
                }
              }
              float f3 = a(i5, paramInt + 1).e;
              if (paramInt >= 0) {}
              for (localObject1 = (b)this.e.get(paramInt);; localObject1 = null)
              {
                i1 += 1;
                f1 += f3;
                break;
              }
              label918:
              localObject1 = null;
              break label479;
              label924:
              f2 = getPaddingRight() / i8 + 2.0F;
              break label486;
              label939:
              if ((f1 >= f2) && (i4 > i3))
              {
                if (localObject1 == null) {
                  break label526;
                }
                if ((i4 != ((b)localObject1).b) || (((b)localObject1).d)) {
                  break label1273;
                }
                this.e.remove(paramInt);
                this.i.destroyItem(this, ((b)localObject1).c, ((b)localObject1).a);
                if (paramInt < this.e.size()) {
                  localObject1 = (b)this.e.get(paramInt);
                }
              }
              label1155:
              label1265:
              label1271:
              label1273:
              for (;;)
              {
                i4 += 1;
                break label498;
                localObject1 = null;
                continue;
                if ((localObject1 != null) && (i4 == ((b)localObject1).b))
                {
                  f1 += ((b)localObject1).e;
                  paramInt += 1;
                  if (paramInt < this.e.size()) {}
                  for (localObject1 = (b)this.e.get(paramInt);; localObject1 = null) {
                    break;
                  }
                }
                localObject1 = a(i4, paramInt);
                paramInt += 1;
                f1 += ((b)localObject1).e;
                if (paramInt < this.e.size()) {}
                for (localObject1 = (b)this.e.get(paramInt);; localObject1 = null) {
                  break;
                }
                localObject1 = null;
                break label559;
                h();
                if (!hasFocus()) {
                  break;
                }
                localObject1 = findFocus();
                if (localObject1 != null) {}
                for (localObject1 = b((View)localObject1);; localObject1 = null)
                {
                  if ((localObject1 != null) && (((b)localObject1).c == this.j)) {
                    break label1271;
                  }
                  paramInt = 0;
                  for (;;)
                  {
                    if (paramInt >= getChildCount()) {
                      break label1265;
                    }
                    localObject1 = getChildAt(paramInt);
                    localObject2 = a((View)localObject1);
                    if ((localObject2 != null) && (((b)localObject2).c == this.j) && (((View)localObject1).requestFocus(i2))) {
                      break;
                    }
                    paramInt += 1;
                  }
                  break;
                }
                break;
              }
            }
          }
          label1286:
          localObject1 = null;
        }
      }
      localObject2 = null;
    }
  }
  
  protected void a(int paramInt1, float paramFloat, int paramInt2)
  {
    int i1;
    View localView;
    if (this.W > 0)
    {
      int i6 = getScrollX();
      i1 = getPaddingLeft();
      int i2 = getPaddingRight();
      int i7 = getWidth();
      int i8 = getChildCount();
      int i5 = 0;
      while (i5 < i8)
      {
        localView = getChildAt(i5);
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        int i4;
        int i3;
        if (!localLayoutParams.a)
        {
          i4 = i1;
          i3 = i2;
          i5 += 1;
          i1 = i4;
          i2 = i3;
        }
        else
        {
          switch (localLayoutParams.b & 0x7)
          {
          case 2: 
          case 4: 
          default: 
            i3 = i1;
            i4 = i2;
            i2 = i1;
            i1 = i4;
          }
          for (;;)
          {
            int i9 = i3 + i6 - localView.getLeft();
            i3 = i1;
            i4 = i2;
            if (i9 == 0) {
              break;
            }
            localView.offsetLeftAndRight(i9);
            i3 = i1;
            i4 = i2;
            break;
            i3 = localView.getWidth();
            i4 = i3 + i1;
            i3 = i1;
            i1 = i2;
            i2 = i4;
            continue;
            i3 = Math.max((i7 - localView.getMeasuredWidth()) / 2, i1);
            i4 = i1;
            i1 = i2;
            i2 = i4;
            continue;
            i3 = i7 - i2 - localView.getMeasuredWidth();
            i9 = localView.getMeasuredWidth();
            i4 = i1;
            i1 = i2 + i9;
            i2 = i4;
          }
        }
      }
    }
    if (this.aa != null) {
      this.aa.a(paramInt1, paramFloat, paramInt2);
    }
    if (this.ab != null) {
      this.ab.a(paramInt1, paramFloat, paramInt2);
    }
    if (this.ad != null)
    {
      paramInt2 = getScrollX();
      i1 = getChildCount();
      paramInt1 = 0;
      if (paramInt1 < i1)
      {
        localView = getChildAt(paramInt1);
        if (((LayoutParams)localView.getLayoutParams()).a) {}
        for (;;)
        {
          paramInt1 += 1;
          break;
          paramFloat = (localView.getLeft() - paramInt2) / getClientWidth();
          this.ad.a(localView, paramFloat);
        }
      }
    }
    this.V = true;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (getChildCount() == 0)
    {
      setScrollingCacheEnabled(false);
      return;
    }
    int i1 = getScrollX();
    int i2 = getScrollY();
    int i3 = paramInt1 - i1;
    paramInt2 -= i2;
    if ((i3 == 0) && (paramInt2 == 0))
    {
      a(false);
      c();
      setScrollState(0);
      return;
    }
    setScrollingCacheEnabled(true);
    setScrollState(2);
    paramInt1 = getClientWidth();
    int i4 = paramInt1 / 2;
    float f3 = Math.min(1.0F, Math.abs(i3) * 1.0F / paramInt1);
    float f1 = i4;
    float f2 = i4;
    f3 = a(f3);
    paramInt3 = Math.abs(paramInt3);
    if (paramInt3 > 0) {}
    for (paramInt1 = Math.round(1000.0F * Math.abs((f2 * f3 + f1) / paramInt3)) * 4;; paramInt1 = (int)((Math.abs(i3) / (f1 * f2 + this.p) + 1.0F) * 100.0F))
    {
      paramInt1 = Math.min(paramInt1, 600);
      this.n.startScroll(i1, i2, i3, paramInt2, paramInt1);
      ViewCompat.postInvalidateOnAnimation(this);
      return;
      f1 = paramInt1;
      f2 = this.i.getPageWidth(this.j);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.z = false;
    a(paramInt, paramBoolean, false);
  }
  
  void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    boolean bool = false;
    if ((this.i == null) || (this.i.getCount() <= 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    if ((!paramBoolean2) && (this.j == paramInt1) && (this.e.size() != 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    int i1 = this.A;
    if ((paramInt1 > this.j + i1) || (paramInt1 < this.j - i1))
    {
      i1 = 0;
      while (i1 < this.e.size())
      {
        ((b)this.e.get(i1)).d = true;
        i1 += 1;
      }
    }
    paramBoolean2 = bool;
    if (this.j != paramInt1) {
      paramBoolean2 = true;
    }
    if (this.T)
    {
      this.j = paramInt1;
      if ((paramBoolean2) && (this.aa != null)) {
        this.aa.a(paramInt1);
      }
      if ((paramBoolean2) && (this.ab != null)) {
        this.ab.a(paramInt1);
      }
      requestLayout();
      return;
    }
    a(paramInt1);
    a(paramInt1, paramBoolean1, paramInt2, paramBoolean2);
  }
  
  public boolean a(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0) {
      switch (paramKeyEvent.getKeyCode())
      {
      }
    }
    do
    {
      do
      {
        return false;
        return c(17);
        return c(66);
      } while (Build.VERSION.SDK_INT < 11);
      if (KeyEventCompat.hasNoModifiers(paramKeyEvent)) {
        return c(2);
      }
    } while (!KeyEventCompat.hasModifiers(paramKeyEvent, 1));
    return c(1);
  }
  
  protected boolean a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1;
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i2 = paramView.getScrollX();
      int i3 = paramView.getScrollY();
      i1 = localViewGroup.getChildCount() - 1;
      if (i1 >= 0)
      {
        localView = localViewGroup.getChildAt(i1);
        if ((paramInt2 + i2 < localView.getLeft()) || (paramInt2 + i2 >= localView.getRight()) || (paramInt3 + i3 < localView.getTop()) || (paramInt3 + i3 >= localView.getBottom()) || (!a(localView, true, paramInt1, paramInt2 + i2 - localView.getLeft(), paramInt3 + i3 - localView.getTop()))) {}
      }
    }
    while ((paramBoolean) && (ViewCompat.canScrollHorizontally(paramView, -paramInt1)))
    {
      View localView;
      return true;
      i1 -= 1;
      break;
    }
    return false;
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    int i2 = paramArrayList.size();
    int i3 = getDescendantFocusability();
    if (i3 != 393216)
    {
      int i1 = 0;
      while (i1 < getChildCount())
      {
        View localView = getChildAt(i1);
        if (localView.getVisibility() == 0)
        {
          b localb = a(localView);
          if ((localb != null) && (localb.c == this.j)) {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
        i1 += 1;
      }
    }
    if (((i3 == 262144) && (i2 != paramArrayList.size())) || (!isFocusable())) {}
    while ((((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) || (paramArrayList == null)) {
      return;
    }
    paramArrayList.add(this);
  }
  
  public void addTouchables(ArrayList<View> paramArrayList)
  {
    int i1 = 0;
    while (i1 < getChildCount())
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        b localb = a(localView);
        if ((localb != null) && (localb.c == this.j)) {
          localView.addTouchables(paramArrayList);
        }
      }
      i1 += 1;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!checkLayoutParams(paramLayoutParams)) {
      paramLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    for (;;)
    {
      LayoutParams localLayoutParams = (LayoutParams)paramLayoutParams;
      localLayoutParams.a |= paramView instanceof a;
      if (this.x)
      {
        if ((localLayoutParams != null) && (localLayoutParams.a)) {
          throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        localLayoutParams.d = true;
        addViewInLayout(paramView, paramInt, paramLayoutParams);
        return;
      }
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    }
  }
  
  b b(int paramInt)
  {
    int i1 = 0;
    while (i1 < this.e.size())
    {
      b localb = (b)this.e.get(i1);
      if (localb.c == paramInt) {
        return localb;
      }
      i1 += 1;
    }
    return null;
  }
  
  b b(View paramView)
  {
    for (;;)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent == this) {
        break;
      }
      if ((localViewParent == null) || (!(localViewParent instanceof View))) {
        return null;
      }
      paramView = (View)localViewParent;
    }
    return a(paramView);
  }
  
  void b()
  {
    int i7 = this.i.getCount();
    this.b = i7;
    int i1;
    int i2;
    int i3;
    int i5;
    int i4;
    label70:
    Object localObject;
    int i6;
    if ((this.e.size() < this.A * 2 + 1) && (this.e.size() < i7))
    {
      i1 = 1;
      i2 = this.j;
      i3 = 0;
      i5 = 0;
      i4 = i1;
      i1 = i2;
      i2 = i3;
      i3 = i5;
      if (i3 >= this.e.size()) {
        break label308;
      }
      localObject = (b)this.e.get(i3);
      i5 = this.i.getItemPosition(((b)localObject).a);
      if (i5 != -1) {
        break label164;
      }
      i5 = i3;
      i6 = i2;
      i3 = i4;
      i2 = i1;
      i1 = i6;
      i4 = i5;
    }
    for (;;)
    {
      i5 = i3;
      i6 = i2;
      i3 = i4 + 1;
      i2 = i1;
      i1 = i6;
      i4 = i5;
      break label70;
      i1 = 0;
      break;
      label164:
      if (i5 == -2)
      {
        this.e.remove(i3);
        i4 = i3 - 1;
        i3 = i2;
        if (i2 == 0)
        {
          this.i.startUpdate(this);
          i3 = 1;
        }
        this.i.destroyItem(this, ((b)localObject).c, ((b)localObject).a);
        if (this.j == ((b)localObject).c)
        {
          i2 = Math.max(0, Math.min(this.j, i7 - 1));
          i1 = i3;
          i3 = 1;
        }
      }
      else
      {
        if (((b)localObject).c != i5)
        {
          if (((b)localObject).c == this.j) {
            i1 = i5;
          }
          ((b)localObject).c = i5;
          i5 = i1;
          i6 = 1;
          i4 = i3;
          i1 = i2;
          i2 = i5;
          i3 = i6;
          continue;
          label308:
          if (i2 != 0) {
            this.i.finishUpdate(this);
          }
          Collections.sort(this.e, c);
          if (i4 != 0)
          {
            i3 = getChildCount();
            i2 = 0;
            while (i2 < i3)
            {
              localObject = (LayoutParams)getChildAt(i2).getLayoutParams();
              if (!((LayoutParams)localObject).a) {
                ((LayoutParams)localObject).c = 0.0F;
              }
              i2 += 1;
            }
            a(i1, false, true);
            requestLayout();
          }
          return;
        }
        i5 = i1;
        i6 = i4;
        i4 = i3;
        i1 = i2;
        i2 = i5;
        i3 = i6;
        continue;
      }
      i2 = i1;
      i5 = 1;
      i1 = i3;
      i3 = i5;
    }
  }
  
  void c()
  {
    a(this.j);
  }
  
  public boolean c(int paramInt)
  {
    View localView = findFocus();
    Object localObject;
    int i2;
    boolean bool;
    if (localView == this)
    {
      localObject = null;
      localView = FocusFinder.getInstance().findNextFocus(this, (View)localObject, paramInt);
      if ((localView == null) || (localView == localObject)) {
        break label308;
      }
      if (paramInt != 17) {
        break label245;
      }
      i1 = a(this.h, localView).left;
      i2 = a(this.h, (View)localObject).left;
      if ((localObject != null) && (i1 >= i2))
      {
        bool = d();
        label82:
        if (bool) {
          playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
        }
        return bool;
      }
    }
    else
    {
      if (localView == null) {
        break label354;
      }
      localObject = localView.getParent();
      if (!(localObject instanceof ViewGroup)) {
        break label359;
      }
      if (localObject != this) {}
    }
    label245:
    label308:
    label354:
    label359:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localView.getClass().getSimpleName());
        localObject = localView.getParent();
        for (;;)
        {
          if ((localObject instanceof ViewGroup))
          {
            localStringBuilder.append(" => ").append(localObject.getClass().getSimpleName());
            localObject = ((ViewParent)localObject).getParent();
            continue;
            localObject = ((ViewParent)localObject).getParent();
            break;
          }
        }
        Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + localStringBuilder.toString());
        localObject = null;
        break;
        bool = localView.requestFocus();
        break label82;
        if (paramInt == 66)
        {
          i1 = a(this.h, localView).left;
          i2 = a(this.h, (View)localObject).left;
          if ((localObject != null) && (i1 <= i2))
          {
            bool = e();
            break label82;
          }
          bool = localView.requestFocus();
          break label82;
          if ((paramInt == 17) || (paramInt == 1))
          {
            bool = d();
            break label82;
          }
          if ((paramInt == 66) || (paramInt == 2))
          {
            bool = e();
            break label82;
          }
        }
        bool = false;
        break label82;
      }
      localObject = localView;
      break;
    }
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (this.i == null) {}
    int i1;
    int i2;
    do
    {
      return false;
      i1 = getClientWidth();
      i2 = getScrollX();
      if (paramInt < 0)
      {
        if (i2 > (int)(i1 * this.t)) {}
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
      }
    } while (paramInt <= 0);
    if (i2 < (int)(i1 * this.u)) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    if ((!this.n.isFinished()) && (this.n.computeScrollOffset()))
    {
      int i1 = getScrollX();
      int i2 = getScrollY();
      int i3 = this.n.getCurrX();
      int i4 = this.n.getCurrY();
      if ((i1 != i3) || (i2 != i4))
      {
        scrollTo(i3, i4);
        if (!d(i3))
        {
          this.n.abortAnimation();
          scrollTo(0, i4);
        }
      }
      ViewCompat.postInvalidateOnAnimation(this);
      return;
    }
    a(true);
  }
  
  boolean d()
  {
    if (this.j > 0)
    {
      a(this.j - 1, true);
      return true;
    }
    return false;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (a(paramKeyEvent));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramAccessibilityEvent.getEventType() == 4096)
    {
      bool1 = super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
      return bool1;
    }
    int i2 = getChildCount();
    int i1 = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i1 >= i2) {
        break;
      }
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        b localb = a(localView);
        if ((localb != null) && (localb.c == this.j) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
          return true;
        }
      }
      i1 += 1;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i3 = 0;
    int i1 = 0;
    int i4 = ViewCompat.getOverScrollMode(this);
    boolean bool;
    if ((i4 == 0) || ((i4 == 1) && (this.i != null) && (this.i.getCount() > 1)))
    {
      int i2;
      if (!this.R.isFinished())
      {
        i3 = paramCanvas.save();
        i1 = getHeight() - getPaddingTop() - getPaddingBottom();
        i4 = getWidth();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(-i1 + getPaddingTop(), this.t * i4);
        this.R.setSize(i1, i4);
        i2 = false | this.R.draw(paramCanvas);
        paramCanvas.restoreToCount(i3);
      }
      i3 = i2;
      if (!this.S.isFinished())
      {
        i4 = paramCanvas.save();
        i3 = getWidth();
        int i5 = getHeight();
        int i6 = getPaddingTop();
        int i7 = getPaddingBottom();
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-getPaddingTop(), -(this.u + 1.0F) * i3);
        this.S.setSize(i5 - i6 - i7, i3);
        bool = i2 | this.S.draw(paramCanvas);
        paramCanvas.restoreToCount(i4);
      }
    }
    for (;;)
    {
      if (bool) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      return;
      this.R.finish();
      this.S.finish();
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.q;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  boolean e()
  {
    if ((this.i != null) && (this.j < this.i.getCount() - 1))
    {
      a(this.j + 1, true);
      return true;
    }
    return false;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return generateDefaultLayoutParams();
  }
  
  public PagerAdapter getAdapter()
  {
    return this.i;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i1 = paramInt2;
    if (this.af == 2) {
      i1 = paramInt1 - 1 - paramInt2;
    }
    return ((LayoutParams)((View)this.ag.get(i1)).getLayoutParams()).f;
  }
  
  public int getCurrentItem()
  {
    return this.j;
  }
  
  public int getOffscreenPageLimit()
  {
    return this.A;
  }
  
  public int getPageMargin()
  {
    return this.p;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.T = true;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.ai);
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i3;
    int i4;
    float f3;
    Object localObject;
    float f1;
    int i5;
    int i1;
    int i6;
    int i2;
    if ((this.p > 0) && (this.q != null) && (this.e.size() > 0) && (this.i != null))
    {
      i3 = getScrollX();
      i4 = getWidth();
      f3 = this.p / i4;
      localObject = (b)this.e.get(0);
      f1 = ((b)localObject).f;
      i5 = this.e.size();
      i1 = ((b)localObject).c;
      i6 = ((b)this.e.get(i5 - 1)).c;
      i2 = 0;
    }
    for (;;)
    {
      float f2;
      if (i1 < i6)
      {
        while ((i1 > ((b)localObject).c) && (i2 < i5))
        {
          localObject = this.e;
          i2 += 1;
          localObject = (b)((ArrayList)localObject).get(i2);
        }
        if (i1 != ((b)localObject).c) {
          break label271;
        }
        f2 = (((b)localObject).f + ((b)localObject).e) * i4;
      }
      label271:
      float f4;
      for (f1 = ((b)localObject).f + ((b)localObject).e + f3;; f1 += f4 + f3)
      {
        if (this.p + f2 > i3)
        {
          this.q.setBounds((int)f2, this.r, (int)(this.p + f2 + 0.5F), this.s);
          this.q.draw(paramCanvas);
        }
        if (f2 <= i3 + i4) {
          break;
        }
        return;
        f4 = this.i.getPageWidth(i1);
        f2 = (f1 + f4) * i4;
      }
      i1 += 1;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if ((i1 == 3) || (i1 == 1))
    {
      this.B = false;
      this.C = false;
      this.K = -1;
      if (this.L != null)
      {
        this.L.recycle();
        this.L = null;
      }
    }
    do
    {
      return false;
      if (i1 == 0) {
        break;
      }
      if (this.B) {
        return true;
      }
    } while (this.C);
    switch (i1)
    {
    }
    for (;;)
    {
      if (this.L == null) {
        this.L = VelocityTracker.obtain();
      }
      this.L.addMovement(paramMotionEvent);
      return this.B;
      i1 = this.K;
      if (i1 != -1)
      {
        i1 = MotionEventCompat.findPointerIndex(paramMotionEvent, i1);
        float f2 = MotionEventCompat.getX(paramMotionEvent, i1);
        float f1 = f2 - this.G;
        float f4 = Math.abs(f1);
        float f3 = MotionEventCompat.getY(paramMotionEvent, i1);
        float f5 = Math.abs(f3 - this.J);
        if ((f1 != 0.0F) && (!a(this.G, f1)) && (a(this, false, (int)f1, (int)f2, (int)f3)))
        {
          this.G = f2;
          this.H = f3;
          this.C = true;
          return false;
        }
        if ((f4 > this.F) && (0.5F * f4 > f5))
        {
          this.B = true;
          c(true);
          setScrollState(1);
          if (f1 > 0.0F)
          {
            f1 = this.I + this.F;
            label310:
            this.G = f1;
            this.H = f3;
            setScrollingCacheEnabled(true);
          }
        }
        while ((this.B) && (b(f2)))
        {
          ViewCompat.postInvalidateOnAnimation(this);
          break;
          f1 = this.I - this.F;
          break label310;
          if (f5 > this.F) {
            this.C = true;
          }
        }
        f1 = paramMotionEvent.getX();
        this.I = f1;
        this.G = f1;
        f1 = paramMotionEvent.getY();
        this.J = f1;
        this.H = f1;
        this.K = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        this.C = false;
        this.n.computeScrollOffset();
        if ((this.aj == 2) && (Math.abs(this.n.getFinalX() - this.n.getCurrX()) > this.P))
        {
          this.n.abortAnimation();
          this.z = false;
          c();
          this.B = true;
          c(true);
          setScrollState(1);
        }
        else
        {
          a(false);
          this.B = false;
          continue;
          a(paramMotionEvent);
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i6 = getChildCount();
    int i8 = paramInt3 - paramInt1;
    int i7 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    int i1 = getPaddingRight();
    paramInt3 = getPaddingBottom();
    int i9 = getScrollX();
    int i2 = 0;
    int i4 = 0;
    View localView;
    LayoutParams localLayoutParams;
    int i10;
    int i3;
    label154:
    int i5;
    if (i4 < i6)
    {
      localView = getChildAt(i4);
      if (localView.getVisibility() == 8) {
        break label671;
      }
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (!localLayoutParams.a) {
        break label671;
      }
      paramInt4 = localLayoutParams.b;
      i10 = localLayoutParams.b;
      switch (paramInt4 & 0x7)
      {
      case 2: 
      case 4: 
      default: 
        paramInt4 = paramInt2;
        i3 = paramInt2;
        switch (i10 & 0x70)
        {
        default: 
          i5 = paramInt1;
          paramInt2 = paramInt1;
          paramInt1 = paramInt3;
          paramInt3 = i5;
          label204:
          paramInt4 += i9;
          localView.layout(paramInt4, paramInt3, localView.getMeasuredWidth() + paramInt4, localView.getMeasuredHeight() + paramInt3);
          i2 += 1;
          paramInt4 = i1;
          paramInt3 = i3;
          i1 = paramInt1;
          paramInt1 = i2;
        }
        break;
      }
    }
    for (;;)
    {
      i4 += 1;
      i3 = paramInt3;
      i2 = paramInt1;
      paramInt1 = paramInt2;
      paramInt3 = i1;
      i1 = paramInt4;
      paramInt2 = i3;
      break;
      i3 = localView.getMeasuredWidth();
      paramInt4 = paramInt2;
      i3 += paramInt2;
      break label154;
      paramInt4 = Math.max((i8 - localView.getMeasuredWidth()) / 2, paramInt2);
      i3 = paramInt2;
      break label154;
      i3 = localView.getMeasuredWidth();
      paramInt4 = i1 + localView.getMeasuredWidth();
      i5 = i8 - i1 - i3;
      i1 = paramInt4;
      i3 = paramInt2;
      paramInt4 = i5;
      break label154;
      i5 = localView.getMeasuredHeight();
      paramInt2 = paramInt3;
      i5 += paramInt1;
      paramInt3 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i5;
      break label204;
      i5 = Math.max((i7 - localView.getMeasuredHeight()) / 2, paramInt1);
      paramInt2 = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = i5;
      break label204;
      i5 = i7 - paramInt3 - localView.getMeasuredHeight();
      i10 = localView.getMeasuredHeight();
      paramInt2 = paramInt1;
      paramInt1 = paramInt3 + i10;
      paramInt3 = i5;
      break label204;
      i1 = i8 - paramInt2 - i1;
      paramInt4 = 0;
      while (paramInt4 < i6)
      {
        localView = getChildAt(paramInt4);
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.a)
          {
            b localb = a(localView);
            if (localb != null)
            {
              float f1 = i1;
              i3 = (int)(localb.f * f1) + paramInt2;
              if (localLayoutParams.d)
              {
                localLayoutParams.d = false;
                f1 = i1;
                localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.c * f1), 1073741824), View.MeasureSpec.makeMeasureSpec(i7 - paramInt1 - paramInt3, 1073741824));
              }
              localView.layout(i3, paramInt1, localView.getMeasuredWidth() + i3, localView.getMeasuredHeight() + paramInt1);
            }
          }
        }
        paramInt4 += 1;
      }
      this.r = paramInt1;
      this.s = (i7 - paramInt3);
      this.W = i2;
      if (this.T) {
        a(this.j, false, 0, false);
      }
      this.T = false;
      return;
      label671:
      paramInt4 = i2;
      i2 = paramInt1;
      i3 = paramInt2;
      paramInt1 = paramInt4;
      paramInt4 = i1;
      i1 = paramInt3;
      paramInt2 = i2;
      paramInt3 = i3;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    this.E = Math.min(paramInt1 / 10, this.D);
    paramInt1 = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int i9 = getChildCount();
    int i3 = 0;
    View localView;
    int i1;
    int i2;
    LayoutParams localLayoutParams;
    int i4;
    int i6;
    label183:
    int i5;
    if (i3 < i9)
    {
      localView = getChildAt(i3);
      i1 = paramInt1;
      i2 = paramInt2;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i1 = paramInt1;
        i2 = paramInt2;
        if (localLayoutParams != null)
        {
          i1 = paramInt1;
          i2 = paramInt2;
          if (localLayoutParams.a)
          {
            i1 = localLayoutParams.b & 0x7;
            i4 = localLayoutParams.b & 0x70;
            i6 = Integer.MIN_VALUE;
            i2 = Integer.MIN_VALUE;
            if ((i4 != 48) && (i4 != 80)) {
              break label333;
            }
            i4 = 1;
            if ((i1 != 3) && (i1 != 5)) {
              break label339;
            }
            i5 = 1;
            label198:
            if (i4 == 0) {
              break label345;
            }
            i1 = 1073741824;
            label208:
            if (localLayoutParams.width == -2) {
              break label528;
            }
            i6 = 1073741824;
            if (localLayoutParams.width == -1) {
              break label522;
            }
            i1 = localLayoutParams.width;
          }
        }
      }
    }
    for (;;)
    {
      int i8;
      if (localLayoutParams.height != -2)
      {
        i7 = 1073741824;
        i2 = i7;
        if (localLayoutParams.height != -1)
        {
          i8 = localLayoutParams.height;
          i2 = i7;
        }
      }
      for (int i7 = i8;; i7 = paramInt2)
      {
        localView.measure(View.MeasureSpec.makeMeasureSpec(i1, i6), View.MeasureSpec.makeMeasureSpec(i7, i2));
        if (i4 != 0)
        {
          i2 = paramInt2 - localView.getMeasuredHeight();
          i1 = paramInt1;
        }
        for (;;)
        {
          i3 += 1;
          paramInt1 = i1;
          paramInt2 = i2;
          break;
          label333:
          i4 = 0;
          break label183;
          label339:
          i5 = 0;
          break label198;
          label345:
          i1 = i6;
          if (i5 == 0) {
            break label208;
          }
          i2 = 1073741824;
          i1 = i6;
          break label208;
          i1 = paramInt1;
          i2 = paramInt2;
          if (i5 != 0)
          {
            i1 = paramInt1 - localView.getMeasuredWidth();
            i2 = paramInt2;
          }
        }
        this.v = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
        this.w = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
        this.x = true;
        c();
        this.x = false;
        i1 = getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i1)
        {
          localView = getChildAt(paramInt2);
          if (localView.getVisibility() != 8)
          {
            localLayoutParams = (LayoutParams)localView.getLayoutParams();
            if ((localLayoutParams == null) || (!localLayoutParams.a))
            {
              float f1 = paramInt1;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.c * f1), 1073741824), this.w);
            }
          }
          paramInt2 += 1;
        }
        return;
      }
      label522:
      i1 = paramInt1;
      continue;
      label528:
      i6 = i1;
      i1 = paramInt1;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i3 = -1;
    int i2 = getChildCount();
    int i1;
    if ((paramInt & 0x2) != 0)
    {
      i3 = 1;
      i1 = 0;
    }
    while (i1 != i2)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        b localb = a(localView);
        if ((localb != null) && (localb.c == this.j) && (localView.requestFocus(paramInt, paramRect)))
        {
          return true;
          i1 = i2 - 1;
          i2 = -1;
          continue;
        }
      }
      i1 += i3;
    }
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (this.i != null)
    {
      this.i.restoreState(paramParcelable.b, paramParcelable.c);
      a(paramParcelable.a, false, true);
      return;
    }
    this.k = paramParcelable.a;
    this.l = paramParcelable.b;
    this.m = paramParcelable.c;
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.a = this.j;
    if (this.i != null) {
      localSavedState.b = this.i.saveState();
    }
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      a(paramInt1, paramInt3, this.p, this.p);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i4 = 0;
    if (this.Q) {
      return true;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    if ((this.i == null) || (this.i.getCount() == 0)) {
      return false;
    }
    if (this.L == null) {
      this.L = VelocityTracker.obtain();
    }
    this.L.addMovement(paramMotionEvent);
    int i1 = i4;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      i1 = i4;
    }
    for (;;)
    {
      if (i1 != 0) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      return true;
      this.n.abortAnimation();
      this.z = false;
      c();
      float f1 = paramMotionEvent.getX();
      this.I = f1;
      this.G = f1;
      f1 = paramMotionEvent.getY();
      this.J = f1;
      this.H = f1;
      this.K = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      i1 = i4;
      continue;
      float f2;
      if (!this.B)
      {
        i1 = MotionEventCompat.findPointerIndex(paramMotionEvent, this.K);
        f1 = MotionEventCompat.getX(paramMotionEvent, i1);
        float f3 = Math.abs(f1 - this.G);
        f2 = MotionEventCompat.getY(paramMotionEvent, i1);
        float f4 = Math.abs(f2 - this.H);
        if ((f3 > this.F) && (f3 > f4))
        {
          this.B = true;
          c(true);
          if (f1 - this.I <= 0.0F) {
            break label378;
          }
        }
      }
      Object localObject;
      label378:
      for (f1 = this.I + this.F;; f1 = this.I - this.F)
      {
        this.G = f1;
        this.H = f2;
        setScrollState(1);
        setScrollingCacheEnabled(true);
        localObject = getParent();
        if (localObject != null) {
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
        }
        i1 = i4;
        if (!this.B) {
          break;
        }
        bool1 = false | b(MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.K)));
        break;
      }
      boolean bool1 = i4;
      if (this.B)
      {
        localObject = this.L;
        ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.N);
        int i2 = (int)VelocityTrackerCompat.getXVelocity((VelocityTracker)localObject, this.K);
        this.z = true;
        i4 = getClientWidth();
        int i5 = getScrollX();
        localObject = i();
        a(a((b)localObject, ((b)localObject).c, (i5 / i4 - ((b)localObject).f) / ((b)localObject).e, i2, (int)(MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.K)) - this.I)), true, true, i2);
        this.K = -1;
        j();
        boolean bool3 = this.R.onRelease();
        boolean bool2 = this.S.onRelease() | bool3;
        continue;
        bool2 = i4;
        if (this.B)
        {
          a(this.j, true, 0, false);
          this.K = -1;
          j();
          bool3 = this.R.onRelease();
          bool2 = this.S.onRelease() | bool3;
          continue;
          int i3 = MotionEventCompat.getActionIndex(paramMotionEvent);
          this.G = MotionEventCompat.getX(paramMotionEvent, i3);
          this.K = MotionEventCompat.getPointerId(paramMotionEvent, i3);
          i3 = i4;
          continue;
          a(paramMotionEvent);
          this.G = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.K));
          i3 = i4;
        }
      }
    }
  }
  
  public void removeView(View paramView)
  {
    if (this.x)
    {
      removeViewInLayout(paramView);
      return;
    }
    super.removeView(paramView);
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    if (this.i != null)
    {
      this.i.unregisterDataSetObserver(this.o);
      this.i.startUpdate(this);
      int i1 = 0;
      while (i1 < this.e.size())
      {
        localObject = (b)this.e.get(i1);
        this.i.destroyItem(this, ((b)localObject).c, ((b)localObject).a);
        i1 += 1;
      }
      this.i.finishUpdate(this);
      this.e.clear();
      g();
      this.j = 0;
      scrollTo(0, 0);
    }
    Object localObject = this.i;
    this.i = paramPagerAdapter;
    this.b = 0;
    boolean bool;
    if (this.i != null)
    {
      if (this.o == null) {
        this.o = new g(null);
      }
      this.i.registerDataSetObserver(this.o);
      this.z = false;
      bool = this.T;
      this.T = true;
      this.b = this.i.getCount();
      if (this.k < 0) {
        break label255;
      }
      this.i.restoreState(this.l, this.m);
      a(this.k, false, true);
      this.k = -1;
      this.l = null;
      this.m = null;
    }
    for (;;)
    {
      if ((this.ac != null) && (localObject != paramPagerAdapter)) {
        this.ac.a((PagerAdapter)localObject, paramPagerAdapter);
      }
      return;
      label255:
      if (!bool) {
        c();
      } else {
        requestLayout();
      }
    }
  }
  
  void setChildrenDrawingOrderEnabledCompat(boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT < 7) || (this.ae == null)) {}
    try
    {
      this.ae = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] { Boolean.TYPE });
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        try
        {
          this.ae.invoke(this, new Object[] { Boolean.valueOf(paramBoolean) });
          return;
        }
        catch (Exception localException)
        {
          Log.e("ViewPager", "Error changing children drawing order", localException);
        }
        localNoSuchMethodException = localNoSuchMethodException;
        Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", localNoSuchMethodException);
      }
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    int i1 = this.b;
    int i2 = this.j;
    int i3 = this.b;
    int i4 = this.b;
    int i5 = this.b;
    int i6 = this.b;
    int i7 = this.b;
    int i8 = this.j;
    this.z = false;
    if (!this.T) {}
    for (boolean bool = true;; bool = false)
    {
      a(i8 + ((i5 + paramInt % i6) % i7 - (i1 + i2 % i3) % i4), bool, false);
      return;
    }
  }
  
  public void setLoopEnable(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 1)
    {
      Log.w("ViewPager", "Requested offscreen page limit " + paramInt + " too small; defaulting to " + 1);
      i1 = 1;
    }
    if (i1 != this.A)
    {
      this.A = i1;
      c();
    }
  }
  
  void setOnAdapterChangeListener(d paramd)
  {
    this.ac = paramd;
  }
  
  public void setOnPageChangeListener(e parame)
  {
    this.aa = parame;
  }
  
  public void setPageMargin(int paramInt)
  {
    int i1 = this.p;
    this.p = paramInt;
    int i2 = getWidth();
    a(i2, i2, paramInt, i1);
    requestLayout();
  }
  
  public void setPageMarginDrawable(int paramInt)
  {
    setPageMarginDrawable(getContext().getResources().getDrawable(paramInt));
  }
  
  public void setPageMarginDrawable(Drawable paramDrawable)
  {
    this.q = paramDrawable;
    if (paramDrawable != null) {
      refreshDrawableState();
    }
    if (paramDrawable == null) {}
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.q);
  }
  
  public static class LayoutParams
    extends ViewGroup.LayoutParams
  {
    public boolean a;
    public int b;
    float c = 0.0F;
    boolean d;
    int e;
    int f;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, LoopViewPager.f());
      this.b = paramContext.getInteger(0, 48);
      paramContext.recycle();
    }
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new p());
    int a;
    Parcelable b;
    ClassLoader c;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super();
      ClassLoader localClassLoader = paramClassLoader;
      if (paramClassLoader == null) {
        localClassLoader = getClass().getClassLoader();
      }
      this.a = paramParcel.readInt();
      this.b = paramParcel.readParcelable(localClassLoader);
      this.c = localClassLoader;
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.a + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.a);
      paramParcel.writeParcelable(this.b, paramInt);
    }
  }
  
  static abstract interface a {}
  
  static class b
  {
    Object a;
    int b;
    int c;
    boolean d;
    float e;
    float f;
  }
  
  class c
    extends AccessibilityDelegateCompat
  {
    c() {}
    
    private boolean a()
    {
      return (LoopViewPager.a(LoopViewPager.this) != null) && (LoopViewPager.a(LoopViewPager.this).getCount() > 1);
    }
    
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(LoopViewPager.class.getName());
      paramView = AccessibilityRecordCompat.obtain();
      paramView.setScrollable(a());
      if ((paramAccessibilityEvent.getEventType() == 4096) && (LoopViewPager.a(LoopViewPager.this) != null))
      {
        paramView.setItemCount(LoopViewPager.a(LoopViewPager.this).getCount());
        paramView.setFromIndex(LoopViewPager.b(LoopViewPager.this));
        paramView.setToIndex(LoopViewPager.b(LoopViewPager.this));
      }
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      paramAccessibilityNodeInfoCompat.setClassName(LoopViewPager.class.getName());
      paramAccessibilityNodeInfoCompat.setScrollable(a());
      if (LoopViewPager.this.canScrollHorizontally(1)) {
        paramAccessibilityNodeInfoCompat.addAction(4096);
      }
      if (LoopViewPager.this.canScrollHorizontally(-1)) {
        paramAccessibilityNodeInfoCompat.addAction(8192);
      }
    }
    
    public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
        return true;
      }
      switch (paramInt)
      {
      default: 
        return false;
      case 4096: 
        if (LoopViewPager.this.canScrollHorizontally(1))
        {
          LoopViewPager.this.setCurrentItem(LoopViewPager.b(LoopViewPager.this) + 1);
          return true;
        }
        return false;
      }
      if (LoopViewPager.this.canScrollHorizontally(-1))
      {
        LoopViewPager.this.setCurrentItem(LoopViewPager.b(LoopViewPager.this) - 1);
        return true;
      }
      return false;
    }
  }
  
  static abstract interface d
  {
    public abstract void a(PagerAdapter paramPagerAdapter1, PagerAdapter paramPagerAdapter2);
  }
  
  public static abstract interface e
  {
    public abstract void a(int paramInt);
    
    public abstract void a(int paramInt1, float paramFloat, int paramInt2);
    
    public abstract void b(int paramInt);
  }
  
  public static abstract interface f
  {
    public abstract void a(View paramView, float paramFloat);
  }
  
  private class g
    extends DataSetObserver
  {
    private g() {}
    
    public void onChanged()
    {
      LoopViewPager.this.b();
    }
    
    public void onInvalidated()
    {
      LoopViewPager.this.b();
    }
  }
  
  static class h
    implements Comparator<View>
  {
    public int a(View paramView1, View paramView2)
    {
      paramView1 = (LoopViewPager.LayoutParams)paramView1.getLayoutParams();
      paramView2 = (LoopViewPager.LayoutParams)paramView2.getLayoutParams();
      if (paramView1.a != paramView2.a)
      {
        if (paramView1.a) {
          return 1;
        }
        return -1;
      }
      return paramView1.e - paramView2.e;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\LoopViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */