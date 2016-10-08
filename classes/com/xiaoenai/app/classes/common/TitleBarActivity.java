package com.xiaoenai.app.classes.common;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.ah;
import com.xiaoenai.app.widget.TitleBarView;

public abstract class TitleBarActivity
  extends BaseActivity
  implements aa
{
  protected int f = 2;
  protected TitleBarView g;
  protected int h = 2131296397;
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      i = 2131296398;
      this.h = i;
      if (!paramBoolean) {
        break label37;
      }
    }
    label37:
    for (int i = 2;; i = 1)
    {
      ah.a(this, i, paramString, paramInt);
      return;
      i = 2131296397;
      break;
    }
  }
  
  public void a_(int paramInt)
  {
    ab.b(this);
    finish();
    if (paramInt == 1) {
      overridePendingTransition(2130968602, 2130968603);
    }
    while (paramInt != 2) {
      return;
    }
    overridePendingTransition(2130968606, 2130968607);
  }
  
  protected void b()
  {
    this.g = ((TitleBarView)findViewById(2131558471));
    if (this.g != null)
    {
      if (!AppModel.getInstance().isLogined()) {
        this.g.setTitleBarTheme(0);
      }
      this.g.setLeftButtonClickListener(new z(this));
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2131296398;; i = 2131296397)
    {
      this.h = i;
      setTheme(this.h);
      return;
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      i = 2131296398;
      this.h = i;
      if (!paramBoolean) {
        break label30;
      }
    }
    label30:
    for (int i = 2;; i = 1)
    {
      ah.a(this, i);
      return;
      i = 2131296397;
      break;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      requestWindowFeature(10);
    }
    setContentView(a());
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      r();
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
    if (this.g != null) {
      this.g.a(this.h);
    }
  }
  
  public void r()
  {
    a_(this.f);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\TitleBarActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */