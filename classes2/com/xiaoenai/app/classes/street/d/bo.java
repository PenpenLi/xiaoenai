package com.xiaoenai.app.classes.street.d;

import com.google.gson.j;
import com.xiaoenai.app.classes.street.model.ProductItemInfo;
import com.xiaoenai.app.classes.street.model.SceneInfo;
import com.xiaoenai.app.classes.street.model.SceneTextType;
import com.xiaoenai.app.classes.street.widget.StreetSceneView;
import com.xiaoenai.app.net.ad;
import com.xiaoenai.app.utils.ae;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class bo
  extends a
{
  boolean a = false;
  private StreetSceneView b = null;
  private long c = -1L;
  private boolean d;
  
  public bo(StreetSceneView paramStreetSceneView)
  {
    this.b = paramStreetSceneView;
  }
  
  public void a(int paramInt)
  {
    new ad(new br(this, this.b.getContext())).a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.d) {}
    ad localad;
    do
    {
      return;
      this.d = true;
      this.b.a();
      localad = new ad(new bp(this, this.b.getContext(), paramInt1, paramInt3, paramInt2));
      if (paramInt2 == 0)
      {
        localad.a(paramInt3, paramInt1, 20);
        return;
      }
      if (1 == paramInt2)
      {
        localad.b(paramInt3, paramInt1, 20);
        return;
      }
    } while (2 != paramInt2);
    localad.c(paramInt3, paramInt1, 20);
  }
  
  public void a(int paramInt, long paramLong)
  {
    new ad(new bq(this, this.b.getContext())).a(paramInt, paramLong);
  }
  
  public void a(JSONObject paramJSONObject, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    com.xiaoenai.app.utils.f.a.c("street_scene_data {} {}", new Object[] { Integer.valueOf(paramInt1), paramJSONObject.toString() });
    paramJSONObject = (SceneInfo)new j().a(paramJSONObject.toString(), SceneInfo.class);
    ArrayList localArrayList = new ArrayList();
    List localList = paramJSONObject.getProduct_list();
    int i = localList.size();
    Object localObject;
    if (!paramBoolean)
    {
      localObject = paramJSONObject.getBanner_list();
      if ((localObject != null) && (localObject.length > 0)) {
        localArrayList.add(paramJSONObject.getBanner_list());
      }
      if (!ae.a(paramJSONObject.getSpecial_text())) {
        localArrayList.add(new SceneTextType(paramJSONObject.getSpecial_text(), 1));
      }
    }
    if ((1 == paramInt2) && (!paramBoolean)) {
      this.a = false;
    }
    if ((localList != null) && (i > 0))
    {
      this.c = this.b.b(paramInt1, paramInt2);
      paramInt1 = 0;
      if (paramInt1 < localList.size())
      {
        localObject = (ProductItemInfo)localList.get(paramInt1);
        if ((paramInt2 == 1) && (!((ProductItemInfo)localObject).isToday())) {
          if ((!this.a) && (!ae.a(paramJSONObject.getSpecial_today_text())))
          {
            if ((paramInt1 != 0) || (paramBoolean)) {
              localArrayList.add(new SceneTextType(paramJSONObject.getSpecial_today_text(), 2));
            }
            this.a = true;
          }
        }
        for (;;)
        {
          localArrayList.add(localObject);
          paramInt1 += 1;
          break;
          if (paramInt2 == 0) {
            if ((this.c != -1L) && (((ProductItemInfo)localObject).getSelling_ts() > this.c)) {
              ((ProductItemInfo)localObject).setNew(true);
            } else {
              ((ProductItemInfo)localObject).setNew(false);
            }
          }
        }
      }
    }
    this.b.a(paramBoolean, localArrayList, i, paramJSONObject.getNo_more());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\d\bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */