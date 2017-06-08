#!/bin/bash
docker build -t risk-p2p-server-test:1.5 --build-arg RISK_VER=$1 .
