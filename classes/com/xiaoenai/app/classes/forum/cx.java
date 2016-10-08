package com.xiaoenai.app.classes.forum;

import android.content.Context;
import com.xiaoenai.app.classes.forum.presenter.ForumTopicViewPresenter;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import org.json.JSONObject;

class cx
  extends m
{
  h a = h.a(this.b);
  
  cx(ForumTopicActivity paramForumTopicActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    super.a();
    this.a.show();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.a.dismiss();
    this.b.c.a(this.b, 0);
  }
  
  public void a(k paramk)
  {
    super.a(paramk);
    this.a.dismiss();
    this.b.c.a(this.b, 0);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.a.dismiss();
    this.b.c.a(this.b, -1);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */