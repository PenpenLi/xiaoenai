package com.alibaba.mtl.log.e;

import java.io.File;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class k
{
  static File jdField_a_of_type_JavaIoFile = null;
  static FileChannel jdField_a_of_type_JavaNioChannelsFileChannel;
  static FileLock jdField_a_of_type_JavaNioChannelsFileLock;
  
  /* Error */
  public static boolean c(android.content.Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 12	com/alibaba/mtl/log/e/k:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   8: ifnonnull +41 -> 49
    //   11: new 23	java/io/File
    //   14: dup
    //   15: new 25	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   22: aload_0
    //   23: invokevirtual 34	android/content/Context:getFilesDir	()Ljava/io/File;
    //   26: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: getstatic 42	java/io/File:separator	Ljava/lang/String;
    //   32: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 47
    //   37: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   46: putstatic 12	com/alibaba/mtl/log/e/k:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   49: getstatic 12	com/alibaba/mtl/log/e/k:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   52: invokevirtual 58	java/io/File:exists	()Z
    //   55: istore_1
    //   56: iload_1
    //   57: istore_2
    //   58: iload_1
    //   59: ifne +10 -> 69
    //   62: getstatic 12	com/alibaba/mtl/log/e/k:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   65: invokevirtual 61	java/io/File:createNewFile	()Z
    //   68: istore_2
    //   69: iload_2
    //   70: ifne +10 -> 80
    //   73: iload_3
    //   74: istore_1
    //   75: ldc 2
    //   77: monitorexit
    //   78: iload_1
    //   79: ireturn
    //   80: getstatic 63	com/alibaba/mtl/log/e/k:jdField_a_of_type_JavaNioChannelsFileChannel	Ljava/nio/channels/FileChannel;
    //   83: astore_0
    //   84: aload_0
    //   85: ifnonnull +21 -> 106
    //   88: new 65	java/io/RandomAccessFile
    //   91: dup
    //   92: getstatic 12	com/alibaba/mtl/log/e/k:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   95: ldc 67
    //   97: invokespecial 70	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   100: invokevirtual 74	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   103: putstatic 63	com/alibaba/mtl/log/e/k:jdField_a_of_type_JavaNioChannelsFileChannel	Ljava/nio/channels/FileChannel;
    //   106: getstatic 63	com/alibaba/mtl/log/e/k:jdField_a_of_type_JavaNioChannelsFileChannel	Ljava/nio/channels/FileChannel;
    //   109: invokevirtual 80	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   112: astore_0
    //   113: aload_0
    //   114: ifnull +51 -> 165
    //   117: aload_0
    //   118: putstatic 82	com/alibaba/mtl/log/e/k:jdField_a_of_type_JavaNioChannelsFileLock	Ljava/nio/channels/FileLock;
    //   121: iload_3
    //   122: istore_1
    //   123: goto -48 -> 75
    //   126: astore_0
    //   127: aconst_null
    //   128: astore_0
    //   129: ldc 84
    //   131: new 25	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   138: ldc 86
    //   140: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_0
    //   144: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 92	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   153: pop
    //   154: iconst_0
    //   155: istore_1
    //   156: goto -81 -> 75
    //   159: astore_0
    //   160: iconst_0
    //   161: istore_1
    //   162: goto -87 -> 75
    //   165: goto -36 -> 129
    //   168: astore_0
    //   169: ldc 2
    //   171: monitorexit
    //   172: aload_0
    //   173: athrow
    //   174: astore_0
    //   175: iload_1
    //   176: istore_2
    //   177: goto -108 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	paramContext	android.content.Context
    //   55	121	1	bool1	boolean
    //   57	120	2	bool2	boolean
    //   1	121	3	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   106	113	126	java/lang/Throwable
    //   117	121	126	java/lang/Throwable
    //   88	106	159	java/lang/Exception
    //   5	49	168	finally
    //   49	56	168	finally
    //   62	69	168	finally
    //   80	84	168	finally
    //   88	106	168	finally
    //   106	113	168	finally
    //   117	121	168	finally
    //   129	154	168	finally
    //   62	69	174	java/io/IOException
  }
  
  /* Error */
  public static void release()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 82	com/alibaba/mtl/log/e/k:jdField_a_of_type_JavaNioChannelsFileLock	Ljava/nio/channels/FileLock;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +13 -> 21
    //   11: getstatic 82	com/alibaba/mtl/log/e/k:jdField_a_of_type_JavaNioChannelsFileLock	Ljava/nio/channels/FileLock;
    //   14: invokevirtual 97	java/nio/channels/FileLock:release	()V
    //   17: aconst_null
    //   18: putstatic 82	com/alibaba/mtl/log/e/k:jdField_a_of_type_JavaNioChannelsFileLock	Ljava/nio/channels/FileLock;
    //   21: getstatic 63	com/alibaba/mtl/log/e/k:jdField_a_of_type_JavaNioChannelsFileChannel	Ljava/nio/channels/FileChannel;
    //   24: astore_0
    //   25: aload_0
    //   26: ifnull +13 -> 39
    //   29: getstatic 63	com/alibaba/mtl/log/e/k:jdField_a_of_type_JavaNioChannelsFileChannel	Ljava/nio/channels/FileChannel;
    //   32: invokevirtual 100	java/nio/channels/FileChannel:close	()V
    //   35: aconst_null
    //   36: putstatic 63	com/alibaba/mtl/log/e/k:jdField_a_of_type_JavaNioChannelsFileChannel	Ljava/nio/channels/FileChannel;
    //   39: ldc 2
    //   41: monitorexit
    //   42: return
    //   43: astore_0
    //   44: aconst_null
    //   45: putstatic 82	com/alibaba/mtl/log/e/k:jdField_a_of_type_JavaNioChannelsFileLock	Ljava/nio/channels/FileLock;
    //   48: goto -27 -> 21
    //   51: astore_0
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    //   57: astore_0
    //   58: aconst_null
    //   59: putstatic 82	com/alibaba/mtl/log/e/k:jdField_a_of_type_JavaNioChannelsFileLock	Ljava/nio/channels/FileLock;
    //   62: aload_0
    //   63: athrow
    //   64: astore_0
    //   65: aconst_null
    //   66: putstatic 63	com/alibaba/mtl/log/e/k:jdField_a_of_type_JavaNioChannelsFileChannel	Ljava/nio/channels/FileChannel;
    //   69: goto -30 -> 39
    //   72: astore_0
    //   73: aconst_null
    //   74: putstatic 63	com/alibaba/mtl/log/e/k:jdField_a_of_type_JavaNioChannelsFileChannel	Ljava/nio/channels/FileChannel;
    //   77: aload_0
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	20	0	localObject1	Object
    //   43	1	0	localIOException	java.io.IOException
    //   51	5	0	localObject2	Object
    //   57	6	0	localObject3	Object
    //   64	1	0	localException	Exception
    //   72	6	0	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   11	17	43	java/io/IOException
    //   3	7	51	finally
    //   17	21	51	finally
    //   21	25	51	finally
    //   35	39	51	finally
    //   44	48	51	finally
    //   58	64	51	finally
    //   65	69	51	finally
    //   73	79	51	finally
    //   11	17	57	finally
    //   29	35	64	java/lang/Exception
    //   29	35	72	finally
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\e\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */