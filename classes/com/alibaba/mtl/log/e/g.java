package com.alibaba.mtl.log.e;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Comparator;

public class g
{
  private static g jdField_a_of_type_ComAlibabaMtlLogEG = new g();
  private a jdField_a_of_type_ComAlibabaMtlLogEG$a = new a(null);
  private b jdField_a_of_type_ComAlibabaMtlLogEG$b = new b(null);
  
  public static g a()
  {
    return jdField_a_of_type_ComAlibabaMtlLogEG;
  }
  
  public String[] a(String[] paramArrayOfString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = this.jdField_a_of_type_ComAlibabaMtlLogEG$a; (localObject != null) && (paramArrayOfString != null) && (paramArrayOfString.length > 0); localObject = this.jdField_a_of_type_ComAlibabaMtlLogEG$b)
    {
      Arrays.sort(paramArrayOfString, (Comparator)localObject);
      return paramArrayOfString;
    }
    return null;
  }
  
  private class a
    implements Comparator<String>
  {
    private a() {}
    
    public int compare(String paramString1, String paramString2)
    {
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
        return paramString1.compareTo(paramString2);
      }
      return 0;
    }
  }
  
  private class b
    implements Comparator<String>
  {
    private b() {}
    
    public int compare(String paramString1, String paramString2)
    {
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
        return paramString1.compareTo(paramString2) * -1;
      }
      return 0;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\e\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */