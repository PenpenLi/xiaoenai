package butterknife;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.support.annotation.CheckResult;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.UiThread;
import android.util.Log;
import android.util.Property;
import android.view.View;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ButterKnife
{
  static final Map<Class<?>, ViewBinder<Object>> BINDERS = new LinkedHashMap();
  static final ViewBinder<Object> NOP_VIEW_BINDER = new ButterKnife.1();
  private static final String TAG = "ButterKnife";
  private static boolean debug = false;
  
  private ButterKnife()
  {
    throw new AssertionError("No instances.");
  }
  
  @TargetApi(14)
  @RequiresApi
  @UiThread
  public static <T extends View, V> void apply(@NonNull T paramT, @NonNull Property<? super T, V> paramProperty, V paramV)
  {
    paramProperty.set(paramT, paramV);
  }
  
  @UiThread
  public static <T extends View> void apply(@NonNull T paramT, @NonNull Action<? super T> paramAction)
  {
    paramAction.apply(paramT, 0);
  }
  
  @UiThread
  public static <T extends View, V> void apply(@NonNull T paramT, @NonNull Setter<? super T, V> paramSetter, V paramV)
  {
    paramSetter.set(paramT, paramV, 0);
  }
  
  @SafeVarargs
  @UiThread
  public static <T extends View> void apply(@NonNull T paramT, @NonNull Action<? super T>... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramVarArgs[i].apply(paramT, 0);
      i += 1;
    }
  }
  
  @TargetApi(14)
  @RequiresApi
  @UiThread
  public static <T extends View, V> void apply(@NonNull List<T> paramList, @NonNull Property<? super T, V> paramProperty, V paramV)
  {
    int i = 0;
    int j = paramList.size();
    while (i < j)
    {
      paramProperty.set(paramList.get(i), paramV);
      i += 1;
    }
  }
  
  @UiThread
  public static <T extends View> void apply(@NonNull List<T> paramList, @NonNull Action<? super T> paramAction)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      paramAction.apply((View)paramList.get(i), i);
      i += 1;
    }
  }
  
  @UiThread
  public static <T extends View, V> void apply(@NonNull List<T> paramList, @NonNull Setter<? super T, V> paramSetter, V paramV)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      paramSetter.set((View)paramList.get(i), paramV, i);
      i += 1;
    }
  }
  
  @SafeVarargs
  @UiThread
  public static <T extends View> void apply(@NonNull List<T> paramList, @NonNull Action<? super T>... paramVarArgs)
  {
    int k = paramList.size();
    int i = 0;
    while (i < k)
    {
      int m = paramVarArgs.length;
      int j = 0;
      while (j < m)
      {
        paramVarArgs[j].apply((View)paramList.get(i), i);
        j += 1;
      }
      i += 1;
    }
  }
  
  @TargetApi(14)
  @RequiresApi
  @UiThread
  public static <T extends View, V> void apply(@NonNull T[] paramArrayOfT, @NonNull Property<? super T, V> paramProperty, V paramV)
  {
    int i = 0;
    int j = paramArrayOfT.length;
    while (i < j)
    {
      paramProperty.set(paramArrayOfT[i], paramV);
      i += 1;
    }
  }
  
  @UiThread
  public static <T extends View> void apply(@NonNull T[] paramArrayOfT, @NonNull Action<? super T> paramAction)
  {
    int i = 0;
    int j = paramArrayOfT.length;
    while (i < j)
    {
      paramAction.apply(paramArrayOfT[i], i);
      i += 1;
    }
  }
  
  @UiThread
  public static <T extends View, V> void apply(@NonNull T[] paramArrayOfT, @NonNull Setter<? super T, V> paramSetter, V paramV)
  {
    int i = 0;
    int j = paramArrayOfT.length;
    while (i < j)
    {
      paramSetter.set(paramArrayOfT[i], paramV, i);
      i += 1;
    }
  }
  
  @SafeVarargs
  @UiThread
  public static <T extends View> void apply(@NonNull T[] paramArrayOfT, @NonNull Action<? super T>... paramVarArgs)
  {
    int k = paramArrayOfT.length;
    int i = 0;
    while (i < k)
    {
      int m = paramVarArgs.length;
      int j = 0;
      while (j < m)
      {
        paramVarArgs[j].apply(paramArrayOfT[i], i);
        j += 1;
      }
      i += 1;
    }
  }
  
  @NonNull
  @UiThread
  public static Unbinder bind(@NonNull Activity paramActivity)
  {
    return getViewBinder(paramActivity).bind(Finder.ACTIVITY, paramActivity, paramActivity);
  }
  
  @NonNull
  @UiThread
  public static Unbinder bind(@NonNull Dialog paramDialog)
  {
    return getViewBinder(paramDialog).bind(Finder.DIALOG, paramDialog, paramDialog);
  }
  
  @NonNull
  @UiThread
  public static Unbinder bind(@NonNull View paramView)
  {
    return getViewBinder(paramView).bind(Finder.VIEW, paramView, paramView);
  }
  
  @NonNull
  @UiThread
  public static Unbinder bind(@NonNull Object paramObject, @NonNull Activity paramActivity)
  {
    return getViewBinder(paramObject).bind(Finder.ACTIVITY, paramObject, paramActivity);
  }
  
  @NonNull
  @UiThread
  public static Unbinder bind(@NonNull Object paramObject, @NonNull Dialog paramDialog)
  {
    return getViewBinder(paramObject).bind(Finder.DIALOG, paramObject, paramDialog);
  }
  
  @NonNull
  @UiThread
  public static Unbinder bind(@NonNull Object paramObject, @NonNull View paramView)
  {
    return getViewBinder(paramObject).bind(Finder.VIEW, paramObject, paramView);
  }
  
  @CheckResult
  public static <T extends View> T findById(@NonNull Activity paramActivity, @IdRes int paramInt)
  {
    return paramActivity.findViewById(paramInt);
  }
  
  @CheckResult
  public static <T extends View> T findById(@NonNull Dialog paramDialog, @IdRes int paramInt)
  {
    return paramDialog.findViewById(paramInt);
  }
  
  @CheckResult
  public static <T extends View> T findById(@NonNull View paramView, @IdRes int paramInt)
  {
    return paramView.findViewById(paramInt);
  }
  
  @CheckResult
  @NonNull
  @UiThread
  private static ViewBinder<Object> findViewBinderForClass(Class<?> paramClass)
  {
    Object localObject = (ViewBinder)BINDERS.get(paramClass);
    if (localObject != null)
    {
      if (debug) {
        Log.d("ButterKnife", "HIT: Cached in view binder map.");
      }
      return (ViewBinder<Object>)localObject;
    }
    str = paramClass.getName();
    if ((str.startsWith("android.")) || (str.startsWith("java.")))
    {
      if (debug) {
        Log.d("ButterKnife", "MISS: Reached framework class. Abandoning search.");
      }
      return NOP_VIEW_BINDER;
    }
    try
    {
      ViewBinder localViewBinder2 = (ViewBinder)Class.forName(str + "_ViewBinder").newInstance();
      localObject = localViewBinder2;
      if (debug)
      {
        Log.d("ButterKnife", "HIT: Loaded view binder class.");
        localObject = localViewBinder2;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        if (debug) {
          Log.d("ButterKnife", "Not found. Trying superclass " + paramClass.getSuperclass().getName());
        }
        ViewBinder localViewBinder1 = findViewBinderForClass(paramClass.getSuperclass());
      }
    }
    catch (InstantiationException paramClass)
    {
      throw new RuntimeException("Unable to create view binder for " + str, paramClass);
    }
    catch (IllegalAccessException paramClass)
    {
      throw new RuntimeException("Unable to create view binder for " + str, paramClass);
    }
    BINDERS.put(paramClass, localObject);
    return (ViewBinder<Object>)localObject;
  }
  
  @CheckResult
  @NonNull
  @UiThread
  static ViewBinder<Object> getViewBinder(@NonNull Object paramObject)
  {
    paramObject = paramObject.getClass();
    if (debug) {
      Log.d("ButterKnife", "Looking up view binder for " + ((Class)paramObject).getName());
    }
    return findViewBinderForClass((Class)paramObject);
  }
  
  public static void setDebug(boolean paramBoolean)
  {
    debug = paramBoolean;
  }
  
  public static abstract interface Action<T extends View>
  {
    @UiThread
    public abstract void apply(@NonNull T paramT, int paramInt);
  }
  
  public static abstract interface Setter<T extends View, V>
  {
    @UiThread
    public abstract void set(@NonNull T paramT, V paramV, int paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\butterknife\ButterKnife.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */