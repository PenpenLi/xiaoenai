package com.xiaoenai.app.classes.gameCenter.a;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.xiaoenai.app.classes.gameCenter.model.GameEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class f
  extends BaseAdapter
{
  public Activity a;
  private final Map<Integer, a> b = new LinkedHashMap();
  private final g c;
  private List<ApplicationInfo> d;
  private Map<String, ApplicationInfo> e;
  private List<a> f = new ArrayList();
  private List<GameEntry> g = null;
  
  public f(Activity paramActivity)
  {
    this.a = paramActivity;
    this.c = new g(paramActivity);
    b();
  }
  
  private void b()
  {
    this.d = this.a.getPackageManager().getInstalledApplications(128);
    this.e = new HashMap();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      ApplicationInfo localApplicationInfo = (ApplicationInfo)localIterator.next();
      this.e.put(localApplicationInfo.packageName, localApplicationInfo);
    }
  }
  
  public void a()
  {
    b();
    if (this.g != null)
    {
      Iterator localIterator = this.g.iterator();
      while (localIterator.hasNext())
      {
        GameEntry localGameEntry = (GameEntry)localIterator.next();
        if ((localGameEntry.getMpackage() != null) && (localGameEntry.getMpackage().length() > 0))
        {
          if (this.e.containsKey(localGameEntry.getMpackage())) {}
          for (int i = 1;; i = -1)
          {
            localGameEntry.setDownload_state(i);
            break;
          }
        }
      }
      localIterator = this.f.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).notifyDataSetChanged();
      }
      notifyDataSetChanged();
    }
  }
  
  public void a(List<GameEntry> paramList)
  {
    this.g = paramList;
    this.f.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      GameEntry localGameEntry = (GameEntry)paramList.next();
      label89:
      a locala;
      if (localGameEntry.getStartType() == 0)
      {
        if (this.b.containsKey(Integer.valueOf(localGameEntry.getStartType())))
        {
          ((a)this.b.get(Integer.valueOf(localGameEntry.getStartType()))).a(localGameEntry);
          if (!this.e.containsKey(localGameEntry.getMpackage())) {
            break label186;
          }
        }
        label186:
        for (int i = 1;; i = -1)
        {
          localGameEntry.setDownload_state(i);
          break;
          this.c.a(this.a.getString(2131100527));
          locala = new a(this.a);
          this.b.put(Integer.valueOf(localGameEntry.getStartType()), locala);
          locala.a(localGameEntry);
          this.f.add(locala);
          notifyDataSetChanged();
          break label89;
        }
      }
      if (this.b.containsKey(Integer.valueOf(localGameEntry.getStartType())))
      {
        ((a)this.b.get(Integer.valueOf(localGameEntry.getStartType()))).a(localGameEntry);
      }
      else
      {
        this.c.a(this.a.getString(2131100526));
        locala = new a(this.a);
        this.b.put(Integer.valueOf(localGameEntry.getStartType()), locala);
        locala.a(localGameEntry);
        this.f.add(locala);
        notifyDataSetChanged();
      }
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    Iterator localIterator = this.b.values().iterator();
    for (int i = 0; localIterator.hasNext(); i = ((a)localIterator.next()).getCount() + 1 + i) {}
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      a locala = (a)this.b.get(localObject);
      int i = locala.getCount() + 1;
      if (paramInt == 0) {
        return localObject;
      }
      if (paramInt < i) {
        return locala.getItem(paramInt - 1);
      }
      paramInt -= i;
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    Iterator localIterator = this.b.keySet().iterator();
    int j = 1;
    int i = paramInt;
    Object localObject;
    for (paramInt = j; localIterator.hasNext(); paramInt = ((a)localObject).getViewTypeCount() + paramInt)
    {
      localObject = localIterator.next();
      localObject = (a)this.b.get(localObject);
      j = ((a)localObject).getCount() + 1;
      if (i == 0) {
        return 0;
      }
      if (i < j) {
        return ((a)localObject).getItemViewType(i - 1) + paramInt;
      }
      i -= j;
    }
    return -1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Iterator localIterator = this.b.keySet().iterator();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      localObject = (a)this.b.get(localObject);
      j = ((a)localObject).getCount() + 1;
      if (i == 0) {
        return this.c.getView(paramInt, paramView, paramViewGroup);
      }
      if (i < j) {
        return ((a)localObject).getView(i - 1, paramView, paramViewGroup);
      }
      i -= j;
      paramInt += 1;
    }
    return null;
  }
  
  public int getViewTypeCount()
  {
    Iterator localIterator = this.b.values().iterator();
    for (int i = 1; localIterator.hasNext(); i = ((a)localIterator.next()).getViewTypeCount() + i) {}
    return i;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\gameCenter\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */