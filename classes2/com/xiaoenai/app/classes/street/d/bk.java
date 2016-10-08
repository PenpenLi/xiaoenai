package com.xiaoenai.app.classes.street.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.common.dialog.e;
import com.xiaoenai.app.classes.street.StreetCommentProductActitvity;
import com.xiaoenai.app.classes.street.model.Comment;

final class bk
  implements View.OnClickListener
{
  bk(e parame, Comment paramComment, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    paramView = new Intent();
    paramView.putExtra("street_comment_id_key", this.b.getId());
    paramView.setClass(this.c, StreetCommentProductActitvity.class);
    ((Activity)this.c).startActivityForResult(paramView, 100);
    ((Activity)this.c).overridePendingTransition(2130968606, 2130968607);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\d\bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */