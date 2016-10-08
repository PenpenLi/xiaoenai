package in.srain.cube.views.ptr.b;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class b
{
  public static int a;
  public static int b;
  public static float c;
  public static int d;
  public static int e;
  
  public static int a(float paramFloat)
  {
    return (int)(c * paramFloat + 0.5F);
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    a = localDisplayMetrics.widthPixels;
    b = localDisplayMetrics.heightPixels;
    c = localDisplayMetrics.density;
    d = (int)(a / localDisplayMetrics.density);
    e = (int)(b / localDisplayMetrics.density);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\in\srain\cube\views\ptr\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */