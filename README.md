# Robotium

Robotium is an open-source test framework for writing automatic Gray-Box testing cases for Android applications.

### 1º Session (21/01/16)

Presentation of Robotium and example how to use the tool.

- **[Slides](https://docs.google.com/presentation/d/1PIk20UxrxhWRqOVUF0bdE4CupmAD4ZSW2GK8t9D2ddc/edit?usp=sharing)**
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
2. Install Robotium Recorder.
3. Import project: [Tax System](https://github.com/davidmigloz/robotium-testing/releases/download/v1/TaxSystem.zip).
4. Create following test cases:
  - `AddEmployeeTest` (white-box)
  - `AddEmployeeTest` (black-box)
  - `RemoveEmployeeTest` (with Robotium Recorder)
  - `HelpTest` (web view that loads [Help](http://davidmiguel.com/proyectos/robotium/taxsystem/) web site)
5. Find at least 3 app errors:
  - [x] Error 1
  - [x] Error 2
  - [x] Error 3

> Tip: create a test `testCalculationTaxes` and use the Boundary-value analysis technique with valid and invalid boundaries.

**Resources:**

- [Tax System Project](https://github.com/davidmigloz/robotium-testing/releases/download/v1/TaxSystem.zip)
- [Robotium tests template](https://gist.github.com/Abdullilah/65a8d5b323146eab97ce)

###### Do you need help?

We have created a step-by-step tutorial covering the following topics:

- Adding Robotium library
- Preparing our first test case
- Writing our first Robotium test
- Running our test case
- Viewing test results
- Using Robotium Recorder to record a test

> **[Robotium tutorial](https://docs.google.com/document/d/1sIN5DE9VzEJ5RL-pg-zDQlU0yFkUBLBTxGEthOURCLw/edit?usp=sharing)**

### Useful links:

- [Robotium](https://github.com/robotiumtech/robotium)
- [Robotium Recorder](http://robotium.com/)
- [Robotium Java Doc](Robotium Solo API Java Doc)

### Team

- Abdullilah Alhaj
- David Miguel (PM)
- Elham Shahrour
- Nesreen Malkawi 
- Hema Lakshmi
- Karam Alhadithi
