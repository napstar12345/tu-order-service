### How to run?
compile, test, package
```bash
mvn clean install
```

run
```bash
mvn spring-boot:run
```

Sending sample order to db:
```bash
kafka-console-producer --broker-list localhost:9092 --topic col_sainsburys_logistics_delivery_clothing_dispatched
>{  "status": "collected", "code": "70010110008100T" }
```

Query API for order information:
```bash
http://localhost:8080/orders/70010110008100T?page=0&size=3
```