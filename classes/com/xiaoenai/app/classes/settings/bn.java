package com.xiaoenai.app.classes.settings;

import android.content.Context;
import android.widget.TextView;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class bn
  extends m
{
  bn(UpdateActivity paramUpdateActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    UpdateActivity.b(this.a).setText(2131099682);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.getBoolean("new_ver"))
      {
        UpdateActivity.b(this.a, paramJSONObject.getString("url"));
        UpdateActivity.a(this.a, paramJSONObject.getString("content"), UpdateActivity.a(this.a));
        UpdateActivity.b(this.a).setText(this.a.getString(2131099691));
        UpdateActivity.b(this.a).setOnClickListener(UpdateActivity.c(this.a));
        return;
      }
      UpdateActivity.b(this.a).setText(this.a.getString(2131099692));
      return;
    }
    catch (Exception paramJSONObject) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */