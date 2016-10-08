package com.xiaoenai.app.classes.settings.account;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.Button;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.newRegister.phone.PhoneRegisterVerifyActivity;
import com.xiaoenai.app.net.ah;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.utils.am;
import com.xiaoenai.app.widget.CleanableEditText;

public class ResetPasswordByPhoneNumActivity
  extends TitleBarActivity
{
  private CleanableEditText a;
  private Button b;
  private String c;
  private String i;
  
  private void b(String paramString)
  {
    if ((am.e(paramString)) && (paramString.length() == 11))
    {
      c(paramString);
      return;
    }
    h.c(this, 2131101212, 1500L);
  }
  
  private void c()
  {
    this.a = ((CleanableEditText)findViewById(2131559610));
    this.a.setmIsPhoneFormat(true);
    this.b = ((Button)findViewById(2131559611));
  }
  
  private void c(String paramString)
  {
    new k(this).a(2131101206, String.format(getString(2131101207), new Object[] { paramString }), 2131099973, new p(this), 2131100898, new q(this, paramString));
  }
  
  private void d()
  {
    this.a.addTextChangedListener(new n(this));
    this.b.setOnClickListener(new o(this));
  }
  
  private void d(String paramString)
  {
    new ah(new r(this, this, paramString)).a(paramString, 2);
  }
  
  private void f()
  {
    Drawable localDrawable = this.b.getBackground();
    if (localDrawable != null) {
      localDrawable.setAlpha(153);
    }
    this.b.setClickable(false);
    if (Build.VERSION.SDK_INT <= 11) {
      this.b.invalidate();
    }
  }
  
  private void g()
  {
    Drawable localDrawable = this.b.getBackground();
    if (localDrawable != null) {
      localDrawable.setAlpha(255);
    }
    this.b.setClickable(true);
    if (Build.VERSION.SDK_INT <= 11) {
      this.b.invalidate();
    }
  }
  
  private void h()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, PhoneRegisterVerifyActivity.class);
    localIntent.putExtra("phone_register_verify_phone_number", this.c);
    if ((this.i != null) && (this.i.equals("findPW"))) {
      localIntent.putExtra("from", 3);
    }
    for (;;)
    {
      startActivityForResult(localIntent, 1001);
      return;
      localIntent.putExtra("from", 2);
    }
  }
  
  public int a()
  {
    return 2130903273;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = false;
    this.f = 1;
    paramBundle = getIntent();
    if (paramBundle != null) {
      this.i = paramBundle.getStringExtra("from");
    }
    c();
    d();
    f();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.a.requestFocus();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\ResetPasswordByPhoneNumActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */