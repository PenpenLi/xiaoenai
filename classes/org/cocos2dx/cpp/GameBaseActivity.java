package org.cocos2dx.cpp;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import com.f.a.b;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.lock.LockScreenActivity;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.stat.StatEntry;
import com.xiaoenai.app.stat.j;
import com.xiaoenai.app.ui.a.g;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.utils.f.a;
import org.cocos2dx.lib.Cocos2dxActivity;

public abstract class GameBaseActivity
  extends Cocos2dxActivity
{
  protected boolean a = true;
  protected com.xiaoenai.app.ui.a.h b;
  private int c = 0;
  private UpdateReceiver d;
  private g e;
  private String f = "";
  
  protected void a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      try
      {
        if (paramView.getBackground() != null) {
          paramView.getBackground().setCallback(null);
        }
        paramView.setBackgroundDrawable(null);
        if ((paramView instanceof ImageView))
        {
          ((ImageView)paramView).setImageDrawable(null);
          return;
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
        if (!(paramView instanceof ViewGroup)) {
          continue;
        }
        if (paramInt1 <= paramInt2)
        {
          int i = 0;
          while (i < ((ViewGroup)paramView).getChildCount())
          {
            a(((ViewGroup)paramView).getChildAt(i), paramInt1 + 1, paramInt2);
            i += 1;
          }
        }
        if ((paramView instanceof AdapterView)) {
          continue;
        }
        ((ViewGroup)paramView).removeAllViews();
        return;
      }
      catch (Error paramView)
      {
        for (;;) {}
      }
    }
  }
  
  public void a(StatEntry paramStatEntry)
  {
    j.a().a(paramStatEntry, this, this.f, getComponentName().getClassName());
  }
  
  /* Error */
  public void a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 105	org/cocos2dx/cpp/GameBaseActivity:b	()V
    //   6: aload_0
    //   7: invokevirtual 109	org/cocos2dx/cpp/GameBaseActivity:isFinishing	()Z
    //   10: istore_3
    //   11: iload_3
    //   12: ifeq +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: aload_0
    //   20: invokestatic 114	com/xiaoenai/app/ui/a/h:a	(Landroid/content/Context;)Lcom/xiaoenai/app/ui/a/h;
    //   23: putfield 116	org/cocos2dx/cpp/GameBaseActivity:b	Lcom/xiaoenai/app/ui/a/h;
    //   26: aload_0
    //   27: getfield 116	org/cocos2dx/cpp/GameBaseActivity:b	Lcom/xiaoenai/app/ui/a/h;
    //   30: iload_2
    //   31: invokevirtual 120	com/xiaoenai/app/ui/a/h:setCancelable	(Z)V
    //   34: aload_1
    //   35: ifnull +11 -> 46
    //   38: aload_0
    //   39: getfield 116	org/cocos2dx/cpp/GameBaseActivity:b	Lcom/xiaoenai/app/ui/a/h;
    //   42: aload_1
    //   43: invokevirtual 123	com/xiaoenai/app/ui/a/h:a	(Ljava/lang/String;)V
    //   46: aload_0
    //   47: getfield 116	org/cocos2dx/cpp/GameBaseActivity:b	Lcom/xiaoenai/app/ui/a/h;
    //   50: invokevirtual 126	com/xiaoenai/app/ui/a/h:isShowing	()Z
    //   53: ifne -38 -> 15
    //   56: aload_0
    //   57: invokevirtual 109	org/cocos2dx/cpp/GameBaseActivity:isFinishing	()Z
    //   60: ifne -45 -> 15
    //   63: aload_0
    //   64: getfield 116	org/cocos2dx/cpp/GameBaseActivity:b	Lcom/xiaoenai/app/ui/a/h;
    //   67: invokevirtual 129	com/xiaoenai/app/ui/a/h:show	()V
    //   70: goto -55 -> 15
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	GameBaseActivity
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
  
  public void b()
  {
    if ((this.b != null) && (this.b.isShowing())) {
      this.b.dismiss();
    }
    this.b = null;
  }
  
  public void c()
  {
    if (!this.a) {}
    do
    {
      do
      {
        return;
      } while ((this.e != null) && (this.e.isShowing()));
      this.e = new g(this);
      this.e.a(2131099960);
      this.e.setCancelable(false);
      this.e.a(2131100898, new h(this));
    } while (isFinishing());
    this.e.show();
  }
  
  protected void d() {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    a.c("onActivityResult requestCode={} resultCode={} data={}", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.c = com.xiaoenai.app.stat.h.c();
    com.xiaoenai.app.stat.h.a().a(this.c);
    this.d = new UpdateReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.xiaoenai.onProfileUpdate");
    registerReceiver(this.d, localIntentFilter);
    a.c(getIntent().toString(), new Object[0]);
    a.c("{}：onCreate", new Object[] { getClass().getSimpleName() });
    if (paramBundle != null)
    {
      a.c("savedInstanceState={}", new Object[] { paramBundle });
      Xiaoenai.j().a(UserConfig.getBoolean("lock_show_lock", Boolean.valueOf(false)).booleanValue());
      UserConfig.setBoolean("lock_show_lock", Boolean.valueOf(Xiaoenai.j().q()));
    }
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.f = paramBundle.getStringExtra("stat_caller");
      paramBundle = new StatEntry();
      a(paramBundle);
      com.xiaoenai.app.stat.h.a().a(paramBundle);
    }
  }
  
  protected void onDestroy()
  {
    if ((this.e != null) && (this.e.isShowing())) {
      this.e.dismiss();
    }
    b();
    unregisterReceiver(this.d);
    super.onDestroy();
    a(getWindow().getDecorView(), 0, 20);
    a.c("{}：onDestory", new Object[] { getClass().getSimpleName() });
    System.gc();
    Runtime.getRuntime().gc();
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    a.c("{}：onLowMemory", new Object[] { getClass().getSimpleName() });
    System.gc();
    Runtime.getRuntime().gc();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    a.c("{}：onNewIntent", new Object[] { getClass().getSimpleName() });
  }
  
  protected void onPause()
  {
    super.onPause();
    a.c("isScreenLock {}", new Object[] { Boolean.valueOf(Xiaoenai.j().q()) });
    a.c("{}：onPause", new Object[] { getClass().getSimpleName() });
    b.a(this);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    a.c("{}：onRestoreInstanceState", new Object[] { getClass().getSimpleName() });
  }
  
  protected void onResume()
  {
    super.onResume();
    a.c("isScreenLock {}", new Object[] { Boolean.valueOf(Xiaoenai.j().q()) });
    b.b(this);
    if ((this.a) && (!AppModel.getInstance().isLogined())) {
      c();
    }
    a.c("{}：onResume", new Object[] { getClass().getSimpleName() });
    if (Xiaoenai.j().d()) {
      Xiaoenai.j().b();
    }
    a.c("hasScreenLock {} {}", new Object[] { Boolean.valueOf(Xiaoenai.j().q()), Boolean.valueOf(as.e()) });
    if ((Xiaoenai.j().q()) && (AppModel.getInstance().isLogined()) && (as.e()))
    {
      LockScreenActivity.a(this);
      Xiaoenai.j().a(false);
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    a.c("{}：onSaveInstanceState", new Object[] { getClass().getSimpleName() });
  }
  
  protected void onStart()
  {
    super.onStart();
    a.c("{}：onStart", new Object[] { getClass().getSimpleName() });
  }
  
  protected void onStop()
  {
    super.onStop();
    a.c("{}：onStop", new Object[] { getClass().getSimpleName() });
    boolean bool = as.e(this);
    if (!bool) {
      Xiaoenai.j().c();
    }
    if ((AppModel.getInstance().isLogined()) && (!bool) && (as.e()))
    {
      Xiaoenai.j().a(true);
      UserConfig.setBoolean("lock_show_lock", Boolean.valueOf(true));
    }
    a.c("isScreenLock {}", new Object[] { Boolean.valueOf(Xiaoenai.j().q()) });
  }
  
  public void startActivity(Intent paramIntent)
  {
    paramIntent.putExtra("stat_caller", getComponentName().getClassName());
    super.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    paramIntent.putExtra("stat_caller", getComponentName().getClassName());
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  public class UpdateReceiver
    extends BroadcastReceiver
  {
    public UpdateReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      if ((paramContext != null) && (paramContext.equals("com.xiaoenai.onProfileUpdate"))) {
        GameBaseActivity.this.d();
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\cpp\GameBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */