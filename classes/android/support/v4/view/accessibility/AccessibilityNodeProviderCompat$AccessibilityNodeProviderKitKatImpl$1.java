package android.support.v4.view.accessibility;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

class AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl$1
  implements AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge
{
  AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl$1(AccessibilityNodeProviderCompat.AccessibilityNodeProviderKitKatImpl paramAccessibilityNodeProviderKitKatImpl, AccessibilityNodeProviderCompat paramAccessibilityNodeProviderCompat) {}
  
  public Object createAccessibilityNodeInfo(int paramInt)
  {
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = this.val$compat.createAccessibilityNodeInfo(paramInt);
    if (localAccessibilityNodeInfoCompat == null) {
      return null;
    }
    return localAccessibilityNodeInfoCompat.getInfo();
  }
  
  public List<Object> findAccessibilityNodeInfosByText(String paramString, int paramInt)
  {
    paramString = this.val$compat.findAccessibilityNodeInfosByText(paramString, paramInt);
    ArrayList localArrayList = new ArrayList();
    int i = paramString.size();
    paramInt = 0;
    while (paramInt < i)
    {
      localArrayList.add(((AccessibilityNodeInfoCompat)paramString.get(paramInt)).getInfo());
      paramInt += 1;
    }
    return localArrayList;
  }
  
  public Object findFocus(int paramInt)
  {
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = this.val$compat.findFocus(paramInt);
    if (localAccessibilityNodeInfoCompat == null) {
      return null;
    }
    return localAccessibilityNodeInfoCompat.getInfo();
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return this.val$compat.performAction(paramInt1, paramInt2, paramBundle);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\view\accessibility\AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */