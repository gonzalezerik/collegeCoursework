#!/bin/bash
exec 3>file2.lock
exec 4>file1.lock
echo "Process 2 acquiring lock on file2.lock"
flock 3
sleep 2
echo "Process 2 attempting to acquire lock on file1.lock"
flock 4
echo "Process 2 acquired both locks"
echo "Process 2 releasing locks"
exec 3>&-
exec 4>&-
