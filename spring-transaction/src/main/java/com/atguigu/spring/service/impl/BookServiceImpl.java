package com.atguigu.spring.service.impl;

import com.atguigu.spring.dao.BookDao;
import com.atguigu.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
//    @Transactional(
//            propagation = Propagation.REQUIRES_NEW //调用该方法时，开启新事务
//    )  //设置事务
    public void buyBook(Integer userId, Integer bookId) {
//        1. 查询图书的价格
        Integer price = bookDao.getPriceByBookId(bookId);
//        2.更新图书的库存
        bookDao.updateStock(bookId);
//        3.更新用户的余额
        bookDao.updateBalance(userId,price);
    }
}
