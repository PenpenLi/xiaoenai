package com.xiaoenai.app.common;

import android.app.Activity;
import java.util.Iterator;
import java.util.Stack;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class a
{
  private Stack<Activity> a = new Stack();
  
  @Inject
  public a()
  {
    com.xiaoenai.app.utils.f.a.c("Inject AppManager init", new Object[0]);
  }
  
  public Activity a()
  {
    if (!this.a.empty()) {
      return (Activity)this.a.lastElement();
    }
    return null;
  }
  
  public void a(Activity paramActivity)
  {
    this.a.add(paramActivity);
  }
  
  public void a(Class<?> paramClass)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      Activity localActivity = (Activity)this.a.get(i);
      if ((localActivity != null) && (!localActivity.getClass().equals(paramClass))) {
        localActivity.finish();
      }
      i += 1;
    }
  }
  
  public Activity b(Class<?> paramClass)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Activity localActivity = (Activity)localIterator.next();
      if (localActivity.getClass().equals(paramClass)) {
        return localActivity;
      }
    }
    return null;
  }
  
  public void b()
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      if (this.a.get(i) != null)
      {
        Activity localActivity = (Activity)this.a.get(i);
        if (!localActivity.isFinishing()) {
          localActivity.finish();
        }
      }
      i += 1;
    }
    this.a.clear();
  }
  
  public void b(Activity paramActivity)
  {
    if ((paramActivity != null) && (!this.a.empty()))
    {
      this.a.remove(paramActivity);
      paramActivity.finish();
    }
  }
  
  public int c()
  {
    return this.a.size();
  }
  
  public void c(Activity paramActivity)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      Activity localActivity = (Activity)this.a.get(i);
      if ((localActivity != null) && (paramActivity != localActivity) && (!paramActivity.equals(localActivity))) {
        localActivity.finish();
      }
      i += 1;
    }
  }
  
  public boolean c(Class<?> paramClass)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (((Activity)localIterator.next()).getClass().equals(paramClass)) {
        return true;
      }
    }
    return false;
  }
  
  public void d(Activity paramActivity)
  {
    if ((paramActivity != null) && (!this.a.empty())) {
      this.a.remove(paramActivity);
    }
  }
  
  public void d(Class<?> paramClass)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Activity localActivity = (Activity)localIterator.next();
      if (localActivity.getClass().equals(paramClass)) {
        b(localActivity);
      }
    }
  }
  
  public void e(Activity paramActivity)
  {
    if (!this.a.empty())
    {
      Activity localActivity = (Activity)this.a.lastElement();
      if ((paramActivity != null) && (paramActivity != localActivity))
      {
        d(paramActivity);
        a(paramActivity);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\common\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */