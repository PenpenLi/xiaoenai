package com.xiaoenai.app.classes.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.model.UserConfig;

public class SettingAppConfigActivity
  extends TitleBarActivity
{
  private View a;
  private View b;
  private View c;
  private ImageView i;
  
  private void d()
  {
    boolean bool1 = false;
    boolean bool2 = UserConfig.getBoolean("Audio_mode", Boolean.valueOf(false)).booleanValue();
    if (bool2) {
      this.i.setImageResource(2130837821);
    }
    for (;;)
    {
      if (!bool2) {
        bool1 = true;
      }
      UserConfig.setBoolean("Audio_mode", Boolean.valueOf(bool1));
      return;
      this.i.setImageResource(2130837822);
    }
  }
  
  public int a()
  {
    return 2130903317;
  }
  
  public void a(Class<?> paramClass)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, paramClass);
    startActivity(localIntent);
    overridePendingTransition(2130968604, 2130968605);
  }
  
  public void c()
  {
    this.a = findViewById(2131559736);
    this.a.setOnClickListener(new m(this));
    this.b = findViewById(2131559735);
    this.b.setOnClickListener(new n(this));
    this.c = findViewById(2131559737);
    this.i = ((ImageView)findViewById(2131559732));
    this.c.setOnClickListener(new o(this));
    if (UserConfig.getBoolean("Audio_mode", Boolean.valueOf(false)).booleanValue())
    {
      this.i.setImageResource(2130837822);
      return;
    }
    this.i.setImageResource(2130837821);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      finish();
      overridePendingTransition(2130968606, 2130968607);
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (UserConfig.getBoolean("Audio_mode", Boolean.valueOf(false)).booleanValue())
    {
      this.i.setImageResource(2130837822);
      return;
    }
    this.i.setImageResource(2130837821);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\SettingAppConfigActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */