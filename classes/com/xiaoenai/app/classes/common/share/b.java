package com.xiaoenai.app.classes.common.share;

import android.content.Context;
import android.os.Bundle;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.extentions.reward.model.BaseTask;
import com.xiaoenai.app.utils.f.a;

public class b
  implements com.xiaoenai.app.classes.common.a.c
{
  private int a = -1;
  private int b = -1;
  private Context c;
  private boolean d = true;
  private e e = null;
  
  public b() {}
  
  public b(int paramInt1, int paramInt2, Context paramContext)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramContext;
  }
  
  public b(int paramInt1, int paramInt2, Context paramContext, e parame)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramContext;
    this.e = parame;
  }
  
  public b(e parame)
  {
    this.e = parame;
  }
  
  public void a(com.xiaoenai.app.classes.common.a.b paramb)
  {
    paramb = paramb.a();
    if (paramb != null) {
      switch (paramb.getInt("_weibo_resp_errcode"))
      {
      }
    }
    label149:
    do
    {
      do
      {
        return;
        if (this.d) {
          Xiaoenai.j().a(new c(this));
        }
        if (this.a != -1) {
          BaseTask.doTaskAction(this.a, 1, this.c);
        }
        if (this.b == 1)
        {
          paramb = ShareSDK.getPlatform(this.c, SinaWeibo.NAME);
          if (paramb.getId() != 1) {
            break label149;
          }
          paramb.followFriend("2516593910");
        }
        for (;;)
        {
          a.c(" mPlatformActionListener {}", new Object[] { this.e });
          if (this.e == null) {
            break;
          }
          this.e.onComplete(null, 0, null);
          return;
          if (paramb.getId() == 2) {
            paramb.followFriend("xiaoenai_com");
          }
        }
      } while (this.e == null);
      this.e.onCancel(null, 0);
      return;
      if (this.d) {
        Xiaoenai.j().a(new d(this));
      }
    } while (this.e == null);
    this.e.onError(null, 0, null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\share\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */