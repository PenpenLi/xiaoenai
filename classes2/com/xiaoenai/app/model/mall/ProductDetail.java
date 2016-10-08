package com.xiaoenai.app.model.mall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.f.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProductDetail
  implements Parcelable
{
  public static final Parcelable.Creator<ProductDetail> CREATOR = new ProductDetail.1();
  public static final String PRODUCT_ID = "product_id";
  private List<String> mArguments = new ArrayList();
  private long mCloseTime = 0L;
  private Comment mComment = new Comment();
  private int mCommentCount = 0;
  private int mCtlOnlyCount = 0;
  private String mDesc = "";
  private List<ProductImage> mDetailImageUrls = new ArrayList();
  private String mDetailPage = "";
  private String mDetailTitle = "";
  private boolean mFavored = false;
  private String[] mFlagArray = null;
  private String mFlags = "";
  private int mId = 0;
  private String mJsonData = null;
  private String mOrderChanceDesc = "";
  private long mPrice = 0L;
  private int mProductStatus = 0;
  private int mProductSubStatus = 0;
  private int mSellingCount = 0;
  private long mSellingTime = 0L;
  private String mShareUrl = "";
  private int mStoreCount = 0;
  private String orderNotiDesc;
  private int orderNotiTs;
  
  public ProductDetail() {}
  
  protected ProductDetail(Parcel paramParcel)
  {
    this.mJsonData = paramParcel.readString();
    try
    {
      parse(new JSONObject(this.mJsonData));
      return;
    }
    catch (JSONException paramParcel)
    {
      paramParcel.printStackTrace();
    }
  }
  
  public ProductDetail(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      this.mJsonData = paramString;
    }
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
  
  public ProductDetail(JSONObject paramJSONObject)
  {
    a.c("======== =data= {}", new Object[] { paramJSONObject });
    this.mJsonData = paramJSONObject.toString();
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
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<String> getArguments()
  {
    return this.mArguments;
  }
  
  public long getCloseTime()
  {
    return this.mCloseTime;
  }
  
  public Comment getComment()
  {
    return this.mComment;
  }
  
  public int getCommentCount()
  {
    return this.mCommentCount;
  }
  
  public int getCtlOnlyCount()
  {
    return this.mCtlOnlyCount;
  }
  
  public String getDesc()
  {
    return this.mDesc;
  }
  
  public List<ProductImage> getDetailImageUrls()
  {
    return this.mDetailImageUrls;
  }
  
  public String getDetailPage()
  {
    return this.mDetailPage;
  }
  
  public String getDetailTitle()
  {
    return this.mDetailTitle;
  }
  
  public boolean getFavored()
  {
    return this.mFavored;
  }
  
  public String[] getFlagArray()
  {
    return this.mFlagArray;
  }
  
  public String getFlags()
  {
    return this.mFlags;
  }
  
  public int getId()
  {
    return this.mId;
  }
  
  public String getJsonData()
  {
    return this.mJsonData;
  }
  
  public String getOrderChanceDesc()
  {
    return this.mOrderChanceDesc;
  }
  
  public String getOrderNotiDesc()
  {
    return this.orderNotiDesc;
  }
  
  public int getOrderNotiTs()
  {
    return this.orderNotiTs;
  }
  
  public long getPrice()
  {
    return this.mPrice;
  }
  
  public int getProductStatus()
  {
    return this.mProductStatus;
  }
  
  public int getProductSubStatus()
  {
    return this.mProductSubStatus;
  }
  
  public int getSellingCount()
  {
    return this.mSellingCount;
  }
  
  public long getSellingTime()
  {
    return this.mSellingTime;
  }
  
  public String getShareUrl()
  {
    return this.mShareUrl;
  }
  
  public int getStoreCount()
  {
    return this.mStoreCount;
  }
  
  public boolean isBookedState()
  {
    int j = getOrderNotiTs();
    int i = j;
    if (j <= 0) {
      i = 600;
    }
    return getSellingTime() - (int)(ak.a() / 1000L) == i;
  }
  
  public boolean isBookingState()
  {
    int j = getOrderNotiTs();
    int i = j;
    if (j <= 0) {
      i = 600;
    }
    return getSellingTime() - (int)(ak.a() / 1000L) > i;
  }
  
  public void parse(JSONObject paramJSONObject)
  {
    int j = 0;
    this.mId = paramJSONObject.optInt("id", 0);
    this.mDetailTitle = paramJSONObject.getString("detail_title");
    this.mDesc = paramJSONObject.optString("desc", "");
    this.mFlags = paramJSONObject.optString("flags", "");
    if (this.mFlags.length() > 0) {
      this.mFlagArray = Pattern.compile(",").split(this.mFlags);
    }
    this.mCtlOnlyCount = paramJSONObject.optInt("ctl_only_count", 0);
    this.mSellingCount = paramJSONObject.optInt("selling_count", 0);
    this.mStoreCount = paramJSONObject.optInt("store_count", 0);
    this.mPrice = paramJSONObject.optLong("price", 0L);
    this.mSellingTime = paramJSONObject.optInt("selling_time");
    this.mCloseTime = paramJSONObject.optInt("close_time", 0);
    this.mProductStatus = paramJSONObject.optInt("product_status", 0);
    this.mProductSubStatus = paramJSONObject.optInt("product_sub_status", 0);
    this.mOrderChanceDesc = paramJSONObject.optString("order_chance_desc");
    this.mFavored = paramJSONObject.optBoolean("favored", false);
    this.mDetailPage = paramJSONObject.optString("detail_page");
    this.mShareUrl = paramJSONObject.optString("share_url", "");
    this.mCommentCount = paramJSONObject.optInt("comment_count", 0);
    this.orderNotiTs = paramJSONObject.optInt("order_noti_ts");
    this.orderNotiDesc = paramJSONObject.optString("order_noti_desc");
    Object localObject1 = paramJSONObject.optJSONObject("comment");
    if (localObject1 != null) {
      this.mComment = new Comment(((JSONObject)localObject1).getString("name"), ((JSONObject)localObject1).getString("couple_photo"), ((JSONObject)localObject1).getString("content"), ((JSONObject)localObject1).getLong("created_at"));
    }
    localObject1 = new JSONArray(paramJSONObject.optString("detail_image_urls"));
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localObject2 = ((JSONArray)localObject1).getJSONObject(i);
        this.mDetailImageUrls.add(new ProductImage(((JSONObject)localObject2).getString("url"), ((JSONObject)localObject2).getInt("width"), ((JSONObject)localObject2).getInt("height")));
        i += 1;
      }
    }
    paramJSONObject = new JSONArray(paramJSONObject.optString("arguments"));
    if (paramJSONObject != null)
    {
      i = j;
      while (i < paramJSONObject.length())
      {
        localObject1 = paramJSONObject.getJSONObject(i);
        localObject2 = ((JSONObject)localObject1).keys();
        if (((Iterator)localObject2).hasNext())
        {
          localObject2 = ((Iterator)localObject2).next().toString();
          ((JSONObject)localObject1).getString((String)localObject2);
          this.mArguments.add((String)localObject2 + "：" + ((JSONObject)localObject1).getString((String)localObject2));
        }
        i += 1;
      }
    }
  }
  
  public void setOrderNotiDesc(String paramString)
  {
    this.orderNotiDesc = paramString;
  }
  
  public void setOrderNotiTs(int paramInt)
  {
    this.orderNotiTs = paramInt;
  }
  
  public void setProductStatus(int paramInt)
  {
    this.mProductStatus = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mJsonData);
  }
  
  public class Comment
  {
    public String mContent = "";
    public String mCouplePhoto = "";
    public long mCreateAt = 0L;
    public String mName = "";
    
    public Comment() {}
    
    public Comment(String paramString1, String paramString2, String paramString3, long paramLong)
    {
      this.mName = paramString1;
      this.mCouplePhoto = paramString2;
      this.mContent = paramString3;
      this.mCreateAt = paramLong;
    }
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


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\model\mall\ProductDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */