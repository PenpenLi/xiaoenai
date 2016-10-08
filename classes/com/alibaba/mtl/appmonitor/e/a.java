package com.alibaba.mtl.appmonitor.e;

import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.s;
import com.alibaba.mtl.log.model.LogField;
import java.util.Map;

public class a
{
  private static final String TAG = null;
  private static a a;
  
  public static a a()
  {
    try
    {
      if (a == null) {
        a = new a();
      }
      a locala = a;
      return locala;
    }
    finally {}
  }
  
  public void c(Map<String, String> paramMap)
  {
    if (paramMap == null) {}
    do
    {
      return;
      i.a(TAG, new Object[] { "[sendToUT]:", " args:", paramMap });
      if (!com.alibaba.mtl.log.a.r) {
        break;
      }
    } while (paramMap == null);
    String str1 = (String)paramMap.get(LogField.ARG1.toString());
    String str2 = (String)paramMap.get(LogField.ARG2.toString());
    String str3 = (String)paramMap.get(LogField.ARG3.toString());
    com.alibaba.mtl.log.a.a((String)paramMap.get(LogField.PAGE.toString()), (String)paramMap.get(LogField.EVENTID.toString()), str1, str2, str3, paramMap);
    return;
    paramMap.put("_fuamf", "yes");
    s.send(paramMap);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */