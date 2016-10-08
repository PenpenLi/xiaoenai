package com.xiaoenai.app.classes.street.model;

import com.xiaoenai.app.annotation.json.JsonParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="BuyProducts", b="buy_products")})
public class BuyProducts
  extends com.xiaoenai.app.annotation.json.a
{
  private BuyProduct[] buyProducts;
  
  public BuyProducts() {}
  
  public BuyProducts(String paramString)
  {
    try
    {
      fromJson(BuyProducts.class, new JSONObject(paramString), this);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public BuyProducts(JSONObject paramJSONObject)
  {
    try
    {
      fromJson(BuyProducts.class, paramJSONObject, this);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public BuyProduct[] getBuyProducts()
  {
    return this.buyProducts;
  }
  
  public void setBuyProduct(BuyProduct paramBuyProduct)
  {
    this.buyProducts = new BuyProduct[1];
    this.buyProducts[0] = paramBuyProduct;
  }
  
  public void setBuyProducts(JSONArray paramJSONArray)
  {
    com.xiaoenai.app.utils.f.a.c("json = {}", new Object[] { paramJSONArray });
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      this.buyProducts = new BuyProduct[paramJSONArray.length()];
      int i = 0;
      while (i < paramJSONArray.length())
      {
        this.buyProducts[i] = new BuyProduct(paramJSONArray.optJSONObject(i));
        com.xiaoenai.app.utils.f.a.c("json = {}", new Object[] { paramJSONArray.optJSONObject(i) });
        com.xiaoenai.app.utils.f.a.c("json = {}", new Object[] { this.buyProducts[i].toJson() });
        i += 1;
      }
    }
  }
  
  public void setBuyProducts(BuyProduct[] paramArrayOfBuyProduct)
  {
    this.buyProducts = paramArrayOfBuyProduct;
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    if (this.buyProducts != null) {}
    try
    {
      BuyProduct[] arrayOfBuyProduct = this.buyProducts;
      int j = arrayOfBuyProduct.length;
      int i = 0;
      while (i < j)
      {
        localJSONArray.put(arrayOfBuyProduct[i].toJson());
        i += 1;
      }
      localJSONObject.put("buy_products", localJSONArray);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\model\BuyProducts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */