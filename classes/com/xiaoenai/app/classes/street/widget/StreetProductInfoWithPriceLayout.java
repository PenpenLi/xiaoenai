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

public class StreetProductInfoWithPriceLayout
  extends RelativeLayout
{
  private StreetProductInfoLayout a;
  private View b;
  private TextView c;
  private View d;
  private Button e;
  private Button f;
  
  public StreetProductInfoWithPriceLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public StreetProductInfoWithPriceLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.a = new StreetProductInfoLayout(getContext(), "mall_pd_layout_type_order");
    this.a.setId(2131558457);
    this.b = new View(getContext());
    this.b.setId(2131558458);
    this.c = new TextView(getContext());
    this.c.setId(2131558456);
    this.b.setLayoutParams(c());
    this.c.setLayoutParams(b());
    this.d = new View(getContext());
    this.d.setId(2131558470);
    this.e = new Button(getContext());
    this.e.setId(2131558468);
    this.f = new Button(getContext());
    this.f.setId(2131558469);
    this.d.setLayoutParams(d());
    this.e.setLayoutParams(e());
    this.f.setLayoutParams(f());
    this.d.setVisibility(8);
    this.e.setVisibility(8);
    this.f.setVisibility(8);
    g();
    h();
    setPadding(0, 0, 0, ab.a(6.0F));
  }
  
  private RelativeLayout.LayoutParams b()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    int i = (int)getContext().getResources().getDimension(2131230891);
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localLayoutParams.addRule(3, this.b.getId());
    localLayoutParams.addRule(11, -1);
    return localLayoutParams;
  }
  
  private RelativeLayout.LayoutParams c()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
    int i = (int)getContext().getResources().getDimension(2131230891);
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localLayoutParams.addRule(3, this.a.getId());
    return localLayoutParams;
  }
  
  private RelativeLayout.LayoutParams d()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
    int i = (int)getContext().getResources().getDimension(2131230891);
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localLayoutParams.addRule(3, this.c.getId());
    return localLayoutParams;
  }
  
  private RelativeLayout.LayoutParams e()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(ab.a(72.0F), ab.a(28.0F));
    localLayoutParams.topMargin = ab.a(11.0F);
    localLayoutParams.addRule(3, this.d.getId());
    localLayoutParams.addRule(0, this.f.getId());
    return localLayoutParams;
  }
  
  private RelativeLayout.LayoutParams f()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(ab.a(72.0F), ab.a(28.0F));
    int i = ab.a(11.0F);
    localLayoutParams.topMargin = i;
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localLayoutParams.addRule(3, this.d.getId());
    localLayoutParams.addRule(11, -1);
    return localLayoutParams;
  }
  
  private void g()
  {
    addView(this.a);
    addView(this.b);
    addView(this.c);
    addView(this.d);
    addView(this.e);
    addView(this.f);
  }
  
  private void h()
  {
    int i = ab.a(12.0F);
    this.c.setPadding(0, i, 0, i);
    this.c.setGravity(5);
    this.c.setTextColor(getContext().getResources().getColor(2131493035));
    this.b.setBackgroundColor(getContext().getResources().getColor(2131493011));
    i = getContext().getResources().getColor(2131493132);
    this.d.setBackgroundColor(getContext().getResources().getColor(2131493011));
    this.e.setBackgroundResource(2130837598);
    this.e.setTextColor(i);
    this.e.setTextSize(14);
    this.f.setBackgroundResource(2130837598);
    this.f.setTextColor(i);
    this.f.setTextSize(14);
  }
  
  public Button getLeftOpBtn()
  {
    return this.e;
  }
  
  public StreetProductInfoLayout getMallProductInfoLayout()
  {
    return this.a;
  }
  
  public Button getOpBtn()
  {
    return this.f;
  }
  
  public View getPriceOpDivider()
  {
    return this.d;
  }
  
  public TextView getPriceTxt()
  {
    return this.c;
  }
  
  public void setPriceVisibility(int paramInt)
  {
    this.b.setVisibility(paramInt);
    this.c.setVisibility(paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\StreetProductInfoWithPriceLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */