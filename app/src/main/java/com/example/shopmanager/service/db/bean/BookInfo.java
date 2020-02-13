package com.example.shopmanager.service.db.bean;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;

/**
 *  书的数据库对应
 */

@Entity
public class BookInfo{

    @Id(autoincrement = true)
    private Long _id;

    // 图书编码
    private String code;

    // 书名
    private String bookNmae;

    // 价格
    private String price;

    // 原价
    private String oldPrice;

    // 作者
    private String author;

    // 出版社
    private String press;

    // 装帧
    private String binding ;

    // 评分
    private String score;

    // 介绍和目录
    private String contents;

    // 图书图片
    private String bookPhoto;

    // 图书删除标记
    private int deleSign;

    @Generated(hash = 906173558)
    public BookInfo(Long _id, String code, String bookNmae, String price,
            String oldPrice, String author, String press, String binding,
            String score, String contents, String bookPhoto, int deleSign) {
        this._id = _id;
        this.code = code;
        this.bookNmae = bookNmae;
        this.price = price;
        this.oldPrice = oldPrice;
        this.author = author;
        this.press = press;
        this.binding = binding;
        this.score = score;
        this.contents = contents;
        this.bookPhoto = bookPhoto;
        this.deleSign = deleSign;
    }

    @Generated(hash = 1952025412)
    public BookInfo() {
    }

    public Long get_id() {
        return this._id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBookNmae() {
        return this.bookNmae;
    }

    public void setBookNmae(String bookNmae) {
        this.bookNmae = bookNmae;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOldPrice() {
        return this.oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return this.press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getBinding() {
        return this.binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getScore() {
        return this.score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getContents() {
        return this.contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getBookPhoto() {
        return this.bookPhoto;
    }

    public void setBookPhoto(String bookPhoto) {
        this.bookPhoto = bookPhoto;
    }


    @Override
    public String toString() {
        return "BookInfo{" +
                "_id=" + _id +
                ", code='" + code + '\'' +
                ", bookNmae='" + bookNmae + '\'' +
                ", price='" + price + '\'' +
                ", oldPrice='" + oldPrice + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", binding='" + binding + '\'' +
                ", score='" + score + '\'' +
                ", contents='" + contents + '\'' +
                ", bookPhoto='" + bookPhoto + '\'' +
                '}';
    }

    public int getDeleSign() {
        return this.deleSign;
    }

    public void setDeleSign(int deleSign) {
        this.deleSign = deleSign;
    }
}
