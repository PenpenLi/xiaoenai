package com.marshalchen.ultimaterecyclerview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.LayoutRes;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.marshalchen.ultimaterecyclerview.ui.VerticalSwipeRefreshLayout;
import com.marshalchen.ultimaterecyclerview.ui.floatingactionbutton.FloatingActionButton;
import com.marshalchen.ultimaterecyclerview.uiUtils.SavedStateScrolling;

public class UltimateRecyclerView
  extends FrameLayout
{
  private static boolean U = false;
  private int A;
  private int B;
  private SparseIntArray C = new SparseIntArray();
  private a D;
  private b E;
  private boolean F;
  private boolean G;
  private boolean H;
  private boolean I;
  private MotionEvent J;
  private ViewGroup K;
  private int L;
  private int M = 0;
  private int N = 0;
  private int O = 0;
  private int P;
  private a Q;
  private int R;
  private final float S = 0.5F;
  private d T;
  private c a;
  private int b;
  private boolean c = false;
  private s d;
  public RecyclerView e;
  protected FloatingActionButton f;
  protected RecyclerView.OnScrollListener g;
  protected b h;
  protected int i;
  protected int j;
  protected int k;
  protected int l;
  protected int m;
  protected boolean n;
  protected ViewStub o;
  protected View p;
  protected int q;
  protected ViewStub r;
  protected View s;
  protected int t;
  protected int[] u = null;
  public int v = 3;
  public VerticalSwipeRefreshLayout w;
  private int x;
  private int y = -1;
  private int z;
  
  public UltimateRecyclerView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public UltimateRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
    a();
  }
  
  public UltimateRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
    a();
  }
  
  private int a(int[] paramArrayOfInt)
  {
    int i1 = Integer.MIN_VALUE;
    int i4 = paramArrayOfInt.length;
    int i2 = 0;
    if (i2 < i4)
    {
      int i3 = paramArrayOfInt[i2];
      if (i3 <= i1) {
        break label38;
      }
      i1 = i3;
    }
    label38:
    for (;;)
    {
      i2 += 1;
      break;
      return i1;
    }
  }
  
  private void a(float paramFloat)
  {
    float f1 = paramFloat * 0.5F;
    if (Build.VERSION.SDK_INT >= 11) {
      this.Q.setTranslationY(f1);
    }
    for (;;)
    {
      this.Q.setClipY(Math.round(f1));
      if (this.T != null)
      {
        f1 = Math.min(1.0F, f1 / (this.Q.getHeight() * 0.5F));
        this.T.a(f1, paramFloat, this.Q);
      }
      return;
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, f1, f1);
      localTranslateAnimation.setFillAfter(true);
      localTranslateAnimation.setDuration(0L);
      this.Q.startAnimation(localTranslateAnimation);
    }
  }
  
  private int b(int[] paramArrayOfInt)
  {
    int i1 = Integer.MAX_VALUE;
    int i4 = paramArrayOfInt.length;
    int i2 = 0;
    if (i2 < i4)
    {
      int i3 = paramArrayOfInt[i2];
      if ((i3 == -1) || (i3 >= i1)) {
        break label44;
      }
      i1 = i3;
    }
    label44:
    for (;;)
    {
      i2 += 1;
      break;
      return i1;
    }
  }
  
  private void b()
  {
    this.e.removeOnScrollListener(this.g);
    this.g = new m(this);
    this.e.addOnScrollListener(this.g);
  }
  
  private void h()
  {
    this.c = false;
    if (this.w != null) {
      this.w.setRefreshing(false);
    }
    if (this.d == null) {}
    label52:
    label157:
    for (;;)
    {
      return;
      int i1;
      if (this.d.a() == 0)
      {
        ViewStub localViewStub = this.o;
        if (this.q != 0)
        {
          i1 = 0;
          localViewStub.setVisibility(i1);
        }
      }
      for (;;)
      {
        if (this.d.d() == null) {
          break label157;
        }
        if ((this.d.a() >= this.v) && (this.d.d().getVisibility() == 8)) {
          this.d.d().setVisibility(0);
        }
        if (this.d.a() >= this.v) {
          break;
        }
        this.d.d().setVisibility(8);
        return;
        i1 = 8;
        break label52;
        if (this.q != 0) {
          this.o.setVisibility(8);
        }
      }
    }
  }
  
  protected void a()
  {
    View localView = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(d.d.ultimate_recycler_view_layout, this);
    this.e = ((RecyclerView)localView.findViewById(d.c.ultimate_list));
    this.w = ((VerticalSwipeRefreshLayout)localView.findViewById(d.c.swipe_refresh_layout));
    c();
    this.w.setEnabled(false);
    if (this.e != null)
    {
      this.e.setClipToPadding(this.n);
      if (this.i == -1.1F) {
        break label210;
      }
      this.e.setPadding(this.i, this.i, this.i, this.i);
    }
    for (;;)
    {
      this.f = ((FloatingActionButton)localView.findViewById(d.c.defaultFloatingActionButton));
      d();
      this.o = ((ViewStub)localView.findViewById(d.c.emptyview));
      this.r = ((ViewStub)localView.findViewById(d.c.floatingActionViewStub));
      this.o.setLayoutResource(this.q);
      this.r.setLayoutResource(this.t);
      if (this.q != 0) {
        this.p = this.o.inflate();
      }
      this.o.setVisibility(8);
      return;
      label210:
      this.e.setPadding(this.l, this.j, this.m, this.k);
    }
  }
  
  public void a(int paramInt)
  {
    RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
    if ((localLayoutManager != null) && ((localLayoutManager instanceof LinearLayoutManager)))
    {
      ((LinearLayoutManager)localLayoutManager).scrollToPositionWithOffset(paramInt, 0);
      return;
    }
    localLayoutManager.scrollToPosition(paramInt);
  }
  
  public void a(RecyclerView.ItemDecoration paramItemDecoration)
  {
    this.e.addItemDecoration(paramItemDecoration);
  }
  
  public void a(RecyclerView.OnScrollListener paramOnScrollListener)
  {
    this.e.addOnScrollListener(paramOnScrollListener);
  }
  
  protected void a(RecyclerView paramRecyclerView)
  {
    int i4;
    int i1;
    int i2;
    if ((this.E != null) && (getChildCount() > 0))
    {
      i4 = paramRecyclerView.getChildAdapterPosition(paramRecyclerView.getChildAt(0));
      int i5 = paramRecyclerView.getChildAdapterPosition(paramRecyclerView.getChildAt(paramRecyclerView.getChildCount() - 1));
      i1 = 0;
      i2 = i4;
      if (i2 > i5) {}
    }
    for (;;)
    {
      try
      {
        View localView = paramRecyclerView.getChildAt(i1);
        if (((this.C.indexOfKey(i2) >= 0) && ((localView == null) || (localView.getHeight() == this.C.get(i2)))) || (localView == null)) {
          break label533;
        }
        i3 = localView.getHeight();
        this.C.put(i2, i3);
        i2 += 1;
        i1 += 1;
      }
      catch (NullPointerException localNullPointerException)
      {
        localNullPointerException.printStackTrace();
        k.a(localNullPointerException, "");
      }
      paramRecyclerView = paramRecyclerView.getChildAt(0);
      if (paramRecyclerView != null)
      {
        if (this.x >= i4) {
          break label368;
        }
        if (i4 - this.x != 1)
        {
          i2 = i4 - 1;
          i1 = 0;
          i3 = i1;
          if (i2 > this.x)
          {
            if (this.C.indexOfKey(i2) > 0) {
              i1 += this.C.get(i2);
            }
            for (;;)
            {
              i2 -= 1;
              break;
              i1 += paramRecyclerView.getHeight();
            }
          }
        }
        else
        {
          i3 = 0;
        }
        this.z += i3 + this.y;
        this.y = paramRecyclerView.getHeight();
        if (this.y < 0) {
          this.y = 0;
        }
        this.B = (this.z - paramRecyclerView.getTop());
        this.x = i4;
        this.E.a(this.B, this.F, this.G);
        if (this.A >= this.B) {
          break label502;
        }
        if (this.F)
        {
          this.F = false;
          this.D = a.a;
        }
        this.D = a.b;
      }
      for (;;)
      {
        if (this.F) {
          this.F = false;
        }
        this.A = this.B;
        return;
        label368:
        if (i4 < this.x)
        {
          if (this.x - i4 != 1)
          {
            i2 = this.x - 1;
            i1 = 0;
            i3 = i1;
            if (i2 > i4)
            {
              if (this.C.indexOfKey(i2) > 0) {
                i1 += this.C.get(i2);
              }
              for (;;)
              {
                i2 -= 1;
                break;
                i1 += paramRecyclerView.getHeight();
              }
            }
          }
          else
          {
            i3 = 0;
          }
          this.z -= i3 + paramRecyclerView.getHeight();
          this.y = paramRecyclerView.getHeight();
          break;
        }
        if (i4 != 0) {
          break;
        }
        this.y = paramRecyclerView.getHeight();
        this.z = 0;
        break;
        label502:
        if (this.B < this.A) {
          this.D = a.c;
        } else {
          this.D = a.a;
        }
      }
      label533:
      int i3 = 0;
    }
  }
  
  protected void a(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, d.e.UltimateRecyclerview);
    try
    {
      this.i = ((int)paramAttributeSet.getDimension(d.e.UltimateRecyclerview_recyclerviewPadding, -1.1F));
      this.j = ((int)paramAttributeSet.getDimension(d.e.UltimateRecyclerview_recyclerviewPaddingTop, 0.0F));
      this.k = ((int)paramAttributeSet.getDimension(d.e.UltimateRecyclerview_recyclerviewPaddingBottom, 0.0F));
      this.l = ((int)paramAttributeSet.getDimension(d.e.UltimateRecyclerview_recyclerviewPaddingLeft, 0.0F));
      this.m = ((int)paramAttributeSet.getDimension(d.e.UltimateRecyclerview_recyclerviewPaddingRight, 0.0F));
      this.n = paramAttributeSet.getBoolean(d.e.UltimateRecyclerview_recyclerviewClipToPadding, false);
      this.q = paramAttributeSet.getResourceId(d.e.UltimateRecyclerview_recyclerviewEmptyView, 0);
      this.t = paramAttributeSet.getResourceId(d.e.UltimateRecyclerview_recyclerviewFloatingActionView, 0);
      this.L = paramAttributeSet.getInt(d.e.UltimateRecyclerview_recyclerviewScrollbars, 0);
      int i1 = paramAttributeSet.getResourceId(d.e.UltimateRecyclerview_recyclerviewDefaultSwipeColor, 0);
      if (i1 != 0) {
        this.u = getResources().getIntArray(i1);
      }
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  public void a(View paramView)
  {
    e();
    if (this.d != null)
    {
      this.d.c(paramView);
      this.d.d = false;
    }
    this.I = true;
  }
  
  public void b(RecyclerView.ItemDecoration paramItemDecoration)
  {
    this.e.removeItemDecoration(paramItemDecoration);
  }
  
  protected void c()
  {
    LayoutInflater localLayoutInflater = (LayoutInflater)getContext().getSystemService("layout_inflater");
    switch (this.L)
    {
    default: 
      return;
    case 1: 
      this.w.removeView(this.e);
      this.e = ((RecyclerView)localLayoutInflater.inflate(d.d.vertical_recycler_view, this.w, true).findViewById(d.c.ultimate_list));
      return;
    }
    this.w.removeView(this.e);
    this.e = ((RecyclerView)localLayoutInflater.inflate(d.d.horizontal_recycler_view, this.w, true).findViewById(d.c.ultimate_list));
  }
  
  protected void d()
  {
    this.e.removeOnScrollListener(this.g);
    this.g = new l(this);
    this.e.addOnScrollListener(this.g);
  }
  
  public void e()
  {
    this.e.removeOnScrollListener(this.g);
    this.g = new n(this);
    this.e.addOnScrollListener(this.g);
    if ((this.d != null) && (this.d.d() == null)) {
      this.d.c(LayoutInflater.from(getContext()).inflate(d.d.bottom_progressbar, null));
    }
    this.I = true;
  }
  
  public void f()
  {
    d();
    if (this.d != null) {
      this.d.d(LayoutInflater.from(getContext()).inflate(d.d.empty_progressbar, null));
    }
    this.I = false;
  }
  
  public RecyclerView.Adapter getAdapter()
  {
    return this.e.getAdapter();
  }
  
  public int getCurrentScrollY()
  {
    return this.B;
  }
  
  public View getCustomFloatingActionView()
  {
    return this.s;
  }
  
  public FloatingActionButton getDefaultFloatingActionButton()
  {
    return this.f;
  }
  
  public View getEmptyView()
  {
    return this.p;
  }
  
  public RecyclerView.ItemAnimator getItemAnimator()
  {
    return this.e.getItemAnimator();
  }
  
  public RecyclerView.LayoutManager getLayoutManager()
  {
    return this.e.getLayoutManager();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.E != null) {
      switch (paramMotionEvent.getActionMasked())
      {
      }
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      this.G = true;
      this.F = true;
      this.E.a();
      continue;
      this.H = false;
      this.G = false;
      this.E.a(this.D);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SavedStateScrolling)paramParcelable;
    this.x = paramParcelable.b;
    this.y = paramParcelable.c;
    this.z = paramParcelable.d;
    this.A = paramParcelable.e;
    this.B = paramParcelable.f;
    this.C = paramParcelable.g;
    super.onRestoreInstanceState(paramParcelable.a());
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedStateScrolling localSavedStateScrolling = new SavedStateScrolling(super.onSaveInstanceState());
    localSavedStateScrolling.b = this.x;
    localSavedStateScrolling.c = this.y;
    localSavedStateScrolling.d = this.z;
    localSavedStateScrolling.e = this.A;
    localSavedStateScrolling.f = this.B;
    localSavedStateScrolling.g = this.C;
    return localSavedStateScrolling;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    k.a("ev---" + paramMotionEvent);
    if (this.E != null) {
      switch (paramMotionEvent.getActionMasked())
      {
      }
    }
    float f2;
    float f3;
    do
    {
      for (;;)
      {
        return super.onTouchEvent(paramMotionEvent);
        this.H = false;
        this.G = false;
        this.E.a(this.D);
      }
      if (this.J == null) {
        this.J = paramMotionEvent;
      }
      f2 = paramMotionEvent.getY();
      f3 = this.J.getY();
      this.J = MotionEvent.obtainNoHistory(paramMotionEvent);
    } while (getCurrentScrollY() - (f2 - f3) > 0.0F);
    if (this.H) {
      return false;
    }
    if (this.K == null) {}
    for (ViewGroup localViewGroup = (ViewGroup)getParent();; localViewGroup = this.K)
    {
      localObject = this;
      f2 = 0.0F;
      while ((localObject != null) && (localObject != localViewGroup))
      {
        f2 += ((View)localObject).getLeft() - ((View)localObject).getScrollX();
        f1 += ((View)localObject).getTop() - ((View)localObject).getScrollY();
        localObject = (View)((View)localObject).getParent();
      }
    }
    Object localObject = MotionEvent.obtainNoHistory(paramMotionEvent);
    ((MotionEvent)localObject).offsetLocation(f2, f1);
    if (localViewGroup.onInterceptTouchEvent((MotionEvent)localObject))
    {
      this.H = true;
      ((MotionEvent)localObject).setAction(0);
      post(new q(this, localViewGroup, (MotionEvent)localObject));
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  @Deprecated
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    this.e.setAdapter(paramAdapter);
    if (this.w != null) {
      this.w.setRefreshing(false);
    }
    paramAdapter.registerAdapterDataObserver(new p(this));
  }
  
  public void setAdapter(s params)
  {
    this.d = params;
    this.e.setAdapter(this.d);
    if (this.w != null) {
      this.w.setRefreshing(false);
    }
    if (this.d != null) {
      this.d.registerAdapterDataObserver(new o(this));
    }
    if (((params == null) || (this.d.a() == 0)) && (this.q != 0)) {
      this.o.setVisibility(0);
    }
  }
  
  public void setDefaultFloatingActionButton(FloatingActionButton paramFloatingActionButton)
  {
    this.f = paramFloatingActionButton;
  }
  
  public void setDefaultOnRefreshListener(SwipeRefreshLayout.OnRefreshListener paramOnRefreshListener)
  {
    this.w.setEnabled(true);
    if ((this.u != null) && (this.u.length > 0)) {
      this.w.setColorSchemeColors(this.u);
    }
    for (;;)
    {
      this.w.setOnRefreshListener(paramOnRefreshListener);
      return;
      this.w.setColorSchemeResources(new int[] { 17170459, 17170452, 17170456, 17170454 });
    }
  }
  
  public void setDefaultSwipeToRefreshColorScheme(int... paramVarArgs)
  {
    this.w.setColorSchemeColors(paramVarArgs);
  }
  
  public void setEmptyView(@LayoutRes int paramInt)
  {
    this.q = paramInt;
    this.o.setLayoutResource(this.q);
    if (this.q != 0) {
      this.p = this.o.inflate();
    }
    this.o.setVisibility(8);
  }
  
  public void setHasFixedSize(boolean paramBoolean)
  {
    this.e.setHasFixedSize(paramBoolean);
  }
  
  public void setItemAnimator(RecyclerView.ItemAnimator paramItemAnimator)
  {
    this.e.setItemAnimator(paramItemAnimator);
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    this.e.setLayoutManager(paramLayoutManager);
  }
  
  public void setNormalHeader(View paramView)
  {
    setParallaxHeader(paramView);
    U = false;
  }
  
  public void setOnLoadMoreListener(c paramc)
  {
    this.a = paramc;
  }
  
  public void setOnParallaxScroll(d paramd)
  {
    this.T = paramd;
    this.T.a(0.0F, 0.0F, this.Q);
  }
  
  public void setOnScrollListener(RecyclerView.OnScrollListener paramOnScrollListener)
  {
    this.e.setOnScrollListener(paramOnScrollListener);
  }
  
  public void setParallaxHeader(@LayoutRes int paramInt)
  {
    setParallaxHeader(LayoutInflater.from(getContext()).inflate(paramInt, null));
  }
  
  public void setParallaxHeader(View paramView)
  {
    this.Q = new a(paramView.getContext());
    this.Q.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    this.Q.addView(paramView, new RelativeLayout.LayoutParams(-1, -1));
    if (this.d != null) {
      this.d.a(this.Q);
    }
    U = true;
  }
  
  public void setRecylerViewBackgroundColor(@ColorInt int paramInt)
  {
    this.e.setBackgroundColor(paramInt);
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    if (this.w != null) {
      this.w.setRefreshing(paramBoolean);
    }
  }
  
  public void setScrollViewCallbacks(b paramb)
  {
    this.E = paramb;
  }
  
  public void setTouchInterceptionViewGroup(ViewGroup paramViewGroup)
  {
    this.K = paramViewGroup;
    b();
  }
  
  public static class a
    extends RelativeLayout
  {
    private int a;
    
    public a(Context paramContext)
    {
      super();
    }
    
    protected void dispatchDraw(Canvas paramCanvas)
    {
      if (UltimateRecyclerView.g()) {
        paramCanvas.clipRect(new Rect(getLeft(), getTop(), getRight(), getBottom() + this.a));
      }
      super.dispatchDraw(paramCanvas);
    }
    
    public void setClipY(int paramInt)
    {
      this.a = paramInt;
      invalidate();
    }
  }
  
  public static enum b
  {
    private b() {}
  }
  
  public static abstract interface c
  {
    public abstract void a(int paramInt1, int paramInt2);
  }
  
  public static abstract interface d
  {
    public abstract void a(float paramFloat1, float paramFloat2, View paramView);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\UltimateRecyclerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */