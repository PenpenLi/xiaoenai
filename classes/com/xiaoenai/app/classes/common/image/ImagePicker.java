package com.xiaoenai.app.classes.common.image;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.xiaoenai.app.classes.common.BaseActivity;
import com.xiaoenai.app.classes.common.image.croper.CropImage;
import com.xiaoenai.app.model.ConfigCenter;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.ae;
import com.xiaoenai.app.utils.as;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class ImagePicker
{
  protected static b a;
  protected static Boolean c = Boolean.valueOf(false);
  protected static Boolean d = Boolean.valueOf(false);
  protected static int e = 0;
  protected static int f = 0;
  protected static String g = null;
  protected static int h = 0;
  private static String i = null;
  protected Activity b;
  
  public ImagePicker(Activity paramActivity)
  {
    g = null;
    this.b = paramActivity;
    c = Boolean.valueOf(false);
  }
  
  private static String c()
  {
    if (g == null) {
      g = com.xiaoenai.app.utils.e.b(String.valueOf(System.currentTimeMillis()) + ".jpg");
    }
    return g;
  }
  
  public void a(int paramInt)
  {
    g = null;
    h = paramInt;
    Intent localIntent = new Intent(this.b, ImagePickerActivity.class);
    this.b.startActivityForResult(localIntent, 21);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    c = Boolean.valueOf(true);
    e = paramInt1;
    f = paramInt2;
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    g = null;
    h = paramInt;
    paramActivity.startActivityForResult(new Intent(paramActivity, ImagePickerActivity.class), 5);
  }
  
  public void a(Fragment paramFragment, int paramInt)
  {
    g = null;
    h = paramInt;
    paramFragment.startActivityForResult(new Intent(paramFragment.getActivity(), ImagePickerActivity.class), 5);
  }
  
  @Deprecated
  public void a(b paramb)
  {
    a = paramb;
  }
  
  public void a(String paramString)
  {
    com.xiaoenai.app.classes.common.dialog.e locale = new com.xiaoenai.app.classes.common.dialog.e(this.b);
    locale.a(paramString);
    locale.a(2131100091, 1, new a(this, locale));
    locale.a(2131100088, 1, new f(this, locale));
    locale.setOnDismissListener(new g(this));
    locale.show();
  }
  
  public void a(String paramString, Fragment paramFragment, m paramm, a parama)
  {
    com.xiaoenai.app.classes.common.dialog.e locale = new com.xiaoenai.app.classes.common.dialog.e(paramFragment.getActivity());
    locale.a(paramString);
    locale.a(2131100091, 1, new b(this, locale, paramFragment));
    locale.a(2131100088, 1, new c(this, locale, parama));
    locale.a(2131100090, 1, new d(this, locale, paramm));
    locale.setOnDismissListener(new e(this));
    locale.show();
  }
  
  public void a(String paramString, a parama)
  {
    com.xiaoenai.app.classes.common.dialog.e locale = new com.xiaoenai.app.classes.common.dialog.e(this.b);
    if (paramString != null) {
      locale.a(paramString);
    }
    locale.a(2131100091, 1, new h(this, locale));
    locale.a(2131100088, 1, new i(this, locale, parama));
    locale.setOnDismissListener(new j(this));
    locale.show();
  }
  
  public void b(int paramInt)
  {
    g = null;
    h = paramInt;
    Intent localIntent = new Intent(this.b, ImagePickerActivity.class);
    this.b.startActivityForResult(localIntent, paramInt);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    d = Boolean.valueOf(true);
    e = paramInt1;
    f = paramInt2;
  }
  
  public static class ImagePickerActivity
    extends BaseActivity
  {
    private ProgressView a;
    
    private String a(Intent paramIntent)
    {
      Object localObject;
      if (paramIntent == null)
      {
        localObject = null;
        return (String)localObject;
      }
      Uri localUri;
      if (paramIntent.getData() != null)
      {
        localUri = paramIntent.getData();
        com.xiaoenai.app.utils.f.a.c("uri={}", new Object[] { localUri.toString() });
        localObject = localUri.getPath();
        if (localObject == null) {
          paramIntent = a(localUri);
        }
      }
      for (;;)
      {
        if (paramIntent != null)
        {
          localObject = paramIntent;
          if (new File(paramIntent).exists()) {
            break;
          }
        }
        return null;
        paramIntent = (Intent)localObject;
        if (!new File((String)localObject).exists())
        {
          paramIntent = a(localUri);
          continue;
          paramIntent = paramIntent.getExtras();
          if (paramIntent != null)
          {
            paramIntent = (Bitmap)paramIntent.getParcelable("data");
            if (paramIntent != null)
            {
              paramIntent = a(paramIntent);
              continue;
            }
          }
          paramIntent = null;
        }
      }
    }
    
    private String a(Bitmap paramBitmap)
    {
      String str = ImagePicker.b();
      Object localObject = new File(str);
      try
      {
        localObject = new BufferedOutputStream(new FileOutputStream((File)localObject));
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject);
        return str;
      }
      catch (FileNotFoundException paramBitmap)
      {
        paramBitmap.printStackTrace();
      }
      return null;
    }
    
    private String a(Uri paramUri)
    {
      String str2 = b(paramUri);
      String str1 = str2;
      if (str2 == null)
      {
        paramUri = c(paramUri);
        str1 = str2;
        if (paramUri != null) {
          str1 = a(paramUri);
        }
      }
      return str1;
    }
    
    private void a()
    {
      if (ImagePicker.a == null) {
        if (ImagePicker.a() != null)
        {
          Intent localIntent = new Intent();
          localIntent.setData(as.b(ImagePicker.a()));
          setResult(-1, localIntent);
        }
      }
      for (;;)
      {
        ImagePicker.d = Boolean.valueOf(false);
        ImagePicker.c = Boolean.valueOf(false);
        ImagePicker.e = 0;
        ImagePicker.f = 0;
        ImagePicker.h = 0;
        ImagePicker.a = null;
        return;
        setResult(0);
        continue;
        if (ImagePicker.a() == null) {
          ImagePicker.a.a();
        } else {
          ImagePicker.a.a(ImagePicker.a());
        }
      }
    }
    
    private String b(Uri paramUri)
    {
      if (paramUri != null) {
        for (;;)
        {
          try
          {
            Cursor localCursor = getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
            if ((localCursor != null) && (localCursor.moveToFirst()))
            {
              paramUri = localCursor.getString(localCursor.getColumnIndexOrThrow("_data"));
              if (localCursor == null) {}
            }
            paramUri = null;
          }
          catch (Exception localException1)
          {
            try
            {
              localCursor.close();
              return paramUri;
            }
            catch (Exception localException2)
            {
              continue;
            }
            localException1 = localException1;
            paramUri = null;
            localException1.printStackTrace();
            return paramUri;
          }
        }
      }
      return null;
    }
    
    private Bitmap c(Uri paramUri)
    {
      try
      {
        paramUri = MediaStore.Images.Media.getBitmap(getContentResolver(), paramUri);
        return paramUri;
      }
      catch (Exception paramUri)
      {
        paramUri.printStackTrace();
      }
      return null;
    }
    
    public void b(String paramString, boolean paramBoolean)
    {
      Intent localIntent = new Intent(this, CropImage.class);
      localIntent.addCategory("android.intent.category.ALTERNATIVE");
      localIntent.putExtra("scale", true);
      localIntent.putExtra("aspectX", ImagePicker.e);
      localIntent.putExtra("aspectY", ImagePicker.f);
      localIntent.putExtra("outputX", ImagePicker.e);
      localIntent.putExtra("outputY", ImagePicker.f);
      localIntent.putExtra("noFaceDetection", true);
      localIntent.putExtra("return-data", false);
      localIntent.putExtra("image-path", paramString);
      ImagePicker.g = null;
      localIntent.putExtra("output", ImagePicker.b());
      localIntent.putExtra("needCrop", paramBoolean);
      localIntent.putExtra("scaleBeforeShow", ImagePicker.d);
      startActivityForResult(localIntent, 5);
    }
    
    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      if (paramInt2 == -1)
      {
        if (paramInt1 == 3)
        {
          ImagePicker.b(ImagePicker.b());
          a();
          finish();
          return;
        }
        if (paramInt1 == 1)
        {
          paramIntent = a(paramIntent);
          if (paramIntent != null)
          {
            b(paramIntent, false);
            return;
          }
          as.b(2131100089);
          a();
          finish();
          return;
        }
        if (paramInt1 == 2)
        {
          paramIntent = a(paramIntent);
          if (paramIntent != null)
          {
            b(paramIntent, true);
            return;
          }
          as.b(2131100089);
          a();
          finish();
          return;
        }
        if (paramInt1 == 4)
        {
          b(ImagePicker.b(), true);
          return;
        }
        if (paramInt1 == 5)
        {
          Object localObject = a(paramIntent);
          paramIntent = (Intent)localObject;
          if (localObject == null) {
            paramIntent = ImagePicker.b();
          }
          localObject = new File(paramIntent);
          if ((((File)localObject).exists()) && (((File)localObject).length() > 0L))
          {
            ImagePicker.b(paramIntent);
            a();
            finish();
            return;
          }
          a();
          finish();
          return;
        }
        a();
        finish();
        return;
      }
      a();
      finish();
    }
    
    protected void onCreate(Bundle paramBundle)
    {
      super.onCreate(paramBundle);
      Object localObject = new RelativeLayout(this);
      ((RelativeLayout)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.a = new ProgressView(this);
      this.a.setType(ProgressView.a);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(ab.a(40.0F), ab.a(40.0F));
      localLayoutParams.addRule(13);
      this.a.setLayoutParams(localLayoutParams);
      ((RelativeLayout)localObject).addView(this.a);
      this.d = false;
      setContentView((View)localObject);
      if (paramBundle != null)
      {
        ImagePicker.b(paramBundle.getString("path"));
        ImagePicker.g = ImagePicker.a();
        com.xiaoenai.app.utils.f.a.a("restore from savedInstanceState!!! path={}", new Object[] { ImagePicker.a() });
      }
      label241:
      do
      {
        do
        {
          return;
          ImagePicker.b(null);
          if (ImagePicker.h == 1)
          {
            paramBundle = new Intent("android.intent.action.PICK");
            paramBundle.setType("image/*");
            try
            {
              if (ImagePicker.c.booleanValue())
              {
                startActivityForResult(paramBundle, 2);
                return;
              }
            }
            catch (Exception paramBundle)
            {
              paramBundle = new Intent("android.intent.action.PICK");
              paramBundle.setType("image/*");
              try
              {
                if (!ImagePicker.c.booleanValue()) {
                  break label241;
                }
                startActivityForResult(paramBundle, 2);
                return;
              }
              catch (Exception paramBundle)
              {
                paramBundle.printStackTrace();
                as.b(2131100095);
                return;
              }
              startActivityForResult(paramBundle, 1);
              return;
            }
            startActivityForResult(paramBundle, 1);
            return;
          }
        } while (ImagePicker.h != 0);
        if (as.g(this, "android.permission.CAMERA"))
        {
          paramBundle = new Intent();
          paramBundle.setAction("android.media.action.IMAGE_CAPTURE");
          paramBundle.putExtra("output", Uri.fromFile(new File(ImagePicker.b())));
          try
          {
            if (ImagePicker.c.booleanValue())
            {
              startActivityForResult(paramBundle, 4);
              return;
            }
          }
          catch (Exception paramBundle)
          {
            paramBundle.printStackTrace();
            as.b(2131100094);
            return;
          }
          startActivityForResult(paramBundle, 3);
          return;
        }
        paramBundle = ConfigCenter.getHelpPage();
      } while (ae.a(paramBundle));
      localObject = new com.xiaoenai.app.ui.a.k(this);
      ((com.xiaoenai.app.ui.a.k)localObject).d(com.xiaoenai.app.ui.a.k.i);
      ((com.xiaoenai.app.ui.a.k)localObject).a(2131099706, 2131100054, new k(this), 2131099685, new l(this, paramBundle));
    }
    
    protected void onDestroy()
    {
      super.onDestroy();
    }
    
    protected void onSaveInstanceState(Bundle paramBundle)
    {
      super.onSaveInstanceState(paramBundle);
      if (ImagePicker.g != null) {
        paramBundle.putString("path", ImagePicker.g);
      }
      com.xiaoenai.app.utils.f.a.c("onSaveInstanceState={}", new Object[] { paramBundle });
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
  
  public static abstract interface b
  {
    public abstract void a();
    
    public abstract void a(String paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\image\ImagePicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */