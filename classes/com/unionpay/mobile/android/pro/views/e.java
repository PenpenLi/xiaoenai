package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
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
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.widgets.ax;
import com.unionpay.mobile.android.widgets.m;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class e
  extends com.unionpay.mobile.android.nocard.views.b
  implements Handler.Callback, a.b
{
  private View.OnClickListener A = new h(this);
  private String p = "00";
  private int q = 0;
  private int r = 0;
  private int s = 20;
  private com.unionpay.mobile.android.upwidget.a t = null;
  private com.unionpay.mobile.android.upwidget.a u = null;
  private TextView v = null;
  private com.unionpay.mobile.android.upviews.a w = null;
  private boolean x = false;
  private Handler y = null;
  private View.OnClickListener z = new f(this);
  
  public e(Context paramContext, com.unionpay.mobile.android.model.d paramd)
  {
    super(paramContext, paramd);
    this.f = 6;
    setBackgroundColor(-1052684);
    e();
  }
  
  private void f(int paramInt)
  {
    this.r = 4;
    this.q = paramInt;
    paramInt = this.s;
    this.e.a("query", this.a.ae, 3);
    this.s -= 1;
  }
  
  public final void a(a.a parama)
  {
    if (!parama.a())
    {
      a(parama.b);
      return;
    }
    com.unionpay.mobile.android.utils.h.a("uppay", "sms elements:" + parama.b);
    this.i = false;
    this.b.a(com.unionpay.mobile.android.languages.c.by.U);
    this.e.b("sms", parama.b);
    this.r = 1;
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    this.x = false;
    switch (this.r)
    {
    case 2: 
    case 5: 
    default: 
    case 1: 
    case 6: 
    case 4: 
      do
      {
        return;
        j();
        this.r = 0;
        this.w.a(com.unionpay.mobile.android.global.b.p);
        return;
        j();
        int i = com.unionpay.mobile.android.nocard.utils.f.a(this.a, paramJSONObject, false);
        if (i != 0) {
          b(i);
        }
        for (;;)
        {
          this.r = 0;
          return;
          this.a.F = true;
          if ((this.a.u != null) && (this.a.u.length() > 0)) {
            d(6);
          } else if ((this.a.y != null) && (this.a.y.length() > 0)) {
            d(5);
          }
        }
        this.p = g.a(paramJSONObject, "status");
        if ((this.s > 0) && (this.p.equalsIgnoreCase("01")))
        {
          f(this.q);
          return;
        }
        this.r = 0;
        if (this.p.equalsIgnoreCase("00"))
        {
          i = this.q;
          j();
          this.r = 0;
          this.a.C = g.c(paramJSONObject, "result");
          this.a.K = g.a(paramJSONObject, "openupgrade_flag");
          this.a.L = g.a(paramJSONObject, "temporary_pay_flag");
          this.a.M = g.a(paramJSONObject, "temporary_pay_info");
          this.a.Q = g.a(paramJSONObject, "front_url");
          this.a.R = g.a(paramJSONObject, "front_request");
          this.a.v = g.a(paramJSONObject, "title");
          this.a.w = g.a(paramJSONObject, "succ_info");
          com.unionpay.mobile.android.nocard.utils.b.b(paramJSONObject, this.a);
          com.unionpay.mobile.android.nocard.utils.b.a(paramJSONObject, this.a);
          if (this.w != null) {
            this.w.f();
          }
          d(8);
          return;
        }
        if (this.p.equalsIgnoreCase("03"))
        {
          paramJSONObject = g.a(paramJSONObject, "fail_msg");
          if (this.r == 3)
          {
            a(paramJSONObject);
            return;
          }
          i locali = new i(this);
          j localj = new j(this);
          if (this.a.A)
          {
            this.b.a(locali, localj);
            this.b.a(com.unionpay.mobile.android.languages.c.by.Y, paramJSONObject, com.unionpay.mobile.android.languages.c.by.W, com.unionpay.mobile.android.languages.c.by.X);
            return;
          }
          this.b.a(locali, null);
          this.b.a(com.unionpay.mobile.android.languages.c.by.Y, paramJSONObject, com.unionpay.mobile.android.languages.c.by.W);
          return;
        }
      } while (this.s > 0);
      if (this.q == 3)
      {
        a(this.a.af, true);
        return;
      }
      a(this.a.af);
      return;
    }
    this.a.ae = com.unionpay.mobile.android.utils.f.a(paramJSONObject.toString());
    if ((this.a.ae == null) || (this.a.ae.length() <= 0))
    {
      b(2);
      return;
    }
    this.s = 20;
    f(this.r);
  }
  
  public final void a(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.v != null)
    {
      localTextView = this.v;
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
    this.x = false;
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
  
  protected final void c()
  {
    boolean bool = false;
    Object localObject2 = new LinearLayout(this.d);
    ((LinearLayout)localObject2).setId(localObject2.hashCode());
    ((LinearLayout)localObject2).setOrientation(1);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    this.l.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    this.w = new com.unionpay.mobile.android.upviews.a(this.d, this.a.u, this.e.b(), this, this.a.al, false);
    localObject1 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject1).topMargin = com.unionpay.mobile.android.global.a.f;
    ((LinearLayout)localObject2).addView(this.w, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new LinearLayout(this.d);
    ((LinearLayout)localObject1).setOrientation(1);
    ((LinearLayout)localObject1).setId(localObject1.hashCode());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(3, ((LinearLayout)localObject2).getId());
    localLayoutParams.leftMargin = com.unionpay.mobile.android.global.a.f;
    localLayoutParams.topMargin = localLayoutParams.leftMargin;
    this.l.addView((View)localObject1, localLayoutParams);
    if ((i()) || (this.a.ag != null) || (this.a.ah != null))
    {
      if (this.a.ag != null)
      {
        this.u = new com.unionpay.mobile.android.upwidget.a(this.d, this.a.ag, this.A);
        ((LinearLayout)localObject1).addView(this.u);
      }
      if (this.a.ah != null)
      {
        this.t = new com.unionpay.mobile.android.upwidget.a(this.d, this.a.ah, null);
        localObject2 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject2).topMargin = com.unionpay.mobile.android.global.a.f;
        ((LinearLayout)localObject1).addView(this.t, (ViewGroup.LayoutParams)localObject2);
      }
    }
    this.v = new TextView(this.d);
    this.v.setText(g.a(this.a.x, "label"));
    this.v.setTextSize(com.unionpay.mobile.android.global.b.i);
    this.v.setTextColor(p());
    this.v.setGravity(17);
    localObject2 = this.v;
    if ((this.w == null) || (this.w.e())) {
      bool = true;
    }
    ((TextView)localObject2).setEnabled(bool);
    int i = com.unionpay.mobile.android.global.a.n;
    localObject2 = this.c.a(2008);
    this.v.setBackgroundDrawable((Drawable)localObject2);
    this.v.setOnClickListener(this.z);
    localObject2 = new RelativeLayout.LayoutParams(-1, i);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((LinearLayout)localObject1).getId());
    ((RelativeLayout.LayoutParams)localObject2).topMargin = com.unionpay.mobile.android.global.a.f;
    i = com.unionpay.mobile.android.utils.d.a(this.d, 10.0F);
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = i;
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = i;
    this.l.addView(this.v, (ViewGroup.LayoutParams)localObject2);
  }
  
  public final void c(String paramString)
  {
    this.i = false;
    this.b.a(com.unionpay.mobile.android.languages.c.by.U);
    String str = "\"card\":\"" + ((com.unionpay.mobile.android.model.c)this.a.l.get(this.a.I)).a() + "\"";
    com.unionpay.mobile.android.utils.h.a("uppay", "cmd:" + paramString + ", ele:" + str);
    this.e.b(paramString, str);
    this.r = 6;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.obj != null)
    {
      Object localObject = (Bundle)paramMessage.obj;
      paramMessage = ((Bundle)localObject).getString("action_resp_code");
      localObject = ((Bundle)localObject).getString("action_resp_message");
      if (!"0000".equalsIgnoreCase(paramMessage)) {
        break label53;
      }
      if (localObject != null) {
        a(0, (String)localObject);
      }
    }
    for (;;)
    {
      return true;
      label53:
      a(this.a.ak, false);
    }
  }
  
  public final void l()
  {
    if (this.w.d()) {
      return;
    }
    if ((this.a.F) && (this.x))
    {
      this.a.F = false;
      n();
      return;
    }
    this.a.F = false;
    a(2);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.w.d();
  }
  
  public com.unionpay.mobile.android.pro.pboc.engine.b r()
  {
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\mobile\android\pro\views\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */