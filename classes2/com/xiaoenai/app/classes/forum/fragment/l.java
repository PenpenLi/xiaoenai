package com.xiaoenai.app.classes.forum.fragment;

import com.xiaoenai.app.model.Forum.d;
import com.xiaoenai.app.utils.f.a;
import java.util.ArrayList;
import org.json.JSONObject;

class l
  implements Runnable
{
  l(k paramk, JSONObject paramJSONObject) {}
  
  public void run()
  {
    b.a(this.b.a, false);
    ArrayList localArrayList = d.b(this.a.optJSONArray("replies"));
    b.b(this.b.a, localArrayList.size());
    b.f(this.b.a).b(localArrayList);
    a.c("=====event===== Reply ==count: {}", new Object[] { Integer.valueOf(localArrayList.size()) });
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\fragment\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */