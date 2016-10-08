package com.xiaoenai.app.classes.album;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.common.dialog.e;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.model.album.Photo;
import com.xiaoenai.app.model.album.PhotoImageList;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.utils.d.w;
import com.xiaoenai.app.utils.g;
import com.xiaoenai.app.widget.TitleBarView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PhotoAlbumActivity
  extends TitleBarActivity
  implements t.b
{
  private a A;
  private e B;
  private boolean a = false;
  private TextView b = null;
  private TextView c = null;
  private View i;
  private ProgressView j = null;
  private com.xiaoenai.app.ui.a.h k = null;
  private boolean l = true;
  private boolean m = false;
  private int n = 0;
  private int o = 0;
  private com.c.a.l s;
  private com.c.a.l t;
  private RelativeLayout u;
  private ImageView v;
  private TextView w;
  private ProgressBar x;
  private ImageButton y;
  private ImageButton z;
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.m) {
      return;
    }
    new com.xiaoenai.app.net.b(new b(this, this, paramInt1)).a(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  private void a(List<Photo> paramList)
  {
    Object localObject = new StringBuilder();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      ((StringBuilder)localObject).append(((Photo)localIterator.next()).getId()).append(",");
    }
    localObject = ((StringBuilder)localObject).toString().substring(0, ((StringBuilder)localObject).length() - 1);
    new com.xiaoenai.app.net.b(new c(this, this, paramList)).c((String)localObject);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    int i2 = 0;
    if (isFinishing()) {
      return;
    }
    this.j.setVisibility(8);
    try
    {
      if (paramJSONObject.has("size"))
      {
        this.n = paramJSONObject.getInt("size");
        UserConfig.setInt("photoalbum_total", this.n);
      }
      if (paramJSONObject.has("count"))
      {
        this.o = paramJSONObject.getInt("count");
        UserConfig.setInt("photoalbum_cur", this.o);
        if (this.o == 0)
        {
          this.l = false;
          c(0);
          return;
        }
      }
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      return;
    }
    paramJSONObject = paramJSONObject.getJSONArray("list");
    int i1 = i2;
    if (paramJSONObject.length() == 0)
    {
      this.l = false;
      i1 = i2;
    }
    for (;;)
    {
      if (i1 < paramJSONObject.length())
      {
        Object localObject = paramJSONObject.getJSONObject(i1);
        if ((!((JSONObject)localObject).has("del")) || (((JSONObject)localObject).getInt("del") != 1))
        {
          localObject = new Photo((JSONObject)localObject);
          PhotoImageList.getInstance().addPhoto((Photo)localObject);
        }
      }
      else
      {
        q();
        return;
      }
      i1 += 1;
    }
  }
  
  private void a(String[] paramArrayOfString, boolean paramBoolean)
  {
    if (paramArrayOfString.length < 0) {
      return;
    }
    this.u.setVisibility(0);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("0/");
    ((StringBuilder)localObject).append(paramArrayOfString.length);
    this.w.setText(((StringBuilder)localObject).toString());
    this.x.setVisibility(0);
    this.x.setMax(paramArrayOfString.length);
    this.x.setProgress(0);
    this.y.setVisibility(4);
    this.z.setVisibility(4);
    int i1 = 0;
    label91:
    com.xiaoenai.app.classes.common.b.c localc;
    if (i1 < paramArrayOfString.length)
    {
      localObject = g.a().a(paramArrayOfString[i1]);
      com.xiaoenai.app.classes.common.b.c.a().b(paramArrayOfString.length);
      localc = com.xiaoenai.app.classes.common.b.c.a();
      if (!paramBoolean) {
        break label149;
      }
    }
    label149:
    for (int i2 = 1;; i2 = 0)
    {
      localc.a((String)localObject, this, 1, 1, i2);
      i1 += 1;
      break label91;
      break;
    }
  }
  
  private void b(String paramString)
  {
    if (paramString.equals("normal"))
    {
      this.g.setTitle(2131099739);
      this.g.setLeftButtonVisible(0);
      this.g.setRightButtonVisible(0);
      this.t.a();
    }
    while (!paramString.equals("edit")) {
      return;
    }
    this.g.setTitle(2131099734);
    this.g.setLeftButtonVisible(8);
    this.g.setRightButtonVisible(8);
    this.c.setText(getString(2131100104));
    this.s.a();
  }
  
  private void c(int paramInt)
  {
    if (isFinishing()) {}
    LinearLayout localLinearLayout;
    do
    {
      return;
      localLinearLayout = (LinearLayout)findViewById(2131558736);
    } while (localLinearLayout == null);
    localLinearLayout.setVisibility(paramInt);
  }
  
  private void d(int paramInt)
  {
    this.x.setVisibility(8);
    this.w.setText(String.format(getString(2131100611), new Object[] { Integer.valueOf(paramInt) }));
    this.y.setVisibility(0);
    this.z.setVisibility(0);
  }
  
  private void f()
  {
    this.i = findViewById(2131558711);
    this.i.setVisibility(8);
    j();
    this.b = ((TextView)findViewById(2131558712));
    this.b.setOnTouchListener(w.a);
    this.b.setOnClickListener(new a(this));
    this.c = ((TextView)findViewById(2131558713));
    this.c.setOnTouchListener(w.a);
    this.c.setOnClickListener(new h(this));
    this.j = ((ProgressView)findViewById(2131558669));
    h();
  }
  
  private void g()
  {
    if (com.xiaoenai.app.classes.common.b.c.a().e())
    {
      this.x.setMax(com.xiaoenai.app.classes.common.b.c.a().d());
      this.x.setProgress(com.xiaoenai.app.classes.common.b.c.a().d() - com.xiaoenai.app.classes.common.b.c.a().c());
      this.w.setText(com.xiaoenai.app.classes.common.b.c.a().d() - com.xiaoenai.app.classes.common.b.c.a().c() + "/" + com.xiaoenai.app.classes.common.b.c.a().d());
      this.u.setVisibility(0);
      return;
    }
    i();
  }
  
  private void h()
  {
    this.u = ((RelativeLayout)findViewById(2131558700));
    this.v = ((ImageView)findViewById(2131558702));
    this.w = ((TextView)findViewById(2131558705));
    this.x = ((ProgressBar)findViewById(2131558706));
    this.y = ((ImageButton)findViewById(2131558707));
    this.z = ((ImageButton)findViewById(2131558708));
    this.y.setOnClickListener(new i(this));
    this.z.setOnClickListener(new j(this));
  }
  
  private void i()
  {
    List localList = com.xiaoenai.app.classes.common.b.a.a().b();
    com.xiaoenai.app.classes.common.b.a.a().a(1);
    if (localList.size() > 0)
    {
      String[] arrayOfString = new String[localList.size()];
      int i1 = 0;
      while (i1 < arrayOfString.length)
      {
        arrayOfString[i1] = ((com.xiaoenai.app.classes.common.b.b)localList.get(i1)).a();
        i1 += 1;
      }
      a(arrayOfString, ((com.xiaoenai.app.classes.common.b.b)localList.get(0)).d());
      com.xiaoenai.app.classes.common.b.c.a().g();
    }
  }
  
  private void j()
  {
    this.s = com.c.a.l.a(this.i, "translationY", new float[] { 100.0F, 0.0F });
    this.s.a(new l(this));
    this.t = com.c.a.l.a(this.i, "translationY", new float[] { 0.0F, 100.0F });
    this.t.a(new m(this));
  }
  
  private void k()
  {
    if (this.B == null)
    {
      this.B = new e(this);
      this.B.a(2131099749, 1, new n(this));
      this.B.a(2131100145, 1, new q(this));
    }
    String str = String.format(getString(2131099736), new Object[] { Integer.valueOf(this.o) });
    this.B.a(str);
    this.B.show();
  }
  
  private void o()
  {
    if (this.k == null)
    {
      this.k = com.xiaoenai.app.ui.a.h.a(this);
      this.k.a(getString(2131099714));
      this.k.setCancelable(false);
    }
    if (!this.k.isShowing()) {
      this.k.show();
    }
  }
  
  private void p()
  {
    if ((this.k != null) && (this.k.isShowing())) {
      this.k.dismiss();
    }
  }
  
  private void q()
  {
    if (this.o > 0) {
      c(4);
    }
    for (;;)
    {
      t localt = (t)getSupportFragmentManager().findFragmentByTag("PhotoAlbumFragment");
      if (localt != null) {
        localt.a();
      }
      return;
      c(0);
    }
  }
  
  public int a()
  {
    return 2130903082;
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 0)
    {
      this.c.setTextColor(getResources().getColor(2131493206));
      this.c.setText(getString(2131100104) + "(" + paramInt + ")");
      this.c.setBackgroundResource(2130837584);
      return;
    }
    this.c.setTextColor(getResources().getColor(2131492872));
    this.c.setText(getString(2131100104));
    this.c.setBackgroundResource(2130837604);
  }
  
  protected void b()
  {
    super.b();
    this.g.setRightButtonClickListener(new k(this));
  }
  
  public boolean c()
  {
    return this.a;
  }
  
  public void d()
  {
    if (!this.a)
    {
      Iterator localIterator = PhotoImageList.getInstance().getPhotoList().iterator();
      while (localIterator.hasNext()) {
        ((Photo)localIterator.next()).setSelected(false);
      }
    }
    this.a = true;
    b("edit");
    q();
  }
  
  public void e_()
  {
    if ((this.l) && (!this.m)) {
      a(PhotoImageList.getInstance().size(), 40);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 != 21) {
        break label44;
      }
      a(paramIntent.getStringArrayExtra("image_url_array"), paramIntent.getBooleanExtra("image_origin_flag", false));
      com.xiaoenai.app.classes.common.b.c.a().b();
    }
    label44:
    while ((paramInt1 != 0) || (paramIntent == null) || (paramIntent.getData() == null)) {
      return;
    }
    g.a().a(paramIntent.getData().getPath(), this, new d(this, paramIntent), 0);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.f = 2;
    f();
    if (getSupportFragmentManager().findFragmentByTag("PhotoAlbumFragment") == null)
    {
      paramBundle = getSupportFragmentManager().beginTransaction();
      paramBundle.add(2131558735, new t(), "PhotoAlbumFragment");
      paramBundle.commit();
    }
    a(0, 40);
    com.xiaoenai.app.stat.c.a().a(110);
    this.A = new a();
    paramBundle = new IntentFilter();
    paramBundle.addAction("job_action");
    registerReceiver(this.A, paramBundle);
    g();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.A != null)
    {
      unregisterReceiver(this.A);
      this.A = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.a)
      {
        this.a = false;
        b("normal");
        q();
        return true;
      }
    }
    else if (paramInt == 82)
    {
      if ((this.B != null) && (this.B.isShowing()))
      {
        this.B.dismiss();
        return true;
      }
      k();
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
    this.n = UserConfig.getInt("photoalbum_total", Integer.valueOf(this.n)).intValue();
    this.o = UserConfig.getInt("photoalbum_cur", Integer.valueOf(this.o)).intValue();
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      int i;
      if (paramIntent.getAction().equals("job_action"))
      {
        i = paramIntent.getIntExtra("op", 0);
        if (i != 1) {
          break label76;
        }
        paramContext = paramIntent.getStringExtra("job_data_url");
        com.xiaoenai.app.utils.e.b.a(PhotoAlbumActivity.m(PhotoAlbumActivity.this), "file://" + paramContext, PhotoAlbumActivity.this.getResources().getDrawable(2130839089));
      }
      label76:
      do
      {
        String str;
        int j;
        int k;
        do
        {
          return;
          if (i != 2) {
            break;
          }
          str = paramIntent.getStringExtra("job_data_json");
          paramContext = paramIntent.getStringExtra("job_data_url");
          i = paramIntent.getIntExtra("job_data_leftSize", -1);
          j = paramIntent.getIntExtra("job_data_totalSize", 0);
          k = paramIntent.getIntExtra("job_data_is_original", 0);
        } while ((str == null) || (paramContext == null) || (i < 0));
        try
        {
          paramIntent = new JSONObject(str);
          int m = paramIntent.getInt("id");
          int n = paramIntent.getInt("ts");
          Xiaoenai.j().a(new r(this, m, n, paramContext, k, j, i));
          return;
        }
        catch (JSONException paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
        if (i == -1)
        {
          i = paramIntent.getIntExtra("job_data_leftSize", 0);
          PhotoAlbumActivity.b(PhotoAlbumActivity.this, i);
          PhotoAlbumActivity.a(PhotoAlbumActivity.this);
          return;
        }
      } while (i != 3);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\album\PhotoAlbumActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */