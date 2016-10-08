package com.alibaba.sdk.android.webview.utils;

import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import java.io.File;

public class ImageUtils
{
  public static boolean deleteImageFile(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (!paramString.isFile()));
    return paramString.delete();
  }
  
  /* Error */
  public static String getDataColumn(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 34	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   7: aload_1
    //   8: iconst_1
    //   9: anewarray 36	java/lang/String
    //   12: dup
    //   13: iconst_0
    //   14: ldc 38
    //   16: aastore
    //   17: aload_2
    //   18: aload_3
    //   19: aconst_null
    //   20: invokevirtual 44	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   23: astore_1
    //   24: aload_1
    //   25: ifnull +39 -> 64
    //   28: aload_1
    //   29: invokeinterface 49 1 0
    //   34: ifeq +30 -> 64
    //   37: aload_1
    //   38: aload_1
    //   39: ldc 38
    //   41: invokeinterface 53 2 0
    //   46: invokeinterface 57 2 0
    //   51: astore_0
    //   52: aload_1
    //   53: ifnull +9 -> 62
    //   56: aload_1
    //   57: invokeinterface 60 1 0
    //   62: aload_0
    //   63: areturn
    //   64: aload_1
    //   65: ifnull +9 -> 74
    //   68: aload_1
    //   69: invokeinterface 60 1 0
    //   74: aconst_null
    //   75: areturn
    //   76: astore_0
    //   77: aload 4
    //   79: astore_1
    //   80: aload_1
    //   81: ifnull +9 -> 90
    //   84: aload_1
    //   85: invokeinterface 60 1 0
    //   90: aload_0
    //   91: athrow
    //   92: astore_0
    //   93: goto -13 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramContext	Context
    //   0	96	1	paramUri	Uri
    //   0	96	2	paramString	String
    //   0	96	3	paramArrayOfString	String[]
    //   1	77	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	24	76	finally
    //   28	52	92	finally
  }
  
  @TargetApi(19)
  public static String getPath(Context paramContext, Uri paramUri)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i;
    if (Build.VERSION.SDK_INT >= 19)
    {
      i = 1;
      if ((i == 0) || (!DocumentsContract.isDocumentUri(paramContext, paramUri))) {
        break label216;
      }
      if (!isExternalStorageDocument(paramUri)) {
        break label92;
      }
      paramContext = DocumentsContract.getDocumentId(paramUri).split(":");
      if ("primary".equalsIgnoreCase(paramContext[0])) {
        localObject1 = Environment.getExternalStorageDirectory() + "/" + paramContext[1];
      }
    }
    label92:
    label216:
    do
    {
      do
      {
        return (String)localObject1;
        i = 0;
        break;
        if (isDownloadsDocument(paramUri))
        {
          paramUri = DocumentsContract.getDocumentId(paramUri);
          return getDataColumn(paramContext, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(paramUri).longValue()), null, null);
        }
      } while (!isMediaDocument(paramUri));
      localObject1 = DocumentsContract.getDocumentId(paramUri).split(":");
      Object localObject3 = localObject1[0];
      if ("image".equals(localObject3)) {
        paramUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
      }
      for (;;)
      {
        return getDataColumn(paramContext, paramUri, "_id=?", new String[] { localObject1[1] });
        if ("video".equals(localObject3))
        {
          paramUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        }
        else
        {
          paramUri = (Uri)localObject2;
          if ("audio".equals(localObject3)) {
            paramUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
          }
        }
      }
      if ("content".equalsIgnoreCase(paramUri.getScheme()))
      {
        if (isGooglePhotosUri(paramUri)) {
          return paramUri.getLastPathSegment();
        }
        return getDataColumn(paramContext, paramUri, null, null);
      }
    } while (!"file".equalsIgnoreCase(paramUri.getScheme()));
    return paramUri.getPath();
  }
  
  public static boolean isDownloadsDocument(Uri paramUri)
  {
    return "com.android.providers.downloads.documents".equals(paramUri.getAuthority());
  }
  
  public static boolean isExternalStorageDocument(Uri paramUri)
  {
    return "com.android.externalstorage.documents".equals(paramUri.getAuthority());
  }
  
  public static boolean isGooglePhotosUri(Uri paramUri)
  {
    return "com.google.android.apps.photos.content".equals(paramUri.getAuthority());
  }
  
  public static boolean isMediaDocument(Uri paramUri)
  {
    return "com.android.providers.media.documents".equals(paramUri.getAuthority());
  }
  
  /* Error */
  public static String saveImageToCacheDir(Context paramContext, android.graphics.Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +16 -> 17
    //   4: bipush 7
    //   6: ldc -47
    //   8: ldc -45
    //   10: ldc -43
    //   12: invokestatic 219	com/alibaba/sdk/android/trace/AliSDKLogger:e	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   15: aconst_null
    //   16: areturn
    //   17: new 13	java/io/File
    //   20: dup
    //   21: aload_0
    //   22: invokevirtual 222	android/content/Context:getCacheDir	()Ljava/io/File;
    //   25: ldc -104
    //   27: invokespecial 225	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   30: astore_0
    //   31: aload_0
    //   32: invokevirtual 20	java/io/File:exists	()Z
    //   35: ifne +8 -> 43
    //   38: aload_0
    //   39: invokevirtual 228	java/io/File:mkdir	()Z
    //   42: pop
    //   43: new 13	java/io/File
    //   46: dup
    //   47: aload_0
    //   48: new 98	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   55: invokestatic 233	java/lang/System:currentTimeMillis	()J
    //   58: invokevirtual 236	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   61: ldc -18
    //   63: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokespecial 225	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   72: astore_3
    //   73: new 240	java/io/FileOutputStream
    //   76: dup
    //   77: aload_3
    //   78: invokespecial 243	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   81: astore_2
    //   82: aload_2
    //   83: astore_0
    //   84: aload_1
    //   85: getstatic 249	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   88: bipush 100
    //   90: aload_2
    //   91: invokevirtual 255	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   94: pop
    //   95: aload_2
    //   96: astore_0
    //   97: aload_2
    //   98: invokevirtual 258	java/io/FileOutputStream:flush	()V
    //   101: aload_2
    //   102: ifnull +7 -> 109
    //   105: aload_2
    //   106: invokevirtual 259	java/io/FileOutputStream:close	()V
    //   109: aload_3
    //   110: invokevirtual 262	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   113: areturn
    //   114: astore_0
    //   115: aload_0
    //   116: invokevirtual 265	java/io/IOException:printStackTrace	()V
    //   119: goto -10 -> 109
    //   122: astore_1
    //   123: aconst_null
    //   124: astore_2
    //   125: aload_2
    //   126: astore_0
    //   127: bipush 7
    //   129: ldc -47
    //   131: ldc -45
    //   133: ldc_w 267
    //   136: aload_1
    //   137: invokestatic 270	com/alibaba/sdk/android/trace/AliSDKLogger:e	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   140: aload_2
    //   141: astore_0
    //   142: aload_1
    //   143: invokevirtual 271	java/io/FileNotFoundException:printStackTrace	()V
    //   146: aload_2
    //   147: ifnull -38 -> 109
    //   150: aload_2
    //   151: invokevirtual 259	java/io/FileOutputStream:close	()V
    //   154: goto -45 -> 109
    //   157: astore_0
    //   158: aload_0
    //   159: invokevirtual 265	java/io/IOException:printStackTrace	()V
    //   162: goto -53 -> 109
    //   165: astore_1
    //   166: aconst_null
    //   167: astore_2
    //   168: aload_2
    //   169: astore_0
    //   170: bipush 7
    //   172: ldc -47
    //   174: ldc -45
    //   176: ldc_w 267
    //   179: aload_1
    //   180: invokestatic 270	com/alibaba/sdk/android/trace/AliSDKLogger:e	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   183: aload_2
    //   184: astore_0
    //   185: aload_1
    //   186: invokevirtual 265	java/io/IOException:printStackTrace	()V
    //   189: aload_2
    //   190: ifnull -81 -> 109
    //   193: aload_2
    //   194: invokevirtual 259	java/io/FileOutputStream:close	()V
    //   197: goto -88 -> 109
    //   200: astore_0
    //   201: aload_0
    //   202: invokevirtual 265	java/io/IOException:printStackTrace	()V
    //   205: goto -96 -> 109
    //   208: astore_1
    //   209: aconst_null
    //   210: astore_0
    //   211: aload_0
    //   212: ifnull +7 -> 219
    //   215: aload_0
    //   216: invokevirtual 259	java/io/FileOutputStream:close	()V
    //   219: aload_1
    //   220: athrow
    //   221: astore_0
    //   222: aload_0
    //   223: invokevirtual 265	java/io/IOException:printStackTrace	()V
    //   226: goto -7 -> 219
    //   229: astore_1
    //   230: goto -19 -> 211
    //   233: astore_1
    //   234: goto -66 -> 168
    //   237: astore_1
    //   238: goto -113 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	paramContext	Context
    //   0	241	1	paramBitmap	android.graphics.Bitmap
    //   81	113	2	localFileOutputStream	java.io.FileOutputStream
    //   72	38	3	localFile	File
    // Exception table:
    //   from	to	target	type
    //   105	109	114	java/io/IOException
    //   73	82	122	java/io/FileNotFoundException
    //   150	154	157	java/io/IOException
    //   73	82	165	java/io/IOException
    //   193	197	200	java/io/IOException
    //   73	82	208	finally
    //   215	219	221	java/io/IOException
    //   84	95	229	finally
    //   97	101	229	finally
    //   127	140	229	finally
    //   142	146	229	finally
    //   170	183	229	finally
    //   185	189	229	finally
    //   84	95	233	java/io/IOException
    //   97	101	233	java/io/IOException
    //   84	95	237	java/io/FileNotFoundException
    //   97	101	237	java/io/FileNotFoundException
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\utils\ImageUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */