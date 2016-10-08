package com.inmobi.rendering.mraid;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.util.Base64;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class e
{
  private static final String a = e.class.getSimpleName();
  
  public static Bitmap a(String paramString, Context paramContext, int paramInt1, int paramInt2)
  {
    paramInt2 = paramInt1 * paramInt2;
    try
    {
      paramContext = new FileInputStream(paramString);
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeStream(paramContext, null, (BitmapFactory.Options)localObject);
      paramContext.close();
      paramInt1 = 1;
      while (((BitmapFactory.Options)localObject).outWidth * ((BitmapFactory.Options)localObject).outHeight * (1.0D / Math.pow(paramInt1, 2.0D)) > paramInt2) {
        paramInt1 += 1;
      }
      paramContext = new FileInputStream(paramString);
      if (paramInt1 > 1)
      {
        paramString = new BitmapFactory.Options();
        paramString.inSampleSize = (paramInt1 - 1);
        localObject = BitmapFactory.decodeStream(paramContext, null, paramString);
        paramInt1 = ((Bitmap)localObject).getHeight();
        int i = ((Bitmap)localObject).getWidth();
        double d = Math.sqrt(paramInt2 / (i / paramInt1));
        paramString = Bitmap.createScaledBitmap((Bitmap)localObject, (int)(d / paramInt1 * i), (int)d, true);
        ((Bitmap)localObject).recycle();
        System.gc();
      }
      for (;;)
      {
        paramContext.close();
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "bitmap size - width: " + paramString.getWidth() + ", height: " + paramString.getHeight());
        return paramString;
        paramString = BitmapFactory.decodeStream(paramContext);
      }
      return null;
    }
    catch (IOException paramString)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, paramString.getMessage());
    }
  }
  
  public static String a(Bitmap paramBitmap, Context paramContext, int paramInt)
  {
    paramContext = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, paramContext);
    return Base64.encodeToString(paramContext.toByteArray(), 2);
  }
  
  public static String a(Uri paramUri, Context paramContext)
  {
    paramUri = paramContext.getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
    int i = paramUri.getColumnIndexOrThrow("_data");
    paramUri.moveToFirst();
    paramContext = paramUri.getString(i);
    paramUri.close();
    return paramContext;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\mraid\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */