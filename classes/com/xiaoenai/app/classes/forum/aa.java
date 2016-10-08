package com.xiaoenai.app.classes.forum;

import android.content.Context;
import android.os.Handler;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class aa
  extends m
{
  aa(ForumMineInfoActivity paramForumMineInfoActivity, Context paramContext, boolean paramBoolean, int paramInt, String paramString)
  {
    super(paramContext);
  }
  
  public void a()
  {
    Xiaoenai.j().k().post(new ab(this));
    super.a();
  }
  
  public void a(int paramInt)
  {
    Xiaoenai.j().k().post(new ad(this));
    super.a(paramInt);
  }
  
  public void a(k paramk)
  {
    Xiaoenai.j().k().post(new ae(this));
    super.a(paramk);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    Xiaoenai.j().k().post(new ac(this));
    super.a(paramJSONObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */