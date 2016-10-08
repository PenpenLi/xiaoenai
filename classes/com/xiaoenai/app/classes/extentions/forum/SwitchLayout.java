package com.xiaoenai.app.classes.extentions.forum;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.xiaoenai.app.utils.k;

public class SwitchLayout
  extends LinearLayout
{
  Drawable a;
  Drawable b;
  Drawable c;
  private Button d;
  private Button e;
  private int f = 0;
  private int g = 2131296397;
  private a h;
  
  public SwitchLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public SwitchLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public SwitchLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private Drawable a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(View.PRESSED_SELECTED_STATE_SET, paramDrawable1);
    localStateListDrawable.addState(View.SELECTED_STATE_SET, paramDrawable1);
    localStateListDrawable.addState(View.EMPTY_STATE_SET, paramDrawable2);
    return localStateListDrawable;
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2130903173, this, false);
    addView(localView);
    setPadding(0, 0, 0, 0);
    this.d = ((Button)localView.findViewById(2131558912));
    this.d.setSelected(true);
    this.d.setOnClickListener(new b(this));
    this.e = ((Button)localView.findViewById(2131558914));
    this.e.setOnClickListener(new c(this));
    a(this.d, this.e);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == this.f) {}
    for (;;)
    {
      return;
      this.f = paramInt;
      if (this.f == 0)
      {
        this.d.setSelected(true);
        this.d.requestFocus();
        this.e.setSelected(false);
        this.e.clearFocus();
        b(this.d, this.e);
      }
      while (this.h != null)
      {
        this.h.a(this.f);
        return;
        this.d.setSelected(false);
        this.d.clearFocus();
        this.e.setSelected(true);
        this.e.requestFocus();
        b(this.e, this.d);
      }
    }
  }
  
  private void a(Button paramButton1, Button paramButton2)
  {
    if (this.g == 2131296398)
    {
      b();
      paramButton1.setBackgroundDrawable(this.a);
      paramButton2.setBackgroundDrawable(this.b);
    }
  }
  
  private void b()
  {
    this.a = a(k.a(getResources().getDrawable(2130837812), getResources().getColor(2131492956)), k.a(getResources().getDrawable(2130837809), getResources().getColor(2131492956)));
    this.d.setBackgroundDrawable(this.a);
    this.c = a(k.a(getResources().getDrawable(2130837806), getResources().getColor(2131492956)), k.a(getResources().getDrawable(2130837803), getResources().getColor(2131492956)));
    this.b = a(k.a(getResources().getDrawable(2130837818), getResources().getColor(2131492956)), k.a(getResources().getDrawable(2130837815), getResources().getColor(2131492956)));
  }
  
  private void b(Button paramButton1, Button paramButton2)
  {
    if (this.g == 2131296398)
    {
      paramButton1.setTextColor(getResources().getColor(2131492974));
      paramButton2.setTextColor(getResources().getColor(2131492956));
      return;
    }
    paramButton1.setTextColor(-764523);
    paramButton2.setTextColor(-1);
  }
  
  public a getOnTabChangeListener()
  {
    return this.h;
  }
  
  public void setLeftTabString(String paramString)
  {
    this.d.setText(paramString);
  }
  
  public void setOnTabChangeListener(a parama)
  {
    this.h = parama;
  }
  
  public void setRightTabString(String paramString)
  {
    this.e.setText(paramString);
  }
  
  public void setTheme(int paramInt)
  {
    this.g = paramInt;
    b(this.d, this.e);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\forum\SwitchLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */