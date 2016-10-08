package com.xiaoenai.app.feature.photoalbum.view.activity;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.xiaoenai.app.feature.photoalbum.a.b;

class v
  implements TextWatcher
{
  v(PostPhotoActivity paramPostPhotoActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    PostPhotoActivity.a(this.a, PostPhotoActivity.a(this.a) - paramEditable.length());
    PostPhotoActivity.c(this.a).setText(String.valueOf(PostPhotoActivity.b(this.a)));
    if (PostPhotoActivity.b(this.a) < 0)
    {
      PostPhotoActivity.c(this.a).setTextColor(-65536);
      return;
    }
    PostPhotoActivity.c(this.a).setTextColor(this.a.getResources().getColor(a.b.post_hint));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\view\activity\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */