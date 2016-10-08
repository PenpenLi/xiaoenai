package com.xiaoenai.app.feature.photoalbum.view.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.xiaoenai.app.domain.PhotoAlbum;
import com.xiaoenai.app.feature.photoalbum.a.f;
import com.xiaoenai.app.feature.photoalbum.view.a.b.a;
import java.util.List;
import java.util.Map;
import java.util.Set;

class b
  implements View.OnClickListener
{
  b(a parama, Set paramSet, int paramInt, com.xiaoenai.app.feature.photoalbum.view.a.b paramb) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    paramView = (b.a)paramView.getTag();
    Map localMap = a.a(this.d).c();
    List localList = paramView.e.d();
    if (paramView.e.a() == localList.size())
    {
      i = 0;
      while (i < localList.size())
      {
        a.a(this.d).a(Integer.valueOf(paramView.e.b() + i));
        localMap.remove(((PhotoAlbum)localList.get(i)).getGroupId());
        i += 1;
      }
      paramView.d = false;
      this.a.remove(Integer.valueOf(this.b));
      this.d.c.setText(a.f.album_choose_enable);
      a.a(this.d, paramView.e, false, this.c);
      paramView.e.a(0);
      return;
    }
    paramView.d = true;
    this.a.add(Integer.valueOf(this.b));
    while (i < localList.size())
    {
      a.a(this.d).a(Integer.valueOf(paramView.e.b() + i), Integer.valueOf(((PhotoAlbum)localList.get(i)).getId().intValue()));
      localMap.put(((PhotoAlbum)localList.get(i)).getGroupId(), Integer.valueOf(-1));
      i += 1;
    }
    this.d.c.setText(a.f.album_choose_unable);
    a.a(this.d, paramView.e, true, this.c);
    paramView.e.a(localList.size());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\view\widget\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */