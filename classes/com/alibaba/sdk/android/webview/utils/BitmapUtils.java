package com.alibaba.sdk.android.webview.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class BitmapUtils
{
  public static Bitmap compressToDefiniteSizeBitmap(Bitmap paramBitmap, int paramInt)
  {
    int j = 100;
    if (paramBitmap == null) {
      return null;
    }
    int i = paramInt;
    if (paramInt == 0) {
      i = 50;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    paramInt = j;
    long l = localByteArrayOutputStream.toByteArray().length / 1024;
    if (l > i)
    {
      localByteArrayOutputStream.reset();
      if ((l >= 0L) && (l < 50L)) {
        paramInt = 90;
      }
      for (;;)
      {
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, localByteArrayOutputStream);
        paramBitmap = BitmapFactory.decodeStream(new ByteArrayInputStream(localByteArrayOutputStream.toByteArray()), null, null);
        break;
        if ((l >= 50L) && (l < 100L)) {
          paramInt = 80;
        } else if ((l >= 100L) && (l < 1000L)) {
          paramInt = 15;
        } else if (l >= 1000L) {
          paramInt = 10;
        }
      }
    }
    paramBitmap = localByteArrayOutputStream.toByteArray();
    return BitmapFactory.decodeByteArray(paramBitmap, 0, paramBitmap.length);
  }
  
  public static Bitmap createMiniBitmapByPath(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject;
    if ((paramString == null) || (paramString.equals(""))) {
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return (Bitmap)localObject;
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      paramInt2 = ((BitmapFactory.Options)localObject).outWidth;
      int i = ((BitmapFactory.Options)localObject).outHeight;
      ((BitmapFactory.Options)localObject).inSampleSize = (paramInt2 / (paramInt1 / 10));
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      localBitmap = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      localObject = localBitmap;
    } while (localBitmap == null);
    return rotateBitmapByDegree(localBitmap, getBitmapDegree(paramString));
  }
  
  public static int getBitmapDegree(String paramString)
  {
    try
    {
      paramString = new ExifInterface(paramString);
      int i;
      if (paramString != null)
      {
        i = paramString.getAttributeInt("Orientation", 1);
        if (i == -1) {}
      }
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
  
  public static Bitmap rotateBitmapByDegree(Bitmap paramBitmap, int paramInt)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.postRotate(paramInt);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
  }
  
  public static Bitmap safeDecodeFile(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inSampleSize = 3;
    localOptions.inJustDecodeBounds = false;
    return BitmapFactory.decodeFile(paramString, localOptions).copy(Bitmap.Config.ARGB_8888, true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\utils\BitmapUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */