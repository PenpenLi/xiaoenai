package com.xiaoenai.app.classes.street.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.widget.h.a;
import java.util.Timer;

public class StreetCountdownView
  extends RelativeLayout
  implements h.a
{
  private RelativeLayout a = null;
  private Context b = null;
  private TextView c = null;
  private TextView d = null;
  private TextView e = null;
  private TextView f = null;
  private TextView g = null;
  private TextView h = null;
  private long i = 0L;
  private long j = 0L;
  private Timer k = null;
  private Handler l = new Handler();
  private a m = null;
  private final long n = 1000L;
  
  public StreetCountdownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public StreetCountdownView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private String a(int paramInt)
  {
    if (paramInt < 10) {
      return "0" + paramInt;
    }
    return "" + paramInt;
  }
  
  private void a()
  {
    if (this.k != null)
    {
      this.k.cancel();
      this.k = null;
    }
  }
  
  private void a(Context paramContext)
  {
    this.b = paramContext;
    this.a = ((RelativeLayout)RelativeLayout.inflate(paramContext, 2130903338, this));
    this.c = ((TextView)findViewById(2131559837));
    this.d = ((TextView)findViewById(2131559838));
    this.e = ((TextView)findViewById(2131559839));
    this.f = ((TextView)findViewById(2131559840));
    this.g = ((TextView)findViewById(2131559841));
    this.h = ((TextView)findViewById(2131559842));
    this.c.setTextColor(getResources().getColor(2131493111));
  }
  
  private void setTime(long paramLong)
  {
    int i1 = (int)paramLong;
    int i2 = i1 / 60;
    String str = a(i1 / 3600 % 3600);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
    if (str.length() > 2) {}
    for (localLayoutParams.width = ab.a(str.length() * 9);; localLayoutParams.width = ab.a(18.0F))
    {
      this.d.setLayoutParams(localLayoutParams);
      this.d.setText(str);
      this.f.setText(a(i2 % 60));
      this.h.setText(a(i1 % 60));
      return;
    }
  }
  
  public void b()
  {
    if (this.j > 0L)
    {
      long l1 = this.j - 1L;
      this.j = l1;
      setTime(l1);
    }
    do
    {
      return;
      setTime(0L);
      a();
    } while (this.m == null);
    this.m.a();
  }
  
  public long getPeriod()
  {
    return 1000L;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a();
  }
  
  public void setCloseTime(long paramLong)
  {
    this.i = paramLong;
    this.j = (this.i - ak.b());
    if (this.j > 0L) {
      setTime(this.j);
    }
  }
  
  public void setDeadlineColor(int paramInt)
  {
    ((GradientDrawable)this.d.getBackground()).setColor(paramInt);
    ((GradientDrawable)this.f.getBackground()).setColor(paramInt);
    ((GradientDrawable)this.h.getBackground()).setColor(paramInt);
    this.e.setTextColor(paramInt);
    this.g.setTextColor(paramInt);
  }
  
  public void setDeadlineDesc(String paramString)
  {
    paramString = paramString + this.b.getString(2131101369);
    this.c.setText(paramString);
  }
  
  public void setOnCloseTimeListener(a parama)
  {
    this.m = parama;
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt != 0) {
      a();
    }
    super.setVisibility(paramInt);
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\StreetCountdownView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */