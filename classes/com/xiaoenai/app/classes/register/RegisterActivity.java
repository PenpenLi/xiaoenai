package com.xiaoenai.app.classes.register;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.guide.NewVersionIntroActivity;
import com.xiaoenai.app.classes.home.HomeActivity;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.am;
import com.xiaoenai.app.utils.am.a;
import javax.inject.Inject;

public class RegisterActivity
  extends TitleBarActivity
{
  protected View a;
  @Inject
  protected com.xiaoenai.app.common.application.a.a b;
  private EditText c;
  private EditText i;
  private ImageView j;
  private ScrollView k;
  private String l = null;
  private com.xiaoenai.app.ui.a.h m;
  
  private void a(String paramString1, String paramString2)
  {
    String str = String.format(getString(2131101029), new Object[] { paramString1 });
    com.xiaoenai.app.ui.a.g localg = new com.xiaoenai.app.ui.a.g(this);
    localg.a(str);
    localg.a(2131100898, new b(this, paramString1, paramString2));
    localg.b(2131099973, new c(this));
    localg.show();
  }
  
  private void b(String paramString)
  {
    com.xiaoenai.app.ui.a.g localg = new com.xiaoenai.app.ui.a.g(this);
    localg.a(paramString);
    localg.a(2131100898, new o(this));
    localg.show();
  }
  
  private void b(String paramString1, String paramString2)
  {
    new com.xiaoenai.app.net.l(new e(this, this, paramString1)).d(paramString1, paramString2);
  }
  
  private void d()
  {
    String str1 = this.c.getText().toString().trim().replace(" ", "");
    String str2 = this.i.getText().toString().trim();
    if (this.c.hasFocus())
    {
      localObject = am.b(str1);
      if (!((am.a)localObject).a.booleanValue())
      {
        b(((am.a)localObject).b);
        return;
      }
      if (str2.length() == 0) {
        this.i.requestFocus();
      }
    }
    else if (this.i.hasFocus())
    {
      localObject = am.a(str2);
      if (!((am.a)localObject).a.booleanValue())
      {
        b(((am.a)localObject).b);
        return;
      }
    }
    Object localObject = am.b(str1);
    if (!((am.a)localObject).a.booleanValue())
    {
      b(((am.a)localObject).b);
      return;
    }
    localObject = am.a(str2);
    if (!((am.a)localObject).a.booleanValue())
    {
      b(((am.a)localObject).b);
      return;
    }
    if (this.l == null)
    {
      localObject = new com.xiaoenai.app.ui.a.g(this);
      ((com.xiaoenai.app.ui.a.g)localObject).a(2131101040);
      ((com.xiaoenai.app.ui.a.g)localObject).a(2131101047, new m(this));
      ((com.xiaoenai.app.ui.a.g)localObject).b(2131101041, new n(this, str1, str2));
      ((com.xiaoenai.app.ui.a.g)localObject).show();
      return;
    }
    a(str1, str2);
  }
  
  private void f()
  {
    com.xiaoenai.app.net.n localn = new com.xiaoenai.app.net.n(new d(this, this));
    com.xiaoenai.app.utils.f.a.c("upload avatar 1", new Object[0]);
    localn.d(this.l);
  }
  
  private void g()
  {
    if (UserConfig.getString("cur_version", "").equals("v5.6.0"))
    {
      h();
      return;
    }
    i();
  }
  
  private void h()
  {
    ab.b(this);
    sendBroadcast(new Intent("kill_action"), getString(2131101650));
    Intent localIntent = new Intent(this, HomeActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("from", "register");
    startActivity(localIntent);
    com.xiaoenai.app.classes.common.a.a().a(this);
    overridePendingTransition(2130968604, 2130968605);
    finish();
  }
  
  private void i()
  {
    Intent localIntent = new Intent(this, NewVersionIntroActivity.class);
    localIntent.putExtra("from", "login");
    startActivity(localIntent);
    finish();
  }
  
  public int a()
  {
    return 2130903303;
  }
  
  protected void b()
  {
    super.b();
  }
  
  public void c()
  {
    a locala = new a(this);
    this.c = ((EditText)findViewById(2131558742));
    this.c.setOnEditorActionListener(locala);
    this.c.clearFocus();
    this.c.setCursorVisible(false);
    this.c.setOnClickListener(new f(this));
    this.i = ((EditText)findViewById(2131558744));
    this.i.setOnEditorActionListener(locala);
    this.i.clearFocus();
    this.i.setCursorVisible(false);
    this.i.setOnClickListener(new g(this));
    this.j = ((ImageView)findViewById(2131559684));
    this.j.requestFocus();
    this.j.setOnClickListener(new h(this));
    this.k = ((ScrollView)findViewById(2131558587));
    this.a = findViewById(2131558670);
    this.a.getViewTreeObserver().addOnGlobalLayoutListener(new k(this));
    ((Button)findViewById(2131559687)).setOnClickListener(new l(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 != 21) {
        break label55;
      }
      paramIntent = paramIntent.getStringArrayExtra("image_url_array");
      if (paramIntent != null) {
        com.xiaoenai.app.utils.g.a().a(com.xiaoenai.app.utils.g.a().a(paramIntent[0]), true, null, 1280, 1280, this);
      }
    }
    label55:
    while (paramInt1 != 5) {
      return;
    }
    com.xiaoenai.app.utils.f.a.c("=========== {}", new Object[] { paramIntent });
    this.l = paramIntent.getData().getPath();
    com.xiaoenai.app.utils.e.b.b(this.j, "file://" + this.l, ab.a(62.0F));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = false;
    this.f = 1;
    c();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\register\RegisterActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */