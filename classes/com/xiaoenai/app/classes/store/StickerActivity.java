package com.xiaoenai.app.classes.store;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.store.sticker.BaseSticker;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.widget.TitleBarView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

public class StickerActivity
  extends TitleBarActivity
{
  private ListView a;
  private ag b;
  private BroadcastReceiver c;
  private boolean i;
  private LinearLayout j;
  private Button k;
  private boolean l;
  private ProgressView m = null;
  private Set<Integer> n = new HashSet();
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString.equals("download_action"))
    {
      paramString = k.a().a(paramInt2);
      if (paramInt1 == 1) {
        if (!isFinishing())
        {
          a.a(this, paramString.getName(), new g(this, paramString));
          break label46;
        }
      }
    }
    label46:
    label163:
    label195:
    for (;;)
    {
      return;
      if (paramInt1 == -1)
      {
        a.a(this, new h(this, paramString));
        return;
        if (!paramString.equals("download_all_action")) {
          break;
        }
        if (this.n.contains(Integer.valueOf(paramInt2)))
        {
          paramString = k.a().a(paramInt2);
          if (paramInt1 != 1) {
            break label163;
          }
          this.n.remove(Integer.valueOf(paramInt2));
          paramString.setDownload(true);
          k.a().c(paramString);
        }
        for (;;)
        {
          if (this.n.size() != 0) {
            break label195;
          }
          com.xiaoenai.app.ui.a.h.a(this, 2131101330, 1500L);
          if (this.k == null) {
            break;
          }
          g();
          return;
          if (paramInt1 == -1)
          {
            this.n.remove(Integer.valueOf(paramInt2));
            paramString.setDownloading(false);
            k.a().d(paramString);
          }
        }
      }
    }
  }
  
  private void a(List<BaseSticker> paramList)
  {
    this.n.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BaseSticker localBaseSticker = (BaseSticker)paramList.next();
      com.xiaoenai.app.f.c localc = new com.xiaoenai.app.f.c(localBaseSticker.getId(), localBaseSticker.getZipUrl(), "download_all_action", localBaseSticker.getName());
      Xiaoenai.j().a().b(localc);
      localBaseSticker.setDownloading(true);
      k.a().d(localBaseSticker);
      this.n.add(Integer.valueOf(localBaseSticker.getId()));
    }
  }
  
  private void f()
  {
    this.a = ((ListView)findViewById(2131559139));
    as.a(this.a);
    this.b = new ag(null, this);
    this.j = ((LinearLayout)LayoutInflater.from(this).inflate(2130903184, null));
    this.k = ((Button)this.j.findViewById(2131559167));
    this.a.addFooterView(this.j);
    this.j.setVisibility(8);
    this.a.setAdapter(this.b);
    this.m = ((ProgressView)findViewById(2131558669));
  }
  
  private void g()
  {
    this.k.setOnClickListener(new f(this));
  }
  
  public int a()
  {
    return 2130903180;
  }
  
  protected void b()
  {
    super.b();
    String str = getIntent().getStringExtra("from");
    if ((str != null) && (str.equals("FacesFragment"))) {
      this.g.a(2130839000, 2131100544);
    }
  }
  
  public void c()
  {
    new com.xiaoenai.app.net.l(new e(this, this)).k();
  }
  
  public void d()
  {
    if (!this.i)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("download_action");
      localIntentFilter.addAction("download_all_action");
      this.c = new a();
      registerReceiver(this.c, localIntentFilter);
    }
    this.i = true;
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
    this.f = 2;
    f();
    this.b.a(k.a().b().toArray(), 1);
    c();
    com.xiaoenai.app.stat.c.a().a(108);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    k.a().c(k.a().b());
  }
  
  protected void onPause()
  {
    super.onPause();
    if ((this.i) && (this.c != null)) {
      unregisterReceiver(this.c);
    }
    this.i = false;
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    this.l = paramBundle.getBoolean("hasStickerRcv");
    super.onRestoreInstanceState(paramBundle);
  }
  
  protected void onResume()
  {
    super.onResume();
    d();
    this.b.notifyDataSetChanged();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("hasStickerRcv", this.l);
    super.onSaveInstanceState(paramBundle);
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      if (paramContext != null)
      {
        int i = paramIntent.getIntExtra("download_id", -1);
        int j = paramIntent.getIntExtra("download_key", -2);
        if (j != -2) {
          StickerActivity.a(StickerActivity.this, paramContext, j, i);
        }
      }
    }
  }
  
  class b
    extends AsyncTask<JSONObject, Void, List<BaseSticker>>
  {
    b() {}
    
    protected List<BaseSticker> a(JSONObject... paramVarArgs)
    {
      return com.xiaoenai.app.utils.l.b(paramVarArgs[0].toString());
    }
    
    protected void a(List<BaseSticker> paramList)
    {
      super.onPostExecute(paramList);
      k.a().d(paramList);
      k.a().d();
      k.a().a(paramList);
      if (!StickerActivity.this.isFinishing()) {
        StickerActivity.a(StickerActivity.this).a(k.a().b().toArray(), 1);
      }
    }
    
    public void a(JSONObject paramJSONObject)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new JSONObject[] { paramJSONObject });
        return;
      }
      execute(new JSONObject[] { paramJSONObject });
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\store\StickerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */