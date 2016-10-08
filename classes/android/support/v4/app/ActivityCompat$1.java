package android.support.v4.app;

import android.app.Activity;
import android.content.pm.PackageManager;

final class ActivityCompat$1
  implements Runnable
{
  ActivityCompat$1(String[] paramArrayOfString, Activity paramActivity, int paramInt) {}
  
  public void run()
  {
    int[] arrayOfInt = new int[this.val$permissions.length];
    PackageManager localPackageManager = this.val$activity.getPackageManager();
    String str = this.val$activity.getPackageName();
    int j = this.val$permissions.length;
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = localPackageManager.checkPermission(this.val$permissions[i], str);
      i += 1;
    }
    ((ActivityCompat.OnRequestPermissionsResultCallback)this.val$activity).onRequestPermissionsResult(this.val$requestCode, this.val$permissions, arrayOfInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\app\ActivityCompat$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */