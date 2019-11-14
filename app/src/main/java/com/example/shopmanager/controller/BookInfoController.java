package com.example.shopmanager.controller;


import com.example.shopmanager.service.BookInfoService;
import com.example.shopmanager.service.db.bean.BookInfo;

import java.util.List;

/**
 *  用于控制展示详情的页面
 */
public class BookInfoController {

    private final BookInfoService bookInfoService;

    public BookInfoController() {
        bookInfoService = new BookInfoService();
    }

    /**
     *  获取全部图书信息
     */
    public List<BookInfo> getBookInfoList(){
        List<BookInfo> bookInfos = bookInfoService.queryBookInfoList();
        return  bookInfos;
    }

    /**
     *  根据图书编号获得图书信息
     */
    public BookInfo getBookInfByCode(String code){
        BookInfo bookInfByCode = bookInfoService.getBookInfByCode(code);
        return bookInfByCode;
    }

    /**
     *  根据图书名字获得图书信息
     */
    public BookInfo getBookInfoByName(String name){
        BookInfo bookInfoByName = bookInfoService.getBookInfoByName(name);
        return bookInfoByName;
    }

    /**
     *  根据 id 获取图书信息
     */
    public BookInfo getBookInfoById(Long id){
        BookInfo bookInfoByName = bookInfoService.getBookInfoById(id);
        return bookInfoByName;
    }

    /**
     *  设定图书信息
     */
    public void setBookInfo(BookInfo bookInfo){
        bookInfoService.setBookInfo(bookInfo);
    }

    /**
     * 主页获取图书信息，最大6个
     */
    public List<BookInfo> getNum(){
        List<BookInfo> numBookInfo = bookInfoService.getNumBookInfo(6);
        return numBookInfo;
    }
}
