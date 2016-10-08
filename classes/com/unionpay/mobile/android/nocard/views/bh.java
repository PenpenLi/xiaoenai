package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.upviews.d;
import com.unionpay.mobile.android.upviews.d.a;
import com.unionpay.mobile.android.widgets.ax;
import org.json.JSONObject;

public final class bh
  extends b
  implements d.a
{
  private d p = null;
  private ViewGroup q = null;
  
  public bh(Context paramContext)
  {
    super(paramContext);
    this.f = 14;
    this.j = a();
    b();
    d();
  }
  
  public final void a(JSONObject paramJSONObject) {}
  
  protected final void b()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    ax localax = new ax(this.d, this.a.aa, this);
    localLayoutParams.addRule(13, -1);
    this.j.addView(localax, localLayoutParams);
  }
  
  protected final void d()
  {
    super.d();
    this.p = new d(this.d, this);
    this.p.setOnTouchListener(new bi(this));
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, this.j.getId());
    ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
    this.l.addView(this.p, (ViewGroup.LayoutParams)localObject);
    this.q = new RelativeLayout(this.d);
    localObject = new RelativeLayout.LayoutParams(-1, a.t - a.k);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, this.j.getId());
    ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
    ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
    this.l.addView(this.q, (ViewGroup.LayoutParams)localObject);
    localObject = new ProgressBar(this.d);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13, -1);
    this.q.addView((View)localObject, localLayoutParams);
    this.p.a(this.a.ab);
  }
  
  public final void l()
  {
    ((InputMethodManager)this.d.getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    super.l();
  }
  
  public final void r()
  {
    this.p.setVisibility(8);
    this.q.setVisibility(0);
  }
  
  public final void s()
  {
    this.p.setVisibility(0);
    this.q.setVisibility(8);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\mobile\android\nocard\views\bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */