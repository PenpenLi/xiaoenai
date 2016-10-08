package com.alibaba.nb.android.trade.utils.a;

import com.alibaba.nb.android.trade.model.AliPayResult;
import com.alibaba.nb.android.trade.model.AliTradeResult;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  private static final String a = c.class.getSimpleName();
  
  public static a a(String paramString)
  {
    int i = 808;
    for (;;)
    {
      try
      {
        int j = Integer.parseInt(paramString);
        switch (j)
        {
        }
      }
      catch (Exception localException)
      {
        com.alibaba.nb.android.trade.utils.d.a.d(a, "fail to parse the response code " + paramString);
        continue;
      }
      return a.a(i, new Object[] { paramString });
      i = 804;
      continue;
      i = 805;
      continue;
      i = 806;
      continue;
      i = 807;
      continue;
      i = 809;
    }
  }
  
  public static AliTradeResult b(String paramString)
  {
    int j = 0;
    localAliTradeResult = new AliTradeResult();
    localAliTradeResult.payResult = new AliPayResult();
    try
    {
      paramString = new JSONObject(paramString);
      Object localObject = paramString.optJSONArray("paySuccessOrders");
      int k;
      int i;
      if (localObject != null)
      {
        ArrayList localArrayList = new ArrayList(((JSONArray)localObject).length());
        localAliTradeResult.payResult.paySuccessOrders = localArrayList;
        k = ((JSONArray)localObject).length();
        i = 0;
        while (i < k)
        {
          localArrayList.add(Long.valueOf(((JSONArray)localObject).optLong(i)));
          i += 1;
        }
      }
      paramString = paramString.optJSONArray("payFailedOrders");
      if (paramString != null)
      {
        localObject = new ArrayList(paramString.length());
        localAliTradeResult.payResult.payFailedOrders = ((List)localObject);
        k = paramString.length();
        i = j;
        while (i < k)
        {
          ((List)localObject).add(Long.valueOf(paramString.optLong(i)));
          i += 1;
        }
      }
      return localAliTradeResult;
    }
    catch (JSONException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\utils\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */