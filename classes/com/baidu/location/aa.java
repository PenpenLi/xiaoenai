package com.baidu.location;

import android.os.Environment;
import android.os.Process;
import java.io.File;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;

public class aa
  implements ax, n, Thread.UncaughtExceptionHandler
{
  private static aa gu = null;
  
  public static aa bg()
  {
    if (gu == null) {
      gu = new aa();
    }
    return gu;
  }
  
  private String jdMethod_if(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.close();
    return localStringWriter.toString();
  }
  
  public void bh()
  {
    Object localObject4 = null;
    for (;;)
    {
      try
      {
        Object localObject1 = Environment.getExternalStorageDirectory().getPath() + "/traces";
        localObject1 = new File((String)localObject1 + "/error_fs.dat");
        if (((File)localObject1).exists())
        {
          RandomAccessFile localRandomAccessFile = new RandomAccessFile((File)localObject1, "rw");
          localRandomAccessFile.seek(280L);
          if (1326 == localRandomAccessFile.readInt())
          {
            localRandomAccessFile.seek(308L);
            int i = localRandomAccessFile.readInt();
            if ((i <= 0) || (i >= 2048)) {
              break label239;
            }
            localObject1 = new byte[i];
            localRandomAccessFile.read((byte[])localObject1, 0, i);
            localObject1 = new String((byte[])localObject1, 0, i);
            localRandomAccessFile.seek(600L);
            i = localRandomAccessFile.readInt();
            Object localObject3 = localObject4;
            if (i > 0)
            {
              localObject3 = localObject4;
              if (i < 2048)
              {
                localObject3 = new byte[i];
                localRandomAccessFile.read((byte[])localObject3, 0, i);
                localObject3 = new String((byte[])localObject3, 0, i);
              }
            }
            if (jdMethod_new((String)localObject1, (String)localObject3))
            {
              localRandomAccessFile.seek(280L);
              localRandomAccessFile.writeInt(12346);
            }
          }
          localRandomAccessFile.close();
        }
        else
        {
          return;
        }
      }
      catch (Exception localException)
      {
        return;
      }
      label239:
      Object localObject2 = null;
    }
  }
  
  public void jdMethod_if(File paramFile, String paramString1, String paramString2)
  {
    try
    {
      paramFile = new RandomAccessFile(paramFile, "rw");
      paramFile.seek(280L);
      paramFile.writeInt(12346);
      paramFile.seek(300L);
      paramFile.writeLong(System.currentTimeMillis());
      byte[] arrayOfByte = paramString1.getBytes();
      paramFile.writeInt(arrayOfByte.length);
      paramFile.write(arrayOfByte, 0, arrayOfByte.length);
      paramFile.seek(600L);
      arrayOfByte = paramString2.getBytes();
      paramFile.writeInt(arrayOfByte.length);
      paramFile.write(arrayOfByte, 0, arrayOfByte.length);
      if (!jdMethod_new(paramString1, paramString2))
      {
        paramFile.seek(280L);
        paramFile.writeInt(1326);
      }
      paramFile.close();
      return;
    }
    catch (Exception paramFile) {}
  }
  
  boolean jdMethod_new(String paramString1, String paramString2)
  {
    if (!ar.bU()) {}
    for (;;)
    {
      return false;
      try
      {
        HttpPost localHttpPost = new HttpPost(c.Y);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new BasicNameValuePair("e0", paramString1));
        localArrayList.add(new BasicNameValuePair("e1", paramString2));
        localHttpPost.setEntity(new UrlEncodedFormEntity(localArrayList, "utf-8"));
        paramString1 = new DefaultHttpClient();
        paramString1.getParams().setParameter("http.connection.timeout", Integer.valueOf(12000));
        paramString1.getParams().setParameter("http.socket.timeout", Integer.valueOf(12000));
        int i = paramString1.execute(localHttpPost).getStatusLine().getStatusCode();
        if (i == 200) {
          return true;
        }
      }
      catch (Exception paramString1) {}
    }
    return false;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    localObject1 = null;
    if ((System.currentTimeMillis() - ab.bi() < 10000L) && (4.2F > f.getFrameVersion()))
    {
      l = e.jdMethod_do().a();
      if (System.currentTimeMillis() - l >= 40000L) {
        break label107;
      }
      paramThread = new File(c.jdMethod_goto() + File.separator + f.getJarFileName());
      if (paramThread.exists()) {
        paramThread.delete();
      }
    }
    while (!y.f0)
    {
      Process.killProcess(Process.myPid());
      return;
      label107:
      e.jdMethod_do().jdMethod_if(System.currentTimeMillis());
    }
    for (;;)
    {
      try
      {
        paramThread = jdMethod_if(paramThrowable);
      }
      catch (Exception paramThread)
      {
        Object localObject2;
        label262:
        label269:
        paramThread = null;
        paramThrowable = null;
        continue;
        localObject1 = new RandomAccessFile(localFile, "rw");
        ((RandomAccessFile)localObject1).seek(300L);
        l = ((RandomAccessFile)localObject1).readLong();
        if (System.currentTimeMillis() - l > 604800000L) {
          jdMethod_if(localFile, paramThrowable, paramThread);
        }
        ((RandomAccessFile)localObject1).close();
        continue;
      }
      for (;;)
      {
        try
        {
          paramThrowable = az.cn().jdMethod_char(false);
          paramThrowable = paramThrowable + k.p().o();
          if (paramThrowable == null) {
            continue;
          }
          paramThrowable = Jni.i(paramThrowable);
        }
        catch (Exception paramThrowable)
        {
          break label279;
          localObject1 = localFile;
          break label262;
          paramThrowable = null;
          break;
        }
        try
        {
          localObject2 = Environment.getExternalStorageDirectory().getPath() + "/traces";
          localFile = new File((String)localObject2 + "/error_fs.dat");
          if (localFile.exists()) {
            break label284;
          }
          localObject2 = new File((String)localObject2);
          if (!((File)localObject2).exists()) {
            ((File)localObject2).mkdirs();
          }
          if (localFile.createNewFile()) {
            continue;
          }
          jdMethod_if((File)localObject1, paramThrowable, paramThread);
        }
        catch (Exception paramThread)
        {
          break label269;
        }
      }
    }
    Process.killProcess(Process.myPid());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */