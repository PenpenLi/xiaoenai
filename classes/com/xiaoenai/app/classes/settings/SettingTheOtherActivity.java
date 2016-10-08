package com.xiaoenai.app.classes.settings;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.utils.e.b;

public class SettingTheOtherActivity
  extends TitleBarActivity
{
  private void d()
  {
    ImageView localImageView = (ImageView)findViewById(2131559741);
    TextView localTextView1 = (TextView)findViewById(2131559744);
    TextView localTextView2 = (TextView)findViewById(2131559775);
    TextView localTextView3 = (TextView)findViewById(2131559747);
    TextView localTextView4 = (TextView)findViewById(2131559774);
    b.a(localImageView, User.getInstance().getLoverAvatar());
    localTextView1.setText(User.getInstance().getLoverNickName());
    localTextView2.setText(User.getInstance().getLoverEmail());
    localTextView3.setText(User.getInstance().getLoverUserName());
    localTextView4.setText(User.getInstance().getLoverPhoneNum());
  }
  
  public int a()
  {
    return 2130903322;
  }
  
  public void c()
  {
    findViewById(2131559769).setOnClickListener(new an(this));
  }
  
  protected void m()
  {
    super.m();
    d();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c();
    d();
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
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\SettingTheOtherActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */