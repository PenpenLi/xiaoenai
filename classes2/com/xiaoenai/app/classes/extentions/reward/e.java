package com.xiaoenai.app.classes.extentions.reward;

import android.content.Context;
import com.xiaoenai.app.classes.extentions.reward.model.BaseTask;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import org.json.JSONObject;

class e
  extends m
{
  final h a = h.a(this.b.a);
  
  e(d paramd, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.a.show();
    super.a();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.a.dismiss();
  }
  
  public void a(k paramk)
  {
    super.a(paramk);
    this.a.dismiss();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.a.dismiss();
    super.a(paramJSONObject);
    c.a(this.b.b, this.b.a.getString(2131101058));
    this.b.c.setStatus(2);
    String str1 = paramJSONObject.optString("image_url");
    String str2 = paramJSONObject.optString("click_url");
    String str3 = paramJSONObject.optString("name");
    String str4 = paramJSONObject.optString("desc");
    paramJSONObject = paramJSONObject.optString("logo_url");
    c.a(this.b.a, str1, str2, str3, paramJSONObject, str4);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\extentions\reward\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */