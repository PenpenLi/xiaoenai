package com.xiaoenai.app.classes.street;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.classes.common.dialog.q;
import com.xiaoenai.app.classes.street.a.p;
import com.xiaoenai.app.classes.street.model.DeliveryCompany;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.widget.TitleBarView;

public class StreetAfterSaleLogisticsActivity
  extends StreetBaseActivity
{
  private long a;
  private a b;
  private q c;
  private DeliveryCompany[] i;
  private int j;
  private int k = 0;
  
  private void c(String paramString)
  {
    this.g.setTitle(getResources().getString(2131101374));
    a.b(this.b).setVisibility(8);
    a.c(this.b).setVisibility(0);
    a.d(this.b).setText(paramString);
  }
  
  private void d()
  {
    this.b = new a();
    a.a(this.b, (RelativeLayout)findViewById(2131559806));
    a.a(this.b, (LinearLayout)findViewById(2131559815));
    a.a(this.b, (TextView)findViewById(2131559816));
    a.b(this.b, (RelativeLayout)findViewById(2131559809));
    this.b.a = ((TextView)findViewById(2131559810));
    this.b.b = ((EditText)findViewById(2131559812));
    this.b.c = ((TextView)findViewById(2131559808));
    this.b.d = ((Button)findViewById(2131559814));
  }
  
  private void f()
  {
    a.a(this.b).setOnClickListener(new z(this));
    this.b.d.setOnClickListener(new aa(this));
  }
  
  private void g()
  {
    if (this.c == null)
    {
      this.c = new q(this);
      this.c.a(new p(this, this.i), new ab(this));
      this.c.b(new ac(this));
      this.c.a(new ad(this));
    }
    this.c.show();
  }
  
  private void h()
  {
    a(null);
    new com.xiaoenai.app.net.ae(new ae(this, this)).e();
  }
  
  private void i()
  {
    String str = this.b.b.getText().toString();
    if (j())
    {
      a(null);
      new com.xiaoenai.app.net.ae(new af(this, this)).a(this.a, this.i[this.j].getId(), str);
      return;
    }
    h.b(this, 2131101371, 1500L);
  }
  
  private boolean j()
  {
    String str = this.b.b.getText().toString();
    if ((this.i == null) || (this.i[this.j] == null)) {}
    while ((this.j != this.i.length - 1) && ((str == null) || (str.length() == 0))) {
      return false;
    }
    return true;
  }
  
  public int a()
  {
    return 2130903332;
  }
  
  public void b(String paramString)
  {
    c(paramString);
    this.k = -1;
  }
  
  public void c()
  {
    setResult(this.k);
    super.r();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = getIntent().getLongExtra("street_order_id_key", -1L);
    d();
    h();
    f();
  }
  
  public void r()
  {
    c();
  }
  
  class a
  {
    public TextView a;
    public EditText b;
    public TextView c;
    public Button d;
    private RelativeLayout f;
    private LinearLayout g;
    private TextView h;
    private RelativeLayout i;
    
    a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\StreetAfterSaleLogisticsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */