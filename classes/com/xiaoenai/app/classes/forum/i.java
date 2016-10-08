package com.xiaoenai.app.classes.forum;

import android.content.Context;
import com.xiaoenai.app.model.Forum.f;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class i
  extends m
{
  i(ForumActivity paramForumActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    f.b(paramJSONObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */