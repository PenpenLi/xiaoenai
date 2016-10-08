package com.handmark.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;

public class PinnedSectionListView
  extends ListView
{
  AbsListView.OnScrollListener a;
  a b;
  a c;
  int d;
  private final Rect e = new Rect();
  private final PointF f = new PointF();
  private int g;
  private View h;
  private MotionEvent i;
  private GradientDrawable j;
  private int k;
  private int l;
  private final AbsListView.OnScrollListener m = new h(this);
  private final DataSetObserver n = new i(this);
  
  public PinnedSectionListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public PinnedSectionListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    paramView.getHitRect(this.e);
    paramView = this.e;
    paramView.top += this.d;
    paramView = this.e;
    paramView.bottom += this.d + getPaddingTop();
    paramView = this.e;
    paramView.left += getPaddingLeft();
    paramView = this.e;
    paramView.right -= getPaddingRight();
    return this.e.contains((int)paramFloat1, (int)paramFloat2);
  }
  
  public static boolean a(ListAdapter paramListAdapter, int paramInt)
  {
    if ((paramListAdapter instanceof HeaderViewListAdapter)) {
      paramListAdapter = ((HeaderViewListAdapter)paramListAdapter).getWrappedAdapter();
    }
    for (;;)
    {
      return ((b)paramListAdapter).a(paramInt);
    }
  }
  
  private void c()
  {
    setOnScrollListener(this.m);
    this.g = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    a(true);
  }
  
  private void d()
  {
    this.h = null;
    if (this.i != null)
    {
      this.i.recycle();
      this.i = null;
    }
  }
  
  private boolean e()
  {
    if (this.c == null) {
      return false;
    }
    AdapterView.OnItemClickListener localOnItemClickListener = getOnItemClickListener();
    if (localOnItemClickListener != null)
    {
      View localView = this.c.a;
      playSoundEffect(0);
      if (localView != null) {
        localView.sendAccessibilityEvent(1);
      }
      localOnItemClickListener.onItemClick(this, localView, this.c.b, this.c.c);
      return true;
    }
    return false;
  }
  
  int a(int paramInt1, int paramInt2)
  {
    ListAdapter localListAdapter = getAdapter();
    int i1 = 0;
    while (i1 < paramInt2)
    {
      int i2 = paramInt1 + i1;
      if ((i2 < paramInt2) && (a(localListAdapter, localListAdapter.getItemViewType(i2)))) {
        return i2;
      }
      i1 += 1;
    }
    return -1;
  }
  
  void a()
  {
    if (this.c != null)
    {
      this.b = this.c;
      this.c = null;
    }
  }
  
  void a(int paramInt)
  {
    a locala = this.b;
    this.b = null;
    if (locala == null) {
      locala = new a();
    }
    for (;;)
    {
      View localView = getAdapter().getView(paramInt, locala.a, this);
      AbsListView.LayoutParams localLayoutParams2 = (AbsListView.LayoutParams)localView.getLayoutParams();
      AbsListView.LayoutParams localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null) {
        localLayoutParams1 = new AbsListView.LayoutParams(-1, -2);
      }
      int i1 = View.MeasureSpec.getMode(localLayoutParams1.height);
      int i2 = View.MeasureSpec.getSize(localLayoutParams1.height);
      if (i1 == 0) {
        i1 = 1073741824;
      }
      for (;;)
      {
        int i3 = getHeight() - getListPaddingTop() - getListPaddingBottom();
        if (i2 > i3) {
          i2 = i3;
        }
        for (;;)
        {
          localView.measure(View.MeasureSpec.makeMeasureSpec(getWidth() - getListPaddingLeft() - getListPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(i2, i1));
          localView.layout(0, 0, localView.getMeasuredWidth(), localView.getMeasuredHeight());
          this.d = 0;
          locala.a = localView;
          locala.b = paramInt;
          locala.c = getAdapter().getItemId(paramInt);
          this.c = locala;
          return;
        }
      }
    }
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 < 2) {
      a();
    }
    do
    {
      return;
      if ((this.c != null) && (this.c.b != paramInt1)) {
        a();
      }
      if (this.c == null) {
        a(paramInt1);
      }
      paramInt1 += 1;
    } while (paramInt1 >= getCount());
    paramInt1 = a(paramInt1, paramInt3 - (paramInt1 - paramInt2));
    if (paramInt1 > -1)
    {
      View localView = getChildAt(paramInt1 - paramInt2);
      paramInt1 = this.c.a.getBottom();
      paramInt2 = getPaddingTop();
      this.k = (localView.getTop() - (paramInt1 + paramInt2));
      if (this.k < 0)
      {
        this.d = this.k;
        return;
      }
      this.d = 0;
      return;
    }
    this.d = 0;
    this.k = Integer.MAX_VALUE;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.j == null)
      {
        this.j = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { Color.parseColor("#ffa0a0a0"), Color.parseColor("#50a0a0a0"), Color.parseColor("#00a0a0a0") });
        this.l = ((int)(8.0F * getResources().getDisplayMetrics().density));
      }
    }
    while (this.j == null) {
      return;
    }
    this.j = null;
    this.l = 0;
  }
  
  int b(int paramInt)
  {
    ListAdapter localListAdapter = getAdapter();
    int i1;
    if ((localListAdapter instanceof SectionIndexer))
    {
      SectionIndexer localSectionIndexer = (SectionIndexer)localListAdapter;
      i1 = localSectionIndexer.getPositionForSection(localSectionIndexer.getSectionForPosition(paramInt));
      if (a(localListAdapter, localListAdapter.getItemViewType(i1))) {
        return i1;
      }
    }
    for (;;)
    {
      if (paramInt < 0) {
        break label78;
      }
      i1 = paramInt;
      if (a(localListAdapter, localListAdapter.getItemViewType(paramInt))) {
        break;
      }
      paramInt -= 1;
    }
    label78:
    return -1;
  }
  
  void b()
  {
    a();
    ListAdapter localListAdapter = getAdapter();
    int i1;
    int i2;
    if ((localListAdapter != null) && (localListAdapter.getCount() > 0))
    {
      i1 = getFirstVisiblePosition();
      i2 = b(i1);
      if (i2 != -1) {}
    }
    else
    {
      return;
    }
    a(i2, i1, getLastVisiblePosition() - i1);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    int i2;
    int i3;
    View localView;
    int i4;
    if (this.c != null)
    {
      i2 = getListPaddingLeft();
      i3 = getListPaddingTop();
      localView = this.c.a;
      paramCanvas.save();
      i4 = localView.getHeight();
      if (this.j != null) {
        break label186;
      }
    }
    label186:
    for (int i1 = 0;; i1 = Math.min(this.l, this.k))
    {
      paramCanvas.clipRect(i2, i3, localView.getWidth() + i2, i1 + i4 + i3);
      paramCanvas.translate(i2, this.d + i3);
      drawChild(paramCanvas, this.c.a, getDrawingTime());
      if ((this.j != null) && (this.k > 0))
      {
        this.j.setBounds(this.c.a.getLeft(), this.c.a.getBottom(), this.c.a.getRight(), this.c.a.getBottom() + this.l);
        this.j.draw(paramCanvas);
      }
      paramCanvas.restore();
      return;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i1 = paramMotionEvent.getAction();
    if ((i1 == 0) && (this.h == null) && (this.c != null) && (a(this.c.a, f1, f2)))
    {
      this.h = this.c.a;
      this.f.x = f1;
      this.f.y = f2;
      this.i = MotionEvent.obtain(paramMotionEvent);
    }
    if (this.h != null)
    {
      if (a(this.h, f1, f2)) {
        this.h.dispatchTouchEvent(paramMotionEvent);
      }
      if (i1 == 1)
      {
        super.dispatchTouchEvent(paramMotionEvent);
        e();
        d();
      }
      do
      {
        return true;
        if (i1 == 3)
        {
          d();
          return true;
        }
      } while ((i1 != 2) || (Math.abs(f2 - this.f.y) <= this.g));
      MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      localMotionEvent.setAction(3);
      this.h.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      super.dispatchTouchEvent(this.i);
      super.dispatchTouchEvent(paramMotionEvent);
      d();
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.c != null) && (paramInt3 - paramInt1 - getPaddingLeft() - getPaddingRight() != this.c.a.getWidth())) {
      b();
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    super.onRestoreInstanceState(paramParcelable);
    post(new j(this));
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    ListAdapter localListAdapter = getAdapter();
    if (localListAdapter != null) {
      localListAdapter.unregisterDataSetObserver(this.n);
    }
    if (paramListAdapter != null) {
      paramListAdapter.registerDataSetObserver(this.n);
    }
    if (localListAdapter != paramListAdapter) {
      a();
    }
    super.setAdapter(paramListAdapter);
  }
  
  public void setColor(int paramInt)
  {
    this.j.setColor(paramInt);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    if (paramOnScrollListener == this.m)
    {
      super.setOnScrollListener(paramOnScrollListener);
      return;
    }
    this.a = paramOnScrollListener;
  }
  
  public void setShadow(int paramInt)
  {
    this.j.setShape(paramInt);
  }
  
  public void setShadowVisible(boolean paramBoolean)
  {
    a(paramBoolean);
    if (this.c != null)
    {
      View localView = this.c.a;
      invalidate(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom() + this.l);
    }
  }
  
  static class a
  {
    public View a;
    public int b;
    public long c;
  }
  
  public static abstract interface b
    extends ListAdapter
  {
    public abstract boolean a(int paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\handmark\pulltorefresh\library\internal\PinnedSectionListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */