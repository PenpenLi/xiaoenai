package com.xiaoenai.app.classes.forum;

import com.xiaoenai.app.classes.forum.a.b;
import com.xiaoenai.app.classes.forum.presenter.ForumTopicViewPresenter;
import com.xiaoenai.app.classes.forum.widget.ForumPostLayoutView;
import com.xiaoenai.app.model.Forum.Post;
import com.xiaoenai.app.model.Forum.d;
import com.xiaoenai.app.widget.PullToRefreshListViewWithFirstItem;
import java.util.ArrayList;
import org.json.JSONObject;

class da
  implements Runnable
{
  da(cy paramcy, JSONObject paramJSONObject) {}
  
  public void run()
  {
    Object localObject;
    if (!this.b.a.i.d())
    {
      this.b.a.a.k();
      if (this.b.a.b.getVisibility() == 8)
      {
        dm.a(this.b.b(), this.b.a.a);
        this.b.a.b.setVisibility(0);
      }
      localObject = new Post(this.a.optJSONObject("topic"));
      this.b.a.b.setCardType(1);
      this.b.a.c.a((Post)localObject);
      if (this.b.a.m == null) {
        break label245;
      }
      this.b.a.c.d();
    }
    for (;;)
    {
      this.b.a.m = ((Post)localObject);
      localObject = d.a(this.a.optJSONArray("replies"));
      this.b.a.a(((ArrayList)localObject).size());
      this.b.a.i.a((ArrayList)localObject);
      this.b.a.h();
      return;
      this.b.a.i.b(false);
      this.b.a.i.notifyDataSetChanged();
      break;
      label245:
      this.b.a.c.b();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */