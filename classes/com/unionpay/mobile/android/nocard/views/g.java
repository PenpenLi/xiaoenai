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
import com.unionpay.mobile.android.upwidget.UPScrollView;
import com.unionpay.mobile.android.utils.d;
import com.unionpay.mobile.android.widgets.ax;
import com.unionpay.mobile.android.widgets.m;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g
  extends b
  implements a.b
{
  private int p = 20;
  private int q = 100;
  private com.unionpay.mobile.android.upwidget.a r = null;
  private TextView s = null;
  private com.unionpay.mobile.android.upviews.a t = null;
  private boolean u = false;
  private boolean v = true;
  private View.OnClickListener w = new h(this);
  private View.OnClickListener x = new i(this);
  
  public g(Context paramContext)
  {
    super(paramContext);
    this.f = 5;
    if (!this.a.F) {}
    for (;;)
    {
      this.v = bool;
      setBackgroundColor(-1052684);
      e();
      return;
      bool = false;
    }
  }
  
  private void e(JSONObject paramJSONObject)
  {
    j();
    this.a.u = com.unionpay.mobile.android.utils.g.c(paramJSONObject, "rules");
    this.a.v = com.unionpay.mobile.android.utils.g.a(paramJSONObject, "title");
    this.a.x = com.unionpay.mobile.android.utils.g.b(paramJSONObject, "followrules_button");
    this.a.ag = com.unionpay.mobile.android.utils.g.b(paramJSONObject, "service_checkbox");
    this.a.ah = com.unionpay.mobile.android.utils.g.b(paramJSONObject, "bind_card_checkbox");
    this.a.al = com.unionpay.mobile.android.utils.g.a(paramJSONObject, "pan");
    if ((this.a.u == null) || (this.a.u.length() <= 0))
    {
      b(2);
      return;
    }
    if (this.t != null) {
      this.t.f();
    }
    paramJSONObject = com.unionpay.mobile.android.nocard.utils.f.a(paramJSONObject);
    this.a.F = false;
    a(6, paramJSONObject);
  }
  
  private void r()
  {
    this.e.h(this.t.a("pan"));
    this.q = 104;
  }
  
  private void s()
  {
    this.q = 103;
    int i = this.p;
    this.e.a("query", this.a.ae, 3);
    this.p -= 1;
  }
  
  public final void a(a.a parama)
  {
    if (parama.a())
    {
      this.i = false;
      this.q = 101;
      this.b.a(com.unionpay.mobile.android.languages.c.by.U);
      com.unionpay.mobile.android.utils.h.a("uppay", "sms elements:" + parama.b);
      this.e.b("sms", parama.b);
      return;
    }
    a(parama.b);
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    this.v = false;
    switch (this.q)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          this.t.a(com.unionpay.mobile.android.global.b.p);
          this.b.c();
          this.q = 100;
          return;
          this.a.ae = com.unionpay.mobile.android.utils.f.a(paramJSONObject.toString());
          if ((this.a.ae == null) || (this.a.ae.length() <= 0))
          {
            b(2);
            return;
          }
          this.p = 20;
          s();
          return;
          Object localObject = com.unionpay.mobile.android.utils.g.a(paramJSONObject, "status");
          paramJSONObject = com.unionpay.mobile.android.utils.g.a(paramJSONObject, "fail_msg");
          if ((this.p > 0) && (((String)localObject).equalsIgnoreCase("01")))
          {
            s();
            return;
          }
          this.q = 100;
          if (((String)localObject).equalsIgnoreCase("00"))
          {
            this.u = true;
            r();
            return;
          }
          j();
          if (((String)localObject).equalsIgnoreCase("03"))
          {
            localObject = new j(this);
            k localk = new k(this);
            if (this.a.A)
            {
              this.b.a((View.OnClickListener)localObject, localk);
              this.b.a(com.unionpay.mobile.android.languages.c.by.ab, paramJSONObject, com.unionpay.mobile.android.languages.c.by.ac, com.unionpay.mobile.android.languages.c.by.ad);
              return;
            }
            this.b.a((View.OnClickListener)localObject, null);
            this.b.a(com.unionpay.mobile.android.languages.c.by.ab, paramJSONObject, com.unionpay.mobile.android.languages.c.by.ac);
            return;
          }
        } while (this.p > 0);
        a(this.a.af);
        return;
      } while (c(paramJSONObject));
      e(paramJSONObject);
      return;
      j();
      int i = com.unionpay.mobile.android.nocard.utils.f.a(this.a, paramJSONObject, false);
      if (i != 0)
      {
        b(i);
        return;
      }
      paramJSONObject = com.unionpay.mobile.android.nocard.utils.f.a(paramJSONObject);
      if ((this.a.u != null) && (this.a.u.length() > 0))
      {
        a(6, paramJSONObject);
        return;
      }
    } while ((this.a.y == null) || (this.a.y.length() <= 0));
    d(5);
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
  
  protected final boolean a(String paramString, JSONObject paramJSONObject)
  {
    this.v = false;
    return false;
  }
  
  protected final void b()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    ax localax = new ax(getContext(), this.a.v, this);
    localLayoutParams.addRule(13, -1);
    this.j.addView(localax, localLayoutParams);
  }
  
  public final void b(String paramString1, String paramString2) {}
  
  protected final void b(String paramString, JSONObject paramJSONObject)
  {
    if ("init".equals(paramString))
    {
      a(2);
      return;
    }
    if ("".equals(paramString))
    {
      e(paramJSONObject);
      return;
    }
    this.b.a(com.unionpay.mobile.android.languages.c.by.U);
    this.i = false;
    this.q = 105;
    this.e.b(paramString, "");
  }
  
  protected final void c()
  {
    boolean bool2 = true;
    this.n.a(this);
    LinearLayout localLinearLayout = new LinearLayout(this.d);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setId(localLinearLayout.hashCode());
    Object localObject = new RelativeLayout.LayoutParams(-1, -2);
    int i = com.unionpay.mobile.android.global.a.d;
    this.l.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject);
    this.t = new com.unionpay.mobile.android.upviews.a(this.d, this.a.y, this.e.b(), this, this.a.al, true);
    localObject = new LinearLayout.LayoutParams(-1, -1);
    ((LinearLayout.LayoutParams)localObject).topMargin = com.unionpay.mobile.android.global.a.f;
    localLinearLayout.addView(this.t, (ViewGroup.LayoutParams)localObject);
    localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).topMargin = i;
    ((RelativeLayout.LayoutParams)localObject).leftMargin = com.unionpay.mobile.android.global.a.f;
    ((RelativeLayout.LayoutParams)localObject).addRule(3, localLinearLayout.getId());
    localLinearLayout = new LinearLayout(this.d);
    localLinearLayout.setOrientation(0);
    localLinearLayout.setId(localLinearLayout.hashCode());
    this.r = new com.unionpay.mobile.android.upwidget.a(this.d, this.a.ag, this.x);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLinearLayout.addView(this.r, localLayoutParams);
    this.l.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject);
    this.s = new TextView(this.d);
    this.s.setText(com.unionpay.mobile.android.utils.g.a(this.a.x, "label"));
    this.s.setTextSize(com.unionpay.mobile.android.global.b.i);
    this.s.setTextColor(p());
    this.s.setGravity(17);
    i = com.unionpay.mobile.android.global.a.n;
    localObject = this.c.a(2008);
    this.s.setBackgroundDrawable((Drawable)localObject);
    this.s.setOnClickListener(this.w);
    localObject = this.s;
    boolean bool1 = bool2;
    if (this.t != null) {
      if (!this.t.e()) {
        break label438;
      }
    }
    label438:
    for (bool1 = bool2;; bool1 = false)
    {
      ((TextView)localObject).setEnabled(bool1);
      localObject = new RelativeLayout.LayoutParams(-1, i);
      ((RelativeLayout.LayoutParams)localObject).topMargin = com.unionpay.mobile.android.global.a.f;
      i = d.a(this.d, 10.0F);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = i;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = i;
      ((RelativeLayout.LayoutParams)localObject).addRule(3, localLinearLayout.getId());
      this.l.addView(this.s, (ViewGroup.LayoutParams)localObject);
      return;
    }
  }
  
  public final void c(String paramString) {}
  
  public final void l()
  {
    if (this.t.d()) {
      return;
    }
    if (this.a.G)
    {
      a(13);
      this.a.G = false;
      return;
    }
    if ((this.a.F) && (this.v))
    {
      this.a.F = false;
      com.unionpay.mobile.android.nocard.utils.f.a(this.a, this.a.B);
      n();
      return;
    }
    this.a.F = false;
    this.a.B = null;
    a(2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\mobile\android\nocard\views\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */