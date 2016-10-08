package com.xiaoenai.app.classes.settings.feedback;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import com.xiaoenai.app.classes.chat.messagelist.view.BaseItemView;
import com.xiaoenai.app.classes.common.dialog.e;
import com.xiaoenai.app.utils.ak;

public class a
  extends BaseAdapter
{
  private Context a;
  private Object[] b;
  private com.xiaoenai.app.d.f c;
  private p d;
  private int e = 0;
  private long f;
  
  public a(Object[] paramArrayOfObject, Context paramContext, com.xiaoenai.app.d.f paramf, p paramp)
  {
    this.b = paramArrayOfObject;
    this.a = paramContext;
    this.c = paramf;
    this.d = paramp;
  }
  
  public a(Object[] paramArrayOfObject, Context paramContext, com.xiaoenai.app.d.f paramf, p paramp, int paramInt, long paramLong)
  {
    this.b = paramArrayOfObject;
    this.a = paramContext;
    this.c = paramf;
    this.d = paramp;
    this.e = paramInt;
    this.f = paramLong;
  }
  
  private void a(com.xiaoenai.app.classes.chat.messagelist.message.a.a parama)
  {
    e locale = new e(this.a);
    locale.a(2131100104, 2, new c(this, parama, locale));
    locale.show();
  }
  
  public void a()
  {
    notifyDataSetChanged();
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    this.b = paramArrayOfObject;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.b.length;
  }
  
  public Object getItem(int paramInt)
  {
    return this.b[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    com.xiaoenai.app.classes.chat.messagelist.message.a.a locala = (com.xiaoenai.app.classes.chat.messagelist.message.a.a)this.b[paramInt];
    if ((locala instanceof FeedbackPhoto)) {
      return 2;
    }
    if (locala.g() == 1) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (com.xiaoenai.app.classes.chat.messagelist.message.a.a)this.b[paramInt];
    paramInt = getItemViewType(paramInt);
    label49:
    BaseItemView localBaseItemView;
    if (paramView == null) {
      if (paramInt == 0)
      {
        paramView = new i(this.a);
        ((i)paramView).setUserType(1);
        paramView.setTag(paramView);
        localBaseItemView = (BaseItemView)paramView;
        if (this.e != 1) {
          break label204;
        }
        f.a(paramInt, paramViewGroup, localBaseItemView, this.f);
        label74:
        if (paramViewGroup.g() != 2) {
          break label214;
        }
        localBaseItemView.setCreatedAt(ak.c(paramViewGroup.d()));
      }
    }
    for (;;)
    {
      localBaseItemView.getMessageBody().setOnLongClickListener(new b(this, paramViewGroup));
      return paramView;
      if (paramInt == 1)
      {
        paramView = new i(this.a);
        ((i)paramView).setUserType(2);
        break;
      }
      if (paramInt == 2)
      {
        paramView = new m(this.a);
        ((m)paramView).setUserType(1);
        break;
      }
      paramView = new i(this.a);
      ((i)paramView).setUserType(1);
      break;
      paramView = (View)paramView.getTag();
      break label49;
      label204:
      f.a(paramInt, paramViewGroup, localBaseItemView);
      break label74;
      label214:
      localBaseItemView.setCreatedAt(null);
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\feedback\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */