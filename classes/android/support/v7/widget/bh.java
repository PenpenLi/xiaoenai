package android.support.v7.widget;

import android.text.Editable;
import android.text.TextWatcher;

class bh
  implements TextWatcher
{
  bh(SearchView paramSearchView) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    SearchView.access$2000(this.a, paramCharSequence);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */