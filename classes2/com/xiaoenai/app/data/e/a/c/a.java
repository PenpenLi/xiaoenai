package com.xiaoenai.app.data.e.a.c;

import com.xiaoenai.app.data.e.o;
import com.xiaoenai.app.data.entity.mapper.AlbumEntityDataMapper;
import com.xiaoenai.app.domain.PhotoAlbum;
import java.lang.ref.WeakReference;
import java.util.List;

public class a
  implements k
{
  private final com.xiaoenai.app.data.d.b.a a;
  private final com.xiaoenai.app.data.d.d.h b;
  private final AlbumEntityDataMapper c;
  private final o d;
  
  public a(com.xiaoenai.app.data.d.b.a parama, com.xiaoenai.app.data.d.d.h paramh, AlbumEntityDataMapper paramAlbumEntityDataMapper, o paramo)
  {
    this.a = parama;
    this.b = paramh;
    this.c = paramAlbumEntityDataMapper;
    this.d = paramo;
  }
  
  public rx.a<List<PhotoAlbum>> a(int paramInt1, int paramInt2)
  {
    rx.a locala = rx.a.a(b.a(this, paramInt1, paramInt2));
    AlbumEntityDataMapper localAlbumEntityDataMapper = this.c;
    localAlbumEntityDataMapper.getClass();
    return locala.b(c.a(localAlbumEntityDataMapper));
  }
  
  public rx.a<List<PhotoAlbum>> a(String paramString1, String paramString2)
  {
    return rx.a.a(d.a(this, paramString1, paramString2));
  }
  
  public void a(List<String> paramList, WeakReference<rx.k<com.xiaoenai.app.domain.c>> paramWeakReference)
  {
    h localh = new h(this);
    this.b.a("api_type_image", paramList, paramWeakReference, localh);
    this.b.b();
  }
  
  public boolean a()
  {
    return this.b.a() >= 0;
  }
  
  public int b()
  {
    return this.a.c();
  }
  
  public rx.a<Integer> b(String paramString1, String paramString2)
  {
    paramString1 = this.a.b(paramString1, paramString2);
    paramString2 = this.c;
    paramString2.getClass();
    return paramString1.b(e.a(paramString2));
  }
  
  public int c()
  {
    return this.a.d();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\e\a\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */