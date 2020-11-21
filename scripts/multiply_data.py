import json
import random
from randomtimestamp import randomtimestamp
from math import sin,cos

brussels = ('Brussels',50.8503, 4.3517)
amsterdam = ('Amsterdam',52.3676, 4.9041)
bucharest = ('Bucharest',44.4268, 26.1025)
hague = ('Hague',52.0705, 4.3007)
bruges = ('Bruges',51.2093, 3.2247)
anvers = ('Antwerp',51.2194, 4.4025)
rotterdam = ('Rotterdam',51.9244, 4.4777)
thesalonikis = ('Thessaloniki',40.6401, 22.9444)
thassos = ('Thassos',40.6845, 24.6484)
sofia = ('Sofia',42.6977, 23.3219)
cities = [brussels,amsterdam,bucharest,hague,bruges,anvers,rotterdam,thesalonikis,thassos,sofia]
people = ["Sierra Brewer",
			"Simra Hilton",
			"Farrah Carlson",
			"Shelly Hartman",
			"Esme-Rose Parker",
			"Hunter Lott",
			"Wasim Giles",
			"Kishan Christie",
			"Sahara Bains",
			"Johnny Burris", ]

# print(randomtimestamp(start_year=2019,text=True).replace('/','-'))
distrib = [True,True,True,False,False,False,False,False,False,False,False,False]
distrib2 = [1,1,1,1,1,1,1,1,1,1,1.5,1.5,1.5,1.5,2,2,2,2,2,4,4,4,4,5,5,10]
with open('clean_data.csv') as f:
	lines = f.readlines()
	new_lines = []
	for line in lines[1:]:
		# new_lines.append(line[:-1])
		try:
			[user,tt,message,amount,category,location,lat,lon] = line.split(',')
			for _ in range(30):
				(city,lat,lon) = random.choice(cities)
				tt = randomtimestamp(start_year=2019,text=False)
				if random.choice(distrib):
					if tt.hour < 12:
						tt = tt.replace(hour = tt.hour + 12)
				tt = str(tt)
				# print(tt)
				tt = tt.split('-')
				tt[1] = "{:02d}".format(int(tt[1]))
				# print(tt[1])
				# aux = tt[0]
				# tt[0] = tt[1]
				# tt[1] = aux
				tt = '-'.join(tt)
				tt = tt.replace('-','/')


				time = tt.split(' ')[1].split(':')[:2]
				tt = tt.split(' ')[0] + ' ' + ':'.join(time)
				radius = 1000 * random.choice(distrib2)
				radius = random.randrange(-radius,radius)
				fi = 1.0 * random.randrange(0, 3140) / 1000
				# print(fi)
				# print(time)
				lat_delta = 1.0 * radius * sin(fi) / 100000
				long_delta = 1.0 * radius * cos(fi) / 100000
				# print(lat_delta)
				new_lines.append(';'.join([random.choice(people),tt,message,amount,category,city,"{:.5f}".format(float(lat) + lat_delta),"{:.5f}".format(float(lon) + long_delta)]))

		except ValueError:
			pass
	new_lines = map(str,new_lines)	
	print('User;Date;Description;Amount;Category;Location;Latitude;Longitude')
	print('\n'.join(new_lines))