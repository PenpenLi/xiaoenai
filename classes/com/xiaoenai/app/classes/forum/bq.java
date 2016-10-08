package com.xiaoenai.app.classes.forum;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.widget.EditText;

class bq
  implements DialogInterface.OnDismissListener
{
  bq(ForumPostActivity paramForumPostActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ForumPostActivity.e(this.a).postDelayed(new br(this), 500L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */