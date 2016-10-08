package com.xiaoenai.app.classes.store;

import android.content.Context;
import android.widget.Button;
import com.xiaoenai.app.classes.store.sticker.BaseSticker;

public class t
{
  public static void a(Context paramContext, BaseSticker paramBaseSticker, s params)
  {
    if (paramBaseSticker == null) {}
    do
    {
      return;
      if (paramBaseSticker.isDownload())
      {
        params.a().setTextColor(-4077363);
        params.a().setText(paramContext.getString(2131101295));
        params.a().setBackgroundResource(2130838913);
        params.a().setOnClickListener(null);
        return;
      }
    } while (!paramBaseSticker.isDownloading());
    params.a().setTextColor(-1);
    params.a().setText(paramContext.getString(2131101310));
    params.a().setBackgroundResource(2130837740);
    params.a().setOnClickListener(null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\store\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */