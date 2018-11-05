package com.cnw.traffic.service.impl;

import com.cnw.traffic.dao.TrafficDao;
import com.cnw.traffic.model.Traffic;
import com.cnw.traffic.service.TrafficService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class TrafficServiceImpl implements TrafficService {

    @Autowired
    private TrafficDao trafficDao;


    @Override
    public PageInfo<Traffic> findAllTpc(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Traffic> userDomains = trafficDao.selectTpcs();
        PageInfo result = new PageInfo(userDomains);
        return result;
    }

    @Override
    public PageInfo<Traffic> findAllScrc(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Traffic> userDomains = trafficDao.selectScrcs();
        PageInfo result = new PageInfo(userDomains);
        return result;
    }

    @Override
    public PageInfo<Traffic> findAllTxc(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Traffic> userDomains = trafficDao.selectTxcs();
        PageInfo result = new PageInfo(userDomains);
        return result;
    }
}
