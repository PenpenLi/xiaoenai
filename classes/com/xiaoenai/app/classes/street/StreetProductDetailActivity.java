package com.xiaoenai.app.classes.street;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.DirectionalViewPager;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import com.xiaoenai.app.classes.home.HomeActivity;
import com.xiaoenai.app.classes.street.a.l;
import com.xiaoenai.app.classes.street.model.ProductInfo;
import com.xiaoenai.app.classes.street.widget.StreetCartButton;
import com.xiaoenai.app.classes.street.widget.StreetPayBottomView;
import com.xiaoenai.app.classes.street.widget.am;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.utils.f.a;
import com.xiaoenai.app.widget.TitleBarView;
import org.json.JSONException;
import org.json.JSONObject;

public class StreetProductDetailActivity
  extends StreetBaseActivity
{
  private RelativeLayout a = null;
  private l b = null;
  private ProgressView c = null;
  private b i = new b();
  private int j = 0;
  private int k = 0;
  private boolean l = false;
  private String m = null;
  private StreetCartButton n = null;
  private Handler o = new Handler();
  private int s = 0;
  
  private void d()
  {
    Intent localIntent = getIntent();
    String str1;
    if (localIntent != null)
    {
      str1 = localIntent.getStringExtra("param");
      if (com.xiaoenai.app.utils.ae.a(str1)) {
        break label164;
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(str1);
        if (localJSONObject != null)
        {
          String str2 = localJSONObject.optString("product_id");
          if (com.xiaoenai.app.utils.ae.a(str2)) {
            continue;
          }
          this.j = Integer.parseInt(str2);
          str2 = localJSONObject.optString("rush_id");
          if (com.xiaoenai.app.utils.ae.a(str2)) {
            continue;
          }
          this.k = Integer.parseInt(str2);
        }
      }
      catch (JSONException localJSONException)
      {
        JSONObject localJSONObject;
        localJSONException.printStackTrace();
        continue;
        this.k = localJSONException.optInt("rush_id");
        continue;
      }
      this.m = localIntent.getStringExtra("from");
      a.c("product_id = {} rush_id = {} param = {}", new Object[] { Integer.valueOf(this.j), Integer.valueOf(this.k), str1 });
      return;
      this.j = localJSONObject.optInt("product_id");
      continue;
      label164:
      this.j = localIntent.getIntExtra("product_id", 0);
      this.k = localIntent.getIntExtra("rush_id", 0);
    }
  }
  
  private void f()
  {
    if ((this.m != null) && (this.m.length() > 0))
    {
      if (!this.m.equalsIgnoreCase("notification")) {
        break label41;
      }
      this.g.a(2130839000, 2131100897);
    }
    label41:
    while ((!this.m.equalsIgnoreCase("push")) && (!this.m.equalsIgnoreCase("ads"))) {
      return;
    }
    this.g.a(2130839000, 0);
  }
  
  private void g()
  {
    this.i.a = ((DirectionalViewPager)findViewById(2131559973));
    this.i.b = ((StreetPayBottomView)findViewById(2131559974));
    this.i.b.setVisibility(4);
    this.i.a.setOrientation(1);
    this.i.a.setScrollable(false);
    this.i.a.setSaveEnabled(false);
  }
  
  public int a()
  {
    return 2130903355;
  }
  
  public void a(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.l) {
      return;
    }
    try
    {
      if (this.l) {
        return;
      }
    }
    finally {}
    this.l = true;
    new com.xiaoenai.app.net.ae(new dh(this, this, paramBoolean)).b(this.j, this.k);
  }
  
  public void a_(int paramInt)
  {
    setResult(this.s);
    super.a_(paramInt);
  }
  
  public void c()
  {
    a(false);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (10 != paramInt1) {
        break label36;
      }
      if (this.b != null) {
        this.b.a(paramInt1, paramInt2, paramIntent);
      }
    }
    return;
    label36:
    c();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    d();
    this.a = ((RelativeLayout)findViewById(2131558670));
    this.c = ((ProgressView)findViewById(2131558669));
    if (paramBundle != null)
    {
      this.j = paramBundle.getInt("product_id");
      this.k = paramBundle.getInt("rush_id");
    }
    a.c("mProductId = {}", new Object[] { Integer.valueOf(this.j) });
    a.c("mRushId = {}", new Object[] { Integer.valueOf(this.k) });
    if (this.j > 0)
    {
      this.a.setVisibility(4);
      this.c.a();
      g();
      f();
      c();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.i != null) && (this.i.b != null)) {
      this.i.b.a();
    }
    if (this.b != null)
    {
      this.b.b();
      this.b = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      r();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if (paramBundle != null)
    {
      this.j = paramBundle.getInt("product_id");
      this.k = paramBundle.getInt("rush_id");
    }
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putInt("product_id", this.j);
    paramBundle.putInt("rush_id", this.k);
    paramBundle.setClassLoader(getClass().getClassLoader());
    super.onSaveInstanceState(paramBundle);
  }
  
  public void r()
  {
    if ((this.m != null) && ((this.m.equalsIgnoreCase("ads")) || (this.m.equalsIgnoreCase("from_mall_detail"))))
    {
      Intent localIntent = new Intent();
      localIntent.setClass(this, HomeActivity.class);
      startActivity(localIntent);
    }
    super.r();
  }
  
  private class a
    extends AsyncTask<JSONObject, Void, ProductInfo>
  {
    private a() {}
    
    protected ProductInfo a(JSONObject... paramVarArgs)
    {
      paramVarArgs = paramVarArgs[0];
      if (paramVarArgs.optBoolean("success", false)) {
        return StreetProductDetailActivity.b(StreetProductDetailActivity.this).a(paramVarArgs.optJSONObject("data"));
      }
      return null;
    }
    
    protected void a(ProductInfo paramProductInfo)
    {
      super.onPostExecute(paramProductInfo);
      if (!StreetProductDetailActivity.this.isFinishing())
      {
        if ((StreetProductDetailActivity.c(StreetProductDetailActivity.this) != null) && (StreetProductDetailActivity.c(StreetProductDetailActivity.this).c == null)) {
          StreetProductDetailActivity.c(StreetProductDetailActivity.this).c = new am(StreetProductDetailActivity.this);
        }
        if (StreetProductDetailActivity.a(StreetProductDetailActivity.this) != null) {
          StreetProductDetailActivity.a(StreetProductDetailActivity.this).b();
        }
        if (StreetProductDetailActivity.b(StreetProductDetailActivity.this) != null)
        {
          StreetProductDetailActivity.b(StreetProductDetailActivity.this).a();
          StreetProductDetailActivity.b(StreetProductDetailActivity.this).a(paramProductInfo);
        }
        if ((StreetProductDetailActivity.c(StreetProductDetailActivity.this) != null) && (StreetProductDetailActivity.c(StreetProductDetailActivity.this).b != null)) {
          StreetProductDetailActivity.c(StreetProductDetailActivity.this).b.setVisibility(0);
        }
        if (StreetProductDetailActivity.d(StreetProductDetailActivity.this) != null) {
          StreetProductDetailActivity.d(StreetProductDetailActivity.this).setVisibility(0);
        }
        StreetProductDetailActivity.a(StreetProductDetailActivity.this, false);
      }
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
      if (StreetProductDetailActivity.b(StreetProductDetailActivity.this) == null)
      {
        StreetProductDetailActivity.a(StreetProductDetailActivity.this, new l(StreetProductDetailActivity.this.getSupportFragmentManager(), StreetProductDetailActivity.this, StreetProductDetailActivity.c(StreetProductDetailActivity.this)));
        StreetProductDetailActivity.c(StreetProductDetailActivity.this).a.setAdapter(StreetProductDetailActivity.b(StreetProductDetailActivity.this));
      }
    }
  }
  
  public class b
  {
    public DirectionalViewPager a = null;
    public StreetPayBottomView b = null;
    public am c = null;
    
    public b() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\StreetProductDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */