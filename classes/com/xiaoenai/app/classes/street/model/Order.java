package com.xiaoenai.app.classes.street.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xiaoenai.app.annotation.json.JsonParser;
import com.xiaoenai.app.annotation.json.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="isPrivate", b="is_private"), @com.xiaoenai.app.annotation.json.JsonElement(a="state", b="status"), @com.xiaoenai.app.annotation.json.JsonElement(a="createdTime", b="created_time"), @com.xiaoenai.app.annotation.json.JsonElement(a="expireTime", b="expire_time"), @com.xiaoenai.app.annotation.json.JsonElement(a="sku", b="sku"), @com.xiaoenai.app.annotation.json.JsonElement(a="id", b="id"), @com.xiaoenai.app.annotation.json.JsonElement(a="stateDesc", b="status_desc"), @com.xiaoenai.app.annotation.json.JsonElement(a="memo", b="memo"), @com.xiaoenai.app.annotation.json.JsonElement(a="count", b="count"), @com.xiaoenai.app.annotation.json.JsonElement(a="product", b="product"), @com.xiaoenai.app.annotation.json.JsonElement(a="contact", b="contact"), @com.xiaoenai.app.annotation.json.JsonElement(a="isAfterSale", b="is_aftersale"), @com.xiaoenai.app.annotation.json.JsonElement(a="aftersale", b="aftersale"), @com.xiaoenai.app.annotation.json.JsonElement(a="serviceScore", b="service_score"), @com.xiaoenai.app.annotation.json.JsonElement(a="deliveryScore", b="delivery_score"), @com.xiaoenai.app.annotation.json.JsonElement(a="sendScore", b="send_score")})
public class Order
  extends a
  implements Parcelable
{
  public static final Parcelable.Creator<Order> CREATOR = new Order.1();
  public static final int ORDER_CLOSED = 4;
  public static final int ORDER_NO_PAY = 0;
  public static final int ORDER_PAY_ACTION = 153;
  public static final int ORDER_RECEIVED = 3;
  public static final int ORDER_SENDED = 2;
  public static final int ORDER_WAITING_SEND = 1;
  private AfterSale afterSale;
  private Contact contact;
  private int count;
  private long created_time;
  private int deliveryScore;
  private long expire_time;
  private long id;
  private boolean isAfterSale = false;
  private boolean isChecked = false;
  private boolean isShowAfterSale = false;
  private boolean isShowCheckBtn = false;
  private boolean isShowSellOpBtn = false;
  private int is_private;
  private String memo = "";
  private Product product;
  private int sendScore;
  private int serviceScore;
  private Sku sku;
  private int state;
  private String state_desc = "";
  
  public Order() {}
  
  protected Order(Parcel paramParcel)
  {
    setStateDesc(paramParcel.readString());
    setMemo(paramParcel.readString());
    setCount(paramParcel.readInt());
    String str = paramParcel.readString();
    this.product = new Product();
    try
    {
      this.product.fromJson(Product.class, new JSONObject(str), this.product);
      setProduct(this.product);
      str = paramParcel.readString();
      this.contact = new Contact();
    }
    catch (Exception localException3)
    {
      try
      {
        this.contact.fromJson(Contact.class, new JSONObject(str), this.contact);
        setContact(this.contact);
        setId(paramParcel.readLong());
        setState(paramParcel.readInt());
        setCreatedTime(paramParcel.readLong());
        setExpireTime(paramParcel.readLong());
        str = paramParcel.readString();
        this.sku = new Sku();
      }
      catch (Exception localException3)
      {
        try
        {
          this.sku.fromJson(Sku.class, new JSONObject(str), this.sku);
          setSku(this.sku);
          setIsPrivate(paramParcel.readInt());
          if (paramParcel.readInt() == 1)
          {
            bool1 = true;
            setShowSellOpBtn(bool1);
            if (paramParcel.readInt() != 1) {
              break label416;
            }
            bool1 = true;
            setIsShowCheckBtn(bool1);
            if (paramParcel.readInt() != 1) {
              break label421;
            }
            bool1 = true;
            setIsChecked(bool1);
            setIsAfterSale(paramParcel.readInt());
            str = paramParcel.readString();
            if ((str != null) && (!str.equals(""))) {
              this.afterSale = new AfterSale();
            }
          }
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              this.afterSale.fromJson(AfterSale.class, new JSONObject(str), this.afterSale);
              if (paramParcel.readInt() != 1) {
                break;
              }
              bool1 = bool2;
              setIsShowAfterSale(bool1);
              setServiceScore(paramParcel.readInt());
              setDeliveryScore(paramParcel.readInt());
              setSendScore(paramParcel.readInt());
              return;
              localException1 = localException1;
              localException1.printStackTrace();
              continue;
              localException2 = localException2;
              localException2.printStackTrace();
              continue;
              localException3 = localException3;
              localException3.printStackTrace();
              continue;
              bool1 = false;
              continue;
              label416:
              bool1 = false;
            }
            label421:
            bool1 = false;
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              localException4.printStackTrace();
              continue;
              boolean bool1 = false;
            }
          }
        }
      }
    }
  }
  
  public Order(Product paramProduct, Contact paramContact, long paramLong1, String paramString1, String paramString2, int paramInt1, Sku paramSku, int paramInt2, int paramInt3, long paramLong2, long paramLong3)
  {
    this.state = paramInt3;
    this.created_time = paramLong2;
    this.expire_time = paramLong3;
    this.sku = paramSku;
    this.is_private = paramInt2;
    this.state_desc = paramString1;
    this.memo = paramString2;
    this.count = paramInt1;
    this.product = paramProduct;
    this.contact = paramContact;
    this.id = paramLong1;
  }
  
  public Order(JSONObject paramJSONObject)
  {
    try
    {
      fromJson(Order.class, paramJSONObject, this);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
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
  
  public void aftersaleJsonTransformer(Object paramObject)
  {
    if (paramObject != null)
    {
      paramObject = (JSONObject)paramObject;
      this.afterSale = new AfterSale();
    }
    try
    {
      this.afterSale.fromJson(AfterSale.class, (JSONObject)paramObject, this.afterSale);
      setAfterSale(this.afterSale);
      return;
    }
    catch (Exception paramObject)
    {
      ((Exception)paramObject).printStackTrace();
    }
  }
  
  public void contactJsonTransformer(Object paramObject)
  {
    paramObject = (JSONObject)paramObject;
    this.contact = new Contact();
    try
    {
      this.contact.fromJson(Contact.class, (JSONObject)paramObject, this.contact);
      return;
    }
    catch (Exception paramObject)
    {
      ((Exception)paramObject).printStackTrace();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public AfterSale getAfterSale()
  {
    return this.afterSale;
  }
  
  public Contact getContact()
  {
    return this.contact;
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  public long getCreatedTime()
  {
    return this.created_time;
  }
  
  public int getDeliveryScore()
  {
    return this.deliveryScore;
  }
  
  public long getExpireTime()
  {
    return this.expire_time;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public boolean getIsPrivate()
  {
    return this.is_private == 1;
  }
  
  public String getMemo()
  {
    return this.memo;
  }
  
  public Product getProduct()
  {
    return this.product;
  }
  
  public int getSendScore()
  {
    return this.sendScore;
  }
  
  public int getServiceScore()
  {
    return this.serviceScore;
  }
  
  public Sku getSku()
  {
    return this.sku;
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public String getStateDesc()
  {
    return this.state_desc;
  }
  
  public boolean isAfterSale()
  {
    return this.isAfterSale;
  }
  
  public boolean isChecked()
  {
    return this.isChecked;
  }
  
  public boolean isShowAfterSale()
  {
    return this.isShowAfterSale;
  }
  
  public boolean isShowCheckBtn()
  {
    return this.isShowCheckBtn;
  }
  
  public boolean isShowSellOpBtn()
  {
    return this.isShowSellOpBtn;
  }
  
  public void parseOrder(JSONObject paramJSONObject)
  {
    try
    {
      fromJson(Order.class, paramJSONObject, this);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public void productJsonTransformer(Object paramObject)
  {
    if ((paramObject instanceof String)) {}
    for (;;)
    {
      try
      {
        paramObject = new JSONObject((String)paramObject);
        this.product = new Product();
      }
      catch (JSONException paramObject)
      {
        try
        {
          this.product.fromJson(Product.class, (JSONObject)paramObject, this.product);
          return;
        }
        catch (Exception paramObject)
        {
          ((Exception)paramObject).printStackTrace();
          return;
        }
        paramObject = paramObject;
        ((JSONException)paramObject).printStackTrace();
        paramObject = null;
        continue;
      }
      if ((paramObject instanceof JSONObject)) {
        paramObject = (JSONObject)paramObject;
      } else {
        paramObject = null;
      }
    }
  }
  
  public void setAfterSale(AfterSale paramAfterSale)
  {
    this.afterSale = paramAfterSale;
  }
  
  public void setContact(Contact paramContact)
  {
    this.contact = paramContact;
  }
  
  public void setCount(int paramInt)
  {
    this.count = paramInt;
  }
  
  public void setCreatedTime(long paramLong)
  {
    this.created_time = paramLong;
  }
  
  public void setDeliveryScore(int paramInt)
  {
    this.deliveryScore = paramInt;
  }
  
  public void setExpireTime(long paramLong)
  {
    this.expire_time = paramLong;
  }
  
  public void setId(long paramLong)
  {
    this.id = paramLong;
  }
  
  public void setIsAfterSale(int paramInt)
  {
    boolean bool = true;
    if (paramInt == 1) {}
    for (;;)
    {
      this.isAfterSale = bool;
      return;
      bool = false;
    }
  }
  
  public void setIsChecked(boolean paramBoolean)
  {
    this.isChecked = paramBoolean;
  }
  
  public void setIsPrivate(int paramInt)
  {
    this.is_private = paramInt;
  }
  
  public void setIsShowAfterSale(boolean paramBoolean)
  {
    this.isShowAfterSale = paramBoolean;
  }
  
  public void setIsShowCheckBtn(boolean paramBoolean)
  {
    this.isShowCheckBtn = paramBoolean;
  }
  
  public void setMemo(String paramString)
  {
    this.memo = paramString;
  }
  
  public void setProduct(Product paramProduct)
  {
    this.product = paramProduct;
  }
  
  public void setSendScore(int paramInt)
  {
    this.sendScore = paramInt;
  }
  
  public void setServiceScore(int paramInt)
  {
    this.serviceScore = paramInt;
  }
  
  public void setShowSellOpBtn(boolean paramBoolean)
  {
    this.isShowSellOpBtn = paramBoolean;
  }
  
  public void setSku(Sku paramSku)
  {
    this.sku = paramSku;
  }
  
  public void setState(int paramInt)
  {
    this.state = paramInt;
  }
  
  public void setStateDesc(String paramString)
  {
    this.state_desc = paramString;
  }
  
  public void skuJsonTransformer(Object paramObject)
  {
    paramObject = (JSONObject)paramObject;
    this.sku = new Sku();
    try
    {
      this.sku.fromJson(Sku.class, (JSONObject)paramObject, this.sku);
      return;
    }
    catch (Exception paramObject)
    {
      ((Exception)paramObject).printStackTrace();
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.state_desc);
    paramParcel.writeString(this.memo);
    paramParcel.writeInt(this.count);
    try
    {
      paramParcel.writeString(this.product.toJson(this.product, Product.class).toString());
    }
    catch (Exception localException3)
    {
      try
      {
        paramParcel.writeString(this.contact.toJson(this.contact, Contact.class).toString());
        paramParcel.writeLong(this.id);
        paramParcel.writeInt(this.state);
        paramParcel.writeLong(this.created_time);
        paramParcel.writeLong(this.expire_time);
      }
      catch (Exception localException3)
      {
        try
        {
          paramParcel.writeString(this.sku.toJson(this.sku, Sku.class).toString());
          paramParcel.writeInt(this.is_private);
          if (this.isShowSellOpBtn)
          {
            paramInt = 1;
            paramParcel.writeInt(paramInt);
            if (!this.isShowCheckBtn) {
              break label279;
            }
            paramInt = 1;
            paramParcel.writeInt(paramInt);
            if (!this.isChecked) {
              break label284;
            }
            paramInt = 1;
            paramParcel.writeInt(paramInt);
            if (!this.isAfterSale) {
              break label289;
            }
            paramInt = 1;
            paramParcel.writeInt(paramInt);
            if (this.afterSale == null) {
              break label302;
            }
          }
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            try
            {
              paramParcel.writeString(this.afterSale.toJson(this.afterSale, AfterSale.class).toString());
              if (!this.isShowAfterSale) {
                break label311;
              }
              paramInt = i;
              paramParcel.writeInt(paramInt);
              paramParcel.writeInt(this.serviceScore);
              paramParcel.writeInt(this.deliveryScore);
              paramParcel.writeInt(this.sendScore);
              return;
              localException1 = localException1;
              localException1.printStackTrace();
              continue;
              localException2 = localException2;
              localException2.printStackTrace();
              continue;
              localException3 = localException3;
              localException3.printStackTrace();
              continue;
              paramInt = 0;
              continue;
              label279:
              paramInt = 0;
              continue;
              label284:
              paramInt = 0;
              continue;
              label289:
              paramInt = 0;
            }
            catch (Exception localException4)
            {
              localException4.printStackTrace();
              continue;
            }
            label302:
            paramParcel.writeString("");
            continue;
            label311:
            paramInt = 0;
          }
        }
      }
    }
  }
  
  public static abstract interface OnOrderOpListener
  {
    public abstract void onCancelOrderSuccess(int paramInt);
    
    public abstract void onCloseOrderSuccess(int paramInt);
    
    public abstract void onConfirmSuccess(int paramInt);
    
    public abstract void onDelOrderSuccess(int paramInt);
  }
  
  public static abstract interface OnPayListener
  {
    public abstract void onPayResult(String paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\model\Order.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */