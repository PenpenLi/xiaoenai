package com.xiaoenai.app.classes.common.share;

import android.content.Context;
import android.view.View;
import cn.sharesdk.framework.PlatformActionListener;
import com.xiaoenai.app.classes.common.dialog.a.a;
import com.xiaoenai.app.stat.f;

class r
  extends f
{
  r(p paramp, String paramString1, String paramString2, ShareInfo paramShareInfo, l paraml, Context paramContext, PlatformActionListener paramPlatformActionListener, a parama)
  {
    super(paramString1, paramString2);
  }
  
  public void onClick(View paramView)
  {
    this.a.b(this.a.d());
    if (this.a.e() != null) {
      this.a.c(this.a.e());
    }
    this.b.d(this.a, this.c, this.d);
    this.e.b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\share\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */