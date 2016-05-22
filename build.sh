#!/bin/bash
rm -rf out
mkdir out
javac -d out -cp lib/Multivalent20091027.jar -s src src/io/github/vitalinaumov/mybriss/MyBriss.java
