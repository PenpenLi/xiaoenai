package com.alibaba.wireless.security.open.initialize;

import android.content.ContextWrapper;
import com.alibaba.wireless.security.open.SecException;
import com.taobao.wireless.security.adapter.dynamicupdatelib.DynamicUpdateLibAdapter;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  b a = null;
  private ArrayList b = new ArrayList();
  
  a(b paramb)
  {
    this.a = paramb;
  }
  
  private static int a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((paramArrayOfInt1 == null) && (paramArrayOfInt2 != null)) {
      return -1;
    }
    if ((paramArrayOfInt1 != null) && (paramArrayOfInt2 == null)) {
      return 1;
    }
    if ((paramArrayOfInt1 == null) && (paramArrayOfInt2 == null)) {
      return 0;
    }
    int i;
    int j;
    if (paramArrayOfInt1.length < paramArrayOfInt2.length)
    {
      i = paramArrayOfInt1.length;
      j = 0;
    }
    for (;;)
    {
      if (j >= i) {
        break label82;
      }
      if (paramArrayOfInt1[j] > paramArrayOfInt2[j])
      {
        return 1;
        i = paramArrayOfInt2.length;
        break;
      }
      if (paramArrayOfInt1[j] < paramArrayOfInt2[j]) {
        return -1;
      }
      j += 1;
    }
    label82:
    if (paramArrayOfInt1.length == paramArrayOfInt2.length) {
      return 0;
    }
    if (i == paramArrayOfInt1.length) {
      return -1;
    }
    return 1;
  }
  
  private static int[] a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || (!paramString.startsWith("libsecuritysdk-"))) {}
    int i;
    int j;
    do
    {
      return null;
      i = paramString.indexOf('-') + 1;
      j = paramString.lastIndexOf('.');
    } while ((i == -1) || (i >= paramString.length()) || (j == -1) || (j >= paramString.length()));
    return b(paramString.substring(i, j));
  }
  
  private b.a b(ContextWrapper paramContextWrapper)
  {
    b.a locala = new b.a();
    locala.a = false;
    try
    {
      Object localObject = paramContextWrapper.getFilesDir();
      if (localObject != null)
      {
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdir();
        }
        locala.a = ((File)localObject).exists();
        return locala;
      }
      localObject = this.a;
      paramContextWrapper = b.a(paramContextWrapper);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContextWrapper).append("/files/");
      paramContextWrapper = new File(((StringBuilder)localObject).toString());
      paramContextWrapper.mkdir();
      locala.a = paramContextWrapper.exists();
      return locala;
    }
    catch (Throwable paramContextWrapper)
    {
      paramContextWrapper.printStackTrace();
    }
    return locala;
  }
  
  private static int[] b(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.split("\\.");
      if ((paramString != null) && (paramString.length > 1))
      {
        int[] arrayOfInt = new int[paramString.length];
        int i = 0;
        while (i < paramString.length) {
          try
          {
            arrayOfInt[i] = Integer.valueOf(paramString[i]).intValue();
            i += 1;
          }
          catch (NumberFormatException paramString)
          {
            return null;
          }
        }
        return arrayOfInt;
      }
    }
    return null;
  }
  
  private static File c()
  {
    Object localObject1 = null;
    int[] arrayOfInt = null;
    Object localObject5 = null;
    Object localObject6 = DynamicUpdateLibAdapter.getDownloadFolderDirAdapter();
    Object localObject4 = localObject5;
    if (localObject6 != null)
    {
      if (((String)localObject6).length() != 0) {
        break label31;
      }
      localObject4 = localObject5;
    }
    label31:
    Object localObject3;
    int i;
    for (;;)
    {
      return (File)localObject4;
      localObject3 = arrayOfInt;
      try
      {
        Object localObject7 = new File((String)localObject6);
        localObject3 = arrayOfInt;
        localObject6 = new ArrayList();
        localObject4 = localObject5;
        localObject3 = arrayOfInt;
        if (((File)localObject7).exists())
        {
          localObject4 = localObject5;
          localObject3 = arrayOfInt;
          if (((File)localObject7).isDirectory())
          {
            localObject3 = arrayOfInt;
            localObject7 = ((File)localObject7).listFiles();
            localObject4 = localObject5;
            if (localObject7 != null)
            {
              localObject3 = arrayOfInt;
              int j = localObject7.length;
              i = 0;
              localObject4 = null;
              if (i < j)
              {
                localObject5 = localObject7[i];
                localObject3 = localObject1;
                if (!((File)localObject5).isFile()) {
                  break label264;
                }
                localObject3 = localObject1;
                arrayOfInt = a(((File)localObject5).getName());
                if (arrayOfInt == null) {
                  break label264;
                }
                if (localObject4 != null)
                {
                  if (localObject4 != null)
                  {
                    localObject3 = localObject1;
                    if (a(arrayOfInt, (int[])localObject4) <= 0) {}
                  }
                }
                else
                {
                  if (localObject1 == null) {
                    break;
                  }
                  localObject3 = localObject1;
                  ((ArrayList)localObject6).add(localObject1);
                  break;
                }
                localObject3 = localObject1;
                ((ArrayList)localObject6).add(localObject5);
                break label264;
              }
              else
              {
                localObject3 = localObject1;
                localObject5 = ((ArrayList)localObject6).iterator();
                for (;;)
                {
                  localObject4 = localObject1;
                  localObject3 = localObject1;
                  if (!((Iterator)localObject5).hasNext()) {
                    break;
                  }
                  localObject3 = localObject1;
                  localObject4 = (File)((Iterator)localObject5).next();
                  if (localObject4 != null)
                  {
                    localObject3 = localObject1;
                    ((File)localObject4).delete();
                  }
                }
              }
              localObject3 = arrayOfInt;
            }
          }
        }
      }
      catch (Exception localException)
      {
        return (File)localObject3;
      }
    }
    Object localObject2 = localObject5;
    for (;;)
    {
      i += 1;
      localObject4 = localObject3;
      break;
      label264:
      localObject3 = localObject4;
    }
  }
  
  final void a()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((IInitializeComponent.IInitFinishListener)localIterator.next()).onSuccess();
    }
  }
  
  public final void a(IInitializeComponent.IInitFinishListener paramIInitFinishListener)
  {
    if (paramIInitFinishListener != null) {
      this.b.add(paramIInitFinishListener);
    }
  }
  
  final boolean a(ContextWrapper paramContextWrapper)
  {
    if (b(paramContextWrapper).a)
    {
      Object localObject = this.a;
      String str = b.a();
      localObject = new File(str);
      File localFile = c();
      int[] arrayOfInt1 = a(((File)localObject).getName());
      localObject = DynamicUpdateLibAdapter.getMiniVersion();
      if (localObject != null)
      {
        localObject = b((String)localObject);
        if (localFile == null) {
          break label133;
        }
        int[] arrayOfInt2 = a(localFile.getName());
        if ((a(arrayOfInt2, (int[])localObject) < 0) || (a(arrayOfInt2, arrayOfInt1) <= 0)) {
          break label133;
        }
        if (c.a().a(paramContextWrapper, localFile.getAbsolutePath()) != 1) {
          break label121;
        }
        i = 1;
        if (i == 0) {
          break label127;
        }
      }
      label121:
      label127:
      label133:
      while (c.a().a(paramContextWrapper, str) == 1)
      {
        for (;;)
        {
          return true;
          localObject = null;
          break;
          int i = 0;
        }
        localFile.delete();
      }
      return false;
    }
    return false;
  }
  
  final void b()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((IInitializeComponent.IInitFinishListener)localIterator.next()).onError();
    }
  }
  
  public final void b(IInitializeComponent.IInitFinishListener paramIInitFinishListener)
  {
    if (paramIInitFinishListener != null) {
      this.b.remove(paramIInitFinishListener);
    }
  }
  
  public static final class a
    implements Runnable
  {
    private ContextWrapper a;
    private boolean b = true;
    private boolean c = true;
    private a d = null;
    
    public a(a parama, ContextWrapper paramContextWrapper)
    {
      this.d = parama;
      this.a = paramContextWrapper;
      this.b = true;
      this.c = true;
    }
    
    public final void run()
    {
      boolean bool = this.b;
      if (this.c) {
        try
        {
          b localb = this.d.a;
          if (b.a(this.a))
          {
            this.d.a();
            return;
          }
          this.d.b();
          return;
        }
        catch (SecException localSecException)
        {
          localSecException.printStackTrace();
          this.d.b();
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\initialize\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */