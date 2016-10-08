package com.xiaoenai.app.feature.photoalbum.view.widget;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.xiaoenai.app.domain.PhotoAlbum;
import com.xiaoenai.app.feature.photoalbum.a.f;
import com.xiaoenai.app.feature.photoalbum.e.c;
import com.xiaoenai.app.feature.photoalbum.view.a.e.a;
import java.util.List;
import java.util.Map;

class e
  implements View.OnClickListener
{
  e(d paramd, e.a parama, com.xiaoenai.app.feature.photoalbum.view.a.e parame) {}
  
  public void onClick(View paramView)
  {
    int j = 0;
    Map localMap = d.a(this.c).c();
    List localList = this.a.d.d();
    Integer localInteger = (Integer)localMap.get(this.a.d.a());
    int i = j;
    if (localInteger != null)
    {
      i = j;
      if (-1 == localInteger.intValue())
      {
        i = 0;
        while (i < localList.size())
        {
          d.a(this.c).a(Integer.valueOf(this.a.d.e() + i));
          i += 1;
        }
        localMap.remove(this.a.d.a());
        d.b(this.c).setText(a.f.album_choose_enable);
        d.a(this.c, this.a.d, false, this.b);
        return;
      }
    }
    while (i < localList.size())
    {
      d.a(this.c).a(Integer.valueOf(this.a.d.e() + i), Integer.valueOf(((PhotoAlbum)localList.get(i)).getId().intValue()));
      i += 1;
    }
    localMap.put(this.a.d.a(), Integer.valueOf(-1));
    ((TextView)paramView).setText(d.b(this.c).getResources().getString(a.f.album_choose_unable));
    d.a(this.c, this.a.d, true, this.b);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\view\widget\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */