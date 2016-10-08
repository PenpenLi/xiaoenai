package com.xiaoenai.app.classes.street;

import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.classes.street.model.BuyInfo;
import com.xiaoenai.app.classes.street.model.BuyProduct;
import com.xiaoenai.app.classes.street.model.BuyProducts;
import com.xiaoenai.app.classes.street.model.Contact;
import com.xiaoenai.app.classes.street.pay.StreetPayBaseActivity;
import com.xiaoenai.app.classes.street.pay.a.a.a;
import com.xiaoenai.app.classes.street.pay.a.p;
import com.xiaoenai.app.classes.street.widget.StreetBuyProductView;
import com.xiaoenai.app.classes.street.widget.StreetPayListItemView;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.ae;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.ui.component.view.ProgressView;
import org.json.JSONArray;
import org.json.JSONObject;

public class StreetProductOrderActivity
  extends StreetPayBaseActivity
{
  private ProgressView A = null;
  private Contact B = null;
  private String C = null;
  private boolean D = true;
  private Button E = null;
  private boolean F = false;
  private BuyInfo[] G = null;
  private BuyProducts H = null;
  private long[] I;
  private RelativeLayout a = null;
  private LinearLayout b = null;
  private TextView i = null;
  private TextView j = null;
  private TextView k = null;
  private TextView l = null;
  private RelativeLayout m = null;
  private RelativeLayout n = null;
  private StreetBuyProductView o = null;
  private LinearLayout s = null;
  private StreetPayListItemView t = null;
  private LinearLayout u = null;
  private StreetPayListItemView v = null;
  private StreetPayListItemView w = null;
  private StreetPayListItemView x = null;
  private TextView y = null;
  private long z = 0L;
  
  private void a(View paramView)
  {
    if (paramView == this.v)
    {
      this.w.setClickState(false);
      this.x.setClickState(false);
      this.v.setClickState(true);
    }
    do
    {
      return;
      if (paramView == this.w)
      {
        this.x.setClickState(false);
        this.v.setClickState(false);
        this.w.setClickState(true);
        return;
      }
    } while (paramView != this.x);
    this.v.setClickState(false);
    this.w.setClickState(false);
    this.x.setClickState(true);
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    com.xiaoenai.app.ui.a.g localg = new com.xiaoenai.app.ui.a.g(this);
    if ((paramString1 != null) && (paramString1.length() > 0) && (paramString2 != null) && (paramString2.length() > 0))
    {
      localg.a(paramString1);
      localg.a(paramString2);
    }
    for (;;)
    {
      localg.a(2131100898, new dj(this, paramBoolean));
      localg.show();
      return;
      localg.setTitle(2131101454);
      localg.a(2131101453);
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    com.xiaoenai.app.utils.f.a.c("address = {}", new Object[] { paramJSONObject });
    if ((paramJSONObject != null) && (paramJSONObject.optBoolean("success", false)))
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject("data");
      if (localJSONObject != null)
      {
        paramJSONObject = localJSONObject.optString("delivery_desc");
        localJSONObject = localJSONObject.optJSONObject("contact");
        com.xiaoenai.app.utils.f.a.c("delivery_desc = {}", new Object[] { paramJSONObject });
        this.C = paramJSONObject;
        if ((localJSONObject != null) && (localJSONObject.length() > 0))
        {
          com.xiaoenai.app.utils.f.a.c("contact = {}", new Object[] { localJSONObject });
          this.B = new Contact(localJSONObject);
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.F = true;
      localIntent = new Intent();
      localIntent.putExtra("street_address_add_or_edit_key", false);
      localIntent.setClass(this, StreetAddOrEditAddressActivity.class);
      startActivityForResult(localIntent, 1);
      overridePendingTransition(2130968604, 2130968605);
      return;
    }
    this.F = true;
    Intent localIntent = new Intent();
    localIntent.putExtra("street_address_is_selector_mode_key", true);
    localIntent.setClass(this, StreetAddressManagerActivity.class);
    startActivityForResult(localIntent, 2);
    overridePendingTransition(2130968604, 2130968605);
  }
  
  private void a(boolean paramBoolean, JSONObject paramJSONObject)
  {
    int i1 = 0;
    if (!paramBoolean)
    {
      l_();
      if (paramJSONObject == null)
      {
        h.c(this, 2131100335, 1500L);
        return;
      }
      com.xiaoenai.app.utils.f.a.c("data = {}", new Object[] { paramJSONObject });
      if (paramJSONObject != null)
      {
        i1 = paramJSONObject.optInt("code", 0);
        String str1 = paramJSONObject.optString("title");
        String str2 = paramJSONObject.optString("message");
        if (91000 == i1)
        {
          a(str1, str2, true);
          UserConfig.setInt("street_cart_count", 0);
          return;
        }
        if (91001 == i1)
        {
          a(str1, str2, false);
          UserConfig.setInt("street_cart_count", 0);
          return;
        }
        i1 = paramJSONObject.optInt("type", 0);
        if ((str1 != null) && (str1.length() > 0) && (str2 != null) && (str2.length() > 0))
        {
          paramJSONObject = new com.xiaoenai.app.net.c.a.g();
          if (i1 == 1)
          {
            paramJSONObject.a(this, str1, str2);
            return;
          }
          if (i1 == 2)
          {
            paramJSONObject.b(this, str1, str2);
            return;
          }
          if (i1 == 3)
          {
            paramJSONObject.c(this, str1, str2);
            return;
          }
          h.c(this, 2131100335, 1500L);
          return;
        }
        h.c(this, 2131100335, 1500L);
        return;
      }
      h.c(this, 2131100335, 1500L);
      return;
    }
    paramJSONObject = paramJSONObject.optJSONArray("order_ids");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      this.I = new long[paramJSONObject.length()];
      while (i1 < paramJSONObject.length())
      {
        this.I[i1] = paramJSONObject.optLong(i1);
        i1 += 1;
      }
      k();
      return;
    }
    l_();
    h.c(this, 2131101448, 1500L);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, long[] paramArrayOfLong)
  {
    com.xiaoenai.app.utils.f.a.c("isPay = {} success = {} order_ids = {}", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramArrayOfLong });
    Intent localIntent = new Intent();
    if (paramBoolean1) {
      if ((paramArrayOfLong != null) && (paramArrayOfLong.length == 1) && (this.G != null) && (this.G.length == 1))
      {
        localIntent.setClass(this, StreetOrderRemindActivity.class);
        if (paramBoolean2)
        {
          localIntent.putExtra("order_state", 1);
          localIntent.putExtra("product_order_id", paramArrayOfLong[0]);
          startActivity(localIntent);
        }
      }
    }
    while ((paramArrayOfLong == null) || (paramArrayOfLong.length <= 0)) {
      for (;;)
      {
        overridePendingTransition(2130968604, 2130968605);
        finish();
        return;
        localIntent.putExtra("order_state", 0);
        continue;
        localIntent.setClass(this, StreetOrderActivity.class);
        if (paramBoolean2) {
          localIntent.putExtra("order_index_key", 2);
        } else {
          localIntent.putExtra("order_index_key", 1);
        }
      }
    }
    localIntent.setClass(this, StreetOrderActivity.class);
    if (paramBoolean2) {
      localIntent.putExtra("order_index_key", 2);
    }
    for (;;)
    {
      startActivity(localIntent);
      break;
      localIntent.putExtra("order_index_key", 1);
    }
  }
  
  private void c()
  {
    Object localObject = this.H.getBuyProducts();
    int i2 = localObject.length;
    int i1 = 0;
    while (i1 < i2)
    {
      str = localObject[i1];
      long l1 = this.z;
      int i3 = str.getPrice();
      this.z = (str.getCount() * i3 + l1);
      i1 += 1;
    }
    localObject = getString(2131101450) + String.format("%.2f", new Object[] { Double.valueOf(this.z / 100.0D) });
    String str = String.format(getString(2131100780), new Object[] { localObject });
    SpannableString localSpannableString = new SpannableString(str);
    localSpannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131493038)), str.length() - ((String)localObject).length(), str.length(), 33);
    localSpannableString.setSpan(new AbsoluteSizeSpan(14, true), str.length() - ((String)localObject).length(), str.length(), 33);
    this.y.setText(localSpannableString);
    this.o.setProducts(this.H);
    if (User.isSingle()) {
      this.D = false;
    }
    this.t.setClickState(this.D);
    a(this.v);
  }
  
  private void d()
  {
    this.u = ((LinearLayout)findViewById(2131560024));
    this.v = new StreetPayListItemView(this);
    this.w = new StreetPayListItemView(this);
    this.x = new StreetPayListItemView(this);
    this.v.setItemIcon(2130838708);
    this.v.setItemText(getResources().getString(2131100764));
    this.w.setItemIcon(2130838706);
    this.w.setItemText(getResources().getString(2131100760));
    this.x.setItemIcon(2130838707);
    this.x.a(getResources().getString(2131100762), getResources().getString(2131100763));
    this.u.addView(this.v);
    this.u.addView(this.w);
    this.u.addView(this.x);
    this.s = ((LinearLayout)findViewById(2131560022));
    this.t = new StreetPayListItemView(this);
    this.t.setItemText(getResources().getString(2131100736));
    this.t.a();
    this.t.setVisibility(0);
    this.s.addView(this.t);
    this.n = ((RelativeLayout)findViewById(2131560009));
    this.n.setVisibility(0);
    this.b = ((LinearLayout)findViewById(2131560011));
    this.b.setVisibility(8);
    this.i = ((TextView)findViewById(2131560014));
    this.j = ((TextView)findViewById(2131560015));
    this.k = ((TextView)findViewById(2131560016));
    this.l = ((TextView)findViewById(2131560019));
    this.m = ((RelativeLayout)findViewById(2131560017));
    this.m.setVisibility(8);
    this.A = ((ProgressView)findViewById(2131558669));
    this.y = ((TextView)findViewById(2131560025));
    this.E = ((Button)findViewById(2131560026));
    this.o = ((StreetBuyProductView)findViewById(2131560023));
    if (User.isSingle()) {
      findViewById(2131559919).setVisibility(8);
    }
    for (;;)
    {
      this.t.setClickEnable(true);
      f();
      h();
      return;
      findViewById(2131559919).setVisibility(0);
    }
  }
  
  private void f()
  {
    this.v.setOnClickListener(new di(this));
    a(this.v);
    this.w.setOnClickListener(new dm(this));
    this.x.setOnClickListener(new dn(this));
    this.t.setOnClickListener(new do(this));
    this.n.setOnClickListener(new dp(this));
    this.b.setOnClickListener(new dq(this));
    findViewById(2131558826).setOnClickListener(new dr(this));
    this.E.setOnClickListener(new ds(this));
    this.c = new com.xiaoenai.app.classes.street.pay.a.a(this, j());
  }
  
  private String g()
  {
    if (this.v.getState()) {
      return "alipay";
    }
    if (this.w.getState()) {
      return "wx";
    }
    return "upacp";
  }
  
  private void h()
  {
    new ae(new dt(this, this)).a();
  }
  
  private void i()
  {
    if ((this.C != null) && (this.C.length() > 0))
    {
      this.m.setVisibility(0);
      this.l.setText(this.C);
      return;
    }
    this.m.setVisibility(8);
  }
  
  private a.a j()
  {
    return new dk(this);
  }
  
  private void k()
  {
    new ae(new dl(this, this)).f();
  }
  
  public int a()
  {
    return 2130903358;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.F) && (paramInt2 == -1)) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      this.F = false;
      return;
      paramIntent = (Contact)paramIntent.getParcelableExtra("street_contact_info_key");
      if ((paramIntent != null) && (paramIntent.getId() > 0))
      {
        this.B = paramIntent;
        this.i.setText(getString(2131100731) + paramIntent.getReceiver());
        this.j.setText(paramIntent.getPhone());
        this.k.setText(getString(2131100730) + paramIntent.getProvinceCityZone().replace(",", "") + paramIntent.getAddress());
        this.n.setVisibility(8);
        this.b.setVisibility(0);
        i();
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null) {}
    paramBundle = getIntent().getStringExtra("buy_info");
    com.xiaoenai.app.utils.f.a.c("data = {}", new Object[] { paramBundle });
    if ((paramBundle != null) && (paramBundle.length() > 0)) {
      this.H = new BuyProducts(paramBundle);
    }
    this.a = ((RelativeLayout)findViewById(2131558633));
    this.a.setVisibility(4);
    if ((this.H != null) && (this.H.getBuyProducts() != null) && (this.H.getBuyProducts().length > 0)) {
      d();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((4 == paramInt) && (this.B != null) && (!isFinishing()) && (this.e != null) && (this.e.isShowing()))
    {
      if ((this.c.b() != null) && (!(this.c.b() instanceof p))) {
        this.c.c();
      }
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if (paramBundle != null) {}
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    if ((this.B == null) || (this.H != null)) {}
    super.onSaveInstanceState(paramBundle);
  }
  
  private class a
    extends AsyncTask<JSONObject, Void, Integer>
  {
    private a() {}
    
    protected Integer a(JSONObject... paramVarArgs)
    {
      paramVarArgs = paramVarArgs[0];
      StreetProductOrderActivity.a(StreetProductOrderActivity.this, paramVarArgs);
      return null;
    }
    
    protected void a(Integer paramInteger)
    {
      super.onPostExecute(paramInteger);
      if (!StreetProductOrderActivity.this.isFinishing())
      {
        StreetProductOrderActivity.p(StreetProductOrderActivity.this);
        if ((StreetProductOrderActivity.f(StreetProductOrderActivity.this) == null) || (StreetProductOrderActivity.f(StreetProductOrderActivity.this).getId() <= 0)) {
          break label220;
        }
        StreetProductOrderActivity.q(StreetProductOrderActivity.this).setVisibility(8);
        StreetProductOrderActivity.b(StreetProductOrderActivity.this).setVisibility(0);
        StreetProductOrderActivity.r(StreetProductOrderActivity.this).setText(StreetProductOrderActivity.this.getString(2131101404) + StreetProductOrderActivity.f(StreetProductOrderActivity.this).getReceiver());
        StreetProductOrderActivity.s(StreetProductOrderActivity.this).setText(StreetProductOrderActivity.f(StreetProductOrderActivity.this).getPhone());
        StreetProductOrderActivity.t(StreetProductOrderActivity.this).setText(StreetProductOrderActivity.this.getString(2131101403) + StreetProductOrderActivity.f(StreetProductOrderActivity.this).getProvinceCityZone() + StreetProductOrderActivity.f(StreetProductOrderActivity.this).getAddress());
        StreetProductOrderActivity.u(StreetProductOrderActivity.this);
      }
      for (;;)
      {
        StreetProductOrderActivity.m(StreetProductOrderActivity.this).b();
        StreetProductOrderActivity.n(StreetProductOrderActivity.this).setVisibility(0);
        return;
        label220:
        StreetProductOrderActivity.q(StreetProductOrderActivity.this).setVisibility(0);
        StreetProductOrderActivity.b(StreetProductOrderActivity.this).setVisibility(8);
      }
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\StreetProductOrderActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */