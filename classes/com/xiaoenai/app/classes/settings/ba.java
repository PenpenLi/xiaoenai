package com.xiaoenai.app.classes.settings;

import android.content.res.Resources;
import android.os.AsyncTask;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.a.d;
import com.xiaoenai.app.utils.e;
import com.xiaoenai.app.utils.e.b;

class ba
  extends AsyncTask<Void, Integer, Void>
{
  ba(SettingsActivity paramSettingsActivity) {}
  
  protected Void a(Void... paramVarArgs)
  {
    try
    {
      e.a();
      b.a();
      b.b();
      d.b();
      return null;
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        paramVarArgs.printStackTrace();
      }
    }
  }
  
  protected void a(Void paramVoid)
  {
    this.a.l_();
    h.a(this.a, 2131101123, 1500L);
  }
  
  protected void onPreExecute()
  {
    this.a.a(this.a.getResources().getString(2131101094), false);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */