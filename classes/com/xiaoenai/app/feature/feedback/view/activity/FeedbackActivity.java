package com.xiaoenai.app.feature.feedback.view.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTouch;
import com.xiaoenai.app.common.view.activity.TitleBarActivity;
import com.xiaoenai.app.common.view.widget.TitleBarView;
import com.xiaoenai.app.feature.feedback.a.c;
import com.xiaoenai.app.feature.feedback.a.e;
import com.xiaoenai.app.feature.feedback.a.f;
import com.xiaoenai.app.feature.feedback.a.a.a.a.a;
import com.xiaoenai.app.feature.feedback.a.a.a.u;
import com.xiaoenai.app.feature.feedback.view.widget.BaseItemView.a;
import com.xiaoenai.app.feature.feedback.view.widget.InputLayoutView;
import com.xiaoenai.app.feature.feedback.view.widget.InputLayoutView.a;
import com.xiaoenai.app.feature.photopicker.view.PhotoPickerActivity;
import com.xiaoenai.app.ui.component.view.keyboard.FuncLayout.b;
import com.xiaoenai.app.ui.xrecyclerview.XRecyclerView;
import com.xiaoenai.app.ui.xrecyclerview.XRecyclerView.b;
import com.xiaoenai.app.utils.d.o;
import com.xiaoenai.app.utils.d.p;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

public class FeedbackActivity
  extends TitleBarActivity
  implements com.xiaoenai.app.feature.feedback.view.a, BaseItemView.a, InputLayoutView.a, FuncLayout.b, XRecyclerView.b
{
  @Inject
  protected com.xiaoenai.app.domain.e.c e;
  @Inject
  protected com.xiaoenai.app.data.e.c f;
  @Inject
  protected com.xiaoenai.app.common.a.a g;
  @Inject
  protected com.xiaoenai.app.feature.feedback.presenter.a h;
  private TextView i;
  private a j;
  private com.xiaoenai.app.feature.feedback.view.a.a k;
  private List<com.xiaoenai.app.feature.feedback.b.c> l = new ArrayList();
  private boolean m = false;
  @BindView(2131230760)
  InputLayoutView mInputLayoutView;
  @BindView(2131230762)
  XRecyclerView mRecyclerView;
  @BindView(2131230761)
  RelativeLayout mRlChatBody;
  private boolean n;
  private com.xiaoenai.app.feature.feedback.b.a o;
  private com.xiaoenai.app.feature.feedback.b.f s;
  private u t;
  private com.xiaoenai.app.b.a u;
  private com.xiaoenai.app.ui.a.h v;
  private int w = 16;
  
  private void C()
  {
    if (this.u == null) {
      this.u = new com.xiaoenai.app.b.a(this);
    }
    this.u.a(c.a(this));
  }
  
  private void D()
  {
    com.xiaoenai.app.feature.feedback.c.b.a(this.l);
    Iterator localIterator = this.l.iterator();
    String str = this.h.j();
    while (localIterator.hasNext())
    {
      com.xiaoenai.app.feature.feedback.b.c localc = (com.xiaoenai.app.feature.feedback.b.c)localIterator.next();
      if (-1 == localc.e()) {
        localc.b(0);
      }
      if ((!TextUtils.isEmpty(str)) && (localc.d() == 0)) {
        localc.b(str);
      }
    }
    E();
    this.k.notifyDataSetChanged();
    this.m = true;
    if (this.l.size() == 0) {
      this.h.b(System.currentTimeMillis());
    }
    if (this.h.n())
    {
      this.h.m();
      v();
      f(getString(a.f.fb_title_allocate_queue));
      return;
    }
    t();
  }
  
  private void E()
  {
    if (this.mRecyclerView != null)
    {
      this.mRecyclerView.requestLayout();
      if ((this.k != null) && (this.k.getItemCount() > 0)) {
        this.mRecyclerView.post(h.a(this));
      }
    }
  }
  
  private List<String> F()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext())
    {
      com.xiaoenai.app.feature.feedback.b.c localc = (com.xiaoenai.app.feature.feedback.b.c)localIterator.next();
      if ((localc instanceof com.xiaoenai.app.feature.feedback.b.d)) {
        localArrayList.add(((com.xiaoenai.app.feature.feedback.b.d)localc).i().a());
      }
    }
    return localArrayList;
  }
  
  private void G()
  {
    Intent localIntent = new Intent();
    localIntent.setFlags(536870912);
    int i1 = Integer.valueOf(getString(a.f.xiaoenai_meiqia)).intValue();
    localIntent.setClass(this, FeedbackActivity.class);
    p.a(this, a.c.icon, getString(a.f.app_name), getString(a.f.fb_new_message_notification), 0, i1, localIntent);
  }
  
  private int a(List<String> paramList, String paramString)
  {
    int i1 = 0;
    int i2 = 0;
    while (i1 < paramList.size())
    {
      if (paramString.equals(paramList.get(i1))) {
        i2 = i1;
      }
      i1 += 1;
    }
    return i2;
  }
  
  private void a(ArrayList<String> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      b(new File((String)paramArrayList.next()));
    }
  }
  
  private void b(File paramFile)
  {
    if (!paramFile.exists()) {
      return;
    }
    com.xiaoenai.app.feature.feedback.b.d locald = new com.xiaoenai.app.feature.feedback.b.d();
    locald.c(paramFile.getAbsolutePath());
    e(locald);
  }
  
  private String[] c(List<String> paramList)
  {
    String[] arrayOfString = new String[paramList.size()];
    int i1 = 0;
    while (i1 < paramList.size())
    {
      arrayOfString[i1] = ((String)paramList.get(i1));
      i1 += 1;
    }
    return arrayOfString;
  }
  
  private void e(com.xiaoenai.app.feature.feedback.b.c paramc)
  {
    if (!g(paramc)) {
      return;
    }
    this.h.a(paramc);
    E();
  }
  
  private void f(com.xiaoenai.app.feature.feedback.b.c paramc)
  {
    this.l.remove(paramc);
    com.xiaoenai.app.feature.feedback.c.b.a(this.l);
    this.l.add(paramc);
    n();
  }
  
  private void f(String paramString)
  {
    this.b.setTitle(paramString);
  }
  
  private void g(String paramString)
  {
    if (this.i == null)
    {
      this.i = ((TextView)getLayoutInflater().inflate(a.e.view_top_pop_tip, null));
      this.i.setText(paramString);
      this.mRlChatBody.addView(this.i, -1, -2);
      ViewCompat.animate(this.i).translationY(0.0F).setDuration(300L).start();
    }
  }
  
  private boolean g(com.xiaoenai.app.feature.feedback.b.c paramc)
  {
    if (this.k == null) {
      return false;
    }
    if ((this.s != null) && (this.o == null))
    {
      h(getString(a.f.fb_allocate_queue_tip));
      return false;
    }
    String str = this.h.j();
    if (!TextUtils.isEmpty(str)) {
      paramc.b(str);
    }
    paramc.b(-1);
    this.l.add(paramc);
    this.mInputLayoutView.setUnSendText("");
    if (!TextUtils.isEmpty(this.h.o())) {
      this.h.a("");
    }
    com.xiaoenai.app.feature.feedback.c.b.a(this.l);
    this.k.notifyDataSetChanged();
    return true;
  }
  
  private void h(String paramString)
  {
    com.xiaoenai.app.ui.a.h.c(this, paramString, 1500L);
  }
  
  private void i(String paramString)
  {
    if (TextUtils.isEmpty(paramString.trim())) {
      return;
    }
    if (paramString.equals("debug"))
    {
      h();
      this.e.a(1000).a(d.a(this), e.a(this));
      this.mInputLayoutView.setUnSendText("");
      return;
    }
    if (paramString.equals("debugdebug"))
    {
      h();
      this.e.a(2000).a(f.a(this), g.a(this));
      this.mInputLayoutView.setUnSendText("");
      return;
    }
    e(new com.xiaoenai.app.feature.feedback.b.e(paramString));
  }
  
  private void p()
  {
    this.h.a(this);
    this.k = new com.xiaoenai.app.feature.feedback.view.a.a(this, this.l, this);
    this.mRecyclerView.setAdapter(this.k);
    if (!TextUtils.isEmpty(this.h.o()))
    {
      String str = this.h.i();
      this.mInputLayoutView.setUnSendText(str);
    }
    this.h.f();
  }
  
  private void q()
  {
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this);
    localLinearLayoutManager.setOrientation(1);
    this.mRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.mRecyclerView.setRefreshProgressStyle(0);
    this.mRecyclerView.setNoMore(true);
    this.mRecyclerView.setLoadingMoreEnabled(false);
    this.mRecyclerView.a();
  }
  
  private void r()
  {
    this.mInputLayoutView.setListener(this);
    this.mInputLayoutView.a(this);
    this.mRecyclerView.setLoadingListener(this);
    WeakReference localWeakReference = new WeakReference(com.xiaoenai.app.utils.e.d.b());
    this.mRecyclerView.addOnScrollListener(new com.xiaoenai.app.utils.e.d.f(localWeakReference, true, true, new i(this)));
  }
  
  private void s()
  {
    this.h.g();
    this.j = new a(null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    registerReceiver(this.j, localIntentFilter);
  }
  
  private void t()
  {
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext()) {
      if (((com.xiaoenai.app.feature.feedback.b.c)localIterator.next() instanceof com.xiaoenai.app.feature.feedback.b.f))
      {
        localIterator.remove();
        this.k.notifyDataSetChanged();
      }
    }
    this.s = null;
  }
  
  private void u()
  {
    if ((this.s != null) && (this.o != null)) {
      e();
    }
    do
    {
      do
      {
        return;
        t();
      } while (this.i != null);
      String str2 = this.h.l();
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = getString(a.f.fb_leave_msg_tips);
      }
      g(str1);
    } while (this.o != null);
    b(a.f.fb_title_leave_msg);
  }
  
  private void v()
  {
    if (this.i != null) {
      w();
    }
  }
  
  private void w()
  {
    if (this.i != null) {
      ViewCompat.animate(this.i).translationY(-this.i.getHeight()).setListener(new j(this)).setDuration(300L).start();
    }
  }
  
  private void x()
  {
    com.xiaoenai.app.ui.a.b localb = new com.xiaoenai.app.ui.a.b(this);
    localb.a(a.f.fb_take_photo, 1, new k(this, localb));
    localb.a(a.f.fb_pick_from_photo, 1, new l(this, localb));
    localb.show();
  }
  
  private void y()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, PhotoPickerActivity.class);
    localIntent.putExtra("max_selected_size", 1);
    startActivityForResult(localIntent, this.w);
  }
  
  public void a()
  {
    this.mRecyclerView.a();
    this.k.notifyDataSetChanged();
  }
  
  public void a(int paramInt, String paramString)
  {
    if (19999 == paramInt) {
      b(a.f.fb_title_no_network);
    }
    for (;;)
    {
      if (!this.m) {
        this.h.c(System.currentTimeMillis());
      }
      return;
      if (19998 == paramInt)
      {
        a(this.o);
        u();
      }
      else if (20004 == paramInt)
      {
        a(null);
        this.n = true;
      }
      else
      {
        a(paramString);
        b(a.f.fb_title_unknown_error);
      }
    }
  }
  
  public void a(com.xiaoenai.app.feature.feedback.b.a parama)
  {
    if ((this.i != null) && (this.o != null)) {}
    com.xiaoenai.app.feature.feedback.b.a locala;
    do
    {
      do
      {
        return;
        locala = this.o;
        this.o = parama;
      } while (this.h.n());
      if (this.o == null)
      {
        b(a.f.fb_title_leave_msg);
        return;
      }
      f(parama.a());
    } while (locala == this.o);
    v();
    t();
  }
  
  public void a(com.xiaoenai.app.feature.feedback.b.c paramc)
  {
    if (this.k != null) {
      if (!"voice".equals(paramc.b())) {}
    }
    while (!this.g.a())
    {
      return;
      this.l.add(paramc);
      this.k.notifyDataSetChanged();
      if (((LinearLayoutManager)this.mRecyclerView.getLayoutManager()).findLastVisibleItemPosition() == this.k.getItemCount() - 1) {
        E();
      }
    }
    G();
  }
  
  public void a(com.xiaoenai.app.feature.feedback.b.c paramc1, com.xiaoenai.app.feature.feedback.b.c paramc2)
  {
    if (this.o == null) {
      a(this.h.k());
    }
    paramc1.a(paramc2.a());
    paramc1.b(paramc2.f());
    paramc1.b(paramc2.c());
    paramc1.b(paramc2.e());
    paramc1.a(paramc2.d());
    if (paramc1.b().equals("photo")) {
      ((com.xiaoenai.app.feature.feedback.b.d)paramc1).a(((com.xiaoenai.app.feature.feedback.b.d)paramc2).i());
    }
    f(paramc1);
    this.k.notifyDataSetChanged();
  }
  
  public void a(String paramString) {}
  
  public void a(List<com.xiaoenai.app.feature.feedback.b.c> paramList)
  {
    this.l.clear();
    this.l.addAll(paramList);
    D();
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    this.b.setTitle(paramInt);
  }
  
  public void b(com.xiaoenai.app.feature.feedback.b.c paramc)
  {
    if ((this.s != null) && (this.o == null))
    {
      h(getString(a.f.fb_allocate_queue_tip));
      return;
    }
    paramc.b(-1);
    this.h.b(paramc);
  }
  
  public void b(String paramString)
  {
    i(paramString);
  }
  
  public void b(List<com.xiaoenai.app.feature.feedback.b.c> paramList)
  {
    if (!this.m)
    {
      this.l.addAll(paramList);
      D();
    }
    do
    {
      return;
      com.xiaoenai.app.feature.feedback.c.b.a(paramList);
      this.l.addAll(0, paramList);
      this.k.notifyDataSetChanged();
      ((LinearLayoutManager)this.mRecyclerView.getLayoutManager()).scrollToPositionWithOffset(paramList.size(), 1);
    } while (paramList.size() != 0);
    this.mRecyclerView.setPullRefreshEnabled(false);
  }
  
  public void b_(int paramInt)
  {
    if (paramInt == 20008)
    {
      if (this.o != null) {
        this.o = null;
      }
      h(getString(a.f.fb_allocate_queue_tip));
      this.h.m();
      v();
      b(a.f.fb_title_allocate_queue);
    }
    while (19998 != paramInt) {
      return;
    }
    this.o = null;
    a(this.o);
    u();
  }
  
  public Context c()
  {
    return getApplicationContext();
  }
  
  public void c(int paramInt)
  {
    E();
  }
  
  public void c(com.xiaoenai.app.feature.feedback.b.c paramc)
  {
    com.xiaoenai.app.ui.a.b localb = new com.xiaoenai.app.ui.a.b(this);
    if ("text".equals(paramc.b())) {
      localb.a(a.f.copy, 1, new m(this, paramc, localb));
    }
    localb.a(a.f.delete, 2, new n(this, paramc, localb));
    localb.show();
  }
  
  public void c(String paramString)
  {
    List localList = F();
    if (localList.size() > 0)
    {
      Intent localIntent = new Intent(this, ChatImageViewPager.class);
      localIntent.putExtra("imageUrls", c(localList));
      localIntent.putExtra("position", a(localList, paramString));
      startActivity(localIntent);
    }
  }
  
  protected int d()
  {
    return a.e.activity_feedback;
  }
  
  public void d(com.xiaoenai.app.feature.feedback.b.c paramc)
  {
    b(paramc);
  }
  
  public void e()
  {
    v();
    b(a.f.fb_title_allocate_queue);
    t();
    this.s = new com.xiaoenai.app.feature.feedback.b.f();
    String str2 = this.f.a("config_meiqia_no_free_agent_msg", "");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = getString(a.f.fb_allocate_agent_tip);
    }
    this.s.c(str1);
    this.l.add(this.s);
    E();
  }
  
  public void g()
  {
    x();
  }
  
  /* Error */
  public void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 667	com/xiaoenai/app/feature/feedback/view/activity/FeedbackActivity:i	()V
    //   6: aload_0
    //   7: invokevirtual 767	com/xiaoenai/app/feature/feedback/view/activity/FeedbackActivity:isFinishing	()Z
    //   10: istore_2
    //   11: iload_2
    //   12: ifeq +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: aload_0
    //   20: invokestatic 770	com/xiaoenai/app/ui/a/h:a	(Landroid/content/Context;)Lcom/xiaoenai/app/ui/a/h;
    //   23: putfield 772	com/xiaoenai/app/feature/feedback/view/activity/FeedbackActivity:v	Lcom/xiaoenai/app/ui/a/h;
    //   26: aload_0
    //   27: getfield 772	com/xiaoenai/app/feature/feedback/view/activity/FeedbackActivity:v	Lcom/xiaoenai/app/ui/a/h;
    //   30: iconst_1
    //   31: invokevirtual 775	com/xiaoenai/app/ui/a/h:setCancelable	(Z)V
    //   34: aload_0
    //   35: getfield 772	com/xiaoenai/app/feature/feedback/view/activity/FeedbackActivity:v	Lcom/xiaoenai/app/ui/a/h;
    //   38: invokevirtual 778	com/xiaoenai/app/ui/a/h:isShowing	()Z
    //   41: ifne -26 -> 15
    //   44: aload_0
    //   45: invokevirtual 767	com/xiaoenai/app/feature/feedback/view/activity/FeedbackActivity:isFinishing	()Z
    //   48: ifne -33 -> 15
    //   51: aload_0
    //   52: getfield 772	com/xiaoenai/app/feature/feedback/view/activity/FeedbackActivity:v	Lcom/xiaoenai/app/ui/a/h;
    //   55: invokevirtual 779	com/xiaoenai/app/ui/a/h:show	()V
    //   58: goto -43 -> 15
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	FeedbackActivity
    //   61	4	1	localObject	Object
    //   10	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	11	61	finally
    //   18	58	61	finally
  }
  
  public void i()
  {
    if ((!isFinishing()) && (this.v != null) && (this.v.isShowing())) {
      this.v.dismiss();
    }
    this.v = null;
  }
  
  public void j()
  {
    long l1 = System.currentTimeMillis();
    if (this.l.size() > 0) {
      l1 = ((com.xiaoenai.app.feature.feedback.b.c)this.l.get(0)).c();
    }
    this.h.b(l1);
  }
  
  public void k() {}
  
  protected void l()
  {
    super.l();
    this.t = com.xiaoenai.app.feature.feedback.a.a.a.a.c().a(z()).a(A()).a(new com.xiaoenai.app.feature.feedback.a.a.b.a(this)).a();
    this.t.a(this);
  }
  
  public void m() {}
  
  public void n() {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (-1 == paramInt2)
    {
      if ((this.w != paramInt1) || (paramIntent == null)) {
        break label124;
      }
      paramIntent = paramIntent.getStringArrayListExtra("selected_image_url");
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        localArrayList = new ArrayList();
        localIterator = paramIntent.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          paramIntent = str;
          if (str.startsWith("file://")) {
            paramIntent = str.substring(6, str.length());
          }
          localArrayList.add(paramIntent);
        }
        a(localArrayList);
      }
    }
    label124:
    while (32 != paramInt1)
    {
      ArrayList localArrayList;
      Iterator localIterator;
      String str;
      return;
    }
    this.u.a(paramInt1, paramInt2);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (com.xiaoenai.app.utils.d.l.a(this) > 0) {
      getWindow().setSoftInputMode(18);
    }
    super.onCreate(paramBundle);
    ButterKnife.bind(this);
    q();
    p();
    r();
    s();
  }
  
  protected void onDestroy()
  {
    if (this.mRecyclerView != null) {
      this.mRecyclerView.clearOnScrollListeners();
    }
    this.mInputLayoutView.c();
    unregisterReceiver(this.j);
    if (!TextUtils.isEmpty(this.h.o()))
    {
      String str = this.mInputLayoutView.getInputEditText().getText().toString().trim();
      this.h.a(str);
    }
    this.h.e();
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    this.mInputLayoutView.a();
    this.h.c();
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.o == null)
    {
      b(a.f.fb_title_waiting);
      this.h.b();
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    this.h.a();
  }
  
  protected void onStop()
  {
    super.onStop();
    this.h.d();
    if ((this.l != null) && (this.l.size() > 0))
    {
      this.h.d(((com.xiaoenai.app.feature.feedback.b.c)this.l.get(this.l.size() - 1)).c());
      return;
    }
    this.h.d(System.currentTimeMillis());
  }
  
  @OnTouch({2131230762})
  boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      com.xiaoenai.app.utils.d.l.b(this);
    }
    return false;
  }
  
  private class a
    extends BroadcastReceiver
  {
    private boolean b = true;
    
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
      {
        if (this.b) {
          break label87;
        }
        if (o.a(FeedbackActivity.this.getApplicationContext()))
        {
          FeedbackActivity.this.a(FeedbackActivity.this.h.k());
          FeedbackActivity.this.h.m();
        }
      }
      else
      {
        return;
      }
      FeedbackActivity.this.b(a.f.fb_title_no_network);
      FeedbackActivity.this.h.h();
      return;
      label87:
      this.b = false;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\feedback\view\activity\FeedbackActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */