package com.xiaoenai.app.classes.forum;

import android.content.Context;
import com.xiaoenai.app.model.Forum.f;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class ag
  extends m
{
  ag(ForumMineInfoActivity paramForumMineInfoActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
  }
  
  public void a(k paramk)
  {
    super.a(paramk);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    ForumMineInfoActivity.a(new f(paramJSONObject));
    f.a(ForumMineInfoActivity.c());
    ForumMineInfoActivity.c(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */