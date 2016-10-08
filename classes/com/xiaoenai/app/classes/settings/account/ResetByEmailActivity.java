package com.xiaoenai.app.classes.settings.account;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.net.l;
import com.xiaoenai.app.ui.a.g;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.am;
import com.xiaoenai.app.utils.am.a;
import com.xiaoenai.app.utils.d.w;
import com.xiaoenai.app.widget.CleanableEditText;
import com.xiaoenai.app.widget.TitleBarView;

public class ResetByEmailActivity
  extends TitleBarActivity
{
  private CleanableEditText a = null;
  private Button b;
  
  private void b(String paramString)
  {
    new l(new f(this, this, paramString)).g(paramString);
  }
  
  private void b(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      h.c(this, paramString, 1500L);
      return;
    }
    g localg = new g(this);
    localg.setCancelable(false);
    localg.a(paramString);
    localg.a(2131100898, new e(this));
    localg.show();
  }
  
  private void c()
  {
    b localb = new b(this);
    this.a = ((CleanableEditText)findViewById(2131558813));
    this.a.addTextChangedListener(localb);
    this.a.setOnEditorActionListener(new c(this));
    this.b = ((Button)findViewById(2131559608));
    this.b.setOnClickListener(new d(this));
  }
  
  private void d()
  {
    String str = this.a.getText().toString().trim();
    if ((str != null) && (str.length() > 0))
    {
      am.a locala = am.b(str);
      if (!locala.a.booleanValue()) {
        b(locala.b, false);
      }
    }
    else
    {
      return;
    }
    b(str);
  }
  
  public int a()
  {
    return 2130903272;
  }
  
  protected void b()
  {
    super.b();
    this.g.a(2130839000, 2131101183);
    if (getIntent() != null)
    {
      String str = getIntent().getStringExtra("from");
      if ((str != null) && (str.equals("resetpassword"))) {
        this.g.a(0, 2131099973);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c();
    if (getIntent() != null)
    {
      paramBundle = getIntent().getAction();
      if ((paramBundle == null) || (!paramBundle.equals("resetPwdAction"))) {
        break label108;
      }
      paramBundle = getIntent().getStringExtra("email");
      this.a.setText(paramBundle);
      this.a.setSelection(this.a.getText().length());
    }
    for (;;)
    {
      paramBundle = getIntent().getStringExtra("from");
      if ((paramBundle == null) || (!paramBundle.equals("resetpassword"))) {
        break;
      }
      this.d = false;
      this.f = 1;
      return;
      label108:
      this.a.postDelayed(new a(this), 300L);
      w.a(this.b);
    }
    this.f = 2;
  }
  
  protected void onResume()
  {
    this.d = false;
    super.onResume();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\ResetByEmailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */