package com.xiaoenai.app.classes.forum.presenter;

import android.support.v4.app.Fragment;
import com.xiaoenai.app.h.b.d;
import com.xiaoenai.app.model.AppSettings;
import com.xiaoenai.app.model.Forum.ForumAdInfo;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.g;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ap
  extends com.xiaoenai.app.classes.common.mvp.a.a.a<com.xiaoenai.app.classes.common.ads.a>
{
  private final com.xiaoenai.app.classes.forum.c.b f;
  private List<d> g = null;
  private int h = 0;
  private boolean i = true;
  private boolean j = false;
  
  public ap(com.xiaoenai.app.classes.forum.c.b paramb)
  {
    super(paramb);
    this.f = paramb;
  }
  
  private void a(int paramInt)
  {
    ((com.xiaoenai.app.classes.forum.c.b)this.e).b(paramInt);
    UserConfig.setLong("forum_notify_cout_req_delay", System.currentTimeMillis());
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int n;
    int i1;
    if (v.a(this.e.c()))
    {
      k = ab.b() - ab.a(10.0F) * 2;
      m = k * 423 / 1182;
      com.xiaoenai.app.utils.f.a.c("categoryId = {} add AdFeed w = {} h = {}", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(k), Integer.valueOf(m) });
      com.xiaoenai.app.h.b.b localb = new com.xiaoenai.app.h.b.b(this.f.m().getActivity(), k, m, new ar(this, paramInt2));
      n = AppSettings.getInt("forum_topic_list_ad_offset_mmu", Integer.valueOf(3)).intValue();
      i1 = AppSettings.getInt("forum_topic_list_ad_space_mmu", Integer.valueOf(8)).intValue();
      if (paramInt1 != 0) {
        break label348;
      }
      this.h = 0;
      k = (this.d - n) / i1 + 1;
      com.xiaoenai.app.utils.f.a.c("count = {}", new Object[] { Integer.valueOf(k) });
      com.xiaoenai.app.utils.f.a.c("count = {}", new Object[] { Integer.valueOf(k) });
      m = k;
      if (k > 4) {
        m = 4;
      }
      com.xiaoenai.app.utils.f.a.c("categoryId = {} offset = {} adOffset = {} adInterval = {} mAdOffset = {} count = {}", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(this.h), Integer.valueOf(m) });
      if ((this.h >= 0) && (this.h < 4) && (m > 0))
      {
        com.xiaoenai.app.utils.f.a.c("count = {}", new Object[] { Integer.valueOf(m) });
        localb.a(this.h);
        localb.b(m);
        localb.a();
        this.h = (m + this.h);
        com.xiaoenai.app.utils.f.a.c("mAdOffset = {}", new Object[] { Integer.valueOf(this.h) });
      }
    }
    return;
    label348:
    int k = this.d + paramInt1 - n;
    int m = k / i1;
    int i2 = this.h;
    if (k % i1 > 0) {}
    for (k = 1;; k = 0)
    {
      k += m - i2;
      com.xiaoenai.app.utils.f.a.c("count = {} mAdOffset = {}", new Object[] { Integer.valueOf(k), Integer.valueOf(this.h) });
      break;
    }
  }
  
  private void b(List<d> paramList)
  {
    if (paramList != null)
    {
      com.xiaoenai.app.utils.f.a.c("feedAdInfo size = {}", new Object[] { Integer.valueOf(paramList.size()) });
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(new ForumAdInfo((d)paramList.next()));
      }
      c(localArrayList);
    }
    this.g = null;
  }
  
  private void c(List<com.xiaoenai.app.classes.common.ads.a> paramList)
  {
    if ((this.e != null) && (!this.e.k_())) {
      this.e.b(paramList, true);
    }
  }
  
  private void i()
  {
    if (16 != ((com.xiaoenai.app.classes.forum.c.b)this.e).k()) {}
    long l;
    do
    {
      return;
      l = UserConfig.getLong("forum_notify_cout_req_delay", 0L);
      l = System.currentTimeMillis() - l;
      com.xiaoenai.app.utils.f.a.c("notify_count_delay ----------:{}", new Object[] { Long.valueOf(l) });
    } while (l < 5000L);
    new g(new as(this, this.e.c())).c();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    int k = ((com.xiaoenai.app.classes.forum.c.b)this.e).k();
    com.xiaoenai.app.utils.f.a.c("categoryId = {} offset = {} load more = {}", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    g localg = new g(new aq(this, this.e.c(), paramBoolean));
    if (paramBoolean) {}
    for (long l = ((com.xiaoenai.app.classes.forum.c.b)this.e).l();; l = -1L)
    {
      com.xiaoenai.app.utils.f.a.c("offset = {}", new Object[] { Integer.valueOf(paramInt) });
      this.j = false;
      localg.a(k, l, this.d, paramInt);
      a(paramInt, k);
      return;
    }
  }
  
  public void a(ForumAdInfo paramForumAdInfo) {}
  
  public void a(List<com.xiaoenai.app.classes.common.ads.a> paramList)
  {
    if (paramList != null) {}
    for (int k = paramList.size();; k = 0)
    {
      com.xiaoenai.app.utils.f.a.c("offset = {} mOffset = {}", new Object[] { Integer.valueOf(k), Integer.valueOf(this.c) });
      this.c += k;
      com.xiaoenai.app.classes.common.mvp.view.b localb;
      if ((this.e != null) && (!this.e.k_()))
      {
        localb = this.e;
        if (k < 20) {
          break label117;
        }
      }
      label117:
      for (boolean bool = true;; bool = false)
      {
        localb.a(bool);
        this.e.a(paramList, this.b);
        this.e.j_();
        this.a = false;
        return;
      }
    }
  }
  
  public void d()
  {
    com.xiaoenai.app.utils.f.a.c("CategoryId = {}", new Object[] { Integer.valueOf(this.f.k()) });
    if (this.f.k() == 16) {
      h();
    }
  }
  
  public void e()
  {
    super.e();
    i();
  }
  
  public void h()
  {
    com.xiaoenai.app.utils.f.a.c("CategoryId = {}", new Object[] { Integer.valueOf(this.f.k()) });
    if (this.i)
    {
      this.e.h_();
      a();
      this.i = false;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\presenter\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */