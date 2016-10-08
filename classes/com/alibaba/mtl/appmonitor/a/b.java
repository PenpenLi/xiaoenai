package com.alibaba.mtl.appmonitor.a;

import com.alibaba.fastjson.JSONObject;

public class b
  extends d
{
  public int count;
  public double e;
  
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = super.a();
      localJSONObject.put("count", Integer.valueOf(this.count));
      localJSONObject.put("value", Double.valueOf(this.e));
      return localJSONObject;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(double paramDouble)
  {
    try
    {
      this.e += paramDouble;
      this.count += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void fill(Object... paramVarArgs)
  {
    try
    {
      super.fill(paramVarArgs);
      this.e = 0.0D;
      this.count = 0;
      return;
    }
    finally
    {
      paramVarArgs = finally;
      throw paramVarArgs;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */