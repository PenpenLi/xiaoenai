package com.xiaoenai.app.classes.common.share;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import cn.sharesdk.framework.PlatformActionListener;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.common.a.c;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.widget.TitleBarView;

public class ShareActivity
  extends TitleBarActivity
{
  private static int m = 140;
  TextView a;
  EditText b;
  ImageView c;
  com.xiaoenai.app.ui.a.h i;
  int j;
  private ShareInfo k;
  private int l = 0;
  private TextWatcher n = new k(this);
  
  private long a(CharSequence paramCharSequence)
  {
    double d = 0.0D;
    int i1 = 0;
    if (i1 < paramCharSequence.length())
    {
      int i2 = paramCharSequence.charAt(i1);
      if ((i2 > 0) && (i2 < 127)) {}
      for (d += 0.5D;; d += 1.0D)
      {
        i1 += 1;
        break;
      }
    }
    return Math.round(d);
  }
  
  private void f()
  {
    this.k = ((ShareInfo)getIntent().getParcelableExtra("share_data"));
    this.j = getIntent().getIntExtra("task_id", 9);
    this.l = this.k.l();
    this.b = ((EditText)findViewById(2131559781));
    this.b.setText(this.k.b());
    this.a = ((TextView)findViewById(2131559782));
    this.a.setText("" + (140L - a(this.b.getText().toString())));
    this.b.addTextChangedListener(this.n);
    this.c = ((ImageView)findViewById(2131559780));
    if ((this.k.c() != null) && (this.k.c().startsWith("http"))) {
      com.xiaoenai.app.utils.e.b.a(this.k.c(), new h(this), true, false);
    }
    if ((this.k.e() != null) || (this.k.c() != null))
    {
      if (this.k.e() == null)
      {
        if (this.k.c().startsWith("/"))
        {
          com.xiaoenai.app.utils.e.b.a(this.c, "file://" + this.k.c());
          return;
        }
        com.xiaoenai.app.utils.e.b.a(this.c, this.k.c());
        return;
      }
      if (this.k.e().startsWith("/"))
      {
        com.xiaoenai.app.utils.e.b.a(this.c, "file://" + this.k.e());
        return;
      }
      com.xiaoenai.app.utils.e.b.a(this.c, this.k.e());
      return;
    }
    this.c.setVisibility(8);
  }
  
  public int a()
  {
    return 2130903325;
  }
  
  public String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return getResources().getString(2131101277);
    case 3: 
      return getResources().getString(2131101276);
    case 1: 
      return getResources().getString(2131101278);
    }
    return getResources().getString(2131101279);
  }
  
  protected void c()
  {
    this.g.a(a(this.k.l()), null);
    this.g.setLeftButtonClickListener(new i(this));
    this.g.b(null, getResources().getString(2131101071));
    this.g.setRightButtonClickListener(new j(this));
  }
  
  public void c(int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = this.b.getText().toString();
    l locall = new l();
    this.k.b((String)localObject2);
    if (this.k.i() == 1) {
      if (this.k.k() != -1)
      {
        localObject2 = new e(this.k.k(), 1, this);
        localObject1 = new b(this.k.k(), 1, this);
      }
    }
    for (;;)
    {
      if (paramInt == 0) {
        locall.a(this.k, this, (c)localObject1);
      }
      while (paramInt != 3)
      {
        return;
        localObject2 = new e();
        localObject1 = new b();
        break;
        if (this.k.i() != 2) {
          break label168;
        }
        localObject2 = new at();
        localObject1 = new ap();
        break;
      }
      locall.c(this.k, this, (PlatformActionListener)localObject2);
      return;
      label168:
      localObject2 = null;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    f();
    c();
    if (getIntent().hasExtra("hasAuthFailDialog")) {
      this.d = getIntent().getBooleanExtra("hasAuthFailDialog", true);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.i != null) && (this.i.isShowing())) {
      this.i.dismiss();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      finish();
      overridePendingTransition(2130968606, 2130968607);
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
    if ((this.i != null) && (this.i.isShowing())) {
      this.i.dismiss();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\share\ShareActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */