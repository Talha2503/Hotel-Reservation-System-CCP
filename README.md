 # Hotel-Reservation-System-CCP

 
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)

![JUnit5](https://img.shields.io/badge/JUnit5-25A162?style=for-the-badge&logo=junit5&logoColor=white)

![VS Code](https://img.shields.io/badge/VS%20Code-007ACC?style=for-the-badge&logo=visual-studio-code&logoColor=white)

## 📂 Project Structure

```text

Hotel-Reservation-System/

├── src/

│   ├── CCP/                 # Root Package

│   │   ├── Main.java        # Entry Point

│   │   ├── Hotel_Chain.java # Controller Class

│   │   ├── Hotel.java

│   │   ├── Room.java

│   │   ├── RoomType.java

│   │   ├── Reservation.java

│   │   ├── ReserverPayer.java

│   │   └── How_Many.java    # Value Object

├── tests/                   # JUnit Test Suite

│   └── ... (Test classes for each domain object)

└── README.

```

---

# 1. Project Overview and Objective
The Hotel Reservation System is a software solution developed as a Complex Computing Problem (CCP). The primary goal is to demonstrate the transition from architectural design (UML) to a functional object-oriented system. This project manages the lifecycle of a hotel stay, from guest registration and room allocation to the final reservation and payment processing. It emphasizes the importance of structural integrity and modularity in software construction.

# 2. Architectural Design and Relationships
The system's foundation is built upon the relationships defined in the UML class diagram. These include:

Composition & Aggregation: Managing how a Hotel contains Rooms and how a HotelChain aggregates multiple Hotels.

Associations: Defining the link between a Guest making a Reservation and the ReserverPayer responsible for the billing.

Domain Entities: Utilizing classes like RoomType and HowMany to ensure that data is stored in a structured and type-safe manner.

# 3. Defensive Programming and Robustness
To ensure the system is "production-ready," Defensive Programming techniques have been implemented across all 18 files.

Validation Logic: Every class contains checks to prevent invalid data states, such as negative room prices, null guest names, or overlapping reservation dates.

Encapsulation: All data members are kept private, with access controlled through strictly validated getters and setters to maintain object state integrity.

Exception Handling: The system is designed to handle edge cases gracefully without crashing, providing a reliable user experience.

# 4. Testing Strategy: The AAA Pattern
A significant portion of the project (9 out of 18 files) is dedicated to automated testing using the JUnit 5 framework. We utilize the Arrange-Act-Assert (AAA) methodology:

Arrange: Setting up the test environment and initializing the necessary objects.

Act: Calling the specific method or functionality being tested.

Assert: Comparing the actual output against the expected result to verify correctness.

Integration Testing: Beyond unit tests, an IntegrationTest suite ensures that different modules (like Hotel and Reservation) work together seamlessly.

# 5. Implementation and Execution Flow
The implementation follows a clean, decoupled approach where the Main class serves as the entry point.

Scalability: The use of the HotelChain class allows the system to scale from a single boutique hotel to a multi-national chain.

Execution: The system compiles via standard Java compilers and provides a CLI (Command Line Interface) output that demonstrates successful guest booking and validation flows.

Version Control: The development process was recorded through meaningful Git commits, showcasing an incremental and organized coding workflow.
