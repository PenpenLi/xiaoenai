package android.support.v7.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class bp
  implements TextView.OnEditorActionListener
{
  bp(SearchView paramSearchView) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    SearchView.access$900(this.a);
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */