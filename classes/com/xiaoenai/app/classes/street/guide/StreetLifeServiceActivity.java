package com.xiaoenai.app.classes.street.guide;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.PopupWindow;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.nb.android.trade.AliTradeSDK;
import com.alibaba.nb.android.trade.uibridge.AliTradeMyCartsPage;
import com.alibaba.nb.android.trade.uibridge.AliTradeMyOrdersPage;
import com.alibaba.nb.android.trade.uibridge.IAliTradeService;
import com.alibaba.sdk.android.AlibabaHelper;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.common.widget.NewViewPagerIndicator;
import com.xiaoenai.app.classes.home.a.k;
import com.xiaoenai.app.classes.home.model.HomeDiscoverItem;
import com.xiaoenai.app.classes.settings.bj;
import com.xiaoenai.app.classes.street.StreetOrderActivity;
import com.xiaoenai.app.classes.street.widget.StreetOrderMenu;
import com.xiaoenai.app.utils.ae;
import com.xiaoenai.app.widget.CustomViewPager;
import com.xiaoenai.app.widget.TitleBarView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class StreetLifeServiceActivity
  extends TitleBarActivity
{
  private StreetOrderMenu a;
  private PopupWindow b;
  private com.xiaoenai.app.classes.street.a.f c;
  private List<HomeDiscoverItem> i;
  private int j = 0;
  private boolean k = true;
  @BindView(2131559885)
  CustomViewPager mLifeServicePager;
  @BindView(2131559882)
  ImageView mProfile;
  @BindView(2131559884)
  NewViewPagerIndicator mViewPagerIndicator;
  
  private void a(int paramInt)
  {
    a(paramInt, this.mViewPagerIndicator.getCurrentPosition());
    this.g.setTitle(this.c.getPageTitle(paramInt).toString());
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((this.i != null) && (this.i.size() > 0)) {
      if (paramInt2 < 0) {
        break label78;
      }
    }
    label78:
    for (HomeDiscoverItem localHomeDiscoverItem1 = (HomeDiscoverItem)this.i.get(paramInt2);; localHomeDiscoverItem1 = null)
    {
      HomeDiscoverItem localHomeDiscoverItem2 = (HomeDiscoverItem)this.i.get(paramInt1);
      if ((localHomeDiscoverItem1 != null) && (localHomeDiscoverItem2 != null)) {
        com.xiaoenai.app.stat.j.a().a(this, localHomeDiscoverItem1.getClickUrl(), localHomeDiscoverItem2.getClickUrl());
      }
      return;
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("module_id"))
    {
      String str1 = paramJSONObject.optString("module_id");
      String str2 = paramJSONObject.optString("title");
      HomeDiscoverItem localHomeDiscoverItem = new HomeDiscoverItem();
      localHomeDiscoverItem.setClickUrl(str1 + "?params=" + paramJSONObject.toString());
      localHomeDiscoverItem.setTitle(str2);
      this.i.add(localHomeDiscoverItem);
    }
  }
  
  private void b(String paramString)
  {
    if (!ae.a(paramString)) {}
    for (;;)
    {
      int m;
      try
      {
        paramString = new JSONObject(paramString);
        if (!paramString.has("module")) {
          break label112;
        }
        str = paramString.optString("module");
        if (ae.a(str)) {
          break label112;
        }
        if (this.i.size() != 0) {
          break label113;
        }
        a(paramString);
        return;
      }
      catch (JSONException paramString)
      {
        String str;
        paramString.printStackTrace();
        return;
      }
      if (m < this.i.size())
      {
        if (((HomeDiscoverItem)this.i.get(m)).getModule().equals(str))
        {
          this.j = m;
          return;
        }
        m += 1;
      }
      else
      {
        label112:
        return;
        label113:
        m = 0;
      }
    }
  }
  
  private void c()
  {
    this.a = new StreetOrderMenu(this);
    this.b = new PopupWindow(this.a, -2, -2, true);
    this.b.setOutsideTouchable(true);
    this.b.setBackgroundDrawable(getResources().getDrawable(2130839016));
    this.c = new com.xiaoenai.app.classes.street.a.f(this);
    this.mLifeServicePager.setAdapter(this.c);
  }
  
  private void c(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("street_author_type", paramInt);
    localIntent.setClass(this, StreetTaeAuthorizationActivity.class);
    startActivity(localIntent);
    overridePendingTransition(2130968604, 2130968605);
  }
  
  private void d()
  {
    this.a.setOnManuClckListener(new c(this));
    this.mViewPagerIndicator.setListener(new d(this));
  }
  
  private void f()
  {
    g();
    if ((this.k) && (this.i != null) && (this.i.size() > 0))
    {
      this.mViewPagerIndicator.setVisibility(0);
      return;
    }
    this.mLifeServicePager.setPagingEnabled(false);
  }
  
  private void g()
  {
    this.c.a(this.i);
    this.mViewPagerIndicator.a(this.mLifeServicePager, this.j);
    if (this.c.getPageTitle(this.j) != null) {
      this.g.setTitle(this.c.getPageTitle(this.j).toString());
    }
  }
  
  private void h()
  {
    if (this.k)
    {
      List localList = k.a().c();
      com.xiaoenai.app.utils.f.a.c(" lifeServiceItemList {} ", new Object[] { Integer.valueOf(localList.size()) });
      if ((localList != null) && (localList.size() > 0)) {
        this.i = localList;
      }
    }
    i();
  }
  
  private void i()
  {
    Intent localIntent = getIntent();
    if (localIntent != null) {
      b(localIntent.getStringExtra("param"));
    }
  }
  
  private void j()
  {
    if (bj.a().b())
    {
      k();
      return;
    }
    c(0);
  }
  
  private void k()
  {
    ((IAliTradeService)AliTradeSDK.getService(IAliTradeService.class)).show(this, new AliTradeMyCartsPage(), AlibabaHelper.creatAliTradeShowParams(), null, null, new e(this));
  }
  
  private void o()
  {
    if (bj.a().b())
    {
      p();
      return;
    }
    c(1);
  }
  
  private void p()
  {
    ((IAliTradeService)AliTradeSDK.getService(IAliTradeService.class)).show(this, new AliTradeMyOrdersPage(0, true), AlibabaHelper.creatAliTradeShowParams(), null, null, new f(this));
  }
  
  private void q()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, StreetOrderActivity.class);
    startActivity(localIntent);
    overridePendingTransition(2130968604, 2130968605);
  }
  
  public int a()
  {
    return 2130903345;
  }
  
  @OnClick({2131559883})
  void cart()
  {
    j();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.i = new ArrayList();
    h();
    ButterKnife.bind(this);
    c();
    d();
    f();
  }
  
  protected void onDestroy()
  {
    if (this.c != null)
    {
      this.c.a();
      this.c = null;
    }
    super.onDestroy();
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if (paramBundle != null)
    {
      this.j = paramBundle.getInt("index");
      this.k = paramBundle.getBoolean("isShowIndicator");
      paramBundle = paramBundle.getString("lifeServiceItemList");
      if (!TextUtils.isEmpty(paramBundle)) {
        this.i = ((List)new com.google.gson.j().a(paramBundle, new a(this).getType()));
      }
    }
    g();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("index", this.mViewPagerIndicator.getCurrentPosition());
    paramBundle.putBoolean("isShowIndicator", this.k);
    paramBundle.putString("lifeServiceItemList", new com.google.gson.j().a(this.i, new b(this).getType()));
  }
  
  @OnClick({2131559882})
  void profile()
  {
    if (this.b.isShowing())
    {
      this.b.dismiss();
      return;
    }
    this.b.showAsDropDown(this.mProfile);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\guide\StreetLifeServiceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */