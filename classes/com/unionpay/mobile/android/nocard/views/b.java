package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine.a;
import com.unionpay.mobile.android.plugin.BaseActivity;
import com.unionpay.mobile.android.upwidget.UPScrollView;
import com.unionpay.mobile.android.upwidget.UPScrollView.a;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.views.order.l;
import com.unionpay.mobile.android.widgets.UPWidget;
import com.unionpay.mobile.android.widgets.ac;
import com.unionpay.mobile.android.widgets.ad;
import com.unionpay.mobile.android.widgets.ae;
import com.unionpay.mobile.android.widgets.ag;
import com.unionpay.mobile.android.widgets.an;
import com.unionpay.mobile.android.widgets.ar;
import com.unionpay.mobile.android.widgets.at;
import com.unionpay.mobile.android.widgets.au;
import com.unionpay.mobile.android.widgets.ax.a;
import com.unionpay.mobile.android.widgets.t;
import com.unionpay.mobile.android.widgets.x;
import com.unionpay.mobile.android.widgets.y;
import com.unionpay.mobile.android.widgets.z;
import com.unionpay.mobile.android.widgets.z.a;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b
  extends RelativeLayout
  implements UPPayEngine.a, a, UPScrollView.a, ax.a, z.a
{
  protected com.unionpay.mobile.android.model.b a = null;
  protected com.unionpay.mobile.android.widgets.m b = null;
  protected com.unionpay.mobile.android.resource.c c = null;
  protected Context d = null;
  protected UPPayEngine e = null;
  protected int f = 0;
  protected String g = null;
  protected String h = null;
  protected boolean i = true;
  protected RelativeLayout j = null;
  protected ViewGroup k = null;
  protected RelativeLayout l = null;
  protected ar m = null;
  protected UPScrollView n = null;
  protected com.unionpay.mobile.android.model.d o;
  private LinearLayout p;
  private LinearLayout q;
  private LinearLayout r;
  private int s;
  private int t;
  
  public b(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public b(Context paramContext, com.unionpay.mobile.android.model.d paramd)
  {
    super(paramContext);
    this.d = paramContext;
    this.o = paramd;
    this.e = ((UPPayEngine)((BaseActivity)paramContext).a(UPPayEngine.class.toString()));
    this.a = ((com.unionpay.mobile.android.model.b)((BaseActivity)paramContext).a(null));
    this.b = ((com.unionpay.mobile.android.widgets.m)((BaseActivity)paramContext).a(com.unionpay.mobile.android.widgets.m.class.toString()));
    this.c = com.unionpay.mobile.android.resource.c.a(paramContext);
    setId(8888);
    setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    setBackgroundColor(-1);
    h.b("uppayEx", "UPViewBase:" + toString());
  }
  
  protected static boolean b(String paramString)
  {
    return (paramString != null) && (paramString.length() > 0);
  }
  
  protected static ColorStateList p()
  {
    return com.unionpay.mobile.android.utils.e.a(com.unionpay.mobile.android.global.b.b, com.unionpay.mobile.android.global.b.c, com.unionpay.mobile.android.global.b.c, com.unionpay.mobile.android.global.b.d);
  }
  
  private final RelativeLayout r()
  {
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    if (this.j != null)
    {
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, this.j.getId());
      ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
    }
    Object localObject2 = new FrameLayout(this.d);
    addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new FrameLayout.LayoutParams(-1, -1);
    this.n = new UPScrollView(this.d);
    this.n.setPadding(0, 0, 0, 0);
    ((FrameLayout)localObject2).addView(this.n, (ViewGroup.LayoutParams)localObject1);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    int i1 = com.unionpay.mobile.android.utils.d.a(this.d, 10.0F);
    this.r = new LinearLayout(this.d);
    this.r.setId(this.r.hashCode());
    this.r.setOrientation(1);
    this.r.setBackgroundColor(-267336);
    this.r.setPadding(i1, i1, i1, i1);
    localObject1 = "";
    if (b(this.a.am)) {
      localObject1 = "" + this.a.am;
    }
    if (b((String)localObject1))
    {
      TextView localTextView = new TextView(this.d);
      localTextView.setTextColor(-10066330);
      localTextView.setText((CharSequence)localObject1);
      localTextView.setTextSize(com.unionpay.mobile.android.global.b.k);
      this.r.addView(localTextView);
    }
    for (;;)
    {
      this.r.setVisibility(8);
      ((FrameLayout)localObject2).addView(this.r, localLayoutParams);
      localObject1 = new RelativeLayout(this.d);
      ((RelativeLayout)localObject1).setBackgroundColor(-1052684);
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      this.n.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      return (RelativeLayout)localObject1;
      this.r.setVisibility(8);
    }
  }
  
  protected final RelativeLayout a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setId(localRelativeLayout.hashCode());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(10, -1);
    addView(localRelativeLayout, localLayoutParams);
    return localRelativeLayout;
  }
  
  public final void a(int paramInt)
  {
    ((BaseActivity)this.d).a(paramInt);
  }
  
  protected final void a(int paramInt, com.unionpay.mobile.android.model.d paramd)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.d;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (paramInt)
    {
    default: 
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (localObject1 != null) {
        localBaseActivity.a((b)localObject1);
      }
      return;
      localObject1 = new ao(this.d, paramd);
      continue;
      int i1 = 0;
      paramInt = i1;
      if (this.a.l != null)
      {
        paramInt = i1;
        if (this.a.l.size() > 0) {
          paramInt = ((com.unionpay.mobile.android.model.c)this.a.l.get(this.a.I)).c();
        }
      }
      if ((i()) || (paramInt == 0) || (this.a.aF == l.c.intValue()))
      {
        localObject1 = new as(this.d, paramd);
      }
      else
      {
        localObject1 = localBaseActivity.a(6, paramd);
        continue;
        localObject1 = new bc(this.d);
        continue;
        localObject1 = new g(this.d);
        continue;
        localObject1 = new ak(this.d);
        continue;
        localObject1 = new ai(this.d);
        continue;
        localObject1 = new af(this.d);
        continue;
        localObject1 = new o(this.d, paramd);
        continue;
        localObject1 = new bh(this.d);
        continue;
        localObject1 = localBaseActivity.a(paramInt, paramd);
      }
    }
  }
  
  public final void a(int paramInt, String paramString)
  {
    this.i = true;
    h.a("uppay", " " + toString());
    if (paramInt == 0)
    {
      h.a("uppay", "parserResponseMesage() +++");
      paramInt = 0;
      JSONObject localJSONObject = null;
      Object localObject = null;
      if ((paramString == null) || (paramString.length() == 0))
      {
        h.a("uppay", " ERROR_MSG_FORMAT");
        paramInt = 2;
        paramString = (String)localObject;
        if (paramInt == 0) {
          break label267;
        }
        localObject = this.g;
        if (!a(this.h, paramString)) {
          b(paramInt);
        }
      }
      for (;;)
      {
        h.a("uppay", "parserResponseMesage() ---");
        return;
        localObject = localJSONObject;
        try
        {
          paramString = new JSONObject(paramString);
          localObject = localJSONObject;
          this.g = com.unionpay.mobile.android.utils.g.a(paramString, "resp");
          localObject = localJSONObject;
          this.h = com.unionpay.mobile.android.utils.g.a(paramString, "msg");
          localObject = localJSONObject;
          localJSONObject = com.unionpay.mobile.android.utils.g.b(paramString, "params");
          paramString = localJSONObject;
          localObject = localJSONObject;
          if (this.g.equalsIgnoreCase("00")) {
            break;
          }
          localObject = localJSONObject;
          if (!this.g.equalsIgnoreCase("21")) {
            break label246;
          }
          paramInt = 17;
          localObject = localJSONObject;
          h.a("uppay", " ERROR_ORDER_TIMEOUT");
          paramString = localJSONObject;
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
          h.a("uppay", " ERROR_MSG_FORMAT");
          paramInt = 2;
          paramString = (String)localObject;
        }
        break;
        label246:
        paramInt = 3;
        localObject = localJSONObject;
        h.a("uppay", " ERROR_TRANSACTION");
        paramString = localJSONObject;
        break;
        label267:
        a(paramString);
      }
    }
    b(paramInt);
  }
  
  public final void a(t paramt, String paramString) {}
  
  protected final void a(String paramString)
  {
    a(paramString, false);
  }
  
  protected final void a(String paramString, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    this.b.a(paramOnClickListener1, paramOnClickListener2);
    this.b.a(com.unionpay.mobile.android.languages.c.by.Y, paramString, com.unionpay.mobile.android.languages.c.by.W, com.unionpay.mobile.android.languages.c.by.X, false);
  }
  
  protected final void a(String paramString1, String paramString2)
  {
    ((InputMethodManager)this.d.getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    this.a.ab = paramString2;
    this.a.aa = paramString1;
    d(14);
  }
  
  protected final void a(String paramString, boolean paramBoolean)
  {
    d locald = new d(this, paramBoolean);
    h.a("uppay", " showErrDialog(msg, boolean)  ");
    this.b.a(locald, null);
    this.b.a(com.unionpay.mobile.android.languages.c.by.Y, paramString, com.unionpay.mobile.android.languages.c.by.W);
  }
  
  protected boolean a(String paramString, JSONObject paramJSONObject)
  {
    return false;
  }
  
  protected final y b(JSONObject paramJSONObject)
  {
    Object localObject = null;
    String str = com.unionpay.mobile.android.utils.g.a(paramJSONObject, "type");
    int i1 = com.unionpay.mobile.android.global.a.I - com.unionpay.mobile.android.global.a.f * 4;
    if ("pan".equalsIgnoreCase(str)) {
      localObject = new ae(this.d, i1, paramJSONObject);
    }
    for (;;)
    {
      if ((localObject != null) && ((localObject instanceof z))) {
        ((z)localObject).a(this);
      }
      return (y)localObject;
      if ("mobile".equalsIgnoreCase(str)) {
        localObject = new ag(this.d, i1, paramJSONObject);
      } else if ("sms".equalsIgnoreCase(str)) {
        localObject = new com.unionpay.mobile.android.widgets.ao(this.d, i1, paramJSONObject);
      } else if ("cvn2".equalsIgnoreCase(str)) {
        localObject = new com.unionpay.mobile.android.widgets.e(this.d, i1, paramJSONObject);
      } else if ("expire".equalsIgnoreCase(str)) {
        localObject = new au(this.d, i1, paramJSONObject);
      } else if ("pwd".equalsIgnoreCase(str)) {
        localObject = new UPWidget(this.d, this.e.b(), i1, paramJSONObject);
      } else if ("text".equalsIgnoreCase(str)) {
        localObject = new com.unionpay.mobile.android.widgets.as(this.d, i1, paramJSONObject);
      } else if ("string".equalsIgnoreCase(str)) {
        localObject = new ac(this.d, paramJSONObject);
      } else if ("cert_id".equalsIgnoreCase(str)) {
        localObject = new com.unionpay.mobile.android.widgets.f(this.d, i1, paramJSONObject);
      } else if ("cert_type".equalsIgnoreCase(str)) {
        localObject = new com.unionpay.mobile.android.widgets.g(this.d, paramJSONObject);
      } else if ("name".equalsIgnoreCase(str)) {
        localObject = new ad(this.d, i1, paramJSONObject);
      } else if ("hidden".equalsIgnoreCase(str)) {
        localObject = new x(this.d, paramJSONObject);
      } else if ("user_name".equalsIgnoreCase(str)) {
        localObject = new at(this.d, i1, paramJSONObject);
      } else if ("password".equalsIgnoreCase(str)) {
        localObject = new an(this.d, i1, paramJSONObject);
      }
    }
  }
  
  protected void b() {}
  
  public void b(int paramInt)
  {
    if ((paramInt == 8) || (paramInt == 17) || (paramInt == 19))
    {
      this.a.D.f = "fail";
      h.a("uppay", "showErrDialog 1");
      a(c(paramInt), true);
      return;
    }
    h.a("uppay", "showErrDialog 2");
    a(c(paramInt), false);
  }
  
  protected void b(String paramString, JSONObject paramJSONObject) {}
  
  protected final String c(int paramInt)
  {
    switch (paramInt)
    {
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    default: 
      return com.unionpay.mobile.android.languages.c.by.aA;
    case 2: 
      return com.unionpay.mobile.android.languages.c.by.aB;
    case 7: 
      return com.unionpay.mobile.android.languages.c.by.aG;
    case 5: 
      return com.unionpay.mobile.android.languages.c.by.aH;
    case 6: 
      return com.unionpay.mobile.android.languages.c.by.aI;
    case 4: 
      return com.unionpay.mobile.android.languages.c.by.az;
    case 8: 
      return com.unionpay.mobile.android.languages.c.by.aJ;
    case 9: 
      return com.unionpay.mobile.android.languages.c.by.aK;
    case 21: 
      return com.unionpay.mobile.android.languages.c.by.aL;
    case 16: 
      return com.unionpay.mobile.android.languages.c.by.aM;
    case 19: 
      return com.unionpay.mobile.android.languages.c.by.aN;
    case 20: 
      return com.unionpay.mobile.android.languages.c.by.aO;
    case 18: 
      return com.unionpay.mobile.android.languages.c.by.aP;
    }
    return this.h;
  }
  
  protected void c() {}
  
  protected final boolean c(JSONObject paramJSONObject)
  {
    boolean bool = false;
    if (com.unionpay.mobile.android.nocard.utils.f.c(this.a, paramJSONObject))
    {
      d(paramJSONObject);
      bool = true;
    }
    return bool;
  }
  
  protected void d()
  {
    this.l = r();
  }
  
  protected final void d(int paramInt)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.d;
    Object localObject;
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 7: 
    case 9: 
    default: 
      localObject = null;
    }
    for (;;)
    {
      if (localObject != null) {
        localBaseActivity.a((b)localObject);
      }
      return;
      localObject = new ao(this.d, null);
      continue;
      int i1 = 0;
      paramInt = i1;
      if (this.a.l != null)
      {
        paramInt = i1;
        if (this.a.l.size() > 0) {
          paramInt = ((com.unionpay.mobile.android.model.c)this.a.l.get(this.a.I)).c();
        }
      }
      if ((i()) || (paramInt == 0))
      {
        localObject = new as(this.d);
      }
      else
      {
        localObject = localBaseActivity.a(6, null);
        continue;
        localObject = new bc(this.d);
        continue;
        localObject = new g(this.d);
        continue;
        localObject = new ak(this.d);
        continue;
        localObject = new ai(this.d);
        continue;
        localObject = new af(this.d);
        continue;
        localObject = new o(this.d, null);
        continue;
        localObject = new bh(this.d);
        continue;
        localObject = localBaseActivity.a(paramInt, null);
        continue;
        localObject = localBaseActivity.a(paramInt, null);
      }
    }
  }
  
  protected final void d(JSONObject paramJSONObject)
  {
    e locale = new e(this, paramJSONObject);
    paramJSONObject = new f(this, paramJSONObject);
    this.b.a(locale, paramJSONObject);
    this.b.a(this.a.aw, this.a.ax, this.a.ay, this.a.aA);
  }
  
  protected final void e()
  {
    this.j = a();
    b();
    RelativeLayout localRelativeLayout = r();
    Object localObject1 = new LinearLayout(this.d);
    ((LinearLayout)localObject1).setOrientation(1);
    ((LinearLayout)localObject1).setId(localObject1.hashCode());
    ((LinearLayout)localObject1).setBackgroundColor(-1114114);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.k = ((ViewGroup)localObject1);
    this.k.setBackgroundColor(0);
    f();
    int i1 = this.k.getId();
    localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.unionpay.mobile.android.global.a.b;
    ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, i1);
    localObject2 = new RelativeLayout(this.d);
    localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    this.l = ((RelativeLayout)localObject2);
    c();
  }
  
  public final void e(int paramInt)
  {
    if (paramInt >= this.t) {
      if ((this.r.getVisibility() != 0) && (this.r != null) && (this.p.getVisibility() == 0)) {
        this.r.setVisibility(0);
      }
    }
    while ((paramInt > this.t + this.s) || (this.r.getVisibility() != 0) || (this.r == null)) {
      return;
    }
    this.r.setVisibility(8);
  }
  
  protected void f()
  {
    this.q = new LinearLayout(this.d);
    this.q.setOrientation(1);
    this.q.setBackgroundColor(-267336);
    int i1 = com.unionpay.mobile.android.utils.d.a(this.d, 10.0F);
    Object localObject1;
    Object localObject2;
    if (b(this.a.am))
    {
      this.q.setPadding(i1, i1, i1, 0);
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
      this.k.addView(this.q, (ViewGroup.LayoutParams)localObject1);
      localObject1 = "";
      if (b(this.a.ao)) {
        localObject1 = "" + this.a.ao;
      }
      if (!b((String)localObject1)) {
        break label516;
      }
      localObject2 = new TextView(this.d);
      ((TextView)localObject2).setTextColor(-10066330);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setTextSize(com.unionpay.mobile.android.global.b.k);
      this.q.addView((View)localObject2);
      label181:
      this.p = new LinearLayout(this.d);
      this.p.setOrientation(1);
      this.p.setBackgroundColor(-267336);
      this.p.setPadding(i1, i1, i1, i1);
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
      this.k.addView(this.p, (ViewGroup.LayoutParams)localObject1);
      localObject1 = "";
      if (b(this.a.am)) {
        localObject1 = "" + this.a.am;
      }
      if (!b((String)localObject1)) {
        break label528;
      }
      localObject2 = new TextView(this.d);
      ((TextView)localObject2).setTextColor(-10066330);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setTextSize(com.unionpay.mobile.android.global.b.k);
      this.p.addView((View)localObject2);
      label339:
      this.p.getViewTreeObserver().addOnPreDrawListener(new c(this));
      localObject1 = new com.unionpay.mobile.android.views.order.m(this.d);
      ((com.unionpay.mobile.android.views.order.m)localObject1).a(this.c.a(1003), this.c.a(1001));
      if (!(this instanceof ao)) {
        break label540;
      }
    }
    label516:
    label528:
    label540:
    for (boolean bool = false;; bool = true)
    {
      ((com.unionpay.mobile.android.views.order.m)localObject1).a(bool, this.a.e, this.a.f);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      this.k.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localObject2 = this.c.a(1026);
      localObject1 = new LinearLayout(this.d);
      if (localObject2 != null) {
        ((LinearLayout)localObject1).setBackgroundDrawable((Drawable)localObject2);
      }
      localObject2 = new LinearLayout.LayoutParams(-1, com.unionpay.mobile.android.utils.d.a(this.d, 2.0F));
      this.k.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      return;
      this.q.setPadding(i1, i1, i1, i1);
      break;
      this.q.setVisibility(8);
      break label181;
      this.p.setVisibility(8);
      break label339;
    }
  }
  
  protected final void g()
  {
    RelativeLayout localRelativeLayout = this.l;
  }
  
  public final int h()
  {
    return this.f;
  }
  
  protected final boolean i()
  {
    return (this.a.E) || (this.a.l == null) || (this.a.l.size() == 0);
  }
  
  protected final void j()
  {
    if ((this.b != null) && (this.b.a())) {
      this.b.c();
    }
  }
  
  public final void k()
  {
    com.unionpay.mobile.android.nocard.utils.d.a(this.d, this.a);
  }
  
  public void l()
  {
    if (this.i) {
      n();
    }
  }
  
  public final void m()
  {
    l();
  }
  
  public final void n()
  {
    ((BaseActivity)this.d).a();
  }
  
  protected final boolean o()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.b != null)
    {
      bool1 = bool2;
      if (this.b.a()) {
        bool1 = true;
      }
    }
    h.a("uppay", " dialog showing:" + bool1);
    return bool1;
  }
  
  protected void onAttachedToWindow()
  {
    h.b("uppayEx", toString() + " onAttachedToWindow()");
    super.onAttachedToWindow();
    this.e.a(this);
  }
  
  protected final boolean q()
  {
    return !this.a.c;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\mobile\android\nocard\views\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */