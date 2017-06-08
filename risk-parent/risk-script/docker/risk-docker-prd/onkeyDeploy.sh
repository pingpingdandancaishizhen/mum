#!/usr/bin/env bash
cd /root/risk-docker-prd/
docker rm -f $(sudo docker ps -a -q)
docker rmi $(docker images -q)
cd /root/risk-docker-prd/riskp2p
sh build.sh $1
cd /root/risk-docker-prd/riskassetweb
sh build.sh $1
cd /root/risk-docker-prd/riskp2pweb
sh build.sh $1
cd /root/risk-docker-prd/riskreport
sh build.sh $1
cd /root/risk-docker-prd/riskasset
sh build.sh $1
cd ../



