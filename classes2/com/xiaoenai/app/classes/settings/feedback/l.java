package com.xiaoenai.app.classes.settings.feedback;

import android.content.Context;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class l
  extends m
{
  l(FeedbackPhoto paramFeedbackPhoto, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(int paramInt)
  {
    this.a.b(Integer.valueOf(-2));
    if (FeedbackPhoto.a(this.a) != null) {
      FeedbackPhoto.a(this.a).a(paramInt);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.a.b(Integer.valueOf(1));
    if (FeedbackPhoto.a(this.a) != null) {
      FeedbackPhoto.a(this.a).a(paramJSONObject);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\settings\feedback\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */