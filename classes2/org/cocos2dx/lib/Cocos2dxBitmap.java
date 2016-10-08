package org.cocos2dx.lib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class Cocos2dxBitmap
{
  private static final int HORIZONTAL_ALIGN_CENTER = 3;
  private static final int HORIZONTAL_ALIGN_LEFT = 1;
  private static final int HORIZONTAL_ALIGN_RIGHT = 2;
  private static final int VERTICAL_ALIGN_BOTTOM = 2;
  private static final int VERTICAL_ALIGN_CENTER = 3;
  private static final int VERTICAL_ALIGN_TOP = 1;
  private static Context sContext;
  
  public static boolean createTextBitmapShadowStroke(byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean2, int paramInt9, int paramInt10, int paramInt11, int paramInt12, float paramFloat5)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return false;
    }
    Object localObject2 = new String(paramArrayOfByte);
    Object localObject1 = Layout.Alignment.ALIGN_NORMAL;
    int k = paramInt6 & 0xF;
    paramArrayOfByte = (byte[])localObject1;
    switch (k)
    {
    default: 
      paramArrayOfByte = (byte[])localObject1;
    case 1: 
      paramString = newPaint(paramString, paramInt1);
      if (paramBoolean2)
      {
        paramString.setStyle(Paint.Style.STROKE);
        paramString.setStrokeWidth(paramFloat5);
      }
      if (paramInt7 > 0) {
        break;
      }
    }
    for (paramInt1 = (int)Math.ceil(StaticLayout.getDesiredWidth((CharSequence)localObject2, paramString));; paramInt1 = paramInt7)
    {
      paramArrayOfByte = new StaticLayout((CharSequence)localObject2, paramString, paramInt1, paramArrayOfByte, 1.0F, 0.0F, false);
      paramInt1 = paramArrayOfByte.getWidth();
      int i = paramArrayOfByte.getLineTop(paramArrayOfByte.getLineCount());
      int j = Math.max(paramInt1, paramInt7);
      if (paramInt8 > 0) {}
      for (;;)
      {
        if ((j == 0) || (paramInt8 == 0))
        {
          return false;
          paramArrayOfByte = Layout.Alignment.ALIGN_CENTER;
          break;
          paramArrayOfByte = Layout.Alignment.ALIGN_OPPOSITE;
          break;
        }
        if (k == 3) {
          paramInt1 = (j - paramInt1) / 2;
        }
        for (;;)
        {
          paramInt7 = 0;
          switch (paramInt6 >> 4 & 0xF)
          {
          default: 
            paramInt6 = paramInt7;
          }
          for (;;)
          {
            localObject1 = Bitmap.createBitmap(j, paramInt8, Bitmap.Config.ARGB_8888);
            localObject2 = new Canvas((Bitmap)localObject1);
            ((Canvas)localObject2).translate(paramInt1, paramInt6);
            if (paramBoolean2)
            {
              paramString.setARGB(paramInt12, paramInt9, paramInt10, paramInt11);
              paramArrayOfByte.draw((Canvas)localObject2);
            }
            paramString.setStyle(Paint.Style.FILL);
            paramString.setARGB(paramInt5, paramInt2, paramInt3, paramInt4);
            paramArrayOfByte.draw((Canvas)localObject2);
            initNativeObject((Bitmap)localObject1);
            return true;
            if (k != 2) {
              break label351;
            }
            paramInt1 = j - paramInt1;
            break;
            paramInt6 = (paramInt8 - i) / 2;
            continue;
            paramInt6 = paramInt8 - i;
          }
          label351:
          paramInt1 = 0;
        }
        paramInt8 = i;
      }
    }
  }
  
  public static int getFontSizeAccordingHeight(int paramInt)
  {
    TextPaint localTextPaint = new TextPaint();
    Rect localRect = new Rect();
    localTextPaint.setTypeface(Typeface.DEFAULT);
    int j = 0;
    int i = 1;
    while (j == 0)
    {
      localTextPaint.setTextSize(i);
      localTextPaint.getTextBounds("SghMNy", 0, "SghMNy".length(), localRect);
      int k = i + 1;
      i = k;
      if (paramInt - localRect.height() <= 2)
      {
        j = 1;
        i = k;
      }
    }
    return i;
  }
  
  private static byte[] getPixels(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      byte[] arrayOfByte = new byte[paramBitmap.getWidth() * paramBitmap.getHeight() * 4];
      ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte);
      localByteBuffer.order(ByteOrder.nativeOrder());
      paramBitmap.copyPixelsToBuffer(localByteBuffer);
      return arrayOfByte;
    }
    return null;
  }
  
  private static String getStringWithEllipsis(String paramString, float paramFloat1, float paramFloat2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setTypeface(Typeface.DEFAULT);
    localTextPaint.setTextSize(paramFloat2);
    return TextUtils.ellipsize(paramString, localTextPaint, paramFloat1, TextUtils.TruncateAt.END).toString();
  }
  
  private static void initNativeObject(Bitmap paramBitmap)
  {
    byte[] arrayOfByte = getPixels(paramBitmap);
    if (arrayOfByte == null) {
      return;
    }
    nativeInitBitmapDC(paramBitmap.getWidth(), paramBitmap.getHeight(), arrayOfByte);
  }
  
  private static native void nativeInitBitmapDC(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  private static TextPaint newPaint(String paramString, int paramInt)
  {
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setTextSize(paramInt);
    localTextPaint.setAntiAlias(true);
    if (paramString.endsWith(".ttf")) {
      try
      {
        localTextPaint.setTypeface(Cocos2dxTypefaces.get(sContext, paramString));
        return localTextPaint;
      }
      catch (Exception localException)
      {
        Log.e("Cocos2dxBitmap", "error to create ttf type face: " + paramString);
        localTextPaint.setTypeface(Typeface.create(paramString, 0));
        return localTextPaint;
      }
    }
    localTextPaint.setTypeface(Typeface.create(paramString, 0));
    return localTextPaint;
  }
  
  public static void setContext(Context paramContext)
  {
    sContext = paramContext;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxBitmap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */