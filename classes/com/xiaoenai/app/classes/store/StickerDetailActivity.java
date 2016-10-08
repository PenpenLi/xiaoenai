package com.xiaoenai.app.classes.store;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.store.sticker.BaseSticker;
import com.xiaoenai.app.classes.store.sticker.Sticker;
import com.xiaoenai.app.net.l;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.utils.e.b;
import java.util.Vector;

public class StickerDetailActivity
  extends TitleBarActivity
{
  protected static boolean a = false;
  private Button b;
  private ImageView c;
  private TextView i;
  private TextView j;
  private GridView k;
  private ImageView l;
  private i m;
  private Vector<Sticker> n = new Vector();
  private ScrollView o;
  private BaseSticker s;
  private boolean t;
  private s u;
  private com.xiaoenai.app.classes.chat.input.faces.p v;
  private RelativeLayout w;
  private LinearLayout x;
  private RelativeLayout y;
  private a z;
  
  private int a(int paramInt)
  {
    return ab.a() * paramInt / 1280;
  }
  
  private void a(String paramString, int paramInt)
  {
    if (paramString.equals("download_action"))
    {
      if (paramInt != 1) {
        break label41;
      }
      if (!isFinishing()) {
        a.a(this, this.s.getName(), new q(this));
      }
    }
    label41:
    while (paramInt != -1) {
      return;
    }
    a.a(this, new r(this));
  }
  
  private void d()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("download_action");
    registerReceiver(this.z, localIntentFilter);
    this.t = true;
  }
  
  public int a()
  {
    return 2130903182;
  }
  
  public void a(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getAction() != null) && (paramIntent.getAction().equals("detailAction")))
    {
      this.f = 2;
      this.s = k.a().a(paramIntent.getIntExtra("data", -1));
      if (this.s != null)
      {
        new l(new o(this, this)).a(this.s.getId());
        a(this.s);
      }
    }
  }
  
  public void a(BaseSticker paramBaseSticker)
  {
    this.i.setText(paramBaseSticker.getName());
    b(paramBaseSticker);
    t.a(this, paramBaseSticker, this.u);
    this.j.setText(paramBaseSticker.getIntro());
    b.a(this.c, paramBaseSticker.getCover_url());
    b.a(this.l, paramBaseSticker.getCover_bg_url());
  }
  
  public void b(BaseSticker paramBaseSticker)
  {
    if (!paramBaseSticker.isDownload())
    {
      if (!paramBaseSticker.isPurchased()) {
        this.b.setOnClickListener(new n(this, paramBaseSticker));
      }
    }
    else {
      return;
    }
    d(paramBaseSticker);
  }
  
  public void c()
  {
    this.b = ((Button)findViewById(2131559153));
    this.c = ((ImageView)findViewById(2131559151));
    this.i = ((TextView)findViewById(2131559140));
    this.j = ((TextView)findViewById(2131559154));
    this.u = new s(this.b, this.i);
    this.w = ((RelativeLayout)findViewById(2131559148));
    this.x = ((LinearLayout)findViewById(2131559150));
    this.y = ((RelativeLayout)findViewById(2131559152));
    Object localObject = new LinearLayout.LayoutParams(-1, a(600));
    if (Build.VERSION.SDK_INT > 16) {
      ((LinearLayout.LayoutParams)localObject).gravity = 4;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, a(430));
    localLayoutParams.addRule(14, -1);
    this.w.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.x.setLayoutParams(localLayoutParams);
    localObject = new RelativeLayout.LayoutParams(-1, a(100));
    ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
    this.y.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.k = ((GridView)findViewById(2131559156));
    this.l = ((ImageView)findViewById(2131559149));
    this.m = new i(this.n.toArray(), this);
    this.k.setAdapter(this.m);
    this.o = ((ScrollView)findViewById(2131559147));
    if (Build.VERSION.SDK_INT >= 8) {
      this.k.smoothScrollToPosition(0, 0);
    }
    this.o.smoothScrollTo(0, 0);
    as.a(this.o);
    this.k.setOnTouchListener(new com.xiaoenai.app.classes.chat.input.faces.t(null, this.v, new m(this), 2));
  }
  
  public void c(BaseSticker paramBaseSticker)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("detailAction", paramBaseSticker);
    localIntent.setClass(this, StickerDownloadActivity.class);
    startActivity(localIntent);
  }
  
  public void d(BaseSticker paramBaseSticker)
  {
    this.b.setOnClickListener(new p(this, paramBaseSticker));
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 4))
    {
      r();
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.v == null) {
      this.v = new com.xiaoenai.app.classes.chat.input.faces.p(this);
    }
    c();
    this.z = new a();
    a(getIntent());
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.z != null) && (this.t))
    {
      unregisterReceiver(this.z);
      this.t = false;
    }
  }
  
  protected void onPause()
  {
    if ((this.z != null) && (this.t))
    {
      unregisterReceiver(this.z);
      this.t = false;
    }
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    d();
    this.s = k.a().a(this.s.getId());
    a(this.s);
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      if ((paramContext != null) && (paramIntent.getIntExtra("download_id", -1) == StickerDetailActivity.b(StickerDetailActivity.this).getId()))
      {
        int i = paramIntent.getIntExtra("download_key", -2);
        if (i != -2) {
          StickerDetailActivity.a(StickerDetailActivity.this, paramContext, i);
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\store\StickerDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */