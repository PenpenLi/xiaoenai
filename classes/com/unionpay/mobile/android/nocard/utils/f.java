package com.unionpay.mobile.android.nocard.utils;

import android.text.TextUtils;
import com.unionpay.mobile.android.model.a;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.model.d;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.utils.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  public static int a(b paramb, JSONObject paramJSONObject)
  {
    paramb.u = g.c(paramJSONObject, "rules");
    paramb.Y = g.c(paramJSONObject, "available_area_codes");
    paramb.y = g.c(paramJSONObject, "entrust_rules");
    paramb.z = g.a(paramJSONObject, "pre_cmd");
    paramb.v = g.a(paramJSONObject, "title");
    paramb.x = g.b(paramJSONObject, "rules_button");
    paramb.ag = g.b(paramJSONObject, "service_checkbox");
    paramb.ah = g.b(paramJSONObject, "bind_card_checkbox");
    String str = g.a(paramJSONObject, "timeout_msg");
    if ((str != null) && (!TextUtils.isEmpty(str))) {
      paramb.af = str;
    }
    paramb.k = new HashMap();
    Object localObject = g.b(paramJSONObject, "f55");
    str = g.a((JSONObject)localObject, "order_amount");
    HashMap localHashMap = paramb.k;
    if ((str != null) && (str.length() > 0))
    {
      localHashMap.put("trans_amt", str);
      str = g.a((JSONObject)localObject, "order_currency");
      localHashMap = paramb.k;
      if ((str == null) || (str.length() <= 0)) {
        break label328;
      }
      label178:
      localHashMap.put("trans currcy code", str);
      str = g.a((JSONObject)localObject, "trans_type");
      localHashMap = paramb.k;
      if ((str == null) || (str.length() <= 0)) {
        break label334;
      }
      label211:
      localHashMap.put("trans_type", str);
      str = g.a((JSONObject)localObject, "mer_name");
      localObject = paramb.k;
      if ((str == null) || (str.length() <= 0)) {
        break label340;
      }
    }
    for (;;)
    {
      ((HashMap)localObject).put("mer_name", str);
      paramb.al = g.a(paramJSONObject, "pan");
      paramJSONObject = g.a(paramJSONObject, "fail_continue");
      if ((paramJSONObject != null) && (paramJSONObject.equalsIgnoreCase("0"))) {
        paramb.A = true;
      }
      if (((paramb.u != null) && (paramb.u.length() > 0)) || ((paramb.y != null) && (paramb.y.length() > 0))) {
        break label346;
      }
      return 2;
      str = "000000000000";
      break;
      label328:
      str = "0156";
      break label178;
      label334:
      str = "00";
      break label211;
      label340:
      str = "";
    }
    label346:
    return 0;
  }
  
  public static int a(b paramb, JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (!paramBoolean) {
      paramb.B = paramJSONObject;
    }
    return a(paramb, paramJSONObject);
  }
  
  public static d a(JSONObject paramJSONObject)
  {
    e locale = new e();
    locale.a("promotion", g.b(paramJSONObject, "promotion"));
    locale.a("instalment", g.b(paramJSONObject, "instalment"));
    locale.a("promotion_instalment_msgbox", g.b(paramJSONObject, "promotion_instalment_msgbox"));
    return locale;
  }
  
  public static boolean a(JSONArray paramJSONArray)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (paramJSONArray != null) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < paramJSONArray.length()) {}
      try
      {
        Object localObject = paramJSONArray.getJSONObject(i);
        String str = g.a((JSONObject)localObject, "type");
        localObject = g.a((JSONObject)localObject, "readonly");
        if ("pan".equalsIgnoreCase(str))
        {
          boolean bool3 = "true".equalsIgnoreCase((String)localObject);
          bool1 = bool2;
          if (bool3) {
            bool1 = true;
          }
          return bool1;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        i += 1;
      }
    }
  }
  
  public static int b(b paramb, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (int i = 2;; i = 0)
    {
      if (paramb.W == null) {
        paramb.W = new ArrayList();
      }
      paramb.W.clear();
      List localList = g.d(paramJSONObject, "user_cards");
      if ((localList != null) && (localList.size() > 0))
      {
        int j = 0;
        while ((localList != null) && (j < localList.size()))
        {
          a locala = new a(g.a((JSONArray)localList.get(j), 0), g.a((JSONArray)localList.get(j), 1), g.a((JSONArray)localList.get(j), 2), (byte)0);
          paramb.W.add(locala);
          j += 1;
        }
      }
      paramb.Y = g.c(paramJSONObject, "available_area_codes");
      paramb.X = g.c(paramJSONObject, "user_info");
      paramb.u = g.c(paramJSONObject, "rules");
      paramb.U = g.b(paramJSONObject, "service_url");
      paramb.V = g.b(paramJSONObject, "bind_url");
      paramb.Z = g.a(paramJSONObject, "empty_info");
      paramb.aO = g.a(paramJSONObject, "add_card_tip");
      paramb.al = g.a(paramJSONObject, "pan");
      return i;
    }
  }
  
  public static boolean c(b paramb, JSONObject paramJSONObject)
  {
    boolean bool = false;
    paramb.av = null;
    paramb.av = g.b(paramJSONObject, "cardExpireMsgBox");
    if (paramb.av == null) {
      paramb.av = g.b(paramJSONObject, "openByCounterMsgBox");
    }
    if (paramb.av == null) {
      paramb.av = g.b(paramJSONObject, "restrictPayMsgBox");
    }
    if (paramb.av != null)
    {
      paramb.aw = g.a(paramb.av, "title");
      paramb.ax = g.a(paramb.av, "text");
      paramJSONObject = g.b(paramb.av, "func");
      JSONObject localJSONObject = g.b(paramb.av, "cancel");
      paramb.aA = g.a(paramJSONObject, "label");
      paramb.aB = g.a(paramJSONObject, "action");
      paramb.ay = g.a(localJSONObject, "label");
      paramb.az = g.a(localJSONObject, "action");
      bool = true;
    }
    return bool;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\mobile\android\nocard\utils\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */