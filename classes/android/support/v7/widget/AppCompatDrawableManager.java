package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.a.a.b;
import android.support.a.a.g;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.LruCache;
import android.support.v7.a.a.a;
import android.support.v7.a.a.e;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class AppCompatDrawableManager
{
  private static final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY;
  private static final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED;
  private static final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL;
  private static final b COLOR_FILTER_CACHE;
  private static final boolean DEBUG = false;
  private static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
  private static AppCompatDrawableManager INSTANCE;
  private static final String PLATFORM_VD_CLAZZ = "android.graphics.drawable.VectorDrawable";
  private static final String SKIP_DRAWABLE_TAG = "appcompat_skip_skip";
  private static final String TAG = "AppCompatDrawableManager";
  private static final int[] TINT_CHECKABLE_BUTTON_LIST = { a.e.abc_btn_check_material, a.e.abc_btn_radio_material };
  private static final int[] TINT_COLOR_CONTROL_NORMAL;
  private static final int[] TINT_COLOR_CONTROL_STATE_LIST;
  private ArrayMap<String, c> mDelegates;
  private final Object mDrawableCacheLock = new Object();
  private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> mDrawableCaches = new WeakHashMap(0);
  private boolean mHasCheckedVectorDrawableSetup;
  private SparseArray<String> mKnownDrawableIdTags;
  private WeakHashMap<Context, SparseArray<ColorStateList>> mTintLists;
  private TypedValue mTypedValue;
  
  static
  {
    COLOR_FILTER_CACHE = new b(6);
    COLORFILTER_TINT_COLOR_CONTROL_NORMAL = new int[] { a.e.abc_textfield_search_default_mtrl_alpha, a.e.abc_textfield_default_mtrl_alpha, a.e.abc_ab_share_pack_mtrl_alpha };
    TINT_COLOR_CONTROL_NORMAL = new int[] { a.e.abc_ic_ab_back_mtrl_am_alpha, a.e.abc_ic_go_search_api_mtrl_alpha, a.e.abc_ic_search_api_mtrl_alpha, a.e.abc_ic_commit_search_api_mtrl_alpha, a.e.abc_ic_clear_mtrl_alpha, a.e.abc_ic_menu_share_mtrl_alpha, a.e.abc_ic_menu_copy_mtrl_am_alpha, a.e.abc_ic_menu_cut_mtrl_alpha, a.e.abc_ic_menu_selectall_mtrl_alpha, a.e.abc_ic_menu_paste_mtrl_am_alpha, a.e.abc_ic_menu_moreoverflow_mtrl_alpha, a.e.abc_ic_voice_search_api_mtrl_alpha };
    COLORFILTER_COLOR_CONTROL_ACTIVATED = new int[] { a.e.abc_textfield_activated_mtrl_alpha, a.e.abc_textfield_search_activated_mtrl_alpha, a.e.abc_cab_background_top_mtrl_alpha, a.e.abc_text_cursor_material };
    COLORFILTER_COLOR_BACKGROUND_MULTIPLY = new int[] { a.e.abc_popup_background_mtrl_mult, a.e.abc_cab_background_internal_bg, a.e.abc_menu_hardkey_panel_mtrl_mult };
    TINT_COLOR_CONTROL_STATE_LIST = new int[] { a.e.abc_edit_text_material, a.e.abc_tab_indicator_material, a.e.abc_textfield_search_material, a.e.abc_spinner_mtrl_am_alpha, a.e.abc_spinner_textfield_background_material, a.e.abc_ratingbar_full_material, a.e.abc_switch_track_mtrl_alpha, a.e.abc_switch_thumb_material, a.e.abc_btn_default_mtrl_shape, a.e.abc_btn_borderless_material };
  }
  
  private void addDelegate(@NonNull String paramString, @NonNull c paramc)
  {
    if (this.mDelegates == null) {
      this.mDelegates = new ArrayMap();
    }
    this.mDelegates.put(paramString, paramc);
  }
  
  private boolean addDrawableToCache(@NonNull Context paramContext, long paramLong, @NonNull Drawable paramDrawable)
  {
    Drawable.ConstantState localConstantState = paramDrawable.getConstantState();
    if (localConstantState != null) {
      synchronized (this.mDrawableCacheLock)
      {
        LongSparseArray localLongSparseArray = (LongSparseArray)this.mDrawableCaches.get(paramContext);
        paramDrawable = localLongSparseArray;
        if (localLongSparseArray == null)
        {
          paramDrawable = new LongSparseArray();
          this.mDrawableCaches.put(paramContext, paramDrawable);
        }
        paramDrawable.put(paramLong, new WeakReference(localConstantState));
        return true;
      }
    }
    return false;
  }
  
  private void addTintListToCache(@NonNull Context paramContext, @DrawableRes int paramInt, @NonNull ColorStateList paramColorStateList)
  {
    if (this.mTintLists == null) {
      this.mTintLists = new WeakHashMap();
    }
    SparseArray localSparseArray2 = (SparseArray)this.mTintLists.get(paramContext);
    SparseArray localSparseArray1 = localSparseArray2;
    if (localSparseArray2 == null)
    {
      localSparseArray1 = new SparseArray();
      this.mTintLists.put(paramContext, localSparseArray1);
    }
    localSparseArray1.append(paramInt, paramColorStateList);
  }
  
  private static boolean arrayContains(int[] paramArrayOfInt, int paramInt)
  {
    boolean bool2 = false;
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private ColorStateList createBorderlessButtonColorStateList(Context paramContext)
  {
    return createButtonColorStateList(paramContext, 0);
  }
  
  private ColorStateList createButtonColorStateList(Context paramContext, @ColorInt int paramInt)
  {
    int k = bx.a(paramContext, a.a.colorControlHighlight);
    int[] arrayOfInt1 = bx.a;
    int i = bx.c(paramContext, a.a.colorButtonNormal);
    paramContext = bx.d;
    int j = ColorUtils.compositeColors(k, paramInt);
    int[] arrayOfInt2 = bx.b;
    k = ColorUtils.compositeColors(k, paramInt);
    return new ColorStateList(new int[][] { arrayOfInt1, paramContext, arrayOfInt2, bx.h }, new int[] { i, j, k, paramInt });
  }
  
  private static long createCacheKey(TypedValue paramTypedValue)
  {
    return paramTypedValue.assetCookie << 32 | paramTypedValue.data;
  }
  
  private ColorStateList createCheckableButtonColorStateList(Context paramContext)
  {
    int[] arrayOfInt1 = bx.a;
    int i = bx.c(paramContext, a.a.colorControlNormal);
    int[] arrayOfInt2 = bx.e;
    int j = bx.a(paramContext, a.a.colorControlActivated);
    int[] arrayOfInt3 = bx.h;
    int k = bx.a(paramContext, a.a.colorControlNormal);
    return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3 }, new int[] { i, j, k });
  }
  
  private ColorStateList createColoredButtonColorStateList(Context paramContext)
  {
    return createButtonColorStateList(paramContext, bx.a(paramContext, a.a.colorAccent));
  }
  
  private ColorStateList createDefaultButtonColorStateList(Context paramContext)
  {
    return createButtonColorStateList(paramContext, bx.a(paramContext, a.a.colorButtonNormal));
  }
  
  private ColorStateList createDefaultColorStateList(Context paramContext)
  {
    int i = bx.a(paramContext, a.a.colorControlNormal);
    int j = bx.a(paramContext, a.a.colorControlActivated);
    int[] arrayOfInt = bx.a;
    int k = bx.c(paramContext, a.a.colorControlNormal);
    return new ColorStateList(new int[][] { arrayOfInt, bx.b, bx.c, bx.d, bx.e, bx.f, bx.h }, new int[] { k, j, j, j, j, j, i });
  }
  
  private Drawable createDrawableIfNeeded(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    if (this.mTypedValue == null) {
      this.mTypedValue = new TypedValue();
    }
    TypedValue localTypedValue = this.mTypedValue;
    paramContext.getResources().getValue(paramInt, localTypedValue, true);
    long l = createCacheKey(localTypedValue);
    Object localObject1 = getCachedDrawable(paramContext, l);
    Object localObject2;
    if (localObject1 != null) {
      localObject2 = localObject1;
    }
    do
    {
      return (Drawable)localObject2;
      if (paramInt == a.e.abc_cab_background_top_material) {
        localObject1 = new LayerDrawable(new Drawable[] { getDrawable(paramContext, a.e.abc_cab_background_internal_bg), getDrawable(paramContext, a.e.abc_cab_background_top_mtrl_alpha) });
      }
      localObject2 = localObject1;
    } while (localObject1 == null);
    ((Drawable)localObject1).setChangingConfigurations(localTypedValue.changingConfigurations);
    addDrawableToCache(paramContext, l, (Drawable)localObject1);
    return (Drawable)localObject1;
  }
  
  private ColorStateList createEditTextColorStateList(Context paramContext)
  {
    int[] arrayOfInt1 = bx.a;
    int i = bx.c(paramContext, a.a.colorControlNormal);
    int[] arrayOfInt2 = bx.g;
    int j = bx.a(paramContext, a.a.colorControlNormal);
    int[] arrayOfInt3 = bx.h;
    int k = bx.a(paramContext, a.a.colorControlActivated);
    return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3 }, new int[] { i, j, k });
  }
  
  private ColorStateList createSeekbarThumbColorStateList(Context paramContext)
  {
    int[] arrayOfInt1 = bx.a;
    int i = bx.c(paramContext, a.a.colorControlActivated);
    int[] arrayOfInt2 = bx.h;
    int j = bx.a(paramContext, a.a.colorControlActivated);
    return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2 }, new int[] { i, j });
  }
  
  private ColorStateList createSpinnerColorStateList(Context paramContext)
  {
    int[] arrayOfInt1 = bx.a;
    int i = bx.c(paramContext, a.a.colorControlNormal);
    int[] arrayOfInt2 = bx.g;
    int j = bx.a(paramContext, a.a.colorControlNormal);
    int[] arrayOfInt3 = bx.h;
    int k = bx.a(paramContext, a.a.colorControlActivated);
    return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3 }, new int[] { i, j, k });
  }
  
  private ColorStateList createSwitchThumbColorStateList(Context paramContext)
  {
    int[][] arrayOfInt = new int[3][];
    int[] arrayOfInt1 = new int[3];
    ColorStateList localColorStateList = bx.b(paramContext, a.a.colorSwitchThumbNormal);
    if ((localColorStateList != null) && (localColorStateList.isStateful()))
    {
      arrayOfInt[0] = bx.a;
      arrayOfInt1[0] = localColorStateList.getColorForState(arrayOfInt[0], 0);
      arrayOfInt[1] = bx.e;
      arrayOfInt1[1] = bx.a(paramContext, a.a.colorControlActivated);
      arrayOfInt[2] = bx.h;
      arrayOfInt1[2] = localColorStateList.getDefaultColor();
    }
    for (;;)
    {
      return new ColorStateList(arrayOfInt, arrayOfInt1);
      arrayOfInt[0] = bx.a;
      arrayOfInt1[0] = bx.c(paramContext, a.a.colorSwitchThumbNormal);
      arrayOfInt[1] = bx.e;
      arrayOfInt1[1] = bx.a(paramContext, a.a.colorControlActivated);
      arrayOfInt[2] = bx.h;
      arrayOfInt1[2] = bx.a(paramContext, a.a.colorSwitchThumbNormal);
    }
  }
  
  private ColorStateList createSwitchTrackColorStateList(Context paramContext)
  {
    int[] arrayOfInt1 = bx.a;
    int i = bx.a(paramContext, 16842800, 0.1F);
    int[] arrayOfInt2 = bx.e;
    int j = bx.a(paramContext, a.a.colorControlActivated, 0.3F);
    int[] arrayOfInt3 = bx.h;
    int k = bx.a(paramContext, 16842800, 0.3F);
    return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3 }, new int[] { i, j, k });
  }
  
  private static PorterDuffColorFilter createTintFilter(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int[] paramArrayOfInt)
  {
    if ((paramColorStateList == null) || (paramMode == null)) {
      return null;
    }
    return getPorterDuffColorFilter(paramColorStateList.getColorForState(paramArrayOfInt, 0), paramMode);
  }
  
  public static AppCompatDrawableManager get()
  {
    if (INSTANCE == null)
    {
      INSTANCE = new AppCompatDrawableManager();
      installDefaultInflateDelegates(INSTANCE);
    }
    return INSTANCE;
  }
  
  private Drawable getCachedDrawable(@NonNull Context paramContext, long paramLong)
  {
    LongSparseArray localLongSparseArray;
    synchronized (this.mDrawableCacheLock)
    {
      localLongSparseArray = (LongSparseArray)this.mDrawableCaches.get(paramContext);
      if (localLongSparseArray == null) {
        return null;
      }
      Object localObject2 = (WeakReference)localLongSparseArray.get(paramLong);
      if (localObject2 == null) {
        break label90;
      }
      localObject2 = (Drawable.ConstantState)((WeakReference)localObject2).get();
      if (localObject2 != null)
      {
        paramContext = ((Drawable.ConstantState)localObject2).newDrawable(paramContext.getResources());
        return paramContext;
      }
    }
    localLongSparseArray.delete(paramLong);
    label90:
    return null;
  }
  
  public static PorterDuffColorFilter getPorterDuffColorFilter(int paramInt, PorterDuff.Mode paramMode)
  {
    PorterDuffColorFilter localPorterDuffColorFilter2 = COLOR_FILTER_CACHE.a(paramInt, paramMode);
    PorterDuffColorFilter localPorterDuffColorFilter1 = localPorterDuffColorFilter2;
    if (localPorterDuffColorFilter2 == null)
    {
      localPorterDuffColorFilter1 = new PorterDuffColorFilter(paramInt, paramMode);
      COLOR_FILTER_CACHE.a(paramInt, paramMode, localPorterDuffColorFilter1);
    }
    return localPorterDuffColorFilter1;
  }
  
  private ColorStateList getTintListFromCache(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    if (this.mTintLists != null)
    {
      paramContext = (SparseArray)this.mTintLists.get(paramContext);
      if (paramContext != null) {
        return (ColorStateList)paramContext.get(paramInt);
      }
      return null;
    }
    return null;
  }
  
  private static void installDefaultInflateDelegates(@NonNull AppCompatDrawableManager paramAppCompatDrawableManager)
  {
    int i = Build.VERSION.SDK_INT;
    if (i < 23)
    {
      paramAppCompatDrawableManager.addDelegate("vector", new d(null));
      if (i >= 11) {
        paramAppCompatDrawableManager.addDelegate("animated-vector", new a(null));
      }
    }
  }
  
  private static boolean isVectorDrawable(@NonNull Drawable paramDrawable)
  {
    return ((paramDrawable instanceof g)) || ("android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName()));
  }
  
  private Drawable loadDrawableFromDelegates(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    if ((this.mDelegates != null) && (!this.mDelegates.isEmpty()))
    {
      if (this.mKnownDrawableIdTags != null)
      {
        localObject1 = (String)this.mKnownDrawableIdTags.get(paramInt);
        if (("appcompat_skip_skip".equals(localObject1)) || ((localObject1 != null) && (this.mDelegates.get(localObject1) == null)))
        {
          localObject1 = null;
          return (Drawable)localObject1;
        }
      }
      else
      {
        this.mKnownDrawableIdTags = new SparseArray();
      }
      if (this.mTypedValue == null) {
        this.mTypedValue = new TypedValue();
      }
      TypedValue localTypedValue = this.mTypedValue;
      Object localObject1 = paramContext.getResources();
      ((Resources)localObject1).getValue(paramInt, localTypedValue, true);
      long l = createCacheKey(localTypedValue);
      Drawable localDrawable = getCachedDrawable(paramContext, l);
      if (localDrawable != null) {
        return localDrawable;
      }
      Object localObject2 = localDrawable;
      XmlResourceParser localXmlResourceParser;
      AttributeSet localAttributeSet;
      if (localTypedValue.string != null)
      {
        localObject2 = localDrawable;
        if (localTypedValue.string.toString().endsWith(".xml"))
        {
          localObject2 = localDrawable;
          try
          {
            localXmlResourceParser = ((Resources)localObject1).getXml(paramInt);
            localObject2 = localDrawable;
            localAttributeSet = Xml.asAttributeSet(localXmlResourceParser);
            int i;
            do
            {
              localObject2 = localDrawable;
              i = localXmlResourceParser.next();
            } while ((i != 2) && (i != 1));
            if (i != 2)
            {
              localObject2 = localDrawable;
              throw new XmlPullParserException("No start tag found");
            }
          }
          catch (Exception paramContext)
          {
            Log.e("AppCompatDrawableManager", "Exception while inflating drawable", paramContext);
          }
        }
      }
      for (paramContext = (Context)localObject2;; paramContext = (Context)localObject1)
      {
        localObject1 = paramContext;
        if (paramContext != null) {
          break;
        }
        this.mKnownDrawableIdTags.append(paramInt, "appcompat_skip_skip");
        return paramContext;
        localObject2 = localDrawable;
        localObject1 = localXmlResourceParser.getName();
        localObject2 = localDrawable;
        this.mKnownDrawableIdTags.append(paramInt, localObject1);
        localObject2 = localDrawable;
        c localc = (c)this.mDelegates.get(localObject1);
        localObject1 = localDrawable;
        if (localc != null)
        {
          localObject2 = localDrawable;
          localObject1 = localc.a(paramContext, localXmlResourceParser, localAttributeSet, paramContext.getTheme());
        }
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          ((Drawable)localObject1).setChangingConfigurations(localTypedValue.changingConfigurations);
          localObject2 = localObject1;
          boolean bool = addDrawableToCache(paramContext, l, (Drawable)localObject1);
          if (!bool) {}
        }
      }
    }
    return null;
  }
  
  private void removeDelegate(@NonNull String paramString, @NonNull c paramc)
  {
    if ((this.mDelegates != null) && (this.mDelegates.get(paramString) == paramc)) {
      this.mDelegates.remove(paramString);
    }
  }
  
  private static void setPorterDuffColorFilter(Drawable paramDrawable, int paramInt, PorterDuff.Mode paramMode)
  {
    Drawable localDrawable = paramDrawable;
    if (DrawableUtils.canSafelyMutateDrawable(paramDrawable)) {
      localDrawable = paramDrawable.mutate();
    }
    paramDrawable = paramMode;
    if (paramMode == null) {
      paramDrawable = DEFAULT_MODE;
    }
    localDrawable.setColorFilter(getPorterDuffColorFilter(paramInt, paramDrawable));
  }
  
  private Drawable tintDrawable(@NonNull Context paramContext, @DrawableRes int paramInt, boolean paramBoolean, @NonNull Drawable paramDrawable)
  {
    Object localObject = getTintList(paramContext, paramInt);
    if (localObject != null)
    {
      paramContext = paramDrawable;
      if (DrawableUtils.canSafelyMutateDrawable(paramDrawable)) {
        paramContext = paramDrawable.mutate();
      }
      paramContext = DrawableCompat.wrap(paramContext);
      DrawableCompat.setTintList(paramContext, (ColorStateList)localObject);
      paramDrawable = getTintMode(paramInt);
      localObject = paramContext;
      if (paramDrawable != null)
      {
        DrawableCompat.setTintMode(paramContext, paramDrawable);
        localObject = paramContext;
      }
    }
    do
    {
      do
      {
        return (Drawable)localObject;
        if (paramInt == a.e.abc_seekbar_track_material)
        {
          localObject = (LayerDrawable)paramDrawable;
          setPorterDuffColorFilter(((LayerDrawable)localObject).findDrawableByLayerId(16908288), bx.a(paramContext, a.a.colorControlNormal), DEFAULT_MODE);
          setPorterDuffColorFilter(((LayerDrawable)localObject).findDrawableByLayerId(16908303), bx.a(paramContext, a.a.colorControlNormal), DEFAULT_MODE);
          setPorterDuffColorFilter(((LayerDrawable)localObject).findDrawableByLayerId(16908301), bx.a(paramContext, a.a.colorControlActivated), DEFAULT_MODE);
          return paramDrawable;
        }
        if ((paramInt == a.e.abc_ratingbar_indicator_material) || (paramInt == a.e.abc_ratingbar_small_material))
        {
          localObject = (LayerDrawable)paramDrawable;
          setPorterDuffColorFilter(((LayerDrawable)localObject).findDrawableByLayerId(16908288), bx.c(paramContext, a.a.colorControlNormal), DEFAULT_MODE);
          setPorterDuffColorFilter(((LayerDrawable)localObject).findDrawableByLayerId(16908303), bx.a(paramContext, a.a.colorControlActivated), DEFAULT_MODE);
          setPorterDuffColorFilter(((LayerDrawable)localObject).findDrawableByLayerId(16908301), bx.a(paramContext, a.a.colorControlActivated), DEFAULT_MODE);
          return paramDrawable;
        }
        localObject = paramDrawable;
      } while (tintDrawableUsingColorFilter(paramContext, paramInt, paramDrawable));
      localObject = paramDrawable;
    } while (!paramBoolean);
    return null;
  }
  
  public static void tintDrawable(Drawable paramDrawable, by paramby, int[] paramArrayOfInt)
  {
    if ((DrawableUtils.canSafelyMutateDrawable(paramDrawable)) && (paramDrawable.mutate() != paramDrawable)) {
      Log.d("AppCompatDrawableManager", "Mutated drawable is not the same instance as the input.");
    }
    label63:
    label91:
    label103:
    for (;;)
    {
      return;
      ColorStateList localColorStateList;
      if ((paramby.d) || (paramby.c)) {
        if (paramby.d)
        {
          localColorStateList = paramby.a;
          if (!paramby.c) {
            break label91;
          }
          paramby = paramby.b;
          paramDrawable.setColorFilter(createTintFilter(localColorStateList, paramby, paramArrayOfInt));
        }
      }
      for (;;)
      {
        if (Build.VERSION.SDK_INT > 23) {
          break label103;
        }
        paramDrawable.invalidateSelf();
        return;
        localColorStateList = null;
        break;
        paramby = DEFAULT_MODE;
        break label63;
        paramDrawable.clearColorFilter();
      }
    }
  }
  
  static boolean tintDrawableUsingColorFilter(@NonNull Context paramContext, @DrawableRes int paramInt, @NonNull Drawable paramDrawable)
  {
    PorterDuff.Mode localMode = DEFAULT_MODE;
    int i;
    int j;
    if (arrayContains(COLORFILTER_TINT_COLOR_CONTROL_NORMAL, paramInt))
    {
      i = a.a.colorControlNormal;
      j = 1;
      paramInt = -1;
    }
    for (;;)
    {
      if (j != 0)
      {
        Drawable localDrawable = paramDrawable;
        if (DrawableUtils.canSafelyMutateDrawable(paramDrawable)) {
          localDrawable = paramDrawable.mutate();
        }
        localDrawable.setColorFilter(getPorterDuffColorFilter(bx.a(paramContext, i), localMode));
        if (paramInt != -1) {
          localDrawable.setAlpha(paramInt);
        }
        return true;
        if (arrayContains(COLORFILTER_COLOR_CONTROL_ACTIVATED, paramInt))
        {
          i = a.a.colorControlActivated;
          j = 1;
          paramInt = -1;
          continue;
        }
        if (arrayContains(COLORFILTER_COLOR_BACKGROUND_MULTIPLY, paramInt))
        {
          localMode = PorterDuff.Mode.MULTIPLY;
          j = 1;
          i = 16842801;
          paramInt = -1;
          continue;
        }
        if (paramInt == a.e.abc_list_divider_mtrl_alpha)
        {
          i = 16842800;
          paramInt = Math.round(40.8F);
          j = 1;
        }
      }
      else
      {
        return false;
      }
      paramInt = -1;
      i = 0;
      j = 0;
    }
  }
  
  public Drawable getDrawable(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    return getDrawable(paramContext, paramInt, false);
  }
  
  public Drawable getDrawable(@NonNull Context paramContext, @DrawableRes int paramInt, boolean paramBoolean)
  {
    Object localObject2 = loadDrawableFromDelegates(paramContext, paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = createDrawableIfNeeded(paramContext, paramInt);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = ContextCompat.getDrawable(paramContext, paramInt);
    }
    localObject1 = localObject2;
    if (localObject2 != null) {
      localObject1 = tintDrawable(paramContext, paramInt, paramBoolean, (Drawable)localObject2);
    }
    if (localObject1 != null) {
      DrawableUtils.fixDrawable((Drawable)localObject1);
    }
    return (Drawable)localObject1;
  }
  
  public final ColorStateList getTintList(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    ColorStateList localColorStateList1 = getTintListFromCache(paramContext, paramInt);
    ColorStateList localColorStateList2 = localColorStateList1;
    if (localColorStateList1 == null)
    {
      if (paramInt != a.e.abc_edit_text_material) {
        break label47;
      }
      localColorStateList1 = createEditTextColorStateList(paramContext);
    }
    for (;;)
    {
      localColorStateList2 = localColorStateList1;
      if (localColorStateList1 != null)
      {
        addTintListToCache(paramContext, paramInt, localColorStateList1);
        localColorStateList2 = localColorStateList1;
      }
      return localColorStateList2;
      label47:
      if (paramInt == a.e.abc_switch_track_mtrl_alpha) {
        localColorStateList1 = createSwitchTrackColorStateList(paramContext);
      } else if (paramInt == a.e.abc_switch_thumb_material) {
        localColorStateList1 = createSwitchThumbColorStateList(paramContext);
      } else if (paramInt == a.e.abc_btn_default_mtrl_shape) {
        localColorStateList1 = createDefaultButtonColorStateList(paramContext);
      } else if (paramInt == a.e.abc_btn_borderless_material) {
        localColorStateList1 = createBorderlessButtonColorStateList(paramContext);
      } else if (paramInt == a.e.abc_btn_colored_material) {
        localColorStateList1 = createColoredButtonColorStateList(paramContext);
      } else if ((paramInt == a.e.abc_spinner_mtrl_am_alpha) || (paramInt == a.e.abc_spinner_textfield_background_material)) {
        localColorStateList1 = createSpinnerColorStateList(paramContext);
      } else if (arrayContains(TINT_COLOR_CONTROL_NORMAL, paramInt)) {
        localColorStateList1 = bx.b(paramContext, a.a.colorControlNormal);
      } else if (arrayContains(TINT_COLOR_CONTROL_STATE_LIST, paramInt)) {
        localColorStateList1 = createDefaultColorStateList(paramContext);
      } else if (arrayContains(TINT_CHECKABLE_BUTTON_LIST, paramInt)) {
        localColorStateList1 = createCheckableButtonColorStateList(paramContext);
      } else if (paramInt == a.e.abc_seekbar_thumb_material) {
        localColorStateList1 = createSeekbarThumbColorStateList(paramContext);
      }
    }
  }
  
  final PorterDuff.Mode getTintMode(int paramInt)
  {
    PorterDuff.Mode localMode = null;
    if (paramInt == a.e.abc_switch_thumb_material) {
      localMode = PorterDuff.Mode.MULTIPLY;
    }
    return localMode;
  }
  
  public final Drawable onDrawableLoadedFromResources(@NonNull Context paramContext, @NonNull VectorEnabledTintResources paramVectorEnabledTintResources, @DrawableRes int paramInt)
  {
    Drawable localDrawable2 = loadDrawableFromDelegates(paramContext, paramInt);
    Drawable localDrawable1 = localDrawable2;
    if (localDrawable2 == null) {
      localDrawable1 = paramVectorEnabledTintResources.superGetDrawable(paramInt);
    }
    if (localDrawable1 != null) {
      return tintDrawable(paramContext, paramInt, false, localDrawable1);
    }
    return null;
  }
  
  private static class a
    implements AppCompatDrawableManager.c
  {
    public Drawable a(@NonNull Context paramContext, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
    {
      try
      {
        paramContext = b.a(paramContext, paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", paramContext);
      }
      return null;
    }
  }
  
  private static class b
    extends LruCache<Integer, PorterDuffColorFilter>
  {
    public b(int paramInt)
    {
      super();
    }
    
    private static int b(int paramInt, PorterDuff.Mode paramMode)
    {
      return (paramInt + 31) * 31 + paramMode.hashCode();
    }
    
    PorterDuffColorFilter a(int paramInt, PorterDuff.Mode paramMode)
    {
      return (PorterDuffColorFilter)get(Integer.valueOf(b(paramInt, paramMode)));
    }
    
    PorterDuffColorFilter a(int paramInt, PorterDuff.Mode paramMode, PorterDuffColorFilter paramPorterDuffColorFilter)
    {
      return (PorterDuffColorFilter)put(Integer.valueOf(b(paramInt, paramMode)), paramPorterDuffColorFilter);
    }
  }
  
  private static abstract interface c
  {
    public abstract Drawable a(@NonNull Context paramContext, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme);
  }
  
  private static class d
    implements AppCompatDrawableManager.c
  {
    public Drawable a(@NonNull Context paramContext, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
    {
      try
      {
        paramContext = g.a(paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        Log.e("VdcInflateDelegate", "Exception while inflating <vector>", paramContext);
      }
      return null;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\AppCompatDrawableManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */