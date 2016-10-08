package com.xiaoenai.app.data.e.a.c;

import com.google.gson.j;
import com.xiaoenai.app.data.d.d.h.a;
import com.xiaoenai.app.data.e.o;
import com.xiaoenai.app.data.entity.album.CompressPhoto;
import com.xiaoenai.app.data.entity.album.UploadData;
import com.xiaoenai.app.domain.c;
import java.util.List;

class h
  implements h.a
{
  h(a parama) {}
  
  public void a(c paramc)
  {
    if (paramc.c() != null)
    {
      Object localObject = a.a(this.a).b("uploaddata", "");
      j localj = new j();
      localObject = (UploadData)localj.a((String)localObject, UploadData.class);
      int i = Integer.valueOf(((UploadData)localObject).getUploadedCount()).intValue();
      List localList = (List)localj.a(((UploadData)localObject).getUploadJson(), new i(this).getType());
      ((CompressPhoto)localList.get(i)).setUrl(paramc.c().b());
      ((CompressPhoto)localList.get(i)).setBaseUrl(paramc.c().a());
      String str = localj.a(localList);
      if (((CompressPhoto)localList.get(i)).isOrigin()) {
        com.xiaoenai.app.utils.e.b.b(paramc.c().a() + paramc.c().b(), ((CompressPhoto)localList.get(i)).getOriginPath());
      }
      ((UploadData)localObject).setUploadJson(str);
      ((UploadData)localObject).setUploadedCount(String.valueOf(i + 1));
      paramc = localj.a(localObject);
      a.a(this.a).a("uploaddata", paramc);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\e\a\c\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */