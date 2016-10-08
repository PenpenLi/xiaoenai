package com.xiaoenai.app.classes.street.a;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.xiaoenai.app.classes.home.model.HomeDiscoverItem;
import com.xiaoenai.app.classes.street.widget.StreetSceneView;
import com.xiaoenai.app.utils.f.a;
import java.util.List;

public class f
  extends PagerAdapter
{
  private Context a;
  private List<HomeDiscoverItem> b;
  private SparseArray<View> c;
  
  public f(Context paramContext)
  {
    this.a = paramContext;
    this.c = new SparseArray();
  }
  
  public void a()
  {
    if (this.c != null)
    {
      this.c.clear();
      this.c = null;
    }
  }
  
  public void a(List<HomeDiscoverItem> paramList)
  {
    this.b = paramList;
    notifyDataSetChanged();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
    a.c("======== destroyItem =====position: {}", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public int getCount()
  {
    if (this.b != null) {
      return this.b.size();
    }
    return 0;
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    if ((this.b != null) && (this.b.size() > 0)) {
      return ((HomeDiscoverItem)this.b.get(paramInt)).getTitle();
    }
    return null;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    a.c("====== instantiateItem =======position: {}", new Object[] { Integer.valueOf(paramInt) });
    StreetSceneView localStreetSceneView = (StreetSceneView)this.c.get(paramInt);
    if (localStreetSceneView == null)
    {
      localStreetSceneView = new StreetSceneView(this.a);
      this.c.put(paramInt, localStreetSceneView);
    }
    for (;;)
    {
      localStreetSceneView.setData((HomeDiscoverItem)this.b.get(paramInt));
      paramViewGroup.addView(localStreetSceneView);
      return localStreetSceneView;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */