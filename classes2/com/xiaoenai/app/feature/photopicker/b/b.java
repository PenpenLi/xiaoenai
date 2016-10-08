package com.xiaoenai.app.feature.photopicker.b;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import com.xiaoenai.app.feature.photopicker.a.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

class b
  implements Runnable
{
  b(a parama, a.a parama1, Activity paramActivity) {}
  
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
          if ((localObject4 == null) || (a.a(this.c, new File((String)localObject4)))) {
            break label392;
          }
          a.a(this.c).add(new c(i, (String)localObject4, (String)localObject4));
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
        this.a.a(localArrayList, a.a(this.c));
        return;
      }
      try
      {
        ((SortedSet)localObject3).add(str);
        if (localHashMap.containsKey(str))
        {
          localObject4 = (com.xiaoenai.app.feature.photopicker.a.b)localHashMap.get(str);
          ((com.xiaoenai.app.feature.photopicker.a.b)localObject4).a(((com.xiaoenai.app.feature.photopicker.a.b)localObject4).c() + 1);
          i += 1;
          boolean bool = ((Cursor)localObject1).moveToNext();
          if (bool) {
            break label389;
          }
          a.b(this.c).clear();
          localArrayList.addAll((Collection)localObject3);
          localObject1 = localHashMap.keySet().iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject3 = (String)((Iterator)localObject1).next();
            a.b(this.c).add(localHashMap.get(localObject3));
            continue;
          }
        }
        else
        {
          com.xiaoenai.app.feature.photopicker.a.a locala = new com.xiaoenai.app.feature.photopicker.a.a();
          locala.a(1);
          locala.b((String)localObject4);
          locala.a(str);
          localHashMap.put(str, locala);
          continue;
        }
      }
      catch (Exception localException2)
      {
        this.a.b();
        continue;
      }
      label389:
      continue;
      label392:
      continue;
      Object localObject2 = null;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\photopicker\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */