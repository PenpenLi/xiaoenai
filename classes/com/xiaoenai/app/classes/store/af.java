package com.xiaoenai.app.classes.store;

import android.content.Context;
import com.xiaoenai.app.classes.store.sticker.BaseSticker;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class af
  extends m
{
  af(StickerService paramStickerService, Context paramContext, BaseSticker paramBaseSticker)
  {
    super(paramContext);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    StickerService.a(this.b, this.a, StickerService.a(this.b), paramJSONObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\store\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */