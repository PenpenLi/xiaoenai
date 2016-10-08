package com.sina.weibo.sdk.api.share.ui;

import android.text.Editable;
import android.text.Selection;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;

class EditBlogView$1
  extends InputConnectionWrapper
{
  EditBlogView$1(EditBlogView paramEditBlogView, InputConnection paramInputConnection, boolean paramBoolean)
  {
    super(paramInputConnection, paramBoolean);
  }
  
  public boolean commitText(CharSequence paramCharSequence, int paramInt)
  {
    Editable localEditable = this.this$0.getEditableText();
    new String(localEditable.toString());
    int m = Selection.getSelectionStart(localEditable);
    int n = Selection.getSelectionEnd(localEditable);
    int i;
    int j;
    int k;
    if ((m != -1) && (n != -1))
    {
      i = this.this$0.correctPosition(m);
      j = this.this$0.correctPosition(n);
      if (i <= j) {
        break label136;
      }
      k = j;
      j = i;
    }
    for (;;)
    {
      if ((k != m) || (j != n)) {
        Selection.setSelection(localEditable, k, j);
      }
      if (k != j) {
        this.this$0.getText().delete(k, j);
      }
      return super.commitText(paramCharSequence, paramInt);
      label136:
      k = i;
    }
  }
  
  public boolean setComposingText(CharSequence paramCharSequence, int paramInt)
  {
    Editable localEditable = this.this$0.getEditableText();
    new String(localEditable.toString());
    int m = Selection.getSelectionStart(localEditable);
    int n = Selection.getSelectionEnd(localEditable);
    int i;
    int j;
    int k;
    if ((m != -1) && (n != -1))
    {
      i = this.this$0.correctPosition(m);
      j = this.this$0.correctPosition(n);
      if (i <= j) {
        break label136;
      }
      k = j;
      j = i;
    }
    for (;;)
    {
      if ((k != m) || (j != n)) {
        Selection.setSelection(localEditable, k, j);
      }
      if (k != j) {
        this.this$0.getText().delete(k, j);
      }
      return super.setComposingText(paramCharSequence, paramInt);
      label136:
      k = i;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\api\share\ui\EditBlogView$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */