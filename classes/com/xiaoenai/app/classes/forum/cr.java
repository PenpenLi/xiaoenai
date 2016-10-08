package com.xiaoenai.app.classes.forum;

import android.content.Context;
import android.os.Handler;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.forum.a.g;
import com.xiaoenai.app.model.Forum.f;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.widget.PullToRefreshListViewEx;
import java.util.List;
import org.json.JSONObject;

class cr
  extends m
{
  cr(ForumShowoffActivity paramForumShowoffActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    super.a();
    ForumShowoffActivity.a(this.a, true);
    Xiaoenai.j().k().post(new cs(this));
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    ForumShowoffActivity.a(this.a, false);
    if (ForumShowoffActivity.c(this.a))
    {
      ForumShowoffActivity.b(this.a).k();
      ForumShowoffActivity.b(this.a, false);
    }
    ForumShowoffActivity.c(this.a, false);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    ForumShowoffActivity.a(this.a, false);
    if (ForumShowoffActivity.c(this.a))
    {
      ForumShowoffActivity.d(this.a).clear();
      ForumShowoffActivity.b(this.a).k();
      ForumShowoffActivity.b(this.a, false);
    }
    ForumShowoffActivity.d(this.a).addAll(f.a(paramJSONObject));
    ForumShowoffActivity.c(this.a, false);
    if (ForumShowoffActivity.e(this.a) == 0) {
      ForumShowoffActivity.f(this.a).a(ForumShowoffActivity.d(this.a), 1);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */