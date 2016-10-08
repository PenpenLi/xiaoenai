package com.alibaba.sdk.android.webview;

import android.graphics.Bitmap;
import android.view.View;
import android.view.Window;
import com.alibaba.sdk.android.executor.ExecutorService;
import com.alibaba.sdk.android.impl.KernelContext;
import com.alibaba.sdk.android.task.AbsRunnable;
import com.alibaba.sdk.android.webview.utils.ImageUtils;

class BaseWebViewActivity$8
  extends AbsRunnable
{
  BaseWebViewActivity$8(BaseWebViewActivity paramBaseWebViewActivity) {}
  
  public void runWithoutException()
  {
    View localView = this.this$0.getWindow().getDecorView();
    localView.setDrawingCacheEnabled(true);
    localView.buildDrawingCache();
    Object localObject = localView.getDrawingCache();
    if (localObject != null)
    {
      localObject = ImageUtils.saveImageToCacheDir(this.this$0, (Bitmap)localObject);
      localView.destroyDrawingCache();
      KernelContext.executorService.postUITask(new BaseWebViewActivity.8.1(this, (String)localObject));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\BaseWebViewActivity$8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */