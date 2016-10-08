package com.xiaoenai.app.classes.street.pay;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.xiaoenai.app.classes.street.pay.a.i.a;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.f.a;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private String a = "upacp";
  private i.a b = null;
  
  public b(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2, Intent paramIntent)
  {
    a.b("paymentResultAction requestCode = {} resultCode = {}", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 513) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getExtras().getString("pay_result");
      a.b("=========paymentResultAction====pay_result===== {}", new Object[] { paramIntent });
      if (!paramIntent.equals("invalid")) {
        break label147;
      }
      if (!this.a.equalsIgnoreCase("upacp")) {
        break label102;
      }
      if (this.b != null) {
        this.b.a("invalid");
      }
    }
    label102:
    label147:
    while (this.b == null)
    {
      do
      {
        return;
      } while (!this.a.equalsIgnoreCase("wx"));
      if ((paramContext instanceof StreetPayBaseActivity)) {
        ((StreetPayBaseActivity)paramContext).l_();
      }
      h.b(paramContext, 2131100761, 1500L, new c(this));
      return;
    }
    this.b.a(paramIntent);
  }
  
  public void a(Context paramContext, String paramString)
  {
    a.c("data = {}", new Object[] { paramString });
    try
    {
      this.a = new JSONObject(paramString).optString("channel");
      Intent localIntent = new Intent();
      String str = paramContext.getPackageName();
      localIntent.setComponent(new ComponentName(str, str + ".wxapi.WXPayEntryActivity"));
      localIntent.putExtra("com.pingplusplus.android.PaymentActivity.CHARGE", paramString);
      ((Activity)paramContext).startActivityForResult(localIntent, 513);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void a(i.a parama)
  {
    this.b = parama;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\pay\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */