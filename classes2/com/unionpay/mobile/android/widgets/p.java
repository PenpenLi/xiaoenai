package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.upwidget.e;
import com.unionpay.mobile.android.upwidget.o;
import com.unionpay.mobile.android.upwidget.o.a;
import com.unionpay.mobile.android.utils.d;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class p
  extends y
{
  private final View.OnClickListener a = new q(this);
  private final AdapterView.OnItemClickListener b = new r(this);
  private JSONArray n = g.c(this.m, "options");
  private List<Map<String, Object>> o;
  private PopupWindow p;
  private com.unionpay.mobile.android.upwidget.c q;
  private e r;
  private int s = 1;
  private TextView t;
  private o u;
  private TextView v;
  private String w;
  private RelativeLayout x;
  
  public p(Context paramContext, JSONObject paramJSONObject)
  {
    super(paramContext, paramJSONObject);
    this.w = g.a(paramJSONObject, "label");
    if (a(this.w)) {
      this.w = com.unionpay.mobile.android.languages.c.by.bg;
    }
    Object localObject2 = this.n;
    Object localObject1 = null;
    paramJSONObject = (JSONObject)localObject1;
    if (localObject2 != null)
    {
      paramJSONObject = (JSONObject)localObject1;
      if (((JSONArray)localObject2).length() > 0)
      {
        paramJSONObject = new ArrayList(((JSONArray)localObject2).length());
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localObject1 = new HashMap();
          ((Map)localObject1).put("text1", a(i, "label"));
          ((Map)localObject1).put("text2", "");
          ((Map)localObject1).put("editable", Boolean.FALSE);
          paramJSONObject.add(localObject1);
          i += 1;
        }
      }
    }
    this.o = paramJSONObject;
    this.q = new com.unionpay.mobile.android.upwidget.c(paramContext, this.o, this.w, "", "", this.s, 0);
    this.r = new e(this.c, this.q);
    this.r.a(this.b);
    this.r.a(this.a);
    paramContext = this.l;
    localObject2 = com.unionpay.mobile.android.resource.c.a(this.c).a(2014);
    localObject1 = new LinearLayout(this.c);
    ((LinearLayout)localObject1).setId(localObject1.hashCode());
    ((LinearLayout)localObject1).setBackgroundColor(-3419943);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
    paramJSONObject = g.a(this.m, "type");
    if ("instalment".equals(paramJSONObject)) {
      localLayoutParams.leftMargin = d.a(this.c, 10.0F);
    }
    paramContext.addView((View)localObject1, localLayoutParams);
    this.x = new RelativeLayout(this.c);
    this.x.setId(this.x.hashCode());
    this.x.setBackgroundDrawable((Drawable)localObject2);
    this.x.setOnClickListener(new s(this));
    localObject2 = new RelativeLayout.LayoutParams(-1, com.unionpay.mobile.android.global.a.n);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((LinearLayout)localObject1).getId());
    paramContext.addView(this.x, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new ImageView(this.c);
    ((ImageView)localObject1).setId(localObject1.hashCode());
    ((ImageView)localObject1).setBackgroundDrawable(com.unionpay.mobile.android.resource.c.a(this.c).a(1002));
    int i = d.a(this.c, 15.0F);
    localObject2 = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = d.a(this.c, 10.0F);
    this.x.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.t = new TextView(this.c);
    this.t.setTextSize(b.k);
    this.t.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    this.t.setSingleLine(true);
    this.t.setTextColor(-10066330);
    localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(9, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(0, ((ImageView)localObject1).getId());
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = d.a(this.c, 10.0F);
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((RelativeLayout.LayoutParams)localObject2).leftMargin;
    this.x.addView(this.t, (ViewGroup.LayoutParams)localObject2);
    if (!"instalment".equals(paramJSONObject))
    {
      paramJSONObject = new LinearLayout(this.c);
      paramJSONObject.setBackgroundColor(-3419943);
      localObject1 = new RelativeLayout.LayoutParams(-1, 1);
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.unionpay.mobile.android.global.a.f;
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, this.x.getId());
      paramContext.addView(paramJSONObject, (ViewGroup.LayoutParams)localObject1);
    }
    a(f());
    a(1);
  }
  
  private String a(int paramInt, String paramString)
  {
    Object localObject = g.b(this.n, paramInt);
    if (localObject != null) {
      return g.a((JSONObject)localObject, paramString);
    }
    return "";
  }
  
  private JSONObject a(String paramString1, String paramString2, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramString1);
      localJSONObject.put("label", paramString2);
      localJSONObject.put("checked", paramString3);
      localJSONObject.put("ckb_style", "small");
      localJSONObject.put("required", "0");
      if ("instalment".equals(paramString1))
      {
        paramString1 = g.b(this.m, "url");
        if (paramString1 != null)
        {
          localJSONObject.put("href_label", g.a(paramString1, "label"));
          localJSONObject.put("href_url", g.a(paramString1, "href"));
        }
      }
      return localJSONObject;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return localJSONObject;
  }
  
  private void a(int paramInt)
  {
    int i = 0;
    this.s = paramInt;
    paramInt -= this.q.c();
    this.q.a(this.s);
    if (this.t != null) {
      this.t.setText(a(paramInt, "label"));
    }
    String str1 = a(paramInt, "rel_label");
    String str2 = a(paramInt, "rel_value");
    Object localObject2 = a(paramInt, "rel_value_style");
    if ((a(str1)) && (a(str2))) {
      return;
    }
    Object localObject1 = localObject2;
    if (com.unionpay.mobile.android.data.a.a((String)localObject2))
    {
      paramInt = Color.parseColor((String)localObject2);
      localObject1 = Integer.toString(paramInt, 16);
    }
    localObject2 = "#ff" + (String)localObject1;
    localObject1 = this.v;
    paramInt = Color.parseColor((String)localObject2);
    localObject2 = new SpannableString(str1 + str2);
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(paramInt);
    int j = str1.length();
    boolean bool;
    if (TextUtils.isEmpty(str2))
    {
      paramInt = 0;
      ((SpannableString)localObject2).setSpan(localForegroundColorSpan, j, paramInt + j, 33);
      ((TextView)localObject1).setText((CharSequence)localObject2);
      if (this.u == null) {
        break label276;
      }
      bool = this.u.b();
      label250:
      if (!bool) {
        break label282;
      }
    }
    label276:
    label282:
    for (paramInt = i;; paramInt = 8)
    {
      this.v.setVisibility(paramInt);
      return;
      paramInt = str2.length();
      break;
      bool = true;
      break label250;
    }
  }
  
  public final String a()
  {
    String str2 = a(this.s - this.q.c(), "value");
    String str1 = str2;
    if (this.u != null)
    {
      str1 = str2;
      if (!this.u.b()) {
        str1 = null;
      }
    }
    h.c("uppay", m() + " : " + str1);
    return str1;
  }
  
  public final void a(o.a parama)
  {
    this.u.a(parama);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.u.a(paramBoolean);
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      this.l.setVisibility(i);
      if (this.v != null)
      {
        if (!TextUtils.isEmpty(this.v.getText().toString())) {
          break;
        }
        this.v.setVisibility(8);
      }
      return;
    }
    this.v.setVisibility(i);
  }
  
  protected final boolean a(LinearLayout paramLinearLayout, String paramString)
  {
    if (a(paramString)) {
      return true;
    }
    LinearLayout localLinearLayout1 = new LinearLayout(this.c);
    localLinearLayout1.setBackgroundColor(-1);
    localLinearLayout1.setOrientation(1);
    paramLinearLayout.addView(localLinearLayout1, new LinearLayout.LayoutParams(-1, com.unionpay.mobile.android.global.a.n));
    paramLinearLayout = g.a(this.m, "type");
    if ("instalment".equals(paramLinearLayout))
    {
      LinearLayout localLinearLayout2 = new LinearLayout(this.c);
      localLinearLayout2.setId(localLinearLayout2.hashCode());
      localLinearLayout2.setBackgroundColor(-3419943);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 1);
      localLayoutParams.leftMargin = d.a(this.c, 10.0F);
      localLinearLayout1.addView(localLinearLayout2, localLayoutParams);
    }
    paramLinearLayout = a(paramLinearLayout, paramString, g.a(this.m, "checked"));
    this.u = new o(this.c, paramLinearLayout);
    this.u.a();
    this.u.a(b.k);
    paramLinearLayout = new LinearLayout.LayoutParams(-1, com.unionpay.mobile.android.global.a.n);
    paramLinearLayout.gravity = 16;
    int i = d.a(this.c, 10.0F);
    paramLinearLayout.rightMargin = i;
    paramLinearLayout.leftMargin = i;
    localLinearLayout1.addView(this.u, paramLinearLayout);
    return true;
  }
  
  public final boolean b()
  {
    return true;
  }
  
  protected final boolean b_()
  {
    this.v = new TextView(this.c);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = d.a(this.c, 10.0F);
    int i = d.a(this.c, 5.0F);
    localLayoutParams.bottomMargin = i;
    localLayoutParams.topMargin = i;
    this.v.setTextSize(b.k);
    addView(this.v, localLayoutParams);
    this.v.setVisibility(8);
    return true;
  }
  
  public final boolean c()
  {
    return true;
  }
  
  public final boolean e()
  {
    String str = a(this.s - this.q.c(), "available");
    return (TextUtils.isEmpty(str)) || (!"1".equals(str));
  }
  
  public final boolean f()
  {
    if (this.u != null) {
      return this.u.b();
    }
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\widgets\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */