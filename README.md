# Banking System Application

A Java-based banking system application with a graphical user interface built using Swing and Maven. This application allows users to create bank accounts, make deposits, and withdrawals while maintaining basic banking operations security.

## Features

- Customer registration with personal details
- Account creation with unique account numbers
- Deposit functionality
- Withdrawal functionality with balance checking
- Real-time balance updates
- Basic error handling and input validation
- Modern graphical user interface

## Prerequisites

Before running this application, ensure you have the following installed:
- Java Development Kit (JDK) 23 or higher
- Apache Maven 3.8.x or higher
- NetBeans IDE 23 (recommended) or any Java IDE

## Installation

1. Clone the repository
```bash
git clone https://github.com/Zeus-mnn/HexSoftware_BankingSystem.git
```

2. Navigate to the project directory
```bash
cd HexSoftware_BankingSystem
```

3. Build the project using Maven
```bash
mvn clean install
```

## Running the Application

### Using NetBeans IDE:
1. Open NetBeans IDE
2. File → Open Project
3. Navigate to the project directory
4. Select the project and click Open
5. Right-click on the project and select Run or press F6

### Using Command Line:
```bash
mvn exec:java
```

## Project Structure

```
BankingSystem/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── mybank/
│                   └── bankingsystem/
│                       ├── BankingSystem.java
│                       ├── Customer.java
│                       └── BankAccount.java
└── pom.xml
```

## Class Description

- `BankingSystem.java`: Main application class containing the GUI and program entry point
- `Customer.java`: Customer data model class
- `BankAccount.java`: Bank account operations and data management class

## Usage

1. Launch the application
2. Fill in the registration form with:
   - Name
   - ID
   - Email
3. Click "Register" to create an account
4. Use the transaction panel to:
   - View current balance
   - Make deposits
   - Make withdrawals

## Error Handling

The application includes validation for:
- Empty registration fields
- Invalid amount inputs
- Insufficient funds for withdrawals
- Negative amount entries

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Authors

- Zeus-mnn

## License

This project is licensed under the MIT License - see the LICENSE file for details

## Acknowledgments

- Built using Java Swing for GUI
- Maven for project management
- Developed using NetBeans IDE
