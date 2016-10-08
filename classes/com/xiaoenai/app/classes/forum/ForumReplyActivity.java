package com.xiaoenai.app.classes.forum;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.chat.input.faces.FaceFragmentBottomBar;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.forum.fragment.a.a;
import com.xiaoenai.app.classes.forum.widget.ForumScrollEditTextView;
import com.xiaoenai.app.classes.forum.widget.ForumScrollEditTextView.a;
import com.xiaoenai.app.model.Forum.f;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.widget.TitleBarView;
import org.json.JSONObject;

public class ForumReplyActivity
  extends TitleBarActivity
{
  private ImageButton a;
  private LinearLayout b;
  private int c;
  private int i;
  private int j = 1;
  private boolean k = false;
  private String l = null;
  private int m = 0;
  private FragmentTabHost n;
  private TabWidget o;
  private FrameLayout s;
  private FaceFragmentBottomBar t;
  private boolean u = false;
  private ForumScrollEditTextView v;
  private ForumScrollEditTextView.a w;
  
  private void a(int paramInt)
  {
    if (dm.a(this, paramInt))
    {
      if (paramInt != 1) {
        break label18;
      }
      d();
    }
    label18:
    while (paramInt != 2) {
      return;
    }
    f();
  }
  
  private void a(EditText paramEditText)
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(paramEditText.getWindowToken(), 0);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("forum_reply_name", paramJSONObject.toString());
    setResult(-1, localIntent);
    a_(1);
  }
  
  private void b(EditText paramEditText)
  {
    ((InputMethodManager)getSystemService("input_method")).showSoftInput(paramEditText, 0);
  }
  
  private void i()
  {
    this.a = ((ImageButton)findViewById(2131559278));
    this.v = ((ForumScrollEditTextView)findViewById(2131559279));
    this.w = this.v.getViewHolder();
    this.b = ((LinearLayout)findViewById(2131559276));
    this.w.b.setVisibility(8);
    this.w.c.setSelected(this.k);
    this.n = ((FragmentTabHost)findViewById(16908306));
    this.n.setup(this, getSupportFragmentManager(), 2131558806);
    this.o = ((TabWidget)findViewById(16908307));
    this.o.setVisibility(8);
    this.s = ((FrameLayout)findViewById(2131558806));
    this.t = ((FaceFragmentBottomBar)findViewById(2131558805));
    this.t.b();
    this.n.addTab(this.n.newTabSpec("classic").setIndicator("classic"), a.a.class, null);
    this.w.a.requestFocus();
    if (this.l != null)
    {
      this.w.a.setHint(String.format(getString(2131100482), new Object[] { this.l }));
      this.g.setTitle(getString(2131100478) + this.m + getString(2131100386));
    }
  }
  
  private void j()
  {
    this.g.setTitle(2131100478);
  }
  
  private void k()
  {
    this.g.setTitle(2131100484);
    this.w.c.setVisibility(8);
    this.b.setVisibility(8);
  }
  
  private void o()
  {
    this.a.setOnClickListener(new cd(this));
    this.w.c.setOnClickListener(new ch(this));
    ci localci = new ci(this);
    this.w.a.setOnTouchListener(localci);
  }
  
  private void p()
  {
    com.xiaoenai.app.ui.a.g localg = new com.xiaoenai.app.ui.a.g(this);
    localg.a(2131100898, new cm(this));
    localg.b(2131099973, new cn(this));
    localg.a(2131100392);
    localg.show();
  }
  
  private void q()
  {
    setResult(-1);
    a_(1);
  }
  
  public int a()
  {
    return 2130903212;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    new com.xiaoenai.app.net.g(new cf(this, this)).c(paramInt1, paramInt2, paramString);
  }
  
  protected void b()
  {
    super.b();
    this.g.setLeftButtonClickListener(new cj(this));
    this.g.setRightButtonClickListener(new ck(this));
  }
  
  public void b(int paramInt1, int paramInt2, String paramString)
  {
    new com.xiaoenai.app.net.g(new cg(this, this)).b(paramInt1, paramInt2, paramString);
  }
  
  public EditText c()
  {
    return this.w.a;
  }
  
  public void d()
  {
    com.xiaoenai.app.net.g localg = new com.xiaoenai.app.net.g(new cl(this, this));
    if (this.k) {}
    for (int i1 = f.d().g;; i1 = -1)
    {
      com.xiaoenai.app.utils.f.a.c("是否通知另一半  {}", new Object[] { Boolean.valueOf(this.k) });
      com.xiaoenai.app.utils.f.a.c("loveId {}", new Object[] { Integer.valueOf(i1) });
      String str = io.github.rockerhieu.emojicon.a.a(Xiaoenai.j(), this.w.a.getText().toString());
      localg.a(this.c, i1, this.i, str);
      return;
    }
  }
  
  public void f()
  {
    com.xiaoenai.app.net.g localg = new com.xiaoenai.app.net.g(new co(this, this));
    if (this.k) {}
    for (int i1 = f.d().g;; i1 = -1)
    {
      String str = io.github.rockerhieu.emojicon.a.a(Xiaoenai.j(), this.w.a.getText().toString());
      localg.a(this.c, i1, str);
      return;
    }
  }
  
  public void g()
  {
    if (!isFinishing())
    {
      this.n.setVisibility(0);
      this.s.setVisibility(0);
    }
  }
  
  public void h()
  {
    this.n.setVisibility(8);
    this.s.setVisibility(8);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.d(UserConfig.getBoolean("forum_night_theme", Boolean.valueOf(false)).booleanValue());
    this.f = 1;
    super.onCreate(paramBundle);
    this.c = getIntent().getIntExtra("forum_topic_id", 0);
    this.i = getIntent().getIntExtra("forum_reply_id", 0);
    this.j = getIntent().getIntExtra("forum_Reply_type", 1);
    this.l = getIntent().getStringExtra("forum_reply_name");
    this.m = getIntent().getIntExtra("forum_reply_floor", 0);
    i();
    if (this.j == 2) {
      j();
    }
    for (;;)
    {
      o();
      return;
      if ((this.j == 3) || (this.j == 4)) {
        k();
      }
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    ab.b(this);
  }
  
  protected void onResume()
  {
    super.onResume();
    com.xiaoenai.app.utils.f.a.c("isShowFace={}", new Object[] { Boolean.valueOf(this.u) });
    if (this.u)
    {
      a(this.w.a);
      return;
    }
    ab.a(this, this.w.a);
  }
  
  public void r()
  {
    if (this.w.a.length() > 0)
    {
      p();
      return;
    }
    super.a_(1);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\ForumReplyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */