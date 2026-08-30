# 🚗 Smart Parking Lot System

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![OOP](https://img.shields.io/badge/Architecture-OOP-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Completed-success?style=for-the-badge)

A comprehensive, production-grade object-oriented parking lot management and simulation system implemented in **Java**. This repository models real-world parking operations, enforcing strict Object-Oriented Programming (OOP) design patterns, encapsulation, and scalable class hierarchies.

---

## 📋 Table of Contents
1. [Overview](#-overview)
2. [Core OOP Principles Applied](#-core-oop-principles-applied)
3. [System Architecture & Class Breakdown](#-system-architecture--class-breakdown)
4. [System Workflows](#-system-workflows)
5. [Project Structure](#-project-structure)
6. [Getting Started & Installation](#-getting-started--installation)
7. [Simulation Scenarios](#-simulation-scenarios)

---

## 🎯 Overview

The **Smart Parking Lot System** is designed to automate the operational workflows of a modern, multi-zone parking facility. It handles multi-type vehicle registration, dynamic space allocation across different parking zones, automated ticket issuing, real-time capacity checks, and polymorphic fee calculations. 

The system is built with high scalability in mind, segregating parking areas based on vehicle dimensions and abstracting payment methods to easily accommodate future extensions.

---

## 💡 Core OOP Principles Applied

This project heavily utilizes the four pillars of Object-Oriented Programming to ensure a clean, maintainable, and modular codebase:

* **Abstraction:** Complex backend routing logic (e.g., capacity algorithms, ticket validation, and fee processing) is abstracted away from the `Main` execution flow. 
* **Encapsulation:** Sensitive data such as ticket IDs, entry timestamps, and payment statuses are strictly kept private (`private` modifiers) and accessed only via secure getter/setter methods.
* **Inheritance:** `Car`, `Truck`, and `Motorcycle` inherit fundamental state and behavior from the abstract `Vehicle` base class, preventing code duplication.
* **Polymorphism (Method Overriding & Overloading):** The system processes varying `Vehicle` types dynamically. Furthermore, the checkout flow utilizes Strategy/Polymorphic patterns where the `processExit` method seamlessly accepts distinct payment implementations (`CashPayment`, `CardPayment`) at runtime.

---

## 🏗️ System Architecture & Class Breakdown

The project follows the **Single Responsibility Principle (SRP)**, dividing the domain into 15 distinct, highly specialized classes and interfaces.

### 1. Core Entities & Enums
* **`User.java`**: Represents the vehicle owner or system operator. Manages user profile details, contact information, and actor behaviors.
* **`VehicleType.java`**: An Enum defining the strictly allowed categories of vehicles (e.g., `CAR`, `TRUCK`, `MOTORCYCLE`), ensuring type and thread safety throughout the application.

### 2. Vehicle Hierarchy (Domain Models)
* **`Vehicle.java`**: (Abstract) The base blueprint for all vehicles. Encapsulates common attributes like license plates, ownership linkages, and base tariffs.
* **`Car.java`**: Concrete subclass representing standard passenger cars.
* **`Truck.java`**: Concrete subclass representing heavy commercial vehicles requiring large spatial allocations.
* **`Motorcycle.java`**: Concrete subclass representing two-wheelers, optimized for compact parking spaces.

### 3. Parking Area Management (Zone Segregation)
* **`ParkingLot.java`**: (Base) Defines the overarching contract for any parking area, handling generic capacity tracking, availability status, and foundational entry/exit logic.
* **`CompactParkingArea.java`**: Specialized parking zone engineered specifically for standard-sized vehicles (Cars).
* **`LargeVehicleZone.java`**: Specialized parking zone with larger dimensions, dedicated exclusively to handling heavy-duty vehicles (Trucks).
* **`MotorcycleLot.java`**: Highly optimized parking zone designed to maximize throughput for smaller vehicles (Motorcycles).

### 4. Transactions & Ticketing
* **`ParkingTicket.java`**: The transactional entity generated upon a successful vehicle entry. Records precise entry timestamps, assigned zones, and unique cryptographic/alphanumeric ticket IDs required for checkout validation.

### 5. Payment System (Financial Engine)
* **`Payment.java`**: The foundational class/interface representing the financial engine of the checkout process.
* **`CashPayment.java`**: Concrete implementation processing traditional physical fiat transactions.
* **`CardPayment.java`**: Concrete implementation processing digital/credit card transactions, mocking bank gateway responses.

### 6. Execution & Testing Suite
* **`Main.java`**: The application's entry point. Acts as the simulation driver, orchestrating integration tests, instantiating mock data, and outputting the lifecycle to the console.

---

## 🔄 System Workflows

1. **Arrival & Routing:** A `Vehicle` arrives at the facility. The system identifies its `VehicleType`.
2. **Capacity Check:** The system queries the specific lot (e.g., `LargeVehicleZone` for a Truck) to check for available capacity.
3. **Ticketing (Check-in):** If space is available, a `ParkingTicket` is generated, the lot's available capacity is decremented, and the vehicle is successfully parked.
4. **Checkout & Billing:** The vehicle presents its ticket. The system validates the ID, calculates the elapsed time, applies the specific vehicle multiplier, and delegates the billing to the selected `Payment` strategy.
5. **Liberation:** Upon successful payment, the parking slot is freed up for the next customer.

---

## 📂 Project Structure

```text
smartParkingLot/
│
└── src/
    ├── Main.java                 # Simulation Runner
    ├── User.java                 # Domain Entity
    ├── VehicleType.java          # Configuration Enum
    │
    ├── Vehicle.java              # Base Entity
    ├── Car.java                  # Extends Vehicle
    ├── Truck.java                # Extends Vehicle
    ├── Motorcycle.java           # Extends Vehicle
    │
    ├── ParkingLot.java           # Base Manager
    ├── CompactParkingArea.java   # Extends ParkingLot
    ├── LargeVehicleZone.java     # Extends ParkingLot
    ├── MotorcycleLot.java        # Extends ParkingLot
    │
    ├── ParkingTicket.java        # Transaction Logic
    │
    ├── Payment.java              # Base Processor
    ├── CashPayment.java          # Payment Strategy
    └── CardPayment.java          # Payment Strategy

## Author
- **Name:** Sudenaz KAYA
- **University:** Alparslan Türkeş Science and Technology University
- **Department:** Computer Engineering
- **LinkedIn:** [linkedin.com/in/sudenazkaya](https://www.linkedin.com/in/sudenazkaya)
- **GitHub:** [github.com/sudenazky](https://github.com/sudenazky)
