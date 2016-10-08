package com.xiaoenai.app.data.e.a.c;

import com.xiaoenai.app.data.b.b.a;
import com.xiaoenai.app.data.entity.mapper.AlbumEntityDataMapper;
import com.xiaoenai.app.domain.PhotoAlbum;
import java.util.List;

public class j
{
  private final a a;
  private final AlbumEntityDataMapper b;
  
  public j(a parama, AlbumEntityDataMapper paramAlbumEntityDataMapper)
  {
    this.a = parama;
    this.b = paramAlbumEntityDataMapper;
  }
  
  public List<PhotoAlbum> a()
  {
    return this.b.transformToModule(this.a.a());
  }
  
  public void a(String paramString)
  {
    paramString = paramString.split(",");
    this.a.b(this.b.transformToDB(paramString));
  }
  
  public void a(List<PhotoAlbum> paramList)
  {
    this.a.a(this.b.transformToDB(paramList));
  }
  
  public void b()
  {
    this.a.b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\e\a\c\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */