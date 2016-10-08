package com.xiaoenai.app.classes.street.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.utils.ab;

public class StreetProductTypeItemView
  extends RelativeLayout
{
  private Context a = null;
  private RelativeLayout b = null;
  private RelativeLayout c = null;
  private TextView d = null;
  private a e = null;
  private boolean f = false;
  private int g = -1;
  private boolean h = true;
  private StreetProductTypeItemLayout.a i = null;
  
  public StreetProductTypeItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public StreetProductTypeItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  public StreetProductTypeItemView(Context paramContext, StreetProductTypeItemLayout.a parama)
  {
    super(paramContext);
    this.i = parama;
    a(paramContext);
  }
  
  private void a()
  {
    this.c.setOnClickListener(new az(this));
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    this.b = ((RelativeLayout)RelativeLayout.inflate(this.a, 2130903283, this));
    this.c = ((RelativeLayout)findViewById(2131558670));
    this.d = ((TextView)findViewById(2131559609));
    this.d.setText(this.i.b);
    a();
  }
  
  public int getItemWidth()
  {
    if (this.g < 0)
    {
      Rect localRect = new Rect();
      this.d.getPaint().getTextBounds(this.i.b, 0, this.i.b.length(), localRect);
      this.g = (ab.b(localRect.width()) + 20);
    }
    return this.g;
  }
  
  public boolean getPressState()
  {
    return this.f;
  }
  
  public StreetProductTypeItemLayout.a getProductItem()
  {
    return this.i;
  }
  
  public TextView getTextView()
  {
    return this.d;
  }
  
  public void setItemEnable(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if (paramBoolean)
    {
      this.c.setBackgroundResource(2130838715);
      this.d.setTextColor(getResources().getColor(2131493028));
      return;
    }
    this.c.setBackgroundResource(2130838715);
    this.d.setTextColor(getResources().getColor(2131493003));
  }
  
  public void setItemWidth(int paramInt)
  {
    if (paramInt > this.g)
    {
      this.g = paramInt;
      this.d.getLayoutParams().width = ab.a(this.g);
      this.d.setGravity(17);
      this.d.setPadding(0, 0, 0, 0);
      this.c.getLayoutParams().width = ab.a(this.g);
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener) {}
  
  public void setOnClickListener(a parama)
  {
    this.e = parama;
  }
  
  public void setPressState(boolean paramBoolean)
  {
    if (!this.h) {
      return;
    }
    this.f = paramBoolean;
    if (this.f)
    {
      this.c.setBackgroundResource(2131493038);
      this.d.setTextColor(getResources().getColor(2131493206));
      return;
    }
    this.c.setBackgroundResource(2130838715);
    this.d.setTextColor(getResources().getColor(2131493028));
  }
  
  public static abstract interface a
  {
    public abstract void a(StreetProductTypeItemLayout.a parama);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\StreetProductTypeItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */