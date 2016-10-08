package com.xiaoenai.app.classes.gameCenter;

import android.os.Bundle;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.common.c.a.d;
import com.xiaoenai.app.classes.common.c.a.e;
import com.xiaoenai.app.classes.gameCenter.a.f;
import com.xiaoenai.app.classes.gameCenter.model.GameEntry;
import com.xiaoenai.app.model.RedHintsInfo;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.widget.AutoViewPager;
import com.xiaoenai.app.widget.ViewPagerInsideListView;
import java.util.List;

public class GameCenterActivity
  extends TitleBarActivity
{
  private ViewPagerInsideListView a;
  private f b;
  private ProgressView c = null;
  private AutoViewPager i;
  private List<GameEntry> j = null;
  
  private GameEntry a(int paramInt)
  {
    if ((this.j != null) && (this.j.size() > 0))
    {
      int k = 0;
      while (k < this.j.size())
      {
        if (((GameEntry)this.j.get(k)).getId() == paramInt) {
          return (GameEntry)this.j.get(k);
        }
        k += 1;
      }
    }
    return null;
  }
  
  private void c()
  {
    this.a = ((ViewPagerInsideListView)findViewById(2131559335));
    this.b = new f(this);
    this.i = new AutoViewPager(this);
    this.a.addHeaderView(this.i);
    this.a.setAdapter(this.b);
    this.c = ((ProgressView)findViewById(2131559336));
  }
  
  private void d()
  {
    new com.xiaoenai.app.net.b(new a(this, this)).b();
  }
  
  private void f()
  {
    List localList = com.xiaoenai.app.widget.remindButton.a.a().b("xiaoenai.discovery.game");
    if ((localList != null) && (localList.size() > 0))
    {
      int k = 0;
      while (k < localList.size())
      {
        RedHintsInfo localRedHintsInfo = (RedHintsInfo)localList.get(k);
        GameEntry localGameEntry = a(Integer.valueOf(new e(localRedHintsInfo.getModule()).a().c).intValue());
        if (localGameEntry != null) {
          localGameEntry.setRedHintsInfo(localRedHintsInfo);
        }
        k += 1;
      }
    }
  }
  
  public int a()
  {
    return 2130903225;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.f = 2;
    super.onCreate(paramBundle);
    c();
    paramBundle = b.a().b();
    if (paramBundle.size() > 0) {
      this.b.a(paramBundle);
    }
    d();
  }
  
  protected void onResume()
  {
    super.onResume();
    if (getRequestedOrientation() != 1) {
      setRequestedOrientation(1);
    }
    if (this.b != null) {
      this.b.a();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\gameCenter\GameCenterActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */