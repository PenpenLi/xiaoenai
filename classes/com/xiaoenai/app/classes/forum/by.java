package com.xiaoenai.app.classes.forum;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;

class by
  implements TextWatcher
{
  by(ForumRegisterActivity paramForumRegisterActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence.length() > 0)
    {
      ForumRegisterActivity.d(this.a).setVisibility(0);
      return;
    }
    ForumRegisterActivity.d(this.a).setVisibility(8);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */