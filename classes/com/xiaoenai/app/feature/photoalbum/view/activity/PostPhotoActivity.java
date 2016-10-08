package com.xiaoenai.app.feature.photoalbum.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import com.xiaoenai.app.common.view.activity.TitleBarActivity;
import com.xiaoenai.app.common.view.widget.TitleBarView;
import com.xiaoenai.app.feature.photoalbum.a.d;
import com.xiaoenai.app.feature.photoalbum.a.e;
import com.xiaoenai.app.feature.photoalbum.a.f;
import com.xiaoenai.app.feature.photoalbum.d.a.a.a.a;
import com.xiaoenai.app.feature.photoalbum.preview.PhotoPreviewActivity;
import com.xiaoenai.app.feature.photopicker.view.PhotoPickerActivity;
import com.xiaoenai.app.ui.a.b;
import com.xiaoenai.app.ui.a.g;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.ui.a.k;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class PostPhotoActivity
  extends TitleBarActivity
{
  @Inject
  protected com.xiaoenai.app.feature.photoalbum.e.a e;
  private TextView f;
  private EditText g;
  private int h = 140;
  private GridView i;
  private b j;
  private com.xiaoenai.app.feature.photoalbum.view.a.a k;
  private int l = 0;
  private int m = this.h;
  private com.xiaoenai.app.b.a n;
  private com.xiaoenai.app.feature.photoalbum.d.a.a.y o;
  
  private void a()
  {
    this.f = ((TextView)findViewById(a.d.text_lenth));
    this.g = ((EditText)findViewById(a.d.et_describe));
    this.g.clearFocus();
    this.i = ((GridView)findViewById(a.d.postactivity_gridview));
    this.f.setText(String.valueOf(this.h));
    this.g.addTextChangedListener(new v(this));
    this.k = new com.xiaoenai.app.feature.photoalbum.view.a.a(this);
    this.i.setOnItemClickListener(new a());
    this.i.setAdapter(this.k);
    this.i.setScrollbarFadingEnabled(true);
  }
  
  private void b()
  {
    if ((this.g.getText().length() > 0) || (this.e.b().size() > 0))
    {
      c();
      return;
    }
    m_();
  }
  
  private void b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      h.c(this, a.f.album_too_long, 1500L);
      return;
    }
    h.c(this, a.f.album_image_too_many, 1500L);
  }
  
  private void c()
  {
    g localg = new g(this);
    localg.a(a.f.ok, new y(this));
    localg.b(a.f.cancel, new z(this));
    localg.setTitle(a.f.album_give_up_post);
    localg.d(k.i);
    localg.show();
  }
  
  private void g()
  {
    if (this.j == null)
    {
      this.j = new b(this);
      this.j.a(a.f.album_take_photo, 1, new aa(this));
      this.j.a(a.f.album_pick_from_photo, 1, new ab(this));
    }
    this.j.show();
  }
  
  private void h()
  {
    this.n.a(new ac(this));
  }
  
  private void i()
  {
    Intent localIntent = new Intent(this, PhotoPickerActivity.class);
    localIntent.putExtra("image_picker_mode", 0);
    localIntent.putExtra("max_selected_size", 20 - this.e.b().size());
    startActivityForResult(localIntent, 21);
  }
  
  protected int d()
  {
    return a.e.activity_post_photo;
  }
  
  protected void f()
  {
    super.f();
    this.b.setTitle(a.f.photo_describe);
    this.b.a(0, a.f.cancel);
    this.b.b(0, a.f.complete);
    this.b.setLeftButtonClickListener(new w(this));
    this.b.setRightButtonClickListener(new x(this));
  }
  
  protected void l()
  {
    super.l();
    this.o = com.xiaoenai.app.feature.photoalbum.d.a.a.a.c().a(A()).a(z()).a(new com.xiaoenai.app.feature.photoalbum.d.a.b.a()).a();
    this.o.a(this);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      ArrayList localArrayList;
      do
      {
        return;
        localArrayList = paramIntent.getStringArrayListExtra("selected_image_url");
        paramIntent = paramIntent.getIntArrayExtra("image_url_origin");
        paramIntent = this.e.a(localArrayList.size(), paramIntent);
        this.e.b(localArrayList, paramIntent);
        this.k.a(this.e.b());
      } while (localArrayList.size() <= 0);
      this.b.setRightButtonClickenable(true);
      return;
      this.n.a(paramInt1, paramInt2);
      return;
      paramIntent = paramIntent.getIntArrayExtra("delete_photo");
    } while ((paramIntent == null) || (paramIntent.length <= 0));
    if (paramIntent.length == this.e.b().size()) {
      this.b.setRightButtonClickenable(false);
    }
    this.e.a(paramIntent);
    this.k.a(this.e.b());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    f();
    a();
    Object localObject = getIntent();
    paramBundle = ((Intent)localObject).getStringArrayListExtra("selected_image_url");
    localObject = ((Intent)localObject).getIntArrayExtra("image_url_origin");
    localObject = this.e.a(paramBundle.size(), (int[])localObject);
    this.e.a(paramBundle, (List)localObject);
    this.k.a(this.e.b());
    this.n = new com.xiaoenai.app.b.a(this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      b();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public class a
    implements AdapterView.OnItemClickListener
  {
    public a() {}
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      if ((PostPhotoActivity.this.e.b().size() < 20) && (paramInt == PostPhotoActivity.this.e.b().size()))
      {
        PostPhotoActivity.g(PostPhotoActivity.this);
        return;
      }
      paramAdapterView = new Intent(PostPhotoActivity.this, PhotoPreviewActivity.class);
      paramView = PostPhotoActivity.this.e.b();
      paramAdapterView.putExtra("imageUrls", (String[])paramView.toArray(new String[paramView.size()]));
      paramAdapterView.putExtra("position", paramInt);
      paramAdapterView.putExtra(PhotoPreviewActivity.h, PhotoPreviewActivity.g);
      paramAdapterView.putExtra("show_origin", true);
      PostPhotoActivity.this.startActivityForResult(paramAdapterView, 0);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\view\activity\PostPhotoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */