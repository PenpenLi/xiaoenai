package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.upviews.a.a;
import com.unionpay.mobile.android.upviews.a.b;
import com.unionpay.mobile.android.upwidget.UPScrollView;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.widgets.m;
import com.unionpay.mobile.android.widgets.y;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class as
  extends b
  implements a.b
{
  private boolean A = false;
  private String B;
  private View.OnClickListener C = new at(this);
  private View.OnClickListener D = new au(this);
  private View.OnClickListener E = new av(this);
  private View.OnClickListener F = new aw(this);
  private View.OnClickListener G = new ax(this);
  private String p = "00";
  private int q = 0;
  private int r = 0;
  private int s = 20;
  private int t = 5;
  private com.unionpay.mobile.android.upwidget.a u = null;
  private com.unionpay.mobile.android.upwidget.a v = null;
  private TextView w = null;
  private com.unionpay.mobile.android.upviews.a x = null;
  private com.unionpay.mobile.android.upviews.a y = null;
  private boolean z = false;
  
  public as(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public as(Context paramContext, com.unionpay.mobile.android.model.d paramd)
  {
    super(paramContext, paramd);
    this.f = 6;
    if (!this.a.F) {
      bool = true;
    }
    this.A = bool;
    setBackgroundColor(-1052684);
    e();
  }
  
  private void c(String paramString1, String paramString2)
  {
    this.r = 9;
    if (TextUtils.isEmpty(paramString2)) {
      this.e.b(paramString1, "");
    }
    for (;;)
    {
      this.t -= 1;
      return;
      paramString2 = "\"uuid\":\"" + paramString2 + "\"";
      this.e.a(paramString1, paramString2, 10);
    }
  }
  
  private void d(String paramString)
  {
    a(paramString, new ay(this), new az(this));
  }
  
  private void e(String paramString)
  {
    this.i = false;
    this.r = 3;
    String str2 = bg.a(this.a.x);
    if (this.u != null) {}
    for (String str1 = this.u.a();; str1 = null)
    {
      paramString = bg.c("1", "1", str1, paramString);
      this.e.b(str2, paramString);
      return;
    }
  }
  
  private static boolean e(JSONObject paramJSONObject)
  {
    return "0".equalsIgnoreCase(g.a(paramJSONObject, "reopen_flag"));
  }
  
  private void f(int paramInt)
  {
    this.r = 4;
    this.q = paramInt;
    paramInt = this.s;
    this.e.a("query", this.a.ae, 3);
    this.s -= 1;
  }
  
  private String r()
  {
    Object localObject2 = "";
    Object localObject1 = localObject2;
    Object localObject3;
    if (this.y != null)
    {
      localObject3 = this.y.b();
      localObject1 = localObject2;
      if (((a.a)localObject3).a()) {
        localObject1 = "" + ((a.a)localObject3).b;
      }
    }
    localObject2 = localObject1;
    if (this.x != null)
    {
      localObject3 = this.x.b();
      localObject2 = localObject1;
      if (((a.a)localObject3).a())
      {
        localObject3 = ((a.a)localObject3).b;
        localObject2 = localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject2 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = (String)localObject1 + ",";
          }
          localObject2 = (String)localObject2 + (String)localObject3;
        }
      }
    }
    return (String)localObject2;
  }
  
  public final void a(a.a parama)
  {
    if (!parama.a())
    {
      a(parama.b);
      return;
    }
    h.a("uppay", "sms elements:" + parama.b);
    this.i = false;
    this.b.a(com.unionpay.mobile.android.languages.c.by.U);
    this.e.b("sms", parama.b);
    this.r = 1;
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    this.A = false;
    switch (this.r)
    {
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              j();
              this.r = 0;
              this.y.a(com.unionpay.mobile.android.global.b.p);
              return;
              j();
              i = com.unionpay.mobile.android.nocard.utils.f.a(this.a, paramJSONObject, true);
              if (i != 0) {
                b(i);
              }
              for (;;)
              {
                this.r = 0;
                return;
                this.a.F = true;
                paramJSONObject = com.unionpay.mobile.android.nocard.utils.f.a(paramJSONObject);
                if ((this.a.u != null) && (this.a.u.length() > 0)) {
                  a(6, paramJSONObject);
                } else if ((this.a.y != null) && (this.a.y.length() > 0)) {
                  d(5);
                }
              }
              this.p = g.a(paramJSONObject, "status");
              if (e(paramJSONObject))
              {
                d(g.a(paramJSONObject, "fail_msg"));
                return;
              }
              if ((this.s > 0) && (this.p.equalsIgnoreCase("01")))
              {
                f(this.q);
                return;
              }
              this.r = 0;
              if (this.p.equalsIgnoreCase("00"))
              {
                switch (this.q)
                {
                default: 
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
                  if (this.y != null) {
                    this.y.f();
                  }
                  d(8);
                  return;
                }
                this.z = true;
                e(r());
                return;
              }
              if (this.p.equalsIgnoreCase("03"))
              {
                paramJSONObject = g.a(paramJSONObject, "fail_msg");
                if (this.q == 3)
                {
                  a(paramJSONObject);
                  return;
                }
                localObject = new ba(this);
                bb localbb = new bb(this);
                if (this.a.A)
                {
                  this.b.a((View.OnClickListener)localObject, localbb);
                  this.b.a(com.unionpay.mobile.android.languages.c.by.ab, paramJSONObject, com.unionpay.mobile.android.languages.c.by.ac, com.unionpay.mobile.android.languages.c.by.ad);
                  return;
                }
                this.b.a((View.OnClickListener)localObject, null);
                this.b.a(com.unionpay.mobile.android.languages.c.by.ab, paramJSONObject, com.unionpay.mobile.android.languages.c.by.ac);
                return;
              }
            } while (this.s > 0);
            localObject = c(19);
            paramJSONObject = (JSONObject)localObject;
            if (this.a.af != null)
            {
              paramJSONObject = (JSONObject)localObject;
              if (!TextUtils.isEmpty(this.a.af)) {
                paramJSONObject = this.a.af;
              }
            }
            if (this.q == 3)
            {
              a(paramJSONObject, true);
              return;
            }
            a(paramJSONObject);
            return;
            this.a.ae = com.unionpay.mobile.android.utils.f.a(paramJSONObject.toString());
            if ((this.a.ae == null) || (this.a.ae.length() <= 0))
            {
              b(2);
              return;
            }
            this.s = 20;
            f(this.r);
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
          return;
          j();
          paramJSONObject = g.c(paramJSONObject, "options");
        } while (this.x == null);
        this.x.a(paramJSONObject);
        return;
        localObject = g.a(paramJSONObject, "status");
        if ((localObject == null) || (!"01".equals(localObject))) {
          break;
        }
        paramJSONObject = g.a(paramJSONObject, "uuid");
        if (this.t >= 0)
        {
          c(this.B, paramJSONObject);
          return;
        }
        paramJSONObject = com.unionpay.mobile.android.languages.c.by.D;
      } while (this.x == null);
      this.x.a(null, paramJSONObject);
      return;
      localObject = g.c(paramJSONObject, "options");
      paramJSONObject = g.a(paramJSONObject, "empty_info");
    } while (this.x == null);
    this.x.a((JSONArray)localObject, paramJSONObject);
  }
  
  public final void a(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.w != null)
    {
      localTextView = this.w;
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
    this.A = false;
    if ((this.r == 1) && (e(paramJSONObject)))
    {
      d(paramString);
      return true;
    }
    return false;
  }
  
  protected final void b()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    com.unionpay.mobile.android.widgets.ax localax = new com.unionpay.mobile.android.widgets.ax(getContext(), this.a.v, this);
    localLayoutParams.addRule(13, -1);
    this.j.addView(localax, localLayoutParams);
  }
  
  public final void b(String paramString1, String paramString2)
  {
    a(paramString1, paramString2);
  }
  
  protected final void c()
  {
    this.n.a(this);
    Object localObject2 = new LinearLayout(this.d);
    ((LinearLayout)localObject2).setId(localObject2.hashCode());
    ((LinearLayout)localObject2).setOrientation(1);
    ((LinearLayout)localObject2).setBackgroundColor(0);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    this.l.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new JSONArray();
    if (this.o != null)
    {
      localObject3 = (e)this.o;
      ((JSONArray)localObject1).put(((e)localObject3).a("promotion"));
      ((JSONArray)localObject1).put(((e)localObject3).a("instalment"));
      this.a.aK = ((e)localObject3).a("promotion_instalment_msgbox");
    }
    if (((JSONArray)localObject1).length() > 0)
    {
      this.x = new com.unionpay.mobile.android.upviews.a(this.d, (JSONArray)localObject1, this);
      this.x.a(this.b, this.a.aK);
      this.x.a(this.D);
      this.x.b(this.E);
      this.x.c(this.F);
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).topMargin = com.unionpay.mobile.android.global.a.f;
      ((LinearLayout)localObject2).addView(this.x, (ViewGroup.LayoutParams)localObject1);
    }
    localObject1 = null;
    if (this.x != null) {
      localObject1 = this.x.c("instalment");
    }
    this.y = new com.unionpay.mobile.android.upviews.a(this.d, this.a.u, this.e.b(), this, this.a.al, true, false, (y)localObject1, this.a.Y);
    localObject1 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject1).topMargin = com.unionpay.mobile.android.global.a.f;
    ((LinearLayout)localObject2).addView(this.y, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new LinearLayout(this.d);
    ((LinearLayout)localObject1).setOrientation(1);
    ((LinearLayout)localObject1).setId(localObject1.hashCode());
    Object localObject3 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, ((LinearLayout)localObject2).getId());
    ((RelativeLayout.LayoutParams)localObject3).leftMargin = com.unionpay.mobile.android.global.a.f;
    ((RelativeLayout.LayoutParams)localObject3).topMargin = ((RelativeLayout.LayoutParams)localObject3).leftMargin;
    this.l.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
    if ((i()) || (this.a.ag != null) || (this.a.ah != null))
    {
      if (this.a.ag != null)
      {
        this.v = new com.unionpay.mobile.android.upwidget.a(this.d, this.a.ag, this.G);
        ((LinearLayout)localObject1).addView(this.v);
      }
      if (this.a.ah != null)
      {
        this.u = new com.unionpay.mobile.android.upwidget.a(this.d, this.a.ah, null);
        localObject2 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject2).topMargin = com.unionpay.mobile.android.global.a.f;
        ((LinearLayout)localObject1).addView(this.u, (ViewGroup.LayoutParams)localObject2);
      }
    }
    this.w = new TextView(this.d);
    this.w.setText(g.a(this.a.x, "label"));
    this.w.setTextSize(com.unionpay.mobile.android.global.b.i);
    this.w.setTextColor(p());
    this.w.setGravity(17);
    localObject2 = this.w;
    if ((this.y == null) || (this.y.e())) {}
    for (boolean bool = true;; bool = false)
    {
      ((TextView)localObject2).setEnabled(bool);
      int i = com.unionpay.mobile.android.global.a.n;
      localObject2 = this.c.a(2008);
      this.w.setBackgroundDrawable((Drawable)localObject2);
      this.w.setOnClickListener(this.C);
      localObject2 = new RelativeLayout.LayoutParams(-1, i);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((LinearLayout)localObject1).getId());
      ((RelativeLayout.LayoutParams)localObject2).topMargin = com.unionpay.mobile.android.global.a.f;
      i = com.unionpay.mobile.android.utils.d.a(this.d, 10.0F);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = i;
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = i;
      this.l.addView(this.w, (ViewGroup.LayoutParams)localObject2);
      return;
    }
  }
  
  public final void c(String paramString)
  {
    this.i = false;
    this.b.a(com.unionpay.mobile.android.languages.c.by.U);
    if (i()) {}
    for (String str = "\"card\":\"" + this.a.al + "\"";; str = "\"card\":\"" + ((com.unionpay.mobile.android.model.c)this.a.l.get(this.a.I)).a() + "\"")
    {
      h.a("uppay", "cmd:" + paramString + ", ele:" + str);
      this.e.b(paramString, str);
      this.r = 6;
      return;
    }
  }
  
  public final void l()
  {
    if (this.y.d()) {
      return;
    }
    if (this.a.G)
    {
      a(13);
      this.a.G = false;
      return;
    }
    if ((this.a.F) && (this.A))
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
  
  protected final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.y.d();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\mobile\android\nocard\views\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */