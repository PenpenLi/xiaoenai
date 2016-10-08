package com.alibaba.sdk.android.ui.bus;

import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.ui.bus.filter.FilterInfo;
import com.alibaba.sdk.android.ui.bus.handler.HandlerInfo;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class UIBusInfo
  implements Serializable
{
  private static final long serialVersionUID = -6818538205628650162L;
  public int environment;
  public LinkedHashMap<String, FilterInfo> filterInfos;
  public LinkedHashMap<String, HandlerInfo> handlerInfos;
  public int version;
  
  public JSONObject toJSONObject()
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator;
    try
    {
      localJSONObject.put("version", this.version);
      JSONArray localJSONArray1 = new JSONArray();
      if (this.filterInfos != null)
      {
        localIterator = this.filterInfos.values().iterator();
        while (localIterator.hasNext()) {
          localJSONArray1.put(((FilterInfo)localIterator.next()).toJSONObject());
        }
      }
      localJSONObject.put("filters", localException);
    }
    catch (Exception localException)
    {
      AliSDKLogger.e("ui", localException);
      return localJSONObject;
    }
    JSONArray localJSONArray2 = new JSONArray();
    if (this.handlerInfos != null)
    {
      localIterator = this.handlerInfos.values().iterator();
      while (localIterator.hasNext()) {
        localJSONArray2.put(((HandlerInfo)localIterator.next()).toJSONObject());
      }
    }
    localJSONObject.put("handlers", localJSONArray2);
    return localJSONObject;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\bus\UIBusInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */