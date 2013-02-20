# Pour parser le fichier de sortie d'airodump

import csv

	def parse(file):
		data = csv.reader(open(file))
		# Read the column names from the first line of the file
		fields = data.next()
		for row in data:
			# Zip together the field names and values
		    items = zip(fields, row)
		    item = {}
			# Add the value to our dictionary
		    for (name, value) in items:
			item[name] = value.strip()
		return items
