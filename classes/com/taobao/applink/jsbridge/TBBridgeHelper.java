package com.taobao.applink.jsbridge;

import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebView;
import com.taobao.applink.jsbridge.adapter.TBBridgeAdapter;
import com.taobao.applink.jsbridge.adapter.TBBridgeCallBackFunction;
import com.taobao.applink.jsbridge.adapter.TBBridgeHandler;
import com.taobao.applink.util.TBAppLinkJsBridgeUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TBBridgeHelper
  implements TBBridgeAdapter
{
  private TBBridgeHandler defaultHandler = new TBBridgeDefaultHandler();
  private Map<String, TBBridgeHandler> messageHandlers = new HashMap();
  private Map<String, TBBridgeCallBackFunction> responseCallbacks = new HashMap();
  private List<TBBridgeMessage> startupMessage = new ArrayList();
  long uniqueId = 0L;
  
  private void doSend(WebView paramWebView, String paramString1, String paramString2, TBBridgeCallBackFunction paramTBBridgeCallBackFunction)
  {
    TBBridgeMessage localTBBridgeMessage = new TBBridgeMessage();
    if (!TextUtils.isEmpty(paramString2)) {
      localTBBridgeMessage.setData(paramString2);
    }
    if (paramTBBridgeCallBackFunction != null)
    {
      paramString2 = new StringBuilder();
      long l = this.uniqueId + 1L;
      this.uniqueId = l;
      paramString2 = String.format("JAVA_CB_%s", new Object[] { l + "_" + SystemClock.currentThreadTimeMillis() });
      this.responseCallbacks.put(paramString2, paramTBBridgeCallBackFunction);
      localTBBridgeMessage.setCallbackId(paramString2);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      localTBBridgeMessage.setHandlerName(paramString1);
    }
    queueMessage(paramWebView, localTBBridgeMessage);
  }
  
  private void queueMessage(WebView paramWebView, TBBridgeMessage paramTBBridgeMessage)
  {
    if (this.startupMessage != null)
    {
      this.startupMessage.add(paramTBBridgeMessage);
      return;
    }
    dispatchMessage(paramWebView, paramTBBridgeMessage);
  }
  
  public void callHandler(WebView paramWebView, String paramString1, String paramString2, TBBridgeCallBackFunction paramTBBridgeCallBackFunction)
  {
    doSend(paramWebView, paramString1, paramString2, paramTBBridgeCallBackFunction);
  }
  
  public void dispatchMessage(WebView paramWebView, TBBridgeMessage paramTBBridgeMessage)
  {
    paramTBBridgeMessage = String.format("javascript:TBAppLinkJsBridge._handleMessageFromNative(\"%s\");", new Object[] { paramTBBridgeMessage.toJson().replaceAll("(\\\\)([^utrn])", "\\\\\\\\$1$2").replaceAll("(?<=[^\\\\])(\")", "\\\\\"") });
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      paramWebView.loadUrl(paramTBBridgeMessage);
    }
  }
  
  public void flushMessageQueue(WebView paramWebView)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      loadUrl(paramWebView, "javascript:TBAppLinkJsBridge._fetchQueue();", new TBBridgeHelper.1(this, paramWebView));
    }
  }
  
  public void handlerReturnData(WebView paramWebView, String paramString)
  {
    paramWebView = TBAppLinkJsBridgeUtil.getFunctionFromReturnUrl(paramString);
    TBBridgeCallBackFunction localTBBridgeCallBackFunction = (TBBridgeCallBackFunction)this.responseCallbacks.get(paramWebView);
    paramString = TBAppLinkJsBridgeUtil.getDataFromReturnUrl(paramString);
    if (localTBBridgeCallBackFunction != null)
    {
      localTBBridgeCallBackFunction.onCallBack(paramString);
      this.responseCallbacks.remove(paramWebView);
    }
  }
  
  public void initMessageQueue(WebView paramWebView)
  {
    if (this.startupMessage != null)
    {
      Iterator localIterator = this.startupMessage.iterator();
      while (localIterator.hasNext()) {
        dispatchMessage(paramWebView, (TBBridgeMessage)localIterator.next());
      }
      this.startupMessage = null;
    }
  }
  
  public void loadUrl(WebView paramWebView, String paramString, TBBridgeCallBackFunction paramTBBridgeCallBackFunction)
  {
    paramWebView.loadUrl(paramString);
    this.responseCallbacks.put(TBAppLinkJsBridgeUtil.parseFunctionName(paramString), paramTBBridgeCallBackFunction);
  }
  
  public void registerHandler(WebView paramWebView, String paramString, TBBridgeHandler paramTBBridgeHandler)
  {
    if (paramTBBridgeHandler != null) {
      this.messageHandlers.put(paramString, paramTBBridgeHandler);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\jsbridge\TBBridgeHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */