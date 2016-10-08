package com.xiaoenai.app.classes.street;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.street.a.j;
import com.xiaoenai.app.classes.street.model.Order;
import com.xiaoenai.app.classes.street.model.Product;
import com.xiaoenai.app.classes.street.model.Sku;
import com.xiaoenai.app.classes.street.pay.StreetPayBaseActivity;
import com.xiaoenai.app.classes.street.pay.a.a.a;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.widget.TitleBarView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StreetOrderActivity
  extends StreetPayBaseActivity
{
  private RelativeLayout A;
  private RelativeLayout B;
  private RelativeLayout C;
  private RelativeLayout D;
  private RelativeLayout E;
  private TextView F;
  private Button G;
  private int H = 0;
  private LinearLayout I;
  private ImageView J;
  private TextView K;
  private int L = 0;
  private Order M = null;
  private HashMap<Long, Order> N = new HashMap();
  private Handler O = new bw(this);
  long[] a = null;
  private ViewPager b;
  private TextView i;
  private ImageView j;
  private TextView k;
  private ImageView l;
  private j m;
  private TextView n;
  private ImageView o;
  private TextView s;
  private ImageView t;
  private TextView u;
  private ImageView v;
  private TextView w;
  private ImageView x;
  private RelativeLayout y;
  private RelativeLayout z;
  
  private void a(int paramInt)
  {
    String str = getString(2131101366);
    Object localObject = new StringBuilder().append(str).append("￥ ");
    if (paramInt == 0) {}
    for (double d = 0.0D;; d = paramInt / 100.0D)
    {
      localObject = String.format("%.2f", new Object[] { Double.valueOf(d) });
      SpannableString localSpannableString = new SpannableString((CharSequence)localObject);
      localSpannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131493132)), str.length(), ((String)localObject).length(), 17);
      this.F.setText(localSpannableString);
      return;
    }
  }
  
  private void a(Map<Long, Order> paramMap)
  {
    int i2 = 0;
    Iterator localIterator = paramMap.keySet().iterator();
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (localIterator.hasNext())
    {
      localArrayList.add(i1, Long.valueOf(((Order)paramMap.get((Long)localIterator.next())).getId()));
      i1 += 1;
    }
    this.a = new long[localArrayList.size()];
    i1 = i2;
    while (i1 < localArrayList.size())
    {
      this.a[i1] = ((Long)localArrayList.get(i1)).longValue();
      i1 += 1;
    }
    com.xiaoenai.app.classes.street.pay.a.a(this, new cd(this));
  }
  
  private void a(boolean paramBoolean)
  {
    com.xiaoenai.app.utils.f.a.c("success = {}", new Object[] { Boolean.valueOf(paramBoolean) });
    Intent localIntent = new Intent();
    localIntent.setClass(this, StreetOrderRemindActivity.class);
    int i1;
    if (paramBoolean)
    {
      localIntent.putExtra("order_state", 1);
      if (this.M == null) {
        break label273;
      }
      if ((!this.M.getProduct().getIsRush().booleanValue()) && (this.M.getSku().getRushId() <= 0)) {
        break label251;
      }
      i1 = this.M.getSku().getRushPrice() * this.M.getCount();
      label99:
      this.a = new long[1];
      this.a[0] = this.M.getId();
      localIntent.putExtra("product_order_total_price_key", i1);
    }
    for (;;)
    {
      localIntent.putExtra("product_order_ids", this.a);
      localIntent.putExtra("product_order_remind_type_key", 1);
      com.xiaoenai.app.utils.f.a.c(" success = {} orderIds = {}", new Object[] { Boolean.valueOf(paramBoolean), this.a });
      startActivity(localIntent);
      overridePendingTransition(2130968606, 2130968607);
      d(this.b.getCurrentItem());
      if (paramBoolean)
      {
        if (this.b.getCurrentItem() != 2) {
          this.b.setCurrentItem(2, true);
        }
        d(this.b.getCurrentItem());
      }
      this.M = null;
      return;
      localIntent.putExtra("order_state", 0);
      break;
      label251:
      i1 = this.M.getSku().getPrice() * this.M.getCount();
      break label99;
      label273:
      localIntent.putExtra("product_order_total_price_key", this.H);
    }
  }
  
  private void c()
  {
    this.b = ((ViewPager)findViewById(2131559906));
    this.y = ((RelativeLayout)findViewById(2131559887));
    this.z = ((RelativeLayout)findViewById(2131559890));
    this.A = ((RelativeLayout)findViewById(2131559893));
    this.B = ((RelativeLayout)findViewById(2131559896));
    this.C = ((RelativeLayout)findViewById(2131559899));
    this.D = ((RelativeLayout)findViewById(2131559902));
    this.i = ((TextView)findViewById(2131559888));
    this.k = ((TextView)findViewById(2131559891));
    this.n = ((TextView)findViewById(2131559894));
    this.s = ((TextView)findViewById(2131559897));
    this.u = ((TextView)findViewById(2131559900));
    this.w = ((TextView)findViewById(2131559903));
    this.j = ((ImageView)findViewById(2131559889));
    this.l = ((ImageView)findViewById(2131559892));
    this.o = ((ImageView)findViewById(2131559895));
    this.t = ((ImageView)findViewById(2131559898));
    this.v = ((ImageView)findViewById(2131559901));
    this.x = ((ImageView)findViewById(2131559904));
    this.E = ((RelativeLayout)findViewById(2131559907));
    this.F = ((TextView)findViewById(2131559908));
    this.G = ((Button)findViewById(2131559909));
    this.I = ((LinearLayout)findViewById(2131559910));
    this.J = ((ImageView)findViewById(2131559911));
    this.K = ((TextView)findViewById(2131559912));
    this.G.setSelected(false);
    a(this.H);
    this.m = new j(this, this.O);
    this.b.setAdapter(this.m);
  }
  
  private void c(int paramInt)
  {
    int i6 = 0;
    this.I.setVisibility(8);
    this.E.setVisibility(8);
    boolean bool1;
    boolean bool2;
    label36:
    boolean bool3;
    label44:
    boolean bool4;
    label52:
    boolean bool5;
    label60:
    boolean bool6;
    label68:
    int i1;
    label75:
    int i2;
    label82:
    int i3;
    label90:
    int i4;
    label98:
    int i5;
    if (paramInt == 0)
    {
      bool1 = true;
      if (paramInt != 1) {
        break label232;
      }
      bool2 = true;
      if (paramInt != 2) {
        break label238;
      }
      bool3 = true;
      if (paramInt != 3) {
        break label244;
      }
      bool4 = true;
      if (paramInt != 4) {
        break label250;
      }
      bool5 = true;
      if (paramInt != 5) {
        break label256;
      }
      bool6 = true;
      if (!bool1) {
        break label262;
      }
      i1 = 0;
      if (!bool2) {
        break label267;
      }
      i2 = 0;
      if (!bool3) {
        break label272;
      }
      i3 = 0;
      if (!bool4) {
        break label278;
      }
      i4 = 0;
      if (!bool5) {
        break label284;
      }
      i5 = 0;
      label106:
      if (!bool6) {
        break label290;
      }
    }
    for (;;)
    {
      this.i.setSelected(bool1);
      this.j.setVisibility(i1);
      this.k.setSelected(bool2);
      this.l.setVisibility(i2);
      this.n.setSelected(bool3);
      this.o.setVisibility(i3);
      this.s.setSelected(bool4);
      this.t.setVisibility(i4);
      this.u.setSelected(bool5);
      this.v.setVisibility(i5);
      this.w.setSelected(bool6);
      this.x.setVisibility(i6);
      this.b.setCurrentItem(paramInt);
      return;
      bool1 = false;
      break;
      label232:
      bool2 = false;
      break label36;
      label238:
      bool3 = false;
      break label44;
      label244:
      bool4 = false;
      break label52;
      label250:
      bool5 = false;
      break label60;
      label256:
      bool6 = false;
      break label68;
      label262:
      i1 = 4;
      break label75;
      label267:
      i2 = 4;
      break label82;
      label272:
      i3 = 4;
      break label90;
      label278:
      i4 = 4;
      break label98;
      label284:
      i5 = 4;
      break label106;
      label290:
      i6 = 4;
    }
  }
  
  private void d()
  {
    com.xiaoenai.app.classes.common.a.a.a().a(833L, new ce(this));
    com.xiaoenai.app.classes.common.a.a.a().a(835L, new cf(this));
  }
  
  private void d(int paramInt)
  {
    Xiaoenai.j().a(new cb(this, paramInt), 200L);
  }
  
  private void e(int paramInt)
  {
    this.m.b(paramInt);
  }
  
  private void f()
  {
    this.b.setOnPageChangeListener(new cg(this));
    this.y.setOnClickListener(new ch(this));
    this.z.setOnClickListener(new ci(this));
    this.A.setOnClickListener(new cj(this));
    this.B.setOnClickListener(new ck(this));
    this.C.setOnClickListener(new cl(this));
    this.G.setOnClickListener(new by(this));
    this.D.setOnClickListener(new bz(this));
    this.g.setRightButtonClickListener(new ca(this));
  }
  
  private a.a g()
  {
    return new cc(this);
  }
  
  public int a()
  {
    return 2130903347;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.xiaoenai.app.utils.f.a.c("resultCode {} {} {}", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    if (paramInt2 == -1)
    {
      if (paramInt1 != 152) {
        break label59;
      }
      d(this.b.getCurrentItem());
    }
    label59:
    while (paramInt1 != 834) {
      return;
    }
    h.a(this, 2131101427, 1500L);
    d(4);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c();
    f();
    paramBundle = getIntent();
    if (paramBundle != null) {
      this.L = paramBundle.getIntExtra("order_index_key", 0);
    }
    c(this.L);
    d();
    d(this.L);
    this.c = new com.xiaoenai.app.classes.street.pay.a.a(this, g());
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.m.a();
    com.xiaoenai.app.classes.common.a.a.a().a(833L);
    com.xiaoenai.app.classes.common.a.a.a().a(835L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\StreetOrderActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */