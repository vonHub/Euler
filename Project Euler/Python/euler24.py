class Euler24:

	#Ha! It's a horrible, horrible mess, and I still don't understand
	#why I can't declare "nums" for the class, but by golly it WORKS,
	#and with 28% battery to spare!
	#Was going to fix it, but decided a)that that would be obsessive
	#and b)to leave this as a monument to my self-taught Python.

	#nums = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
	#first few, to get the hang of it:
	#0123456789, 0123456798, 0123456879, 0123456897, 0123456978, 0123456987
	#0123457689, 0123457698, 0123457869, 0123457896, 0123457968, 0123457986, 0123458679
	#etc..

	#	in general: if the last n are in order from biggest to smallest,
	#	but digit n+1 (from the end) is smaller than digit n from the end,
	#	switch digit n+1 with the next largest digit available,
	#	then order the last n digits from small to large.
	#	if all numbers are in order from biggest to smallest, you are done!

	def order_nums(iterations):
		nums = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		for i in range(iterations):
			#get next lexicographic permutation
			for x in range(len(nums)-1):
				index = len(nums)-2-x
				#print("Index: ", index)
				#find first number less than all following
				if nums[index] < nums[index+1]:
					#switch it with next highest number
					smallestIndex = index+1
					#to find next highest, go through all following numbers
					for y in range(len(nums[index+1:])):
						#and get the smallest of all following numbers
						if nums[index+1+y] < nums[smallestIndex] and nums[index+1+y] > nums[index]:
							smallestIndex = index+1+y
					a = nums[index]
					nums[index] = nums[smallestIndex]
					nums[smallestIndex] = a
					#print(nums)
					#then order all numbers after index from small to large
					rest = nums[index+1:]
					#print(rest)
					rest.sort()
					nums = nums[:index+1] + rest
					#print(nums)
					break
		print(nums)

Euler24.order_nums(999999)
