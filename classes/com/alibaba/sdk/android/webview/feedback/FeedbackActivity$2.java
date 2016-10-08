package com.alibaba.sdk.android.webview.feedback;

import android.graphics.Bitmap;
import com.alibaba.sdk.android.executor.ExecutorService;
import com.alibaba.sdk.android.impl.KernelContext;
import com.alibaba.sdk.android.task.AbsRunnable;
import com.alibaba.sdk.android.webview.utils.ImageUtils;
import com.alibaba.sdk.android.webview.views.HandWriter;

class FeedbackActivity$2
  extends AbsRunnable
{
  FeedbackActivity$2(FeedbackActivity paramFeedbackActivity) {}
  
  public void runWithoutException()
  {
    Object localObject = FeedbackActivity.access$000(this.this$0).getNewBitmap();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ImageUtils.saveImageToCacheDir(this.this$0, (Bitmap)localObject);
      ImageUtils.deleteImageFile(FeedbackActivity.access$100(this.this$0));
    } while (localObject == null);
    KernelContext.executorService.postUITask(new FeedbackActivity.2.1(this, (String)localObject));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\feedback\FeedbackActivity$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */