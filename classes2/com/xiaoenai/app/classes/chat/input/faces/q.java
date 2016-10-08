package com.xiaoenai.app.classes.chat.input.faces;

import android.graphics.Bitmap;
import com.xiaoenai.app.utils.e.d.c;
import com.xiaoenai.app.widget.gif.GifView;

class q
  implements c
{
  q(p paramp) {}
  
  public void a(String paramString)
  {
    paramString = com.xiaoenai.app.utils.e.b.f(paramString);
    if ((paramString != null) && (paramString.isRecycled()))
    {
      p.a(this.a).setImageBitmap(paramString);
      return;
    }
    p.a(this.a).setImageBitmap(null);
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    paramString = com.xiaoenai.app.utils.e.b.a(paramString);
    p.a(this.a).e();
    p.a(this.a).a(paramString, paramBitmap);
    p.a(this.a).d();
    p.a(this.a).setImageBitmap(null);
  }
  
  public void a(String paramString, com.xiaoenai.app.utils.e.a.b paramb) {}
  
  public void b(String paramString) {}
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\faces\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */