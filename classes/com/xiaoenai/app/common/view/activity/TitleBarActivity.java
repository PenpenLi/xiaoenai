package com.xiaoenai.app.common.view.activity;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import com.xiaoenai.app.common.c.c;
import com.xiaoenai.app.common.internal.di.a.c;
import com.xiaoenai.app.common.view.widget.TitleBarView;
import com.xiaoenai.app.data.e.o;
import com.xiaoenai.app.utils.d.l;
import javax.inject.Inject;

public abstract class TitleBarActivity
  extends BaseActivity
{
  protected int a = 2;
  protected TitleBarView b;
  @Inject
  protected o c;
  @Inject
  protected com.xiaoenai.app.domain.e.a d;
  
  public void a(int paramInt)
  {
    l.b(this);
    finish();
    if (1 == paramInt) {
      overridePendingTransition(com.xiaoenai.app.common.c.a.push_down_in, com.xiaoenai.app.common.c.a.push_down_out);
    }
    while (2 != paramInt) {
      return;
    }
    overridePendingTransition(com.xiaoenai.app.common.c.a.push_right_in, com.xiaoenai.app.common.c.a.push_right_out);
  }
  
  protected abstract int d();
  
  protected void f()
  {
    this.b = ((TitleBarView)findViewById(c.c.titleBar));
    if (this.b != null)
    {
      if ((this.d.a().d()) && (this.b.getTitleBarTheme() == 2))
      {
        int i = this.c.b("chat_title_color", Integer.valueOf(-1864528)).intValue();
        this.b.setTitleBarBackground(i);
      }
      this.b.setLeftButtonClickListener(new b(this));
    }
  }
  
  protected void l()
  {
    super.l();
    c.c().a(z()).a(A()).a().a(this);
  }
  
  public void m_()
  {
    a(this.a);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      requestWindowFeature(10);
    }
    setContentView(d());
    f();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      m_();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected void onStart()
  {
    super.onStart();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\common\view\activity\TitleBarActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */