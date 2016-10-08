package com.xiaoenai.app.classes.common.image.imagePreview;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.xiaoenai.app.model.album.Photo;
import com.xiaoenai.app.model.album.PhotoImageList;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.ui.photoview.PhotoView;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.widget.TitleBarView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class a
  extends m
{
  private ArrayList<Photo> a = (ArrayList)PhotoImageList.getInstance().getPhotoList().clone();
  private TextView b;
  private ImageButton c;
  private ImageButton d;
  private Button e;
  private TitleBarView f;
  private ViewPager g;
  private SparseArray<View> h = new SparseArray();
  private boolean i = false;
  
  public a(Activity paramActivity, TextView paramTextView, ImageButton paramImageButton1, ImageButton paramImageButton2, Button paramButton, TitleBarView paramTitleBarView, ViewPager paramViewPager, int paramInt)
  {
    super(paramActivity, paramViewPager);
    this.b = paramTextView;
    this.c = paramImageButton1;
    this.d = paramImageButton2;
    this.e = paramButton;
    this.f = paramTitleBarView;
    this.g = paramViewPager;
    d(paramInt);
    c();
    c(paramInt);
    b(paramInt);
  }
  
  private void a(ArrayList<Integer> paramArrayList, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localStringBuilder.append((Integer)paramArrayList.next()).append(",");
    }
    paramArrayList = localStringBuilder.toString().substring(0, localStringBuilder.length() - 1);
    new com.xiaoenai.app.net.b(new j(this, a(), paramInt2, paramInt1)).c(paramArrayList);
  }
  
  private void b(int paramInt)
  {
    if ((this.a != null) && (this.a.size() > paramInt))
    {
      Photo localPhoto = (Photo)this.a.get(paramInt);
      this.b.setText(ak.j(localPhoto.getCreateAt()));
    }
  }
  
  private void b(String paramString)
  {
    if (!as.c())
    {
      com.xiaoenai.app.ui.a.h.c(a(), 2131101068, 1500L);
      return;
    }
    as.c(paramString);
  }
  
  private void c()
  {
    this.g.setOnPageChangeListener(new b(this));
  }
  
  private void c(int paramInt)
  {
    if ((this.a != null) && (this.a.size() > paramInt))
    {
      Photo localPhoto = (Photo)this.a.get(paramInt);
      this.e.setOnClickListener(new c(this, localPhoto, paramInt));
    }
  }
  
  private void d(int paramInt)
  {
    if ((this.a != null) && (this.a.size() > paramInt))
    {
      Photo localPhoto = (Photo)this.a.get(paramInt);
      File localFile = com.xiaoenai.app.utils.e.b.b(localPhoto.getUrl());
      if ((localPhoto.isOriginal() == 1) && ((localFile == null) || (!localFile.exists())))
      {
        this.e.setVisibility(0);
        this.e.setText(a().getString(2131100080));
        a(this.e);
        return;
      }
    }
    this.e.setVisibility(8);
  }
  
  private void e(int paramInt)
  {
    com.xiaoenai.app.ui.a.g localg = new com.xiaoenai.app.ui.a.g(a());
    localg.a(2131099712);
    localg.d(k.j);
    localg.a(2131100898, new h(this, paramInt));
    localg.b(2131099973, new i(this));
    localg.show();
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    b().remove(Integer.valueOf(paramInt));
    paramObject = (View)paramObject;
    ((ViewPager)paramView).removeView((View)paramObject);
    this.h.remove(paramInt);
  }
  
  public int getCount()
  {
    if ((this.a != null) && (this.a.size() > 0)) {
      return this.a.size();
    }
    return 0;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    View localView = a().getLayoutInflater().inflate(2130903149, null);
    ((ViewPager)paramView).addView(localView);
    PhotoView localPhotoView = (PhotoView)localView.findViewById(2131558985);
    ImageButton localImageButton = (ImageButton)localView.findViewById(2131558986);
    Button localButton = (Button)localView.findViewById(2131558982);
    ProgressView localProgressView = (ProgressView)localView.findViewById(2131558987);
    Photo localPhoto = (Photo)this.a.get(paramInt);
    localButton.setVisibility(8);
    localImageButton.setVisibility(8);
    this.c.setOnClickListener(new d(this));
    this.d.setOnClickListener(new e(this, paramView));
    localPhotoView.setOnClickListener(new f(this));
    paramView = com.xiaoenai.app.utils.e.b.b(localPhoto.getUrl());
    if ((paramView != null) && (paramView.exists()))
    {
      com.xiaoenai.app.utils.e.b.a(localPhotoView, paramView.getAbsolutePath(), new g(this, localProgressView));
      com.xiaoenai.app.utils.f.a.c("url={}", new Object[] { localPhoto.getUrl() });
      this.h.put(paramInt, localView);
      b().put(Integer.valueOf(paramInt), localPhotoView);
      return localView;
    }
    int j = localPhoto.getWidth();
    int k = localPhoto.getHeight();
    if (localPhoto.isOriginal() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      a(j, k, bool, localPhoto.getUrl(), localPhotoView, localProgressView, a());
      break;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */