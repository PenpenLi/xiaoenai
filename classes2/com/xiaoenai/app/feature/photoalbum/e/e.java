package com.xiaoenai.app.feature.photoalbum.e;

import com.xiaoenai.app.feature.photoalbum.a.f;
import com.xiaoenai.app.feature.photoalbum.view.activity.PhotoAlbumActivity;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.f.a;
import java.util.Map;
import rx.k;

class e
  extends k<Integer>
{
  e(c paramc, String paramString1, String paramString2) {}
  
  public void a() {}
  
  public void a(Integer paramInteger)
  {
    this.c.a = paramInteger.intValue();
    c.b(this.c).clear();
    c.c(this.c).clear();
    c.d(this.c);
    c.a(this.c).b(-1);
    c.a(this.c).a("normal");
    h.a(c.a(this.c), a.f.delete_done, 1000L);
  }
  
  public void a(Throwable paramThrowable)
  {
    a.a(true, paramThrowable, "delPhoto {} {} ", new Object[] { this.a, this.b });
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\e\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */