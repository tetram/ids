# -*-coding:Latin-1 -*
# Pour parser le fichier de sortie d'airodump

import csv
import datetime

##########################################################
#
# La fonction parse retourne la liste des clients wifi présents 
# dans le csv.
# Pour chaque client on a :
# Station MAC, First time seen, Last time seen, Power, # packets, BSSID, Probed ESSIDs
#
##########################################################
def parse(file):
	myfile = open(file)
	data = csv.reader(x.replace('\0','') for x in myfile)
	tag = 0
	rows = []
	for row in data:
		if len(row) != 0:
			if tag:
				rows.append(row)
			else:
				if "Station MAC" in row:
					tag = 1
	return rows
		
##########################################################
#
# La fonction parseM retourne la liste des clients wifi présents 
# dans le csv, qui ont émis un paquet dans les s secondes précédentes
# Pour chaque client on a :
# Station MAC, First time seen, Last time seen, Power, # packets, BSSID, Probed ESSIDs
# 2013-02-20 10:02:28
##########################################################
def parseM(file,s):
	myfile = open(file)
	data = csv.reader(x.replace('\0','') for x in myfile)
	tag = 0
	rows = []
	now = datetime.datetime.now()
	nowSago = now + datetime.timedelta(seconds=-s)
	for row in data:
		if len(row) != 0:
			if tag:
				t = datetime.datetime.strptime(row[2]," %Y-%m-%d %H:%M:%S")
				if (t > nowSago):
					rows.append(row)
			else:
				if "Station MAC" in row:
					tag = 1
	return rows
	
def printRows(rows):
	for row in rows:
		print(row)

if __name__ == "__main__":
    #print(parse("test-01.csv"))
	printRows(parseM("test-01.csv",3600))