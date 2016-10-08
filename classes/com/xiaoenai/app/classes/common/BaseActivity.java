package com.xiaoenai.app.classes.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.ui.a.g;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.f.a;

public abstract class BaseActivity
  extends com.xiaoenai.app.common.view.activity.BaseActivity
{
  private UpdateReceiver a;
  private g b;
  protected boolean d = true;
  protected h e;
  
  public void a(String paramString)
  {
    a(paramString, true);
  }
  
  /* Error */
  public void a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 29	com/xiaoenai/app/classes/common/BaseActivity:l_	()V
    //   6: aload_0
    //   7: invokevirtual 33	com/xiaoenai/app/classes/common/BaseActivity:isFinishing	()Z
    //   10: istore_3
    //   11: iload_3
    //   12: ifeq +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: aload_0
    //   20: invokestatic 38	com/xiaoenai/app/ui/a/h:a	(Landroid/content/Context;)Lcom/xiaoenai/app/ui/a/h;
    //   23: putfield 40	com/xiaoenai/app/classes/common/BaseActivity:e	Lcom/xiaoenai/app/ui/a/h;
    //   26: aload_0
    //   27: getfield 40	com/xiaoenai/app/classes/common/BaseActivity:e	Lcom/xiaoenai/app/ui/a/h;
    //   30: iload_2
    //   31: invokevirtual 44	com/xiaoenai/app/ui/a/h:setCancelable	(Z)V
    //   34: aload_1
    //   35: ifnull +11 -> 46
    //   38: aload_0
    //   39: getfield 40	com/xiaoenai/app/classes/common/BaseActivity:e	Lcom/xiaoenai/app/ui/a/h;
    //   42: aload_1
    //   43: invokevirtual 46	com/xiaoenai/app/ui/a/h:a	(Ljava/lang/String;)V
    //   46: aload_0
    //   47: getfield 40	com/xiaoenai/app/classes/common/BaseActivity:e	Lcom/xiaoenai/app/ui/a/h;
    //   50: invokevirtual 49	com/xiaoenai/app/ui/a/h:isShowing	()Z
    //   53: ifne -38 -> 15
    //   56: aload_0
    //   57: invokevirtual 33	com/xiaoenai/app/classes/common/BaseActivity:isFinishing	()Z
    //   60: ifne -45 -> 15
    //   63: aload_0
    //   64: getfield 40	com/xiaoenai/app/classes/common/BaseActivity:e	Lcom/xiaoenai/app/ui/a/h;
    //   67: invokevirtual 52	com/xiaoenai/app/ui/a/h:show	()V
    //   70: goto -55 -> 15
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	BaseActivity
    //   0	78	1	paramString	String
    //   0	78	2	paramBoolean	boolean
    //   10	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	11	73	finally
    //   18	34	73	finally
    //   38	46	73	finally
    //   46	70	73	finally
  }
  
  public void e(String paramString)
  {
    if (!this.d) {}
    do
    {
      do
      {
        return;
      } while ((this.b != null) && (this.b.isShowing()));
      this.b = new g(this);
      this.b.a(paramString);
      this.b.setCancelable(false);
      this.b.a(2131100898, new c(this));
    } while (isFinishing());
    this.b.show();
  }
  
  public void l_()
  {
    if ((!isFinishing()) && (this.e != null) && (this.e.isShowing())) {
      this.e.dismiss();
    }
    this.e = null;
  }
  
  protected void m() {}
  
  public void n()
  {
    e(getResources().getString(2131099960));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = new UpdateReceiver();
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.xiaoenai.onProfileUpdate");
    registerReceiver(this.a, paramBundle, getString(2131101650), null);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.b != null) && (this.b.isShowing())) {
      this.b.dismiss();
    }
    l_();
    unregisterReceiver(this.a);
    a.c("{}：onDestory", new Object[] { getClass().getSimpleName() });
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    a.c("{}：onLowMemory", new Object[] { getClass().getSimpleName() });
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    if ((this.d) && (!AppModel.getInstance().isLogined())) {
      n();
    }
  }
  
  protected void y()
  {
    new q(this).c();
  }
  
  public class UpdateReceiver
    extends BroadcastReceiver
  {
    public UpdateReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      if ((paramContext != null) && (paramContext.equals("com.xiaoenai.onProfileUpdate"))) {
        BaseActivity.this.m();
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\BaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */