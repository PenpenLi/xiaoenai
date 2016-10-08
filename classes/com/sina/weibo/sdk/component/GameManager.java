package com.sina.weibo.sdk.component;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.net.HttpManager;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.LogUtil;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GameManager
{
  private static final String BOUNDARY;
  public static final String DEFAULT_CHARSET = "UTF-8";
  private static final String HTTP_METHOD_GET = "GET";
  private static final String HTTP_METHOD_POST = "POST";
  private static String INVITATION_ONE_FRINED_URL = "http://widget.weibo.com/invitation/appinfo.php?";
  private static String INVITATION_URL;
  private static final String MULTIPART_FORM_DATA = "multipart/form-data";
  private static final String TAG = "GameManager";
  private static StringBuffer URL = new StringBuffer("https://api.weibo.com/2/proxy/darwin/graph/game/");
  private static String URL_ACHIEVEMENT_ADD_UPDATE;
  private static String URL_ACHIEVEMENT_READ_PLAYER_FRIENDS;
  private static String URL_ACHIEVEMENT_READ_PLAYER_SCORE;
  private static String URL_ACHIEVEMENT_RELATION_ADD_UPDATE;
  private static String URL_ACHIEVEMENT_SCORE_ADD_UPDATE;
  private static String URL_ACHIEVEMENT_USER_GAIN;
  
  static
  {
    BOUNDARY = HttpManager.getBoundry();
    URL_ACHIEVEMENT_ADD_UPDATE = URL + "achievement/add.json";
    URL_ACHIEVEMENT_RELATION_ADD_UPDATE = URL + "achievement/gain/add.json";
    URL_ACHIEVEMENT_SCORE_ADD_UPDATE = URL + "score/add.json";
    URL_ACHIEVEMENT_READ_PLAYER_SCORE = URL + "score/read_player.json";
    URL_ACHIEVEMENT_READ_PLAYER_FRIENDS = URL + "score/read_player_friends.json";
    URL_ACHIEVEMENT_USER_GAIN = URL + "achievement/user_gain.json";
    INVITATION_URL = "http://widget.weibo.com/invitation/app.php?";
  }
  
  public static String AddOrUpdateGameAchievement(Context paramContext, WeiboParameters paramWeiboParameters)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date localDate = new Date();
    paramWeiboParameters.put("updated_time", localSimpleDateFormat.format(localDate));
    if (TextUtils.isEmpty((String)paramWeiboParameters.get("create_time"))) {
      paramWeiboParameters.put("create_time", localSimpleDateFormat.format(localDate));
    }
    paramContext = HttpManager.readRsponse(requestHttpExecute(paramContext, URL_ACHIEVEMENT_ADD_UPDATE, "POST", paramWeiboParameters));
    LogUtil.d("GameManager", "Response : " + paramContext);
    return paramContext;
  }
  
  public static String addOrUpdateAchievementScore(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    WeiboParameters localWeiboParameters = new WeiboParameters("");
    if (!TextUtils.isEmpty(paramString1)) {
      localWeiboParameters.put("access_token", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localWeiboParameters.put("source", paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localWeiboParameters.put("game_id", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localWeiboParameters.put("uid", paramString4);
    }
    if (!TextUtils.isEmpty(paramString5)) {
      localWeiboParameters.put("score", paramString5);
    }
    paramString1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    paramString2 = new Date();
    localWeiboParameters.put("updated_time", paramString1.format(paramString2));
    if (TextUtils.isEmpty((String)localWeiboParameters.get("create_time"))) {
      localWeiboParameters.put("create_time", paramString1.format(paramString2));
    }
    paramContext = HttpManager.readRsponse(requestHttpExecute(paramContext, URL_ACHIEVEMENT_SCORE_ADD_UPDATE, "POST", localWeiboParameters));
    LogUtil.d("GameManager", "Response : " + paramContext);
    return paramContext;
  }
  
  public static String addOrUpdateGameAchievementRelation(Context paramContext, WeiboParameters paramWeiboParameters)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date localDate = new Date();
    paramWeiboParameters.put("updated_time", localSimpleDateFormat.format(localDate));
    if (TextUtils.isEmpty((String)paramWeiboParameters.get("create_time"))) {
      paramWeiboParameters.put("create_time", localSimpleDateFormat.format(localDate));
    }
    paramContext = HttpManager.readRsponse(requestHttpExecute(paramContext, URL_ACHIEVEMENT_RELATION_ADD_UPDATE, "POST", paramWeiboParameters));
    LogUtil.d("GameManager", "Response : " + paramContext);
    return paramContext;
  }
  
  public static String readPlayerAchievementGain(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    WeiboParameters localWeiboParameters = new WeiboParameters("");
    if (!TextUtils.isEmpty(paramString1)) {
      localWeiboParameters.put("access_token", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localWeiboParameters.put("source", paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localWeiboParameters.put("game_id", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localWeiboParameters.put("uid", paramString4);
    }
    localWeiboParameters.put("create_time", new Timestamp(new Date().getTime()));
    paramContext = HttpManager.readRsponse(requestHttpExecute(paramContext, URL_ACHIEVEMENT_USER_GAIN, "GET", localWeiboParameters));
    LogUtil.d("GameManager", "Response : " + paramContext);
    return paramContext;
  }
  
  public static String readPlayerFriendsScoreInfo(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    WeiboParameters localWeiboParameters = new WeiboParameters("");
    if (!TextUtils.isEmpty(paramString1)) {
      localWeiboParameters.put("access_token", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localWeiboParameters.put("source", paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localWeiboParameters.put("game_id", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localWeiboParameters.put("uid", paramString4);
    }
    localWeiboParameters.put("create_time", new Timestamp(new Date().getTime()));
    paramContext = HttpManager.readRsponse(requestHttpExecute(paramContext, URL_ACHIEVEMENT_READ_PLAYER_FRIENDS, "GET", localWeiboParameters));
    LogUtil.d("GameManager", "Response : " + paramContext);
    return paramContext;
  }
  
  public static String readPlayerScoreInfo(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    WeiboParameters localWeiboParameters = new WeiboParameters("");
    if (!TextUtils.isEmpty(paramString1)) {
      localWeiboParameters.put("access_token", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localWeiboParameters.put("source", paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localWeiboParameters.put("game_id", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localWeiboParameters.put("uid", paramString4);
    }
    paramContext = HttpManager.readRsponse(requestHttpExecute(paramContext, URL_ACHIEVEMENT_READ_PLAYER_SCORE, "GET", localWeiboParameters));
    LogUtil.d("GameManager", "Response : " + paramContext);
    return paramContext;
  }
  
  /* Error */
  private static org.apache.http.HttpResponse requestHttpExecute(Context paramContext, String paramString1, String paramString2, WeiboParameters paramWeiboParameters)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore_0
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore 8
    //   11: aconst_null
    //   12: astore 6
    //   14: invokestatic 189	com/sina/weibo/sdk/net/HttpManager:getNewHttpClient	()Lorg/apache/http/client/HttpClient;
    //   17: astore 5
    //   19: aload 5
    //   21: astore_0
    //   22: aload 7
    //   24: astore 4
    //   26: aload 8
    //   28: astore 5
    //   30: aload_0
    //   31: invokeinterface 195 1 0
    //   36: ldc -59
    //   38: invokestatic 203	com/sina/weibo/sdk/net/NetStateManager:getAPN	()Lorg/apache/http/HttpHost;
    //   41: invokeinterface 209 3 0
    //   46: pop
    //   47: aload 7
    //   49: astore 4
    //   51: aload 8
    //   53: astore 5
    //   55: aload_2
    //   56: ldc 12
    //   58: invokevirtual 213	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   61: ifeq +186 -> 247
    //   64: aload 7
    //   66: astore 4
    //   68: aload 8
    //   70: astore 5
    //   72: new 53	java/lang/StringBuilder
    //   75: dup
    //   76: aload_1
    //   77: invokestatic 217	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   80: invokespecial 146	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   83: ldc -37
    //   85: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_3
    //   89: invokevirtual 222	com/sina/weibo/sdk/net/WeiboParameters:encodeUrl	()Ljava/lang/String;
    //   92: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: astore_2
    //   99: aload 7
    //   101: astore 4
    //   103: aload 8
    //   105: astore 5
    //   107: new 224	org/apache/http/client/methods/HttpGet
    //   110: dup
    //   111: aload_2
    //   112: invokespecial 225	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   115: astore_1
    //   116: aload 7
    //   118: astore 4
    //   120: aload 8
    //   122: astore 5
    //   124: ldc 23
    //   126: new 53	java/lang/StringBuilder
    //   129: dup
    //   130: ldc -29
    //   132: invokespecial 146	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   135: aload_2
    //   136: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 151	com/sina/weibo/sdk/utils/LogUtil:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: aload 6
    //   147: astore_2
    //   148: aload_2
    //   149: astore 4
    //   151: aload_2
    //   152: astore 5
    //   154: aload_0
    //   155: aload_1
    //   156: invokeinterface 231 2 0
    //   161: astore_1
    //   162: aload_2
    //   163: astore 4
    //   165: aload_2
    //   166: astore 5
    //   168: aload_1
    //   169: invokeinterface 237 1 0
    //   174: invokeinterface 243 1 0
    //   179: istore 9
    //   181: iload 9
    //   183: sipush 200
    //   186: if_icmpeq +357 -> 543
    //   189: aload_2
    //   190: astore 4
    //   192: aload_2
    //   193: astore 5
    //   195: new 245	com/sina/weibo/sdk/exception/WeiboHttpException
    //   198: dup
    //   199: aload_1
    //   200: invokestatic 143	com/sina/weibo/sdk/net/HttpManager:readRsponse	(Lorg/apache/http/HttpResponse;)Ljava/lang/String;
    //   203: iload 9
    //   205: invokespecial 248	com/sina/weibo/sdk/exception/WeiboHttpException:<init>	(Ljava/lang/String;I)V
    //   208: athrow
    //   209: astore_2
    //   210: aload_0
    //   211: astore_1
    //   212: aload 4
    //   214: astore_0
    //   215: new 250	com/sina/weibo/sdk/exception/WeiboException
    //   218: dup
    //   219: aload_2
    //   220: invokespecial 253	com/sina/weibo/sdk/exception/WeiboException:<init>	(Ljava/lang/Throwable;)V
    //   223: athrow
    //   224: astore 4
    //   226: aload_1
    //   227: astore_3
    //   228: aload_0
    //   229: astore_2
    //   230: aload 4
    //   232: astore_1
    //   233: aload_2
    //   234: ifnull +7 -> 241
    //   237: aload_2
    //   238: invokevirtual 258	java/io/ByteArrayOutputStream:close	()V
    //   241: aload_3
    //   242: invokestatic 262	com/sina/weibo/sdk/net/HttpManager:shutdownHttpClient	(Lorg/apache/http/client/HttpClient;)V
    //   245: aload_1
    //   246: athrow
    //   247: aload 7
    //   249: astore 4
    //   251: aload 8
    //   253: astore 5
    //   255: aload_2
    //   256: ldc 15
    //   258: invokevirtual 213	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   261: ifeq +232 -> 493
    //   264: aload 7
    //   266: astore 4
    //   268: aload 8
    //   270: astore 5
    //   272: ldc 23
    //   274: new 53	java/lang/StringBuilder
    //   277: dup
    //   278: ldc_w 264
    //   281: invokespecial 146	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   284: aload_1
    //   285: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokestatic 151	com/sina/weibo/sdk/utils/LogUtil:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: aload 7
    //   296: astore 4
    //   298: aload 8
    //   300: astore 5
    //   302: new 266	org/apache/http/client/methods/HttpPost
    //   305: dup
    //   306: aload_1
    //   307: invokespecial 267	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   310: astore_2
    //   311: aload 7
    //   313: astore 4
    //   315: aload 8
    //   317: astore 5
    //   319: new 255	java/io/ByteArrayOutputStream
    //   322: dup
    //   323: invokespecial 268	java/io/ByteArrayOutputStream:<init>	()V
    //   326: astore_1
    //   327: aload_3
    //   328: invokevirtual 272	com/sina/weibo/sdk/net/WeiboParameters:hasBinaryData	()Z
    //   331: ifeq +58 -> 389
    //   334: aload_2
    //   335: ldc_w 274
    //   338: new 53	java/lang/StringBuilder
    //   341: dup
    //   342: ldc_w 276
    //   345: invokespecial 146	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   348: getstatic 51	com/sina/weibo/sdk/component/GameManager:BOUNDARY	Ljava/lang/String;
    //   351: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokevirtual 279	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   360: aload_1
    //   361: aload_3
    //   362: invokestatic 283	com/sina/weibo/sdk/net/HttpManager:buildParams	(Ljava/io/OutputStream;Lcom/sina/weibo/sdk/net/WeiboParameters;)V
    //   365: aload_2
    //   366: new 285	org/apache/http/entity/ByteArrayEntity
    //   369: dup
    //   370: aload_1
    //   371: invokevirtual 289	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   374: invokespecial 292	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   377: invokevirtual 296	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   380: aload_1
    //   381: astore_3
    //   382: aload_2
    //   383: astore_1
    //   384: aload_3
    //   385: astore_2
    //   386: goto -238 -> 148
    //   389: aload_3
    //   390: ldc_w 298
    //   393: invokevirtual 127	com/sina/weibo/sdk/net/WeiboParameters:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   396: astore 4
    //   398: aload 4
    //   400: ifnull +70 -> 470
    //   403: aload 4
    //   405: instanceof 129
    //   408: ifeq +62 -> 470
    //   411: aload_3
    //   412: ldc_w 298
    //   415: invokevirtual 301	com/sina/weibo/sdk/net/WeiboParameters:remove	(Ljava/lang/String;)V
    //   418: aload_2
    //   419: ldc_w 274
    //   422: aload 4
    //   424: checkcast 129	java/lang/String
    //   427: invokevirtual 279	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   430: aload_3
    //   431: invokevirtual 222	com/sina/weibo/sdk/net/WeiboParameters:encodeUrl	()Ljava/lang/String;
    //   434: astore_3
    //   435: ldc 23
    //   437: new 53	java/lang/StringBuilder
    //   440: dup
    //   441: ldc_w 303
    //   444: invokespecial 146	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   447: aload_3
    //   448: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   454: invokestatic 151	com/sina/weibo/sdk/utils/LogUtil:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   457: aload_1
    //   458: aload_3
    //   459: ldc 9
    //   461: invokevirtual 307	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   464: invokevirtual 310	java/io/ByteArrayOutputStream:write	([B)V
    //   467: goto -102 -> 365
    //   470: aload_2
    //   471: ldc_w 274
    //   474: ldc_w 312
    //   477: invokevirtual 279	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   480: goto -50 -> 430
    //   483: astore_3
    //   484: aload_1
    //   485: astore_2
    //   486: aload_3
    //   487: astore_1
    //   488: aload_0
    //   489: astore_3
    //   490: goto -257 -> 233
    //   493: aload 7
    //   495: astore 4
    //   497: aload 8
    //   499: astore 5
    //   501: aload_2
    //   502: ldc_w 314
    //   505: invokevirtual 213	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   508: ifeq +72 -> 580
    //   511: aload 7
    //   513: astore 4
    //   515: aload 8
    //   517: astore 5
    //   519: new 316	org/apache/http/client/methods/HttpDelete
    //   522: dup
    //   523: aload_1
    //   524: invokespecial 317	org/apache/http/client/methods/HttpDelete:<init>	(Ljava/lang/String;)V
    //   527: astore_1
    //   528: aload 6
    //   530: astore_2
    //   531: goto -383 -> 148
    //   534: astore_1
    //   535: aload 5
    //   537: astore_2
    //   538: aload_0
    //   539: astore_3
    //   540: goto -307 -> 233
    //   543: aload_2
    //   544: ifnull +7 -> 551
    //   547: aload_2
    //   548: invokevirtual 258	java/io/ByteArrayOutputStream:close	()V
    //   551: aload_0
    //   552: invokestatic 262	com/sina/weibo/sdk/net/HttpManager:shutdownHttpClient	(Lorg/apache/http/client/HttpClient;)V
    //   555: aload_1
    //   556: areturn
    //   557: astore_0
    //   558: goto -317 -> 241
    //   561: astore_2
    //   562: goto -11 -> 551
    //   565: astore_1
    //   566: aconst_null
    //   567: astore_3
    //   568: aload 4
    //   570: astore_2
    //   571: goto -338 -> 233
    //   574: astore_2
    //   575: aconst_null
    //   576: astore_1
    //   577: goto -362 -> 215
    //   580: aconst_null
    //   581: astore_1
    //   582: aload 6
    //   584: astore_2
    //   585: goto -437 -> 148
    //   588: astore_2
    //   589: aload_0
    //   590: astore_3
    //   591: aload_1
    //   592: astore_0
    //   593: aload_3
    //   594: astore_1
    //   595: goto -380 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	598	0	paramContext	Context
    //   0	598	1	paramString1	String
    //   0	598	2	paramString2	String
    //   0	598	3	paramWeiboParameters	WeiboParameters
    //   6	207	4	localObject1	Object
    //   224	7	4	localObject2	Object
    //   249	320	4	localObject3	Object
    //   17	519	5	localObject4	Object
    //   12	571	6	localObject5	Object
    //   1	511	7	localObject6	Object
    //   9	507	8	localObject7	Object
    //   179	25	9	i	int
    // Exception table:
    //   from	to	target	type
    //   30	47	209	java/io/IOException
    //   55	64	209	java/io/IOException
    //   72	99	209	java/io/IOException
    //   107	116	209	java/io/IOException
    //   124	145	209	java/io/IOException
    //   154	162	209	java/io/IOException
    //   168	181	209	java/io/IOException
    //   195	209	209	java/io/IOException
    //   255	264	209	java/io/IOException
    //   272	294	209	java/io/IOException
    //   302	311	209	java/io/IOException
    //   319	327	209	java/io/IOException
    //   501	511	209	java/io/IOException
    //   519	528	209	java/io/IOException
    //   215	224	224	finally
    //   327	365	483	finally
    //   365	380	483	finally
    //   389	398	483	finally
    //   403	430	483	finally
    //   430	467	483	finally
    //   470	480	483	finally
    //   30	47	534	finally
    //   55	64	534	finally
    //   72	99	534	finally
    //   107	116	534	finally
    //   124	145	534	finally
    //   154	162	534	finally
    //   168	181	534	finally
    //   195	209	534	finally
    //   255	264	534	finally
    //   272	294	534	finally
    //   302	311	534	finally
    //   319	327	534	finally
    //   501	511	534	finally
    //   519	528	534	finally
    //   237	241	557	java/io/IOException
    //   547	551	561	java/io/IOException
    //   14	19	565	finally
    //   14	19	574	java/io/IOException
    //   327	365	588	java/io/IOException
    //   365	380	588	java/io/IOException
    //   389	398	588	java/io/IOException
    //   403	430	588	java/io/IOException
    //   430	467	588	java/io/IOException
    //   470	480	588	java/io/IOException
  }
  
  public void invatationWeiboFriendsByList(Context paramContext, String paramString1, String paramString2, String paramString3, WeiboAuthListener paramWeiboAuthListener)
  {
    Object localObject = new WeiboParameters(paramString2);
    ((WeiboParameters)localObject).put("access_token", paramString1);
    ((WeiboParameters)localObject).put("source", paramString2);
    String str = INVITATION_URL.toString() + ((WeiboParameters)localObject).encodeUrl();
    localObject = new GameRequestParam(paramContext);
    ((GameRequestParam)localObject).setAppKey(paramString2);
    ((GameRequestParam)localObject).setToken(paramString1);
    ((GameRequestParam)localObject).setLauncher(BrowserLauncher.GAME);
    ((GameRequestParam)localObject).setUrl(str);
    ((GameRequestParam)localObject).setAuthListener(paramWeiboAuthListener);
    paramString1 = new Intent(paramContext, WeiboSdkBrowser.class);
    paramString2 = ((GameRequestParam)localObject).createRequestParamBundle();
    paramString2.putString("key_specify_title", paramString3);
    paramString1.putExtras(paramString2);
    paramContext.startActivity(paramString1);
  }
  
  public void invatationWeiboFriendsInOnePage(Context paramContext, String paramString1, String paramString2, String paramString3, WeiboAuthListener paramWeiboAuthListener, ArrayList<String> paramArrayList)
  {
    Object localObject = new StringBuffer();
    int i;
    if (paramArrayList != null)
    {
      i = 0;
      if (i < paramArrayList.size()) {}
    }
    else
    {
      paramArrayList = new WeiboParameters(paramString2);
      paramArrayList.put("access_token", paramString1);
      paramArrayList.put("source", paramString2);
      localObject = INVITATION_ONE_FRINED_URL.toString() + paramArrayList.encodeUrl() + "&uids=" + ((StringBuffer)localObject).toString();
      paramArrayList = new GameRequestParam(paramContext);
      paramArrayList.setAppKey(paramString2);
      paramArrayList.setToken(paramString1);
      paramArrayList.setLauncher(BrowserLauncher.GAME);
      paramArrayList.setUrl((String)localObject);
      paramArrayList.setAuthListener(paramWeiboAuthListener);
      paramString1 = new Intent(paramContext, WeiboSdkBrowser.class);
      paramString2 = paramArrayList.createRequestParamBundle();
      paramString2.putString("key_specify_title", paramString3);
      paramString1.putExtras(paramString2);
      paramContext.startActivity(paramString1);
      return;
    }
    String str = (String)paramArrayList.get(i);
    if (i == 0) {
      ((StringBuffer)localObject).append(str);
    }
    for (;;)
    {
      i += 1;
      break;
      ((StringBuffer)localObject).append("," + str);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\component\GameManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */