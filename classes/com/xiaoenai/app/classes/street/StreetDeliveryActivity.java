package com.xiaoenai.app.classes.street;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.classes.street.a.e;
import com.xiaoenai.app.classes.street.d.ay;
import com.xiaoenai.app.classes.street.model.Delivery;
import com.xiaoenai.app.classes.street.model.Order;
import com.xiaoenai.app.classes.street.widget.StreetProductInfoLayout;
import com.xiaoenai.app.net.ae;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.widget.TitleBarView;

public class StreetDeliveryActivity
  extends StreetBaseActivity
{
  private TextView a;
  private TextView b;
  private TextView c;
  private TextView i;
  private ImageView j;
  private StreetProductInfoLayout k;
  private ListView l;
  private e m;
  private ay n;
  private RelativeLayout o;
  private View s;
  private RelativeLayout t;
  private RelativeLayout u;
  private long v;
  private Order w;
  private int x = 1;
  
  private void a(int paramInt)
  {
    if (paramInt == 3)
    {
      String str = String.format(getString(2131100709), new Object[0]);
      this.i.setText(String.format(getString(2131100710), new Object[] { str }));
      return;
    }
    this.i.setVisibility(8);
  }
  
  private void a(Delivery paramDelivery)
  {
    this.a.setText(paramDelivery.getExpressName());
    ((LinearLayout.LayoutParams)this.u.getLayoutParams()).topMargin = 0;
    if (paramDelivery.getIconUrl() != null) {
      b.a(this.j, paramDelivery.getIconUrl(), 2130839103);
    }
    this.c.setText(String.format(getString(2131100708), new Object[] { paramDelivery.getId() }));
    a(paramDelivery.getStatus());
  }
  
  private void c()
  {
    this.a = ((TextView)findViewById(2131559859));
    this.j = ((ImageView)findViewById(2131559858));
    this.c = ((TextView)findViewById(2131559860));
    this.i = ((TextView)findViewById(2131559861));
    this.k = ((StreetProductInfoLayout)findViewById(2131559865));
    this.l = ((ListView)findViewById(2131559866));
    this.o = ((RelativeLayout)LayoutInflater.from(this).inflate(2130903277, null));
    this.b = ((TextView)this.o.findViewById(2131559626));
    this.l.addHeaderView(this.o);
    this.s = findViewById(2131559627);
    this.t = ((RelativeLayout)findViewById(2131559857));
    this.u = ((RelativeLayout)findViewById(2131559862));
  }
  
  private void d()
  {
    this.k.setOnClickListener(new bg(this));
  }
  
  private void f()
  {
    new ae(new bh(this, this)).e(this.v);
  }
  
  private void g()
  {
    h();
    new ae(new bi(this, this)).g(this.v);
  }
  
  private void h()
  {
    this.g.setTitle(getString(2131101337));
    this.b.setText(getResources().getText(2131101337));
    this.t.setVisibility(8);
  }
  
  public int a()
  {
    return 2130903340;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c();
    this.w = ((Order)getIntent().getParcelableExtra("street_order_key"));
    if (this.w != null) {
      this.v = this.w.getId();
    }
    this.m = new e(this);
    this.l.setAdapter(this.m);
    if (this.w != null)
    {
      this.n = new ay(this.k, this.w);
      this.n.a();
    }
    this.x = getIntent().getIntExtra("street_progress_key", 1);
    if (this.x == 1) {
      f();
    }
    for (;;)
    {
      d();
      return;
      if (this.x == 2) {
        g();
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\StreetDeliveryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */