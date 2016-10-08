package com.xiaoenai.app.classes.common.webview;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Finder;

public class v<T extends WebViewActivity>
  implements Unbinder
{
  protected T a;
  
  public v(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.mDebugLayout = paramFinder.findRequiredView(paramObject, 2131558622, "field 'mDebugLayout'");
    paramT.mDebugEdit = ((EditText)paramFinder.findRequiredViewAsType(paramObject, 2131559070, "field 'mDebugEdit'", EditText.class));
    paramT.mDebugBtn = ((Button)paramFinder.findRequiredViewAsType(paramObject, 2131559071, "field 'mDebugBtn'", Button.class));
    paramT.mNonVideoLayout = ((RelativeLayout)paramFinder.findRequiredViewAsType(paramObject, 2131559066, "field 'mNonVideoLayout'", RelativeLayout.class));
    paramT.mVideoLayout = ((RelativeLayout)paramFinder.findRequiredViewAsType(paramObject, 2131559072, "field 'mVideoLayout'", RelativeLayout.class));
    paramT.mProgressView = paramFinder.findRequiredView(paramObject, 2131558669, "field 'mProgressView'");
  }
  
  public void unbind()
  {
    WebViewActivity localWebViewActivity = this.a;
    if (localWebViewActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localWebViewActivity.mDebugLayout = null;
    localWebViewActivity.mDebugEdit = null;
    localWebViewActivity.mDebugBtn = null;
    localWebViewActivity.mNonVideoLayout = null;
    localWebViewActivity.mVideoLayout = null;
    localWebViewActivity.mProgressView = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\webview\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */