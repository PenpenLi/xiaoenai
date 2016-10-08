package com.xiaoenai.app.data.d.d;

import android.content.Context;
import com.google.gson.j;
import com.xiaoenai.app.data.d.i;
import com.xiaoenai.app.data.entity.ImageEntity;
import com.xiaoenai.app.data.entity.ImageResultEntity;
import com.xiaoenai.app.net.http.base.b.c;
import org.json.JSONObject;
import rx.k;

class f
  extends c
{
  f(e parame, Context paramContext, k paramk)
  {
    super(paramContext);
  }
  
  public void a(float paramFloat)
  {
    super.a(paramFloat);
    ImageResultEntity localImageResultEntity = new ImageResultEntity();
    localImageResultEntity.setImagePath(this.b.a);
    localImageResultEntity.setProgress((int)(paramFloat * 100.0F));
    com.xiaoenai.app.utils.f.a.c("uploadInProgress:" + paramFloat * 100.0F, new Object[0]);
    this.a.a(localImageResultEntity);
  }
  
  public void a(com.xiaoenai.app.net.http.base.e parame)
  {
    super.a(parame);
    i.a().c();
    this.a.a(new com.xiaoenai.app.data.c.a(a.b(this.b.c, parame)));
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    ImageResultEntity localImageResultEntity = new ImageResultEntity();
    localImageResultEntity.setImagePath(this.b.a);
    localImageResultEntity.setProgress(100);
    localImageResultEntity.setImageEntity((ImageEntity)new j().a(paramJSONObject.toString(), ImageEntity.class));
    com.xiaoenai.app.utils.f.a.c("uploadImageSuccess: {}", new Object[] { paramJSONObject.toString() });
    this.a.a(localImageResultEntity);
    this.a.a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\d\d\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */