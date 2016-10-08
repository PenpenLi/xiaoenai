package com.xiaoenai.app.classes.street;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.xiaoenai.app.classes.common.image.ImagePicker;
import com.xiaoenai.app.classes.settings.feedback.FeedbackPhoto;
import com.xiaoenai.app.classes.settings.feedback.n;
import com.xiaoenai.app.d.f;
import com.xiaoenai.app.net.ae;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.al;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.utils.d.w;
import java.util.Collections;
import java.util.Vector;

public class StreetFeedbackActivity
  extends StreetBaseActivity
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
  private long o;
  
  private void a(Vector<com.xiaoenai.app.classes.settings.feedback.h> paramVector)
  {
    Collections.sort(paramVector, new bl(this));
  }
  
  private void a(Object[] paramArrayOfObject)
  {
    if (this.j != null)
    {
      this.j.a(paramArrayOfObject);
      if (this.k.size() <= ab.a() / ab.a(100.0F)) {
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
    localFeedbackPhoto.e(this.o);
    localFeedbackPhoto.d(paramString);
    localFeedbackPhoto.b(1);
    localFeedbackPhoto.b(Integer.valueOf(-1));
    localFeedbackPhoto.a(localOptions.outWidth, localOptions.outHeight);
    localFeedbackPhoto.a(new bu(this, this, localFeedbackPhoto));
  }
  
  private void d(String paramString)
  {
    getWindow().setSoftInputMode(5);
    com.xiaoenai.app.ui.a.g localg = new com.xiaoenai.app.ui.a.g(this);
    localg.a(2131101113);
    localg.a(2131100898, new bn(this, paramString));
    localg.show();
  }
  
  private void j()
  {
    if (this.j != null) {
      this.j.a();
    }
  }
  
  private void k()
  {
    Object localObject = (InputMethodManager)getSystemService("input_method");
    getWindow().setSoftInputMode(3);
    if (this.b.getWindowToken() != null) {
      ((InputMethodManager)localObject).hideSoftInputFromWindow(this.b.getWindowToken(), 2);
    }
    localObject = new com.xiaoenai.app.ui.a.g(this);
    ((com.xiaoenai.app.ui.a.g)localObject).a(2131101383);
    ((com.xiaoenai.app.ui.a.g)localObject).a(2131100898, new bm(this));
    ((com.xiaoenai.app.ui.a.g)localObject).show();
  }
  
  public int a()
  {
    return 2130903341;
  }
  
  public void b(String paramString)
  {
    com.xiaoenai.app.classes.settings.feedback.h localh = new com.xiaoenai.app.classes.settings.feedback.h();
    localh.a(-1L);
    localh.b(paramString);
    localh.a((int)ak.b());
    localh.b(1);
    new ae(new bk(this, this, localh, paramString)).a(this.o, paramString, "text");
  }
  
  public void c()
  {
    this.a = ((ListView)findViewById(2131559871));
    this.b = ((EditText)findViewById(2131559870));
    this.c = ((Button)findViewById(2131559869));
    this.k = this.l.a(this.o);
    this.j = new com.xiaoenai.app.classes.settings.feedback.a(this.k.toArray(), this, this.l, new bo(this), 1, this.o);
    this.a.setAdapter(this.j);
    this.i = ((RelativeLayout)findViewById(2131559867));
    this.b.setFocusable(true);
    this.b.setFocusableInTouchMode(true);
    this.b.requestFocus();
    this.b.setOnClickListener(new bp(this));
    this.b.setCursorVisible(false);
    this.c.setOnTouchListener(w.a);
    this.a.setClickable(true);
    this.a.setDescendantFocusability(393216);
    this.a.setOnTouchListener(new bq(this));
    g();
    this.b.setHint(getString(2131101382));
    this.c.setOnClickListener(new br(this));
    if (this.k.size() > ab.a() / ab.a(100.0F)) {
      this.a.setStackFromBottom(true);
    }
    for (;;)
    {
      this.a.setSelection(this.j.getCount());
      Button localButton = (Button)findViewById(2131558818);
      localButton.setOnTouchListener(w.a);
      localButton.setOnClickListener(new bs(this));
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
    new ImagePicker(this).a(getString(2131101117), new bt(this));
  }
  
  public void f()
  {
    i();
  }
  
  public void g()
  {
    new ae(new bv(this, this)).f(this.o);
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
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      String str = paramBundle.getStringExtra("param");
      if (str == null) {
        break label106;
      }
      paramBundle = al.a(str).getString("order_id");
      if ((paramBundle == null) || (paramBundle.length() <= 0)) {}
    }
    label106:
    for (this.o = Long.parseLong(paramBundle);; this.o = paramBundle.getLongExtra("street_order_id_key", 0L))
    {
      this.l = new f();
      c();
      this.m = new bj(this);
      this.n = new n(this.m);
      this.n.start();
      return;
    }
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\StreetFeedbackActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */