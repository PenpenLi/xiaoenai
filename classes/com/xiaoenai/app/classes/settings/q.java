package com.xiaoenai.app.classes.settings;

import android.content.Context;
import com.xiaoenai.app.classes.chat.messagelist.message.a.a;
import com.xiaoenai.app.classes.settings.feedback.g;
import com.xiaoenai.app.classes.settings.feedback.h;
import com.xiaoenai.app.d.f;
import com.xiaoenai.app.net.m;
import java.util.Collection;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

class q
  extends m
{
  q(SettingFeedbackActivity paramSettingFeedbackActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    int j = 0;
    super.a(paramJSONObject);
    Object localObject1 = paramJSONObject.optString("fb_name");
    Object localObject2 = paramJSONObject.optString("fb_url");
    if (!((String)localObject1).equals(g.a())) {}
    for (int i = 1;; i = 0)
    {
      g.a((String)localObject1);
      g.b((String)localObject2);
      paramJSONObject = paramJSONObject.optJSONArray("list");
      if (paramJSONObject.length() == 0) {
        if (i != 0) {
          SettingFeedbackActivity.g(this.a);
        }
      }
      for (;;)
      {
        return;
        localObject1 = new Vector();
        i = 0;
        while (i < paramJSONObject.length())
        {
          localObject2 = paramJSONObject.optJSONObject(i);
          h localh = new h();
          localh.a(-1L);
          localh.b(((JSONObject)localObject2).optString("content"));
          localh.a(((JSONObject)localObject2).optInt("ts"));
          localh.b(2);
          localh.b(Integer.valueOf(1));
          ((Vector)localObject1).add(localh);
          i += 1;
        }
        SettingFeedbackActivity.a(this.a, (Vector)localObject1);
        SettingFeedbackActivity.a(this.a).addAll((Collection)localObject1);
        SettingFeedbackActivity.a(this.a, SettingFeedbackActivity.a(this.a).toArray());
        i = j;
        while (i < ((Vector)localObject1).size())
        {
          SettingFeedbackActivity.e(this.a).a((a)((Vector)localObject1).get(i));
          i += 1;
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */