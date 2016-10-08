package com.xiaoenai.app.common.view.activity;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.xiaoenai.app.common.application.BaseApplication;
import com.xiaoenai.app.common.internal.di.a.b;
import com.xiaoenai.app.common.internal.di.a.c;
import com.xiaoenai.app.common.internal.di.a.c.a;
import javax.inject.Inject;

public class BaseActivity
  extends FragmentActivity
{
  private com.xiaoenai.app.common.internal.di.a.a a;
  private final String b = getClass().getSimpleName();
  @Inject
  protected com.xiaoenai.app.common.a p;
  @Inject
  protected com.xiaoenai.app.common.view.b.a q;
  @Inject
  protected com.xiaoenai.app.common.application.a.a r;
  
  public com.xiaoenai.app.common.internal.di.b.a A()
  {
    return new com.xiaoenai.app.common.internal.di.b.a(this);
  }
  
  public com.xiaoenai.app.common.internal.di.a.a B()
  {
    return this.a;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void l()
  {
    this.a = c.c().a(z()).a(A()).a();
    this.a.a(this);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.xiaoenai.app.utils.f.a.c("{}:onActivityResult requestCode={} resultCode={} data={}", new Object[] { this.b, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    l();
    super.onCreate(paramBundle);
    com.xiaoenai.app.utils.f.a.c("{}:onCreate#1", new Object[] { this.b });
    this.q.a(this, paramBundle);
    this.p.a(this);
    if (Build.VERSION.SDK_INT >= 11) {
      requestWindowFeature(10);
    }
  }
  
  public void onCreate(Bundle paramBundle, PersistableBundle paramPersistableBundle)
  {
    super.onCreate(paramBundle, paramPersistableBundle);
    com.xiaoenai.app.utils.f.a.c("{}:onCreate#2", new Object[] { this.b });
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    com.xiaoenai.app.utils.f.a.c("{}:onDestroy", new Object[] { this.b });
    this.p.d(this);
    this.q.e(this);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    com.xiaoenai.app.utils.f.a.c("{}:onDetachedFromWindow", new Object[] { this.b });
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    com.xiaoenai.app.utils.f.a.c("{}:onLowMemory", new Object[] { this.b });
    this.q.f(this);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    com.xiaoenai.app.utils.f.a.c("{}:onNewIntent", new Object[] { this.b });
  }
  
  protected void onPause()
  {
    super.onPause();
    this.q.d(this);
    com.xiaoenai.app.utils.f.a.c("{}:onPause", new Object[] { this.b });
  }
  
  protected void onRestart()
  {
    super.onRestart();
    this.q.g(this);
    com.xiaoenai.app.utils.f.a.c("{}:onRestart", new Object[] { this.b });
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    com.xiaoenai.app.utils.f.a.c("{}:onRestoreInstanceState", new Object[] { this.b });
  }
  
  protected void onResume()
  {
    super.onResume();
    this.q.c(this);
    this.p.e(this);
    com.xiaoenai.app.utils.f.a.c("{}:onResume", new Object[] { this.b });
  }
  
  protected void onResumeFragments()
  {
    super.onResumeFragments();
    com.xiaoenai.app.utils.f.a.c("{}:onResumeFragments", new Object[] { this.b });
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    com.xiaoenai.app.utils.f.a.c("{}:onSaveInstanceState", new Object[] { this.b });
  }
  
  protected void onStart()
  {
    super.onStart();
    this.q.a(this);
    com.xiaoenai.app.utils.f.a.c("{}:onStart", new Object[] { this.b });
  }
  
  protected void onStop()
  {
    super.onStop();
    com.xiaoenai.app.utils.f.a.c("{}:onStop", new Object[] { this.b });
    this.q.b(this);
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    super.setContentView(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setContentView(paramView, paramLayoutParams);
  }
  
  public void startActivity(Intent paramIntent)
  {
    com.xiaoenai.app.utils.f.a.c("{}:startActivity", new Object[] { this.b });
    this.q.a(this, paramIntent);
    super.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    com.xiaoenai.app.utils.f.a.c("{}:startActivityForResult", new Object[] { this.b });
    this.q.a(this, paramIntent, paramInt, paramBundle);
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  protected b z()
  {
    return ((BaseApplication)getApplication()).z();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\common\view\activity\BaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */