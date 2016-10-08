package com.xiaoenai.app.classes.street.pay;

import android.content.Intent;
import android.os.Bundle;
import com.xiaoenai.app.classes.street.StreetBaseActivity;
import com.xiaoenai.app.classes.street.pay.a.a;

public abstract class StreetPayBaseActivity
  extends StreetBaseActivity
{
  protected a c;
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.c != null) {
      this.c.a(this, paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\pay\StreetPayBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */