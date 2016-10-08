package com.xiaoenai.app.ui.component.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.xiaoenai.app.ui.component.a.a;
import com.xiaoenai.app.ui.component.a.c;

@Deprecated
public class AvatarView
  extends ImageView
{
  private Drawable a = null;
  private boolean b = false;
  private String c = null;
  private boolean d = false;
  private boolean e = true;
  
  public AvatarView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AvatarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.c.AvatarAttr);
    int i = paramContext.getResourceId(a.c.AvatarAttr_avatarCover, -1);
    if (i != -1) {
      this.a = getResources().getDrawable(i);
    }
    paramContext.recycle();
  }
  
  public void a(String paramString, com.xiaoenai.app.utils.e.d.b paramb)
  {
    com.xiaoenai.app.utils.e.b.a(this, paramString, Boolean.valueOf(false), paramb);
    invalidate();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.d = false;
    this.b = true;
    this.e = paramBoolean;
    if ((this.c == null) || (!this.c.equals(paramString)))
    {
      this.c = paramString;
      invalidate();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.a != null)
    {
      this.a.setBounds(0, 0, getWidth(), getHeight());
      this.a.draw(paramCanvas);
    }
    if ((!this.d) && (this.b))
    {
      this.d = true;
      com.xiaoenai.app.utils.e.b.a(this, this.c, this.e, getWidth(), a.a.avatar_round);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setImgage(String paramString)
  {
    com.xiaoenai.app.utils.e.b.a(this, paramString, Boolean.valueOf(true));
    invalidate();
  }
  
  public void setRoundedImage(String paramString)
  {
    this.d = false;
    this.b = true;
    if ((this.c == null) || (!this.c.equals(paramString)))
    {
      this.c = paramString;
      invalidate();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\ui\component\view\AvatarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */