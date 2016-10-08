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

public class v
  extends a
{
  RelativeLayout a = (RelativeLayout)getLayoutInflater().inflate(2130903145, null);
  WheelView b = (WheelView)this.a.findViewById(2131558934);
  Button c = (Button)this.a.findViewById(2131558933);
  Button d;
  private LinearLayout e = (LinearLayout)this.a.findViewById(2131558919);
  private int f = 0;
  
  public v(Context paramContext)
  {
    super(paramContext, 2131296448);
    this.c.setOnClickListener(new w(this));
    this.d = ((Button)this.a.findViewById(2131558932));
    this.d.setOnClickListener(new x(this));
  }
  
  public int a()
  {
    return this.b.getCurrentItem();
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.c.setOnClickListener(paramOnClickListener);
  }
  
  public void a(e parame, d paramd)
  {
    this.b.setViewAdapter(parame);
    this.b.setCyclic(false);
    this.b.setVisibleItems(this.b.getHeight() / 50);
    this.b.a(paramd);
    this.b.setCurrentItem(0);
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.d.setVisibility(0);
    this.d.setOnClickListener(paramOnClickListener);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(this.a);
  }
  
  protected void onStart()
  {
    super.onStart();
    this.e.measure(0, 0);
    this.f = this.e.getMeasuredHeight();
    l.a(this.e, "translationY", new float[] { this.f, 0.0F }).b(300L).a();
    this.e.setVisibility(0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\dialog\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */