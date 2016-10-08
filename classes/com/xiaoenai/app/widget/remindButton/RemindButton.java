package com.xiaoenai.app.widget.remindButton;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.xiaoenai.app.utils.ab;

public class RemindButton
  extends RelativeLayout
{
  private TextView a = null;
  private ImageView b = null;
  
  public RemindButton(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public RemindButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public RemindButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    RelativeLayout.inflate(paramContext, 2130903252, this);
    this.a = ((TextView)findViewById(2131559514));
    this.b = ((ImageView)findViewById(2131559513));
  }
  
  public void a()
  {
    this.b.setVisibility(0);
    this.a.setVisibility(8);
    setVisibility(0);
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 99)
    {
      this.a.setText(getResources().getString(2131100100));
      this.a.setTextSize(9.0F);
      this.a.setLayoutParams(new RelativeLayout.LayoutParams(ab.a(19.0F), ab.a(19.0F)));
      if (Build.VERSION.SDK_INT <= 15) {
        break label125;
      }
      this.a.setBackground(getResources().getDrawable(2130838799));
    }
    for (;;)
    {
      this.a.setVisibility(0);
      this.b.setVisibility(8);
      setVisibility(0);
      return;
      this.a.setText(String.valueOf(paramInt));
      this.a.setTextSize(12.0F);
      break;
      label125:
      this.a.setBackgroundResource(2130838799);
    }
  }
  
  public void a(String paramString)
  {
    this.a.setText(paramString);
    this.a.setTextSize(12.0F);
    this.a.setLayoutParams(new RelativeLayout.LayoutParams(-2, ab.a(19.0F)));
    if (Build.VERSION.SDK_INT > 15) {
      this.a.setBackground(getResources().getDrawable(2130838798));
    }
    for (;;)
    {
      this.a.setPadding(ab.a(5.0F), 0, ab.a(5.0F), ab.a(1.0F));
      this.a.setVisibility(0);
      this.b.setVisibility(8);
      setVisibility(0);
      return;
      this.a.setBackgroundResource(2130838798);
    }
  }
  
  public void b()
  {
    setVisibility(4);
  }
  
  public int getCount()
  {
    int i = 0;
    if (this.a != null) {
      i = Integer.parseInt(this.a.getText().toString());
    }
    return i;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\widget\remindButton\RemindButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */