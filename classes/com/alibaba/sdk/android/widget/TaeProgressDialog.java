package com.alibaba.sdk.android.widget;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.alibaba.sdk.android.util.ResourceUtils;

public class TaeProgressDialog
  extends ProgressDialog
{
  private boolean indeterminate;
  private CharSequence message;
  private ProgressBar progressBar;
  private boolean progressVisiable;
  private TextView textView;
  
  public TaeProgressDialog(Context paramContext)
  {
    super(paramContext);
  }
  
  public TaeProgressDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void setMessageAndView()
  {
    int i = 8;
    this.textView.setText(this.message);
    if ((this.message == null) || ("".equals(this.message))) {
      this.textView.setVisibility(8);
    }
    ProgressBar localProgressBar = this.progressBar;
    if (this.progressVisiable) {
      i = 0;
    }
    localProgressBar.setVisibility(i);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(ResourceUtils.getIdentifier("layout", "com_taobao_tae_sdk_progress_dialog"));
    getWindow().setBackgroundDrawableResource(17170445);
    this.progressBar = ((ProgressBar)findViewById(16908301));
    this.textView = ((TextView)findViewById(ResourceUtils.getIdentifier("id", "com_taobao_tae_sdk_progress_dialog_message")));
    setMessageAndView();
    setIndeterminate(this.indeterminate);
  }
  
  public void setIndeterminate(boolean paramBoolean)
  {
    if (this.progressBar != null)
    {
      this.progressBar.setIndeterminate(paramBoolean);
      return;
    }
    this.indeterminate = paramBoolean;
  }
  
  public void setMessage(CharSequence paramCharSequence)
  {
    this.message = paramCharSequence;
  }
  
  public void setProgressVisiable(boolean paramBoolean)
  {
    this.progressVisiable = paramBoolean;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\widget\TaeProgressDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */