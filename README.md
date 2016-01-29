# Robotium

Robotium is an open-source test framework for writing automatic Gray-Box testing cases for Android applications.

### 1º Session (21/01/16)

Presentation of Robotium and example how to use the tool.

- **[Slides](https://raw.githubusercontent.com/davidmigloz/robotium-testing/master/Presentation/Slides.pdf)**
- **[Calculator App](https://github.com/davidmigloz/robotium-testing/releases/download/v1/Calculator.zip)**

### 2º Session (28/01/16)

An app with some error on which the rest of the group will be working.

##### App Specification 

Design a system to work out the tax to be paid by an employee:
- An employee has €4 000 of salary tax free.
- The next €1 500 is taxed at 10%.
- The next €28 000 after that is taxed at 22%.
- Any further amount is taxed at 40%.

> The tax is rounded to the nearest whole euro.

##### Schedule

1. Check the Android Studio, SDK manager and AVD manager.
  - Lab computers with Android Studio: 20205-20212 (8 computers).
  - SDK path: `C:\software_testing\Android\SDK`.
2. Install Robotium Recorder.
3. Import project: [Tax System](https://github.com/davidmigloz/robotium-testing/releases/download/v1/TaxSystem.zip).
4. Create following test cases:
  - `AddEmployeeTest` (white-box)
    * [Useful methods](https://gist.github.com/davidmigloz/fc865c39db9da14f28d1)
  - `AddEmployeeTest` (black-box)
  - `AddEmployeeTest` (with Robotium Recorder)
  - `RemoveEmployeeTest` 
  - `HelpTest` (web view that loads [Help](http://davidmiguel.com/proyectos/robotium/taxsystem/) web site)
    * [Useful methods for testing web views](https://gist.github.com/davidmigloz/396f5728079c82b5bd39)
5. Find at least 3 app errors:
  - [x] Error 1: Enter a salary > MAX_INT (2*10^9)
  - [x] Error 2: Enter a salary < 0
  - [x] Error 3: Logic error when calculare employee tax cathegory

> Tip: create a test `testCalculationTaxes` and use the Boundary-value analysis technique with valid and invalid boundaries.

**Resources:**

- [Tax System Project](https://github.com/davidmigloz/robotium-testing/releases/download/v1/TaxSystem.zip)
- [Robotium tests template](https://gist.github.com/davidmigloz/8dabbdd012fbdb92838f)

###### Do you need help?

We have created a step-by-step tutorial covering the following topics:

1. Adding Robotium library
2. Preparing our first test case
3. Writing our first Robotium test
4. Running our test case
5. Viewing test results
6. Using Robotium Recorder to record a test

> **[Robotium tutorial](https://docs.google.com/document/d/1sIN5DE9VzEJ5RL-pg-zDQlU0yFkUBLBTxGEthOURCLw/edit?usp=sharing)**

### Useful links:

- [Robotium](https://github.com/robotiumtech/robotium)
- [Robotium Recorder](http://robotium.com/)
- [Robotium Java Doc](http://recorder.robotium.com/javadoc/)

### Team

- Abdullilah Alhaj
- David Miguel (PM)
- Elham Shahrour
- Nesreen Malkawi 
- Hema Lakshmi
- Karam Alhadithi

....................[.](https://gist.github.com/davidmigloz/f4c49b52f62535e20826)....................
