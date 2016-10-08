package com.b.a.a;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public abstract class h
  extends f
{
  private static final String LOG_TAG = "FileAsyncHttpRH";
  protected final boolean append;
  protected final File file;
  protected File frontendFile;
  protected final boolean renameIfExists;
  
  public h(Context paramContext)
  {
    this.file = getTemporaryFile(paramContext);
    this.append = false;
    this.renameIfExists = false;
  }
  
  public h(File paramFile)
  {
    this(paramFile, false);
  }
  
  public h(File paramFile, boolean paramBoolean)
  {
    this(paramFile, paramBoolean, false);
  }
  
  public h(File paramFile, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramFile != null) {}
    for (boolean bool = true;; bool = false)
    {
      u.a(bool, "File passed into FileAsyncHttpResponseHandler constructor must not be null");
      if ((!paramFile.isDirectory()) && (!paramFile.getParentFile().isDirectory())) {
        u.a(paramFile.getParentFile().mkdirs(), "Cannot create parent directories for requested File location");
      }
      if ((paramFile.isDirectory()) && (!paramFile.mkdirs())) {
        a.a.b("FileAsyncHttpRH", "Cannot create directories for requested Directory location, might not be a problem");
      }
      this.file = paramFile;
      this.append = paramBoolean1;
      this.renameIfExists = paramBoolean2;
      return;
    }
  }
  
  public boolean deleteTargetFile()
  {
    return (getTargetFile() != null) && (getTargetFile().delete());
  }
  
  protected File getOriginalFile()
  {
    if (this.file != null) {}
    for (boolean bool = true;; bool = false)
    {
      u.a(bool, "Target file is null, fatal!");
      return this.file;
    }
  }
  
  protected byte[] getResponseData(HttpEntity paramHttpEntity)
  {
    int i = 0;
    if (paramHttpEntity != null)
    {
      InputStream localInputStream = paramHttpEntity.getContent();
      long l = paramHttpEntity.getContentLength();
      paramHttpEntity = new FileOutputStream(getTargetFile(), this.append);
      if (localInputStream != null)
      {
        try
        {
          byte[] arrayOfByte = new byte['က'];
          for (;;)
          {
            int j = localInputStream.read(arrayOfByte);
            if ((j == -1) || (Thread.currentThread().isInterrupted())) {
              break;
            }
            i += j;
            paramHttpEntity.write(arrayOfByte, 0, j);
            sendProgressMessage(i, l);
          }
          a.a(localInputStream);
        }
        finally
        {
          a.a(localInputStream);
          paramHttpEntity.flush();
          a.a(paramHttpEntity);
        }
        paramHttpEntity.flush();
        a.a(paramHttpEntity);
      }
    }
    return null;
  }
  
  public File getTargetFile()
  {
    if (this.frontendFile == null) {
      if (!getOriginalFile().isDirectory()) {
        break label32;
      }
    }
    label32:
    for (File localFile = getTargetFileByParsingURL();; localFile = getOriginalFile())
    {
      this.frontendFile = localFile;
      return this.frontendFile;
    }
  }
  
  protected File getTargetFileByParsingURL()
  {
    u.a(getOriginalFile().isDirectory(), "Target file is not a directory, cannot proceed");
    boolean bool;
    Object localObject;
    String str;
    File localFile;
    label114:
    int i;
    if (getRequestURI() != null)
    {
      bool = true;
      u.a(bool, "RequestURI is null, cannot proceed");
      localObject = getRequestURI().toString();
      str = ((String)localObject).substring(((String)localObject).lastIndexOf('/') + 1, ((String)localObject).length());
      localFile = new File(getOriginalFile(), str);
      localObject = localFile;
      if (localFile.exists())
      {
        localObject = localFile;
        if (this.renameIfExists)
        {
          if (str.contains(".")) {
            break label162;
          }
          localObject = str + " (%d)";
          i = 0;
        }
      }
    }
    for (;;)
    {
      localFile = new File(getOriginalFile(), String.format((String)localObject, new Object[] { Integer.valueOf(i) }));
      if (!localFile.exists())
      {
        localObject = localFile;
        return (File)localObject;
        bool = false;
        break;
        label162:
        localObject = str.substring(0, str.lastIndexOf('.')) + " (%d)" + str.substring(str.lastIndexOf('.'), str.length());
        break label114;
      }
      i += 1;
    }
  }
  
  protected File getTemporaryFile(Context paramContext)
  {
    if (paramContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      u.a(bool, "Tried creating temporary file without having Context");
      try
      {
        paramContext = File.createTempFile("temp_", "_handled", paramContext.getCacheDir());
        return paramContext;
      }
      catch (IOException paramContext)
      {
        a.a.b("FileAsyncHttpRH", "Cannot create temporary file", paramContext);
      }
    }
    return null;
  }
  
  public abstract void onFailure(int paramInt, Header[] paramArrayOfHeader, Throwable paramThrowable, File paramFile);
  
  public final void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    onFailure(paramInt, paramArrayOfHeader, paramThrowable, getTargetFile());
  }
  
  public abstract void onSuccess(int paramInt, Header[] paramArrayOfHeader, File paramFile);
  
  public final void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte)
  {
    onSuccess(paramInt, paramArrayOfHeader, getTargetFile());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\b\a\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */