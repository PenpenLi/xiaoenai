package com.xiaoenai.app.classes.street;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

class ai
  implements View.OnClickListener
{
  ai(StreetCommentProductActitvity paramStreetCommentProductActitvity) {}
  
  public void onClick(View paramView)
  {
    if (StreetCommentProductActitvity.e(this.a))
    {
      StreetCommentProductActitvity.f(this.a).setImageResource(2130838430);
      this.a.f();
      StreetCommentProductActitvity.b(this.a, StreetCommentProductActitvity.a(this.a));
      paramView = this.a;
      if (StreetCommentProductActitvity.e(this.a)) {
        break label103;
      }
    }
    label103:
    for (boolean bool = true;; bool = false)
    {
      StreetCommentProductActitvity.a(paramView, bool);
      return;
      this.a.d();
      StreetCommentProductActitvity.a(this.a, StreetCommentProductActitvity.a(this.a));
      StreetCommentProductActitvity.f(this.a).setImageResource(2130838424);
      break;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */