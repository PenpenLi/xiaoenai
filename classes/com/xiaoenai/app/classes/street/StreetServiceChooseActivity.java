package com.xiaoenai.app.classes.street;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.xiaoenai.app.utils.a.d;

public class StreetServiceChooseActivity
  extends StreetBaseActivity
{
  private RelativeLayout a;
  private RelativeLayout b;
  private long c;
  
  private void c()
  {
    this.b = ((RelativeLayout)findViewById(2131560057));
    this.a = ((RelativeLayout)findViewById(2131560058));
  }
  
  private void d()
  {
    this.b.setOnClickListener(new du(this));
    this.a.setOnClickListener(new dv(this));
  }
  
  public int a()
  {
    return 2130903368;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.c = getIntent().getLongExtra("street_order_id_key", 0L);
    c();
    d();
    d.a(StreetOrderDetailActivity.class.getName() + StreetCustomerServiceActivity.class.getName(), "result_cancel");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\StreetServiceChooseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */