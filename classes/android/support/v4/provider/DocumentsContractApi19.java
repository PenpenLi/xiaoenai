package android.support.v4.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;

class DocumentsContractApi19
{
  private static final String TAG = "DocumentFile";
  
  public static boolean canRead(Context paramContext, Uri paramUri)
  {
    if (paramContext.checkCallingOrSelfUriPermission(paramUri, 1) != 0) {}
    while (TextUtils.isEmpty(getRawType(paramContext, paramUri))) {
      return false;
    }
    return true;
  }
  
  public static boolean canWrite(Context paramContext, Uri paramUri)
  {
    if (paramContext.checkCallingOrSelfUriPermission(paramUri, 2) != 0) {}
    String str;
    int i;
    do
    {
      do
      {
        return false;
        str = getRawType(paramContext, paramUri);
        i = queryForInt(paramContext, paramUri, "flags", 0);
      } while (TextUtils.isEmpty(str));
      if ((i & 0x4) != 0) {
        return true;
      }
      if (("vnd.android.document/directory".equals(str)) && ((i & 0x8) != 0)) {
        return true;
      }
    } while ((TextUtils.isEmpty(str)) || ((i & 0x2) == 0));
    return true;
  }
  
  private static void closeQuietly(AutoCloseable paramAutoCloseable)
  {
    if (paramAutoCloseable != null) {}
    try
    {
      paramAutoCloseable.close();
      return;
    }
    catch (RuntimeException paramAutoCloseable)
    {
      throw paramAutoCloseable;
    }
    catch (Exception paramAutoCloseable) {}
  }
  
  public static boolean delete(Context paramContext, Uri paramUri)
  {
    return DocumentsContract.deleteDocument(paramContext.getContentResolver(), paramUri);
  }
  
  /* Error */
  public static boolean exists(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 62	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_0
    //   5: aload_0
    //   6: aload_1
    //   7: iconst_1
    //   8: anewarray 42	java/lang/String
    //   11: dup
    //   12: iconst_0
    //   13: ldc 71
    //   15: aastore
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: invokevirtual 77	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   22: astore_1
    //   23: aload_1
    //   24: astore_0
    //   25: aload_1
    //   26: invokeinterface 83 1 0
    //   31: istore_3
    //   32: iload_3
    //   33: ifle +13 -> 46
    //   36: iconst_1
    //   37: istore 4
    //   39: aload_1
    //   40: invokestatic 85	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   43: iload 4
    //   45: ireturn
    //   46: iconst_0
    //   47: istore 4
    //   49: goto -10 -> 39
    //   52: astore_2
    //   53: aconst_null
    //   54: astore_1
    //   55: aload_1
    //   56: astore_0
    //   57: ldc 8
    //   59: new 87	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   66: ldc 90
    //   68: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_2
    //   72: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 107	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   81: pop
    //   82: aload_1
    //   83: invokestatic 85	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   86: iconst_0
    //   87: ireturn
    //   88: astore_1
    //   89: aconst_null
    //   90: astore_0
    //   91: aload_0
    //   92: invokestatic 85	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   95: aload_1
    //   96: athrow
    //   97: astore_1
    //   98: goto -7 -> 91
    //   101: astore_2
    //   102: goto -47 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramContext	Context
    //   0	105	1	paramUri	Uri
    //   52	20	2	localException1	Exception
    //   101	1	2	localException2	Exception
    //   31	2	3	i	int
    //   37	11	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	23	52	java/lang/Exception
    //   5	23	88	finally
    //   25	32	97	finally
    //   57	82	97	finally
    //   25	32	101	java/lang/Exception
  }
  
  public static String getName(Context paramContext, Uri paramUri)
  {
    return queryForString(paramContext, paramUri, "_display_name", null);
  }
  
  private static String getRawType(Context paramContext, Uri paramUri)
  {
    return queryForString(paramContext, paramUri, "mime_type", null);
  }
  
  public static String getType(Context paramContext, Uri paramUri)
  {
    paramUri = getRawType(paramContext, paramUri);
    paramContext = paramUri;
    if ("vnd.android.document/directory".equals(paramUri)) {
      paramContext = null;
    }
    return paramContext;
  }
  
  public static boolean isDirectory(Context paramContext, Uri paramUri)
  {
    return "vnd.android.document/directory".equals(getRawType(paramContext, paramUri));
  }
  
  public static boolean isDocumentUri(Context paramContext, Uri paramUri)
  {
    return DocumentsContract.isDocumentUri(paramContext, paramUri);
  }
  
  public static boolean isFile(Context paramContext, Uri paramUri)
  {
    paramContext = getRawType(paramContext, paramUri);
    return (!"vnd.android.document/directory".equals(paramContext)) && (!TextUtils.isEmpty(paramContext));
  }
  
  public static long lastModified(Context paramContext, Uri paramUri)
  {
    return queryForLong(paramContext, paramUri, "last_modified", 0L);
  }
  
  public static long length(Context paramContext, Uri paramUri)
  {
    return queryForLong(paramContext, paramUri, "_size", 0L);
  }
  
