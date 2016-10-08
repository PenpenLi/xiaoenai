package com.taobao.applink.util;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.taobao.applink.appinfo.TBAppInfo;
import com.taobao.applink.jsbridge.adapter.TBBridgeAdapter;
import com.taobao.applink.webviewclient.TBBridgeWebViewClient;

public class TBAppLinkJsBridgeUtil
{
  public static final String BRIDGE_AUTH_CALLBACK_FALSE = "{\"result\":false}";
  public static final String BRIDGE_AUTH_CALLBACK_TRUE = "{\"result\":true,\"mixedNick\":\"%s\",\"icon\":\"%s\"}";
  public static final String BRIDGE_HANDLER_NAME = "TBAppLink";
  public static final String BRIDGE_JS_FILEPATH = "TBAppLinkJsBridge.js";
  public static final String BRIDGE_JUMP_CALLBACK_FALSE = "{\"result\":false}";
  public static final String BRIDGE_JUMP_CALLBACK_TRUE = "{\"result\":true}";
  public static final String CALLBACK_ID_FORMAT = "JAVA_CB_%s";
  public static final String EMPTY_STR = "";
  public static final String JS_APP_INFO = "window.applinkInfo ={sdkVersion:\"%s\",system:\"%s\",device:\"%s\",taoVersion:\"%s\"};";
  public static final String JS_FETCH_QUEUE_FROM_JAVA = "javascript:TBAppLinkJsBridge._fetchQueue();";
  public static final String JS_HANDLE_MESSAGE_FROM_JAVA = "javascript:TBAppLinkJsBridge._handleMessageFromNative(\"%s\");";
  public static final String SPLIT_MARK = "/";
  public static final String TB_FETCHQUEUE = "tblink://return/_fetchQueue/";
  public static final String TB_OVERRIDE_SCHEMA = "tblink://";
  public static final String TB_RETURN_DATA = "tblink://return/";
  public static final String UNDERLINE_STR = "_";
  
  /* Error */
  public static String assetFile2Str(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_3
    //   3: astore_2
    //   4: aload_0
    //   5: ifnull +12 -> 17
    //   8: aload_1
    //   9: invokestatic 68	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifeq +7 -> 19
    //   15: aload_3
    //   16: astore_2
    //   17: aload_2
    //   18: areturn
    //   19: aload_0
    //   20: invokevirtual 74	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   23: aload_1
    //   24: invokevirtual 80	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   27: astore_0
    //   28: aload_0
    //   29: astore_1
    //   30: new 82	java/io/BufferedReader
    //   33: dup
    //   34: new 84	java/io/InputStreamReader
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 87	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   42: invokespecial 90	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   45: astore_2
    //   46: aload_0
    //   47: astore_1
    //   48: new 92	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   55: astore 4
    //   57: aload_0
    //   58: astore_1
    //   59: aload_2
    //   60: invokevirtual 97	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   63: astore 5
    //   65: aload 5
    //   67: ifnull +25 -> 92
    //   70: aload_0
    //   71: astore_1
    //   72: aload 5
    //   74: ldc 99
    //   76: invokevirtual 105	java/lang/String:matches	(Ljava/lang/String;)Z
    //   79: ifne +13 -> 92
    //   82: aload_0
    //   83: astore_1
    //   84: aload 4
    //   86: aload 5
    //   88: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload 5
    //   94: ifnonnull -37 -> 57
    //   97: aload_0
    //   98: astore_1
    //   99: aload_2
    //   100: invokevirtual 112	java/io/BufferedReader:close	()V
    //   103: aload_0
    //   104: astore_1
    //   105: aload_0
    //   106: invokevirtual 115	java/io/InputStream:close	()V
    //   109: aload_0
    //   110: astore_1
    //   111: aload 4
    //   113: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: astore_2
    //   117: aload_2
    //   118: astore_1
    //   119: aload_1
    //   120: astore_2
    //   121: aload_0
    //   122: ifnull -105 -> 17
    //   125: aload_0
    //   126: invokevirtual 115	java/io/InputStream:close	()V
    //   129: aload_1
    //   130: areturn
    //   131: astore_0
    //   132: ldc 120
    //   134: aload_0
    //   135: invokevirtual 121	java/io/IOException:toString	()Ljava/lang/String;
    //   138: invokestatic 127	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   141: pop
    //   142: aload_1
    //   143: areturn
    //   144: astore_2
    //   145: aconst_null
    //   146: astore_0
    //   147: aload_0
    //   148: astore_1
    //   149: ldc 120
    //   151: aload_2
    //   152: invokevirtual 128	java/lang/Throwable:toString	()Ljava/lang/String;
    //   155: invokestatic 127	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   158: pop
    //   159: aload_3
    //   160: astore_2
    //   161: aload_0
    //   162: ifnull -145 -> 17
    //   165: aload_0
    //   166: invokevirtual 115	java/io/InputStream:close	()V
    //   169: aconst_null
    //   170: areturn
    //   171: astore_0
    //   172: ldc 120
    //   174: aload_0
    //   175: invokevirtual 121	java/io/IOException:toString	()Ljava/lang/String;
    //   178: invokestatic 127	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   181: pop
    //   182: aconst_null
    //   183: areturn
    //   184: astore_0
    //   185: aconst_null
    //   186: astore_1
    //   187: aload_1
    //   188: ifnull +7 -> 195
    //   191: aload_1
    //   192: invokevirtual 115	java/io/InputStream:close	()V
    //   195: aload_0
    //   196: athrow
    //   197: astore_1
    //   198: ldc 120
    //   200: aload_1
    //   201: invokevirtual 121	java/io/IOException:toString	()Ljava/lang/String;
    //   204: invokestatic 127	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   207: pop
    //   208: goto -13 -> 195
    //   211: astore_0
    //   212: goto -25 -> 187
    //   215: astore_2
    //   216: goto -69 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	paramContext	android.content.Context
    //   0	219	1	paramString	String
    //   3	118	2	localObject1	Object
    //   144	8	2	localThrowable1	Throwable
    //   160	1	2	localObject2	Object
    //   215	1	2	localThrowable2	Throwable
    //   1	159	3	localObject3	Object
    //   55	57	4	localStringBuilder	StringBuilder
    //   63	30	5	str	String
    // Exception table:
    //   from	to	target	type
    //   125	129	131	java/io/IOException
    //   19	28	144	java/lang/Throwable
    //   165	169	171	java/io/IOException
    //   19	28	184	finally
    //   191	195	197	java/io/IOException
    //   30	46	211	finally
    //   48	57	211	finally
    //   59	65	211	finally
    //   72	82	211	finally
    //   84	92	211	finally
    //   99	103	211	finally
    //   105	109	211	finally
    //   111	117	211	finally
    //   149	159	211	finally
    //   30	46	215	java/lang/Throwable
    //   48	57	215	java/lang/Throwable
    //   59	65	215	java/lang/Throwable
    //   72	82	215	java/lang/Throwable
    //   84	92	215	java/lang/Throwable
    //   99	103	215	java/lang/Throwable
    //   105	109	215	java/lang/Throwable
    //   111	117	215	java/lang/Throwable
  }
  
