package com.xiaoenai.app.classes.settings.account;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.newLogin.LoginActivity;
import com.xiaoenai.app.net.r;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.d.w;
import com.xiaoenai.app.widget.CleanableEditText;
import com.xiaoenai.app.widget.TitleBarView;

public class ResetPasswordActivity
  extends TitleBarActivity
{
  private CleanableEditText a = null;
  private CleanableEditText b = null;
  private Button c;
  private String i = null;
  private String j = null;
  private String k = null;
  
  private void a(String paramString1, String paramString2)
  {
    if (!c(paramString1, paramString2)) {
      return;
    }
    ab.b(this);
    new com.xiaoenai.app.net.l(new j(this, this)).e(null, paramString1);
  }
  
  private void b(String paramString)
  {
    com.xiaoenai.app.ui.a.h.c(this, paramString, 1500L);
  }
  
  private void b(String paramString1, String paramString2)
  {
    if (!c(paramString1, paramString2)) {
      return;
    }
    ab.b(this);
    new r(new l(this, this)).b(this.j, paramString1, this.k);
  }
  
  private boolean c(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.equals("")))
    {
      b(getString(2131099976));
      return false;
    }
    if ((paramString1 == null) || (paramString1.length() < 6))
    {
      b(getString(2131099977));
      return false;
    }
    if (!paramString1.equals(paramString2))
    {
      b(getString(2131099978));
      return false;
    }
    return true;
  }
  
  private void d()
  {
    this.a = ((CleanableEditText)findViewById(2131559612));
    this.b = ((CleanableEditText)findViewById(2131559613));
    this.c = ((Button)findViewById(2131559614));
    this.a.requestFocus();
  }
  
  private void f()
  {
    if ((this.i != null) && ((this.i.equals("resetpassword")) || (this.i.equals("findPW"))))
    {
      b(this.a.getText().toString().trim(), this.b.getText().toString().trim());
      return;
    }
    a(this.a.getText().toString().trim(), this.b.getText().toString().trim());
  }
  
  private void g()
  {
    Intent localIntent = new Intent();
    localIntent.setFlags(67108864);
    localIntent.setClass(this, LoginActivity.class);
    startActivity(localIntent);
    finish();
  }
  
  private boolean h()
  {
    boolean bool = false;
    if (this.i.equals("release"))
    {
      i();
      bool = true;
    }
    return bool;
  }
  
  private void i()
  {
    Intent localIntent = new Intent();
    localIntent.setFlags(67108864);
    localIntent.setClass(this, SettingPersonalActivity.class);
    startActivity(localIntent);
    overridePendingTransition(2130968606, 2130968607);
    finish();
  }
  
  public int a()
  {
    return 2130903274;
  }
  
  protected void b()
  {
    super.b();
    if ((this.i != null) && ((this.i.equals("resetpassword")) || (this.i.equals("findPW"))))
    {
      this.g.a(getResources().getString(2131100972), null);
      this.g.a(null, getResources().getString(2131099973));
    }
    do
    {
      return;
      this.g.a(getResources().getDrawable(2130839000), getResources().getString(2131101183));
    } while ((this.i == null) || ((!this.i.equals("setting")) && (!this.i.equals("release"))));
    this.g.a(getResources().getString(2131101150), null);
  }
  
  public void c()
  {
    this.b.setOnEditorActionListener(new g(this));
    this.c.setOnClickListener(new h(this));
    i locali = new i(this);
    this.a.addTextChangedListener(locali);
    this.b.addTextChangedListener(locali);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.i = getIntent().getStringExtra("from");
    if ((this.i != null) && ((this.i.equals("resetpassword")) || (this.i.equals("findPW"))))
    {
      this.j = getIntent().getStringExtra("setting_password_phone_number");
      this.k = getIntent().getStringExtra("setting_password_verify_code");
      this.d = false;
    }
    for (this.f = 1;; this.f = 2)
    {
      super.onCreate(paramBundle);
      d();
      c();
      w.a(this.c);
      return;
    }
  }
  
  public void r()
  {
    if (!h()) {
      super.r();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\ResetPasswordActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */