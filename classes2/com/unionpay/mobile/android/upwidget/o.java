package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.utils.d;
import com.unionpay.mobile.android.utils.e;
import com.unionpay.mobile.android.utils.g;
import org.json.JSONObject;

public final class o
  extends RelativeLayout
{
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  private String j = "";
  private RelativeLayout k;
  private Button l = null;
  private boolean m = false;
  private Context n = null;
  private float o = 0.0F;
  private View.OnClickListener p = new p(this);
  private View.OnClickListener q = new q(this);
  private String r;
  private TextView s;
  private a t;
  
  public o(Context paramContext, JSONObject paramJSONObject)
  {
    this(paramContext, paramJSONObject, (byte)0);
  }
  
  private o(Context paramContext, JSONObject paramJSONObject, byte paramByte)
  {
    super(paramContext);
    this.n = paramContext;
    this.o = 16.0F;
    this.a = g.a(paramJSONObject, "name");
    this.b = g.a(paramJSONObject, "type");
    this.c = g.a(paramJSONObject, "value");
    this.d = g.a(paramJSONObject, "label");
    this.e = g.a(paramJSONObject, "href_label");
    this.f = g.a(paramJSONObject, "href_url");
    this.g = g.a(paramJSONObject, "href_title");
    this.h = g.a(paramJSONObject, "checked");
    this.i = g.a(paramJSONObject, "required");
    this.j = g.a(paramJSONObject, "error_info");
    this.r = g.a(paramJSONObject, "ckb_style");
    this.k = new RelativeLayout(this.n);
    paramContext = new RelativeLayout.LayoutParams(-1, a.n);
    addView(this.k, paramContext);
    this.l = new Button(this.n);
    this.l.setId(this.l.hashCode());
    if ((a(this.h)) && (this.h.equalsIgnoreCase("0"))) {}
    for (this.m = true;; this.m = false)
    {
      this.l.setOnClickListener(this.p);
      c();
      paramContext = new RelativeLayout.LayoutParams(d.a(this.n, 60.0F), d.a(this.n, 34.0F));
      paramContext.addRule(11, -1);
      paramContext.addRule(15, -1);
      this.k.addView(this.l, paramContext);
      if (this.t != null) {
        this.t.a(this.b, this.m);
      }
      if ((a(this.e)) && (a(this.f)))
      {
        paramContext = new TextView(this.n);
        paramContext.setText(Html.fromHtml(this.e));
        paramContext.setTextSize(this.o);
        paramContext.setOnClickListener(this.q);
        paramContext.setTextColor(e.a(-10705958, -5846275, -5846275, -6710887));
        paramJSONObject = new RelativeLayout.LayoutParams(-2, -2);
        paramJSONObject.addRule(0, this.l.getId());
        paramJSONObject.addRule(15, -1);
        paramJSONObject.rightMargin = d.a(this.n, 10.0F);
        this.k.addView(paramContext, paramJSONObject);
      }
      if (a(this.d))
      {
        this.s = new TextView(this.n);
        this.s.setText(this.d);
        this.s.setTextSize(this.o);
        this.s.setTextColor(-16777216);
        paramContext = new RelativeLayout.LayoutParams(-2, -2);
        paramContext.addRule(9, -1);
        paramContext.addRule(15, -1);
        this.k.addView(this.s, paramContext);
      }
      return;
    }
  }
  
  private static boolean a(String paramString)
  {
    return (paramString != null) && (paramString.length() > 0);
  }
  
  private void c()
  {
    if (this.l == null) {
      return;
    }
    if (this.m) {}
    for (int i1 = 1010;; i1 = 1009)
    {
      Drawable localDrawable = c.a(this.n).a(i1, d.a(this.n, 60.0F), d.a(this.n, 34.0F));
      this.l.setBackgroundDrawable(localDrawable);
      return;
    }
  }
  
  public final void a()
  {
    if (this.s != null) {
      this.s.setTextColor(-13421773);
    }
  }
  
  public final void a(float paramFloat)
  {
    if (this.s != null) {
      this.s.setTextSize(paramFloat);
    }
  }
  
  public final void a(a parama)
  {
    this.t = parama;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
    c();
  }
  
  public final boolean b()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (a(this.i))
    {
      bool1 = bool2;
      if (this.i.equalsIgnoreCase("0")) {
        bool1 = this.m;
      }
    }
    return bool1;
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2);
    
    public abstract void a(String paramString, boolean paramBoolean);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\upwidget\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */