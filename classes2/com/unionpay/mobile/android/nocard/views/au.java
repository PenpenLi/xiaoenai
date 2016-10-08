package com.unionpay.mobile.android.nocard.views;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.unionpay.mobile.android.utils.g;
import org.json.JSONObject;

final class au
  implements View.OnClickListener
{
  au(as paramas) {}
  
  public final void onClick(View paramView)
  {
    paramView = (JSONObject)paramView.getTag();
    String str = g.a(paramView, "errMsg");
    if ((str != null) && (!TextUtils.isEmpty(str)))
    {
      this.a.a(str);
      return;
    }
    str = g.a(paramView, "action");
    paramView = g.a(paramView, "value");
    as.a(this.a, str, paramView);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\nocard\views\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */