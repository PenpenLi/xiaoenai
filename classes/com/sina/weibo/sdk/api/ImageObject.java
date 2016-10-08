package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.File;

public class ImageObject
  extends BaseMediaObject
{
  public static final Parcelable.Creator<ImageObject> CREATOR = new ImageObject.1();
  private static final int DATA_SIZE = 2097152;
  public byte[] imageData;
  public String imagePath;
  
  public ImageObject() {}
  
  public ImageObject(Parcel paramParcel)
  {
    this.imageData = paramParcel.createByteArray();
    this.imagePath = paramParcel.readString();
  }
  
  public boolean checkArgs()
  {
    if ((this.imageData == null) && (this.imagePath == null))
    {
      LogUtil.e("Weibo.ImageObject", "imageData and imagePath are null");
      return false;
    }
    if ((this.imageData != null) && (this.imageData.length > 2097152))
    {
      LogUtil.e("Weibo.ImageObject", "imageData is too large");
      return false;
    }
    if ((this.imagePath != null) && (this.imagePath.length() > 512))
    {
      LogUtil.e("Weibo.ImageObject", "imagePath is too length");
      return false;
    }
    if (this.imagePath != null)
    {
      File localFile = new File(this.imagePath);
      try
      {
        if ((!localFile.exists()) || (localFile.length() == 0L) || (localFile.length() > 10485760L))
        {
          LogUtil.e("Weibo.ImageObject", "checkArgs fail, image content is too large or not exists");
          return false;
        }
      }
      catch (SecurityException localSecurityException)
      {
        LogUtil.e("Weibo.ImageObject", "checkArgs fail, image content is too large or not exists");
        return false;
      }
    }
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getObjType()
  {
    return 2;
  }
  
  /* Error */
  public final void setImageObject(android.graphics.Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 89	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 90	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: astore_2
    //   10: aload_1
    //   11: getstatic 96	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   14: bipush 85
    //   16: aload_3
    //   17: invokevirtual 102	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   20: pop
    //   21: aload_3
    //   22: astore_2
    //   23: aload_0
    //   24: aload_3
    //   25: invokevirtual 105	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   28: putfield 34	com/sina/weibo/sdk/api/ImageObject:imageData	[B
    //   31: aload_3
    //   32: ifnull +7 -> 39
    //   35: aload_3
    //   36: invokevirtual 108	java/io/ByteArrayOutputStream:close	()V
    //   39: return
    //   40: astore 4
    //   42: aconst_null
    //   43: astore_1
    //   44: aload_1
    //   45: astore_2
    //   46: aload 4
    //   48: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   51: aload_1
    //   52: astore_2
    //   53: ldc 46
    //   55: ldc 113
    //   57: invokestatic 54	com/sina/weibo/sdk/utils/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload_1
    //   61: ifnull -22 -> 39
    //   64: aload_1
    //   65: invokevirtual 108	java/io/ByteArrayOutputStream:close	()V
    //   68: return
    //   69: astore_1
    //   70: aload_1
    //   71: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   74: return
    //   75: astore_1
    //   76: aconst_null
    //   77: astore_2
    //   78: aload_2
    //   79: ifnull +7 -> 86
    //   82: aload_2
    //   83: invokevirtual 108	java/io/ByteArrayOutputStream:close	()V
    //   86: aload_1
    //   87: athrow
    //   88: astore_2
    //   89: aload_2
    //   90: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   93: goto -7 -> 86
    //   96: astore_1
    //   97: aload_1
    //   98: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   101: return
    //   102: astore_1
    //   103: goto -25 -> 78
    //   106: astore 4
    //   108: aload_3
    //   109: astore_1
    //   110: goto -66 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	ImageObject
    //   0	113	1	paramBitmap	android.graphics.Bitmap
    //   9	74	2	localObject	Object
    //   88	2	2	localIOException	java.io.IOException
    //   7	102	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   40	7	4	localException1	Exception
    //   106	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	8	40	java/lang/Exception
    //   64	68	69	java/io/IOException
    //   0	8	75	finally
    //   82	86	88	java/io/IOException
    //   35	39	96	java/io/IOException
    //   10	21	102	finally
    //   23	31	102	finally
    //   46	51	102	finally
    //   53	60	102	finally
    //   10	21	106	java/lang/Exception
    //   23	31	106	java/lang/Exception
  }
  
  protected BaseMediaObject toExtraMediaObject(String paramString)
  {
    return this;
  }
  
  protected String toExtraMediaString()
  {
    return "";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByteArray(this.imageData);
    paramParcel.writeString(this.imagePath);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\api\ImageObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */