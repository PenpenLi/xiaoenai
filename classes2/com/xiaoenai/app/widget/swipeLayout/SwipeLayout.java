package com.xiaoenai.app.widget.swipeLayout;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.xiaoenai.app.R.styleable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SwipeLayout
  extends FrameLayout
{
  private ViewDragHelper a = ViewDragHelper.create(this, this.k);
  private int b = 0;
  private b c;
  private e d;
  private List<i> e = new ArrayList();
  private List<g> f = new ArrayList();
  private Map<View, ArrayList<d>> g = new HashMap();
  private Map<View, Boolean> h = new HashMap();
  private a i;
  private boolean j = true;
  private ViewDragHelper.Callback k = new b(this);
  private int l = 0;
  private List<c> m;
  private boolean n = false;
  private float o = -1.0F;
  private float p = -1.0F;
  private GestureDetector q = new GestureDetector(getContext(), new h());
  
  public SwipeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwipeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SwipeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SwipeLayout);
    paramInt = paramContext.getInt(0, b.b.ordinal());
    this.c = b.values()[paramInt];
    paramInt = paramContext.getInt(5, e.b.ordinal());
    this.d = e.values()[paramInt];
  }
  
  private int a(float paramFloat)
  {
    return (int)(getContext().getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private Rect a(b paramb)
  {
    int i3 = getPaddingLeft();
    int i2 = getPaddingTop();
    int i1;
    int i4;
    if (paramb == b.b)
    {
      i1 = getMeasuredWidth() - this.b;
      if ((paramb != b.a) && (paramb != b.b)) {
        break label98;
      }
      i4 = i1 + this.b;
    }
    for (i3 = getMeasuredHeight() + i2;; i3 = this.b + i2)
    {
      return new Rect(i1, i2, i4, i3);
      i1 = i3;
      if (paramb != b.d) {
        break;
      }
      i2 = getMeasuredHeight() - this.b;
      i1 = i3;
      break;
      label98:
      i4 = i1 + getMeasuredWidth();
    }
  }
  
  private Rect a(e parame, Rect paramRect)
  {
    int i1 = paramRect.left;
    int i2 = paramRect.top;
    int i3 = paramRect.right;
    int i4 = paramRect.bottom;
    int i5;
    if (parame == e.b) {
      if (this.c == b.a)
      {
        i1 = paramRect.left - this.b;
        if ((this.c != b.a) && (this.c != b.b)) {
          break label169;
        }
        i5 = paramRect.bottom;
        i3 = getBottomView().getMeasuredWidth();
        i4 = i1;
        i1 = i3 + i1;
        i3 = i2;
        i2 = i1;
        i1 = i5;
      }
    }
    for (;;)
    {
      return new Rect(i4, i3, i2, i1);
      if (this.c == b.b)
      {
        i1 = paramRect.right;
        break;
      }
      if (this.c == b.c)
      {
        i2 = paramRect.top - this.b;
        break;
      }
      i2 = paramRect.bottom;
      break;
      label169:
      i4 = getBottomView().getMeasuredHeight();
      i5 = paramRect.right;
      i3 = i2;
      int i6 = i4 + i2;
      i4 = i1;
      i2 = i5;
      i1 = i6;
      continue;
      if (parame == e.a)
      {
        if (this.c == b.a)
        {
          i5 = this.b;
          i3 = i2;
          i2 = i4;
          i4 = i1;
          i5 += i1;
          i1 = i2;
          i2 = i5;
        }
        else if (this.c == b.b)
        {
          i6 = this.b;
          i5 = i2;
          i1 = i4;
          i4 = i3 - i6;
          i2 = i3;
          i3 = i5;
        }
        else if (this.c == b.c)
        {
          i5 = this.b;
          i4 = i2;
          i6 = i5 + i2;
          i5 = i1;
          i2 = i3;
          i1 = i6;
          i3 = i4;
          i4 = i5;
        }
        else
        {
          i5 = i4 - this.b;
          i2 = i4;
          i4 = i1;
          i1 = i2;
          i2 = i3;
          i3 = i5;
        }
      }
      else
      {
        i5 = i2;
        i2 = i4;
        i4 = i1;
        i1 = i2;
        i2 = i3;
        i3 = i5;
      }
    }
  }
  
  private View a(ViewGroup paramViewGroup, MotionEvent paramMotionEvent)
  {
    Object localObject;
    if (paramViewGroup == null) {
      localObject = null;
    }
    do
    {
      return (View)localObject;
      localObject = paramViewGroup;
    } while (paramViewGroup.onTouchEvent(paramMotionEvent));
    int i1 = paramViewGroup.getChildCount() - 1;
    while (i1 >= 0)
    {
      localObject = paramViewGroup.getChildAt(i1);
      if ((localObject instanceof ViewGroup))
      {
        localObject = a((ViewGroup)localObject, paramMotionEvent);
        if (localObject != null) {
          return (View)localObject;
        }
      }
      else if (a(paramViewGroup.getChildAt(i1), paramMotionEvent))
      {
        return paramViewGroup.getChildAt(i1);
      }
      i1 -= 1;
    }
    return null;
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 == 0.0F) && (getOpenStatus() == f.a)) {
      e();
    }
    if ((this.c == b.a) || (this.c == b.b)) {
      if (paramFloat1 > 0.0F)
      {
        if (this.c == b.a) {
          d();
        }
      }
      else if (paramFloat1 < 0.0F)
      {
        if (this.c != b.a) {
          break label88;
        }
        e();
      }
    }
    for (;;)
    {
      return;
      e();
      break;
      label88:
      d();
      return;
      if (paramFloat2 > 0.0F)
      {
        if (this.c != b.c) {
          break label134;
        }
        d();
      }
      while (paramFloat2 < 0.0F)
      {
        if (this.c != b.c) {
          break label141;
        }
        e();
        return;
        label134:
        e();
      }
    }
    label141:
    d();
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    for (paramMotionEvent = getParent();; paramMotionEvent = paramMotionEvent.getParent())
    {
      if (paramMotionEvent != null)
      {
        if (!(paramMotionEvent instanceof AdapterView)) {
          break label56;
        }
        localAdapterView = (AdapterView)paramMotionEvent;
        i1 = localAdapterView.getPositionForView(this);
        if ((i1 == -1) || (!localAdapterView.performItemClick(localAdapterView.getChildAt(i1), i1, localAdapterView.getAdapter().getItemId(i1)))) {
          continue;
        }
      }
      label56:
      while (((paramMotionEvent instanceof View)) && (((View)paramMotionEvent).performClick()))
      {
        AdapterView localAdapterView;
        int i1;
        return;
      }
    }
  }
  
  private boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == null) {}
    int i1;
    int i2;
    do
    {
      return false;
      int[] arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      i1 = arrayOfInt[0];
      i2 = arrayOfInt[1];
    } while ((paramMotionEvent.getRawX() <= i1) || (paramMotionEvent.getRawX() >= i1 + paramView.getWidth()) || (paramMotionEvent.getRawY() <= i2) || (paramMotionEvent.getRawY() >= i2 + paramView.getHeight()));
    return paramView.onTouchEvent(paramMotionEvent);
  }
  
  private void b(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 == 0.0F) && (getOpenStatus() == f.a)) {
      e();
    }
    if ((this.c == b.a) || (this.c == b.b)) {
      if (paramFloat1 > 0.0F)
      {
        if (this.c == b.a) {
          d();
        }
      }
      else if (paramFloat1 < 0.0F)
      {
        if (this.c != b.a) {
          break label88;
        }
        e();
      }
    }
    for (;;)
    {
      return;
      e();
      break;
      label88:
      d();
      return;
      if (paramFloat2 > 0.0F)
      {
        if (this.c != b.c) {
          break label134;
        }
        d();
      }
      while (paramFloat2 < 0.0F)
      {
        if (this.c != b.c) {
          break label141;
        }
        e();
        return;
        label134:
        e();
      }
    }
    label141:
    d();
  }
  
  private void c(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 == 0.0F) && (getOpenStatus() == f.a)) {
      e();
    }
    int i2 = getPaddingLeft();
    int i3 = getPaddingTop();
    int i1 = i2;
    if (paramFloat1 < 0.0F)
    {
      i1 = i2;
      if (this.c == b.b) {
        i1 = i2 - this.b;
      }
    }
    i2 = i1;
    if (paramFloat1 > 0.0F)
    {
      i2 = i1;
      if (this.c == b.a) {
        i2 = i1 + this.b;
      }
    }
    i1 = i3;
    if (paramFloat2 > 0.0F)
    {
      i1 = i3;
      if (this.c == b.c) {
        i1 = i3 + this.b;
      }
    }
    i3 = i1;
    if (paramFloat2 < 0.0F)
    {
      i3 = i1;
      if (this.c == b.d) {
        i3 = i1 - this.b;
      }
    }
    this.a.smoothSlideViewTo(getSurfaceView(), i2, i3);
    invalidate();
  }
  
  private Rect d(boolean paramBoolean)
  {
    int i3 = getPaddingLeft();
    int i4 = getPaddingTop();
    int i1 = i4;
    int i2 = i3;
    if (paramBoolean)
    {
      if (this.c != b.a) {
        break label67;
      }
      i2 = getPaddingLeft() + this.b;
      i1 = i4;
    }
    for (;;)
    {
      return new Rect(i2, i1, getMeasuredWidth() + i2, getMeasuredHeight() + i1);
      label67:
      if (this.c == b.b)
      {
        i2 = getPaddingLeft() - this.b;
        i1 = i4;
      }
      else if (this.c == b.c)
      {
        i1 = getPaddingTop() + this.b;
        i2 = i3;
      }
      else
      {
        i1 = getPaddingTop() - this.b;
        i2 = i3;
      }
    }
  }
  
  private void f()
  {
    f localf = getOpenStatus();
    ViewGroup localViewGroup = getBottomView();
    if (localf == f.c) {}
    while (localViewGroup.getVisibility() == 0) {
      return;
    }
    localViewGroup.setVisibility(0);
  }
  
  private boolean g()
  {
    AdapterView localAdapterView = getAdapterView();
    if (localAdapterView != null)
    {
      Adapter localAdapter = localAdapterView.getAdapter();
      if (localAdapter != null)
      {
        int i1 = localAdapterView.getPositionForView(this);
        if ((localAdapter instanceof BaseAdapter)) {
          return ((BaseAdapter)localAdapter).isEnabled(i1);
        }
        if ((localAdapter instanceof ListAdapter)) {
          return ((ListAdapter)localAdapter).isEnabled(i1);
        }
      }
    }
    return true;
  }
  
  private AdapterView getAdapterView()
  {
    for (ViewParent localViewParent = getParent(); localViewParent != null; localViewParent = localViewParent.getParent()) {
      if ((localViewParent instanceof AdapterView)) {
        return (AdapterView)localViewParent;
      }
    }
    return null;
  }
  
  protected Rect a(View paramView)
  {
    Rect localRect = new Rect(paramView.getLeft(), paramView.getTop(), 0, 0);
    View localView = paramView;
    for (;;)
    {
      if ((localView.getParent() != null) && (localView != getRootView()))
      {
        localView = (View)localView.getParent();
        if (localView != this) {}
      }
      else
      {
        localRect.right = (localRect.left + paramView.getMeasuredWidth());
        localRect.bottom = (localRect.top + paramView.getMeasuredHeight());
        return localRect;
      }
      localRect.left += localView.getLeft();
      localRect.top += localView.getTop();
    }
  }
  
  void a()
  {
    Rect localRect = d(false);
    getSurfaceView().layout(localRect.left, localRect.top, localRect.right, localRect.bottom);
    localRect = a(e.b, localRect);
    getBottomView().layout(localRect.left, localRect.top, localRect.right, localRect.bottom);
    bringChildToFront(getSurfaceView());
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = false;
    b localb = getDragEdge();
    if (localb == b.a) {
      if (paramInt3 >= 0) {
        break label42;
      }
    }
    for (;;)
    {
      a(paramInt1, paramInt2, bool);
      return;
      if (localb == b.b)
      {
        if (paramInt3 > 0) {}
      }
      else {
        label42:
        label64:
        do
        {
          do
          {
            bool = true;
            break;
            if (localb != b.c) {
              break label64;
            }
          } while (paramInt4 >= 0);
          break;
        } while ((localb != b.d) || (paramInt4 <= 0));
      }
    }
  }
  
  protected void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    f();
    Object localObject = getOpenStatus();
    if (!this.e.isEmpty())
    {
      this.l += 1;
      Iterator localIterator = this.e.iterator();
      if (localIterator.hasNext())
      {
        i locali = (i)localIterator.next();
        if (this.l == 1)
        {
          if (!paramBoolean) {
            break label108;
          }
          locali.a(this);
        }
        for (;;)
        {
          locali.a(this, paramInt1 - getPaddingLeft(), paramInt2 - getPaddingTop());
          break;
          label108:
          locali.c(this);
        }
      }
      if (localObject == f.c)
      {
        localIterator = this.e.iterator();
        while (localIterator.hasNext()) {
          ((i)localIterator.next()).d(this);
        }
        this.l = 0;
      }
      if (localObject == f.b)
      {
        getBottomView().setEnabled(true);
        localObject = this.e.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((i)((Iterator)localObject).next()).b(this);
        }
        this.l = 0;
      }
    }
  }
  
  public void a(i parami)
  {
    this.e.add(parami);
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, true);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = getSurfaceView();
    ViewGroup localViewGroup = getBottomView();
    Rect localRect = d(true);
    if (paramBoolean1) {
      this.a.smoothSlideViewTo(getSurfaceView(), localRect.left, localRect.top);
    }
    for (;;)
    {
      invalidate();
      return;
      int i1 = localRect.left;
      int i2 = ((ViewGroup)localObject).getLeft();
      int i3 = localRect.top;
      int i4 = ((ViewGroup)localObject).getTop();
      ((ViewGroup)localObject).layout(localRect.left, localRect.top, localRect.right, localRect.bottom);
      if (getShowMode() == e.b)
      {
        localObject = a(e.b, localRect);
        localViewGroup.layout(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, ((Rect)localObject).bottom);
      }
      if (paramBoolean2)
      {
        b(localRect.left, localRect.top, localRect.right, localRect.bottom);
        a(localRect.left, localRect.top, i1 - i2, i3 - i4);
      }
      else
      {
        f();
      }
    }
  }
  
  protected boolean a(View paramView, Rect paramRect, b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((Boolean)this.h.get(paramView)).booleanValue()) {
      return false;
    }
    int i1 = paramRect.left;
    int i2 = paramRect.right;
    int i3 = paramRect.top;
    int i4 = paramRect.bottom;
    boolean bool;
    if (getShowMode() == e.a)
    {
      if (((paramb != b.b) || (paramInt3 > i1)) && ((paramb != b.a) || (paramInt1 < i2)) && ((paramb != b.c) || (paramInt2 < i4)) && ((paramb != b.d) || (paramInt4 > i3))) {
        break label197;
      }
      bool = true;
    }
    for (;;)
    {
      return bool;
      if ((getShowMode() == e.b) && (((paramb == b.b) && (i2 <= getWidth())) || ((paramb == b.a) && (i1 >= getPaddingLeft())) || ((paramb == b.c) && (i3 >= getPaddingTop())) || ((paramb == b.d) && (i4 <= getHeight())))) {
        bool = true;
      } else {
        label197:
        bool = false;
      }
    }
  }
  
  void b()
  {
    Rect localRect = d(false);
    getSurfaceView().layout(localRect.left, localRect.top, localRect.right, localRect.bottom);
    localRect = a(e.a, localRect);
    getBottomView().layout(localRect.left, localRect.top, localRect.right, localRect.bottom);
    bringChildToFront(getSurfaceView());
  }
  
  protected void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    label12:
    Iterator localIterator1;
    if (this.g.isEmpty()) {
      return;
    } else {
      localIterator1 = this.g.entrySet().iterator();
    }
    for (;;)
    {
      if (!localIterator1.hasNext()) {
        break label12;
      }
      Object localObject1 = (Map.Entry)localIterator1.next();
      View localView = (View)((Map.Entry)localObject1).getKey();
      Object localObject2 = a(localView);
      if (b(localView, (Rect)localObject2, this.c, paramInt1, paramInt2, paramInt3, paramInt4))
      {
        this.h.put(localView, Boolean.valueOf(false));
        int i1 = 0;
        float f1 = 0.0F;
        if (getShowMode() == e.a) {
          switch (c.a[this.c.ordinal()])
          {
          }
        }
        for (;;)
        {
          Iterator localIterator2 = ((ArrayList)((Map.Entry)localObject1).getValue()).iterator();
          while (localIterator2.hasNext())
          {
            ((d)localIterator2.next()).a(localView, this.c, Math.abs(f1), i1);
            if (Math.abs(f1) == 1.0F) {
              this.h.put(localView, Boolean.valueOf(true));
            }
          }
          i1 = ((Rect)localObject2).left - paramInt1;
          f1 = i1 / localView.getWidth();
          continue;
          i1 = ((Rect)localObject2).right - paramInt3;
          f1 = i1 / localView.getWidth();
          continue;
          i1 = ((Rect)localObject2).top - paramInt2;
          f1 = i1 / localView.getHeight();
          continue;
          i1 = ((Rect)localObject2).bottom - paramInt4;
          f1 = i1 / localView.getHeight();
          continue;
          if (getShowMode() == e.b) {}
          switch (c.a[this.c.ordinal()])
          {
          default: 
            i1 = 0;
            f1 = 0.0F;
            break;
          case 3: 
            i1 = ((Rect)localObject2).right - getPaddingLeft();
            f1 = i1 / localView.getWidth();
            break;
          case 4: 
            i1 = ((Rect)localObject2).left - getWidth();
            f1 = i1 / localView.getWidth();
            break;
          case 1: 
            i1 = ((Rect)localObject2).bottom - getPaddingTop();
            f1 = i1 / localView.getHeight();
            break;
          case 2: 
            i1 = ((Rect)localObject2).top - getHeight();
            f1 = i1 / localView.getHeight();
          }
        }
      }
      if (!a(localView, (Rect)localObject2, this.c, paramInt1, paramInt2, paramInt3, paramInt4)) {
        break;
      }
      this.h.put(localView, Boolean.valueOf(true));
      localObject1 = ((ArrayList)((Map.Entry)localObject1).getValue()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (d)((Iterator)localObject1).next();
        if ((this.c == b.a) || (this.c == b.b)) {
          ((d)localObject2).a(localView, this.c, 1.0F, localView.getWidth());
        } else {
          ((d)localObject2).a(localView, this.c, 1.0F, localView.getHeight());
        }
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    b(paramBoolean, true);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    ViewGroup localViewGroup = getSurfaceView();
    if (paramBoolean1) {
      this.a.smoothSlideViewTo(getSurfaceView(), getPaddingLeft(), getPaddingTop());
    }
    for (;;)
    {
      invalidate();
      return;
      Rect localRect = d(false);
      int i1 = localRect.left;
      int i2 = localViewGroup.getLeft();
      int i3 = localRect.top;
      int i4 = localViewGroup.getTop();
      localViewGroup.layout(localRect.left, localRect.top, localRect.right, localRect.bottom);
      if (paramBoolean2)
      {
        b(localRect.left, localRect.top, localRect.right, localRect.bottom);
        a(localRect.left, localRect.top, i1 - i2, i3 - i4);
      }
      else
      {
        f();
      }
    }
  }
  
  protected boolean b(View paramView, Rect paramRect, b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = paramRect.left;
    int i2 = paramRect.right;
    int i3 = paramRect.top;
    int i4 = paramRect.bottom;
    if (getShowMode() == e.a) {
      switch (c.a[paramb.ordinal()])
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return false;
              if ((paramInt3 > i1) && (paramInt3 <= i2))
              {
                return true;
                if ((paramInt1 < i2) && (paramInt1 >= i1))
                {
                  return true;
                  if ((paramInt2 >= i3) && (paramInt2 < i4))
                  {
                    return true;
                    if ((paramInt4 > i3) && (paramInt4 <= i4))
                    {
                      return true;
                      if (getShowMode() == e.b) {
                        switch (c.a[paramb.ordinal()])
                        {
                        }
                      }
                    }
                  }
                }
              }
            }
          } while ((i3 >= getPaddingTop()) || (i4 < getPaddingTop()));
          return true;
        } while ((i1 > getWidth()) || (i2 <= getWidth()));
        return true;
      } while ((i2 < getPaddingLeft()) || (i1 >= getPaddingLeft()));
      return true;
    } while ((i3 >= getHeight()) || (i3 < getPaddingTop()));
    return true;
  }
  
  public void c(boolean paramBoolean)
  {
    if (getOpenStatus() == f.b) {
      b(paramBoolean);
    }
    while (getOpenStatus() != f.c) {
      return;
    }
    a(paramBoolean);
  }
  
  public boolean c()
  {
    return this.j;
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if (this.a.continueSettling(true)) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void d()
  {
    a(true, true);
  }
  
  public void e()
  {
    b(true, true);
  }
  
  public ViewGroup getBottomView()
  {
    return (ViewGroup)getChildAt(0);
  }
  
  public int getDragDistance()
  {
    return this.b;
  }
  
  public b getDragEdge()
  {
    return this.c;
  }
  
  public f getOpenStatus()
  {
    int i1 = getSurfaceView().getLeft();
    int i2 = getSurfaceView().getTop();
    if ((i1 == getPaddingLeft()) && (i2 == getPaddingTop())) {
      return f.c;
    }
    if ((i1 == getPaddingLeft() - this.b) || (i1 == getPaddingLeft() + this.b) || (i2 == getPaddingTop() - this.b) || (i2 == getPaddingTop() + this.b)) {
      return f.b;
    }
    return f.a;
  }
  
  public e getShowMode()
  {
    return this.d;
  }
  
  public ViewGroup getSurfaceView()
  {
    return (ViewGroup)getChildAt(1);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    boolean bool1;
    if ((!isEnabled()) || (!g())) {
      bool1 = true;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (!c());
    Object localObject = this.f.iterator();
    while (((Iterator)localObject).hasNext())
    {
      g localg = (g)((Iterator)localObject).next();
      if ((localg != null) && (localg.a(paramMotionEvent))) {
        return false;
      }
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      bool1 = bool2;
      if (this.n) {
        break;
      }
      return this.a.shouldInterceptTouchEvent(paramMotionEvent);
      localObject = getOpenStatus();
      if (localObject == f.c)
      {
        if (a(getSurfaceView(), paramMotionEvent) != null) {}
        for (bool1 = true;; bool1 = false)
        {
          this.n = bool1;
          break;
        }
      }
      if (localObject == f.b)
      {
        if (a(getBottomView(), paramMotionEvent) != null) {}
        for (bool1 = bool3;; bool1 = false)
        {
          this.n = bool1;
          break;
        }
        this.n = false;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() != 2) {
      throw new IllegalStateException("You need 2  views in SwipeLayout");
    }
    if ((!(getChildAt(0) instanceof ViewGroup)) || (!(getChildAt(1) instanceof ViewGroup))) {
      throw new IllegalArgumentException("The 2 children in SwipeLayout must be an instance of ViewGroup");
    }
    if (this.d == e.b) {
      a();
    }
    for (;;)
    {
      f();
      if (this.m == null) {
        break;
      }
      paramInt1 = 0;
      while (paramInt1 < this.m.size())
      {
        ((c)this.m.get(paramInt1)).a(this);
        paramInt1 += 1;
      }
      if (this.d == e.a) {
        b();
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.c == b.a) || (this.c == b.b))
    {
      this.b = getBottomView().getMeasuredWidth();
      return;
    }
    this.b = getBottomView().getMeasuredHeight();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!g()) || (!isEnabled())) {
      return true;
    }
    if (!c()) {
      return super.onTouchEvent(paramMotionEvent);
    }
    int i1 = paramMotionEvent.getActionMasked();
    ViewParent localViewParent = getParent();
    this.q.onTouchEvent(paramMotionEvent);
    f localf = getOpenStatus();
    ViewGroup localViewGroup;
    if (localf == f.c) {
      localViewGroup = getSurfaceView();
    }
    for (;;)
    {
      float f1;
      float f2;
      float f3;
      switch (i1)
      {
      default: 
        localViewParent.requestDisallowInterceptTouchEvent(true);
        this.a.processTouchEvent(paramMotionEvent);
        return true;
        if (localf == f.b) {
          localViewGroup = getBottomView();
        }
        break;
      case 0: 
        this.a.processTouchEvent(paramMotionEvent);
        localViewParent.requestDisallowInterceptTouchEvent(true);
        this.o = paramMotionEvent.getRawX();
        this.p = paramMotionEvent.getRawY();
        if (localViewGroup == null) {
          break;
        }
        localViewGroup.setPressed(true);
        return true;
      case 2: 
        if ((this.o == -1.0F) || (this.p == -1.0F))
        {
          paramMotionEvent.setAction(0);
          this.a.processTouchEvent(paramMotionEvent);
          localViewParent.requestDisallowInterceptTouchEvent(true);
          this.o = paramMotionEvent.getRawX();
          this.p = paramMotionEvent.getRawY();
          return true;
        }
        f1 = paramMotionEvent.getRawX() - this.o;
        f2 = paramMotionEvent.getRawY() - this.p;
        f3 = (float)Math.toDegrees(Math.atan(Math.abs(f2 / f1)));
        if (this.c == b.b) {
          if (((localf == f.b) && (f1 > 0.0F)) || ((localf == f.c) && (f1 < 0.0F)))
          {
            i1 = 1;
            if ((i1 == 0) && (localf != f.a)) {
              break label620;
            }
            i1 = 1;
            if ((f3 <= 30.0F) && (i1 != 0)) {
              break label717;
            }
          }
        }
      case 1: 
      case 3: 
        label336:
        label398:
        label414:
        label480:
        label496:
        label562:
        label620:
        label626:
        label632:
        label638:
        label644:
        label650:
        label656:
        label662:
        label717:
        for (int i2 = 1;; i2 = 0)
        {
          i1 = i2;
          if (this.c == b.a)
          {
            if (((localf != f.b) || (f1 >= 0.0F)) && ((localf != f.c) || (f1 <= 0.0F))) {
              break label626;
            }
            i1 = 1;
            if ((i1 == 0) && (localf != f.a)) {
              break label632;
            }
            i3 = 1;
            if (f3 <= 30.0F)
            {
              i1 = i2;
              if (i3 != 0) {}
            }
            else
            {
              i1 = 1;
            }
          }
          i2 = i1;
          if (this.c == b.c)
          {
            if (((localf != f.b) || (f2 >= 0.0F)) && ((localf != f.c) || (f2 <= 0.0F))) {
              break label638;
            }
            i2 = 1;
            if ((i2 == 0) && (localf != f.a)) {
              break label644;
            }
            i3 = 1;
            if (f3 >= 60.0F)
            {
              i2 = i1;
              if (i3 != 0) {}
            }
            else
            {
              i2 = 1;
            }
          }
          int i3 = i2;
          if (this.c == b.d)
          {
            if (((localf != f.b) || (f2 <= 0.0F)) && ((localf != f.c) || (f2 >= 0.0F))) {
              break label650;
            }
            i1 = 1;
            if ((i1 == 0) && (localf != f.a)) {
              break label656;
            }
          }
          for (i1 = 1;; i1 = 0)
          {
            if (f3 >= 60.0F)
            {
              i3 = i2;
              if (i1 != 0) {}
            }
            else
            {
              i3 = 1;
            }
            if (i3 == 0) {
              break label662;
            }
            localViewParent.requestDisallowInterceptTouchEvent(false);
            return false;
            i1 = 0;
            break;
            i1 = 0;
            break label336;
            i1 = 0;
            break label398;
            i3 = 0;
            break label414;
            i2 = 0;
            break label480;
            i3 = 0;
            break label496;
            i1 = 0;
            break label562;
          }
          if (localViewGroup != null) {
            localViewGroup.setPressed(false);
          }
          localViewParent.requestDisallowInterceptTouchEvent(true);
          this.a.processTouchEvent(paramMotionEvent);
          return true;
          this.o = -1.0F;
          this.p = -1.0F;
          if (localViewGroup == null) {
            break;
          }
          localViewGroup.setPressed(false);
          break;
        }
        localViewGroup = null;
      }
    }
  }
  
  public void setDragDistance(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Drag distance can not be < 0");
    }
    this.b = a(paramInt);
    requestLayout();
  }
  
  public void setDragEdge(b paramb)
  {
    this.c = paramb;
    requestLayout();
  }
  
  public void setOnDoubleClickListener(a parama)
  {
    this.i = parama;
  }
  
  public void setShowMode(e parame)
  {
    this.d = parame;
    requestLayout();
  }
  
  public void setSwipeEnabled(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void a(SwipeLayout paramSwipeLayout, boolean paramBoolean);
  }
  
  public static enum b
  {
    private b() {}
  }
  
  public static abstract interface c
  {
    public abstract void a(SwipeLayout paramSwipeLayout);
  }
  
  public static abstract interface d
  {
    public abstract void a(View paramView, SwipeLayout.b paramb, float paramFloat, int paramInt);
  }
  
  public static enum e
  {
    private e() {}
  }
  
  public static enum f
  {
    private f() {}
  }
  
  public static abstract interface g
  {
    public abstract boolean a(MotionEvent paramMotionEvent);
  }
  
  class h
    extends GestureDetector.SimpleOnGestureListener
  {
    h() {}
    
    public boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      Object localObject;
      ViewGroup localViewGroup;
      SwipeLayout localSwipeLayout;
      if (SwipeLayout.e(SwipeLayout.this) != null)
      {
        localObject = SwipeLayout.this.getBottomView();
        localViewGroup = SwipeLayout.this.getSurfaceView();
        if ((paramMotionEvent.getX() <= ((ViewGroup)localObject).getLeft()) || (paramMotionEvent.getX() >= ((ViewGroup)localObject).getRight()) || (paramMotionEvent.getY() <= ((ViewGroup)localObject).getTop()) || (paramMotionEvent.getY() >= ((ViewGroup)localObject).getBottom())) {
          break label114;
        }
        paramMotionEvent = (MotionEvent)localObject;
        localObject = SwipeLayout.e(SwipeLayout.this);
        localSwipeLayout = SwipeLayout.this;
        if (paramMotionEvent != localViewGroup) {
          break label119;
        }
      }
      label114:
      label119:
      for (boolean bool = true;; bool = false)
      {
        ((SwipeLayout.a)localObject).a(localSwipeLayout, bool);
        return true;
        paramMotionEvent = localViewGroup;
        break;
      }
    }
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public void onLongPress(MotionEvent paramMotionEvent)
    {
      SwipeLayout.this.performLongClick();
    }
    
    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      if (SwipeLayout.e(SwipeLayout.this) != null) {
        SwipeLayout.a(SwipeLayout.this, paramMotionEvent);
      }
      return true;
    }
    
    public boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      if (SwipeLayout.e(SwipeLayout.this) == null) {
        SwipeLayout.a(SwipeLayout.this, paramMotionEvent);
      }
      return true;
    }
  }
  
  public static abstract interface i
  {
    public abstract void a(SwipeLayout paramSwipeLayout);
    
    public abstract void a(SwipeLayout paramSwipeLayout, float paramFloat1, float paramFloat2);
    
    public abstract void a(SwipeLayout paramSwipeLayout, int paramInt1, int paramInt2);
    
    public abstract void b(SwipeLayout paramSwipeLayout);
    
    public abstract void c(SwipeLayout paramSwipeLayout);
    
    public abstract void d(SwipeLayout paramSwipeLayout);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\swipeLayout\SwipeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */