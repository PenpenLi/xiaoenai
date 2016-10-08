package com.xiaoenai.app.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.xiaoenai.app.classes.common.image.croper.CropImage;
import com.xiaoenai.app.net.b;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.n;
import com.xiaoenai.app.widget.imagepicker.BaseImagePickerActivity;
import org.json.JSONObject;

public class g
{
  private static g a = null;
  
  public static g a()
  {
    try
    {
      if (a == null) {
        a = new g();
      }
      g localg = a;
      return localg;
    }
    finally {}
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, String paramString2, Context paramContext, a parama, int paramInt3)
  {
    new b(new i(this, paramContext, parama, paramString1)).a(paramString2, paramInt1, paramInt2, paramInt3);
  }
  
  public String a(String paramString)
  {
    String str = paramString;
    if (paramString.contains("file://")) {
      str = paramString.substring("file://".length());
    }
    return str;
  }
  
  public void a(Activity paramActivity)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, BaseImagePickerActivity.class);
    localIntent.putExtra("max_selected_size", 1);
    paramActivity.startActivityForResult(localIntent, 21);
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, BaseImagePickerActivity.class);
    localIntent.putExtra("max_selected_size", 1);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public void a(Fragment paramFragment)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramFragment.getActivity(), BaseImagePickerActivity.class);
    localIntent.putExtra("max_selected_size", 1);
    paramFragment.startActivityForResult(localIntent, 21);
  }
  
  public void a(String paramString, Activity paramActivity)
  {
    if (paramActivity != null) {
      new n(new j(this, paramActivity, paramActivity, paramString)).e(paramString);
    }
  }
  
  public void a(String paramString, Context paramContext, a parama, int paramInt)
  {
    paramContext = new n(new h(this, paramContext, parama, paramString, paramContext, paramInt));
    if (paramInt == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramContext.a(paramString, bool);
      return;
    }
  }
  
  public void a(String paramString, boolean paramBoolean, Fragment paramFragment, int paramInt1, int paramInt2, Activity paramActivity)
  {
    if (paramFragment != null) {}
    for (Object localObject = paramFragment.getActivity();; localObject = paramActivity)
    {
      localObject = new Intent((Context)localObject, CropImage.class);
      ((Intent)localObject).addCategory("android.intent.category.ALTERNATIVE");
      ((Intent)localObject).putExtra("scale", true);
      ((Intent)localObject).putExtra("aspectX", paramInt1);
      ((Intent)localObject).putExtra("aspectY", paramInt2);
      ((Intent)localObject).putExtra("outputX", paramInt1);
      ((Intent)localObject).putExtra("outputY", paramInt2);
      ((Intent)localObject).putExtra("noFaceDetection", true);
      ((Intent)localObject).putExtra("return-data", false);
      ((Intent)localObject).putExtra("image-path", paramString);
      ((Intent)localObject).putExtra("output", e.b(String.valueOf(System.currentTimeMillis()) + ".jpg"));
      ((Intent)localObject).putExtra("needCrop", paramBoolean);
      ((Intent)localObject).putExtra("scaleBeforeShow", false);
      if (paramFragment == null) {
        break;
      }
      paramFragment.startActivityForResult((Intent)localObject, 5);
      return;
    }
    paramActivity.startActivityForResult((Intent)localObject, 5);
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(int paramInt);
    
    public abstract void a(k paramk);
    
    public abstract void a(JSONObject paramJSONObject, String paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */