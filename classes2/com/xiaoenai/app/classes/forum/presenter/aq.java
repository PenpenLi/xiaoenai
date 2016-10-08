package com.xiaoenai.app.classes.forum.presenter;

import android.content.Context;
import com.xiaoenai.app.classes.forum.ForumActivity;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import java.util.ArrayList;
import org.json.JSONObject;

class aq
  extends m
{
  aq(ap paramap, Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.b.a(null);
  }
  
  public void a(k paramk)
  {
    super.a(paramk);
    this.b.a(null);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    ArrayList localArrayList1 = (ArrayList)com.xiaoenai.app.classes.common.ads.a.a(paramJSONObject, "topics");
    if (!this.a)
    {
      ArrayList localArrayList2 = (ArrayList)com.xiaoenai.app.classes.common.ads.a.a(paramJSONObject, "top_topics");
      ((com.xiaoenai.app.classes.forum.c.b)ap.a(this.b)).a(localArrayList2);
      if (16 == ((com.xiaoenai.app.classes.forum.c.b)ap.b(this.b)).k())
      {
        int i = paramJSONObject.optInt("notifications_count", 0);
        ap.a(this.b, i);
      }
      UserConfig.setInt("forum_publish_limit", paramJSONObject.optInt("publish_limit"));
      UserConfig.setInt("forum_reply_limit", paramJSONObject.optInt("reply_limit"));
      UserConfig.setBoolean("forum_has_moment", Boolean.valueOf(paramJSONObject.optBoolean("has_event")));
      UserConfig.setInt("forum_moment_id", paramJSONObject.optInt("event_id"));
      UserConfig.setLong("forum_moment_end_time", paramJSONObject.optLong("event_end_time"));
      ((ForumActivity)ap.c(this.b).c()).a(2);
    }
    this.b.a(localArrayList1);
    ap.a(this.b, true);
    com.xiaoenai.app.utils.f.a.c("mLoadEnd = {}", new Object[] { Boolean.valueOf(ap.d(this.b)) });
    if (ap.e(this.b) != null) {
      ap.a(this.b, ap.e(this.b));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\presenter\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */