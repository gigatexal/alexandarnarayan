import re
import os
import multiprocessing as mp


def getAbsPaths(dir='/'):
   for folder, subs, filenames in os.walk(dir):
      for ff in filenames:
         if (ff[0] is not '.'):
            yield (os.path.join(folder,ff))

files = getAbsPaths('/Users/gigatexal/PycharmProjects/test/')

def srch(srchitem='',dir='/'):
   listOfFiles = {}
   srch = re.compile(srchitem)
   paths = getAbsPaths(dir)
   filesandlines = {}
   count = 0
   for f in paths:
      with open(f) as openedFile:
         for line in openedFile:
            if (srch.search(line)):
               listOfFiles[count] = (f,line)
               count += 1

   return listOfFiles


s = srch('alexn','/Users/gigatexal/PycharmProjects/test/')

#iterate through s
for i in s.keys():
   print (s[i][0], s[i][1])
