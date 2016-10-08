package com.xiaoenai.app.classes.common.dialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import com.xiaoenai.app.ui.component.view.AvatarView;

public class InviteDialog
  extends a
{
  private View a;
  @BindView(2131558924)
  AvatarView avatarView;
  @BindView(2131558930)
  Button mLeftButton;
  @BindView(2131558931)
  Button mRightButton;
  @BindView(2131558935)
  TextView messageName;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\dialog\InviteDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */