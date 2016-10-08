package com.pingplusplus.android;

import com.baidu.android.pay.PayCallBack;

class b
  implements PayCallBack
{
  b(PaymentActivity paramPaymentActivity) {}
  
  public boolean isHideLoadingDialog()
  {
    return false;
  }
  
  public void onPayResult(int paramInt, String paramString)
  {
    PaymentActivity.a(this.a, 0);
    PaymentActivity.a(this.a, paramInt, paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\pingplusplus\android\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */