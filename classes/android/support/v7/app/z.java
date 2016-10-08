package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.a.a.a;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class z
  extends Dialog
  implements l
{
  private AppCompatDelegate a;
  
  public z(Context paramContext, int paramInt)
  {
    super(paramContext, a(paramContext, paramInt));
    a().a(null);
    a().h();
  }
  
  private static int a(Context paramContext, int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0)
    {
      TypedValue localTypedValue = new TypedValue();
      paramContext.getTheme().resolveAttribute(a.a.dialogTheme, localTypedValue, true);
      i = localTypedValue.resourceId;
    }
    return i;
  }
  
  public AppCompatDelegate a()
  {
    if (this.a == null) {
      this.a = AppCompatDelegate.a(this, this);
    }
    return this.a;
  }
  
  @Nullable
  public b a(b.a parama)
  {
    return null;
  }
  
  public void a(b paramb) {}
  
  public boolean a(int paramInt)
  {
    return a().c(paramInt);
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    a().b(paramView, paramLayoutParams);
  }
  
  public void b(b paramb) {}
  
  @Nullable
  public View findViewById(@IdRes int paramInt)
  {
    return a().a(paramInt);
  }
  
  public void invalidateOptionsMenu()
  {
    a().e();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    a().g();
    super.onCreate(paramBundle);
    a().a(paramBundle);
  }
  
  protected void onStop()
  {
    super.onStop();
    a().c();
  }
  
  public void setContentView(@LayoutRes int paramInt)
  {
    a().b(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    a().a(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    a().a(paramView, paramLayoutParams);
  }
  
  public void setTitle(int paramInt)
  {
    super.setTitle(paramInt);
    a().a(getContext().getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    a().a(paramCharSequence);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\app\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */