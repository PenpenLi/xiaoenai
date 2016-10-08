package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.StateSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import org.apache.http.util.EncodingUtils;

public class ResourceManager
{
  private static final String DRAWABLE = "drawable";
  private static final String DRAWABLE_HDPI = "drawable-hdpi";
  private static final String DRAWABLE_LDPI = "drawable-ldpi";
  private static final String DRAWABLE_MDPI = "drawable-mdpi";
  private static final String DRAWABLE_XHDPI = "drawable-xhdpi";
  private static final String DRAWABLE_XXHDPI = "drawable-xxhdpi";
  private static final String[] PRE_INSTALL_DRAWBLE_PATHS = { "drawable-xxhdpi", "drawable-xhdpi", "drawable-hdpi", "drawable-mdpi", "drawable-ldpi", "drawable" };
  private static final String TAG = ResourceManager.class.getName();
  
  public static ColorStateList createColorStateList(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt2 = { 16842908 };
    int[] arrayOfInt1 = StateSet.WILD_CARD;
    return new ColorStateList(new int[][] { { 16842919 }, { 16842913 }, arrayOfInt2, arrayOfInt1 }, new int[] { paramInt2, paramInt2, paramInt2, paramInt1 });
  }
  
  public static StateListDrawable createStateListDrawable(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString1.indexOf(".9") > -1)
    {
      paramString1 = getNinePatchDrawable(paramContext, paramString1);
      if (paramString2.indexOf(".9") <= -1) {
        break label98;
      }
    }
    label98:
    for (paramContext = getNinePatchDrawable(paramContext, paramString2);; paramContext = getDrawable(paramContext, paramString2))
    {
      paramString2 = new StateListDrawable();
      paramString2.addState(new int[] { 16842919 }, paramContext);
      paramString2.addState(new int[] { 16842913 }, paramContext);
      paramString2.addState(new int[] { 16842908 }, paramContext);
      paramString2.addState(StateSet.WILD_CARD, paramString1);
      return paramString2;
      paramString1 = getDrawable(paramContext, paramString1);
      break;
    }
  }
  
  public static StateListDrawable createStateListDrawable(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (paramString1.indexOf(".9") > -1)
    {
      paramString1 = getNinePatchDrawable(paramContext, paramString1);
      if (paramString3.indexOf(".9") <= -1) {
        break label127;
      }
      paramString3 = getNinePatchDrawable(paramContext, paramString3);
      label32:
      if (paramString2.indexOf(".9") <= -1) {
        break label136;
      }
    }
    label127:
    label136:
    for (paramContext = getNinePatchDrawable(paramContext, paramString2);; paramContext = getDrawable(paramContext, paramString2))
    {
      paramString2 = new StateListDrawable();
      paramString2.addState(new int[] { 16842919 }, paramContext);
      paramString2.addState(new int[] { 16842913 }, paramContext);
      paramString2.addState(new int[] { 16842908 }, paramContext);
      paramString2.addState(new int[] { 16842766 }, paramString3);
      paramString2.addState(StateSet.WILD_CARD, paramString1);
      return paramString2;
      paramString1 = getDrawable(paramContext, paramString1);
      break;
      paramString3 = getDrawable(paramContext, paramString3);
      break label32;
    }
  }
  
  public static int dp2px(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    float f = paramInt;
    return (int)(paramContext.density * f + 0.5D);
  }
  
  private static Drawable extractDrawable(Context paramContext, String paramString)
  {
    InputStream localInputStream = paramContext.getAssets().open(paramString);
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    TypedValue localTypedValue = new TypedValue();
    localTypedValue.density = localDisplayMetrics.densityDpi;
    paramContext = Drawable.createFromResourceStream(paramContext.getResources(), localTypedValue, localInputStream, paramString);
    localInputStream.close();
    return paramContext;
  }
  
  private static View extractView(Context paramContext, String paramString, ViewGroup paramViewGroup)
  {
    paramString = paramContext.getAssets().openXmlResourceParser(paramString);
    return ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(paramString, paramViewGroup);
  }
  
  private static String getAppropriatePathOfDrawable(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      LogUtil.e(TAG, "id is NOT correct!");
      return null;
    }
    String str1 = getCurrentDpiFolder(paramContext);
    LogUtil.d(TAG, "find Appropriate path...");
    int i = 0;
    int m = -1;
    int k = -1;
    int j;
    int n;
    if (i >= PRE_INSTALL_DRAWBLE_PATHS.length)
    {
      j = -1;
      n = m;
      label55:
      if ((k <= 0) || (j <= 0)) {
        break label204;
      }
      i = k;
      if (Math.abs(n - j) <= Math.abs(n - k)) {
        i = j;
      }
    }
    for (;;)
    {
      if (i >= 0) {
        break label249;
      }
      LogUtil.e(TAG, "Not find the appropriate path for drawable");
      return null;
      if (PRE_INSTALL_DRAWBLE_PATHS[i].equals(str1)) {
        m = i;
      }
      String str2 = PRE_INSTALL_DRAWBLE_PATHS[i] + "/" + paramString;
      j = k;
      if (isFileExisted(paramContext, str2))
      {
        if (m == i) {
          return str2;
        }
        j = i;
        n = m;
        if (m >= 0) {
          break label55;
        }
        j = i;
      }
      i += 1;
      k = j;
      break;
      label204:
      if (k > 0)
      {
        i = k;
        if (j < 0) {}
      }
      else if ((k < 0) && (j > 0))
      {
        i = j;
      }
      else
      {
        LogUtil.e(TAG, "Not find the appropriate path for drawable");
        i = -1;
      }
    }
    label249:
    return PRE_INSTALL_DRAWBLE_PATHS[i] + "/" + paramString;
  }
  
  private static String getCurrentDpiFolder(Context paramContext)
  {
    int i = paramContext.getResources().getDisplayMetrics().densityDpi;
    if (i <= 120) {
      return "drawable-ldpi";
    }
    if ((i > 120) && (i <= 160)) {
      return "drawable-mdpi";
    }
    if ((i > 160) && (i <= 240)) {
      return "drawable-hdpi";
    }
    if ((i > 240) && (i <= 320)) {
      return "drawable-xhdpi";
    }
    return "drawable-xxhdpi";
  }
  
  public static Drawable getDrawable(Context paramContext, String paramString)
  {
    return getDrawableFromAssert(paramContext, getAppropriatePathOfDrawable(paramContext, paramString), false);
  }
  
  /* Error */
  private static Drawable getDrawableFromAssert(Context paramContext, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 112	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: astore_3
    //   5: aload_3
    //   6: aload_1
    //   7: invokevirtual 118	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnull +180 -> 192
    //   15: aload_1
    //   16: invokestatic 229	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   19: astore_3
    //   20: aload_0
    //   21: invokevirtual 93	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   24: invokevirtual 99	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   27: astore 4
    //   29: iload_2
    //   30: ifeq +62 -> 92
    //   33: aload_0
    //   34: invokevirtual 93	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   37: invokevirtual 233	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   40: astore 5
    //   42: new 235	android/graphics/drawable/NinePatchDrawable
    //   45: dup
    //   46: new 95	android/content/res/Resources
    //   49: dup
    //   50: aload_0
    //   51: invokevirtual 112	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   54: aload 4
    //   56: aload 5
    //   58: invokespecial 238	android/content/res/Resources:<init>	(Landroid/content/res/AssetManager;Landroid/util/DisplayMetrics;Landroid/content/res/Configuration;)V
    //   61: aload_3
    //   62: aload_3
    //   63: invokevirtual 244	android/graphics/Bitmap:getNinePatchChunk	()[B
    //   66: new 246	android/graphics/Rect
    //   69: dup
    //   70: iconst_0
    //   71: iconst_0
    //   72: iconst_0
    //   73: iconst_0
    //   74: invokespecial 249	android/graphics/Rect:<init>	(IIII)V
    //   77: aconst_null
    //   78: invokespecial 252	android/graphics/drawable/NinePatchDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;[BLandroid/graphics/Rect;Ljava/lang/String;)V
    //   81: astore_0
    //   82: aload_1
    //   83: ifnull +7 -> 90
    //   86: aload_1
    //   87: invokevirtual 138	java/io/InputStream:close	()V
    //   90: aload_0
    //   91: areturn
    //   92: aload_3
    //   93: aload 4
    //   95: getfield 125	android/util/DisplayMetrics:densityDpi	I
    //   98: invokevirtual 256	android/graphics/Bitmap:setDensity	(I)V
    //   101: new 258	android/graphics/drawable/BitmapDrawable
    //   104: dup
    //   105: aload_0
    //   106: invokevirtual 93	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   109: aload_3
    //   110: invokespecial 261	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   113: astore_0
    //   114: goto -32 -> 82
    //   117: astore_3
    //   118: aload_1
    //   119: astore_0
    //   120: aload_3
    //   121: astore_1
    //   122: aload_1
    //   123: invokevirtual 264	java/io/IOException:printStackTrace	()V
    //   126: aload_0
    //   127: ifnull +63 -> 190
    //   130: aload_0
    //   131: invokevirtual 138	java/io/InputStream:close	()V
    //   134: aconst_null
    //   135: areturn
    //   136: astore_0
    //   137: aload_0
    //   138: invokevirtual 264	java/io/IOException:printStackTrace	()V
    //   141: goto -7 -> 134
    //   144: astore_0
    //   145: aconst_null
    //   146: astore_1
    //   147: aload_1
    //   148: ifnull +7 -> 155
    //   151: aload_1
    //   152: invokevirtual 138	java/io/InputStream:close	()V
    //   155: aload_0
    //   156: athrow
    //   157: astore_1
    //   158: aload_1
    //   159: invokevirtual 264	java/io/IOException:printStackTrace	()V
    //   162: goto -7 -> 155
    //   165: astore_1
    //   166: aload_1
    //   167: invokevirtual 264	java/io/IOException:printStackTrace	()V
    //   170: aload_0
    //   171: areturn
    //   172: astore_0
    //   173: goto -26 -> 147
    //   176: astore_3
    //   177: aload_0
    //   178: astore_1
    //   179: aload_3
    //   180: astore_0
    //   181: goto -34 -> 147
    //   184: astore_1
    //   185: aconst_null
    //   186: astore_0
    //   187: goto -65 -> 122
    //   190: aconst_null
    //   191: areturn
    //   192: aconst_null
    //   193: astore_0
    //   194: goto -112 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramContext	Context
    //   0	197	1	paramString	String
    //   0	197	2	paramBoolean	boolean
    //   4	106	3	localObject1	Object
    //   117	4	3	localIOException	IOException
    //   176	4	3	localObject2	Object
    //   27	67	4	localDisplayMetrics	DisplayMetrics
    //   40	17	5	localConfiguration	android.content.res.Configuration
    // Exception table:
    //   from	to	target	type
    //   15	29	117	java/io/IOException
    //   33	82	117	java/io/IOException
    //   92	114	117	java/io/IOException
    //   130	134	136	java/io/IOException
    //   5	11	144	finally
    //   151	155	157	java/io/IOException
    //   86	90	165	java/io/IOException
    //   15	29	172	finally
    //   33	82	172	finally
    //   92	114	172	finally
    //   122	126	176	finally
    //   5	11	184	java/io/IOException
  }
  
  public static Locale getLanguage()
  {
    Locale localLocale = Locale.getDefault();
    if ((Locale.SIMPLIFIED_CHINESE.equals(localLocale)) || (Locale.TRADITIONAL_CHINESE.equals(localLocale))) {
      return localLocale;
    }
    return Locale.ENGLISH;
  }
  
  public static Drawable getNinePatchDrawable(Context paramContext, String paramString)
  {
    return getDrawableFromAssert(paramContext, getAppropriatePathOfDrawable(paramContext, paramString), true);
  }
  
  public static String getString(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = getLanguage();
    if (Locale.SIMPLIFIED_CHINESE.equals(paramContext)) {
      return paramString2;
    }
    if (Locale.TRADITIONAL_CHINESE.equals(paramContext)) {
      return paramString3;
    }
    return paramString1;
  }
  
  private static boolean isFileExisted(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    Context localContext;
    for (;;)
    {
      return false;
      Object localObject2 = paramContext.getAssets();
      Object localObject1 = null;
      paramContext = null;
      try
      {
        localObject2 = ((AssetManager)localObject2).open(paramString);
        paramContext = (Context)localObject2;
        localObject1 = localObject2;
        LogUtil.d(TAG, "file [" + paramString + "] existed");
        if (localObject2 != null) {}
        try
        {
          ((InputStream)localObject2).close();
          return true;
        }
        catch (IOException paramContext)
        {
          for (;;)
          {
            paramContext.printStackTrace();
          }
        }
      }
      catch (IOException localIOException)
      {
        localContext = paramContext;
        LogUtil.d(TAG, "file [" + paramString + "] NOT existed");
        if (paramContext != null) {
          try
          {
            paramContext.close();
            return false;
          }
          catch (IOException paramContext)
          {
            paramContext.printStackTrace();
            return false;
          }
        }
      }
      finally
      {
        if (localContext == null) {}
      }
    }
    try
    {
      localContext.close();
      throw paramContext;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static String readCountryFromAsset(Context paramContext, String paramString)
  {
    String str = "";
    Object localObject = str;
    try
    {
      paramString = paramContext.getAssets().open(paramString);
      paramContext = str;
      if (paramString != null)
      {
        localObject = str;
        paramContext = new DataInputStream(paramString);
        localObject = str;
        byte[] arrayOfByte = new byte[paramContext.available()];
        localObject = str;
        paramContext.read(arrayOfByte);
        localObject = str;
        paramContext = EncodingUtils.getString(arrayOfByte, "UTF-8");
        localObject = paramContext;
        paramString.close();
      }
      return paramContext;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return (String)localObject;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\utils\ResourceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */