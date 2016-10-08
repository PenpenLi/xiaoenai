package com.xiaoenai.app.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaoenai.app.classes.extentions.anniversary.ad;
import com.xiaoenai.app.classes.extentions.menses.t;
import com.xiaoenai.app.classes.newRegister.phone.PhoneRegisterActivity;
import com.xiaoenai.app.classes.newRegister.phone.PhoneRegisterSettingPWActivity;
import com.xiaoenai.app.classes.newRegister.phone.PhoneRegisterVerifyActivity;
import com.xiaoenai.app.classes.street.StreetProductDetailActivity;
import com.xiaoenai.app.classes.street.b.f;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.utils.d.d;
import com.xiaoenai.app.utils.f.a;
import com.xiaoenai.app.utils.w;
import java.util.Calendar;
import org.cocos2dx.cpp.k;

public class RemindReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    a.c("onReceive: time={}", new Object[] { d.a(Calendar.getInstance()) });
    String str;
    if (paramIntent != null)
    {
      str = paramIntent.getAction();
      a.c("action={}", new Object[] { str });
      a.c("from={}", new Object[] { paramIntent.getStringExtra("from") });
      if ((!AppModel.getInstance().isLogined()) || (TextUtils.isEmpty(str))) {
        break label221;
      }
      if (!str.equals("com.xiaoenai.app.REMIND_ANNIVERSARY")) {
        break label88;
      }
      ad.a(paramContext);
    }
    label88:
    label221:
    do
    {
      do
      {
        do
        {
          int j;
          do
          {
            return;
            if (str.equals("com.xiaoenai.app.REMIND_MENSES"))
            {
              t.a(paramContext);
              return;
            }
            if (!str.equals("com.xiaoenai.app.REMIND_STREET")) {
              break;
            }
            i = paramIntent.getIntExtra("product_id", -1);
            j = paramIntent.getIntExtra("rush_id", 0);
          } while (i == -1);
          paramIntent = new Intent();
          paramIntent.putExtra("product_id", i);
          paramIntent.putExtra("rush_id", j);
          paramIntent.setClass(paramContext, StreetProductDetailActivity.class);
          w.a(paramContext, paramContext.getString(2131101470), paramIntent, i);
          w.a(paramContext.getString(2131101470), i, j);
          f.a().a(i, j);
          return;
        } while (!str.equals("com.xiaoenai.app.GAME_ON_LOVEPET_PUSH"));
        k.a(paramContext, paramIntent);
        return;
      } while ((TextUtils.isEmpty(str)) || (!str.equals("com.xiaoenai.app.REMIND_REGISTER")));
      str = paramIntent.getStringExtra("alarm_from");
      a.c("alarm_from = {}", new Object[] { str });
    } while (TextUtils.isEmpty(str));
    paramIntent.setFlags(536870912);
    int i = Integer.valueOf(paramContext.getString(2131101646)).intValue();
    if (str.equals("from_register_one")) {
      paramIntent.setClass(paramContext, PhoneRegisterActivity.class);
    }
    for (;;)
    {
      w.a(paramContext, paramContext.getString(2131100952), 0, i, paramIntent);
      return;
      if (str.equals("from_register_verify")) {
        paramIntent.setClass(paramContext, PhoneRegisterVerifyActivity.class);
      } else if (str.equals("from_register_last")) {
        paramIntent.setClass(paramContext, PhoneRegisterSettingPWActivity.class);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\service\RemindReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */