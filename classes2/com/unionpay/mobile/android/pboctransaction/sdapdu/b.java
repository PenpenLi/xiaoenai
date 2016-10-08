package com.unionpay.mobile.android.pboctransaction.sdapdu;

import java.util.ArrayList;
import java.util.HashSet;

public final class b
{
  public static String[] a;
  public static int b = 0;
  private static ArrayList<String> c = new ArrayList();
  
  public static void a()
  {
    HashSet localHashSet = b();
    a = new String[localHashSet.size()];
    localHashSet.toArray(a);
  }
  
  /* Error */
  private static HashSet<String> b()
  {
    // Byte code:
    //   0: new 28	java/util/HashSet
    //   3: dup
    //   4: invokespecial 43	java/util/HashSet:<init>	()V
    //   7: astore_2
    //   8: new 45	java/lang/ProcessBuilder
    //   11: dup
    //   12: iconst_0
    //   13: anewarray 34	java/lang/String
    //   16: invokespecial 48	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   19: iconst_1
    //   20: anewarray 34	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: ldc 50
    //   27: aastore
    //   28: invokevirtual 54	java/lang/ProcessBuilder:command	([Ljava/lang/String;)Ljava/lang/ProcessBuilder;
    //   31: iconst_1
    //   32: invokevirtual 58	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   35: invokevirtual 62	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   38: astore_0
    //   39: aload_0
    //   40: invokevirtual 67	java/lang/Process:waitFor	()I
    //   43: pop
    //   44: aload_0
    //   45: invokevirtual 71	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   48: astore_3
    //   49: sipush 1024
    //   52: newarray <illegal type>
    //   54: astore 4
    //   56: ldc 73
    //   58: astore_0
    //   59: aload_3
    //   60: aload 4
    //   62: invokevirtual 79	java/io/InputStream:read	([B)I
    //   65: iconst_m1
    //   66: if_icmpeq +35 -> 101
    //   69: new 81	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   76: aload_0
    //   77: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: new 34	java/lang/String
    //   83: dup
    //   84: aload 4
    //   86: invokespecial 89	java/lang/String:<init>	([B)V
    //   89: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: astore_1
    //   96: aload_1
    //   97: astore_0
    //   98: goto -39 -> 59
    //   101: aload_3
    //   102: invokevirtual 96	java/io/InputStream:close	()V
    //   105: aload_0
    //   106: ldc 98
    //   108: invokevirtual 102	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   111: astore_0
    //   112: aload_0
    //   113: arraylength
    //   114: istore 7
    //   116: iconst_0
    //   117: istore 5
    //   119: iload 5
    //   121: iload 7
    //   123: if_icmpge +117 -> 240
    //   126: aload_0
    //   127: iload 5
    //   129: aaload
    //   130: astore_1
    //   131: aload_1
    //   132: getstatic 108	java/util/Locale:US	Ljava/util/Locale;
    //   135: invokevirtual 112	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   138: ldc 114
    //   140: invokevirtual 118	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   143: ifne +88 -> 231
    //   146: aload_1
    //   147: ldc 120
    //   149: invokevirtual 124	java/lang/String:matches	(Ljava/lang/String;)Z
    //   152: ifeq +79 -> 231
    //   155: aload_1
    //   156: ldc 126
    //   158: invokevirtual 102	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   161: astore_1
    //   162: aload_1
    //   163: arraylength
    //   164: istore 8
    //   166: iconst_0
    //   167: istore 6
    //   169: iload 6
    //   171: iload 8
    //   173: if_icmpge +58 -> 231
    //   176: aload_1
    //   177: iload 6
    //   179: aaload
    //   180: astore_3
    //   181: aload_3
    //   182: ldc -128
    //   184: invokevirtual 131	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   187: ifeq +24 -> 211
    //   190: aload_3
    //   191: getstatic 108	java/util/Locale:US	Ljava/util/Locale;
    //   194: invokevirtual 112	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   197: ldc -123
    //   199: invokevirtual 118	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   202: ifne +9 -> 211
    //   205: aload_2
    //   206: aload_3
    //   207: invokevirtual 137	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   210: pop
    //   211: iload 6
    //   213: iconst_1
    //   214: iadd
    //   215: istore 6
    //   217: goto -48 -> 169
    //   220: astore_1
    //   221: ldc 73
    //   223: astore_0
    //   224: aload_1
    //   225: invokevirtual 140	java/lang/Exception:printStackTrace	()V
    //   228: goto -123 -> 105
    //   231: iload 5
    //   233: iconst_1
    //   234: iadd
    //   235: istore 5
    //   237: goto -118 -> 119
    //   240: aload_2
    //   241: areturn
    //   242: astore_1
    //   243: goto -19 -> 224
    // Local variable table:
    //   start	length	slot	name	signature
    //   38	186	0	localObject1	Object
    //   95	82	1	localObject2	Object
    //   220	5	1	localException1	Exception
    //   242	1	1	localException2	Exception
    //   7	234	2	localHashSet	HashSet
    //   48	159	3	localInputStream	java.io.InputStream
    //   54	31	4	arrayOfByte	byte[]
    //   117	119	5	i	int
    //   167	49	6	j	int
    //   114	10	7	k	int
    //   164	10	8	m	int
    // Exception table:
    //   from	to	target	type
    //   8	56	220	java/lang/Exception
    //   59	96	242	java/lang/Exception
    //   101	105	242	java/lang/Exception
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\pboctransaction\sdapdu\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */