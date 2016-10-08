package com.xiaoenai.app.feature.photopreview.view;

import android.content.Intent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.common.view.activity.TitleBarActivity;
import com.xiaoenai.app.common.view.widget.TitleBarView;
import com.xiaoenai.app.feature.photopreview.a.a;
import com.xiaoenai.app.feature.photopreview.a.c;
import com.xiaoenai.app.utils.d.t;
import java.text.DecimalFormat;
import java.util.ArrayList;

public abstract class PreviewActivity
  extends TitleBarActivity
  implements e.a
{
  private a e;
  protected LinearLayout k;
  protected RelativeLayout l;
  protected TextView m;
  protected Button n;
  protected ImageViewPagerWidget o;
  protected e s;
  protected String[] t;
  protected boolean u = false;
  protected boolean v = false;
  protected boolean w = false;
  protected int x = 0;
  
  protected ArrayList<com.xiaoenai.app.feature.photopreview.b.a> a(String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      com.xiaoenai.app.feature.photopreview.b.a.a locala = new com.xiaoenai.app.feature.photopreview.b.a.a();
      locala.b(paramArrayOfString[i]);
      localArrayList.add(locala);
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.b.setVisibility(0);
    if (this.u) {
      this.l.setVisibility(0);
    }
  }
  
  protected void a(a parama)
  {
    this.e = parama;
  }
  
  public void a(String paramString) {}
  
  public void b()
  {
    if (this.w)
    {
      a();
      this.w = false;
      return;
    }
    h();
    this.w = true;
  }
  
  protected void b(long paramLong)
  {
    if (this.v)
    {
      this.m.setText(getString(a.c.image_upload_original) + "(" + c(paramLong) + ")");
      return;
    }
    this.m.setText(getString(a.c.image_upload_original));
  }
  
  public String c(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    float f = (float)paramLong / 1024.0F;
    String str2 = "K";
    f = 1.0F * (int)f;
    String str1 = new DecimalFormat("0").format(f);
    if (f > 1024.0F)
    {
      f /= 1024.0F;
      str2 = "M";
      str1 = new DecimalFormat("0.00").format(f);
    }
    localStringBuilder.append(str1);
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
  
  protected void c()
  {
    this.x = getIntent().getIntExtra("position", 0);
    this.u = getIntent().getBooleanExtra("show_origin", false);
    this.t = getIntent().getStringArrayExtra("imageUrls");
    this.l = ((RelativeLayout)findViewById(a.a.album_photo_send_btn_layout));
    this.k = ((LinearLayout)findViewById(a.a.image_upload_original_layout));
    this.m = ((TextView)findViewById(a.a.image_upload_original_txt));
    this.n = ((Button)findViewById(a.a.preview_send_btn));
    this.k.setOnClickListener(new b(this));
    this.n.setOnClickListener(new c(this));
    if (this.u) {
      this.l.setVisibility(0);
    }
    for (;;)
    {
      this.o.addOnPageChangeListener(new d(this));
      ArrayList localArrayList = a(this.t);
      if ((this.t != null) && (this.t.length > 0))
      {
        this.s = new e(this, localArrayList);
        this.s.a(this);
        this.o.setAdapter(this.s);
      }
      this.b.setTitle(this.x + 1 + " / " + this.s.getCount());
      this.o.setCurrentItem(this.x);
      this.o.setPageMargin(t.a(this, 60.0F));
      this.o.setOffscreenPageLimit(1);
      return;
      this.l.setVisibility(8);
    }
  }
  
  public void h()
  {
    this.b.setVisibility(8);
    this.l.setVisibility(8);
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photopreview\view\PreviewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */