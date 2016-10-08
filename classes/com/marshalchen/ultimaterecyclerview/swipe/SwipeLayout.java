package com.marshalchen.ultimaterecyclerview.swipe;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.FrameLayout;
import com.marshalchen.ultimaterecyclerview.d.e;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SwipeLayout
  extends FrameLayout
{
  private static final b c = b.c;
  View.OnClickListener a;
  View.OnLongClickListener b;
  private int d;
  private b e = c;
  private ViewDragHelper f = ViewDragHelper.create(this, this.s);
  private int g = 0;
  private LinkedHashMap<b, View> h = new LinkedHashMap();
  private e i;
  private float[] j = new float[4];
  private List<i> k = new ArrayList();
  private List<g> l = new ArrayList();
  private Map<View, ArrayList<d>> m = new HashMap();
  private Map<View, Boolean> n = new HashMap();
  private a o;
  private boolean p = true;
  private boolean[] q = { 1, 1, 1, 1 };
  private boolean r = false;
  private ViewDragHelper.Callback s = new a(this);
  private int t = 0;
  private List<c> u;
  private boolean v;
  private float w = -1.0F;
  private float x = -1.0F;
  private Rect y;
  private GestureDetector z = new GestureDetector(getContext(), new h());
  
  public SwipeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SwipeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.d = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, d.e.SwipeLayout);
    paramInt = paramContext.getInt(d.e.SwipeLayout_drag_edge, 2);
    this.j[b.a.ordinal()] = paramContext.getDimension(d.e.SwipeLayout_leftEdgeSwipeOffset, 0.0F);
    this.j[b.c.ordinal()] = paramContext.getDimension(d.e.SwipeLayout_rightEdgeSwipeOffset, 0.0F);
    this.j[b.b.ordinal()] = paramContext.getDimension(d.e.SwipeLayout_topEdgeSwipeOffset, 0.0F);
    this.j[b.d.ordinal()] = paramContext.getDimension(d.e.SwipeLayout_bottomEdgeSwipeOffset, 0.0F);
    setClickToClose(paramContext.getBoolean(d.e.SwipeLayout_clickToClose, this.r));
    if ((paramInt & 0x1) == 1) {
      this.h.put(b.a, null);
    }
    if ((paramInt & 0x4) == 4) {
      this.h.put(b.b, null);
    }
    if ((paramInt & 0x2) == 2) {
      this.h.put(b.c, null);
    }
    if ((paramInt & 0x8) == 8) {
      this.h.put(b.d, null);
    }
    paramInt = paramContext.getInt(d.e.SwipeLayout_show_mode, e.b.ordinal());
    this.i = e.values()[paramInt];
    paramContext.recycle();
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
    if (paramb == b.c)
    {
      i1 = getMeasuredWidth() - this.g;
      if ((paramb != b.a) && (paramb != b.c)) {
        break label98;
      }
      i4 = i1 + this.g;
    }
    for (i3 = getMeasuredHeight() + i2;; i3 = this.g + i2)
    {
      return new Rect(i1, i2, i4, i3);
      i1 = i3;
      if (paramb != b.d) {
        break;
      }
      i2 = getMeasuredHeight() - this.g;
      i1 = i3;
      break;
      label98:
      i4 = i1 + getMeasuredWidth();
    }
  }
  
  private Rect a(e parame, Rect paramRect)
  {
    int i6 = 0;
    int i5 = 0;
    View localView = getCurrentBottomView();
    int i2 = paramRect.left;
    int i1 = paramRect.top;
    int i3 = paramRect.right;
    int i4 = paramRect.bottom;
    if (parame == e.b) {
      if (this.e == b.a)
      {
        i2 = paramRect.left - this.g;
        if ((this.e != b.a) && (this.e != b.c)) {
          break label193;
        }
        i6 = paramRect.bottom;
        if (localView != null) {
          break label184;
        }
        i3 = i5;
        label97:
        i4 = i2;
        i2 = i3 + i2;
        i3 = i1;
        i1 = i6;
      }
    }
    for (;;)
    {
      return new Rect(i4, i3, i2, i1);
      if (this.e == b.c)
      {
        i2 = paramRect.right;
        break;
      }
      if (this.e == b.b)
      {
        i1 = paramRect.top - this.g;
        break;
      }
      i1 = paramRect.bottom;
      break;
      label184:
      i3 = localView.getMeasuredWidth();
      break label97;
      label193:
      if (localView == null) {}
      for (i4 = i6;; i4 = localView.getMeasuredHeight())
      {
        i5 = paramRect.right;
        i3 = i1;
        i1 = i4 + i1;
        i4 = i2;
        i2 = i5;
        break;
      }
      if (parame == e.a)
      {
        if (this.e == b.a)
        {
          i3 = this.g;
          i5 = i2;
          i2 = i3 + i2;
          i3 = i1;
          i1 = i4;
          i4 = i5;
        }
        else if (this.e == b.c)
        {
          i2 = this.g;
          i5 = i1;
          i1 = i4;
          i4 = i3 - i2;
          i2 = i3;
          i3 = i5;
        }
        else if (this.e == b.b)
        {
          i5 = this.g;
          i4 = i2;
          i2 = i3;
          i5 += i1;
          i3 = i1;
          i1 = i5;
        }
        else
        {
          i5 = i4 - this.g;
          i1 = i4;
          i4 = i2;
          i2 = i3;
          i3 = i5;
        }
      }
      else
      {
        i5 = i1;
        i1 = i4;
        i4 = i2;
        i2 = i3;
        i3 = i5;
      }
    }
  }
  
  private Rect a(boolean paramBoolean)
  {
    int i3 = getPaddingLeft();
    int i4 = getPaddingTop();
    int i1 = i4;
    int i2 = i3;
    if (paramBoolean)
    {
      if (this.e != b.a) {
        break label67;
      }
      i2 = getPaddingLeft() + this.g;
      i1 = i4;
    }
    for (;;)
    {
      return new Rect(i2, i1, getMeasuredWidth() + i2, getMeasuredHeight() + i1);
      label67:
      if (this.e == b.c)
      {
        i2 = getPaddingLeft() - this.g;
        i1 = i4;
      }
      else if (this.e == b.b)
      {
        i1 = getPaddingTop() + this.g;
        i2 = i3;
      }
      else
      {
        i1 = getPaddingTop() - this.g;
        i2 = i3;
      }
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (this.v) {
      return;
    }
    if (getOpenStatus() == f.a)
    {
      this.v = true;
      return;
    }
    f localf = getOpenStatus();
    float f1 = paramMotionEvent.getRawX() - this.w;
    float f2 = paramMotionEvent.getRawY() - this.x;
    float f3 = (float)Math.toDegrees(Math.atan(Math.abs(f2 / f1)));
    label105:
    int i1;
    if (getOpenStatus() == f.c)
    {
      if (f3 >= 45.0F) {
        break label498;
      }
      if ((f1 > 0.0F) && (e()))
      {
        paramMotionEvent = b.a;
        setCurrentDragEdge(paramMotionEvent);
      }
    }
    else
    {
      if (this.e != b.c) {
        break label592;
      }
      if (((localf != f.b) || (f1 <= this.d)) && ((localf != f.c) || (f1 >= -this.d))) {
        break label538;
      }
      i1 = 1;
      label160:
      if ((i1 == 0) && (localf != f.a)) {
        break label544;
      }
      i1 = 1;
      label176:
      if ((f3 <= 30.0F) && (i1 != 0)) {
        break label592;
      }
    }
    label247:
    label263:
    label338:
    label354:
    label429:
    label445:
    label498:
    label538:
    label544:
    label550:
    label556:
    label562:
    label568:
    label574:
    label580:
    label592:
    for (int i2 = 1;; i2 = 0)
    {
      i1 = i2;
      if (this.e == b.a)
      {
        if (((localf != f.b) || (f1 >= -this.d)) && ((localf != f.c) || (f1 <= this.d))) {
          break label550;
        }
        i1 = 1;
        if ((i1 == 0) && (localf != f.a)) {
          break label556;
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
      if (this.e == b.b)
      {
        if (((localf != f.b) || (f2 >= -this.d)) && ((localf != f.c) || (f2 <= this.d))) {
          break label562;
        }
        i2 = 1;
        if ((i2 == 0) && (localf != f.a)) {
          break label568;
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
      if (this.e == b.d)
      {
        if (((localf != f.b) || (f2 <= this.d)) && ((localf != f.c) || (f2 >= -this.d))) {
          break label574;
        }
        i1 = 1;
        if ((i1 == 0) && (localf != f.a)) {
          break label580;
        }
        i1 = 1;
        if (f3 >= 60.0F)
        {
          i3 = i2;
          if (i1 != 0) {}
        }
        else
        {
          i3 = 1;
        }
      }
      if (i3 == 0) {}
      for (;;)
      {
        this.v = bool;
        return;
        if ((f1 >= 0.0F) || (!f())) {
          break;
        }
        paramMotionEvent = b.c;
        break label105;
        if ((f2 > 0.0F) && (g()))
        {
          paramMotionEvent = b.b;
          break label105;
        }
        if ((f2 >= 0.0F) || (!h())) {
          break;
        }
        paramMotionEvent = b.d;
        break label105;
        i1 = 0;
        break label160;
        i1 = 0;
        break label176;
        i1 = 0;
        break label247;
        i3 = 0;
        break label263;
        i2 = 0;
        break label338;
        i3 = 0;
        break label354;
        i1 = 0;
        break label429;
        i1 = 0;
        break label445;
        bool = false;
      }
    }
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    View localView = getSurfaceView();
    if (localView == null) {
      return false;
    }
    if (this.y == null) {
      this.y = new Rect();
    }
    localView.getHitRect(this.y);
    return this.y.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
  }
  
  private AdapterView getAdapterView()
  {
    ViewParent localViewParent = getParent();
    if ((localViewParent instanceof AdapterView)) {
      return (AdapterView)localViewParent;
    }
    return null;
  }
  
  private float getCurrentOffset()
  {
    if (this.e == null) {
      return 0.0F;
    }
    return this.j[this.e.ordinal()];
  }
  
  private void k()
  {
    Object localObject1 = getOpenStatus();
    Object localObject2 = getBottomViews();
    if (localObject1 == f.c)
    {
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (View)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((View)localObject2).getVisibility() != 4)) {
          ((View)localObject2).setVisibility(4);
        }
      }
    }
    localObject1 = getCurrentBottomView();
    if ((localObject1 != null) && (((View)localObject1).getVisibility() != 0)) {
      ((View)localObject1).setVisibility(0);
    }
  }
  
  private boolean l()
  {
    return getAdapterView() != null;
  }
  
  private void m()
  {
    if (getOpenStatus() != f.c) {}
    Object localObject;
    int i1;
    do
    {
      do
      {
        return;
        localObject = getParent();
      } while (!(localObject instanceof AdapterView));
      localObject = (AdapterView)localObject;
      i1 = ((AdapterView)localObject).getPositionForView(this);
    } while (i1 == -1);
    ((AdapterView)localObject).performItemClick(((AdapterView)localObject).getChildAt(i1 - ((AdapterView)localObject).getFirstVisiblePosition()), i1, ((AdapterView)localObject).getAdapter().getItemId(i1));
  }
  
  private boolean n()
  {
    boolean bool2;
    if (getOpenStatus() != f.c)
    {
      bool2 = false;
      return bool2;
    }
    Object localObject = getParent();
    int i1;
    long l1;
    if ((localObject instanceof AdapterView))
    {
      localObject = (AdapterView)localObject;
      i1 = ((AdapterView)localObject).getPositionForView(this);
      if (i1 == -1) {
        return false;
      }
      l1 = ((AdapterView)localObject).getItemIdAtPosition(i1);
      try
      {
        Method localMethod = AbsListView.class.getDeclaredMethod("performLongPress", new Class[] { View.class, Integer.TYPE, Long.TYPE });
        localMethod.setAccessible(true);
        bool1 = ((Boolean)localMethod.invoke(localObject, new Object[] { this, Integer.valueOf(i1), Long.valueOf(l1) })).booleanValue();
        return bool1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (((AdapterView)localObject).getOnItemLongClickListener() == null) {}
      }
    }
    for (boolean bool1 = ((AdapterView)localObject).getOnItemLongClickListener().onItemLongClick((AdapterView)localObject, this, i1, l1);; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      ((AdapterView)localObject).performHapticFeedback(0);
      return bool1;
      return false;
    }
  }
  
  private void o()
  {
    View localView = getCurrentBottomView();
    if (localView != null)
    {
      if ((this.e == b.a) || (this.e == b.c)) {
        this.g = (localView.getMeasuredWidth() - a(getCurrentOffset()));
      }
    }
    else
    {
      if (this.i != e.b) {
        break label85;
      }
      b();
    }
    for (;;)
    {
      k();
      return;
      this.g = (localView.getMeasuredHeight() - a(getCurrentOffset()));
      break;
      label85:
      if (this.i == e.a) {
        c();
      }
    }
  }
  
  private void setCurrentDragEdge(b paramb)
  {
    this.e = paramb;
    o();
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
  
  public void a()
  {
    this.h.clear();
  }
  
  protected void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f2 = this.f.getMinVelocity();
    View localView = getSurfaceView();
    b localb = this.e;
    if ((localb == null) || (localView == null)) {}
    float f1;
    do
    {
      return;
      if (paramBoolean) {
        f1 = 0.25F;
      }
      while (localb == b.a) {
        if (paramFloat1 > f2)
        {
          i();
          return;
          f1 = 0.75F;
        }
        else
        {
          if (paramFloat1 < -f2)
          {
            j();
            return;
          }
          if (getSurfaceView().getLeft() * 1.0F / this.g > f1)
          {
            i();
            return;
          }
          j();
          return;
        }
      }
      if (localb == b.c)
      {
        if (paramFloat1 > f2)
        {
          j();
          return;
        }
        if (paramFloat1 < -f2)
        {
          i();
          return;
        }
        if (-getSurfaceView().getLeft() * 1.0F / this.g > f1)
        {
          i();
          return;
        }
        j();
        return;
      }
      if (localb == b.b)
      {
        if (paramFloat2 > f2)
        {
          i();
          return;
        }
        if (paramFloat2 < -f2)
        {
          j();
          return;
        }
        if (getSurfaceView().getTop() * 1.0F / this.g > f1)
        {
          i();
          return;
        }
        j();
        return;
      }
    } while (localb != b.d);
    if (paramFloat2 > f2)
    {
      j();
      return;
    }
    if (paramFloat2 < -f2)
    {
      i();
      return;
    }
    if (-getSurfaceView().getTop() * 1.0F / this.g > f1)
    {
      i();
      return;
    }
    j();
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
      if (localb == b.c)
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
            if (localb != b.b) {
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
    k();
    Object localObject = getOpenStatus();
    if (!this.k.isEmpty())
    {
      this.t += 1;
      Iterator localIterator = this.k.iterator();
      if (localIterator.hasNext())
      {
        i locali = (i)localIterator.next();
        if (this.t == 1)
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
        localIterator = this.k.iterator();
        while (localIterator.hasNext()) {
          ((i)localIterator.next()).d(this);
        }
        this.t = 0;
      }
      if (localObject == f.b)
      {
        localObject = getCurrentBottomView();
        if (localObject != null) {
          ((View)localObject).setEnabled(true);
        }
        localObject = this.k.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((i)((Iterator)localObject).next()).b(this);
        }
        this.t = 0;
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = getSurfaceView();
    View localView = getCurrentBottomView();
    if (localObject == null) {
      return;
    }
    Rect localRect = a(true);
    if (paramBoolean1) {
      this.f.smoothSlideViewTo((View)localObject, localRect.left, localRect.top);
    }
    for (;;)
    {
      invalidate();
      return;
      int i1 = localRect.left;
      int i2 = ((View)localObject).getLeft();
      int i3 = localRect.top;
      int i4 = ((View)localObject).getTop();
      ((View)localObject).layout(localRect.left, localRect.top, localRect.right, localRect.bottom);
      if (getShowMode() == e.b)
      {
        localObject = a(e.b, localRect);
        if (localView != null) {
          localView.layout(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, ((Rect)localObject).bottom);
        }
      }
      if (paramBoolean2)
      {
        b(localRect.left, localRect.top, localRect.right, localRect.bottom);
        a(localRect.left, localRect.top, i1 - i2, i3 - i4);
      }
      else
      {
        k();
      }
    }
  }
  
  protected boolean a(View paramView, Rect paramRect, b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((Boolean)this.n.get(paramView)).booleanValue()) {
      return false;
    }
    int i1 = paramRect.left;
    int i2 = paramRect.right;
    int i3 = paramRect.top;
    int i4 = paramRect.bottom;
    boolean bool;
    if (getShowMode() == e.a)
    {
      if (((paramb != b.c) || (paramInt3 > i1)) && ((paramb != b.a) || (paramInt1 < i2)) && ((paramb != b.b) || (paramInt2 < i4)) && ((paramb != b.d) || (paramInt4 > i3))) {
        break label197;
      }
      bool = true;
    }
    for (;;)
    {
      return bool;
      if ((getShowMode() == e.b) && (((paramb == b.c) && (i2 <= getWidth())) || ((paramb == b.a) && (i1 >= getPaddingLeft())) || ((paramb == b.b) && (i3 >= getPaddingTop())) || ((paramb == b.d) && (i4 <= getHeight())))) {
        bool = true;
      } else {
        label197:
        bool = false;
      }
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      try
      {
        i1 = ((Integer)paramLayoutParams.getClass().getField("gravity").get(paramLayoutParams)).intValue();
        if (i1 > 0)
        {
          i1 = GravityCompat.getAbsoluteGravity(i1, ViewCompat.getLayoutDirection(this));
          if ((i1 & 0x3) == 3) {
            this.h.put(b.a, paramView);
          }
          if ((i1 & 0x5) == 5) {
            this.h.put(b.c, paramView);
          }
          if ((i1 & 0x30) == 48) {
            this.h.put(b.b, paramView);
          }
          if ((i1 & 0x50) == 80) {
            this.h.put(b.d, paramView);
          }
          if (paramView.getParent() == this) {
            continue;
          }
          super.addView(paramView, paramInt, paramLayoutParams);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          int i1 = 0;
          continue;
          Iterator localIterator = this.h.entrySet().iterator();
          Map.Entry localEntry;
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localEntry = (Map.Entry)localIterator.next();
          } while (localEntry.getValue() != null);
          this.h.put(localEntry.getKey(), paramView);
        }
      }
    }
  }
  
  void b()
  {
    Rect localRect = a(false);
    View localView = getSurfaceView();
    if (localView != null)
    {
      localView.layout(localRect.left, localRect.top, localRect.right, localRect.bottom);
      bringChildToFront(localView);
    }
    localRect = a(e.b, localRect);
    localView = getCurrentBottomView();
    if (localView != null) {
      localView.layout(localRect.left, localRect.top, localRect.right, localRect.bottom);
    }
  }
  
  protected void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    label12:
    Iterator localIterator1;
    if (this.m.isEmpty()) {
      return;
    } else {
      localIterator1 = this.m.entrySet().iterator();
    }
    for (;;)
    {
      if (!localIterator1.hasNext()) {
        break label12;
      }
      Object localObject1 = (Map.Entry)localIterator1.next();
      View localView = (View)((Map.Entry)localObject1).getKey();
      Object localObject2 = a(localView);
      if (b(localView, (Rect)localObject2, this.e, paramInt1, paramInt2, paramInt3, paramInt4))
      {
        this.n.put(localView, Boolean.valueOf(false));
        int i1 = 0;
        float f1 = 0.0F;
        if (getShowMode() == e.a) {
          switch (1.a[this.e.ordinal()])
          {
          }
        }
        for (;;)
        {
          Iterator localIterator2 = ((ArrayList)((Map.Entry)localObject1).getValue()).iterator();
          while (localIterator2.hasNext())
          {
            ((d)localIterator2.next()).a(localView, this.e, Math.abs(f1), i1);
            if (Math.abs(f1) == 1.0F) {
              this.n.put(localView, Boolean.valueOf(true));
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
          switch (1.a[this.e.ordinal()])
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
      if (!a(localView, (Rect)localObject2, this.e, paramInt1, paramInt2, paramInt3, paramInt4)) {
        break;
      }
      this.n.put(localView, Boolean.valueOf(true));
      localObject1 = ((ArrayList)((Map.Entry)localObject1).getValue()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (d)((Iterator)localObject1).next();
        if ((this.e == b.a) || (this.e == b.c)) {
          ((d)localObject2).a(localView, this.e, 1.0F, localView.getWidth());
        } else {
          ((d)localObject2).a(localView, this.e, 1.0F, localView.getHeight());
        }
      }
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    View localView = getSurfaceView();
    if (localView == null) {
      return;
    }
    if (paramBoolean1) {
      this.f.smoothSlideViewTo(getSurfaceView(), getPaddingLeft(), getPaddingTop());
    }
    for (;;)
    {
      invalidate();
      return;
      Rect localRect = a(false);
      int i1 = localRect.left;
      int i2 = localView.getLeft();
      int i3 = localRect.top;
      int i4 = localView.getTop();
      localView.layout(localRect.left, localRect.top, localRect.right, localRect.bottom);
      if (paramBoolean2)
      {
        b(localRect.left, localRect.top, localRect.right, localRect.bottom);
        a(localRect.left, localRect.top, i1 - i2, i3 - i4);
      }
      else
      {
        k();
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
      switch (1.a[paramb.ordinal()])
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
                        switch (1.a[paramb.ordinal()])
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
  
  void c()
  {
    Rect localRect = a(false);
    View localView = getSurfaceView();
    if (localView != null)
    {
      localView.layout(localRect.left, localRect.top, localRect.right, localRect.bottom);
      bringChildToFront(localView);
    }
    localRect = a(e.a, localRect);
    localView = getCurrentBottomView();
    if (localView != null) {
      localView.layout(localRect.left, localRect.top, localRect.right, localRect.bottom);
    }
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if (this.f.continueSettling(true)) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public boolean d()
  {
    return this.p;
  }
  
  public boolean e()
  {
    View localView = (View)this.h.get(b.a);
    return (localView != null) && (localView.getParent() == this) && (localView != getSurfaceView()) && (this.q[b.a.ordinal()] != 0);
  }
  
  public boolean f()
  {
    View localView = (View)this.h.get(b.c);
    return (localView != null) && (localView.getParent() == this) && (localView != getSurfaceView()) && (this.q[b.c.ordinal()] != 0);
  }
  
  public boolean g()
  {
    View localView = (View)this.h.get(b.b);
    return (localView != null) && (localView.getParent() == this) && (localView != getSurfaceView()) && (this.q[b.b.ordinal()] != 0);
  }
  
  public List<View> getBottomViews()
  {
    ArrayList localArrayList = new ArrayList();
    b[] arrayOfb = b.values();
    int i2 = arrayOfb.length;
    int i1 = 0;
    while (i1 < i2)
    {
      b localb = arrayOfb[i1];
      localArrayList.add(this.h.get(localb));
      i1 += 1;
    }
    return localArrayList;
  }
  
  @Nullable
  public View getCurrentBottomView()
  {
    List localList = getBottomViews();
    if (this.e.ordinal() < localList.size()) {
      return (View)localList.get(this.e.ordinal());
    }
    return null;
  }
  
  public int getDragDistance()
  {
    return this.g;
  }
  
  public b getDragEdge()
  {
    return this.e;
  }
  
  public Map<b, View> getDragEdgeMap()
  {
    return this.h;
  }
  
  @Deprecated
  public List<b> getDragEdges()
  {
    return new ArrayList(this.h.keySet());
  }
  
  public f getOpenStatus()
  {
    View localView = getSurfaceView();
    if (localView == null) {
      return f.c;
    }
    int i1 = localView.getLeft();
    int i2 = localView.getTop();
    if ((i1 == getPaddingLeft()) && (i2 == getPaddingTop())) {
      return f.c;
    }
    if ((i1 == getPaddingLeft() - this.g) || (i1 == getPaddingLeft() + this.g) || (i2 == getPaddingTop() - this.g) || (i2 == getPaddingTop() + this.g)) {
      return f.b;
    }
    return f.a;
  }
  
  public e getShowMode()
  {
    return this.i;
  }
  
  public View getSurfaceView()
  {
    if (getChildCount() == 0) {
      return null;
    }
    return getChildAt(getChildCount() - 1);
  }
  
  public boolean h()
  {
    View localView = (View)this.h.get(b.d);
    return (localView != null) && (localView.getParent() == this) && (localView != getSurfaceView()) && (this.q[b.d.ordinal()] != 0);
  }
  
  public void i()
  {
    a(true, true);
  }
  
  public void j()
  {
    b(true, true);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (l())
    {
      if (this.a == null) {
        setOnClickListener(new b(this));
      }
      if (this.b == null) {
        setOnLongClickListener(new c(this));
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!d()) {
      return false;
    }
    if ((this.r) && (getOpenStatus() == f.b) && (b(paramMotionEvent))) {
      return true;
    }
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      if ((localg != null) && (localg.a(paramMotionEvent))) {
        return false;
      }
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      this.f.processTouchEvent(paramMotionEvent);
    }
    for (;;)
    {
      return this.v;
      this.f.processTouchEvent(paramMotionEvent);
      this.v = false;
      this.w = paramMotionEvent.getRawX();
      this.x = paramMotionEvent.getRawY();
      if (getOpenStatus() == f.a)
      {
        this.v = true;
        continue;
        boolean bool = this.v;
        a(paramMotionEvent);
        if (this.v)
        {
          paramMotionEvent = getParent();
          if (paramMotionEvent != null) {
            paramMotionEvent.requestDisallowInterceptTouchEvent(true);
          }
        }
        if ((!bool) && (this.v))
        {
          return false;
          this.v = false;
          this.f.processTouchEvent(paramMotionEvent);
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    o();
    if (this.u != null)
    {
      paramInt1 = 0;
      while (paramInt1 < this.u.size())
      {
        ((c)this.u.get(paramInt1)).a(this);
        paramInt1 += 1;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (!d())
    {
      bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    int i1 = paramMotionEvent.getActionMasked();
    this.z.onTouchEvent(paramMotionEvent);
    switch (i1)
    {
    default: 
      this.f.processTouchEvent(paramMotionEvent);
    }
    while ((super.onTouchEvent(paramMotionEvent)) || (this.v) || (i1 == 0))
    {
      return true;
      this.f.processTouchEvent(paramMotionEvent);
      this.w = paramMotionEvent.getRawX();
      this.x = paramMotionEvent.getRawY();
      a(paramMotionEvent);
      if (this.v)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        this.f.processTouchEvent(paramMotionEvent);
        continue;
        this.v = false;
        this.f.processTouchEvent(paramMotionEvent);
      }
    }
  }
  
  protected void onViewRemoved(View paramView)
  {
    Iterator localIterator = new HashMap(this.h).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry.getValue() == paramView) {
        this.h.remove(localEntry.getKey());
      }
    }
  }
  
  public void setBottomSwipeEnabled(boolean paramBoolean)
  {
    this.q[b.d.ordinal()] = paramBoolean;
  }
  
  public void setClickToClose(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
  
  public void setDragDistance(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = 0;
    }
    this.g = a(i1);
    requestLayout();
  }
  
  @Deprecated
  public void setDragEdge(b paramb)
  {
    a();
    if (getChildCount() >= 2) {
      this.h.put(paramb, getChildAt(getChildCount() - 2));
    }
    setCurrentDragEdge(paramb);
  }
  
  @Deprecated
  public void setDragEdges(List<b> paramList)
  {
    a();
    int i2 = Math.min(paramList.size(), getChildCount() - 1);
    int i1 = 0;
    while (i1 < i2)
    {
      b localb = (b)paramList.get(i1);
      this.h.put(localb, getChildAt(i1));
      i1 += 1;
    }
    if ((paramList.size() == 0) || (paramList.contains(c)))
    {
      setCurrentDragEdge(c);
      return;
    }
    setCurrentDragEdge((b)paramList.get(0));
  }
  
  @Deprecated
  public void setDragEdges(b... paramVarArgs)
  {
    a();
    setDragEdges(Arrays.asList(paramVarArgs));
  }
  
  public void setLeftSwipeEnabled(boolean paramBoolean)
  {
    this.q[b.a.ordinal()] = paramBoolean;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
    this.a = paramOnClickListener;
  }
  
  public void setOnDoubleClickListener(a parama)
  {
    this.o = parama;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    super.setOnLongClickListener(paramOnLongClickListener);
    this.b = paramOnLongClickListener;
  }
  
  public void setRightSwipeEnabled(boolean paramBoolean)
  {
    this.q[b.c.ordinal()] = paramBoolean;
  }
  
  public void setShowMode(e parame)
  {
    this.i = parame;
    requestLayout();
  }
  
  public void setSwipeEnabled(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void setTopSwipeEnabled(boolean paramBoolean)
  {
    this.q[b.b.ordinal()] = paramBoolean;
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
      View localView;
      SwipeLayout localSwipeLayout;
      if (SwipeLayout.h(SwipeLayout.this) != null)
      {
        localObject = SwipeLayout.this.getCurrentBottomView();
        localView = SwipeLayout.this.getSurfaceView();
        if ((localObject == null) || (paramMotionEvent.getX() <= ((View)localObject).getLeft()) || (paramMotionEvent.getX() >= ((View)localObject).getRight()) || (paramMotionEvent.getY() <= ((View)localObject).getTop()) || (paramMotionEvent.getY() >= ((View)localObject).getBottom())) {
          break label118;
        }
        paramMotionEvent = (MotionEvent)localObject;
        localObject = SwipeLayout.h(SwipeLayout.this);
        localSwipeLayout = SwipeLayout.this;
        if (paramMotionEvent != localView) {
          break label123;
        }
      }
      label118:
      label123:
      for (boolean bool = true;; bool = false)
      {
        ((SwipeLayout.a)localObject).a(localSwipeLayout, bool);
        return true;
        paramMotionEvent = localView;
        break;
      }
    }
    
    public boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      if ((SwipeLayout.g(SwipeLayout.this)) && (SwipeLayout.a(SwipeLayout.this, paramMotionEvent))) {
        SwipeLayout.this.j();
      }
      return super.onSingleTapUp(paramMotionEvent);
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\swipe\SwipeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */