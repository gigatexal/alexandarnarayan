import socket
import sys
import random

HOST, PORT = "localhost", 9999
data = " ".join(sys.argv[1:])
data2 = str([random.randint(0,1) for x in xrange(0,100)])
# Create a socket (SOCK_STREAM means a TCP socket)
sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

try:
    # Connect to server and send data
    sock.connect((HOST, PORT))
    while True:	
	#sock.sendall(data + "\n")
	print sys.getsizeof(data2)
	sock.sendall(data2)
    # Receive data from the server and shut down
    received = sock.recv(10240000)
finally:
    sock.close()

print "Sent:     {}".format(data)
print "Received: {}".format(received)

