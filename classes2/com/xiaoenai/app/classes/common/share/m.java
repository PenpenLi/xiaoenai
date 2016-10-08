package com.xiaoenai.app.classes.common.share;

import android.content.Context;
import android.graphics.Bitmap;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.e.a.b;

class m
  implements com.xiaoenai.app.utils.e.d.c
{
  m(l paraml, Context paramContext, WeiboMultiMessage paramWeiboMultiMessage, ShareInfo paramShareInfo, com.xiaoenai.app.classes.common.a.c paramc) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    this.b.imageObject = new ImageObject();
    this.b.imageObject.setImageObject(paramBitmap);
    this.e.a(this.c, this.b, this.a, this.d);
  }
  
  public void a(String paramString, b paramb)
  {
    h.c(this.a, 2131101255, 1500L);
  }
  
  public void b(String paramString) {}
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\share\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */