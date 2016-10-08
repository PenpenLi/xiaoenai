package com.xiaoenai.app.ui.xrecyclerview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import java.util.Date;

public class ArrowRefreshHeader
  extends LinearLayout
{
  public int a;
  private LinearLayout b;
  private LinearLayout c;
  private ImageView d;
  private SimpleViewSwitcher e;
  private TextView f;
  private int g = 0;
  private TextView h;
  private Animation i;
  private Animation j;
  private String k;
  private String l;
  private String m;
  private String n;
  
  public ArrowRefreshHeader(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  public ArrowRefreshHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  private void a(int paramInt)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { getVisibleHeight(), paramInt });
    localValueAnimator.setDuration(300L).start();
    localValueAnimator.addUpdateListener(new c(this));
    localValueAnimator.start();
  }
  
  private void d()
  {
    this.b = ((LinearLayout)LayoutInflater.from(getContext()).inflate(d.c.listview_header, null));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(0, 0, 0, 0);
    setLayoutParams(localLayoutParams);
    setPadding(0, 0, 0, 0);
    addView(this.b, new LinearLayout.LayoutParams(-1, 0));
    setGravity(80);
    this.c = ((LinearLayout)findViewById(d.b.listview_header_text));
    this.d = ((ImageView)findViewById(d.b.listview_header_arrow));
    this.f = ((TextView)findViewById(d.b.refresh_status_textview));
    this.e = ((SimpleViewSwitcher)findViewById(d.b.listview_header_progressbar));
    this.i = new RotateAnimation(0.0F, -180.0F, 1, 0.5F, 1, 0.5F);
    this.i.setDuration(180L);
    this.i.setFillAfter(true);
    this.j = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.j.setDuration(180L);
    this.j.setFillAfter(true);
    this.h = ((TextView)findViewById(d.b.last_refresh_time));
    measure(-2, -2);
    this.a = getMeasuredHeight();
    this.k = getContext().getString(d.d.xrv_refreshing);
    this.l = getContext().getString(d.d.xrv_refresh_done);
    this.m = getContext().getString(d.d.xrv_listview_header_hint_normal);
    this.n = getContext().getString(d.d.xrv_listview_header_hint_release);
  }
  
  private void e()
  {
    this.c.setVisibility(8);
    Object localObject = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(13, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(9, 0);
    this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.d.setImageResource(d.a.progressbar);
    localObject = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(13, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(9, 0);
    this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new ProgressBar(getContext(), null, 16842871);
    ((ProgressBar)localObject).setIndeterminateDrawable(getResources().getDrawable(d.a.progressbar));
    this.e.setView((View)localObject);
  }
  
  public String a(Date paramDate)
  {
    int i1 = (int)((System.currentTimeMillis() - paramDate.getTime()) / 1000L);
    if (i1 == 0) {
      return getResources().getString(d.d.xrv_just_now);
    }
    if ((i1 > 0) && (i1 < 60)) {
      return i1 + getResources().getString(d.d.xrv_second_ago);
    }
    if ((i1 >= 60) && (i1 < 3600)) {
      return Math.max(i1 / 60, 1) + getResources().getString(d.d.xrv_minutes_ago);
    }
    if ((i1 >= 3600) && (i1 < 86400)) {
      return i1 / 3600 + getResources().getString(d.d.xrv_hour_ago);
    }
    if ((i1 >= 86400) && (i1 < 2592000))
    {
      i1 /= 86400;
      return i1 + getResources().getString(d.d.xrv_day_ago);
    }
    if ((i1 >= 2592000) && (i1 < 31104000)) {
      return i1 / 2592000 + getResources().getString(d.d.xrv_month_ago);
    }
    return i1 / 31104000 + getResources().getString(d.d.xrv_year_ago);
  }
  
  public void a()
  {
    this.h.setText(a(new Date()));
    setState(3);
    new Handler().postDelayed(new a(this), 200L);
  }
  
  public void a(float paramFloat)
  {
    if ((getVisibleHeight() > 0) || (paramFloat > 0.0F))
    {
      setVisibleHeight((int)paramFloat + getVisibleHeight());
      if (this.g <= 1)
      {
        if (getVisibleHeight() <= this.a) {
          break label49;
        }
        setState(1);
      }
    }
    return;
    label49:
    setState(0);
  }
  
  public boolean b()
  {
    int i1 = 0;
    int i2 = getVisibleHeight();
    if ((i2 != 0) || ((getVisibleHeight() > this.a) && (this.g < 2))) {
      setState(2);
    }
    for (boolean bool = true;; bool = false)
    {
      if (((this.g != 2) || (i2 > this.a)) || (this.g == 2)) {
        i1 = this.a;
      }
      a(i1);
      return bool;
    }
  }
  
  public void c()
  {
    a(0);
    new Handler().postDelayed(new b(this), 500L);
  }
  
  public int getState()
  {
    return this.g;
  }
  
  public int getVisibleHeight()
  {
    return ((LinearLayout.LayoutParams)this.b.getLayoutParams()).height;
  }
  
  public void setArrowImageView(int paramInt)
  {
    this.d.setImageResource(paramInt);
  }
  
  public void setHeaderHintNormalTip(String paramString)
  {
    this.m = paramString;
  }
  
  public void setHeaderHintReleaseTip(String paramString)
  {
    this.n = paramString;
  }
  
  public void setProgressStyle(int paramInt)
  {
    if (paramInt == -1) {
      this.e.setView(new ProgressBar(getContext(), null, 16842871));
    }
    while (paramInt != 0) {
      return;
    }
    e();
  }
  
  public void setProgressStyle(ProgressBar paramProgressBar)
  {
    if (paramProgressBar != null) {
      this.e.setView(paramProgressBar);
    }
  }
  
  public void setRefreshDoneTip(String paramString)
  {
    this.l = paramString;
  }
  
  public void setRefreshingTip(String paramString)
  {
    this.k = paramString;
  }
  
  public void setState(int paramInt)
  {
    if (paramInt == this.g) {
      return;
    }
    if (paramInt == 2)
    {
      this.d.clearAnimation();
      this.d.setVisibility(4);
      this.e.setVisibility(0);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.g = paramInt;
      return;
      if (paramInt == 3)
      {
        this.d.setVisibility(4);
        this.e.setVisibility(4);
        break;
      }
      this.d.setVisibility(0);
      this.e.setVisibility(4);
      break;
      if (this.g == 1) {
        this.d.startAnimation(this.j);
      }
      if (this.g == 2) {
        this.d.clearAnimation();
      }
      this.f.setText(this.m);
      continue;
      if (this.g != 1)
      {
        this.d.clearAnimation();
        this.d.startAnimation(this.i);
        this.f.setText(this.n);
        continue;
        this.f.setText(this.k);
        continue;
        this.f.setText(this.l);
      }
    }
  }
  
  public void setVisibleHeight(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = 0;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.height = i1;
    this.b.setLayoutParams(localLayoutParams);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\ui\xrecyclerview\ArrowRefreshHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */