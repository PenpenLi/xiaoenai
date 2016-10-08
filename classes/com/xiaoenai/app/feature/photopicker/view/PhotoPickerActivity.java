package com.xiaoenai.app.feature.photopicker.view;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.common.view.activity.TitleBarActivity;
import com.xiaoenai.app.common.view.widget.TitleBarView;
import com.xiaoenai.app.feature.photopicker.a.a;
import com.xiaoenai.app.feature.photopicker.a.b;
import com.xiaoenai.app.feature.photopicker.a.c;
import com.xiaoenai.app.feature.photopicker.a.d;
import com.xiaoenai.app.feature.photopicker.a.e;
import com.xiaoenai.app.utils.d.w;
import java.util.ArrayList;
import java.util.List;

public class PhotoPickerActivity
  extends TitleBarActivity
  implements Animation.AnimationListener
{
  private GridView e;
  private m f;
  private TextView g;
  private TextView h;
  private TextView i;
  private RelativeLayout j;
  private ArrayList<com.xiaoenai.app.feature.photopicker.a.d> k;
  private ListView l;
  private a m;
  private int n = 1;
  private com.xiaoenai.app.feature.photopicker.b.c o;
  private int s = 2;
  private int t = -1;
  private boolean u = true;
  private int v;
  private int w = -1;
  private int[] x;
  private boolean y = false;
  private Handler z = new Handler();
  
  private void a()
  {
    this.a = 2;
    this.e = ((GridView)findViewById(a.c.image_picker_grid_view));
    this.g = ((TextView)findViewById(a.c.previewBtn));
    this.h = ((TextView)findViewById(a.c.sendBtn));
    this.i = ((TextView)findViewById(a.c.count));
    this.j = ((RelativeLayout)findViewById(a.c.manageLayout));
    this.i.setVisibility(8);
    this.s = getIntent().getIntExtra("pick_from", 2);
    this.u = getIntent().getBooleanExtra("original_flag", true);
    this.t = getIntent().getIntExtra("max_selected_size", -1);
    this.w = getIntent().getIntExtra("image_picker_mode", -1);
    if (this.t != -1) {
      m.b(this.t);
    }
    if (this.s == 1) {
      this.h.setText(a.e.photopicker_send);
    }
    for (;;)
    {
      if (this.t != -1) {
        m.b(this.t);
      }
      b();
      c();
      g();
      return;
      if (this.s == 2)
      {
        this.h.setText(a.e.photopicker_image_upload);
      }
      else if (this.s == 3)
      {
        this.h.setText(a.e.photopicker_done);
        this.b.setTitle(a.e.photopicker_image_picker_title);
      }
    }
  }
  
  private void a(View paramView)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.2F, 1.0F, 1.2F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setAnimationListener(this);
    paramView.startAnimation(localScaleAnimation);
  }
  
  private void a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("selected_image_url", paramArrayList);
      localIntent.putExtra("image_url_origin", this.x);
      setResult(-1, localIntent);
      finish();
    }
  }
  
  private void b()
  {
    this.f = new m(this, new c(this), this.o, this.u);
    if (this.w != -1) {
      this.f.c(this.w);
    }
    this.e.setAdapter(this.f);
    this.o.a(new d(this), this);
    this.e.setOnItemClickListener(this.f);
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 0) {
      if (this.s == 1)
      {
        this.h.setText(a.e.photopicker_send);
        this.g.setClickable(false);
        this.g.setTextColor(getResources().getColor(a.a.album_preview_btn_unable));
        this.h.setClickable(false);
        this.h.setTextColor(getResources().getColor(a.a.album_send_btn_unable));
        this.i.setVisibility(8);
      }
    }
    while (paramInt <= 0) {
      for (;;)
      {
        return;
        if (this.s == 2) {
          this.h.setText(a.e.photopicker_image_upload);
        } else if (this.s == 3) {
          this.h.setText(a.e.photopicker_done);
        }
      }
    }
    this.g.setClickable(true);
    this.g.setTextColor(getResources().getColor(a.a.album_preview_btn_able));
    this.h.setClickable(true);
    this.h.setTextColor(getResources().getColor(a.a.album_send_btn_able));
    this.i.setText(String.valueOf(paramInt));
    this.i.setVisibility(0);
    a(this.i);
  }
  
  private void b(View paramView)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.2F, 1.0F, 1.2F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(400L);
    paramView.setAnimation(localScaleAnimation);
    localScaleAnimation.start();
  }
  
  private void c()
  {
    this.g.setClickable(false);
    this.g.setOnClickListener(new h(this));
    this.g.setOnTouchListener(w.a);
  }
  
  private void g()
  {
    this.h.setClickable(false);
    this.h.setOnClickListener(new i(this));
    this.h.setOnTouchListener(w.a);
  }
  
  private void h()
  {
    this.l = ((ListView)findViewById(a.c.image_dir_list));
    this.m = new a(null, this);
    this.l.setAdapter(this.m);
  }
  
  private void i()
  {
    ArrayList localArrayList = this.o.e();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      this.j.setVisibility(8);
      this.l.setVisibility(0);
      this.e.setVisibility(8);
      this.b.setLeftButtonVisible(8);
      this.m.a(this.o.e(), new l(this));
    }
  }
  
  public int d()
  {
    return a.d.activity_photo_picker;
  }
  
  protected void f()
  {
    super.f();
    this.b.setTitle(a.e.photopicker_image_picker_title);
    this.b.a(a.b.title_bar_icon_back, a.e.photopicker_album);
    this.b.b(0, a.e.photopicker_cancel);
    this.b.setLeftButtonClickListener(new j(this));
    this.b.setRightButtonClickListener(new k(this));
  }
  
  public void m_()
  {
    if (this.n == 2)
    {
      super.m_();
      return;
    }
    this.n = 2;
    i();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ArrayList localArrayList;
    if ((-1 == paramInt2) && (1 == paramInt1))
    {
      this.x = paramIntent.getIntArrayExtra("image_url_origin");
      if (this.f != null) {
        this.f.a(this.x);
      }
      localArrayList = paramIntent.getStringArrayListExtra("selected_image_url");
      if (paramIntent.getBooleanExtra("action_back", false))
      {
        b(localArrayList.size());
        this.o.b(localArrayList);
        this.f.notifyDataSetChanged();
      }
    }
    else
    {
      return;
    }
    a(localArrayList);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    b(this.i);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.o = new com.xiaoenai.app.feature.photopicker.b.a();
    a();
    h();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.o = null;
    this.f.c();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photopicker\view\PhotoPickerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */