package com.inmobi.ads;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;

class j
{
  static Animation a(InMobiBanner.AnimationType paramAnimationType, float paramFloat1, float paramFloat2)
  {
    AlphaAnimation localAlphaAnimation = null;
    if (paramAnimationType == InMobiBanner.AnimationType.ANIMATION_ALPHA)
    {
      localAlphaAnimation = new AlphaAnimation(0.0F, 0.5F);
      localAlphaAnimation.setDuration(1000L);
      localAlphaAnimation.setFillAfter(false);
      localAlphaAnimation.setInterpolator(new DecelerateInterpolator());
    }
    do
    {
      return localAlphaAnimation;
      if (paramAnimationType == InMobiBanner.AnimationType.ROTATE_HORIZONTAL_AXIS)
      {
        paramAnimationType = new a(0.0F, 90.0F, paramFloat1 / 2.0F, paramFloat2 / 2.0F, 0.0F, true);
        paramAnimationType.setDuration(500L);
        paramAnimationType.setFillAfter(false);
        paramAnimationType.setInterpolator(new AccelerateInterpolator());
        return paramAnimationType;
      }
    } while (paramAnimationType != InMobiBanner.AnimationType.ROTATE_VERTICAL_AXIS);
    paramAnimationType = new b(0.0F, 90.0F, paramFloat1 / 2.0F, paramFloat2 / 2.0F, 0.0F, true);
    paramAnimationType.setDuration(500L);
    paramAnimationType.setFillAfter(false);
    paramAnimationType.setInterpolator(new AccelerateInterpolator());
    return paramAnimationType;
  }
  
  static class a
    extends Animation
  {
    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private final float e;
    private final boolean f;
    private Camera g;
    
    public a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, boolean paramBoolean)
    {
      this.a = paramFloat1;
      this.b = paramFloat2;
      this.c = paramFloat3;
      this.d = paramFloat4;
      this.e = paramFloat5;
      this.f = paramBoolean;
    }
    
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      float f1 = this.a;
      float f2 = this.b;
      float f3 = this.c;
      float f4 = this.d;
      Camera localCamera = this.g;
      paramTransformation = paramTransformation.getMatrix();
      localCamera.save();
      if (this.f) {
        localCamera.translate(0.0F, 0.0F, this.e * paramFloat);
      }
      for (;;)
      {
        localCamera.rotateX(f1 + (f2 - f1) * paramFloat);
        localCamera.getMatrix(paramTransformation);
        localCamera.restore();
        paramTransformation.preTranslate(-f3, -f4);
        paramTransformation.postTranslate(f3, f4);
        return;
        localCamera.translate(0.0F, 0.0F, this.e * (1.0F - paramFloat));
      }
    }
    
    public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
      this.g = new Camera();
    }
  }
  
  static class b
    extends Animation
  {
    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private final float e;
    private final boolean f;
    private Camera g;
    
    public b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, boolean paramBoolean)
    {
      this.a = paramFloat1;
      this.b = paramFloat2;
      this.c = paramFloat3;
      this.d = paramFloat4;
      this.e = paramFloat5;
      this.f = paramBoolean;
    }
    
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      float f1 = this.a;
      float f2 = this.b;
      float f3 = this.c;
      float f4 = this.d;
      Camera localCamera = this.g;
      paramTransformation = paramTransformation.getMatrix();
      localCamera.save();
      if (this.f) {
        localCamera.translate(0.0F, 0.0F, this.e * paramFloat);
      }
      for (;;)
      {
        localCamera.rotateY(f1 + (f2 - f1) * paramFloat);
        localCamera.getMatrix(paramTransformation);
        localCamera.restore();
        paramTransformation.preTranslate(-f3, -f4);
        paramTransformation.postTranslate(f3, f4);
        return;
        localCamera.translate(0.0F, 0.0F, this.e * (1.0F - paramFloat));
      }
    }
    
    public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
      this.g = new Camera();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */