package com.xiaoenai.app.classes.street.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.utils.ab;

public class StreetProductStateView
  extends RelativeLayout
{
  private Context a = null;
  private RelativeLayout b = null;
  private a c = null;
  private int d = 0;
  
  public StreetProductStateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public StreetProductStateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    this.b = ((RelativeLayout)RelativeLayout.inflate(this.a, 2130903281, this));
    this.c = new a();
    this.c.a = ((ImageView)this.b.findViewById(2131559637));
    this.c.b = ((RelativeLayout)this.b.findViewById(2131559638));
    this.c.c = ((ImageView)this.b.findViewById(2131559639));
    this.c.d = ((TextView)this.b.findViewById(2131559640));
    this.c.e = ((RelativeLayout)this.b.findViewById(2131559641));
    this.c.f = ((TextView)this.b.findViewById(2131559642));
    this.c.g = ((TextView)this.b.findViewById(2131559644));
    this.c.h = ((TextView)this.b.findViewById(2131559645));
    this.c.i = ((TextView)this.b.findViewById(2131559646));
    this.c.j = (ab.b() - ab.a(20.0F));
    this.c.k = (this.c.j * 2 / 5);
    this.c.a.getLayoutParams().height = this.c.k;
    this.c.c.getLayoutParams().height = (this.c.j / 6);
    this.c.c.getLayoutParams().width = this.c.c.getLayoutParams().height;
    paramContext = this.c.e.getBackground();
    if (paramContext != null) {
      paramContext.setAlpha(127);
    }
  }
  
  public int getTimeLayoutWidth()
  {
    return ab.a(this.c.f, this.c.f.getText().toString()) + ab.a(this.c.g, this.c.g.getText().toString()) + ab.a(50.0F);
  }
  
  public void setProductStatus(int paramInt)
  {
    this.d = paramInt;
  }
  
  public class a
  {
    public ImageView a = null;
    public RelativeLayout b = null;
    public ImageView c = null;
    public TextView d = null;
    public RelativeLayout e = null;
    public TextView f = null;
    public TextView g = null;
    public TextView h = null;
    public TextView i = null;
    public int j = 0;
    public int k = 0;
    
    public a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\StreetProductStateView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */