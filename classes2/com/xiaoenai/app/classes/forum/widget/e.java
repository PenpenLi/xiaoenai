package com.xiaoenai.app.classes.forum.widget;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;

class e
  implements com.xiaoenai.app.utils.e.d.b
{
  e(ForumPostImageLayoutView paramForumPostImageLayoutView, int paramInt, LinearLayout.LayoutParams paramLayoutParams) {}
  
  public void a(String paramString, View paramView)
  {
    this.c.setProgressViewVisibility(0);
    this.c.setTextViewVisibility(8);
  }
  
  public void a(String paramString, View paramView, Bitmap paramBitmap)
  {
    if (this.a == 1) {
      this.c.setLayoutParams(this.b);
    }
    this.c.setProgressViewVisibility(8);
    this.c.setTextViewVisibility(8);
    this.c.a();
  }
  
  public void a(String paramString, View paramView, com.xiaoenai.app.utils.e.a.b paramb)
  {
    this.c.setProgressViewVisibility(8);
    this.c.setTextViewVisibility(0);
  }
  
  public void b(String paramString, View paramView)
  {
    this.c.setProgressViewVisibility(8);
    this.c.setTextViewVisibility(8);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\widget\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */