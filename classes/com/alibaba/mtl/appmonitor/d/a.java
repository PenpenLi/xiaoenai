package com.alibaba.mtl.appmonitor.d;

import com.alibaba.fastjson.JSONObject;

public abstract class a<T extends JSONObject>
{
  protected int n;
  
  public a(int paramInt)
  {
    this.n = paramInt;
  }
  
  protected void a(T paramT)
  {
    try
    {
      paramT = paramT.getInteger("sampling");
      if (paramT != null) {
        this.n = paramT.intValue();
      }
      return;
    }
    catch (Exception paramT) {}
  }
  
  protected boolean a(int paramInt)
  {
    return paramInt < this.n;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */