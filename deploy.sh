#!/usr/bin/env bash

mvn clean deploy -pl '!alipay-demo' -Prelease -DskipTests