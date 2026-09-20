# Assignment 2 - Factory Method and Abstract Factory

## Project Overview
This project is a simple Java logistics application. The project demonstrates two design patterns:
* Factory Method
* Abstract Factory
Factory Method is used to create different types of transport. Abstract Factory is used to create user interface components for Windows and macOS. The user can choose a delivery mode and a UI platform when the program starts. Available delivery modes:
* ROAD
* SEA
Available UI platforms:
* WINDOWS
* MACOS
The application supports all four combinations.

## Technologies

* Java
* JDK 17
* IntelliJ IDEA
* Git
* GitHub
* PlantUML

The application is a console program. No database, web framework, graphical interface, or external services are required.

## Project Structure

The project contains three main packages. The `logistics` package contains the Factory Method implementation. The `gui` package contains the Abstract Factory implementation. The `app` package contains the main application client. The project also contains `Main.java`, UML diagrams, and this README file.

## Factory Method

The Factory Method pattern is used for creating transport objects. The `Transport` interface defines the common delivery method. The project has two transport classes:
* Truck
* Ship
The `Logistics` class is the abstract creator. It contains the `createTransport()` factory method and the `planDelivery()` method. The project has two concrete logistics classes:

* RoadLogistics
* SeaLogistics
`RoadLogistics` creates a Truck.
`SeaLogistics` creates a Ship.

The `planDelivery()` method does not directly create a Truck or Ship. It uses the `createTransport()` method and then calls the `deliver()` method through the Transport interface. This allows the delivery workflow to remain the same for different types of transport.

## Abstract Factory

The Abstract Factory pattern is used for creating UI components. The project has two product interfaces:

* Button
* Checkbox

There are two UI families.

The Windows family contains:

* WindowsButton
* WindowsCheckbox

The macOS family contains:

* MacOSButton
* MacOSCheckbox

The `GUIFactory` interface defines two methods:

* createButton()
* createCheckbox()

There are two concrete factories:

* WindowsFactory
* MacOSFactory

WindowsFactory creates WindowsButton and WindowsCheckbox. MacOSFactory creates MacOSButton and MacOSCheckbox. This keeps the UI components from the same platform together.

## DeliveryApplication

The `DeliveryApplication` class is the client of the application. It receives a `GUIFactory` and a `Logistics` object through its constructor. The application uses the factory to create the Button and Checkbox. It also uses the Logistics object to start the delivery process. The client does not directly create WindowsButton, WindowsCheckbox, MacOSButton, MacOSCheckbox, Truck, or Ship. Instead, it works with the interfaces and abstract classes.

## How to Run

### Step 1

Install JDK 17.

You can check the installed Java version with:

```text
java -version
```

### Step 2

Open the project in IntelliJ IDEA.

### Step 3

Set JDK 17 as the project SDK.

### Step 4

Check that all files are located in the correct packages. The logistics classes should be in the `logistics` package. The UI classes should be in the `gui` package. The `DeliveryApplication` class should be in the `app` package. `Main.java` should be outside these packages.

### Step 5

Open `Main.java`.

Run the `main()` method.

### Step 6

Enter the delivery mode.

Use either:

```text
ROAD
```

or:

```text
SEA
```

### Step 7

Enter the UI platform.

Use either:

```text
WINDOWS
```

or:

```text
MACOS
```

The program will then create the correct transport and UI components.

## Example Run

Example input:

```text
ROAD
WINDOWS
```

Example output:

```text
=== Simple Logistics System ===
Enter delivery mode (ROAD/SEA): ROAD
Enter UI platform (WINDOWS/MACOS): WINDOWS

--- User Interface ---
Rendering Windows button
Rendering Windows checkbox

--- Delivery ---
Preparing delivery...
Truck delivers laboratory equipment to Aktau warehouse
Delivery goes by road.
Delivery planned successfully.
```

Another example:

```text
SEA
MACOS
```

The program creates a Ship, a macOS button, and a macOS checkbox.

## Supported Combinations

The following combinations are supported:

1. ROAD and WINDOWS
2. SEA and WINDOWS
3. ROAD and MACOS
4. SEA and MACOS

The source code does not need to be changed between these combinations.

## Input Validation

The program checks the user's input.

If an unsupported delivery mode is entered, the program displays an error message and stops.

For example:

```text
Unknown delivery mode: PLANE
```

If an unsupported platform is entered, the program displays an error message and stops.

For example:

```text
Unknown UI platform: ANDROID
```

The program does not silently choose a default option.

Missing input is also handled by the program's validation behavior.

## Verification

The application should be tested with the following cases.

Test 1:

Input:

```text
ROAD
WINDOWS
```

Expected result:

Truck delivery with Windows button and Windows checkbox.

Test 2:

Input:

```text
SEA
WINDOWS
```

Expected result:

Ship delivery with Windows button and Windows checkbox.

Test 3:

Input:

```text
ROAD
MACOS
```

Expected result:

Truck delivery with macOS button and macOS checkbox.

Test 4:

Input:

```text
SEA
MACOS
```

Expected result:

Ship delivery with macOS button and macOS checkbox.

Test 5:

Use an unsupported delivery mode.

Expected result:

A clear validation message is displayed and no delivery is started.

Test 6:

Use an unsupported UI platform.

Expected result:

A clear validation message is displayed and no UI components are created.

## Clean Code

The project uses several Clean Code practices.

First, meaningful names are used for classes, methods, and variables. Names such as `RoadLogistics`, `SeaLogistics`, `WindowsFactory`, and `DeliveryApplication` clearly describe their purpose.

Second, methods have separate responsibilities. Creating a transport, creating UI components, rendering the UI, and starting delivery are handled by different classes and methods.

Third, duplicated delivery logic is avoided. The common delivery workflow is stored in the `planDelivery()` method of the `Logistics` class.

Fourth, interfaces are used to separate the application from concrete implementations. The application works with `Transport`, `Button`, `Checkbox`, `GUIFactory`, and `Logistics`.

Fifth, internal fields in the application are private. This provides basic encapsulation and prevents direct access to the internal state.

## Design Reflection

### Adding a New Transport

If another transport is needed, such as an airplane, a new class can implement the `Transport` interface.

A new logistics creator can also extend the `Logistics` class.

The existing delivery workflow and `DeliveryApplication` can remain unchanged.

Only the startup selection in `Main.java` would need to recognize the new delivery mode.

### Adding a New UI Family

If another platform is needed, a new factory can implement the `GUIFactory` interface.

For example, a Linux family could contain:

* LinuxButton
* LinuxCheckbox
* LinuxFactory

The existing `Button`, `Checkbox`, and `DeliveryApplication` classes can remain unchanged.

The platform selection in `Main.java` would need to be updated.

### Adding a New UI Product Type

If a new product type such as `TextField` is required, a new `TextField` interface can be created.

The `GUIFactory` interface would then need a `createTextField()` method.

Each concrete factory would need to implement this method.

The client application could then be updated to use the new component.

## Factory Method and Abstract Factory

Factory Method is mainly focused on creating one type of product through a factory method.

In this project, the product is `Transport`, with `Truck` and `Ship` as concrete products.

Abstract Factory is focused on creating a family of related products.

In this project, the related products are `Button` and `Checkbox`. WindowsFactory creates the Windows family, while MacOSFactory creates the macOS family.

Both patterns help reduce direct dependency on concrete classes.

## Conclusion

This project demonstrates the use of Factory Method and Abstract Factory in one Java application.

Factory Method is responsible for creating the correct type of transport.

Abstract Factory is responsible for creating a matching set of UI components.

The application can switch between road and sea delivery and between Windows and macOS UI without changing the main application logic.

The project also demonstrates basic Clean Code principles, input validation, abstraction, and separation of responsibilities.
