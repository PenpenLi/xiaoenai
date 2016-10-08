package com.xiaoenai.app.classes.forum;

import android.content.Context;
import com.xiaoenai.app.classes.extentions.reward.model.BaseTask;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class cl
  extends m
{
  cl(ForumReplyActivity paramForumReplyActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.a.a(null);
    super.a();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.a.l_();
  }
  
  public void a(k paramk)
  {
    super.a(paramk);
    this.a.l_();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.a.l_();
    ForumReplyActivity.a(this.a, paramJSONObject);
    BaseTask.doTaskAction(7, 1, this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */