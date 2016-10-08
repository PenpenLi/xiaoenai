package com.xiaoenai.app.classes.street.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class StreetPayListItemView
  extends RelativeLayout
{
  private View.OnClickListener a = null;
  private Context b = null;
  private RelativeLayout c = null;
  private ImageView d = null;
  private TextView e = null;
  private TextView f = null;
  private ImageView g = null;
  private boolean h = false;
  private boolean i = true;
  
  public StreetPayListItemView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
    b();
  }
  
  public StreetPayListItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
    b();
  }
  
  public StreetPayListItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
    b();
  }
  
  private void a(Context paramContext)
  {
    this.b = paramContext;
    this.c = ((RelativeLayout)LayoutInflater.from(paramContext).inflate(2130903354, this));
    this.d = ((ImageView)this.c.findViewById(2131559969));
    this.e = ((TextView)this.c.findViewById(2131559970));
    this.f = ((TextView)this.c.findViewById(2131559971));
    this.g = ((ImageView)this.c.findViewById(2131559972));
    this.g.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.f.setVisibility(8);
    setClickState(false);
  }
  
  private void a(View paramView)
  {
    if (!this.i) {}
    for (;;)
    {
      return;
      if (this.h) {
        setClickState(false);
      }
      while (this.a != null)
      {
        this.a.onClick(paramView);
        return;
        setClickState(true);
      }
    }
  }
  
  private void b()
  {
    super.setOnClickListener(new ac(this));
  }
  
  public void a()
  {
    this.d.setVisibility(4);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
    localLayoutParams.setMargins(0, 0, 0, 0);
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(5, this.d.getId());
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.equals(""))) {
      this.e.setVisibility(8);
    }
    while ((paramString2 == null) || (paramString2.equals("")))
    {
      this.f.setVisibility(8);
      return;
      this.e.setText(paramString1);
    }
    this.f.setVisibility(0);
    this.f.setText(paramString2);
  }
  
  public boolean getState()
  {
    return this.h;
  }
  
  public void setClickEnable(boolean paramBoolean)
  {
    this.i = paramBoolean;
    if (!paramBoolean) {
      setClickState(false);
    }
  }
  
  public void setClickState(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if (this.h)
    {
      this.g.setImageResource(2130838675);
      return;
    }
    this.g.setImageResource(2130838705);
  }
  
  public void setItemIcon(int paramInt)
  {
    this.d.setImageResource(paramInt);
    this.d.setVisibility(0);
  }
  
  public void setItemText(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      this.e.setVisibility(8);
      return;
    }
    this.e.setText(paramString);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.a = paramOnClickListener;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\StreetPayListItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */