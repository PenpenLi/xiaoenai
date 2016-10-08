package com.xiaoenai.app.classes.home;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.util.TypedValue;

public class d
{
  private static double[] a = { 0.0D, 0.01D, 0.02D, 0.04D, 0.05D, 0.06D, 0.07D, 0.08D, 0.1D, 0.11D, 0.12D, 0.14D, 0.15D, 0.16D, 0.17D, 0.18D, 0.2D, 0.21D, 0.22D, 0.24D, 0.25D, 0.27D, 0.28D, 0.3D, 0.32D, 0.34D, 0.36D, 0.38D, 0.4D, 0.42D, 0.44D, 0.46D, 0.48D, 0.5D, 0.53D, 0.56D, 0.59D, 0.62D, 0.65D, 0.68D, 0.71D, 0.74D, 0.77D, 0.8D, 0.83D, 0.86D, 0.89D, 0.92D, 0.95D, 0.98D, 1.0D, 1.06D, 1.12D, 1.18D, 1.24D, 1.3D, 1.36D, 1.42D, 1.48D, 1.54D, 1.6D, 1.66D, 1.72D, 1.78D, 1.84D, 1.9D, 1.96D, 2.0D, 2.12D, 2.25D, 2.37D, 2.5D, 2.62D, 2.75D, 2.87D, 3.0D, 3.2D, 3.4D, 3.6D, 3.8D, 4.0D, 4.3D, 4.7D, 4.9D, 5.0D, 5.5D, 6.0D, 6.5D, 6.8D, 7.0D, 7.3D, 7.5D, 7.8D, 8.0D, 8.4D, 8.7D, 9.0D, 9.4D, 9.6D, 9.8D, 10.0D };
  
  public static int a(Context paramContext, int paramInt)
  {
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(paramInt, localTypedValue, true);
    return localTypedValue.resourceId;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */