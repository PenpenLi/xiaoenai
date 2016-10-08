package com.xiaoenai.app.classes.common.dialog;

import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.xiaoenai.app.ui.component.view.AvatarView;

public class u<T extends InviteDialog>
  implements Unbinder
{
  protected T a;
  
  public u(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.avatarView = ((AvatarView)paramFinder.findRequiredViewAsType(paramObject, 2131558924, "field 'avatarView'", AvatarView.class));
    paramT.messageName = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131558935, "field 'messageName'", TextView.class));
    paramT.mLeftButton = ((Button)paramFinder.findRequiredViewAsType(paramObject, 2131558930, "field 'mLeftButton'", Button.class));
    paramT.mRightButton = ((Button)paramFinder.findRequiredViewAsType(paramObject, 2131558931, "field 'mRightButton'", Button.class));
  }
  
  public void unbind()
  {
    InviteDialog localInviteDialog = this.a;
    if (localInviteDialog == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localInviteDialog.avatarView = null;
    localInviteDialog.messageName = null;
    localInviteDialog.mLeftButton = null;
    localInviteDialog.mRightButton = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\dialog\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */