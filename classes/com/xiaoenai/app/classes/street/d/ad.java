package com.xiaoenai.app.classes.street.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.xiaoenai.app.classes.common.BaseActivity;
import com.xiaoenai.app.classes.street.StreetDeliveryActivity;
import com.xiaoenai.app.classes.street.model.Order;
import com.xiaoenai.app.classes.street.model.Order.OnOrderOpListener;
import com.xiaoenai.app.ui.a.g;

public class ad
{
  private Order.OnOrderOpListener a;
  private int b;
  
  public ad(Order.OnOrderOpListener paramOnOrderOpListener, int paramInt)
  {
    this.a = paramOnOrderOpListener;
    this.b = paramInt;
  }
  
  private void f(Context paramContext, Order paramOrder)
  {
    g localg = new g(paramContext);
    localg.a(2131101405);
    localg.a(2131100898, new ae(this, paramContext, paramOrder));
    localg.b(2131099973, new ai(this));
    localg.show();
  }
  
  private void g(Context paramContext, Order paramOrder)
  {
    BaseActivity localBaseActivity = (BaseActivity)paramContext;
    if ((localBaseActivity != null) && (localBaseActivity.isFinishing())) {
      localBaseActivity.a(null);
    }
    new com.xiaoenai.app.net.ae(new aj(this, paramContext, localBaseActivity, paramContext)).b(paramOrder.getId());
  }
  
  private void h(Context paramContext, Order paramOrder)
  {
    g localg = new g(paramContext);
    localg.setTitle(2131101409);
    localg.a(2131101408);
    localg.a(2131100104, new ak(this, paramContext, paramOrder));
    localg.b(2131099973, new al(this));
    localg.show();
  }
  
  private void i(Context paramContext, Order paramOrder)
  {
    BaseActivity localBaseActivity = (BaseActivity)paramContext;
    if ((localBaseActivity != null) && (localBaseActivity.isFinishing())) {
      localBaseActivity.a(null);
    }
    paramContext = new com.xiaoenai.app.net.ae(new am(this, paramContext, localBaseActivity));
    if ((paramOrder.isAfterSale()) && (paramOrder.getAfterSale() != null))
    {
      paramContext.i(paramOrder.getId());
      return;
    }
    paramContext.c(paramOrder.getId());
  }
  
  private void j(Context paramContext, Order paramOrder)
  {
    g localg = new g(paramContext);
    localg.setTitle(2131101402);
    localg.a(2131101401);
    localg.a(2131100898, new an(this, paramContext, paramOrder));
    localg.b(2131099973, new ao(this));
    localg.show();
  }
  
  private void k(Context paramContext, Order paramOrder)
  {
    BaseActivity localBaseActivity = (BaseActivity)paramContext;
    if ((localBaseActivity != null) && (localBaseActivity.isFinishing())) {
      localBaseActivity.a(null);
    }
    new com.xiaoenai.app.net.ae(new ap(this, paramContext, localBaseActivity)).d(paramOrder.getId());
  }
  
  private void l(Context paramContext, Order paramOrder)
  {
    g localg = new g(paramContext);
    localg.a(2131101396);
    localg.a(2131100054, new af(this, paramContext, paramOrder));
    localg.b(2131099973, new ag(this));
    localg.show();
  }
  
  private void m(Context paramContext, Order paramOrder)
  {
    BaseActivity localBaseActivity = (BaseActivity)paramContext;
    if ((localBaseActivity != null) && (localBaseActivity.isFinishing())) {
      localBaseActivity.a(null);
    }
    new com.xiaoenai.app.net.ae(new ah(this, paramContext, localBaseActivity)).j(paramOrder.getId());
  }
  
  public void a(Context paramContext, Order paramOrder)
  {
    f(paramContext, paramOrder);
  }
  
  public void b(Context paramContext, Order paramOrder)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("street_order_key", paramOrder);
    localIntent.setClass(paramContext, StreetDeliveryActivity.class);
    paramContext.startActivity(localIntent);
    ((Activity)paramContext).overridePendingTransition(2130968604, 2130968605);
  }
  
  public void c(Context paramContext, Order paramOrder)
  {
    h(paramContext, paramOrder);
  }
  
  public void d(Context paramContext, Order paramOrder)
  {
    j(paramContext, paramOrder);
  }
  
  public void e(Context paramContext, Order paramOrder)
  {
    l(paramContext, paramOrder);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\d\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */