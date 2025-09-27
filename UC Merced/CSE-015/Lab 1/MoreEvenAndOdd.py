# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""

count = 0
oddList = []
for i in range(10):
    num = int(input("Enter a number: "))
    if num % 2 != 0:
        oddList.append(num)
    else:
        count += 1
if count == 10:
    print("No odd numbers were entered")
else:
    print("The largest odd number is: ", max(oddList))

    
    