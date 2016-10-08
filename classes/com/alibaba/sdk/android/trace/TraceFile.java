package com.alibaba.sdk.android.trace;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TraceFile
{
  private static int maxBackupIndex = 1;
  private int bufferSize;
  private long count;
  private byte[] encodeSecrt;
  private String fileName;
  private OutputStream fileWriter;
  private int maxFileSize = 5242880;
  private long nextRollover = 0L;
  
  public TraceFile(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this.encodeSecrt = paramArrayOfByte;
    setFile(paramString, paramInt1, paramInt2);
  }
  
  private byte[] encode(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (this.encodeSecrt != null) && (this.encodeSecrt.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ this.encodeSecrt[(i % this.encodeSecrt.length)]));
        i += 1;
      }
    }
    return paramArrayOfByte;
  }
  
  private void rollOver()
  {
    if (this.fileWriter != null) {
      this.nextRollover = (this.count + this.maxFileSize);
    }
    File localFile;
    if (maxBackupIndex > 0)
    {
      localFile = new File(this.fileName + '.' + maxBackupIndex);
      if (!localFile.exists()) {
        break label253;
      }
    }
    label253:
    for (boolean bool = localFile.delete();; bool = true)
    {
      int i = maxBackupIndex - 1;
      while ((i >= 1) && (bool))
      {
        localFile = new File(this.fileName + "." + i);
        if (localFile.exists()) {
          bool = localFile.renameTo(new File(this.fileName + '.' + (i + 1)));
        }
        i -= 1;
      }
      if (bool)
      {
        localFile = new File(this.fileName + "." + 1);
        closeFile();
        new File(this.fileName).renameTo(localFile);
        setFile(this.fileName, this.bufferSize, this.maxFileSize);
      }
      return;
    }
  }
  
  /* Error */
  public TraceFile append(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 51	com/alibaba/sdk/android/trace/TraceFile:fileName	Ljava/lang/String;
    //   6: ifnull +96 -> 102
    //   9: aload_0
    //   10: getfield 42	com/alibaba/sdk/android/trace/TraceFile:fileWriter	Ljava/io/OutputStream;
    //   13: ifnull +89 -> 102
    //   16: aload_1
    //   17: ifnull +85 -> 102
    //   20: aload_1
    //   21: invokevirtual 97	java/lang/String:length	()I
    //   24: istore_2
    //   25: iload_2
    //   26: ifle +76 -> 102
    //   29: aload_0
    //   30: aload_1
    //   31: ldc 99
    //   33: invokevirtual 103	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   36: invokespecial 105	com/alibaba/sdk/android/trace/TraceFile:encode	([B)[B
    //   39: astore_1
    //   40: aload_1
    //   41: ifnull +61 -> 102
    //   44: aload_1
    //   45: arraylength
    //   46: istore_2
    //   47: iload_2
    //   48: ifle +54 -> 102
    //   51: aload_0
    //   52: getfield 42	com/alibaba/sdk/android/trace/TraceFile:fileWriter	Ljava/io/OutputStream;
    //   55: aload_1
    //   56: invokevirtual 111	java/io/OutputStream:write	([B)V
    //   59: aload_0
    //   60: getfield 44	com/alibaba/sdk/android/trace/TraceFile:count	J
    //   63: lstore_3
    //   64: aload_0
    //   65: aload_1
    //   66: arraylength
    //   67: i2l
    //   68: lload_3
    //   69: ladd
    //   70: putfield 44	com/alibaba/sdk/android/trace/TraceFile:count	J
    //   73: aload_0
    //   74: getfield 44	com/alibaba/sdk/android/trace/TraceFile:count	J
    //   77: aload_0
    //   78: getfield 29	com/alibaba/sdk/android/trace/TraceFile:maxFileSize	I
    //   81: i2l
    //   82: lcmp
    //   83: iflt +19 -> 102
    //   86: aload_0
    //   87: getfield 44	com/alibaba/sdk/android/trace/TraceFile:count	J
    //   90: aload_0
    //   91: getfield 31	com/alibaba/sdk/android/trace/TraceFile:nextRollover	J
    //   94: lcmp
    //   95: iflt +7 -> 102
    //   98: aload_0
    //   99: invokespecial 113	com/alibaba/sdk/android/trace/TraceFile:rollOver	()V
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_0
    //   105: areturn
    //   106: astore_1
    //   107: aload_1
    //   108: instanceof 115
    //   111: ifeq -9 -> 102
    //   114: invokestatic 121	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   117: invokevirtual 124	java/lang/Thread:interrupt	()V
    //   120: goto -18 -> 102
    //   123: astore_1
    //   124: goto -22 -> 102
    //   127: astore_1
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	TraceFile
    //   0	132	1	paramString	String
    //   24	24	2	i	int
    //   63	6	3	l	long
    // Exception table:
    //   from	to	target	type
    //   51	102	106	java/io/IOException
    //   29	40	123	java/io/UnsupportedEncodingException
    //   44	47	123	java/io/UnsupportedEncodingException
    //   51	102	123	java/io/UnsupportedEncodingException
    //   107	120	123	java/io/UnsupportedEncodingException
    //   2	16	127	finally
    //   20	25	127	finally
    //   29	40	127	finally
    //   44	47	127	finally
    //   51	102	127	finally
    //   107	120	127	finally
  }
  
  public TraceFile appendln(String paramString)
  {
    return append(paramString + "\n\r");
  }
  
  public void closeFile()
  {
    try
    {
      flushFile();
      if (this.fileWriter != null) {
        this.fileWriter.close();
      }
      this.fileWriter = null;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        if ((localIOException instanceof InterruptedIOException)) {
          Thread.currentThread().interrupt();
        }
      }
    }
    finally {}
  }
  
  public void flushFile()
  {
    try
    {
      if (this.fileWriter != null) {
        this.fileWriter.flush();
      }
      this.count = 0L;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        if ((localIOException instanceof InterruptedIOException)) {
          Thread.currentThread().interrupt();
        }
      }
    }
    finally {}
  }
  
  public TraceFile log(String paramString)
  {
    return appendln(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS ", Locale.CHINA).format(new Date()) + paramString);
  }
  
  public void setFile(String paramString, int paramInt1, int paramInt2)
  {
    label126:
    for (;;)
    {
      try
      {
        closeFile();
        this.fileName = paramString;
        this.bufferSize = paramInt1;
        this.maxFileSize = paramInt2;
        try
        {
          localFile = new File(paramString);
          if (!localFile.exists()) {
            continue;
          }
          this.count = localFile.length();
          paramString = new FileOutputStream(paramString, true);
          if (paramInt1 <= 0) {
            break label126;
          }
          paramString = new BufferedOutputStream(paramString, paramInt1);
          this.fileWriter = paramString;
        }
        catch (IOException paramString)
        {
          File localFile;
          if (!(paramString instanceof InterruptedIOException)) {
            continue;
          }
          Thread.currentThread().interrupt();
          continue;
        }
        return;
      }
      finally {}
      localFile = localFile.getParentFile();
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\trace\TraceFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */