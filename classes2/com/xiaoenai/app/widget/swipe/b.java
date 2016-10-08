package com.xiaoenai.app.widget.swipe;

import android.app.Activity;
import java.lang.reflect.Method;

public class b
{
  public static void a(Activity paramActivity)
  {
    Object localObject = null;
    for (;;)
    {
      int i;
      try
      {
        Class[] arrayOfClass = Activity.class.getDeclaredClasses();
        int j = arrayOfClass.length;
        i = 0;
        if (i < j)
        {
          Class localClass = arrayOfClass[i];
          if (localClass.getSimpleName().contains("TranslucentConversionListener")) {
            localObject = localClass;
          }
        }
        else
        {
          localObject = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[] { localObject });
          ((Method)localObject).setAccessible(true);
          ((Method)localObject).invoke(paramActivity, new Object[] { null });
          return;
        }
      }
      catch (Throwable paramActivity)
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\swipe\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */