package com.xiaoenai.app.classes.chat.messagelist.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.xiaoenai.app.utils.ab;

public class b
  extends BaseItemView
{
  private ImageView b;
  private String c = "";
  private ProgressGifView d;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.c = paramString;
    if (paramInt != 1)
    {
      this.d.a();
      this.b.setVisibility(4);
    }
    com.xiaoenai.app.utils.e.b.a(this.b, paramString, Boolean.valueOf(true), new c(this));
  }
  
  public View getMsgContentView()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    this.d = new ProgressGifView(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(ab.a(120.0F), ab.a(120.0F));
    this.b = new ImageView(getContext());
    this.b.setLayoutParams(localLayoutParams);
    localRelativeLayout.addView(this.d);
    localRelativeLayout.addView(this.b);
    return localRelativeLayout;
  }
  
  public void setImageResource(int paramInt)
  {
    if (this.d != null) {
      this.d.b();
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    this.b.setImageResource(paramInt);
    this.b.setLayoutParams(localLayoutParams);
    this.b.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
  }
  
  public void setUserType(int paramInt)
  {
    super.setUserType(paramInt);
    this.mMessageBody.setBackgroundDrawable(null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\view\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */