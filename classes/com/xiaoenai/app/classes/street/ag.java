package com.xiaoenai.app.classes.street;

import android.view.View;
import android.view.View.OnClickListener;

class ag
  implements View.OnClickListener
{
  ag(StreetCommentProductActitvity paramStreetCommentProductActitvity) {}
  
  public void onClick(View paramView)
  {
    StreetCommentProductActitvity.a(this.a, StreetCommentProductActitvity.a(this.a));
    if (StreetCommentProductActitvity.b(this.a) > 0)
    {
      StreetCommentProductActitvity.c(this.a);
      return;
    }
    StreetCommentProductActitvity.d(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */