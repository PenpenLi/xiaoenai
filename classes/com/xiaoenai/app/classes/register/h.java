package com.xiaoenai.app.classes.register;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.common.image.ImagePicker;

class h
  implements View.OnClickListener
{
  h(RegisterActivity paramRegisterActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new ImagePicker(this.a);
    paramView.a(new i(this));
    paramView.a(640, 640);
    paramView.a(this.a.getString(2131101044), new j(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\register\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */