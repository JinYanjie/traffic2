package com.cnw.traffic.service;

import com.cnw.traffic.model.Traffic;
import com.github.pagehelper.PageInfo;

public interface TrafficService {

    PageInfo<Traffic> findAllTpc(int pageNum, int pageSize);

    PageInfo<Traffic> findAllScrc(int pageNum, int pageSize);

    PageInfo<Traffic> findAllTxc(int pageNum, int pageSize);
}
