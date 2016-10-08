package com.xiaoenai.app.classes.street.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xiaoenai.app.annotation.json.JsonParser;
import com.xiaoenai.app.annotation.json.a;
import org.json.JSONObject;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="id", b="id"), @com.xiaoenai.app.annotation.json.JsonElement(a="key", b="key"), @com.xiaoenai.app.annotation.json.JsonElement(a="ProductId", b="product_id"), @com.xiaoenai.app.annotation.json.JsonElement(a="Quantity", b="quantity"), @com.xiaoenai.app.annotation.json.JsonElement(a="QuantityDesc", b="quantity_desc"), @com.xiaoenai.app.annotation.json.JsonElement(a="Price", b="price"), @com.xiaoenai.app.annotation.json.JsonElement(a="RushId", b="rush_id"), @com.xiaoenai.app.annotation.json.JsonElement(a="RushPrice", b="rush_price")})
public class Sku
  extends a
  implements Parcelable
{
  public static final Parcelable.Creator<Sku> CREATOR = new Sku.1();
  private int id;
  private String key;
  private int price;
  private int productId;
  private int quantity;
  private String quantityDesc = "";
  private int rushId;
  private int rushPrice;
  
  public Sku() {}
  
  public Sku(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, int paramInt4, int paramInt5, int paramInt6)
  {
    this.quantityDesc = paramString2;
    this.price = paramInt4;
    this.id = paramInt1;
    this.key = paramString1;
    this.productId = paramInt2;
    this.quantity = paramInt3;
    this.rushId = paramInt5;
    this.rushPrice = paramInt6;
  }
  
  protected Sku(Parcel paramParcel)
  {
    this.quantity = paramParcel.readInt();
    this.quantityDesc = paramParcel.readString();
    this.price = paramParcel.readInt();
    this.id = paramParcel.readInt();
    this.key = paramParcel.readString();
    this.productId = paramParcel.readInt();
    this.rushId = paramParcel.readInt();
    this.rushPrice = paramParcel.readInt();
  }
  
  public Sku(JSONObject paramJSONObject)
  {
    try
    {
      fromJson(Sku.class, paramJSONObject, this);
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
  
  public int getId()
  {
    return this.id;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public int getPrice()
  {
    return this.price;
  }
  
  public int getProductId()
  {
    return this.productId;
  }
  
  public int getQuantity()
  {
    return this.quantity;
  }
  
  public String getQuantityDesc()
  {
    return this.quantityDesc;
  }
  
  public int getRushId()
  {
    return this.rushId;
  }
  
  public int getRushPrice()
  {
    return this.rushPrice;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setKey(String paramString)
  {
    this.key = paramString;
  }
  
  public void setPrice(int paramInt)
  {
    this.price = paramInt;
  }
  
  public void setProductId(int paramInt)
  {
    this.productId = paramInt;
  }
  
  public void setQuantity(int paramInt)
  {
    this.quantity = paramInt;
  }
  
  public void setQuantityDesc(String paramString)
  {
    this.quantityDesc = paramString;
  }
  
  public void setRushId(int paramInt)
  {
    this.rushId = paramInt;
  }
  
  public void setRushPrice(int paramInt)
  {
    this.rushPrice = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.id);
    paramParcel.writeString(this.key);
    paramParcel.writeInt(this.productId);
    paramParcel.writeInt(this.quantity);
    paramParcel.writeString(this.quantityDesc);
    paramParcel.writeInt(this.price);
    paramParcel.writeInt(this.rushId);
    paramParcel.writeInt(this.rushPrice);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\model\Sku.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */