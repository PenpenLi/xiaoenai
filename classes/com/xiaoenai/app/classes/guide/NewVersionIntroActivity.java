package com.xiaoenai.app.classes.guide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.xiaoenai.app.classes.common.BaseActivity;
import com.xiaoenai.app.classes.home.HomeActivity;
import com.xiaoenai.app.common.application.a.a;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.l;
import com.xiaoenai.app.utils.ab;
import org.json.JSONObject;

public class NewVersionIntroActivity
  extends BaseActivity
{
  JSONObject a = null;
  private ViewPager b;
  private PagerAdapter c;
  private LinearLayout f;
  private int g = 0;
  
  private void b()
  {
    new l(new k(this, this)).t();
  }
  
  public void a()
  {
    Intent localIntent = new Intent(this, HomeActivity.class);
    localIntent.putExtra("from", getIntent().getStringExtra("from"));
    startActivity(localIntent);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    b();
    setContentView(2130903231);
    this.b = ((ViewPager)findViewById(2131559366));
    this.c = new a(getSupportFragmentManager());
    this.b.setAdapter(this.c);
    this.f = ((LinearLayout)findViewById(2131558785));
    int i = 0;
    while (i < 4)
    {
      paramBundle = new ImageView(this);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(ab.a(4.0F), ab.a(4.0F));
      localLayoutParams.leftMargin = ab.a(4.0F);
      localLayoutParams.rightMargin = ab.a(4.0F);
      paramBundle.setLayoutParams(localLayoutParams);
      paramBundle.setImageResource(2130837787);
      paramBundle.setSelected(false);
      this.f.addView(paramBundle);
      i += 1;
    }
    this.f.getChildAt(0).setSelected(true);
    this.b.setOnPageChangeListener(new j(this));
    UserConfig.setString("cur_version", "v5.6.0");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return true;
  }
  
  protected void onResume()
  {
    super.onResume();
    this.r.b();
  }
  
  private class a
    extends FragmentStatePagerAdapter
  {
    private Fragment b;
    
    public a(FragmentManager paramFragmentManager)
    {
      super();
    }
    
    public Fragment a()
    {
      return this.b;
    }
    
    public int getCount()
    {
      return 4;
    }
    
    public Fragment getItem(int paramInt)
    {
      f localf = new f();
      localf.a(paramInt);
      if (paramInt == 3) {
        this.b = localf;
      }
      return localf;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\guide\NewVersionIntroActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */