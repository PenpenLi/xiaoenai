package com.xiaoenai.app.classes.chat;

import android.graphics.Bitmap;
import android.view.View;
import com.xiaoenai.app.widget.gif.ArtworkGifView;

class as
  implements com.xiaoenai.app.utils.e.d.b
{
  as(GifPlayerActivity paramGifPlayerActivity, String paramString) {}
  
  public void a(String paramString, View paramView) {}
  
  public void a(String paramString, View paramView, Bitmap paramBitmap)
  {
    if ((paramString != null) && (paramString.equals(this.a)))
    {
      paramString = com.xiaoenai.app.utils.e.b.a(paramString);
      GifPlayerActivity.a(this.b).a(paramString, paramBitmap);
      GifPlayerActivity.a(this.b).d();
      GifPlayerActivity.a(this.b).setDecodeListener(new at(this));
    }
  }
  
  public void a(String paramString, View paramView, com.xiaoenai.app.utils.e.a.b paramb) {}
  
  public void b(String paramString, View paramView) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */