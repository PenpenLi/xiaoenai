package com.xiaoenai.app.classes.chat;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.chat.messagelist.message.b.l;
import com.xiaoenai.app.classes.chat.messagelist.view.BaseItemView;
import com.xiaoenai.app.classes.common.dialog.e;
import com.xiaoenai.app.net.socket.SocketManager;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.utils.h.g;
import java.util.Iterator;
import java.util.Vector;

public class av
  extends BaseAdapter
  implements View.OnClickListener, View.OnLongClickListener, AbsListView.OnScrollListener
{
  private int a;
  private View b;
  private View c = null;
  private Object[] d = null;
  private Context e;
  private a f;
  private final Vector<com.xiaoenai.app.classes.chat.messagelist.view.d> g = new Vector();
  private int h = -1;
  
  public av(Context paramContext)
  {
    this.e = paramContext;
    if (this.d.length > 0) {
      this.a = ((com.xiaoenai.app.classes.chat.messagelist.message.a.a)this.d[(this.d.length - 1)]).d();
    }
  }
  
  private void a(com.xiaoenai.app.classes.chat.messagelist.message.a.a parama)
  {
    if ((!as.d()) && (as.g()) && ((!as.e()) || ((as.e()) && (!Xiaoenai.j().q())))) {
      parama.l();
    }
  }
  
  private void b(com.xiaoenai.app.classes.chat.messagelist.message.a.a parama)
  {
    if ((!as.d()) && (as.g()) && ((!as.e()) || ((as.e()) && (!Xiaoenai.j().q())))) {
      g.a().a((com.xiaoenai.app.classes.chat.messagelist.message.model.o)parama);
    }
  }
  
  private void c(com.xiaoenai.app.classes.chat.messagelist.message.a.a parama)
  {
    e locale = new e(this.e);
    if (parama.b().equals("text")) {
      locale.a(2131100099, 1, new ax(this, parama, locale));
    }
    for (;;)
    {
      locale.a(2131100104, 2, new az(this, parama, locale));
      locale.show();
      return;
      if (parama.b().equals("image")) {
        locale.a(2131099989, 1, new ay(this, locale, parama));
      }
    }
  }
  
  private void g()
  {
    if (this.h != 0)
    {
      c();
      if (!com.xiaoenai.app.classes.chat.messagelist.a.a().d()) {
        break label25;
      }
      h();
    }
    label25:
    while (!com.xiaoenai.app.classes.chat.messagelist.a.a().e()) {
      return;
    }
    com.xiaoenai.app.classes.chat.messagelist.a.a().a(this);
  }
  
  private void h()
  {
    new bc(this).execute(new Integer[] { Integer.valueOf(0) });
  }
  
  public void a()
  {
    this.d = com.xiaoenai.app.classes.chat.messagelist.a.a().g();
    if (this.d.length > 0) {
      this.a = ((com.xiaoenai.app.classes.chat.messagelist.message.a.a)this.d[(this.d.length - 1)]).d();
    }
    notifyDataSetChanged();
    com.xiaoenai.app.utils.f.a.c("MessageListAdapter refresh, data size: {}", new Object[] { Integer.valueOf(this.d.length) });
  }
  
  public void a(a parama)
  {
    this.f = parama;
  }
  
  public void b()
  {
    this.h = -1;
  }
  
  public void c()
  {
    this.h = 0;
  }
  
  public void d()
  {
    if ((this.g != null) && (!this.g.isEmpty()))
    {
      Iterator localIterator = this.g.iterator();
      while (localIterator.hasNext())
      {
        ((com.xiaoenai.app.classes.chat.messagelist.view.d)localIterator.next()).b();
        this.g.remove(null);
      }
    }
  }
  
  public void e()
  {
    notifyDataSetChanged();
    if (this.g != null)
    {
      Iterator localIterator = this.g.iterator();
      while (localIterator.hasNext()) {
        ((com.xiaoenai.app.classes.chat.messagelist.view.d)localIterator.next()).c();
      }
    }
  }
  
  public int f()
  {
    return this.a;
  }
  
  public int getCount()
  {
    return this.d.length + 1;
  }
  
  public Object getItem(int paramInt)
  {
    return this.d[(paramInt - 1)];
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    com.xiaoenai.app.classes.chat.messagelist.message.a.a locala = (com.xiaoenai.app.classes.chat.messagelist.message.a.a)getItem(paramInt);
    if (locala.b().equals("image"))
    {
      if (locala.g() == 1) {
        return 1;
      }
      return 4;
    }
    if (locala.b().equals("status"))
    {
      if (locala.g() == 1) {
        return 2;
      }
      return 5;
    }
    if (locala.b().equals("text"))
    {
      if (locala.g() == 1) {
        return 0;
      }
      return 3;
    }
    if (locala.b().equals("voice"))
    {
      if (locala.g() == 1) {
        return 6;
      }
      return 7;
    }
    if (locala.b().equals("emotion"))
    {
      if (((com.xiaoenai.app.classes.chat.messagelist.message.model.a)locala).r().equalsIgnoreCase("gif"))
      {
        if (locala.g() == 1) {
          return 10;
        }
        return 11;
      }
      if (locala.g() == 1) {
        return 8;
      }
      return 9;
    }
    if (locala.g() == 1) {
      return 0;
    }
    return 3;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramInt == 0)
    {
      if ((com.xiaoenai.app.classes.chat.messagelist.a.a().f()) && (!com.xiaoenai.app.classes.chat.messagelist.a.a().c()))
      {
        if (this.c == null)
        {
          this.c = LayoutInflater.from(this.e).inflate(2130903113, null);
          paramView = this.c.findViewById(2131558849);
          paramViewGroup = (LinearLayout.LayoutParams)paramView.getLayoutParams();
          paramViewGroup.topMargin = ab.a(66.0F);
          paramView.setLayoutParams(paramViewGroup);
        }
        g();
        return this.c;
      }
      if (this.b == null)
      {
        this.b = LayoutInflater.from(this.e).inflate(2130903117, null);
        paramView = (TextView)this.b.findViewById(2131558857);
        paramView.setText(Html.fromHtml("<b>" + this.e.getString(2131100005) + "<br />" + String.format(this.e.getString(2131100006), new Object[] { "<font color=\"#0000ff\">" + this.e.getString(2131100021) + "</font>" }) + "</b>"));
        paramView.setOnClickListener(new aw(this));
        paramView = this.b.findViewById(2131558736);
        paramViewGroup = (LinearLayout.LayoutParams)paramView.getLayoutParams();
        paramViewGroup.topMargin = ab.a(66.0F);
        paramView.setLayoutParams(paramViewGroup);
      }
      return this.b;
    }
    com.xiaoenai.app.classes.chat.messagelist.a.a().a(false);
    int i = getItemViewType(paramInt);
    com.xiaoenai.app.classes.chat.messagelist.message.a.a locala = (com.xiaoenai.app.classes.chat.messagelist.message.a.a)getItem(paramInt);
    if ((paramView == null) || (!(paramView instanceof BaseItemView)))
    {
      paramViewGroup = l.a(this.e, i);
      paramView = paramViewGroup;
      if (paramViewGroup == null)
      {
        paramView = new com.xiaoenai.app.classes.chat.messagelist.view.o(this.e);
        ((com.xiaoenai.app.classes.chat.messagelist.view.o)paramView).setUserType(locala.g());
      }
      switch (i)
      {
      default: 
        paramView.setTag(paramView);
        label385:
        paramViewGroup = (BaseItemView)paramView;
        paramViewGroup.setOnClickListener(this);
        paramViewGroup.setTag(2131558412, locala);
        paramViewGroup.getMessageBody().setTag(2131558412, locala);
        paramViewGroup.getMessageBody().setTag(2131558412, locala);
        paramViewGroup.getMessageBody().setOnClickListener(this);
        l.a(i, locala, (BaseItemView)paramView, locala.d(), 1, this);
        if ((7 != i) && (!com.xiaoenai.app.classes.chat.messagelist.message.b.d.a(locala)))
        {
          com.xiaoenai.app.utils.f.a.c("lock = {} isChatOnForeground = {} status = {}", new Object[] { Boolean.valueOf(as.d()), Boolean.valueOf(as.g()), locala.f() });
          com.xiaoenai.app.utils.f.a.c("lockScreen = {}", new Object[] { Boolean.valueOf(Xiaoenai.j().q()) });
          a(locala);
          label533:
          if (!locala.a) {
            break label700;
          }
          paramViewGroup.setCreatedAt(ak.c(locala.d()));
        }
        break;
      }
    }
    for (;;)
    {
      if (locala.f().intValue() == -2)
      {
        paramViewGroup.getSendFailedImageView().setTag(2131558412, locala);
        paramViewGroup.setSendFailedClickListener(this);
      }
      paramViewGroup.getMessageBody().setOnLongClickListener(this);
      return paramView;
      this.g.add((com.xiaoenai.app.classes.chat.messagelist.view.d)paramView);
      break;
      paramView = (View)paramView.getTag();
      break label385;
      if ((7 != i) || (locala.f().intValue() != 0)) {
        break label533;
      }
      com.xiaoenai.app.utils.f.a.c("auto download voice {}", new Object[] { locala.c() });
      if ((!(locala instanceof com.xiaoenai.app.classes.chat.messagelist.message.model.o)) || (SocketManager.a().f() != 2)) {
        break label533;
      }
      if (!locala.p())
      {
        b(locala);
        break label533;
      }
      a(locala);
      break label533;
      label700:
      paramViewGroup.setCreatedAt(null);
    }
  }
  
  public int getViewTypeCount()
  {
    return 12;
  }
  
  public void onClick(View paramView)
  {
    ((ChatActivity)this.e).f();
    com.xiaoenai.app.classes.chat.messagelist.message.a.a locala = (com.xiaoenai.app.classes.chat.messagelist.message.a.a)paramView.getTag(2131558412);
    if (locala != null)
    {
      if (locala.f().intValue() == -2)
      {
        locala.m();
        locala.a(-1L);
        locala.j();
      }
      if (this.f != null)
      {
        if (paramView.getId() != 2131558839) {
          break label99;
        }
        if (((locala instanceof com.xiaoenai.app.classes.chat.messagelist.message.model.o)) && (((com.xiaoenai.app.classes.chat.messagelist.message.model.o)locala).r() != 3)) {
          this.f.a(paramView, locala);
        }
      }
    }
    label99:
    while ((paramView.getId() != 2131558847) && (paramView.getId() != 2131558846)) {
      return;
    }
    this.f.a(paramView, locala);
  }
  
  public boolean onLongClick(View paramView)
  {
    ((ChatActivity)this.e).f();
    com.xiaoenai.app.classes.chat.messagelist.message.a.a locala = (com.xiaoenai.app.classes.chat.messagelist.message.a.a)paramView.getTag(2131558412);
    c(locala);
    if (this.f != null) {
      this.f.b(paramView, locala);
    }
    return true;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      com.xiaoenai.app.classes.chat.messagelist.a.a = Boolean.valueOf(false);
      if (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) {
        paramAbsListView.setTranscriptMode(2);
      }
      do
      {
        return;
        paramAbsListView.setTranscriptMode(1);
      } while ((paramAbsListView.getFirstVisiblePosition() != 0) || (!com.xiaoenai.app.classes.chat.messagelist.a.a().f()));
      g();
      return;
    }
    ((ChatActivity)this.e).f();
    com.xiaoenai.app.classes.chat.messagelist.a.a = Boolean.valueOf(true);
  }
  
  public static abstract interface a
  {
    public abstract void a(View paramView, com.xiaoenai.app.classes.chat.messagelist.message.a.a parama);
    
    public abstract void b(View paramView, com.xiaoenai.app.classes.chat.messagelist.message.a.a parama);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */