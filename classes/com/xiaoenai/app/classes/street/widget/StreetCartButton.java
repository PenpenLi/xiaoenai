package com.xiaoenai.app.classes.street.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.utils.ab;

public class StreetCartButton
  extends RelativeLayout
{
  private Context a = null;
  private TextView b = null;
  private ImageView c = null;
  
  public StreetCartButton(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public StreetCartButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public StreetCartButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    RelativeLayout.inflate(paramContext, 2130903335, this);
    this.b = ((TextView)findViewById(2131559829));
    this.b.setVisibility(8);
    this.c = ((ImageView)findViewById(2131559828));
    setCount(UserConfig.getInt("street_cart_count", Integer.valueOf(0)).intValue());
  }
  
  public void setCount(int paramInt)
  {
    if (paramInt > 0)
    {
      this.b.setVisibility(8);
      if (paramInt > 99)
      {
        this.b.setText(getResources().getString(2131100100));
        this.b.setTextSize(2, 9.0F);
        if (this.b.getVisibility() != 0) {
          break label131;
        }
        this.c.setPadding(0, ab.a(5.0F), 0, 0);
      }
      for (;;)
      {
        UserConfig.setInt("street_cart_count", paramInt);
        return;
        if (paramInt > 9)
        {
          this.b.setText(String.valueOf(paramInt));
          this.b.setTextSize(2, 10.0F);
          break;
        }
        this.b.setText(String.valueOf(paramInt));
        this.b.setTextSize(2, 11.0F);
        break;
        label131:
        this.c.setPadding(0, 0, 0, 0);
      }
    }
    this.b.setVisibility(8);
    this.c.setPadding(0, 0, 0, 0);
    UserConfig.setInt("street_cart_count", 0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\StreetCartButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */