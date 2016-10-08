package d.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class cd
{
  public static String a(Context paramContext)
  {
    return "/data/data/" + paramContext.getPackageName() + "/databases/cc/";
  }
  
  public static String a(List<String> paramList)
  {
    return TextUtils.join("!", paramList);
  }
  
  public static List<String> a(String paramString)
  {
    return new ArrayList(Arrays.asList(paramString.split("!")));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */