#!/bin/bash
java -Dspring.profiles.active=${1:-dev} -jar build/libs/adaptavist-cli-1.0.jar