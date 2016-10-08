package com.xiaoenai.app.classes.extentions.todo;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.common.dialog.e;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.ui.a.g;
import com.xiaoenai.app.widget.TitleBarView;
import com.xiaoenai.app.widget.q;

public class TodoDetailActivity
  extends TitleBarActivity
{
  protected View a;
  ScrollView b;
  View c;
  TextWatcher i = new am(this);
  private TextView j;
  private TextView k;
  private TextView l;
  private EditText m;
  private View n;
  private ImageButton o;
  private ImageButton s;
  private int t = 0;
  private com.xiaoenai.app.classes.extentions.todo.a.b u;
  private boolean v = false;
  private Handler w;
  private q x;
  
  private void a(String paramString, int paramInt)
  {
    if ((-1 == this.t) && (paramString.trim().length() > 0))
    {
      UserConfig.setString("todo_edittext_tmpmsg", paramString.trim());
      UserConfig.setInt("todo_edittext_tmpindex", paramInt);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Drawable localDrawable = getResources().getDrawable(2130838352);
    if (!paramBoolean) {
      this.o.setImageDrawable(com.xiaoenai.app.utils.k.a(localDrawable));
    }
    for (;;)
    {
      this.o.setEnabled(paramBoolean);
      return;
      this.o.setImageDrawable(localDrawable);
    }
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    com.xiaoenai.app.net.b localb = new com.xiaoenai.app.net.b(new y(this, this, paramBoolean, paramString2));
    this.u.b(User.getInstance().getUserId());
    this.u.a(System.currentTimeMillis() / 1000L);
    com.xiaoenai.app.classes.extentions.todo.a.b localb1 = this.u;
    if (paramString1 != null) {}
    for (;;)
    {
      localb1.a(paramString1);
      this.u.b(false);
      if (paramString2 != null) {
        break;
      }
      localb.a(Integer.valueOf(this.u.e()), this.u.f(), null);
      return;
      paramString1 = this.l.getText().toString().trim();
    }
    ao.a().d(this.u);
    localb.a(Integer.valueOf(this.u.e()), null, paramString2);
  }
  
  private void b(String paramString)
  {
    com.xiaoenai.app.utils.ab.b(this);
    new com.xiaoenai.app.net.b(new ad(this, this, paramString)).b(paramString);
  }
  
  private void b(boolean paramBoolean)
  {
    Drawable localDrawable = getResources().getDrawable(2130838351);
    if (!paramBoolean) {
      this.s.setImageDrawable(com.xiaoenai.app.utils.k.a(localDrawable));
    }
    for (;;)
    {
      this.s.setEnabled(paramBoolean);
      return;
      this.s.setImageDrawable(localDrawable);
    }
  }
  
  public static void d()
  {
    UserConfig.remove("todo_edittext_tmpmsg");
    UserConfig.remove("todo_edittext_tmpindex");
  }
  
  private void f()
  {
    this.x = new q(this.l);
    this.x.a(this.l.getLineHeight());
    this.l.setBackgroundDrawable(this.x);
  }
  
  private void g()
  {
    this.a = findViewById(2131558670);
    this.j = ((TextView)findViewById(2131559178));
    this.k = ((TextView)findViewById(2131559179));
    this.l = ((TextView)findViewById(2131559181));
    this.n = findViewById(2131559171);
    this.m = ((EditText)findViewById(2131559182));
    this.b = ((ScrollView)findViewById(2131559180));
    this.c = findViewById(2131558831);
    if (-1 == this.t)
    {
      this.m.setFocusable(true);
      this.m.requestFocus();
      this.m.setVisibility(0);
      this.n.setVisibility(8);
      this.m.addTextChangedListener(this.i);
      com.xiaoenai.app.utils.ab.a(this, this.m);
      this.l.setVisibility(4);
      q();
    }
    this.o = ((ImageButton)findViewById(2131559173));
    ImageButton localImageButton = (ImageButton)findViewById(2131559175);
    this.s = ((ImageButton)findViewById(2131559177));
    findViewById(2131559172).setOnClickListener(new ah(this));
    this.o.setOnClickListener(new ai(this));
    localImageButton.setOnClickListener(new aj(this));
    findViewById(2131559176).setOnClickListener(new ak(this));
    this.s.setOnClickListener(new al(this));
    if ((this.t == ao.a().c() - 1) && (!ao.a().f())) {
      b(false);
    }
    if (this.t == 0) {
      a(false);
    }
    this.g.setRightButtonVisible(8);
    h();
  }
  
  private void h()
  {
    if (-1 == this.t)
    {
      this.k.setText(com.xiaoenai.app.utils.ak.e(com.xiaoenai.app.utils.ak.a()));
      this.n.setVisibility(8);
      this.m.setFocusable(true);
      this.m.setVisibility(0);
      this.g.setRightButtonVisible(0);
      this.m.requestFocus();
      return;
    }
    this.m.setFocusable(false);
    this.m.setVisibility(8);
    this.n.setVisibility(8);
    this.g.setRightButtonVisible(0);
    this.l.setVisibility(0);
    if (this.u.d() == 0) {
      this.j.setText("");
    }
    for (;;)
    {
      this.k.setText(com.xiaoenai.app.utils.ak.e(this.u.b() * 1000L));
      this.l.setText(this.u.f());
      this.u.a(false);
      return;
      String str2;
      String str1;
      if (User.getInstance().getUserId() == this.u.d())
      {
        str2 = User.getInstance().getNickName();
        if (str2 != null)
        {
          str1 = str2;
          if (!str2.equalsIgnoreCase("")) {}
        }
        else
        {
          str1 = User.getInstance().getUserName();
        }
        this.j.setText(str1);
      }
      else
      {
        str2 = User.getInstance().getLoverNickName();
        if (str2 != null)
        {
          str1 = str2;
          if (!str2.equalsIgnoreCase("")) {}
        }
        else
        {
          str1 = User.getInstance().getLoverUserName();
        }
        this.j.setText(str1);
      }
    }
  }
  
  private void i()
  {
    if (this.v)
    {
      a(false, null, null);
      this.v = false;
    }
    if (this.t > 0)
    {
      ao localao = ao.a();
      int i1 = this.t - 1;
      this.t = i1;
      this.u = localao.a(i1);
      h();
      if (!this.s.isEnabled()) {
        b(true);
      }
      return;
    }
    a(false);
  }
  
  private void j()
  {
    if (this.v)
    {
      a(false, null, null);
      this.v = false;
    }
    if (this.t == ao.a().c() - 1) {
      if (ao.a().f())
      {
        this.u = ao.a().a(this.t);
        h();
      }
    }
    do
    {
      return;
      b(false);
      break;
      if (this.t >= ao.a().c() - 1) {
        break label130;
      }
      ao localao = ao.a();
      int i1 = this.t + 1;
      this.t = i1;
      this.u = localao.a(i1);
      h();
    } while (this.o.isEnabled());
    a(true);
    return;
    label130:
    b(false);
  }
  
  private void k()
  {
    new com.xiaoenai.app.net.b(new x(this, this)).b(Integer.valueOf(this.u.e()));
  }
  
  private void o()
  {
    g localg = new g(this);
    localg.d(com.xiaoenai.app.ui.a.k.j);
    localg.a(2131101537);
    localg.a(2131101539, new z(this));
    localg.b(2131099973, new aa(this));
    localg.show();
  }
  
  private void p()
  {
    e locale = new e(this);
    locale.a(2131101540, 0, new ab(this, locale));
    locale.a(2131101538, 2, new ac(this, locale));
    locale.show();
  }
  
  private void q()
  {
    String str;
    if (-1 == this.t)
    {
      str = UserConfig.getString("todo_edittext_tmpmsg", "");
      int i1 = UserConfig.getInt("todo_edittext_tmpindex", Integer.valueOf(str.length())).intValue();
      if ((str.length() >= 0) && (i1 >= 0))
      {
        this.m.setText(str);
        if (str.length() <= i1) {
          break label69;
        }
        this.m.setSelection(i1);
      }
    }
    return;
    label69:
    this.m.setSelection(str.length());
  }
  
  public int a()
  {
    return 2130903186;
  }
  
  protected void b()
  {
    super.b();
    if (-1 == this.t) {
      this.g.b(0, 2131101542);
    }
    for (;;)
    {
      this.g.setRightButtonClickListener(new an(this));
      this.g.setLeftButtonClickListener(new w(this));
      return;
      this.g.b(2130839004, 0);
    }
  }
  
  public void c()
  {
    com.xiaoenai.app.utils.ab.b(this);
    g localg = new g(this);
    localg.a(2131100898, new ae(this));
    localg.b(2131099973, new af(this));
    localg.a(2131101543);
    localg.show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.t = getIntent().getIntExtra("index", 0);
    if (-1 != this.t) {
      this.u = ao.a().a(this.t);
    }
    this.f = 2;
    super.onCreate(paramBundle);
    g();
    this.b.getViewTreeObserver().addOnGlobalLayoutListener(new v(this));
    this.w = new ag(this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      Object localObject = a.b(this);
      if (localObject != null)
      {
        ((a)localObject).a();
        return true;
      }
      localObject = h.e(this);
      if (localObject != null)
      {
        if (h.d(this))
        {
          h.c(this);
          return true;
        }
        ((h)localObject).b();
        return true;
      }
      if ((-1 == this.t) && (this.v))
      {
        c();
        return true;
      }
      if (this.v) {
        a(false, null, null);
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    com.xiaoenai.app.utils.ab.b(this);
    a(this.m.getText().toString().trim(), this.m.getSelectionEnd());
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\todo\TodoDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */