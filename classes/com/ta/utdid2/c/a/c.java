package com.ta.utdid2.c.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import com.ta.utdid2.b.a.i;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class c
{
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private b.a jdField_a_of_type_ComTaUtdid2CAB$a;
  private b jdField_a_of_type_ComTaUtdid2CAB;
  private d jdField_a_of_type_ComTaUtdid2CAD;
  private String e;
  private String f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private Context mContext;
  
  /* Error */
  public c(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 27	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: ldc 29
    //   7: putfield 31	com/ta/utdid2/c/a/c:e	Ljava/lang/String;
    //   10: aload_0
    //   11: ldc 29
    //   13: putfield 33	com/ta/utdid2/c/a/c:f	Ljava/lang/String;
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield 35	com/ta/utdid2/c/a/c:g	Z
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield 37	com/ta/utdid2/c/a/c:h	Z
    //   26: aload_0
    //   27: iconst_0
    //   28: putfield 39	com/ta/utdid2/c/a/c:i	Z
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield 41	com/ta/utdid2/c/a/c:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 43	com/ta/utdid2/c/a/c:jdField_a_of_type_ComTaUtdid2CAB	Lcom/ta/utdid2/c/a/b;
    //   41: aload_0
    //   42: aconst_null
    //   43: putfield 45	com/ta/utdid2/c/a/c:jdField_a_of_type_AndroidContentSharedPreferences$Editor	Landroid/content/SharedPreferences$Editor;
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 47	com/ta/utdid2/c/a/c:jdField_a_of_type_ComTaUtdid2CAB$a	Lcom/ta/utdid2/c/a/b$a;
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield 49	com/ta/utdid2/c/a/c:mContext	Landroid/content/Context;
    //   56: aload_0
    //   57: aconst_null
    //   58: putfield 51	com/ta/utdid2/c/a/c:jdField_a_of_type_ComTaUtdid2CAD	Lcom/ta/utdid2/c/a/d;
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield 53	com/ta/utdid2/c/a/c:j	Z
    //   66: aload_0
    //   67: iload 4
    //   69: putfield 35	com/ta/utdid2/c/a/c:g	Z
    //   72: aload_0
    //   73: iload 5
    //   75: putfield 53	com/ta/utdid2/c/a/c:j	Z
    //   78: aload_0
    //   79: aload_3
    //   80: putfield 31	com/ta/utdid2/c/a/c:e	Ljava/lang/String;
    //   83: aload_0
    //   84: aload_2
    //   85: putfield 33	com/ta/utdid2/c/a/c:f	Ljava/lang/String;
    //   88: aload_0
    //   89: aload_1
    //   90: putfield 49	com/ta/utdid2/c/a/c:mContext	Landroid/content/Context;
    //   93: lconst_0
    //   94: lstore 8
    //   96: lconst_0
    //   97: lstore 14
    //   99: aload_1
    //   100: ifnull +27 -> 127
    //   103: aload_0
    //   104: aload_1
    //   105: aload_3
    //   106: iconst_0
    //   107: invokevirtual 59	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   110: putfield 41	com/ta/utdid2/c/a/c:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   113: aload_0
    //   114: getfield 41	com/ta/utdid2/c/a/c:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   117: ldc 61
    //   119: lconst_0
    //   120: invokeinterface 67 4 0
    //   125: lstore 8
    //   127: aconst_null
    //   128: astore 6
    //   130: invokestatic 73	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   133: astore 7
    //   135: aload 7
    //   137: astore 6
    //   139: aload 6
    //   141: invokestatic 78	com/ta/utdid2/b/a/i:a	(Ljava/lang/String;)Z
    //   144: ifeq +295 -> 439
    //   147: aload_0
    //   148: iconst_0
    //   149: putfield 39	com/ta/utdid2/c/a/c:i	Z
    //   152: aload_0
    //   153: iconst_0
    //   154: putfield 37	com/ta/utdid2/c/a/c:h	Z
    //   157: aload_0
    //   158: getfield 37	com/ta/utdid2/c/a/c:h	Z
    //   161: ifne +18 -> 179
    //   164: lload 8
    //   166: lstore 10
    //   168: lload 14
    //   170: lstore 12
    //   172: aload_0
    //   173: getfield 39	com/ta/utdid2/c/a/c:i	Z
    //   176: ifeq +127 -> 303
    //   179: lload 8
    //   181: lstore 10
    //   183: lload 14
    //   185: lstore 12
    //   187: aload_1
    //   188: ifnull +115 -> 303
    //   191: lload 8
    //   193: lstore 10
    //   195: lload 14
    //   197: lstore 12
    //   199: aload_2
    //   200: invokestatic 78	com/ta/utdid2/b/a/i:a	(Ljava/lang/String;)Z
    //   203: ifne +100 -> 303
    //   206: aload_0
    //   207: aload_0
    //   208: aload_2
    //   209: invokespecial 81	com/ta/utdid2/c/a/c:a	(Ljava/lang/String;)Lcom/ta/utdid2/c/a/d;
    //   212: putfield 51	com/ta/utdid2/c/a/c:jdField_a_of_type_ComTaUtdid2CAD	Lcom/ta/utdid2/c/a/d;
    //   215: lload 8
    //   217: lstore 10
    //   219: lload 14
    //   221: lstore 12
    //   223: aload_0
    //   224: getfield 51	com/ta/utdid2/c/a/c:jdField_a_of_type_ComTaUtdid2CAD	Lcom/ta/utdid2/c/a/d;
    //   227: ifnull +76 -> 303
    //   230: aload_0
    //   231: aload_0
    //   232: getfield 51	com/ta/utdid2/c/a/c:jdField_a_of_type_ComTaUtdid2CAD	Lcom/ta/utdid2/c/a/d;
    //   235: aload_3
    //   236: iconst_0
    //   237: invokevirtual 86	com/ta/utdid2/c/a/d:a	(Ljava/lang/String;I)Lcom/ta/utdid2/c/a/b;
    //   240: putfield 43	com/ta/utdid2/c/a/c:jdField_a_of_type_ComTaUtdid2CAB	Lcom/ta/utdid2/c/a/b;
    //   243: aload_0
    //   244: getfield 43	com/ta/utdid2/c/a/c:jdField_a_of_type_ComTaUtdid2CAB	Lcom/ta/utdid2/c/a/b;
    //   247: ldc 61
    //   249: lconst_0
    //   250: invokeinterface 89 4 0
    //   255: lstore 10
    //   257: iload 5
    //   259: ifne +308 -> 567
    //   262: lload 8
    //   264: lload 10
    //   266: lcmp
    //   267: ifle +231 -> 498
    //   270: aload_0
    //   271: aload_0
    //   272: getfield 41	com/ta/utdid2/c/a/c:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   275: aload_0
    //   276: getfield 43	com/ta/utdid2/c/a/c:jdField_a_of_type_ComTaUtdid2CAB	Lcom/ta/utdid2/c/a/b;
    //   279: invokespecial 92	com/ta/utdid2/c/a/c:a	(Landroid/content/SharedPreferences;Lcom/ta/utdid2/c/a/b;)V
    //   282: aload_0
    //   283: aload_0
    //   284: getfield 51	com/ta/utdid2/c/a/c:jdField_a_of_type_ComTaUtdid2CAD	Lcom/ta/utdid2/c/a/d;
    //   287: aload_3
    //   288: iconst_0
    //   289: invokevirtual 86	com/ta/utdid2/c/a/d:a	(Ljava/lang/String;I)Lcom/ta/utdid2/c/a/b;
    //   292: putfield 43	com/ta/utdid2/c/a/c:jdField_a_of_type_ComTaUtdid2CAB	Lcom/ta/utdid2/c/a/b;
    //   295: lload 10
    //   297: lstore 12
    //   299: lload 8
    //   301: lstore 10
    //   303: lload 10
    //   305: lload 12
    //   307: lcmp
    //   308: ifne +17 -> 325
    //   311: lload 10
    //   313: lconst_0
    //   314: lcmp
    //   315: ifne +113 -> 428
    //   318: lload 12
    //   320: lconst_0
    //   321: lcmp
    //   322: ifne +106 -> 428
    //   325: invokestatic 98	java/lang/System:currentTimeMillis	()J
    //   328: lstore 8
    //   330: aload_0
    //   331: getfield 53	com/ta/utdid2/c/a/c:j	Z
    //   334: ifeq +24 -> 358
    //   337: aload_0
    //   338: getfield 53	com/ta/utdid2/c/a/c:j	Z
    //   341: ifeq +87 -> 428
    //   344: lload 10
    //   346: lconst_0
    //   347: lcmp
    //   348: ifne +80 -> 428
    //   351: lload 12
    //   353: lconst_0
    //   354: lcmp
    //   355: ifne +73 -> 428
    //   358: aload_0
    //   359: getfield 41	com/ta/utdid2/c/a/c:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   362: ifnull +31 -> 393
    //   365: aload_0
    //   366: getfield 41	com/ta/utdid2/c/a/c:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   369: invokeinterface 102 1 0
    //   374: astore_1
    //   375: aload_1
    //   376: ldc 104
    //   378: lload 8
    //   380: invokeinterface 110 4 0
    //   385: pop
    //   386: aload_1
    //   387: invokeinterface 114 1 0
    //   392: pop
    //   393: aload_0
    //   394: getfield 43	com/ta/utdid2/c/a/c:jdField_a_of_type_ComTaUtdid2CAB	Lcom/ta/utdid2/c/a/b;
    //   397: ifnull +31 -> 428
    //   400: aload_0
    //   401: getfield 43	com/ta/utdid2/c/a/c:jdField_a_of_type_ComTaUtdid2CAB	Lcom/ta/utdid2/c/a/b;
    //   404: invokeinterface 117 1 0
    //   409: astore_1
    //   410: aload_1
    //   411: ldc 104
    //   413: lload 8
    //   415: invokeinterface 122 4 0
    //   420: pop
    //   421: aload_1
    //   422: invokeinterface 123 1 0
    //   427: pop
    //   428: return
    //   429: astore 7
    //   431: aload 7
    //   433: invokevirtual 126	java/lang/Exception:printStackTrace	()V
    //   436: goto -297 -> 139
    //   439: aload 6
    //   441: ldc -128
    //   443: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   446: ifeq +16 -> 462
    //   449: aload_0
    //   450: iconst_1
    //   451: putfield 39	com/ta/utdid2/c/a/c:i	Z
    //   454: aload_0
    //   455: iconst_1
    //   456: putfield 37	com/ta/utdid2/c/a/c:h	Z
    //   459: goto -302 -> 157
    //   462: aload 6
    //   464: ldc -120
    //   466: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   469: ifeq +16 -> 485
    //   472: aload_0
    //   473: iconst_1
    //   474: putfield 37	com/ta/utdid2/c/a/c:h	Z
    //   477: aload_0
    //   478: iconst_0
    //   479: putfield 39	com/ta/utdid2/c/a/c:i	Z
    //   482: goto -325 -> 157
    //   485: aload_0
    //   486: iconst_0
    //   487: putfield 39	com/ta/utdid2/c/a/c:i	Z
    //   490: aload_0
    //   491: iconst_0
    //   492: putfield 37	com/ta/utdid2/c/a/c:h	Z
    //   495: goto -338 -> 157
    //   498: lload 8
    //   500: lload 10
    //   502: lcmp
    //   503: ifge +28 -> 531
    //   506: aload_0
    //   507: aload_0
    //   508: getfield 43	com/ta/utdid2/c/a/c:jdField_a_of_type_ComTaUtdid2CAB	Lcom/ta/utdid2/c/a/b;
    //   511: aload_0
    //   512: getfield 41	com/ta/utdid2/c/a/c:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   515: invokespecial 139	com/ta/utdid2/c/a/c:a	(Lcom/ta/utdid2/c/a/b;Landroid/content/SharedPreferences;)V
    //   518: aload_0
    //   519: aload_1
    //   520: aload_3
    //   521: iconst_0
    //   522: invokevirtual 59	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   525: putfield 41	com/ta/utdid2/c/a/c:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   528: goto -233 -> 295
    //   531: lload 8
    //   533: lload 10
    //   535: lcmp
    //   536: ifne +296 -> 832
    //   539: aload_0
    //   540: aload_0
    //   541: getfield 41	com/ta/utdid2/c/a/c:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   544: aload_0
    //   545: getfield 43	com/ta/utdid2/c/a/c:jdField_a_of_type_ComTaUtdid2CAB	Lcom/ta/utdid2/c/a/b;
    //   548: invokespecial 92	com/ta/utdid2/c/a/c:a	(Landroid/content/SharedPreferences;Lcom/ta/utdid2/c/a/b;)V
    //   551: aload_0
    //   552: aload_0
    //   553: getfield 51	com/ta/utdid2/c/a/c:jdField_a_of_type_ComTaUtdid2CAD	Lcom/ta/utdid2/c/a/d;
    //   556: aload_3
    //   557: iconst_0
    //   558: invokevirtual 86	com/ta/utdid2/c/a/d:a	(Ljava/lang/String;I)Lcom/ta/utdid2/c/a/b;
    //   561: putfield 43	com/ta/utdid2/c/a/c:jdField_a_of_type_ComTaUtdid2CAB	Lcom/ta/utdid2/c/a/b;
    //   564: goto -269 -> 295
    //   567: aload_0
    //   568: getfield 41	com/ta/utdid2/c/a/c:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   571: ldc 104
    //   573: lconst_0
    //   574: invokeinterface 67 4 0
    //   579: lstore 12
    //   581: lload 12
    //   583: lstore 8
    //   585: aload_0
    //   586: getfield 43	com/ta/utdid2/c/a/c:jdField_a_of_type_ComTaUtdid2CAB	Lcom/ta/utdid2/c/a/b;
    //   589: ldc 104
    //   591: lconst_0
    //   592: invokeinterface 89 4 0
    //   597: lstore 12
    //   599: lload 12
    //   601: lstore 10
    //   603: lload 8
    //   605: lload 10
    //   607: lcmp
    //   608: ifge +38 -> 646
    //   611: lload 8
    //   613: lconst_0
    //   614: lcmp
    //   615: ifle +31 -> 646
    //   618: aload_0
    //   619: aload_0
    //   620: getfield 41	com/ta/utdid2/c/a/c:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   623: aload_0
    //   624: getfield 43	com/ta/utdid2/c/a/c:jdField_a_of_type_ComTaUtdid2CAB	Lcom/ta/utdid2/c/a/b;
    //   627: invokespecial 92	com/ta/utdid2/c/a/c:a	(Landroid/content/SharedPreferences;Lcom/ta/utdid2/c/a/b;)V
    //   630: aload_0
    //   631: aload_0
    //   632: getfield 51	com/ta/utdid2/c/a/c:jdField_a_of_type_ComTaUtdid2CAD	Lcom/ta/utdid2/c/a/d;
    //   635: aload_3
    //   636: iconst_0
    //   637: invokevirtual 86	com/ta/utdid2/c/a/d:a	(Ljava/lang/String;I)Lcom/ta/utdid2/c/a/b;
    //   640: putfield 43	com/ta/utdid2/c/a/c:jdField_a_of_type_ComTaUtdid2CAB	Lcom/ta/utdid2/c/a/b;
    //   643: goto -348 -> 295
    //   646: lload 8
    //   648: lload 10
    //   650: lcmp
    //   651: ifle +35 -> 686
    //   654: lload 10
    //   656: lconst_0
    //   657: lcmp
    //   658: ifle +28 -> 686
    //   661: aload_0
    //   662: aload_0
    //   663: getfield 43	com/ta/utdid2/c/a/c:jdField_a_of_type_ComTaUtdid2CAB	Lcom/ta/utdid2/c/a/b;
    //   666: aload_0
    //   667: getfield 41	com/ta/utdid2/c/a/c:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   670: invokespecial 139	com/ta/utdid2/c/a/c:a	(Lcom/ta/utdid2/c/a/b;Landroid/content/SharedPreferences;)V
    //   673: aload_0
    //   674: aload_1
    //   675: aload_3
    //   676: iconst_0
    //   677: invokevirtual 59	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   680: putfield 41	com/ta/utdid2/c/a/c:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   683: goto -388 -> 295
    //   686: lload 8
    //   688: lconst_0
    //   689: lcmp
    //   690: ifne +35 -> 725
    //   693: lload 10
    //   695: lconst_0
    //   696: lcmp
    //   697: ifle +28 -> 725
    //   700: aload_0
    //   701: aload_0
    //   702: getfield 43	com/ta/utdid2/c/a/c:jdField_a_of_type_ComTaUtdid2CAB	Lcom/ta/utdid2/c/a/b;
    //   705: aload_0
    //   706: getfield 41	com/ta/utdid2/c/a/c:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   709: invokespecial 139	com/ta/utdid2/c/a/c:a	(Lcom/ta/utdid2/c/a/b;Landroid/content/SharedPreferences;)V
    //   712: aload_0
    //   713: aload_1
    //   714: aload_3
    //   715: iconst_0
    //   716: invokevirtual 59	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   719: putfield 41	com/ta/utdid2/c/a/c:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   722: goto -427 -> 295
    //   725: lload 10
    //   727: lconst_0
    //   728: lcmp
    //   729: ifne +38 -> 767
    //   732: lload 8
    //   734: lconst_0
    //   735: lcmp
    //   736: ifle +31 -> 767
    //   739: aload_0
    //   740: aload_0
    //   741: getfield 41	com/ta/utdid2/c/a/c:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   744: aload_0
    //   745: getfield 43	com/ta/utdid2/c/a/c:jdField_a_of_type_ComTaUtdid2CAB	Lcom/ta/utdid2/c/a/b;
    //   748: invokespecial 92	com/ta/utdid2/c/a/c:a	(Landroid/content/SharedPreferences;Lcom/ta/utdid2/c/a/b;)V
    //   751: aload_0
    //   752: aload_0
    //   753: getfield 51	com/ta/utdid2/c/a/c:jdField_a_of_type_ComTaUtdid2CAD	Lcom/ta/utdid2/c/a/d;
    //   756: aload_3
    //   757: iconst_0
    //   758: invokevirtual 86	com/ta/utdid2/c/a/d:a	(Ljava/lang/String;I)Lcom/ta/utdid2/c/a/b;
    //   761: putfield 43	com/ta/utdid2/c/a/c:jdField_a_of_type_ComTaUtdid2CAB	Lcom/ta/utdid2/c/a/b;
    //   764: goto -469 -> 295
    //   767: lload 8
    //   769: lload 10
    //   771: lcmp
    //   772: ifne +28 -> 800
    //   775: aload_0
    //   776: aload_0
    //   777: getfield 41	com/ta/utdid2/c/a/c:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   780: aload_0
    //   781: getfield 43	com/ta/utdid2/c/a/c:jdField_a_of_type_ComTaUtdid2CAB	Lcom/ta/utdid2/c/a/b;
    //   784: invokespecial 92	com/ta/utdid2/c/a/c:a	(Landroid/content/SharedPreferences;Lcom/ta/utdid2/c/a/b;)V
    //   787: aload_0
    //   788: aload_0
    //   789: getfield 51	com/ta/utdid2/c/a/c:jdField_a_of_type_ComTaUtdid2CAD	Lcom/ta/utdid2/c/a/d;
    //   792: aload_3
    //   793: iconst_0
    //   794: invokevirtual 86	com/ta/utdid2/c/a/d:a	(Ljava/lang/String;I)Lcom/ta/utdid2/c/a/b;
    //   797: putfield 43	com/ta/utdid2/c/a/c:jdField_a_of_type_ComTaUtdid2CAB	Lcom/ta/utdid2/c/a/b;
    //   800: goto -505 -> 295
    //   803: astore_1
    //   804: lconst_0
    //   805: lstore 10
    //   807: lload 10
    //   809: lstore 12
    //   811: lload 8
    //   813: lstore 10
    //   815: goto -512 -> 303
    //   818: astore_1
    //   819: return
    //   820: astore_1
    //   821: goto -14 -> 807
    //   824: astore_1
    //   825: goto -18 -> 807
    //   828: astore_1
    //   829: goto -22 -> 807
    //   832: goto -537 -> 295
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	835	0	this	c
    //   0	835	1	paramContext	Context
    //   0	835	2	paramString1	String
    //   0	835	3	paramString2	String
    //   0	835	4	paramBoolean1	boolean
    //   0	835	5	paramBoolean2	boolean
    //   128	335	6	localObject	Object
    //   133	3	7	str	String
    //   429	3	7	localException	Exception
    //   94	718	8	l1	long
    //   166	648	10	l2	long
    //   170	640	12	l3	long
    //   97	123	14	l4	long
    // Exception table:
    //   from	to	target	type
    //   130	135	429	java/lang/Exception
    //   230	257	803	java/lang/Exception
    //   393	428	818	java/lang/Exception
    //   270	295	820	java/lang/Exception
    //   506	528	820	java/lang/Exception
    //   539	564	820	java/lang/Exception
    //   567	581	820	java/lang/Exception
    //   585	599	824	java/lang/Exception
    //   618	643	828	java/lang/Exception
    //   661	683	828	java/lang/Exception
    //   700	722	828	java/lang/Exception
    //   739	764	828	java/lang/Exception
    //   775	800	828	java/lang/Exception
  }
  
  private d a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null)
    {
      this.jdField_a_of_type_ComTaUtdid2CAD = new d(paramString.getAbsolutePath());
      return this.jdField_a_of_type_ComTaUtdid2CAD;
    }
    return null;
  }
  
  private File a(String paramString)
  {
    File localFile = Environment.getExternalStorageDirectory();
    if (localFile != null)
    {
      paramString = new File(String.format("%s%s%s", new Object[] { localFile.getAbsolutePath(), File.separator, paramString }));
      if ((paramString != null) && (!paramString.exists())) {
        paramString.mkdirs();
      }
      return paramString;
    }
    return null;
  }
  
  private void a(SharedPreferences paramSharedPreferences, b paramb)
  {
    if ((paramSharedPreferences != null) && (paramb != null))
    {
      paramb = paramb.a();
      if (paramb != null)
      {
        paramb.b();
        paramSharedPreferences = paramSharedPreferences.getAll().entrySet().iterator();
        while (paramSharedPreferences.hasNext())
        {
          Object localObject = (Map.Entry)paramSharedPreferences.next();
          String str = (String)((Map.Entry)localObject).getKey();
          localObject = ((Map.Entry)localObject).getValue();
          if ((localObject instanceof String)) {
            paramb.a(str, (String)localObject);
          } else if ((localObject instanceof Integer)) {
            paramb.a(str, ((Integer)localObject).intValue());
          } else if ((localObject instanceof Long)) {
            paramb.a(str, ((Long)localObject).longValue());
          } else if ((localObject instanceof Float)) {
            paramb.a(str, ((Float)localObject).floatValue());
          } else if ((localObject instanceof Boolean)) {
            paramb.a(str, ((Boolean)localObject).booleanValue());
          }
        }
        paramb.commit();
      }
    }
  }
  
  private void a(b paramb, SharedPreferences paramSharedPreferences)
  {
    if ((paramb != null) && (paramSharedPreferences != null))
    {
      paramSharedPreferences = paramSharedPreferences.edit();
      if (paramSharedPreferences != null)
      {
        paramSharedPreferences.clear();
        paramb = paramb.getAll().entrySet().iterator();
        while (paramb.hasNext())
        {
          Object localObject = (Map.Entry)paramb.next();
          String str = (String)((Map.Entry)localObject).getKey();
          localObject = ((Map.Entry)localObject).getValue();
          if ((localObject instanceof String)) {
            paramSharedPreferences.putString(str, (String)localObject);
          } else if ((localObject instanceof Integer)) {
            paramSharedPreferences.putInt(str, ((Integer)localObject).intValue());
          } else if ((localObject instanceof Long)) {
            paramSharedPreferences.putLong(str, ((Long)localObject).longValue());
          } else if ((localObject instanceof Float)) {
            paramSharedPreferences.putFloat(str, ((Float)localObject).floatValue());
          } else if ((localObject instanceof Boolean)) {
            paramSharedPreferences.putBoolean(str, ((Boolean)localObject).booleanValue());
          }
        }
        paramSharedPreferences.commit();
      }
    }
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_ComTaUtdid2CAB != null)
    {
      boolean bool = this.jdField_a_of_type_ComTaUtdid2CAB.a();
      if (!bool) {
        commit();
      }
      return bool;
    }
    return false;
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_AndroidContentSharedPreferences$Editor == null) && (this.jdField_a_of_type_AndroidContentSharedPreferences != null)) {
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    }
    if ((this.i) && (this.jdField_a_of_type_ComTaUtdid2CAB$a == null) && (this.jdField_a_of_type_ComTaUtdid2CAB != null)) {
      this.jdField_a_of_type_ComTaUtdid2CAB$a = this.jdField_a_of_type_ComTaUtdid2CAB.a();
    }
    b();
  }
  
  public boolean commit()
  {
    boolean bool2 = true;
    long l = System.currentTimeMillis();
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidContentSharedPreferences$Editor != null)
    {
      if ((!this.j) && (this.jdField_a_of_type_AndroidContentSharedPreferences != null)) {
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("t", l);
      }
      bool1 = bool2;
      if (!this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit()) {
        bool1 = false;
      }
    }
    if ((this.jdField_a_of_type_AndroidContentSharedPreferences != null) && (this.mContext != null)) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = this.mContext.getSharedPreferences(this.e, 0);
    }
    Object localObject1 = null;
    try
    {
      localObject2 = Environment.getExternalStorageState();
      localObject1 = localObject2;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        try
        {
          Object localObject2;
          boolean bool3;
          if (this.jdField_a_of_type_ComTaUtdid2CAD != null)
          {
            this.jdField_a_of_type_ComTaUtdid2CAB = this.jdField_a_of_type_ComTaUtdid2CAD.a(this.e, 0);
            bool3 = bool2;
          }
          return bool3;
        }
        catch (Exception localException1) {}
        localException2 = localException2;
        localException2.printStackTrace();
        continue;
        a(this.jdField_a_of_type_ComTaUtdid2CAB, this.jdField_a_of_type_AndroidContentSharedPreferences);
        continue;
        bool2 = bool1;
        if (this.jdField_a_of_type_ComTaUtdid2CAB$a != null)
        {
          bool2 = bool1;
          if (!this.jdField_a_of_type_ComTaUtdid2CAB$a.commit()) {
            bool2 = false;
          }
        }
      }
    }
    bool3 = bool1;
    if (!i.a((String)localObject1))
    {
      bool2 = bool1;
      if (((String)localObject1).equals("mounted"))
      {
        if (this.jdField_a_of_type_ComTaUtdid2CAB != null) {
          break label289;
        }
        localObject2 = a(this.f);
        bool2 = bool1;
        if (localObject2 != null)
        {
          this.jdField_a_of_type_ComTaUtdid2CAB = ((d)localObject2).a(this.e, 0);
          if (this.j) {
            break label274;
          }
          a(this.jdField_a_of_type_AndroidContentSharedPreferences, this.jdField_a_of_type_ComTaUtdid2CAB);
          this.jdField_a_of_type_ComTaUtdid2CAB$a = this.jdField_a_of_type_ComTaUtdid2CAB.a();
          bool2 = bool1;
        }
      }
      if (!((String)localObject1).equals("mounted"))
      {
        bool3 = bool2;
        if (((String)localObject1).equals("mounted_ro"))
        {
          bool3 = bool2;
          if (this.jdField_a_of_type_ComTaUtdid2CAB == null) {}
        }
      }
      else
      {
        bool3 = bool2;
      }
    }
    label274:
    label289:
    return bool2;
  }
  
  public String getString(String paramString)
  {
    b();
    if (this.jdField_a_of_type_AndroidContentSharedPreferences != null)
    {
      String str = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(paramString, "");
      if (!i.a(str)) {
        return str;
      }
    }
    if (this.jdField_a_of_type_ComTaUtdid2CAB != null) {
      return this.jdField_a_of_type_ComTaUtdid2CAB.getString(paramString, "");
    }
    return "";
  }
  
  public void putString(String paramString1, String paramString2)
  {
    if ((!i.a(paramString1)) && (!paramString1.equals("t")))
    {
      c();
      if (this.jdField_a_of_type_AndroidContentSharedPreferences$Editor != null) {
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString(paramString1, paramString2);
      }
      if (this.jdField_a_of_type_ComTaUtdid2CAB$a != null) {
        this.jdField_a_of_type_ComTaUtdid2CAB$a.a(paramString1, paramString2);
      }
    }
  }
  
  public void remove(String paramString)
  {
    if ((!i.a(paramString)) && (!paramString.equals("t")))
    {
      c();
      if (this.jdField_a_of_type_AndroidContentSharedPreferences$Editor != null) {
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.remove(paramString);
      }
      if (this.jdField_a_of_type_ComTaUtdid2CAB$a != null) {
        this.jdField_a_of_type_ComTaUtdid2CAB$a.a(paramString);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\ta\utdid2\c\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */