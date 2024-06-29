#!/bin/bash
java -Dspring.profiles.active=${1:-dev} -jar build/libs/test-cli-1.0.jar