package com.xiaoenai.app.classes.store;

import android.view.View;
import com.xiaoenai.app.classes.store.sticker.BaseSticker;
import com.xiaoenai.app.f.c;
import com.xiaoenai.app.ui.a.k.a;

class v
  implements k.a
{
  v(u paramu) {}
  
  public void a(com.xiaoenai.app.ui.a.k paramk, View paramView)
  {
    a.a = false;
    if (StickerDownloadActivity.a(this.a.a) != null) {
      StickerDownloadActivity.a(this.a.a).k();
    }
    StickerDownloadActivity.b(this.a.a).setDownloading(false);
    StickerDownloadActivity.b(this.a.a).setDownload(false);
    k.a().c(StickerDownloadActivity.b(this.a.a));
    k.a().d(StickerDownloadActivity.b(this.a.a));
    ab.a().a(StickerDownloadActivity.b(this.a.a));
    this.a.a.r();
    paramk.dismiss();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\store\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */