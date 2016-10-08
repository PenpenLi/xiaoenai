package com.xiaoenai.app.classes.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.f.a.b;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.net.l;
import com.xiaoenai.app.service.ApkDownloadService;
import com.xiaoenai.app.ui.a.g;
import com.xiaoenai.app.ui.a.k;

public class UpdateActivity
  extends TitleBarActivity
{
  private int a = 123;
  private TextView b;
  private String c = "";
  private Intent i = null;
  private View.OnClickListener j = new bk(this);
  
  private void a(String paramString1, String paramString2)
  {
    g localg = new g(this);
    localg.d(k.i);
    localg.a(paramString1);
    localg.a(2131099696, new bl(this, paramString2));
    localg.b(2131099694, new bm(this));
    localg.show();
  }
  
  private void b(String paramString)
  {
    this.i = new Intent();
    this.i.setAction("downloadApkAction");
    this.i.setClass(this, ApkDownloadService.class);
    this.i.putExtra("url", paramString);
    startService(this.i);
    b.b(this, "UpdateApp");
  }
  
  private void d()
  {
    new l(new bn(this, this)).j();
  }
  
  public int a()
  {
    return 2130903324;
  }
  
  public void c()
  {
    ((TextView)findViewById(2131559699)).setText(getString(2131099698) + Xiaoenai.j().B);
    this.b = ((TextView)findViewById(2131559777));
    this.b.setText(getString(2131099690));
    ((Button)findViewById(2131559779)).setOnClickListener(this.j);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent().getIntExtra("from", 0) == 1) {
      this.d = false;
    }
    c();
    d();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      finish();
      overridePendingTransition(2130968606, 2130968607);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\UpdateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */