package com.ta.utdid2.c.a;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

public class d
{
  private static final Object c = new Object();
  private File jdField_a_of_type_JavaIoFile;
  private HashMap<File, a> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final Object b = new Object();
  
  public d(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      this.jdField_a_of_type_JavaIoFile = new File(paramString);
      return;
    }
    throw new RuntimeException("Directory can not be empty");
  }
  
  private File a()
  {
    synchronized (this.b)
    {
      File localFile = this.jdField_a_of_type_JavaIoFile;
      return localFile;
    }
  }
  
  private static File a(File paramFile)
  {
    return new File(paramFile.getPath() + ".bak");
  }
  
  private File a(File paramFile, String paramString)
  {
    if (paramString.indexOf(File.separatorChar) < 0) {
      return new File(paramFile, paramString);
    }
    throw new IllegalArgumentException("File " + paramString + " contains a path separator");
  }
  
  private File b(String paramString)
  {
    return a(a(), paramString + ".xml");
  }
  
  public b a(String arg1, int paramInt)
  {
    localFile = b(???);
    synchronized (c)
    {
      a locala = (a)this.jdField_a_of_type_JavaUtilHashMap.get(localFile);
      if ((locala != null) && (!locala.c())) {
        return locala;
      }
      ??? = a(localFile);
      if (???.exists())
      {
        localFile.delete();
        ???.renameTo(localFile);
      }
      if ((localFile.exists()) && (!localFile.canRead())) {}
      Object localObject7 = null;
      Object localObject8 = null;
      Object localObject9 = null;
      Object localObject10 = null;
      Object localObject1 = null;
      ??? = (String)localObject1;
      if (localFile.exists())
      {
        ??? = (String)localObject1;
        if (localFile.canRead())
        {
          localObject1 = localObject7;
          localObject4 = localObject8;
          localObject5 = localObject9;
          localObject6 = localObject10;
        }
      }
      try
      {
        FileInputStream localFileInputStream = new FileInputStream(localFile);
        localObject1 = localObject7;
        localObject4 = localObject8;
        localObject5 = localObject9;
        localObject6 = localObject10;
        ??? = e.a(localFileInputStream);
        localObject1 = ???;
        localObject4 = ???;
        localObject5 = ???;
        localObject6 = ???;
        localFileInputStream.close();
      }
      catch (XmlPullParserException ???)
      {
        for (;;)
        {
          try
          {
            ??? = new FileInputStream(localFile);
            localObject4 = new byte[???.available()];
            ???.read((byte[])localObject4);
            new String((byte[])localObject4, 0, localObject4.length, "UTF-8");
            ??? = (String)localObject2;
          }
          catch (FileNotFoundException ???)
          {
            ???.printStackTrace();
            ??? = (String)localObject2;
          }
          catch (IOException ???)
          {
            ???.printStackTrace();
            ??? = (String)localObject2;
          }
        }
      }
      catch (FileNotFoundException ???)
      {
        for (;;)
        {
          ???.printStackTrace();
          ??? = (String)localObject4;
        }
      }
      catch (IOException ???)
      {
        for (;;)
        {
          ???.printStackTrace();
          ??? = (String)localObject5;
        }
      }
      catch (Exception ???)
      {
        for (;;)
        {
          ???.printStackTrace();
          ??? = (String)localObject6;
          continue;
          localObject4 = (a)this.jdField_a_of_type_JavaUtilHashMap.get(localFile);
          Object localObject3 = localObject4;
          if (localObject4 == null)
          {
            localObject3 = new a(localFile, paramInt, ???);
            this.jdField_a_of_type_JavaUtilHashMap.put(localFile, localObject3);
          }
        }
      }
      localObject5 = c;
      if (locala != null) {
        try
        {
          locala.a(???);
          localObject1 = locala;
          return (b)localObject1;
        }
        finally {}
      }
    }
  }
  
  private static final class a
    implements b
  {
    private static final Object d = new Object();
    private WeakHashMap<b.b, Object> a;
    private final File b;
    private final int jdField_c_of_type_Int;
    private final File jdField_c_of_type_JavaIoFile;
    private Map jdField_c_of_type_JavaUtilMap;
    private boolean k = false;
    
    a(File paramFile, int paramInt, Map paramMap)
    {
      this.b = paramFile;
      this.jdField_c_of_type_JavaIoFile = d.b(paramFile);
      this.jdField_c_of_type_Int = paramInt;
      if (paramMap != null) {}
      for (;;)
      {
        this.jdField_c_of_type_JavaUtilMap = paramMap;
        this.a = new WeakHashMap();
        return;
        paramMap = new HashMap();
      }
    }
    
    private FileOutputStream a(File paramFile)
    {
      try
      {
        FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
        return localFileOutputStream;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        if (!paramFile.getParentFile().mkdir()) {
          return null;
        }
        try
        {
          paramFile = new FileOutputStream(paramFile);
          return paramFile;
        }
        catch (FileNotFoundException paramFile) {}
      }
      return null;
    }
    
    private boolean d()
    {
      if (this.b.exists()) {
        if (!this.jdField_c_of_type_JavaIoFile.exists()) {
          if (this.b.renameTo(this.jdField_c_of_type_JavaIoFile)) {
            break label44;
          }
        }
      }
      for (;;)
      {
        return false;
        this.b.delete();
        try
        {
          label44:
          FileOutputStream localFileOutputStream = a(this.b);
          if (localFileOutputStream == null) {
            continue;
          }
          e.a(this.jdField_c_of_type_JavaUtilMap, localFileOutputStream);
          localFileOutputStream.close();
          this.jdField_c_of_type_JavaIoFile.delete();
          return true;
        }
        catch (IOException localIOException)
        {
          if ((!this.b.exists()) || (this.b.delete())) {
            continue;
          }
          return false;
        }
        catch (XmlPullParserException localXmlPullParserException)
        {
          for (;;) {}
        }
      }
    }
    
    public b.a a()
    {
      return new a();
    }
    
    public void a(Map paramMap)
    {
      if (paramMap != null) {
        try
        {
          this.jdField_c_of_type_JavaUtilMap = paramMap;
          return;
        }
        finally {}
      }
    }
    
    public void a(boolean paramBoolean)
    {
      try
      {
        this.k = paramBoolean;
        return;
      }
      finally {}
    }
    
    public boolean a()
    {
      return (this.b != null) && (new File(this.b.getAbsolutePath()).exists());
    }
    
    public boolean c()
    {
      try
      {
        boolean bool = this.k;
        return bool;
      }
      finally {}
    }
    
    public Map<String, ?> getAll()
    {
      try
      {
        HashMap localHashMap = new HashMap(this.jdField_c_of_type_JavaUtilMap);
        return localHashMap;
      }
      finally {}
    }
    
    public long getLong(String paramString, long paramLong)
    {
      try
      {
        paramString = (Long)this.jdField_c_of_type_JavaUtilMap.get(paramString);
        if (paramString != null) {
          paramLong = paramString.longValue();
        }
        return paramLong;
      }
      finally {}
    }
    
    public String getString(String paramString1, String paramString2)
    {
      for (;;)
      {
        try
        {
          paramString1 = (String)this.jdField_c_of_type_JavaUtilMap.get(paramString1);
          if (paramString1 != null) {
            return paramString1;
          }
        }
        finally {}
        paramString1 = paramString2;
      }
    }
    
    public final class a
      implements b.a
    {
      private final Map<String, Object> d = new HashMap();
      private boolean l = false;
      
      public a() {}
      
      public b.a a(String paramString)
      {
        try
        {
          this.d.put(paramString, this);
          return this;
        }
        finally {}
      }
      
      public b.a a(String paramString, float paramFloat)
      {
        try
        {
          this.d.put(paramString, Float.valueOf(paramFloat));
          return this;
        }
        finally {}
      }
      
      public b.a a(String paramString, int paramInt)
      {
        try
        {
          this.d.put(paramString, Integer.valueOf(paramInt));
          return this;
        }
        finally {}
      }
      
      public b.a a(String paramString, long paramLong)
      {
        try
        {
          this.d.put(paramString, Long.valueOf(paramLong));
          return this;
        }
        finally {}
      }
      
      public b.a a(String paramString1, String paramString2)
      {
        try
        {
          this.d.put(paramString1, paramString2);
          return this;
        }
        finally {}
      }
      
      public b.a a(String paramString, boolean paramBoolean)
      {
        try
        {
          this.d.put(paramString, Boolean.valueOf(paramBoolean));
          return this;
        }
        finally {}
      }
      
      public b.a b()
      {
        try
        {
          this.l = true;
          return this;
        }
        finally {}
      }
      
      public boolean commit()
      {
        int i = 0;
        for (;;)
        {
          Iterator localIterator;
          Object localObject6;
          Object localObject5;
          synchronized (d.a())
          {
            if (d.a.a(d.a.this).size() > 0) {
              i = 1;
            }
            if (i == 0) {
              break label338;
            }
            localArrayList = new ArrayList();
            HashSet localHashSet = new HashSet(d.a.a(d.a.this).keySet());
            try
            {
              if (this.l)
              {
                d.a.a(d.a.this).clear();
                this.l = false;
              }
              localIterator = this.d.entrySet().iterator();
              if (!localIterator.hasNext()) {
                break label209;
              }
              localObject6 = (Map.Entry)localIterator.next();
              localObject5 = (String)((Map.Entry)localObject6).getKey();
              localObject6 = ((Map.Entry)localObject6).getValue();
              if (localObject6 == this)
              {
                d.a.a(d.a.this).remove(localObject5);
                if (i == 0) {
                  continue;
                }
                localArrayList.add(localObject5);
                continue;
                localObject2 = finally;
              }
            }
            finally {}
          }
          d.a.a(d.a.this).put(localObject5, localObject6);
          continue;
          label209:
          this.d.clear();
          boolean bool = d.a.a(d.a.this);
          if (bool) {
            d.a.this.a(true);
          }
          if (i != 0)
          {
            i = localArrayList.size() - 1;
            while (i >= 0)
            {
              ??? = (String)localArrayList.get(i);
              localIterator = ((Set)localObject2).iterator();
              while (localIterator.hasNext())
              {
                localObject5 = (b.b)localIterator.next();
                if (localObject5 != null) {
                  ((b.b)localObject5).a(d.a.this, (String)???);
                }
              }
              i -= 1;
            }
          }
          return bool;
          label338:
          Object localObject3 = null;
          ArrayList localArrayList = null;
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\ta\utdid2\c\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */