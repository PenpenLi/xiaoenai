package com.inmobi.rendering;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.inmobi.ads.b.c;
import com.inmobi.ads.b.e;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.info.DisplayInfo;
import com.inmobi.commons.core.utilities.info.c;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"ClickableViewAccessibility"})
public class InMobiAdActivity
  extends Activity
{
  @SuppressLint({"UseSparseArrays"})
  public static Map<Integer, a> a = new HashMap();
  @SuppressLint({"UseSparseArrays"})
  public static Map<Integer, Intent> b = new HashMap();
  public static Integer c = Integer.valueOf(0);
  @SuppressLint({"UseSparseArrays"})
  public static Map<Integer, c> d = new HashMap();
  public static Integer e = Integer.valueOf(0);
  private static final String f = InMobiAdActivity.class.getSimpleName();
  private static Map<Integer, RenderView> g = new HashMap();
  private static RenderView h;
  private RenderView i;
  private RenderView j;
  private CustomView k;
  private CustomView l;
  private int m;
  private boolean n = false;
  
  public static int a(Intent paramIntent, a parama)
  {
    Integer localInteger = c;
    c = Integer.valueOf(c.intValue() + 1);
    a.put(c, parama);
    b.put(c, paramIntent);
    return c.intValue();
  }
  
  private static int a(c paramc)
  {
    Integer localInteger = e;
    e = Integer.valueOf(e.intValue() + 1);
    d.put(e, paramc);
    return e.intValue();
  }
  
  public static int a(RenderView paramRenderView)
  {
    int i1 = paramRenderView.hashCode();
    g.put(Integer.valueOf(i1), paramRenderView);
    return i1;
  }
  
  private void a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(2, 65533);
    localRelativeLayout.setBackgroundColor(-1);
    localRelativeLayout.addView(this.j, localLayoutParams);
    a(localRelativeLayout);
    setContentView(localRelativeLayout);
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    float f1 = DisplayInfo.a().c();
    LinearLayout localLinearLayout = new LinearLayout(this);
    Object localObject = new RelativeLayout.LayoutParams(-1, (int)(48.0F * f1));
    localLinearLayout.setOrientation(0);
    localLinearLayout.setId(65533);
    localLinearLayout.setWeightSum(100.0F);
    localLinearLayout.setBackgroundResource(17301658);
    localLinearLayout.setBackgroundColor(-7829368);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    paramViewGroup.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject);
    paramViewGroup = new LinearLayout.LayoutParams(-1, -1);
    paramViewGroup.weight = 25.0F;
    localObject = new CustomView(this, f1, CustomView.SwitchIconType.CLOSE_ICON);
    ((CustomView)localObject).setOnTouchListener(new InMobiAdActivity.1(this));
    localLinearLayout.addView((View)localObject, paramViewGroup);
    localObject = new CustomView(this, f1, CustomView.SwitchIconType.REFRESH);
    ((CustomView)localObject).setOnTouchListener(new InMobiAdActivity.2(this));
    localLinearLayout.addView((View)localObject, paramViewGroup);
    localObject = new CustomView(this, f1, CustomView.SwitchIconType.BACK);
    ((CustomView)localObject).setOnTouchListener(new InMobiAdActivity.3(this));
    localLinearLayout.addView((View)localObject, paramViewGroup);
    localObject = new CustomView(this, f1, CustomView.SwitchIconType.FORWARD_INACTIVE);
    ((CustomView)localObject).setOnTouchListener(new InMobiAdActivity.4(this));
    localLinearLayout.addView((View)localObject, paramViewGroup);
  }
  
  public static void a(String[] paramArrayOfString, c paramc)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return;
    }
    int i1 = a(paramc);
    paramc = new Intent(com.inmobi.commons.a.a.b(), InMobiAdActivity.class);
    paramc.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 104);
    paramc.putExtra("id", i1);
    paramc.putExtra("permissions", paramArrayOfString);
    com.inmobi.commons.a.a.a(com.inmobi.commons.a.a.b(), paramc);
  }
  
  private void b()
  {
    FrameLayout localFrameLayout = (FrameLayout)findViewById(16908290);
    RelativeLayout localRelativeLayout = new RelativeLayout(this);
    float f1 = DisplayInfo.a().c();
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams1.addRule(10);
    if (this.i.getParent() != null) {
      ((ViewGroup)this.i.getParent()).removeView(this.i);
    }
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams((int)(50.0F * f1), (int)(50.0F * f1));
    localLayoutParams2.addRule(11);
    this.k = new CustomView(this, f1, CustomView.SwitchIconType.CLOSE_BUTTON);
    this.k.setId(65532);
    this.k.setOnClickListener(new InMobiAdActivity.5(this));
    this.l = new CustomView(this, f1, CustomView.SwitchIconType.CLOSE_TRANSPARENT);
    this.l.setId(65531);
    this.l.setOnClickListener(new InMobiAdActivity.6(this));
    localRelativeLayout.setId(65534);
    localRelativeLayout.addView(this.i, localLayoutParams1);
    localRelativeLayout.addView(this.k, localLayoutParams2);
    localRelativeLayout.addView(this.l, localLayoutParams2);
    localRelativeLayout.setBackgroundColor(0);
    localFrameLayout.addView(localRelativeLayout, new RelativeLayout.LayoutParams(-1, -1));
    this.i.b(this.i.f());
    this.i.c(this.i.e());
  }
  
  public static void b(@NonNull RenderView paramRenderView)
  {
    if ((RenderView)g.remove(Integer.valueOf(paramRenderView.hashCode())) == null) {
      Logger.a(Logger.InternalLogLevel.INTERNAL, f, "Failed to remove renderview with key:" + paramRenderView.hashCode());
    }
  }
  
  public static void c(RenderView paramRenderView)
  {
    h = paramRenderView;
  }
  
  void a(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    a locala = (a)a.get(Integer.valueOf(paramInt1));
    a.remove(Integer.valueOf(paramInt1));
    b.remove(Integer.valueOf(paramInt1));
    locala.a(paramInt2, paramIntent);
    this.n = true;
    finish();
  }
  
  public void onBackPressed()
  {
    if (this.m == 102) {
      if (this.i != null)
      {
        this.i.i();
        if (!this.i.g()) {}
      }
    }
    while (this.m != 100)
    {
      return;
      this.i.k();
      this.n = true;
      return;
    }
    this.n = true;
    finish();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.j != null) {
      this.j.l();
    }
  }
  
  @TargetApi(23)
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.m = getIntent().getIntExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 102);
    b.e locale;
    label87:
    b.c localc;
    if (this.m == 100)
    {
      String str = getIntent().getStringExtra("com.inmobi.rendering.InMobiAdActivity.IN_APP_BROWSER_URL");
      this.j = new RenderView(this, new RenderingProperties(RenderingProperties.PlacementType.FULL_SCREEN));
      if (h == null)
      {
        paramBundle = RenderView.a;
        if (h != null) {
          break label167;
        }
        locale = new b.e();
        if (h != null) {
          break label177;
        }
        localc = new b.c();
        label101:
        this.j.setIsInAppBrowser(true);
        this.j.a(paramBundle, locale, localc);
        a();
        this.j.loadUrl(str);
        this.j.getListener().e(this.j);
        this.j.setFullScreenActivity(this);
      }
    }
    label167:
    label177:
    int i1;
    label352:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramBundle = h.getListener();
            break;
            locale = h.getRenderingConfig();
            break label87;
            localc = h.getMraidConfig();
            break label101;
            if (this.m != 102) {
              break label352;
            }
          } while (!getIntent().hasExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_RENDERVIEW_INDEX"));
          i1 = getIntent().getIntExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_RENDERVIEW_INDEX", -1);
          this.i = ((RenderView)g.get(Integer.valueOf(i1)));
          if (this.i == null)
          {
            Logger.a(Logger.InternalLogLevel.INTERNAL, f, "Failed to find RenderView with key:" + i1);
            finish();
            return;
          }
          if (getIntent().getBooleanExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_IS_FULL_SCREEN", false))
          {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
          }
          b();
          this.i.setFullScreenActivity(this);
        } while (this.i.getAdScreenEventsListener() == null);
        this.i.getAdScreenEventsListener().a();
        return;
        if (this.m == 103)
        {
          i1 = getIntent().getIntExtra("id", -1);
          if (i1 == -1)
          {
            Logger.a(Logger.InternalLogLevel.INTERNAL, f, "Invalid Request Code Supplied for ACTIVITY_TYPE_FOR_RESULT");
            return;
          }
          startActivityForResult((Intent)b.get(Integer.valueOf(i1)), i1);
          return;
        }
      } while (this.m != 104);
      i1 = getIntent().getIntExtra("id", -1);
      if (i1 == -1)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, f, "Invalid Request Code Supplied for ACTIVITY_TYPE_PERMISSIONS_DIALOG");
        return;
      }
      paramBundle = getIntent().getStringArrayExtra("permissions");
    } while ((paramBundle == null) || (paramBundle.length <= 0));
    com.inmobi.commons.core.utilities.a.a();
    com.inmobi.commons.core.utilities.a.b();
    requestPermissions(paramBundle, i1);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.n)
    {
      if (this.m != 100) {
        break label44;
      }
      this.j.getListener().f(this.j);
      this.j.destroy();
    }
    label44:
    while ((this.m != 102) || (this.i == null) || (this.i.getAdScreenEventsListener() == null)) {
      return;
    }
    this.i.getAdScreenEventsListener().b();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    com.inmobi.commons.core.utilities.a.a();
    com.inmobi.commons.core.utilities.a.c();
    c localc = (c)d.get(Integer.valueOf(paramInt));
    d.remove(Integer.valueOf(paramInt));
    if (localc != null) {
      localc.a(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    finish();
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, Intent paramIntent);
  }
  
  public static abstract interface b
  {
    public abstract void a();
    
    public abstract void b();
  }
  
  public static abstract interface c
  {
    public abstract void a(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\InMobiAdActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */