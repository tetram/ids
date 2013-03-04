# -*-coding:Latin-1 -*
# Pour parser le fichier de sortie d'airodump

import csv

##########################################################
#
# La fonction retourne la liste des clients wifi présents 
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
		
# test de la fonction parse
if __name__ == "__main__":
    print(parse("test-01.csv"))
