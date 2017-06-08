package org.risk.report.api.service;

import java.util.List;
import java.util.Map;

public interface RepaymentOverdueService {

    void insertRepaymentOverdue4Report(String domain);

    List<Map<String, String>> selectAllOverDay(String domain);

}
