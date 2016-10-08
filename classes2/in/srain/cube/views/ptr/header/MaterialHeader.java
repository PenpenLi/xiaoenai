package in.srain.cube.views.ptr.header;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Animation;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class MaterialHeader
  extends View
  implements in.srain.cube.views.ptr.d
{
  private d a;
  private float b = 1.0F;
  private PtrFrameLayout c;
  private Animation d = new a(this);
  
  public MaterialHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public MaterialHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = new d(getContext(), this);
    this.a.b(-1);
    this.a.setCallback(this);
  }
  
  public void a(PtrFrameLayout paramPtrFrameLayout)
  {
    this.b = 1.0F;
    this.a.stop();
  }
  
  public void a(PtrFrameLayout paramPtrFrameLayout, boolean paramBoolean, byte paramByte, in.srain.cube.views.ptr.a.a parama)
  {
    float f = Math.min(1.0F, parama.w());
    if (paramByte == 2)
    {
      this.a.setAlpha((int)(255.0F * f));
      this.a.a(true);
      this.a.a(0.0F, Math.min(0.8F, f * 0.8F));
      this.a.a(Math.min(1.0F, f));
      this.a.b((f * 2.0F + (-0.25F + 0.4F * f)) * 0.5F);
      invalidate();
    }
  }
  
  public void b(PtrFrameLayout paramPtrFrameLayout) {}
  
  public void c(PtrFrameLayout paramPtrFrameLayout)
  {
    this.a.setAlpha(255);
    this.a.start();
  }
  
  public void d(PtrFrameLayout paramPtrFrameLayout)
  {
    this.a.stop();
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == this.a)
    {
      invalidate();
      return;
    }
    super.invalidateDrawable(paramDrawable);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = paramCanvas.save();
    Rect localRect = this.a.getBounds();
    paramCanvas.translate(getPaddingLeft() + (getMeasuredWidth() - this.a.getIntrinsicWidth()) / 2, getPaddingTop());
    paramCanvas.scale(this.b, this.b, localRect.exactCenterX(), localRect.exactCenterY());
    this.a.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = this.a.getIntrinsicHeight();
    this.a.setBounds(0, 0, paramInt1, paramInt1);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.a.getIntrinsicHeight() + getPaddingTop() + getPaddingBottom(), 1073741824));
  }
  
  public void setColorSchemeColors(int[] paramArrayOfInt)
  {
    this.a.a(paramArrayOfInt);
    invalidate();
  }
  
  public void setPtrFrameLayout(PtrFrameLayout paramPtrFrameLayout)
  {
    b localb = new b(this);
    this.d.setDuration(200L);
    this.d.setAnimationListener(new c(this, localb));
    this.c = paramPtrFrameLayout;
    this.c.setRefreshCompleteHook(localb);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\in\srain\cube\views\ptr\header\MaterialHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */