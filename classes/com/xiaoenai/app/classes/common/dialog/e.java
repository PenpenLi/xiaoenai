package com.xiaoenai.app.classes.common.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.c.a.l;
import com.xiaoenai.app.utils.ab;
import java.util.ArrayList;

public class e
  extends a
{
  protected Object a = null;
  private LinearLayout b = (LinearLayout)this.e.findViewById(2131558921);
  private LinearLayout c = (LinearLayout)this.e.findViewById(2131558919);
  private TextView d = (TextView)this.e.findViewById(2131558920);
  private RelativeLayout e = (RelativeLayout)getLayoutInflater().inflate(2130903135, null);
  private Button f = (Button)this.e.findViewById(2131558922);
  private int g = 0;
  private ArrayList<Button> h = new ArrayList();
  private b i;
  
  public e(Context paramContext)
  {
    super(paramContext, 2131296448);
  }
  
  private void a(Button paramButton, String paramString, int paramInt1, View.OnClickListener paramOnClickListener, int paramInt2)
  {
    paramButton.setText(paramString);
    paramButton.setTextSize(2, 18.0F);
    paramButton.setLayoutParams(new LinearLayout.LayoutParams(paramInt2, ab.a(48.0F)));
    switch (paramInt1)
    {
    }
    for (;;)
    {
      paramButton.setBackgroundResource(2130837746);
      if (this.h.size() > 1) {
        ((Button)this.h.get(this.h.size() - 1)).setBackgroundResource(2130837747);
      }
      if (paramOnClickListener != null) {
        paramButton.setOnClickListener(paramOnClickListener);
      }
      this.h.add(paramButton);
      if (this.h.size() > 1)
      {
        paramButton = new View(getContext());
        paramButton.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        paramButton.setBackgroundColor(-3618616);
        this.b.addView(paramButton);
      }
      return;
      paramButton.setTextColor(-12551475);
      continue;
      paramButton.setTextColor(-379318);
      continue;
      paramButton.setTextColor(-12551475);
    }
  }
  
  private void b(View paramView)
  {
    this.b.addView(paramView);
  }
  
  public Object a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.d.setVisibility(paramInt);
  }
  
  @Deprecated
  public void a(int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    a(getContext().getString(paramInt1), paramInt2, paramOnClickListener);
  }
  
  public void a(int paramInt1, int paramInt2, a parama)
  {
    a(paramInt1, paramInt2, new i(this, parama));
  }
  
  public void a(View paramView)
  {
    this.c.addView(paramView, this.c.getChildCount() - 2);
  }
  
  public void a(b paramb)
  {
    this.i = paramb;
  }
  
  public void a(Object paramObject)
  {
    this.a = paramObject;
  }
  
  public void a(String paramString)
  {
    this.d.setVisibility(0);
    this.d.setText(paramString);
  }
  
  @Deprecated
  public void a(String paramString, int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.b.setVisibility(0);
    Button localButton = new Button(getContext());
    a(localButton, paramString, paramInt, paramOnClickListener, -1);
    b(localButton);
  }
  
  public void dismiss()
  {
    l locall = l.a(this.c, "translationY", new float[] { 0.0F, this.g });
    locall.b(300L);
    locall.a(new j(this));
    locall.a();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(this.e);
    super.setOnDismissListener(new f(this));
    this.e.setOnClickListener(new g(this));
  }
  
  protected void onStart()
  {
    super.onStart();
    this.c.measure(0, 0);
    if (this.h.size() == 1) {
      ((Button)this.h.get(0)).setBackgroundResource(2130837750);
    }
    for (;;)
    {
      this.g = this.c.getMeasuredHeight();
      l.a(this.c, "translationY", new float[] { this.g, 0.0F }).b(300L).a();
      this.c.setVisibility(0);
      this.f.setOnClickListener(new h(this));
      return;
      if (this.h.size() > 1) {
        ((Button)this.h.get(0)).setBackgroundResource(2130837751);
      }
    }
  }
  
  public void setTitle(int paramInt)
  {
    this.d.setVisibility(0);
    this.d.setText(paramInt);
  }
  
  public static abstract interface a
  {
    public abstract void a(e parame);
  }
  
  public static abstract interface b
  {
    public abstract void a(e parame);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\dialog\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */