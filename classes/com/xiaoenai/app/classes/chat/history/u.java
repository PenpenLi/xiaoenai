package com.xiaoenai.app.classes.chat.history;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.xiaoenai.app.classes.chat.av.a;
import com.xiaoenai.app.classes.chat.messagelist.message.b.l;
import com.xiaoenai.app.classes.chat.messagelist.view.BaseItemView;
import com.xiaoenai.app.classes.chat.messagelist.view.d;
import com.xiaoenai.app.classes.chat.messagelist.view.o;
import com.xiaoenai.app.ui.component.view.AvatarView;
import com.xiaoenai.app.utils.ak;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

public class u
  extends BaseAdapter
  implements View.OnClickListener, AbsListView.OnScrollListener
{
  private static final Set<Integer> e = new HashSet();
  private Object[] a;
  private Context b;
  private boolean c = false;
  private Vector<Boolean> d;
  private q f;
  private final Vector<d> g = new Vector();
  private av.a h = null;
  
  public u(Context paramContext, Object[] paramArrayOfObject, q paramq)
  {
    this.a = paramArrayOfObject;
    this.b = paramContext;
    this.f = paramq;
    this.d = new Vector(this.a.length);
    g();
  }
  
  public void a()
  {
    notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    this.d.removeElementAt(paramInt);
  }
  
  public void a(av.a parama)
  {
    this.h = parama;
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    this.a = paramArrayOfObject;
    g();
    notifyDataSetChanged();
  }
  
  public void a(Object[] paramArrayOfObject, boolean paramBoolean)
  {
    this.c = paramBoolean;
    a(paramArrayOfObject);
  }
  
  public Object[] b()
  {
    return this.a;
  }
  
  public void c()
  {
    this.b = null;
  }
  
  public int[] d()
  {
    return new int[] { 1, 0, 6, 2, 8, 10, 4, 3, 7, 5, 9, 11 };
  }
  
  public Set<Integer> e()
  {
    return e;
  }
  
  public void f()
  {
    e.clear();
  }
  
  public void g()
  {
    this.d.clear();
    int j = 0;
    int i = 0;
    com.xiaoenai.app.classes.chat.messagelist.message.a.a locala;
    if (j < b().length)
    {
      this.d.add(Boolean.valueOf(false));
      locala = (com.xiaoenai.app.classes.chat.messagelist.message.a.a)this.a[j];
      if (j == 0) {
        locala.a = true;
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if (locala.d() > ((com.xiaoenai.app.classes.chat.messagelist.message.a.a)this.a[i]).d() + 300)
      {
        locala.a = true;
        i = j;
        continue;
        return;
      }
    }
  }
  
  public int getCount()
  {
    return b().length;
  }
  
  public Object getItem(int paramInt)
  {
    return b()[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    com.xiaoenai.app.classes.chat.messagelist.message.a.a locala = (com.xiaoenai.app.classes.chat.messagelist.message.a.a)getItem(paramInt);
    int[] arrayOfInt = d();
    if (locala.b().equals("image"))
    {
      if (locala.g() == 1) {
        return arrayOfInt[0];
      }
      return arrayOfInt[6];
    }
    if (locala.b().equals("text"))
    {
      if (locala.g() == 1) {
        return arrayOfInt[1];
      }
      return arrayOfInt[7];
    }
    if (locala.b().equals("voice"))
    {
      if (locala.g() == 1) {
        return arrayOfInt[2];
      }
      return arrayOfInt[8];
    }
    if (locala.b().equals("status"))
    {
      if (locala.g() == 1) {
        return arrayOfInt[3];
      }
      return arrayOfInt[9];
    }
    if (locala.b().equals("emotion"))
    {
      if (((com.xiaoenai.app.classes.chat.messagelist.message.model.a)locala).r().equalsIgnoreCase("gif"))
      {
        if (locala.g() == 1) {
          return arrayOfInt[5];
        }
        return arrayOfInt[11];
      }
      if (locala.g() == 1) {
        return arrayOfInt[4];
      }
      return arrayOfInt[10];
    }
    return arrayOfInt[1];
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    com.xiaoenai.app.classes.chat.messagelist.message.a.a locala = (com.xiaoenai.app.classes.chat.messagelist.message.a.a)getItem(paramInt);
    BaseItemView localBaseItemView;
    if (paramView == null)
    {
      paramViewGroup = l.a(this.b, i);
      paramView = paramViewGroup;
      if (paramViewGroup == null)
      {
        paramView = new o(this.b);
        ((o)paramView).setUserType(locala.g());
      }
      paramView.setTag(paramView);
      switch (i)
      {
      default: 
        paramViewGroup = ((BaseItemView)paramView).getPickerAvatar();
        LinearLayout localLinearLayout = ((BaseItemView)paramView).getPickerAvatarBg();
        localBaseItemView = (BaseItemView)paramView;
        if (locala.a)
        {
          localBaseItemView.setCreatedAt(ak.c(locala.d()));
          label137:
          if (!this.c) {
            break label316;
          }
          ((BaseItemView)paramView).getAvatar().setVisibility(4);
          ((BaseItemView)paramView).getAvatarBg().setVisibility(4);
          paramViewGroup.setVisibility(0);
          if (((Boolean)this.d.get(paramInt)).booleanValue()) {
            break label307;
          }
          paramViewGroup.setImageResource(2130837597);
          label194:
          localLinearLayout.setOnClickListener(new v(this, paramInt, paramViewGroup));
        }
        break;
      }
    }
    for (;;)
    {
      l.a(i, locala, (BaseItemView)paramView, -1, 2, null);
      ((BaseItemView)paramView).setStatus(-3);
      if ("voice".equals(locala.b()))
      {
        ((BaseItemView)paramView).getMessageBody().setOnClickListener(this);
        ((BaseItemView)paramView).getMessageBody().setTag(2131558412, locala);
      }
      return paramView;
      this.g.add((d)paramView);
      break;
      paramView = (View)paramView.getTag();
      break;
      localBaseItemView.setCreatedAt(null);
      break label137;
      label307:
      paramViewGroup.setImageResource(2130837596);
      break label194;
      label316:
      ((BaseItemView)paramView).getAvatar().setVisibility(0);
      ((BaseItemView)paramView).getAvatarBg().setVisibility(0);
      paramViewGroup.setVisibility(8);
    }
  }
  
  public int getViewTypeCount()
  {
    return 24;
  }
  
  public void h()
  {
    if (this.d != null)
    {
      int i = 0;
      while (i < this.d.size())
      {
        this.d.set(i, Boolean.valueOf(false));
        i += 1;
      }
    }
  }
  
  public void i()
  {
    if ((this.g != null) && (!this.g.isEmpty()))
    {
      Iterator localIterator = this.g.iterator();
      while (localIterator.hasNext())
      {
        ((d)localIterator.next()).b();
        this.g.remove(null);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    com.xiaoenai.app.classes.chat.messagelist.message.a.a locala = (com.xiaoenai.app.classes.chat.messagelist.message.a.a)paramView.getTag(2131558412);
    if ((this.h != null) && (locala != null)) {
      this.h.a(paramView, locala);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\history\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */