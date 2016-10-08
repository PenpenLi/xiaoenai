package com.xiaoenai.app.classes.common.image.croper;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Parcelable;
import android.os.StatFs;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.Toast;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.d.w;
import com.xiaoenai.app.utils.k;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CropImage
  extends MonitoredActivity
{
  boolean a;
  boolean b;
  l c;
  Runnable d = new j(this);
  private Bitmap.CompressFormat e = Bitmap.CompressFormat.JPEG;
  private Uri f = null;
  private int g;
  private int h;
  private boolean i = false;
  private final Handler j = new Handler();
  private int k;
  private int l;
  private boolean m;
  private boolean n = true;
  private boolean o = true;
  private boolean p = false;
  private boolean q = false;
  private CropImageView r;
  private ContentResolver s;
  private Bitmap t;
  private final a.b u = new a.b();
  private m v;
  private String w;
  private boolean x = false;
  
  public static int a()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().toString());
      float f1 = localStatFs.getAvailableBlocks();
      int i1 = localStatFs.getBlockSize();
      return (int)(f1 * i1 / 400000.0F);
    }
    catch (Exception localException) {}
    return -2;
  }
  
  private Bitmap a(Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    Object localObject;
    if (paramBitmap == null) {
      localObject = null;
    }
    for (;;)
    {
      return (Bitmap)localObject;
      paramFloat1 /= paramBitmap.getWidth();
      paramFloat2 /= paramBitmap.getHeight();
      localObject = new Matrix();
      paramFloat1 = Math.max(paramFloat1, paramFloat2);
      ((Matrix)localObject).postScale(paramFloat1, paramFloat1);
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
        localObject = paramBitmap;
        if (paramBitmap != localBitmap)
        {
          paramBitmap.recycle();
          return localBitmap;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError) {}
    }
    return paramBitmap;
  }
  
  private Uri a(String paramString)
  {
    return Uri.fromFile(new File(paramString));
  }
  
  public static void a(Activity paramActivity)
  {
    a(paramActivity, a());
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    String str = null;
    if (paramInt == -1) {
      if (Environment.getExternalStorageState().equals("checking")) {
        str = "Preparing card";
      }
    }
    for (;;)
    {
      if (str != null) {
        Toast.makeText(paramActivity, str, 1).show();
      }
      return;
      str = "No storage card";
      continue;
      if (paramInt < 1) {
        str = "Not enough space";
      }
    }
  }
  
  private void a(Bitmap paramBitmap)
  {
    Object localObject2;
    Object localObject1;
    if (this.f != null)
    {
      localObject2 = null;
      localObject1 = null;
      try
      {
        OutputStream localOutputStream = this.s.openOutputStream(this.f);
        if (localOutputStream != null)
        {
          localObject1 = localOutputStream;
          localObject2 = localOutputStream;
          paramBitmap.compress(this.e, 100, localOutputStream);
        }
        q.a(localOutputStream);
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localObject2 = localObject1;
          localIOException.printStackTrace();
          localObject2 = localObject1;
          Log.e("crop", "save bitmap error");
          localObject2 = localObject1;
          this.f = a(this.w);
          q.a((Closeable)localObject1);
        }
      }
      finally
      {
        q.a((Closeable)localObject2);
      }
      localObject1 = getIntent();
      ((Intent)localObject1).setData(this.f);
      setResult(-1, (Intent)localObject1);
    }
    for (;;)
    {
      paramBitmap.recycle();
      finish();
      return;
      Log.e("crop", "mSaveUri is null");
    }
  }
  
  private Bitmap b(String paramString)
  {
    int i2 = 1;
    paramString = a(paramString);
    try
    {
      if (ab.a() > ab.b()) {}
      Object localObject;
      for (int i1 = ab.a();; i1 = ab.b())
      {
        localObject = this.s.openInputStream(paramString);
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeStream((InputStream)localObject, null, localOptions);
        ((InputStream)localObject).close();
        if ((localOptions.outHeight > i1) || (localOptions.outWidth > i1)) {
          i2 = (int)Math.pow(2.0D, (int)Math.round(Math.log(i1 / Math.max(localOptions.outHeight, localOptions.outWidth)) / Math.log(0.5D)));
        }
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inSampleSize = i2;
        if (!this.i) {
          ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
        }
        paramString = this.s.openInputStream(paramString);
        localObject = BitmapFactory.decodeStream(paramString, null, (BitmapFactory.Options)localObject);
        paramString.close();
        if ((!this.p) || (this.k >= ((Bitmap)localObject).getWidth()) || (this.l >= ((Bitmap)localObject).getHeight())) {
          break;
        }
        return a((Bitmap)localObject, this.k, this.l);
      }
      return (Bitmap)localObject;
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private void b()
  {
    if (isFinishing()) {
      return;
    }
    this.r.a(this.t, true);
    q.a(this, null, "Please wait…", new g(this), this.j);
  }
  
  private void c()
  {
    if (this.b) {}
    while ((this.o) && (this.c == null)) {
      return;
    }
    this.b = true;
    System.gc();
    Rect localRect1;
    int i1;
    int i2;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.o)
    {
      localRect1 = this.c.b();
      i1 = localRect1.width();
      i2 = localRect1.height();
      if (this.i)
      {
        localObject1 = Bitmap.Config.ARGB_8888;
        localObject2 = Bitmap.createBitmap(i1, i2, (Bitmap.Config)localObject1);
        localObject1 = new Canvas((Bitmap)localObject2);
        localObject3 = new Rect(0, 0, i1, i2);
        ((Canvas)localObject1).drawBitmap(this.t, localRect1, (Rect)localObject3, null);
        if (this.i)
        {
          localObject1 = new Canvas((Bitmap)localObject2);
          localObject3 = new Path();
          ((Path)localObject3).addCircle(i1 / 2.0F, i2 / 2.0F, i1 / 2.0F, Path.Direction.CW);
          ((Canvas)localObject1).clipPath((Path)localObject3, Region.Op.DIFFERENCE);
          ((Canvas)localObject1).drawColor(0, PorterDuff.Mode.CLEAR);
        }
        localObject1 = localObject2;
        if (this.k != 0)
        {
          localObject1 = localObject2;
          if (this.l != 0)
          {
            if ((((Bitmap)localObject2).getWidth() > this.k) || (((Bitmap)localObject2).getHeight() > this.l)) {
              break label306;
            }
            localObject1 = localObject2;
          }
        }
        label221:
        System.gc();
      }
    }
    for (;;)
    {
      localObject2 = getIntent().getExtras();
      if ((localObject2 == null) || ((((Bundle)localObject2).getParcelable("data") == null) && (!((Bundle)localObject2).getBoolean("return-data")))) {
        break label484;
      }
      localObject2 = new Bundle();
      ((Bundle)localObject2).putParcelable("data", (Parcelable)localObject1);
      setResult(-1, new Intent().setAction("inline-data").putExtras((Bundle)localObject2));
      finish();
      return;
      localObject1 = Bitmap.Config.RGB_565;
      break;
      label306:
      if (this.m)
      {
        localObject1 = q.a(new Matrix(), (Bitmap)localObject2, this.k, this.l, this.n);
        if (localObject2 != localObject1) {
          ((Bitmap)localObject2).recycle();
        }
        break label221;
      }
      localObject1 = Bitmap.createBitmap(this.k, this.l, Bitmap.Config.RGB_565);
      localObject3 = new Canvas((Bitmap)localObject1);
      Rect localRect2 = new Rect(0, 0, this.k, this.l);
      i1 = (localRect1.width() - localRect2.width()) / 2;
      i2 = (localRect1.height() - localRect2.height()) / 2;
      localRect1.inset(Math.max(0, i1), Math.max(0, i2));
      localRect2.inset(Math.max(0, -i1), Math.max(0, -i2));
      ((Canvas)localObject3).drawBitmap(this.t, localRect1, localRect2, null);
      ((Bitmap)localObject2).recycle();
      break label221;
      localObject1 = this.t;
    }
    label484:
    if ((!this.o) && (!this.i) && (!this.x))
    {
      this.f = a(this.w);
      localObject2 = getIntent();
      ((Intent)localObject2).setData(this.f);
      setResult(-1, (Intent)localObject2);
      ((Bitmap)localObject1).recycle();
      finish();
      return;
    }
    q.a(this, null, getString(2131101064), new i(this, (Bitmap)localObject1), this.j);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.s = getContentResolver();
    requestWindowFeature(1);
    setContentView(2130903147);
    this.r = ((CropImageView)findViewById(2131558574));
    a(this);
    paramBundle = getIntent().getExtras();
    if (paramBundle != null)
    {
      this.p = paramBundle.getBoolean("scaleBeforeShow", false);
      if (paramBundle.getString("circleCrop") != null)
      {
        this.i = true;
        this.g = 1;
        this.h = 1;
      }
      this.w = paramBundle.getString("image-path");
      if (paramBundle.getString("output") == null) {
        break label271;
      }
    }
    label271:
    for (this.f = a(paramBundle.getString("output"));; this.f = a(this.w))
    {
      this.g = paramBundle.getInt("aspectX");
      this.h = paramBundle.getInt("aspectY");
      this.k = paramBundle.getInt("outputX");
      this.l = paramBundle.getInt("outputY");
      this.m = paramBundle.getBoolean("scale", true);
      this.n = paramBundle.getBoolean("scaleUpIfNeeded", true);
      this.o = paramBundle.getBoolean("needCrop", true);
      if (this.i) {
        this.e = Bitmap.CompressFormat.PNG;
      }
      int i1 = k.b(this.w);
      this.t = b(this.w);
      if (i1 != 0) {
        this.t = k.a(this.t, i1);
      }
      if (this.t != null) {
        break;
      }
      finish();
      return;
    }
    if (this.p) {
      this.r.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    paramBundle = (Button)findViewById(2131558975);
    paramBundle.setOnTouchListener(w.a);
    paramBundle.setOnClickListener(new c(this));
    paramBundle = (Button)findViewById(2131558976);
    if (!this.o) {
      paramBundle.setText(2131100086);
    }
    paramBundle.setOnTouchListener(w.a);
    paramBundle.setOnClickListener(new d(this));
    ((ImageView)findViewById(2131558973)).setOnClickListener(new e(this));
    ((ImageView)findViewById(2131558974)).setOnClickListener(new f(this));
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.t != null) {
      this.t.recycle();
    }
    System.gc();
    Runtime.getRuntime().gc();
  }
  
  protected void onPause()
  {
    super.onPause();
    a.a().a(this.u);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\image\croper\CropImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */