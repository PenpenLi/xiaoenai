package com.xiaoenai.app.classes.common.image.imagePreview;

import android.content.Context;
import android.os.Handler;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import org.json.JSONObject;

class j
  extends m
{
  j(a parama, Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      h.a(b(), 2131099713, 1500L);
      Xiaoenai.j().a(new k(this));
      if (this.b <= 1) {
        Xiaoenai.j().k().postDelayed(new l(this), 1500L);
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */