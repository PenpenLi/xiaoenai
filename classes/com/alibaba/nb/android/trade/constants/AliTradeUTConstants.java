package com.alibaba.nb.android.trade.constants;

import com.alibaba.nb.android.trade.AliTradeContext;

public class AliTradeUTConstants
{
  public static final String APPKEY = "appkey";
  public static final String APP_VERSION = "app_version";
  public static final String E_ADDITEM2CART;
  public static final String E_ADDTAOKEITEM2CART = "api_addTaoKeItem2Cart";
  public static final String E_GETSERVICE = "api_getService";
  public static final String E_ONESDK_INIT;
  public static final String E_SDK_GETUTDID = "sdk_getUtdid";
  public static final String E_SDK_INIT;
  public static final String E_SDK_INIT_RESULT = "sdk_init_result";
  public static final String E_SDK_PLUGIN_START_FAILURE = "sdk_plugin_start_failure";
  public static final String E_SDK_PLUGIN_START_SUCCESS = "sdk_plugin_start_success";
  public static final String E_SHOW = "api_show_aliTradesdk_" + AliTradeContext.sdkVersion;
  public static final String E_SHOWCART;
  public static final String E_SHOWETICKETDETAIL = "api_showETicketDetail";
  public static final String E_SHOWITEMDETAIL;
  public static final String E_SHOWLOGIN = "api_loginSuccess_aliTradesdk_" + AliTradeContext.sdkVersion;
  public static final String E_SHOWORDER;
  public static final String E_SHOWORDERWITHSKU = "api_showOrderWithSKU";
  public static final String E_SHOWPAGE;
  public static final String E_SHOWSHOP;
  public static final String E_SHOWTAOKEORDER = "api_showTaokeOrder";
  public static final String E_SHOWTAOKEORDERWITHSKU = "api_showTaokeOrderWithSKU";
  public static final String E_SHOWTAOKETVORDERWITHSKU = "api_showTaokeTvOrderWithSKU";
  public static final String E_SHOW_APPLINK = "api_applink_aliTradesdk_" + AliTradeContext.sdkVersion;
  public static final String FROM = "from";
  public static final String FROM_VALUE = "nbsdk";
  public static final String IS_SUCCESS = "isSuccess";
  public static final String PARAM = "param";
  public static final String SDK_TYPE = "sdkType";
  public static final String SDK_TYPE_STANDARD = "standard";
  public static final String TAOKEPARAMS = "taokeParam";
  public static final String TRACKER_ID = "aliTradesdk";
  public static final String TYPE_INIT_FAILED = "initFailed";
  public static final String TYPE_INIT_SUCCESS = "initSuccess";
  public static final String USERID = "userId";
  public static final String USER_ID = "user_id";
  public static final String USER_NICK = "user_nick";
  public static final String UTDID = "utdid";
  public static final String YBHPSS = "ybhpss";
  
  static
  {
    E_SDK_INIT = "api_sdkInit_aliTradesdk_" + AliTradeContext.sdkVersion;
    E_ONESDK_INIT = "api_onesdkInit_aliTradesdk_" + AliTradeContext.sdkVersion;
    E_SHOWCART = "api_showCart_aliTradesdk_" + AliTradeContext.sdkVersion;
    E_ADDITEM2CART = "api_addItem2Cart_aliTradesdk_" + AliTradeContext.sdkVersion;
    E_SHOWORDER = "api_showOrder_aliTradesdk_" + AliTradeContext.sdkVersion;
    E_SHOWSHOP = "api_showShop_aliTradesdk_" + AliTradeContext.sdkVersion;
    E_SHOWITEMDETAIL = "api_showItemDetail_aliTradesdk_" + AliTradeContext.sdkVersion;
    E_SHOWPAGE = "api_showPage_aliTradesdk_" + AliTradeContext.sdkVersion;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\constants\AliTradeUTConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */