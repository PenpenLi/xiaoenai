package com.xiaoenai.app.classes.street.model;

import com.xiaoenai.app.annotation.json.JsonParser;
import com.xiaoenai.app.annotation.json.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="imageUrl", b="image_url"), @com.xiaoenai.app.annotation.json.JsonElement(a="closeTime", b="close_time"), @com.xiaoenai.app.annotation.json.JsonElement(a="id", b="id"), @com.xiaoenai.app.annotation.json.JsonElement(a="price", b="price"), @com.xiaoenai.app.annotation.json.JsonElement(a="isValid", b="is_valid"), @com.xiaoenai.app.annotation.json.JsonElement(a="title", b="title"), @com.xiaoenai.app.annotation.json.JsonElement(a="rushId", b="rush_id"), @com.xiaoenai.app.annotation.json.JsonElement(a="rushPrice", b="rush_price"), @com.xiaoenai.app.annotation.json.JsonElement(a="soldDesc", b="sold_desc")})
public class Product
  extends a
{
  private long closeTime;
  private int id = 0;
  private ImageInfo imageUrl;
  private boolean isSelected = false;
  private int isValid;
  private int price;
  private int rushId;
  private int rushPrice;
  private SoldDesc soldDesc = new SoldDesc();
  private String title;
  
  public Product() {}
  
  public Product(JSONObject paramJSONObject)
  {
    try
    {
      fromJson(Product.class, paramJSONObject, this);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public static ArrayList<Product> getProductList(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        localArrayList.add(new Product(paramJSONArray.optJSONObject(i)));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public long getCloseTime()
  {
    return this.closeTime;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public ImageInfo getImageUrl()
  {
    return this.imageUrl;
  }
  
  public Boolean getIsRush()
  {
    if (this.rushId > 0) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  public Boolean getIsValid()
  {
    if (this.isValid > 0) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
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
    return this.rushPrice;
  }
  
  public SoldDesc getSoldDesc()
  {
    return this.soldDesc;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void imageUrlJsonTransformer(Object paramObject)
  {
    if ((paramObject instanceof JSONObject)) {
      paramObject = (JSONObject)paramObject;
    }
    for (;;)
    {
      this.imageUrl = new ImageInfo();
      do
      {
        try
        {
          this.imageUrl.fromJson(ImageInfo.class, (JSONObject)paramObject, this.imageUrl);
          return;
        }
        catch (Exception paramObject)
        {
          ((Exception)paramObject).printStackTrace();
        }
      } while (!(paramObject instanceof String));
      try
      {
        paramObject = new JSONObject((String)paramObject);
      }
      catch (JSONException paramObject)
      {
        ((JSONException)paramObject).printStackTrace();
        paramObject = null;
      }
    }
  }
  
  public String imageUrlTransformerToJson()
  {
    try
    {
      String str = this.imageUrl.toJson(this.imageUrl, ImageInfo.class).toString();
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public int isRushTransformerToJson()
  {
    if (getIsRush().booleanValue()) {
      return 1;
    }
    return 0;
  }
  
  public boolean isSelected()
  {
    return this.isSelected;
  }
  
  public int isValidTransformerToJson()
  {
    return this.isValid;
  }
  
  public void setCloseTime(long paramLong)
  {
    this.closeTime = paramLong;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setIsValid(int paramInt)
  {
    this.isValid = paramInt;
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
    this.rushPrice = paramInt;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    this.isSelected = paramBoolean;
  }
  
  public void setSoldDesc(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      this.soldDesc = new SoldDesc(paramJSONObject);
    }
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void soldDescJsonTransformer(Object paramObject)
  {
    if ((paramObject instanceof JSONObject)) {
      paramObject = (JSONObject)paramObject;
    }
    for (;;)
    {
      this.soldDesc = new SoldDesc();
      do
      {
        try
        {
          this.soldDesc.fromJson(SoldDesc.class, (JSONObject)paramObject, this.soldDesc);
          return;
        }
        catch (Exception paramObject)
        {
          ((Exception)paramObject).printStackTrace();
        }
      } while (!(paramObject instanceof String));
      try
      {
        paramObject = new JSONObject((String)paramObject);
      }
      catch (JSONException paramObject)
      {
        ((JSONException)paramObject).printStackTrace();
        paramObject = null;
      }
    }
  }
  
  public String soldDescTransformerToJson()
  {
    try
    {
      if (this.soldDesc != null)
      {
        String str = this.soldDesc.toJson(this.soldDesc, SoldDesc.class).toString();
        return str;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\model\Product.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */