package com.xiaoenai.app.classes.common.ads;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.R.styleable;

public class AdsView
  extends RelativeLayout
{
  private a a;
  private int b = 1;
  
  public AdsView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AdsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public AdsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    this.b = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.Ads).getInt(0, 1);
  }
  
  public void a()
  {
    this.a = new a();
    this.a.a = new View(getContext());
    this.a.a.setId(2131558410);
    this.a.b = new View(getContext());
    this.a.b.setId(2131558407);
    this.a.c = new ImageView(getContext());
    this.a.c.setId(2131558404);
    this.a.d = new TextView(getContext());
    this.a.d.setId(2131558411);
    this.a.e = new TextView(getContext());
    this.a.e.setId(2131558406);
    this.a.f = new ImageView(getContext());
    this.a.f.setId(2131558405);
    this.a.g = new TextView(getContext());
    this.a.g.setId(2131558408);
    this.a.h = new Button(getContext());
    this.a.h.setId(2131558409);
    this.a.i = new RelativeLayout(getContext());
  }
  
  public int getType()
  {
    return this.b;
  }
  
  public a getViewHolder()
  {
    return this.a;
  }
  
  public void setType(int paramInt)
  {
    this.b = paramInt;
  }
  
  public class a
  {
    public View a;
    public View b;
    public ImageView c;
    public TextView d;
    public TextView e;
    public ImageView f;
    public TextView g;
    public Button h;
    public RelativeLayout i;
    
    public a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\ads\AdsView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */