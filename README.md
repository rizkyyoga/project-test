# project-test
	
## How to run
### Using eclipse
- File > Open Project From File System > (choose project-test folder)
- run Main class in every package
  for running first task run Main class in com.yoga.bagian1
  for running second task run Main class in com.yoga.bagian2
  for running third task run Main class in com.yoga.bagian3
  
### Using command line
- open command line
- to running first task, locate to folder project in command line 
- execute following command :
  cd src/com/yoga/bagian1
  javac *.java
- locate to src folder in command line
- then execute following command
  java com.yoga.bagian1.Main
(for executing second and third task is exactly same unless the path should be change from src/com/yoga/bagian1 to src/com/yoga/bagian2 or src/com/yoga/bagian3)

## Overview
### First task
- test code is in Main class in com.yoga.bagian1, you can change it freely
- from this task it has N x M array where N is fixed size and M can be vary but to simpler explanation I will make it fixed
- basically to traverse NxM array it has complexity O(NxM) since to store and load all item should be picked it up
- but in this task I implement something different. instead it has O(NxM), this project has O(Nx(M/(available core))) it means it has faster process than usually does
- how I use is using multythread. because dictionary datatype or HashMap in java doesnt need sequential process so it posible to do so

### Second task
- test code is in Main class in com.yoga.bagian2, you can change it freely
- I've completed this task using recursive
- and in this project it can handle infinite loop as well
- feel free to create acylic or non cyclic graph

### Third task
- test code is in Main class in com.yoga.bagian3, you can change it freely
- the is in OOP and you can change freely the test coverage in the Main class
- code is generic and specified at a same time, which means made it simpler to implement the rest