package com.alibaba.mtl.appmonitor.model;

import com.alibaba.mtl.log.model.LogField;
import java.util.Map;
import java.util.Set;

public class UTDimensionValueSet
  extends DimensionValueSet
{
  private static final Set<LogField> a = new UTDimensionValueSet.1();
  
  public static UTDimensionValueSet create(Map<String, String> paramMap)
  {
    return (UTDimensionValueSet)com.alibaba.mtl.appmonitor.c.a.a().a(UTDimensionValueSet.class, new Object[] { paramMap });
  }
  
  public void clean()
  {
    super.clean();
  }
  
  public void fill(Object... paramVarArgs)
  {
    super.fill(paramVarArgs);
  }
  
  public Integer getEventId()
  {
    String str;
    if (this.map != null)
    {
      str = (String)this.map.get(LogField.EVENTID.toString());
      if (str == null) {}
    }
    for (;;)
    {
      try
      {
        i = com.alibaba.mtl.appmonitor.f.a.a(str);
        return Integer.valueOf(i);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        i = 0;
        continue;
      }
      int i = 0;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\model\UTDimensionValueSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */