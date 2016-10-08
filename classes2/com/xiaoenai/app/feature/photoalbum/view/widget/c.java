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
import com.xiaoenai.app.feature.photoalbum.view.a.b;
import com.xiaoenai.app.feature.photoalbum.view.activity.PhotoAlbumActivity;
import java.util.List;
import java.util.Map;

class c
  implements View.OnClickListener
{
  c(a.b paramb, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (a.b.a(this.b).g())
    {
      Object localObject1 = this.b.a(this.a);
      boolean bool;
      label125:
      long l;
      Object localObject2;
      int i;
      if (!this.b.a(this.a).getIsSelected().booleanValue())
      {
        bool = true;
        ((PhotoAlbum)localObject1).setIsSelected(Boolean.valueOf(bool));
        if (!this.b.a(this.a).getIsSelected().booleanValue()) {
          break label390;
        }
        a.a(this.b.a).a(Integer.valueOf(a.b.b(this.b) + this.a), Integer.valueOf(this.b.a(this.a).getId().intValue()));
        localObject1 = a.a(this.b.a).c();
        l = this.b.a(this.a).getGroupId().longValue();
        localObject2 = (Integer)((Map)localObject1).get(Long.valueOf(l));
        if (localObject2 != null) {
          break label421;
        }
        i = 1;
        label180:
        paramView = (a.a)paramView.getTag();
        if (paramView.b) {
          break label432;
        }
        bool = true;
        label198:
        paramView.b = bool;
        this.b.a(this.a).setIsSelected(Boolean.valueOf(paramView.b));
        localObject2 = paramView.a;
        Resources localResources = paramView.a.getContext().getResources();
        if (!paramView.b) {
          break label438;
        }
        j = a.c.album_items_selected;
        label254:
        ((ImageView)localObject2).setImageDrawable(localResources.getDrawable(j));
        localObject2 = a.b.c(this.b);
        if (!paramView.b) {
          break label446;
        }
      }
      label390:
      label421:
      label432:
      label438:
      label446:
      for (int j = a.b.c(this.b).a() + 1;; j = a.b.c(this.b).a() - 1)
      {
        ((com.xiaoenai.app.feature.photoalbum.b.c)localObject2).a(j);
        if (a.b.c(this.b).d().size() != a.b.c(this.b).a()) {
          break label463;
        }
        ((Map)localObject1).put(Long.valueOf(l), Integer.valueOf(-1));
        a.b.d(this.b).setText(a.f.album_choose_unable);
        a.b.e(this.b).a(a.b(this.b.a) - 1).d = true;
        return;
        bool = false;
        break;
        a.a(this.b.a).a(Integer.valueOf(a.b.b(this.b) + this.a));
        break label125;
        i = ((Integer)localObject2).intValue() + 1;
        break label180;
        bool = false;
        break label198;
        j = a.c.album_items_unselected;
        break label254;
      }
      label463:
      ((Map)localObject1).put(Long.valueOf(l), Integer.valueOf(i));
      a.b.d(this.b).setText(a.f.album_choose_enable);
      a.b.e(this.b).a(a.b(this.b.a) - 1).d = false;
      return;
    }
    a.a(this.b.a, a.b.c(this.b).d(), this.a + a.b.b(this.b));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\view\widget\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */