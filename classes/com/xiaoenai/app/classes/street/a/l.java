package com.xiaoenai.app.classes.street.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FixedFragmentStatePagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.DirectionalViewPager;
import com.xiaoenai.app.classes.street.StreetProductDetailActivity.b;
import com.xiaoenai.app.classes.street.d.aq;
import com.xiaoenai.app.classes.street.model.ProductInfo;
import com.xiaoenai.app.classes.street.model.SkuProp;
import com.xiaoenai.app.classes.street.widget.ad;
import com.xiaoenai.app.widget.PullToRefreshScrollViewEx;
import com.xiaoenai.app.widget.WebViewInsideViewPager;
import org.json.JSONObject;

public class l
  extends FixedFragmentStatePagerAdapter
{
  private Context a = null;
  private int b = 0;
  private StreetProductDetailActivity.b c = null;
  private ad d = null;
  private ad e = null;
  private aq f = null;
  private ProductInfo g = null;
  
  public l(FragmentManager paramFragmentManager, Context paramContext, StreetProductDetailActivity.b paramb)
  {
    super(paramFragmentManager);
    this.a = paramContext;
    this.c = paramb;
    this.f = new aq(paramContext, paramb);
    c();
  }
  
  private void c()
  {
    this.c.a.setOnPageChangeListener(new m(this));
    this.c.a.setOnInterceptTouchListener(new n(this));
  }
  
  private PullToRefreshScrollViewEx d()
  {
    if (this.d != null) {
      return this.d.q();
    }
    return null;
  }
  
  private WebViewInsideViewPager e()
  {
    if (this.e != null) {
      return this.e.r();
    }
    return null;
  }
  
  public ProductInfo a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      ProductInfo localProductInfo = new ProductInfo(paramJSONObject);
      SkuProp[] arrayOfSkuProp = localProductInfo.getSkuProps();
      paramJSONObject = localProductInfo;
      if (arrayOfSkuProp != null)
      {
        paramJSONObject = localProductInfo;
        if (localProductInfo.getSkus() != null)
        {
          int j = arrayOfSkuProp.length;
          int i = 0;
          for (;;)
          {
            paramJSONObject = localProductInfo;
            if (i >= j) {
              break;
            }
            arrayOfSkuProp[i].setContainsValuesMap(localProductInfo.getSkus());
            i += 1;
          }
        }
      }
    }
    else
    {
      paramJSONObject = null;
    }
    return paramJSONObject;
  }
  
  public void a()
  {
    if (d() != null) {
      d().k();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.d != null) {
      this.d.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(ProductInfo paramProductInfo)
  {
    if (paramProductInfo != null)
    {
      this.g = paramProductInfo;
      notifyDataSetChanged();
      this.f.a(this.g);
      this.f.b(this.g);
    }
  }
  
  public void b()
  {
    if (this.f != null)
    {
      this.f.a();
      this.f = null;
    }
  }
  
  public int getCount()
  {
    return 2;
  }
  
  public Fragment getItem(int paramInt)
  {
    Bundle localBundle;
    if (paramInt == 0)
    {
      if (this.d == null)
      {
        this.d = new ad();
        localBundle = new Bundle();
        localBundle.putInt("index_key", 0);
        this.d.setArguments(localBundle);
        this.f.a(this.d);
      }
      return this.d;
    }
    if (this.e == null)
    {
      this.e = new ad();
      localBundle = new Bundle();
      localBundle.putInt("index_key", 1);
      this.e.setArguments(localBundle);
      this.f.b(this.e);
    }
    return this.e;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return super.getItemPosition(paramObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */