package com.xiaoenai.app.feature.photoalbum.view.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.xiaoenai.app.feature.photoalbum.a.c;
import com.xiaoenai.app.utils.d.t;
import com.xiaoenai.app.utils.e.b;
import java.util.ArrayList;
import java.util.List;

public class a
  extends BaseAdapter
{
  private List<String> a = new ArrayList();
  private Context b;
  
  public a(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private AbsListView.LayoutParams a()
  {
    int i = (t.b(this.b) - (t.a(this.b, 16.0F) * 2 + t.a(this.b, 12.0F) * 3)) / 4;
    return new AbsListView.LayoutParams(i, i);
  }
  
  public String a(int paramInt)
  {
    if ((this.a == null) || (this.a.size() == 0)) {
      return null;
    }
    return (String)this.a.get(paramInt);
  }
  
  public void a(List<String> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    int i = 20;
    if ((this.a == null) || (this.a.size() == 0)) {
      i = 1;
    }
    while (this.a.size() >= 20) {
      return i;
    }
    return this.a.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      paramView = new ImageView(this.b);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.setLayoutParams(a());
      localView = paramView;
      localObject = paramView;
      if ((paramInt != 0) || (paramViewGroup.getChildCount() == 0))
      {
        ((ImageView)localObject).setImageBitmap(null);
        if ((this.a.size() >= 20) || (paramInt != this.a.size())) {
          break label130;
        }
        ((ImageView)localObject).setImageResource(a.c.album_add_image);
      }
    }
    for (;;)
    {
      com.xiaoenai.app.utils.f.a.c("getView {} {} ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramViewGroup.getChildCount()) });
      return localView;
      localObject = (ImageView)paramView;
      localView = paramView;
      break;
      label130:
      b.a((ImageView)localObject, a(paramInt));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\view\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */