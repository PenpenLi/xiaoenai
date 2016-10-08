package com.adhoc;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
public class k
{
  private static k a = new k();
  
  public static k a()
  {
    return a;
  }
  
  private String a(List<View> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      View localView = (View)paramList.get(i);
      localStringBuilder.append(localView.getClass().getCanonicalName() + " @id :" + localView.getId() + "\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private List<View> a(Activity paramActivity, float paramFloat1, float paramFloat2)
  {
    ArrayList localArrayList = new ArrayList();
    int i = (int)paramFloat1;
    int j = (int)paramFloat2;
    paramActivity = a(paramActivity.getWindow().getDecorView()).iterator();
    while (paramActivity.hasNext())
    {
      View localView = (View)paramActivity.next();
      Object localObject = localView.getClass().getCanonicalName();
      if ((((String)localObject).indexOf("internal.widget") == -1) && (((String)localObject).indexOf("android.support.") == -1))
      {
        boolean bool = localView instanceof TextView;
        if ((localView.getId() != -1) || (bool))
        {
          localObject = new int[2];
          localView.getLocationOnScreen((int[])localObject);
          if ((i >= localObject[0]) && (i <= localObject[0] + localView.getWidth()) && (j <= localObject[1] + localView.getHeight()) && (j >= localObject[1])) {
            localArrayList.add(localView);
          }
        }
      }
    }
    return localArrayList;
  }
  
  private List<View> a(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        View localView = paramView.getChildAt(i);
        localArrayList.add(localView);
        localArrayList.addAll(a(localView));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public void a(Context paramContext, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      new Thread(new l(this, paramContext, paramMotionEvent)).start();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */