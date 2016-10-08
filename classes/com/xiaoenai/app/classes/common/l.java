package com.xiaoenai.app.classes.common;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.utils.n;
import com.xiaoenai.tool.log.d;

class l
  implements View.OnClickListener
{
  l(DebugActivity paramDebugActivity) {}
  
  public void onClick(View paramView)
  {
    d.b(this.a.getApplicationContext());
    n.a().b(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */