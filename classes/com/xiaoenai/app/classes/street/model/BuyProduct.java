package com.xiaoenai.app.classes.street.model;

import com.xiaoenai.app.annotation.json.JsonParser;
import org.json.JSONObject;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="title", b="title"), @com.xiaoenai.app.annotation.json.JsonElement(a="Count", b="count"), @com.xiaoenai.app.annotation.json.JsonElement(a="imageInfo", b="image_url"), @com.xiaoenai.app.annotation.json.JsonElement(a="SkuId", b="sku_id"), @com.xiaoenai.app.annotation.json.JsonElement(a="CartId", b="cart_id"), @com.xiaoenai.app.annotation.json.JsonElement(a="ProductId", b="product_id"), @com.xiaoenai.app.annotation.json.JsonElement(a="RushId", b="rush_id"), @com.xiaoenai.app.annotation.json.JsonElement(a="Price", b="price"), @com.xiaoenai.app.annotation.json.JsonElement(a="SkuDesc", b="sku_desc")})
public class BuyProduct
  extends com.xiaoenai.app.annotation.json.a
{
  private int cartId = 0;
  private int count;
  private ImageInfo imageInfo;
  private int price;
  private int productId;
  private int rushId;
  private String skuDesc;
  private int skuId;
  private String title;
  
  public BuyProduct() {}
  
  public BuyProduct(JSONObject paramJSONObject)
  {
    com.xiaoenai.app.utils.f.a.c("BuyProduct = {}", new Object[] { paramJSONObject });
    try
    {
      fromJson(BuyProduct.class, paramJSONObject, this);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public int getCartId()
  {
    return this.cartId;
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  public ImageInfo getImageInfo()
  {
    return this.imageInfo;
  }
  
  public int getPrice()
  {
    return this.price;
  }
  
  public int getProductId()
  {
    return this.productId;
  }
  
  public int getRushId()
  {
    return this.rushId;
  }
  
  public String getSkuDesc()
  {
    return this.skuDesc;
  }
  
  public int getSkuId()
  {
    return this.skuId;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String imageInfoTransformerToJson()
  {
    try
    {
      if (this.imageInfo != null)
      {
        String str = this.imageInfo.toJson(this.imageInfo, ImageInfo.class).toString();
        return str;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public void setCartId(int paramInt)
  {
    this.cartId = paramInt;
  }
  
  public void setCount(int paramInt)
  {
    this.count = paramInt;
  }
  
  public void setImage(ImageInfo paramImageInfo)
  {
    this.imageInfo = paramImageInfo;
  }
  
  public void setImageInfo(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof JSONObject)) {
        break label27;
      }
      this.imageInfo = new ImageInfo((JSONObject)paramObject);
    }
    label27:
    while (!(paramObject instanceof String)) {
      return;
    }
    this.imageInfo = new ImageInfo((String)paramObject);
  }
  
  public void setPrice(int paramInt)
  {
    this.price = paramInt;
  }
  
  public void setProductId(int paramInt)
  {
    this.productId = paramInt;
  }
  
  public void setRushId(int paramInt)
  {
    this.rushId = paramInt;
  }
  
  public void setSkuDesc(String paramString)
  {
    this.skuDesc = paramString;
  }
  
  public void setSkuId(int paramInt)
  {
    this.skuId = paramInt;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public JSONObject toJson()
  {
    try
    {
      JSONObject localJSONObject = toJson(this, BuyProduct.class);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\model\BuyProduct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */