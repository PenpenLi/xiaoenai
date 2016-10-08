package com.xiaoenai.app.classes.street.d;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.common.BaseActivity;
import com.xiaoenai.app.classes.street.model.Order;
import com.xiaoenai.app.net.ae;

class be
  implements View.OnClickListener
{
  be(ba paramba, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    if (ba.a(this.b).isAfterSale())
    {
      paramView = (BaseActivity)this.a;
      if ((paramView != null) && (paramView.isFinishing())) {
        paramView.a(null);
      }
      new ae(new bf(this, this.a, paramView)).k(ba.a(this.b).getId());
      return;
    }
    ba.b(this.b, this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\d\be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */