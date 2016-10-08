package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.nocard.utils.f;
import com.unionpay.mobile.android.upviews.a.a;
import com.unionpay.mobile.android.upviews.a.b;
import com.unionpay.mobile.android.upwidget.UPScrollView;
import com.unionpay.mobile.android.upwidget.u;
import com.unionpay.mobile.android.widgets.ax;
import com.unionpay.mobile.android.widgets.m;
import org.json.JSONObject;

public final class af
  extends b
  implements a.b
{
  private TextView p = null;
  private View.OnClickListener q = null;
  private com.unionpay.mobile.android.upviews.a r = null;
  private int s = 0;
  
  public af(Context paramContext)
  {
    super(paramContext);
    this.f = 12;
    setBackgroundColor(-1052684);
    e();
  }
  
  public final void a(a.a parama) {}
  
  public final void a(JSONObject paramJSONObject)
  {
    switch (this.s)
    {
    default: 
      return;
    }
    this.b.c();
    f.c(this.a, paramJSONObject);
    int i = f.b(this.a, paramJSONObject);
    if (i != 0)
    {
      b(i);
      return;
    }
    if (this.r != null) {
      this.r.f();
    }
    d(13);
  }
  
  public final void a(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.p != null)
    {
      localTextView = this.p;
      if (paramBoolean) {
        break label24;
      }
    }
    label24:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localTextView.setEnabled(paramBoolean);
      return;
    }
  }
  
  protected final void b()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    Object localObject = com.unionpay.mobile.android.languages.c.by.m;
    localObject = new ax(this.d, (String)localObject, this);
    localLayoutParams.addRule(13, -1);
    this.j.addView((View)localObject, localLayoutParams);
  }
  
  public final void b(String paramString1, String paramString2) {}
  
  protected final void c()
  {
    boolean bool2 = true;
    this.n.a(this);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10, -1);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = com.unionpay.mobile.android.global.a.f;
    this.r = new com.unionpay.mobile.android.upviews.a(this.d, this.a.S, this);
    this.r.setOrientation(1);
    this.r.setId(this.r.hashCode());
    this.l.addView(this.r, (ViewGroup.LayoutParams)localObject1);
    localObject1 = u.a(this.d, this.a.T, this.c.a(1017));
    if (localObject1 != null)
    {
      ((u)localObject1).setId(localObject1.hashCode());
      ((u)localObject1).a(new ah(this, ((u)localObject1).a()));
      localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, this.r.getId());
      i = com.unionpay.mobile.android.global.a.d;
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = i;
      ((RelativeLayout.LayoutParams)localObject2).topMargin = i;
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = com.unionpay.mobile.android.global.a.d;
      this.l.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    }
    this.p = new TextView(this.d);
    this.p.setText(com.unionpay.mobile.android.languages.c.by.n);
    this.p.setTextSize(com.unionpay.mobile.android.global.b.i);
    this.p.setTextColor(p());
    this.p.setGravity(17);
    Object localObject2 = this.p;
    boolean bool1 = bool2;
    if (this.r != null)
    {
      if (this.r.e()) {
        bool1 = bool2;
      }
    }
    else
    {
      ((TextView)localObject2).setEnabled(bool1);
      i = com.unionpay.mobile.android.global.a.n;
      localObject2 = this.c.a(2008);
      this.p.setBackgroundDrawable((Drawable)localObject2);
      this.p.setOnClickListener(this.q);
      localObject2 = new RelativeLayout.LayoutParams(-1, i);
      if (localObject1 == null) {
        break label377;
      }
    }
    label377:
    for (int i = ((u)localObject1).getId();; i = this.r.getId())
    {
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, i);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = com.unionpay.mobile.android.global.a.f;
      this.l.addView(this.p, (ViewGroup.LayoutParams)localObject2);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void c(String paramString) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\mobile\android\nocard\views\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */