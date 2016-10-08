package com.xiaoenai.app.feature.photopicker.b;

import android.app.Activity;
import com.xiaoenai.app.feature.photopicker.a.d;
import com.xiaoenai.app.feature.photopicker.view.m;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class a
  implements c
{
  private static final Executor a = new ScheduledThreadPoolExecutor(2);
  private ArrayList<d> b = new ArrayList();
  private ArrayList<d> c = new ArrayList(m.a());
  private ArrayList<com.xiaoenai.app.feature.photopicker.a.b> d = new ArrayList();
  
  private boolean a(File paramFile)
  {
    String str = paramFile.getAbsolutePath();
    File localFile = paramFile;
    if (paramFile.isHidden()) {
      return true;
    }
    do
    {
      localFile = localFile.getParentFile();
      str = localFile.getAbsolutePath();
      if (str.equals("/")) {
        break;
      }
    } while (!localFile.getParentFile().isHidden());
    return true;
    return false;
  }
  
  public ArrayList<d> a()
  {
    return this.b;
  }
  
  public ArrayList<d> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (locald.a().substring(7).startsWith(paramString)) {
        localArrayList.add(locald);
      }
    }
    return localArrayList;
  }
  
  public void a(d paramd)
  {
    Iterator localIterator = this.c.iterator();
    d locald;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      locald = (d)localIterator.next();
    } while (locald.c() != paramd.c());
    for (;;)
    {
      if (locald == null) {
        this.c.add(paramd);
      }
      return;
      locald = null;
    }
  }
  
  public void a(a parama, Activity paramActivity)
  {
    this.d.clear();
    this.b.clear();
    a.execute(new b(this, parama, paramActivity));
  }
  
  public void a(ArrayList<d> paramArrayList)
  {
    this.b = paramArrayList;
  }
  
  public ArrayList<String> b()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.c.size())
    {
      if (this.c.get(i) != null) {
        localArrayList.add(((d)this.c.get(i)).a());
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void b(d paramd)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (paramd.c() == locald.c()) {
        this.c.remove(locald);
      }
    }
  }
  
  public void b(ArrayList<String> paramArrayList)
  {
    this.c.clear();
    int i = 0;
    if (i < this.b.size())
    {
      if (this.b.get(i) != null)
      {
        if ((paramArrayList == null) || (!paramArrayList.contains(((d)this.b.get(i)).a()))) {
          break label116;
        }
        ((d)this.b.get(i)).a(true);
        if (!this.c.contains(this.b.get(i))) {
          this.c.add(this.b.get(i));
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label116:
        ((d)this.b.get(i)).a(false);
      }
    }
  }
  
  public int c()
  {
    return this.c.size();
  }
  
  public ArrayList<d> d()
  {
    return this.c;
  }
  
  public ArrayList<com.xiaoenai.app.feature.photopicker.a.b> e()
  {
    return this.d;
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(List<String> paramList, List<d> paramList1);
    
    public abstract void b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photopicker\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */