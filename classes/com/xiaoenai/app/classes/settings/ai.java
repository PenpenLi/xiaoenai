package com.xiaoenai.app.classes.settings;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.xiaoenai.app.classes.common.dialog.EditDialog;
import com.xiaoenai.app.classes.common.dialog.EditDialog.a;
import com.xiaoenai.app.classes.common.q;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.ab;

class ai
  implements EditDialog.a
{
  ai(SettingReleaseActivity paramSettingReleaseActivity, EditDialog paramEditDialog) {}
  
  public void a(View paramView, EditText paramEditText)
  {
    if (paramEditText.getText().length() >= 6)
    {
      if (User.getInstance().getLoverId() > 0)
      {
        paramView = paramEditText.getText().toString();
        if ((paramView != null) && (paramView.length() >= 6)) {
          new q(this.b).a(paramView);
        }
      }
      paramEditText.setText("");
    }
    for (;;)
    {
      ab.b(this.b);
      this.a.dismiss();
      return;
      h.c(this.b, 2131101042, 1500L);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */