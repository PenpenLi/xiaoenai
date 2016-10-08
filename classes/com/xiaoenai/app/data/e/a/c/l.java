package com.xiaoenai.app.data.e.a.c;

import android.content.Context;
import com.xiaoenai.app.data.d.d.h;
import com.xiaoenai.app.data.e.o;
import com.xiaoenai.app.data.entity.mapper.AlbumEntityDataMapper;
import com.xiaoenai.app.domain.internal.di.PerActivity;
import javax.inject.Inject;

@PerActivity
public class l
{
  private final Context a;
  private final com.xiaoenai.app.data.d.b.a b;
  private final h c;
  private final AlbumEntityDataMapper d;
  private final com.xiaoenai.app.data.b.b.a e;
  private final o f;
  
  @Inject
  public l(Context paramContext, com.xiaoenai.app.data.d.b.a parama, h paramh, com.xiaoenai.app.data.b.b.a parama1, AlbumEntityDataMapper paramAlbumEntityDataMapper, o paramo)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Constructor parameters cannot be null!!!");
    }
    this.a = paramContext;
    this.b = parama;
    this.c = paramh;
    this.d = paramAlbumEntityDataMapper;
    this.e = parama1;
    this.f = paramo;
  }
  
  public k a()
  {
    return new a(this.b, this.c, this.d, this.f);
  }
  
  public j b()
  {
    return new j(this.e, this.d);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\e\a\c\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */