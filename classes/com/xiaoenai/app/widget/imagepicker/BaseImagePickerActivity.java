package com.xiaoenai.app.widget.imagepicker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.ui.a.g;
import com.xiaoenai.app.utils.d.w;
import com.xiaoenai.app.widget.TitleBarView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseImagePickerActivity
  extends TitleBarActivity
{
  private GridView a;
  private s b;
  private TextView c;
  private TextView i;
  private ListView j;
  private o k;
  private int l = 1;
  private ImageDataManager m;
  private a n;
  private int o = 2;
  private int s = -1;
  private int t = -1;
  private boolean u = true;
  private int v = -1;
  
  private void a(int paramInt)
  {
    if (paramInt == 0) {
      if (this.o == 1)
      {
        this.i.setText(2131101071);
        this.c.setClickable(false);
        this.c.setTextColor(getResources().getColor(2131492875));
        this.c.setBackgroundResource(2130837599);
        this.i.setClickable(false);
        this.i.setTextColor(getResources().getColor(2131492877));
        this.i.setBackgroundResource(2130837604);
      }
    }
    while (paramInt <= 0) {
      for (;;)
      {
        return;
        if (this.o == 2) {
          this.i.setText(2131100610);
        } else if (this.o == 3) {
          this.i.setText(2131100136);
        }
      }
    }
    this.c.setClickable(true);
    this.c.setTextColor(getResources().getColor(2131493073));
    this.c.setBackgroundResource(2130837598);
    this.i.setClickable(true);
    this.i.setTextColor(getResources().getColor(2131493206));
    this.i.setBackgroundResource(2130837603);
    this.i.setText(c(paramInt));
  }
  
  private void a(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("from", -1);
    int[] arrayOfInt;
    boolean bool;
    if (i1 == 3)
    {
      arrayOfInt = paramIntent.getIntArrayExtra("image_select_map");
      bool = paramIntent.getBooleanExtra("image_origin_flag", false);
      a(arrayOfInt);
      this.m.a(bool);
    }
    for (;;)
    {
      this.i.setText(c(this.m.c()));
      if (this.m.c() > 0)
      {
        this.c.setClickable(true);
        this.c.setTextColor(getResources().getColor(2131493073));
      }
      this.b.notifyDataSetChanged();
      return;
      if (i1 == 4)
      {
        arrayOfInt = paramIntent.getIntArrayExtra("image_select_map");
        bool = paramIntent.getBooleanExtra("image_origin_flag", false);
        a(arrayOfInt);
        this.m.a(bool);
      }
    }
  }
  
  private void a(int[] paramArrayOfInt)
  {
    int i1 = 0;
    Object localObject = this.m.d().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ImageEntry)((Iterator)localObject).next()).a(false);
    }
    this.m.d().clear();
    while (i1 < paramArrayOfInt.length)
    {
      if (paramArrayOfInt[i1] != -1)
      {
        this.m.a((ImageEntry)this.m.a().get(paramArrayOfInt[i1]));
        localObject = (ImageEntry)this.m.a().get(paramArrayOfInt[i1]);
        ((ImageEntry)this.m.a().get(((ImageEntry)localObject).c())).a(true);
      }
      i1 += 1;
    }
  }
  
  private String c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.o == 1) {
      localStringBuilder.append(getString(2131101071));
    }
    for (;;)
    {
      if (paramInt > 0)
      {
        localStringBuilder.append("(");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("/");
        localStringBuilder.append(s.a());
        localStringBuilder.append(")");
      }
      return localStringBuilder.toString();
      if (this.o == 2) {
        localStringBuilder.append(getString(2131100610));
      } else if (this.o == 3) {
        localStringBuilder.append(getString(2131100136));
      }
    }
  }
  
  private void c()
  {
    this.f = 2;
    this.a = ((GridView)findViewById(2131558717));
    this.c = ((TextView)findViewById(2131558714));
    this.i = ((TextView)findViewById(2131558715));
    this.o = getIntent().getIntExtra("pick_from", 2);
    this.u = getIntent().getBooleanExtra("original_flag", true);
    this.s = getIntent().getIntExtra("max_selected_size", -1);
    this.v = getIntent().getIntExtra("image_picker_mode", -1);
    if (this.s != -1) {
      s.a(this.s);
    }
    if (this.o == 1) {
      this.i.setText(2131101071);
    }
    for (;;)
    {
      this.t = getIntent().getIntExtra("max_selected_size", -1);
      if (this.t != -1) {
        s.a(this.t);
      }
      d();
      f();
      i();
      return;
      if (this.o == 2)
      {
        this.i.setText(2131100610);
      }
      else if (this.o == 3)
      {
        this.i.setText(2131100136);
        this.g.setTitle(2131100371);
      }
    }
  }
  
  private void d()
  {
    this.b = new s(this, new a(this), this.m, this.o, this.u);
    if (this.v != -1) {
      this.b.b(this.v);
    }
    this.a.setAdapter(this.b);
    this.m.a(new b(this), this);
    this.a.setOnItemClickListener(this.b);
  }
  
  private void f()
  {
    this.c.setClickable(false);
    this.c.setOnClickListener(new f(this));
    this.c.setOnTouchListener(w.a);
  }
  
  private int[] g()
  {
    int[] arrayOfInt = new int[this.m.c()];
    int i1 = 0;
    if (i1 < arrayOfInt.length)
    {
      if ((i1 < this.m.d().size()) && (((ImageEntry)this.m.d().get(i1)).b())) {
        arrayOfInt[i1] = ((ImageEntry)this.m.d().get(i1)).c();
      }
      for (;;)
      {
        i1 += 1;
        break;
        arrayOfInt[i1] = -1;
      }
    }
    return arrayOfInt;
  }
  
  private int[] h()
  {
    int[] arrayOfInt = new int[this.m.c()];
    int i1 = 0;
    while (i1 < arrayOfInt.length)
    {
      arrayOfInt[i1] = ((ImageEntry)this.m.d().get(i1)).c();
      i1 += 1;
    }
    return arrayOfInt;
  }
  
  private void i()
  {
    this.i.setClickable(false);
    this.i.setOnClickListener(new h(this));
    this.i.setOnTouchListener(w.a);
  }
  
  private void j()
  {
    this.j = ((ListView)findViewById(2131558718));
    this.k = new o(null, this);
    this.j.setAdapter(this.k);
  }
  
  private void k()
  {
    List localList = this.m.e();
    if ((localList != null) && (localList.size() > 0))
    {
      this.j.setVisibility(0);
      this.a.setVisibility(8);
      this.g.setLeftButtonVisible(8);
      this.k.a(this.m.e().toArray(), new k(this));
    }
  }
  
  private void o()
  {
    Object localObject = this.m.b();
    if ((localObject == null) || (localObject.length <= 0))
    {
      localObject = new g(this);
      ((g)localObject).setTitle(2131100989);
      ((g)localObject).a(2131100898, new l(this));
      ((g)localObject).show();
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("image_url_array", (String[])localObject);
    localIntent.putExtra("image_origin_flag", this.m.f());
    setResult(-1, localIntent);
    finish();
  }
  
  public int a()
  {
    return 2130903150;
  }
  
  protected void b()
  {
    super.b();
    this.g.setLeftButtonClickListener(new i(this));
    this.g.setRightButtonClickListener(new j(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = false;
    this.m = new ImageDataManager();
    this.n = new a();
    paramBundle = new IntentFilter();
    paramBundle.addAction("merge_action");
    paramBundle.addAction("preview_send_action");
    registerReceiver(this.n, paramBundle);
    c();
    j();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.n != null)
    {
      unregisterReceiver(this.n);
      this.n = null;
    }
    this.m = null;
    this.b.c();
  }
  
  public void r()
  {
    if (this.l == 2)
    {
      super.r();
      return;
    }
    this.l = 2;
    k();
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      if (paramContext != null)
      {
        if (!paramContext.equals("merge_action")) {
          break label27;
        }
        BaseImagePickerActivity.a(BaseImagePickerActivity.this, paramIntent);
      }
      label27:
      while (!paramContext.equals("preview_send_action")) {
        return;
      }
      BaseImagePickerActivity.a(BaseImagePickerActivity.this, paramIntent);
      BaseImagePickerActivity.h(BaseImagePickerActivity.this);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\widget\imagepicker\BaseImagePickerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */