package com.xiaoenai.app.classes.street.model;

import com.xiaoenai.app.annotation.json.JsonParser;
import com.xiaoenai.app.annotation.json.a;
import org.json.JSONArray;
import org.json.JSONObject;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="Complete", b="complete"), @com.xiaoenai.app.annotation.json.JsonElement(a="Orders", b="order_ids"), @com.xiaoenai.app.annotation.json.JsonElement(a="totalPrice", b="total_price")})
public class BuyQueryResult
  extends a
{
  private int complete;
  private long[] orders;
  private int totalPrice = 0;
  
  public BuyQueryResult() {}
  
  public BuyQueryResult(JSONObject paramJSONObject)
  {
    try
    {
      fromJson(BuyQueryResult.class, paramJSONObject, this);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public boolean getComplete()
  {
    return this.complete > 0;
  }
  
  public long[] getOrders()
  {
    return this.orders;
  }
  
  public int getTotalPrice()
  {
    return this.totalPrice;
  }
  
  public void setComplete(int paramInt)
  {
    this.complete = paramInt;
  }
  
  public void setOrders(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      this.orders = new long[paramJSONArray.length()];
      int i = 0;
      while (i < paramJSONArray.length())
      {
        this.orders[i] = paramJSONArray.optLong(i);
        i += 1;
      }
    }
  }
  
  public void setTotalPrice(int paramInt)
  {
    this.totalPrice = paramInt;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\model\BuyQueryResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */