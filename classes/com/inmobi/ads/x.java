package com.inmobi.ads;

import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.webkit.URLUtil;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.info.DisplayInfo;
import com.inmobi.commons.core.utilities.info.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@VisibleForTesting
class x
{
  private static final String a = x.class.getSimpleName();
  private JSONObject b;
  private String c;
  private JSONObject d;
  private v e;
  
  @VisibleForTesting
  x() {}
  
  public x(@NonNull JSONObject paramJSONObject)
  {
    this.b = paramJSONObject;
    g();
  }
  
  private NativeStrandAsset a(@NonNull JSONObject paramJSONObject, NativeStrandAsset.AssetType paramAssetType, String paramString)
  {
    Object localObject3 = c(paramJSONObject);
    Object localObject4 = e(paramJSONObject);
    if (!a((JSONObject)localObject4, paramAssetType))
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Invalid asset style for asset: " + (String)localObject3);
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Asset style JSON: " + localObject4);
      paramJSONObject = null;
      label84:
      return paramJSONObject;
    }
    Point localPoint1 = f(paramJSONObject);
    Point localPoint2 = g(paramJSONObject);
    ai[] arrayOfai = a(paramJSONObject);
    for (;;)
    {
      int i;
      Object localObject2;
      try
      {
        switch (x.1.a[paramAssetType.ordinal()])
        {
        case 1: 
          paramAssetType = a(localPoint1, localPoint2, (JSONObject)localObject4);
          if ((arrayOfai == null) || (arrayOfai.length == 0))
          {
            paramAssetType = new v((String)localObject3, paramAssetType, paramJSONObject);
            paramAssetType.a(paramString);
            localObject1 = paramJSONObject.getJSONArray("assetValue");
            i = 0;
            paramJSONObject = paramAssetType;
            if (i >= ((JSONArray)localObject1).length()) {
              break label84;
            }
            paramJSONObject = paramString + "." + "assetValue" + "[" + i + "]";
            localObject2 = ((JSONArray)localObject1).getJSONObject(i);
            localObject3 = a((JSONObject)localObject2, d(d((JSONObject)localObject2)), paramJSONObject);
            if (localObject3 != null) {
              break label343;
            }
            Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Cannot build asset from JSON: " + localObject2);
            break label812;
          }
          paramAssetType = new v((String)localObject3, paramAssetType, arrayOfai, paramJSONObject);
          continue;
          ((NativeStrandAsset)localObject3).a(paramJSONObject);
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return null;
      }
      label343:
      ((NativeStrandAsset)localObject3).a(paramAssetType);
      paramAssetType.b((NativeStrandAsset)localObject3);
      break label812;
      paramJSONObject = new ah((String)localObject3, b(localPoint1, localPoint2, (JSONObject)localObject4), h(paramJSONObject).getString(0));
      paramJSONObject.a(paramString);
      return paramJSONObject;
      paramJSONObject = new z((String)localObject3, a(localPoint1, localPoint2, (JSONObject)localObject4), b(paramJSONObject));
      paramJSONObject.a(paramString);
      return paramJSONObject;
      if (i(paramJSONObject)) {
        if (paramJSONObject.getJSONObject("assetOnclick").isNull("itemUrl")) {
          return null;
        }
      }
      for (Object localObject1 = paramJSONObject.getJSONObject("assetOnclick").getString("itemUrl");; localObject1 = "")
      {
        localObject4 = a(localPoint1, localPoint2, (JSONObject)localObject4);
        paramAssetType = NativeStrandAsset.AssetInteractionMode.ASSET_INTERACTION_MODE_NO_ACTION;
        if (i(paramJSONObject))
        {
          paramAssetType = NativeStrandAsset.AssetInteractionMode.ASSET_INTERACTION_MODE_BROWSER;
          if (!paramJSONObject.getJSONObject("assetOnclick").isNull("openMode")) {
            paramAssetType = c(paramJSONObject.getJSONObject("assetOnclick").getString("openMode"));
          }
        }
        for (localObject2 = a(paramAssetType, paramJSONObject.getJSONObject("assetOnclick"));; localObject2 = null)
        {
          if ((arrayOfai == null) || (arrayOfai.length == 0)) {}
          for (paramAssetType = new aa((String)localObject3, (t)localObject4, b(paramJSONObject), paramAssetType, paramJSONObject);; paramAssetType = new aa((String)localObject3, (t)localObject4, b(paramJSONObject), arrayOfai, paramAssetType, paramJSONObject))
          {
            paramAssetType.a(paramString);
            paramAssetType.b((String)localObject1);
            paramJSONObject = paramAssetType;
            if (localObject2 == null) {
              break;
            }
            paramAssetType.c((String)localObject2);
            return paramAssetType;
          }
          if (!i(paramJSONObject)) {
            return null;
          }
          localObject2 = paramJSONObject.getJSONObject("assetOnclick").getString("itemUrl");
          localObject4 = c(localPoint1, localPoint2, (JSONObject)localObject4);
          paramAssetType = NativeStrandAsset.AssetInteractionMode.ASSET_INTERACTION_MODE_BROWSER;
          if (!paramJSONObject.getJSONObject("assetOnclick").isNull("openMode")) {
            paramAssetType = c(paramJSONObject.getJSONObject("assetOnclick").getString("openMode"));
          }
          for (localObject1 = a(paramAssetType, paramJSONObject.getJSONObject("assetOnclick"));; localObject1 = null)
          {
            if ((arrayOfai == null) || (arrayOfai.length == 0)) {}
            for (paramAssetType = new w((String)localObject3, (t)localObject4, h(paramJSONObject).getString(0), paramAssetType, paramJSONObject);; paramAssetType = new w((String)localObject3, (t)localObject4, h(paramJSONObject).getString(0), arrayOfai, paramAssetType, paramJSONObject))
            {
              paramAssetType.a(paramString);
              paramAssetType.b((String)localObject2);
              paramJSONObject = paramAssetType;
              if (localObject1 == null) {
                break;
              }
              paramAssetType.c((String)localObject1);
              return paramAssetType;
            }
          }
        }
      }
      return null;
      label812:
      i += 1;
    }
    return null;
  }
  
  private ai.b a(@NonNull String paramString)
  {
    paramString = paramString.toUpperCase(Locale.US).trim();
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return ai.b.a;
        if (paramString.equals("URL_PING"))
        {
          i = 1;
          continue;
          if (paramString.equals("URL_WEBVIEW_PING"))
          {
            i = 2;
            continue;
            if (paramString.equals("HTML_SCRIPT")) {
              i = 3;
            }
          }
        }
        break;
      }
    }
    return ai.b.b;
    return ai.b.c;
    return ai.b.d;
  }
  
  private t a(@NonNull Point paramPoint1, @NonNull Point paramPoint2, @NonNull JSONObject paramJSONObject)
  {
    t.b localb;
    t.a locala;
    Object localObject;
    if (paramJSONObject.isNull("border"))
    {
      localb = t.b.a;
      locala = t.a.b;
      localObject = "#ff000000";
      if (!paramJSONObject.isNull("backgroundColor")) {
        break label190;
      }
    }
    label174:
    label190:
    for (paramJSONObject = "#00000000";; paramJSONObject = paramJSONObject.getString("backgroundColor").trim())
    {
      return new t(paramPoint1.x, paramPoint1.y, paramPoint2.x, paramPoint2.y, localb, locala, (String)localObject, paramJSONObject);
      localObject = paramJSONObject.getJSONObject("border");
      if (((JSONObject)localObject).isNull("style"))
      {
        localb = t.b.a;
        locala = t.a.b;
        localObject = "#ff000000";
        break;
      }
      localb = f(((JSONObject)localObject).getString("style"));
      if (((JSONObject)localObject).isNull("corner")) {}
      for (locala = t.a.b;; locala = g(((JSONObject)localObject).getString("corner")))
      {
        if (!((JSONObject)localObject).isNull("color")) {
          break label174;
        }
        localObject = "#ff000000";
        break;
      }
      localObject = ((JSONObject)localObject).getString("color").trim();
      break;
    }
  }
  
  private String a(@NonNull NativeStrandAsset.AssetInteractionMode paramAssetInteractionMode, @NonNull JSONObject paramJSONObject)
  {
    if ((paramAssetInteractionMode == NativeStrandAsset.AssetInteractionMode.ASSET_INTERACTION_MODE_DEEP_LINK) && (paramJSONObject.has("fallbackUrl"))) {
      return paramJSONObject.getString("fallbackUrl");
    }
    return null;
  }
  
  private boolean a(@NonNull v paramv)
  {
    return "card_container".equalsIgnoreCase(paramv.c());
  }
  
  private ah.a b(@NonNull Point paramPoint1, @NonNull Point paramPoint2, @NonNull JSONObject paramJSONObject)
  {
    t.b localb;
    t.a locala;
    Object localObject;
    String str1;
    label40:
    JSONObject localJSONObject;
    if (paramJSONObject.isNull("border"))
    {
      localb = t.b.a;
      locala = t.a.b;
      localObject = "#ff000000";
      if (!paramJSONObject.isNull("backgroundColor")) {
        break label275;
      }
      str1 = "#00000000";
      localJSONObject = paramJSONObject.getJSONObject("text");
    }
    label275:
    label323:
    label339:
    label355:
    int m;
    for (;;)
    {
      try
      {
        int k = Integer.parseInt(localJSONObject.getString("size"));
        if (!localJSONObject.isNull("length")) {
          break label323;
        }
        i = Integer.MAX_VALUE;
        if (!localJSONObject.isNull("color")) {
          break label339;
        }
        str2 = "#ff000000";
        if (!localJSONObject.isNull("style")) {
          break label355;
        }
        paramJSONObject = new ah.a.a[1];
        paramJSONObject[0] = ah.a.a.a;
        return new ah.a(paramPoint1.x, paramPoint1.y, paramPoint2.x, paramPoint2.y, localb, locala, (String)localObject, str1, k, i, str2, paramJSONObject);
      }
      catch (NumberFormatException paramPoint1)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Failure in building text asset! Text size should be an integer");
        paramPoint2 = new JSONException(paramPoint1.getMessage());
        paramPoint2.initCause(paramPoint1);
        throw paramPoint2;
      }
      localObject = paramJSONObject.getJSONObject("border");
      if (((JSONObject)localObject).isNull("style"))
      {
        localb = t.b.a;
        locala = t.a.b;
        localObject = "#ff000000";
        break;
      }
      localb = f(((JSONObject)localObject).getString("style"));
      if (((JSONObject)localObject).isNull("corner"))
      {
        locala = t.a.b;
        if (!((JSONObject)localObject).isNull("color")) {
          continue;
        }
        localObject = "#ff000000";
        break;
      }
      locala = g(((JSONObject)localObject).getString("corner"));
      continue;
      localObject = ((JSONObject)localObject).getString("color").trim();
      break;
      str1 = paramJSONObject.getString("backgroundColor").trim();
      break label40;
      int i = Integer.parseInt(localJSONObject.getString("length"));
      continue;
      String str2 = localJSONObject.getString("color").trim();
      continue;
      m = localJSONObject.getJSONArray("style").length();
      if (m != 0) {
        break label387;
      }
      paramJSONObject = new ah.a.a[1];
      paramJSONObject[0] = ah.a.a.a;
    }
    label387:
    ah.a.a[] arrayOfa = new ah.a.a[m];
    int j = 0;
    for (;;)
    {
      paramJSONObject = arrayOfa;
      if (j >= m) {
        break;
      }
      arrayOfa[j] = e(localJSONObject.getJSONArray("style").getString(j));
      j += 1;
    }
  }
  
  private ai.a b(@NonNull String paramString)
  {
    paramString = paramString.toUpperCase(Locale.US).trim();
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return ai.a.a;
        if (paramString.equals("LOAD"))
        {
          i = 1;
          continue;
          if (paramString.equals("CLIENT_FILL"))
          {
            i = 2;
            continue;
            if (paramString.equals("RENDER"))
            {
              i = 3;
              continue;
              if (paramString.equals("VIEW"))
              {
                i = 4;
                continue;
                if (paramString.equals("CLICK")) {
                  i = 5;
                }
              }
            }
          }
        }
        break;
      }
    }
    return ai.a.b;
    return ai.a.c;
    return ai.a.d;
    return ai.a.e;
    return ai.a.f;
  }
  
  private String b(@NonNull JSONObject paramJSONObject)
  {
    try
    {
      if (((d(paramJSONObject).equalsIgnoreCase("ICON")) || (d(paramJSONObject).equalsIgnoreCase("IMAGE"))) && (paramJSONObject.getJSONArray("assetValue").getString(0).startsWith("http")))
      {
        paramJSONObject = paramJSONObject.getJSONArray("assetValue").getString(0);
        return paramJSONObject;
      }
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return "";
  }
  
  private NativeStrandAsset.AssetInteractionMode c(@NonNull String paramString)
  {
    paramString = paramString.toUpperCase(Locale.US).trim();
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return NativeStrandAsset.AssetInteractionMode.ASSET_INTERACTION_MODE_BROWSER;
        if (paramString.equals("EXTERNAL"))
        {
          i = 1;
          continue;
          if (paramString.equals("INAPP"))
          {
            i = 2;
            continue;
            if (paramString.equals("DEEPLINK")) {
              i = 3;
            }
          }
        }
        break;
      }
    }
    return NativeStrandAsset.AssetInteractionMode.ASSET_INTERACTION_MODE_IN_APP;
    return NativeStrandAsset.AssetInteractionMode.ASSET_INTERACTION_MODE_DEEP_LINK;
  }
  
  private ah.a c(@NonNull Point paramPoint1, @NonNull Point paramPoint2, @NonNull JSONObject paramJSONObject)
  {
    t.b localb;
    t.a locala;
    Object localObject;
    String str1;
    label40:
    JSONObject localJSONObject;
    if (paramJSONObject.isNull("border"))
    {
      localb = t.b.a;
      locala = t.a.b;
      localObject = "#ff000000";
      if (!paramJSONObject.isNull("backgroundColor")) {
        break label257;
      }
      str1 = "#00000000";
      localJSONObject = paramJSONObject.getJSONObject("text");
    }
    label257:
    label305:
    label321:
    int k;
    for (;;)
    {
      try
      {
        int j = Integer.parseInt(localJSONObject.getString("size"));
        if (!localJSONObject.isNull("color")) {
          break label305;
        }
        str2 = "#ff000000";
        if (!localJSONObject.isNull("style")) {
          break label321;
        }
        paramJSONObject = new ah.a.a[1];
        paramJSONObject[0] = ah.a.a.a;
        return new w.a(paramPoint1.x, paramPoint1.y, paramPoint2.x, paramPoint2.y, localb, locala, (String)localObject, str1, j, str2, paramJSONObject);
      }
      catch (NumberFormatException paramPoint1)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Failure in building text asset! Text size should be an integer");
        paramPoint2 = new JSONException(paramPoint1.getMessage());
        paramPoint2.initCause(paramPoint1);
        throw paramPoint2;
      }
      localObject = paramJSONObject.getJSONObject("border");
      if (((JSONObject)localObject).isNull("style"))
      {
        localb = t.b.a;
        locala = t.a.b;
        localObject = "#ff000000";
        break;
      }
      localb = f(((JSONObject)localObject).getString("style"));
      if (((JSONObject)localObject).isNull("corner"))
      {
        locala = t.a.b;
        if (!((JSONObject)localObject).isNull("color")) {
          continue;
        }
        localObject = "#ff000000";
        break;
      }
      locala = g(((JSONObject)localObject).getString("corner"));
      continue;
      localObject = ((JSONObject)localObject).getString("color").trim();
      break;
      str1 = paramJSONObject.getString("backgroundColor").trim();
      break label40;
      String str2 = localJSONObject.getString("color").trim();
      continue;
      k = localJSONObject.getJSONArray("style").length();
      if (k != 0) {
        break label353;
      }
      paramJSONObject = new ah.a.a[1];
      paramJSONObject[0] = ah.a.a.a;
    }
    label353:
    ah.a.a[] arrayOfa = new ah.a.a[k];
    int i = 0;
    for (;;)
    {
      paramJSONObject = arrayOfa;
      if (i >= k) {
        break;
      }
      arrayOfa[i] = e(localJSONObject.getJSONArray("style").getString(i));
      i += 1;
    }
  }
  
  private String c(@NonNull JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getString("assetName");
      return paramJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return "";
  }
  
  private NativeStrandAsset.AssetType d(@NonNull String paramString)
  {
    paramString = paramString.toLowerCase(Locale.US).trim();
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return NativeStrandAsset.AssetType.ASSET_TYPE_CONTAINER;
        if (paramString.equals("container"))
        {
          i = 1;
          continue;
          if (paramString.equals("icon"))
          {
            i = 2;
            continue;
            if (paramString.equals("image"))
            {
              i = 3;
              continue;
              if (paramString.equals("text"))
              {
                i = 4;
                continue;
                if (paramString.equals("cta"))
                {
                  i = 5;
                  continue;
                  if (paramString.equals("rating")) {
                    i = 6;
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    return NativeStrandAsset.AssetType.ASSET_TYPE_ICON;
    return NativeStrandAsset.AssetType.ASSET_TYPE_IMAGE;
    return NativeStrandAsset.AssetType.ASSET_TYPE_TEXT;
    return NativeStrandAsset.AssetType.ASSET_TYPE_CTA;
    return NativeStrandAsset.AssetType.ASSET_TYPE_RATING;
  }
  
  private String d(@NonNull JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getString("assetType");
      return paramJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return "";
  }
  
  private ah.a.a e(@NonNull String paramString)
  {
    paramString = paramString.toLowerCase(Locale.US).trim();
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return ah.a.a.a;
        if (paramString.equals("none"))
        {
          i = 1;
          continue;
          if (paramString.equals("bold"))
          {
            i = 2;
            continue;
            if (paramString.equals("italic"))
            {
              i = 3;
              continue;
              if (paramString.equals("strike"))
              {
                i = 4;
                continue;
                if (paramString.equals("underline")) {
                  i = 5;
                }
              }
            }
          }
        }
        break;
      }
    }
    return ah.a.a.b;
    return ah.a.a.c;
    return ah.a.a.d;
    return ah.a.a.e;
  }
  
  private JSONObject e(@NonNull JSONObject paramJSONObject)
  {
    JSONObject localJSONObject2;
    try
    {
      if (paramJSONObject.isNull("assetStyle")) {}
      for (JSONObject localJSONObject1 = null;; localJSONObject1 = paramJSONObject.getJSONObject("assetStyle"))
      {
        localJSONObject2 = localJSONObject1;
        if (localJSONObject1 != null) {
          return localJSONObject2;
        }
        if (!paramJSONObject.isNull("assetStyleRef")) {
          break;
        }
        return new JSONObject();
      }
      paramJSONObject = paramJSONObject.getString("assetStyleRef");
      paramJSONObject = b().getJSONObject(paramJSONObject);
      return paramJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      localJSONObject2 = new JSONObject();
    }
    return localJSONObject2;
  }
  
  private Point f(@NonNull JSONObject paramJSONObject)
  {
    Point localPoint = new Point();
    try
    {
      paramJSONObject = e(paramJSONObject);
      if (paramJSONObject.isNull("geometry")) {
        return localPoint;
      }
      paramJSONObject = paramJSONObject.getJSONArray("geometry");
      localPoint.x = b(paramJSONObject.getInt(0));
      localPoint.y = b(paramJSONObject.getInt(1));
      return localPoint;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localPoint;
  }
  
  private t.b f(@NonNull String paramString)
  {
    paramString = paramString.toLowerCase(Locale.US).trim();
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return t.b.a;
        if (paramString.equals("none"))
        {
          i = 1;
          continue;
          if (paramString.equals("line")) {
            i = 2;
          }
        }
        break;
      }
    }
    return t.b.b;
  }
  
  private Point g(@NonNull JSONObject paramJSONObject)
  {
    Point localPoint = new Point();
    try
    {
      paramJSONObject = e(paramJSONObject);
      if (paramJSONObject.isNull("geometry")) {
        return localPoint;
      }
      paramJSONObject = paramJSONObject.getJSONArray("geometry");
      localPoint.x = b(paramJSONObject.getInt(2));
      localPoint.y = b(paramJSONObject.getInt(3));
      return localPoint;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localPoint;
  }
  
  private t.a g(@NonNull String paramString)
  {
    paramString = paramString.toLowerCase(Locale.US).trim();
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return t.a.b;
        if (paramString.equals("straight"))
        {
          i = 1;
          continue;
          if (paramString.equals("curved")) {
            i = 2;
          }
        }
        break;
      }
    }
    return t.a.a;
  }
  
  private JSONArray h(@NonNull JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getJSONArray("assetValue");
      return paramJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return new JSONArray();
  }
  
  private boolean i(@NonNull JSONObject paramJSONObject)
  {
    return !paramJSONObject.isNull("assetOnclick");
  }
  
  public v a()
  {
    return this.e;
  }
  
  public v a(int paramInt)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      NativeStrandAsset localNativeStrandAsset = (NativeStrandAsset)localIterator.next();
      if (localNativeStrandAsset.c().equalsIgnoreCase("card_scrollable"))
      {
        if (paramInt >= ((v)localNativeStrandAsset).n()) {
          return null;
        }
        return (v)((v)localNativeStrandAsset).a(paramInt);
      }
    }
    return null;
  }
  
  public v a(@NonNull NativeStrandAsset paramNativeStrandAsset)
  {
    Object localObject;
    if (((paramNativeStrandAsset instanceof v)) && (a((v)paramNativeStrandAsset)))
    {
      localObject = (v)paramNativeStrandAsset;
      return (v)localObject;
    }
    for (paramNativeStrandAsset = (v)paramNativeStrandAsset.k();; paramNativeStrandAsset = (v)paramNativeStrandAsset.k())
    {
      if (paramNativeStrandAsset == null) {
        break label58;
      }
      localObject = paramNativeStrandAsset;
      if (a(paramNativeStrandAsset)) {
        break;
      }
    }
    label58:
    return null;
  }
  
  @VisibleForTesting
  boolean a(JSONArray paramJSONArray)
  {
    boolean bool = true;
    int j = DisplayInfo.a().b();
    for (;;)
    {
      try
      {
        i = paramJSONArray.getInt(0);
        k = paramJSONArray.getInt(1);
        if ((i < 0) || (k < 0) || (i > j)) {
          break label91;
        }
        i = 1;
      }
      catch (JSONException paramJSONArray)
      {
        int k;
        paramJSONArray.printStackTrace();
        return false;
      }
      int i = paramJSONArray.getInt(2);
      k = paramJSONArray.getInt(3);
      if ((i >= 0) && (k >= 0) && (i <= j)) {
        return bool;
      }
      bool = false;
      continue;
      while (i == 0)
      {
        return false;
        label91:
        i = 0;
      }
    }
  }
  
  @VisibleForTesting
  boolean a(JSONObject paramJSONObject, NativeStrandAsset.AssetType paramAssetType)
  {
    boolean bool = true;
    if (paramJSONObject.isNull("geometry")) {
      label13:
      return false;
    }
    for (;;)
    {
      try
      {
        if (!a(paramJSONObject.getJSONArray("geometry"))) {
          break;
        }
        switch (x.1.a[paramAssetType.ordinal()])
        {
        case 2: 
        case 6: 
          if (paramJSONObject.isNull("text")) {
            break label13;
          }
          paramJSONObject = paramJSONObject.getJSONObject("text");
          try
          {
            int i = Integer.parseInt(paramJSONObject.getString("size"));
            if (i > 0) {
              return bool;
            }
          }
          catch (NumberFormatException paramJSONObject)
          {
            Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Failure in validating text asset! Text size should be an integer");
            return false;
          }
          bool = false;
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return false;
      }
    }
    return false;
    return true;
  }
  
  @VisibleForTesting
  ai[] a(@NonNull JSONObject paramJSONObject)
  {
    if (paramJSONObject.isNull("trackers")) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("trackers");
        j = paramJSONObject.length();
        if (j != 0) {
          break label335;
        }
        return new ai[0];
      }
      catch (JSONException paramJSONObject)
      {
        int j;
        JSONObject localJSONObject;
        Object localObject;
        int k;
        ai.a locala;
        HashMap localHashMap;
        boolean bool;
        paramJSONObject.printStackTrace();
        return (ai[])localArrayList.toArray(new ai[localArrayList.size()]);
      }
      if (i < j)
      {
        localJSONObject = paramJSONObject.getJSONObject(i);
        if (!localJSONObject.isNull("trackerType"))
        {
          localObject = a(localJSONObject.getString("trackerType"));
          if ((ai.b.b == localObject) && (!localJSONObject.isNull("url")))
          {
            localObject = localJSONObject.getString("url").trim();
            if (URLUtil.isValidUrl((String)localObject))
            {
              k = localJSONObject.optInt("eventId", 0);
              if (!localJSONObject.isNull("uiEvent"))
              {
                locala = b(localJSONObject.getString("uiEvent"));
                if (ai.a.a != locala)
                {
                  localHashMap = new HashMap();
                  bool = localJSONObject.isNull("params");
                  if (!bool) {
                    try
                    {
                      localJSONObject = localJSONObject.getJSONObject("params");
                      Iterator localIterator = localJSONObject.keys();
                      if (localIterator.hasNext())
                      {
                        String str = (String)localIterator.next();
                        localHashMap.put(str, localJSONObject.getString(str));
                        continue;
                      }
                      localArrayList.add(new ai((String)localObject, k, locala, localHashMap));
                    }
                    catch (JSONException localJSONException)
                    {
                      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Failed to parser tracker.params", localJSONException);
                    }
                  }
                }
              }
            }
          }
        }
      }
      else
      {
        paramJSONObject = (ai[])localArrayList.toArray(new ai[localArrayList.size()]);
        return paramJSONObject;
        label335:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
  
  @VisibleForTesting
  int b(int paramInt)
  {
    return DisplayInfo.a(paramInt);
  }
  
  public JSONObject b()
  {
    return this.d;
  }
  
  public v c()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      NativeStrandAsset localNativeStrandAsset = (NativeStrandAsset)localIterator.next();
      if (localNativeStrandAsset.c().equalsIgnoreCase("card_scrollable")) {
        return (v)localNativeStrandAsset;
      }
    }
    return null;
  }
  
  public int d()
  {
    if (this.e == null) {
      return 0;
    }
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      NativeStrandAsset localNativeStrandAsset = (NativeStrandAsset)localIterator.next();
      if (localNativeStrandAsset.c().equalsIgnoreCase("card_scrollable")) {
        return ((v)localNativeStrandAsset).n();
      }
    }
    return 0;
  }
  
  public int e()
  {
    if (this.e == null) {
      return 0;
    }
    return this.e.b().a().x;
  }
  
  public int f()
  {
    if (this.e == null) {
      return 0;
    }
    return this.e.b().a().y;
  }
  
  @VisibleForTesting
  void g()
  {
    try
    {
      this.c = String.valueOf(this.b.getDouble("version"));
      this.d = this.b.getJSONObject("styleRefs");
      this.e = ((v)a(this.b.getJSONObject("rootContainer"), NativeStrandAsset.AssetType.ASSET_TYPE_CONTAINER, "/rootContainer"));
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  @VisibleForTesting
  boolean h()
  {
    if (a() == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Invalid Data Model: No Root Container");
      return false;
    }
    if (c() == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "No Card Scrollable in the data model");
      return true;
    }
    if (d() <= 0)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Invalid Data Model: No Cards in Card Scrollable");
      return false;
    }
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */