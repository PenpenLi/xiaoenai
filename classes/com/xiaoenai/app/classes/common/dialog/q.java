package com.xiaoenai.app.classes.common.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.c.a.l;
import com.xiaoenai.app.widget.wheel.WheelView;
import com.xiaoenai.app.widget.wheel.a.e;
import com.xiaoenai.app.widget.wheel.d;

public class q
  extends a
{
  RelativeLayout a;
  WheelView b;
  Button c;
  Button d;
  private int[] e = { -2959910, -808266278, 13817306 };
  private LinearLayout f;
  private int g = 0;
  private a h = null;
  
  public q(Context paramContext)
  {
    super(paramContext, 2131296448);
    b();
  }
  
  private void b()
  {
    this.a = ((RelativeLayout)getLayoutInflater().inflate(2130903138, null));
    this.f = ((LinearLayout)this.a.findViewById(2131558919));
    this.b = ((WheelView)this.a.findViewById(2131558934));
    this.c = ((Button)this.a.findViewById(2131558933));
    this.c.setOnClickListener(new r(this));
    this.d = ((Button)this.a.findViewById(2131558932));
    this.d.setOnClickListener(new s(this));
  }
  
  public int a()
  {
    return this.b.getCurrentItem();
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.c.setOnClickListener(paramOnClickListener);
  }
  
  public void a(a parama)
  {
    this.h = parama;
  }
  
  public void a(e parame, d paramd)
  {
    this.b.setViewAdapter(parame);
    this.b.setCyclic(false);
    this.b.setVisibleItems(this.b.getHeight() / 50);
    this.b.a(paramd);
    this.b.setCurrentItem(0);
    this.b.setWheelValResourceId(2130839049);
    this.b.setWheelBgResourceId(2130839045);
    this.b.setShadowsColors(this.e);
    this.b.setShadowCount(3.5F);
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.d.setVisibility(0);
    this.d.setOnClickListener(paramOnClickListener);
  }
  
  public void dismiss()
  {
    super.dismiss();
    if (this.h != null) {
      this.h.a();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(this.a);
    this.a.setOnClickListener(new t(this));
  }
  
  protected void onStart()
  {
    super.onStart();
    this.f.measure(0, 0);
    this.g = this.f.getMeasuredHeight();
    l.a(this.f, "translationY", new float[] { this.g, 0.0F }).b(300L).a();
    this.f.setVisibility(0);
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\dialog\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */