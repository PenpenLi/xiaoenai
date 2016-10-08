package com.xiaoenai.app.classes.common.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.xiaoenai.app.classes.common.dialog.a.a;
import com.xiaoenai.app.stat.f;
import com.xiaoenai.app.utils.as;

class aj
  extends f
{
  aj(p paramp, String paramString1, String paramString2, ShareInfo paramShareInfo, Context paramContext, a parama)
  {
    super(paramString1, paramString2);
  }
  
  public void onClick(View paramView)
  {
    this.a.b(this.a.d());
    this.a.c(this.a.e());
    if (as.i(this.b))
    {
      this.a.d(3);
      p.a(this.b, this.a);
    }
    for (;;)
    {
      this.c.b();
      return;
      paramView = new Intent(this.b, ShareActivity.class);
      this.a.d(3);
      paramView.putExtra("hasAuthFailDialog", p.a(this.d));
      paramView.putExtra("share_data", this.a);
      this.b.startActivity(paramView);
      ((Activity)this.b).overridePendingTransition(2130968604, 2130968605);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\share\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */