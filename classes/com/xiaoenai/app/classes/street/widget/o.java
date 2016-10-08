package com.xiaoenai.app.classes.street.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.c.a.l;

public class o
  extends Dialog
{
  private a a = null;
  private Context b = null;
  private RelativeLayout c = null;
  private RelativeLayout d = null;
  private RelativeLayout e = null;
  private RelativeLayout f = null;
  private RelativeLayout g = null;
  private Button h = null;
  private int i = 0;
  
  public o(Context paramContext)
  {
    super(paramContext, 2131296448);
    this.b = paramContext;
  }
  
  private void a()
  {
    this.d = ((RelativeLayout)findViewById(2131558670));
    this.e = ((RelativeLayout)findViewById(2131559630));
    this.f = ((RelativeLayout)findViewById(2131559632));
    this.g = ((RelativeLayout)findViewById(2131559634));
    this.h = ((Button)findViewById(2131559636));
  }
  
  private void b()
  {
    this.h.setOnClickListener(new p(this));
    this.e.setOnClickListener(new q(this));
    this.f.setOnClickListener(new r(this));
    this.g.setOnClickListener(new s(this));
  }
  
  public void a(a parama)
  {
    this.a = parama;
  }
  
  public void dismiss()
  {
    l locall = l.a(this.d, "translationY", new float[] { 0.0F, this.i });
    locall.b(300L);
    locall.a(new t(this));
    locall.a();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.c = ((RelativeLayout)getLayoutInflater().inflate(2130903279, null));
    setContentView(this.c);
    a();
    b();
  }
  
  protected void onStart()
  {
    super.onStart();
    this.d.measure(0, 0);
    this.i = this.d.getMeasuredHeight();
    l.a(this.d, "translationY", new float[] { this.i, 0.0F }).b(300L).a();
    this.d.setVisibility(0);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */