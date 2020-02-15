
CL-USER 1 > (defun factorial(x) "Calcular Factorial" (cond ((= n 1) 1) (t (* n ( factorial(- n 1))))))
FACTORIAL

CL-USER 2 > (Factorial 5)

Error: The variable N is unbound.
  1 (continue) Try evaluating N again.
  2 Return the value of :N instead.
  3 Specify a value to use this time instead of evaluating N.
  4 Specify a value to set N to.
  5 (abort) Return to level 0.
  6 Return to top loop level 0.

Type :b for backtrace or :c <option number> to proceed.
Type :bug-form "<subject>" for a bug report template or :? for other options.

CL-USER 3 : 1 > (defun factorial (x) "Calcular Factorial" (cond ((= x 1) 1) (t (* n (factorial(- n 1))))))
FACTORIAL

CL-USER 4 : 1 > (factorial 3)

Error: The variable N is unbound.
  1 (continue) Try evaluating N again.
  2 Return the value of :N instead.
  3 Specify a value to use this time instead of evaluating N.
  4 Specify a value to set N to.
  5 (abort) Return to level 1.
  6 Return to debug level 1.
  7 Return to level 0.
  8 Return to top loop level 0.

Type :b for backtrace or :c <option number> to proceed.
Type :bug-form "<subject>" for a bug report template or :? for other options.

CL-USER 5 : 2 > (defun factorial (x) "Calcular Factorial" (cond ((= x 1) 1) (t (* x (factorial(- n 1))))))
FACTORIAL

CL-USER 6 : 2 > (factorial 3)

Error: The variable N is unbound.
   1 (continue) Try evaluating N again.
   2 Return the value of :N instead.
   3 Specify a value to use this time instead of evaluating N.
   4 Specify a value to set N to.
   5 (abort) Return to level 2.
   6 Return to debug level 2.
   7 Return to level 1.
   8 Return to debug level 1.
   9 Return to level 0.
  10 Return to top loop level 0.

Type :b for backtrace or :c <option number> to proceed.
Type :bug-form "<subject>" for a bug report template or :? for other options.

CL-USER 7 : 3 > (defun factorial (x) "Calcular Factorial" (cond ((= x 1) 1) (t (* n (factorial(- x 1))))))
FACTORIAL

CL-USER 8 : 3 > (factorial 3)

Error: The variable N is unbound.
   1 (continue) Try evaluating N again.
   2 Return the value of :N instead.
   3 Specify a value to use this time instead of evaluating N.
   4 Specify a value to set N to.
   5 (abort) Return to level 3.
   6 Return to debug level 3.
   7 Return to level 2.
   8 Return to debug level 2.
   9 Return to level 1.
  10 Return to debug level 1.
  11 Return to level 0.
  12 Return to top loop level 0.

Type :b for backtrace or :c <option number> to proceed.
Type :bug-form "<subject>" for a bug report template or :? for other options.

CL-USER 9 : 4 > (defun factorial (x) "Calcular Factorial" (cond ((= x 1) 1) (t (* x (factorial(- x 1))))))
FACTORIAL

CL-USER 10 : 4 > (factorial 3)
6

CL-USER 11 : 4 > (factorial 6)
720

CL-USER 12 : 4 > 