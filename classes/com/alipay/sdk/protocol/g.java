package com.alipay.sdk.protocol;

import android.text.TextUtils;
import com.alipay.sdk.data.e;
import org.json.JSONObject;

public final class g
  extends h
{
  private int l;
  private boolean m = false;
  
  protected g(e parame, com.alipay.sdk.data.f paramf)
  {
    super(parame, paramf);
  }
  
  private boolean d()
  {
    return this.m;
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = 0;
    super.a(paramJSONObject);
    if (paramJSONObject.has("form"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("form");
      String str = paramJSONObject.optString("type");
      this.k = Boolean.parseBoolean(paramJSONObject.optString("oneTime"));
      if (TextUtils.equals("page", str))
      {
        this.m = true;
        this.l = 9;
      }
      do
      {
        for (;;)
        {
          return;
          if (TextUtils.equals("dialog", str))
          {
            this.l = 7;
            this.m = false;
            return;
          }
          if (!TextUtils.equals("toast", str)) {
            break;
          }
          paramJSONObject = b.a(paramJSONObject, "onload");
          this.l = 6;
          if (paramJSONObject != null)
          {
            paramJSONObject = a.a(paramJSONObject);
            int j = paramJSONObject.length;
            while (i < j)
            {
              str = paramJSONObject[i];
              if ((str == a.d) || (str == a.e)) {
                this.l = 10;
              }
              i += 1;
            }
          }
        }
      } while (TextUtils.equals("confirm", str));
      this.m = TextUtils.equals(str, "fullscreen");
      this.l = 4;
      return;
    }
    if (f.a(paramJSONObject.optString("status")) == f.c)
    {
      this.l = -10;
      return;
    }
    this.l = 8;
  }
  
  public final boolean a()
  {
    return (this.l == 4) || (this.l == 9);
  }
  
  public final int b()
  {
    return this.l;
  }
  
  public final String c()
  {
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\protocol\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */