package com.xiaoenai.app.model.street;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xiaoenai.app.utils.f.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Product
  implements Parcelable
{
  public static final Parcelable.Creator<Product> CREATOR = new Product.1();
  private long mCloseTime = 0L;
  private int mCtlOnlyCount = 0;
  private String mData = "";
  private int mId = 0;
  private int mLimitCount = 0;
  private ProductImage mListImage = new ProductImage();
  private long mPrice = 0L;
  private int mProductState = 0;
  private int mSellingCount = 0;
  private long mSellingTime = 0L;
  private int mStoreCount = 0;
  private String mTitle = "";
  
  public Product() {}
  
  protected Product(Parcel paramParcel)
  {
    this.mId = paramParcel.readInt();
    this.mTitle = paramParcel.readString();
    this.mCtlOnlyCount = paramParcel.readInt();
    this.mSellingCount = paramParcel.readInt();
    this.mLimitCount = paramParcel.readInt();
    this.mStoreCount = paramParcel.readInt();
    this.mPrice = paramParcel.readLong();
    this.mSellingTime = paramParcel.readLong();
    this.mCloseTime = paramParcel.readLong();
    this.mProductState = paramParcel.readInt();
    this.mData = paramParcel.readString();
  }
  
  public Product(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.mData = paramString;
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
  
  public Product(JSONObject paramJSONObject)
  {
    this.mData = paramJSONObject.toString();
    try
    {
      parse(paramJSONObject);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public static List<Product> parseArray(JSONObject paramJSONObject)
  {
    a.c("data = {}", new Object[] { paramJSONObject });
    ArrayList localArrayList = new ArrayList();
    paramJSONObject = paramJSONObject.getJSONArray("list");
    int i = 0;
    while (i < paramJSONObject.length())
    {
      localArrayList.add(new Product(paramJSONObject.getJSONObject(i)));
      i += 1;
    }
    a.c("productList = {}", new Object[] { Integer.valueOf(localArrayList.size()) });
    return localArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long getCloseTime()
  {
    return this.mCloseTime;
  }
  
  public int getCtlOnlyCount()
  {
    return this.mCtlOnlyCount;
  }
  
  public String getDate()
  {
    return this.mData;
  }
  
  public int getId()
  {
    return this.mId;
  }
  
  public ProductImage getImageUrl()
  {
    return this.mListImage;
  }
  
  public int getLimitCount()
  {
    return this.mLimitCount;
  }
  
  public long getPrice()
  {
    return this.mPrice;
  }
  
  public int getProductState()
  {
    return this.mProductState;
  }
  
  public int getSellingCount()
  {
    return this.mSellingCount;
  }
  
  public long getSellingTime()
  {
    return this.mSellingTime;
  }
  
  public int getStoreCount()
  {
    return this.mStoreCount;
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public void parse(JSONObject paramJSONObject)
  {
    this.mId = paramJSONObject.getInt("id");
    this.mTitle = paramJSONObject.getString("list_title");
    JSONObject localJSONObject = new JSONObject(paramJSONObject.getString("list_image_url"));
    if (localJSONObject != null)
    {
      this.mListImage.mUrl = localJSONObject.getString("url");
      this.mListImage.mWidth = localJSONObject.getInt("width");
      this.mListImage.mHeight = localJSONObject.getInt("height");
    }
    this.mCtlOnlyCount = paramJSONObject.getInt("ctl_only_count");
    this.mSellingCount = paramJSONObject.getInt("selling_count");
    this.mLimitCount = paramJSONObject.getInt("limit_count");
    this.mStoreCount = paramJSONObject.getInt("store_count");
    this.mPrice = paramJSONObject.getLong("price");
    this.mSellingTime = paramJSONObject.getLong("selling_time");
    this.mCloseTime = paramJSONObject.getLong("close_time");
    this.mProductState = paramJSONObject.getInt("product_status");
  }
  
  public void setId(int paramInt)
  {
    this.mId = paramInt;
  }
  
  public void setProductState(int paramInt)
  {
    this.mProductState = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mId);
    paramParcel.writeString(this.mTitle);
    paramParcel.writeInt(this.mCtlOnlyCount);
    paramParcel.writeInt(this.mSellingCount);
    paramParcel.writeInt(this.mLimitCount);
    paramParcel.writeInt(this.mStoreCount);
    paramParcel.writeLong(this.mPrice);
    paramParcel.writeLong(this.mSellingTime);
    paramParcel.writeLong(this.mCloseTime);
    paramParcel.writeInt(this.mProductState);
    paramParcel.writeString(this.mData);
  }
  
  public class ProductImage
  {
    public int mHeight = 0;
    public String mUrl = "";
    public int mWidth = 0;
    
    public ProductImage() {}
    
    public ProductImage(String paramString, int paramInt1, int paramInt2)
    {
      this.mUrl = paramString;
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\model\street\Product.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */