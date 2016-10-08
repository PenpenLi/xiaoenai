package com.xiaoenai.app.classes.common;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.tool.log.d;

class f
  implements View.OnClickListener
{
  f(DebugActivity paramDebugActivity) {}
  
  public void onClick(View paramView)
  {
    d.d(this.a.getApplicationContext());
    DebugActivity.a(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */