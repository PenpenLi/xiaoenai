package a.a.a;

import a.a.a.d.i;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class a<T, K>
{
  protected final a.a.a.c.a config;
  protected final SQLiteDatabase db;
  protected a.a.a.b.a<K, T> identityScope;
  protected a.a.a.b.b<T> identityScopeLong;
  protected final int pkOrdinal;
  protected final c session;
  protected a.a.a.c.e statements;
  
  public a(a.a.a.c.a parama)
  {
    this(parama, null);
  }
  
  public a(a.a.a.c.a parama, c paramc)
  {
    this.config = parama;
    this.session = paramc;
    this.db = parama.a;
    this.identityScope = parama.b();
    if ((this.identityScope instanceof a.a.a.b.b)) {
      this.identityScopeLong = ((a.a.a.b.b)this.identityScope);
    }
    this.statements = parama.i;
    if (parama.g != null) {}
    for (int i = parama.g.a;; i = -1)
    {
      this.pkOrdinal = i;
      return;
    }
  }
  
  private void deleteByKeyInsideSynchronized(K paramK, SQLiteStatement paramSQLiteStatement)
  {
    if ((paramK instanceof Long)) {
      paramSQLiteStatement.bindLong(1, ((Long)paramK).longValue());
    }
    for (;;)
    {
      paramSQLiteStatement.execute();
      return;
      if (paramK == null) {
        throw new d("Cannot delete entity, key is null");
      }
      paramSQLiteStatement.bindString(1, paramK.toString());
    }
  }
  
  private void deleteInTxInternal(Iterable<T> paramIterable, Iterable<K> paramIterable1)
  {
    assertSinglePk();
    SQLiteStatement localSQLiteStatement = this.statements.c();
    ArrayList localArrayList = null;
    this.db.beginTransaction();
    try
    {
      try
      {
        if (this.identityScope != null)
        {
          this.identityScope.b();
          localArrayList = new ArrayList();
        }
        if (paramIterable != null)
        {
          try
          {
            paramIterable = paramIterable.iterator();
            while (paramIterable.hasNext())
            {
              Object localObject = getKeyVerified(paramIterable.next());
              deleteByKeyInsideSynchronized(localObject, localSQLiteStatement);
              if (localArrayList != null) {
                localArrayList.add(localObject);
              }
            }
            paramIterable = finally;
          }
          finally
          {
            if (this.identityScope != null) {
              this.identityScope.c();
            }
          }
          paramIterable = finally;
        }
      }
      finally {}
      if (paramIterable1 == null) {
        break label189;
      }
    }
    finally
    {
      this.db.endTransaction();
    }
    paramIterable = paramIterable1.iterator();
    while (paramIterable.hasNext())
    {
      paramIterable1 = paramIterable.next();
      deleteByKeyInsideSynchronized(paramIterable1, localSQLiteStatement);
      if (localArrayList != null) {
        localArrayList.add(paramIterable1);
      }
    }
    label189:
    if (this.identityScope != null) {
      this.identityScope.c();
    }
    this.db.setTransactionSuccessful();
    if ((localArrayList != null) && (this.identityScope != null)) {
      this.identityScope.a(localArrayList);
    }
    this.db.endTransaction();
  }
  
  /* Error */
  private long executeInsert(T paramT, SQLiteStatement paramSQLiteStatement)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	a/a/a/a:db	Landroid/database/sqlite/SQLiteDatabase;
    //   4: invokevirtual 168	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   7: ifeq +32 -> 39
    //   10: aload_2
    //   11: monitorenter
    //   12: aload_0
    //   13: aload_2
    //   14: aload_1
    //   15: invokevirtual 172	a/a/a/a:bindValues	(Landroid/database/sqlite/SQLiteStatement;Ljava/lang/Object;)V
    //   18: aload_2
    //   19: invokevirtual 174	android/database/sqlite/SQLiteStatement:executeInsert	()J
    //   22: lstore_3
    //   23: aload_2
    //   24: monitorexit
    //   25: aload_0
    //   26: aload_1
    //   27: lload_3
    //   28: iconst_1
    //   29: invokevirtual 178	a/a/a/a:updateKeyAfterInsertAndAttach	(Ljava/lang/Object;JZ)V
    //   32: lload_3
    //   33: lreturn
    //   34: astore_1
    //   35: aload_2
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    //   39: aload_0
    //   40: getfield 41	a/a/a/a:db	Landroid/database/sqlite/SQLiteDatabase;
    //   43: invokevirtual 116	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   46: aload_2
    //   47: monitorenter
    //   48: aload_0
    //   49: aload_2
    //   50: aload_1
    //   51: invokevirtual 172	a/a/a/a:bindValues	(Landroid/database/sqlite/SQLiteStatement;Ljava/lang/Object;)V
    //   54: aload_2
    //   55: invokevirtual 174	android/database/sqlite/SQLiteStatement:executeInsert	()J
    //   58: lstore_3
    //   59: aload_2
    //   60: monitorexit
    //   61: aload_0
    //   62: getfield 41	a/a/a/a:db	Landroid/database/sqlite/SQLiteDatabase;
    //   65: invokevirtual 159	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   68: aload_0
    //   69: getfield 41	a/a/a/a:db	Landroid/database/sqlite/SQLiteDatabase;
    //   72: invokevirtual 156	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   75: goto -50 -> 25
    //   78: astore_1
    //   79: aload_2
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    //   83: astore_1
    //   84: aload_0
    //   85: getfield 41	a/a/a/a:db	Landroid/database/sqlite/SQLiteDatabase;
    //   88: invokevirtual 156	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   91: aload_1
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	a
    //   0	93	1	paramT	T
    //   0	93	2	paramSQLiteStatement	SQLiteStatement
    //   22	37	3	l	long
    // Exception table:
    //   from	to	target	type
    //   12	25	34	finally
    //   35	37	34	finally
    //   48	61	78	finally
    //   79	81	78	finally
    //   46	48	83	finally
    //   61	68	83	finally
    //   81	83	83	finally
  }
  
  private void executeInsertInTx(SQLiteStatement paramSQLiteStatement, Iterable<T> paramIterable, boolean paramBoolean)
  {
    this.db.beginTransaction();
    label108:
    for (;;)
    {
      try
      {
        try
        {
          if (this.identityScope != null) {
            this.identityScope.b();
          }
          try
          {
            paramIterable = paramIterable.iterator();
            if (!paramIterable.hasNext()) {
              break;
            }
            Object localObject = paramIterable.next();
            bindValues(paramSQLiteStatement, localObject);
            if (!paramBoolean) {
              break label108;
            }
            updateKeyAfterInsertAndAttach(localObject, paramSQLiteStatement.executeInsert(), false);
            continue;
            paramIterable = finally;
          }
          finally
          {
            if (this.identityScope != null) {
              this.identityScope.c();
            }
          }
          paramSQLiteStatement = finally;
        }
        finally {}
        paramSQLiteStatement.execute();
      }
      finally
      {
        this.db.endTransaction();
      }
    }
    if (this.identityScope != null) {
      this.identityScope.c();
    }
    this.db.setTransactionSuccessful();
    this.db.endTransaction();
  }
  
  private void loadAllUnlockOnWindowBounds(Cursor paramCursor, CursorWindow paramCursorWindow, List<T> paramList)
  {
    int i = paramCursorWindow.getStartPosition() + paramCursorWindow.getNumRows();
    int j = 0;
    paramList.add(loadCurrent(paramCursor, 0, false));
    j += 1;
    if (j >= i)
    {
      paramCursorWindow = moveToNextUnlocked(paramCursor);
      if (paramCursorWindow == null) {
        return;
      }
      i = paramCursorWindow.getStartPosition();
      i = paramCursorWindow.getNumRows() + i;
    }
    while (paramCursor.moveToNext())
    {
      j += 1;
      break;
    }
  }
  
  private CursorWindow moveToNextUnlocked(Cursor paramCursor)
  {
    this.identityScope.c();
    try
    {
      if (paramCursor.moveToNext())
      {
        paramCursor = ((CrossProcessCursor)paramCursor).getWindow();
        return paramCursor;
      }
      return null;
    }
    finally
    {
      this.identityScope.b();
    }
  }
  
  protected void assertSinglePk()
  {
    if (this.config.e.length != 1) {
      throw new d(this + " (" + this.config.b + ") does not have a single-column primary key");
    }
  }
  
  protected void attachEntity(T paramT) {}
  
  protected final void attachEntity(K paramK, T paramT, boolean paramBoolean)
  {
    attachEntity(paramT);
    if ((this.identityScope != null) && (paramK != null))
    {
      if (paramBoolean) {
        this.identityScope.a(paramK, paramT);
      }
    }
    else {
      return;
    }
    this.identityScope.b(paramK, paramT);
  }
  
  protected abstract void bindValues(SQLiteStatement paramSQLiteStatement, T paramT);
  
  public long count()
  {
    return DatabaseUtils.queryNumEntries(this.db, '\'' + this.config.b + '\'');
  }
  
  public void delete(T paramT)
  {
    assertSinglePk();
    deleteByKey(getKeyVerified(paramT));
  }
  
  public void deleteAll()
  {
    this.db.execSQL("DELETE FROM '" + this.config.b + "'");
    if (this.identityScope != null) {
      this.identityScope.a();
    }
  }
  
  /* Error */
  public void deleteByKey(K paramK)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 105	a/a/a/a:assertSinglePk	()V
    //   4: aload_0
    //   5: getfield 56	a/a/a/a:statements	La/a/a/c/e;
    //   8: invokevirtual 111	a/a/a/c/e:c	()Landroid/database/sqlite/SQLiteStatement;
    //   11: astore_2
    //   12: aload_0
    //   13: getfield 41	a/a/a/a:db	Landroid/database/sqlite/SQLiteDatabase;
    //   16: invokevirtual 168	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   19: ifeq +36 -> 55
    //   22: aload_2
    //   23: monitorenter
    //   24: aload_0
    //   25: aload_1
    //   26: aload_2
    //   27: invokespecial 145	a/a/a/a:deleteByKeyInsideSynchronized	(Ljava/lang/Object;Landroid/database/sqlite/SQLiteStatement;)V
    //   30: aload_2
    //   31: monitorexit
    //   32: aload_0
    //   33: getfield 47	a/a/a/a:identityScope	La/a/a/b/a;
    //   36: ifnull +13 -> 49
    //   39: aload_0
    //   40: getfield 47	a/a/a/a:identityScope	La/a/a/b/a;
    //   43: aload_1
    //   44: invokeinterface 273 2 0
    //   49: return
    //   50: astore_1
    //   51: aload_2
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    //   55: aload_0
    //   56: getfield 41	a/a/a/a:db	Landroid/database/sqlite/SQLiteDatabase;
    //   59: invokevirtual 116	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   62: aload_2
    //   63: monitorenter
    //   64: aload_0
    //   65: aload_1
    //   66: aload_2
    //   67: invokespecial 145	a/a/a/a:deleteByKeyInsideSynchronized	(Ljava/lang/Object;Landroid/database/sqlite/SQLiteStatement;)V
    //   70: aload_2
    //   71: monitorexit
    //   72: aload_0
    //   73: getfield 41	a/a/a/a:db	Landroid/database/sqlite/SQLiteDatabase;
    //   76: invokevirtual 159	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   79: aload_0
    //   80: getfield 41	a/a/a/a:db	Landroid/database/sqlite/SQLiteDatabase;
    //   83: invokevirtual 156	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   86: goto -54 -> 32
    //   89: astore_1
    //   90: aload_2
    //   91: monitorexit
    //   92: aload_1
    //   93: athrow
    //   94: astore_1
    //   95: aload_0
    //   96: getfield 41	a/a/a/a:db	Landroid/database/sqlite/SQLiteDatabase;
    //   99: invokevirtual 156	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   102: aload_1
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	a
    //   0	104	1	paramK	K
    //   11	80	2	localSQLiteStatement	SQLiteStatement
    // Exception table:
    //   from	to	target	type
    //   24	32	50	finally
    //   51	53	50	finally
    //   64	72	89	finally
    //   90	92	89	finally
    //   62	64	94	finally
    //   72	79	94	finally
    //   92	94	94	finally
  }
  
  public void deleteByKeyInTx(Iterable<K> paramIterable)
  {
    deleteInTxInternal(null, paramIterable);
  }
  
  public void deleteByKeyInTx(K... paramVarArgs)
  {
    deleteInTxInternal(null, Arrays.asList(paramVarArgs));
  }
  
  public void deleteInTx(Iterable<T> paramIterable)
  {
    deleteInTxInternal(paramIterable, null);
  }
  
  public void deleteInTx(T... paramVarArgs)
  {
    deleteInTxInternal(Arrays.asList(paramVarArgs), null);
  }
  
  public boolean detach(T paramT)
  {
    if (this.identityScope != null)
    {
      Object localObject = getKeyVerified(paramT);
      return this.identityScope.c(localObject, paramT);
    }
    return false;
  }
  
  public void detachAll()
  {
    if (this.identityScope != null) {
      this.identityScope.a();
    }
  }
  
  public String[] getAllColumns()
  {
    return this.config.d;
  }
  
  public SQLiteDatabase getDatabase()
  {
    return this.db;
  }
  
  protected abstract K getKey(T paramT);
  
  protected K getKeyVerified(T paramT)
  {
    Object localObject = getKey(paramT);
    if (localObject == null)
    {
      if (paramT == null) {
        throw new NullPointerException("Entity may not be null");
      }
      throw new d("Entity has no key");
    }
    return (K)localObject;
  }
  
  public String[] getNonPkColumns()
  {
    return this.config.f;
  }
  
  public String[] getPkColumns()
  {
    return this.config.e;
  }
  
  public g getPkProperty()
  {
    return this.config.g;
  }
  
  public g[] getProperties()
  {
    return this.config.c;
  }
  
  public c getSession()
  {
    return this.session;
  }
  
  a.a.a.c.e getStatements()
  {
    return this.config.i;
  }
  
  public String getTablename()
  {
    return this.config.b;
  }
  
  public long insert(T paramT)
  {
    return executeInsert(paramT, this.statements.a());
  }
  
  public void insertInTx(Iterable<T> paramIterable)
  {
    insertInTx(paramIterable, isEntityUpdateable());
  }
  
  public void insertInTx(Iterable<T> paramIterable, boolean paramBoolean)
  {
    executeInsertInTx(this.statements.a(), paramIterable, paramBoolean);
  }
  
  public void insertInTx(T... paramVarArgs)
  {
    insertInTx(Arrays.asList(paramVarArgs), isEntityUpdateable());
  }
  
  public long insertOrReplace(T paramT)
  {
    return executeInsert(paramT, this.statements.b());
  }
  
  public void insertOrReplaceInTx(Iterable<T> paramIterable)
  {
    insertOrReplaceInTx(paramIterable, isEntityUpdateable());
  }
  
  public void insertOrReplaceInTx(Iterable<T> paramIterable, boolean paramBoolean)
  {
    executeInsertInTx(this.statements.b(), paramIterable, paramBoolean);
  }
  
  public void insertOrReplaceInTx(T... paramVarArgs)
  {
    insertOrReplaceInTx(Arrays.asList(paramVarArgs), isEntityUpdateable());
  }
  
  /* Error */
  public long insertWithoutSettingPk(T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 56	a/a/a/a:statements	La/a/a/c/e;
    //   4: invokevirtual 334	a/a/a/c/e:a	()Landroid/database/sqlite/SQLiteStatement;
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 41	a/a/a/a:db	Landroid/database/sqlite/SQLiteDatabase;
    //   12: invokevirtual 168	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   15: ifeq +25 -> 40
    //   18: aload_2
    //   19: monitorenter
    //   20: aload_0
    //   21: aload_2
    //   22: aload_1
    //   23: invokevirtual 172	a/a/a/a:bindValues	(Landroid/database/sqlite/SQLiteStatement;Ljava/lang/Object;)V
    //   26: aload_2
    //   27: invokevirtual 174	android/database/sqlite/SQLiteStatement:executeInsert	()J
    //   30: lstore_3
    //   31: aload_2
    //   32: monitorexit
    //   33: lload_3
    //   34: lreturn
    //   35: astore_1
    //   36: aload_2
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    //   40: aload_0
    //   41: getfield 41	a/a/a/a:db	Landroid/database/sqlite/SQLiteDatabase;
    //   44: invokevirtual 116	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   47: aload_2
    //   48: monitorenter
    //   49: aload_0
    //   50: aload_2
    //   51: aload_1
    //   52: invokevirtual 172	a/a/a/a:bindValues	(Landroid/database/sqlite/SQLiteStatement;Ljava/lang/Object;)V
    //   55: aload_2
    //   56: invokevirtual 174	android/database/sqlite/SQLiteStatement:executeInsert	()J
    //   59: lstore_3
    //   60: aload_2
    //   61: monitorexit
    //   62: aload_0
    //   63: getfield 41	a/a/a/a:db	Landroid/database/sqlite/SQLiteDatabase;
    //   66: invokevirtual 159	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   69: aload_0
    //   70: getfield 41	a/a/a/a:db	Landroid/database/sqlite/SQLiteDatabase;
    //   73: invokevirtual 156	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   76: lload_3
    //   77: lreturn
    //   78: astore_1
    //   79: aload_2
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    //   83: astore_1
    //   84: aload_0
    //   85: getfield 41	a/a/a/a:db	Landroid/database/sqlite/SQLiteDatabase;
    //   88: invokevirtual 156	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   91: aload_1
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	a
    //   0	93	1	paramT	T
    //   7	73	2	localSQLiteStatement	SQLiteStatement
    //   30	47	3	l	long
    // Exception table:
    //   from	to	target	type
    //   20	33	35	finally
    //   36	38	35	finally
    //   49	62	78	finally
    //   79	81	78	finally
    //   47	49	83	finally
    //   62	69	83	finally
    //   81	83	83	finally
  }
  
  protected abstract boolean isEntityUpdateable();
  
  public T load(K paramK)
  {
    assertSinglePk();
    if (paramK == null) {
      localObject1 = null;
    }
    Object localObject2;
    do
    {
      return (T)localObject1;
      if (this.identityScope == null) {
        break;
      }
      localObject2 = this.identityScope.a(paramK);
      localObject1 = localObject2;
    } while (localObject2 != null);
    Object localObject1 = this.statements.f();
    paramK = paramK.toString();
    return (T)loadUniqueAndCloseCursor(this.db.rawQuery((String)localObject1, new String[] { paramK }));
  }
  
  public List<T> loadAll()
  {
    return loadAllAndCloseCursor(this.db.rawQuery(this.statements.e(), null));
  }
  
  protected List<T> loadAllAndCloseCursor(Cursor paramCursor)
  {
    try
    {
      List localList = loadAllFromCursor(paramCursor);
      return localList;
    }
    finally
    {
      paramCursor.close();
    }
  }
  
  protected List<T> loadAllFromCursor(Cursor paramCursor)
  {
    int j = paramCursor.getCount();
    if (j == 0) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList(j);
    CursorWindow localCursorWindow;
    if ((paramCursor instanceof CrossProcessCursor))
    {
      localCursorWindow = ((CrossProcessCursor)paramCursor).getWindow();
      if (localCursorWindow != null) {
        if (localCursorWindow.getNumRows() == j) {
          paramCursor = new a.a.a.c.b(localCursorWindow);
        }
      }
    }
    for (int i = 1;; i = 0) {
      for (;;)
      {
        if (paramCursor.moveToFirst())
        {
          if (this.identityScope != null)
          {
            this.identityScope.b();
            this.identityScope.a(j);
          }
          if ((i != 0) || (localCursorWindow == null)) {
            break label194;
          }
        }
        try
        {
          if (this.identityScope != null) {
            loadAllUnlockOnWindowBounds(paramCursor, localCursorWindow, localArrayList);
          }
          for (;;)
          {
            return localArrayList;
            e.a("Window vs. result size: " + localCursorWindow.getNumRows() + "/" + j);
            i = 0;
            break;
            label194:
            boolean bool;
            do
            {
              localArrayList.add(loadCurrent(paramCursor, 0, false));
              bool = paramCursor.moveToNext();
            } while (bool);
          }
          localCursorWindow = null;
        }
        finally
        {
          if (this.identityScope != null) {
            this.identityScope.c();
          }
        }
      }
    }
  }
  
  public T loadByRowId(long paramLong)
  {
    String str = Long.toString(paramLong);
    return (T)loadUniqueAndCloseCursor(this.db.rawQuery(this.statements.g(), new String[] { str }));
  }
  
  protected final T loadCurrent(Cursor paramCursor, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = null;
    if (this.identityScopeLong != null) {
      if ((paramInt == 0) || (!paramCursor.isNull(this.pkOrdinal + paramInt))) {}
    }
    label112:
    do
    {
      Object localObject3;
      do
      {
        return (T)localObject1;
        long l = paramCursor.getLong(this.pkOrdinal + paramInt);
        if (paramBoolean) {}
        for (localObject2 = this.identityScopeLong.a(l);; localObject2 = this.identityScopeLong.b(l))
        {
          localObject1 = localObject2;
          if (localObject2 != null) {
            break;
          }
          paramCursor = readEntity(paramCursor, paramInt);
          attachEntity(paramCursor);
          if (!paramBoolean) {
            break label112;
          }
          this.identityScopeLong.a(l, paramCursor);
          return paramCursor;
        }
        this.identityScopeLong.b(l, paramCursor);
        return paramCursor;
        if (this.identityScope == null) {
          break;
        }
        localObject3 = readKey(paramCursor, paramInt);
      } while ((paramInt != 0) && (localObject3 == null));
      if (paramBoolean) {}
      for (Object localObject2 = this.identityScope.a(localObject3);; localObject2 = this.identityScope.b(localObject3))
      {
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        paramCursor = readEntity(paramCursor, paramInt);
        attachEntity(localObject3, paramCursor, paramBoolean);
        return paramCursor;
      }
    } while ((paramInt != 0) && (readKey(paramCursor, paramInt) == null));
    paramCursor = readEntity(paramCursor, paramInt);
    attachEntity(paramCursor);
    return paramCursor;
  }
  
  protected final <O> O loadCurrentOther(a<O, ?> parama, Cursor paramCursor, int paramInt)
  {
    return (O)parama.loadCurrent(paramCursor, paramInt, true);
  }
  
  protected T loadUnique(Cursor paramCursor)
  {
    if (!paramCursor.moveToFirst()) {
      return null;
    }
    if (!paramCursor.isLast()) {
      throw new d("Expected unique result, but count was " + paramCursor.getCount());
    }
    return (T)loadCurrent(paramCursor, 0, true);
  }
  
  protected T loadUniqueAndCloseCursor(Cursor paramCursor)
  {
    try
    {
      Object localObject1 = loadUnique(paramCursor);
      return (T)localObject1;
    }
    finally
    {
      paramCursor.close();
    }
  }
  
  public i<T> queryBuilder()
  {
    return i.a(this);
  }
  
  public List<T> queryRaw(String paramString, String... paramVarArgs)
  {
    return loadAllAndCloseCursor(this.db.rawQuery(this.statements.e() + paramString, paramVarArgs));
  }
  
  public a.a.a.d.g<T> queryRawCreate(String paramString, Object... paramVarArgs)
  {
    return queryRawCreateListArgs(paramString, Arrays.asList(paramVarArgs));
  }
  
  public a.a.a.d.g<T> queryRawCreateListArgs(String paramString, Collection<Object> paramCollection)
  {
    return a.a.a.d.g.a(this, this.statements.e() + paramString, paramCollection.toArray());
  }
  
  protected abstract T readEntity(Cursor paramCursor, int paramInt);
  
  protected abstract void readEntity(Cursor paramCursor, T paramT, int paramInt);
  
  protected abstract K readKey(Cursor paramCursor, int paramInt);
  
  public void refresh(T paramT)
  {
    assertSinglePk();
    Object localObject1 = getKeyVerified(paramT);
    Object localObject2 = this.statements.f();
    String str = localObject1.toString();
    localObject2 = this.db.rawQuery((String)localObject2, new String[] { str });
    try
    {
      if (!((Cursor)localObject2).moveToFirst()) {
        throw new d("Entity does not exist in the database anymore: " + paramT.getClass() + " with key " + localObject1);
      }
    }
    finally
    {
      ((Cursor)localObject2).close();
    }
    if (!((Cursor)localObject2).isLast()) {
      throw new d("Expected unique result, but count was " + ((Cursor)localObject2).getCount());
    }
    readEntity((Cursor)localObject2, paramT, 0);
    attachEntity(localObject1, paramT, true);
    ((Cursor)localObject2).close();
  }
  
  /* Error */
  public void update(T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 105	a/a/a/a:assertSinglePk	()V
    //   4: aload_0
    //   5: getfield 56	a/a/a/a:statements	La/a/a/c/e;
    //   8: invokevirtual 510	a/a/a/c/e:d	()Landroid/database/sqlite/SQLiteStatement;
    //   11: astore_2
    //   12: aload_0
    //   13: getfield 41	a/a/a/a:db	Landroid/database/sqlite/SQLiteDatabase;
    //   16: invokevirtual 168	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   19: ifeq +20 -> 39
    //   22: aload_2
    //   23: monitorenter
    //   24: aload_0
    //   25: aload_1
    //   26: aload_2
    //   27: iconst_1
    //   28: invokevirtual 514	a/a/a/a:updateInsideSynchronized	(Ljava/lang/Object;Landroid/database/sqlite/SQLiteStatement;Z)V
    //   31: aload_2
    //   32: monitorexit
    //   33: return
    //   34: astore_1
    //   35: aload_2
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    //   39: aload_0
    //   40: getfield 41	a/a/a/a:db	Landroid/database/sqlite/SQLiteDatabase;
    //   43: invokevirtual 116	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   46: aload_2
    //   47: monitorenter
    //   48: aload_0
    //   49: aload_1
    //   50: aload_2
    //   51: iconst_1
    //   52: invokevirtual 514	a/a/a/a:updateInsideSynchronized	(Ljava/lang/Object;Landroid/database/sqlite/SQLiteStatement;Z)V
    //   55: aload_2
    //   56: monitorexit
    //   57: aload_0
    //   58: getfield 41	a/a/a/a:db	Landroid/database/sqlite/SQLiteDatabase;
    //   61: invokevirtual 159	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   64: aload_0
    //   65: getfield 41	a/a/a/a:db	Landroid/database/sqlite/SQLiteDatabase;
    //   68: invokevirtual 156	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   71: return
    //   72: astore_1
    //   73: aload_2
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    //   77: astore_1
    //   78: aload_0
    //   79: getfield 41	a/a/a/a:db	Landroid/database/sqlite/SQLiteDatabase;
    //   82: invokevirtual 156	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	a
    //   0	87	1	paramT	T
    //   11	63	2	localSQLiteStatement	SQLiteStatement
    // Exception table:
    //   from	to	target	type
    //   24	33	34	finally
    //   35	37	34	finally
    //   48	57	72	finally
    //   73	75	72	finally
    //   46	48	77	finally
    //   57	64	77	finally
    //   75	77	77	finally
  }
  
  /* Error */
  public void updateInTx(Iterable<T> paramIterable)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 56	a/a/a/a:statements	La/a/a/c/e;
    //   4: invokevirtual 510	a/a/a/c/e:d	()Landroid/database/sqlite/SQLiteStatement;
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 41	a/a/a/a:db	Landroid/database/sqlite/SQLiteDatabase;
    //   12: invokevirtual 116	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   15: aload_2
    //   16: monitorenter
    //   17: aload_0
    //   18: getfield 47	a/a/a/a:identityScope	La/a/a/b/a;
    //   21: ifnull +12 -> 33
    //   24: aload_0
    //   25: getfield 47	a/a/a/a:identityScope	La/a/a/b/a;
    //   28: invokeinterface 120 1 0
    //   33: aload_1
    //   34: invokeinterface 129 1 0
    //   39: astore_1
    //   40: aload_1
    //   41: invokeinterface 135 1 0
    //   46: ifeq +51 -> 97
    //   49: aload_0
    //   50: aload_1
    //   51: invokeinterface 139 1 0
    //   56: aload_2
    //   57: iconst_0
    //   58: invokevirtual 514	a/a/a/a:updateInsideSynchronized	(Ljava/lang/Object;Landroid/database/sqlite/SQLiteStatement;Z)V
    //   61: goto -21 -> 40
    //   64: astore_1
    //   65: aload_0
    //   66: getfield 47	a/a/a/a:identityScope	La/a/a/b/a;
    //   69: ifnull +12 -> 81
    //   72: aload_0
    //   73: getfield 47	a/a/a/a:identityScope	La/a/a/b/a;
    //   76: invokeinterface 153 1 0
    //   81: aload_1
    //   82: athrow
    //   83: astore_1
    //   84: aload_2
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    //   88: astore_1
    //   89: aload_0
    //   90: getfield 41	a/a/a/a:db	Landroid/database/sqlite/SQLiteDatabase;
    //   93: invokevirtual 156	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   96: return
    //   97: aload_0
    //   98: getfield 47	a/a/a/a:identityScope	La/a/a/b/a;
    //   101: ifnull +12 -> 113
    //   104: aload_0
    //   105: getfield 47	a/a/a/a:identityScope	La/a/a/b/a;
    //   108: invokeinterface 153 1 0
    //   113: aload_2
    //   114: monitorexit
    //   115: aload_0
    //   116: getfield 41	a/a/a/a:db	Landroid/database/sqlite/SQLiteDatabase;
    //   119: invokevirtual 159	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   122: aload_0
    //   123: getfield 41	a/a/a/a:db	Landroid/database/sqlite/SQLiteDatabase;
    //   126: invokevirtual 156	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   129: return
    //   130: astore_1
    //   131: iconst_0
    //   132: ifeq +13 -> 145
    //   135: ldc_w 519
    //   138: aload_1
    //   139: invokestatic 522	a/a/a/e:b	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   142: pop
    //   143: aconst_null
    //   144: athrow
    //   145: aload_1
    //   146: athrow
    //   147: astore_2
    //   148: aload_1
    //   149: ifnull +13 -> 162
    //   152: ldc_w 519
    //   155: aload_2
    //   156: invokestatic 522	a/a/a/e:b	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   159: pop
    //   160: aload_1
    //   161: athrow
    //   162: aload_2
    //   163: athrow
    //   164: astore_1
    //   165: aload_0
    //   166: getfield 41	a/a/a/a:db	Landroid/database/sqlite/SQLiteDatabase;
    //   169: invokevirtual 156	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   172: aload_1
    //   173: athrow
    //   174: astore_1
    //   175: iconst_0
    //   176: ifeq +13 -> 189
    //   179: ldc_w 519
    //   182: aload_1
    //   183: invokestatic 522	a/a/a/e:b	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   186: pop
    //   187: aconst_null
    //   188: athrow
    //   189: aload_1
    //   190: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	a
    //   0	191	1	paramIterable	Iterable<T>
    //   7	107	2	localSQLiteStatement	SQLiteStatement
    //   147	16	2	localRuntimeException	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   33	40	64	finally
    //   40	61	64	finally
    //   17	33	83	finally
    //   65	81	83	finally
    //   81	83	83	finally
    //   84	86	83	finally
    //   97	113	83	finally
    //   113	115	83	finally
    //   15	17	88	java/lang/RuntimeException
    //   86	88	88	java/lang/RuntimeException
    //   115	122	88	java/lang/RuntimeException
    //   122	129	130	java/lang/RuntimeException
    //   89	96	147	java/lang/RuntimeException
    //   15	17	164	finally
    //   86	88	164	finally
    //   115	122	164	finally
    //   165	172	174	java/lang/RuntimeException
  }
  
  public void updateInTx(T... paramVarArgs)
  {
    updateInTx(Arrays.asList(paramVarArgs));
  }
  
  protected void updateInsideSynchronized(T paramT, SQLiteStatement paramSQLiteStatement, boolean paramBoolean)
  {
    bindValues(paramSQLiteStatement, paramT);
    int i = this.config.d.length + 1;
    Object localObject = getKey(paramT);
    if ((localObject instanceof Long)) {
      paramSQLiteStatement.bindLong(i, ((Long)localObject).longValue());
    }
    for (;;)
    {
      paramSQLiteStatement.execute();
      attachEntity(localObject, paramT, paramBoolean);
      return;
      if (localObject == null) {
        throw new d("Cannot update entity without key - was it inserted before?");
      }
      paramSQLiteStatement.bindString(i, localObject.toString());
    }
  }
  
  protected abstract K updateKeyAfterInsert(T paramT, long paramLong);
  
  protected void updateKeyAfterInsertAndAttach(T paramT, long paramLong, boolean paramBoolean)
  {
    if (paramLong != -1L)
    {
      attachEntity(updateKeyAfterInsert(paramT, paramLong), paramT, paramBoolean);
      return;
    }
    e.c("Could not insert row (executeInsert returned -1)");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\a\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */