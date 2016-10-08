package android.support.v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.support.v7.graphics.drawable.a;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DrawableUtils
{
  public static final Rect INSETS_NONE = new Rect();
  private static final String TAG = "DrawableUtils";
  private static final String VECTOR_DRAWABLE_CLAZZ_NAME = "android.graphics.drawable.VectorDrawable";
  private static Class<?> sInsetsClazz;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 18) {}
    try
    {
      sInsetsClazz = Class.forName("android.graphics.Insets");
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
  }
  
  public static boolean canSafelyMutateDrawable(@NonNull Drawable paramDrawable)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramDrawable instanceof LayerDrawable)) {
      if (Build.VERSION.SDK_INT >= 16) {
        bool1 = true;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                return bool1;
                bool1 = false;
              }
              if (!(paramDrawable instanceof InsetDrawable)) {
                break;
              }
              bool1 = bool2;
            } while (Build.VERSION.SDK_INT >= 14);
            return false;
            if (!(paramDrawable instanceof StateListDrawable)) {
              break;
            }
            bool1 = bool2;
          } while (Build.VERSION.SDK_INT >= 8);
          return false;
          if (!(paramDrawable instanceof GradientDrawable)) {
            break;
          }
          bool1 = bool2;
        } while (Build.VERSION.SDK_INT >= 14);
        return false;
        if (!(paramDrawable instanceof DrawableContainer)) {
          break;
        }
        paramDrawable = paramDrawable.getConstantState();
        bool1 = bool2;
      } while (!(paramDrawable instanceof DrawableContainer.DrawableContainerState));
      paramDrawable = ((DrawableContainer.DrawableContainerState)paramDrawable).getChildren();
      int j = paramDrawable.length;
      int i = 0;
      for (;;)
      {
        bool1 = bool2;
        if (i >= j) {
          break;
        }
        if (!canSafelyMutateDrawable(paramDrawable[i])) {
          return false;
        }
        i += 1;
      }
      if ((paramDrawable instanceof DrawableWrapper)) {
        return canSafelyMutateDrawable(((DrawableWrapper)paramDrawable).getWrappedDrawable());
      }
      if ((paramDrawable instanceof a)) {
        return canSafelyMutateDrawable(((a)paramDrawable).a());
      }
      bool1 = bool2;
    } while (!(paramDrawable instanceof ScaleDrawable));
    return canSafelyMutateDrawable(((ScaleDrawable)paramDrawable).getDrawable());
  }
  
  static void fixDrawable(@NonNull Drawable paramDrawable)
  {
    if ((Build.VERSION.SDK_INT == 21) && ("android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName()))) {
      fixVectorDrawableTinting(paramDrawable);
    }
  }
  
  private static void fixVectorDrawableTinting(Drawable paramDrawable)
  {
    int[] arrayOfInt = paramDrawable.getState();
    if ((arrayOfInt == null) || (arrayOfInt.length == 0)) {
      paramDrawable.setState(bx.e);
    }
    for (;;)
    {
      paramDrawable.setState(arrayOfInt);
      return;
      paramDrawable.setState(bx.h);
    }
  }
  
  public static Rect getOpticalBounds(Drawable paramDrawable)
  {
    if (sInsetsClazz != null) {}
    for (;;)
    {
      Object localObject;
      Rect localRect;
      int j;
      int i;
      try
      {
        paramDrawable = DrawableCompat.unwrap(paramDrawable);
        localObject = paramDrawable.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(paramDrawable, new Object[0]);
        if (localObject == null) {
          break label213;
        }
        localRect = new Rect();
        Field[] arrayOfField = sInsetsClazz.getFields();
        int k = arrayOfField.length;
        j = 0;
        paramDrawable = localRect;
        if (j >= k) {
          break label217;
        }
        paramDrawable = arrayOfField[j];
        str = paramDrawable.getName();
        i = -1;
        switch (str.hashCode())
        {
        case 3317767: 
          if (!str.equals("left")) {
            break label255;
          }
          i = 0;
        }
      }
      catch (Exception paramDrawable)
      {
        String str;
        Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
      }
      if (str.equals("top"))
      {
        i = 1;
        break label255;
        if (str.equals("right"))
        {
          i = 2;
          break label255;
          if (str.equals("bottom"))
          {
            i = 3;
            break label255;
            localRect.left = paramDrawable.getInt(localObject);
            break label288;
            label213:
            paramDrawable = INSETS_NONE;
            label217:
            return paramDrawable;
            localRect.top = paramDrawable.getInt(localObject);
            break label288;
            localRect.right = paramDrawable.getInt(localObject);
            break label288;
            localRect.bottom = paramDrawable.getInt(localObject);
            break label288;
          }
        }
      }
      label255:
      switch (i)
      {
      }
      label288:
      j += 1;
    }
  }
  
  static PorterDuff.Mode parseTintMode(int paramInt, PorterDuff.Mode paramMode)
  {
    switch (paramInt)
    {
    }
    do
    {
      return paramMode;
      return PorterDuff.Mode.SRC_OVER;
      return PorterDuff.Mode.SRC_IN;
      return PorterDuff.Mode.SRC_ATOP;
      return PorterDuff.Mode.MULTIPLY;
      return PorterDuff.Mode.SCREEN;
    } while (Build.VERSION.SDK_INT < 11);
    return PorterDuff.Mode.valueOf("ADD");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\DrawableUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */