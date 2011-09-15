#!/bin/sh
cd src
gcc stress.c -o stress
sudo mv stress /bin/stress
