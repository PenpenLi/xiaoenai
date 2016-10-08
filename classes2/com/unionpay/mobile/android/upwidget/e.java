package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.utils.d;
import java.util.ArrayList;

public final class e
  extends LinearLayout
{
  private Context a;
  private c b;
  private ArrayList<AdapterView.OnItemClickListener> c = new ArrayList();
  private ArrayList<View.OnClickListener> d = new ArrayList();
  private AdapterView.OnItemClickListener e = new f(this);
  private View.OnClickListener f = new g(this);
  
  public e(Context paramContext, c paramc)
  {
    super(paramContext);
    this.a = paramContext;
    this.b = paramc;
    paramContext = new RelativeLayout(this.a);
    Object localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
    paramc = new LinearLayout(this.a);
    paramc.setOrientation(1);
    paramc.setBackgroundColor(-1);
    paramc.setId(paramc.hashCode());
    paramContext.addView(paramc, (ViewGroup.LayoutParams)localObject);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    LinearLayout localLinearLayout = new LinearLayout(this.a);
    ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(2, paramc.getId());
    paramContext.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject);
    localLinearLayout.setOnClickListener(this.f);
    int i = d.a(this.a, 1.0F);
    localObject = new LinearLayout.LayoutParams(-1, -2);
    int j = b.a;
    ((LinearLayout.LayoutParams)localObject).bottomMargin = j;
    ((LinearLayout.LayoutParams)localObject).topMargin = j;
    localObject = new LinearLayout.LayoutParams(-1, i);
    localLinearLayout = new LinearLayout(this.a);
    localLinearLayout.setBackgroundColor(-3355444);
    paramc.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject);
    new LinearLayout.LayoutParams(-1, -2);
    localObject = new ListView(this.a);
    ((ListView)localObject).setDivider(null);
    ((ListView)localObject).setAdapter(this.b);
    ((ListView)localObject).setOnItemClickListener(this.e);
    new LinearLayout.LayoutParams(-1, -2);
    paramc.addView((View)localObject);
    addView(paramContext);
  }
  
  public final void a(View.OnClickListener paramOnClickListener)
  {
    this.d.add(paramOnClickListener);
  }
  
  public final void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.c.add(paramOnItemClickListener);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\upwidget\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */