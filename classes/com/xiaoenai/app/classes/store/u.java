package com.xiaoenai.app.classes.store;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.ui.a.g;

class u
  implements View.OnClickListener
{
  u(StickerDownloadActivity paramStickerDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    if (!a.a)
    {
      a.a = true;
      paramView = new g(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.getString(2131101301));
      localStringBuilder.append("\n\n");
      localStringBuilder.append(this.a.getString(2131101300));
      paramView.b(17);
      paramView.a(localStringBuilder.toString());
      paramView.setCancelable(false);
      paramView.a(2131100898, new v(this));
      paramView.b(2131099973, new w(this));
      paramView.show();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\store\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */