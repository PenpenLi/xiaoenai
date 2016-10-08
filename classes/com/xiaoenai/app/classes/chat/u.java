package com.xiaoenai.app.classes.chat;

import android.content.Context;
import com.xiaoenai.app.net.m;
import java.util.List;
import org.json.JSONObject;

class u
  extends m
{
  u(ChangeBgActivity paramChangeBgActivity, Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
  }
  
  public void a()
  {
    if (this.a) {
      this.b.a(null);
    }
  }
  
  public void a(int paramInt)
  {
    this.b.l_();
    if (this.a) {
      super.a(paramInt);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.b.l_();
    if (ChangeBgActivity.b(this.b).size() > 3)
    {
      ChangeBgActivity.b(this.b).clear();
      ChangeBgActivity.c(this.b);
    }
    ChangeBgActivity.a(this.b, paramJSONObject);
    ak.a("chat_bg_urls", paramJSONObject.toString());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */