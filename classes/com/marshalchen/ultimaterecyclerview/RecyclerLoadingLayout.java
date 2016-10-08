package com.marshalchen.ultimaterecyclerview;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.a.a;
import in.srain.cube.views.ptr.d;

public class RecyclerLoadingLayout
  extends FrameLayout
  implements d
{
  private final String a;
  private final String b;
  private final String c;
  private RotateAnimation d;
  private float e;
  @BindView(2131559681)
  TextView mHeaderTxt;
  @BindView(2131559680)
  ImageView mRotateImg;
  
  public RecyclerLoadingLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RecyclerLoadingLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RecyclerLoadingLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    View.inflate(paramContext, 2130903300, this);
    this.a = paramContext.getString(2131099677);
    this.b = paramContext.getString(2131099678);
    this.c = paramContext.getString(2131099679);
    a();
  }
  
  private void a()
  {
    ButterKnife.bind(this);
    this.d = new RotateAnimation(this.e, this.e + 360.0F, 1, 0.5F, 1, 0.5F);
    this.d.setDuration(1000L);
    this.d.setRepeatCount(-1);
    this.d.setRepeatMode(1);
  }
  
  public void a(PtrFrameLayout paramPtrFrameLayout)
  {
    this.mRotateImg.clearAnimation();
  }
  
  @TargetApi(11)
  public void a(PtrFrameLayout paramPtrFrameLayout, boolean paramBoolean, byte paramByte, a parama)
  {
    if (paramPtrFrameLayout.c()) {
      return;
    }
    float f = parama.w();
    this.e = Math.max(0.0F, Math.min(180.0F, 360.0F * f - 180.0F));
    this.mRotateImg.setRotation(this.e);
    if (f < 1.0D)
    {
      this.mHeaderTxt.setText(this.a);
      return;
    }
    this.mHeaderTxt.setText(this.c);
  }
  
  public void b(PtrFrameLayout paramPtrFrameLayout)
  {
    this.mHeaderTxt.setText(this.a);
  }
  
  public void c(PtrFrameLayout paramPtrFrameLayout)
  {
    this.mHeaderTxt.setText(this.b);
    this.mRotateImg.startAnimation(this.d);
  }
  
  public void d(PtrFrameLayout paramPtrFrameLayout)
  {
    this.mRotateImg.clearAnimation();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\RecyclerLoadingLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */