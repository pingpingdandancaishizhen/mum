package org.risk.server.report.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepaymentOverdueDAO {

    void insertRepaymentOverdue4Report(@Param("domain") String domain);

    List<Map<String, String>> selectAllOverDay(@Param("domain") String domain);

}