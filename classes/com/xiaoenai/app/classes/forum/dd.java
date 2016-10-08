package com.xiaoenai.app.classes.forum;

import android.content.Context;
import com.xiaoenai.app.classes.forum.a.b;
import com.xiaoenai.app.model.Forum.d;
import com.xiaoenai.app.net.m;
import java.util.ArrayList;
import org.json.JSONObject;

class dd
  extends m
{
  dd(ForumTopicActivity paramForumTopicActivity, Context paramContext, ForumTopicActivity.a parama)
  {
    super(paramContext);
  }
  
  public void a()
  {
    super.a();
    ForumTopicActivity.a(this.b, true);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    ForumTopicActivity.a(this.b, false);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    ForumTopicActivity.a(this.b, false);
    paramJSONObject = d.a(paramJSONObject.optJSONArray("replies"));
    this.b.a(paramJSONObject.size());
    this.b.i.b(paramJSONObject);
    if (this.a != null) {
      this.a.a();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */