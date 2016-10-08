package com.xiaoenai.app.classes.forum;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.common.dialog.v;
import com.xiaoenai.app.model.Forum.f;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.g;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.am;
import com.xiaoenai.app.widget.wheel.a.b;

public class ForumRegisterActivity
  extends TitleBarActivity
{
  private static f m;
  private EditText a;
  private TextView b;
  private LinearLayout c;
  private Button i;
  private ImageView j;
  private String[] k;
  private int l = -1;
  private v n;
  
  private boolean b(String paramString)
  {
    if (paramString.length() == 0)
    {
      h.c(this, 2131100459, 1500L);
      return false;
    }
    if (paramString.length() < 2)
    {
      h.c(this, 2131100461, 1500L);
      return false;
    }
    if (paramString.length() > 12)
    {
      h.c(this, 2131100462, 1500L);
      return false;
    }
    if (am.e(paramString))
    {
      h.c(this, 2131100458, 1500L);
      return false;
    }
    return true;
  }
  
  private void d()
  {
    this.a = ((EditText)findViewById(2131559271));
    this.a.setFilters(new InputFilter[] { new InputFilter.LengthFilter(12) });
    this.c = ((LinearLayout)findViewById(2131559272));
    this.b = ((TextView)findViewById(2131559273));
    this.k = new String[] { getResources().getString(2131100469), getResources().getString(2131100468) };
    this.i = ((Button)findViewById(2131559274));
    this.j = ((ImageView)findViewById(2131559239));
  }
  
  private void f()
  {
    this.c.setOnClickListener(new bv(this));
    this.i.setOnClickListener(new bw(this));
    this.j.setOnClickListener(new bx(this));
    this.a.addTextChangedListener(new by(this));
  }
  
  private void g()
  {
    if (this.n == null)
    {
      this.n = new v(this);
      this.n.a(new a(this, this.k), new bz(this));
      this.n.b(new ca(this));
      this.n.a(new cb(this));
    }
    this.n.show();
  }
  
  private void h()
  {
    String str = this.a.getText().toString().trim();
    if (!b(str)) {
      return;
    }
    if (this.l == -1)
    {
      h.c(this, 2131100467, 1500L);
      return;
    }
    new g(new cc(this, this)).a(str, this.l);
  }
  
  private void i()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, ForumActivity.class);
    startActivity(localIntent);
    finish();
  }
  
  public int a()
  {
    return 2130903211;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.d(UserConfig.getBoolean("forum_night_theme", Boolean.valueOf(false)).booleanValue());
    super.onCreate(paramBundle);
    d();
    f();
  }
  
  class a
    extends b
  {
    private String[] g;
    
    public a(Context paramContext, String[] paramArrayOfString)
    {
      super();
      this.g = paramArrayOfString;
    }
    
    public int a()
    {
      return this.g.length;
    }
    
    protected CharSequence a(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < a())) {
        return this.g[paramInt];
      }
      return null;
    }
    
    protected void a(TextView paramTextView)
    {
      paramTextView.setTextColor(-16777216);
      paramTextView.setGravity(17);
      paramTextView.setTextSize(20.0F);
      paramTextView.setLines(1);
      paramTextView.setTypeface(Typeface.SANS_SERIF);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\ForumRegisterActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */