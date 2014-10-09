class Euler25:
	#Find the first term in the Fibonacci sequence to exceed 1000 digits.

	#Brute force method (probably won't work, but a place to start)
	def fib_with_digits(digits):
		a = 0
		f = 1
		n = 1
		while f < 10 ** (digits - 1):
			b = f
			f = a + f
			a = b
			n = n + 1
		print(f, ",", n)
	#Hm. It worked, and in .032 seconds.
	#I wonder how long it would take to do in Java.
	#Geez, this is taking a while. Did I program it right?
	#Nope! Fixed it, only took about .015 seconds to run.
	#Sorry Python!

Euler25.fib_with_digits(1000)
