package com.ut.mini.internal;

import android.text.TextUtils;
import com.ut.mini.UTHitBuilders.UTHitBuilder;
import java.util.Map;

public class UTOriginalCustomHitBuilder
  extends UTHitBuilders.UTHitBuilder
{
  public UTOriginalCustomHitBuilder(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      super.setProperty("_field_page", paramString1);
    }
    super.setProperty("_field_event_id", "" + paramInt);
    if (!TextUtils.isEmpty(paramString2)) {
      super.setProperty("_field_arg1", paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      super.setProperty("_field_arg2", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      super.setProperty("_field_arg3", paramString4);
    }
    super.setProperties(paramMap);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\ut\mini\internal\UTOriginalCustomHitBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */