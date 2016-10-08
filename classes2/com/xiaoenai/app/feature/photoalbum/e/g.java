package com.xiaoenai.app.feature.photoalbum.e;

import com.xiaoenai.app.domain.PhotoAlbum;
import com.xiaoenai.app.domain.e.d;
import com.xiaoenai.app.utils.f.a;
import java.util.List;
import rx.k;

class g
  extends k<List<PhotoAlbum>>
{
  g(f paramf, k paramk) {}
  
  public void a()
  {
    this.a.a();
  }
  
  public void a(Throwable paramThrowable)
  {
    a.a(true, paramThrowable, "addPhoto {} {} ", new Object[] { this.b.a, this.b.b });
    this.a.a(paramThrowable);
  }
  
  public void a(List<PhotoAlbum> paramList)
  {
    this.b.c.a = this.b.c.c.b();
    this.a.a(paramList);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\e\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */