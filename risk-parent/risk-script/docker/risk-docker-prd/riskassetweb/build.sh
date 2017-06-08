#!/bin/bash
docker build -t risk-asset-web-server-prd:1.6 --build-arg RISK_VER=$1 .
