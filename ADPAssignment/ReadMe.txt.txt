Approach
1. At first I created pojos namely,
Customer
ProductCategory
Product
SalesOrder
OrderItem

2. Next I created Services to have some crud operations
(except for SalesOrder and OrderItem)
I tried to persist the pojos using hibernate and used hsql database for this purpose.

3. Finally I wrote SalesOrderService for the main cart operations and price calculations on them and then display them on console

Sample run
In order to run a sample(hard-coded) input 
Go to ExecutableJar folder and run the jar.

or

run maven goal as below on the source-code pom

exec:java -Dexec.mainClass="com.org.adp.main.App"