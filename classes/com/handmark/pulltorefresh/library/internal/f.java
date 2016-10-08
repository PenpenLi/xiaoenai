package com.handmark.pulltorefresh.library.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.b;
import com.handmark.pulltorefresh.library.PullToRefreshBase.h;
import com.handmark.pulltorefresh.library.b;
import com.handmark.pulltorefresh.library.l.d;
import com.handmark.pulltorefresh.library.l.e;
import com.handmark.pulltorefresh.library.l.f;
import com.handmark.pulltorefresh.library.l.g;

@SuppressLint({"ViewConstructor"})
public abstract class f
  extends FrameLayout
  implements b
{
  static final Interpolator a = new LinearInterpolator();
  protected final ImageView b;
  protected final ProgressBar c;
  protected final PullToRefreshBase.b d;
  protected final PullToRefreshBase.h e;
  private FrameLayout f;
  private boolean g;
  private final TextView h;
  private final TextView i;
  private CharSequence j;
  private CharSequence k;
  private CharSequence l;
  
  public f(Context paramContext, PullToRefreshBase.b paramb, PullToRefreshBase.h paramh, TypedArray paramTypedArray)
  {
    super(paramContext);
    this.d = paramb;
    this.e = paramh;
    FrameLayout.LayoutParams localLayoutParams;
    int m;
    switch (g.a[paramh.ordinal()])
    {
    default: 
      LayoutInflater.from(paramContext).inflate(l.e.pull_to_refresh_header_vertical, this);
      this.f = ((FrameLayout)findViewById(l.d.fl_inner));
      this.h = ((TextView)this.f.findViewById(l.d.pull_to_refresh_text));
      this.c = ((ProgressBar)this.f.findViewById(l.d.pull_to_refresh_progress));
      this.i = ((TextView)this.f.findViewById(l.d.pull_to_refresh_sub_text));
      this.b = ((ImageView)this.f.findViewById(l.d.pull_to_refresh_image));
      localLayoutParams = (FrameLayout.LayoutParams)this.f.getLayoutParams();
      switch (g.b[paramb.ordinal()])
      {
      default: 
        if (paramh == PullToRefreshBase.h.a)
        {
          m = 80;
          label183:
          localLayoutParams.gravity = m;
          this.j = paramContext.getString(l.f.pull_to_refresh_pull_label);
          this.k = paramContext.getString(l.f.pull_to_refresh_refreshing_label);
          this.l = paramContext.getString(l.f.pull_to_refresh_release_label);
          if (paramTypedArray.hasValue(l.g.PullToRefresh_ptrHeaderBackground))
          {
            paramh = paramTypedArray.getDrawable(l.g.PullToRefresh_ptrHeaderBackground);
            if (paramh != null) {
              m.a(this, paramh);
            }
          }
          if (paramTypedArray.hasValue(l.g.PullToRefresh_ptrHeaderTextAppearance))
          {
            paramh = new TypedValue();
            paramTypedArray.getValue(l.g.PullToRefresh_ptrHeaderTextAppearance, paramh);
            setTextAppearance(paramh.data);
          }
          if (paramTypedArray.hasValue(l.g.PullToRefresh_ptrSubHeaderTextAppearance))
          {
            paramh = new TypedValue();
            paramTypedArray.getValue(l.g.PullToRefresh_ptrSubHeaderTextAppearance, paramh);
            setSubTextAppearance(paramh.data);
          }
          if (paramTypedArray.hasValue(l.g.PullToRefresh_ptrHeaderTextColor))
          {
            paramh = paramTypedArray.getColorStateList(l.g.PullToRefresh_ptrHeaderTextColor);
            if (paramh != null) {
              setTextColor(paramh);
            }
          }
          if (paramTypedArray.hasValue(l.g.PullToRefresh_ptrHeaderSubTextColor))
          {
            paramh = paramTypedArray.getColorStateList(l.g.PullToRefresh_ptrHeaderSubTextColor);
            if (paramh != null) {
              setSubTextColor(paramh);
            }
          }
          paramh = null;
          if (paramTypedArray.hasValue(l.g.PullToRefresh_ptrDrawable)) {
            paramh = paramTypedArray.getDrawable(l.g.PullToRefresh_ptrDrawable);
          }
          switch (g.b[paramb.ordinal()])
          {
          default: 
            if (paramTypedArray.hasValue(l.g.PullToRefresh_ptrDrawableStart)) {
              paramb = paramTypedArray.getDrawable(l.g.PullToRefresh_ptrDrawableStart);
            }
            break;
          }
        }
        break;
      }
      break;
    }
    for (;;)
    {
      paramh = paramb;
      if (paramb == null) {
        paramh = paramContext.getResources().getDrawable(getDefaultDrawableResId());
      }
      setLoadingDrawable(paramh);
      i();
      return;
      LayoutInflater.from(paramContext).inflate(l.e.pull_to_refresh_header_horizontal, this);
      break;
      if (paramh == PullToRefreshBase.h.a) {}
      for (m = 48;; m = 3)
      {
        localLayoutParams.gravity = m;
        this.j = paramContext.getString(l.f.pull_to_refresh_from_bottom_pull_label);
        this.k = paramContext.getString(l.f.pull_to_refresh_from_bottom_refreshing_label);
        this.l = paramContext.getString(l.f.pull_to_refresh_from_bottom_release_label);
        break;
      }
      m = 5;
      break label183;
      paramb = paramh;
      if (paramTypedArray.hasValue(l.g.PullToRefresh_ptrDrawableTop))
      {
        l.a("ptrDrawableTop", "ptrDrawableStart");
        paramb = paramTypedArray.getDrawable(l.g.PullToRefresh_ptrDrawableTop);
        continue;
        if (paramTypedArray.hasValue(l.g.PullToRefresh_ptrDrawableEnd))
        {
          paramb = paramTypedArray.getDrawable(l.g.PullToRefresh_ptrDrawableEnd);
        }
        else
        {
          paramb = paramh;
          if (paramTypedArray.hasValue(l.g.PullToRefresh_ptrDrawableBottom))
          {
            l.a("ptrDrawableBottom", "ptrDrawableEnd");
            paramb = paramTypedArray.getDrawable(l.g.PullToRefresh_ptrDrawableBottom);
          }
        }
      }
    }
  }
  
  private void setSubHeaderText(CharSequence paramCharSequence)
  {
    if (this.i != null)
    {
      if (!TextUtils.isEmpty(paramCharSequence)) {
        break label24;
      }
      this.i.setVisibility(8);
    }
    label24:
    do
    {
      return;
      this.i.setText(paramCharSequence);
    } while (8 != this.i.getVisibility());
    this.i.setVisibility(0);
  }
  
  private void setSubTextAppearance(int paramInt)
  {
    if (this.i != null) {
      this.i.setTextAppearance(getContext(), paramInt);
    }
  }
  
  private void setSubTextColor(ColorStateList paramColorStateList)
  {
    if (this.i != null) {
      this.i.setTextColor(paramColorStateList);
    }
  }
  
  private void setTextAppearance(int paramInt)
  {
    if (this.h != null) {
      this.h.setTextAppearance(getContext(), paramInt);
    }
    if (this.i != null) {
      this.i.setTextAppearance(getContext(), paramInt);
    }
  }
  
  private void setTextColor(ColorStateList paramColorStateList)
  {
    if (this.h != null) {
      this.h.setTextColor(paramColorStateList);
    }
    if (this.i != null) {
      this.i.setTextColor(paramColorStateList);
    }
  }
  
  protected abstract void a();
  
  protected abstract void a(float paramFloat);
  
  protected abstract void a(Drawable paramDrawable);
  
  protected abstract void b();
  
  public final void b(float paramFloat)
  {
    if (!this.g) {
      a(paramFloat);
    }
  }
  
  protected abstract void c();
  
  protected abstract void d();
  
  public final void e()
  {
    if (this.h.getVisibility() == 0) {
      this.h.setVisibility(4);
    }
    if (this.c.getVisibility() == 0) {
      this.c.setVisibility(4);
    }
    if (this.b.getVisibility() == 0) {
      this.b.setVisibility(4);
    }
    if (this.i.getVisibility() == 0) {
      this.i.setVisibility(4);
    }
  }
  
  public final void f()
  {
    if (this.h != null) {
      this.h.setText(this.j);
    }
    a();
  }
  
  public final void g()
  {
    if (this.h != null) {
      this.h.setText(this.k);
    }
    if (this.g) {
      ((AnimationDrawable)this.b.getDrawable()).start();
    }
    for (;;)
    {
      if (this.i != null) {
        this.i.setVisibility(8);
      }
      return;
      b();
    }
  }
  
  public final int getContentSize()
  {
    switch (g.a[this.e.ordinal()])
    {
    default: 
      return this.f.getHeight();
    }
    return this.f.getWidth();
  }
  
  protected abstract int getDefaultDrawableResId();
  
  public final void h()
  {
    if (this.h != null) {
      this.h.setText(this.l);
    }
    c();
  }
  
  public final void i()
  {
    if (this.h != null) {
      this.h.setText(this.j);
    }
    this.b.setVisibility(0);
    if (this.g) {
      ((AnimationDrawable)this.b.getDrawable()).stop();
    }
    for (;;)
    {
      if (this.i != null)
      {
        if (!TextUtils.isEmpty(this.i.getText())) {
          break;
        }
        this.i.setVisibility(8);
      }
      return;
      d();
    }
    this.i.setVisibility(0);
  }
  
  public final void j()
  {
    if (4 == this.h.getVisibility()) {
      this.h.setVisibility(0);
    }
    if (4 == this.c.getVisibility()) {
      this.c.setVisibility(0);
    }
    if (4 == this.b.getVisibility()) {
      this.b.setVisibility(0);
    }
    if (4 == this.i.getVisibility()) {
      this.i.setVisibility(0);
    }
  }
  
  public final void setHeight(int paramInt)
  {
    getLayoutParams().height = paramInt;
    requestLayout();
  }
  
  public void setLastUpdatedLabel(CharSequence paramCharSequence)
  {
    setSubHeaderText(paramCharSequence);
  }
  
  public final void setLoadingDrawable(Drawable paramDrawable)
  {
    this.b.setImageDrawable(paramDrawable);
    this.g = (paramDrawable instanceof AnimationDrawable);
    a(paramDrawable);
  }
  
  public void setPullLabel(CharSequence paramCharSequence)
  {
    this.j = paramCharSequence;
  }
  
  public void setRefreshingLabel(CharSequence paramCharSequence)
  {
    this.k = paramCharSequence;
  }
  
  public void setReleaseLabel(CharSequence paramCharSequence)
  {
    this.l = paramCharSequence;
  }
  
  public void setTextTypeface(Typeface paramTypeface)
  {
    this.h.setTypeface(paramTypeface);
  }
  
  public final void setWidth(int paramInt)
  {
    getLayoutParams().width = paramInt;
    requestLayout();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\handmark\pulltorefresh\library\internal\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */