package com.xiaoenai.app.classes.street;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.text.Editable;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import com.xiaoenai.app.classes.street.c.a;
import com.xiaoenai.app.net.ae;
import com.xiaoenai.app.ui.a.g;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.widget.TitleBarView;
import io.github.rockerhieu.emojicon.EmojiconEditText;

public class StreetCommentProductActitvity
  extends StreetBaseActivity
{
  private int a;
  private int b;
  private ImageButton c;
  private LinearLayout i;
  private FragmentTabHost j;
  private TabWidget k;
  private FrameLayout l;
  private boolean m = false;
  private EmojiconEditText n;
  
  private void a(EditText paramEditText)
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(paramEditText.getWindowToken(), 0);
  }
  
  private void b(EditText paramEditText)
  {
    ((InputMethodManager)getSystemService("input_method")).showSoftInput(paramEditText, 0);
  }
  
  private void g()
  {
    this.g.setTitle(2131100484);
    this.i.setVisibility(8);
  }
  
  private void h()
  {
    this.c = ((ImageButton)findViewById(2131559833));
    this.n = ((EmojiconEditText)findViewById(2131559834));
    this.i = ((LinearLayout)findViewById(2131559831));
    this.j = ((FragmentTabHost)findViewById(16908306));
    this.j.setup(this, getSupportFragmentManager(), 2131558806);
    this.k = ((TabWidget)findViewById(16908307));
    this.k.setVisibility(8);
    this.l = ((FrameLayout)findViewById(2131558806));
    this.j.addTab(this.j.newTabSpec("classic").setIndicator("classic"), a.class, null);
    this.n.requestFocus();
  }
  
  private void i()
  {
    this.c.setOnClickListener(new ai(this));
    aj localaj = new aj(this);
    this.n.setOnTouchListener(localaj);
  }
  
  private void j()
  {
    g localg = new g(this);
    localg.a(2131100898, new ak(this));
    localg.b(2131099973, new al(this));
    localg.a(2131100392);
    localg.show();
  }
  
  private void k()
  {
    if (this.n.getText().length() <= 0)
    {
      h.c(this, 2131100702, 1500L);
      return;
    }
    new ae(new am(this, this)).a(this.a, this.n.getText().toString());
  }
  
  private void o()
  {
    if (this.n.getText().length() <= 0)
    {
      h.c(this, 2131100702, 1500L);
      return;
    }
    new ae(new an(this, this)).b(this.b, this.n.getText().toString());
  }
  
  private void p()
  {
    setResult(-1);
    super.a_(2);
  }
  
  public int a()
  {
    return 2130903336;
  }
  
  protected void b()
  {
    super.b();
    this.g.setRightButtonClickListener(new ag(this));
    this.g.setLeftButtonClickListener(new ah(this));
  }
  
  public EditText c()
  {
    return this.n;
  }
  
  public void d()
  {
    this.j.setVisibility(0);
    this.l.setVisibility(0);
  }
  
  public void f()
  {
    this.j.setVisibility(8);
    this.l.setVisibility(8);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.a = paramBundle.getIntExtra("product_id", -1);
    this.b = paramBundle.getIntExtra("street_comment_id_key", -1);
    h();
    if (this.b > 0) {
      g();
    }
    i();
  }
  
  protected void onPause()
  {
    super.onPause();
    ab.b(this);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.m)
    {
      a(this.n);
      return;
    }
    ab.a(this, this.n);
  }
  
  public void r()
  {
    if (this.n.length() > 0)
    {
      j();
      return;
    }
    super.a_(2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\StreetCommentProductActitvity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */