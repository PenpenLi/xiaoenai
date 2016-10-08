package com.xiaoenai.app.classes.extentions.anniversary;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class e
  implements View.OnClickListener
{
  e(AnniversaryActivity.a parama, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.setClass(this.b.a, AnniversaryAddActivity.class);
    paramView.putExtra("index", this.a);
    this.b.a.startActivity(paramView);
    this.b.a.overridePendingTransition(2130968604, 2130968605);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\extentions\anniversary\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */