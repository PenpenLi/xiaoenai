package com.xiaoenai.app;

import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.model.UserConfig;

class f
  implements Runnable
{
  f(Xiaoenai paramXiaoenai) {}
  
  public void run()
  {
    if (AppModel.getInstance().isLogined())
    {
      int i = UserConfig.getInt("cur_version_code", Integer.valueOf(0)).intValue();
      if ((this.a.C != null) && (i != this.a.C.intValue()))
      {
        UserConfig.setInt("cur_version_code", this.a.C.intValue());
        Xiaoenai.a(this.a, i, this.a.C.intValue());
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */