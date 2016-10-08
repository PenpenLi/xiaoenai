package com.xiaoenai.app.classes.store;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.store.sticker.BaseSticker;
import com.xiaoenai.app.f.c;
import com.xiaoenai.app.net.l;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.widget.TitleBarView;

public class StickerDownloadActivity
  extends TitleBarActivity
{
  public String a;
  private TextView b;
  private ImageView c;
  private ProgressBar i;
  private ImageButton j;
  private TextView k;
  private BaseSticker l;
  private a m;
  private c n;
  
  public static int a(long paramLong)
  {
    if ((paramLong < -2147483648L) || (paramLong > 2147483647L)) {
      throw new IllegalArgumentException(paramLong + " cannot be cast to int without changing its value.");
    }
    return (int)paramLong;
  }
  
  private void a(String paramString, int paramInt)
  {
    if (paramString.equals("download_action"))
    {
      if (paramInt != 1) {
        break label41;
      }
      if (!isFinishing()) {
        a.a(this, this.l.getName(), new z(this));
      }
    }
    label41:
    while (paramInt != -1) {
      return;
    }
    a.a(this, new aa(this));
  }
  
  public int a()
  {
    return 2130903181;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.b.setText(paramString1);
    b.a(this.c, paramString2);
  }
  
  protected void b()
  {
    super.b();
    this.g.setRightButtonClickListener(new x(this));
  }
  
  public void c()
  {
    this.b = ((TextView)findViewById(2131559140));
    this.c = ((ImageView)findViewById(2131559142));
    this.i = ((ProgressBar)findViewById(2131559144));
    this.j = ((ImageButton)findViewById(2131559145));
    this.k = ((TextView)findViewById(2131559146));
    this.j.setOnClickListener(new u(this));
  }
  
  public void d()
  {
    new l(new y(this, this)).b(this.l.getId());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.f = 2;
    c();
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.l = ((BaseSticker)paramBundle.getParcelableExtra("detailAction"));
      if (this.l != null) {
        a(this.l.getName(), this.l.getThumb_url());
      }
      d();
    }
    this.m = new a();
    paramBundle = new IntentFilter();
    paramBundle.addAction("download_action");
    registerReceiver(this.m, paramBundle);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.m != null) {
      unregisterReceiver(this.m);
    }
    a.a = false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      r();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      if ((paramContext != null) && (paramIntent.getIntExtra("download_id", -1) == StickerDownloadActivity.b(StickerDownloadActivity.this).getId()))
      {
        int i = paramIntent.getIntExtra("download_key", -2);
        if (i != -2) {
          StickerDownloadActivity.a(StickerDownloadActivity.this, paramContext, i);
        }
        long l1 = paramIntent.getLongExtra("download_size", -1L);
        if (l1 != -1L)
        {
          long l2 = paramIntent.getLongExtra("total_size", 1L);
          StickerDownloadActivity.c(StickerDownloadActivity.this).setText(l1 + "/" + l2 + " KBytes");
          StickerDownloadActivity.d(StickerDownloadActivity.this).setProgress(StickerDownloadActivity.a(l1 * 100L / l2));
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\store\StickerDownloadActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */