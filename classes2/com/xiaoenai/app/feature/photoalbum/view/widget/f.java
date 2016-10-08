package com.xiaoenai.app.feature.photoalbum.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaoenai.app.domain.PhotoAlbum;
import com.xiaoenai.app.feature.photoalbum.a.c;
import com.xiaoenai.app.feature.photoalbum.a.f;
import com.xiaoenai.app.feature.photoalbum.e.c;
import com.xiaoenai.app.feature.photoalbum.view.activity.PhotoAlbumActivity;
import java.util.List;
import java.util.Map;

class f
  implements View.OnClickListener
{
  f(d.b paramb, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (d.c(this.b.a).g())
    {
      Map localMap = d.a(this.b.a).c();
      long l = this.b.a(this.a).getGroupId().longValue();
      Object localObject = (Integer)localMap.get(Long.valueOf(l));
      d.a locala = (d.a)paramView.getTag();
      boolean bool;
      label101:
      label167:
      Resources localResources;
      if (!d.a.a(locala))
      {
        bool = true;
        d.a.a(locala, bool);
        if (localObject != null) {
          break label290;
        }
        paramView = Integer.valueOf(0);
        if (!d.a.a(locala)) {
          break label319;
        }
        d.a(this.b.a).a(Integer.valueOf(d.b.b(this.b) + this.a), Integer.valueOf(this.b.a(this.a).getId().intValue()));
        paramView = Integer.valueOf(paramView.intValue() + 1);
        this.b.a(this.a).setIsSelected(Boolean.valueOf(d.a.a(locala)));
        localObject = d.a.b(locala);
        localResources = d.a.b(locala).getContext().getResources();
        if (!d.a.a(locala)) {
          break label379;
        }
      }
      label290:
      label319:
      label379:
      for (int i = a.c.album_items_selected;; i = a.c.album_items_unselected)
      {
        ((ImageView)localObject).setImageDrawable(localResources.getDrawable(i));
        if (d.b.a(this.b).size() != paramView.intValue()) {
          break label387;
        }
        localMap.put(Long.valueOf(l), Integer.valueOf(-1));
        d.b(this.b.a).setText(a.f.album_choose_unable);
        return;
        bool = false;
        break;
        paramView = (View)localObject;
        if (-1 != ((Integer)localObject).intValue()) {
          break label101;
        }
        paramView = Integer.valueOf(d.b.a(this.b).size());
        break label101;
        d.a(this.b.a).a(Integer.valueOf(d.b.b(this.b) + this.a));
        if (paramView == null)
        {
          localMap.remove(Long.valueOf(l));
          break label167;
        }
        paramView = Integer.valueOf(paramView.intValue() - 1);
        break label167;
      }
      label387:
      localMap.put(Long.valueOf(l), paramView);
      d.b(this.b.a).setText(a.f.album_choose_enable);
      return;
    }
    d.a(this.b.a, d.b.a(this.b), this.a + d.b.b(this.b));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\view\widget\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */