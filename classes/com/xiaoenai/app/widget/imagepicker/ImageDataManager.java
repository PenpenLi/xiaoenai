package com.xiaoenai.app.widget.imagepicker;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class ImageDataManager
  implements Parcelable
{
  public static final Parcelable.Creator<ImageDataManager> CREATOR = new n();
  private static final Executor a = new ScheduledThreadPoolExecutor(2);
  private ArrayList<ImageEntry> b = new ArrayList();
  private ArrayList<ImageEntry> c = new ArrayList(s.a());
  private ArrayList<ImageDirEntry> d = new ArrayList();
  private boolean e = false;
  
  public ImageDataManager() {}
  
  public ImageDataManager(Parcel paramParcel)
  {
    paramParcel.readTypedList(this.b, ImageEntry.CREATOR);
    paramParcel.readTypedList(this.c, ImageEntry.CREATOR);
  }
  
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
  
  public ArrayList<ImageEntry> a()
  {
    return this.b;
  }
  
  public ArrayList<ImageEntry> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      ImageEntry localImageEntry = (ImageEntry)localIterator.next();
      if (localImageEntry.a().substring(7).startsWith(paramString)) {
        localArrayList.add(localImageEntry);
      }
    }
    return localArrayList;
  }
  
  public void a(a parama, Activity paramActivity)
  {
    this.d.clear();
    this.b.clear();
    a.execute(new m(this, parama, paramActivity));
  }
  
  public void a(ImageEntry paramImageEntry)
  {
    Iterator localIterator = this.c.iterator();
    ImageEntry localImageEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localImageEntry = (ImageEntry)localIterator.next();
    } while (localImageEntry.c() != paramImageEntry.c());
    for (;;)
    {
      if (localImageEntry == null) {
        this.c.add(paramImageEntry);
      }
      return;
      localImageEntry = null;
    }
  }
  
  public void a(ArrayList<ImageEntry> paramArrayList)
  {
    this.b = paramArrayList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void b(ImageEntry paramImageEntry)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      ImageEntry localImageEntry = (ImageEntry)localIterator.next();
      if (paramImageEntry.c() == localImageEntry.c()) {
        this.c.remove(localImageEntry);
      }
    }
  }
  
  public String[] b()
  {
    int m = 0;
    int i = 0;
    int k;
    for (int j = 0; i < this.c.size(); j = k)
    {
      k = j;
      if (this.c.get(i) != null) {
        k = j + 1;
      }
      i += 1;
    }
    String[] arrayOfString = new String[j];
    i = 0;
    j = m;
    if (j < this.c.size())
    {
      if (this.c.get(j) == null) {
        break label109;
      }
      arrayOfString[i] = ((ImageEntry)this.c.get(j)).a();
      i += 1;
    }
    label109:
    for (;;)
    {
      j += 1;
      break;
      return arrayOfString;
    }
  }
  
  public int c()
  {
    return this.c.size();
  }
  
  public ArrayList<ImageEntry> d()
  {
    return this.c;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<ImageDirEntry> e()
  {
    return this.d;
  }
  
  public boolean f()
  {
    return this.e;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedList(this.b);
    paramParcel.writeTypedList(this.c);
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(List<String> paramList, List<ImageEntry> paramList1);
    
    public abstract void b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\widget\imagepicker\ImageDataManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */