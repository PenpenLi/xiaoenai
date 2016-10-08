package com.xiaoenai.app.classes.common.ads;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.utils.ab;

public class b
{
  private a a;
  private AdsView.a b;
  private AdsView c;
  private int d;
  
  private int a(int paramInt)
  {
    return this.c.getContext().obtainStyledAttributes(this.d, new int[] { paramInt }).getColor(0, -16777216);
  }
  
  private void c()
  {
    this.b.a.setLayoutParams(h());
    this.b.b.setLayoutParams(i());
    this.c.setBackgroundColor(a(2130772020));
    if (this.a.h() != 1)
    {
      this.b.c.setLayoutParams(j());
      this.b.d.setLayoutParams(k());
      this.b.d.setTextColor(this.b.d.getResources().getColor(2131492967));
    }
    this.b.e.setLayoutParams(l());
    this.b.f.setLayoutParams(m());
    this.b.g.setLayoutParams(n());
    this.b.h.setLayoutParams(o());
    this.b.i.setLayoutParams(p());
  }
  
  private void d()
  {
    Context localContext = this.b.g.getContext();
    this.b.g.setTextColor(localContext.getResources().getColor(2131492946));
  }
  
  private void e()
  {
    if (this.a.h() != 1)
    {
      this.c.addView(this.b.c);
      this.c.addView(this.b.d);
    }
    for (;;)
    {
      this.c.addView(this.b.e);
      this.c.addView(this.b.f);
      this.c.addView(this.b.i);
      this.b.i.addView(this.b.g);
      this.b.i.addView(this.b.h);
      this.b.e.setTextColor(a(2130772211));
      this.b.h.setBackgroundResource(2130837739);
      this.b.h.setText(2131100079);
      this.b.h.setTextColor(this.c.getResources().getColor(2131493206));
      this.b.h.setGravity(17);
      return;
      this.b.a.setBackgroundColor(a(2130772024));
      this.b.b.setBackgroundColor(a(2130772024));
      this.c.addView(this.b.a);
      this.c.addView(this.b.b);
    }
  }
  
  private void f()
  {
    Context localContext = this.c.getContext();
    this.c.setOnClickListener(new c(this, localContext));
    this.b.h.setOnClickListener(new h(this));
  }
  
  private void g()
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(this.a.b()));
    this.c.getContext().startActivity(localIntent);
  }
  
  private RelativeLayout.LayoutParams h()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
    localLayoutParams.addRule(12, -1);
    return localLayoutParams;
  }
  
  private RelativeLayout.LayoutParams i()
  {
    return new RelativeLayout.LayoutParams(-1, 1);
  }
  
  private RelativeLayout.LayoutParams j()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(ab.a(32.0F), ab.a(32.0F));
    localLayoutParams.addRule(3, this.b.b.getId());
    int i = ab.a(12.0F);
    localLayoutParams.topMargin = i;
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    return localLayoutParams;
  }
  
  private RelativeLayout.LayoutParams k()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(3, this.b.b.getId());
    int i = ab.a(10.0F);
    localLayoutParams.topMargin = i;
    localLayoutParams.bottomMargin = i;
    localLayoutParams.rightMargin = i;
    localLayoutParams.addRule(1, this.b.c.getId());
    return localLayoutParams;
  }
  
  private RelativeLayout.LayoutParams l()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    int i = ab.a(16.0F);
    if (this.a.h() != 1)
    {
      localLayoutParams.addRule(1, this.b.c.getId());
      localLayoutParams.addRule(3, this.b.d.getId());
    }
    for (;;)
    {
      localLayoutParams.rightMargin = i;
      localLayoutParams.bottomMargin = ab.a(6.0F);
      return localLayoutParams;
      localLayoutParams.addRule(3, this.b.b.getId());
      localLayoutParams.leftMargin = i;
      localLayoutParams.topMargin = i;
    }
  }
  
  private RelativeLayout.LayoutParams m()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(5, this.b.e.getId());
    localLayoutParams.addRule(3, this.b.e.getId());
    localLayoutParams.rightMargin = ab.a(16.0F);
    return localLayoutParams;
  }
  
  private RelativeLayout.LayoutParams n()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(15, -1);
    return localLayoutParams;
  }
  
  private RelativeLayout.LayoutParams o()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(ab.a(80.0F), ab.a(28.0F));
    localLayoutParams.addRule(11, -1);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.rightMargin = ab.a(16.0F);
    return localLayoutParams;
  }
  
  private RelativeLayout.LayoutParams p()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, ab.a(42.0F));
    localLayoutParams.addRule(3, this.b.f.getId());
    localLayoutParams.addRule(5, this.b.e.getId());
    return localLayoutParams;
  }
  
  public void a()
  {
    if (this.c != null)
    {
      this.c.a();
      this.b = this.c.getViewHolder();
      if (!UserConfig.getBoolean("forum_night_theme", Boolean.valueOf(false)).booleanValue()) {
        break label67;
      }
    }
    label67:
    for (int i = 2131296398;; i = 2131296397)
    {
      this.d = i;
      c();
      e();
      f();
      d();
      return;
    }
  }
  
  public void a(AdsView paramAdsView)
  {
    this.c = paramAdsView;
  }
  
  public void a(a parama)
  {
    this.a = parama;
  }
  
  public void b()
  {
    Object localObject2 = null;
    Object localObject1;
    if ((this.a != null) && (this.b != null))
    {
      if (this.a.h() == 2)
      {
        com.xiaoenai.app.utils.e.b.a(this.b.c, this.a.g());
        this.b.d.setText(this.a.e());
      }
      this.b.e.setText(this.a.f());
      if (this.a.c() == null) {
        break label275;
      }
      localObject1 = this.a.c()[0];
      if (localObject1 != null)
      {
        localObject2 = ((a.a)localObject1).c;
        this.b.f.setScaleType(ImageView.ScaleType.FIT_XY);
        if (this.a.h() == 1) {
          break label280;
        }
      }
    }
    label275:
    label280:
    for (int i = ab.b() - ab.a(16.0F) - ab.a(10.0F) * 2 - ab.a(32.0F);; i = ab.b() - ab.a(16.0F) * 2)
    {
      i = i * ((a.a)localObject1).a / ((a.a)localObject1).b;
      this.b.f.getLayoutParams().height = i;
      com.xiaoenai.app.utils.e.b.a(this.b.f, (String)localObject2);
      localObject1 = String.format(this.b.g.getContext().getString(2131100078), new Object[] { Integer.valueOf(this.a.d()) });
      localObject2 = new SpannableString((CharSequence)localObject1);
      ((Spannable)localObject2).setSpan(new ForegroundColorSpan(-65536), 2, ((String)localObject1).length() - 3, 33);
      this.b.g.setText((CharSequence)localObject2);
      return;
      localObject1 = null;
      break;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\ads\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */