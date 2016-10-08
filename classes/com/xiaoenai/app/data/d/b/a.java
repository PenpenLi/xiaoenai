package com.xiaoenai.app.data.d.b;

import android.content.Context;
import android.os.Handler;
import com.xiaoenai.app.data.d.j;
import com.xiaoenai.app.data.d.m;
import com.xiaoenai.app.data.entity.album.AlbumCapacityEntity;
import com.xiaoenai.app.data.entity.album.AlbumEntity;
import com.xiaoenai.app.data.entity.album.AlbumGroupEntity;
import com.xiaoenai.app.domain.internal.di.PerActivity;
import javax.inject.Inject;

@PerActivity
public class a
  extends com.xiaoenai.app.data.d.b
{
  private int g = -1;
  private int h = 0;
  
  @Inject
  public a(Context paramContext, j paramj, m paramm, com.xiaoenai.app.data.d.f paramf, Handler paramHandler)
  {
    super(paramContext, paramj, paramm, paramf, paramHandler);
  }
  
  public rx.a<AlbumEntity> a(String paramString1, String paramString2)
  {
    this.a = this.c.b("photo_vault/v1/timelines");
    return rx.a.a(new b(this, paramString1, paramString2));
  }
  
  public rx.a<AlbumCapacityEntity> b(String paramString1, String paramString2)
  {
    this.a = this.c.b("photo_vault/v1/del");
    return rx.a.a(new d(this, paramString1, paramString2));
  }
  
  public int c()
  {
    return this.g;
  }
  
  public rx.a<AlbumGroupEntity> c(String paramString1, String paramString2)
  {
    this.a = this.c.b("photo_vault/v1/add");
    com.xiaoenai.app.utils.f.a.c("addPhoto: {} ", new Object[] { paramString1 });
    return rx.a.a(new f(this, paramString1, paramString2));
  }
  
  public int d()
  {
    return this.h;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\d\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */