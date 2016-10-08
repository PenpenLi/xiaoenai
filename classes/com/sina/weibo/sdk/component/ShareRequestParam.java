package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.MusicObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.VideoObject;
import com.sina.weibo.sdk.api.VoiceObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.api.share.BaseRequest;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;
import org.json.JSONException;
import org.json.JSONObject;

public class ShareRequestParam
  extends BrowserRequestParamBase
{
  public static final String REQ_PARAM_AID = "aid";
  public static final String REQ_PARAM_KEY_HASH = "key_hash";
  public static final String REQ_PARAM_PACKAGENAME = "packagename";
  public static final String REQ_PARAM_PICINFO = "picinfo";
  public static final String REQ_PARAM_SOURCE = "source";
  public static final String REQ_PARAM_TITLE = "title";
  public static final String REQ_PARAM_TOKEN = "access_token";
  public static final String REQ_PARAM_VERSION = "version";
  public static final String REQ_UPLOAD_PIC_PARAM_IMG = "img";
  public static final String RESP_UPLOAD_PIC_PARAM_CODE = "code";
  public static final String RESP_UPLOAD_PIC_PARAM_DATA = "data";
  public static final int RESP_UPLOAD_PIC_SUCC_CODE = 1;
  private static final String SHARE_URL = "http://service.weibo.com/share/mobilesdk.php";
  public static final String UPLOAD_PIC_URL = "http://service.weibo.com/share/mobilesdk_uppic.php";
  private String mAppKey;
  private String mAppPackage;
  private WeiboAuthListener mAuthListener;
  private String mAuthListenerKey;
  private byte[] mBase64ImgData;
  private BaseRequest mBaseRequest;
  private String mHashKey;
  private String mShareContent;
  private String mToken;
  
  public ShareRequestParam(Context paramContext)
  {
    super(paramContext);
    this.mLaucher = BrowserLauncher.SHARE;
  }
  
  /* Error */
  private void handleMblogPic(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +91 -> 95
    //   7: new 92	java/io/File
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: astore_1
    //   16: aload_1
    //   17: invokevirtual 99	java/io/File:exists	()Z
    //   20: ifeq +75 -> 95
    //   23: aload_1
    //   24: invokevirtual 102	java/io/File:canRead	()Z
    //   27: ifeq +68 -> 95
    //   30: aload_1
    //   31: invokevirtual 106	java/io/File:length	()J
    //   34: lconst_0
    //   35: lcmp
    //   36: ifle +59 -> 95
    //   39: aload_1
    //   40: invokevirtual 106	java/io/File:length	()J
    //   43: l2i
    //   44: newarray <illegal type>
    //   46: astore 4
    //   48: aconst_null
    //   49: astore_3
    //   50: new 108	java/io/FileInputStream
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 111	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   58: astore_1
    //   59: aload_1
    //   60: aload 4
    //   62: invokevirtual 115	java/io/FileInputStream:read	([B)I
    //   65: pop
    //   66: aload_0
    //   67: aload 4
    //   69: invokestatic 121	com/sina/weibo/sdk/utils/Base64:encodebyte	([B)[B
    //   72: putfield 123	com/sina/weibo/sdk/component/ShareRequestParam:mBase64ImgData	[B
    //   75: aload_1
    //   76: ifnull +7 -> 83
    //   79: aload_1
    //   80: invokevirtual 127	java/io/FileInputStream:close	()V
    //   83: return
    //   84: astore_1
    //   85: aconst_null
    //   86: astore_1
    //   87: aload_1
    //   88: ifnull +7 -> 95
    //   91: aload_1
    //   92: invokevirtual 127	java/io/FileInputStream:close	()V
    //   95: aload_2
    //   96: ifnull -13 -> 83
    //   99: aload_2
    //   100: arraylength
    //   101: ifle -18 -> 83
    //   104: aload_0
    //   105: aload_2
    //   106: invokestatic 121	com/sina/weibo/sdk/utils/Base64:encodebyte	([B)[B
    //   109: putfield 123	com/sina/weibo/sdk/component/ShareRequestParam:mBase64ImgData	[B
    //   112: return
    //   113: astore_1
    //   114: aload_3
    //   115: ifnull +7 -> 122
    //   118: aload_3
    //   119: invokevirtual 127	java/io/FileInputStream:close	()V
    //   122: aload_1
    //   123: athrow
    //   124: astore_1
    //   125: goto -30 -> 95
    //   128: astore_1
    //   129: return
    //   130: astore_1
    //   131: goto -36 -> 95
    //   134: astore_3
    //   135: goto -13 -> 122
    //   138: astore 4
    //   140: aload_1
    //   141: astore_3
    //   142: aload 4
    //   144: astore_1
    //   145: goto -31 -> 114
    //   148: astore_3
    //   149: goto -62 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	ShareRequestParam
    //   0	152	1	paramString	String
    //   0	152	2	paramArrayOfByte	byte[]
    //   49	70	3	localObject1	Object
    //   134	1	3	localException	Exception
    //   141	1	3	str	String
    //   148	1	3	localIOException	java.io.IOException
    //   46	22	4	arrayOfByte	byte[]
    //   138	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   50	59	84	java/io/IOException
    //   50	59	113	finally
    //   0	48	124	java/lang/SecurityException
    //   79	83	124	java/lang/SecurityException
    //   91	95	124	java/lang/SecurityException
    //   118	122	124	java/lang/SecurityException
    //   122	124	124	java/lang/SecurityException
    //   79	83	128	java/lang/Exception
    //   91	95	130	java/lang/Exception
    //   118	122	134	java/lang/Exception
    //   59	75	138	finally
    //   59	75	148	java/io/IOException
  }
  
  private void handleSharedMessage(Bundle paramBundle)
  {
    Object localObject1 = new WeiboMultiMessage();
    ((WeiboMultiMessage)localObject1).toObject(paramBundle);
    paramBundle = new StringBuilder();
    if ((((WeiboMultiMessage)localObject1).textObject instanceof TextObject)) {
      paramBundle.append(((WeiboMultiMessage)localObject1).textObject.text);
    }
    Object localObject2;
    if ((((WeiboMultiMessage)localObject1).imageObject instanceof ImageObject))
    {
      localObject2 = ((WeiboMultiMessage)localObject1).imageObject;
      handleMblogPic(((ImageObject)localObject2).imagePath, ((ImageObject)localObject2).imageData);
    }
    if ((((WeiboMultiMessage)localObject1).mediaObject instanceof TextObject)) {
      paramBundle.append(((TextObject)((WeiboMultiMessage)localObject1).mediaObject).text);
    }
    if ((((WeiboMultiMessage)localObject1).mediaObject instanceof ImageObject))
    {
      localObject2 = (ImageObject)((WeiboMultiMessage)localObject1).mediaObject;
      handleMblogPic(((ImageObject)localObject2).imagePath, ((ImageObject)localObject2).imageData);
    }
    if ((((WeiboMultiMessage)localObject1).mediaObject instanceof WebpageObject))
    {
      localObject2 = (WebpageObject)((WeiboMultiMessage)localObject1).mediaObject;
      paramBundle.append(" ").append(((WebpageObject)localObject2).actionUrl);
    }
    if ((((WeiboMultiMessage)localObject1).mediaObject instanceof MusicObject))
    {
      localObject2 = (MusicObject)((WeiboMultiMessage)localObject1).mediaObject;
      paramBundle.append(" ").append(((MusicObject)localObject2).actionUrl);
    }
    if ((((WeiboMultiMessage)localObject1).mediaObject instanceof VideoObject))
    {
      localObject2 = (VideoObject)((WeiboMultiMessage)localObject1).mediaObject;
      paramBundle.append(" ").append(((VideoObject)localObject2).actionUrl);
    }
    if ((((WeiboMultiMessage)localObject1).mediaObject instanceof VoiceObject))
    {
      localObject1 = (VoiceObject)((WeiboMultiMessage)localObject1).mediaObject;
      paramBundle.append(" ").append(((VoiceObject)localObject1).actionUrl);
    }
    this.mShareContent = paramBundle.toString();
  }
  
  private void sendSdkResponse(Activity paramActivity, int paramInt, String paramString)
  {
    Bundle localBundle = paramActivity.getIntent().getExtras();
    if (localBundle == null) {
      return;
    }
    Intent localIntent = new Intent("com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY");
    localIntent.setFlags(131072);
    localIntent.setPackage(localBundle.getString("_weibo_appPackage"));
    localIntent.putExtras(localBundle);
    localIntent.putExtra("_weibo_appPackage", paramActivity.getPackageName());
    localIntent.putExtra("_weibo_resp_errcode", paramInt);
    localIntent.putExtra("_weibo_resp_errstr", paramString);
    try
    {
      paramActivity.startActivityForResult(localIntent, 765);
      return;
    }
    catch (ActivityNotFoundException paramActivity) {}
  }
  
  public WeiboParameters buildUploadPicParam(WeiboParameters paramWeiboParameters)
  {
    if (!hasImage()) {
      return paramWeiboParameters;
    }
    paramWeiboParameters.put("img", new String(this.mBase64ImgData));
    return paramWeiboParameters;
  }
  
  public String buildUrl(String paramString)
  {
    Uri.Builder localBuilder = Uri.parse("http://service.weibo.com/share/mobilesdk.php").buildUpon();
    localBuilder.appendQueryParameter("title", this.mShareContent);
    localBuilder.appendQueryParameter("version", "0031405000");
    if (!TextUtils.isEmpty(this.mAppKey)) {
      localBuilder.appendQueryParameter("source", this.mAppKey);
    }
    if (!TextUtils.isEmpty(this.mToken)) {
      localBuilder.appendQueryParameter("access_token", this.mToken);
    }
    String str = Utility.getAid(this.mContext, this.mAppKey);
    if (!TextUtils.isEmpty(str)) {
      localBuilder.appendQueryParameter("aid", str);
    }
    if (!TextUtils.isEmpty(this.mAppPackage)) {
      localBuilder.appendQueryParameter("packagename", this.mAppPackage);
    }
    if (!TextUtils.isEmpty(this.mHashKey)) {
      localBuilder.appendQueryParameter("key_hash", this.mHashKey);
    }
    if (!TextUtils.isEmpty(paramString)) {
      localBuilder.appendQueryParameter("picinfo", paramString);
    }
    return localBuilder.build().toString();
  }
  
  public void execRequest(Activity paramActivity, int paramInt)
  {
    if (paramInt == 3)
    {
      sendSdkCancleResponse(paramActivity);
      WeiboSdkBrowser.closeBrowser(paramActivity, this.mAuthListenerKey, null);
    }
  }
  
  public String getAppKey()
  {
    return this.mAppKey;
  }
  
  public String getAppPackage()
  {
    return this.mAppPackage;
  }
  
  public WeiboAuthListener getAuthListener()
  {
    return this.mAuthListener;
  }
  
  public String getAuthListenerKey()
  {
    return this.mAuthListenerKey;
  }
  
  public byte[] getBase64ImgData()
  {
    return this.mBase64ImgData;
  }
  
  public String getHashKey()
  {
    return this.mHashKey;
  }
  
  public String getShareContent()
  {
    return this.mShareContent;
  }
  
  public String getToken()
  {
    return this.mToken;
  }
  
  public boolean hasImage()
  {
    return (this.mBase64ImgData != null) && (this.mBase64ImgData.length > 0);
  }
  
  public void onCreateRequestParamBundle(Bundle paramBundle)
  {
    if (this.mBaseRequest != null) {
      this.mBaseRequest.toBundle(paramBundle);
    }
    if (!TextUtils.isEmpty(this.mAppPackage)) {
      this.mHashKey = MD5.hexdigest(Utility.getSign(this.mContext, this.mAppPackage));
    }
    paramBundle.putString("access_token", this.mToken);
    paramBundle.putString("source", this.mAppKey);
    paramBundle.putString("packagename", this.mAppPackage);
    paramBundle.putString("key_hash", this.mHashKey);
    paramBundle.putString("_weibo_appPackage", this.mAppPackage);
    paramBundle.putString("_weibo_appKey", this.mAppKey);
    paramBundle.putInt("_weibo_flag", 538116905);
    paramBundle.putString("_weibo_sign", this.mHashKey);
    if (this.mAuthListener != null)
    {
      WeiboCallbackManager localWeiboCallbackManager = WeiboCallbackManager.getInstance(this.mContext);
      this.mAuthListenerKey = localWeiboCallbackManager.genCallbackKey();
      localWeiboCallbackManager.setWeiboAuthListener(this.mAuthListenerKey, this.mAuthListener);
      paramBundle.putString("key_listener", this.mAuthListenerKey);
    }
  }
  
  protected void onSetupRequestParam(Bundle paramBundle)
  {
    this.mAppKey = paramBundle.getString("source");
    this.mAppPackage = paramBundle.getString("packagename");
    this.mHashKey = paramBundle.getString("key_hash");
    this.mToken = paramBundle.getString("access_token");
    this.mAuthListenerKey = paramBundle.getString("key_listener");
    if (!TextUtils.isEmpty(this.mAuthListenerKey)) {
      this.mAuthListener = WeiboCallbackManager.getInstance(this.mContext).getWeiboAuthListener(this.mAuthListenerKey);
    }
    handleSharedMessage(paramBundle);
    this.mUrl = buildUrl("");
  }
  
  public void sendSdkCancleResponse(Activity paramActivity)
  {
    sendSdkResponse(paramActivity, 1, "send cancel!!!");
  }
  
  public void sendSdkErrorResponse(Activity paramActivity, String paramString)
  {
    sendSdkResponse(paramActivity, 2, paramString);
  }
  
  public void sendSdkOkResponse(Activity paramActivity)
  {
    sendSdkResponse(paramActivity, 0, "send ok!!!");
  }
  
  public void setAppKey(String paramString)
  {
    this.mAppKey = paramString;
  }
  
  public void setAppPackage(String paramString)
  {
    this.mAppPackage = paramString;
  }
  
  public void setAuthListener(WeiboAuthListener paramWeiboAuthListener)
  {
    this.mAuthListener = paramWeiboAuthListener;
  }
  
  public void setBaseRequest(BaseRequest paramBaseRequest)
  {
    this.mBaseRequest = paramBaseRequest;
  }
  
  public void setToken(String paramString)
  {
    this.mToken = paramString;
  }
  
  public static class UploadPicResult
  {
    private int code = -2;
    private String picId;
    
    public static UploadPicResult parse(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      UploadPicResult localUploadPicResult = new UploadPicResult();
      try
      {
        paramString = new JSONObject(paramString);
        localUploadPicResult.code = paramString.optInt("code", -2);
        localUploadPicResult.picId = paramString.optString("data", "");
        return localUploadPicResult;
      }
      catch (JSONException paramString) {}
      return localUploadPicResult;
    }
    
    public int getCode()
    {
      return this.code;
    }
    
    public String getPicId()
    {
      return this.picId;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\component\ShareRequestParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */