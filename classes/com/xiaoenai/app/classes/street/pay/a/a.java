package com.xiaoenai.app.classes.street.pay.a;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.xiaoenai.app.classes.street.model.BuyInfo;
import com.xiaoenai.app.classes.street.model.BuyQueryResult;
import com.xiaoenai.app.classes.street.pay.StreetPayBaseActivity;
import com.xiaoenai.app.utils.as;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private o a = null;
  private f b = null;
  private a c = null;
  private StreetPayBaseActivity d = null;
  private Handler e = new Handler();
  private int f = 0;
  private int g = 0;
  private String h = "";
  private String i = "";
  private BuyInfo[] j = null;
  private long k = 100L;
  private boolean l = false;
  private boolean m = true;
  
  public a(StreetPayBaseActivity paramStreetPayBaseActivity, a parama)
  {
    this.d = paramStreetPayBaseActivity;
    this.c = parama;
    this.b = new b(this);
  }
  
  private void b(boolean paramBoolean, JSONObject paramJSONObject)
  {
    com.xiaoenai.app.utils.f.a.c("success = {} data = {}", new Object[] { Boolean.valueOf(paramBoolean), paramJSONObject });
    if (paramBoolean)
    {
      com.xiaoenai.app.utils.f.a.c("data = {}", new Object[] { paramJSONObject });
      n = paramJSONObject.optInt("data");
      a(new d(this.d, n));
      a();
    }
    while (this.c == null)
    {
      int n;
      return;
    }
    this.c.a(paramBoolean, paramJSONObject);
  }
  
  private void c(boolean paramBoolean, JSONObject paramJSONObject)
  {
    com.xiaoenai.app.utils.f.a.c("success = {} data = {}", new Object[] { Boolean.valueOf(paramBoolean), paramJSONObject });
    if (paramBoolean)
    {
      localJSONObject = paramJSONObject.optJSONObject("data");
      if (localJSONObject != null)
      {
        if (localJSONObject.optInt("complete", 0) <= 0) {
          break label150;
        }
        if (this.c != null)
        {
          localBuyQueryResult = new BuyQueryResult(localJSONObject);
          if (this.c != null) {
            this.c.b(paramBoolean, localJSONObject);
          }
          if ((localBuyQueryResult.getOrders() == null) || (localBuyQueryResult.getOrders().length <= 0)) {
            break label131;
          }
          a(new g(this.d, localBuyQueryResult.getOrders(), this.h, localBuyQueryResult.getTotalPrice()));
          a();
        }
      }
    }
    label131:
    label150:
    while (this.c == null)
    {
      JSONObject localJSONObject;
      BuyQueryResult localBuyQueryResult;
      do
      {
        return;
      } while (this.c == null);
      this.c.b(paramBoolean, paramJSONObject);
      return;
      d();
      return;
    }
    this.c.b(paramBoolean, paramJSONObject);
  }
  
  private void d()
  {
    if (this.k < 60000L)
    {
      this.e.postDelayed(new c(this), this.k);
      this.k = (4L * this.k);
    }
  }
  
  private void d(boolean paramBoolean, JSONObject paramJSONObject)
  {
    com.xiaoenai.app.utils.f.a.c("success = {} data = {}", new Object[] { Boolean.valueOf(paramBoolean), paramJSONObject });
    if (paramBoolean)
    {
      int n = paramJSONObject.optInt("data");
      a(new k(this.d, n));
      a();
    }
    if (this.c != null) {
      this.c.c(paramBoolean, paramJSONObject);
    }
  }
  
  private void e(boolean paramBoolean, JSONObject paramJSONObject)
  {
    com.xiaoenai.app.utils.f.a.c("success = {} data = {}", new Object[] { Boolean.valueOf(paramBoolean), paramJSONObject });
    if ((paramBoolean) && (paramJSONObject != null))
    {
      paramJSONObject = paramJSONObject.optJSONObject("data");
      com.xiaoenai.app.utils.f.a.c("data = {}", new Object[] { paramJSONObject });
      if (paramJSONObject.optInt("complete", 0) > 0)
      {
        str3 = paramJSONObject.optString("charge");
        localObject2 = null;
        paramJSONObject = null;
        str2 = "";
        str1 = str2;
        localObject1 = localObject2;
        if (str3 != null)
        {
          str1 = str2;
          localObject1 = localObject2;
          if (str3.length() <= 0) {}
        }
        try
        {
          localObject1 = new JSONObject(str3);
          paramJSONObject = (JSONObject)localObject1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
        str1 = str2;
        localObject1 = paramJSONObject;
        if (paramJSONObject != null)
        {
          str1 = paramJSONObject.optString("id");
          localObject1 = paramJSONObject;
        }
        com.xiaoenai.app.utils.f.a.c("charge = {}", new Object[] { str3 });
        com.xiaoenai.app.utils.f.a.c("charge_id = {}", new Object[] { str1 });
        this.i = str1;
        if ((localObject1 != null) && (this.c != null)) {
          this.c.d(paramBoolean, (JSONObject)localObject1);
        }
        if ((str3 != null) && (str3.length() > 0))
        {
          a(new i(this.d, str3, this.h));
          a();
        }
      }
    }
    while (this.c == null)
    {
      String str3;
      Object localObject2;
      String str2;
      String str1;
      Object localObject1;
      return;
      d();
      return;
    }
    this.c.d(paramBoolean, paramJSONObject);
  }
  
  private void f(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      a(new m(this.d, this.i));
      a();
      if (this.c != null) {
        this.c.e(paramBoolean, paramJSONObject);
      }
    }
    do
    {
      do
      {
        return;
        String str1 = paramJSONObject.optString("data", "fail");
        String str2 = paramJSONObject.optString("channel", "alipay");
        if (!str1.equalsIgnoreCase("invalid")) {
          break;
        }
        if ((this.m) && (as.e(this.d, "com.unionpay.uppay")) && (str2.equals("upacp")))
        {
          a();
          this.m = false;
          return;
        }
      } while (this.c == null);
      this.c.e(paramBoolean, paramJSONObject);
      return;
    } while (this.c == null);
    this.c.e(paramBoolean, paramJSONObject);
  }
  
  private void g(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (this.c != null) {
      this.c.f(paramBoolean, paramJSONObject);
    }
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.a(this.b);
    }
  }
  
  public void a(int paramInt1, int paramInt2, BuyInfo[] paramArrayOfBuyInfo, String paramString)
  {
    com.xiaoenai.app.utils.f.a.c("contact_id = {}", new Object[] { Integer.valueOf(paramInt1) });
    com.xiaoenai.app.utils.f.a.c("privated = {}", new Object[] { Integer.valueOf(paramInt2) });
    com.xiaoenai.app.utils.f.a.c("channel = {}", new Object[] { paramString });
    this.f = paramInt1;
    this.g = paramInt2;
    this.j = paramArrayOfBuyInfo;
    this.h = paramString;
    if (this.a == null) {
      this.a = new p(this.d, this.f, paramInt2, this.j);
    }
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((b() != null) && ((b() instanceof i))) {
      ((i)b()).a(paramContext, paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(o paramo)
  {
    this.k = 100L;
    this.m = true;
    this.a = paramo;
  }
  
  public void a(boolean paramBoolean, JSONObject paramJSONObject)
  {
    com.xiaoenai.app.utils.f.a.c("state = {} success = {} data = {} state", new Object[] { b(), Boolean.valueOf(paramBoolean), paramJSONObject });
    if ((b() instanceof p)) {
      b(paramBoolean, paramJSONObject);
    }
    do
    {
      return;
      if ((b() instanceof d))
      {
        c(paramBoolean, paramJSONObject);
        return;
      }
      if ((b() instanceof g))
      {
        d(paramBoolean, paramJSONObject);
        return;
      }
      if ((b() instanceof k))
      {
        e(paramBoolean, paramJSONObject);
        return;
      }
      if ((b() instanceof i))
      {
        f(paramBoolean, paramJSONObject);
        return;
      }
    } while (!(b() instanceof m));
    g(paramBoolean, paramJSONObject);
  }
  
  public o b()
  {
    return this.a;
  }
  
  public void c() {}
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(boolean paramBoolean, JSONObject paramJSONObject);
    
    public abstract void b(boolean paramBoolean, JSONObject paramJSONObject);
    
    public abstract void c(boolean paramBoolean, JSONObject paramJSONObject);
    
    public abstract void d(boolean paramBoolean, JSONObject paramJSONObject);
    
    public abstract void e(boolean paramBoolean, JSONObject paramJSONObject);
    
    public abstract void f(boolean paramBoolean, JSONObject paramJSONObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\pay\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */