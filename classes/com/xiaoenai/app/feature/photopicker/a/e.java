package com.xiaoenai.app.feature.photopicker.a;

import java.util.ArrayList;
import java.util.List;

public class e
{
  public static List<f> a(String[] paramArrayOfString, ArrayList<String> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      f localf = new f();
      localf.b(paramArrayList.contains(paramArrayOfString[i]));
      localf.a(paramArrayOfString[i]);
      localf.a(false);
      localArrayList.add(localf);
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photopicker\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */