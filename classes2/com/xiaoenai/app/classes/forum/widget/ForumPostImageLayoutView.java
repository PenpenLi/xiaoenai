package com.xiaoenai.app.classes.forum.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.utils.e.a.c;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.utils.f.a;

public class ForumPostImageLayoutView
  extends RelativeLayout
{
  private Context a;
  private ImageView b;
  private ProgressView c;
  private RelativeLayout d;
  private TextView e;
  
  public ForumPostImageLayoutView(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    c();
  }
  
  public ForumPostImageLayoutView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    c();
  }
  
  private void c()
  {
    LayoutInflater.from(this.a).inflate(2130903192, this);
    this.b = ((ImageView)findViewById(2131559206));
    this.c = ((ProgressView)findViewById(2131559207));
    this.d = ((RelativeLayout)findViewById(2131558829));
    this.e = ((TextView)findViewById(2131559208));
  }
  
  public void a()
  {
    if (this.d != null) {
      this.d.setBackgroundColor(getResources().getColor(2131493177));
    }
  }
  
  public void a(String paramString, LinearLayout.LayoutParams paramLayoutParams, int paramInt)
  {
    a.c("================ setImaggViewSrc: {}", new Object[] { paramString });
    if (this.b != null)
    {
      if (paramString != null) {
        b.a(this.b, paramString, Boolean.valueOf(true), new e(this, paramInt, paramLayoutParams), c.b);
      }
    }
    else {
      return;
    }
    this.b.setImageResource(2131493177);
  }
  
  public void b()
  {
    if (this.d != null)
    {
      if (Build.VERSION.SDK_INT > 15) {
        this.d.setBackground(getResources().getDrawable(2130838478));
      }
    }
    else {
      return;
    }
    this.d.setBackgroundResource(2130838478);
  }
  
  public void setImageViewSrc(String paramString)
  {
    a(paramString, null, 0);
  }
  
  public void setProgressViewVisibility(int paramInt)
  {
    if (this.c != null) {
      this.c.setVisibility(paramInt);
    }
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (this.b != null) {
      this.b.setScaleType(paramScaleType);
    }
  }
  
  public void setTextViewVisibility(int paramInt)
  {
    if (this.e != null)
    {
      if (this.c.getVisibility() == 0) {
        this.e.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.e.setVisibility(paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\widget\ForumPostImageLayoutView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */