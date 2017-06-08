#!/bin/bash
docker build -t risk-p2p-web-server-prd:1.6 --build-arg RISK_VER=$1 .
