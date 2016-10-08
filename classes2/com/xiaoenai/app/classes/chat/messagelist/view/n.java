package com.xiaoenai.app.classes.chat.messagelist.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.xiaoenai.app.utils.ab;

public class n
  extends BaseItemView
{
  public int b = getResources().getDimensionPixelOffset(2131230931);
  private TextView c;
  private ImageView d;
  private View e;
  private int f = 0;
  
  public n(Context paramContext)
  {
    super(paramContext);
  }
  
  public View getMsgContentView()
  {
    this.e = inflate(getContext(), 2130903115, null);
    this.c = ((TextView)this.e.findViewById(2131558855));
    this.d = ((ImageView)this.e.findViewById(2131558854));
    this.c.setGravity(19);
    return this.e;
  }
  
  public void setContentBackground(int paramInt)
  {
    if (this.mMessageBody != null) {
      this.mMessageBody.setBackgroundResource(paramInt);
    }
  }
  
  public void setContentText(String paramString)
  {
    this.c.setText(paramString);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
    int j = ab.a(this.c, paramString) + ab.a(52.0F);
    if (this.f == 0) {
      this.f = ((int)(ab.b() * 0.65D));
    }
    int i = j;
    if (j > this.f) {
      i = this.f;
    }
    localLayoutParams.width = i;
    localLayoutParams.height = -2;
    this.e.setLayoutParams(localLayoutParams);
  }
  
  public void setContentTextColor(int paramInt)
  {
    this.c.setTextColor(getResources().getColor(paramInt));
  }
  
  public void setImageResource(int paramInt) {}
  
  public void setLocationContentText(String paramString)
  {
    this.c.setText(paramString);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
    int j = ab.a(this.c, paramString) + ab.a(40.0F);
    if (this.f == 0) {
      this.f = ((int)(ab.b() * 0.65D));
    }
    int i = j;
    if (j > this.f) {
      i = this.f;
    }
    localLayoutParams.width = i;
    localLayoutParams.height = -2;
    this.e.setLayoutParams(localLayoutParams);
  }
  
  public void setStatusIcon(int paramInt)
  {
    this.d.setImageResource(paramInt);
  }
  
  public void setUserType(int paramInt)
  {
    super.setUserType(paramInt);
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
    localLayoutParams2.addRule(15, -1);
    if (paramInt == 2)
    {
      localLayoutParams2.addRule(9, -1);
      localLayoutParams2.addRule(11, 0);
      localLayoutParams1.setMargins(getResources().getDimensionPixelOffset(2131230931), 0, 0, 0);
      localLayoutParams1.addRule(1, this.d.getId());
      localLayoutParams1.addRule(0, -1);
    }
    for (;;)
    {
      this.d.setLayoutParams(localLayoutParams2);
      this.c.setLayoutParams(localLayoutParams1);
      this.mMessageBody.requestLayout();
      return;
      localLayoutParams2.addRule(11, -1);
      localLayoutParams2.addRule(9, 0);
      localLayoutParams1.setMargins(0, 0, getResources().getDimensionPixelOffset(2131230931), 0);
      localLayoutParams1.addRule(0, this.d.getId());
      localLayoutParams1.addRule(1, -1);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\view\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */