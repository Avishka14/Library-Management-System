# 📚 Library Management System

A **Java Swing + MySQL based Library Management System**, developed as a **university assignment** to demonstrate and practice **Data Structures, Object-Oriented Programming (OOP)** concepts, and Java application development.

This system provides a **graphical user interface (GUI)** for managing library operations such as **book registration, member management, reservations, finance tracking, and reporting**.

---

## 🚀 Features

### 📖 Book Management
- Register new books with details (title, author, category, etc.)
- Update book information and availability
- Organize books by sections and cupboards

### 👤 Member Management
- Register new members (students, employees)
- Track member status (active/deactivated)
- View and update member information

### 📅 Reservation System
- Issue and return books
- Calculate and manage late return fees
- Track reservation history

### 💰 Finance Section
- Track fines and registration fees
- View financial reports by date and member

### 📊 Activity & Reporting
- Visualize library and member activity with charts
- View statistics on book usage and member registrations

### 🔐 Admin Panel
- Manage library data and activities
- View, search, and sort data tables

---

## 🛠️ Technologies Used

- **Java (Swing)** — GUI development
- **MySQL** — Database management
- **OOP Principles** — Encapsulation, Inheritance, Polymorphism, Abstraction
- **Data Structures** — HashMap, Vector, ArrayList, DefaultTableModel
- **Logging** — Java Logging API

**External Libraries**
- 🎨 [FlatLaf](https://www.formdev.com/flatlaf/) — Modern UI theme
- 📊 [XChart](https://knowm.org/open-source/xchart/) — Charts & graphs
- 📅 [JCalendar](https://toedter.com/jcalendar/) — Date chooser component
- 🗄️ [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/) — JDBC driver for MySQL database connectivity


---

## 💡 Key OOP & Data Structure Concepts

- **Encapsulation:** Each module (Library, Member, Finance, etc.) is encapsulated in its own class.
- **Inheritance & Polymorphism:** GUI components extend Swing classes; event handling uses polymorphic listeners.
- **Data Structures:**
  - `HashMap` — for mapping categories, sections, and member occupations
  - `Vector` & `DefaultTableModel` — for managing table data
  - `ArrayList` — for dynamic lists such as database query results
- **Exception Handling:** Robust error handling and logging throughout the application

---

## ⚙️ How to Run

1. **Database Setup:** Ensure MySQL is running and the `librarym` database is created.
2. **Dependencies:** All required JARs are in the `lib` folder.
3. **Build & Run:** Use your IDE (NetBeans, IntelliJ, VS Code, etc.) to build and run the project.
4. **Login:** Start with the `LogIn` window. Default credentials may be set in the database.

---

## 🎓 Learning Outcomes

- Practical experience with **Java Swing** for GUI development
- Applying **OOP principles** in a real-world context
- Using **data structures** for efficient data management
- Integrating Java applications with a **relational database**
- Implementing **logging** and **error handling** in Java applications

---

## 👤 Author

**Avishka Chamod**

---

## 📂 File References

- **Main GUI:** `gui.LogIn`, `gui.Dashboard`
- **Book Management:** `gui.LibrarySection`
- **Member Management:** `gui.MemberSection`
- **Reservation:** `gui.Reservation`
- **Finance:** `gui.FinanceSection`
- **Database:** `model.MySQL`, `model.SetupDb`
- **Charts:** `model.Charts`

---

## 📝 License

This project is for **educational purposes only**.  

For more details, see the source files in the `src` directory.
