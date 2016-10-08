package com.xiaoenai.app.classes.common.image.imagePreview;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.xiaoenai.app.classes.chat.messagelist.message.model.PhotoMessage;
import com.xiaoenai.app.ui.photoview.PhotoView;
import java.io.File;

class u
  implements View.OnClickListener
{
  u(t paramt, File paramFile, PhotoMessage paramPhotoMessage, PhotoView paramPhotoView, Button paramButton) {}
  
  public void onClick(View paramView)
  {
    if (((this.a == null) || (!this.a.exists())) && (!TextUtils.isEmpty(this.b.t()))) {
      this.e.a(this.b.t(), this.c, this.d);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */