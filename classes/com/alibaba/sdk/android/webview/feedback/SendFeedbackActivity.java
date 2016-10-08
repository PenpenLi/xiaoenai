package com.alibaba.sdk.android.webview.feedback;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.alibaba.sdk.android.AlibabaSDK;
import com.alibaba.sdk.android.Version;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.executor.ExecutorService;
import com.alibaba.sdk.android.impl.KernelContext;
import com.alibaba.sdk.android.rpc.RpcService;
import com.alibaba.sdk.android.rpc.model.RpcRequest;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.ui.UIContext;
import com.alibaba.sdk.android.util.ResourceUtils;
import com.alibaba.sdk.android.util.TraceHelper;
import com.alibaba.sdk.android.webview.utils.BitmapUtils;
import com.alibaba.sdk.android.webview.utils.FeedbackInfoUtils;
import com.alibaba.sdk.android.webview.utils.FeedbackInfoUtils.NetworkEnum;
import com.alibaba.sdk.android.webview.utils.ImageUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class SendFeedbackActivity
  extends Activity
{
  private String SAVE_IMAGE_DIR_PATH = "feedbackService";
  private Bitmap bitmap = null;
  private Bitmap bmp;
  private Button buttonBackOfTitle;
  private ImageButton buttonChoosePicture;
  private int buttonChoosePictureHeight;
  private int buttonChoosePictureWidth;
  private Button buttonSendFeedback;
  private int count = 0;
  private float density;
  private EditText editEmialOfSetting;
  private EditText editFeedbackOfSetting;
  private int heightOfDisplay;
  private LinearLayout layoutOfImage;
  private View.OnClickListener listenerOfTitle = new SendFeedbackActivity.7(this);
  private String originImagePath;
  private String picturePath;
  private PopupWindow popupWindow;
  private int widthOfDisplay;
  
  private void addLayoutDynamic(Bitmap paramBitmap, String paramString)
  {
    FrameLayout localFrameLayout = (FrameLayout)getLayoutInflater().inflate(ResourceUtils.getRLayout(this, "com_taobao_tae_sdk_web_view_activity_sendfeedback_newimagewithdelete"), null);
    Object localObject = (ImageView)localFrameLayout.findViewById(ResourceUtils.getRId(this, "com_taobao_tae_sdk_web_view_activity_sendfeedback_newimagewithdelete_newimage_imageview"));
    ((ImageView)localObject).setImageBitmap(paramBitmap);
    ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_CENTER);
    paramBitmap = (ImageView)localFrameLayout.findViewById(ResourceUtils.getRId(this, "com_taobao_tae_sdk_web_view_activity_sendfeedback_newimagewithdelete_delete_imageview"));
    localObject = (RelativeLayout.LayoutParams)paramBitmap.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = ((int)(this.buttonChoosePictureWidth / 2.8D));
    ((RelativeLayout.LayoutParams)localObject).height = ((int)(this.buttonChoosePictureWidth / 2.8D));
    paramBitmap.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramBitmap.setOnClickListener(new SendFeedbackActivity.6(this));
    localFrameLayout.setTag(paramString);
    this.layoutOfImage.addView(localFrameLayout);
    paramBitmap = (LinearLayout.LayoutParams)localFrameLayout.getLayoutParams();
    paramBitmap.width = this.buttonChoosePictureWidth;
    paramBitmap.height = this.buttonChoosePictureHeight;
    paramBitmap.leftMargin = dpToPx(6, this.density);
    localFrameLayout.setLayoutParams(paramBitmap);
    this.count += 1;
  }
  
  private void cancleOfPopWin()
  {
    this.popupWindow.dismiss();
  }
  
  private void choosePicture()
  {
    if (this.count < 5)
    {
      this.popupWindow.showAtLocation(findViewById(ResourceUtils.getRId(this, "com_taobao_tae_sdk_web_view_activity_sendfeedback_send_button")), 81, 0, 0);
      return;
    }
    Toast.makeText(this, ResourceUtils.getString("com_taobao_tae_sdk_web_view_activity_sendfeedback_strings_feedback_maximages"), 0).show();
  }
  
  private void choosePictureFromAlbum()
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setType("image/*");
      localIntent.setAction("android.intent.action.GET_CONTENT");
      startActivityForResult(localIntent, 1);
      this.popupWindow.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private int dpToPx(int paramInt, float paramFloat)
  {
    return (int)(paramInt * paramFloat + 0.5F);
  }
  
  private void initBmp(Bitmap paramBitmap, String paramString)
  {
    addLayoutDynamic(paramBitmap, paramString);
  }
  
  private int pxToDp(int paramInt, float paramFloat)
  {
    return (int)(paramInt / paramFloat + 0.5F);
  }
  
  private void sendFeedback()
  {
    if (FeedbackInfoUtils.getNetworkType(this) != FeedbackInfoUtils.NetworkEnum.WIFI)
    {
      Toast.makeText(this, ResourceUtils.getString("com_taobao_tae_sdk_web_view_activity_sendfeedback_strings_feedback_nowifi"), 0).show();
      return;
    }
    String str1 = this.editEmialOfSetting.getText().toString().trim();
    String str2 = this.editFeedbackOfSetting.getText().toString().trim();
    if ((str2 == null) || (str2.equals("")))
    {
      Toast.makeText(this, ResourceUtils.getString("com_taobao_tae_sdk_web_view_activity_sendfeedback_strings_feedback_nocontent"), 0).show();
      return;
    }
    if (str2.length() <= 3)
    {
      Toast.makeText(this, ResourceUtils.getString("com_taobao_tae_sdk_web_view_activity_sendfeedback_strings_feedback_invalidcontent"), 0).show();
      return;
    }
    if ((str1 == null) || (str1.equals("")))
    {
      Toast.makeText(this, ResourceUtils.getString("com_taobao_tae_sdk_web_view_activity_sendfeedback_strings_feedback_nocontact"), 0).show();
      return;
    }
    if (str1.length() <= 6)
    {
      Toast.makeText(this, ResourceUtils.getString("com_taobao_tae_sdk_web_view_activity_sendfeedback_strings_feedback_invalidcontact"), 0).show();
      return;
    }
    KernelContext.executorService.postTask(new SendFeedbackActivity.8(this, str2, str1));
    Toast.makeText(this, ResourceUtils.getString("com_taobao_tae_sdk_web_view_activity_sendfeedback_strings_feedback_feedbackcomplete"), 0).show();
    setResult(200);
    finish();
  }
  
  private void sendFeedbackInfoToMpop(String paramString1, String paramString2, List<String> paramList)
  {
    paramString1 = sendMpopFeedback(paramString1, paramString2, paramList);
    if ((paramString1 != null) && (!paramString1.equals(""))) {
      sendMpopfeedbackExtData(paramString1);
    }
  }
  
  private String sendMpopFeedback(String paramString1, String paramString2, List<String> paramList)
  {
    RpcRequest localRpcRequest = new RpcRequest();
    localRpcRequest.target = "taobao-wireless-mpop-feedback";
    HashMap localHashMap = new HashMap();
    localHashMap.put("appType", "baichuan_tae_onesdk_android");
    localHashMap.put("content", paramString1);
    localHashMap.put("appkey", UIContext.appContext.getAppKey());
    localHashMap.put("appVersion", FeedbackInfoUtils.getAppVersion(this));
    localHashMap.put("ttid", TraceHelper.clientTTID);
    localHashMap.put("osVersion", Build.VERSION.RELEASE);
    localHashMap.put("model", Build.BRAND + " " + Build.MODEL);
    localHashMap.put("city", FeedbackInfoUtils.getLocationByGps(this));
    localHashMap.put("network", FeedbackInfoUtils.getNetworkType(this));
    localHashMap.put("resolution", this.heightOfDisplay + "," + this.widthOfDisplay);
    localHashMap.put("clientIp", FeedbackInfoUtils.getIp());
    localHashMap.put("extra", "联系方式 :" + paramString2 + "; Onesdk版本 :" + AlibabaSDK.getVersion().toString());
    localHashMap.put("deviceId", FeedbackInfoUtils.getDeviceId(this));
    localHashMap.put("gmtCreate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    if ((paramList != null) && (paramList.size() > 0)) {
      localHashMap.put("imageAddrs", paramList);
    }
    localHashMap.put("feedbackTitle", "问题报告");
    paramString1 = new HashMap();
    paramString1.put("feedback", localHashMap);
    localRpcRequest.params = paramString1;
    paramString1 = UIContext.rpcService.invoke(localRpcRequest);
    try
    {
      paramString1 = new JSONObject(paramString1).getString("feedbackId");
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  private void sendMpopfeedbackExtData(String paramString)
  {
    RpcRequest localRpcRequest = new RpcRequest();
    localRpcRequest.target = "taobao-wireless-mpop-diagnose";
    try
    {
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("utdid", UIContext.appContext.getUserTrackerId());
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("deviceInfo", localObject1);
      localObject1 = ((JSONObject)localObject2).toString();
      localObject2 = new HashMap();
      ((Map)localObject2).put("diagnoseInfo", localObject1);
      ((Map)localObject2).put("feedbackId", Long.valueOf(Long.parseLong(paramString)));
      ((Map)localObject2).put("platform", "ANDROID");
      localRpcRequest.params = ((Map)localObject2);
      UIContext.rpcService.invoke(localRpcRequest);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void takePicture()
  {
    try
    {
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        Object localObject1 = new SimpleDateFormat("yyyyMMddHHmmss");
        Object localObject2 = new Date();
        localObject1 = ((SimpleDateFormat)localObject1).format((Date)localObject2) + ".jpg";
        localObject2 = new File(Environment.getExternalStorageDirectory() + "/" + this.SAVE_IMAGE_DIR_PATH);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        localObject2 = new File((File)localObject2, (String)localObject1);
        localObject1 = Uri.fromFile((File)localObject2);
        this.picturePath = ((File)localObject2).getPath();
        localObject2 = new Intent();
        ((Intent)localObject2).setAction("android.media.action.IMAGE_CAPTURE");
        ((Intent)localObject2).putExtra("output", (Parcelable)localObject1);
        startActivityForResult((Intent)localObject2, 2);
        this.popupWindow.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1) {
      AliSDKLogger.i("SendFeedbackActivity--onActivityResult", "没有图片被选择");
    }
    do
    {
      return;
      if (paramInt1 != 1) {
        break;
      }
    } while (paramIntent == null);
    for (;;)
    {
      try
      {
        paramIntent = paramIntent.getData();
        if (paramIntent == null) {
          break;
        }
        if (Build.VERSION.SDK_INT >= 19)
        {
          paramIntent = ImageUtils.getPath(this, paramIntent);
          if ((paramIntent == null) || (paramIntent.equals(""))) {
            break;
          }
          this.bitmap = BitmapUtils.createMiniBitmapByPath(paramIntent, this.widthOfDisplay, this.heightOfDisplay);
          if (this.bitmap == null) {
            break;
          }
          addLayoutDynamic(this.bitmap, paramIntent);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        return;
      }
      Cursor localCursor = managedQuery(paramIntent, new String[] { "_data" }, null, null, null);
      if (localCursor != null)
      {
        paramInt1 = localCursor.getColumnIndexOrThrow("_data");
        localCursor.moveToFirst();
        String str = localCursor.getString(paramInt1);
        paramIntent = str;
        if (Build.VERSION.SDK_INT >= 14) {
          continue;
        }
        localCursor.close();
        paramIntent = str;
        continue;
        if ((paramInt1 != 2) || (this.picturePath == null) || (this.picturePath.equals(""))) {
          break;
        }
        this.bitmap = BitmapUtils.createMiniBitmapByPath(this.picturePath, this.widthOfDisplay, this.heightOfDisplay);
        if (this.bitmap == null) {
          break;
        }
        addLayoutDynamic(this.bitmap, this.picturePath);
        return;
      }
      paramIntent = null;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(ResourceUtils.getRLayout(this, "com_taobao_tae_sdk_web_view_activity_sendfeedback"));
    getWindow().setFeatureInt(7, ResourceUtils.getRLayout(this, "com_taobao_tae_sdk_web_view_activity_feedback_titlebar"));
    this.buttonBackOfTitle = ((Button)findViewById(ResourceUtils.getRId(this, "com_taobao_tae_sdk_web_view_activity_feedback_titlebar_back_button")));
    if (this.buttonBackOfTitle != null) {
      this.buttonBackOfTitle.setOnClickListener(this.listenerOfTitle);
    }
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.originImagePath = paramBundle.getStringExtra("imagePath").trim();
      if ((this.originImagePath != null) && (!this.originImagePath.equals("")))
      {
        this.bmp = BitmapUtils.safeDecodeFile(this.originImagePath);
        this.bmp = BitmapUtils.compressToDefiniteSizeBitmap(this.bmp, 100);
      }
    }
    paramBundle = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
    this.widthOfDisplay = paramBundle.widthPixels;
    this.heightOfDisplay = paramBundle.heightPixels;
    this.density = paramBundle.density;
    this.editEmialOfSetting = ((EditText)findViewById(ResourceUtils.getRId(this, "com_taobao_tae_sdk_web_view_activity_sendfeedback_email_edit")));
    this.editFeedbackOfSetting = ((EditText)findViewById(ResourceUtils.getRId(this, "com_taobao_tae_sdk_web_view_activity_sendfeedback_feedback_edit")));
    this.buttonChoosePicture = ((ImageButton)findViewById(ResourceUtils.getRId(this, "com_taobao_tae_sdk_web_view_activity_sendfeedback_choosepicture_button")));
    if (this.buttonChoosePicture != null) {
      this.buttonChoosePicture.setOnClickListener(new SendFeedbackActivity.1(this));
    }
    this.buttonSendFeedback = ((Button)findViewById(ResourceUtils.getRId(this, "com_taobao_tae_sdk_web_view_activity_sendfeedback_send_button")));
    if (this.buttonSendFeedback != null) {
      this.buttonSendFeedback.setOnClickListener(new SendFeedbackActivity.2(this));
    }
    this.layoutOfImage = ((LinearLayout)findViewById(ResourceUtils.getRId(this, "com_taobao_tae_sdk_web_view_activity_sendfeedback_images_layout")));
    paramBundle = (LinearLayout.LayoutParams)this.buttonChoosePicture.getLayoutParams();
    this.buttonChoosePictureWidth = ((this.widthOfDisplay - dpToPx(38, this.density)) / 6);
    this.buttonChoosePictureHeight = ((int)(this.buttonChoosePictureWidth * 1.7D));
    paramBundle.width = this.buttonChoosePictureWidth;
    paramBundle.height = this.buttonChoosePictureHeight;
    this.buttonChoosePicture.setLayoutParams(paramBundle);
    paramBundle = getLayoutInflater().inflate(ResourceUtils.getRLayout(this, "com_taobao_tea_sdk_web_view_actvity_selectpicturepopwindows"), null);
    this.popupWindow = new PopupWindow(paramBundle, -1, -2, true);
    this.popupWindow.setBackgroundDrawable(new ColorDrawable(0));
    this.popupWindow.setAnimationStyle(ResourceUtils.getIdentifier(this, "style", "popup_window"));
    Button localButton = (Button)paramBundle.findViewById(ResourceUtils.getRId(this, "com_taobao_tae_sdk_web_view_activity_selectpicturepopwindow_album_button"));
    if (localButton != null) {
      localButton.setOnClickListener(new SendFeedbackActivity.3(this));
    }
    localButton = (Button)paramBundle.findViewById(ResourceUtils.getRId(this, "com_taobao_tae_sdk_web_view_activity_selectpicturepopwindow_photograph_button"));
    if (localButton != null) {
      localButton.setOnClickListener(new SendFeedbackActivity.4(this));
    }
    paramBundle = (Button)paramBundle.findViewById(ResourceUtils.getRId(this, "com_taobao_tae_sdk_web_view_activity_selectpicturepopwindow_cancel_button"));
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new SendFeedbackActivity.5(this));
    }
    if ((this.originImagePath != null) && (!this.originImagePath.equals("")) && (this.bmp != null)) {
      initBmp(this.bmp, this.originImagePath);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\feedback\SendFeedbackActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */