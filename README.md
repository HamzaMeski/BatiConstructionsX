# BatiConstructionsX

### Application for Estimating Kitchen Construction Costs

**Bati-Constructions** is a Java application designed for professionals in kitchen construction and renovation. The app calculates the total cost of kitchen projects, factoring in materials and labor costs. It aims to provide a powerful and user-friendly tool for accurate cost estimation and effective project management.

---

## Table of Contents
1. [Features](#features)
2. [Installation](#installation)
3. [Usage](#usage)
4. [Project Structure](#project-structure)
5. [License](#license)

---

## Features

### 1. Project Management
- Add a client associated with the project.
- Add and manage components (materials, labor).
- Associate an estimate with a project to determine costs before work begins.
- Project attributes:
    - **name**: Project name.
    - **profitMargin**: Profit margin applied to the total cost.
    - **totalCost**: Total calculated project cost.
    - **status**: Project status (In Progress, Completed, Canceled).

### 2. Component Management
- **Materials**: Manage material costs, including:
    - Name
    - Unit cost
    - Quantity
    - Component type (Material or Labor)
    - VAT rate
    - Transport cost
    - Quality coefficient
- **Labor**: Calculate costs based on hourly rate, hours worked, and worker productivity.

### 3. Client Management
- Register client information, including professional or private status, which may affect discounts or taxes.
- Client attributes:
    - Name
    - Address
    - Phone number
    - IsProfessional (Boolean flag for professional clients)

### 4. Estimate Generation
- Generate estimates before work begins, including material, labor, equipment, and tax costs.
- Attributes:
    - **estimatedAmount**: Estimated total project amount.
    - **issueDate**: Estimate issue date.
    - **validityDate**: Estimate validity date.
    - **accepted**: Boolean flag indicating if the estimate is accepted.

### 5. Cost Calculation
- Integrate component costs (materials, labor) into the total project cost.
- Apply a profit margin to determine the final project cost.
- Account for applicable taxes (VAT) and discounts.

### 6. Display Project Details
- Display complete project details, including client information, components, and total costs.
- Generate a detailed summary of the total cost, including labor, materials, taxes, and profit margin.

---

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/HamzaMeski/BatiConstructionsX.git
