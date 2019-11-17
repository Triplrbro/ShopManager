package com.example.shopmanager.service.db.dao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.shopmanager.service.db.bean.BookInfo;

import com.example.shopmanager.service.db.bean.OrderBookInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ORDER_BOOK_INFO".
*/
public class OrderBookInfoDao extends AbstractDao<OrderBookInfo, Long> {

    public static final String TABLENAME = "ORDER_BOOK_INFO";

    /**
     * Properties of entity OrderBookInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property _id = new Property(0, Long.class, "_id", true, "_id");
        public final static Property BookId = new Property(1, Long.class, "bookId", false, "BOOK_ID");
        public final static Property OrderInfo = new Property(2, Long.class, "orderInfo", false, "ORDER_INFO");
    }

    private DaoSession daoSession;


    public OrderBookInfoDao(DaoConfig config) {
        super(config);
    }
    
    public OrderBookInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ORDER_BOOK_INFO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: _id
                "\"BOOK_ID\" INTEGER," + // 1: bookId
                "\"ORDER_INFO\" INTEGER);"); // 2: orderInfo
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ORDER_BOOK_INFO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, OrderBookInfo entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
 
        Long bookId = entity.getBookId();
        if (bookId != null) {
            stmt.bindLong(2, bookId);
        }
 
        Long orderInfo = entity.getOrderInfo();
        if (orderInfo != null) {
            stmt.bindLong(3, orderInfo);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, OrderBookInfo entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
 
        Long bookId = entity.getBookId();
        if (bookId != null) {
            stmt.bindLong(2, bookId);
        }
 
        Long orderInfo = entity.getOrderInfo();
        if (orderInfo != null) {
            stmt.bindLong(3, orderInfo);
        }
    }

    @Override
    protected final void attachEntity(OrderBookInfo entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public OrderBookInfo readEntity(Cursor cursor, int offset) {
        OrderBookInfo entity = new OrderBookInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // _id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // bookId
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2) // orderInfo
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, OrderBookInfo entity, int offset) {
        entity.set_id(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setBookId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setOrderInfo(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(OrderBookInfo entity, long rowId) {
        entity.set_id(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(OrderBookInfo entity) {
        if(entity != null) {
            return entity.get_id();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(OrderBookInfo entity) {
        return entity.get_id() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getBookInfoDao().getAllColumns());
            builder.append(" FROM ORDER_BOOK_INFO T");
            builder.append(" LEFT JOIN BOOK_INFO T0 ON T.\"BOOK_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected OrderBookInfo loadCurrentDeep(Cursor cursor, boolean lock) {
        OrderBookInfo entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        BookInfo bookInfo = loadCurrentOther(daoSession.getBookInfoDao(), cursor, offset);
        entity.setBookInfo(bookInfo);

        return entity;    
    }

    public OrderBookInfo loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<OrderBookInfo> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<OrderBookInfo> list = new ArrayList<OrderBookInfo>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<OrderBookInfo> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<OrderBookInfo> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
