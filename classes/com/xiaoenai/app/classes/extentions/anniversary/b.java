package com.xiaoenai.app.classes.extentions.anniversary;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.ui.a.g;
import java.util.ArrayList;

class b
  implements View.OnClickListener
{
  b(AnniversaryActivity paramAnniversaryActivity) {}
  
  public void onClick(View paramView)
  {
    if (ai.a().b().size() >= 100)
    {
      paramView = new g(this.a);
      paramView.a(2131099944);
      paramView.a(2131100898, new c(this));
      paramView.show();
      return;
    }
    paramView = new Intent();
    paramView.setClass(this.a, AnniversaryAddActivity.class);
    this.a.startActivity(paramView);
    this.a.overridePendingTransition(2130968604, 2130968605);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\anniversary\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */