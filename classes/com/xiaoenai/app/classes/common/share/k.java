package com.xiaoenai.app.classes.common.share;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

class k
  implements TextWatcher
{
  private int b;
  private int c;
  
  k(ShareActivity paramShareActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (ShareActivity.b(this.a) != 3)
    {
      this.b = this.a.b.getSelectionStart();
      this.c = this.a.b.getSelectionEnd();
      this.a.b.removeTextChangedListener(ShareActivity.c(this.a));
      while (ShareActivity.a(this.a, paramEditable.toString()) > ShareActivity.d())
      {
        paramEditable.delete(this.b - 1, this.c);
        this.b -= 1;
        this.c -= 1;
      }
      this.a.b.setText(paramEditable);
      this.a.b.setSelection(this.b);
      this.a.a.setText("" + (140L - ShareActivity.a(this.a, paramEditable.toString())));
      this.a.b.addTextChangedListener(ShareActivity.c(this.a));
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\share\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */