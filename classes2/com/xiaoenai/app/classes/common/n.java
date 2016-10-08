package com.xiaoenai.app.classes.common;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.xiaoenai.app.widget.wheel.WheelView;

public class n<T extends DebugActivity>
  implements Unbinder
{
  protected T a;
  
  public n(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.mDebugLayout = paramFinder.findRequiredView(paramObject, 2131558626, "field 'mDebugLayout'");
    paramT.mDebugText = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131558627, "field 'mDebugText'", TextView.class));
    paramT.mEnvWheel = ((WheelView)paramFinder.findRequiredViewAsType(paramObject, 2131558628, "field 'mEnvWheel'", WheelView.class));
    paramT.mScrollView = ((ScrollView)paramFinder.findRequiredViewAsType(paramObject, 2131558587, "field 'mScrollView'", ScrollView.class));
    paramT.mDevIp = paramFinder.findRequiredView(paramObject, 2131558630, "field 'mDevIp'");
    paramT.mDevIpBtn = ((Button)paramFinder.findRequiredViewAsType(paramObject, 2131558632, "field 'mDevIpBtn'", Button.class));
    paramT.mDevEdt = ((EditText)paramFinder.findRequiredViewAsType(paramObject, 2131558631, "field 'mDevEdt'", EditText.class));
    paramT.mSuspendLog = paramFinder.findRequiredView(paramObject, 2131558620, "field 'mSuspendLog'");
    paramT.mImageView = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131558621, "field 'mImageView'", ImageView.class));
    paramT.mWebViewDebug = paramFinder.findRequiredView(paramObject, 2131558622, "field 'mWebViewDebug'");
    paramT.mWebImg = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131558623, "field 'mWebImg'", ImageView.class));
    paramT.mAnalyticsDebug = paramFinder.findRequiredView(paramObject, 2131558624, "field 'mAnalyticsDebug'");
    paramT.mAnalyticImg = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131558625, "field 'mAnalyticImg'", ImageView.class));
  }
  
  public void unbind()
  {
    DebugActivity localDebugActivity = this.a;
    if (localDebugActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localDebugActivity.mDebugLayout = null;
    localDebugActivity.mDebugText = null;
    localDebugActivity.mEnvWheel = null;
    localDebugActivity.mScrollView = null;
    localDebugActivity.mDevIp = null;
    localDebugActivity.mDevIpBtn = null;
    localDebugActivity.mDevEdt = null;
    localDebugActivity.mSuspendLog = null;
    localDebugActivity.mImageView = null;
    localDebugActivity.mWebViewDebug = null;
    localDebugActivity.mWebImg = null;
    localDebugActivity.mAnalyticsDebug = null;
    localDebugActivity.mAnalyticImg = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */