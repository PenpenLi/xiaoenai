package com.xiaoenai.app.classes.street.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.widget.h;

public class StreetOrderListItemLayout
  extends RelativeLayout
{
  private a a;
  private h b = null;
  
  public StreetOrderListItemLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public StreetOrderListItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public StreetOrderListItemLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = new a();
    this.a.a = this;
    this.a.b = new TextView(getContext());
    this.a.b.setId(2131558445);
    this.a.c = new TextView(getContext());
    this.a.c.setId(2131558448);
    this.a.d = new View(getContext());
    this.a.d.setId(2131558441);
    this.a.e = new StreetProductInfoWithPriceLayout(getContext());
    this.a.e.setId(2131558447);
    this.a.f = new View(getContext());
    this.a.f.setId(2131558442);
    this.a.g = new TextView(getContext());
    this.a.g.setId(2131558444);
    this.a.h = new Button(getContext());
    this.a.h.setId(2131558446);
    this.a.i = new Button(getContext());
    this.a.i.setId(2131558443);
    j();
    k();
    this.b = new h(getContext());
  }
  
  private RelativeLayout.LayoutParams b()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    int i = (int)getContext().getResources().getDimension(2131230891);
    localLayoutParams.leftMargin = i;
    localLayoutParams.topMargin = i;
    return localLayoutParams;
  }
  
  private RelativeLayout.LayoutParams c()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    int i = (int)getContext().getResources().getDimension(2131230891);
    localLayoutParams.topMargin = i;
    localLayoutParams.rightMargin = i;
    localLayoutParams.addRule(11, -1);
    return localLayoutParams;
  }
  
  private RelativeLayout.LayoutParams d()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
    int i = (int)getContext().getResources().getDimension(2131230891);
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localLayoutParams.topMargin = ab.a(6.0F);
    localLayoutParams.addRule(3, this.a.b.getId());
    return localLayoutParams;
  }
  
  private RelativeLayout.LayoutParams e()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(3, this.a.d.getId());
    return localLayoutParams;
  }
  
  private RelativeLayout.LayoutParams f()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
    int i = (int)getContext().getResources().getDimension(2131230891);
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localLayoutParams.addRule(3, this.a.e.getId());
    return localLayoutParams;
  }
  
  private RelativeLayout.LayoutParams g()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(3, this.a.f.getId());
    int i = (int)getContext().getResources().getDimension(2131230891);
    localLayoutParams.topMargin = i;
    localLayoutParams.leftMargin = i;
    localLayoutParams.bottomMargin = i;
    return localLayoutParams;
  }
  
  private RelativeLayout.LayoutParams h()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(ab.a(72.0F), ab.a(28.0F));
    localLayoutParams.addRule(3, this.a.f.getId());
    localLayoutParams.addRule(0, this.a.h.getId());
    int i = (int)getContext().getResources().getDimension(2131230891);
    localLayoutParams.topMargin = i;
    localLayoutParams.rightMargin = i;
    localLayoutParams.bottomMargin = i;
    return localLayoutParams;
  }
  
  private RelativeLayout.LayoutParams i()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(ab.a(72.0F), ab.a(28.0F));
    localLayoutParams.addRule(3, this.a.f.getId());
    localLayoutParams.addRule(11, -1);
    int i = (int)getContext().getResources().getDimension(2131230891);
    localLayoutParams.topMargin = i;
    localLayoutParams.rightMargin = i;
    return localLayoutParams;
  }
  
  private void j()
  {
    this.a.b.setLayoutParams(b());
    addView(this.a.b);
    this.a.c.setLayoutParams(c());
    addView(this.a.c);
    this.a.d.setLayoutParams(d());
    addView(this.a.d);
    this.a.e.setLayoutParams(e());
    addView(this.a.e);
    this.a.f.setLayoutParams(f());
    addView(this.a.f);
    this.a.g.setLayoutParams(g());
    addView(this.a.g);
    this.a.h.setLayoutParams(i());
    addView(this.a.h);
    this.a.i.setLayoutParams(h());
    addView(this.a.i);
  }
  
  private void k()
  {
    int i = getContext().getResources().getColor(2131493011);
    this.a.b.setTextSize(14.0F);
    this.a.b.setTextColor(getContext().getResources().getColor(2131493032));
    this.a.c.setTextSize(14.0F);
    this.a.d.setBackgroundColor(i);
    this.a.f.setBackgroundColor(i);
    this.a.g.setTextSize(14.0F);
    this.a.g.setTextColor(getContext().getResources().getColor(2131493029));
    this.a.h.setTextSize(14.0F);
    i = getContext().getResources().getColor(2131493028);
    this.a.i.setTextColor(i);
    this.a.h.setTextColor(i);
    this.a.h.setGravity(17);
    setBackgroundResource(2130838698);
    setPadding(0, 0, 0, (int)getContext().getResources().getDimension(2131230891));
  }
  
  public a getViewHolder()
  {
    return this.a;
  }
  
  public h getmTimer()
  {
    return this.b;
  }
  
  public class a
  {
    public RelativeLayout a;
    public TextView b;
    public TextView c;
    public View d;
    public StreetProductInfoWithPriceLayout e;
    public View f;
    public TextView g;
    public Button h;
    public Button i;
    
    public a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\StreetOrderListItemLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */