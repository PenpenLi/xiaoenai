package com.xiaoenai.app.classes.street.model;

import com.xiaoenai.app.annotation.json.JsonParser;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="Id", b="id"), @com.xiaoenai.app.annotation.json.JsonElement(a="Comment", b="top_comment"), @com.xiaoenai.app.annotation.json.JsonElement(a="SoldDesc", b="info_sold_desc"), @com.xiaoenai.app.annotation.json.JsonElement(a="OrderLimit", b="order_limit"), @com.xiaoenai.app.annotation.json.JsonElement(a="Title", b="title"), @com.xiaoenai.app.annotation.json.JsonElement(a="OnlineStatus", b="online_status"), @com.xiaoenai.app.annotation.json.JsonElement(a="Arguments", b="arguments"), @com.xiaoenai.app.annotation.json.JsonElement(a="CloseTime", b="close_time"), @com.xiaoenai.app.annotation.json.JsonElement(a="CommentsCount", b="comments_count"), @com.xiaoenai.app.annotation.json.JsonElement(a="Desc", b="desc"), @com.xiaoenai.app.annotation.json.JsonElement(a="DetailPage", b="detail_page"), @com.xiaoenai.app.annotation.json.JsonElement(a="Favor", b="favor"), @com.xiaoenai.app.annotation.json.JsonElement(a="Guarantees", b="guarantees"), @com.xiaoenai.app.annotation.json.JsonElement(a="ImageUrls", b="image_urls"), @com.xiaoenai.app.annotation.json.JsonElement(a="OrderNotiDesc", b="order_noti_desc"), @com.xiaoenai.app.annotation.json.JsonElement(a="OrderNotiTs", b="order_noti_ts"), @com.xiaoenai.app.annotation.json.JsonElement(a="Price", b="price"), @com.xiaoenai.app.annotation.json.JsonElement(a="RushId", b="rush_id"), @com.xiaoenai.app.annotation.json.JsonElement(a="RushPrice", b="rush_price"), @com.xiaoenai.app.annotation.json.JsonElement(a="SellingTime", b="selling_time"), @com.xiaoenai.app.annotation.json.JsonElement(a="SkuProps", b="sku_props"), @com.xiaoenai.app.annotation.json.JsonElement(a="Skus", b="skus"), @com.xiaoenai.app.annotation.json.JsonElement(a="Status", b="status"), @com.xiaoenai.app.annotation.json.JsonElement(a="SubStatus", b="sub_status"), @com.xiaoenai.app.annotation.json.JsonElement(a="SubStatusDesc", b="sub_status_desc"), @com.xiaoenai.app.annotation.json.JsonElement(a="TotalStock", b="store_count"), @com.xiaoenai.app.annotation.json.JsonElement(a="TotalStockDesc", b="store_count_desc")})
public class ProductInfo
  extends com.xiaoenai.app.annotation.json.a
{
  private Argument[] arguments;
  private long close_time;
  private Comment comment;
  private int comments_count = 0;
  private String data = "";
  private String desc;
  private String detail_page;
  private int favor = 0;
  private String[] guarantees;
  private int id;
  private ImageInfo[] image_urls;
  private boolean online_status = false;
  private int orderLimit = 0;
  private String order_noti_desc;
  private long order_noti_ts;
  private int price;
  private int rushId;
  private int rush_price;
  private long selling_time;
  private HashMap<String, Sku> skuHashMap = new HashMap();
  private HashMap<String, SkuProp> skuPropHashMap = new HashMap();
  private SkuProp[] sku_props;
  private Sku[] skus;
  private SoldDesc sold_desc;
  private int status;
  private int sub_status;
  private String sub_status_desc;
  private String title;
  private int totalStock = 0;
  private String totalStockDesc = "";
  
  public ProductInfo()
  {
    this.sold_desc = new SoldDesc();
  }
  
  public ProductInfo(String paramString)
  {
    this.data = paramString;
    try
    {
      fromJson(ProductInfo.class, new JSONObject(paramString), this);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public ProductInfo(JSONObject paramJSONObject)
  {
    this.sold_desc = new SoldDesc();
    this.data = paramJSONObject.toString();
    try
    {
      fromJson(ProductInfo.class, paramJSONObject, this);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public Argument[] getArguments()
  {
    return this.arguments;
  }
  
  public long getCloseTime()
  {
    return this.close_time;
  }
  
  public Comment getComment()
  {
    return this.comment;
  }
  
  public int getCommentsCount()
  {
    return this.comments_count;
  }
  
  public String getData()
  {
    return this.data;
  }
  
  public String getDesc()
  {
    return this.desc;
  }
  
  public String getDetailPage()
  {
    return this.detail_page;
  }
  
  public Boolean getFavor()
  {
    boolean bool = true;
    if (1 == this.favor) {}
    for (;;)
    {
      return Boolean.valueOf(bool);
      bool = false;
    }
  }
  
  public String[] getGuarantees()
  {
    return this.guarantees;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public ImageInfo[] getImageUrl()
  {
    return this.image_urls;
  }
  
  public Boolean getIsRush()
  {
    if (this.rushId > 0) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  public boolean getOnlineStatus()
  {
    return this.online_status;
  }
  
  public int getOrderLimit()
  {
    return this.orderLimit;
  }
  
  public String getOrderNotiDesc()
  {
    return this.order_noti_desc;
  }
  
  public long getOrderNotiTs()
  {
    return this.order_noti_ts;
  }
  
  public int getPrice()
  {
    return this.price;
  }
  
  public int getRushId()
  {
    return this.rushId;
  }
  
  public int getRushPrice()
  {
    return this.rush_price;
  }
  
  public long getSellingTime()
  {
    return this.selling_time;
  }
  
  public HashMap<String, Sku> getSkuHashMap()
  {
    return this.skuHashMap;
  }
  
  public HashMap<String, SkuProp> getSkuPropHashMap()
  {
    return this.skuPropHashMap;
  }
  
  public SkuProp[] getSkuProps()
  {
    return this.sku_props;
  }
  
  public Sku[] getSkus()
  {
    return this.skus;
  }
  
  public SoldDesc getSoldDesc()
  {
    return this.sold_desc;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public int getSubState()
  {
    return this.sub_status;
  }
  
  public int getSubStatus()
  {
    return this.sub_status;
  }
  
  public String getSubStatusDesc()
  {
    return this.sub_status_desc;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public int getTotalStock()
  {
    return this.totalStock;
  }
  
  public String getTotalStockDesc()
  {
    return this.totalStockDesc;
  }
  
  public void setArguments(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      Argument[] arrayOfArgument = new Argument[paramJSONArray.length()];
      int i = 0;
      while (i < paramJSONArray.length())
      {
        arrayOfArgument[i] = new Argument(paramJSONArray.optJSONObject(i));
        i += 1;
      }
      this.arguments = arrayOfArgument;
    }
  }
  
  public void setCloseTime(long paramLong)
  {
    this.close_time = paramLong;
  }
  
  public void setComment(JSONObject paramJSONObject)
  {
    com.xiaoenai.app.utils.f.a.c("setComment = {}", new Object[] { paramJSONObject });
    if (paramJSONObject != null) {
      this.comment = new Comment(paramJSONObject);
    }
  }
  
  public void setCommentsCount(int paramInt)
  {
    this.comments_count = paramInt;
  }
  
  public void setData(JSONObject paramJSONObject)
  {
    this.data = paramJSONObject.toString();
    try
    {
      fromJson(ProductInfo.class, paramJSONObject, this);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public void setDesc(String paramString)
  {
    this.desc = paramString;
  }
  
  public void setDetailPage(String paramString)
  {
    this.detail_page = paramString;
  }
  
  public void setFavor(int paramInt)
  {
    this.favor = paramInt;
  }
  
  public void setGuarantees(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      String[] arrayOfString = new String[paramJSONArray.length()];
      int i = 0;
      while (i < paramJSONArray.length())
      {
        arrayOfString[i] = paramJSONArray.optString(i);
        i += 1;
      }
      this.guarantees = arrayOfString;
    }
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setImageUrls(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      ImageInfo[] arrayOfImageInfo = new ImageInfo[paramJSONArray.length()];
      int i = 0;
      while (i < paramJSONArray.length())
      {
        arrayOfImageInfo[i] = new ImageInfo(paramJSONArray.optJSONObject(i));
        i += 1;
      }
      this.image_urls = arrayOfImageInfo;
    }
  }
  
  public void setOnlineStatus(int paramInt)
  {
    if (paramInt == 0)
    {
      this.online_status = true;
      return;
    }
    this.online_status = false;
  }
  
  public void setOrderLimit(int paramInt)
  {
    this.orderLimit = paramInt;
  }
  
  public void setOrderNotiDesc(String paramString)
  {
    this.order_noti_desc = paramString;
  }
  
  public void setOrderNotiTs(long paramLong)
  {
    this.order_noti_ts = paramLong;
  }
  
  public void setPrice(int paramInt)
  {
    this.price = paramInt;
  }
  
  public void setRushId(int paramInt)
  {
    this.rushId = paramInt;
  }
  
  public void setRushPrice(int paramInt)
  {
    this.rush_price = paramInt;
  }
  
  public void setSellingTime(long paramLong)
  {
    this.selling_time = paramLong;
  }
  
  public void setSkuProps(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      SkuProp[] arrayOfSkuProp = new SkuProp[paramJSONArray.length()];
      int i = 0;
      while (i < paramJSONArray.length())
      {
        SkuProp localSkuProp = new SkuProp(paramJSONArray.optJSONObject(i));
        arrayOfSkuProp[i] = localSkuProp;
        this.skuPropHashMap.put(localSkuProp.getName(), localSkuProp);
        i += 1;
      }
      this.sku_props = arrayOfSkuProp;
    }
  }
  
  public void setSkus(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      Sku[] arrayOfSku = new Sku[paramJSONArray.length()];
      int i = 0;
      while (i < paramJSONArray.length())
      {
        Sku localSku = new Sku(paramJSONArray.optJSONObject(i));
        arrayOfSku[i] = localSku;
        this.skuHashMap.put(localSku.getKey(), localSku);
        i += 1;
      }
      this.skus = arrayOfSku;
    }
  }
  
  public void setSoldDesc(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      this.sold_desc = new SoldDesc(paramJSONObject);
    }
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public void setSubState(int paramInt)
  {
    this.sub_status = paramInt;
  }
  
  public void setSubStatus(int paramInt)
  {
    this.sub_status = paramInt;
  }
  
  public void setSubStatusDesc(String paramString)
  {
    com.xiaoenai.app.utils.f.a.c("sub_status_desc = {}", new Object[] { paramString });
    this.sub_status_desc = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setTotalStock(int paramInt)
  {
    this.totalStock = paramInt;
  }
  
  public void setTotalStockDesc(String paramString)
  {
    this.totalStockDesc = paramString;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\model\ProductInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */