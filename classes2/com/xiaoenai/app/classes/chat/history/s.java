package com.xiaoenai.app.classes.chat.history;

import android.content.Context;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import org.json.JSONObject;

class s
  extends m
{
  s(r paramr, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    r.b(this.a).dismiss();
    r.a(this.a, null);
    if (r.c(this.a))
    {
      h.c(r.d(this.a), 2131100336, 1500L);
      return;
    }
    r.a(this.a).a();
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    r.a(this.a).a(paramJSONObject.toString());
    r.b(this.a).dismiss();
    r.a(this.a, null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\history\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */