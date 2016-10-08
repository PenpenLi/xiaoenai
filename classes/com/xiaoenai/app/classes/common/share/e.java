package com.xiaoenai.app.classes.common.share;

import android.content.Context;
import android.webkit.WebView;
import cn.sharesdk.framework.Platform;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.extentions.reward.model.BaseTask;
import java.util.HashMap;

public class e
  extends at
{
  private int a = -1;
  private int b = -1;
  private Context c;
  private boolean d = true;
  
  public e() {}
  
  public e(int paramInt1, int paramInt2, Context paramContext)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramContext;
  }
  
  public e(int paramInt1, int paramInt2, Context paramContext, WebView paramWebView, String paramString)
  {
    super(paramWebView, paramString);
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramContext;
  }
  
  public e(WebView paramWebView, String paramString)
  {
    super(paramWebView, paramString);
  }
  
  public void a() {}
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    super.onCancel(paramPlatform, paramInt);
    a();
  }
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    super.onComplete(paramPlatform, paramInt, paramHashMap);
    a();
    if (this.d) {
      Xiaoenai.j().a(new f(this));
    }
    if (this.a != -1) {
      BaseTask.doTaskAction(this.a, 1, this.c);
    }
    if ((this.b == 1) && (paramPlatform != null))
    {
      if (paramPlatform.getId() != 1) {
        break label79;
      }
      paramPlatform.followFriend("2516593910");
    }
    label79:
    while (paramPlatform.getId() != 2) {
      return;
    }
    paramPlatform.followFriend("xiaoenai_com");
  }
  
  public void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable)
  {
    super.onError(paramPlatform, paramInt, paramThrowable);
    a();
    if (this.d) {
      Xiaoenai.j().a(new g(this));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\share\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */