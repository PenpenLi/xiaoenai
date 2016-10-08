package com.xiaoenai.app.classes.store;

import android.content.Context;
import com.d.a.a.f;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.store.sticker.BaseSticker;
import com.xiaoenai.app.f.c;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.l;
import org.json.JSONObject;

class y
  extends m
{
  y(StickerDownloadActivity paramStickerDownloadActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(int paramInt)
  {
    a.a(this.a, StickerDownloadActivity.b(this.a), "com.xiaoenai.app.download.TASK_CHANGE", "type", 9);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.a.a = l.e(paramJSONObject.toString());
    StickerDownloadActivity.a(this.a, new c(StickerDownloadActivity.b(this.a).getId(), this.a.a, "download_action", StickerDownloadActivity.b(this.a).getName()));
    Xiaoenai.j().a().a(StickerDownloadActivity.a(this.a));
    StickerDownloadActivity.b(this.a).setDownloading(true);
    k.a().d(StickerDownloadActivity.b(this.a));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\store\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */