#!/bin/bash
docker run -d  -p8080:8080 -v /root/risk-docker-dev/riskp2pweb/logs:/home/deploy/apache-tomcat/logs  risk-p2p-web-server-test:1.5
