#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Feb 15 19:43:09 2020
@author: Erik Gonzalez
CSE 15: Discrete Mathematics
Lab02: Basic Truth Tables
"""

from logic import TruthTable

aT = TruthTable(['-a'])

bT = TruthTable([ 'a and b' ])

cT = TruthTable(['a or b'])

dT = TruthTable(['a -> b'])

eT = TruthTable(['a <-> b'])

tables = [aT ,bT ,cT, dT, eT]

for i in range(5):
    tables[i].display()
    print("")
