#!/bin/bash
docker run --net=host  -d  -p10030:10030 -v/root/risk-docker-dev/riskreport/logs:/home/deploy/risk_report/risk_report_server/logs risk-report-server-test:1.5
