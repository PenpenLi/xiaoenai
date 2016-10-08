package com.xiaoenai.app.classes.street;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.xiaoenai.app.classes.street.d.i;
import com.xiaoenai.app.classes.street.model.Order;
import com.xiaoenai.app.classes.street.pay.StreetPayBaseActivity;
import com.xiaoenai.app.classes.street.pay.a.a.a;
import com.xiaoenai.app.classes.street.widget.StreetProductInfoWithPriceLayout;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.a.d;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.widget.TitleBarView;
import org.json.JSONException;
import org.json.JSONObject;

public class StreetOrderDetailActivity
  extends StreetPayBaseActivity
{
  private a a;
  private i b;
  private Order i;
  private int j = 0;
  private long k;
  private String l = null;
  private boolean m = false;
  
  private void a(long paramLong)
  {
    this.a.a.l();
    new com.xiaoenai.app.net.ae(new ct(this, this)).a(paramLong);
  }
  
  private void a(boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, StreetOrderRemindActivity.class);
    if (paramBoolean)
    {
      this.j = 1;
      a(this.i.getId());
      localIntent.putExtra("order_state", 1);
    }
    for (;;)
    {
      localIntent.putExtra("product_order_id", this.i.getId());
      startActivity(localIntent);
      overridePendingTransition(2130968604, 2130968605);
      finish();
      return;
      localIntent.putExtra("order_state", 0);
    }
  }
  
  private void b(long paramLong)
  {
    new com.xiaoenai.app.net.ae(new cu(this, this)).h(paramLong);
  }
  
  private void f()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getStringExtra("param");
      if (com.xiaoenai.app.utils.ae.a((String)localObject)) {
        break label228;
      }
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        if (localObject != null)
        {
          String str = ((JSONObject)localObject).optString("order_id");
          if ((str == null) || (str.length() <= 0)) {
            continue;
          }
          this.k = Long.parseLong(str);
          localObject = ((JSONObject)localObject).optString("module_id");
          if (!com.xiaoenai.app.utils.ae.a((String)localObject))
          {
            if ((!((String)localObject).equalsIgnoreCase("xiaoenai.street.returngoods")) && (!((String)localObject).equalsIgnoreCase("xiaoenai.street.aftersalesuccess"))) {
              continue;
            }
            this.m = true;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
        if ((!localJSONException.equalsIgnoreCase("xiaoenai.street.aftersalefail")) && (!localJSONException.equalsIgnoreCase("xiaoenai.street.delivery"))) {
          continue;
        }
        this.m = false;
        continue;
      }
      this.i = ((Order)getIntent().getParcelableExtra("street_order_key"));
      this.l = getIntent().getStringExtra("from");
      com.xiaoenai.app.utils.f.a.c("order {}", new Object[] { this.i });
      com.xiaoenai.app.utils.f.a.c("orderId {}", new Object[] { Long.valueOf(this.k) });
      com.xiaoenai.app.utils.f.a.c("from {}", new Object[] { this.l });
      return;
      this.k = ((JSONObject)localObject).optInt("order_id");
      continue;
      label228:
      this.k = getIntent().getLongExtra("street_order_id_key", 0L);
      this.m = getIntent().getBooleanExtra("street_order_detail_type", false);
    }
  }
  
  private void g()
  {
    this.a.a = ((PullToRefreshScrollView)findViewById(2131559916));
    this.a.b = ((RelativeLayout)findViewById(2131559917));
    this.a.c = ((StreetProductInfoWithPriceLayout)findViewById(2131559918));
    this.a.d = ((RelativeLayout)findViewById(2131559919));
    this.a.e = ((TextView)findViewById(2131559920));
    this.a.f = ((TextView)findViewById(2131559921));
    this.a.g = ((TextView)findViewById(2131559922));
    this.a.h = ((ImageView)findViewById(2131559925));
    this.a.i = ((TextView)findViewById(2131559926));
    this.a.j = ((TextView)findViewById(2131559927));
    this.a.k = ((TextView)findViewById(2131559929));
    this.a.l = ((TextView)findViewById(2131559930));
    this.a.m = ((TextView)findViewById(2131559938));
    this.a.n = ((Button)findViewById(2131559939));
    this.a.o = ((Button)findViewById(2131559940));
    this.a.p = ((Button)findViewById(2131559941));
    this.a.q = ((RelativeLayout)findViewById(2131559931));
    this.a.r = ((TextView)findViewById(2131559932));
    this.a.s = ((TextView)findViewById(2131559933));
    this.a.t = ((TextView)findViewById(2131559934));
    this.a.u = findViewById(2131559935);
    this.a.v = ((Button)findViewById(2131559936));
    this.a.w = findViewById(2131559937);
    this.c = new com.xiaoenai.app.classes.street.pay.a.a(this, p());
  }
  
  private void h()
  {
    this.a.n.setOnClickListener(new cp(this));
    this.a.a.setOnRefreshListener(new cr(this));
  }
  
  private void i()
  {
    if (this.m)
    {
      b(o());
      return;
    }
    a(o());
  }
  
  private void j()
  {
    this.a.b.setVisibility(0);
    this.a.c.setVisibility(0);
    this.a.d.setVisibility(0);
  }
  
  private void k()
  {
    this.a.b.setVisibility(4);
    this.a.c.setVisibility(4);
    this.a.d.setVisibility(4);
  }
  
  private long o()
  {
    if ((this.i != null) && (this.i.getId() > 0L)) {
      return this.i.getId();
    }
    return this.k;
  }
  
  private a.a p()
  {
    return new cv(this);
  }
  
  public int a()
  {
    return 2130903349;
  }
  
  protected void b()
  {
    super.b();
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getStringExtra("from");
      if ((localObject != null) && (((String)localObject).equals("notification"))) {
        this.g.a(2130839000, 2131100897);
      }
    }
    this.g.setLeftButtonClickListener(new cs(this));
  }
  
  public void c()
  {
    this.b.b();
    ab.b(this);
    int n = 0;
    if (this.j == 1) {
      n = -1;
    }
    setResult(n, new Intent());
    finish();
    overridePendingTransition(2130968606, 2130968607);
  }
  
  public void d()
  {
    com.xiaoenai.app.utils.f.a.c("backWithResultTillOpSuccess from {}", new Object[] { this.l });
    if ((this.l != null) && (this.l.equals("notification")))
    {
      Intent localIntent = new Intent();
      localIntent.setClass(this, StreetOrderActivity.class);
      startActivity(localIntent);
      overridePendingTransition(2130968604, 2130968605);
    }
    for (;;)
    {
      finish();
      overridePendingTransition(2130968606, 2130968607);
      return;
      setResult(-1, new Intent());
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      if (paramInt1 == 834) {
        h.a(this, 2131101427, 1500L);
      }
    }
    do
    {
      do
      {
        return;
      } while (paramInt1 != 836);
      i();
      return;
      paramIntent = d.a(StreetOrderDetailActivity.class.getName() + StreetCustomerServiceActivity.class.getName());
    } while ((paramIntent == null) || (!paramIntent.equals("result_ok")));
    i();
    d.a(StreetOrderDetailActivity.class.getName() + StreetCustomerServiceActivity.class.getName(), "result_cancel");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = new a();
    f();
    if ((this.i != null) && ((this.i.getState() == 1) || (this.i.getState() == 2) || (this.i.getState() == 3))) {
      this.i.setShowSellOpBtn(true);
    }
    g();
    this.b = new i(this.i, this.a, new co(this));
    if (this.i != null)
    {
      this.i.setIsShowAfterSale(true);
      this.i.setIsShowCheckBtn(false);
      this.b.a();
      i();
    }
    for (;;)
    {
      h();
      return;
      k();
      this.i = new Order();
      this.i.setIsShowAfterSale(true);
      this.b.a(this.i);
      i();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    c();
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public class a
  {
    public PullToRefreshScrollView a;
    public RelativeLayout b;
    public StreetProductInfoWithPriceLayout c;
    public RelativeLayout d;
    public TextView e;
    public TextView f;
    public TextView g;
    public ImageView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public Button n;
    public Button o;
    public Button p;
    public RelativeLayout q;
    public TextView r;
    public TextView s;
    public TextView t;
    public View u;
    public Button v;
    public View w;
    
    public a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\StreetOrderDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */