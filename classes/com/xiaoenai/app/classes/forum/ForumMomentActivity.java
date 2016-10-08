package com.xiaoenai.app.classes.forum;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.forum.fragment.b;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.widget.TitleBarView;

public class ForumMomentActivity
  extends TitleBarActivity
{
  protected boolean a = UserConfig.getBoolean("forum_night_theme", Boolean.valueOf(false)).booleanValue();
  private Bundle b = null;
  
  private void c()
  {
    this.g.setLeftButtonClickListener(new az(this));
    if (getIntent() != null)
    {
      String str = getIntent().getStringExtra("from");
      if ((!TextUtils.isEmpty(str)) && (str.equals("notification"))) {
        this.g.a(2130839000, 2131100897);
      }
    }
  }
  
  public int a()
  {
    return 2130903201;
  }
  
  public void b(String paramString)
  {
    this.g.setTitle(paramString);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.d(this.a);
    super.onCreate(paramBundle);
    c();
    this.b = getIntent().getExtras();
    paramBundle = new b();
    if (this.b != null) {
      paramBundle.setArguments(this.b);
    }
    getSupportFragmentManager().beginTransaction().add(2131558817, paramBundle).commit();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\ForumMomentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */