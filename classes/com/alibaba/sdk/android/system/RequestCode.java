package com.alibaba.sdk.android.system;

import com.alibaba.sdk.android.util.CodeAllocator;

public class RequestCode
{
  public static int OPEN_CART = CodeAllocator.allocateRequestCode("OPEN_CART");
  public static int OPEN_H5_LOGIN;
  public static int OPEN_H5_TRADE;
  public static int OPEN_OPENACCOUNT = CodeAllocator.allocateRequestCode("OPEN_OPENACCOUNT");
  public static int OPEN_PAY;
  public static int OPEN_QR_LOGIN = CodeAllocator.allocateRequestCode("OPEN_QR_LOGIN");
  public static int OPEN_QR_LOGIN_CONFIRM = CodeAllocator.allocateRequestCode("OPEN_QR_LOGIN_CONFIRM");
  public static int OPEN_TAOBAO;
  public static int OPEN_YUNOS = CodeAllocator.allocateRequestCode("OPEN_YUNOS");
  
  static
  {
    OPEN_TAOBAO = CodeAllocator.allocateRequestCode("OPEN_TAOBAO");
    OPEN_H5_LOGIN = CodeAllocator.allocateRequestCode("OPEN_H5_LOGIN");
    OPEN_H5_TRADE = CodeAllocator.allocateRequestCode("OPEN_H5_TRADE");
    OPEN_PAY = CodeAllocator.allocateRequestCode("OPEN_PAY");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\system\RequestCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */