package com.alibaba.mtl.appmonitor.d;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.mtl.log.a.a;

public class n
{
  /* Error */
  public static void c(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 14	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +249 -> 253
    //   7: aload_0
    //   8: invokestatic 20	com/alibaba/fastjson/JSON:parseObject	(Ljava/lang/String;)Lcom/alibaba/fastjson/JSONObject;
    //   11: astore_1
    //   12: aload_1
    //   13: ifnull +240 -> 253
    //   16: aload_1
    //   17: ldc 22
    //   19: invokevirtual 28	com/alibaba/fastjson/JSONObject:containsKey	(Ljava/lang/Object;)Z
    //   22: ifeq +231 -> 253
    //   25: ldc 30
    //   27: iconst_2
    //   28: anewarray 4	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: ldc 32
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: aload_0
    //   39: aastore
    //   40: invokestatic 38	com/alibaba/mtl/log/e/i:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: aload_1
    //   44: ldc 22
    //   46: invokevirtual 41	com/alibaba/fastjson/JSONObject:getJSONObject	(Ljava/lang/String;)Lcom/alibaba/fastjson/JSONObject;
    //   49: astore_0
    //   50: aload_0
    //   51: ifnull +202 -> 253
    //   54: aload_0
    //   55: ldc 43
    //   57: invokevirtual 28	com/alibaba/fastjson/JSONObject:containsKey	(Ljava/lang/Object;)Z
    //   60: ifeq +23 -> 83
    //   63: aload_0
    //   64: ldc 43
    //   66: invokevirtual 47	com/alibaba/fastjson/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   69: astore_1
    //   70: ldc 49
    //   72: aload_1
    //   73: invokevirtual 55	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   76: ifeq +178 -> 254
    //   79: iconst_0
    //   80: putstatic 61	com/alibaba/mtl/log/a:r	Z
    //   83: aload_0
    //   84: ldc 63
    //   86: invokevirtual 28	com/alibaba/fastjson/JSONObject:containsKey	(Ljava/lang/Object;)Z
    //   89: ifeq +12 -> 101
    //   92: aload_0
    //   93: ldc 63
    //   95: invokevirtual 47	com/alibaba/fastjson/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   98: invokestatic 68	com/alibaba/mtl/log/a/a:j	(Ljava/lang/String;)V
    //   101: aload_0
    //   102: ldc 70
    //   104: invokevirtual 28	com/alibaba/fastjson/JSONObject:containsKey	(Ljava/lang/Object;)Z
    //   107: ifeq +12 -> 119
    //   110: aload_0
    //   111: ldc 70
    //   113: invokevirtual 47	com/alibaba/fastjson/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   116: invokestatic 73	com/alibaba/mtl/log/a/a:k	(Ljava/lang/String;)V
    //   119: ldc 30
    //   121: iconst_2
    //   122: anewarray 4	java/lang/Object
    //   125: dup
    //   126: iconst_0
    //   127: ldc 75
    //   129: aastore
    //   130: dup
    //   131: iconst_1
    //   132: getstatic 61	com/alibaba/mtl/log/a:r	Z
    //   135: invokestatic 81	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   138: aastore
    //   139: invokestatic 38	com/alibaba/mtl/log/e/i:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: ldc 30
    //   144: iconst_2
    //   145: anewarray 4	java/lang/Object
    //   148: dup
    //   149: iconst_0
    //   150: ldc 83
    //   152: aastore
    //   153: dup
    //   154: iconst_1
    //   155: invokestatic 87	com/alibaba/mtl/log/a/a:b	()J
    //   158: invokestatic 92	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   161: aastore
    //   162: invokestatic 38	com/alibaba/mtl/log/e/i:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   165: ldc 30
    //   167: iconst_2
    //   168: anewarray 4	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: ldc 94
    //   175: aastore
    //   176: dup
    //   177: iconst_1
    //   178: invokestatic 96	com/alibaba/mtl/log/a/a:a	()J
    //   181: invokestatic 92	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   184: aastore
    //   185: invokestatic 38	com/alibaba/mtl/log/e/i:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   188: aload_0
    //   189: ldc 98
    //   191: invokevirtual 28	com/alibaba/fastjson/JSONObject:containsKey	(Ljava/lang/Object;)Z
    //   194: ifeq +97 -> 291
    //   197: aload_0
    //   198: ldc 98
    //   200: invokevirtual 102	com/alibaba/fastjson/JSONObject:getIntValue	(Ljava/lang/String;)I
    //   203: istore_2
    //   204: iload_2
    //   205: iconst_1
    //   206: if_icmpne +68 -> 274
    //   209: iconst_1
    //   210: putstatic 105	com/alibaba/mtl/log/a/a:A	Z
    //   213: invokestatic 110	com/alibaba/mtl/log/d/a:a	()Lcom/alibaba/mtl/log/d/a;
    //   216: invokevirtual 114	com/alibaba/mtl/log/d/a:stop	()V
    //   219: aload_0
    //   220: ldc 116
    //   222: invokevirtual 28	com/alibaba/fastjson/JSONObject:containsKey	(Ljava/lang/Object;)Z
    //   225: ifeq +28 -> 253
    //   228: aload_0
    //   229: ldc 116
    //   231: invokevirtual 102	com/alibaba/fastjson/JSONObject:getIntValue	(Ljava/lang/String;)I
    //   234: invokestatic 120	com/alibaba/mtl/appmonitor/d/n:f	()I
    //   237: if_icmple +16 -> 253
    //   240: invokestatic 125	com/alibaba/mtl/log/e/r:a	()Lcom/alibaba/mtl/log/e/r;
    //   243: new 127	com/alibaba/mtl/appmonitor/d/n$1
    //   246: dup
    //   247: invokespecial 130	com/alibaba/mtl/appmonitor/d/n$1:<init>	()V
    //   250: invokevirtual 133	com/alibaba/mtl/log/e/r:b	(Ljava/lang/Runnable;)V
    //   253: return
    //   254: ldc -121
    //   256: aload_1
    //   257: invokevirtual 55	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   260: ifeq -177 -> 83
    //   263: iconst_1
    //   264: putstatic 61	com/alibaba/mtl/log/a:r	Z
    //   267: goto -184 -> 83
    //   270: astore_1
    //   271: goto -188 -> 83
    //   274: iload_2
    //   275: ifne -56 -> 219
    //   278: iconst_0
    //   279: putstatic 105	com/alibaba/mtl/log/a/a:A	Z
    //   282: invokestatic 110	com/alibaba/mtl/log/d/a:a	()Lcom/alibaba/mtl/log/d/a;
    //   285: invokevirtual 138	com/alibaba/mtl/log/d/a:start	()V
    //   288: goto -69 -> 219
    //   291: getstatic 105	com/alibaba/mtl/log/a/a:A	Z
    //   294: ifeq -75 -> 219
    //   297: iconst_0
    //   298: putstatic 105	com/alibaba/mtl/log/a/a:A	Z
    //   301: invokestatic 110	com/alibaba/mtl/log/d/a:a	()Lcom/alibaba/mtl/log/d/a;
    //   304: invokevirtual 138	com/alibaba/mtl/log/d/a:start	()V
    //   307: goto -88 -> 219
    //   310: astore_0
    //   311: ldc 30
    //   313: ldc -116
    //   315: aload_0
    //   316: invokestatic 143	com/alibaba/mtl/log/e/i:a	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   319: return
    //   320: astore_0
    //   321: return
    //   322: astore_1
    //   323: goto -204 -> 119
    //   326: astore_1
    //   327: goto -226 -> 101
    //   330: astore_1
    //   331: goto -112 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	paramString	String
    //   11	246	1	localObject	Object
    //   270	1	1	localThrowable1	Throwable
    //   322	1	1	localThrowable2	Throwable
    //   326	1	1	localThrowable3	Throwable
    //   330	1	1	localThrowable4	Throwable
    //   203	72	2	i	int
    // Exception table:
    //   from	to	target	type
    //   54	83	270	java/lang/Throwable
    //   254	267	270	java/lang/Throwable
    //   7	12	310	java/lang/Throwable
    //   16	50	310	java/lang/Throwable
    //   119	188	310	java/lang/Throwable
    //   219	253	320	java/lang/Throwable
    //   101	119	322	java/lang/Throwable
    //   83	101	326	java/lang/Throwable
    //   188	204	330	java/lang/Throwable
    //   209	219	330	java/lang/Throwable
    //   278	288	330	java/lang/Throwable
    //   291	307	330	java/lang/Throwable
  }
  
  public static int f()
  {
    Object localObject = a.g();
    int j = 0;
    int i = j;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      localObject = JSON.parseObject((String)localObject);
      i = j;
      if (localObject != null)
      {
        i = j;
        if (((JSONObject)localObject).containsKey("SYSTEM"))
        {
          localObject = ((JSONObject)localObject).getJSONObject("SYSTEM");
          i = j;
          if (localObject != null)
          {
            i = j;
            if (((JSONObject)localObject).containsKey("cdb")) {
              i = ((JSONObject)localObject).getIntValue("cdb");
            }
          }
        }
      }
      return i;
    }
    catch (Throwable localThrowable) {}
    return 0;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\d\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */