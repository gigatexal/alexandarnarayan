import socket
import sys
import random

HOST, PORT = "localhost", 9999
data2 = str([random.randint(0,1) for x in xrange(0,100)])
sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

try:
    sock.connect((HOST, PORT))
    while True:	
	print sys.getsizeof(data2)
	sock.sendall(data2)
    received = sock.recv(10240000)
finally:
    sock.close()

print "Sent:     {}".format(data)
print "Received: {}".format(received)

