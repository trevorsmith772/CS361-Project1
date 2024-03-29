# Project 1: Deterministic Finite Automata

* Author: Trevor Smith, Brandon Mattaini, Berto Cisneros
* Class: CS 361, Section 1 (Trevor & Berto), Section 2 (Brandon)
* Semester: Spring 2021


## Overview

This program is an implementation of a deterministic finite automaton. The program takes in a file and reads the states, alphabet, and transitions, and determines whether specific input strings are valid or not.

## Compiling and Using

In order to compile this program, make sure you are in the parent directory containing this README file. Once you are at this directory, run the command shown below to compile the whole package:

javac fa/dfa/DFADriver.java

Then to run the program, run the following command, where \<input file> is the file (and filepath) that the program will run.

java fa.dfa.DFADriver \<input file>


## Discussion

This project overall was not too bad. I would say that having to use the Set class is where the most difficulty came from. This was a class that we weren't super familiar with, and we found it somewhat difficult to use for certain operations. We believe it would've been easier to implement using a list or an array, but learning about the set class was still helpful. Most of the project went very smoothly without any problems, but we had few issues that took more time to solve which are outlined below:

1) We had an issue with states appearing as null, where each state had a DFAState name (which was correct), and a State name. This was simply because we had mistakenly added a name variable to the DFAState class which was unneeded as the State class has its own name variable.

2) We had issues with our states not maintaining the correct order from how they were read into the file. It turns out that this was an issue in our addTransition method, where we were removing a state from the set and re-adding an updated version back to the set. To fix this, we just made the method update the state directly without removing and re-adding.

3) Our last issue that we had was just formatting for the toString, where we just had to switch from using the Set's provided toString method, to iterating through the set and printing each element directly.


## Testing

For testing this project, we compiled and ran the DFADriver class with the 3 given test files to be able to compare our results. If we found any issues with our code we would run the other two tests to see if they contained the same problems and we went from there. We were able to match the correct output for all 3 tests provided to us. In addition to the 3 given tests, we also added 7 of our own tests that we either made DFA's for in JFLAP or were from homework problems. In these tests we found errors that the original 3 did not catch.
