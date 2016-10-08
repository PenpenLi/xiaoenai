package com.xiaoenai.app.classes.common.dialog;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;

public class p<T extends EditDialog>
  implements Unbinder
{
  protected T a;
  
  public p(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.messageText = ((EditText)paramFinder.findRequiredViewAsType(paramObject, 2131558928, "field 'messageText'", EditText.class));
    paramT.mTv_title = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131558923, "field 'mTv_title'", TextView.class));
    paramT.mLeftButton = ((Button)paramFinder.findRequiredViewAsType(paramObject, 2131558930, "field 'mLeftButton'", Button.class));
    paramT.mRightButton = ((Button)paramFinder.findRequiredViewAsType(paramObject, 2131558931, "field 'mRightButton'", Button.class));
  }
  
  public void unbind()
  {
    EditDialog localEditDialog = this.a;
    if (localEditDialog == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localEditDialog.messageText = null;
    localEditDialog.mTv_title = null;
    localEditDialog.mLeftButton = null;
    localEditDialog.mRightButton = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\dialog\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */