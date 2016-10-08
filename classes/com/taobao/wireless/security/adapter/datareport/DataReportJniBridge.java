package com.taobao.wireless.security.adapter.datareport;

import com.taobao.wireless.security.adapter.common.a;
import com.taobao.wireless.security.adapter.common.b;
import com.taobao.wireless.security.adapter.common.c;
import java.util.HashMap;

public class DataReportJniBridge
{
  public static boolean sendReportBridge(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    HashMap localHashMap = null;
    if (a.b(new String[] { paramString2 }))
    {
      localHashMap = new HashMap();
      localHashMap.put("keyindex", paramString2);
    }
    return c.a(paramString1, localHashMap, paramArrayOfByte).b() == 200;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\wireless\security\adapter\datareport\DataReportJniBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */