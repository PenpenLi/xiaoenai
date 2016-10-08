package com.xiaoenai.app.classes.chat.messagelist.view;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.LinearLayout;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.widget.gif.GifView;

class g
  extends com.xiaoenai.app.utils.e.d.g
{
  g(d paramd) {}
  
  public void a(String paramString, View paramView, Bitmap paramBitmap)
  {
    d.a(this.a).b();
    d.b(this.a).setVisibility(8);
    d.c(this.a).setVisibility(0);
    if ((paramString != null) && (paramString.equals(d.d(this.a))))
    {
      paramString = b.a(paramString);
      d.c(this.a).e();
      d.c(this.a).a(paramString, paramBitmap);
      d.c(this.a).d();
      d.c(this.a).setDecodeListener(new h(this));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\view\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */