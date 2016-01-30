#!/bin/bash

while read line
do
    ./a.out $line
done < data.txt
    
