package com.xiaoenai.app.classes.street;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.xiaoenai.app.classes.street.d.ay;
import com.xiaoenai.app.classes.street.d.bm;
import com.xiaoenai.app.classes.street.model.Order;
import com.xiaoenai.app.classes.street.model.Reviews;
import com.xiaoenai.app.classes.street.widget.StreetProductInfoLayout;
import com.xiaoenai.app.classes.street.widget.ba;
import com.xiaoenai.app.net.ae;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.utils.ab;

public class StreetOrderReviewsActivity
  extends StreetBaseActivity
{
  private StreetProductInfoLayout a;
  private LinearLayout b;
  private ay c;
  private Order i;
  private Button j;
  private Reviews[] k = new Reviews[4];
  
  private void a(String paramString, int paramInt)
  {
    Object localObject1 = new Reviews();
    ((Reviews)localObject1).setTitle(paramString);
    ((Reviews)localObject1).setVote(0);
    this.k[paramInt] = localObject1;
    Object localObject2 = new ba(this);
    paramString = new bm(((ba)localObject2).a(), (Reviews)localObject1);
    this.b.addView(((ba)localObject2).a());
    if (paramInt != 3)
    {
      localObject1 = new View(this);
      localObject2 = new LinearLayout.LayoutParams(-1, 1);
      ((LinearLayout.LayoutParams)localObject2).leftMargin = ab.a(11.0F);
      ((LinearLayout.LayoutParams)localObject2).rightMargin = ab.a(11.0F);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((View)localObject1).setBackgroundColor(getResources().getColor(2131493128));
      this.b.addView((View)localObject1);
    }
    paramString.b();
  }
  
  private void c()
  {
    this.a = ((StreetProductInfoLayout)findViewById(2131559952));
    this.b = ((LinearLayout)findViewById(2131559954));
    d();
    if (this.i != null)
    {
      this.c = new ay(this.a, this.i);
      this.c.a();
    }
    this.j = ((Button)findViewById(2131559956));
  }
  
  private void d()
  {
    a(getString(2131101345), 0);
    a(getString(2131101351), 1);
    a(getString(2131101352), 2);
    a(getString(2131101353), 3);
  }
  
  private void f()
  {
    this.j.setOnClickListener(new dc(this));
    this.a.setOnClickListener(new dd(this));
  }
  
  private void g()
  {
    if (!isFinishing()) {
      a(null);
    }
    new ae(new de(this, this)).a(this.i.getId(), this.k[0].getVote(), this.k[1].getVote(), this.k[2].getVote(), this.k[3].getVote());
  }
  
  private String h()
  {
    int n = 0;
    int i1 = 1;
    int m = 0;
    while (m < this.k.length)
    {
      if (this.k[m].getVote() <= 0) {
        i1 = 0;
      }
      n += this.k[m].getVote();
      m += 1;
    }
    if (n == 0) {
      return getString(2131101484);
    }
    if (i1 == 0) {
      return getString(2131101484);
    }
    return "";
  }
  
  private void i()
  {
    setResult(-1);
    finish();
  }
  
  private void j()
  {
    new k(this).a(2131101481, 2131100898, new df(this), 2131099973, new dg(this));
  }
  
  public int a()
  {
    return 2130903352;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.i = ((Order)getIntent().getParcelableExtra("street_order_key"));
    c();
    f();
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
  
  public void r()
  {
    int m = 0;
    int n = 0;
    while (m < this.k.length)
    {
      n += this.k[m].getVote();
      m += 1;
    }
    if (n > 0)
    {
      j();
      return;
    }
    super.r();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\StreetOrderReviewsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */