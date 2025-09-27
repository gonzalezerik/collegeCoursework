.data 

original_list: .space 100 
sorted_list: .space 100


str0: .asciiz "Enter size of list (between 1 and 25): "
str1: .asciiz "Enter one list element: "
str2: .asciiz "Content of original list: "
str3: .asciiz "Enter a key to search for: "
str4: .asciiz "Content of sorted list: "
strYes: .asciiz "Key found!"
strNo: .asciiz "Key not found!"


# test strings


.text 

# This is the main program.
# It first asks user to enter the size of a list.
# It then asks user to input the elements of the list, one at a time.
# It then calls printList to print out content of the list.
# It then calls inSort to perform insertion sort
# It then asks user to enter a search key and calls bSearch on the sorted list.
# It then prints out search result based on return value of bSearch
main: 
	addi $sp, $sp -8
	sw $ra, 0($sp)
	li $v0, 4 
	la $a0, str0 
	syscall 
	li $v0, 5	# Read size of list from user
	syscall
	move $s0, $v0 #s0 holds size of list
	move $t0, $0
	la $s1, original_list #s1 holds address for the original list
	
loop_in:
	li $v0, 4 
	la $a0, str1 
	syscall 
	sll $t1, $t0, 2
	add $t1, $t1, $s1 
	li $v0, 5	# Read elements from user
	syscall
	sw $v0, 0($t1)
	addi $t0, $t0, 1
	bne $t0, $s0, loop_in
	move $a0, $s1 # a0 is the list
	move $a1, $s0 # a1 is the size
	
	jal inSort	# Call inSort to perform insertion sort in original list
	
	sw $v0, 4($sp)
	li $v0, 4 
	la $a0, str2 
	syscall 
	la $a0, original_list
	move $a1, $s0
	jal printList	# Print original list
	li $v0, 4 
	la $a0, str4 
	syscall 
	lw $a0, 4($sp)
	jal printList	# Print sorted list
	
	li $v0, 4 
	la $a0, str3 
	syscall 
	li $v0, 5	# Read search key from user
	syscall
	move $a3, $v0
	lw $a0, 4($sp)
	jal bSearch	# Call bSearch to perform binary search
	
	beq $v0, $0, notFound
	li $v0, 4 
	la $a0, strYes 
	syscall 
	j end
	
notFound:
	li $v0, 4 
	la $a0, strNo 
	syscall 
end:
	lw $ra, 0($sp)
	addi $sp, $sp 8
	li $v0, 10 
	syscall
	
	
# printList takes in a list and its size as arguments. 
# It prints all the elements in one line.
printList: # a0 has the address of the original list
	   # a1 has size of list
	# Your implementation of printList here	
	#addi $sp, $sp, -4
	sw   $ra, 0($sp) # saving location of $ra in stack
	
	
	li $t0, 0 #counter
	li $t1, 0 #shift through array
	li $t6, 0 # holds the value to print from array
	move $v1, $a0 # passing the list to v1 because I will be using $a0 for syscalls later
printLoop:
	sll $t1, $t0, 2 # shift to the first location in the array
	add $t1, $t1, $v1 #add the location to t1
	
	lw $t6, 0($t1) #putting the value in $t1 into $t6
	
	li $v0, 1
	move $a0, $t6 # print the number in list
	syscall
	
	li $a0, 32
	li $v0, 11  # syscall number for printing character
	syscall
	
	
	addi $t0, $t0, 1
	#li $v0, 0

	bne $t0, $a1, printLoop
	li $t0, 0
	move $v1, $a0
	li $v0 11  # syscall 11: print a character based on its ASCII value
    	li $a0 10  # ASCII value of a newline is "10"
    	syscall
    	move $a0, $v1 #moving list back into $a0
	
	li $t6, 0
	li $t1, 0
	lw $ra, 0($sp)
	jr $ra
	
# inSort takes in a list and it size as arguments. 
# It performs INSERTION sort in ascending order and returns a new sorted list
# You may use the pre-defined sorted_list to store the result
inSort:
	# Your implementation of inSort here
	sw $ra, 0($sp)
	li $t0, 0
	la $a2, sorted_list
	passingList: #passing the orignal list to the sorted array for sorting
		sll $t1, $t0, 2
		add $t1, $t1, $a0
		lw $t2, 0($t1)
		
		sll $t1, $t0, 2
		add $t1, $t1, $a2
		sw $t2, 0($t1)
		add $t0, $t0, 1
		bne $t0, $a1, passingList

	add $t0, $zero, $zero # int i
	add $t1, $zero, $zero  # used for shifting
	add $t2, $zero, $zero # used for shifting
	add $t3, $zero, $zero # int j
	add $a3, $zero, $zero # key
	# initializing variables
	
	
	add $t0, $t0, 1 # adding 1 to the loop to sort in ascending order
	loop: # loop
	sll $t1, $t0, 2 # shift to the first spot in the array
	add $t1, $t1, $a2 # add the location of the first number (n + 1)
	lw $a3, 0($t1) # key = sl+ i # adding the n + 1 to the key
	
	sub $t3, $t0, 1 # j = i - 1
	
	
	
	while:
	sll $t1, $t3, 2 #shift to the first spot of the sorted array
	add $t1, $t1, $a2
	lw $t2, 0($t1) #load first word from sorted array ( still not sorted)
	
	bltz $t3, afterWhile # checking to see if it will go into while loop
	bgt $a3, $t2, afterWhile
	
	add $t3, $t3, 1 
	sll $t1, $t3, 2
	add $t1, $t1, $a2
	sw $t2, 0($t1)
	sub $t3, $t3, 1 
	
	sub $t3, $t3, 1 #int j = j - 1
	j while # loops back to check if it should continue looping
	
	afterWhile: # after the while loop once the conditions dont match
	add $t3, $t3, 1 
	sll $t1, $t3, 2
	add $t1, $t1, $a2
	sw $a3, 0($t1)
	sub $t3, $t3, 1 # shitfting to *(sL + (j + 1) and storing the number from *(sL + j) into it
	
	add $t0, $t0, 1
	bne $t0, $a1, loop # if count isn't the same size as list size, loop again
	

	move $v0, $a2 # moving the sorted array into $v0 for printing
	li $a2, 0 # resetting $a2 for later use
	lw $ra, 0($sp)
	jr $ra
	


	
	
		
	
	
	
# bSearch takes in a list, its size, and a search key as arguments.
# It performs binary search RECURSIVELY to look for the search key.
# It will return a 1 if the key is found, or a 0 otherwise.
# Note: you MUST NOT use iterative approach in this function.
bSearch:
	# Your implementation of bSearch here
	
	beqz $t9, setHigh # checking to see if size is equal to (size - 1) if not, jump to set $a1 (list size) to (list size - 1) 
	#this will only ever get called once at the start of the loop since $t9 is never used again and set to 1
	
	
	add $t0, $t0, $zero # low left side of list
	add $a1, $a1, $zero # high right side of list
	add $a3, $a3, $zero # making sure key gets iterated each time
	
	blt $a1, $t0, keyNotFound # if the loop has gone through all the numbers and still hasn't found a math, not found
	
	#find the middle element in the array
	sub $t1, $a1, $t0
	sra $t1, $t1, 1
	add $a2, $t0, $t1 # int mid 
	li $t1, 0 # restting $t1 to avoid issues
	
	# t4 and  registers onward for shifting through arrays
	sll $t4, $a2, 2
	add $t4, $t4, $a0
	lw $t5, 0($t4) # loading the middle value from the sorted list
	
	beq $t5, $a3, keyFound # if the middle element matches the key then key found!
	blt $a3, $t5, low # if key is smaller than mid, then value must be at the right of the array
	
	#else it is in the right of the array
	add $t0, $a2, 1 
	add $a1, $a1, $zero
	add $a3, $a3, $zero
	j bSearch # jumps back to itself and updates the variables to loop through the right side of the array
	
	#left side of sorted list array
	low:
	add $t0, $t0, $zero
	sub $a1, $a2, 1
	add $a3, $a3, $zero # setting variables to have loop check the left side and then loop back
	j bSearch
	
	keyFound:
	add $v0,$zero, 1
	jr $ra
	
	keyNotFound:
	add $v0, $zero, $zero
	jr $ra
	
	setHigh:
	sub $a1, $a1, 1
	add $t9, $zero, 1 # setting $a1 (size) to (size - 1) for the first run of bSearch
	j bSearch
	
