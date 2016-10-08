package com.xiaoenai.app.net;

import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.street.model.BuyInfo;
import com.xiaoenai.app.net.c.a.l;
import com.xiaoenai.app.utils.f.a;
import org.json.JSONArray;
import org.json.JSONObject;

public class ae
  extends l
{
  public ae(m paramm)
  {
    super(paramm);
  }
  
  public String a(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = Xiaoenai.p + paramString;
    }
    return str;
  }
  
  public void a()
  {
    try
    {
      b("street/v1/contact/default", new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void a(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("contact_id", paramInt);
      a("street/v1/contact/delete", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("offset", paramInt1);
      localJSONObject.put("limit", paramInt2);
      b("street/v1/aftersale/list", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    JSONObject localJSONObject = new JSONObject();
    if (-1 != paramInt1) {}
    try
    {
      localJSONObject.put("state", paramInt1);
      localJSONObject.put("offset", paramInt2);
      localJSONObject.put("limit", paramInt3);
      b("street/v1/order/list", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("product_id", paramInt1);
      localJSONObject.put("last_comment_id", paramInt2);
      localJSONObject.put("limit", paramInt3);
      localJSONObject.put("offset", paramInt4);
      b("street/v1/product/comment", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void a(int paramInt1, int paramInt2, BuyInfo[] paramArrayOfBuyInfo)
  {
    JSONArray localJSONArray = new JSONArray();
    int j = paramArrayOfBuyInfo.length;
    int i = 0;
    while (i < j)
    {
      JSONObject localJSONObject = paramArrayOfBuyInfo[i].toJson();
      if (localJSONObject != null) {
        localJSONArray.put(localJSONObject);
      }
      i += 1;
    }
    a.c("buy_info = {}", new Object[] { localJSONArray });
    try
    {
      paramArrayOfBuyInfo = new JSONObject();
      paramArrayOfBuyInfo.put("contact_id", paramInt1);
      paramArrayOfBuyInfo.put("privated", paramInt2);
      paramArrayOfBuyInfo.put("buy_info", localJSONArray);
      a("street/v1/buy/submit", paramArrayOfBuyInfo);
      return;
    }
    catch (Exception paramArrayOfBuyInfo)
    {
      paramArrayOfBuyInfo.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("product_id", paramInt);
      localJSONObject.put("content", paramString);
      a("street/v1/product/add_comment", localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("contact_id", paramInt1);
      if ((paramString1 != null) && (paramString1.length() > 0)) {
        localJSONObject.put("name", paramString1);
      }
      if ((paramString2 != null) && (paramString2.length() > 0)) {
        localJSONObject.put("phone", paramString2);
      }
      if ((paramString3 != null) && (paramString3.length() > 0)) {
        localJSONObject.put("province_city_zone", paramString3);
      }
      if ((paramString4 != null) && (paramString4.length() > 0)) {
        localJSONObject.put("address", paramString4);
      }
      if (-1 != paramInt2) {
        localJSONObject.put("is_default", paramInt2);
      }
      a("street/v1/contact/update", localJSONObject);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void a(long paramLong)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("order_id", paramLong);
      b("street/v1/order/detail", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("order_id", paramLong);
      localJSONObject.put("desc_score", paramInt1);
      localJSONObject.put("service_score", paramInt2);
      localJSONObject.put("send_score", paramInt3);
      localJSONObject.put("delivery_score", paramInt4);
      a("street/v1/order/score", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("order_id", paramLong);
      localJSONObject.put("company_id", paramInt);
      localJSONObject.put("number", paramString);
      a("street/v1/aftersale/delivery_submit", localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("order_id", paramLong);
      localJSONObject.put("content", paramString);
      a("street/v1/aftersale/refund", localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("order_id", paramLong);
      localJSONObject.put("content", paramString1);
      localJSONObject.put("tag", paramString2);
      a("street/v1/aftersale/feedback_submit", localJSONObject);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2, JSONArray paramJSONArray)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("order_id", paramLong);
      localJSONObject.put("reason", paramString1);
      localJSONObject.put("content", paramString2);
      localJSONObject.put("image_urls", paramJSONArray);
      a("street/v1/aftersale/exchange", localJSONObject);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("name", paramString1);
      localJSONObject.put("phone", paramString2);
      localJSONObject.put("province_city_zone", paramString3);
      localJSONObject.put("address", paramString4);
      localJSONObject.put("is_default", paramInt);
      a("street/v1/contact/add", localJSONObject);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void a(JSONObject paramJSONObject) {}
  
  public void a(long[] paramArrayOfLong, String paramString, int paramInt)
  {
    JSONArray localJSONArray = new JSONArray();
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      localJSONArray.put(Long.valueOf(paramArrayOfLong[i]));
      i += 1;
    }
    try
    {
      paramArrayOfLong = new JSONObject();
      paramArrayOfLong.put("order_ids", localJSONArray);
      paramArrayOfLong.put("channel", paramString);
      paramArrayOfLong.put("total_price", paramInt);
      a("street/v1/pay/pay", paramArrayOfLong);
      return;
    }
    catch (Exception paramArrayOfLong)
    {
      paramArrayOfLong.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void b()
  {
    try
    {
      b("street/v1/contact/list", new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void b(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("product_id", paramInt);
      b("street/v1/product/has_reply", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("product_id", paramInt1);
      localJSONObject.put("rush_id", paramInt2);
      b("street/v1/product/info", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("rush_id", paramInt1);
      localJSONObject.put("product_id", paramInt2);
      localJSONObject.put("subscribe_type", paramInt3);
      a("street/v1/product/subscribe", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("comment_id", paramInt);
      localJSONObject.put("content", paramString);
      a("street/v1/product/report_comment", localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void b(long paramLong)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("order_id", paramLong);
      a("street/v1/order/confirm", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(long paramLong, String paramString1, String paramString2, JSONArray paramJSONArray)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("order_id", paramLong);
      localJSONObject.put("reason", paramString1);
      localJSONObject.put("content", paramString2);
      localJSONObject.put("image_urls", paramJSONArray);
      a("street/v1/aftersale/return", localJSONObject);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("charge_id", paramString);
      a("street/v1/pay/query_paid", localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void b(JSONObject paramJSONObject) {}
  
  public void c()
  {
    try
    {
      b("street/v1/aftersale/return_reason", new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void c(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("product_id", paramInt);
      a("street/v1/product/favor", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void c(long paramLong)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("order_id", paramLong);
      a("street/v1/order/delete", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void d()
  {
    try
    {
      b("street/v1/aftersale/exchange_reason", new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void d(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("buy_task_id", paramInt);
      b("street/v1/buy/query", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void d(long paramLong)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("order_id", paramLong);
      a("street/v1/order/close", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void e()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      b("street/v1/aftersale/delivery_company", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void e(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("pay_task_id", paramInt);
      b("street/v1/pay/query", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void e(long paramLong)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("order_id", paramLong);
      b("street/v1/order/delivery", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void f()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      b("street/v1/cart/count", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void f(long paramLong)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("order_id", paramLong);
      b("street/v1/aftersale/get_feedback", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void g(long paramLong)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("order_id", paramLong);
      b("street/v1/aftersale/progress", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void h(long paramLong)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("order_id", paramLong);
      b("street/v1/aftersale/detail", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void i(long paramLong)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("order_id", paramLong);
      a("street/v1/aftersale/delete", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void j(long paramLong)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("order_id", paramLong);
      a("street/v1/aftersale/cancel", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void k(long paramLong)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("order_id", paramLong);
      b("street/v1/aftersale/aftersale_text", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\net\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */