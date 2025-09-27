#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Feb 15 20:00:37 2020
@author: Erik Gonzalez
CSE 15: Discrete Mathematics
Lab02: Equivalence in Propositional Logic
"""
from logic import TruthTable


propA = input("Enter proposition 1: ")
propB = input("Enter proposition 2: ")
tables = [propA, propB] 
print("")

for i in range(2):
    tables[i] = TruthTable([tables[i]])
    
print(propA)
print(tables[0].table)
print("")
print(propB)
print(tables[1].table)

for i in range(1):
    if (tables[i].table == tables[i + 1].table):
        print("\nThe propositions are equivalent")
    else:
        print("\nThe propositions are not equivalent")
            