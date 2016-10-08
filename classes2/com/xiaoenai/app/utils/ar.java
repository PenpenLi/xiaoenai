package com.xiaoenai.app.utils;

import android.view.View;
import com.xiaoenai.app.model.AppSettings;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.ui.a.k.a;
import java.util.Date;

final class ar
  implements k.a
{
  public void a(k paramk, View paramView)
  {
    paramk.dismiss();
    AppSettings.setString("last_cancel_update", String.format("%tj", new Object[] { new Date() }));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */