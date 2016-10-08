package com.xiaoenai.app.classes.street;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.classes.street.model.Order;
import com.xiaoenai.app.classes.street.pay.StreetPayBaseActivity;
import com.xiaoenai.app.classes.street.pay.a.a.a;
import com.xiaoenai.app.classes.street.widget.o;
import com.xiaoenai.app.net.ae;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.widget.TitleBarView;

public class StreetOrderRemindActivity
  extends StreetPayBaseActivity
{
  private int a = 0;
  private int b = 0;
  private ImageView i = null;
  private TextView j = null;
  private RelativeLayout k = null;
  private TextView l = null;
  private Button m = null;
  private Button n = null;
  private o o = null;
  private double s = 0.0D;
  private Order t = new Order();
  private LinearLayout u = null;
  private ProgressView v = null;
  private long[] w = null;
  private long x;
  
  private void a(int paramInt)
  {
    this.a = paramInt;
    com.xiaoenai.app.utils.f.a.c("=====mTotalPrice====={}", new Object[] { Double.valueOf(this.s) });
    switch (this.a)
    {
    case 2: 
    default: 
      return;
    case 0: 
      this.i.setImageResource(2130838704);
      this.j.setText(2131101426);
      this.j.setTextColor(getResources().getColor(2131493034));
      this.k.setVisibility(0);
      String str1 = getResources().getString(2131101450) + String.format("%.2f", new Object[] { Double.valueOf(this.s / 100.0D) });
      String str2 = String.format(getResources().getString(2131101421), new Object[] { str1 });
      Object localObject = getResources().getString(2131101422);
      localObject = new SpannableStringBuilder(str2 + (String)localObject);
      ((SpannableStringBuilder)localObject).setSpan(new AbsoluteSizeSpan(ab.a(18.0F)), str2.length() - str1.length(), str2.length(), 33);
      ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(getResources().getColor(2131493038)), str2.length() - str1.length(), str2.length(), 33);
      this.l.setText((CharSequence)localObject);
      this.m.setBackgroundResource(2130838702);
      this.m.setText(2131101420);
      this.m.setTextColor(getResources().getColor(2131493206));
      this.n.setBackgroundResource(2130838701);
      this.n.setText(2131101419);
      this.n.setTextColor(getResources().getColor(2131493038));
      return;
    }
    this.i.setImageResource(2130838703);
    this.j.setText(2131101425);
    this.j.setTextColor(getResources().getColor(2131493033));
    this.k.setVisibility(8);
    this.m.setBackgroundResource(2130838701);
    this.m.setText(2131101419);
    this.m.setTextColor(getResources().getColor(2131493038));
    this.n.setBackgroundResource(2130838702);
    this.n.setText(j());
    this.n.setTextColor(getResources().getColor(2131493206));
  }
  
  private void a(long paramLong)
  {
    new ae(new da(this, this)).a(paramLong);
  }
  
  private void c()
  {
    this.t = new Order();
    a(this.x);
  }
  
  private void d()
  {
    ab.b(this);
    int i1 = 0;
    if (this.a == 1) {
      i1 = -1;
    }
    setResult(i1, new Intent());
    finish();
    overridePendingTransition(2130968606, 2130968607);
  }
  
  private void f()
  {
    this.i = ((ImageView)findViewById(2131559945));
    this.j = ((TextView)findViewById(2131559946));
    this.k = ((RelativeLayout)findViewById(2131559947));
    this.l = ((TextView)findViewById(2131559948));
    this.m = ((Button)findViewById(2131559949));
    this.n = ((Button)findViewById(2131559950));
    this.o = new o(this);
    this.u = ((LinearLayout)findViewById(2131559944));
    this.v = ((ProgressView)findViewById(2131558669));
  }
  
  private void g()
  {
    this.m.setOnClickListener(new cx(this));
    this.n.setOnClickListener(new cy(this));
    this.o.a(new cz(this));
    this.c = new com.xiaoenai.app.classes.street.pay.a.a(this, k());
  }
  
  private void h()
  {
    if (this.b == 0) {
      i();
    }
    while (this.b != 1) {
      return;
    }
    r();
  }
  
  private void i()
  {
    Intent localIntent = new Intent();
    if (this.a < 2) {
      this.t.setState(this.a);
    }
    for (;;)
    {
      localIntent.putExtra("street_order_id_key", this.x);
      localIntent.setClass(this, StreetOrderDetailActivity.class);
      startActivity(localIntent);
      overridePendingTransition(2130968606, 2130968607);
      finish();
      com.xiaoenai.app.classes.common.a.a().a(StreetProductDetailActivity.class);
      com.xiaoenai.app.classes.common.a.a().a(StreetProductOrderActivity.class);
      return;
      this.t.setState(0);
    }
  }
  
  private int j()
  {
    return 2131099966;
  }
  
  private a.a k()
  {
    return new db(this);
  }
  
  public int a()
  {
    return 2130903351;
  }
  
  protected void b()
  {
    super.b();
    this.g.setLeftButtonClickListener(new cw(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.a = paramBundle.getIntExtra("order_state", 0);
      this.b = paramBundle.getIntExtra("product_order_remind_type_key", 0);
      if (this.b != 0) {
        break label104;
      }
      this.x = paramBundle.getLongExtra("product_order_id", -1L);
    }
    for (;;)
    {
      com.xiaoenai.app.utils.f.a.c("=====OrderState===== {}", new Object[] { Integer.valueOf(this.a) });
      f();
      g();
      if (1 != this.a) {
        break;
      }
      a(this.a);
      return;
      label104:
      if (this.b == 1)
      {
        this.s = paramBundle.getIntExtra("product_order_total_price_key", 0);
        this.w = paramBundle.getLongArrayExtra("product_order_ids");
      }
    }
    if (this.b == 0)
    {
      c();
      return;
    }
    a(this.a);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      this.a = paramIntent.getIntExtra("order_state", 0);
      this.b = paramIntent.getIntExtra("product_order_remind_type_key", 0);
      if (this.b != 0) {
        break label75;
      }
      this.x = paramIntent.getLongExtra("product_order_id", -1L);
    }
    for (;;)
    {
      com.xiaoenai.app.utils.f.a.c("=====OrderState====={}", new Object[] { Integer.valueOf(this.a) });
      return;
      label75:
      if (this.b == 1)
      {
        this.s = paramIntent.getIntExtra("product_order_total_price_key", 0);
        this.w = paramIntent.getLongArrayExtra("product_order_ids");
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\StreetOrderRemindActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */