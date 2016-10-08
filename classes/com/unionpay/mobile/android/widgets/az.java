package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.utils.d;
import com.unionpay.mobile.android.utils.g;
import org.json.JSONObject;

abstract class az
  extends LinearLayout
{
  private String a = null;
  private String b = null;
  protected Context c = null;
  protected int d = -16777216;
  protected int e = -7829368;
  protected String f = null;
  protected String g = null;
  protected boolean h = false;
  protected String i = null;
  protected LinearLayout j = null;
  protected TextView k = null;
  protected RelativeLayout l = null;
  protected JSONObject m;
  private String n = null;
  private String o = null;
  private TextView p = null;
  private ImageView q = null;
  private boolean r = false;
  
  public az(Context paramContext, JSONObject paramJSONObject)
  {
    super(paramContext);
    this.m = paramJSONObject;
    this.c = paramContext;
    this.g = g.a(paramJSONObject, "label");
    this.o = g.a(paramJSONObject, "placeholder");
    this.n = g.a(paramJSONObject, "tip");
    this.a = g.a(paramJSONObject, "name");
    this.f = g.a(paramJSONObject, "value");
    this.b = g.a(paramJSONObject, "type");
    this.i = g.a(paramJSONObject, "regexp");
    paramContext = g.a(paramJSONObject, "readonly");
    if ((paramContext != null) && (paramContext.equalsIgnoreCase("true"))) {
      this.h = true;
    }
    boolean bool;
    if (g.a(paramJSONObject, "margin").length() > 0)
    {
      bool = true;
      this.r = bool;
      paramContext = this.c;
      setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      setBackgroundColor(0);
      setOrientation(1);
      setPadding(2, 2, 2, 2);
      if (this.b.equalsIgnoreCase("string")) {
        break label614;
      }
      if (!a(this, this.g))
      {
        this.p = new TextView(this.c);
        this.p.setTextSize(20.0F);
        this.p.setText("");
        this.p.setTextColor(this.d);
        paramContext = new LinearLayout.LayoutParams(-1, -2);
        paramContext.leftMargin = a.f;
        addView(this.p, paramContext);
        if ((this.g != null) && (this.g.length() != 0)) {
          break label571;
        }
        this.p.setVisibility(8);
      }
    }
    for (;;)
    {
      a();
      if (!b_())
      {
        this.j = new LinearLayout(this.c);
        this.j.setBackgroundColor(-267336);
        paramContext = new LinearLayout.LayoutParams(-1, -2);
        addView(this.j, paramContext);
        this.k = new TextView(this.c);
        this.k.setTextSize(15.0F);
        this.k.setTextColor(this.e);
        paramContext = new LinearLayout.LayoutParams(-1, -2);
        int i1 = d.a(this.c, 10.0F);
        paramContext.rightMargin = i1;
        paramContext.leftMargin = i1;
        i1 = d.a(this.c, 5.0F);
        paramContext.bottomMargin = i1;
        paramContext.topMargin = i1;
        this.j.addView(this.k, paramContext);
        if ((this.n != null) && (this.n.length() > 0)) {
          break label594;
        }
        this.j.setVisibility(8);
        this.q.setVisibility(8);
      }
      return;
      bool = false;
      break;
      label571:
      this.p.setText(this.g);
      this.p.setVisibility(8);
    }
    label594:
    this.q.setVisibility(0);
    this.k.setText(this.n);
    return;
    label614:
    a();
  }
  
  private void a()
  {
    FrameLayout localFrameLayout = new FrameLayout(this.c);
    addView(localFrameLayout, new LinearLayout.LayoutParams(-1, -2));
    this.l = new RelativeLayout(this.c);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localFrameLayout.addView(this.l, localLayoutParams);
    this.q = new ImageView(this.c);
    this.q.setBackgroundDrawable(c.a(this.c).a(1038));
    localLayoutParams = new FrameLayout.LayoutParams(d.a(this.c, 10.0F), d.a(this.c, 5.0F));
    localLayoutParams.gravity = 80;
    localLayoutParams.leftMargin = d.a(this.c, 20.0F);
    this.q.setVisibility(8);
    localFrameLayout.addView(this.q, localLayoutParams);
  }
  
  protected final void a(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if ((this.p != null) && (paramCharSequence != null) && (paramCharSequence.length() > 0)) {
      this.p.setText(paramCharSequence, paramBufferType);
    }
  }
  
  protected boolean a(LinearLayout paramLinearLayout, String paramString)
  {
    return false;
  }
  
  public boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  protected boolean b_()
  {
    return false;
  }
  
  protected final void c(String paramString)
  {
    if ((this.k != null) && (paramString != null) && (paramString.length() > 0)) {
      this.k.setText(paramString);
    }
  }
  
  public boolean e()
  {
    return true;
  }
  
  public String h()
  {
    return this.f;
  }
  
  public final String m()
  {
    return this.a;
  }
  
  public final String n()
  {
    return this.b;
  }
  
  public final String o()
  {
    return this.g;
  }
  
  public final String p()
  {
    return this.n;
  }
  
  public final String q()
  {
    return this.o;
  }
  
  protected final void r()
  {
    if (this.p != null) {
      this.p.setVisibility(0);
    }
  }
  
  protected final void s()
  {
    if (this.k != null)
    {
      this.k.setVisibility(0);
      this.q.setVisibility(0);
    }
  }
  
  protected final void t()
  {
    if (this.p != null) {
      this.p.setTextSize(16.0F);
    }
  }
  
  public static abstract interface a
  {
    public abstract String a();
    
    public abstract boolean b();
    
    public abstract boolean c();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\mobile\android\widgets\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */