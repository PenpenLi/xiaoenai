package com.xiaoenai.app.ui.a;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.c.a.l;
import com.xiaoenai.app.ui.component.view.ProgressView;

public class h
  extends a
{
  protected ProgressView a = (ProgressView)this.d.findViewById(j.b.HintDialogProgressView);
  protected ImageView b = (ImageView)this.d.findViewById(j.b.HintDialogIcon);
  protected TextView c = (TextView)this.d.findViewById(j.b.HintDialogText);
  protected RelativeLayout d = (RelativeLayout)getLayoutInflater().inflate(j.c.common_dialog_hint_dialog, null);
  protected LinearLayout e = (LinearLayout)this.d.findViewById(j.b.HintDialogLayout);
  
  public h(Context paramContext)
  {
    super(paramContext, j.d.CommonDialog);
  }
  
  public static h a(Context paramContext)
  {
    paramContext = new h(paramContext);
    paramContext.b(2);
    return paramContext;
  }
  
  public static h a(Context paramContext, String paramString, long paramLong)
  {
    return a(paramContext, paramString, paramLong, null);
  }
  
  public static h a(Context paramContext, String paramString, long paramLong, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    paramContext = new h(paramContext);
    paramContext.a(paramString);
    paramContext.b(0);
    paramContext.a(paramLong);
    if (paramOnDismissListener != null)
    {
      paramContext.setOnDismissListener(paramOnDismissListener);
      paramContext.setCancelable(false);
    }
    return paramContext;
  }
  
  public static void a(Context paramContext, int paramInt, long paramLong)
  {
    a(paramContext, paramContext.getString(paramInt), paramLong, null);
  }
  
  public static void a(Context paramContext, int paramInt, long paramLong, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    a(paramContext, paramContext.getString(paramInt), paramLong, paramOnDismissListener);
  }
  
  public static h b(Context paramContext, int paramInt, long paramLong)
  {
    h localh = new h(paramContext);
    localh.a(paramContext.getString(paramInt));
    localh.a(paramLong);
    return localh;
  }
  
  public static h b(Context paramContext, int paramInt, long paramLong, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    return b(paramContext, paramContext.getString(paramInt), paramLong, paramOnDismissListener);
  }
  
  public static h b(Context paramContext, String paramString, long paramLong)
  {
    paramContext = new h(paramContext);
    paramContext.a(paramString);
    paramContext.a(paramLong);
    return paramContext;
  }
  
  public static h b(Context paramContext, String paramString, long paramLong, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    paramContext = new h(paramContext);
    paramContext.a(paramString);
    paramContext.b(1);
    paramContext.a(paramLong);
    paramContext.setOnDismissListener(paramOnDismissListener);
    return paramContext;
  }
  
  public static h c(Context paramContext, int paramInt, long paramLong)
  {
    return b(paramContext, paramContext.getString(paramInt), paramLong, null);
  }
  
  public static h c(Context paramContext, String paramString, long paramLong)
  {
    return b(paramContext, paramString, paramLong, null);
  }
  
  public void a(int paramInt)
  {
    if (paramInt <= 0)
    {
      this.c.setVisibility(8);
      return;
    }
    this.c.setText(paramInt);
    this.c.setVisibility(0);
  }
  
  public void a(long paramLong)
  {
    try
    {
      show();
      this.d.postDelayed(new i(this), paramLong);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      this.c.setVisibility(8);
      return;
    }
    this.c.setText(paramString);
    this.c.setVisibility(0);
  }
  
  public void b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.b.setVisibility(8);
      this.a.setVisibility(8);
      return;
    case 0: 
      this.b.setImageResource(j.a.common_dialog_hint_yes);
      this.b.setVisibility(0);
      this.a.setVisibility(8);
      return;
    case 1: 
      this.b.setImageResource(j.a.common_dialog_hint_error);
      this.b.setVisibility(0);
      this.a.setVisibility(8);
      return;
    }
    this.b.setVisibility(8);
    this.a.setVisibility(0);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(this.d);
    paramBundle = l.a(this.e, "alpha", new float[] { 0.0F, 1.0F });
    paramBundle.b(100L);
    paramBundle.a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\ui\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */