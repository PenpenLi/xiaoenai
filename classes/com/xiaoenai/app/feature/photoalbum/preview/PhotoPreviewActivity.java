package com.xiaoenai.app.feature.photoalbum.preview;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaoenai.app.common.view.widget.TitleBarView;
import com.xiaoenai.app.feature.photoalbum.a.c;
import com.xiaoenai.app.feature.photoalbum.a.d;
import com.xiaoenai.app.feature.photoalbum.a.e;
import com.xiaoenai.app.feature.photoalbum.a.f;
import com.xiaoenai.app.feature.photoalbum.d.a.a.a.a;
import com.xiaoenai.app.feature.photoalbum.d.a.a.y;
import com.xiaoenai.app.feature.photopreview.view.ImageViewPagerWidget;
import com.xiaoenai.app.feature.photopreview.view.PreviewActivity;
import com.xiaoenai.app.utils.d.t;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.inject.Inject;

public class PhotoPreviewActivity
  extends PreviewActivity
{
  public static String e = "isWholeGroup";
  public static String f = "Album";
  public static String g = "post";
  public static String h = "from";
  public static String i = "albumdata";
  private TextView A;
  private ImageView B;
  private com.xiaoenai.app.ui.a.b C;
  private Calendar D = Calendar.getInstance();
  private int E;
  private boolean F;
  private String G = "";
  private List<com.xiaoenai.app.feature.photopreview.b.a> H;
  private y I;
  private List<Integer> J = new ArrayList();
  @Inject
  protected com.xiaoenai.app.domain.e.d j;
  private LinearLayout y;
  private TextView z;
  
  private void b(int paramInt)
  {
    String str = getString(a.f.album_origin2);
    if (paramInt != 0)
    {
      str = a(paramInt);
      str = String.format(getString(a.f.album_origin), new Object[] { str });
    }
    this.A.setText(str);
  }
  
  private void i()
  {
    this.o = ((ImageViewPagerWidget)findViewById(a.d.image_pager));
    this.y = ((LinearLayout)findViewById(a.d.bottom_Layout));
    this.z = ((TextView)findViewById(a.d.feeling));
    this.A = ((TextView)findViewById(a.d.origin));
    this.B = ((ImageView)findViewById(a.d.download));
    c();
    this.B.setOnClickListener(new a(this));
    this.A.setOnClickListener(new f(this));
  }
  
  private void j()
  {
    if (!com.xiaoenai.app.feature.photoalbum.e.c.b()) {
      com.xiaoenai.app.ui.a.h.c(this, a.f.salbum_dcard_unmounted_tip, 1500L);
    }
    while ((this.H == null) || (this.H.size() <= this.E) || (this.H.get(this.E) == null)) {
      return;
    }
    com.xiaoenai.app.utils.e.b.a(((com.xiaoenai.app.feature.photopreview.b.a)this.H.get(this.E)).j(), new g(this), true, false);
  }
  
  private void k()
  {
    com.xiaoenai.app.ui.a.g localg = new com.xiaoenai.app.ui.a.g(this);
    localg.a(a.f.album_delete_photo_confirm);
    localg.d(com.xiaoenai.app.ui.a.k.j);
    localg.a(a.f.ok, new m(this));
    localg.b(a.f.cancel, new b(this));
    localg.show();
  }
  
  private void m()
  {
    if (this.C == null)
    {
      this.C = new com.xiaoenai.app.ui.a.b(this);
      this.C.a(a.f.delete, 0, new c(this));
    }
    this.C.show();
  }
  
  private void n()
  {
    int k = ((com.xiaoenai.app.feature.photoalbum.b.a)this.H.get(this.E)).d().intValue();
    String str = "0";
    if (this.F) {
      str = String.valueOf(((com.xiaoenai.app.feature.photoalbum.b.a)this.H.get(this.E)).g());
    }
    d locald = new d(this);
    this.j.a(String.valueOf(k), str).b(locald);
  }
  
  private void o()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("current_position_index", this.E);
    int[] arrayOfInt = new int[this.J.size()];
    int k = 0;
    while (k < this.J.size())
    {
      arrayOfInt[k] = ((Integer)this.J.get(k)).intValue();
      k += 1;
    }
    localIntent.putExtra("delete_photo", arrayOfInt);
    localIntent.putExtra("photosize", this.j.b());
    setResult(-1, localIntent);
  }
  
  public String a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    float f1 = (float)paramLong / 1024.0F;
    String str2 = "K";
    f1 = 1.0F * (int)f1;
    String str1 = new DecimalFormat("0").format(f1);
    if (f1 > 1024.0F)
    {
      f1 /= 1024.0F;
      str2 = "M";
      str1 = new DecimalFormat("0.00").format(f1);
    }
    localStringBuilder.append(str1);
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    this.b.setVisibility(0);
    if (f.equals(this.G)) {
      this.y.setVisibility(0);
    }
    while (!g.equals(this.G)) {
      return;
    }
    this.y.setVisibility(8);
  }
  
  protected void a(String paramString, ImageView paramImageView, View paramView)
  {
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    com.xiaoenai.app.utils.e.b.a(paramImageView, paramString, new e(this, paramView), null);
  }
  
  protected void c()
  {
    this.E = getIntent().getIntExtra("position", 0);
    Object localObject;
    if (f.equals(this.G))
    {
      localObject = getIntent().getStringExtra("image_transfer_type");
      if ((localObject != null) && (((String)localObject).equals("image_transfer_type_rxbus"))) {}
      for (localObject = ((com.xiaoenai.app.feature.photoalbum.c.a)com.xiaoenai.app.utils.g.a.a().a(com.xiaoenai.app.feature.photoalbum.c.a.class)).a();; localObject = (List)getIntent().getSerializableExtra(i))
      {
        this.y.setVisibility(0);
        new com.xiaoenai.app.feature.photoalbum.b.b();
        this.H = com.xiaoenai.app.feature.photoalbum.b.b.a((List)localObject);
        if ((this.H != null) && (!this.H.isEmpty())) {
          break;
        }
        return;
      }
      if (this.E >= this.H.size()) {
        this.E = 0;
      }
      if ((this.H != null) && (this.H.size() > 0))
      {
        this.s = new com.xiaoenai.app.feature.photopreview.view.e(this, this.H);
        this.s.a(this);
        this.o.setAdapter(this.s);
      }
      this.D.setTimeInMillis(((com.xiaoenai.app.feature.photoalbum.b.a)this.H.get(this.E)).i().longValue());
      localObject = com.xiaoenai.app.utils.d.d.a(this.D);
      this.b.setTitle((String)localObject);
      localObject = ((com.xiaoenai.app.feature.photoalbum.b.a)this.H.get(this.E)).h();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.z.setVisibility(8);
        label286:
        if (!((com.xiaoenai.app.feature.photopreview.b.a)this.H.get(this.E)).c()) {
          break label509;
        }
        localObject = com.xiaoenai.app.utils.e.b.b(((com.xiaoenai.app.feature.photopreview.b.a)this.H.get(this.E)).j());
        if ((localObject == null) || (0L >= ((File)localObject).length())) {
          break label425;
        }
        this.A.setVisibility(8);
      }
    }
    for (;;)
    {
      this.o.setCurrentItem(this.E);
      this.o.setPageMargin(t.a(this, 60.0F));
      this.o.setOffscreenPageLimit(1);
      this.o.addOnPageChangeListener(new h(this));
      return;
      this.z.setVisibility(0);
      this.z.setText((CharSequence)localObject);
      break label286;
      label425:
      com.xiaoenai.app.utils.f.a.c("preview cacheToDisc error:" + ((com.xiaoenai.app.feature.photopreview.b.a)this.H.get(this.E)).j(), new Object[0]);
      b(((com.xiaoenai.app.feature.photoalbum.b.a)this.H.get(this.E)).f().intValue());
      this.A.setVisibility(0);
      continue;
      label509:
      this.A.setVisibility(8);
      continue;
      if (g.equals(this.G))
      {
        this.y.setVisibility(8);
        localObject = getIntent().getStringArrayExtra("imageUrls");
        this.H = a((String[])localObject);
        if ((this.H == null) || (this.H.isEmpty())) {
          break;
        }
        if (this.E >= this.H.size()) {
          this.E = 0;
        }
        if ((localObject != null) && (localObject.length > 0))
        {
          this.s = new com.xiaoenai.app.feature.photopreview.view.e(this, this.H);
          this.s.a(this);
          this.o.setAdapter(this.s);
        }
        this.b.setTitle(this.E + 1 + " / " + this.s.getCount());
      }
    }
  }
  
  protected int d()
  {
    return a.e.activity_photopreview_album;
  }
  
  protected void f()
  {
    super.f();
    this.G = getIntent().getStringExtra(h);
    if (f.equals(this.G))
    {
      this.b.setTitleBarTheme(3);
      this.b.setTitle("详情");
      this.b.b(a.c.album_title_bar_icon_point, 0);
      this.b.a(a.c.title_bar_icon_back, 0);
      this.b.setLeftButtonClickListener(new i(this));
      this.b.setRightButtonClickListener(new j(this));
    }
    while (!g.equals(this.G)) {
      return;
    }
    this.b.b(a.c.titlebar_icon_trash, 0);
    this.b.a(a.c.title_bar_icon_back, 0);
    this.b.setLeftButtonClickListener(new k(this));
    this.b.setRightButtonClickListener(new l(this));
  }
  
  public void g()
  {
    this.H.remove(this.E);
    if (this.H.size() <= 0)
    {
      o();
      finish();
    }
    this.s = new com.xiaoenai.app.feature.photopreview.view.e(this, this.H);
    this.s.a(this);
    this.o.setAdapter(this.s);
    int k = this.s.getCount();
    String str;
    if (this.E >= k - 1)
    {
      this.o.setCurrentItem(k);
      this.E = (k - 1);
      if (f.equals(this.G))
      {
        this.D.setTimeInMillis(((com.xiaoenai.app.feature.photoalbum.b.a)this.H.get(this.E)).i().longValue());
        str = com.xiaoenai.app.utils.d.d.a(this.D);
        this.b.setTitle(str);
        return;
      }
      this.b.setTitle(k + "/" + k);
      return;
    }
    this.o.setCurrentItem(this.E);
    if (f.equals(this.G))
    {
      this.D.setTimeInMillis(((com.xiaoenai.app.feature.photoalbum.b.a)this.H.get(this.E)).i().longValue());
      str = com.xiaoenai.app.utils.d.d.a(this.D);
      this.b.setTitle(str);
      return;
    }
    this.b.setTitle(this.E + 1 + "/" + k);
  }
  
  public void h()
  {
    this.b.setVisibility(8);
    this.y.setVisibility(8);
  }
  
  protected void l()
  {
    super.l();
    this.I = com.xiaoenai.app.feature.photoalbum.d.a.a.a.c().a(A()).a(z()).a(new com.xiaoenai.app.feature.photoalbum.d.a.b.a()).a();
    this.I.a(this);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    i();
    this.F = getIntent().getBooleanExtra(e, false);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      o();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\preview\PhotoPreviewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */