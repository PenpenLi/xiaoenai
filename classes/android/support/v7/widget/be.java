package android.support.v7.widget;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

class be
  implements Runnable
{
  be(SearchView paramSearchView) {}
  
  public void run()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.a.getContext().getSystemService("input_method");
    if (localInputMethodManager != null) {
      SearchView.HIDDEN_METHOD_INVOKER.a(localInputMethodManager, this.a, 0);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */