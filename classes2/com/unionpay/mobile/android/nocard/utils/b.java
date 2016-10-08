package com.unionpay.mobile.android.nocard.utils;

import com.unionpay.mobile.android.utils.g;
import org.json.JSONObject;

public final class b
{
  public static void a(JSONObject paramJSONObject, com.unionpay.mobile.android.model.b paramb)
  {
    paramb.an = g.a(paramJSONObject, "red_packet_url");
  }
  
  public static void b(JSONObject paramJSONObject, com.unionpay.mobile.android.model.b paramb)
  {
    paramb.aH = g.a(paramJSONObject, "pay_msg");
    paramb.aI = g.a(paramJSONObject, "promotion_msg");
    paramb.aJ = g.a(paramJSONObject, "instalment_msg");
    paramb.aM = g.a(paramJSONObject, "temporary_pay_flag");
    if ("0".equalsIgnoreCase(paramb.aM)) {
      paramb.aN = g.a(paramJSONObject, "temporary_pay_info");
    }
    if ("0".equalsIgnoreCase(g.a(paramJSONObject, "luck_draw_flag"))) {
      paramb.aL = true;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\nocard\utils\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */