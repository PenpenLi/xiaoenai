package com.xiaoenai.app.classes.forum;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.model.Forum.f;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.e.b;

public class ForumMineActivity
  extends TitleBarActivity
{
  protected boolean a = UserConfig.getBoolean("forum_night_theme", Boolean.valueOf(false)).booleanValue();
  @BindView(2131558641)
  ImageView arrow1;
  @BindView(2131558638)
  ImageView avatarImg;
  @BindView(2131558666)
  TextView loadedFlagTxt;
  @BindView(2131558646)
  RelativeLayout myFollowedLayout;
  @BindView(2131558636)
  RelativeLayout myInfoLayout;
  @BindView(2131558642)
  RelativeLayout myTopicLayout;
  @BindView(2131558639)
  TextView nickNameTxt;
  @BindView(2131558658)
  RelativeLayout nightThemeLayout;
  @BindView(2131558660)
  ImageView nightThemeToggleBtn;
  @BindView(2131558654)
  RelativeLayout ruleLayout;
  @BindView(2131558640)
  ImageView sexImg;
  @BindView(2131558650)
  RelativeLayout showoffLayout;
  @BindView(2131558662)
  RelativeLayout wifiLoadedFlagLayout;
  @BindView(2131558664)
  ImageView wifiLoadedFlagToggleBtn;
  @BindView(2131558665)
  ImageView wifiNotifyImg;
  
  private void c()
  {
    b.a(this.avatarImg, User.getInstance().getAvatar());
    if (UserConfig.getBoolean("forum_first_click_wifi_loaded_flag", Boolean.valueOf(false)).booleanValue()) {
      this.wifiNotifyImg.setVisibility(8);
    }
    d();
    f();
    g();
    if (ab.b() <= 480) {
      this.loadedFlagTxt.setTextSize(16.0F);
    }
  }
  
  private void d()
  {
    if (f.d().c())
    {
      if (!UserConfig.getBoolean("forum_night_theme", Boolean.valueOf(false)).booleanValue()) {
        this.nickNameTxt.setTextColor(-16777216);
      }
      this.nickNameTxt.setText(f.d().b);
      this.sexImg.setVisibility(0);
      if (f.d().e == 0)
      {
        this.sexImg.setImageResource(2130838341);
        return;
      }
      this.sexImg.setImageResource(2130838340);
      return;
    }
    this.sexImg.setVisibility(8);
    this.nickNameTxt.setTextColor(-5000269);
    if (User.isSingle())
    {
      this.arrow1.setVisibility(8);
      this.nickNameTxt.setText(2131100410);
      return;
    }
    this.nickNameTxt.setText(2131100408);
  }
  
  private void f()
  {
    if (UserConfig.getBoolean("forum_night_theme", Boolean.valueOf(false)).booleanValue())
    {
      this.nightThemeToggleBtn.setImageResource(2130837822);
      return;
    }
    this.nightThemeToggleBtn.setImageResource(2130837821);
  }
  
  private void g()
  {
    if (UserConfig.getBoolean("forum_wifi_loaded_flag", Boolean.valueOf(false)).booleanValue())
    {
      this.wifiLoadedFlagToggleBtn.setImageResource(2130837822);
      return;
    }
    this.wifiLoadedFlagToggleBtn.setImageResource(2130837821);
  }
  
  private void h()
  {
    this.myInfoLayout.setOnClickListener(new n(this));
    this.myTopicLayout.setOnClickListener(new o(this));
    this.myFollowedLayout.setOnClickListener(new p(this));
    this.showoffLayout.setOnClickListener(new q(this));
    this.ruleLayout.setOnClickListener(new r(this));
    this.nightThemeLayout.setOnClickListener(new s(this));
    this.nightThemeToggleBtn.setOnClickListener(new t(this));
    this.wifiLoadedFlagLayout.setOnClickListener(new u(this));
    this.wifiLoadedFlagToggleBtn.setOnClickListener(new v(this));
  }
  
  private void i()
  {
    if (dm.b(this))
    {
      Intent localIntent = new Intent();
      localIntent.setClass(this, ForumMineInfoActivity.class);
      startActivity(localIntent);
      overridePendingTransition(2130968604, 2130968605);
    }
  }
  
  private void j()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("forum_mine_topic_key", 1);
    localIntent.setClass(this, ForumMineTopicActivity.class);
    startActivity(localIntent);
    overridePendingTransition(2130968604, 2130968605);
  }
  
  private void k()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("forum_mine_topic_key", 2);
    localIntent.setClass(this, ForumMineTopicActivity.class);
    startActivity(localIntent);
    overridePendingTransition(2130968604, 2130968605);
  }
  
  private void o()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, ForumShowoffActivity.class);
    startActivity(localIntent);
    overridePendingTransition(2130968604, 2130968605);
  }
  
  private void p()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, ForumTopicActivity.class);
    localIntent.putExtra("forum_topic_type_key", 2);
    startActivity(localIntent);
    overridePendingTransition(2130968604, 2130968605);
  }
  
  private void q()
  {
    boolean bool = false;
    if (!UserConfig.getBoolean("forum_night_theme", Boolean.valueOf(false)).booleanValue()) {
      bool = true;
    }
    if (bool) {
      this.nightThemeToggleBtn.setImageResource(2130837822);
    }
    for (;;)
    {
      UserConfig.setBoolean("forum_night_theme", Boolean.valueOf(bool));
      a(bool, "notification_to_forum_key", 3);
      return;
      this.nightThemeToggleBtn.setImageResource(2130837821);
    }
  }
  
  private void s()
  {
    boolean bool = false;
    if (!UserConfig.getBoolean("forum_wifi_loaded_flag", Boolean.valueOf(false)).booleanValue()) {
      bool = true;
    }
    if (bool) {
      this.wifiLoadedFlagToggleBtn.setImageResource(2130837822);
    }
    for (;;)
    {
      UserConfig.setBoolean("forum_wifi_loaded_flag", Boolean.valueOf(bool));
      UserConfig.setBoolean("forum_first_click_wifi_loaded_flag", Boolean.valueOf(true));
      this.wifiNotifyImg.setVisibility(8);
      return;
      this.wifiLoadedFlagToggleBtn.setImageResource(2130837821);
    }
  }
  
  public int a()
  {
    return 2130903068;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.d(this.a);
    super.onCreate(paramBundle);
    ButterKnife.bind(this);
    c();
    h();
  }
  
  public void onResume()
  {
    super.onResume();
    d();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\ForumMineActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */