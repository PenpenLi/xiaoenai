package com.xiaoenai.app.classes.home.view;

import android.content.Context;
import android.text.TextUtils;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class al
  extends m
{
  al(LoverSearchView paramLoverSearchView, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    LoverSearchView.a(this.a, b().getString(2131100556));
  }
  
  public void a(int paramInt)
  {
    LoverSearchView.c(this.a);
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    LoverSearchView.c(this.a);
    String str4 = paramJSONObject.optString("lover_avatar");
    String str1 = paramJSONObject.optString("lover_nickname");
    String str2 = paramJSONObject.optString("lover_email");
    String str3 = paramJSONObject.optString("lover_phone");
    paramJSONObject = paramJSONObject.optString("lover_username");
    if (!TextUtils.isEmpty(str1)) {
      paramJSONObject = str1;
    }
    for (;;)
    {
      LoverSearchView.a(this.a, paramJSONObject, str4);
      return;
      if (!TextUtils.isEmpty(str3)) {
        paramJSONObject = str3;
      } else if (!TextUtils.isEmpty(str2)) {
        paramJSONObject = str2;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */