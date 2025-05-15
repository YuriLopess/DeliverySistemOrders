<h1>Delivery System Orders</h1>

<h2>Description:</h2>

This repository is part of a microservices-based architecture project.

It is an API responsible for managing order-related endpoints, designed to handle operations within the order domain. The main goal of this project is to study and explore the implementation and structure of microservices in a distributed system.

This service is configured as a Eureka client, enabling service discovery and communication with other components in the architecture. It uses a PostgreSQL database to persist order data.

The API was developed with a focus on modularity and separation of concerns, aiming to simulate real-world use cases in a service-oriented architecture.

<h2>Related Projects</h2>

This project is part of a distributed system composed of multiple microservices. Below is a list of the main repositories and their roles:

- **[Delivery System Gateway](https://github.com/your-org/delivery-system-gateway)**  
  Acts as the API gateway for the entire system. Built with Spring Cloud Gateway, it routes external requests to the appropriate microservices and handles load balancing.

- **[Delivery System Server](https://github.com/your-org/delivery-system-server)**  
  A Eureka server responsible for service discovery. It enables microservices to register themselves and discover other services dynamically.

- **[Delivery System Payments](https://github.com/your-org/delivery-system-payments)**  
  A microservice dedicated to handling payment-related operations. It provides endpoints for managing payments and stores payment data in a PostgreSQL database.

<h2>Project Structure</h2>

The project is organized in a way that ensures clarity and scalability. Below is a summary of the main folders and files:

- `Controllers/`: Responsible for managing HTTP requests and delegating actions to the corresponding services.

- `Services/`: Contains the business logic, implementing CRUD methods and other operations related to orders.

- `DTOs/`: Defines data transfer objects used for communication between application layers.

- `Exceptions/`: Defines custom exceptions and error handling for a clear and controlled response in case of failures.

- `Models/`: Represents database entities, such as Order and related models.

- `Repository/`: Contains database access logic and interfaces responsible for data persistence, handling interaction with the database.

- `Config/`: Contains configuration files for bean definitions and other application-level settings to improve modularity and manage dependencies.

<h2>Installation:</h2>

To install the project, you can download it as a .zip file or clone it directly from GitHub.

### Download as .zip

1. Access the repository on GitHub: [DeliverySystemOrders](https://github.com/YuriLopess/DeliverySystemOrders.git)
2. Click on "Code" and select "Download ZIP".
3. Extract the ZIP file to your preferred directory.

### Clone with Git

1. Open the terminal.
2. Navigate to the directory where you want to clone the repository.
3. Run the following command:

   ```sh
   git clone https://github.com/YuriLopess/DeliverySystemPayments.git

<h2>Contact:</h2>

If you have any questions or want to discuss about the project, please feel free to contact me via this email: **[costalopesyuri@gmail.com](mailto:costalopesyuri@gmail.com)**
