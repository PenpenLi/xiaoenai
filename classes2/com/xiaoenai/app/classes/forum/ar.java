package com.xiaoenai.app.classes.forum;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.xiaoenai.app.classes.forum.a.j;
import java.util.ArrayList;
import org.json.JSONObject;

class ar
  implements Runnable
{
  ar(ap paramap, JSONObject paramJSONObject) {}
  
  public void run()
  {
    ArrayList localArrayList = (ArrayList)com.xiaoenai.app.classes.common.ads.a.a(this.a, "topics");
    if (localArrayList.size() < 20)
    {
      com.xiaoenai.app.utils.f.a.c("=======================has More", new Object[0]);
      ForumMineTopicActivity.a(this.b.b).a(false);
    }
    if (this.b.a)
    {
      ForumMineTopicActivity.b(this.b.b).k();
      ForumMineTopicActivity.a(this.b.b).a(localArrayList);
    }
    for (;;)
    {
      ForumMineTopicActivity.a(this.b.b, false);
      return;
      ForumMineTopicActivity.a(this.b.b).b(localArrayList);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */