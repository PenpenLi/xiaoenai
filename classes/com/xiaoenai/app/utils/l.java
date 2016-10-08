package com.xiaoenai.app.utils;

import com.xiaoenai.app.classes.chat.history.w;
import com.xiaoenai.app.classes.chat.messagelist.message.a.a;
import com.xiaoenai.app.classes.chat.messagelist.message.b.k;
import com.xiaoenai.app.classes.chat.messagelist.message.model.c;
import com.xiaoenai.app.classes.extentions.reward.model.BaseTask;
import com.xiaoenai.app.classes.gameCenter.model.GameInfoEntry;
import com.xiaoenai.app.classes.store.ab;
import com.xiaoenai.app.classes.store.sticker.BaseSticker;
import com.xiaoenai.app.classes.store.sticker.FaceSticker;
import com.xiaoenai.app.classes.store.sticker.Sticker;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class l
{
  public static w a(String paramString)
  {
    w localw = new w();
    Vector localVector = new Vector();
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        localw.a(paramString.optInt("current_ts"));
        paramString = paramString.optJSONArray("timeline");
        i = 0;
        if (i < paramString.length())
        {
          JSONObject localJSONObject = paramString.optJSONObject(i);
          String str1 = localJSONObject.optString("types");
          String str2 = localJSONObject.optString("content");
          a locala = k.a(str1, k.a(str1, str2), c.a(str1, str2));
          if (locala == null) {
            break label214;
          }
          locala.b(localJSONObject.optLong("id"));
          locala.a(str1);
          locala.a(Integer.valueOf(localJSONObject.optInt("sender_id")));
          locala.b(str2);
          locala.a(localJSONObject.optInt("ts"));
          if ((locala.c() == null) || (locala.c().equals("{}")) || (locala.c().equals(""))) {
            break label214;
          }
          localVector.add(locala);
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return localw;
      }
      localw.a(localVector);
      return localw;
      label214:
      i += 1;
    }
  }
  
  public static List<BaseTask> a(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    paramJSONObject = paramJSONObject.optJSONArray("list");
    int i = 0;
    while (i < paramJSONObject.length())
    {
      BaseTask localBaseTask = new BaseTask();
      localBaseTask.fromJson(paramJSONObject.optJSONObject(i));
      localArrayList.add(localBaseTask);
      i += 1;
    }
    return localArrayList;
  }
  
  private static Vector<BaseSticker> a(String paramString, boolean paramBoolean)
  {
    Vector localVector1 = new Vector();
    Vector localVector2 = ab.a().a(100);
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (localVector2.size() <= 0) {
          break label210;
        }
        i = 0;
        paramString = paramString.optJSONArray("list");
        j = 0;
        if (j < paramString.length())
        {
          localFaceSticker = new FaceSticker();
          localFaceSticker.fromJson(paramString.optJSONObject(j));
          localFaceSticker.setNew(false);
          int k = 0;
          m = 0;
          if (k < localVector2.size())
          {
            if (((BaseSticker)localVector2.get(k)).getId() == localFaceSticker.getId())
            {
              localFaceSticker.setDownload(((BaseSticker)localVector2.get(k)).isDownload());
              localFaceSticker.setDownloading(((BaseSticker)localVector2.get(k)).isDownloading());
              m = 1;
            }
            k += 1;
            continue;
          }
        }
      }
      catch (JSONException paramString)
      {
        int j;
        FaceSticker localFaceSticker;
        int m;
        paramString.printStackTrace();
        paramString = null;
        continue;
        if ((m == 0) && (paramBoolean) && (i == 0)) {
          localFaceSticker.setNew(true);
        }
        localVector1.add(localFaceSticker);
        j += 1;
        continue;
      }
      return localVector1;
      label210:
      int i = 1;
    }
  }
  
  public static Vector<BaseSticker> b(String paramString)
  {
    paramString = a(paramString, true);
    ab.a().c();
    return paramString;
  }
  
  public static Vector<Sticker> c(String paramString)
  {
    localVector = new Vector();
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("stickers");
      int i = 0;
      while (i < paramString.length())
      {
        Sticker localSticker = new Sticker();
        localSticker.fromJson(paramString.optJSONObject(i));
        localVector.add(localSticker);
        i += 1;
      }
      return localVector;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static boolean d(String paramString)
  {
    try
    {
      boolean bool = new JSONObject(paramString).optBoolean("purchased");
      return bool;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public static String e(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("url");
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public static List<com.xiaoenai.app.classes.gameCenter.model.GameEntry> f(String paramString)
  {
    // Byte code:
    //   0: new 19	org/json/JSONObject
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 22	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: ldc 126
    //   10: invokevirtual 37	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   13: astore_2
    //   14: new 16	java/util/Vector
    //   17: dup
    //   18: invokespecial 17	java/util/Vector:<init>	()V
    //   21: astore_0
    //   22: iconst_0
    //   23: istore 4
    //   25: aload_0
    //   26: astore_1
    //   27: iload 4
    //   29: aload_2
    //   30: invokevirtual 43	org/json/JSONArray:length	()I
    //   33: if_icmpge +158 -> 191
    //   36: new 209	com/xiaoenai/app/classes/gameCenter/model/GameEntry
    //   39: dup
    //   40: invokespecial 210	com/xiaoenai/app/classes/gameCenter/model/GameEntry:<init>	()V
    //   43: astore_1
    //   44: aload_2
    //   45: iload 4
    //   47: invokevirtual 47	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   50: astore_3
    //   51: aload_1
    //   52: aload_3
    //   53: ldc 68
    //   55: invokevirtual 28	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   58: invokevirtual 213	com/xiaoenai/app/classes/gameCenter/model/GameEntry:setId	(I)V
    //   61: aload_1
    //   62: aload_3
    //   63: ldc -41
    //   65: invokevirtual 53	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   68: invokevirtual 218	com/xiaoenai/app/classes/gameCenter/model/GameEntry:setName	(Ljava/lang/String;)V
    //   71: aload_1
    //   72: aload_3
    //   73: ldc -36
    //   75: invokevirtual 53	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   78: invokevirtual 223	com/xiaoenai/app/classes/gameCenter/model/GameEntry:setAppKey	(Ljava/lang/String;)V
    //   81: aload_1
    //   82: aload_3
    //   83: ldc -31
    //   85: invokevirtual 53	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   88: invokevirtual 228	com/xiaoenai/app/classes/gameCenter/model/GameEntry:setIntro	(Ljava/lang/String;)V
    //   91: aload_1
    //   92: aload_3
    //   93: ldc -26
    //   95: invokevirtual 53	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   98: invokevirtual 233	com/xiaoenai/app/classes/gameCenter/model/GameEntry:setIcon_url	(Ljava/lang/String;)V
    //   101: aload_1
    //   102: aload_3
    //   103: ldc -21
    //   105: invokevirtual 53	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   108: invokevirtual 238	com/xiaoenai/app/classes/gameCenter/model/GameEntry:setMpackage	(Ljava/lang/String;)V
    //   111: aload_1
    //   112: aload_3
    //   113: ldc -16
    //   115: invokevirtual 28	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   118: invokevirtual 243	com/xiaoenai/app/classes/gameCenter/model/GameEntry:setStartType	(I)V
    //   121: aload_1
    //   122: aload_3
    //   123: ldc -11
    //   125: invokevirtual 53	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   128: invokevirtual 248	com/xiaoenai/app/classes/gameCenter/model/GameEntry:setLoginUrl	(Ljava/lang/String;)V
    //   131: aload_1
    //   132: aload_3
    //   133: ldc -6
    //   135: invokevirtual 53	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   138: invokevirtual 253	com/xiaoenai/app/classes/gameCenter/model/GameEntry:setDownloadUrl	(Ljava/lang/String;)V
    //   141: aload_0
    //   142: aload_1
    //   143: invokeinterface 136 2 0
    //   148: pop
    //   149: invokestatic 258	com/xiaoenai/app/classes/gameCenter/b:a	()Lcom/xiaoenai/app/classes/gameCenter/b;
    //   152: aload_1
    //   153: invokevirtual 261	com/xiaoenai/app/classes/gameCenter/b:a	(Lcom/xiaoenai/app/classes/gameCenter/model/GameEntry;)V
    //   156: ldc_w 263
    //   159: iconst_1
    //   160: anewarray 4	java/lang/Object
    //   163: dup
    //   164: iconst_0
    //   165: aload_1
    //   166: invokevirtual 266	com/xiaoenai/app/classes/gameCenter/model/GameEntry:getAppKey	()Ljava/lang/String;
    //   169: aastore
    //   170: invokestatic 271	com/xiaoenai/app/utils/f/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: iload 4
    //   175: iconst_1
    //   176: iadd
    //   177: istore 4
    //   179: goto -154 -> 25
    //   182: astore_1
    //   183: aconst_null
    //   184: astore_0
    //   185: aload_1
    //   186: invokevirtual 116	org/json/JSONException:printStackTrace	()V
    //   189: aload_0
    //   190: astore_1
    //   191: aload_1
    //   192: areturn
    //   193: astore_1
    //   194: goto -9 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramString	String
    //   26	140	1	localObject	Object
    //   182	4	1	localJSONException1	JSONException
    //   190	2	1	str	String
    //   193	1	1	localJSONException2	JSONException
    //   13	32	2	localJSONArray	JSONArray
    //   50	83	3	localJSONObject	JSONObject
    //   23	155	4	i	int
    // Exception table:
    //   from	to	target	type
    //   0	22	182	org/json/JSONException
    //   27	173	193	org/json/JSONException
  }
  
  public static GameInfoEntry g(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramString = new GameInfoEntry();
      localJSONException1.printStackTrace();
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        paramString.fromJson(localJSONObject);
        return paramString;
      }
      catch (JSONException localJSONException2)
      {
        for (;;) {}
      }
      localJSONException1 = localJSONException1;
      paramString = null;
    }
    return paramString;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */