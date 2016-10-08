package com.xiaoenai.app.widget.imagepicker;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

class m
  implements Runnable
{
  m(ImageDataManager paramImageDataManager, ImageDataManager.a parama, Activity paramActivity) {}
  
  public void run()
  {
    int i = 0;
    this.a.a();
    Object localObject1 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    Object localObject3 = new TreeSet();
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    if (localObject1 != null) {}
    for (;;)
    {
      try
      {
        localObject1 = MediaStore.Images.Media.query(this.b.getContentResolver(), (Uri)localObject1, new String[] { "_data", "date_modified" }, null, "date_modified desc");
        if ((localObject1 != null) && (((Cursor)localObject1).moveToFirst()))
        {
          localObject4 = ((Cursor)localObject1).getString(0);
          if ((localObject4 == null) || (ImageDataManager.a(this.c, new File((String)localObject4)))) {
            break label382;
          }
          ImageDataManager.a(this.c).add(new ImageEntry(i, (String)localObject4, (String)localObject4));
          str = ((String)localObject4).substring(0, ((String)localObject4).lastIndexOf("/"));
        }
      }
      catch (Exception localException1)
      {
        Object localObject4;
        String str;
        localException1.printStackTrace();
        this.a.b();
        continue;
        this.a.a(localArrayList, ImageDataManager.a(this.c));
        return;
      }
      try
      {
        ((SortedSet)localObject3).add(str);
        if (localHashMap.containsKey(str))
        {
          localObject4 = (ImageDirEntry)localHashMap.get(str);
          ((ImageDirEntry)localObject4).a(((ImageDirEntry)localObject4).c() + 1);
          i += 1;
          boolean bool = ((Cursor)localObject1).moveToNext();
          if (bool) {
            break label379;
          }
          ImageDataManager.b(this.c).clear();
          localArrayList.addAll((Collection)localObject3);
          localObject1 = localHashMap.keySet().iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject3 = (String)((Iterator)localObject1).next();
            ImageDataManager.b(this.c).add(localHashMap.get(localObject3));
            continue;
          }
        }
        else
        {
          ImageDirEntry localImageDirEntry = new ImageDirEntry();
          localImageDirEntry.a(1);
          localImageDirEntry.b((String)localObject4);
          localImageDirEntry.a(str);
          localHashMap.put(str, localImageDirEntry);
          continue;
        }
      }
      catch (Exception localException2)
      {
        this.a.b();
        continue;
      }
      label379:
      continue;
      label382:
      continue;
      Object localObject2 = null;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\imagepicker\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */