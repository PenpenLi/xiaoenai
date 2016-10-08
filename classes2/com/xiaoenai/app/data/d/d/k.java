package com.xiaoenai.app.data.d.d;

import com.xiaoenai.app.data.entity.ImageResultEntity;
import com.xiaoenai.app.data.entity.mapper.ImageResultDataMapper;
import com.xiaoenai.app.utils.f.a;
import java.lang.ref.WeakReference;
import java.util.List;

class k
  implements h.b
{
  k(h paramh) {}
  
  public void a(ImageResultEntity paramImageResultEntity)
  {
    rx.k localk;
    if (paramImageResultEntity != null) {
      if ((paramImageResultEntity.getProgress() >= 100) && (paramImageResultEntity.getImageEntity() != null))
      {
        if (h.a(this.a) != null) {
          h.a(this.a).a(h.b(this.a).transform(paramImageResultEntity));
        }
        if (h.c(this.a) != h.d(this.a).size() - 1) {
          break label151;
        }
        localk = (rx.k)h.e(this.a).get();
        if (localk != null) {
          localk.a();
        }
        h.a(this.a, -1);
        h.a(this.a, null);
      }
    }
    for (;;)
    {
      localk = (rx.k)h.e(this.a).get();
      if (localk != null) {
        localk.a(h.b(this.a).transform(paramImageResultEntity));
      }
      return;
      label151:
      if (h.c(this.a) < h.d(this.a).size() - 1)
      {
        h.f(this.a);
        h.a(this.a, h.g(this.a), h.c(this.a));
      }
    }
  }
  
  public void a(Throwable paramThrowable)
  {
    rx.k localk = (rx.k)h.e(this.a).get();
    if (localk != null) {
      localk.a(paramThrowable);
    }
    h.a(this.a, null);
    h.a(this.a, -1);
    a.a(paramThrowable.getMessage(), new Object[0]);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\d\d\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */