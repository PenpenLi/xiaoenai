package com.alibaba.sdk.android.webview.feedback;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import com.alibaba.sdk.android.util.CommonUtils;
import com.alibaba.sdk.android.util.ResourceUtils;
import com.alibaba.sdk.android.webview.utils.BitmapUtils;
import com.alibaba.sdk.android.webview.views.HandWriter;

public class FeedbackActivity
  extends Activity
{
  private Bitmap bmp;
  private Button buttonBackOfTitle;
  private Button buttonNext;
  private Button buttonTrash;
  private HandWriter handWriter;
  private String imagePath;
  private View.OnClickListener listener = new FeedbackActivity.1(this);
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == 200) {
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(ResourceUtils.getRLayout(this, "com_taobao_tae_sdk_web_view_activity_feedback"));
    getWindow().setFeatureInt(7, ResourceUtils.getRLayout(this, "com_taobao_tae_sdk_web_view_activity_feedback_titlebar"));
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.imagePath = paramBundle.getStringExtra("imagePath");
      if ((this.imagePath != null) && (!this.imagePath.trim().equals(""))) {
        this.bmp = BitmapUtils.safeDecodeFile(this.imagePath);
      }
    }
    this.handWriter = ((HandWriter)findViewById(ResourceUtils.getRId(this, "com_taobao_tae_sdk_web_view_activity_feedback_handwriter")));
    paramBundle = (LinearLayout)findViewById(ResourceUtils.getRId(this, "com_taobao_tae_sdk_web_view_activity_feedback_handwriter_layout"));
    if (this.bmp != null) {
      this.handWriter.initBitmap(this.bmp, paramBundle);
    }
    this.buttonNext = ((Button)findViewById(ResourceUtils.getRId(this, "com_taobao_tae_sdk_web_view_activity_feedback_forward_button")));
    this.buttonTrash = ((Button)findViewById(ResourceUtils.getRId(this, "com_taobao_tae_sdk_web_view_activity_feedback_refresh_button")));
    this.buttonBackOfTitle = ((Button)findViewById(ResourceUtils.getRId(this, "com_taobao_tae_sdk_web_view_activity_feedback_titlebar_back_button")));
    this.buttonNext.setOnClickListener(this.listener);
    this.buttonTrash.setOnClickListener(this.listener);
    this.buttonBackOfTitle.setOnClickListener(this.listener);
  }
  
  public void saveImageAndGotoNextActivity()
  {
    FeedbackActivity.2 local2 = new FeedbackActivity.2(this);
    CommonUtils.startInitWaitTask(this, new FeedbackActivity.3(this), local2, null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\feedback\FeedbackActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */