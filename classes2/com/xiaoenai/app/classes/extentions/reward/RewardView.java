package com.xiaoenai.app.classes.extentions.reward;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.e.b;

public class RewardView
  extends LinearLayout
{
  private ImageView a;
  private TextView b;
  private TextView c;
  private Button d;
  
  public RewardView(Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(getContext()).inflate(2130903179, this);
    a();
  }
  
  public RewardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    this.a = ((ImageView)findViewById(2131559135));
    this.b = ((TextView)findViewById(2131559136));
    this.c = ((TextView)findViewById(2131559137));
    this.d = ((Button)findViewById(2131559138));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = ab.a(paramInt1);
    paramInt2 = ab.a(paramInt2);
    paramInt3 = ab.a(paramInt3);
    paramInt4 = ab.a(paramInt4);
    if (this.d != null)
    {
      this.d.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
      this.d.invalidate();
      this.d.requestLayout();
      invalidate();
    }
  }
  
  public void setImageView(String paramString)
  {
    if ((this.a != null) && (paramString != null)) {
      b.a(this.a, paramString);
    }
  }
  
  public void setStateBtnColor(int paramInt)
  {
    if (this.d != null) {
      this.d.setTextColor(paramInt);
    }
  }
  
  public void setStateBtnRes(int paramInt)
  {
    if (this.d != null) {
      this.d.setBackgroundResource(paramInt);
    }
  }
  
  public void setStateBtnText(String paramString)
  {
    if ((this.d != null) && (paramString != null)) {
      this.d.setText(paramString);
    }
  }
  
  public void setStateClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.d != null) {
      this.d.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setTipsText(String paramString)
  {
    if ((this.c != null) && (paramString != null)) {
      this.c.setText(paramString);
    }
  }
  
  public void setTitleText(String paramString)
  {
    if ((this.b != null) && (paramString != null)) {
      this.b.setText(paramString);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\extentions\reward\RewardView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */