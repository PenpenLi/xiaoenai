package com.xiaoenai.app.ui.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;

public class a
  extends Dialog
{
  private Activity a = null;
  
  public a(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    if ((paramContext instanceof Activity)) {}
    for (paramContext = (Activity)paramContext;; paramContext = null)
    {
      if (paramContext != null) {
        this.a = paramContext;
      }
      return;
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a(getOwnerActivity());
  }
  
  public void show()
  {
    if ((this.a != null) && (this.a.isFinishing())) {
      return;
    }
    super.show();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\ui\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */