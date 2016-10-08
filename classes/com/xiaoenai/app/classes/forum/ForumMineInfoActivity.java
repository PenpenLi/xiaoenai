package com.xiaoenai.app.classes.forum;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.common.dialog.v;
import com.xiaoenai.app.model.Forum.f;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.g;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.widget.TitleBarView;
import com.xiaoenai.app.widget.wheel.a.b;

public class ForumMineInfoActivity
  extends TitleBarActivity
{
  private static f t;
  private LinearLayout a;
  private LinearLayout b;
  private TextView c;
  private RelativeLayout i;
  private TextView j;
  private RelativeLayout k;
  private EditText l;
  private v m;
  private ImageView n;
  private String[] o;
  private int s = -1;
  private boolean u = false;
  
  private void a(String paramString, int paramInt, boolean paramBoolean)
  {
    new g(new aa(this, this, paramBoolean, paramInt, paramString)).b(paramString, paramInt);
  }
  
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
    if (com.xiaoenai.app.utils.am.e(paramString))
    {
      h.c(this, 2131100458, 1500L);
      return false;
    }
    return true;
  }
  
  private void d()
  {
    this.a = ((LinearLayout)findViewById(2131559232));
    this.b = ((LinearLayout)findViewById(2131559237));
    this.i = ((RelativeLayout)findViewById(2131559233));
    this.c = ((TextView)findViewById(2131559234));
    this.k = ((RelativeLayout)findViewById(2131559235));
    this.j = ((TextView)findViewById(2131559236));
    this.o = new String[] { getResources().getString(2131100469), getResources().getString(2131100468) };
    this.l = ((EditText)findViewById(2131559238));
    this.l.setFilters(new InputFilter[] { new InputFilter.LengthFilter(12) });
    this.n = ((ImageView)findViewById(2131559239));
  }
  
  private void f()
  {
    this.i.setOnClickListener(new x(this));
    this.k.setOnClickListener(new af(this));
  }
  
  private void g()
  {
    t = f.d();
    if (t == null)
    {
      new g(new ag(this, this)).a();
      return;
    }
    h();
  }
  
  private void h()
  {
    this.c.setText(t.b);
    this.j.setText(this.o[t.e]);
  }
  
  private void i()
  {
    if (this.m == null)
    {
      this.m = new v(this);
      this.m.a(new a(this, this.o), new ah(this));
      this.m.b(new ai(this));
      this.m.a(new aj(this));
    }
    this.m.show();
  }
  
  private void j()
  {
    o();
    this.l.setText(t.b);
    this.a.setVisibility(8);
    this.b.setVisibility(0);
    ab.a(this, this.l);
    this.l.setSelection(this.l.getText().toString().length());
    this.u = true;
  }
  
  private void k()
  {
    this.n.setOnClickListener(new ak(this));
    this.l.addTextChangedListener(new al(this));
  }
  
  private void o()
  {
    this.g.setTitle(2131100413);
    this.g.setRightButtonVisible(0);
    this.g.b(0, 2131101063);
    this.g.a(2130839000, 0);
    this.g.setLeftButtonClickListener(new am(this));
    this.g.setRightButtonClickListener(new y(this));
  }
  
  private void p()
  {
    ab.b(this);
    this.a.setVisibility(0);
    this.b.setVisibility(8);
    q();
    this.u = false;
  }
  
  private void q()
  {
    this.g.setTitle(2131100409);
    this.g.setRightButtonVisible(8);
    this.g.a(2130839000, 2131100418);
    this.g.setLeftButtonClickListener(new z(this));
  }
  
  public int a()
  {
    return 2130903199;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (paramBundle != null) {
      this.u = paramBundle.getBoolean("isModifyNicknameMode");
    }
    super.d(UserConfig.getBoolean("forum_night_theme", Boolean.valueOf(false)).booleanValue());
    super.onCreate(paramBundle);
    d();
    g();
    f();
    k();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.a.getVisibility() == 8) {
        p();
      }
      for (;;)
      {
        return true;
        r();
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    ab.b(this);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.u)
    {
      ab.a(this, this.l);
      return;
    }
    ab.b(this);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("isModifyNicknameMode", this.u);
    super.onSaveInstanceState(paramBundle);
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\ForumMineInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */