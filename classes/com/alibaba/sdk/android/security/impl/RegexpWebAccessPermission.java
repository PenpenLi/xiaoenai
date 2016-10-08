package com.alibaba.sdk.android.security.impl;

import com.alibaba.sdk.android.security.WebAccessPermission;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpWebAccessPermission
  implements WebAccessPermission
{
  private Pattern pattern;
  
  public RegexpWebAccessPermission(String paramString)
  {
    this.pattern = Pattern.compile(paramString);
  }
  
  public boolean checkPermission(String paramString)
  {
    return this.pattern.matcher(paramString).matches();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\security\impl\RegexpWebAccessPermission.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */