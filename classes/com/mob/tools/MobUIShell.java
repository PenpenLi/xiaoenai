package com.mob.tools;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.mob.tools.b.h;
import com.mob.tools.log.d;
import java.util.HashMap;

public class MobUIShell
  extends Activity
{
  public static int a;
  private static HashMap<String, a> b = new HashMap();
  private a c;
  
  static
  {
    e.a().d("===============================", new Object[0]);
    String str = "2016-02-23".replace("-0", "-").replace("-", ".");
    e.a().d("MobTools " + str, new Object[0]);
    e.a().d("===============================", new Object[0]);
  }
  
  protected static String a(Object paramObject)
  {
    return a(String.valueOf(System.currentTimeMillis()), paramObject);
  }
  
  protected static String a(String paramString, Object paramObject)
  {
    b.put(paramString, (a)paramObject);
    return paramString;
  }
  
  public a a()
  {
    try
    {
      String str = getPackageManager().getActivityInfo(getComponentName(), 128).metaData.getString("defaultActivity");
      if (!TextUtils.isEmpty(str))
      {
        Object localObject = str;
        if (str.startsWith(".")) {
          localObject = getPackageName() + str;
        }
        localObject = h.a((String)localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = h.a((String)localObject, new Object[0]);
          if ((localObject != null) && ((localObject instanceof a)))
          {
            localObject = (a)localObject;
            return (a)localObject;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      e.a().w(localThrowable);
    }
    return null;
  }
  
  public void finish()
  {
    if ((this.c != null) && (this.c.onFinish())) {
      return;
    }
    super.finish();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.c != null) {
      this.c.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.c != null) {
      this.c.onConfigurationChanged(paramConfiguration);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Object localObject = getIntent();
    String str1 = ((Intent)localObject).getStringExtra("launch_time");
    String str2 = ((Intent)localObject).getStringExtra("executor_name");
    this.c = ((a)b.remove(str1));
    if (this.c == null)
    {
      localObject = ((Intent)localObject).getScheme();
      this.c = ((a)b.remove(localObject));
      if (this.c == null)
      {
        this.c = a();
        if (this.c == null)
        {
          e.a().w(new RuntimeException("Executor lost! launchTime = " + str1 + ", executorName: " + str2));
          super.onCreate(paramBundle);
          finish();
          return;
        }
      }
    }
    e.a().i("MobUIShell found executor: " + this.c.getClass(), new Object[0]);
    this.c.setActivity(this);
    super.onCreate(paramBundle);
    e.a().d(this.c.getClass().getSimpleName() + " onCreate", new Object[0]);
    this.c.onCreate();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    if (this.c != null) {
      bool = this.c.onCreateOptionsMenu(paramMenu);
    }
    return bool;
  }
  
  protected void onDestroy()
  {
    if (this.c != null)
    {
      this.c.sendResult();
      e.a().d(this.c.getClass().getSimpleName() + " onDestroy", new Object[0]);
      this.c.onDestroy();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (this.c != null) {
      bool = this.c.onKeyEvent(paramInt, paramKeyEvent);
    }
    if (bool) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (this.c != null) {
      bool = this.c.onKeyEvent(paramInt, paramKeyEvent);
    }
    if (bool) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    if (this.c == null)
    {
      super.onNewIntent(paramIntent);
      return;
    }
    this.c.onNewIntent(paramIntent);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool = super.onOptionsItemSelected(paramMenuItem);
    if (this.c != null) {
      bool = this.c.onOptionsItemSelected(paramMenuItem);
    }
    return bool;
  }
  
  protected void onPause()
  {
    if (this.c != null)
    {
      e.a().d(this.c.getClass().getSimpleName() + " onPause", new Object[0]);
      this.c.onPause();
    }
    super.onPause();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.c != null) {
      this.c.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
  }
  
  protected void onRestart()
  {
    if (this.c != null)
    {
      e.a().d(this.c.getClass().getSimpleName() + " onRestart", new Object[0]);
      this.c.onRestart();
    }
    super.onRestart();
  }
  
  protected void onResume()
  {
    if (this.c != null)
    {
      e.a().d(this.c.getClass().getSimpleName() + " onResume", new Object[0]);
      this.c.onResume();
    }
    super.onResume();
  }
  
  protected void onStart()
  {
    if (this.c != null)
    {
      e.a().d(this.c.getClass().getSimpleName() + " onStart", new Object[0]);
      this.c.onStart();
    }
    super.onStart();
  }
  
  protected void onStop()
  {
    if (this.c != null)
    {
      e.a().d(this.c.getClass().getSimpleName() + " onStop", new Object[0]);
      this.c.onStop();
    }
    super.onStop();
  }
  
  public void setContentView(int paramInt)
  {
    setContentView(LayoutInflater.from(this).inflate(paramInt, null));
  }
  
  public void setContentView(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      super.setContentView(paramView);
    } while (this.c == null);
    this.c.setContentView(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      if (paramLayoutParams == null) {
        super.setContentView(paramView);
      }
      while (this.c != null)
      {
        this.c.setContentView(paramView);
        return;
        super.setContentView(paramView, paramLayoutParams);
      }
    }
  }
  
  public void setTheme(int paramInt)
  {
    if (a > 0)
    {
      super.setTheme(a);
      return;
    }
    super.setTheme(paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\MobUIShell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */