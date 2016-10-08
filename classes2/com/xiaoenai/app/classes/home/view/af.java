package com.xiaoenai.app.classes.home.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

class af
  implements View.OnClickListener
{
  af(LoverSearchView paramLoverSearchView) {}
  
  public void onClick(View paramView)
  {
    this.a.searchEdit.requestFocus();
    this.a.searchEdit.setCursorVisible(true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */