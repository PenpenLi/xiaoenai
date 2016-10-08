package com.xiaoenai.app.classes.common;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.AppSettings;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.widget.wheel.WheelView;
import com.xiaoenai.tool.log.d;

public class DebugActivity
  extends TitleBarActivity
{
  private boolean a;
  @BindView(2131558625)
  ImageView mAnalyticImg;
  @BindView(2131558624)
  View mAnalyticsDebug;
  @BindView(2131558626)
  View mDebugLayout;
  @BindView(2131558627)
  TextView mDebugText;
  @BindView(2131558631)
  EditText mDevEdt;
  @BindView(2131558630)
  View mDevIp;
  @BindView(2131558632)
  Button mDevIpBtn;
  @BindView(2131558628)
  WheelView mEnvWheel;
  @BindView(2131558621)
  ImageView mImageView;
  @BindView(2131558587)
  ScrollView mScrollView;
  @BindView(2131558620)
  View mSuspendLog;
  @BindView(2131558623)
  ImageView mWebImg;
  @BindView(2131558622)
  View mWebViewDebug;
  
  private void a(int paramInt)
  {
    if (paramInt == 5)
    {
      this.mDevIp.setVisibility(0);
      return;
    }
    this.mDevIp.setVisibility(8);
  }
  
  private void c()
  {
    this.a = AppSettings.getBoolean(AppSettings.getString("setting_environment", getResources().getStringArray(2131427329)[0]), Boolean.valueOf(false)).booleanValue();
    f();
    this.mSuspendLog.setOnClickListener(new f(this));
    this.mWebViewDebug.setOnClickListener(new g(this));
    this.mAnalyticsDebug.setOnClickListener(new h(this));
  }
  
  private void d()
  {
    ImageView localImageView = this.mAnalyticImg;
    if (com.xiaoenai.app.a.c.a()) {}
    for (int i = 2130837822;; i = 2130837821)
    {
      localImageView.setImageResource(i);
      return;
    }
  }
  
  private void f()
  {
    ImageView localImageView = this.mWebImg;
    if (this.a) {}
    for (int i = 2130837822;; i = 2130837821)
    {
      localImageView.setImageResource(i);
      return;
    }
  }
  
  private void g()
  {
    if (d.c(getApplicationContext()))
    {
      this.mImageView.setImageResource(2130837822);
      return;
    }
    this.mImageView.setImageResource(2130837821);
  }
  
  private void h()
  {
    ButterKnife.bind(this);
    this.mDebugLayout.setVisibility(8);
    this.mDebugLayout.setOnClickListener(new i(this));
    this.mEnvWheel.setCyclic(true);
    this.mEnvWheel.setVisibleItems(getResources().getStringArray(2131427329).length);
    this.mEnvWheel.setViewAdapter(new com.xiaoenai.app.widget.wheel.a.c(this, getResources().getStringArray(2131427329)));
    this.mEnvWheel.a(new j(this));
    this.mEnvWheel.setOnTouchListener(new k(this));
    String[] arrayOfString = getResources().getStringArray(2131427329);
    int k = arrayOfString.length;
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (i < k)
      {
        if (arrayOfString[i].equals(AppSettings.getString("setting_environment", getResources().getStringArray(2131427329)[0]))) {
          this.mEnvWheel.setCurrentItem(j);
        }
      }
      else
      {
        findViewById(2131558629).setOnClickListener(new l(this));
        i();
        return;
      }
      j += 1;
      i += 1;
    }
  }
  
  private void i()
  {
    this.mDevIpBtn.setOnClickListener(new m(this));
  }
  
  private void j()
  {
    String str = UserConfig.getString("dev_env_ip", Xiaoenai.v);
    this.mDevEdt.setHint(str);
  }
  
  public int a()
  {
    return 2130903066;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.d = false;
    super.onCreate(paramBundle);
    h();
    c();
    g();
    d();
  }
  
  protected void onStart()
  {
    super.onStart();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\DebugActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */