package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Spinner;
import android.widget.TextView;
import com.unionpay.mobile.android.upwidget.e;
import com.unionpay.mobile.android.utils.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  extends y
{
  private static List<String> u;
  private static List<String> v;
  private Spinner a = null;
  private int b = 1;
  private String n = com.unionpay.mobile.android.languages.c.by.be;
  private com.unionpay.mobile.android.upwidget.c o;
  private TextView p;
  private RelativeLayout q;
  private PopupWindow r;
  private e s;
  private List<Map<String, Object>> t;
  private final View.OnClickListener w = new b(this);
  private final AdapterView.OnItemClickListener x = new c(this);
  
  public a(Context paramContext, JSONObject paramJSONObject, JSONArray paramJSONArray)
  {
    super(paramContext, paramJSONObject);
    paramJSONObject = new ArrayList(1);
    int i = 0;
    while (i < paramJSONArray.length())
    {
      paramJSONObject.add((JSONArray)g.b(paramJSONArray, i));
      i += 1;
    }
    if (paramJSONObject.size() > 0)
    {
      u = new ArrayList(paramJSONObject.size());
      v = new ArrayList(paramJSONObject.size());
      i = 0;
      while (i < paramJSONObject.size())
      {
        v.add(g.a((JSONArray)paramJSONObject.get(i), 0));
        u.add(g.a((JSONArray)paramJSONObject.get(i), 1));
        i += 1;
      }
    }
    this.t = f();
    this.o = new com.unionpay.mobile.android.upwidget.c(paramContext, this.t, this.n, "", "", this.b, 0);
    this.s = new e(this.c, this.o);
    this.s.a(this.x);
    this.s.a(this.w);
    paramContext = this.l;
    paramJSONObject = com.unionpay.mobile.android.resource.c.a(this.c).a(2014);
    this.q = new RelativeLayout(this.c);
    this.q.setBackgroundDrawable(paramJSONObject);
    this.q.setOnClickListener(new d(this));
    paramJSONObject = new RelativeLayout.LayoutParams(-1, com.unionpay.mobile.android.global.a.n);
    paramJSONObject.addRule(15, -1);
    paramContext.addView(this.q, paramJSONObject);
    paramContext = new ImageView(this.c);
    paramContext.setId(paramContext.hashCode());
    paramContext.setBackgroundDrawable(com.unionpay.mobile.android.resource.c.a(this.c).a(1002));
    i = com.unionpay.mobile.android.utils.d.a(this.c, 15.0F);
    paramJSONObject = new RelativeLayout.LayoutParams(i, i);
    paramJSONObject.addRule(11, -1);
    paramJSONObject.addRule(15, -1);
    paramJSONObject.rightMargin = com.unionpay.mobile.android.utils.d.a(this.c, 10.0F);
    this.q.addView(paramContext, paramJSONObject);
    paramJSONObject = new TextView(this.c);
    paramJSONObject.setId(paramJSONObject.hashCode());
    paramJSONObject.setTextSize(com.unionpay.mobile.android.global.b.k);
    paramJSONObject.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    paramJSONObject.setSingleLine(true);
    paramJSONObject.setEms(4);
    paramJSONObject.setText(com.unionpay.mobile.android.languages.c.by.bd);
    paramJSONArray = new RelativeLayout.LayoutParams(-2, -2);
    paramJSONArray.addRule(15, -1);
    paramJSONArray.addRule(9, -1);
    paramJSONArray.leftMargin = com.unionpay.mobile.android.utils.d.a(this.c, 10.0F);
    this.q.addView(paramJSONObject, paramJSONArray);
    this.p = new TextView(this.c);
    this.p.setTextSize(com.unionpay.mobile.android.global.b.k);
    this.p.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    this.p.setSingleLine(true);
    this.p.setTextColor(-10066330);
    paramJSONArray = new RelativeLayout.LayoutParams(-1, -2);
    paramJSONArray.addRule(15, -1);
    paramJSONArray.addRule(1, paramJSONObject.getId());
    paramJSONArray.addRule(0, paramContext.getId());
    this.q.addView(this.p, paramJSONArray);
    if (this.h)
    {
      this.p.setText(b(h()));
      paramContext.setVisibility(8);
      this.q.setClickable(false);
      return;
    }
    a(1);
  }
  
  private void a(int paramInt)
  {
    this.b = paramInt;
    int i = this.o.c();
    this.o.a(this.b);
    if ((this.p != null) && (u != null)) {
      this.p.setText((CharSequence)u.get(paramInt - i));
    }
  }
  
  private static String b(String paramString)
  {
    String str = "";
    int i = 0;
    if (i < v.size())
    {
      if (!((String)v.get(i)).equals(paramString)) {
        break label58;
      }
      str = (String)u.get(i);
    }
    label58:
    for (;;)
    {
      i += 1;
      break;
      return str;
    }
  }
  
  private static List<Map<String, Object>> f()
  {
    HashMap localHashMap = null;
    Object localObject = localHashMap;
    if (u != null)
    {
      localObject = localHashMap;
      if (u.size() > 0)
      {
        localObject = new ArrayList(u.size());
        int i = 0;
        while (i < u.size())
        {
          localHashMap = new HashMap();
          localHashMap.put("text1", u.get(i));
          localHashMap.put("text2", "");
          localHashMap.put("editable", Boolean.FALSE);
          ((List)localObject).add(localHashMap);
          i += 1;
        }
      }
    }
    return (List<Map<String, Object>>)localObject;
  }
  
  public final String a()
  {
    String str2 = "";
    int i = this.b - this.o.c();
    String str1;
    if (this.h) {
      str1 = h();
    }
    do
    {
      do
      {
        return str1;
        str1 = str2;
      } while (i < 0);
      str1 = str2;
    } while (i > u.size());
    return (String)v.get(i);
  }
  
  public final boolean b()
  {
    return true;
  }
  
  public final boolean c()
  {
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\widgets\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */