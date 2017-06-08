#!/bin/bash
docker run --net=host  -d  -p10020:10020 -v/root/risk-docker-dev/riskp2p/logs:/home/deploy/risk_server/risk_p2p_server/logs risk-p2p-server-test:1.5
