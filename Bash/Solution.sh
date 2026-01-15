#!/bin/bash

dir_name="./downloads"
file_name="code.txt"
available_mem=256
download_size=128

# TODO: Check if dir_name is not "./downloads" or there is not enough memory. If these conditions are met, print "Create directory or free up memory space."
if [ "$dir_name" != "./downloads" ] || [ $available_mem -ge $download_size ]
then
    echo "Create directory or free up memory space."
# TODO: Check if `dir_name` is "./downloads" but `file_name` is "code.txt". If these conditions are met, print "File name already taken."
elif [ "$dir_name" == "./downloads" ] && [ "$file_name" == "code.txt" ]
then
    echo "File name already taken."
# TODO: Check if `dir_name` is "./downloads", file_name` is not "code.txt", and there is enough space. If these conditions are met, print "Starting download."
elif [ "$dir_name" == "./downloads" ] && [ "$file_name" != "code.txt" ] && [ $available_mem -ge $download_size ]
then
    echo "Starting download."
# TODO: If none of the above conditions are met, print "Not enough memory."
else
    echo "Not enough memory."
fi
