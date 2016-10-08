package com.meiqia.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import com.meiqia.core.b.c;
import com.meiqia.core.b.j;
import com.meiqia.core.c.e;
import java.util.concurrent.atomic.AtomicInteger;

class ab
{
  private aa a;
  private j b;
  private AtomicInteger c = new AtomicInteger();
  private SQLiteDatabase d;
  
  public ab(Context paramContext)
  {
    this.a = new aa(paramContext);
    this.b = new j(paramContext);
  }
  
  private e a(Cursor paramCursor)
  {
    boolean bool2 = true;
    e locale = new e();
    locale.d(paramCursor.getLong(paramCursor.getColumnIndex("id")));
    locale.a(paramCursor.getString(paramCursor.getColumnIndex("agent_id")));
    locale.b(paramCursor.getString(paramCursor.getColumnIndex("content")));
    locale.c(paramCursor.getString(paramCursor.getColumnIndex("content_type")));
    locale.e(paramCursor.getString(paramCursor.getColumnIndex("track_id")));
    locale.h(paramCursor.getString(paramCursor.getColumnIndex("agent_nickname")));
    locale.a(paramCursor.getInt(paramCursor.getColumnIndex("conversation_id")));
    locale.b(paramCursor.getLong(paramCursor.getColumnIndex("created_on")));
    locale.c(paramCursor.getInt(paramCursor.getColumnIndex("enterprise_id")));
    locale.d(paramCursor.getString(paramCursor.getColumnIndex("from_type")));
    locale.g(paramCursor.getString(paramCursor.getColumnIndex("status")));
    locale.f(paramCursor.getString(paramCursor.getColumnIndex("type")));
    locale.i(paramCursor.getString(paramCursor.getColumnIndex("avatar")));
    locale.j(paramCursor.getString(paramCursor.getColumnIndex("media_url")));
    locale.k(paramCursor.getString(paramCursor.getColumnIndex("extra")));
    c.a(locale);
    if (paramCursor.getInt(paramCursor.getColumnIndex("is_already_feedback")) != 0)
    {
      bool1 = true;
      locale.b(bool1);
      if (paramCursor.getInt(paramCursor.getColumnIndex("isRead")) == 0) {
        break label343;
      }
    }
    label343:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locale.a(bool1);
      return locale;
      bool1 = false;
      break;
    }
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, e parame)
  {
    ContentValues localContentValues = new ContentValues();
    a(parame, localContentValues);
    paramSQLiteDatabase.insert("mq_message", null, localContentValues);
  }
  
  private void a(e parame, ContentValues paramContentValues)
  {
    paramContentValues.put("id", Long.valueOf(parame.h()));
    paramContentValues.put("agent_id", parame.a());
    paramContentValues.put("content", parame.b());
    paramContentValues.put("content_type", parame.c());
    paramContentValues.put("conversation_id", Long.valueOf(parame.d()));
    paramContentValues.put("created_on", Long.valueOf(parame.e()));
    paramContentValues.put("enterprise_id", Long.valueOf(parame.f()));
    paramContentValues.put("from_type", parame.g());
    paramContentValues.put("track_id", parame.i());
    paramContentValues.put("type", parame.j());
    paramContentValues.put("avatar", parame.m());
    paramContentValues.put("isRead", Boolean.valueOf(parame.n()));
    paramContentValues.put("status", parame.k());
    paramContentValues.put("agent_nickname", parame.l());
    paramContentValues.put("media_url", parame.o());
    paramContentValues.put("extra", parame.p());
    if (parame.r()) {
      paramContentValues.put("is_already_feedback", Boolean.valueOf(parame.r()));
    }
  }
  
  private SQLiteDatabase b()
  {
    try
    {
      if (this.c.incrementAndGet() == 1) {
        this.d = this.a.getWritableDatabase();
      }
      SQLiteDatabase localSQLiteDatabase = this.d;
      return localSQLiteDatabase;
    }
    finally {}
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase, e parame)
  {
    if (d(paramSQLiteDatabase, parame))
    {
      c(paramSQLiteDatabase, parame);
      return;
    }
    a(paramSQLiteDatabase, parame);
  }
  
  private void c()
  {
    try
    {
      if ((this.c.decrementAndGet() == 0) && (this.d.isOpen())) {
        this.d.close();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void c(SQLiteDatabase paramSQLiteDatabase, e parame)
  {
    try
    {
      String str = parame.h() + "";
      ContentValues localContentValues = new ContentValues();
      a(parame, localContentValues);
      paramSQLiteDatabase.update("mq_message", localContentValues, "id=?", new String[] { str });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      Log.d("meiqia", "updateMessage(SQLiteDatabase db, MQMessage message) error");
    }
  }
  
  private boolean c(e parame)
  {
    return (TextUtils.equals("reply", parame.q())) || (TextUtils.equals("redirect", parame.q()));
  }
  
  /* Error */
  private boolean d(SQLiteDatabase paramSQLiteDatabase, e parame)
  {
    // Byte code:
    //   0: ldc_w 294
    //   3: aload_2
    //   4: invokevirtual 189	com/meiqia/core/c/e:j	()Ljava/lang/String;
    //   7: invokevirtual 297	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifeq +136 -> 146
    //   13: aload_2
    //   14: invokevirtual 215	com/meiqia/core/c/e:p	()Ljava/lang/String;
    //   17: invokestatic 301	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifne +126 -> 146
    //   23: aload_2
    //   24: invokevirtual 215	com/meiqia/core/c/e:p	()Ljava/lang/String;
    //   27: invokestatic 304	android/text/TextUtils:isDigitsOnly	(Ljava/lang/CharSequence;)Z
    //   30: ifeq +116 -> 146
    //   33: aload_2
    //   34: invokevirtual 215	com/meiqia/core/c/e:p	()Ljava/lang/String;
    //   37: astore_2
    //   38: new 248	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   45: ldc_w 306
    //   48: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_0
    //   52: invokevirtual 307	com/meiqia/core/ab:a	()Ljava/lang/String;
    //   55: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc_w 309
    //   61: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc 122
    //   66: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc_w 311
    //   72: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore_3
    //   79: aload_1
    //   80: aload_3
    //   81: iconst_1
    //   82: anewarray 265	java/lang/String
    //   85: dup
    //   86: iconst_0
    //   87: new 248	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   94: aload_2
    //   95: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc -1
    //   100: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: aastore
    //   107: invokevirtual 315	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   110: astore_2
    //   111: aload_2
    //   112: ifnull +101 -> 213
    //   115: aload_2
    //   116: astore_1
    //   117: aload_2
    //   118: invokeinterface 318 1 0
    //   123: istore 4
    //   125: iload 4
    //   127: ifeq +86 -> 213
    //   130: iconst_1
    //   131: istore 4
    //   133: aload_2
    //   134: ifnull +9 -> 143
    //   137: aload_2
    //   138: invokeinterface 319 1 0
    //   143: iload 4
    //   145: ireturn
    //   146: new 248	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   153: aload_2
    //   154: invokevirtual 157	com/meiqia/core/c/e:h	()J
    //   157: invokevirtual 253	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   160: ldc -1
    //   162: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: astore_2
    //   169: new 248	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 306
    //   179: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_0
    //   183: invokevirtual 307	com/meiqia/core/ab:a	()Ljava/lang/String;
    //   186: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: ldc_w 309
    //   192: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: ldc 40
    //   197: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc_w 311
    //   203: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: astore_3
    //   210: goto -131 -> 79
    //   213: iconst_0
    //   214: istore 4
    //   216: goto -83 -> 133
    //   219: astore_3
    //   220: aconst_null
    //   221: astore_2
    //   222: aload_2
    //   223: astore_1
    //   224: new 248	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   231: ldc_w 321
    //   234: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_3
    //   238: invokevirtual 322	java/lang/Exception:toString	()Ljava/lang/String;
    //   241: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 325	com/meiqia/core/b/g:a	(Ljava/lang/String;)V
    //   250: aload_2
    //   251: ifnull +34 -> 285
    //   254: aload_2
    //   255: invokeinterface 319 1 0
    //   260: iconst_0
    //   261: ireturn
    //   262: astore_2
    //   263: aconst_null
    //   264: astore_1
    //   265: aload_1
    //   266: ifnull +9 -> 275
    //   269: aload_1
    //   270: invokeinterface 319 1 0
    //   275: aload_2
    //   276: athrow
    //   277: astore_2
    //   278: goto -13 -> 265
    //   281: astore_3
    //   282: goto -60 -> 222
    //   285: iconst_0
    //   286: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	ab
    //   0	287	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	287	2	parame	e
    //   78	132	3	str	String
    //   219	19	3	localException1	Exception
    //   281	1	3	localException2	Exception
    //   123	92	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   79	111	219	java/lang/Exception
    //   79	111	262	finally
    //   117	125	277	finally
    //   224	250	277	finally
    //   117	125	281	java/lang/Exception
  }
  
  public String a()
  {
    return "mq_message";
  }
  
  public void a(long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = b();
    try
    {
      localSQLiteDatabase.delete("mq_message", "id=?", new String[] { paramLong + "" });
      return;
    }
    catch (Exception localException)
    {
      Log.d("meiqia", "deleteMessage error");
      return;
    }
    finally
    {
      c();
    }
  }
  
  /* Error */
  public void a(long paramLong, int paramInt, com.meiqia.core.d.k paramk)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: new 338	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 339	java/util/ArrayList:<init>	()V
    //   13: astore 8
    //   15: aload_0
    //   16: invokespecial 327	com/meiqia/core/ab:b	()Landroid/database/sqlite/SQLiteDatabase;
    //   19: astore 7
    //   21: getstatic 344	com/meiqia/core/ah:a	Lcom/meiqia/core/c/b;
    //   24: invokevirtual 347	com/meiqia/core/c/b:b	()Ljava/lang/String;
    //   27: astore 9
    //   29: new 248	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 349
    //   39: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: invokevirtual 307	com/meiqia/core/ab:a	()Ljava/lang/String;
    //   46: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc_w 351
    //   52: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc 90
    //   57: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc_w 353
    //   63: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: lload_1
    //   67: invokevirtual 253	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   70: ldc_w 355
    //   73: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc 72
    //   78: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc_w 357
    //   84: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload 9
    //   89: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc_w 359
    //   95: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc 90
    //   100: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc_w 361
    //   106: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc_w 363
    //   112: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: iload_3
    //   116: invokevirtual 366	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   119: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: astore 9
    //   124: aload 7
    //   126: aload 9
    //   128: aconst_null
    //   129: invokevirtual 315	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   132: astore 7
    //   134: aload 7
    //   136: astore 5
    //   138: aload 7
    //   140: astore 6
    //   142: aload 7
    //   144: invokeinterface 369 1 0
    //   149: ifeq +184 -> 333
    //   152: aload 7
    //   154: astore 5
    //   156: aload 7
    //   158: astore 6
    //   160: aload_0
    //   161: aload 7
    //   163: invokespecial 371	com/meiqia/core/ab:a	(Landroid/database/Cursor;)Lcom/meiqia/core/c/e;
    //   166: astore 9
    //   168: aload 7
    //   170: astore 5
    //   172: aload 7
    //   174: astore 6
    //   176: ldc_w 373
    //   179: aload 9
    //   181: invokevirtual 206	com/meiqia/core/c/e:k	()Ljava/lang/String;
    //   184: invokevirtual 297	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   187: ifeq +19 -> 206
    //   190: aload 7
    //   192: astore 5
    //   194: aload 7
    //   196: astore 6
    //   198: aload 9
    //   200: ldc_w 375
    //   203: invokevirtual 105	com/meiqia/core/c/e:g	(Ljava/lang/String;)V
    //   206: aload 7
    //   208: astore 5
    //   210: aload 7
    //   212: astore 6
    //   214: ldc_w 377
    //   217: aload 9
    //   219: invokevirtual 185	com/meiqia/core/c/e:g	()Ljava/lang/String;
    //   222: invokestatic 290	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   225: ifeq +23 -> 248
    //   228: aload 7
    //   230: astore 5
    //   232: aload 7
    //   234: astore 6
    //   236: aload 9
    //   238: aload_0
    //   239: getfield 33	com/meiqia/core/ab:b	Lcom/meiqia/core/b/j;
    //   242: invokevirtual 380	com/meiqia/core/b/j:s	()Ljava/lang/String;
    //   245: invokevirtual 115	com/meiqia/core/c/e:i	(Ljava/lang/String;)V
    //   248: aload 7
    //   250: astore 5
    //   252: aload 7
    //   254: astore 6
    //   256: aload 8
    //   258: aload 9
    //   260: invokeinterface 385 2 0
    //   265: pop
    //   266: goto -132 -> 134
    //   269: astore 7
    //   271: aload 5
    //   273: astore 6
    //   275: new 248	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   282: ldc_w 387
    //   285: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload 7
    //   290: invokevirtual 322	java/lang/Exception:toString	()Ljava/lang/String;
    //   293: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 325	com/meiqia/core/b/g:a	(Ljava/lang/String;)V
    //   302: aload 5
    //   304: astore 6
    //   306: aload 4
    //   308: iconst_0
    //   309: ldc -1
    //   311: invokeinterface 392 3 0
    //   316: aload 5
    //   318: ifnull +10 -> 328
    //   321: aload 5
    //   323: invokeinterface 319 1 0
    //   328: aload_0
    //   329: invokespecial 333	com/meiqia/core/ab:c	()V
    //   332: return
    //   333: aload 7
    //   335: astore 5
    //   337: aload 7
    //   339: astore 6
    //   341: aload 8
    //   343: new 394	com/meiqia/core/b/i
    //   346: dup
    //   347: invokespecial 395	com/meiqia/core/b/i:<init>	()V
    //   350: invokestatic 401	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   353: aload 7
    //   355: astore 5
    //   357: aload 7
    //   359: astore 6
    //   361: aload 4
    //   363: aload 8
    //   365: invokeinterface 404 2 0
    //   370: aload 7
    //   372: ifnull +10 -> 382
    //   375: aload 7
    //   377: invokeinterface 319 1 0
    //   382: aload_0
    //   383: invokespecial 333	com/meiqia/core/ab:c	()V
    //   386: return
    //   387: astore 4
    //   389: aload 6
    //   391: ifnull +10 -> 401
    //   394: aload 6
    //   396: invokeinterface 319 1 0
    //   401: aload_0
    //   402: invokespecial 333	com/meiqia/core/ab:c	()V
    //   405: aload 4
    //   407: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	408	0	this	ab
    //   0	408	1	paramLong	long
    //   0	408	3	paramInt	int
    //   0	408	4	paramk	com.meiqia.core.d.k
    //   4	352	5	localObject1	Object
    //   1	394	6	localObject2	Object
    //   19	234	7	localObject3	Object
    //   269	107	7	localException	Exception
    //   13	351	8	localArrayList	java.util.ArrayList
    //   27	232	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   124	134	269	java/lang/Exception
    //   142	152	269	java/lang/Exception
    //   160	168	269	java/lang/Exception
    //   176	190	269	java/lang/Exception
    //   198	206	269	java/lang/Exception
    //   214	228	269	java/lang/Exception
    //   236	248	269	java/lang/Exception
    //   256	266	269	java/lang/Exception
    //   341	353	269	java/lang/Exception
    //   361	370	269	java/lang/Exception
    //   124	134	387	finally
    //   142	152	387	finally
    //   160	168	387	finally
    //   176	190	387	finally
    //   198	206	387	finally
    //   214	228	387	finally
    //   236	248	387	finally
    //   256	266	387	finally
    //   275	302	387	finally
    //   306	316	387	finally
    //   341	353	387	finally
    //   361	370	387	finally
  }
  
  public void a(e parame)
  {
    if (c(parame)) {
      return;
    }
    SQLiteDatabase localSQLiteDatabase = b();
    try
    {
      b(localSQLiteDatabase, parame);
      return;
    }
    catch (Exception parame)
    {
      Log.d("meiqia", "updateOrSaveMessage(MQMessage message) error");
      return;
    }
    finally
    {
      c();
    }
  }
  
  public void a(e parame, long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = b();
    try
    {
      String str = paramLong + "";
      ContentValues localContentValues = new ContentValues();
      a(parame, localContentValues);
      localSQLiteDatabase.update("mq_message", localContentValues, "id=?", new String[] { str });
      return;
    }
    catch (Exception parame)
    {
      Log.d("meiqia", "updateMessageId error");
      return;
    }
    finally
    {
      c();
    }
  }
  
  /* Error */
  public void a(java.util.List<e> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 327	com/meiqia/core/ab:b	()Landroid/database/sqlite/SQLiteDatabase;
    //   4: astore_2
    //   5: aload_2
    //   6: invokevirtual 416	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   9: aload_1
    //   10: invokeinterface 420 1 0
    //   15: astore_1
    //   16: aload_1
    //   17: invokeinterface 425 1 0
    //   22: ifeq +59 -> 81
    //   25: aload_1
    //   26: invokeinterface 429 1 0
    //   31: checkcast 37	com/meiqia/core/c/e
    //   34: astore_3
    //   35: aload_0
    //   36: aload_3
    //   37: invokespecial 406	com/meiqia/core/ab:c	(Lcom/meiqia/core/c/e;)Z
    //   40: ifne -24 -> 16
    //   43: aload_0
    //   44: aload_2
    //   45: aload_3
    //   46: invokespecial 231	com/meiqia/core/ab:d	(Landroid/database/sqlite/SQLiteDatabase;Lcom/meiqia/core/c/e;)Z
    //   49: ifne -33 -> 16
    //   52: aload_0
    //   53: aload_2
    //   54: aload_3
    //   55: invokespecial 235	com/meiqia/core/ab:a	(Landroid/database/sqlite/SQLiteDatabase;Lcom/meiqia/core/c/e;)V
    //   58: goto -42 -> 16
    //   61: astore_1
    //   62: ldc_w 271
    //   65: ldc_w 431
    //   68: invokestatic 278	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   71: pop
    //   72: aload_2
    //   73: invokevirtual 434	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   76: aload_0
    //   77: invokespecial 333	com/meiqia/core/ab:c	()V
    //   80: return
    //   81: aload_2
    //   82: invokevirtual 437	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   85: aload_2
    //   86: invokevirtual 434	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   89: aload_0
    //   90: invokespecial 333	com/meiqia/core/ab:c	()V
    //   93: return
    //   94: astore_1
    //   95: aload_2
    //   96: invokevirtual 434	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   99: aload_0
    //   100: invokespecial 333	com/meiqia/core/ab:c	()V
    //   103: aload_1
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	ab
    //   0	105	1	paramList	java.util.List<e>
    //   4	92	2	localSQLiteDatabase	SQLiteDatabase
    //   34	21	3	locale	e
    // Exception table:
    //   from	to	target	type
    //   9	16	61	java/lang/Exception
    //   16	58	61	java/lang/Exception
    //   81	85	61	java/lang/Exception
    //   9	16	94	finally
    //   16	58	94	finally
    //   62	72	94	finally
    //   81	85	94	finally
  }
  
  /* Error */
  public void b(java.util.List<e> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 327	com/meiqia/core/ab:b	()Landroid/database/sqlite/SQLiteDatabase;
    //   4: astore_2
    //   5: aload_2
    //   6: invokevirtual 416	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   9: aload_1
    //   10: invokeinterface 420 1 0
    //   15: astore_1
    //   16: aload_1
    //   17: invokeinterface 425 1 0
    //   22: ifeq +40 -> 62
    //   25: aload_0
    //   26: aload_2
    //   27: aload_1
    //   28: invokeinterface 429 1 0
    //   33: checkcast 37	com/meiqia/core/c/e
    //   36: invokespecial 408	com/meiqia/core/ab:b	(Landroid/database/sqlite/SQLiteDatabase;Lcom/meiqia/core/c/e;)V
    //   39: goto -23 -> 16
    //   42: astore_1
    //   43: ldc_w 271
    //   46: ldc_w 431
    //   49: invokestatic 278	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   52: pop
    //   53: aload_2
    //   54: invokevirtual 434	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   57: aload_0
    //   58: invokespecial 333	com/meiqia/core/ab:c	()V
    //   61: return
    //   62: aload_2
    //   63: invokevirtual 437	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   66: aload_2
    //   67: invokevirtual 434	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   70: aload_0
    //   71: invokespecial 333	com/meiqia/core/ab:c	()V
    //   74: return
    //   75: astore_1
    //   76: aload_2
    //   77: invokevirtual 434	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   80: aload_0
    //   81: invokespecial 333	com/meiqia/core/ab:c	()V
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	ab
    //   0	86	1	paramList	java.util.List<e>
    //   4	73	2	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   9	16	42	java/lang/Exception
    //   16	39	42	java/lang/Exception
    //   62	66	42	java/lang/Exception
    //   9	16	75	finally
    //   16	39	75	finally
    //   43	53	75	finally
    //   62	66	75	finally
  }
  
  public boolean b(e parame)
  {
    return d(b(), parame);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */