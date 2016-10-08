package com.xiaoenai.app.classes.settings;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.d.f;
import org.json.JSONObject;

class aj
  extends m
{
  aj(SettingReleaseActivity paramSettingReleaseActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    if (this.a.c == null) {
      this.a.a(null);
    }
  }
  
  public void a(int paramInt)
  {
    this.a.l_();
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.a.l_();
    f.a(paramJSONObject, f.a(Xiaoenai.j(), "release_note"));
    SettingReleaseActivity.a(this.a).setText(paramJSONObject.getString("note"));
    this.a.b.setEnabled(true);
    this.a.a.setVisibility(0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */