package com.xiaoenai.app.classes.home.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.common.dialog.e;

class l
  implements View.OnClickListener
{
  l(ContentView paramContentView, e parame) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    this.a.setOnDismissListener(new m(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */