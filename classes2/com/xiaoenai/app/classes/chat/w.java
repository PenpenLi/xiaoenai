package com.xiaoenai.app.classes.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.utils.e.b;
import java.io.File;

class w
  implements View.OnClickListener
{
  w(ChangeBgActivity.b paramb) {}
  
  public void onClick(View paramView)
  {
    ChangeBgActivity.a(this.a.a, ((Integer)paramView.getTag()).intValue());
    ChangeBgActivity.a(this.a.a, true);
    paramView = this.a.a(ChangeBgActivity.d(this.a.a));
    ak.a("chat_bg_type", ChangeBgActivity.d(this.a.a));
    if (ChangeBgActivity.d(this.a.a) > 2)
    {
      ak.a("chat_bg_photo_path", paramView.d);
      ak.a("chat_bg_origin_url", paramView.d);
      if (ChangeBgActivity.d(this.a.a) > 2)
      {
        File localFile = b.b(paramView.d);
        if ((localFile != null) && (localFile.exists())) {
          break label235;
        }
        this.a.a.a(this.a.a.getString(2131100140));
        b.a(paramView.d, new x(this), true, false);
      }
    }
    for (;;)
    {
      ChangeBgActivity.f(this.a.a).notifyDataSetChanged();
      return;
      ak.a("chat_bg_photo_path", "" + ChangeBgActivity.d(this.a.a));
      ak.a("chat_bg_origin_url");
      ChangeBgActivity.e(this.a.a);
      break;
      label235:
      ChangeBgActivity.e(this.a.a);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */