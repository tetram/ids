# -*-coding:Latin-1 -*

import csv
from csvparser import parse

def closer(liste):
	c = []
	m = -99
	for l in liste:
		pwr = float(l[3])
		# TODO : faire plus g�n�rique !! pwr depend du drivers wifi
		if (pwr >= m) & (pwr < -1) :
			c = l
			m = pwr
	return c
	
if __name__ == "__main__":
    print(closer(parse("test-01.csv")))
