package com.xiaoenai.app.classes.street.guide;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.nb.android.trade.AliTradeSDK;
import com.alibaba.nb.android.trade.uibridge.AliTradeMyCartsPage;
import com.alibaba.nb.android.trade.uibridge.AliTradeMyOrdersPage;
import com.alibaba.nb.android.trade.uibridge.IAliTradeService;
import com.alibaba.sdk.android.AlibabaHelper;
import com.alibaba.sdk.android.AlibabaSDK;
import com.alibaba.sdk.android.callback.CallbackContext;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.settings.bj;
import com.xiaoenai.app.widget.TitleBarView;

public class StreetTaeAuthorizationActivity
  extends TitleBarActivity
{
  private int a = 0;
  @BindView(2131559879)
  Button mAuthorizationBtn;
  @BindView(2131558577)
  ImageView mIconImg;
  @BindView(2131559878)
  TextView mTipTxt;
  
  private void c()
  {
    Intent localIntent = getIntent();
    if (localIntent != null) {
      this.a = localIntent.getIntExtra("street_author_type", 0);
    }
    if (this.a == 1)
    {
      this.g.setTitle(2131101391);
      this.mIconImg.setImageResource(2130838948);
      this.mTipTxt.setText(2131101500);
      return;
    }
    this.g.setTitle(2131101364);
    this.mIconImg.setImageResource(2130838947);
    this.mTipTxt.setText(2131101498);
  }
  
  private void d()
  {
    bj.a().a(this, new j(this));
  }
  
  private void f()
  {
    finish();
    if (this.a == 0)
    {
      g();
      return;
    }
    h();
  }
  
  private void g()
  {
    ((IAliTradeService)AliTradeSDK.getService(IAliTradeService.class)).show(this, new AliTradeMyCartsPage(), AlibabaHelper.creatAliTradeShowParams(), null, null, new k(this));
  }
  
  private void h()
  {
    ((IAliTradeService)AlibabaSDK.getService(IAliTradeService.class)).show(this, new AliTradeMyOrdersPage(0, true), AlibabaHelper.creatAliTradeShowParams(), null, null, new l(this));
  }
  
  public int a()
  {
    return 2130903343;
  }
  
  @OnClick({2131559879})
  void authorization()
  {
    d();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    CallbackContext.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ButterKnife.bind(this);
    c();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\guide\StreetTaeAuthorizationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */