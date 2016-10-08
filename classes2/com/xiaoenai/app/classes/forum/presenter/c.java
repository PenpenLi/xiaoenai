package com.xiaoenai.app.classes.forum.presenter;

import com.google.gson.j;
import com.xiaoenai.app.classes.common.mvp.a.a.a;
import com.xiaoenai.app.classes.common.mvp.view.b;
import com.xiaoenai.app.classes.forum.model.MomentInfo;
import com.xiaoenai.app.net.g;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class c
  extends a<MomentInfo>
{
  public c(b<MomentInfo> paramb)
  {
    super(paramb);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optJSONObject("data");
      localObject1 = localObject2;
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.optJSONArray("activity_list");
        localObject1 = localObject2;
        if (paramJSONObject != null) {
          localObject1 = (List)new j().a(paramJSONObject.toString(), new e(this).getType());
        }
      }
    }
    a((List)localObject1);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    new g(new d(this, this.e.c())).f(paramInt, 20);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\presenter\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */