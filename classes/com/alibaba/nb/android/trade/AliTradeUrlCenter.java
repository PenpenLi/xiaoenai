package com.alibaba.nb.android.trade;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

public class AliTradeUrlCenter
{
  public static final String URL_CONFIG = "{\n    \"Release\": {\n        \"trade.tmallTradeItemUrlHost\": \"https://detail.m.tmall.com/item.htm\",\n        \"trade.taobaoTradeItemUrlHost\": \"https://h5.m.taobao.com/cm/snap/index.html\",\n        \"trade.taobaoMobileTradeItemUrlHost\": \"https://h5.m.taobao.com/awp/core/detail.htm\",\n        \"trade.myCardCouponsUrl\": \"https://h5.m.taobao.com/vip/portal.html\",\n        \"trade.myOrdersUrl\": \"https://h5.m.taobao.com/mlapp/olist.html\",\n        \"trade.eTicketDetailUrl\": \"https://bendi.m.taobao.com/coupon/q/eticket_detail.htm?isArchive=false\",\n        \"trade.promotionsUrl\": \"https://ff.win.taobao.com?des=promotions&cc=tae\",\n        \"trade.shopUrlHost\": \"https://shop.m.taobao.com/shop/shop_index.htm\",\n        \"trade.cartUrl\": \"https://h5.m.taobao.com/mlapp/cart.html\"\n    },\n    \"PreRelease\": {\n        \"trade.promotionsUrl\": \"http://ff.win.taobao.com?des=promotions&cc=tae\"\n    },\n    \"Daily\": {\n        \"trade.promotionsUrl\": \"http://ff.win.daily.taobao.net?des=promotions&cc=tae\"\n    }\n}";
  public String TAG = "AliTradeUrlCenter";
  Map<String, Object> a;
  Map<String, Object> b;
  Map<String, Object> c;
  private Context d;
  
  public AliTradeUrlCenter(Context paramContext)
  {
    this.d = paramContext;
    try
    {
      JSONObject localJSONObject2 = new JSONObject("{\n    \"Release\": {\n        \"trade.tmallTradeItemUrlHost\": \"https://detail.m.tmall.com/item.htm\",\n        \"trade.taobaoTradeItemUrlHost\": \"https://h5.m.taobao.com/cm/snap/index.html\",\n        \"trade.taobaoMobileTradeItemUrlHost\": \"https://h5.m.taobao.com/awp/core/detail.htm\",\n        \"trade.myCardCouponsUrl\": \"https://h5.m.taobao.com/vip/portal.html\",\n        \"trade.myOrdersUrl\": \"https://h5.m.taobao.com/mlapp/olist.html\",\n        \"trade.eTicketDetailUrl\": \"https://bendi.m.taobao.com/coupon/q/eticket_detail.htm?isArchive=false\",\n        \"trade.promotionsUrl\": \"https://ff.win.taobao.com?des=promotions&cc=tae\",\n        \"trade.shopUrlHost\": \"https://shop.m.taobao.com/shop/shop_index.htm\",\n        \"trade.cartUrl\": \"https://h5.m.taobao.com/mlapp/cart.html\"\n    },\n    \"PreRelease\": {\n        \"trade.promotionsUrl\": \"http://ff.win.taobao.com?des=promotions&cc=tae\"\n    },\n    \"Daily\": {\n        \"trade.promotionsUrl\": \"http://ff.win.daily.taobao.net?des=promotions&cc=tae\"\n    }\n}");
      paramContext = localJSONObject2.getJSONObject("Release");
      JSONObject localJSONObject1 = localJSONObject2.getJSONObject("PreRelease");
      localJSONObject2 = localJSONObject2.getJSONObject("Daily");
      this.a = com.alibaba.nb.android.trade.utils.c.a.a(paramContext);
      this.b = com.alibaba.nb.android.trade.utils.c.a.a(localJSONObject1);
      this.c = com.alibaba.nb.android.trade.utils.c.a.a(localJSONObject2);
      return;
    }
    catch (Exception paramContext)
    {
      com.alibaba.nb.android.trade.utils.d.a.d(this.TAG, "URLCenter初始化失败");
    }
  }
  
  public String getValue(String paramString, AliTradeContext.Environment paramEnvironment)
  {
    switch (1.a[paramEnvironment.ordinal()])
    {
    default: 
      paramEnvironment = null;
    }
    String str;
    do
    {
      do
      {
        return paramEnvironment;
        return (String)this.a.get(paramString);
        str = (String)this.b.get(paramString);
        paramEnvironment = str;
      } while (str != null);
      paramString = (String)this.a.get(paramString);
      if (paramString == null) {}
      for (paramString = null; paramString == null; paramString = paramString.replace(".m.taobao.com", ".wapa.taobao.com")) {
        return null;
      }
      return paramString.replace("https://", "http://");
      str = (String)this.c.get(paramString);
      paramEnvironment = str;
    } while (str != null);
    paramString = (String)this.a.get(paramString);
    if (paramString == null) {}
    for (paramString = null; paramString == null; paramString = paramString.replace(".m.taobao.com", ".waptest.taobao.com")) {
      return null;
    }
    return paramString.replace("https://", "http://");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\AliTradeUrlCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */