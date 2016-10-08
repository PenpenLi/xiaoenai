package com.xiaoenai.app.feature.photopreview.view;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.xiaoenai.app.feature.photopreview.a.a;
import com.xiaoenai.app.feature.photopreview.a.b;
import com.xiaoenai.app.feature.photopreview.view.impl.PreviewItemView;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.ui.photoview.PhotoView;
import java.util.HashMap;
import java.util.List;

public class e
  extends PagerAdapter
{
  private Activity a;
  private HashMap<Integer, PhotoView> b = new HashMap();
  private com.xiaoenai.app.feature.photopreview.c.a c;
  private a d;
  
  public e(Activity paramActivity, List<com.xiaoenai.app.feature.photopreview.b.a> paramList)
  {
    this.a = paramActivity;
    this.c = new com.xiaoenai.app.feature.photopreview.c.a.a(paramList);
  }
  
  public Activity a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    Object localObject = (View)this.b.get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      localObject = (PhotoView)((View)localObject).findViewById(a.a.imageViewPagerImage);
      if (localObject != null) {
        ((PhotoView)localObject).a(((PhotoView)localObject).getMinimumScale(), false);
      }
    }
  }
  
  public void a(a parama)
  {
    this.d = parama;
  }
  
  public ImageView b(int paramInt)
  {
    View localView = (View)this.b.get(Integer.valueOf(paramInt));
    if (localView != null) {
      return (ImageView)localView.findViewById(a.a.imageViewPagerImage);
    }
    return null;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    this.b.remove(Integer.valueOf(paramInt));
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return this.c.a();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    PreviewItemView localPreviewItemView = (PreviewItemView)a().getLayoutInflater().inflate(a.b.image_viewpager_item, null);
    paramViewGroup.addView(localPreviewItemView);
    localPreviewItemView.a = ((PhotoView)localPreviewItemView.findViewById(a.a.imageViewPagerImage));
    localPreviewItemView.b = ((ImageButton)localPreviewItemView.findViewById(a.a.image_save_to_album));
    localPreviewItemView.c = ((Button)localPreviewItemView.findViewById(a.a.image_get_origin_btn));
    localPreviewItemView.d = ((ProgressView)localPreviewItemView.findViewById(a.a.imageViewPagerProgressView));
    localPreviewItemView.c.setVisibility(8);
    localPreviewItemView.b.setVisibility(8);
    this.c.a(localPreviewItemView, paramInt);
    localPreviewItemView.a.setOnClickListener(new f(this));
    localPreviewItemView.a.setOnLongClickListener(new g(this, paramInt));
    this.b.put(Integer.valueOf(paramInt), localPreviewItemView.a);
    return localPreviewItemView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
    
    public abstract void b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photopreview\view\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */