package com.xiaoenai.app.classes.forum;

import android.content.Context;
import com.xiaoenai.app.classes.forum.a.b;
import com.xiaoenai.app.classes.forum.presenter.ForumTopicViewPresenter;
import com.xiaoenai.app.classes.forum.widget.ForumPostLayoutView;
import com.xiaoenai.app.model.Forum.Post;
import com.xiaoenai.app.model.Forum.d;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.widget.PullToRefreshListViewWithFirstItem;
import org.json.JSONObject;

class be
  extends m
{
  be(ForumNotiTopicActivity paramForumNotiTopicActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    super.a();
    this.a.a.l();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.a.a.k();
  }
  
  public void a(k paramk)
  {
    super.a(paramk);
    this.a.a.k();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    ForumNotiTopicActivity.c(this.a);
    this.a.a.k();
    Post localPost = new Post(paramJSONObject.optJSONObject("topic"));
    this.a.b.setCardType(1);
    this.a.c.a(localPost);
    this.a.m = localPost;
    dm.a(b(), this.a.a);
    if (this.a.m != null)
    {
      this.a.c.b();
      this.a.c.d();
    }
    paramJSONObject = d.a(paramJSONObject.optJSONArray("replies"));
    this.a.a(0);
    this.a.i.a(paramJSONObject);
    this.a.h();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */