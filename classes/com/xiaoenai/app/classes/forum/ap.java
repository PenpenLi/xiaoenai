package com.xiaoenai.app.classes.forum;

import android.content.Context;
import android.os.Handler;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class ap
  extends m
{
  ap(ForumMineTopicActivity paramForumMineTopicActivity, Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
  }
  
  public void a()
  {
    super.a();
    Xiaoenai.j().k().post(new aq(this));
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    Xiaoenai.j().k().post(new as(this));
  }
  
  public void a(k paramk)
  {
    super.a(paramk);
    Xiaoenai.j().k().post(new at(this));
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.b.l_();
    Xiaoenai.j().k().post(new ar(this, paramJSONObject));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */