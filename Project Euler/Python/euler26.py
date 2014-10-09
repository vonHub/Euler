#a unit fraction will return a repeating decimal if the denominator
#is not a power of 2 or 5.

def get_nonrepeaters(num):
    nums = []
    for n in range(2, num):
        temp = n
        while temp % 2 == 0:
            temp = temp / 2
        while temp % 5 == 0:
            temp = temp / 5
        if temp > 1:
            nums.append(n)
    return nums
