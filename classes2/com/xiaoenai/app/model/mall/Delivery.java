package com.xiaoenai.app.model.mall;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class Delivery
{
  public static final int DELIVERY_STATE_PULLING = 1;
  public static final int DELIVERY_STATE_RECEIVED = 3;
  public static final int DELIVERY_STATE_ROUTE = 0;
  public static final int DELIVERY_STATE_TROUBLE = 2;
  private String deliveryId;
  private String detailJson;
  private String iconUrl;
  private String name;
  private ArrayList<StationInfo> stationInfos;
  private int status;
  
  public Delivery() {}
  
  public Delivery(JSONObject paramJSONObject)
  {
    this.deliveryId = paramJSONObject.optString("external_delivery_id");
    this.name = paramJSONObject.optString("name");
    this.iconUrl = paramJSONObject.optString("icon_url");
    this.status = paramJSONObject.optInt("status");
    paramJSONObject = paramJSONObject.optJSONArray("detail");
    if (paramJSONObject != null)
    {
      this.detailJson = paramJSONObject.toString();
      if ((this.detailJson != null) && (this.detailJson.length() > 0))
      {
        this.stationInfos = new ArrayList(paramJSONObject.length());
        int i = 0;
        while (i < paramJSONObject.length())
        {
          StationInfo localStationInfo = new StationInfo();
          JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
          localStationInfo.time = localJSONObject.optString("time");
          localStationInfo.ftime = localJSONObject.optString("ftime");
          localStationInfo.context = localJSONObject.optString("context");
          this.stationInfos.add(localStationInfo);
          i += 1;
        }
      }
    }
  }
  
  public String getDeliveryId()
  {
    return this.deliveryId;
  }
  
  public String getDetailJson()
  {
    return this.detailJson;
  }
  
  public String getIconUrl()
  {
    return this.iconUrl;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public ArrayList<StationInfo> getStationInfos()
  {
    return this.stationInfos;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public void setDeliveryId(String paramString)
  {
    this.deliveryId = paramString;
  }
  
  public void setDetailJson(String paramString)
  {
    this.detailJson = paramString;
  }
  
  public void setIconUrl(String paramString)
  {
    this.iconUrl = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setStationInfos(ArrayList<StationInfo> paramArrayList)
  {
    this.stationInfos = paramArrayList;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public class StationInfo
  {
    public String context;
    public String ftime;
    public String time;
    
    public StationInfo() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\model\mall\Delivery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */