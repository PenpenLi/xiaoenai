package com.xiaoenai.app.feature.photoalbum.view.activity;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.xiaoenai.app.feature.photoalbum.e.a;
import java.util.ArrayList;

class w
  implements View.OnClickListener
{
  w(PostPhotoActivity paramPostPhotoActivity) {}
  
  public void onClick(View paramView)
  {
    if ((PostPhotoActivity.d(this.a).getText().length() > 0) || (this.a.e.b().size() > 0))
    {
      PostPhotoActivity.e(this.a);
      return;
    }
    this.a.m_();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\view\activity\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */