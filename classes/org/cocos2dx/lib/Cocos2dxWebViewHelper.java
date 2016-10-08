package org.cocos2dx.lib;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.widget.FrameLayout;
import com.chukong.cocosplay.client.CocosPlayClient;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Cocos2dxWebViewHelper
{
  private static final String TAG = Cocos2dxWebViewHelper.class.getSimpleName();
  private static Cocos2dxActivity sCocos2dxActivity;
  private static Handler sHandler;
  private static FrameLayout sLayout;
  private static int viewTag = 0;
  private static SparseArray<Cocos2dxWebView> webViews;
  
  public Cocos2dxWebViewHelper(FrameLayout paramFrameLayout)
  {
    sLayout = paramFrameLayout;
    sHandler = new Handler(Looper.myLooper());
    sCocos2dxActivity = (Cocos2dxActivity)Cocos2dxActivity.getContext();
    webViews = new SparseArray();
  }
  
  public static void _didFailLoading(int paramInt, String paramString)
  {
    didFailLoading(paramInt, paramString);
  }
  
  public static void _didFinishLoading(int paramInt, String paramString)
  {
    didFinishLoading(paramInt, paramString);
  }
  
  public static void _onJsCallback(int paramInt, String paramString)
  {
    onJsCallback(paramInt, paramString);
  }
  
  public static boolean _shouldStartLoading(int paramInt, String paramString)
  {
    return !shouldStartLoading(paramInt, paramString);
  }
  
  public static <T> T callInMainThread(Callable<T> paramCallable)
  {
    paramCallable = new FutureTask(paramCallable);
    sHandler.post(paramCallable);
    return (T)paramCallable.get();
  }
  
  public static boolean canGoBack(int paramInt)
  {
    Cocos2dxWebViewHelper.12 local12 = new Cocos2dxWebViewHelper.12(paramInt);
    try
    {
      boolean bool = ((Boolean)callInMainThread(local12)).booleanValue();
      return bool;
    }
    catch (ExecutionException localExecutionException)
    {
      return false;
    }
    catch (InterruptedException localInterruptedException) {}
    return false;
  }
  
  public static boolean canGoForward(int paramInt)
  {
    Cocos2dxWebViewHelper.13 local13 = new Cocos2dxWebViewHelper.13(paramInt);
    try
    {
      boolean bool = ((Boolean)callInMainThread(local13)).booleanValue();
      return bool;
    }
    catch (ExecutionException localExecutionException)
    {
      return false;
    }
    catch (InterruptedException localInterruptedException) {}
    return false;
  }
  
  public static int createWebView()
  {
    int i = viewTag;
    sCocos2dxActivity.runOnUiThread(new Cocos2dxWebViewHelper.1(i));
    i = viewTag;
    viewTag = i + 1;
    return i;
  }
  
  private static native void didFailLoading(int paramInt, String paramString);
  
  private static native void didFinishLoading(int paramInt, String paramString);
  
  public static void evaluateJS(int paramInt, String paramString)
  {
    sCocos2dxActivity.runOnUiThread(new Cocos2dxWebViewHelper.16(paramInt, paramString));
  }
  
  public static void goBack(int paramInt)
  {
    sCocos2dxActivity.runOnUiThread(new Cocos2dxWebViewHelper.14(paramInt));
  }
  
  public static void goForward(int paramInt)
  {
    sCocos2dxActivity.runOnUiThread(new Cocos2dxWebViewHelper.15(paramInt));
  }
  
  public static void loadData(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    sCocos2dxActivity.runOnUiThread(new Cocos2dxWebViewHelper.6(paramInt, paramString4, paramString1, paramString2, paramString3));
  }
  
  public static void loadFile(int paramInt, String paramString)
  {
    if ((CocosPlayClient.isEnabled()) && (!CocosPlayClient.isDemo())) {
      CocosPlayClient.updateAssets(paramString);
    }
    CocosPlayClient.notifyFileLoaded(paramString);
    sCocos2dxActivity.runOnUiThread(new Cocos2dxWebViewHelper.9(paramInt, paramString));
  }
  
  public static void loadHTMLString(int paramInt, String paramString1, String paramString2)
  {
    sCocos2dxActivity.runOnUiThread(new Cocos2dxWebViewHelper.7(paramInt, paramString2, paramString1));
  }
  
  public static void loadUrl(int paramInt, String paramString)
  {
    sCocos2dxActivity.runOnUiThread(new Cocos2dxWebViewHelper.8(paramInt, paramString));
  }
  
  private static native void onJsCallback(int paramInt, String paramString);
  
  public static void reload(int paramInt)
  {
    sCocos2dxActivity.runOnUiThread(new Cocos2dxWebViewHelper.11(paramInt));
  }
  
  public static void removeWebView(int paramInt)
  {
    sCocos2dxActivity.runOnUiThread(new Cocos2dxWebViewHelper.2(paramInt));
  }
  
  public static void setJavascriptInterfaceScheme(int paramInt, String paramString)
  {
    sCocos2dxActivity.runOnUiThread(new Cocos2dxWebViewHelper.5(paramInt, paramString));
  }
  
  public static void setScalesPageToFit(int paramInt, boolean paramBoolean)
  {
    sCocos2dxActivity.runOnUiThread(new Cocos2dxWebViewHelper.17(paramInt, paramBoolean));
  }
  
  public static void setVisible(int paramInt, boolean paramBoolean)
  {
    sCocos2dxActivity.runOnUiThread(new Cocos2dxWebViewHelper.3(paramInt, paramBoolean));
  }
  
  public static void setWebViewRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    sCocos2dxActivity.runOnUiThread(new Cocos2dxWebViewHelper.4(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5));
  }
  
  private static native boolean shouldStartLoading(int paramInt, String paramString);
  
  public static void stopLoading(int paramInt)
  {
    sCocos2dxActivity.runOnUiThread(new Cocos2dxWebViewHelper.10(paramInt));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxWebViewHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */