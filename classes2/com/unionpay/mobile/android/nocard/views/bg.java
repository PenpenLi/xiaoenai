package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.widgets.ac;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bg
{
  public static LinearLayout a(Context paramContext, JSONArray paramJSONArray, int paramInt1, int paramInt2)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setBackgroundColor(-1);
    localLinearLayout.setOrientation(1);
    new LinearLayout.LayoutParams(-1, -2).topMargin = a.d;
    Object localObject = null;
    for (;;)
    {
      if ((paramInt1 >= paramInt2) || (paramInt1 >= paramJSONArray.length())) {
        break label100;
      }
      try
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(paramInt1);
        localObject = localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
      localLinearLayout.addView(new ac(paramContext, a.I, (JSONObject)localObject));
      paramInt1 += 1;
    }
    label100:
    return localLinearLayout;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return String.format("\"first_pay_flag\":\"%s\",\"card\":\"%s\",\"pay_type\":\"%s\",\"pay_mode\":\"%s\"", new Object[] { paramString1, paramString2, paramString3, paramString4 });
  }
  
  public static String a(JSONObject paramJSONObject)
  {
    h.a("uppay", "action:" + g.a(paramJSONObject, "action"));
    return g.a(paramJSONObject, "action");
  }
  
  public static String b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return String.format("\"first_pay_flag\":\"%s\",%s,\"pay_type\":\"%s\",\"pay_mode\":\"%s\"", new Object[] { paramString1, paramString2, paramString3, paramString4 });
  }
  
  public static String c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramString3 != null) && (paramString3.length() > 0)) {
      return String.format("\"pay_type\":\"%s\",\"pay_mode\":\"%s\",%s,%s", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    }
    return String.format("\"pay_type\":\"%s\",\"pay_mode\":\"%s\",%s", new Object[] { paramString1, paramString2, paramString4 });
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\nocard\views\bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */