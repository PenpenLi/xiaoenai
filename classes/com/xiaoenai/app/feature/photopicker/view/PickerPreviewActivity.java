package com.xiaoenai.app.feature.photopicker.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.LinearLayout;
import com.xiaoenai.app.common.view.widget.TitleBarView;
import com.xiaoenai.app.feature.photopicker.a.b;
import com.xiaoenai.app.feature.photopicker.a.c;
import com.xiaoenai.app.feature.photopicker.a.d;
import com.xiaoenai.app.feature.photopicker.a.e;
import com.xiaoenai.app.feature.photopicker.a.e;
import com.xiaoenai.app.feature.photopicker.a.f;
import com.xiaoenai.app.feature.photopreview.view.ImageViewPagerWidget;
import com.xiaoenai.app.feature.photopreview.view.PreviewActivity;
import com.xiaoenai.app.utils.d.i;
import com.xiaoenai.app.utils.f.a;
import java.util.ArrayList;
import java.util.List;

public class PickerPreviewActivity
  extends PreviewActivity
{
  private boolean e = false;
  private List<f> f;
  private int g = 0;
  private int h = 0;
  private ArrayList<String> i;
  private List<Integer> j = new ArrayList();
  
  private void a(boolean paramBoolean)
  {
    a.c("{}", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      int k = 0;
      while (k < this.f.size())
      {
        if (((f)this.f.get(k)).a())
        {
          int n = this.i.indexOf(((f)this.f.get(k)).b());
          List localList = this.j;
          int m = n;
          if (n == -1) {
            m = this.i.size() - 1;
          }
          localList.add(Integer.valueOf(m));
        }
        k += 1;
      }
      if (this.h >= this.g) {
        return;
      }
      a(true, true);
    }
    for (;;)
    {
      ((f)this.f.get(this.x)).a(paramBoolean);
      return;
      this.j.clear();
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    a.c("{} {}", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if ((paramBoolean1) && (!((f)this.f.get(this.x)).a()))
    {
      this.h += 1;
      this.i.add(((f)this.f.get(this.x)).b());
      this.n.setText(b(this.h));
      if (!paramBoolean1) {
        break label204;
      }
      this.b.b(a.b.album_item_selected, 0);
    }
    for (;;)
    {
      ((f)this.f.get(this.x)).b(paramBoolean1);
      ((f)this.f.get(this.x)).a(this.v);
      return;
      if (paramBoolean2) {
        break;
      }
      this.h -= 1;
      this.i.remove(((f)this.f.get(this.x)).b());
      break;
      label204:
      this.b.b(a.b.album_item_unselected, 0);
    }
  }
  
  private String b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getString(a.e.photopicker_image_upload));
    if (paramInt > 0)
    {
      localStringBuilder.append("(");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(")");
    }
    return localStringBuilder.toString();
  }
  
  private void i()
  {
    this.o = ((ImageViewPagerWidget)findViewById(a.c.image_pager));
    c();
    a(new o(this));
  }
  
  protected void c()
  {
    super.c();
    this.n.setText(b(this.h));
    this.o.addOnPageChangeListener(new r(this));
    this.n.setOnClickListener(new s(this));
  }
  
  public int d()
  {
    return a.d.activity_picker_preview;
  }
  
  protected void f()
  {
    super.f();
    this.b.setRightButtonClickListener(new p(this));
    this.b.setLeftButtonClickListener(new q(this));
  }
  
  public void g()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("selected_image_url", this.i);
    int[] arrayOfInt = new int[this.j.size()];
    int k = 0;
    while (k < this.j.size())
    {
      arrayOfInt[k] = ((Integer)this.j.get(k)).intValue();
      k += 1;
    }
    localIntent.putExtra("image_url_origin", arrayOfInt);
    localIntent.putExtra("action_back", true);
    setResult(-1, localIntent);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    super.onCreate(paramBundle);
    this.t = getIntent().getStringArrayExtra("imageUrls");
    this.g = getIntent().getIntExtra("max_selected_size", 20);
    this.h = getIntent().getIntExtra("selected_count", 0);
    this.i = getIntent().getStringArrayListExtra("selected_image_url");
    if (this.i == null) {
      this.i = new ArrayList();
    }
    paramBundle = getIntent().getIntArrayExtra("image_url_origin");
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      int k = 0;
      while (k < paramBundle.length)
      {
        this.j.add(Integer.valueOf(paramBundle[k]));
        k += 1;
      }
    }
    this.f = e.a(this.t, this.i);
    i();
    this.e = ((f)this.f.get(this.x)).a();
    if (this.e) {
      this.b.b(a.b.album_item_selected, 0);
    }
    for (;;)
    {
      if (!this.j.isEmpty()) {
        bool = true;
      }
      this.v = bool;
      this.k.setSelected(this.v);
      b(i.a(this.t[this.x]));
      return;
      this.b.b(a.b.album_item_unselected, 0);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      g();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photopicker\view\PickerPreviewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */