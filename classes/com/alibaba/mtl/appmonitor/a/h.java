package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.appmonitor.c.b;
import java.util.HashMap;
import java.util.Map;

public class h
  implements b
{
  public int e;
  public Map<String, String> k;
  public String u;
  public String v;
  public String w;
  public String x;
  
  public void clean()
  {
    this.u = null;
    this.e = 0;
    this.v = null;
    this.w = null;
    this.x = null;
    if (this.k != null) {
      this.k.clear();
    }
  }
  
  public void fill(Object... paramVarArgs)
  {
    if (this.k == null) {
      this.k = new HashMap();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */