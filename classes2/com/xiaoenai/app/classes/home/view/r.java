package com.xiaoenai.app.classes.home.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.xiaoenai.app.classes.chat.messagelist.message.model.k;
import com.xiaoenai.app.utils.as;

class r
  implements View.OnClickListener
{
  r(ContentView paramContentView, k paramk) {}
  
  public void onClick(View paramView)
  {
    if (((Button)paramView).getText().toString().equals(as.a(2131100561))) {
      ContentView.a(this.b, this.a, ContentView.f(this.b));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */