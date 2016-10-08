package com.xiaoenai.app.classes.chat.messagelist.message.model;

import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.a.c;
import com.xiaoenai.app.classes.chat.messagelist.a;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  extends k
{
  private String d = "016";
  private final float e = -1.0F;
  private double f = -1.0D;
  private double g = -1.0D;
  private float h = -1.0F;
  private double i = -99999.0D;
  private boolean j = false;
  private boolean k = false;
  private int l = -1;
  private c m = new c();
  
  public d()
  {
    b(true);
    d(this.d);
    c(Xiaoenai.j().getString(2131100135));
  }
  
  private void z()
  {
    b(Integer.valueOf(-2));
    c(Xiaoenai.j().getString(2131100128));
    k();
    a.k();
  }
  
  public void a(double paramDouble)
  {
    this.f = paramDouble;
  }
  
  public void a(float paramFloat)
  {
    this.h = paramFloat;
  }
  
  public void b(double paramDouble)
  {
    this.g = paramDouble;
  }
  
  public void b(String paramString)
  {
    super.b(paramString);
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("longitude")) {
        this.f = paramString.getDouble("longitude");
      }
      if (paramString.has("latitude")) {
        this.g = paramString.getDouble("latitude");
      }
      if (paramString.has("accuracy")) {
        this.h = ((float)paramString.getDouble("accuracy"));
      }
      if (paramString.has("distance")) {
        this.i = paramString.getDouble("distance");
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public String c()
  {
    Object localObject = new JSONObject();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(super.c());
        localObject = localJSONObject;
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
        continue;
      }
      try
      {
        if (this.f != -1.0D) {
          ((JSONObject)localObject).put("longitude", this.f);
        }
        if (this.g != -1.0D) {
          ((JSONObject)localObject).put("latitude", this.g);
        }
        if (this.h != -1.0F) {
          ((JSONObject)localObject).put("accuracy", this.h);
        }
        ((JSONObject)localObject).put("distance", this.i);
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
      }
    }
    return ((JSONObject)localObject).toString();
  }
  
  public void c(double paramDouble)
  {
    this.i = paramDouble;
  }
  
  public void c(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void j()
  {
    b(Integer.valueOf(-1));
    k();
    a.a().a(this);
    a.k();
    this.m.a(new e(this));
  }
  
  public double s()
  {
    return this.f;
  }
  
  public double t()
  {
    return this.g;
  }
  
  public double u()
  {
    return this.i;
  }
  
  public boolean v()
  {
    return this.j;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\model\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */