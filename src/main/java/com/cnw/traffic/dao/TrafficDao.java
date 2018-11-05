package com.cnw.traffic.dao;

import com.cnw.traffic.model.Traffic;
import java.util.List;

public interface TrafficDao {

    List<Traffic> selectTpcs();

    List<Traffic> selectScrcs();

    List<Traffic> selectTxcs();
}
