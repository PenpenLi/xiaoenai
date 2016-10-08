package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.utils.LogUtil;

public abstract class BaseMediaObject
  implements Parcelable
{
  public static final int MEDIA_TYPE_CMD = 7;
  public static final int MEDIA_TYPE_IMAGE = 2;
  public static final int MEDIA_TYPE_MUSIC = 3;
  public static final int MEDIA_TYPE_TEXT = 1;
  public static final int MEDIA_TYPE_VIDEO = 4;
  public static final int MEDIA_TYPE_VOICE = 6;
  public static final int MEDIA_TYPE_WEBPAGE = 5;
  public String actionUrl;
  public String description;
  public String identify;
  public String schema;
  public byte[] thumbData;
  public String title;
  
  public BaseMediaObject() {}
  
  public BaseMediaObject(Parcel paramParcel)
  {
    this.actionUrl = paramParcel.readString();
    this.schema = paramParcel.readString();
    this.identify = paramParcel.readString();
    this.title = paramParcel.readString();
    this.description = paramParcel.readString();
    this.thumbData = paramParcel.createByteArray();
  }
  
  protected boolean checkArgs()
  {
    if ((this.actionUrl == null) || (this.actionUrl.length() > 512))
    {
      LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, actionUrl is invalid");
      return false;
    }
    if ((this.identify == null) || (this.identify.length() > 512))
    {
      LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, identify is invalid");
      return false;
    }
    if ((this.thumbData == null) || (this.thumbData.length > 32768))
    {
      StringBuilder localStringBuilder = new StringBuilder("checkArgs fail, thumbData is invalid,size is ");
      if (this.thumbData != null) {}
      for (int i = this.thumbData.length;; i = -1)
      {
        LogUtil.e("Weibo.BaseMediaObject", i + "! more then 32768.");
        return false;
      }
    }
    if ((this.title == null) || (this.title.length() > 512))
    {
      LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, title is invalid");
      return false;
    }
    if ((this.description == null) || (this.description.length() > 1024))
    {
      LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, description is invalid");
      return false;
    }
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public abstract int getObjType();
  
  /* Error */
  public final void setThumbImage(android.graphics.Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 111	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 112	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: astore_2
    //   10: aload_1
    //   11: getstatic 118	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   14: bipush 85
    //   16: aload_3
    //   17: invokevirtual 124	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   20: pop
    //   21: aload_3
    //   22: astore_2
    //   23: aload_0
    //   24: aload_3
    //   25: invokevirtual 127	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   28: putfield 57	com/sina/weibo/sdk/api/BaseMediaObject:thumbData	[B
    //   31: aload_3
    //   32: ifnull +7 -> 39
    //   35: aload_3
    //   36: invokevirtual 130	java/io/ByteArrayOutputStream:close	()V
    //   39: return
    //   40: astore 4
    //   42: aconst_null
    //   43: astore_1
    //   44: aload_1
    //   45: astore_2
    //   46: aload 4
    //   48: invokevirtual 133	java/lang/Exception:printStackTrace	()V
    //   51: aload_1
    //   52: astore_2
    //   53: ldc 67
    //   55: ldc -121
    //   57: invokestatic 75	com/sina/weibo/sdk/utils/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload_1
    //   61: ifnull -22 -> 39
    //   64: aload_1
    //   65: invokevirtual 130	java/io/ByteArrayOutputStream:close	()V
    //   68: return
    //   69: astore_1
    //   70: aload_1
    //   71: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   74: return
    //   75: astore_1
    //   76: aconst_null
    //   77: astore_2
    //   78: aload_2
    //   79: ifnull +7 -> 86
    //   82: aload_2
    //   83: invokevirtual 130	java/io/ByteArrayOutputStream:close	()V
    //   86: aload_1
    //   87: athrow
    //   88: astore_2
    //   89: aload_2
    //   90: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   93: goto -7 -> 86
    //   96: astore_1
    //   97: aload_1
    //   98: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   101: return
    //   102: astore_1
    //   103: goto -25 -> 78
    //   106: astore 4
    //   108: aload_3
    //   109: astore_1
    //   110: goto -66 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	BaseMediaObject
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
  
  protected abstract BaseMediaObject toExtraMediaObject(String paramString);
  
  protected abstract String toExtraMediaString();
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.actionUrl);
    paramParcel.writeString(this.schema);
    paramParcel.writeString(this.identify);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.description);
    paramParcel.writeByteArray(this.thumbData);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\api\BaseMediaObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */