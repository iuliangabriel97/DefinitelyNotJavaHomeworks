import requests, threading, time, random

threadCount = 100
loopCount = 100

URL = "http://localhost:8080/Tema4/main"

class StressTester(threading.Thread):
	def __init__(self, index):
		self.index = index
		super().__init__()
		
	def run(self):
		print("Tread %3d STARTED" % (self.index))
		for loop in range(loopCount):
			id = str(random.randint(0, 50))
			r = requests.post(URL, data={'id': id})
			if r.status_code != 200:
				print("Post error code %d" % (r.status_code))
				continue
			r = requests.get(URL + "?id=" + id)
			if r.status_code != 200:
				print("Get error code %d" % (r.status_code))
				continue
			print (r.text)
		print("Tread %3d FINISHED" % (self.index))

for thread in range(threadCount):
	StressTester(thread+1).start()
	