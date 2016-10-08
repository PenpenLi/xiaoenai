package com.xiaoenai.app.classes.settings;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.model.UserConfig;

public class SettingAlertActivity
  extends TitleBarActivity
{
  private View a;
  private View b;
  private ImageView c;
  private ImageView i;
  
  private void a(ImageView paramImageView)
  {
    boolean bool2 = true;
    boolean bool3;
    boolean bool1;
    if (paramImageView == this.i)
    {
      bool3 = UserConfig.getBoolean("setting_vibrate", Boolean.valueOf(true)).booleanValue();
      if (!bool3)
      {
        bool1 = true;
        UserConfig.setBoolean("setting_vibrate", Boolean.valueOf(bool1));
        bool1 = bool3;
      }
    }
    for (;;)
    {
      if (!bool1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        a(paramImageView, bool1);
        return;
        bool1 = false;
        break;
        if (paramImageView != this.c) {
          break label115;
        }
        bool3 = UserConfig.getBoolean("setting_sound", Boolean.valueOf(true)).booleanValue();
        if (!bool3) {}
        for (bool1 = true;; bool1 = false)
        {
          UserConfig.setBoolean("setting_sound", Boolean.valueOf(bool1));
          bool1 = bool3;
          break;
        }
      }
      label115:
      bool1 = false;
    }
  }
  
  private void a(ImageView paramImageView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramImageView.setImageResource(2130837822);
      return;
    }
    paramImageView.setImageResource(2130837821);
  }
  
  public int a()
  {
    return 2130903316;
  }
  
  public void c()
  {
    this.c = ((ImageView)findViewById(2131559732));
    this.c.setOnClickListener(new i(this));
    a(this.c, UserConfig.getBoolean("setting_sound", Boolean.valueOf(true)).booleanValue());
    this.i = ((ImageView)findViewById(2131559734));
    this.i.setOnClickListener(new j(this));
    a(this.i, UserConfig.getBoolean("setting_vibrate", Boolean.valueOf(true)).booleanValue());
    this.a = findViewById(2131559731);
    this.a.setOnClickListener(new k(this));
    this.b = findViewById(2131559733);
    this.b.setOnClickListener(new l(this));
  }
  
  public void onCreate(Bundle paramBundle)
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
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\SettingAlertActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */