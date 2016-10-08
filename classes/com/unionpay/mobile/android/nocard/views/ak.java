package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.upviews.a.a;
import com.unionpay.mobile.android.upviews.a.b;
import com.unionpay.mobile.android.utils.f;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.widgets.ax;
import com.unionpay.mobile.android.widgets.m;
import org.json.JSONObject;

public final class ak
  extends b
  implements a.b
{
  private int p = 100;
  private int q = 20;
  private com.unionpay.mobile.android.upwidget.a r = null;
  private TextView s = null;
  private com.unionpay.mobile.android.upviews.a t = null;
  private View.OnClickListener u = new al(this);
  private View.OnClickListener v = new am(this);
  
  public ak(Context paramContext)
  {
    super(paramContext);
    this.f = 10;
    setBackgroundColor(-1052684);
    this.j = a();
    b();
    super.d();
    c();
  }
  
  private void r()
  {
    this.p = 103;
    h.c("uppay", this.q);
    int i = this.q;
    this.e.a("query", this.a.ae, 3);
    this.q -= 1;
  }
  
  public final void a(a.a parama)
  {
    if (!parama.a())
    {
      a(parama.b);
      return;
    }
    this.i = false;
    this.p = 101;
    this.b.a(com.unionpay.mobile.android.languages.c.by.U);
    h.a("uppay", "sms elements:" + parama.b);
    this.e.b("sms", parama.b);
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    switch (this.p)
    {
    }
    do
    {
      return;
      this.t.a(com.unionpay.mobile.android.global.b.p);
      this.b.c();
      this.p = 100;
      return;
      this.a.ae = f.a(paramJSONObject.toString());
      if ((this.a.ae == null) || (this.a.ae.length() <= 0))
      {
        b(2);
        return;
      }
      this.q = 20;
      r();
      return;
      String str2 = g.a(paramJSONObject, "status");
      String str1 = g.a(paramJSONObject, "fail_msg");
      this.a.N = g.a(paramJSONObject, "open_info");
      this.a.v = g.a(paramJSONObject, "title");
      this.a.w = g.a(paramJSONObject, "succ_info");
      if ((this.q > 0) && (str2.equalsIgnoreCase("01")))
      {
        r();
        return;
      }
      this.p = 100;
      j();
      if (str2.equalsIgnoreCase("00"))
      {
        paramJSONObject = this.a.N;
        d(11);
        return;
      }
      if (str2.equalsIgnoreCase("03"))
      {
        paramJSONObject = new an(this);
        this.b.a(paramJSONObject, null);
        this.b.a(com.unionpay.mobile.android.languages.c.by.ab, str1, com.unionpay.mobile.android.languages.c.by.ac);
        return;
      }
    } while (this.q > 0);
    b(20);
  }
  
  public final void a(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.s != null)
    {
      localTextView = this.s;
      if (paramBoolean) {
        break label24;
      }
    }
    label24:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localTextView.setEnabled(paramBoolean);
      return;
    }
  }
  
  protected final void b()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    ax localax = new ax(getContext(), this.a.v, this);
    localLayoutParams.addRule(13, -1);
    this.j.addView(localax, localLayoutParams);
  }
  
  public final void b(String paramString1, String paramString2) {}
  
  protected final void c()
  {
    boolean bool2 = true;
    Object localObject2 = new LinearLayout(this.d);
    ((LinearLayout)localObject2).setBackgroundColor(-1);
    ((LinearLayout)localObject2).setOrientation(1);
    ((LinearLayout)localObject2).setId(localObject2.hashCode());
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    int i = com.unionpay.mobile.android.global.a.f;
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = i;
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = i;
    this.l.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    this.t = new com.unionpay.mobile.android.upviews.a(this.d, this.a.O, this.e.b(), this, this.a.al, true);
    new LinearLayout.LayoutParams(-1, -1).topMargin = com.unionpay.mobile.android.global.a.f;
    ((LinearLayout)localObject2).addView(this.t);
    localObject1 = new LinearLayout(this.d);
    ((LinearLayout)localObject1).setOrientation(1);
    ((LinearLayout)localObject1).setId(localObject1.hashCode());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = com.unionpay.mobile.android.global.a.d;
    localLayoutParams.leftMargin = com.unionpay.mobile.android.global.a.d;
    localLayoutParams.addRule(3, ((LinearLayout)localObject2).getId());
    this.l.addView((View)localObject1, localLayoutParams);
    this.r = new com.unionpay.mobile.android.upwidget.a(this.d, this.a.ag, this.v);
    ((LinearLayout)localObject1).addView(this.r);
    this.s = new TextView(this.d);
    this.s.setText(g.a(this.a.x, "label"));
    this.s.setTextSize(com.unionpay.mobile.android.global.b.i);
    this.s.setTextColor(p());
    this.s.setGravity(17);
    i = com.unionpay.mobile.android.global.a.n;
    localObject2 = this.c.a(2008);
    this.s.setBackgroundDrawable((Drawable)localObject2);
    this.s.setOnClickListener(this.u);
    localObject2 = this.s;
    boolean bool1 = bool2;
    if (this.t != null) {
      if (!this.t.e()) {
        break label425;
      }
    }
    label425:
    for (bool1 = bool2;; bool1 = false)
    {
      ((TextView)localObject2).setEnabled(bool1);
      localObject2 = new RelativeLayout.LayoutParams(-1, i);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = com.unionpay.mobile.android.global.a.d;
      i = com.unionpay.mobile.android.global.a.d;
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = i;
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = i;
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((LinearLayout)localObject1).getId());
      this.l.addView(this.s, (ViewGroup.LayoutParams)localObject2);
      return;
    }
  }
  
  public final void c(String paramString) {}
  
  public final void l()
  {
    if (this.t.d()) {
      return;
    }
    n();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\mobile\android\nocard\views\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */