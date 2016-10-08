package com.xiaoenai.app.classes.store;

import android.content.Context;
import com.xiaoenai.app.classes.store.sticker.BaseSticker;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.l;
import java.util.Vector;
import org.json.JSONObject;

class o
  extends m
{
  o(StickerDetailActivity paramStickerDetailActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    StickerDetailActivity.a(this.a, l.c(paramJSONObject.toString()));
    StickerDetailActivity.b(this.a).setPurchased(l.d(paramJSONObject.toString()));
    StickerDetailActivity.d(this.a).a(StickerDetailActivity.c(this.a).toArray());
    k.a().a(StickerDetailActivity.b(this.a));
    t.a(this.a, StickerDetailActivity.b(this.a), StickerDetailActivity.e(this.a));
    if ((!StickerDetailActivity.b(this.a).isDownload()) && (!StickerDetailActivity.b(this.a).isDownloading()) && (StickerDetailActivity.b(this.a).isPurchased())) {
      this.a.d(StickerDetailActivity.b(this.a));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\store\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */