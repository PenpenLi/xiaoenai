package com.xiaoenai.app.classes.guide;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.xiaoenai.app.utils.ab;

public class GuideBaseView
  extends RelativeLayout
{
  private Button a;
  private RelativeLayout.LayoutParams b;
  
  public GuideBaseView(Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  public GuideBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    f();
  }
  
  private void f()
  {
    setBackgroundColor(-872415232);
    setFocusable(true);
    setClickable(true);
    setOnClickListener(new a(this));
    this.a = new Button(getContext());
    this.b = new RelativeLayout.LayoutParams(-2, -2);
    this.b.addRule(14, -1);
    this.b.addRule(12, -1);
    this.b.bottomMargin = ab.a(144.0F);
    this.a.setId(110);
    this.a.setBackgroundResource(2130838500);
    addView(this.a, this.b);
  }
  
  public void a()
  {
    this.a.setVisibility(8);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ImageView localImageView = new ImageView(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.addRule(10, -1);
    localImageView.setImageResource(paramInt1);
    localImageView.setId(paramInt2);
    addView(localImageView, localLayoutParams);
    requestLayout();
  }
  
  public void b()
  {
    View localView = View.inflate(getContext(), 2130903247, null);
    localView.findViewById(2131559474).setVisibility(0);
    localView.findViewById(2131559471).setVisibility(0);
    addView(localView);
    requestLayout();
  }
  
  public void c()
  {
    View localView = View.inflate(getContext(), 2130903247, null);
    localView.findViewById(2131559476).setVisibility(0);
    localView.findViewById(2131559472).setVisibility(0);
    addView(localView);
    requestLayout();
  }
  
  public void d()
  {
    View localView = View.inflate(getContext(), 2130903247, null);
    localView.findViewById(2131559478).setVisibility(0);
    localView.findViewById(2131559473).setVisibility(0);
    addView(localView);
    requestLayout();
  }
  
  public void e()
  {
    View localView = View.inflate(getContext(), 2130903247, null);
    localView.findViewById(2131559467).setVisibility(0);
    localView.findViewById(2131559469).setVisibility(0);
    localView.findViewById(2131559466).getLayoutParams().height = (ab.a() - (int)getResources().getDimension(2131230872) - ab.a(70.0F));
    addView(localView);
    requestLayout();
  }
  
  public Button getSureBtn()
  {
    return this.a;
  }
  
  public void setSureBtnListener(View.OnClickListener paramOnClickListener)
  {
    this.a.setOnClickListener(paramOnClickListener);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\guide\GuideBaseView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */