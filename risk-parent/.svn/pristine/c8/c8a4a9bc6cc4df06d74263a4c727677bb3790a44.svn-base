#!/usr/bin/env bash
cd /root/risk-docker-uat/
docker rm -f $(sudo docker ps -a -q)
docker rmi $(docker images -q)
cd /root/risk-docker-uat/riskp2p
sh build.sh $1
cd /root/risk-docker-uat/riskassetweb
sh build.sh $1
cd /root/risk-docker-uat/riskp2pweb
sh build.sh $1
cd /root/risk-docker-uat/riskreport
sh build.sh $1
cd /root/risk-docker-uat/riskasset
sh build.sh $1
cd ../
docker-compose up -d &



