package com.unionpay.mobile.android.widgets;

import android.content.Context;
import org.json.JSONObject;

public abstract class y
  extends az
  implements az.a
{
  public y(Context paramContext, JSONObject paramJSONObject)
  {
    super(paramContext, paramJSONObject);
  }
  
  public String g()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if ((m() != null) && (a() != null))
    {
      localStringBuffer.append("\"");
      localStringBuffer.append(m());
      localStringBuffer.append("\":");
      localStringBuffer.append("\"");
      localStringBuffer.append(a());
      localStringBuffer.append("\"");
    }
    return localStringBuffer.toString();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\mobile\android\widgets\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */