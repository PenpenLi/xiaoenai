package com.xiaoenai.app.feature.photopreview.view;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class c
  implements View.OnClickListener
{
  c(PreviewActivity paramPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("image_url_index", this.a.x);
    this.a.setResult(-1, paramView);
    this.a.finish();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photopreview\view\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */