package com.alibaba.mtl.appmonitor.d;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.mtl.log.e.i;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class e
  extends j
{
  private int o;
  private int p;
  
  public e(String paramString, int paramInt1, int paramInt2)
  {
    super(paramString, 0);
    this.o = paramInt1;
    this.p = paramInt2;
  }
  
  public boolean a(int paramInt, Boolean paramBoolean, Map<String, String> paramMap)
  {
    i.a("AlarmMonitorPointSampling", new Object[] { "samplingSeed:", Integer.valueOf(paramInt), "isSuccess:", paramBoolean, "successSampling:", Integer.valueOf(this.o), "failSampling:", Integer.valueOf(this.p) });
    if ((this.e != null) && (paramMap != null))
    {
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
      {
        Boolean localBoolean = ((c)localIterator.next()).a(paramInt, paramMap);
        if (localBoolean != null) {
          return localBoolean.booleanValue();
        }
      }
    }
    return a(paramInt, paramBoolean.booleanValue());
  }
  
  protected boolean a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (paramInt >= this.o) {}
    }
    while (paramInt < this.p)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void b(JSONObject paramJSONObject)
  {
    super.b(paramJSONObject);
    this.o = this.n;
    this.p = this.n;
    Integer localInteger1 = paramJSONObject.getInteger("successSampling");
    if (localInteger1 != null) {
      this.o = localInteger1.intValue();
    }
    Integer localInteger2 = paramJSONObject.getInteger("failSampling");
    if (localInteger2 != null) {
      this.p = localInteger2.intValue();
    }
    i.a("AlarmMonitorPointSampling", new Object[] { "[updateSelfSampling]", paramJSONObject, "successSampling:", localInteger1, "failSampling", localInteger2 });
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */