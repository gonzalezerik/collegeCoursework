#!/bin/bash
exec 3>file1.lock
exec 4>file2.lock
echo "Process 1 acquiring lock on file1.lock"
flock 3
sleep 2
echo "Process 1 attempting to acquire lock on file2.lock"
flock 4
echo "Process 1 acquired both locks"
echo "Process 1 releasing locks"
exec 3>&-
exec 4>&-
