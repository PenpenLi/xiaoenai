package com.xiaoenai.app.feature.photoalbum.e;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.xiaoenai.app.domain.PhotoAlbum;
import com.xiaoenai.app.feature.photoalbum.view.activity.PhotoAlbumActivity;
import com.xiaoenai.app.utils.f.a;
import java.util.ArrayList;
import java.util.List;
import rx.k;

class d
  extends k<List<PhotoAlbum>>
{
  d(c paramc, RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  
  public void a() {}
  
  public void a(Throwable paramThrowable)
  {
    a.a(true, paramThrowable, "getData {} {} ", new Object[] { Integer.valueOf(this.b), Integer.valueOf(this.c) });
    c.a(this.d, false);
    c.a(this.d, new ArrayList());
    if ((c.a(this.d) != null) && (!c.a(this.d).isFinishing()) && (this.a != null) && (this.a.getTag() != null)) {
      ((View)this.a.getTag()).setVisibility(4);
    }
  }
  
  public void a(List<PhotoAlbum> paramList)
  {
    c.a(this.d, false);
    c.a(this.d, paramList);
    this.d.a = this.d.c.b();
    c.a(this.d, this.d.c.c());
    if ((c.a(this.d) != null) && (!c.a(this.d).isFinishing()))
    {
      if ((c.a(this.d) != null) && (!c.a(this.d).isFinishing()) && (this.a != null) && (this.a.getTag() != null)) {
        ((View)this.a.getTag()).setVisibility(4);
      }
      if ((this.a != null) && (this.b != 0)) {
        this.a.smoothScrollBy(0, 80);
      }
    }
  }
  
  public void b()
  {
    super.b();
    if ((c.a(this.d) != null) && (!c.a(this.d).isFinishing()) && (this.a != null) && (this.a.getTag() != null)) {
      ((View)this.a.getTag()).setVisibility(0);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */