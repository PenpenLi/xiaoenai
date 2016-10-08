package com.xiaoenai.app.classes.street.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xiaoenai.app.annotation.json.JsonParser;
import com.xiaoenai.app.annotation.json.a;
import org.json.JSONObject;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="Delivery", b="delivery"), @com.xiaoenai.app.annotation.json.JsonElement(a="Score", b="score"), @com.xiaoenai.app.annotation.json.JsonElement(a="AfterSale", b="after_sale"), @com.xiaoenai.app.annotation.json.JsonElement(a="Payment", b="payment"), @com.xiaoenai.app.annotation.json.JsonElement(a="WaitingDelivery", b="waiting_delivery")})
public class OrderCount
  extends a
  implements Parcelable
{
  public static final Parcelable.Creator<OrderCount> CREATOR = new OrderCount.1();
  private int after_sale;
  private int delivery;
  private int payment;
  private int score;
  private int waiting_delivery;
  
  public OrderCount() {}
  
  public OrderCount(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.delivery = paramInt2;
    this.score = paramInt3;
    this.after_sale = paramInt4;
    this.payment = paramInt5;
    this.waiting_delivery = paramInt1;
  }
  
  protected OrderCount(Parcel paramParcel)
  {
    this.score = paramParcel.readInt();
    this.after_sale = paramParcel.readInt();
    this.payment = paramParcel.readInt();
    this.waiting_delivery = paramParcel.readInt();
    this.delivery = paramParcel.readInt();
  }
  
  public OrderCount(JSONObject paramJSONObject)
  {
    try
    {
      fromJson(OrderCount.class, paramJSONObject, this);
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
  
  public int getAfterSale()
  {
    return this.after_sale;
  }
  
  public int getDelivery()
  {
    return this.delivery;
  }
  
  public int getPayment()
  {
    return this.payment;
  }
  
  public int getScore()
  {
    return this.score;
  }
  
  public int getWaitingDelivery()
  {
    return this.waiting_delivery;
  }
  
  public void setAfterSale(int paramInt)
  {
    this.after_sale = paramInt;
  }
  
  public void setDelivery(int paramInt)
  {
    this.delivery = paramInt;
  }
  
  public void setPayment(int paramInt)
  {
    this.payment = paramInt;
  }
  
  public void setScore(int paramInt)
  {
    this.score = paramInt;
  }
  
  public void setWaitingDelivery(int paramInt)
  {
    this.waiting_delivery = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.score);
    paramParcel.writeInt(this.after_sale);
    paramParcel.writeInt(this.payment);
    paramParcel.writeInt(this.waiting_delivery);
    paramParcel.writeInt(this.delivery);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\model\OrderCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */