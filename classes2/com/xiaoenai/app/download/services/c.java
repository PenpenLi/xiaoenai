package com.xiaoenai.app.download.services;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.xiaoenai.app.download.b.a;
import com.xiaoenai.app.utils.v;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectTimeoutException;

public class c
  extends AsyncTask<Void, Integer, Long>
{
  private URL a;
  private File b;
  private File c;
  private String d;
  private RandomAccessFile e;
  private d f;
  private Context g;
  private long h;
  private long i;
  private long j;
  private long k;
  private long l;
  private long m;
  private long n;
  private Throwable o = null;
  private boolean p = false;
  private a q;
  private HttpGet r;
  private HttpResponse s;
  
  public c(Context paramContext, String paramString1, String paramString2, d paramd)
  {
    this.d = paramString1;
    this.a = new URL(paramString1);
    this.f = paramd;
    paramString1 = new File(this.a.getFile()).getName();
    this.b = new File(paramString2, paramString1);
    this.c = new File(paramString2, paramString1 + ".download");
    this.g = paramContext;
  }
  
  private long h()
  {
    Log.v("DownloadTask", "totalSize: " + this.j);
    if (!v.b(this.g)) {
      throw new NetworkErrorException("Network blocked.");
    }
    this.q = a.a("DownloadTask");
    this.r = new HttpGet(this.d);
    this.s = this.q.execute(this.r);
    this.j = this.s.getEntity().getContentLength();
    if ((this.b.exists()) && (this.j == this.b.length()))
    {
      Log.v(null, "Output file already exists. Skipping download.");
      if (this.f != null) {
        this.f.a(this, new com.xiaoenai.app.download.a.b("Output file already exists. Skipping download."));
      }
      throw new com.xiaoenai.app.download.a.b("Output file already exists. Skipping download.");
    }
    if (this.c.exists())
    {
      this.r.addHeader("Range", "bytes=" + this.c.length() + "-");
      this.i = this.c.length();
      this.q.a();
      this.q = a.a("DownloadTask");
      this.s = this.q.execute(this.r);
      Log.v("DownloadTask", "File is not complete, download now.");
      Log.v("DownloadTask", "File length:" + this.c.length() + " totalSize:" + this.j);
    }
    if (this.s.getStatusLine().getStatusCode() == 404)
    {
      this.o = new FileNotFoundException();
      throw new FileNotFoundException("file not exists. Skipping download.");
    }
    long l1 = com.xiaoenai.app.download.c.b.b();
    Log.i(null, "storage:" + l1 + " totalSize:" + this.j);
    if (this.j - this.c.length() > l1) {
      throw new com.xiaoenai.app.download.a.c("SD card no memory.");
    }
    this.e = new a(this.c, "rw");
    publishProgress(new Integer[] { Integer.valueOf(0), Integer.valueOf((int)this.j) });
    int i1 = a(this.s.getEntity().getContent(), this.e);
    if ((this.i + i1 != this.j) && (this.j != -1L) && (!this.p))
    {
      this.c.delete();
      throw new IOException("Download incomplete: " + i1 + " != " + this.j);
    }
    Log.v("DownloadTask", "Download completed successfully.");
    return i1;
  }
  
  public int a(InputStream paramInputStream, RandomAccessFile paramRandomAccessFile)
  {
    int i1 = 0;
    if ((paramInputStream == null) || (paramRandomAccessFile == null)) {
      return -1;
    }
    byte[] arrayOfByte = new byte[' '];
    BufferedInputStream localBufferedInputStream = new BufferedInputStream(paramInputStream, 8192);
    Log.v("DownloadTask", "length" + paramRandomAccessFile.length());
    for (;;)
    {
      long l1;
      try
      {
        paramRandomAccessFile.seek(paramRandomAccessFile.length());
        l1 = -1L;
        int i2;
        if (!this.p)
        {
          i2 = localBufferedInputStream.read(arrayOfByte, 0, 8192);
          if (i2 != -1) {}
        }
        else
        {
          return i1;
        }
        paramRandomAccessFile.write(arrayOfByte, 0, i2);
        i1 += i2;
        if (!v.b(this.g)) {
          throw new NetworkErrorException("Network blocked.");
        }
      }
      finally
      {
        this.q.a();
        this.q = null;
        paramRandomAccessFile.close();
        localBufferedInputStream.close();
        paramInputStream.close();
      }
      if (this.l == 0L)
      {
        if (l1 > 0L)
        {
          if (System.currentTimeMillis() - l1 > 30000L) {
            throw new ConnectTimeoutException("connection time out.");
          }
        }
        else {
          l1 = System.currentTimeMillis();
        }
      }
      else {
        l1 = -1L;
      }
    }
  }
  
  protected Long a(Void... paramVarArgs)
  {
    l2 = -1L;
    try
    {
      l1 = h();
      l2 = l1;
      l1 = l2;
      if (this.q != null)
      {
        this.q.a();
        l1 = l2;
      }
    }
    catch (NetworkErrorException paramVarArgs)
    {
      for (;;)
      {
        this.o = paramVarArgs;
        l1 = l2;
        if (this.q != null)
        {
          this.q.a();
          l1 = l2;
        }
      }
    }
    catch (com.xiaoenai.app.download.a.b paramVarArgs)
    {
      for (;;)
      {
        this.o = paramVarArgs;
        l1 = l2;
        if (this.q != null)
        {
          this.q.a();
          l1 = l2;
        }
      }
    }
    catch (com.xiaoenai.app.download.a.c paramVarArgs)
    {
      for (;;)
      {
        this.o = paramVarArgs;
        l1 = l2;
        if (this.q != null)
        {
          this.q.a();
          l1 = l2;
        }
      }
    }
    catch (FileNotFoundException paramVarArgs)
    {
      for (;;)
      {
        this.o = paramVarArgs;
        l1 = l2;
        if (this.q != null)
        {
          this.q.a();
          l1 = l2;
        }
      }
    }
    catch (IOException paramVarArgs)
    {
      for (;;)
      {
        this.o = paramVarArgs;
        long l1 = l2;
        if (this.q != null)
        {
          this.q.a();
          l1 = l2;
        }
      }
    }
    finally
    {
      if (this.q == null) {
        break label198;
      }
      this.q.a();
    }
    return Long.valueOf(l1);
  }
  
  public String a()
  {
    return this.d;
  }
  
  protected void a(Long paramLong)
  {
    if ((paramLong.longValue() == -1L) || (this.p) || (this.o != null))
    {
      if (this.o != null) {
        Log.v("DownloadTask", "Download failed." + this.o.getMessage());
      }
      if (this.f != null) {
        this.f.a(this, this.o);
      }
    }
    do
    {
      return;
      this.c.renameTo(this.b);
    } while (this.f == null);
    this.f.c(this);
  }
  
  protected void a(Integer... paramVarArgs)
  {
    if (paramVarArgs.length > 1)
    {
      this.j = paramVarArgs[1].intValue();
      if ((this.j == -1L) && (this.f != null)) {
        this.f.a(this, this.o);
      }
    }
    do
    {
      return;
      this.n = (System.currentTimeMillis() - this.m);
      this.h = paramVarArgs[0].intValue();
      this.k = ((this.h + this.i) * 100L / this.j);
      this.l = (this.h / this.n);
    } while (this.f == null);
    this.f.a(this);
  }
  
  public boolean b()
  {
    return this.p;
  }
  
  public long c()
  {
    return this.k;
  }
  
  public long d()
  {
    return (this.h + this.i) / 1024L;
  }
  
  public long e()
  {
    return this.j / 1024L;
  }
  
  public long f()
  {
    return this.l;
  }
  
  public String g()
  {
    return this.b.getAbsolutePath();
  }
  
  public void onCancelled()
  {
    super.onCancelled();
    this.p = true;
  }
  
  protected void onPreExecute()
  {
    this.m = System.currentTimeMillis();
    if (this.f != null) {
      this.f.b(this);
    }
  }
  
  private final class a
    extends RandomAccessFile
  {
    private int b = 0;
    
    public a(File paramFile, String paramString)
    {
      super(paramString);
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      super.write(paramArrayOfByte, paramInt1, paramInt2);
      this.b += paramInt2;
      c.a(c.this, new Integer[] { Integer.valueOf(this.b) });
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\download\services\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */