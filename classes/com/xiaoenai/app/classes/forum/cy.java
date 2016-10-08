package com.xiaoenai.app.classes.forum;

import android.content.Context;
import android.os.Handler;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class cy
  extends m
{
  cy(ForumTopicActivity paramForumTopicActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    Xiaoenai.j().k().post(new cz(this));
    super.a();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    Xiaoenai.j().k().post(new db(this));
  }
  
  public void a(k paramk)
  {
    super.a(paramk);
    Xiaoenai.j().k().post(new dc(this));
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    Xiaoenai.j().k().post(new da(this, paramJSONObject));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */