package com.xiaoenai.app.classes.common.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.xiaoenai.app.classes.common.dialog.a.a;
import com.xiaoenai.app.stat.f;
import com.xiaoenai.app.utils.as;

class v
  extends f
{
  v(p paramp, String paramString1, String paramString2, ShareInfo paramShareInfo, Context paramContext, a parama)
  {
    super(paramString1, paramString2);
  }
  
  public void onClick(View paramView)
  {
    if (this.a.a() != null) {
      this.a.a("【" + this.a.a() + "】 ");
    }
    if (as.h(this.b))
    {
      this.a.d(0);
      paramView = p.a(this.a.b(), this.a.f(), this.a.a());
      this.a.b(paramView);
      p.a(this.b, this.a);
    }
    for (;;)
    {
      this.c.b();
      return;
      paramView = new Intent(this.b, ShareActivity.class);
      this.a.d(0);
      String str = p.a(this.a.b(), this.a.f(), this.a.a());
      this.a.b(str);
      paramView.putExtra("share_data", this.a);
      this.b.startActivity(paramView);
      ((Activity)this.b).overridePendingTransition(2130968604, 2130968605);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\share\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */