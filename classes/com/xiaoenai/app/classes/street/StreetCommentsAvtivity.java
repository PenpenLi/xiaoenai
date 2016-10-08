package com.xiaoenai.app.classes.street;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.xiaoenai.app.classes.street.a.b;
import com.xiaoenai.app.classes.street.model.Comment;
import com.xiaoenai.app.net.ae;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.widget.TitleBarView;
import java.util.ArrayList;
import org.json.JSONArray;

public class StreetCommentsAvtivity
  extends StreetBaseActivity
{
  private int a = 0;
  private PullToRefreshListView b;
  private b c;
  private boolean i = false;
  private boolean j = false;
  
  private void a(int paramInt)
  {
    if (this.j) {
      this.j = false;
    }
    this.b.k();
    this.i = false;
    this.c.a(true);
  }
  
  private void a(JSONArray paramJSONArray)
  {
    paramJSONArray = Comment.getCommentList(paramJSONArray);
    c(paramJSONArray.size());
    if (this.j) {
      this.c.a(paramJSONArray);
    }
    for (;;)
    {
      this.j = false;
      this.i = false;
      return;
      this.c.b(paramJSONArray);
    }
  }
  
  private void c()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("product_id", this.a);
    localIntent.setClass(this, StreetCommentProductActitvity.class);
    startActivityForResult(localIntent, 1);
    overridePendingTransition(2130968604, 2130968605);
  }
  
  private void c(int paramInt)
  {
    if (paramInt < 20) {
      this.c.a(false);
    }
  }
  
  private void d()
  {
    this.b = ((PullToRefreshListView)findViewById(2131559836));
    this.c = new b(this);
    this.b.setAdapter(this.c);
    ListView localListView = (ListView)this.b.getRefreshableView();
    localListView.setDivider(getResources().getDrawable(2130839103));
    localListView.setDividerHeight(1);
  }
  
  private void f()
  {
    this.b.setOnRefreshListener(new ap(this));
    this.b.setOnLastItemVisibleListener(new aq(this));
  }
  
  private void g()
  {
    if (this.i) {
      return;
    }
    this.j = true;
    this.c.a(true);
    j();
  }
  
  private void h()
  {
    if (this.i) {}
    while (!this.c.b()) {
      return;
    }
    j();
  }
  
  private void i()
  {
    new ae(new ar(this, this)).b(this.a);
  }
  
  private void j()
  {
    if (this.i) {
      return;
    }
    ae localae = new ae(new as(this, this));
    if (this.j)
    {
      localae.a(this.a, 0, 20, 0);
      return;
    }
    int k = this.c.a();
    Comment localComment = this.c.a(k - 1);
    localae.a(this.a, localComment.getId(), 20, this.c.a());
  }
  
  public int a()
  {
    return 2130903337;
  }
  
  protected void b()
  {
    super.b();
    this.g.setRightButtonClickListener(new ao(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 != 1) {
        break label31;
      }
      h.a(this, 2131100705, 1500L);
      g();
    }
    label31:
    while (paramInt1 != 100) {
      return;
    }
    h.a(this, 2131100822, 1500L);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle != null) {
      this.a = paramBundle.getIntExtra("product_id", 0);
    }
    d();
    f();
    g();
  }
  
  public void r()
  {
    setResult(-1);
    super.r();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\StreetCommentsAvtivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */