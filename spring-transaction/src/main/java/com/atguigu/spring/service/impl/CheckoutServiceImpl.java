package com.atguigu.spring.service.impl;

import com.atguigu.spring.dao.BookDao;
import com.atguigu.spring.service.BookService;
import com.atguigu.spring.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    private BookService bookService;
    @Override
//    @Transactional
    public void checkout(Integer userId,Integer[] bookIds) {
        //事务的嵌套，此时checkout加上了事务，而buyBook也加上了事务，此时起作用的是checkout
        //中的事务，也就是说此时只要有一个buyBook没有成功，整个事务全会回滚
        for (Integer bookId :  bookIds){
            bookService.buyBook(userId,bookId);
        }
    }
}
