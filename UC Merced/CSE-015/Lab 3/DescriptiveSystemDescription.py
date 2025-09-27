# -*- coding: utf-8 -*-
"""
Created on Sun Mar  1 22:28:14 2020

@author: gonza
"""

from logic import TruthTable
i = 0
p = []

prop = input("Enter a proposition:")
p.append(prop)

answer = input("Would you like to enter mroe [Y/N]: ")
if (answer == 'Y'):
    while (answer == 'Y'):
       prop = input("Enter a proposition:")
       p.append(prop)
       answer = input("Would you like to enter mroe [Y/N]: ")
       
table = TruthTable(p)

print("Your program uses propositional variables", table.vars)

a = table.vars
p2 = []

while (i < len(a)):
    p2.append(input("Enter meaning of " + a[i]+': '))
    i += 1
    
b = []
for i in table.table:
    b.append(i[1])
for j in b:
    if (b[2] == 1):
       print ('Your description is inconsistent')
       print ('It is not the case when', p2[0])
       print ('It is not the case when', p2[1])
       break
    else:
        print ('Your description is consistent when:')
        print ('It is not the case when', p2[0])
        print ('It is not the case when', p2[1])
        break