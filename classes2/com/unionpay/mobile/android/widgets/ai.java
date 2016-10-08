package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ForegroundColorSpan;
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
import com.unionpay.mobile.android.upwidget.o;
import com.unionpay.mobile.android.upwidget.o.a;
import com.unionpay.mobile.android.utils.d;
import com.unionpay.mobile.android.utils.g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ai
  extends y
{
  private final View.OnClickListener a = new aj(this);
  private final View.OnClickListener b = new ak(this);
  private final AdapterView.OnItemClickListener n = new al(this);
  private JSONArray o = g.c(this.m, "items");
  private PopupWindow p;
  private com.unionpay.mobile.android.upwidget.h q;
  private int r = 0;
  private int s = 0;
  private JSONArray t = null;
  private JSONArray u = null;
  private TextView v;
  private o w;
  private TextView x;
  private String y;
  private RelativeLayout z;
  
  public ai(Context paramContext, JSONObject paramJSONObject)
  {
    super(paramContext, paramJSONObject);
    this.y = g.a(paramJSONObject, "label");
    if (a(this.y)) {
      this.y = com.unionpay.mobile.android.languages.c.by.bg;
    }
    if (!TextUtils.isEmpty(g.a(paramJSONObject, "default_item_idx"))) {
      this.s = Integer.parseInt(g.a(paramJSONObject, "default_item_idx"));
    }
    this.q = new com.unionpay.mobile.android.upwidget.h(paramContext, this.o, this.s);
    this.q.a(this.n);
    this.q.a(this.a);
    this.q.d(this.b);
    paramContext = this.l;
    Object localObject = com.unionpay.mobile.android.resource.c.a(this.c).a(2014);
    paramJSONObject = new LinearLayout(this.c);
    paramJSONObject.setId(paramJSONObject.hashCode());
    paramJSONObject.setBackgroundColor(-3419943);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
    g.a(this.m, "type");
    paramContext.addView(paramJSONObject, localLayoutParams);
    this.z = new RelativeLayout(this.c);
    this.z.setId(this.z.hashCode());
    this.z.setBackgroundDrawable((Drawable)localObject);
    this.z.setOnClickListener(new am(this));
    localObject = new RelativeLayout.LayoutParams(-1, com.unionpay.mobile.android.global.a.n);
    ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, paramJSONObject.getId());
    paramContext.addView(this.z, (ViewGroup.LayoutParams)localObject);
    paramJSONObject = new ImageView(this.c);
    paramJSONObject.setId(paramJSONObject.hashCode());
    paramJSONObject.setBackgroundDrawable(com.unionpay.mobile.android.resource.c.a(this.c).a(1002));
    int i = d.a(this.c, 15.0F);
    localObject = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = d.a(this.c, 10.0F);
    this.z.addView(paramJSONObject, (ViewGroup.LayoutParams)localObject);
    this.v = new TextView(this.c);
    this.v.setTextSize(b.k);
    this.v.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    this.v.setSingleLine(true);
    this.v.setTextColor(-10066330);
    localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(9, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(0, paramJSONObject.getId());
    ((RelativeLayout.LayoutParams)localObject).leftMargin = d.a(this.c, 10.0F);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = ((RelativeLayout.LayoutParams)localObject).leftMargin;
    this.z.addView(this.v, (ViewGroup.LayoutParams)localObject);
    if (!"instalment".equals("promotion"))
    {
      paramJSONObject = new LinearLayout(this.c);
      paramJSONObject.setBackgroundColor(-3419943);
      localObject = new RelativeLayout.LayoutParams(-1, 1);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = com.unionpay.mobile.android.global.a.f;
      ((RelativeLayout.LayoutParams)localObject).addRule(3, this.z.getId());
      paramContext.addView(paramJSONObject, (ViewGroup.LayoutParams)localObject);
    }
    a(f());
    a(this.s, 0);
  }
  
  private String a(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = g.b(this.o, paramInt1);
    if (localObject != null)
    {
      localObject = (JSONObject)localObject;
      String str = g.a((JSONObject)localObject, "type");
      if ("coupon".equals(str)) {
        localObject = this.t;
      }
      for (;;)
      {
        localObject = g.b((JSONArray)localObject, paramInt2);
        if (localObject == null) {
          break;
        }
        return g.a((JSONObject)localObject, paramString);
        if ("point".equals(str)) {
          localObject = this.u;
        } else {
          localObject = g.c((JSONObject)localObject, "options");
        }
      }
    }
    return "";
  }
  
  private static JSONObject a(String paramString1, String paramString2, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramString1);
      localJSONObject.put("label", paramString2);
      localJSONObject.put("checked", paramString3);
      localJSONObject.put("ckb_style", "small");
      localJSONObject.put("required", "0");
      return localJSONObject;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return localJSONObject;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i = 0;
    this.s = paramInt1;
    this.r = paramInt2;
    if (this.v != null) {
      this.v.setText(a(paramInt1, paramInt2, "label"));
    }
    String str1 = a(paramInt1, paramInt2, "rel_label");
    String str2 = a(paramInt1, paramInt2, "rel_value");
    Object localObject2 = a(paramInt1, paramInt2, "rel_value_style");
    if ((a(str1)) && (a(str2)))
    {
      this.x.setVisibility(8);
      return;
    }
    Object localObject1 = localObject2;
    if (com.unionpay.mobile.android.data.a.a((String)localObject2))
    {
      paramInt1 = Color.parseColor((String)localObject2);
      localObject1 = Integer.toString(paramInt1, 16);
    }
    localObject2 = "#ff" + (String)localObject1;
    localObject1 = this.x;
    paramInt1 = Color.parseColor((String)localObject2);
    localObject2 = new SpannableString(str1 + str2);
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(paramInt1);
    paramInt2 = str1.length();
    boolean bool;
    if (TextUtils.isEmpty(str2))
    {
      paramInt1 = 0;
      ((SpannableString)localObject2).setSpan(localForegroundColorSpan, paramInt2, paramInt1 + paramInt2, 33);
      ((TextView)localObject1).setText((CharSequence)localObject2);
      if (this.w == null) {
        break label279;
      }
      bool = this.w.b();
      label253:
      if (!bool) {
        break label285;
      }
    }
    label279:
    label285:
    for (paramInt1 = i;; paramInt1 = 8)
    {
      this.x.setVisibility(paramInt1);
      return;
      paramInt1 = str2.length();
      break;
      bool = true;
      break label253;
    }
  }
  
  public final String a()
  {
    Object localObject2 = a(this.s, this.r, "value");
    Object localObject1 = localObject2;
    if (localObject2 != null) {
      localObject1 = ((String)localObject2).replace("\"", "\\\"");
    }
    localObject2 = localObject1;
    if (this.w != null)
    {
      localObject2 = localObject1;
      if (!this.w.b()) {
        localObject2 = null;
      }
    }
    com.unionpay.mobile.android.utils.h.c("uppay", m() + " : " + (String)localObject2);
    return (String)localObject2;
  }
  
  public final void a(View.OnClickListener paramOnClickListener)
  {
    this.q.b(this.a);
    this.q.b(paramOnClickListener);
  }
  
  public final void a(o.a parama)
  {
    if (this.w != null) {
      this.w.a(parama);
    }
  }
  
  public final void a(JSONArray paramJSONArray)
  {
    this.t = paramJSONArray;
    this.q.a(paramJSONArray);
  }
  
  public final void a(JSONArray paramJSONArray, String paramString)
  {
    this.u = paramJSONArray;
    this.q.a(paramJSONArray, paramString);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (this.w != null) {
      this.w.a(paramBoolean);
    }
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      this.l.setVisibility(i);
      if (this.x != null)
      {
        if (!TextUtils.isEmpty(this.x.getText().toString())) {
          break;
        }
        this.x.setVisibility(8);
      }
      return;
    }
    this.x.setVisibility(i);
  }
  
  protected final boolean a(LinearLayout paramLinearLayout, String paramString)
  {
    if (a(paramString)) {
      return true;
    }
    LinearLayout localLinearLayout = new LinearLayout(this.c);
    localLinearLayout.setBackgroundColor(-1);
    localLinearLayout.setOrientation(1);
    paramLinearLayout.addView(localLinearLayout, new LinearLayout.LayoutParams(-1, com.unionpay.mobile.android.global.a.n));
    paramLinearLayout = a(g.a(this.m, "type"), paramString, g.a(this.m, "checked"));
    this.w = new o(this.c, paramLinearLayout);
    this.w.a();
    this.w.a(b.k);
    paramLinearLayout = new LinearLayout.LayoutParams(-1, com.unionpay.mobile.android.global.a.n);
    paramLinearLayout.gravity = 16;
    int i = d.a(this.c, 10.0F);
    paramLinearLayout.rightMargin = i;
    paramLinearLayout.leftMargin = i;
    localLinearLayout.addView(this.w, paramLinearLayout);
    return true;
  }
  
  public final void b(View.OnClickListener paramOnClickListener)
  {
    this.q.e(paramOnClickListener);
  }
  
  public final boolean b()
  {
    return true;
  }
  
  protected final boolean b_()
  {
    this.x = new TextView(this.c);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = d.a(this.c, 10.0F);
    int i = d.a(this.c, 5.0F);
    localLayoutParams.bottomMargin = i;
    localLayoutParams.topMargin = i;
    this.x.setTextSize(b.k);
    addView(this.x, localLayoutParams);
    this.x.setVisibility(8);
    return true;
  }
  
  public final void c(View.OnClickListener paramOnClickListener)
  {
    this.q.c(paramOnClickListener);
  }
  
  public final boolean c()
  {
    return true;
  }
  
  public final boolean e()
  {
    String str = a(this.s, this.r, "available");
    return (TextUtils.isEmpty(str)) || (!"1".equals(str));
  }
  
  public final boolean f()
  {
    if (this.w != null) {
      return this.w.b();
    }
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\widgets\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */