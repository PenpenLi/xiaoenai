package com.xiaoenai.app.classes.common.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import com.xiaoenai.app.classes.common.dialog.a.a;
import com.xiaoenai.app.stat.f;
import com.xiaoenai.app.utils.as;

class an
  extends f
{
  an(p paramp, String paramString1, String paramString2, Context paramContext, ShareInfo paramShareInfo, WebView paramWebView, String paramString3, a parama)
  {
    super(paramString1, paramString2);
  }
  
  public void onClick(View paramView)
  {
    if (as.h(this.a))
    {
      this.b.d(0);
      p.a(this.a, this.b, this.c, this.d);
    }
    for (;;)
    {
      this.e.b();
      return;
      paramView = new Intent(this.a, ShareActivity.class);
      this.b.d(0);
      paramView.putExtra("share_data", this.b);
      this.a.startActivity(paramView);
      ((Activity)this.a).overridePendingTransition(2130968604, 2130968605);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\share\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */