package com.xiaoenai.app.classes.forum;

import android.content.Context;
import android.widget.Button;
import com.xiaoenai.app.model.Forum.f;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.utils.f.a;
import org.json.JSONObject;

class cc
  extends m
{
  cc(ForumRegisterActivity paramForumRegisterActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.a.a(null, false);
  }
  
  public void a(int paramInt)
  {
    this.a.l_();
    ForumRegisterActivity.j(this.a).setEnabled(true);
    super.a(paramInt);
    a.c("=================={}", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void a(k paramk)
  {
    this.a.l_();
    ForumRegisterActivity.j(this.a).setEnabled(true);
    super.a(paramk);
    a.c("==============getEvent ErrCode:{}", new Object[] { Integer.valueOf(paramk.b) });
    a.c("==============getEvent ErrString:{}", new Object[] { paramk.d });
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.a.l_();
    ForumRegisterActivity.a(new f(paramJSONObject));
    f.a(ForumRegisterActivity.c());
    as.b(2131100474);
    if ((ForumRegisterActivity.c() != null) && (ForumRegisterActivity.c().c()))
    {
      a.c("=================={}", new Object[] { paramJSONObject.toString() });
      ForumRegisterActivity.i(this.a);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */