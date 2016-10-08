package com.xiaoenai.app.classes.chat;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.hardware.SensorEvent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.chat.input.InputFragment;
import com.xiaoenai.app.classes.chat.input.a.i;
import com.xiaoenai.app.classes.chat.messagelist.message.model.PhotoMessage;
import com.xiaoenai.app.classes.chat.messagelist.message.model.m;
import com.xiaoenai.app.classes.chat.messagelist.message.model.o;
import com.xiaoenai.app.classes.common.ColorPickerActivity;
import com.xiaoenai.app.classes.common.image.ImagePicker;
import com.xiaoenai.app.classes.home.HomeActivity;
import com.xiaoenai.app.g.a.a.a.b.a;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.socket.SocketManager;
import com.xiaoenai.app.stat.c;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.utils.e.d.e;
import com.xiaoenai.app.utils.g;
import com.xiaoenai.app.widget.AutoHeightLayout;
import com.xiaoenai.app.widget.TitleBarView;
import com.xiaoenai.app.widget.imagepicker.BaseImagePickerActivity;
import java.io.File;
import java.lang.ref.WeakReference;
import javax.inject.Inject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatActivity
  extends BaseChatActivity
  implements av.a
{
  public static boolean c = false;
  @Inject
  protected com.xiaoenai.app.domain.e.d b;
  private ChatReceiver i = new ChatReceiver();
  private ListView j;
  private RelativeLayout k;
  private av l;
  private InputFragment m;
  private com.xiaoenai.app.g.a.a.a.a n;
  private int o = 0;
  private boolean s = false;
  private an t;
  private boolean u = false;
  private ImageView v;
  private boolean w = false;
  
  private void C()
  {
    this.j = ((ListView)findViewById(2131558754));
    this.k = ((RelativeLayout)findViewById(2131558755));
    as.a(this.j);
    this.l = new av(this);
    this.l.a(this);
    if (com.xiaoenai.app.classes.chat.messagelist.a.a().j() > com.xiaoenai.app.utils.ab.a() / com.xiaoenai.app.utils.ab.a(100.0F)) {
      this.j.setStackFromBottom(true);
    }
    for (;;)
    {
      this.j.setAdapter(this.l);
      this.m = ((InputFragment)getSupportFragmentManager().findFragmentById(2131558753));
      this.a.setInputFragment(this.m);
      this.j.setOnScrollListener(new e(new WeakReference(com.xiaoenai.app.utils.e.d.b()), false, true, this.l));
      if (this.a.getViewTreeObserver() != null) {
        this.a.getViewTreeObserver().addOnGlobalLayoutListener(new y(this));
      }
      this.j.setOnTouchListener(new aa(this));
      this.v = ((ImageView)findViewById(2131558752));
      D();
      this.k.setOnClickListener(new ab(this));
      return;
      this.j.setStackFromBottom(false);
    }
  }
  
  private void D()
  {
    ak.a(this.v);
  }
  
  private void E()
  {
    if (this.l != null)
    {
      if (com.xiaoenai.app.classes.chat.messagelist.a.a().j() <= com.xiaoenai.app.utils.ab.a() / com.xiaoenai.app.utils.ab.a(100.0F)) {
        break label41;
      }
      this.j.setStackFromBottom(true);
    }
    for (;;)
    {
      this.l.a();
      return;
      label41:
      this.j.setStackFromBottom(false);
    }
  }
  
  private static void a(String paramString, Boolean paramBoolean)
  {
    com.xiaoenai.app.utils.f.a.c(paramString, new Object[0]);
    int i5 = com.xiaoenai.app.utils.k.b(paramString);
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    File localFile = new File(paramString);
    int i3 = ((BitmapFactory.Options)localObject).outWidth;
    int i4 = ((BitmapFactory.Options)localObject).outHeight;
    int i2 = i4;
    int i1 = i3;
    if (i5 != 0)
    {
      i2 = i4;
      i1 = i3;
      if (i3 != 0)
      {
        i2 = i4;
        i1 = i3;
        if (i4 != 0)
        {
          i1 = ((BitmapFactory.Options)localObject).outHeight;
          i2 = ((BitmapFactory.Options)localObject).outWidth;
        }
      }
    }
    localObject = new PhotoMessage();
    ((PhotoMessage)localObject).d(paramString);
    ((PhotoMessage)localObject).b(1);
    ((PhotoMessage)localObject).b(Integer.valueOf(-1));
    ((PhotoMessage)localObject).a(i1, i2);
    ((PhotoMessage)localObject).d(localFile.length());
    ((PhotoMessage)localObject).d(paramBoolean.booleanValue());
  }
  
  private void c(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        String str = User.getInstance().getLoverNickName();
        if ((str != null) && (!str.equals("")) && (!str.equals("null"))) {
          this.g.setTitle(str);
        }
        for (;;)
        {
          h();
          if (this.k == null) {
            break;
          }
          this.k.setVisibility(8);
          return;
          this.g.setTitle(2131099955);
        }
        this.g.setTitle(2131100001);
        g();
      } while (this.k == null);
      this.k.setVisibility(8);
      return;
      this.g.setTitle(2131100003);
      h();
    } while (this.k == null);
    this.k.setVisibility(0);
  }
  
  private static void f(String paramString)
  {
    com.xiaoenai.app.utils.f.a.c(paramString, new Object[0]);
    int i5 = com.xiaoenai.app.utils.k.b(paramString);
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    int i3 = ((BitmapFactory.Options)localObject).outWidth;
    int i4 = ((BitmapFactory.Options)localObject).outHeight;
    int i2 = i4;
    int i1 = i3;
    if (i5 != 0)
    {
      i2 = i4;
      i1 = i3;
      if (i3 != 0)
      {
        i2 = i4;
        i1 = i3;
        if (i4 != 0)
        {
          i1 = ((BitmapFactory.Options)localObject).outHeight;
          i2 = ((BitmapFactory.Options)localObject).outWidth;
        }
      }
    }
    localObject = new PhotoMessage();
    ((PhotoMessage)localObject).d(paramString);
    ((PhotoMessage)localObject).b(1);
    ((PhotoMessage)localObject).b(Integer.valueOf(-1));
    ((PhotoMessage)localObject).a(i1, i2);
    ((PhotoMessage)localObject).j();
  }
  
  public int a()
  {
    return 2130903090;
  }
  
  public void a(int paramInt)
  {
    if (!as.c())
    {
      as.a(this);
      return;
    }
    Object localObject = new ImagePicker(this);
    ((ImagePicker)localObject).a(new ae(this));
    if (paramInt == 0)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("pick_from", 1);
      ((Intent)localObject).setClass(this, BaseImagePickerActivity.class);
      startActivityForResult((Intent)localObject, 21);
    }
    for (;;)
    {
      this.j.setTranscriptMode(2);
      return;
      ((ImagePicker)localObject).a(0);
    }
  }
  
  public void a(View paramView, com.xiaoenai.app.classes.chat.messagelist.message.a.a parama)
  {
    boolean bool = true;
    com.xiaoenai.app.utils.f.a.c("message click type = {} content = {}", new Object[] { parama.b(), parama.c() });
    if (parama.b().equals("voice")) {
      if (parama.f().intValue() != 0) {
        break label63;
      }
    }
    for (;;)
    {
      this.w = bool;
      a((o)parama);
      return;
      label63:
      bool = false;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    a(null, false);
    try
    {
      localJSONObject.put("height", paramInt2);
      localJSONObject.put("is_origin", 1);
      localJSONObject.put("width", paramInt1);
      localJSONObject.put("url", paramString);
      localJSONObject.put("fsize", 0);
      localJSONArray.put(localJSONObject);
      rx.a.a(new ag(this, localJSONArray)).a(new af(this));
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    com.xiaoenai.app.classes.chat.messagelist.message.model.k localk = new com.xiaoenai.app.classes.chat.messagelist.message.model.k();
    localk.c(paramString1);
    localk.d(paramString2);
    localk.b(1);
    localk.b(Integer.valueOf(-1));
    localk.j();
    this.j.setTranscriptMode(2);
  }
  
  public void a_(int paramInt)
  {
    x();
    if (this.l != null) {
      this.l.d();
    }
    if ((com.xiaoenai.app.classes.common.a.a().b() <= 1) && (!com.xiaoenai.app.classes.common.a.a().c(HomeActivity.class)))
    {
      this.m.h();
      Intent localIntent = new Intent(this, HomeActivity.class);
      localIntent.putExtra("from", "login");
      startActivity(localIntent);
      finish();
      overridePendingTransition(2130968602, 2130968603);
      return;
    }
    super.a_(paramInt);
  }
  
  protected void b()
  {
    super.b();
    this.g.setRightButtonClickListener(new ac(this));
    this.g.setTitleClickListener(new ad(this));
    if (UserConfig.getInt("chat_title_color", Integer.valueOf(-1864528)).intValue() != -1864528)
    {
      this.g.b(2130839002, 0);
      this.g.a(2130839001, 0);
    }
  }
  
  public void b(View paramView, com.xiaoenai.app.classes.chat.messagelist.message.a.a parama) {}
  
  public void b(String paramString)
  {
    m localm = new m();
    localm.b(paramString);
    localm.b(1);
    localm.b(Integer.valueOf(-1));
    localm.j();
    this.j.setTranscriptMode(2);
  }
  
  public void c(String paramString)
  {
    com.xiaoenai.app.classes.chat.messagelist.message.model.a locala = new com.xiaoenai.app.classes.chat.messagelist.message.model.a();
    locala.d(paramString);
    locala.b(1);
    locala.b(Integer.valueOf(-1));
    if (paramString.endsWith(".gif")) {
      locala.c("gif");
    }
    for (;;)
    {
      locala.j();
      this.j.setTranscriptMode(2);
      return;
      locala.c("png");
    }
  }
  
  public void f()
  {
    if (this.m != null)
    {
      if (!this.m.n()) {
        break label32;
      }
      this.m.o();
    }
    for (;;)
    {
      this.m.q();
      return;
      label32:
      if (this.m.isAdded())
      {
        this.m.h();
        this.m.j();
        this.m.i();
      }
    }
  }
  
  public void f(o paramo)
  {
    if (paramo == null) {
      return;
    }
    runOnUiThread(new z(this, paramo));
  }
  
  public InputFragment g_()
  {
    return this.m;
  }
  
  protected void i()
  {
    if ((this.l != null) && (!isFinishing())) {
      this.l.a();
    }
  }
  
  protected void l()
  {
    super.l();
    this.n = com.xiaoenai.app.g.a.a.a.b.a().a(A()).a(z()).a(new com.xiaoenai.app.feature.photoalbum.d.a.b.a()).a();
    this.n.a(this);
  }
  
  protected void m()
  {
    super.m();
    c(SocketManager.a().f());
  }
  
  public void n()
  {
    super.n();
  }
  
  public void o()
  {
    com.xiaoenai.app.classes.chat.messagelist.message.model.d locald = new com.xiaoenai.app.classes.chat.messagelist.message.model.d();
    locald.b(1);
    locald.j();
    this.j.setTranscriptMode(2);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i1 = 0;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 != 124) {
        break label55;
      }
      paramIntent = (i)getSupportFragmentManager().findFragmentByTag("StatusFragment");
      if ((paramIntent != null) && (paramIntent.isAdded())) {
        paramIntent.a(paramIntent.getView());
      }
    }
    for (;;)
    {
      return;
      label55:
      if (paramInt1 == 125)
      {
        h.a(this, 2131099997, 1500L);
        D();
        return;
      }
      if (paramInt1 == 126)
      {
        this.g.a();
        if (UserConfig.getInt("chat_title_color", Integer.valueOf(-1864528)).intValue() == -1864528)
        {
          this.g.b(2130839002, -1);
          this.g.a(2130839001, -1);
          return;
        }
        this.g.b(2130839006, -1);
        this.g.a(2130839001, -1);
        return;
      }
      if (paramInt1 == 21)
      {
        String[] arrayOfString = paramIntent.getStringArrayExtra("image_url_array");
        boolean bool = paramIntent.getBooleanExtra("image_origin_flag", false);
        if ((arrayOfString != null) && (arrayOfString.length > 0))
        {
          paramInt1 = i1;
          while (paramInt1 < arrayOfString.length)
          {
            a(g.a().a(arrayOfString[paramInt1]), Boolean.valueOf(bool));
            paramInt1 += 1;
          }
        }
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (com.xiaoenai.app.utils.ab.d() > 0) {
      getWindow().setSoftInputMode(18);
    }
    com.xiaoenai.app.utils.f.a.c("keyboard height = {}", new Object[] { Integer.valueOf(com.xiaoenai.app.utils.ab.d()) });
    super.onCreate(paramBundle);
    paramBundle = new IntentFilter();
    paramBundle.addAction(SocketManager.a);
    paramBundle.addAction("messageList_change");
    paramBundle.addAction("send_location_action");
    registerReceiver(this.i, paramBundle, getString(2131101650), null);
    c.a().a(112);
    this.f = 1;
    c(2);
    C();
    this.o = getIntent().getIntExtra("action", 0);
    if (com.xiaoenai.app.classes.chat.messagelist.a.a().j() > 0) {
      v();
    }
    com.xiaoenai.app.utils.b.b();
  }
  
  protected void onDestroy()
  {
    if (this.m != null)
    {
      this.m.h();
      this.m.q();
    }
    unregisterReceiver(this.i);
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if ((this.m != null) && (this.m.k())) {}
      while (q()) {
        return true;
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    c.a().a(112);
  }
  
  protected void onPause()
  {
    super.onPause();
    this.s = true;
    c = false;
  }
  
  protected void onResume()
  {
    super.onResume();
    this.g.a();
    w();
    q();
    if (this.s)
    {
      this.l.e();
      this.s = false;
    }
    c = true;
    c(SocketManager.a().f());
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (!Xiaoenai.j().o()) {
      super.onSensorChanged(paramSensorEvent);
    }
    f();
  }
  
  public void p()
  {
    this.u = true;
    this.m.h();
    this.m.j();
    this.m.i();
    this.m.q();
    if (this.t == null) {
      this.t = new an();
    }
    if (!this.t.isAdded())
    {
      FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
      localFragmentTransaction.replace(2131558757, this.t);
      localFragmentTransaction.commitAllowingStateLoss();
    }
    this.g.b(2130839006, 0);
  }
  
  public boolean q()
  {
    boolean bool2 = false;
    this.u = false;
    boolean bool1 = bool2;
    if (this.t != null)
    {
      bool1 = bool2;
      if (this.t.isAdded())
      {
        FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
        localFragmentTransaction.remove(this.t);
        localFragmentTransaction.commitAllowingStateLoss();
        this.g.b(2130839002, 0);
        this.t = null;
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void s()
  {
    startActivityForResult(new Intent(this, AddStatusActivity.class), 124);
    overridePendingTransition(2130968604, 2130968605);
  }
  
  public void t()
  {
    Intent localIntent = new Intent(this, ChangeBgActivity.class);
    localIntent.setAction("chat_to_bg_action");
    startActivityForResult(localIntent, 125);
    overridePendingTransition(2130968604, 2130968605);
  }
  
  public void u()
  {
    Intent localIntent = new Intent(this, ColorPickerActivity.class);
    localIntent.putExtra("mode", "chat");
    startActivityForResult(localIntent, 126);
  }
  
  public void v()
  {
    this.j.post(new ai(this));
  }
  
  public void w()
  {
    ((NotificationManager)getSystemService("notification")).cancel(1000);
    com.xiaoenai.app.service.MessageService.a = 0;
    UserConfig.setInt("receive_new_msg_count", 0);
  }
  
  public void x()
  {
    if (this.l != null) {
      UserConfig.setInt("lstTimestamp", this.l.f());
    }
  }
  
  public class ChatReceiver
    extends BroadcastReceiver
  {
    public ChatReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      if (paramContext == null) {}
      do
      {
        int i;
        int j;
        do
        {
          return;
          if (paramContext.equals(SocketManager.a))
          {
            ChatActivity.a(ChatActivity.this, SocketManager.a().f());
            return;
          }
          if (!paramContext.equals("messageList_change")) {
            break;
          }
          ChatActivity.d(ChatActivity.this);
          i = paramIntent.getIntExtra("selection", -2);
          if (i != -2)
          {
            if (i == -1)
            {
              ChatActivity.c(ChatActivity.this).setSelection(ChatActivity.e(ChatActivity.this).getCount());
              return;
            }
            ChatActivity.c(ChatActivity.this).setSelection(i);
            return;
          }
          i = ChatActivity.c(ChatActivity.this).getLastVisiblePosition();
          j = ChatActivity.c(ChatActivity.this).getFirstVisiblePosition();
        } while (ChatActivity.e(ChatActivity.this).getCount() - i > i - j);
        ChatActivity.c(ChatActivity.this).setSelection(ChatActivity.e(ChatActivity.this).getCount());
        return;
      } while ((paramContext.equals("unbindAction")) || (!paramContext.equals("send_location_action")));
      ChatActivity.this.o();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\ChatActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */