package com.xiaoenai.app.classes.settings.feedback;

import android.content.Context;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.e.b;
import org.json.JSONObject;

class j
  extends m
{
  j(FeedbackPhoto paramFeedbackPhoto, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    super.a();
    this.a.b(Integer.valueOf(-1));
    if (FeedbackPhoto.a(this.a) != null) {
      FeedbackPhoto.a(this.a).a();
    }
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
    this.a.e(paramJSONObject.getString("key"));
    this.a.c(paramJSONObject.getString("url"));
    this.a.a(paramJSONObject.getInt("width"), paramJSONObject.getInt("height"));
    b.b(Xiaoenai.b(this.a.t()), this.a.w());
    if (FeedbackPhoto.b(this.a) > 0L)
    {
      FeedbackPhoto.c(this.a);
      return;
    }
    FeedbackPhoto.d(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\settings\feedback\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */