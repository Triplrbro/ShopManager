package com.example.shopmanager.service.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.shopmanager.service.db.bean.OrderSettlementInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ORDER_SETTLEMENT_INFO".
*/
public class OrderSettlementInfoDao extends AbstractDao<OrderSettlementInfo, Long> {

    public static final String TABLENAME = "ORDER_SETTLEMENT_INFO";

    /**
     * Properties of entity OrderSettlementInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property _id = new Property(0, Long.class, "_id", true, "_id");
        public final static Property Address = new Property(1, String.class, "address", false, "ADDRESS");
        public final static Property Phone = new Property(2, String.class, "phone", false, "PHONE");
        public final static Property Name = new Property(3, String.class, "name", false, "NAME");
        public final static Property AllPrice = new Property(4, String.class, "allPrice", false, "ALL_PRICE");
        public final static Property RealityPrice = new Property(5, String.class, "realityPrice", false, "REALITY_PRICE");
        public final static Property UserId = new Property(6, long.class, "userId", false, "USER_ID");
        public final static Property CreateData = new Property(7, String.class, "createData", false, "CREATE_DATA");
        public final static Property State = new Property(8, String.class, "state", false, "STATE");
    }

    private DaoSession daoSession;


    public OrderSettlementInfoDao(DaoConfig config) {
        super(config);
    }
    
    public OrderSettlementInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ORDER_SETTLEMENT_INFO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: _id
                "\"ADDRESS\" TEXT," + // 1: address
                "\"PHONE\" TEXT," + // 2: phone
                "\"NAME\" TEXT," + // 3: name
                "\"ALL_PRICE\" TEXT," + // 4: allPrice
                "\"REALITY_PRICE\" TEXT," + // 5: realityPrice
                "\"USER_ID\" INTEGER NOT NULL ," + // 6: userId
                "\"CREATE_DATA\" TEXT," + // 7: createData
                "\"STATE\" TEXT);"); // 8: state
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ORDER_SETTLEMENT_INFO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, OrderSettlementInfo entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(2, address);
        }
 
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(3, phone);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(4, name);
        }
 
        String allPrice = entity.getAllPrice();
        if (allPrice != null) {
            stmt.bindString(5, allPrice);
        }
 
        String realityPrice = entity.getRealityPrice();
        if (realityPrice != null) {
            stmt.bindString(6, realityPrice);
        }
        stmt.bindLong(7, entity.getUserId());
 
        String createData = entity.getCreateData();
        if (createData != null) {
            stmt.bindString(8, createData);
        }
 
        String state = entity.getState();
        if (state != null) {
            stmt.bindString(9, state);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, OrderSettlementInfo entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(2, address);
        }
 
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(3, phone);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(4, name);
        }
 
        String allPrice = entity.getAllPrice();
        if (allPrice != null) {
            stmt.bindString(5, allPrice);
        }
 
        String realityPrice = entity.getRealityPrice();
        if (realityPrice != null) {
            stmt.bindString(6, realityPrice);
        }
        stmt.bindLong(7, entity.getUserId());
 
        String createData = entity.getCreateData();
        if (createData != null) {
            stmt.bindString(8, createData);
        }
 
        String state = entity.getState();
        if (state != null) {
            stmt.bindString(9, state);
        }
    }

    @Override
    protected final void attachEntity(OrderSettlementInfo entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public OrderSettlementInfo readEntity(Cursor cursor, int offset) {
        OrderSettlementInfo entity = new OrderSettlementInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // _id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // address
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // phone
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // name
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // allPrice
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // realityPrice
            cursor.getLong(offset + 6), // userId
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // createData
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8) // state
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, OrderSettlementInfo entity, int offset) {
        entity.set_id(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setAddress(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPhone(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setAllPrice(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setRealityPrice(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setUserId(cursor.getLong(offset + 6));
        entity.setCreateData(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setState(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(OrderSettlementInfo entity, long rowId) {
        entity.set_id(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(OrderSettlementInfo entity) {
        if(entity != null) {
            return entity.get_id();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(OrderSettlementInfo entity) {
        return entity.get_id() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
