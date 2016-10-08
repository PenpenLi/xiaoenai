package com.unionpay.mobile.android.widgets;

import android.content.Context;
import org.json.JSONObject;

public final class at
  extends z
{
  public at(Context paramContext, int paramInt, JSONObject paramJSONObject)
  {
    super(paramContext, paramInt, paramJSONObject);
  }
  
  public final boolean b()
  {
    if (this.h) {
      return true;
    }
    if (a() != null) {}
    for (String str = a(); (this.i != null) && (this.i.length() > 0); str = "") {
      return str.matches(this.i);
    }
    return (str.length() > 0) && (str.length() <= 64);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\mobile\android\widgets\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */