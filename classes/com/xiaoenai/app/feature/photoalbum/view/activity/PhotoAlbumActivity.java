package com.xiaoenai.app.feature.photoalbum.view.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.common.view.activity.TitleBarActivity;
import com.xiaoenai.app.common.view.widget.TitleBarView;
import com.xiaoenai.app.data.entity.album.UploadData;
import com.xiaoenai.app.feature.photoalbum.a.b;
import com.xiaoenai.app.feature.photoalbum.a.c;
import com.xiaoenai.app.feature.photoalbum.a.d;
import com.xiaoenai.app.feature.photoalbum.a.e;
import com.xiaoenai.app.feature.photoalbum.a.f;
import com.xiaoenai.app.feature.photoalbum.d.a.a.a.a;
import com.xiaoenai.app.feature.photoalbum.d.a.a.y;
import com.xiaoenai.app.feature.photoalbum.view.widget.CanotSlidingViewpager;
import com.xiaoenai.app.feature.photoalbum.view.widget.ToggleButton;
import com.xiaoenai.app.feature.photopicker.view.PhotoPickerActivity;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.utils.d.w;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class PhotoAlbumActivity
  extends TitleBarActivity
{
  private ImageButton A;
  private com.xiaoenai.app.ui.a.b B;
  private com.xiaoenai.app.ui.a.b C;
  private int D = 0;
  private int E = 0;
  private com.xiaoenai.app.b.a F;
  private int G = 0;
  private boolean H = false;
  private y I;
  private Handler J = new b(this);
  @Inject
  protected com.xiaoenai.app.feature.photoalbum.e.c e;
  private CanotSlidingViewpager f;
  private a g;
  private ToggleButton h;
  private View i;
  private SparseArray<Fragment> j = new SparseArray();
  private boolean k = false;
  private View l;
  private com.c.a.l m;
  private com.c.a.l n;
  private TextView o;
  private TextView s;
  private ProgressView t;
  private RelativeLayout u;
  private ImageView v;
  private View w;
  private TextView x;
  private ProgressBar y;
  private ImageButton z;
  
  private void h()
  {
    this.h.setOnToggleListener(new n(this));
    this.f.addOnPageChangeListener(new o(this));
  }
  
  private void i()
  {
    this.m = com.c.a.l.a(this.l, "translationY", new float[] { 100.0F, 0.0F });
    this.m.a(new p(this));
    this.n = com.c.a.l.a(this.l, "translationY", new float[] { 0.0F, 100.0F });
    this.n.a(new q(this));
  }
  
  private void j()
  {
    this.l = findViewById(a.d.manageLayout);
    this.l.setVisibility(8);
    this.t = ((ProgressView)findViewById(a.d.progressView));
    i();
    this.o = ((TextView)findViewById(a.d.cancelBtn));
    this.o.setOnTouchListener(w.a);
    this.o.setOnClickListener(new r(this));
    this.s = ((TextView)findViewById(a.d.deleteBtn));
    this.s.setOnClickListener(new s(this));
    this.s.setClickable(false);
    this.e.a(new t(this));
    k();
  }
  
  private void k()
  {
    this.y = ((ProgressBar)findViewById(a.d.multi_upload_progress));
    this.x = ((TextView)findViewById(a.d.multi_upload_tips));
    this.v = ((ImageView)findViewById(a.d.multi_upload_cur_image));
    this.w = findViewById(a.d.multi_upload_cur_image_foregrand);
    this.z = ((ImageButton)findViewById(a.d.multi_upload_retry_btn));
    this.A = ((ImageButton)findViewById(a.d.multi_upload_cancel_btn));
    this.u = ((RelativeLayout)findViewById(a.d.multi_upload_layout));
    this.z.setOnClickListener(new c(this));
    this.A.setOnClickListener(new d(this));
  }
  
  private void m()
  {
    this.f = ((CanotSlidingViewpager)findViewById(a.d.album_viewpager));
    this.g = new a(getSupportFragmentManager());
    this.f.setAdapter(this.g);
    this.G = b().g();
    this.f.setCurrentItem(this.G);
    ToggleButton localToggleButton = this.h;
    if (this.G == 0) {}
    for (String str = "left";; str = "right")
    {
      localToggleButton.setStatus(str);
      j();
      return;
    }
  }
  
  private void n()
  {
    int i1 = b().a();
    this.B = new com.xiaoenai.app.ui.a.b(this);
    this.B.a(a.f.album_upload_photos, 1, new g(this, i1));
    if (i1 > 0) {
      this.B.a(a.f.edit, 1, new h(this));
    }
    String str = String.format(getString(a.f.album_status_count), new Object[] { Integer.valueOf(i1) });
    this.B.a(str);
    this.B.show();
  }
  
  private void o()
  {
    if (this.C == null)
    {
      this.C = new com.xiaoenai.app.ui.a.b(this);
      this.C.a(a.f.album_take_photo, 1, new i(this));
      this.C.a(a.f.album_pick_from_photo, 1, new j(this));
    }
    this.C.show();
  }
  
  private void p()
  {
    Intent localIntent = new Intent(this, PhotoPickerActivity.class);
    localIntent.putExtra("max_selected_size", 20);
    startActivityForResult(localIntent, 21);
  }
  
  private void q()
  {
    this.F = new com.xiaoenai.app.b.a(this);
    this.F.a(a.a(this));
  }
  
  private void r()
  {
    if (!this.k)
    {
      this.k = true;
      this.f.setScrollble(false);
      a("edit");
      b(-1);
    }
  }
  
  private void s()
  {
    com.xiaoenai.app.ui.a.g localg = new com.xiaoenai.app.ui.a.g(this);
    localg.a(a.f.ok, new k(this));
    localg.b(a.f.cancel, new l(this));
    localg.setTitle(a.f.album_give_up_post);
    localg.d(com.xiaoenai.app.ui.a.k.i);
    localg.show();
  }
  
  public void a()
  {
    if (this.t != null) {
      this.t.setVisibility(8);
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (this.D != paramInt2)
    {
      com.xiaoenai.app.utils.e.b.a(this.v, paramString, getResources().getDrawable(a.c.album_stub_images));
      com.xiaoenai.app.utils.f.a.c("onUploadProcess {} {} {} ", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
      paramString = new StringBuilder(getResources().getString(a.f.album_uploading));
      paramString.append(paramInt2 + "/");
      paramString.append(this.E);
      this.x.setText(paramString.toString());
    }
    if (paramInt1 != 100)
    {
      this.y.setMax(this.E * 100);
      this.y.setProgress(paramInt2 * 100 + paramInt1);
    }
    this.u.setVisibility(0);
  }
  
  public void a(String paramString)
  {
    if (paramString.equals("normal"))
    {
      this.b.a(null, this.i);
      this.b.setLeftButtonVisible(0);
      this.b.setRightButtonVisible(0);
      this.s.setClickable(false);
      this.n.a();
    }
    while (!paramString.equals("edit")) {
      return;
    }
    this.b.setDefultTitleTextView(a.f.album_select_photos);
    this.b.setLeftButtonVisible(8);
    this.b.setRightButtonVisible(8);
    this.s.setText(getString(a.f.delete));
    this.m.a();
  }
  
  public void a(List<String> paramList)
  {
    this.u.setVisibility(0);
    StringBuilder localStringBuilder = new StringBuilder(getResources().getString(a.f.album_uploading));
    localStringBuilder.append("0/");
    if (paramList != null) {
      this.E = paramList.size();
    }
    localStringBuilder.append(this.E);
    this.x.setText(localStringBuilder.toString());
    this.x.setTextColor(getResources().getColor(a.b.album_upload_gray));
    this.y.setVisibility(0);
    this.y.setMax(this.E * 100);
    this.y.setProgress(0);
    this.z.setVisibility(8);
    this.A.setVisibility(8);
    this.H = true;
    if ((paramList != null) && (this.E > 0)) {
      com.xiaoenai.app.utils.e.b.a(this.v, (String)paramList.get(0), getResources().getDrawable(a.c.album_stub_images));
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.u.setVisibility(8);
      this.H = false;
      this.J.sendEmptyMessageDelayed(0, 1000L);
    }
  }
  
  public com.xiaoenai.app.feature.photoalbum.e.c b()
  {
    return this.e;
  }
  
  public void b(int paramInt)
  {
    ((com.xiaoenai.app.feature.photoalbum.view.b.c)this.g.getItem(0)).a(paramInt);
    ((com.xiaoenai.app.feature.photoalbum.view.b.a)this.g.getItem(1)).a(paramInt);
  }
  
  public void c()
  {
    this.y.setVisibility(8);
    this.x.setText(a.f.album_upload_error2);
    ColorDrawable localColorDrawable = new ColorDrawable(Color.argb(64, 0, 0, 0));
    this.w.setBackgroundDrawable(localColorDrawable);
    this.w.setVisibility(0);
    this.x.setTextColor(Color.rgb(234, 66, 66));
    this.z.setVisibility(0);
    this.A.setVisibility(0);
  }
  
  protected int d()
  {
    return a.e.activity_photo_album;
  }
  
  protected void f()
  {
    super.f();
    this.i = getLayoutInflater().inflate(a.e.titleview_albumphoto, null);
    this.h = ((ToggleButton)this.i.findViewById(a.d.album_topic_tab));
    this.h.a(a.c.icon_album_tab_time_alxe, a.c.icon_album_tab_table);
    this.b.a(null, this.i);
    this.b.a(a.c.title_bar_icon_back, a.f.app_name);
    this.b.b(0, a.f.managerr);
    this.b.setLeftButtonClickListener(new e(this));
    this.b.setRightButtonClickListener(new f(this));
  }
  
  public boolean g()
  {
    return this.k;
  }
  
  protected void l()
  {
    super.l();
    this.I = com.xiaoenai.app.feature.photoalbum.d.a.a.a.c().a(A()).a(z()).a(new com.xiaoenai.app.feature.photoalbum.d.a.b.a()).a();
    this.I.a(this);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (-1 == paramInt2) {}
    switch (paramInt1)
    {
    default: 
    case 21: 
    case 32: 
    case 2: 
      do
      {
        return;
        Object localObject = new Intent(this, PostPhotoActivity.class);
        ArrayList localArrayList = paramIntent.getStringArrayListExtra("selected_image_url");
        paramIntent = paramIntent.getIntArrayExtra("image_url_origin");
        ((Intent)localObject).putExtra("selected_image_url", localArrayList);
        ((Intent)localObject).putExtra("image_url_origin", paramIntent);
        ((Intent)localObject).putExtra("image_count", b().a());
        startActivityForResult((Intent)localObject, 1);
        return;
        this.F.a(paramInt1, paramInt2);
        return;
        localObject = paramIntent.getIntArrayExtra("delete_photo");
        this.e.a((int[])localObject, true);
        paramInt1 = paramIntent.getIntExtra("current_position_index", -1);
        if (-1 != paramInt1) {
          b(paramInt1);
        }
        paramInt1 = paramIntent.getIntExtra("photosize", -1);
      } while (-1 == paramInt1);
      this.e.a(paramInt1);
      return;
    }
    this.e.f();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    f();
    this.e.a(this);
    this.e.a(this.c);
    m();
    this.e.a(new m(this));
    h();
    paramBundle = this.c.b("uploaddata", "");
    com.xiaoenai.app.utils.f.a.c("upload data = {}", new Object[] { paramBundle });
    if (paramBundle.length() > 0)
    {
      this.E = Integer.valueOf(((UploadData)new com.google.gson.j().a(paramBundle, UploadData.class)).getUploadtotalCount()).intValue();
      this.e.f();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.e.k();
    this.e = null;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (g())
      {
        this.k = false;
        this.f.setScrollble(true);
        a("normal");
        b(-1);
        this.e.h();
        this.s.setBackgroundDrawable(getResources().getDrawable(a.c.album_send_btn_unable));
        this.s.setTextColor(getResources().getColor(a.b.album_delete_btn_text));
        return true;
      }
      b().b(this.G);
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  class a
    extends FragmentPagerAdapter
  {
    private Fragment b;
    
    public a(FragmentManager paramFragmentManager)
    {
      super();
    }
    
    public int getCount()
    {
      return 2;
    }
    
    public Fragment getItem(int paramInt)
    {
      Object localObject1 = (Fragment)PhotoAlbumActivity.k(PhotoAlbumActivity.this).get(paramInt);
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        if (paramInt != 0) {
          break label49;
        }
        localObject1 = new com.xiaoenai.app.feature.photoalbum.view.b.c();
      }
      for (;;)
      {
        PhotoAlbumActivity.k(PhotoAlbumActivity.this).put(paramInt, localObject1);
        localObject2 = localObject1;
        return (Fragment)localObject2;
        label49:
        if (1 == paramInt) {
          localObject1 = new com.xiaoenai.app.feature.photoalbum.view.b.a();
        }
      }
    }
    
    public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      this.b = ((Fragment)paramObject);
      super.setPrimaryItem(paramViewGroup, paramInt, paramObject);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\view\activity\PhotoAlbumActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */