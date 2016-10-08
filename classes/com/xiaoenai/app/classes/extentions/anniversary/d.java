package com.xiaoenai.app.classes.extentions.anniversary;

import android.content.Context;
import android.widget.TextView;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.m;
import java.util.ArrayList;
import org.json.JSONObject;

class d
  extends m
{
  d(AnniversaryActivity paramAnniversaryActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    ai.a().a(paramJSONObject);
    AnniversaryActivity.a(this.a).a();
    UserConfig.setString("extention_anniversary", paramJSONObject.toString());
    long l = ((ah)ai.a().b().get(0)).k();
    if (l <= 0L) {
      AnniversaryActivity.b(this.a).setText("1");
    }
    for (;;)
    {
      AnniversaryActivity.c(this.a).setText(((ah)ai.a().b().get(0)).a(this.a));
      return;
      AnniversaryActivity.b(this.a).setText(String.valueOf(l));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\anniversary\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */