package com.xiaoenai.app.classes.chat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.widget.gif.ArtworkGifView;

public class GifPlayerActivity
  extends TitleBarActivity
{
  private ArtworkGifView a;
  private LinearLayout b;
  private boolean c;
  
  public int a()
  {
    return 2130903094;
  }
  
  public void a_(int paramInt)
  {
    super.a_(paramInt);
    overridePendingTransition(2130968597, 2130968596);
  }
  
  public void c()
  {
    if (this.a != null) {
      this.a.i();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.f = 0;
    overridePendingTransition(2130968595, 2130968597);
    this.b = ((LinearLayout)findViewById(2131558768));
    this.a = new ArtworkGifView(this);
    paramBundle = new LinearLayout.LayoutParams(-2, -2);
    this.a.setLayoutParams(paramBundle);
    this.b.addView(this.a);
    paramBundle = getIntent();
    if ((paramBundle != null) && (paramBundle.getAction() != null) && (paramBundle.getAction().equals("gifPlayerAction")))
    {
      paramBundle = paramBundle.getStringExtra("gifPath");
      b.a(this.a, paramBundle, new as(this, paramBundle));
    }
  }
  
  protected void onDestroy()
  {
    c();
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    this.c = true;
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.c)
    {
      this.a.e();
      this.a.f();
      this.c = false;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\GifPlayerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */