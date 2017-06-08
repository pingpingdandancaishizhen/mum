#!/bin/bash
docker build -t risk-asset-server-uat:1.5 --build-arg RISK_VER=$1 .