  public static String getDataFromReturnUrl(String paramString)
  {
    if (paramString.startsWith("tblink://return/_fetchQueue/")) {
      return paramString.replace("tblink://return/_fetchQueue/", "");
    }
    paramString = paramString.replace("tblink://return/", "").split("/");
    if (paramString.length >= 2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 1;
      while (i < paramString.length)
      {
        localStringBuilder.append(paramString[i]);
        i += 1;
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static String getFunctionFromReturnUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = paramString.replace("tblink://return/", "").split("/");
    } while (paramString.length < 1);
    return paramString[0];
  }
  
  public static String parseFunctionName(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return paramString.replace("javascript:TBAppLinkJsBridge.", "").replaceAll("\\(.*\\);", "");
  }
  
  public static void registerBridgeHandler(WebView paramWebView, TBBridgeWebViewClient paramTBBridgeWebViewClient)
  {
    if ((paramWebView == null) || (paramTBBridgeWebViewClient == null)) {}
    do
    {
      return;
      paramTBBridgeWebViewClient = paramTBBridgeWebViewClient.getTBBridgeAdapter();
    } while (paramTBBridgeWebViewClient == null);
    paramTBBridgeWebViewClient.registerHandler(paramWebView, "TBAppLink", new TBAppLinkJsBridgeUtil.1(paramWebView));
  }
  
  public static void webViewLoadAppInfo(WebView paramWebView)
  {
    try
    {
      webViewLoadJs(paramWebView, String.format("window.applinkInfo ={sdkVersion:\"%s\",system:\"%s\",device:\"%s\",taoVersion:\"%s\"};", new Object[] { "1.0", String.valueOf("ANDROID " + Build.VERSION.SDK_INT), String.valueOf(Build.MODEL), TBAppInfo.getTaoVersion(paramWebView.getContext()) }));
      return;
    }
    catch (Throwable paramWebView)
    {
      Log.d("AppLink", paramWebView.toString());
    }
  }
  
  public static void webViewLoadJs(WebView paramWebView, String paramString)
  {
    if ((paramWebView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramWebView.loadUrl("javascript:" + paramString);
  }
  
  public static void webViewLoadLocalJs(WebView paramWebView)
  {
    if ((paramWebView == null) || (TextUtils.isEmpty("TBAppLinkJsBridge.js"))) {
      return;
    }
    String str = assetFile2Str(paramWebView.getContext(), "TBAppLinkJsBridge.js");
    paramWebView.loadUrl("javascript:" + str);
  }
  
  public static void webViewLoadStringJs(WebView paramWebView, String paramString)
  {
    if ((paramWebView == null) || (TBAppLinkStringUtil.isBlank(paramString))) {
      return;
    }
    paramWebView.loadUrl("javascript:" + paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\util\TBAppLinkJsBridgeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */