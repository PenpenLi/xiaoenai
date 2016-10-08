package com.sina.weibo.sdk.register.mobile;

import android.content.Context;
import android.text.TextUtils;

public class PinyinUtils
{
  private static final int DISTINGUISH_LEN = 10;
  private static final char FIRST_CHINA = '一';
  private static final char LAST_CHINA = '龥';
  private static final String[] PINYIN = { "a", "ai", "an", "ang", "ao", "ba", "bai", "ban", "bang", "bao", "bei", "ben", "beng", "bi", "bian", "biao", "bie", "bin", "bing", "bo", "bu", "ca", "cai", "can", "cang", "cao", "ce", "cen", "ceng", "cha", "chai", "chan", "chang", "chao", "che", "chen", "cheng", "chi", "chong", "chou", "chu", "chuai", "chuan", "chuang", "chui", "chun", "chuo", "ci", "cong", "cou", "cu", "cuan", "cui", "cun", "cuo", "da", "dai", "dan", "dang", "dao", "de", "deng", "di", "dia", "dian", "diao", "die", "ding", "diu", "dong", "dou", "du", "duan", "dui", "dun", "duo", "e", "ei", "en", "er", "fa", "fan", "fang", "fei", "fen", "feng", "fo", "fou", "fu", "ga", "gai", "gan", "gang", "gao", "ge", "gei", "gen", "geng", "gong", "gou", "gu", "gua", "guai", "guan", "guang", "gui", "gun", "guo", "ha", "hai", "han", "hang", "hao", "he", "hei", "hen", "heng", "hong", "hou", "hu", "hua", "huai", "huan", "huang", "hui", "hun", "huo", "ji", "jia", "jian", "jiang", "jiao", "jie", "jin", "jing", "jiong", "jiu", "ju", "juan", "jue", "jun", "ka", "kai", "kan", "kang", "kao", "ke", "ken", "keng", "kong", "kou", "ku", "kua", "kuai", "kuan", "kuang", "kui", "kun", "kuo", "la", "lai", "lan", "lang", "lao", "le", "lei", "leng", "li", "lia", "lian", "liang", "liao", "lie", "lin", "ling", "liu", "long", "lou", "lu", "luan", "lun", "luo", "lv", "lve", "m", "ma", "mai", "man", "mang", "mao", "me", "mei", "men", "meng", "mi", "mian", "miao", "mie", "min", "ming", "miu", "mo", "mou", "mu", "na", "nai", "nan", "nang", "nao", "ne", "nei", "nen", "neng", "ng", "ni", "nian", "niang", "niao", "nie", "nin", "ning", "niu", "none", "nong", "nou", "nu", "nuan", "nuo", "nv", "nve", "o", "ou", "pa", "pai", "pan", "pang", "pao", "pei", "pen", "peng", "pi", "pian", "piao", "pie", "pin", "ping", "po", "pou", "pu", "qi", "qia", "qian", "qiang", "qiao", "qie", "qin", "qing", "qiong", "qiu", "qu", "quan", "que", "qun", "ran", "rang", "rao", "re", "ren", "reng", "ri", "rong", "rou", "ru", "ruan", "rui", "run", "ruo", "sa", "sai", "san", "sang", "sao", "se", "sen", "seng", "sha", "shai", "shan", "shang", "shao", "she", "shei", "shen", "sheng", "shi", "shou", "shu", "shua", "shuai", "shuan", "shuang", "shui", "shun", "shuo", "si", "song", "sou", "su", "suan", "sui", "sun", "suo", "ta", "tai", "tan", "tang", "tao", "te", "teng", "ti", "tian", "tiao", "tie", "ting", "tong", "tou", "tu", "tuan", "tui", "tun", "tuo", "wa", "wai", "wan", "wang", "wei", "wen", "weng", "wo", "wu", "xi", "xia", "xian", "xiang", "xiao", "xie", "xin", "xing", "xiong", "xiu", "xu", "xuan", "xue", "xun", "ya", "yan", "yang", "yao", "ye", "yi", "yiao", "yin", "ying", "yo", "yong", "you", "yu", "yuan", "yue", "yun", "za", "zai", "zan", "zang", "zao", "ze", "zei", "zen", "zeng", "zha", "zhai", "zhan", "zhang", "zhao", "zhe", "zhei", "zhen", "zheng", "zhi", "zhong", "zhou", "zhu", "zhua", "zhuai", "zhuan", "zhuang", "zhui", "zhun", "zhuo", "zi", "zong", "zou", "zu", "zuan", "zui", "zun", "zuo" };
  private static final char SPECIAL_HANZI = '〇';
  private static final String SPECIAL_HANZI_PINYIN = "LING";
  private static volatile boolean isLoad = false;
  private static PinyinUtils sInstance;
  private static short[] sPinyinIndex;
  
  private boolean distinguish(char[] paramArrayOfChar1, char[] paramArrayOfChar2, String[] paramArrayOfString, int paramInt)
  {
    boolean bool2 = false;
    paramArrayOfChar1 = new String(paramArrayOfChar1);
    int i = 0;
    int j = 0;
    for (;;)
    {
      boolean bool1;
      if (i >= paramInt) {
        bool1 = true;
      }
      do
      {
        return bool1;
        int k = paramArrayOfChar1.indexOf(paramArrayOfString[i].charAt(0), j);
        j = k;
        if (k == -1) {
          j = paramArrayOfChar1.indexOf(paramArrayOfChar2[i], k);
        }
        bool1 = bool2;
      } while (j == -1);
      i += 1;
      j += 1;
    }
  }
  
  public static PinyinUtils getInstance(Context paramContext)
  {
    try
    {
      if (sInstance == null) {
        sInstance = new PinyinUtils();
      }
      loadData(paramContext);
      paramContext = sInstance;
      return paramContext;
    }
    finally {}
  }
  
  public static PinyinUtils getObject()
  {
    return sInstance;
  }
  
  private String getPinyin(char paramChar)
  {
    Object localObject;
    if (!isLoad) {
      localObject = "";
    }
    String str;
    do
    {
      return (String)localObject;
      if (paramChar == '〇') {
        return "LING";
      }
      if ((paramChar < '一') || (paramChar > 40869)) {
        return String.valueOf(paramChar);
      }
      str = PINYIN[sPinyinIndex[(paramChar - '一')]];
      localObject = str;
    } while (str != null);
    return "";
  }
  
  /* Error */
  private static void loadData(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_1
    //   4: getstatic 851	com/sina/weibo/sdk/register/mobile/PinyinUtils:isLoad	Z
    //   7: istore 5
    //   9: iload 5
    //   11: ifeq +28 -> 39
    //   14: iconst_0
    //   15: ifeq +11 -> 26
    //   18: new 894	java/lang/NullPointerException
    //   21: dup
    //   22: invokespecial 895	java/lang/NullPointerException:<init>	()V
    //   25: athrow
    //   26: iconst_0
    //   27: ifeq +11 -> 38
    //   30: new 894	java/lang/NullPointerException
    //   33: dup
    //   34: invokespecial 895	java/lang/NullPointerException:<init>	()V
    //   37: athrow
    //   38: return
    //   39: aload_0
    //   40: invokevirtual 901	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   43: ldc_w 903
    //   46: invokevirtual 909	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   49: astore_0
    //   50: new 911	java/io/DataInputStream
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 914	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   58: astore_1
    //   59: aload_1
    //   60: astore_3
    //   61: aload_0
    //   62: astore_2
    //   63: aload_1
    //   64: invokevirtual 918	java/io/DataInputStream:available	()I
    //   67: iconst_1
    //   68: ishr
    //   69: i2l
    //   70: l2i
    //   71: newarray <illegal type>
    //   73: putstatic 888	com/sina/weibo/sdk/register/mobile/PinyinUtils:sPinyinIndex	[S
    //   76: iconst_0
    //   77: istore 4
    //   79: aload_1
    //   80: astore_3
    //   81: aload_0
    //   82: astore_2
    //   83: iload 4
    //   85: getstatic 888	com/sina/weibo/sdk/register/mobile/PinyinUtils:sPinyinIndex	[S
    //   88: arraylength
    //   89: if_icmplt +30 -> 119
    //   92: aload_1
    //   93: astore_3
    //   94: aload_0
    //   95: astore_2
    //   96: iconst_1
    //   97: putstatic 851	com/sina/weibo/sdk/register/mobile/PinyinUtils:isLoad	Z
    //   100: aload_1
    //   101: ifnull +7 -> 108
    //   104: aload_1
    //   105: invokevirtual 921	java/io/DataInputStream:close	()V
    //   108: aload_0
    //   109: ifnull -71 -> 38
    //   112: aload_0
    //   113: invokevirtual 924	java/io/InputStream:close	()V
    //   116: return
    //   117: astore_0
    //   118: return
    //   119: aload_1
    //   120: astore_3
    //   121: aload_0
    //   122: astore_2
    //   123: getstatic 888	com/sina/weibo/sdk/register/mobile/PinyinUtils:sPinyinIndex	[S
    //   126: iload 4
    //   128: aload_1
    //   129: invokevirtual 928	java/io/DataInputStream:readShort	()S
    //   132: sastore
    //   133: iload 4
    //   135: iconst_1
    //   136: iadd
    //   137: istore 4
    //   139: goto -60 -> 79
    //   142: astore_0
    //   143: aconst_null
    //   144: astore_0
    //   145: iconst_0
    //   146: putstatic 851	com/sina/weibo/sdk/register/mobile/PinyinUtils:isLoad	Z
    //   149: aload_0
    //   150: ifnull +7 -> 157
    //   153: aload_0
    //   154: invokevirtual 921	java/io/DataInputStream:close	()V
    //   157: aload_1
    //   158: ifnull -120 -> 38
    //   161: aload_1
    //   162: invokevirtual 924	java/io/InputStream:close	()V
    //   165: return
    //   166: astore_0
    //   167: return
    //   168: astore_0
    //   169: aconst_null
    //   170: astore_1
    //   171: aconst_null
    //   172: astore_0
    //   173: aload_1
    //   174: astore_3
    //   175: aload_0
    //   176: astore_2
    //   177: iconst_0
    //   178: putstatic 851	com/sina/weibo/sdk/register/mobile/PinyinUtils:isLoad	Z
    //   181: aload_1
    //   182: ifnull +7 -> 189
    //   185: aload_1
    //   186: invokevirtual 921	java/io/DataInputStream:close	()V
    //   189: aload_0
    //   190: ifnull -152 -> 38
    //   193: aload_0
    //   194: invokevirtual 924	java/io/InputStream:close	()V
    //   197: return
    //   198: astore_0
    //   199: return
    //   200: astore_1
    //   201: aconst_null
    //   202: astore_0
    //   203: aload_3
    //   204: ifnull +7 -> 211
    //   207: aload_3
    //   208: invokevirtual 921	java/io/DataInputStream:close	()V
    //   211: aload_0
    //   212: ifnull +7 -> 219
    //   215: aload_0
    //   216: invokevirtual 924	java/io/InputStream:close	()V
    //   219: aload_1
    //   220: athrow
    //   221: astore_0
    //   222: goto -3 -> 219
    //   225: astore_1
    //   226: goto -23 -> 203
    //   229: astore_1
    //   230: aload_2
    //   231: astore_0
    //   232: goto -29 -> 203
    //   235: astore_3
    //   236: aload_1
    //   237: astore_2
    //   238: aload_3
    //   239: astore_1
    //   240: aload_0
    //   241: astore_3
    //   242: aload_2
    //   243: astore_0
    //   244: goto -41 -> 203
    //   247: astore_1
    //   248: aconst_null
    //   249: astore_1
    //   250: goto -77 -> 173
    //   253: astore_2
    //   254: goto -81 -> 173
    //   257: astore_1
    //   258: aconst_null
    //   259: astore_2
    //   260: aload_0
    //   261: astore_1
    //   262: aload_2
    //   263: astore_0
    //   264: goto -119 -> 145
    //   267: astore_2
    //   268: aload_0
    //   269: astore_2
    //   270: aload_1
    //   271: astore_0
    //   272: aload_2
    //   273: astore_1
    //   274: goto -129 -> 145
    //   277: astore_0
    //   278: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	paramContext	Context
    //   3	183	1	localDataInputStream	java.io.DataInputStream
    //   200	20	1	localObject1	Object
    //   225	1	1	localObject2	Object
    //   229	8	1	localObject3	Object
    //   239	1	1	localObject4	Object
    //   247	1	1	localException1	Exception
    //   249	1	1	localObject5	Object
    //   257	1	1	localIOException1	java.io.IOException
    //   261	13	1	localObject6	Object
    //   62	181	2	localObject7	Object
    //   253	1	2	localException2	Exception
    //   259	4	2	localObject8	Object
    //   267	1	2	localIOException2	java.io.IOException
    //   269	4	2	localContext1	Context
    //   1	207	3	localObject9	Object
    //   235	4	3	localObject10	Object
    //   241	1	3	localContext2	Context
    //   77	61	4	i	int
    //   7	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   104	108	117	java/io/IOException
    //   112	116	117	java/io/IOException
    //   4	9	142	java/io/IOException
    //   39	50	142	java/io/IOException
    //   153	157	166	java/io/IOException
    //   161	165	166	java/io/IOException
    //   4	9	168	java/lang/Exception
    //   39	50	168	java/lang/Exception
    //   185	189	198	java/io/IOException
    //   193	197	198	java/io/IOException
    //   4	9	200	finally
    //   39	50	200	finally
    //   207	211	221	java/io/IOException
    //   215	219	221	java/io/IOException
    //   50	59	225	finally
    //   63	76	229	finally
    //   83	92	229	finally
    //   96	100	229	finally
    //   123	133	229	finally
    //   177	181	229	finally
    //   145	149	235	finally
    //   50	59	247	java/lang/Exception
    //   63	76	253	java/lang/Exception
    //   83	92	253	java/lang/Exception
    //   96	100	253	java/lang/Exception
    //   123	133	253	java/lang/Exception
    //   50	59	257	java/io/IOException
    //   63	76	267	java/io/IOException
    //   83	92	267	java/io/IOException
    //   96	100	267	java/io/IOException
    //   123	133	267	java/io/IOException
    //   18	26	277	java/io/IOException
    //   30	38	277	java/io/IOException
  }
  
  private char[] subCharRangeArray(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    char[] arrayOfChar = new char[paramInt2 - paramInt1 + 1];
    int j = 0;
    int i = paramInt1;
    paramInt1 = j;
    for (;;)
    {
      if (i > paramInt2) {
        return arrayOfChar;
      }
      arrayOfChar[paramInt1] = paramArrayOfChar[i];
      i += 1;
      paramInt1 += 1;
    }
  }
  
  private String[] subStringRangeArray(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    String[] arrayOfString = new String[paramInt2 - paramInt1 + 1];
    int j = 0;
    int i = paramInt1;
    paramInt1 = j;
    for (;;)
    {
      if (i > paramInt2) {
        return arrayOfString;
      }
      arrayOfString[paramInt1] = paramArrayOfString[i];
      i += 1;
      paramInt1 += 1;
    }
  }
  
  public int distinguish(char[] paramArrayOfChar1, int paramInt1, char[] paramArrayOfChar2, String[] paramArrayOfString, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 0) && ((paramArrayOfChar1[0] == paramArrayOfChar2[0]) || (paramArrayOfChar1[0] == paramArrayOfString[0].charAt(0)))) {
      if (paramArrayOfChar1.length != 1) {
        paramInt1 = distinguish(paramArrayOfChar1, 1, paramArrayOfChar2, paramArrayOfString, 0, 1);
      }
    }
    do
    {
      return paramInt1;
      return 0;
      if ((paramArrayOfString[paramInt2].length() <= paramInt3) || (paramInt1 >= paramArrayOfChar1.length) || ((paramArrayOfChar1[paramInt1] != paramArrayOfChar2[paramInt2]) && (paramArrayOfChar1[paramInt1] != paramArrayOfString[paramInt2].charAt(paramInt3)))) {
        break label138;
      }
      if (paramInt1 != paramArrayOfChar1.length - 1) {
        break;
      }
      paramInt1 = paramInt2;
    } while (distinguish(paramArrayOfChar1, paramArrayOfChar2, paramArrayOfString, paramInt2));
    return -1;
    return distinguish(paramArrayOfChar1, paramInt1 + 1, paramArrayOfChar2, paramArrayOfString, paramInt2, paramInt3 + 1);
    label138:
    if ((paramArrayOfString.length > paramInt2 + 1) && (paramInt1 < paramArrayOfChar1.length) && ((paramArrayOfChar1[paramInt1] == paramArrayOfChar2[(paramInt2 + 1)]) || (paramArrayOfChar1[paramInt1] == paramArrayOfString[(paramInt2 + 1)].charAt(0))))
    {
      if (paramInt1 == paramArrayOfChar1.length - 1)
      {
        if (distinguish(paramArrayOfChar1, paramArrayOfChar2, paramArrayOfString, paramInt2)) {
          return paramInt2 + 1;
        }
        return -1;
      }
      return distinguish(paramArrayOfChar1, paramInt1 + 1, paramArrayOfChar2, paramArrayOfString, paramInt2 + 1, 1);
    }
    if (paramArrayOfString.length > paramInt2 + 1) {
      paramInt3 = 1;
    }
    for (;;)
    {
      if (paramInt3 >= paramInt1) {
        return -1;
      }
      if (distinguish(paramArrayOfChar1, paramInt1 - paramInt3, paramArrayOfChar2, paramArrayOfString, paramInt2 + 1, 0) != -1) {
        return paramInt2 + 1;
      }
      paramInt3 += 1;
    }
  }
  
  public MatchedResult getMatchedResult(String paramString1, String paramString2)
  {
    MatchedResult localMatchedResult = new MatchedResult();
    localMatchedResult.start = -1;
    localMatchedResult.end = -1;
    if (!isLoad) {
      return localMatchedResult;
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return localMatchedResult;
    }
    paramString1 = paramString1.toUpperCase();
    paramString2 = paramString2.toUpperCase();
    if (Math.min(paramString1.length(), paramString2.length()) > 10)
    {
      paramString1 = paramString1.substring(0, 10);
      paramString2 = paramString2.substring(0, 10);
    }
    for (;;)
    {
      int i = paramString1.indexOf(paramString2);
      if (i >= 0)
      {
        localMatchedResult.start = i;
        localMatchedResult.end = (i + paramString2.length() - 1);
      }
      char[] arrayOfChar = new char[paramString2.length()];
      i = 0;
      String[] arrayOfString;
      int j;
      if (i >= paramString2.length())
      {
        paramString2 = new char[paramString1.length()];
        arrayOfString = new String[paramString1.length()];
        j = paramString1.length();
        i = 0;
        if (i < j) {
          break label214;
        }
        j = arrayOfChar[0];
        i = 0;
      }
      for (;;)
      {
        if (i >= arrayOfString.length)
        {
          return localMatchedResult;
          arrayOfChar[i] = paramString2.charAt(i);
          i += 1;
          break;
          label214:
          char c = paramString1.charAt(i);
          paramString2[i] = c;
          String str = getPinyin(c);
          if (!TextUtils.isEmpty(str)) {
            arrayOfString[i] = str.toUpperCase();
          }
          for (;;)
          {
            i += 1;
            break;
            arrayOfString[i] = c;
          }
        }
        int k = arrayOfString[i].charAt(0);
        int m = paramString2[i];
        if ((k == j) || (m == j))
        {
          k = distinguish(arrayOfChar, 0, subCharRangeArray(paramString2, i, paramString2.length - 1), subStringRangeArray(arrayOfString, i, arrayOfString.length - 1), 0, 0);
          if (k != -1)
          {
            localMatchedResult.start = i;
            localMatchedResult.end = (k + i);
            return localMatchedResult;
          }
        }
        i += 1;
      }
    }
  }
  
  public String getPinyin(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (!isLoad) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return localStringBuilder.toString();
      }
      localStringBuilder.append(getPinyin(paramString.charAt(i)));
      i += 1;
    }
  }
  
  public static class MatchedResult
  {
    public int end = -1;
    public int start = -1;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\register\mobile\PinyinUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */