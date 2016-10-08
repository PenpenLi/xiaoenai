package com.alibaba.mtl.appmonitor.a;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.b;
import com.alibaba.mtl.appmonitor.c.e;

public abstract class d
  implements b
{
  public int e;
  public String o;
  public String p;
  public String s;
  
  public JSONObject a()
  {
    JSONObject localJSONObject = (JSONObject)a.a().a(e.class, new Object[0]);
    localJSONObject.put("page", this.o);
    localJSONObject.put("monitorPoint", this.p);
    if (this.s != null) {
      localJSONObject.put("arg", this.s);
    }
    return localJSONObject;
  }
  
  public void clean()
  {
    this.e = 0;
    this.o = null;
    this.p = null;
    this.s = null;
  }
  
  public void fill(Object... paramVarArgs)
  {
    this.e = ((Integer)paramVarArgs[0]).intValue();
    this.o = ((String)paramVarArgs[1]);
    this.p = ((String)paramVarArgs[2]);
    if ((paramVarArgs.length > 3) && (paramVarArgs[3] != null)) {
      this.s = ((String)paramVarArgs[3]);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */