#!/bin/bash


echo "Running tests watch mode"


fswatch -0 ./test | while read -d "" event 
do
  file=$event
  temp_file=$(echo $file | grep "#")
  if [ "$temp_file" = "" ]
  then
    clear
    lein test :only $file
    echo "\n\n"
    echo "Running tests watch mode"
  fi
done

