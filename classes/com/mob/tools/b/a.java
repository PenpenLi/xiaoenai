package com.mob.tools.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import com.mob.tools.a.l;
import com.mob.tools.e;
import com.mob.tools.log.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class a
{
  public static Bitmap.CompressFormat a(byte[] paramArrayOfByte)
  {
    String str = b(paramArrayOfByte);
    Bitmap.CompressFormat localCompressFormat = Bitmap.CompressFormat.JPEG;
    paramArrayOfByte = localCompressFormat;
    if (str != null) {
      if (!str.endsWith("png"))
      {
        paramArrayOfByte = localCompressFormat;
        if (!str.endsWith("gif")) {}
      }
      else
      {
        paramArrayOfByte = Bitmap.CompressFormat.PNG;
      }
    }
    return paramArrayOfByte;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Rect localRect1 = new Rect(0, 0, i, j);
    if ((i != paramInt1) || (j != paramInt2)) {}
    for (Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);; localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888))
    {
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect2 = new Rect(0, 0, paramInt1, paramInt2);
      localPaint.setAntiAlias(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      Object localObject = new float[8];
      localObject[0] = paramFloat1;
      localObject[1] = paramFloat1;
      localObject[2] = paramFloat2;
      localObject[3] = paramFloat2;
      localObject[4] = paramFloat3;
      localObject[5] = paramFloat3;
      localObject[6] = paramFloat4;
      localObject[7] = paramFloat4;
      localObject = new ShapeDrawable(new RoundRectShape((float[])localObject, new RectF(0.0F, 0.0F, 0.0F, 0.0F), (float[])localObject));
      ((ShapeDrawable)localObject).setBounds(localRect2);
      ((ShapeDrawable)localObject).draw(localCanvas);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
      return localBitmap;
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = paramBitmap.getWidth() - paramInt1 - paramInt3;
    paramInt4 = paramBitmap.getHeight() - paramInt2 - paramInt4;
    if ((paramInt3 == paramBitmap.getWidth()) && (paramInt4 == paramBitmap.getHeight())) {
      return paramBitmap;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramInt3, paramInt4, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localCanvas.drawBitmap(paramBitmap, -paramInt1, -paramInt2, localPaint);
    return localBitmap;
  }
  
  public static Bitmap a(File paramFile, int paramInt)
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      return null;
    }
    paramFile = new FileInputStream(paramFile);
    Bitmap localBitmap = a(paramFile, paramInt);
    paramFile.close();
    return localBitmap;
  }
  
  public static Bitmap a(InputStream paramInputStream, int paramInt)
  {
    if (paramInputStream == null) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    localOptions.inPurgeable = true;
    localOptions.inInputShareable = true;
    localOptions.inSampleSize = paramInt;
    return BitmapFactory.decodeStream(paramInputStream, null, localOptions);
  }
  
  public static Bitmap a(String paramString)
  {
    return a(paramString, 1);
  }
  
  public static Bitmap a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return a(new File(paramString), paramInt);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    return new l().downloadCache(paramContext, paramString, "images", true, null);
  }
  
  private static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramArrayOfByte1 == paramArrayOfByte2) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramArrayOfByte1 == null);
        bool1 = bool2;
      } while (paramArrayOfByte2 == null);
      bool1 = bool2;
    } while (paramArrayOfByte1.length < paramArrayOfByte2.length);
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte2.length) {
        break label63;
      }
      bool1 = bool2;
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
        break;
      }
      i += 1;
    }
    label63:
    return true;
  }
  
  public static int[] a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = new int[2];
    if (paramArrayOfInt1[0] / paramArrayOfInt1[1] > paramArrayOfInt2[0] / paramArrayOfInt2[1])
    {
      arrayOfInt[0] = paramArrayOfInt2[0];
      arrayOfInt[1] = ((int)(paramArrayOfInt1[1] * paramArrayOfInt2[0] / paramArrayOfInt1[0] + 0.5F));
      return arrayOfInt;
    }
    arrayOfInt[1] = paramArrayOfInt2[1];
    arrayOfInt[0] = ((int)(paramArrayOfInt1[0] * paramArrayOfInt2[1] / paramArrayOfInt1[1] + 0.5F));
    return arrayOfInt;
  }
  
  public static Bitmap.CompressFormat b(String paramString)
  {
    String str = paramString.toLowerCase();
    if ((str.endsWith("png")) || (str.endsWith("gif"))) {
      return Bitmap.CompressFormat.PNG;
    }
    if ((str.endsWith("jpg")) || (str.endsWith("jpeg")) || (str.endsWith("bmp")) || (str.endsWith("tif"))) {
      return Bitmap.CompressFormat.JPEG;
    }
    paramString = c(paramString);
    if ((paramString.endsWith("png")) || (paramString.endsWith("gif"))) {
      return Bitmap.CompressFormat.PNG;
    }
    return Bitmap.CompressFormat.JPEG;
  }
  
  private static String b(byte[] paramArrayOfByte)
  {
    if (!a(paramArrayOfByte, new byte[] { -1, -40, -1, -32 }))
    {
      if (!a(paramArrayOfByte, new byte[] { -1, -40, -1, -31 })) {}
    }
    else {
      return "jpg";
    }
    if (a(paramArrayOfByte, new byte[] { -119, 80, 78, 71 })) {
      return "png";
    }
    if (a(paramArrayOfByte, "GIF".getBytes())) {
      return "gif";
    }
    if (a(paramArrayOfByte, "BM".getBytes())) {
      return "bmp";
    }
    if (!a(paramArrayOfByte, new byte[] { 73, 73, 42 }))
    {
      if (!a(paramArrayOfByte, new byte[] { 77, 77, 42 })) {}
    }
    else {
      return "tif";
    }
    return null;
  }
  
  private static String c(String paramString)
  {
    try
    {
      paramString = new FileInputStream(paramString);
      byte[] arrayOfByte = new byte[8];
      paramString.read(arrayOfByte);
      paramString.close();
      paramString = b(arrayOfByte);
      return paramString;
    }
    catch (Exception paramString)
    {
      e.a().w(paramString);
    }
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */