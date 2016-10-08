package com.alibaba.nb.android.trade.constants;

public class AliTradeREUrlsConstants
{
  public static final String[] RE_ADDCART_URLS;
  public static final String[] RE_ADD_PARAM_URLS;
  public static final String[] RE_ALIPAY_URLS;
  public static final String[] RE_DETAIL_URLS = { "^http(s)?://h5\\.(.*)\\.taobao.com/cm/snap/index\\.html(.*)", "^http(s)?://h5\\.(.*)\\.taobao\\.com/awp/core/detail\\.htm(.*)", "^http(s)?://detail\\.(.*)\\.tmall\\.(com|hk)/item\\.htm(.*)" };
  public static final String[] RE_LOGIN_URLS = { "^http(s)?://login\\.(.*)\\.taobao.com/login\\.htm(.*)$", "^http(s)?://login\\.tmall\\.com(.*)$", "^http(s)?://login.taobao.com/member/login.jhtml(.*)$" };
  public static final String[] RE_LOGOUT_URLS = { "^http(s)?://login\\.(.*)\\.taobao\\.com/logout(.*)$" };
  public static final String[] RE_SHOP_URLS;
  public static final String[] RE_TBOPEN_URLS = { "^tbopen://m.taobao\\.com/tbopen/index\\.html(.*)$" };
  
  static
  {
    RE_ALIPAY_URLS = new String[] { "^http(s)?://(maliprod|mclient)\\.alipay\\.com/w/(trade_pay|batch_payment)\\.do(.*)$", "^http(s)?://(mobileclientgw|maliprod)\\.stable\\.alipay\\.net/w/(trade_pay|batch_payment)\\.do(.*)$", "^http(s)?://(maliprod|mclient)\\.alipay\\.com/(trade_pay|batch_payment)\\.do(.*)$", "^http(s)?://(mobileclientgw|maliprod)\\.stable\\.alipay\\.net/(trade_pay|batch_payment)\\.do(.*)$" };
    RE_ADD_PARAM_URLS = new String[] { "^http(s)?://h5\\.(.*)\\.taobao\\.com/cm/snap/index\\.html(.*)", "^http(s)?://h5\\.(.*)\\.taobao\\.com/awp/base/order\\.htm(.*)", "^http(s)?://h5\\.(.*)\\.taobao\\.com/awp/base/cart\\.htm(.*)", "^http(s)?://h5\\.(.*)\\.taobao\\.com/awp/base/bag\\.htm(.*)", "^http(s)?://h5\\.(.*)\\.taobao\\.com/mlapp/cart\\.htm(.*)", "^http(s)?://h5\\.(.*)\\.taobao\\.com/cart/order\\.htm(.*)", "^http(s)?://h5\\.(.*)\\.taobao\\.com/awp/core/detail\\.htm(.*)", "^http(s)?://h5\\.(.*)\\.taobao\\.com/mlapp/olist\\.htm(.*)", "^http(s)?://shop\\.(.*)\\.taobao\\.com/shop/shopIndex\\.htm(.*)", "^http(s)?://shop\\.(.*)\\.taobao\\.com/shop/shop_index\\.htm(.*)", "^http(s)?://detail\\.(.*)\\.tmall\\.(com|hk)/item\\.htm(.*)", "^http(s)?://buy\\.(.*)\\.tmall\\.(com|hk)/order/confirmOrderWap\\.htm(.*)", "^http(s)?://((?!(login|buy|s.click))\\.)(.*)\\.tmall\\.com(.*)$", "^http(s)?://buy\\.(.*)\\.tmall\\.(com|hk)/order/confirm_order_wap\\.htm(.*)", "^http(s)?://cart\\.(.*)\\.tmall\\.(com|hk)/cart/myCart\\.htm(.*)", "^http(s)?://h5\\.(.*)\\.tmall\\.(com|hk)/awp/base/order\\.htm(.*)", "^http(s)?://h5\\.(.*)\\.tmall\\.(com|hk)/cart/order\\.htm(.*)" };
    RE_ADDCART_URLS = new String[] { "^http(s)?://h5\\.(.*)\\.taobao\\.com/baichuanWebViewBridge?(.*)addCart=success(.*)$" };
    RE_SHOP_URLS = new String[] { "^http(s)?://shop\\.(.*)\\.taobao.com/shop/shop_index.htm(.*)", "^http(s)?://shop\\.(.*)\\.tmall.com/shop/shop_index.htm(.*)" };
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\constants\AliTradeREUrlsConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */