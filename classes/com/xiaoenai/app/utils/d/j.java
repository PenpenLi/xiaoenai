package com.xiaoenai.app.utils.d;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import com.xiaoenai.app.utils.f.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class j
{
  private static final Uri a = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int j = paramOptions.outWidth;
    int i = 1;
    if ((k > paramInt2) || (j > paramInt1))
    {
      i = Math.round(k / paramInt2);
      paramInt1 = Math.round(j / paramInt1);
      if (i >= paramInt1) {}
    }
    else
    {
      return i;
    }
    return paramInt1;
  }
  
  public static int a(String paramString)
  {
    try
    {
      int i = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
      switch (i)
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        return 0;
      case 6: 
        return 90;
      case 3: 
        return 180;
      }
      return 270;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  private static Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    Object localObject = new Matrix();
    paramFloat /= paramBitmap.getWidth();
    ((Matrix)localObject).setScale(paramFloat, paramFloat);
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      localObject = paramBitmap;
      if (paramBitmap != localBitmap)
      {
        paramBitmap.recycle();
        localObject = localBitmap;
      }
      return (Bitmap)localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
    return paramBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Object localObject = paramBitmap;
    if (paramInt != 0)
    {
      localObject = paramBitmap;
      if (paramBitmap != null)
      {
        localObject = new Matrix();
        ((Matrix)localObject).setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
      }
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      localObject = paramBitmap;
      if (paramBitmap != localBitmap)
      {
        paramBitmap.recycle();
        localObject = localBitmap;
      }
      return (Bitmap)localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
    return paramBitmap;
  }
  
  public static Uri a(Context paramContext, File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    Object localObject = new ContentValues(7);
    ((ContentValues)localObject).put("title", paramFile.getName());
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramFile.lastModified());
    ((ContentValues)localObject).put("_display_name", d.a(localCalendar));
    ((ContentValues)localObject).put("datetaken", Long.valueOf(paramFile.lastModified()));
    ((ContentValues)localObject).put("mime_type", "image/jpg");
    ((ContentValues)localObject).put("orientation", Integer.valueOf(0));
    ((ContentValues)localObject).put("_data", paramFile.getAbsolutePath());
    ((ContentValues)localObject).put("_size", Long.valueOf(paramFile.length()));
    localObject = paramContext.getContentResolver().insert(a, (ContentValues)localObject);
    b(paramContext, paramFile);
    return (Uri)localObject;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    int i = a(paramString1);
    boolean bool2;
    if (i == 0) {
      bool2 = false;
    }
    do
    {
      return bool2;
      try
      {
        paramString1 = BitmapFactory.decodeFile(paramString1);
        paramString2 = new FileOutputStream(new File(paramString2));
        localBitmap = a(paramString1, i);
        if (!localBitmap.compress(Bitmap.CompressFormat.JPEG, 100, paramString2)) {
          break label102;
        }
        paramString2.flush();
        paramString2.close();
        bool1 = true;
      }
      catch (IOException paramString1)
      {
        Bitmap localBitmap;
        paramString1.printStackTrace();
        return false;
      }
      catch (OutOfMemoryError paramString1)
      {
        for (;;)
        {
          continue;
          boolean bool1 = false;
        }
      }
      bool2 = bool1;
    } while (paramString1.isRecycled());
    paramString1.recycle();
    localBitmap.recycle();
    System.gc();
    return bool1;
  }
  
  private static int b(String paramString)
  {
    int j = 1;
    int k = 1;
    i = k;
    if (!TextUtils.isEmpty(paramString))
    {
      i = k;
      if (!paramString.startsWith("http")) {
        i = j;
      }
    }
    try
    {
      if (paramString.startsWith("file://")) {
        i = j;
      }
      for (String str = paramString.substring(6, paramString.length());; str = paramString)
      {
        i = j;
        ExifInterface localExifInterface = new ExifInterface(str);
        i = j;
        a.c("url: {} {}", new Object[] { str, paramString });
        i = j;
        j = localExifInterface.getAttributeInt("Orientation", 1);
        i = j;
        a.c("Exif orientation : {}", new Object[] { Integer.valueOf(j) });
        i = j;
        return i;
      }
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private static Bitmap b(Bitmap paramBitmap, int paramInt)
  {
    for (;;)
    {
      try
      {
        Matrix localMatrix = new Matrix();
        if (paramInt == 6)
        {
          localMatrix.postRotate(90.0F);
          return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
        }
        if (paramInt == 3)
        {
          localMatrix.postRotate(180.0F);
          continue;
        }
        if (paramInt != 8) {
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return paramBitmap;
      }
      localException.postRotate(270.0F);
    }
  }
  
  public static com.xiaoenai.app.utils.e.a.d b(String paramString1, String paramString2)
  {
    i = 100;
    try
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject).inSampleSize = a((BitmapFactory.Options)localObject, 1280, 1280);
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      if ((((BitmapFactory.Options)localObject).outHeight > 1280) || (((BitmapFactory.Options)localObject).outWidth > 1280)) {
        ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
      }
      j = b(paramString1);
      localObject = BitmapFactory.decodeFile(paramString1, (BitmapFactory.Options)localObject);
      if (localObject == null)
      {
        System.gc();
        return null;
      }
      if ((((Bitmap)localObject).getWidth() <= 1280) && (((Bitmap)localObject).getHeight() <= 1280)) {
        break label223;
      }
      paramString1 = (String)localObject;
      if (((Bitmap)localObject).getWidth() <= 1280) {
        break label302;
      }
      paramString1 = a((Bitmap)localObject, 1280.0F);
    }
    catch (FileNotFoundException paramString1)
    {
      for (;;)
      {
        int j;
        int k;
        paramString1.printStackTrace();
        System.gc();
        return null;
        if ((((Bitmap)localObject).getWidth() > 720) || (((Bitmap)localObject).getHeight() > 720)) {
          break;
        }
        if (((Bitmap)localObject).getWidth() <= 300)
        {
          k = ((Bitmap)localObject).getHeight();
          paramString1 = (String)localObject;
          if (k <= 300) {}
        }
        else
        {
          i = 80;
          paramString1 = (String)localObject;
        }
      }
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
    catch (OutOfMemoryError paramString1)
    {
      for (;;)
      {
        Object localObject;
        a.c("out of memory", new Object[0]);
        continue;
        i = 60;
        continue;
        i = 70;
        paramString1 = (String)localObject;
      }
    }
    paramString2 = new FileOutputStream(new File(paramString2));
    localObject = b(paramString1, j);
    j = ((Bitmap)localObject).getWidth();
    k = ((Bitmap)localObject).getHeight();
    if (((Bitmap)localObject).compress(Bitmap.CompressFormat.JPEG, i, paramString2))
    {
      paramString2.flush();
      paramString2.close();
    }
    if (!paramString1.isRecycled())
    {
      ((Bitmap)localObject).recycle();
      paramString1.recycle();
      System.gc();
    }
    paramString1 = new com.xiaoenai.app.utils.e.a.d(j, k);
    return paramString1;
  }
  
  public static void b(Context paramContext, File paramFile)
  {
    Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    localIntent.setData(Uri.fromFile(paramFile));
    paramContext.sendBroadcast(localIntent);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\d\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */