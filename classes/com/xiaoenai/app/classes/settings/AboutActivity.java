package com.xiaoenai.app.classes.settings;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.common.share.ShareInfo;
import com.xiaoenai.app.classes.common.share.p;
import com.xiaoenai.app.net.l;
import com.xiaoenai.app.widget.TitleBarView;
import org.json.JSONException;
import org.json.JSONObject;

public class AboutActivity
  extends TitleBarActivity
{
  private String a = "com.xiaoenai.setting";
  private TextView b;
  private View c;
  private View i;
  private View j;
  private View k;
  private View l;
  private View m;
  private JSONObject n = null;
  
  private void a(Class<?> paramClass)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, paramClass);
    if (!this.d)
    {
      localIntent.addFlags(268435456);
      localIntent.putExtra("from", 1);
    }
    startActivity(localIntent);
    overridePendingTransition(2130968604, 2130968605);
  }
  
  private void a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, SettingWebPage.class);
    if (!this.d)
    {
      localIntent.addFlags(268435456);
      localIntent.putExtra("from", 1);
    }
    localIntent.setAction(this.a);
    localIntent.putExtra("title", paramString1);
    localIntent.putExtra("url", paramString2);
    startActivity(localIntent);
    overridePendingTransition(2130968604, 2130968605);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    ShareInfo localShareInfo = new ShareInfo();
    try
    {
      localShareInfo.a(paramJSONObject.getString("title"));
      localShareInfo.b(paramJSONObject.getString("content"));
      localShareInfo.d(paramJSONObject.getString("short_content"));
      localShareInfo.c(paramJSONObject.getString("image_url"));
      localShareInfo.e(paramJSONObject.getString("thumb_image_url"));
      localShareInfo.f("http://xiaoenai.com");
      localShareInfo.b(4);
      localShareInfo.c(11);
      localShareInfo.a(1);
      paramJSONObject = new p();
      paramJSONObject.a(this.d);
      paramJSONObject.a(localShareInfo, getString(2131099687), this, new com.xiaoenai.app.classes.common.share.e(11, -1, this));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void b(String paramString)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.setFlags(268435456);
      localIntent.setData(Uri.parse(paramString));
      startActivity(localIntent);
      overridePendingTransition(2130968604, 2130968605);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void g()
  {
    new l(new h(this, this, com.xiaoenai.app.ui.a.h.a(this))).m();
  }
  
  public int a()
  {
    return 2130903310;
  }
  
  protected void b()
  {
    super.b();
    if (getIntent().getIntExtra("from", 0) != 1) {
      this.g.a(2130839000, 2131101252);
    }
    this.g.b(0, 2131099697);
    this.g.setRightButtonClickListener(new a(this));
  }
  
  public void c()
  {
    this.b = ((TextView)findViewById(2131559699));
    this.b.setText(getString(2131099955) + " " + Xiaoenai.j().B);
  }
  
  public void d()
  {
    this.c = findViewById(2131559700);
    this.c.setOnClickListener(new b(this));
    this.i = findViewById(2131559701);
    this.i.setOnClickListener(new c(this));
    this.j = findViewById(2131559702);
    this.j.setOnClickListener(new d(this));
    this.k = findViewById(2131559703);
    this.k.setOnClickListener(new e(this));
    this.l = findViewById(2131559704);
    this.l.setOnClickListener(new f(this));
    this.m = findViewById(2131558626);
    this.m.setVisibility(8);
    this.m.setOnClickListener(new g(this));
  }
  
  public void f()
  {
    if (this.n == null)
    {
      g();
      return;
    }
    a(this.n);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent().getIntExtra("from", 0) == 1) {
      this.d = false;
    }
    c();
    d();
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
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\AboutActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */