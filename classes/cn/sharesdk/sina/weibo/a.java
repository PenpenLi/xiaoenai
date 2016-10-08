package cn.sharesdk.sina.weibo;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import com.mob.tools.b.b;
import com.mob.tools.b.e;
import com.mob.tools.b.g;
import com.mob.tools.b.j;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.UUID;

public class a
  extends com.mob.tools.a
  implements Handler.Callback
{
  private long a = 2097152L;
  private boolean b;
  private String c;
  private Platform.ShareParams d;
  private AuthorizeListener e;
  
  private int a(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(paramCompressFormat, 100, localByteArrayOutputStream);
    int i = localByteArrayOutputStream.size();
    localByteArrayOutputStream.close();
    return i;
  }
  
  private static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int j = paramOptions.outWidth;
    int i = 1;
    j /= 2;
    k /= 2;
    while ((j / i > paramInt1) || (k / i > paramInt2)) {
      i *= 2;
    }
    return i + 2;
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    double d1;
    if ((j <= paramInt) && (i <= paramInt)) {
      d1 = 1.0D;
    }
    for (;;)
    {
      return Bitmap.createScaledBitmap(paramBitmap, (int)(i * d1), (int)(d1 * j), true);
      if (j > i) {
        d1 = paramInt / j;
      } else {
        d1 = paramInt / i;
      }
    }
  }
  
  private String a(Context paramContext, String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
        i = 0;
        if (i >= paramContext.signatures.length) {
          break;
        }
        paramString = paramContext.signatures[i].toByteArray();
        if (paramString != null) {
          return b.c(paramString);
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        return null;
      }
      i += 1;
    }
    return null;
  }
  
  private void a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("_weibo_command_type", 1);
    localBundle.putString("_weibo_transaction", String.valueOf(System.currentTimeMillis()));
    if (!TextUtils.isEmpty(this.d.getText()))
    {
      localBundle.putParcelable("_weibo_message_text", e());
      localBundle.putString("_weibo_message_text_extra", "");
    }
    Object localObject;
    if (!TextUtils.isEmpty(this.d.getUrl()))
    {
      this.a = 32768L;
      WebpageObject localWebpageObject = f();
      if (localWebpageObject.checkArgs())
      {
        localBundle.putParcelable("_weibo_message_media", localWebpageObject);
        localObject = "";
        if (!TextUtils.isEmpty(localWebpageObject.defaultText))
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("extra_key_defaulttext", localWebpageObject.defaultText);
          localObject = new e().a((HashMap)localObject);
        }
        localBundle.putString("_weibo_message_media_extra", (String)localObject);
      }
    }
    for (;;)
    {
      a(this.activity, i.a(this.activity).a(), this.c, localBundle);
      return;
      if ((this.d.getImageData() != null) || (!TextUtils.isEmpty(this.d.getImagePath())))
      {
        this.a = 2097152L;
        localObject = g();
        if (((ImageObject)localObject).checkArgs())
        {
          localBundle.putParcelable("_weibo_message_image", (Parcelable)localObject);
          localBundle.putString("_weibo_message_image_extra", "");
        }
      }
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      finish();
      return;
      if (this.e != null)
      {
        this.e.onComplete(null);
        continue;
        if (this.e != null)
        {
          this.e.onCancel();
          continue;
          if (this.e != null) {
            this.e.onError(new Throwable(paramString));
          }
        }
      }
    }
  }
  
  private boolean a(Activity paramActivity, String paramString1, String paramString2, Bundle paramBundle)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty("com.sina.weibo.sdk.action.ACTION_WEIBO_ACTIVITY")) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      cn.sharesdk.framework.utils.d.a().e("launchWeiboActivity fail, invalid arguments", new Object[0]);
      return false;
    }
    String str = paramActivity.getPackageName();
    Intent localIntent = new Intent();
    localIntent.setPackage(paramString1);
    localIntent.setAction("com.sina.weibo.sdk.action.ACTION_WEIBO_ACTIVITY");
    localIntent.putExtra("_weibo_sdkVersion", "0031205000");
    localIntent.putExtra("_weibo_appPackage", str);
    localIntent.putExtra("_weibo_appKey", paramString2);
    localIntent.putExtra("_weibo_flag", 538116905);
    localIntent.putExtra("_weibo_sign", b.b(a(paramActivity, str)));
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    try
    {
      cn.sharesdk.framework.utils.d.a().d("launchWeiboActivity intent=" + localIntent + ", extra=" + localIntent.getExtras(), new Object[0]);
      paramActivity.startActivityForResult(localIntent, 765);
      return true;
    }
    catch (ActivityNotFoundException paramActivity)
    {
      cn.sharesdk.framework.utils.d.a().e(paramActivity.getMessage(), new Object[0]);
    }
    return false;
  }
  
  private byte[] a(Context paramContext, Bitmap paramBitmap)
  {
    Object localObject = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject);
    ((ByteArrayOutputStream)localObject).flush();
    ((ByteArrayOutputStream)localObject).close();
    paramBitmap = ((ByteArrayOutputStream)localObject).toByteArray();
    localObject = com.mob.tools.b.a.a(paramBitmap);
    int i = g.a(paramContext, 120);
    if (Bitmap.CompressFormat.PNG == localObject) {
      i = g.a(paramContext, 90);
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    if (paramBitmap.length > this.a)
    {
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(paramBitmap, 0, paramBitmap.length, localOptions);
      localOptions.inSampleSize = a(localOptions, i, i);
    }
    localOptions.inJustDecodeBounds = false;
    return a(paramContext, BitmapFactory.decodeByteArray(paramBitmap, 0, paramBitmap.length, localOptions), (Bitmap.CompressFormat)localObject);
  }
  
  private byte[] a(Context paramContext, Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat)
  {
    if (paramBitmap == null) {
      throw new RuntimeException("checkArgs fail, thumbData is null");
    }
    if (paramBitmap.isRecycled()) {
      throw new RuntimeException("checkArgs fail, thumbData is recycled");
    }
    int i = 120;
    while (a(paramBitmap, paramCompressFormat) > this.a)
    {
      int j = g.a(paramContext, i);
      i -= 5;
      paramBitmap = a(paramBitmap, j);
    }
    paramContext = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, paramContext);
    paramContext.flush();
    paramContext.close();
    return paramContext.toByteArray();
  }
  
  private void b()
  {
    j.a(1, 200L, this);
  }
  
  private byte[] b(Context paramContext, String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists()) {
      throw new FileNotFoundException();
    }
    Bitmap.CompressFormat localCompressFormat = com.mob.tools.b.a.b(paramString);
    int i = g.a(paramContext, 120);
    if (Bitmap.CompressFormat.PNG == localCompressFormat) {
      i = g.a(paramContext, 90);
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    if (localFile.length() > this.a)
    {
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      localOptions.inSampleSize = a(localOptions, i, i);
    }
    localOptions.inJustDecodeBounds = false;
    paramString = BitmapFactory.decodeFile(paramString, localOptions);
    if (paramString == null)
    {
      localFile.delete();
      throw new RuntimeException("checkArgs fail, thumbData is null");
    }
    return a(paramContext, paramString, localCompressFormat);
  }
  
  private void c()
  {
    Intent localIntent = new Intent("com.sina.weibo.sdk.Intent.ACTION_WEIBO_REGISTER");
    String str = this.activity.getPackageName();
    localIntent.putExtra("_weibo_sdkVersion", "0031205000");
    localIntent.putExtra("_weibo_appPackage", str);
    localIntent.putExtra("_weibo_appKey", this.c);
    localIntent.putExtra("_weibo_flag", 538116905);
    localIntent.putExtra("_weibo_sign", b.b(a(this.activity, str)));
    cn.sharesdk.framework.utils.d.a().d("intent=" + localIntent + ", extra=" + localIntent.getExtras(), new Object[0]);
    this.activity.sendBroadcast(localIntent, "com.sina.weibo.permission.WEIBO_SDK_PERMISSION");
  }
  
  private String d()
  {
    return UUID.randomUUID().toString().replace("-", "");
  }
  
  private TextObject e()
  {
    TextObject localTextObject = new TextObject();
    localTextObject.text = this.d.getText();
    return localTextObject;
  }
  
  private WebpageObject f()
  {
    WebpageObject localWebpageObject = new WebpageObject();
    localWebpageObject.identify = d();
    localWebpageObject.title = this.d.getTitle();
    localWebpageObject.description = this.d.getText();
    try
    {
      if (this.d.getImageData() != null) {
        localWebpageObject.thumbData = a(this.activity, this.d.getImageData());
      }
      for (;;)
      {
        localWebpageObject.actionUrl = this.d.getUrl();
        localWebpageObject.defaultText = this.d.getText();
        return localWebpageObject;
        if (!TextUtils.isEmpty(this.d.getImagePath())) {
          localWebpageObject.thumbData = b(this.activity, this.d.getImagePath());
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        cn.sharesdk.framework.utils.d.a().w(localThrowable);
        localWebpageObject.setThumbImage(null);
      }
    }
  }
  
  private ImageObject g()
  {
    ImageObject localImageObject3 = new ImageObject();
    try
    {
      if (this.d.getImageData() != null)
      {
        localImageObject3.imageData = a(this.activity, this.d.getImageData());
        return localImageObject3;
      }
      ImageObject localImageObject1 = localImageObject3;
      if (!TextUtils.isEmpty(this.d.getImagePath()))
      {
        localImageObject3.imageData = b(this.activity, this.d.getImagePath());
        return localImageObject3;
      }
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.d.a().w(localThrowable);
      ImageObject localImageObject2 = null;
      return localImageObject2;
    }
  }
  
  public void a(Platform.ShareParams paramShareParams)
  {
    this.d = paramShareParams;
  }
  
  public void a(AuthorizeListener paramAuthorizeListener)
  {
    this.e = paramAuthorizeListener;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      if ((!this.b) && (this.e != null)) {
        this.e.onCancel();
      }
      finish();
    }
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    cn.sharesdk.framework.utils.d.a().d("sina activity requestCode = %s, resultCode = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt1) });
    b();
  }
  
  public void onCreate()
  {
    c();
    a();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    this.b = true;
    Bundle localBundle = paramIntent.getExtras();
    cn.sharesdk.framework.utils.d.a().i("onNewIntent ==>>", new Object[] { localBundle.toString() });
    String str1 = paramIntent.getStringExtra("_weibo_appPackage");
    paramIntent = paramIntent.getStringExtra("_weibo_transaction");
    if (TextUtils.isEmpty(str1))
    {
      cn.sharesdk.framework.utils.d.a().e("handleWeiboResponse faild appPackage is null", new Object[0]);
      return;
    }
    String str2 = this.activity.getCallingPackage();
    cn.sharesdk.framework.utils.d.a().d("handleWeiboResponse getCallingPackage : " + str2, new Object[0]);
    if (TextUtils.isEmpty(paramIntent))
    {
      cn.sharesdk.framework.utils.d.a().e("handleWeiboResponse faild intent _weibo_transaction is null", new Object[0]);
      return;
    }
    if ((!i.a(this.activity, str1)) && (!str1.equals(this.activity.getPackageName())))
    {
      cn.sharesdk.framework.utils.d.a().e("handleWeiboResponse faild appPackage validateSign faild", new Object[0]);
      return;
    }
    a(localBundle.getInt("_weibo_resp_errcode"), localBundle.getString("_weibo_resp_errstr"));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\sina\weibo\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */