package com.xiaoenai.app.model.mall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Order
  implements Parcelable
{
  public static final Parcelable.Creator<Order> CREATOR = new Order.1();
  public static final int DEFAULT_MAX_ORDER_LIST_SIZE = 20;
  public static final String MALL_ORDER_ID_KEY = "mall_order_id_key";
  public static final String MALL_ORDER_KEY = "mall_order_key";
  public static final int ORDER_CLOSED = 6;
  public static final int ORDER_NO_PAY = 0;
  public static final int ORDER_PAY_ACTION = 153;
  public static final int ORDER_RECEIVED = 3;
  public static final int ORDER_ROLLBACKED = 5;
  public static final int ORDER_ROLLBACKING = 4;
  public static final int ORDER_SENDED = 2;
  public static final int ORDER_WAITING_SEND = 1;
  private String address;
  private String addressJson;
  private int count;
  private String deliveryId;
  private ImageInfo[] detailImageUrl;
  private String detailTitle;
  private long expireTime;
  private boolean isPrivate = true;
  private boolean isShowSellOpBtn = false;
  private String itemJson;
  private String itemName;
  private String memo;
  private String name;
  private String orderId;
  private String phone;
  private int price;
  private int productId;
  private String productJson;
  private long startTime;
  private int status;
  private String statusDesc;
  private int totalPrice;
  private String zone;
  
  public Order() {}
  
  public Order(Parcel paramParcel)
  {
    this.orderId = paramParcel.readString();
    this.count = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.isPrivate = bool;
      this.status = paramParcel.readInt();
      this.statusDesc = paramParcel.readString();
      this.deliveryId = paramParcel.readString();
      this.startTime = paramParcel.readLong();
      this.expireTime = paramParcel.readLong();
      this.itemJson = paramParcel.readString();
      try
      {
        if (this.itemJson != null)
        {
          JSONObject localJSONObject = new JSONObject(this.itemJson);
          this.itemName = localJSONObject.optString("name");
          this.price = localJSONObject.optInt("price");
        }
        this.productJson = paramParcel.readString();
      }
      catch (JSONException localJSONException2)
      {
        try
        {
          if (this.productJson != null) {
            parseProductJson(new JSONObject(this.productJson));
          }
          this.addressJson = paramParcel.readString();
        }
        catch (JSONException localJSONException2)
        {
          try
          {
            for (;;)
            {
              if (this.addressJson != null) {
                parseAddressJson(new JSONObject(this.addressJson));
              }
              this.memo = paramParcel.readString();
              return;
              bool = false;
              break;
              localJSONException1 = localJSONException1;
              localJSONException1.printStackTrace();
            }
            localJSONException2 = localJSONException2;
            localJSONException2.printStackTrace();
          }
          catch (JSONException localJSONException3)
          {
            for (;;)
            {
              localJSONException3.printStackTrace();
            }
          }
        }
      }
    }
  }
  
  public Order(JSONObject paramJSONObject)
  {
    parseOrder(paramJSONObject);
  }
  
  public static ArrayList<Order> getOrderList(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localArrayList.add(new Order(paramJSONArray.optJSONObject(i)));
      i += 1;
    }
    return localArrayList;
  }
  
  private void parseAddressJson(JSONObject paramJSONObject)
  {
    this.name = paramJSONObject.optString("name");
    this.phone = paramJSONObject.optString("phone");
    this.zone = paramJSONObject.optString("province_city_zone");
    this.address = paramJSONObject.optString("address");
  }
  
  private void parseProductJson(JSONObject paramJSONObject)
  {
    this.detailTitle = paramJSONObject.optString("detail_title");
    this.productId = paramJSONObject.optInt("id");
    Object localObject = paramJSONObject.optString("detail_image_urls");
    paramJSONObject = null;
    try
    {
      localObject = new JSONArray((String)localObject);
      paramJSONObject = (JSONObject)localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        int i;
        localJSONException.printStackTrace();
      }
    }
    if (paramJSONObject != null)
    {
      this.detailImageUrl = new ImageInfo[paramJSONObject.length()];
      i = 0;
      while (i < paramJSONObject.length())
      {
        localObject = paramJSONObject.optJSONObject(i);
        this.detailImageUrl[i] = new ImageInfo();
        this.detailImageUrl[i].url = ((JSONObject)localObject).optString("url");
        this.detailImageUrl[i].width = ((JSONObject)localObject).optInt("width");
        this.detailImageUrl[i].height = ((JSONObject)localObject).optInt("height");
        i += 1;
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAddress()
  {
    return this.address;
  }
  
  public String getAddressJson()
  {
    return this.addressJson;
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  public String getDeliveryId()
  {
    return this.deliveryId;
  }
  
  public ImageInfo[] getDetailImageUrl()
  {
    return this.detailImageUrl;
  }
  
  public String getDetailTitle()
  {
    return this.detailTitle;
  }
  
  public long getExpireTime()
  {
    return this.expireTime;
  }
  
  public String getItemJson()
  {
    return this.itemJson;
  }
  
  public String getItemName()
  {
    return this.itemName;
  }
  
  public String getMemo()
  {
    return this.memo;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getOrderId()
  {
    return this.orderId;
  }
  
  public String getPhone()
  {
    return this.phone;
  }
  
  public float getPrice()
  {
    return this.price / 100.0F;
  }
  
  public String getPrice(float paramFloat)
  {
    return String.format("%.2f", new Object[] { Float.valueOf(paramFloat) });
  }
  
  public int getProductId()
  {
    return this.productId;
  }
  
  public String getProductJson()
  {
    return this.productJson;
  }
  
  public long getStartTime()
  {
    return this.startTime;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public String getStatusDesc()
  {
    return this.statusDesc;
  }
  
  public float getTotalPrice()
  {
    return this.price * this.count / 100.0F;
  }
  
  public String getZone()
  {
    return this.zone;
  }
  
  public boolean isPrivate()
  {
    return this.isPrivate;
  }
  
  public boolean isShowSellOpBtn()
  {
    return this.isShowSellOpBtn;
  }
  
  public void parseOrder(JSONObject paramJSONObject)
  {
    boolean bool = true;
    this.orderId = paramJSONObject.optString("id");
    if (paramJSONObject.optInt("privated") == 1) {}
    for (;;)
    {
      this.isPrivate = bool;
      this.status = paramJSONObject.optInt("status");
      this.count = paramJSONObject.optInt("count");
      this.deliveryId = paramJSONObject.optString("delivery_id");
      this.startTime = paramJSONObject.optLong("start_time");
      this.expireTime = paramJSONObject.optLong("expire_time");
      this.statusDesc = paramJSONObject.optString("status_desc");
      JSONObject localJSONObject = paramJSONObject.optJSONObject("item");
      this.itemJson = localJSONObject.toString();
      this.itemName = localJSONObject.optString("name");
      this.price = localJSONObject.optInt("price");
      localJSONObject = paramJSONObject.optJSONObject("product");
      this.productJson = localJSONObject.toString();
      parseProductJson(localJSONObject);
      localJSONObject = paramJSONObject.optJSONObject("address");
      this.addressJson = localJSONObject.toString();
      if (localJSONObject != null) {
        parseAddressJson(localJSONObject);
      }
      this.memo = paramJSONObject.optString("memo");
      return;
      bool = false;
    }
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public void setAddressJson(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.addressJson = paramString;
    try
    {
      parseAddressJson(new JSONObject(this.addressJson));
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setCount(int paramInt)
  {
    this.count = paramInt;
  }
  
  public void setDeliveryId(String paramString)
  {
    this.deliveryId = paramString;
  }
  
  public void setDetailImageUrl(ImageInfo[] paramArrayOfImageInfo)
  {
    this.detailImageUrl = paramArrayOfImageInfo;
  }
  
  public void setDetailTitle(String paramString)
  {
    this.detailTitle = paramString;
  }
  
  public void setExpireTime(long paramLong)
  {
    this.expireTime = paramLong;
  }
  
  public void setItemJson(String paramString)
  {
    this.itemJson = paramString;
    try
    {
      paramString = new JSONObject(paramString);
      this.itemName = paramString.optString("name");
      this.price = paramString.optInt("price");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setItemName(String paramString)
  {
    this.itemName = paramString;
  }
  
  public void setMemo(String paramString)
  {
    this.memo = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setOrderId(String paramString)
  {
    this.orderId = paramString;
  }
  
  public void setPhone(String paramString)
  {
    this.phone = paramString;
  }
  
  public void setPrice(int paramInt)
  {
    this.price = paramInt;
  }
  
  public void setPrivate(boolean paramBoolean)
  {
    this.isPrivate = paramBoolean;
  }
  
  public void setProductId(int paramInt)
  {
    this.productId = paramInt;
  }
  
  public void setProductJson(String paramString)
  {
    this.productJson = paramString;
    try
    {
      parseProductJson(new JSONObject(this.productJson));
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setShowSellOpBtn(boolean paramBoolean)
  {
    this.isShowSellOpBtn = paramBoolean;
  }
  
  public void setStartTime(long paramLong)
  {
    this.startTime = paramLong;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public void setStatusDesc(String paramString)
  {
    this.statusDesc = paramString;
  }
  
  public void setZone(String paramString)
  {
    this.zone = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.orderId);
    paramParcel.writeInt(this.count);
    if (this.isPrivate) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.status);
      paramParcel.writeString(this.statusDesc);
      paramParcel.writeString(this.deliveryId);
      paramParcel.writeLong(this.startTime);
      paramParcel.writeLong(this.expireTime);
      paramParcel.writeString(this.itemJson);
      paramParcel.writeString(this.productJson);
      paramParcel.writeString(this.addressJson);
      paramParcel.writeString(this.memo);
      return;
    }
  }
  
  public class ImageInfo
  {
    public int height;
    public String url;
    public int width;
    
    public ImageInfo() {}
  }
  
  public static abstract interface OnOrderOpListener
  {
    public abstract void onCloseOrderSuccess(int paramInt);
    
    public abstract void onConfirmSuccess(int paramInt);
    
    public abstract void onDelOrderSuccess(int paramInt);
  }
  
  public static abstract interface OnPayListener
  {
    public abstract void onPayResult(String paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\model\mall\Order.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */