#!/bin/bash

while read line
do
    ./test $line
done < triangle.txt
