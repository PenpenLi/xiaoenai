package com.xiaoenai.app.feature.photoalbum.e;

import com.xiaoenai.app.domain.PhotoAlbum;
import com.xiaoenai.app.feature.photoalbum.view.activity.PhotoAlbumActivity;
import com.xiaoenai.app.utils.f.a;
import java.util.List;
import rx.k;

class h
  extends k<List<PhotoAlbum>>
{
  h(c paramc, String paramString, List paramList) {}
  
  public void a() {}
  
  public void a(Throwable paramThrowable)
  {
    a.a(true, paramThrowable, "doUploadAction {} {} ", new Object[] { this.a, this.b });
    if ((c.a(this.c) != null) && (!c.a(this.c).isFinishing())) {
      c.a(this.c).c();
    }
  }
  
  public void a(List<PhotoAlbum> paramList)
  {
    c.a(this.c).b(0);
    this.c.l();
    c.b(this.c, 0);
    this.c.a(paramList);
    this.b.clear();
    if ((c.a(this.c) != null) && (!c.a(this.c).isFinishing())) {
      c.a(this.c).a(true, 0);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\e\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */