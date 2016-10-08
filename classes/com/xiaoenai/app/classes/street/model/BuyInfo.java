package com.xiaoenai.app.classes.street.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xiaoenai.app.annotation.json.JsonParser;
import com.xiaoenai.app.annotation.json.a;
import org.json.JSONObject;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="Price", b="price"), @com.xiaoenai.app.annotation.json.JsonElement(a="Count", b="count"), @com.xiaoenai.app.annotation.json.JsonElement(a="Memo", b="memo"), @com.xiaoenai.app.annotation.json.JsonElement(a="RushId", b="rush_id"), @com.xiaoenai.app.annotation.json.JsonElement(a="CartId", b="cart_id"), @com.xiaoenai.app.annotation.json.JsonElement(a="SkuId", b="sku_id")})
public class BuyInfo
  extends a
  implements Parcelable
{
  public static final Parcelable.Creator<BuyInfo> CREATOR = new BuyInfo.1();
  private int cartId = 0;
  private int count;
  private String memo;
  private int price;
  private int rushId = 0;
  private int sku_id;
  
  public BuyInfo() {}
  
  public BuyInfo(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, int paramInt5)
  {
    this.count = paramInt3;
    this.memo = paramString;
    this.sku_id = paramInt1;
    this.price = paramInt2;
    this.rushId = paramInt4;
    this.cartId = paramInt5;
  }
  
  protected BuyInfo(Parcel paramParcel)
  {
    this.sku_id = paramParcel.readInt();
    this.price = paramParcel.readInt();
    this.count = paramParcel.readInt();
    this.memo = paramParcel.readString();
    this.rushId = paramParcel.readInt();
    this.cartId = paramParcel.readInt();
  }
  
  public BuyInfo(JSONObject paramJSONObject)
  {
    try
    {
      fromJson(BuyInfo.class, paramJSONObject, this);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getCartId()
  {
    return this.cartId;
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  public String getMemo()
  {
    return this.memo;
  }
  
  public int getPrice()
  {
    return this.price;
  }
  
  public int getRushId()
  {
    return this.rushId;
  }
  
  public int getSkuId()
  {
    return this.sku_id;
  }
  
  public void setCartId(int paramInt)
  {
    this.cartId = paramInt;
  }
  
  public void setCount(int paramInt)
  {
    this.count = paramInt;
  }
  
  public void setMemo(String paramString)
  {
    this.memo = paramString;
  }
  
  public void setPrice(int paramInt)
  {
    this.price = paramInt;
  }
  
  public void setRushId(int paramInt)
  {
    this.rushId = paramInt;
  }
  
  public void setSkuId(int paramInt)
  {
    this.sku_id = paramInt;
  }
  
  public JSONObject toJson()
  {
    try
    {
      JSONObject localJSONObject = toJson(this, BuyInfo.class);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.sku_id);
    paramParcel.writeInt(this.price);
    paramParcel.writeInt(this.count);
    paramParcel.writeString(this.memo);
    paramParcel.writeInt(this.rushId);
    paramParcel.writeInt(this.cartId);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\model\BuyInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */