#!/usr/bin/env bash
cd /root/risk-docker-dev/
docker rm -f $(sudo docker ps -a -q)
docker rmi $(docker images -q)
cd /root/risk-docker-dev/riskp2p
sh build.sh $1
cd /root/risk-docker-dev/riskassetweb
sh build.sh $1
cd /root/risk-docker-dev/riskp2pweb
sh build.sh $1
cd /root/risk-docker-dev/riskreport
sh build.sh $1
cd /root/risk-docker-dev/riskasset
sh build.sh $1
cd ../
docker-compose up -d &