  private static int queryForInt(Context paramContext, Uri paramUri, String paramString, int paramInt)
  {
    return (int)queryForLong(paramContext, paramUri, paramString, paramInt);
  }
  
  /* Error */
  private static long queryForLong(Context paramContext, Uri paramUri, String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 62	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_0
    //   5: aload_0
    //   6: aload_1
    //   7: iconst_1
    //   8: anewarray 42	java/lang/String
    //   11: dup
    //   12: iconst_0
    //   13: aload_2
    //   14: aastore
    //   15: aconst_null
    //   16: aconst_null
    //   17: aconst_null
    //   18: invokevirtual 77	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   21: astore_1
    //   22: aload_1
    //   23: astore_0
    //   24: aload_1
    //   25: invokeinterface 137 1 0
    //   30: ifeq +33 -> 63
    //   33: aload_1
    //   34: astore_0
    //   35: aload_1
    //   36: iconst_0
    //   37: invokeinterface 141 2 0
    //   42: ifne +21 -> 63
    //   45: aload_1
    //   46: astore_0
    //   47: aload_1
    //   48: iconst_0
    //   49: invokeinterface 145 2 0
    //   54: lstore 5
    //   56: aload_1
    //   57: invokestatic 85	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   60: lload 5
    //   62: lreturn
    //   63: aload_1
    //   64: invokestatic 85	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   67: lload_3
    //   68: lreturn
    //   69: astore_2
    //   70: aconst_null
    //   71: astore_1
    //   72: aload_1
    //   73: astore_0
    //   74: ldc 8
    //   76: new 87	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   83: ldc 90
    //   85: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_2
    //   89: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 107	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   98: pop
    //   99: aload_1
    //   100: invokestatic 85	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   103: lload_3
    //   104: lreturn
    //   105: astore_1
    //   106: aconst_null
    //   107: astore_0
    //   108: aload_0
    //   109: invokestatic 85	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   112: aload_1
    //   113: athrow
    //   114: astore_1
    //   115: goto -7 -> 108
    //   118: astore_2
    //   119: goto -47 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramContext	Context
    //   0	122	1	paramUri	Uri
    //   0	122	2	paramString	String
    //   0	122	3	paramLong	long
    //   54	7	5	l	long
    // Exception table:
    //   from	to	target	type
    //   5	22	69	java/lang/Exception
    //   5	22	105	finally
    //   24	33	114	finally
    //   35	45	114	finally
    //   47	56	114	finally
    //   74	99	114	finally
    //   24	33	118	java/lang/Exception
    //   35	45	118	java/lang/Exception
    //   47	56	118	java/lang/Exception
  }
  
  /* Error */
  private static String queryForString(Context paramContext, Uri paramUri, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 62	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_0
    //   5: aload_0
    //   6: aload_1
    //   7: iconst_1
    //   8: anewarray 42	java/lang/String
    //   11: dup
    //   12: iconst_0
    //   13: aload_2
    //   14: aastore
    //   15: aconst_null
    //   16: aconst_null
    //   17: aconst_null
    //   18: invokevirtual 77	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   21: astore_1
    //   22: aload_1
    //   23: astore_0
    //   24: aload_1
    //   25: invokeinterface 137 1 0
    //   30: ifeq +31 -> 61
    //   33: aload_1
    //   34: astore_0
    //   35: aload_1
    //   36: iconst_0
    //   37: invokeinterface 141 2 0
    //   42: ifne +19 -> 61
    //   45: aload_1
    //   46: astore_0
    //   47: aload_1
    //   48: iconst_0
    //   49: invokeinterface 149 2 0
    //   54: astore_2
    //   55: aload_1
    //   56: invokestatic 85	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   59: aload_2
    //   60: areturn
    //   61: aload_1
    //   62: invokestatic 85	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   65: aload_3
    //   66: areturn
    //   67: astore_2
    //   68: aconst_null
    //   69: astore_1
    //   70: aload_1
    //   71: astore_0
    //   72: ldc 8
    //   74: new 87	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   81: ldc 90
    //   83: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_2
    //   87: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 107	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   96: pop
    //   97: aload_1
    //   98: invokestatic 85	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   101: aload_3
    //   102: areturn
    //   103: astore_1
    //   104: aconst_null
    //   105: astore_0
    //   106: aload_0
    //   107: invokestatic 85	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   110: aload_1
    //   111: athrow
    //   112: astore_1
    //   113: goto -7 -> 106
    //   116: astore_2
    //   117: goto -47 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramContext	Context
    //   0	120	1	paramUri	Uri
    //   0	120	2	paramString1	String
    //   0	120	3	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   5	22	67	java/lang/Exception
    //   5	22	103	finally
    //   24	33	112	finally
    //   35	45	112	finally
    //   47	55	112	finally
    //   72	97	112	finally
    //   24	33	116	java/lang/Exception
    //   35	45	116	java/lang/Exception
    //   47	55	116	java/lang/Exception
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\provider\DocumentsContractApi19.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */