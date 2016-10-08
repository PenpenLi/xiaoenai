package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.utils.e;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.widgets.ax;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ai
  extends b
{
  private TextView p = null;
  private View.OnClickListener q = new aj(this);
  
  public ai(Context paramContext)
  {
    super(paramContext);
    this.f = 11;
    this.j = a();
    b();
    super.d();
    c();
  }
  
  private void r()
  {
    this.a.D.f = "success";
    k();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    j();
    this.a.O = g.c(paramJSONObject, "open_rules");
    if ((this.a.O == null) || (this.a.O.length() <= 0))
    {
      b(2);
      return;
    }
    d(10);
  }
  
  protected final void b()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    ax localax = new ax(getContext(), this.a.v, this);
    localLayoutParams.addRule(13, -1);
    this.j.addView(localax, localLayoutParams);
  }
  
  protected final void c()
  {
    int i = a.d;
    Object localObject1 = new LinearLayout(this.d);
    ((LinearLayout)localObject1).setBackgroundColor(-1114114);
    ((LinearLayout)localObject1).setOrientation(1);
    ((LinearLayout)localObject1).setPadding(0, i, 0, i);
    ((LinearLayout)localObject1).setId(localObject1.hashCode());
    Object localObject2 = new TextView(this.d);
    ((TextView)localObject2).setText(this.a.w);
    ((TextView)localObject2).setTextSize(24.0F);
    ((TextView)localObject2).setTextColor(-15365480);
    ((TextView)localObject2).setGravity(1);
    ((TextView)localObject2).getPaint().setFakeBoldText(true);
    ((LinearLayout)localObject1).addView((View)localObject2);
    localObject2 = new LinearLayout(this.d);
    ((LinearLayout)localObject2).setOrientation(0);
    ((LinearLayout)localObject2).setBackgroundColor(-6958338);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, 2);
    localLayoutParams.addRule(14, -1);
    int j = a.d;
    localLayoutParams.bottomMargin = j;
    localLayoutParams.topMargin = j;
    ((LinearLayout)localObject1).addView((View)localObject2);
    localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    this.l.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new LinearLayout(this.d);
    ((LinearLayout)localObject2).setPadding(i, i, i, i);
    ((LinearLayout)localObject2).setOrientation(1);
    ((LinearLayout)localObject2).setId(localObject2.hashCode());
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(3, ((LinearLayout)localObject1).getId());
    this.l.addView((View)localObject2, localLayoutParams);
    localObject1 = new TextView(this.d);
    ((TextView)localObject1).setTextSize(18.0F);
    ((TextView)localObject1).setText(this.a.N);
    ((TextView)localObject1).setTextColor(-10066330);
    ((TextView)localObject1).setGravity(3);
    ((LinearLayout)localObject2).addView((View)localObject1, new RelativeLayout.LayoutParams(-1, -2));
    this.p = new TextView(this.d);
    this.p.setText(com.unionpay.mobile.android.languages.c.by.E);
    this.p.setTextSize(22.0F);
    this.p.setTextColor(e.a(-1, -730710, -730710, 58791));
    this.p.setGravity(17);
    this.p.setOnClickListener(this.q);
    i = a.n;
    localObject1 = this.c.a(2008);
    this.p.setBackgroundDrawable((Drawable)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(-1, i);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, ((LinearLayout)localObject2).getId());
    ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = a.b;
    ((RelativeLayout.LayoutParams)localObject1).topMargin = a.b;
    i = a.d;
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = i;
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = i;
    this.l.addView(this.p, (ViewGroup.LayoutParams)localObject1);
  }
  
  public final void l()
  {
    r();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\mobile\android\nocard\views\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */