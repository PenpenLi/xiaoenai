package com.xiaoenai.app.classes.common.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import com.xiaoenai.app.classes.common.dialog.a.a;
import com.xiaoenai.app.stat.f;
import com.xiaoenai.app.utils.as;

class ao
  extends f
{
  ao(p paramp, String paramString1, String paramString2, ShareInfo paramShareInfo, Context paramContext, WebView paramWebView, String paramString3, a parama)
  {
    super(paramString1, paramString2);
  }
  
  public void onClick(View paramView)
  {
    this.a.b(this.a.d());
    if (this.a.e() != null) {
      this.a.c(this.a.e());
    }
    if (as.i(this.b))
    {
      this.a.d(3);
      p.a(this.b, this.a, this.c, this.d);
    }
    for (;;)
    {
      this.e.b();
      return;
      paramView = new Intent(this.b, ShareActivity.class);
      this.a.d(3);
      paramView.putExtra("share_data", this.a);
      this.b.startActivity(paramView);
      ((Activity)this.b).overridePendingTransition(2130968604, 2130968605);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\share\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */