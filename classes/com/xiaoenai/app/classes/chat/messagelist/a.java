package com.xiaoenai.app.classes.chat.messagelist;

import android.content.Intent;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.chat.av;
import com.xiaoenai.app.classes.chat.messagelist.message.b.k;
import com.xiaoenai.app.classes.chat.messagelist.message.model.PhotoMessage;
import com.xiaoenai.app.classes.chat.messagelist.message.model.o;
import com.xiaoenai.app.d.q;
import com.xiaoenai.app.model.UserConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public class a
{
  public static Boolean a = Boolean.valueOf(false);
  private static boolean i = false;
  Comparator<com.xiaoenai.app.classes.chat.messagelist.message.a.a> b = new h(this);
  private i<com.xiaoenai.app.classes.chat.messagelist.message.a.a> c;
  private q d;
  private boolean e = true;
  private boolean f = true;
  private int g = 0;
  private boolean h = false;
  
  private a()
  {
    o();
  }
  
  public static a a()
  {
    if (Xiaoenai.j().E == null) {}
    try
    {
      if (Xiaoenai.j().E == null) {
        Xiaoenai.j().E = new a();
      }
      return Xiaoenai.j().E;
    }
    finally {}
  }
  
  private void a(JSONObject paramJSONObject)
  {
    long l1 = paramJSONObject.optLong("max_read_id");
    long l2 = paramJSONObject.optLong("lover_max_read_id");
    Object localObject = paramJSONObject.optJSONArray("timeline");
    if (((JSONArray)localObject).length() < 40) {
      this.f = false;
    }
    if (((JSONArray)localObject).length() == 0) {
      b(0);
    }
    paramJSONObject = new ArrayList();
    int j = 0;
    if (j < ((JSONArray)localObject).length())
    {
      localJSONObject = ((JSONArray)localObject).optJSONObject(j);
      str1 = localJSONObject.optString("types");
      str2 = localJSONObject.optString("content");
      locala = k.a(str1, k.a(str1, str2), com.xiaoenai.app.classes.chat.messagelist.message.model.c.a(str1, str2));
      if (locala != null)
      {
        l3 = localJSONObject.optLong("id");
        if (a(l3) != null) {
          break label298;
        }
        locala.b(l3);
        locala.a(str1);
        locala.a(Integer.valueOf(localJSONObject.optInt("sender_id")));
        locala.b(str2);
        locala.a(localJSONObject.optInt("ts"));
        if (locala.g() != 2) {
          break label268;
        }
        if ((l1 == 0L) || (locala.h() <= l1)) {
          locala.b(Integer.valueOf(1));
        }
        if ((locala.f().intValue() == 0) && ("voice".equals(locala.b()))) {
          locala.a(false);
        }
      }
      for (;;)
      {
        locala.k();
        paramJSONObject.add(locala);
        j += 1;
        break;
        label268:
        if ((l2 == 0L) || (locala.h() <= l2)) {
          locala.b(Integer.valueOf(1));
        }
      }
      label298:
      b(paramJSONObject.size());
    }
    while (paramJSONObject.size() == 0)
    {
      JSONObject localJSONObject;
      String str1;
      String str2;
      com.xiaoenai.app.classes.chat.messagelist.message.a.a locala;
      long l3;
      return;
    }
    ((com.xiaoenai.app.classes.chat.messagelist.message.a.a)paramJSONObject.get(0)).a = true;
    j = 0;
    int k = 0;
    if (j < paramJSONObject.size())
    {
      localObject = (com.xiaoenai.app.classes.chat.messagelist.message.a.a)paramJSONObject.get(j);
      if (((com.xiaoenai.app.classes.chat.messagelist.message.a.a)localObject).d() <= ((com.xiaoenai.app.classes.chat.messagelist.message.a.a)paramJSONObject.get(k)).d() + 300) {
        break label511;
      }
      ((com.xiaoenai.app.classes.chat.messagelist.message.a.a)localObject).a = true;
      k = j;
    }
    label511:
    for (;;)
    {
      j += 1;
      break;
      if ((this.c.size() > 0) && (((com.xiaoenai.app.classes.chat.messagelist.message.a.a)this.c.firstElement()).d() < ((com.xiaoenai.app.classes.chat.messagelist.message.a.a)paramJSONObject.get(k)).d() + 300)) {
        ((com.xiaoenai.app.classes.chat.messagelist.message.a.a)this.c.firstElement()).a = false;
      }
      Collections.sort(paramJSONObject, this.b);
      j = paramJSONObject.size() - 1;
      while (j >= 0)
      {
        localObject = (com.xiaoenai.app.classes.chat.messagelist.message.a.a)paramJSONObject.get(j);
        this.c.a(0, (com.xiaoenai.app.classes.chat.messagelist.message.a.a)localObject);
        j -= 1;
      }
      this.h = false;
      b(paramJSONObject.size());
      return;
    }
  }
  
  private void b(int paramInt)
  {
    Intent localIntent = new Intent("messageList_change");
    localIntent.putExtra("selection", paramInt);
    Xiaoenai.j().sendBroadcast(localIntent);
  }
  
  public static void k()
  {
    Xiaoenai.j().a(new f(), 300L);
  }
  
  public static void l()
  {
    Xiaoenai.j().a(new g());
  }
  
  public static void m()
  {
    Xiaoenai.j().E = null;
  }
  
  private void o()
  {
    this.d = new q();
    this.c = new i();
    Object localObject = this.d.a(20, 0);
    if (((Vector)localObject).size() < 20) {
      this.e = false;
    }
    if (((Vector)localObject).size() > 0) {
      ((com.xiaoenai.app.classes.chat.messagelist.message.a.a)((Vector)localObject).firstElement()).a = true;
    }
    localObject = ((Vector)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      a((com.xiaoenai.app.classes.chat.messagelist.message.a.a)((Iterator)localObject).next());
    }
    l();
  }
  
  public com.xiaoenai.app.classes.chat.messagelist.message.a.a a(long paramLong)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      com.xiaoenai.app.classes.chat.messagelist.message.a.a locala = (com.xiaoenai.app.classes.chat.messagelist.message.a.a)localIterator.next();
      if (locala.h() == paramLong) {
        return locala;
      }
    }
    return null;
  }
  
  public o a(o paramo)
  {
    if (paramo.g() == 2)
    {
      Iterator localIterator = this.c.iterator();
      int j = 0;
      while (localIterator.hasNext())
      {
        com.xiaoenai.app.classes.chat.messagelist.message.a.a locala = (com.xiaoenai.app.classes.chat.messagelist.message.a.a)localIterator.next();
        int k = j + 1;
        j = k;
        if (locala.h() > paramo.h())
        {
          j = k;
          if (locala.g() == 2)
          {
            j = k;
            if (locala.b().equals("voice"))
            {
              j = k;
              if (locala.f().intValue() == 0)
              {
                paramo = (o)locala;
                paramo.d(k);
                return paramo;
              }
            }
          }
        }
      }
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    int k = 0;
    for (;;)
    {
      try
      {
        Vector localVector = this.d.a(paramInt, this.c.a());
        if (localVector.size() < paramInt) {
          this.e = false;
        }
        paramInt = localVector.size();
        if (paramInt == 0) {
          return;
        }
        ((com.xiaoenai.app.classes.chat.messagelist.message.a.a)localVector.firstElement()).a = true;
        int j = 0;
        paramInt = k;
        com.xiaoenai.app.classes.chat.messagelist.message.a.a locala;
        if (paramInt < localVector.size())
        {
          locala = (com.xiaoenai.app.classes.chat.messagelist.message.a.a)localVector.get(paramInt);
          if (locala.d() > ((com.xiaoenai.app.classes.chat.messagelist.message.a.a)localVector.get(j)).d() + 300)
          {
            locala.a = true;
            j = paramInt;
          }
        }
        else
        {
          if ((this.c.size() > 0) && (((com.xiaoenai.app.classes.chat.messagelist.message.a.a)this.c.firstElement()).d() < ((com.xiaoenai.app.classes.chat.messagelist.message.a.a)localVector.get(j)).d() + 300)) {
            ((com.xiaoenai.app.classes.chat.messagelist.message.a.a)this.c.firstElement()).a = false;
          }
          paramInt = localVector.size() - 1;
          if (paramInt >= 0)
          {
            locala = (com.xiaoenai.app.classes.chat.messagelist.message.a.a)localVector.get(paramInt);
            this.c.a(0, locala);
            paramInt -= 1;
            continue;
          }
          Xiaoenai.j().a(new b(this, localVector), 300L);
          continue;
        }
        paramInt += 1;
      }
      finally {}
    }
  }
  
  public void a(av paramav)
  {
    if (this.h) {
      return;
    }
    paramav = new com.xiaoenai.app.net.d.a(new c(this, Xiaoenai.j(), paramav));
    int j = 0;
    if (this.c.size() > 0) {
      j = ((com.xiaoenai.app.classes.chat.messagelist.message.a.a)this.c.firstElement()).d();
    }
    paramav.a(j, 40);
  }
  
  public void a(boolean paramBoolean)
  {
    i = paramBoolean;
  }
  
  public boolean a(com.xiaoenai.app.classes.chat.messagelist.message.a.a parama)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    for (;;)
    {
      try
      {
        if (parama.c() != null) {
          if (parama.c().equals("{}"))
          {
            bool1 = bool2;
            if (parama.b() == null) {}
          }
          else
          {
            bool1 = parama.c().equals("");
            if (!bool1) {
              continue;
            }
            bool1 = bool2;
          }
        }
        return bool1;
        if (this.c.contains(parama)) {
          break label192;
        }
        if (this.c.a(parama)) {
          if (this.c.size() == 1)
          {
            parama.a = true;
          }
          else if (parama.d() > ((com.xiaoenai.app.classes.chat.messagelist.message.a.a)this.c.get(this.g)).d() + 300)
          {
            this.g = (this.c.size() - 1);
            parama.a = true;
          }
        }
      }
      finally {}
      com.xiaoenai.app.utils.f.a.a("将新消息加入列表失败 msg= {} messageId = {}", new Object[] { parama.c(), Long.valueOf(parama.h()) });
      com.f.a.b.b(Xiaoenai.j(), "AddNewMsgFail");
      bool1 = bool2;
      continue;
      label192:
      com.xiaoenai.app.utils.f.a.a("新消息已在列表中", new Object[0]);
      bool1 = bool2;
      continue;
      bool1 = true;
    }
  }
  
  public ArrayList<PhotoMessage> b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      com.xiaoenai.app.classes.chat.messagelist.message.a.a locala = (com.xiaoenai.app.classes.chat.messagelist.message.a.a)localIterator.next();
      if (locala.b().equals("image")) {
        localArrayList.add((PhotoMessage)locala);
      }
    }
    return localArrayList;
  }
  
  public void b(com.xiaoenai.app.classes.chat.messagelist.message.a.a parama)
  {
    label183:
    for (;;)
    {
      try
      {
        int j;
        if (parama.a)
        {
          j = this.c.indexOf(parama);
          if (j != -1)
          {
            if (j != this.c.size() - 1) {
              continue;
            }
            j = this.c.size() - 1;
            if (j >= 0)
            {
              if (!((com.xiaoenai.app.classes.chat.messagelist.message.a.a)this.c.get(j)).a) {
                continue;
              }
              this.g = j;
            }
          }
        }
        if ((this.c.remove(parama)) && (this.g >= this.c.size()))
        {
          j = this.c.size() - 1;
          if (j >= 0)
          {
            if (!((com.xiaoenai.app.classes.chat.messagelist.message.a.a)this.c.get(j)).a) {
              break label183;
            }
            this.g = j;
          }
        }
        return;
        j -= 1;
        continue;
        ((com.xiaoenai.app.classes.chat.messagelist.message.a.a)this.c.get(j + 1)).a = true;
        if (this.g == j)
        {
          this.g = (j + 1);
          continue;
          j -= 1;
        }
      }
      finally {}
    }
  }
  
  public void c(com.xiaoenai.app.classes.chat.messagelist.message.a.a parama)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      com.xiaoenai.app.classes.chat.messagelist.message.a.a locala = (com.xiaoenai.app.classes.chat.messagelist.message.a.a)localIterator.next();
      if (parama.h() == locala.h()) {
        locala.b(parama.c());
      }
    }
  }
  
  public boolean c()
  {
    return i;
  }
  
  public boolean d()
  {
    return this.e;
  }
  
  public boolean e()
  {
    return this.f;
  }
  
  public boolean f()
  {
    return (this.e) || (this.f);
  }
  
  public Object[] g()
  {
    return this.c.toArray();
  }
  
  public void h()
  {
    this.c.clear();
    this.g = 0;
    this.e = false;
    UserConfig.remove("chat_edittext_tmpmsg");
  }
  
  public void i()
  {
    this.d.b();
    h();
  }
  
  public int j()
  {
    return this.c.size();
  }
  
  public long n()
  {
    Iterator localIterator = this.c.iterator();
    long l1 = 0L;
    if (localIterator.hasNext())
    {
      com.xiaoenai.app.classes.chat.messagelist.message.a.a locala = (com.xiaoenai.app.classes.chat.messagelist.message.a.a)localIterator.next();
      if (locala.h() <= l1) {
        break label86;
      }
      l1 = locala.h();
    }
    label86:
    for (;;)
    {
      break;
      long l2 = l1;
      if (0L == l1)
      {
        l2 = this.d.c();
        com.xiaoenai.app.utils.f.a.c(true, "max message id = {}", new Object[] { Long.valueOf(l2) });
      }
      return l2;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */