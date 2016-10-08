package com.xiaoenai.app.widget.wheel;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WheelView
  extends View
{
  private List<d> A = new LinkedList();
  private List<c> B = new LinkedList();
  private DataSetObserver C = new j(this);
  protected int a = 2130839043;
  protected int b = 2130839047;
  protected float c = 1.5F;
  boolean d = false;
  f.a e = new i(this);
  private int[] f = { -1, 16777210, 16777210 };
  private int[] g = { -269882903, -806753815, 1072294377 };
  private boolean h = false;
  private int i = 0;
  private int j = 5;
  private int k = 0;
  private Drawable l;
  private GradientDrawable m;
  private GradientDrawable n;
  private int o = 24;
  private int p = 24;
  private TextPaint q;
  private TextPaint r;
  private f s;
  private boolean t;
  private int u;
  private LinearLayout v;
  private int w;
  private com.xiaoenai.app.widget.wheel.a.e x;
  private e y = new e(this);
  private List<b> z = new LinkedList();
  
  public WheelView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public WheelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public WheelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private int a(LinearLayout paramLinearLayout)
  {
    if ((paramLinearLayout != null) && (paramLinearLayout.getChildAt(0) != null)) {
      this.k = paramLinearLayout.getChildAt(0).getMeasuredHeight();
    }
    if (this.h) {}
    for (int i1 = this.k * this.j - this.k * 0 / 50;; i1 = this.k * this.j - this.k * 10 / 50) {
      return Math.max(i1, getSuggestedMinimumHeight());
    }
  }
  
  private void a(Context paramContext)
  {
    this.s = new f(getContext(), this.e);
  }
  
  private void a(Canvas paramCanvas)
  {
    if (this.h) {}
    for (int i1 = getItemHeight() * 3;; i1 = (int)(this.c * getItemHeight()))
    {
      this.m.setBounds(0, 0, getWidth(), i1);
      this.m.draw(paramCanvas);
      this.n.setBounds(0, getHeight() - i1, getWidth(), getHeight());
      this.n.draw(paramCanvas);
      return;
    }
  }
  
  private void b(int paramInt)
  {
    this.u += paramInt;
    int i4 = getItemHeight();
    paramInt = this.u / i4;
    int i1 = this.i - paramInt;
    int i5 = this.x.a();
    int i3 = this.u % i4;
    int i2 = i3;
    if (Math.abs(i3) <= i4 / 2) {
      i2 = 0;
    }
    if ((this.d) && (i5 > 0)) {
      if (i2 > 0)
      {
        i2 = i1 - 1;
        i1 = paramInt + 1;
        paramInt = i2;
      }
    }
    for (;;)
    {
      if (paramInt < 0)
      {
        paramInt += i5;
        continue;
        if (i2 < 0)
        {
          i1 += 1;
          i2 = paramInt - 1;
          paramInt = i1;
          i1 = i2;
        }
      }
      else
      {
        paramInt %= i5;
        for (;;)
        {
          i2 = this.u;
          if (paramInt != this.i) {
            a(paramInt, false);
          }
          for (;;)
          {
            this.u = (i2 - i1 * i4);
            if (this.u > getHeight()) {
              this.u = (this.u % getHeight() + getHeight());
            }
            return;
            if (i1 < 0)
            {
              i1 = this.i;
              paramInt = 0;
              break;
            }
            if (i1 >= i5)
            {
              i1 = this.i - i5 + 1;
              paramInt = i5 - 1;
              break;
            }
            if ((i1 > 0) && (i2 > 0))
            {
              i1 -= 1;
              i2 = paramInt + 1;
              paramInt = i1;
              i1 = i2;
              break;
            }
            if ((i1 >= i5 - 1) || (i2 >= 0)) {
              break label284;
            }
            i1 += 1;
            i2 = paramInt - 1;
            paramInt = i1;
            i1 = i2;
            break;
            invalidate();
          }
          label284:
          i2 = paramInt;
          paramInt = i1;
          i1 = i2;
        }
      }
      i2 = paramInt;
      paramInt = i1;
      i1 = i2;
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(10.0F, -((this.i - this.w) * getItemHeight() + (getItemHeight() - getHeight()) / 2) + this.u);
    this.v.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  private boolean b(int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    View localView = d(paramInt);
    if (localView != null)
    {
      if (!paramBoolean) {
        break label32;
      }
      this.v.addView(localView, 0);
    }
    for (;;)
    {
      bool = true;
      return bool;
      label32:
      this.v.addView(localView);
    }
  }
  
  private int c(int paramInt1, int paramInt2)
  {
    int i1;
    if (this.h)
    {
      e();
      this.v.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      this.v.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      i1 = this.v.getMeasuredWidth();
      if (paramInt2 != 1073741824) {
        break label92;
      }
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      this.v.measure(View.MeasureSpec.makeMeasureSpec(paramInt2 - 20, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
      return paramInt2;
      d();
      break;
      label92:
      i1 = Math.max(i1 + 20, getSuggestedMinimumWidth());
      if (paramInt2 == Integer.MIN_VALUE)
      {
        paramInt2 = paramInt1;
        if (paramInt1 < i1) {}
      }
      else
      {
        paramInt2 = i1;
      }
    }
  }
  
  private void c(Canvas paramCanvas)
  {
    int i1 = getHeight() / 2;
    int i2 = getItemHeight() / 2;
    if (this.h)
    {
      Paint localPaint = new Paint();
      localPaint.setColor(getResources().getColor(2131493086));
      localPaint.setStrokeWidth(3.0F);
      paramCanvas.drawLine(0.0F, i1 - i2, getWidth(), i1 - i2, localPaint);
      paramCanvas.drawLine(0.0F, i1 + i2, getWidth(), i1 + i2, localPaint);
      return;
    }
    this.l.setBounds(0, i1 - i2, getWidth(), i1 + i2);
    this.l.draw(paramCanvas);
  }
  
  private boolean c(int paramInt)
  {
    return (this.x != null) && (this.x.a() > 0) && ((this.d) || ((paramInt >= 0) && (paramInt < this.x.a())));
  }
  
  private View d(int paramInt)
  {
    if ((this.x == null) || (this.x.a() == 0)) {
      return null;
    }
    int i2 = this.x.a();
    int i1 = paramInt;
    if (!c(paramInt)) {
      return this.x.a(this.y.b(), this.v);
    }
    while (i1 < 0) {
      i1 += i2;
    }
    return this.x.a(i1 % i2, this.y.a(), this.v);
  }
  
  private void d()
  {
    if (this.q == null)
    {
      this.q = new TextPaint(33);
      this.q.setTextSize(this.p);
    }
    if (this.r == null)
    {
      this.r = new TextPaint(37);
      this.r.setTextSize(this.o);
      this.r.setShadowLayer(0.1F, 0.0F, 0.1F, -4144960);
    }
    if (this.l == null) {
      this.l = getContext().getResources().getDrawable(this.b);
    }
    if (this.m == null) {
      this.m = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.f);
    }
    if (this.n == null) {
      this.n = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, this.f);
    }
    setBackgroundResource(this.a);
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    this.v.layout(0, 0, paramInt1 - 20, paramInt2);
  }
  
  private void e()
  {
    if (this.l == null) {
      this.l = getContext().getResources().getDrawable(2130839048);
    }
    if (this.m == null) {
      this.m = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.g);
    }
    if (this.n == null) {
      this.n = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, this.g);
    }
    setBackgroundResource(2130839044);
  }
  
  private boolean f()
  {
    a locala = getItemsRange();
    int i1;
    boolean bool1;
    label45:
    boolean bool2;
    if (this.v != null)
    {
      i1 = this.y.a(this.v, this.w, locala);
      if (this.w != i1)
      {
        bool1 = true;
        this.w = i1;
        bool2 = bool1;
        if (!bool1)
        {
          if ((this.w == locala.a()) && (this.v.getChildCount() == locala.c())) {
            break label210;
          }
          bool2 = true;
        }
        label82:
        if ((this.w <= locala.a()) || (this.w > locala.b())) {
          break label228;
        }
        i1 = this.w - 1;
        label111:
        if ((i1 >= locala.a()) && (b(i1, true))) {
          break label216;
        }
      }
    }
    int i2;
    for (;;)
    {
      i2 = this.w;
      i1 = this.v.getChildCount();
      while (i1 < locala.c())
      {
        int i3 = i2;
        if (!b(this.w + i1, false))
        {
          i3 = i2;
          if (this.v.getChildCount() == 0) {
            i3 = i2 + 1;
          }
        }
        i1 += 1;
        i2 = i3;
      }
      bool1 = false;
      break;
      h();
      bool1 = true;
      break label45;
      label210:
      bool2 = false;
      break label82;
      label216:
      this.w = i1;
      i1 -= 1;
      break label111;
      label228:
      this.w = locala.a();
    }
    this.w = i2;
    return bool2;
  }
  
  private void g()
  {
    if (f())
    {
      c(getWidth(), 1073741824);
      d(getWidth(), getHeight());
    }
  }
  
  private int getItemHeight()
  {
    if (this.k != 0) {
      return this.k;
    }
    if ((this.v != null) && (this.v.getChildAt(0) != null))
    {
      this.k = this.v.getChildAt(0).getHeight();
      return this.k;
    }
    return getHeight() / this.j;
  }
  
  private a getItemsRange()
  {
    if (getItemHeight() == 0) {
      return null;
    }
    int i1 = this.i;
    int i2 = 1;
    while (getItemHeight() * i2 < getHeight())
    {
      i1 -= 1;
      i2 += 2;
    }
    int i4 = i2;
    int i3 = i1;
    if (this.u != 0)
    {
      i3 = i1;
      if (this.u > 0) {
        i3 = i1 - 1;
      }
      i1 = this.u / getItemHeight();
      i3 -= i1;
      double d1 = i2 + 1;
      i4 = (int)(Math.asin(i1) + d1);
    }
    return new a(i3, i4);
  }
  
  private void h()
  {
    if (this.v == null)
    {
      this.v = new LinearLayout(getContext());
      this.v.setOrientation(1);
    }
  }
  
  private void i()
  {
    if (this.v != null) {
      this.y.a(this.v, this.w, new a());
    }
    for (;;)
    {
      int i2 = this.j / 2;
      int i1 = this.i + i2;
      while (i1 >= this.i - i2)
      {
        if (b(i1, true)) {
          this.w = i1;
        }
        i1 -= 1;
      }
      h();
    }
  }
  
  protected void a()
  {
    Iterator localIterator = this.A.iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).a(this);
    }
  }
  
  protected void a(int paramInt)
  {
    Iterator localIterator = this.B.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).a(this, paramInt);
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.z.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).a(this, paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((this.x == null) || (this.x.a() == 0)) {}
    int i2;
    int i1;
    do
    {
      do
      {
        return;
        i2 = this.x.a();
        if (paramInt >= 0)
        {
          i1 = paramInt;
          if (paramInt < i2) {
            break;
          }
        }
      } while (!this.d);
      while (paramInt < 0) {
        paramInt += i2;
      }
      i1 = paramInt % i2;
    } while (i1 == this.i);
    if (paramBoolean)
    {
      paramInt = i1 - this.i;
      if (!this.d) {
        break label170;
      }
      i1 = i2 + Math.min(i1, this.i) - Math.max(i1, this.i);
      if (i1 >= Math.abs(paramInt)) {
        break label170;
      }
      if (paramInt < 0) {
        paramInt = i1;
      }
    }
    label170:
    for (;;)
    {
      b(paramInt, 0);
      return;
      paramInt = -i1;
      continue;
      this.u = 0;
      paramInt = this.i;
      this.i = i1;
      a(paramInt, this.i);
      invalidate();
      return;
    }
  }
  
  public void a(b paramb)
  {
    this.z.add(paramb);
  }
  
  public void a(d paramd)
  {
    this.A.add(paramd);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.y.c();
      if (this.v != null) {
        this.v.removeAllViews();
      }
      this.u = 0;
    }
    for (;;)
    {
      invalidate();
      return;
      if (this.v != null) {
        this.y.a(this.v, this.w, new a());
      }
    }
  }
  
  protected void b()
  {
    Iterator localIterator = this.A.iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).b(this);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    int i1 = getItemHeight();
    int i2 = this.u;
    this.s.a(i1 * paramInt1 - i2, paramInt2);
  }
  
  public void b(b paramb)
  {
    this.z.remove(paramb);
  }
  
  public boolean c()
  {
    return this.d;
  }
  
  public int getCurrentItem()
  {
    return this.i;
  }
  
  public com.xiaoenai.app.widget.wheel.a.e getViewAdapter()
  {
    return this.x;
  }
  
  public int getVisibleItems()
  {
    return this.j;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.x != null) && (this.x.a() > 0))
    {
      g();
      b(paramCanvas);
      c(paramCanvas);
    }
    a(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    d(paramInt3 - paramInt1, paramInt4 - paramInt2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    int i3 = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    i();
    i2 = c(i3, i2);
    if (i1 == 1073741824) {}
    for (;;)
    {
      setMeasuredDimension(i2, paramInt1);
      return;
      paramInt2 = a(this.v);
      if (i1 == Integer.MIN_VALUE) {
        paramInt1 = Math.min(paramInt2, paramInt1);
      } else {
        paramInt1 = paramInt2;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!isEnabled()) || (getViewAdapter() == null)) {
      return true;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        return this.s.a(paramMotionEvent);
        if (getParent() != null) {
          getParent().requestDisallowInterceptTouchEvent(true);
        }
      }
    } while (this.t);
    int i1 = (int)paramMotionEvent.getY() - getHeight() / 2;
    if (i1 > 0) {
      i1 += getItemHeight() / 2;
    }
    for (;;)
    {
      i1 /= getItemHeight();
      if ((i1 == 0) || (!c(this.i + i1))) {
        break;
      }
      a(i1 + this.i);
      break;
      i1 -= getItemHeight() / 2;
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void setCyclic(boolean paramBoolean)
  {
    this.d = paramBoolean;
    a(false);
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.s.a(paramInterpolator);
  }
  
  public void setProvincePicker(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setShadowCount(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  public void setShadowsColors(int[] paramArrayOfInt)
  {
    this.f = paramArrayOfInt;
  }
  
  public void setTextColor(int paramInt)
  {
    if ((this.x != null) && ((this.x instanceof com.xiaoenai.app.widget.wheel.a.b))) {
      ((com.xiaoenai.app.widget.wheel.a.b)this.x).b(paramInt);
    }
  }
  
  public void setTextSize(int paramInt)
  {
    if ((this.x != null) && ((this.x instanceof com.xiaoenai.app.widget.wheel.a.b))) {
      ((com.xiaoenai.app.widget.wheel.a.b)this.x).c(paramInt);
    }
  }
  
  public void setViewAdapter(com.xiaoenai.app.widget.wheel.a.e parame)
  {
    if (this.x != null) {
      this.x.b(this.C);
    }
    this.x = parame;
    if (this.x != null) {
      this.x.a(this.C);
    }
    a(true);
  }
  
  public void setVisibleItems(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setWheelBgResourceId(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setWheelValResourceId(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\widget\wheel\WheelView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */