package com.macoredroid.onlinebookstore.serviceimpl;
import com.macoredroid.onlinebookstore.dao.OrderDao;
import com.macoredroid.onlinebookstore.entity.Order;
import com.macoredroid.onlinebookstore.service.GetSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GetSalesServiceimpl implements GetSalesService {
    @Autowired
    private OrderDao OrderDao;
    @Override
    public List<Order> GetOrderByIsbn(String isbn) {
        return OrderDao.findAllByIsbn(isbn);
    }

    @Override
    public List<Order> GetOrderByTime(String before, String after) {
        return null;
    }
}
