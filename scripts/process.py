import re
import requests
import json
import random

f = open("Tranzactii_vlad_leica.csv")
lines = f.readlines()
date_format = re.compile("^[0-9][0-9] [a-z][a-z][a-z] [0-9]{4};")
entries = []
i = 0
YOUR_API_KEY = 'oVmQM9RuBh-Kf6zthJ3yt3mdZ_I7Qco4-cF2eDHhHuM'
months_dict = {'ian':'01','feb':'02','mar':'03','apr':'04','mai':'05','iun':'06','iul':'07','aug':'08','sep':'09','oct':'10','nov':'11','dec':'12'}
done = 0
while lines != []:
	line = lines.pop(0)
	i+=1
	# print(f'trying {line}')
	# if i > 30:
	# 	break
	x = re.search(date_format,line)
	if x is not None:
		date = x.group()[:-1].split(' ')
		date[1] = months_dict[date[1]]
		entry = ['.'.join(date)]
		# entries.append(entry)
		if lines != []:
			line = lines.pop(0)
			i+=1
			if not line.startswith('Terminal'):
				continue
			entry.append(line.split(':')[1][:-1])
			url = f'https://geocoder.ls.hereapi.com/6.2/geocode.json?apiKey={YOUR_API_KEY}&searchtext={entry[1]}'
			r = requests.get(url)
			resp = json.loads(r.text)
			try:
				entry.append(str(resp['Response']['View'][0]['Result'][0]['Location']['DisplayPosition']['Latitude']))
				entry.append(str(resp['Response']['View'][0]['Result'][0]['Location']['DisplayPosition']['Longitude']))
				entry.append(resp['Response']['View'][0]['Result'][0]['Location']['Address']['City'])
			except (IndexError,KeyError):
				#44.4343, 26.10298, 'București'
				entry.append("{:.5f}".format(44.4343 + 1.0 * random.randint(0,100) / 100000))
				entry.append("{:.5f}".format(26.10298 + 1.0 * random.randint(0,100) / 100000))
				entry.append('București')
		else: 
			break
		if lines != []:
			line = lines.pop(0)
			i+=1
			entry.append(line.split(';')[1][:-1].replace(',','.'))
			entries.append(entry)
		else: 
			break
entries = filter(lambda x: len(x) == 6,entries)
for line in entries:
	print(f'{line[0]},{line[1]},{line[2]},{line[3]},{line[4]},{line[5]}')
