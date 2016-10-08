package com.xiaoenai.app.classes.street.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class StreetOrderMenu
  extends RelativeLayout
{
  private TextView a;
  private TextView b;
  private a c;
  
  public StreetOrderMenu(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StreetOrderMenu(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    View.inflate(paramContext, 2130903350, this);
    a();
    b();
  }
  
  private void a()
  {
    this.a = ((TextView)findViewById(2131559942));
    this.b = ((TextView)findViewById(2131559943));
  }
  
  private void b()
  {
    n localn = new n(this);
    this.a.setOnClickListener(localn);
    this.b.setOnClickListener(localn);
  }
  
  public void setOnManuClckListener(a parama)
  {
    this.c = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(View paramView, int paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\StreetOrderMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */