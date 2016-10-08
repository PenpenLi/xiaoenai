package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.a.a.k;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class ActionBar
{
  public abstract int a();
  
  public b a(b.a parama)
  {
    return null;
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat != 0.0F) {
      throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
    }
  }
  
  public void a(Configuration paramConfiguration) {}
  
  public void a(CharSequence paramCharSequence) {}
  
  public void a(boolean paramBoolean) {}
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
    }
  }
  
  public abstract boolean b();
  
  public Context c()
  {
    return null;
  }
  
  public void c(boolean paramBoolean) {}
  
  public int d()
  {
    return 0;
  }
  
  public void d(boolean paramBoolean) {}
  
  public void e(boolean paramBoolean) {}
  
  public boolean e()
  {
    return false;
  }
  
  public boolean f()
  {
    return false;
  }
  
  boolean g()
  {
    return false;
  }
  
  void h() {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DisplayOptions {}
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public int gravity = 0;
    
    public LayoutParams(int paramInt)
    {
      this(-2, -1, paramInt);
    }
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      this.gravity = 8388627;
    }
    
    public LayoutParams(int paramInt1, int paramInt2, int paramInt3)
    {
      super(paramInt2);
      this.gravity = paramInt3;
    }
    
    public LayoutParams(@NonNull Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.ActionBarLayout);
      this.gravity = paramContext.getInt(a.k.ActionBarLayout_android_layout_gravity, 0);
      paramContext.recycle();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.gravity = paramLayoutParams.gravity;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface NavigationMode {}
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
  
  public static abstract class b
  {
    public abstract Drawable a();
    
    public abstract CharSequence b();
    
    public abstract View c();
    
    public abstract void d();
    
    public abstract CharSequence e();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\app\ActionBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */