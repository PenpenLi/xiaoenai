package com.xiaoenai.app.classes.settings;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.common.image.ImagePicker;
import com.xiaoenai.app.classes.settings.feedback.FeedbackPhoto;
import com.xiaoenai.app.classes.settings.feedback.n;
import com.xiaoenai.app.d.f;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.l;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.widget.TitleBarView;
import java.util.Collections;
import java.util.Vector;

public class SettingFeedbackActivity
  extends TitleBarActivity
{
  private ListView a;
  private EditText b;
  private Button c;
  private RelativeLayout i;
  private com.xiaoenai.app.classes.settings.feedback.a j;
  private Vector<com.xiaoenai.app.classes.chat.messagelist.message.a.a> k;
  private f l;
  private Handler m;
  private n n;
  private Button o;
  
  private void a(Vector<com.xiaoenai.app.classes.settings.feedback.h> paramVector)
  {
    Collections.sort(paramVector, new s(this));
  }
  
  private void a(Object[] paramArrayOfObject)
  {
    if (this.j != null)
    {
      this.j.a(paramArrayOfObject);
      if (this.k.size() <= com.xiaoenai.app.utils.ab.a() / com.xiaoenai.app.utils.ab.a(100.0F)) {
        break label57;
      }
      this.a.setStackFromBottom(true);
    }
    for (;;)
    {
      this.a.setSelection(this.j.getCount());
      return;
      label57:
      this.a.setStackFromBottom(false);
    }
  }
  
  private void c(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    FeedbackPhoto localFeedbackPhoto = new FeedbackPhoto();
    localFeedbackPhoto.d(paramString);
    localFeedbackPhoto.b(1);
    localFeedbackPhoto.b(Integer.valueOf(-1));
    localFeedbackPhoto.a(localOptions.outWidth, localOptions.outHeight);
    localFeedbackPhoto.a(new ad(this, this, localFeedbackPhoto));
  }
  
  private void d(String paramString)
  {
    getWindow().setSoftInputMode(5);
    com.xiaoenai.app.ui.a.g localg = new com.xiaoenai.app.ui.a.g(this);
    localg.a(2131101113);
    localg.a(2131100898, new u(this, paramString));
    localg.show();
  }
  
  private void j()
  {
    if (com.xiaoenai.app.h.a.a.a().a(this, "mzd_enable_meiqia", false))
    {
      this.o.setVisibility(0);
      this.i.setVisibility(4);
      return;
    }
    this.o.setVisibility(8);
    this.i.setVisibility(0);
  }
  
  private void k()
  {
    if (this.j != null) {
      this.j.a();
    }
  }
  
  private void o()
  {
    Object localObject = (InputMethodManager)getSystemService("input_method");
    getWindow().setSoftInputMode(3);
    if (this.b.getWindowToken() != null) {
      ((InputMethodManager)localObject).hideSoftInputFromWindow(this.b.getWindowToken(), 2);
    }
    localObject = new com.xiaoenai.app.ui.a.g(this);
    ((com.xiaoenai.app.ui.a.g)localObject).a(2131101115);
    ((com.xiaoenai.app.ui.a.g)localObject).a(2131100898, new t(this));
    ((com.xiaoenai.app.ui.a.g)localObject).show();
  }
  
  public int a()
  {
    return 2130903308;
  }
  
  protected void b()
  {
    super.b();
    String str = getIntent().getStringExtra("from");
    if ((str != null) && (str.equals("notification")))
    {
      this.g.a(2130839000, 2131100897);
      return;
    }
    if ((str != null) && (str.equals("forum")))
    {
      this.g.a(2130839000, 0);
      return;
    }
    this.g.a(2130839000, 2131101239);
  }
  
  public void b(String paramString)
  {
    com.xiaoenai.app.classes.settings.feedback.h localh = new com.xiaoenai.app.classes.settings.feedback.h();
    localh.a(-1L);
    localh.b(paramString);
    localh.a((int)ak.b());
    localh.b(1);
    new l(new r(this, this, localh, paramString)).f(paramString, "text");
  }
  
  public void c()
  {
    this.o = ((Button)findViewById(2131559696));
    int i1 = UserConfig.getInt("chat_title_color", Integer.valueOf(-1864528)).intValue();
    this.o.setBackgroundColor(i1);
    this.o.setOnClickListener(new v(this));
    this.a = ((ListView)findViewById(2131559695));
    this.b = ((EditText)findViewById(2131559694));
    this.b.setFilters(new InputFilter[] { new InputFilter.LengthFilter(300) });
    this.c = ((Button)findViewById(2131559693));
    this.k = this.l.a();
    this.j = new com.xiaoenai.app.classes.settings.feedback.a(this.k.toArray(), this, this.l, new w(this));
    this.a.setAdapter(this.j);
    this.i = ((RelativeLayout)findViewById(2131559692));
    this.b.setFocusable(true);
    this.b.setFocusableInTouchMode(true);
    this.b.requestFocus();
    this.b.setOnClickListener(new x(this));
    this.b.setCursorVisible(false);
    this.c.setOnTouchListener(com.xiaoenai.app.utils.d.w.a);
    this.a.setClickable(true);
    this.a.setDescendantFocusability(393216);
    this.a.setOnTouchListener(new y(this));
    g();
    this.b.setHint(getString(2131101114));
    this.c.setOnClickListener(new z(this));
    if (this.k.size() > com.xiaoenai.app.utils.ab.a() / com.xiaoenai.app.utils.ab.a(100.0F)) {
      this.a.setStackFromBottom(true);
    }
    for (;;)
    {
      this.a.setSelection(this.j.getCount());
      Button localButton = (Button)findViewById(2131558818);
      localButton.setOnTouchListener(com.xiaoenai.app.utils.d.w.a);
      localButton.setOnClickListener(new ab(this));
      return;
      this.a.setStackFromBottom(false);
    }
  }
  
  public void d()
  {
    if (!as.c())
    {
      as.a(this);
      return;
    }
    new ImagePicker(this).a(getString(2131101117), new ac(this));
  }
  
  public void f()
  {
    i();
  }
  
  public void g()
  {
    new l(new q(this, this)).o();
  }
  
  public boolean h()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.b != null)
    {
      bool1 = bool2;
      if (this.b.getText() != null)
      {
        bool1 = bool2;
        if (this.b.getText().length() > 0) {
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  public void i()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((getCurrentFocus() != null) && (getCurrentFocus().getWindowToken() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      if (paramInt1 == 21)
      {
        paramIntent = paramIntent.getStringArrayExtra("image_url_array");
        if ((paramIntent != null) && (paramIntent.length > 0))
        {
          paramInt1 = 0;
          while (paramInt1 < paramIntent.length)
          {
            c(com.xiaoenai.app.utils.g.a().a(paramIntent[paramInt1]));
            paramInt1 += 1;
          }
        }
      }
      else if ((paramInt1 == 0) && (paramIntent.getData() != null))
      {
        paramIntent = paramIntent.getData().getPath();
        if (paramIntent == null) {
          break label92;
        }
        c(paramIntent);
      }
    }
    return;
    label92:
    com.xiaoenai.app.ui.a.h.c(this, 2131099748, 1500L);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.l = new f();
    c();
    j();
    this.m = new p(this);
    this.n = new n(this.m);
    this.n.start();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void r()
  {
    super.r();
    if (this.n != null) {
      this.n.a(true);
    }
    f();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\SettingFeedbackActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */