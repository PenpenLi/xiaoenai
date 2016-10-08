package com.xiaoenai.app.classes.common.image.imagePreview;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.chat.messagelist.message.model.PhotoMessage;
import java.util.ArrayList;

class w
  implements View.OnClickListener
{
  w(t paramt, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = this.b.a(((PhotoMessage)t.a(this.b).get(this.a)).x(), ((PhotoMessage)t.a(this.b).get(this.a)).u(), ((PhotoMessage)t.a(this.b).get(this.a)).v());
    if ((t.b(this.b) instanceof ImageViewPager)) {
      ((ImageViewPager)t.b(this.b)).a(((PhotoMessage)t.a(this.b).get(this.a)).x(), paramView.a(), paramView.b(), paramView.c());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */