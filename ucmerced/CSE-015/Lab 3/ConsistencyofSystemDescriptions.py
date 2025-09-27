# -*- coding: utf-8 -*-
"""
Created on Sun Mar  1 22:12:53 2020

@author: gonza
"""

from logic import TruthTable

p = []

prop = input("Enter a proposition:")
p.append(prop)

answer = input("Would you like to enter mroe [Y/N]: ")
if (answer == 'Y'):
    while (answer == 'Y'):
       prop = input("Enter a proposition:")
       p.append(prop)
       answer = input("Would you like to enter mroe [Y/N]: ")

prop2=[]
for i in table.table:
    prop2.append(i[1])

for j in prop2:
    if(j[0] == j[1]):
        if(j[0] == 0):
            print("Your description is consistent.")
            break
        else:
             print("Your description is not consistent.")
             break
       
