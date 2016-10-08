package com.xiaoenai.app.feature.photopreview.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.xiaoenai.app.utils.d.i;

class b
  implements View.OnClickListener
{
  b(PreviewActivity paramPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a;
    if (!this.a.v) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.v = bool;
      this.a.k.setSelected(this.a.v);
      long l = i.a(this.a.t[this.a.x]);
      this.a.b(l);
      if (PreviewActivity.a(this.a) != null) {
        PreviewActivity.a(this.a).a(this.a.v);
      }
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photopreview\view\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */