package com.xiaoenai.app.classes.extentions.reward;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.extentions.reward.model.BaseTask;
import com.xiaoenai.app.net.l;
import com.xiaoenai.app.stat.c;
import com.xiaoenai.app.ui.component.view.ProgressView;
import java.util.List;

public class RewardActivity
  extends TitleBarActivity
{
  private ListView a;
  private List<BaseTask> b;
  private ProgressView c;
  private b i;
  
  private void d()
  {
    new l(new a(this, this)).r();
  }
  
  public int a()
  {
    return 2130903178;
  }
  
  public void c()
  {
    this.a = ((ListView)findViewById(2131559134));
    this.i = new b(null, this);
    this.a.setAdapter(this.i);
    this.c = ((ProgressView)findViewById(2131558669));
    d();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c.a().a(107);
    c();
    this.f = 2;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    c.a().a(107);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\reward\RewardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */