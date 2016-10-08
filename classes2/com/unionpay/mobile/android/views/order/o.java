package com.unionpay.mobile.android.views.order;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class o
  extends LinearLayout
{
  private Context a;
  private int b = l.a.intValue();
  private int c = l.a.intValue();
  private JSONObject d;
  private JSONObject e;
  private JSONObject f;
  private Drawable g;
  private JSONArray h;
  private List<Map<String, Object>> i;
  private String j;
  private String k;
  private AbstractMethod l;
  private CViewMethods m;
  private Drawable n;
  private boolean o;
  
  private o(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    setOrientation(1);
  }
  
  public static o a(Context paramContext, Drawable paramDrawable)
  {
    paramContext = new o(paramContext);
    paramContext.g = paramDrawable;
    return paramContext;
  }
  
  public static o a(Context paramContext, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    paramContext = new o(paramContext);
    paramContext.n = paramDrawable2;
    paramContext.b = l.c.intValue();
    paramContext.c = l.c.intValue();
    paramContext.g = paramDrawable1;
    paramContext.c();
    return paramContext;
  }
  
  public static o a(Context paramContext, JSONArray paramJSONArray, List<Map<String, Object>> paramList, Drawable paramDrawable1, Drawable paramDrawable2, String paramString)
  {
    paramContext = new o(paramContext);
    paramContext.n = paramDrawable2;
    paramContext.b = l.b.intValue();
    paramContext.c = l.b.intValue();
    paramContext.g = paramDrawable1;
    paramContext.h = paramJSONArray;
    paramContext.i = paramList;
    paramContext.k = paramString;
    paramContext.c();
    return paramContext;
  }
  
  public final int a()
  {
    return this.b;
  }
  
  public final o a(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public final o a(Drawable paramDrawable)
  {
    this.n = paramDrawable;
    return this;
  }
  
  public final o a(a parama)
  {
    if (this.l != null)
    {
      this.l.a(parama);
      this.l.a(parama);
      if ((this.l instanceof b)) {
        ((b)this.l).a(parama);
      }
    }
    if (this.m != null) {
      this.m.a(parama);
    }
    return this;
  }
  
  public final o a(String paramString)
  {
    this.j = paramString;
    return this;
  }
  
  public final o a(List<Map<String, Object>> paramList)
  {
    this.i = paramList;
    return this;
  }
  
  public final o a(JSONArray paramJSONArray)
  {
    this.h = paramJSONArray;
    return this;
  }
  
  public final o a(JSONObject paramJSONObject)
  {
    this.d = paramJSONObject;
    if ((this.l != null) && ((this.l instanceof b))) {
      ((b)this.l).a(this.d);
    }
    return this;
  }
  
  public final o a(boolean paramBoolean)
  {
    this.o = paramBoolean;
    return this;
  }
  
  public final o b(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public final o b(Drawable paramDrawable)
  {
    if (this.l != null) {
      this.l.a(paramDrawable);
    }
    return this;
  }
  
  public final o b(String paramString)
  {
    this.k = paramString;
    return this;
  }
  
  public final o b(JSONObject paramJSONObject)
  {
    this.e = paramJSONObject;
    if ((this.l != null) && ((this.l instanceof i))) {
      ((i)this.l).a(this.e);
    }
    return this;
  }
  
  public final String b()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.l != null)
    {
      localObject1 = localObject2;
      if ((this.l instanceof i)) {
        localObject1 = ((i)this.l).h();
      }
    }
    return (String)localObject1;
  }
  
  public final o c(JSONObject paramJSONObject)
  {
    this.f = paramJSONObject;
    if ((this.l != null) && ((this.l instanceof i))) {
      ((i)this.l).b(this.f);
    }
    return this;
  }
  
  public final void c()
  {
    this.l = null;
    Object localObject;
    if (this.b == l.b.intValue())
    {
      this.c &= (l.b.intValue() ^ 0xFFFFFFFF);
      localObject = new b(this.a, this.i, this.k);
      ((b)localObject).b(com.unionpay.mobile.android.languages.c.by.bt);
      ((b)localObject).d(com.unionpay.mobile.android.languages.c.by.bu);
      ((b)localObject).a(this.d);
      ((b)localObject).a(this.h);
      ((b)localObject).b(this.o);
      ((b)localObject).b(com.unionpay.mobile.android.resource.c.a(this.a).a(2014));
      com.unionpay.mobile.android.resource.c localc = com.unionpay.mobile.android.resource.c.a(this.a);
      ((b)localObject).a(localc.a(1015), localc.a(1016), localc.a(1002));
      this.l = ((AbstractMethod)localObject);
    }
    for (;;)
    {
      if (this.l != null)
      {
        this.l.a();
        localObject = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject).topMargin = com.unionpay.mobile.android.global.b.a;
        addView(this.l, (ViewGroup.LayoutParams)localObject);
      }
      this.m = new CViewMethods(this.a);
      this.m.a(this.g);
      this.m.a(this.c);
      localObject = new HashMap();
      ((HashMap)localObject).put(l.b, com.unionpay.mobile.android.languages.c.by.bt);
      ((HashMap)localObject).put(l.d, this.j);
      ((HashMap)localObject).put(l.e, com.unionpay.mobile.android.languages.c.by.bo);
      ((HashMap)localObject).put(l.c, com.unionpay.mobile.android.languages.c.by.bv);
      this.m.a((HashMap)localObject);
      localObject = new HashMap();
      ((HashMap)localObject).put(l.b, this.n);
      ((HashMap)localObject).put(l.d, this.n);
      ((HashMap)localObject).put(l.e, this.n);
      ((HashMap)localObject).put(l.c, this.n);
      this.m.b((HashMap)localObject);
      this.m.a(com.unionpay.mobile.android.languages.c.by.bx).a();
      localObject = new LinearLayout.LayoutParams(-1, -2);
      addView(this.m, (ViewGroup.LayoutParams)localObject);
      return;
      if (this.b == l.c.intValue())
      {
        this.c &= (l.c.intValue() ^ 0xFFFFFFFF);
        localObject = new i(this.a);
        ((i)localObject).b(com.unionpay.mobile.android.languages.c.by.bv);
        ((i)localObject).d(com.unionpay.mobile.android.languages.c.by.bw);
        ((i)localObject).a(this.e);
        ((i)localObject).b(this.f);
        this.l = ((AbstractMethod)localObject);
      }
    }
  }
  
  public final void c(int paramInt)
  {
    if ((this.l != null) && ((this.l instanceof b))) {
      ((b)this.l).a(paramInt);
    }
  }
  
  public static abstract interface a
    extends AbstractMethod.a, AbstractMethod.b, CViewMethods.a, b.b
  {}
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\views\order\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */