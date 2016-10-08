package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.text.InputFilter.LengthFilter;
import com.unionpay.mobile.android.utils.g;
import org.json.JSONObject;

public final class as
  extends z
{
  private int n = 0;
  
  public as(Context paramContext, int paramInt, JSONObject paramJSONObject)
  {
    super(paramContext, paramInt, paramJSONObject);
    paramContext = g.a(paramJSONObject, "maxLength");
    if ((paramContext != null) && (paramContext.length() > 0)) {}
    for (this.n = Integer.getInteger(paramContext).intValue();; this.n = 23)
    {
      this.b.a(new InputFilter.LengthFilter(this.n));
      return;
    }
  }
  
  public final boolean b()
  {
    if (this.h) {}
    while (this.n >= a().length()) {
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\mobile\android\widgets\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */