package com.xiaoenai.app.classes.forum.presenter;

import android.content.Context;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import org.json.JSONObject;

final class ae
  extends m
{
  h a = h.a(this.b);
  
  ae(Context paramContext1, Context paramContext2)
  {
    super(paramContext1);
  }
  
  public void a()
  {
    super.a();
    this.a.show();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.a.hide();
  }
  
  public void a(k paramk)
  {
    super.a(paramk);
    this.a.hide();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.a.hide();
    h.a(this.b, 2131100491, 1500L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\presenter\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */