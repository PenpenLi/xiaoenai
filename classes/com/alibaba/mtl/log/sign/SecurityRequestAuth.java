package com.alibaba.mtl.log.sign;

import com.alibaba.mtl.log.e.i;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class SecurityRequestAuth
  implements IRequestAuth
{
  private boolean D = false;
  private Class jdField_a_of_type_JavaLangClass = null;
  private Field jdField_a_of_type_JavaLangReflectField = null;
  private Method jdField_a_of_type_JavaLangReflectMethod = null;
  private String aa;
  private Object jdField_b_of_type_JavaLangObject = null;
  private String jdField_b_of_type_JavaLangString = null;
  private Field jdField_b_of_type_JavaLangReflectField = null;
  private Object jdField_c_of_type_JavaLangObject = null;
  private Field jdField_c_of_type_JavaLangReflectField = null;
  private int z = 1;
  
  public SecurityRequestAuth(String paramString1, String paramString2)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.aa = paramString2;
  }
  
  /* Error */
  private void D()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 44	com/alibaba/mtl/log/sign/SecurityRequestAuth:D	Z
    //   8: istore 5
    //   10: iload 5
    //   12: ifeq +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: ldc 51
    //   20: invokestatic 57	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   23: astore_1
    //   24: aload_0
    //   25: aload_1
    //   26: ldc 59
    //   28: iconst_1
    //   29: anewarray 53	java/lang/Class
    //   32: dup
    //   33: iconst_0
    //   34: ldc 61
    //   36: aastore
    //   37: invokevirtual 65	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   40: aconst_null
    //   41: iconst_1
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: invokestatic 71	com/alibaba/mtl/log/a:getContext	()Landroid/content/Context;
    //   50: aastore
    //   51: invokevirtual 77	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   54: putfield 28	com/alibaba/mtl/log/sign/SecurityRequestAuth:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   57: aload_0
    //   58: aload_1
    //   59: ldc 79
    //   61: iconst_0
    //   62: anewarray 53	java/lang/Class
    //   65: invokevirtual 65	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   68: aload_0
    //   69: getfield 28	com/alibaba/mtl/log/sign/SecurityRequestAuth:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   72: iconst_0
    //   73: anewarray 4	java/lang/Object
    //   76: invokevirtual 77	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   79: putfield 30	com/alibaba/mtl/log/sign/SecurityRequestAuth:jdField_c_of_type_JavaLangObject	Ljava/lang/Object;
    //   82: aload_1
    //   83: ifnull +125 -> 208
    //   86: aload_0
    //   87: ldc 81
    //   89: invokestatic 57	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   92: putfield 32	com/alibaba/mtl/log/sign/SecurityRequestAuth:jdField_a_of_type_JavaLangClass	Ljava/lang/Class;
    //   95: aload_0
    //   96: aload_0
    //   97: getfield 32	com/alibaba/mtl/log/sign/SecurityRequestAuth:jdField_a_of_type_JavaLangClass	Ljava/lang/Class;
    //   100: ldc 83
    //   102: invokevirtual 87	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   105: putfield 34	com/alibaba/mtl/log/sign/SecurityRequestAuth:jdField_a_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   108: aload_0
    //   109: aload_0
    //   110: getfield 32	com/alibaba/mtl/log/sign/SecurityRequestAuth:jdField_a_of_type_JavaLangClass	Ljava/lang/Class;
    //   113: ldc 89
    //   115: invokevirtual 87	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   118: putfield 36	com/alibaba/mtl/log/sign/SecurityRequestAuth:jdField_b_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   121: aload_0
    //   122: aload_0
    //   123: getfield 32	com/alibaba/mtl/log/sign/SecurityRequestAuth:jdField_a_of_type_JavaLangClass	Ljava/lang/Class;
    //   126: ldc 91
    //   128: invokevirtual 87	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   131: putfield 38	com/alibaba/mtl/log/sign/SecurityRequestAuth:jdField_c_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   134: aload_1
    //   135: ldc 93
    //   137: iconst_0
    //   138: anewarray 53	java/lang/Class
    //   141: invokevirtual 65	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   144: astore_1
    //   145: aload_1
    //   146: ifnull +103 -> 249
    //   149: aload_1
    //   150: aload_0
    //   151: getfield 28	com/alibaba/mtl/log/sign/SecurityRequestAuth:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   154: iconst_0
    //   155: anewarray 4	java/lang/Object
    //   158: invokevirtual 77	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   161: checkcast 95	java/lang/Boolean
    //   164: invokevirtual 99	java/lang/Boolean:booleanValue	()Z
    //   167: istore 5
    //   169: goto +136 -> 305
    //   172: aload_0
    //   173: iload 4
    //   175: putfield 42	com/alibaba/mtl/log/sign/SecurityRequestAuth:z	I
    //   178: aload_0
    //   179: ldc 101
    //   181: invokestatic 57	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   184: ldc 103
    //   186: iconst_2
    //   187: anewarray 53	java/lang/Class
    //   190: dup
    //   191: iconst_0
    //   192: aload_0
    //   193: getfield 32	com/alibaba/mtl/log/sign/SecurityRequestAuth:jdField_a_of_type_JavaLangClass	Ljava/lang/Class;
    //   196: aastore
    //   197: dup
    //   198: iconst_1
    //   199: ldc 105
    //   201: aastore
    //   202: invokevirtual 65	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   205: putfield 40	com/alibaba/mtl/log/sign/SecurityRequestAuth:jdField_a_of_type_JavaLangReflectMethod	Ljava/lang/reflect/Method;
    //   208: aload_0
    //   209: iconst_1
    //   210: putfield 44	com/alibaba/mtl/log/sign/SecurityRequestAuth:D	Z
    //   213: goto -198 -> 15
    //   216: astore_1
    //   217: aload_0
    //   218: monitorexit
    //   219: aload_1
    //   220: athrow
    //   221: astore_2
    //   222: aconst_null
    //   223: astore_1
    //   224: ldc 107
    //   226: ldc 109
    //   228: aload_2
    //   229: invokestatic 114	com/alibaba/mtl/log/e/i:a	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   232: goto -150 -> 82
    //   235: astore_1
    //   236: ldc 107
    //   238: ldc 109
    //   240: aload_1
    //   241: invokestatic 114	com/alibaba/mtl/log/e/i:a	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   244: aconst_null
    //   245: astore_1
    //   246: goto -101 -> 145
    //   249: ldc 116
    //   251: invokestatic 57	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   254: astore_1
    //   255: aload_1
    //   256: ifnonnull +46 -> 302
    //   259: iconst_1
    //   260: istore 5
    //   262: goto +43 -> 305
    //   265: astore_1
    //   266: ldc 107
    //   268: ldc 109
    //   270: aload_1
    //   271: invokestatic 114	com/alibaba/mtl/log/e/i:a	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   274: aload_3
    //   275: astore_1
    //   276: goto -21 -> 255
    //   279: astore_1
    //   280: ldc 107
    //   282: ldc 109
    //   284: aload_1
    //   285: invokestatic 114	com/alibaba/mtl/log/e/i:a	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   288: goto -80 -> 208
    //   291: bipush 12
    //   293: istore 4
    //   295: goto -123 -> 172
    //   298: astore_2
    //   299: goto -75 -> 224
    //   302: iconst_0
    //   303: istore 5
    //   305: iload 5
    //   307: ifeq -16 -> 291
    //   310: iconst_1
    //   311: istore 4
    //   313: goto -141 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	this	SecurityRequestAuth
    //   23	127	1	localObject1	Object
    //   216	4	1	localObject2	Object
    //   223	1	1	localObject3	Object
    //   235	6	1	localThrowable1	Throwable
    //   245	11	1	localClass	Class
    //   265	6	1	localThrowable2	Throwable
    //   275	1	1	localObject4	Object
    //   279	6	1	localThrowable3	Throwable
    //   221	8	2	localThrowable4	Throwable
    //   298	1	2	localThrowable5	Throwable
    //   1	274	3	localObject5	Object
    //   173	139	4	i	int
    //   8	298	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	10	216	finally
    //   18	24	216	finally
    //   24	82	216	finally
    //   86	134	216	finally
    //   134	145	216	finally
    //   149	169	216	finally
    //   172	208	216	finally
    //   208	213	216	finally
    //   224	232	216	finally
    //   236	244	216	finally
    //   249	255	216	finally
    //   266	274	216	finally
    //   280	288	216	finally
    //   18	24	221	java/lang/Throwable
    //   134	145	235	java/lang/Throwable
    //   249	255	265	java/lang/Throwable
    //   86	134	279	java/lang/Throwable
    //   149	169	279	java/lang/Throwable
    //   172	208	279	java/lang/Throwable
    //   236	244	279	java/lang/Throwable
    //   266	274	279	java/lang/Throwable
    //   24	82	298	java/lang/Throwable
  }
  
  public String getAppkey()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String getSign(String paramString)
  {
    if (!this.D) {
      D();
    }
    if (this.jdField_b_of_type_JavaLangString == null) {
      i.a("SecurityRequestAuth", new Object[] { "There is no appkey,please check it!" });
    }
    while (paramString == null) {
      return null;
    }
    if ((this.jdField_b_of_type_JavaLangObject != null) && (this.jdField_a_of_type_JavaLangClass != null) && (this.jdField_a_of_type_JavaLangReflectField != null) && (this.jdField_b_of_type_JavaLangReflectField != null) && (this.jdField_c_of_type_JavaLangReflectField != null) && (this.jdField_a_of_type_JavaLangReflectMethod != null) && (this.jdField_c_of_type_JavaLangObject != null)) {}
    for (;;)
    {
      try
      {
        Object localObject = this.jdField_a_of_type_JavaLangClass.newInstance();
        this.jdField_a_of_type_JavaLangReflectField.set(localObject, this.jdField_b_of_type_JavaLangString);
        ((Map)this.jdField_b_of_type_JavaLangReflectField.get(localObject)).put("INPUT", paramString);
        this.jdField_c_of_type_JavaLangReflectField.set(localObject, Integer.valueOf(this.z));
        paramString = (String)this.jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_c_of_type_JavaLangObject, new Object[] { localObject, this.aa });
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      paramString = null;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\sign\SecurityRequestAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */