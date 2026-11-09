# Currency Converter API

REST API that converts amounts between currencies using real-time exchange rates from [AwesomeAPI](https://docs.awesomeapi.com.br/api-de-moedas).

## Technologies

- Java 21
- Spring Boot
- Maven
- Lombok
- AwesomeAPI

## Getting Started

### Prerequisites

- Java 21 or higher
- Maven (or use the included Maven wrapper)

### Running the project

bash
git clone https://github.com/JuliaDeconto/currency-converter-api.git
cd currency-converter-api
mvnw spring-boot:run


The server starts on http://localhost:8080.

## Usage

### Convert currencies


GET /convert?from={currency}&to={currency}&amount={value}


| Parameter | Description                    | Example |
|-----------|--------------------------------|---------|
| from    | Source currency code           | USD   |
| to      | Target currency code           | BRL   |
| amount  | Amount to convert              | 100   |

*Example request:*


http://localhost:8080/convert?from=USD&to=BRL&amount=100


*Example response:*

json
{
"from": "USD",
"to": "BRL",
"rate": 5.505,
"amount": 100,
"result": 550.5
}


The rate is the bid price returned by AwesomeAPI, and result is rounded to 2 decimal places.

## Error Handling
When something goes wrong, the API returns a JSON body with the HTTP status and a descriptive message.

| Status | Cause                      | Message                              |
|--------|----------------------------|--------------------------------------|
| 400    | Blank currency code        | Currency codes must not be blank   |
| 400    | Amount is not a number     | Invalid amount: must be a number   |
| 400    | Missing required parameter | Missing required parameter         |
| 404    | Currency pair not found    | Currency pair not found            |

*Example error response:*

```json
{
"status": 404,
"message": "Currency pair not found"
}
```

## Project Structure


src/main/java/com/juliadeconto/currencyconverter
├── config       # Bean configuration (RestTemplate)
├── controller   # REST endpoints
├── dto          # Data transfer objects
└── service      # Business logic and external API integration


## How It Works

1. The controller receives the request with the currencies and amount.
2. The service calls AwesomeAPI to fetch the current exchange rate.
3. The controller multiplies the amount by the rate and returns the result.