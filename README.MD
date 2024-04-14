# ByBit client

Client that connects via ws to ByBit exchange 

# Used technologies

- Java 11+
- Spring boot
- [official SDK](https://github.com/bybit-exchange/bybit-java-api)

# Usage

1. Specify the orderbook [config](./src/main/resources/application.yaml). Fill ticker + depth. 
2. Specify the trades [config](./src/main/resources/application.yaml). Fill ticker list.
3. Run the app via [main](./src/main/java/com/bybit/ByBitClientApplication.java)
