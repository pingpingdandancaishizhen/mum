#!/bin/bash
docker build -t risk-p2p-server-prd:1.6 --build-arg RISK_VER=$1 .
