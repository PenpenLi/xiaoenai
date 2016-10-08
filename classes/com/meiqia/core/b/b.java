package com.meiqia.core.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

public class b
{
  private static long a(File paramFile)
  {
    long l2;
    if ((paramFile == null) || (!paramFile.exists()))
    {
      l2 = 0L;
      return l2;
    }
    if (!paramFile.isDirectory()) {
      return paramFile.length();
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramFile);
    long l1 = 0L;
    for (;;)
    {
      l2 = l1;
      if (localLinkedList.isEmpty()) {
        break;
      }
      paramFile = (File)localLinkedList.remove(0);
      if (paramFile.exists())
      {
        paramFile = paramFile.listFiles();
        if ((paramFile != null) && (paramFile.length != 0))
        {
          int j = paramFile.length;
          int i = 0;
          while (i < j)
          {
            Object localObject = paramFile[i];
            l2 = ((File)localObject).length();
            if (((File)localObject).isDirectory()) {
              localLinkedList.add(localObject);
            }
            i += 1;
            l1 = l2 + l1;
          }
        }
      }
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    float f2 = paramBitmap.getWidth();
    float f3 = paramBitmap.getHeight();
    if (f2 > f3) {}
    for (float f1 = f2;; f1 = f3)
    {
      f1 = 1024.0F / f1;
      if ((f2 <= 1024.0F) && (f3 <= 1024.0F)) {
        break label78;
      }
      localObject = new Matrix();
      ((Matrix)localObject).postScale(f1, f1);
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, (int)f2, (int)f3, (Matrix)localObject, true);
      break;
    }
    label78:
    Object localObject = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject);
    int i = 80;
    while (((ByteArrayOutputStream)localObject).toByteArray().length / 1024 > 150)
    {
      ((ByteArrayOutputStream)localObject).reset();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, i, (OutputStream)localObject);
      i -= 20;
    }
    return BitmapFactory.decodeStream(new ByteArrayInputStream(((ByteArrayOutputStream)localObject).toByteArray()));
  }
  
  private static Bitmap a(String paramString)
  {
    int i = 2;
    long l;
    try
    {
      l = a(new File(paramString));
      if (l == 0L) {
        return null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l = 0L;
      }
      l /= 1000L;
      if (l > 250L) {
        break label127;
      }
    }
    if (l >= 150L) {}
    for (;;)
    {
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inSampleSize = i;
      localObject = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      for (;;)
      {
        try
        {
          paramString = new ExifInterface(paramString);
          if (paramString != null)
          {
            i = paramString.getAttributeInt("Orientation", 1);
            paramString = new Matrix();
            if (i == 3)
            {
              paramString.postRotate(180.0F);
              return Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), paramString, true);
              label127:
              if ((l > 251L) && (l < 1500L)) {
                break;
              }
              if ((l >= 1500L) && (l < 3000L))
              {
                i = 4;
                break;
              }
              if ((l >= 3000L) && (l <= 4500L))
              {
                i = 4;
                break;
              }
              if (l < 4500L) {
                break label297;
              }
              i = 8;
            }
          }
        }
        catch (IOException paramString)
        {
          paramString.printStackTrace();
          paramString = null;
          continue;
          if (i == 6)
          {
            paramString.postRotate(90.0F);
            return Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), paramString, true);
          }
          if (i == 8)
          {
            paramString.postRotate(270.0F);
            return Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), paramString, true);
          }
          paramString.postRotate(0.0F);
          return Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), paramString, true);
        }
        i = 0;
      }
      label297:
      i = 1;
    }
  }
  
  private static void a(Bitmap paramBitmap, File paramFile)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = 80;
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 80, localByteArrayOutputStream);
    while (localByteArrayOutputStream.toByteArray().length / 1024 > 100)
    {
      localByteArrayOutputStream.reset();
      i -= 10;
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, i, localByteArrayOutputStream);
    }
    try
    {
      paramBitmap = new FileOutputStream(paramFile);
      paramBitmap.write(localByteArrayOutputStream.toByteArray());
      paramBitmap.flush();
      paramBitmap.close();
      return;
    }
    catch (Exception paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
  }
  
  public static void a(File paramFile1, File paramFile2)
  {
    try
    {
      a(a(a(paramFile1.getAbsolutePath())), paramFile2);
      return;
    }
    catch (Exception paramFile1)
    {
      paramFile1.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */