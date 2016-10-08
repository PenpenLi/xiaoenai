package com.xiaoenai.app.feature.photoalbum.view.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.xiaoenai.app.feature.photoalbum.e.a;
import java.util.ArrayList;

class x
  implements View.OnClickListener
{
  x(PostPhotoActivity paramPostPhotoActivity) {}
  
  public void onClick(View paramView)
  {
    if (PostPhotoActivity.b(this.a) < 0) {
      PostPhotoActivity.b(this.a, 0);
    }
    do
    {
      return;
      if (PostPhotoActivity.f(this.a) + this.a.e.b().size() > 5000)
      {
        PostPhotoActivity.b(this.a, 1);
        return;
      }
    } while (this.a.e.b().size() <= 0);
    this.a.e.a(this.a, PostPhotoActivity.d(this.a).getText().toString());
    this.a.finish();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\view\activity\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */