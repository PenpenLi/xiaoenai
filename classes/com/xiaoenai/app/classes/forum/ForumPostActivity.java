package com.xiaoenai.app.classes.forum;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.forum.presenter.h;
import com.xiaoenai.app.classes.forum.widget.ForumScrollEditTextView;
import com.xiaoenai.app.classes.forum.widget.ForumScrollEditTextView.a;
import com.xiaoenai.app.model.Forum.f;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.ui.a.g;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.widget.TitleBarView;

public class ForumPostActivity
  extends TitleBarActivity
{
  private EditText a;
  private EditText b;
  private LinearLayout c;
  private ImageButton i;
  private ImageButton j;
  private h k;
  private ForumScrollEditTextView l;
  private ForumScrollEditTextView.a m;
  private FragmentTabHost n;
  private TabWidget o;
  private FrameLayout s;
  private boolean t = false;
  private com.xiaoenai.app.classes.forum.fragment.a u;
  private boolean v = true;
  private boolean w = false;
  
  private void a(int paramInt)
  {
    this.u = ((com.xiaoenai.app.classes.forum.fragment.a)getSupportFragmentManager().findFragmentById(2131558806));
    this.u.c(paramInt);
  }
  
  private void a(EditText paramEditText)
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(paramEditText.getWindowToken(), 0);
  }
  
  private void b(EditText paramEditText)
  {
    ((InputMethodManager)getSystemService("input_method")).showSoftInput(paramEditText, 0);
  }
  
  private void c(int paramInt)
  {
    if (paramInt > 0)
    {
      this.w = true;
      return;
    }
    this.w = false;
  }
  
  private void f()
  {
    this.a = ((EditText)findViewById(2131559261));
    this.b = ((EditText)findViewById(2131559298));
    this.c = ((LinearLayout)findViewById(2131559264));
    this.i = ((ImageButton)findViewById(2131559266));
    this.j = ((ImageButton)findViewById(2131559267));
    this.l = ((ForumScrollEditTextView)findViewById(2131559263));
    this.m = this.l.getViewHolder();
    this.n = ((FragmentTabHost)findViewById(16908306));
    this.n.setup(this, getSupportFragmentManager(), 2131558806);
    this.o = ((TabWidget)findViewById(16908307));
    this.o.setVisibility(8);
    this.s = ((FrameLayout)findViewById(2131558806));
    this.n.addTab(this.n.newTabSpec("classic").setIndicator("classic"), com.xiaoenai.app.classes.forum.fragment.a.class, null);
  }
  
  private void g()
  {
    this.i.setOnClickListener(new bj(this));
    this.j.setOnClickListener(new bl(this));
    Object localObject = new bn(this);
    this.m.d.setOnClickListener((View.OnClickListener)localObject);
    this.m.c.setOnClickListener((View.OnClickListener)localObject);
    localObject = new bo(this);
    bp localbp = new bp(this);
    this.a.setOnTouchListener((View.OnTouchListener)localObject);
    this.b.setOnTouchListener(localbp);
    this.k.a(new bq(this));
  }
  
  private void h()
  {
    this.k.c();
    this.t = false;
  }
  
  private void i()
  {
    if ((this.a.getText().length() > 0) || (this.b.getText().length() > 0) || (this.k.e().length > 0))
    {
      d();
      return;
    }
    r();
  }
  
  public int a()
  {
    return 2130903209;
  }
  
  protected void b()
  {
    super.b();
    this.g.setLeftButtonClickListener(new bs(this));
    this.g.setRightButtonClickListener(new bt(this));
  }
  
  public EditText c()
  {
    if (this.a.isFocused()) {
      return this.a;
    }
    if (this.b.isFocused()) {
      return this.b;
    }
    return null;
  }
  
  public void d()
  {
    g localg = new g(this);
    localg.a(2131100898, new bu(this));
    localg.b(2131099973, new bk(this));
    localg.a(2131100392);
    localg.show();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 != 21) {
        break label54;
      }
      paramIntent = paramIntent.getStringArrayExtra("image_url_array");
      this.k.a(paramIntent);
      c(this.k.e().length);
      this.k.d();
    }
    label54:
    do
    {
      do
      {
        return;
        if (paramInt1 != 0) {
          break;
        }
      } while ((paramIntent == null) || (paramIntent.getData() == null) || (paramIntent.getData().getPath() == null));
      String str = paramIntent.getData().getPath();
      paramIntent = str;
      if (!str.startsWith("file://")) {
        paramIntent = "file://" + str;
      }
      this.w = true;
      this.k.a(paramIntent);
      this.k.d();
      return;
    } while (paramInt1 != 2);
    paramIntent = paramIntent.getIntArrayExtra("image_position_array");
    if (paramIntent != null) {
      this.k.a(paramIntent);
    }
    c(this.k.e().length);
    this.k.d();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.d(UserConfig.getBoolean("forum_night_theme", Boolean.valueOf(false)).booleanValue());
    this.f = 1;
    super.onCreate(paramBundle);
    f();
    this.k = new h(this, this.m, this.n, this.s, this.i);
    this.m.d.setSelected(this.k.f());
    g();
    paramBundle = f.d();
    if ((paramBundle != null) && (!paramBundle.c()))
    {
      paramBundle = new Intent();
      paramBundle.setClass(this, ForumRegisterActivity.class);
      startActivity(paramBundle);
      finish();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      i();
      return true;
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
    com.xiaoenai.app.utils.f.a.c("isShowFace={}", new Object[] { Boolean.valueOf(this.t) });
    com.xiaoenai.app.utils.f.a.c("showWhichInput={}", new Object[] { Boolean.valueOf(this.v) });
    if ((this.t) || (this.w))
    {
      a(this.a);
      a(this.b);
      return;
    }
    if (this.v)
    {
      ab.a(this, this.a);
      return;
    }
    ab.a(this, this.b);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\ForumPostActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */