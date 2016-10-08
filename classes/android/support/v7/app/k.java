package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;

public class k
  extends z
  implements DialogInterface
{
  private a a = new a(getContext(), this, getWindow());
  
  k(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, a(paramContext, paramInt));
  }
  
  static int a(Context paramContext, int paramInt)
  {
    if (paramInt >= 16777216) {
      return paramInt;
    }
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(android.support.v7.a.a.a.alertDialogTheme, localTypedValue, true);
    return localTypedValue.resourceId;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a.a();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.a.a(paramInt, paramKeyEvent)) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.a.b(paramInt, paramKeyEvent)) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    this.a.a(paramCharSequence);
  }
  
  public static class a
  {
    private final a.a a;
    private int b;
    
    public a(Context paramContext)
    {
      this(paramContext, k.a(paramContext, 0));
    }
    
    public a(Context paramContext, int paramInt)
    {
      this.a = new a.a(new ContextThemeWrapper(paramContext, k.a(paramContext, paramInt)));
      this.b = paramInt;
    }
    
    public Context a()
    {
      return this.a.a;
    }
    
    public a a(DialogInterface.OnKeyListener paramOnKeyListener)
    {
      this.a.r = paramOnKeyListener;
      return this;
    }
    
    public a a(Drawable paramDrawable)
    {
      this.a.d = paramDrawable;
      return this;
    }
    
    public a a(View paramView)
    {
      this.a.g = paramView;
      return this;
    }
    
    public a a(ListAdapter paramListAdapter, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.a.t = paramListAdapter;
      this.a.u = paramOnClickListener;
      return this;
    }
    
    public a a(CharSequence paramCharSequence)
    {
      this.a.f = paramCharSequence;
      return this;
    }
    
    public k b()
    {
      k localk = new k(this.a.a, this.b, false);
      this.a.a(k.a(localk));
      localk.setCancelable(this.a.o);
      if (this.a.o) {
        localk.setCanceledOnTouchOutside(true);
      }
      localk.setOnCancelListener(this.a.p);
      localk.setOnDismissListener(this.a.q);
      if (this.a.r != null) {
        localk.setOnKeyListener(this.a.r);
      }
      return localk;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\app\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */