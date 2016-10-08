package com.xiaoenai.app.data.b.b.a;

import a.a.a.g;
import com.xiaoenai.app.data.b.c;
import com.xiaoenai.app.database.b;
import com.xiaoenai.app.database.bean.AlbumData;
import com.xiaoenai.app.database.bean.AlbumDataDao.Properties;
import com.xiaoenai.app.domain.internal.di.PerActivity;
import java.util.List;
import javax.inject.Inject;

@PerActivity
public class a
  implements com.xiaoenai.app.data.b.b.a
{
  private final c a;
  
  @Inject
  public a(com.xiaoenai.app.data.b.a parama)
  {
    this.a = new c(parama);
  }
  
  public List<AlbumData> a()
  {
    return this.a.a(AlbumData.class).a(AlbumData.class, new g[] { AlbumDataDao.Properties.CreatedTs });
  }
  
  public void a(List<AlbumData> paramList)
  {
    this.a.a(AlbumData.class).a(paramList);
  }
  
  public void b()
  {
    this.a.a(AlbumData.class).a(AlbumData.class);
  }
  
  public void b(List<AlbumData> paramList)
  {
    this.a.a(AlbumData.class).b(paramList);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\b\b\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */