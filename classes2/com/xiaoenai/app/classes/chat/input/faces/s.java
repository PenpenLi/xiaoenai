package com.xiaoenai.app.classes.chat.input.faces;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.xiaoenai.app.classes.chat.ChatActivity;
import com.xiaoenai.app.classes.chat.input.InputFragment;

class s
  implements View.OnClickListener
{
  s(r paramr) {}
  
  public void onClick(View paramView)
  {
    paramView = ((ChatActivity)this.a.getActivity()).g_().d();
    String str = paramView.getText().toString().trim();
    if (str.length() > 0)
    {
      ((ChatActivity)this.a.getActivity()).b(str);
      paramView.setText("");
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\faces\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */