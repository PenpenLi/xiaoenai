package com.xiaoenai.app.classes.street.a;

import android.content.Context;
import android.widget.TextView;
import com.xiaoenai.app.classes.street.model.DeliveryCompany;
import com.xiaoenai.app.widget.wheel.a.b;

public class p
  extends b
{
  private DeliveryCompany[] a;
  
  public p(Context paramContext, DeliveryCompany[] paramArrayOfDeliveryCompany)
  {
    super(paramContext);
    this.a = paramArrayOfDeliveryCompany;
  }
  
  public int a()
  {
    return this.a.length;
  }
  
  protected CharSequence a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < a())) {
      return this.a[paramInt].getName();
    }
    return null;
  }
  
  protected void a(TextView paramTextView)
  {
    paramTextView.setTextColor(-14013652);
    paramTextView.setGravity(17);
    paramTextView.setTextSize(20.0F);
    paramTextView.setLines(1);
    paramTextView.setPadding(0, 15, 0, 15);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\a\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */