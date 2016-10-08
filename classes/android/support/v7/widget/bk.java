package android.support.v7.widget;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class bk
  implements View.OnFocusChangeListener
{
  bk(SearchView paramSearchView) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (SearchView.access$200(this.a) != null) {
      SearchView.access$200(this.a).onFocusChange(this.a, paramBoolean);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */