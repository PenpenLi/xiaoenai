package com.xiaoenai.app.model.mall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class OrderInfo
  implements Parcelable
{
  public static final Parcelable.Creator<OrderInfo> CREATOR = new OrderInfo.1();
  private int address_id = 0;
  private int count = 0;
  private String info = "";
  private int item_id = 0;
  private String memo = "";
  private long price = 0L;
  private int privated = 0;
  private long total_price = 0L;
  
  public OrderInfo() {}
  
  protected OrderInfo(Parcel paramParcel)
  {
    this.info = paramParcel.readString();
    try
    {
      parse(new JSONObject(this.info));
      return;
    }
    catch (JSONException paramParcel)
    {
      paramParcel.printStackTrace();
    }
  }
  
  public OrderInfo(String paramString)
  {
    this.info = paramString;
    try
    {
      parse(new JSONObject(paramString));
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public OrderInfo(JSONObject paramJSONObject)
  {
    this.info = paramJSONObject.toString();
    parse(paramJSONObject);
  }
  
  private void parse(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = new JSONObject(paramJSONObject.getString("order_info"));
      if (paramJSONObject != null)
      {
        this.item_id = paramJSONObject.optInt("item_id");
        this.address_id = paramJSONObject.optInt("address_id");
        this.privated = paramJSONObject.optInt("privated");
        this.count = paramJSONObject.optInt("count");
        this.memo = paramJSONObject.optString("memo");
        this.price = paramJSONObject.optLong("price");
        this.total_price = paramJSONObject.optLong("total_price");
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject.printStackTrace();
        paramJSONObject = null;
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getAddressId()
  {
    return this.address_id;
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  public String getData()
  {
    JSONObject localJSONObject1;
    if ((this.info == null) || (this.info.equals(""))) {
      localJSONObject1 = new JSONObject();
    }
    try
    {
      localJSONObject1.put("item_id", this.item_id);
      localJSONObject1.put("address_id", this.address_id);
      localJSONObject1.put("privated", this.privated);
      localJSONObject1.put("count", this.count);
      localJSONObject1.put("memo", this.memo);
      localJSONObject1.put("price", this.price);
      localJSONObject1.put("total_price", this.total_price);
      localJSONObject2 = new JSONObject();
    }
    catch (JSONException localJSONException2)
    {
      try
      {
        JSONObject localJSONObject2;
        localJSONObject2.put("order_info", localJSONObject1.toString());
        this.info = localJSONObject2.toString();
        return this.info;
        localJSONException2 = localJSONException2;
        localJSONException2.printStackTrace();
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          localJSONException1.printStackTrace();
        }
      }
    }
  }
  
  public int getItemId()
  {
    return this.item_id;
  }
  
  public String getMome()
  {
    return this.memo;
  }
  
  public long getPrice()
  {
    return this.price;
  }
  
  public int getPrivated()
  {
    return this.privated;
  }
  
  public long getTotalPrice()
  {
    return this.total_price;
  }
  
  public void setAddressId(int paramInt)
  {
    this.address_id = paramInt;
  }
  
  public void setCount(int paramInt)
  {
    this.count = paramInt;
  }
  
  public void setData(String paramString)
  {
    this.info = paramString;
  }
  
  public void setItemId(int paramInt)
  {
    this.item_id = paramInt;
  }
  
  public void setMome(String paramString)
  {
    this.memo = paramString;
  }
  
  public void setPrice(long paramLong)
  {
    this.price = paramLong;
  }
  
  public void setPrivated(int paramInt)
  {
    this.privated = paramInt;
  }
  
  public void setTotalPrice(long paramLong)
  {
    this.total_price = paramLong;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.info);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\model\mall\OrderInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */