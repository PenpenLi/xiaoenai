package com.xiaoenai.app.data.e;

import com.xiaoenai.app.domain.PhotoAlbum;
import com.xiaoenai.app.domain.c;
import com.xiaoenai.app.domain.e.d;
import com.xiaoenai.app.domain.internal.di.PerActivity;
import java.lang.ref.WeakReference;
import java.util.List;
import javax.inject.Inject;

@PerActivity
public class g
  implements d
{
  private final com.xiaoenai.app.data.e.a.c.l a;
  private int b = 0;
  
  @Inject
  public g(com.xiaoenai.app.data.e.a.c.l paraml)
  {
    this.a = paraml;
  }
  
  public rx.a<List<PhotoAlbum>> a(int paramInt1, int paramInt2)
  {
    return rx.a.a(h.a(this, paramInt1, paramInt2));
  }
  
  public rx.a<Integer> a(String paramString1, String paramString2)
  {
    return rx.a.a(new j(this, paramString1, paramString2));
  }
  
  public void a(List<String> paramList, WeakReference<rx.k<c>> paramWeakReference)
  {
    this.a.a().a(paramList, paramWeakReference);
  }
  
  public boolean a()
  {
    return ((com.xiaoenai.app.data.e.a.c.a)this.a.a()).a();
  }
  
  public int b()
  {
    int j = this.a.a().b();
    int i = j;
    if (-1 == j) {
      i = this.b;
    }
    return i;
  }
  
  public rx.a<List<PhotoAlbum>> b(String paramString1, String paramString2)
  {
    return rx.a.a(new l(this, paramString1, paramString2));
  }
  
  public int c()
  {
    return this.a.a().c();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\e\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */