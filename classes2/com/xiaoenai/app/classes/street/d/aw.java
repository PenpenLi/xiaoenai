package com.xiaoenai.app.classes.street.d;

import android.content.Context;
import com.xiaoenai.app.classes.street.model.ProductInfo;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class aw
  extends m
{
  aw(aq paramaq, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
  }
  
  public void a(k paramk)
  {
    super.a(paramk);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    if (aq.c(this.a) != null)
    {
      paramJSONObject = aq.c(this.a);
      if (!aq.c(this.a).getFavor().booleanValue()) {
        break label47;
      }
    }
    label47:
    for (int i = 0;; i = 1)
    {
      paramJSONObject.setFavor(i);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\d\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */