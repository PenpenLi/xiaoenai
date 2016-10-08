package com.taobao.applink.usertracker;

import android.content.Context;
import android.util.Log;
import com.taobao.applink.util.TBAppLinkPhoneUtil;
import java.util.ArrayList;
import java.util.List;

public class TBMiniUserTrack
{
  private CharSequence appkey;
  public CharSequence imei = "unkown";
  private List<CharSequence> messages = new ArrayList(30);
  private CharSequence path = "http://wgo.mmstat.com/ire.2.1";
  
  public TBMiniUserTrack(Context paramContext, CharSequence paramCharSequence)
  {
    try
    {
      this.appkey = paramCharSequence;
      this.imei = TBAppLinkPhoneUtil.getImei(paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      Log.d("TBMiniUserTrack", paramContext.getStackTrace().toString());
    }
  }
  
  /* Error */
  private void flush()
  {
    // Byte code:
    //   0: new 67	java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial 68	java/lang/StringBuffer:<init>	()V
    //   7: astore 4
    //   9: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   12: lstore 5
    //   14: aload 4
    //   16: ldc 76
    //   18: invokevirtual 80	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   21: aload_0
    //   22: getfield 35	com/taobao/applink/usertracker/TBMiniUserTrack:appkey	Ljava/lang/CharSequence;
    //   25: invokevirtual 83	java/lang/StringBuffer:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuffer;
    //   28: ldc 85
    //   30: invokevirtual 80	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   33: ldc 87
    //   35: invokevirtual 80	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   38: invokestatic 93	com/taobao/applink/util/TBAppLinkUtil:getApplication	()Landroid/app/Application;
    //   41: invokestatic 98	com/taobao/applink/appinfo/TBAppInfo:getPackageName	(Landroid/content/Context;)Ljava/lang/String;
    //   44: invokevirtual 80	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   47: ldc 85
    //   49: invokevirtual 80	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   52: ldc 100
    //   54: invokevirtual 80	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   57: ldc 102
    //   59: invokevirtual 80	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   62: ldc 85
    //   64: invokevirtual 80	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   67: ldc 104
    //   69: invokevirtual 80	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   72: aload_0
    //   73: getfield 22	com/taobao/applink/usertracker/TBMiniUserTrack:imei	Ljava/lang/CharSequence;
    //   76: invokevirtual 83	java/lang/StringBuffer:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuffer;
    //   79: ldc 106
    //   81: invokevirtual 80	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   84: lload 5
    //   86: invokevirtual 109	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
    //   89: ldc 111
    //   91: invokevirtual 80	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   94: pop
    //   95: aload_0
    //   96: getfield 33	com/taobao/applink/usertracker/TBMiniUserTrack:messages	Ljava/util/List;
    //   99: invokeinterface 117 1 0
    //   104: ifle +22 -> 126
    //   107: aload 4
    //   109: aload_0
    //   110: getfield 33	com/taobao/applink/usertracker/TBMiniUserTrack:messages	Ljava/util/List;
    //   113: iconst_0
    //   114: invokeinterface 121 2 0
    //   119: checkcast 123	java/lang/CharSequence
    //   122: invokevirtual 83	java/lang/StringBuffer:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuffer;
    //   125: pop
    //   126: aload_0
    //   127: getfield 33	com/taobao/applink/usertracker/TBMiniUserTrack:messages	Ljava/util/List;
    //   130: invokeinterface 126 1 0
    //   135: ldc -128
    //   137: aload 4
    //   139: invokevirtual 129	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   142: invokestatic 57	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   145: pop
    //   146: aconst_null
    //   147: astore_1
    //   148: aconst_null
    //   149: astore_3
    //   150: new 131	java/net/URL
    //   153: dup
    //   154: aload_0
    //   155: getfield 26	com/taobao/applink/usertracker/TBMiniUserTrack:path	Ljava/lang/CharSequence;
    //   158: invokestatic 137	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   161: invokespecial 140	java/net/URL:<init>	(Ljava/lang/String;)V
    //   164: invokevirtual 144	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   167: checkcast 146	java/net/HttpURLConnection
    //   170: astore_2
    //   171: aload_2
    //   172: ldc -108
    //   174: invokevirtual 151	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   177: aload_2
    //   178: iconst_1
    //   179: invokevirtual 155	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   182: aload_2
    //   183: iconst_1
    //   184: invokevirtual 158	java/net/HttpURLConnection:setDoInput	(Z)V
    //   187: aload_2
    //   188: sipush 5000
    //   191: invokevirtual 161	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   194: aload_2
    //   195: sipush 5000
    //   198: invokevirtual 164	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   201: aload_2
    //   202: invokevirtual 168	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   205: astore_1
    //   206: aload_1
    //   207: aload 4
    //   209: invokevirtual 129	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   212: ldc -86
    //   214: invokestatic 176	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   217: invokevirtual 180	java/lang/String:getBytes	()[B
    //   220: invokevirtual 186	java/io/OutputStream:write	([B)V
    //   223: aload_1
    //   224: invokevirtual 187	java/io/OutputStream:flush	()V
    //   227: aload_1
    //   228: invokevirtual 190	java/io/OutputStream:close	()V
    //   231: new 192	java/io/BufferedReader
    //   234: dup
    //   235: new 194	java/io/InputStreamReader
    //   238: dup
    //   239: aload_2
    //   240: invokevirtual 198	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   243: invokespecial 201	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   246: invokespecial 204	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   249: astore_3
    //   250: ldc -50
    //   252: astore_1
    //   253: aload_3
    //   254: invokevirtual 209	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   257: astore 4
    //   259: aload 4
    //   261: ifnull +31 -> 292
    //   264: new 211	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   271: aload_1
    //   272: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: ldc -39
    //   277: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload 4
    //   282: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: astore_1
    //   289: goto -36 -> 253
    //   292: ldc -33
    //   294: aload_1
    //   295: invokestatic 57	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   298: pop
    //   299: aload_2
    //   300: ifnull +7 -> 307
    //   303: aload_2
    //   304: invokevirtual 226	java/net/HttpURLConnection:disconnect	()V
    //   307: return
    //   308: astore_1
    //   309: aload_3
    //   310: astore_2
    //   311: aload_1
    //   312: astore_3
    //   313: aload_2
    //   314: astore_1
    //   315: ldc -28
    //   317: aload_3
    //   318: invokevirtual 229	java/lang/Throwable:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   321: invokevirtual 51	java/lang/Object:toString	()Ljava/lang/String;
    //   324: invokestatic 57	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   327: pop
    //   328: aload_2
    //   329: ifnull -22 -> 307
    //   332: aload_2
    //   333: invokevirtual 226	java/net/HttpURLConnection:disconnect	()V
    //   336: return
    //   337: astore_3
    //   338: aload_1
    //   339: astore_2
    //   340: aload_3
    //   341: astore_1
    //   342: aload_2
    //   343: ifnull +7 -> 350
    //   346: aload_2
    //   347: invokevirtual 226	java/net/HttpURLConnection:disconnect	()V
    //   350: aload_1
    //   351: athrow
    //   352: astore_1
    //   353: goto -11 -> 342
    //   356: astore_3
    //   357: goto -44 -> 313
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	this	TBMiniUserTrack
    //   147	148	1	localObject1	Object
    //   308	4	1	localThrowable1	Throwable
    //   314	37	1	localObject2	Object
    //   352	1	1	localObject3	Object
    //   170	177	2	localObject4	Object
    //   149	169	3	localObject5	Object
    //   337	4	3	localObject6	Object
    //   356	1	3	localThrowable2	Throwable
    //   7	274	4	localObject7	Object
    //   12	73	5	l	long
    // Exception table:
    //   from	to	target	type
    //   150	171	308	java/lang/Throwable
    //   150	171	337	finally
    //   315	328	337	finally
    //   171	250	352	finally
    //   253	259	352	finally
    //   264	289	352	finally
    //   292	299	352	finally
    //   171	250	356	java/lang/Throwable
    //   253	259	356	java/lang/Throwable
    //   264	289	356	java/lang/Throwable
    //   292	299	356	java/lang/Throwable
  }
  
  public void commitEvent(CharSequence paramCharSequence)
  {
    try
    {
      this.messages.add(paramCharSequence);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void commitEventAndFlush(CharSequence paramCharSequence)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 238	com/taobao/applink/usertracker/TBMiniUserTrack:commitEvent	(Ljava/lang/CharSequence;)V
    //   7: new 240	java/lang/Thread
    //   10: dup
    //   11: new 242	com/taobao/applink/usertracker/TBMiniUserTrack$1
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 244	com/taobao/applink/usertracker/TBMiniUserTrack$1:<init>	(Lcom/taobao/applink/usertracker/TBMiniUserTrack;)V
    //   19: invokespecial 247	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   22: invokevirtual 250	java/lang/Thread:start	()V
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: astore_1
    //   29: ldc -28
    //   31: aload_1
    //   32: invokevirtual 47	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   35: invokevirtual 51	java/lang/Object:toString	()Ljava/lang/String;
    //   38: invokestatic 57	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   41: pop
    //   42: goto -17 -> 25
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	TBMiniUserTrack
    //   0	50	1	paramCharSequence	CharSequence
    // Exception table:
    //   from	to	target	type
    //   7	25	28	java/lang/Exception
    //   2	7	45	finally
    //   7	25	45	finally
    //   25	27	45	finally
    //   29	42	45	finally
    //   46	48	45	finally
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\usertracker\TBMiniUserTrack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */